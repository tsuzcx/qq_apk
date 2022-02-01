package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.LRULinkedHashMap;
import mqq.os.MqqHandler;
import xov;

public class TextItemBuilder$6
  implements Runnable
{
  public void run()
  {
    SpannableString localSpannableString = this.this$0.a(this.K, this.Jh);
    if (localSpannableString != null) {}
    synchronized (xov.f)
    {
      xov.f.put(Long.valueOf(this.ad), localSpannableString);
      Object localObject3 = this.this$0.mUIHandler.obtainMessage();
      ((Message)localObject3).what = 1;
      ((Message)localObject3).obj = localSpannableString;
      ??? = new Bundle();
      ((Bundle)???).putLong("msg_id", this.ad);
      ((Message)localObject3).setData((Bundle)???);
      this.this$0.mUIHandler.sendMessage((Message)localObject3);
      localObject3 = this.this$0.app.getHandler(MiniChatActivity.class);
      if (localObject3 != null)
      {
        localObject3 = ((MqqHandler)localObject3).obtainMessage();
        ((Message)localObject3).what = 7;
        ((Message)localObject3).obj = localSpannableString;
        ((Message)localObject3).setData((Bundle)???);
        ((Message)localObject3).sendToTarget();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */