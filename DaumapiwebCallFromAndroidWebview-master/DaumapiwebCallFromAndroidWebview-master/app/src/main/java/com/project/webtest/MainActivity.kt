package com.project.webtest

import android.annotation.TargetApi
import android.app.Dialog
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebView.WebViewTransport
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = webview
        WebView.setWebContentsDebuggingEnabled(true)
        webView!!.apply {
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.setSupportMultipleWindows(true)
            webViewClient = client
            // 다이얼 로그로 띄워야 할 경우 사용 하는 코드
//            webChromeClient = object : WebChromeClient() {
//                // Grant permissions for cam
//                override fun onCreateWindow(view: WebView, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message): Boolean {
//                    val newWebView = WebView(this@MainActivity)
//                    newWebView.settings.javaScriptEnabled = true
//                    val dialog = Dialog(this@MainActivity).apply {
//                        setContentView(newWebView)
//                    }
//                    dialog.show()
//                    val lp = WindowManager.LayoutParams().apply {
//                        copyFrom(dialog.window!!.attributes)
//                        width = WindowManager.LayoutParams.MATCH_PARENT
//                        height = WindowManager.LayoutParams.MATCH_PARENT
//                    }
//                    dialog.window!!.attributes = lp
//                    newWebView.webChromeClient = object : WebChromeClient() {
//                        override fun onCloseWindow(window: WebView) {
//                            dialog.dismiss()
//                        }
//                    }
//                    (resultMsg.obj as WebViewTransport).webView = newWebView
//                    resultMsg.sendToTarget()
//                    return true
//                }
//            }

        }
        webView!!.loadUrl("http://10.0.2.2:8080/addressAPI2.html")
    }

    var client: WebViewClient = object : WebViewClient() {

        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            return false
        }

    }

}