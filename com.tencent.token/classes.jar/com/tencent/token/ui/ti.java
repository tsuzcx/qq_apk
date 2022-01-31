package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tmsdk.TMSDKContext;
import tmsdk.common.module.pgsdk.PermissionGuide;
import tmsdk.common.module.pgsdk.PermissionGuide.PermissionRequest;

class ti
  implements View.OnClickListener
{
  ti(PermissionGuideSubActivity paramPermissionGuideSubActivity) {}
  
  public void onClick(View paramView)
  {
    PermissionGuide.build(new int[] { 3 }).request(new tj(this));
    TMSDKContext.saveActionData(1150120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ti
 * JD-Core Version:    0.7.0.1
 */