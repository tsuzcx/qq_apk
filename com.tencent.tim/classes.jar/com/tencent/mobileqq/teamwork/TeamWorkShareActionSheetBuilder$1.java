package com.tencent.mobileqq.teamwork;

import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aobu;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class TeamWorkShareActionSheetBuilder$1
  implements Runnable
{
  public TeamWorkShareActionSheetBuilder$1(aobu paramaobu, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (RelativeLayout.LayoutParams)aobu.a(this.this$0).getLayoutParams();
    int j = aobu.a(this.this$0).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - 80 - aobu.a(this.this$0).getWidth() - aobu.b(this.this$0).getWidth();
    if (aobu.c(this.this$0).getPaint().measureText(this.cjP + this.cjQ) > j)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= this.cjP.length()) || (aobu.c(this.this$0).getPaint().measureText(this.cjP.substring(0, i) + aobu.a(this.this$0).getString(2131690645) + this.cjQ) > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.cjP.substring(0, i - 1);
          aobu.c(this.this$0).setText(this.cjQ + (String)localObject + aobu.a(this.this$0).getString(2131690645));
          return;
        }
        i += 1;
      }
      aobu.c(this.this$0).setText(this.cjQ + this.cjP.substring(0) + aobu.a(this.this$0).getString(2131690645));
      return;
    }
    localObject = this.cjQ + this.cjP;
    aobu.c(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */