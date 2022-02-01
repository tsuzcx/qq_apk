package com.tencent.mobileqq.troop.activity;

import android.widget.ImageView;
import aost;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

public class PublicCommentWindow$1
  implements Runnable
{
  public PublicCommentWindow$1(aost paramaost) {}
  
  public void run()
  {
    this.this$0.cOy = false;
    if ((this.this$0.isShowing()) && (this.this$0.a != null))
    {
      this.this$0.a.setVisibility(0);
      this.this$0.Ea.setImageResource(2130848766);
      this.this$0.Ea.setContentDescription(this.this$0.mActivity.getString(2131698478));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow.1
 * JD-Core Version:    0.7.0.1
 */