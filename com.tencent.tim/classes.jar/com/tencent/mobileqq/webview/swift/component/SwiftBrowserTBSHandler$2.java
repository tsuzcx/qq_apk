package com.tencent.mobileqq.webview.swift.component;

import acfp;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arcb;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class SwiftBrowserTBSHandler$2
  implements Runnable
{
  public SwiftBrowserTBSHandler$2(arcb paramarcb, int paramInt) {}
  
  public void run()
  {
    TextView localTextView = new TextView(this.this$0.a);
    localTextView.setBackgroundColor(2130706432);
    localTextView.setTextColor(2147483647);
    StringBuilder localStringBuilder = new StringBuilder().append(acfp.m(2131715091));
    if (this.eer == 0) {}
    for (String str = "系统WebView";; str = "x5 " + this.eer)
    {
      localTextView.setText(str);
      this.this$0.a.addContentView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.2
 * JD-Core Version:    0.7.0.1
 */