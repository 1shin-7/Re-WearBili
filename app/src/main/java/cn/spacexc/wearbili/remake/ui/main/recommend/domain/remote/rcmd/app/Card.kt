package cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app

data class Card(
    val ad_tag: String,
    val ad_tag_style: cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app.AdTagStyle,
    val adver: cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app.Adver,
    val adver_account_id: Long,
    val adver_logo: String,
    val adver_mid: Long,
    val adver_name: String,
    val adver_page_url: String,
    val callup_url: String,
    val card_type: Int,
    val covers: List<cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app.Cover>,
    val desc: String,
    val duration: String,
    val dynamic_text: String,
    val extra_desc: String,
    val extreme_team_icon: String,
    val extreme_team_status: Boolean,
    val feedback_panel: cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app.FeedbackPanel,
    val fold_time: Int,
    val goods_cur_price: String,
    val goods_ori_price: String,
    val grade_denominator: Int,
    val grade_level: Int,
    val imax_landing_page_v2: String,
    val jump_url: String,
    val live_booking_population_threshold: Int,
    val live_room_area: String,
    val live_room_popularity: Int,
    val live_room_title: String,
    val live_streamer_face: String,
    val live_streamer_name: String,
    val live_tag_show: Boolean,
    val long_desc: String,
    val ori_mark_hidden: Int,
    val ott_jump_url: String,
    val price_desc: String,
    val price_symbol: String,
    val star_level: Int,
    val support_transition: Boolean,
    val title: String,
    val transition: String,
    val under_player_interaction_style: Int,
    val universal_app: String,
    val use_multi_cover: Boolean,
    val video: cn.spacexc.wearbili.remake.ui.main.recommend.domain.remote.rcmd.app.Video
)