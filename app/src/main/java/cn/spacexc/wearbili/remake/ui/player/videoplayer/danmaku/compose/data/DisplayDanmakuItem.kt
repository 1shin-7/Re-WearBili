package cn.spacexc.wearbili.remake.ui.player.videoplayer.danmaku.compose.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.AnnotatedString

/**
 * Created by XC-Qan on 2023/12/10.
 * I'm very cute so please be nice to my code!
 * 给！爷！写！注！释！
 * 给！爷！写！注！释！
 * 给！爷！写！注！释！
 */

data class DisplayDanmakuItem(
    val appearTime: Long,
    val content: AnnotatedString,
    val x: Float,
    val y: Float,
    val color: Color,
    val fontSize: Int,
    val type: Int,
    val danmakuId: Long,
    //val displayedFrames: Int,    //已经显示了多少帧，用于顶端/底端弹幕
    val textWidth: Int,
    val textHeight: Int,
    val displayRow: Int,
    val isLiked: Boolean,
    val image: ImageBitmap? = null,
    val isGradient: Boolean = false
)
