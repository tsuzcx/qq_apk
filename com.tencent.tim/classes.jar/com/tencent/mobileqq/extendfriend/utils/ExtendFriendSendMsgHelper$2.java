package com.tencent.mobileqq.extendfriend.utils;

import afsi;
import afxx;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

public class ExtendFriendSendMsgHelper$2
  implements Runnable
{
  public ExtendFriendSendMsgHelper$2(afxx paramafxx, int paramInt, String paramString) {}
  
  public void run()
  {
    afsi localafsi = (afsi)afxx.a(this.this$0).getManager(264);
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", this.val$from);
    localafsi.v(this.SO, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */