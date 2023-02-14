package com.ramonguimaraes.customotoast

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

class CustomToast(private val context: Context) {

    /**
     * @param text Error message
     * @param duration Toast Duration
     */
    fun showError(text: String, duration: Int = Toast.LENGTH_LONG) {
        val toast = Toast(context)
        toast.view = getView(ERROR, text)
        toast.duration = duration
        toast.show()
    }

    /**
     * @param text Warning message
     * @param duration Toast Duration
     */
    fun showWarning(text: String, duration: Int = Toast.LENGTH_LONG) {
        val toast = Toast(context)
        toast.view = getView(WARN, text)
        toast.duration = duration
        toast.show()
    }

    /**
     * @param text Success message
     * @param duration Toast Duration
     */
    fun showSuccess(text: String, duration: Int = Toast.LENGTH_LONG) {
        val toast = Toast(context)
        toast.view = getView(SUCCESS, text)
        toast.duration = duration
        toast.show()
    }

    /**
     * @param text Info message
     * @param duration Toast Duration
     */
    fun showInfo(text: String, duration: Int = Toast.LENGTH_LONG) {
        val toast = Toast(context)
        toast.view = getView(INFO, text)
        toast.duration = duration
        toast.show()
    }

    private fun getView(type: Int, text: String): View {
        val resource = when (type) {
            SUCCESS -> R.layout.success_layout
            INFO -> R.layout.information_layout
            WARN -> R.layout.warning_layout
            else -> R.layout.erro_layout
        }

        val view = context.getSystemService(LayoutInflater::class.java)
                .inflate(resource, null)

        view.findViewById<TextView>(R.id.text).text = text

        return view
    }

    private companion object {
        private const val SUCCESS = 0
        private const val INFO = 1
        private const val WARN = 2
        private const val ERROR = 3
    }
}