package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;
import xys;
import xzh;

public class FriendChatPie$6$1
  implements Runnable
{
  public FriendChatPie$6$1(xzh paramxzh) {}
  
  public void run()
  {
    Message localMessage = xys.a(this.a.this$0).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    xys.b(this.a.this$0).sendMessage(localMessage);
    aqmj.e(this.a.this$0.app.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.6.1
 * JD-Core Version:    0.7.0.1
 */