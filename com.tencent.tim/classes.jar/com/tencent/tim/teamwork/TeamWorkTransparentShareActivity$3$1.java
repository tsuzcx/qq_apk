package com.tencent.tim.teamwork;

import android.os.Bundle;
import android.text.TextUtils;
import auls;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;

public class TeamWorkTransparentShareActivity$3$1
  implements Runnable
{
  public TeamWorkTransparentShareActivity$3$1(auls paramauls, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.isFinishing()) {
      return;
    }
    this.a.this$0.hideProgressDialog();
    Object localObject;
    if ((this.val$isSuccess) && (this.val$retCode == 0) && (!TextUtils.isEmpty(this.cID)))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", this.cID);
      ((Bundle)localObject).putBoolean("key_flag_clear_top", true);
      ((Bundle)localObject).putBoolean("key_need_reload_url", true);
      ((Bundle)localObject).putString("tdsourcetag", "s_tim_cloud_folder");
      TeamWorkDocEditBrowserActivity.a(this.a.this$0, (Bundle)localObject, false);
      QQToast.a(this.a.this$0.getApplicationContext(), 2, this.a.this$0.getString(2131720883), 1).show(this.a.this$0.getTitleBarHeight());
      this.a.this$0.finish();
      return;
    }
    switch (this.val$retCode)
    {
    default: 
      localObject = this.a.this$0.getString(2131720879);
    }
    for (;;)
    {
      QQToast.a(this.a.this$0.getApplicationContext(), 1, (CharSequence)localObject, 0).show(this.a.this$0.getTitleBarHeight());
      break;
      localObject = this.a.this$0.getString(2131720881);
      continue;
      localObject = this.a.this$0.getString(2131720880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkTransparentShareActivity.3.1
 * JD-Core Version:    0.7.0.1
 */