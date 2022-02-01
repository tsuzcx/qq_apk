package com.tencent.tim.teamwork;

import android.content.Context;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import auln;

public class TeamWorkShareActionSheetBuilder$1
  implements Runnable
{
  public TeamWorkShareActionSheetBuilder$1(auln paramauln, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (RelativeLayout.LayoutParams)auln.a(this.this$0).getLayoutParams();
    int j = auln.a(this.this$0).getWidth() - ((RelativeLayout.LayoutParams)localObject).leftMargin - 80 - auln.a(this.this$0).getWidth() - auln.b(this.this$0).getWidth();
    if (auln.c(this.this$0).getPaint().measureText(this.cjP + this.cjQ) > j)
    {
      int i = 0;
      for (;;)
      {
        if ((i >= this.cjP.length()) || (auln.c(this.this$0).getPaint().measureText(this.cjP.substring(0, i) + auln.a(this.this$0).getString(2131690645) + this.cjQ) > j))
        {
          if (i == 0) {
            break;
          }
          localObject = this.cjP.substring(0, i - 1);
          auln.c(this.this$0).setText(this.cjQ + (String)localObject + auln.a(this.this$0).getString(2131690645));
          return;
        }
        i += 1;
      }
      auln.c(this.this$0).setText(this.cjQ + this.cjP.substring(0) + auln.a(this.this$0).getString(2131690645));
      return;
    }
    localObject = this.cjQ + this.cjP;
    auln.c(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkShareActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */