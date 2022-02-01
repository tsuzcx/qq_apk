package com.tencent.mobileqq.datareportviewer;

import afbx;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import aqcx;

public class DataReportViewerFloatViewHelper$2
  extends DataReportViewer
{
  public DataReportViewerFloatViewHelper$2(afbx paramafbx, Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void cYp()
  {
    int j = aqcx.dip2px(this.val$context, 50.0F);
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 2038;; i = 2003)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(j, -2, i, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = aqcx.dip2px(this.val$context, 72.0F);
      afbx.a(this.this$0).updateViewLayout(afbx.a(this.this$0), localLayoutParams);
      return;
    }
  }
  
  public void cYq()
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 2038;; i = 2003)
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = aqcx.dip2px(this.val$context, 72.0F);
      afbx.a(this.this$0).updateViewLayout(afbx.a(this.this$0), localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewerFloatViewHelper.2
 * JD-Core Version:    0.7.0.1
 */