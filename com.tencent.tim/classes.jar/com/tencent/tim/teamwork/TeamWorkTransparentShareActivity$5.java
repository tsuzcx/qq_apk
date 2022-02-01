package com.tencent.tim.teamwork;

import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class TeamWorkTransparentShareActivity$5
  implements Runnable
{
  TeamWorkTransparentShareActivity$5(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.cjP))
    {
      TeamWorkTransparentShareActivity.b(this.this$0).setVisibility(8);
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)TeamWorkTransparentShareActivity.a(this.this$0).getLayoutParams();
    int j = TeamWorkTransparentShareActivity.a(this.this$0).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - 300 - TeamWorkTransparentShareActivity.a(this.this$0).getWidth();
    if (TeamWorkTransparentShareActivity.b(this.this$0).getPaint().measureText(this.cjP + this.cjQ) > j)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= this.cjP.length()) || (TeamWorkTransparentShareActivity.b(this.this$0).getPaint().measureText(this.cjQ + this.cjP.substring(0, i) + "...等") > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.cjP.substring(0, i - 1);
          TeamWorkTransparentShareActivity.b(this.this$0).setText(this.cjQ + (String)localObject + "...等");
          return;
        }
        i += 1;
      }
      TeamWorkTransparentShareActivity.b(this.this$0).setText(this.cjQ + this.cjP.substring(0) + "...");
      return;
    }
    if (this.val$count == 0) {}
    for (localObject = this.cjP;; localObject = this.cjQ + this.cjP)
    {
      TeamWorkTransparentShareActivity.b(this.this$0).setText((CharSequence)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkTransparentShareActivity.5
 * JD-Core Version:    0.7.0.1
 */