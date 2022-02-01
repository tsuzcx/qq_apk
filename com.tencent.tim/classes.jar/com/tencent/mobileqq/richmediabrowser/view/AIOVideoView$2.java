package com.tencent.mobileqq.richmediabrowser.view;

import amdc;
import amem;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AIOVideoView$2
  implements Runnable
{
  public AIOVideoView$2(amem paramamem, String paramString) {}
  
  public void run()
  {
    this.this$0.b.onLoadFinish(this.this$0.b.getSelectedIndex(), true);
    if (this.val$erroText != null) {}
    for (String str = this.val$erroText;; str = this.this$0.mContext.getString(2131720261))
    {
      this.this$0.OV(false);
      this.this$0.zA(false);
      this.this$0.hQ.setVisibility(8);
      amem.a(this.this$0).setVisibility(0);
      amem.a(this.this$0).setVisibility(8);
      this.this$0.jO.setImageResource(2130847020);
      amem.a(this.this$0, false);
      TextView localTextView = (TextView)amem.a(this.this$0).findViewById(2131366519);
      if (localTextView != null) {
        localTextView.setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.2
 * JD-Core Version:    0.7.0.1
 */