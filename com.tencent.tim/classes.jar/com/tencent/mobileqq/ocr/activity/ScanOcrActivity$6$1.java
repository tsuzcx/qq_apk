package com.tencent.mobileqq.ocr.activity;

import aknq;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class ScanOcrActivity$6$1
  implements Runnable
{
  public ScanOcrActivity$6$1(aknq paramaknq, int paramInt) {}
  
  public void run()
  {
    if (this.val$errCode != 0)
    {
      ScanOcrActivity.a(this.a.this$0).setVisibility(0);
      ScanOcrActivity.a(this.a.this$0).setText(2131690152);
      if (this.a.this$0.dnO == 1) {
        this.a.this$0.a.setVisibility(0);
      }
      return;
    }
    if (this.a.this$0.dnO != 1) {
      if (!ScanOcrActivity.a(this.a.this$0).isPlaying())
      {
        ScanOcrActivity.a(this.a.this$0).setVisibility(0);
        ScanOcrActivity.a(this.a.this$0).postDelayed(new ScanOcrActivity.6.1.1(this), 500L);
      }
    }
    for (;;)
    {
      ScanOcrActivity.a(this.a.this$0).setVisibility(0);
      ScanOcrActivity.a(this.a.this$0).setText(ScanOcrActivity.a(this.a.this$0));
      return;
      this.a.this$0.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */