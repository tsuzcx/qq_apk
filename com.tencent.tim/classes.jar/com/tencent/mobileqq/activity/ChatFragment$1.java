package com.tencent.mobileqq.activity;

import acss;
import anaz;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import mqq.app.MobileQQ;

class ChatFragment$1
  implements Runnable
{
  ChatFragment$1(ChatFragment paramChatFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.getApplication().getSharedPreferences(acss.bqF, 0);
    long l = ((SharedPreferences)localObject).getLong(acss.bqI, 0L);
    if ((l == 0L) || (l > System.currentTimeMillis()) || (System.currentTimeMillis() - l > 14400000L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((SharedPreferences)localObject).edit().putLong(acss.bqI, System.currentTimeMillis()).commit();
      }
      if (i != 0)
      {
        i = this.this$0.mActivity.getIntent().getIntExtra("entrance", 0);
        localObject = this.this$0.mActivity.getIntent().getStringExtra("uin");
        this.this$0.app.a().n((String)localObject, this.val$type, i, this.bFd);
      }
      anaz.ne.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.1
 * JD-Core Version:    0.7.0.1
 */