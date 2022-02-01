package com.tencent.mobileqq.ocr.view;

import android.widget.RadioButton;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;

public final class TranslateLanguageOptionsView$1
  implements Runnable
{
  public TranslateLanguageOptionsView$1(RadioButton paramRadioButton, BounceScrollView paramBounceScrollView) {}
  
  public void run()
  {
    int i = this.t.getBottom() + this.t.getPaddingBottom() - this.k.getHeight();
    if (i > 0)
    {
      this.k.scrollBy(0, i);
      if (QLog.isColorLevel()) {
        QLog.d("TranslateLanguageOptionsView", 2, new Object[] { "compute detail, bottom:", Integer.valueOf(this.t.getBottom()), " padding:", Integer.valueOf(this.t.getPaddingBottom()), " viewHeight:", Integer.valueOf(this.k.getHeight()), " scrollHeight:", Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.1
 * JD-Core Version:    0.7.0.1
 */