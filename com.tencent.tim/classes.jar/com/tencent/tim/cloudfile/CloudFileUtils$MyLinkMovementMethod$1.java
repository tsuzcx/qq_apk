package com.tencent.tim.cloudfile;

import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.widget.TextView;
import athu.b;

public class CloudFileUtils$MyLinkMovementMethod$1
  implements Runnable
{
  public CloudFileUtils$MyLinkMovementMethod$1(athu.b paramb, Spannable paramSpannable, ForegroundColorSpan paramForegroundColorSpan, int paramInt1, int paramInt2, TextView paramTextView) {}
  
  public void run()
  {
    this.this$0.ip = null;
    if (this.this$0.b != null)
    {
      this.b.removeSpan(this.d);
      this.b.setSpan(this.this$0.b, this.val$start, this.val$end, 33);
    }
    if (this.this$0.gq != null) {
      this.this$0.gq.onClick(this.aeK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileUtils.MyLinkMovementMethod.1
 * JD-Core Version:    0.7.0.1
 */