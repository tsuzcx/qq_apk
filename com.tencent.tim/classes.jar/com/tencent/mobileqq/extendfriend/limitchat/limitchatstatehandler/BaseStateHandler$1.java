package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import afwy;
import afxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$1
  implements Runnable
{
  public BaseStateHandler$1(afxb paramafxb, String paramString1, String paramString2) {}
  
  public void run()
  {
    afwy.i((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.val$uin, this.val$id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.1
 * JD-Core Version:    0.7.0.1
 */