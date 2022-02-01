package com.tencent.mobileqq.trooponline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import apyl;
import aqiw;

public class TroopOnlineMemberBar$1
  implements Runnable
{
  public TroopOnlineMemberBar$1(apyl paramapyl) {}
  
  public void run()
  {
    if (apyl.a(this.this$0) != 0)
    {
      this.this$0.Wg.setVisibility(0);
      if ((apyl.a(this.this$0) != 2) && (aqiw.isNetworkAvailable(this.this$0.mContext))) {
        break label170;
      }
      if (this.this$0.dSG != 1) {
        break label129;
      }
      this.this$0.Wg.setText(2131696612);
      this.this$0.Wg.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.this$0.c != null) && (this.this$0.c.isRunning())) {
        this.this$0.c.stop();
      }
      apyl.a(this.this$0, 2);
    }
    label129:
    label170:
    while (apyl.a(this.this$0) != 1) {
      for (;;)
      {
        return;
        if (this.this$0.dSG == 3) {
          this.this$0.Wg.setText(2131694213);
        } else {
          this.this$0.Wg.setText(2131720424);
        }
      }
    }
    if (this.this$0.c == null) {
      this.this$0.c = ((Animatable)this.this$0.mContext.getResources().getDrawable(2130839651));
    }
    this.this$0.Wg.setText(null);
    this.this$0.Wg.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.this$0.c, null, null, null);
    this.this$0.c.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1
 * JD-Core Version:    0.7.0.1
 */