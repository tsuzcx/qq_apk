package com.tencent.mobileqq.jsp;

import aiiy;
import aobh;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.ArrayList;
import java.util.Iterator;

public class DocxApiPlugin$5
  implements Runnable
{
  public DocxApiPlugin$5(aiiy paramaiiy, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.xq.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aobh.aW(this.this$0.mRuntime.a().getCurrentAccountUin(), aobh.nP(str), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.5
 * JD-Core Version:    0.7.0.1
 */