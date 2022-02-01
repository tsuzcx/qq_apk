package com.tencent.mobileqq.jsp;

import ailw;
import ailw.a;
import arcb;
import arcm;
import arcm.a;
import com.tencent.smtt.sdk.WebView;

public class X5ApiPlugin$1
  implements Runnable
{
  public X5ApiPlugin$1(ailw paramailw, ailw.a parama, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (arcm.rT(this.a.bzI))
    {
      arcm.a locala = arcm.a(this.a.bzI);
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = locala.data;
      }
    }
    arcb.a(this.val$webView, this.a.bzI, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.X5ApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */