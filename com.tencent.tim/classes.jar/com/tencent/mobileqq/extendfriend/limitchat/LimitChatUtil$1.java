package com.tencent.mobileqq.extendfriend.limitchat;

import afwy;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public final class LimitChatUtil$1
  implements Runnable
{
  public LimitChatUtil$1(String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anot.a(localQQAppInterface, "dc00898", "", "", "0X800A801", "0X800A801", 0, 0, "", "", afwy.k(localQQAppInterface, this.val$uin), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatUtil.1
 * JD-Core Version:    0.7.0.1
 */