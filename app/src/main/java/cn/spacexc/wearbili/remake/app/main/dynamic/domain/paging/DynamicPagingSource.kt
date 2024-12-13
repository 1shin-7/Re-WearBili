package cn.spacexc.wearbili.remake.app.main.dynamic.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cn.spacexc.wearbili.common.domain.log.logd
import cn.spacexc.wearbili.common.exception.PagingDataLoadFailedException
import cn.spacexc.wearbili.remake.app.main.dynamic.domain.remote.list.DynamicItem
import cn.spacexc.wearbili.remake.app.main.dynamic.domain.remote.list.DynamicList
import cn.spacexc.wearbili.remake.common.networking.KtorNetworkUtils

/**
 * Created by XC-Qan on 2023/4/27.
 * I'm very cute so please be nice to my code!
 * 给！爷！写！注！释！
 * 给！爷！写！注！释！
 * 给！爷！写！注！释！
 */

class DynamicPagingSource(
    private val networkUtils: KtorNetworkUtils
) : PagingSource<Pair<Int, String?>, DynamicItem>() {
    private val requestedDynamicList = HashMap<Int, String?>()

    override fun getRefreshKey(state: PagingState<Pair<Int, String?>, DynamicItem>): Pair<Int, String?>? {
        return null
    }

    override suspend fun load(params: LoadParams<Pair<Int, String?>>): LoadResult<Pair<Int, String?>, DynamicItem> {
        try {
            val currentPage = params.key?.first ?: 1
            val dynamicIdOffset = params.key?.second
            requestedDynamicList[currentPage] = dynamicIdOffset
            val url =
                "https://api.bilibili.com/x/polymer/web-dynamic/v1/feed/all?timezone_offset=-480&type=all${if (currentPage == 1 || dynamicIdOffset.isNullOrEmpty()) "" else "&offset=$dynamicIdOffset"}&page=$currentPage".logd(
                    "dynamicUrl"
                )!!
            val response = networkUtils.get<DynamicList>(url)
            if (response.code != 0 || response.data?.data?.items.isNullOrEmpty()) return LoadResult.Error(
                PagingDataLoadFailedException(apiUrl = response.apiUrl, code = response.code)
            )
            val dynamicList = response.data.data.items
            return LoadResult.Page(
                data = dynamicList,
                prevKey = if (currentPage == 1) null else Pair(
                    first = currentPage - 1,
                    second = requestedDynamicList[currentPage - 1]
                ),
                nextKey = Pair(
                    first = currentPage + 1,
                    second = response.data?.data?.offset
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }
}