package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import mcx;

public class ComponentSocialOperation$1$1
  implements Runnable
{
  public ComponentSocialOperation$1$1(mcx parammcx) {}
  
  public void run()
  {
    if (this.a.b.ama)
    {
      this.a.b.jt.setImageResource(2130847236);
      if (this.a.b.aQw > 0)
      {
        this.a.b.qI.setText(ComponentSocialOperation.bp(this.a.b.aQw));
        this.a.b.qI.setTextColor(Color.parseColor("#07D0B0"));
        if (QLog.isColorLevel()) {
          QLog.d("ComponentSocialOperation", 2, "revert upvote to true, set num:" + ComponentSocialOperation.bp(this.a.b.aQw));
        }
      }
    }
    label286:
    for (;;)
    {
      this.a.b.jt.startAnimation(this.a.b.f);
      return;
      this.a.b.jt.setImageResource(2130847239);
      this.a.b.qI.setTextColor(Color.parseColor("#777777"));
      if (this.a.b.aQw > 0) {
        this.a.b.qI.setText(ComponentSocialOperation.bp(this.a.b.aQw));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label286;
        }
        QLog.d("ComponentSocialOperation", 2, "revert upvote to false, set num:" + ComponentSocialOperation.bp(this.a.b.aQw));
        break;
        this.a.b.qI.setText(2131718546);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation.1.1
 * JD-Core Version:    0.7.0.1
 */