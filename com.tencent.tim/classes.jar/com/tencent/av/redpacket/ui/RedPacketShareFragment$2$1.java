package com.tencent.av.redpacket.ui;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import avpw;
import avpw.d;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import rwt;

class RedPacketShareFragment$2$1
  implements Runnable
{
  RedPacketShareFragment$2$1(RedPacketShareFragment.2 param2, String paramString) {}
  
  public void run()
  {
    if ((this.a.this$0.getActivity() == null) || (this.a.this$0.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.val$filePath))
    {
      RedPacketShareFragment.b(this.a.this$0);
      rwt.ez(1, 2131698711);
      return;
    }
    this.a.this$0.iW(false);
    String str = String.format(BaseApplication.getContext().getString(2131698022), new Object[] { RedPacketShareFragment.b(this.a.this$0), RedPacketShareFragment.c(this.a.this$0) });
    avpw.d locald = avpw.d.a();
    if (this.a.this$0.mApp != null)
    {
      locald.cMP = this.a.this$0.mApp.getAccount();
      locald.nickname = this.a.this$0.mApp.getDisplayName(0, this.a.this$0.mApp.getCurrentAccountUin(), null);
    }
    avpw.a(this.a.this$0.getActivity(), locald, this.val$filePath, BaseApplication.getContext().getString(2131693309), str, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.2.1
 * JD-Core Version:    0.7.0.1
 */