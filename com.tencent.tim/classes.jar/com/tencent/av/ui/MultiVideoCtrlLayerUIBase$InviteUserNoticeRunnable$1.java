package com.tencent.av.ui;

import com.tencent.qphone.base.util.BaseApplication;
import iwu;

class MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable$1
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable$1(MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable paramInviteUserNoticeRunnable) {}
  
  public void run()
  {
    if (this.b.count == 1) {}
    for (String str = String.format(BaseApplication.getContext().getString(2131697688), new Object[] { this.b.name });; str = String.format(BaseApplication.getContext().getString(2131697689), new Object[] { this.b.name, this.b.count + "" }))
    {
      iwu.a(this.b.this$0.mApp, 3010, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable.1
 * JD-Core Version:    0.7.0.1
 */