package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import aftr;
import afxb;
import aine;
import alur;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseStateHandler$2
  implements Runnable
{
  public BaseStateHandler$2(afxb paramafxb, aftr paramaftr) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aine.ai((QQAppInterface)localObject, this.a.bFC);
    aine.a((QQAppInterface)localObject, this.a, this.a.timeStamp, 1);
    String str1 = this.a.bFC;
    int i = this.a.tagId;
    String str2 = this.a.tagName;
    if (!TextUtils.isEmpty(this.a.tipsWording)) {}
    for (;;)
    {
      aine.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.a.tagId >= 2)
      {
        localObject = (alur)((QQAppInterface)localObject).getManager(285);
        ((alur)localObject).Pa(this.a.bFC);
        ((alur)localObject).dJR();
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler.2
 * JD-Core Version:    0.7.0.1
 */