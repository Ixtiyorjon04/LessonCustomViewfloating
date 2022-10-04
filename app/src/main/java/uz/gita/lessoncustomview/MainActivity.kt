package uz.gita.lessoncustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import by.kirich1409.viewbindingdelegate.viewBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind, R.id.container)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
//    @SuppressLint("ClickableViewAccessibility")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        viewBinding.apply {
//            btn.setOnClickListener {
//                if (inputWidth.text.toString().isNotEmpty() && inputHeight.text.toString()
//                        .isNotEmpty()
//                ) {
//                    viewBinding.myCustomView.apply {
//                        horizontalCount = inputWidth.text.toString().toInt()
//                        verticalCount = inputHeight.text.toString().toInt()
//                        setMap()
//                        invalidate()
//                        setOnTouchListener { _, motionEvent ->
//                            val x = motionEvent.x
//                            val y = motionEvent.y
//                            fill(y, x)
//                            false
//                        }
//                    }
//                }
//            }
//        }
//
//    }

    }
}