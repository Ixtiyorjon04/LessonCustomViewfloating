package uz.gita.lessoncustomview

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MyCustomView(context: Context, attr: AttributeSet?) : View(context, attr) {

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.MAGENTA
        style = Paint.Style.STROKE
        strokeWidth = 20f
        textSize = 200f
        textAlign = Paint.Align.CENTER

    }

    private val painCircle = Paint().apply {
        isAntiAlias = true
    }
    private var state = true

    //    init {
//        startAnim()
//    }
    private val text = "TEST"
    private var currentLength = 0

    private val attArr: TypedArray
    private val radius: Float
    private val textCustom: String
    private val bgColor: Int
    private val textSize: Float

    init {
        attArr = context.theme.obtainStyledAttributes(attr, R.styleable.MyCustomView, 0, 0)
        radius = attArr.getDimension(R.styleable.MyCustomView_circle_radius, 200f) ?: 200f
        textCustom = attArr.getString(R.styleable.MyCustomView_circle_text) ?: ""
        textSize = attArr.getDimension(R.styleable.MyCustomView_circle_text_size, 20f)
        bgColor = attArr.getColor(R.styleable.MyCustomView_circle_background, Color.MAGENTA)
            ?: Color.MAGENTA
        paint.color = bgColor
        paint.textSize = textSize
    }

    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawColor(Color.BLUE)
        drawCircle(canvas)
        drawText(canvas)
        if (state) {
            startAnim()
            state = false
        }
    }

    private fun drawCircle(canvas: Canvas?) {
        canvas?.drawCircle(width / 2f, height / 2f, radius, paint)
    }

    private fun drawRect(canvas: Canvas?) {
        canvas?.drawRoundRect(100f, 100f, width / 2f - 100f, height / 2f - 100, 20f, 30f, paint)
    }

    private fun drawArc(canvas: Canvas?) {
        canvas?.drawArc(0f, 0f, width.toFloat(), height.toFloat(), 0f, -90f, true, paint)
    }

    private fun drawText(canvas: Canvas?) {
//        paint.color = Color.WHITE
        canvas?.drawText(textCustom, 0, currentLength, width / 2f, height / 2f, paint)
    }

    private fun startAnim() {
        ValueAnimator.ofInt(0, textCustom.length).apply {
            addUpdateListener {
                Log.d("TTT", "${it.animatedValue as Int}")
                currentLength = it.animatedValue as Int
                invalidate()
            }
            duration = 2000
            start()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        event!!.x
        event!!.y
        return true
//        constructor(
//    context: Context, attributeSet: AttributeSet?
//) :
//    View(context, attributeSet) {
//    var horizontalCount = 0
//    var verticalCount = 0
//    private var map: Array<IntArray>? = null
//    private var xWidth = 0
//    private var xHeight = 0
//
//
//    private val paint = Paint().apply {
//        isAntiAlias = true
//    }
//
//
//    private val emptyPaint = Paint().apply {
//        isAntiAlias = true
//        color = Color.WHITE
//    }
//
//    override fun onDraw(canvas: Canvas?) {
//        map?.let {
//            xWidth = (width / (horizontalCount * 1f)).toInt()
//            xHeight = (height / (verticalCount * 1f)).toInt()
//            for (i in 0 until verticalCount) {
//                for (j in 0 until horizontalCount) {
//                    paint.color = when (it[i][j]) {
//                        1 -> Color.BLACK
//                        2 -> context.getColor(R.color.black)
//                        else -> Color.WHITE
//                    }
//                    canvas?.drawRect(
//                        (i * xHeight).toFloat(),
//                        (j * xWidth).toFloat(),
//                        ((i + 1) * xHeight).toFloat(),
//                        ((j + 1) * xWidth).toFloat(),
//                        paint
//                    )
//                }
//            }
//        }
//    }
//
//    val random = Random(80)
//
//    fun setMap() {
//        map = Array(verticalCount) { IntArray(horizontalCount) }
//        for (i in map!!.indices) {
//            for (j in map!![0].indices) {
//                map!![i][j] = random.nextInt(0, 2)
//            }
//        }
//    }
//
//    fun fill(x: Float, y: Float) {
//        val i = ceil(y / xHeight).toInt() - 1
//        val j = ceil(x / xWidth).toInt() - 1
//        setColor(i, j)
//        invalidate()
//    }
//
//    fun setColor(x: Int, y: Int) {
//        if (x < 0 || x >= verticalCount || y < 0 || y >= horizontalCount)
//            return
//        if (map!![x][y] == 0) {
//            map!![x][y] = 2
//            setColor(x - 1, y)
//            setColor(x + 1, y)
//            setColor(x, y - 1)
//            setColor(x, y + 1)
//        }
//    }
//
//}
    }


}