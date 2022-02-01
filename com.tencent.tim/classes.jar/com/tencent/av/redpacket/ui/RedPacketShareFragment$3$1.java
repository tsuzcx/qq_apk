package com.tencent.av.redpacket.ui;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import itg;
import ith;
import rwt;

public class RedPacketShareFragment$3$1
  implements Runnable
{
  RedPacketShareFragment$3$1(RedPacketShareFragment.3 param3, String paramString) {}
  
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
    Object localObject;
    if (this.a.val$shareType == 2)
    {
      localObject = new itg(this);
      WXShareHelper.a().a((WXShareHelper.a)localObject);
      RedPacketShareFragment.a(this.a.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(this.val$filePath, this.a.this$0.N, 0, true, RedPacketShareFragment.d(this.a.this$0));
      return;
    }
    if (this.a.val$shareType == 3)
    {
      localObject = new ith(this);
      WXShareHelper.a().a((WXShareHelper.a)localObject);
      RedPacketShareFragment.a(this.a.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(this.val$filePath, this.a.this$0.N, 1, true, RedPacketShareFragment.d(this.a.this$0));
      return;
    }
    RedPacketShareFragment.b(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.3.1
 * JD-Core Version:    0.7.0.1
 */