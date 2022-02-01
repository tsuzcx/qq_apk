package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.TextView;
import utt;

class ConversationTitleBtnCtrl$1$1
  implements Runnable
{
  ConversationTitleBtnCtrl$1$1(ConversationTitleBtnCtrl.1 param1, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.bGn > 0) {
      if (utt.a(this.a.this$0) != null)
      {
        if (this.bGn > 99)
        {
          utt.a(this.a.this$0).setText("99+");
          utt.a(this.a.this$0).setVisibility(0);
        }
      }
      else if (utt.a(this.a.this$0) != null) {
        utt.a(this.a.this$0).setVisibility(8);
      }
    }
    label188:
    do
    {
      do
      {
        return;
        utt.a(this.a.this$0).setText("" + this.bGn);
        break;
        if (!this.aVz) {
          break label188;
        }
        if (utt.a(this.a.this$0) != null) {
          utt.a(this.a.this$0).setVisibility(0);
        }
      } while (utt.a(this.a.this$0) == null);
      utt.a(this.a.this$0).setVisibility(8);
      return;
      if (utt.a(this.a.this$0) != null) {
        utt.a(this.a.this$0).setVisibility(8);
      }
    } while (utt.a(this.a.this$0) == null);
    utt.a(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1.1
 * JD-Core Version:    0.7.0.1
 */