package com.tencent.av.redpacket.ui;

import ahgq;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import rwt;

class RedPacketShareFragment$1$1
  implements Runnable
{
  RedPacketShareFragment$1$1(RedPacketShareFragment.1 param1, String paramString) {}
  
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
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 1);
    ((Bundle)localObject).putString("forward_filepath", this.val$filePath);
    ((Bundle)localObject).putString("forward_thumb", this.val$filePath);
    ((Bundle)localObject).putString("forward_urldrawable_big_url", this.val$filePath);
    ((Bundle)localObject).putString("forward_extra", this.val$filePath);
    ((Bundle)localObject).putInt(ahgq.bKy, 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("isFromShare", false);
    localIntent.putExtras((Bundle)localObject);
    localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).setType(10012);
    localIntent.putExtra("fileinfo", (Parcelable)localObject);
    ahgq.f(this.a.this$0.getActivity(), localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.1.1
 * JD-Core Version:    0.7.0.1
 */