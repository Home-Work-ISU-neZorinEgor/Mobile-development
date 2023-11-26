package com.example.colortiles


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.lang.Integer.min
import java.util.*

class MyView(context: Context?): View(context) {
    val p = Paint()
    val r = Random()
    var layoutWidth = -1
    var layoutHeight = -1

    val tiles = Array(4) {BooleanArray(4) {r.nextBoolean()} }
    lateinit var tilesRect: Array<Array<Rectangle>>
    var centerX = 50f
    var centerY = 50f
    var w = -1
    var h = -1

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        layoutWidth = right - left
        layoutHeight = bottom - top
        tilesRect = Array(4){Array(4){ Rectangle(0f, 0f, 0f, 0f) } }
        val minSide = min(layoutHeight, layoutWidth)
        val tile = (minSide / 13).toFloat()
        for (i in tilesRect.indices){
            for (j in tilesRect[i].indices){
                tilesRect[i][j] = Rectangle((1 + 3 * i) * tile, (1 + 3 * j) * tile, tile * 2,
                    tile * 2)
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        p.color = Color.RED
        canvas?.apply {
            w = width
            h = height
            drawColor(Color.WHITE)
            for (i in tilesRect.indices){
                for (j in tilesRect[i].indices){
                    if (tiles[i][j]){
                        p.color = Color.parseColor("#FB3914")
                    }
                    else{
                        p.color = Color.parseColor("#2A337F")
                    }
                    drawRect(tilesRect[i][j].x, tilesRect[i][j].y,
                        tilesRect[i][j].x + tilesRect[i][j].width,
                        tilesRect[i][j].y + tilesRect[i][j].height, p)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action == MotionEvent.ACTION_DOWN){
            event.apply {
                centerX = x
                centerY = y
            }
            var clickX = -1
            var clickY = -1
            for (i in tilesRect.indices){
                for (j in tilesRect[i].indices) {
                    if (tilesRect[i][j].isIntro(centerX, centerY)){
                        clickY = i
                        clickX = j
                    }
                }
            }
            if (clickX == -1 && clickY == -1){
                return true
            }
            Log.d("NIKITA", "$clickX, $clickY")
            for (i in tiles.indices){
                tiles[i][clickX] = !tiles[i][clickX]
            }
            for (i in tiles[0].indices){
                if (i == clickX){
                    continue
                }
                tiles[clickY][i] = !tiles[clickY][i]
            }
            var oneState = 0
            var zeroState = 0
            for (i in tiles.indices){
                for (j in tiles[i].indices){
                    if (tiles[i][j]){
                        oneState += 1
                    }
                    else{
                        zeroState += 1
                    }
                }
            }
            if (oneState == 0 || zeroState == 0){
                Toast.makeText(context, "Вы победили!", Toast.LENGTH_LONG).show()
            }
            invalidate()
        }
        return true
    }
}
