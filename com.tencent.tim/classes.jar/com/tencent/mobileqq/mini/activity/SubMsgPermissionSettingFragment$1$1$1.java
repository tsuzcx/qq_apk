package com.tencent.mobileqq.mini.activity;

import com.tencent.mobileqq.widget.QQToast;

class SubMsgPermissionSettingFragment$1$1$1
  implements Runnable
{
  SubMsgPermissionSettingFragment$1$1$1(SubMsgPermissionSettingFragment.1.1 param1, long paramLong) {}
  
  public void run()
  {
    if (this.val$finalErrCode == -101510007L)
    {
      QQToast.a(this.this$2.this$1.this$0.getActivity(), this.this$2.this$1.this$0.getString(2131695914), 0).show();
      return;
    }
    QQToast.a(this.this$2.this$1.this$0.getActivity(), this.this$2.this$1.this$0.getString(2131695926), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */