package com.tencent.tim.teamwork;

import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

class TeamWorkTransparentShareActivity$4
  implements Runnable
{
  TeamWorkTransparentShareActivity$4(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, List paramList, StringBuilder paramStringBuilder, String paramString) {}
  
  public void run()
  {
    Object localObject = (RelativeLayout.LayoutParams)TeamWorkTransparentShareActivity.a(this.this$0).getLayoutParams();
    int j = TeamWorkTransparentShareActivity.a(this.this$0).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - ((RelativeLayout.LayoutParams)localObject).rightMargin - TeamWorkTransparentShareActivity.a(this.this$0).getWidth();
    int i = 0;
    if (i < this.uU.size())
    {
      if (i != 0) {}
      for (localObject = "、" + (String)this.uU.get(i);; localObject = "我、" + (String)this.uU.get(i))
      {
        this.Z.append((String)localObject);
        i += 1;
        break;
      }
    }
    if (TeamWorkTransparentShareActivity.b(this.this$0).getPaint().measureText(this.Z + this.cjQ) > j)
    {
      i = 0;
      for (;;)
      {
        if ((i >= this.Z.length()) || (TeamWorkTransparentShareActivity.b(this.this$0).getPaint().measureText(this.Z.substring(0, i) + "...等" + this.cjQ) > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.Z.substring(0, i - 1);
          TeamWorkTransparentShareActivity.b(this.this$0).setText((String)localObject + "...等" + this.cjQ);
          return;
        }
        i += 1;
      }
      TeamWorkTransparentShareActivity.b(this.this$0).setText(this.Z.substring(0) + "..." + this.cjQ);
      return;
    }
    localObject = this.Z + this.cjQ;
    TeamWorkTransparentShareActivity.b(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkTransparentShareActivity.4
 * JD-Core Version:    0.7.0.1
 */