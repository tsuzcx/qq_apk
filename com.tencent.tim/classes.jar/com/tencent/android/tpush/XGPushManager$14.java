package com.tencent.android.tpush;

import android.content.Context;
import com.tencent.android.tpush.message.MessageManager;

final class XGPushManager$14
  implements Runnable
{
  XGPushManager$14(Context paramContext) {}
  
  public void run()
  {
    MessageManager.getInstance().clearAllLocalMsg(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.14
 * JD-Core Version:    0.7.0.1
 */