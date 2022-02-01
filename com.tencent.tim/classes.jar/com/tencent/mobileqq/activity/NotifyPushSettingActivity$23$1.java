package com.tencent.mobileqq.activity;

import acfp;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.MultiImageTextView;
import vke;

public class NotifyPushSettingActivity$23$1
  implements Runnable
{
  public NotifyPushSettingActivity$23$1(vke paramvke, String paramString) {}
  
  public void run()
  {
    boolean bool = true;
    QQToast.a(this.a.this$0.getActivity(), 1, acfp.m(2131709185), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
    NotifyPushSettingActivity.a(this.a.this$0).a().setText(this.aOz);
    NotifyPushSettingActivity localNotifyPushSettingActivity = this.a.this$0;
    if (!NotifyPushSettingActivity.a(this.a.this$0).isChecked()) {}
    for (;;)
    {
      NotifyPushSettingActivity.a(localNotifyPushSettingActivity, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.23.1
 * JD-Core Version:    0.7.0.1
 */