package com.tencent.av.redpacket.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import rwt;

class RedPacketShareFragment$4$1
  implements Runnable
{
  RedPacketShareFragment$4$1(RedPacketShareFragment.4 param4, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.getActivity() == null) {
      return;
    }
    if (this.UM)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.Qu));
      this.a.this$0.getActivity().sendBroadcast(localIntent);
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.a.this$0.getString(2131717218, new Object[] { this.Qu }), 1).show(this.a.this$0.getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      this.a.this$0.mEnable = true;
      this.a.this$0.UL = true;
      return;
      rwt.ez(1, 2131698057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.4.1
 * JD-Core Version:    0.7.0.1
 */