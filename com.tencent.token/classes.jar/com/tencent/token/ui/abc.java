package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class abc
  implements View.OnClickListener
{
  abc(UnbindUinActivity paramUnbindUinActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, CheckMobileAvailableActivity.class);
    paramView.putExtra("real_uin", UnbindUinActivity.access$200(this.a));
    paramView.putExtra("user_to_unbind", UnbindUinActivity.access$600(this.a));
    paramView.putExtra("up_sms_scene_id", 6);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abc
 * JD-Core Version:    0.7.0.1
 */