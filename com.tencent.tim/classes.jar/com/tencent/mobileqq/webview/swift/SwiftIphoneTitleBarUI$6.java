package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import android.widget.TextView;
import aqzl;

public class SwiftIphoneTitleBarUI$6
  implements Runnable
{
  public SwiftIphoneTitleBarUI$6(aqzl paramaqzl, TextView paramTextView1, TextView paramTextView2, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.abK.getText().toString()))
    {
      this.abL.setText(this.val$title);
      return;
    }
    this.this$0.setTitle(this.val$title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.6
 * JD-Core Version:    0.7.0.1
 */