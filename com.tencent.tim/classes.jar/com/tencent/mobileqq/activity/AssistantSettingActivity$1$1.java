package com.tencent.mobileqq.activity;

import acfp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import uft;

public class AssistantSettingActivity$1$1
  implements Runnable
{
  public AssistantSettingActivity$1$1(uft paramuft, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.this$0.a.notifyDataSetChanged();
    BaseApplication localBaseApplication = this.a.this$0.app.getApp();
    if (this.aRq) {}
    for (String str = acfp.m(2131702904);; str = acfp.m(2131702900))
    {
      QQToast.a(localBaseApplication, str, 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.1.1
 * JD-Core Version:    0.7.0.1
 */