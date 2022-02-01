package com.tencent.mobileqq.mini.out.activity;

import com.tencent.mobileqq.widget.QQToast;

class PermissionSettingFragment$3$1
  implements Runnable
{
  PermissionSettingFragment$3$1(PermissionSettingFragment.3 param3, long paramLong) {}
  
  public void run()
  {
    if (this.val$finalErrCode == -101510007L)
    {
      QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131695914), 0).show();
      return;
    }
    QQToast.a(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131695926), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */