package cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app

data class FeedbackPanelDetail(
    val icon_url: String,
    val jump_type: Int,
    val jump_url: String,
    val module_id: Long,
    val secondary_panel: List<cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app.SecondaryPanel>?,
    val sub_text: String,
    val text: String
)