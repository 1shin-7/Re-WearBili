package cn.spacexc.wearbili.remake.app.crash.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.spacexc.bilibilisdk.utils.UserUtils
import cn.spacexc.wearbili.remake.app.TAG
import cn.spacexc.wearbili.remake.app.crash.remote.ErrorLog
import cn.spacexc.wearbili.remake.app.crash.remote.Response
import cn.spacexc.wearbili.remake.common.UIState
import cn.spacexc.wearbili.remake.common.networking.KtorNetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val FEEDBACK_SERVER_BASE_URL = "http://43.139.182.127"

@HiltViewModel
class CrashViewModel @Inject constructor(
    private val networkUtils: KtorNetworkUtils,
) : ViewModel() {
    var uiState: UIState by mutableStateOf(UIState.Success)
        private set

    var id by mutableStateOf("")

    fun uploadLog(
        exceptionDescription: String,
        stacktrace: String
    ) {
        viewModelScope.launch {
            uiState = UIState.Loading
            val errorLog = ErrorLog(
                reportTime = System.currentTimeMillis(),
                mid = UserUtils.mid(),
                exceptionDescription = exceptionDescription,
                stacktrace = stacktrace
            )

            val response = networkUtils.post<Response<String>, ErrorLog>(
                "$FEEDBACK_SERVER_BASE_URL/log/upload",
                errorLog
            )
            Log.d(TAG, "uploadLog: ${response.data?.message}")
            if (response.data?.code == 0) {
                id = response.data.body!!
                /*context.startActivity(Intent(context, QrCodeActivity::class.java).apply {
                    putExtra(PARAM_QRCODE_CONTENT, id)
                    putExtra(PARAM_QRCODE_MESSAGE, "Issue id: $id\n请在必要时提供此ID")
                })*/
                uiState = UIState.Success
            } else {
                uiState = UIState.Failed("日志上传失败了...")
            }
        }
    }
}