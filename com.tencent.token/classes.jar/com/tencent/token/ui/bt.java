package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class bt
  implements View.OnClickListener
{
  bt(BindUinActivity paramBindUinActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, CheckMobileAvailableActivity.class);
    paramView.putExtra("intent.qquser", BindUinActivity.access$900(this.a));
    paramView.putExtra("intent.upgradedetermin", BindUinActivity.access$800(this.a));
    if (BindUinActivity.access$200(this.a) == 13)
    {
      paramView.putExtra("scene_id", 1006);
      paramView.putExtra("up_sms_scene_id", 7);
    }
    for (;;)
    {
      this.a.startActivity(paramView);
      return;
      paramView.putExtra("scene_id", 1004);
      paramView.putExtra("up_sms_scene_id", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bt
 * JD-Core Version:    0.7.0.1
 */