package com.tencent.mobileqq.jsp;

import com.tencent.biz.ui.TouchWebView;
import org.json.JSONObject;

public final class DocxApiPlugin$9
  implements Runnable
{
  public DocxApiPlugin$9(TouchWebView paramTouchWebView, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.k.loadUrl("javascript:window.injectLocalTcntDocData(" + this.bC.toString() + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.9
 * JD-Core Version:    0.7.0.1
 */