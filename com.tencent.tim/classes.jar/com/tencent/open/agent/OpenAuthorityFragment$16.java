package com.tencent.open.agent;

import com.tencent.mobileqq.widget.QQToast;

class OpenAuthorityFragment$16
  implements Runnable
{
  OpenAuthorityFragment$16(OpenAuthorityFragment paramOpenAuthorityFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.this$0.getActivity());
    if (this.val$isSuccess)
    {
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      localQQToast.setType(2);
    }
    for (;;)
    {
      localQQToast.setDuration(2000);
      localQQToast.setToastMsg(this.val$msg);
      localQQToast.show();
      return;
      localQQToast.setToastIcon(QQToast.getIconRes(1));
      localQQToast.setType(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.16
 * JD-Core Version:    0.7.0.1
 */