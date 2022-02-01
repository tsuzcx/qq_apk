package com.tencent.mobileqq.troop.activity;

import acfp;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.widget.TextView;
import anot;
import aqcx;
import aqmj;
import com.tencent.biz.qqstory.view.widget.TipsView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tribe.view.TEditText;

class TroopBarPublishActivity$11
  implements Runnable
{
  TroopBarPublishActivity$11(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void run()
  {
    TroopBarPublishActivity localTroopBarPublishActivity = this.this$0;
    TEditText localTEditText = this.this$0.b;
    String str = acfp.m(2131715573);
    int j = aqcx.dip2px(this.this$0, 71.0F);
    if (Build.VERSION.SDK_INT < 19)
    {
      i = aqcx.dip2px(this.this$0, 20.0F);
      TipsView.a(localTroopBarPublishActivity, localTEditText, str, 1, 1, j, i, aqcx.dip2px(this.this$0, 20.0F), 5000, Color.argb(204, 0, 0, 0));
      aqmj.e(this.this$0, this.this$0.app.getCurrentAccountUin(), "tribe_video_post_has_show_tips", true);
      if ((this.this$0.ZZ == null) || (this.this$0.ZZ.getVisibility() != 0)) {
        break label157;
      }
    }
    label157:
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00899", "Grp_tribe", "", "post", "Clk_guide", i, 0, "", "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.11
 * JD-Core Version:    0.7.0.1
 */