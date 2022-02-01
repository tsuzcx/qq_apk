package com.tencent.mobileqq.theme.diy;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.ChatXListView;

class ThemeBackground$1$1
  implements Runnable
{
  ThemeBackground$1$1(ThemeBackground.1 param1, ThemeBackground paramThemeBackground) {}
  
  public void run()
  {
    if ((!"null".equals(this.val$themeBackground.path)) && (this.val$themeBackground.img != null))
    {
      this.this$0.val$view.setTag(this.val$themeBackground);
      if ((this.this$0.val$view instanceof ImageView))
      {
        ((ImageView)this.this$0.val$view).setImageDrawable(this.val$themeBackground.img);
        return;
      }
      if ((this.this$0.val$view instanceof ChatXListView))
      {
        ((ChatXListView)this.this$0.val$view).setContentBackground(this.val$themeBackground.img);
        return;
      }
      this.this$0.val$view.setBackgroundDrawable(this.val$themeBackground.img);
      return;
    }
    this.this$0.val$view.setTag(null);
    if ((this.this$0.val$view instanceof ImageView))
    {
      ((ImageView)this.this$0.val$view).setImageResource(this.this$0.val$defaultBgResId);
      return;
    }
    if ((this.this$0.val$view instanceof ChatXListView))
    {
      ((ChatXListView)this.this$0.val$view).setContentBackground(this.this$0.val$defaultBgResId);
      return;
    }
    this.this$0.val$view.setBackgroundResource(this.this$0.val$defaultBgResId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.1.1
 * JD-Core Version:    0.7.0.1
 */