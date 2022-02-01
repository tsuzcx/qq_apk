package com.tencent.mobileqq.webview.webso;

import android.net.Uri;

final class WebSoService$9
  implements Runnable
{
  WebSoService$9(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean, WebSoService.a parama) {}
  
  public void run()
  {
    String str = WebSoService.b(this.czV, this.czR, this.czS, this.czW, this.d, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState, this.cZd);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$a.onResult(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.9
 * JD-Core Version:    0.7.0.1
 */