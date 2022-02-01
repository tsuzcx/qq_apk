package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import xzk;
import xzo;

public class GameMsgChatPie$4$1
  implements Runnable
{
  public GameMsgChatPie$4$1(xzo paramxzo, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$errMsg)) {
      QQToast.a(this.a.a.mContext, this.val$errMsg, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.4.1
 * JD-Core Version:    0.7.0.1
 */