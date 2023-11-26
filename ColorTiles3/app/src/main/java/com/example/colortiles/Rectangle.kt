package com.example.colortiles

data class Rectangle(val x: Float, val y: Float, val width: Float, val height: Float) {
    fun isIntro(pointX: Float, pointY: Float): Boolean
            = x <= pointX && pointX <= x + width && y <= pointY && pointY <= y + height

}
