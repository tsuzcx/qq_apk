package com.tencent.mobileqq.ocr.view;

import akop;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;

public class CommonMenuPopupView$1
  implements Runnable
{
  public CommonMenuPopupView$1(akop paramakop, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Context localContext = this.Af.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {}
    try
    {
      akop.a(this.this$0).b(this.Af, this.nK, this.nM, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CommonMenuPopupView", 1, "showAtLocation fail, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CommonMenuPopupView.1
 * JD-Core Version:    0.7.0.1
 */