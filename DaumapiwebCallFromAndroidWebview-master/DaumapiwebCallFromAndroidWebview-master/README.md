echo # DaumapiwebCallFromAndroidWebview


호출 url 다음과 같이 
webView!!.loadUrl("api 주소")
라고 적혀있기 때문에 index.html을 올린 호스팅 주소를 api 주소 대신 작성해야 합니다.
webView!!.loadUrl("https:// abcd" )
