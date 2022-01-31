package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.fk;
import com.tmsdk.TMSDKContext;

class x
  implements View.OnClickListener
{
  x(w paramw) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.c.a, PermissionGuideSubActivity.class);
    paramView.putExtra("app_whitelist", this.a.a);
    paramView.putExtra("auto_start", this.a.b);
    this.a.c.a.startActivity(paramView);
    TMSDKContext.saveActionData(1150115);
    fk.a("permission_guide_click_time", System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.x
 * JD-Core Version:    0.7.0.1
 */