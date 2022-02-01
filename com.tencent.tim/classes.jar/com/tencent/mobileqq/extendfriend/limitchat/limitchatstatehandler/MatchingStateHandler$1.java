package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import aftr;
import afxe;
import aine;
import alur;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MatchingStateHandler$1
  implements Runnable
{
  public MatchingStateHandler$1(afxe paramafxe) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aine.ai((QQAppInterface)localObject, this.this$0.c.bFC);
    aine.a((QQAppInterface)localObject, this.this$0.c, this.this$0.c.timeStamp, 2);
    String str1 = this.this$0.c.bFC;
    int i = this.this$0.c.tagId;
    String str2 = this.this$0.c.tagName;
    if (!TextUtils.isEmpty(this.this$0.c.tipsWording)) {}
    for (boolean bool = true;; bool = false)
    {
      aine.a((QQAppInterface)localObject, str1, i, str2, bool, -1, false, 3);
      if (this.this$0.c.tagId >= 2)
      {
        localObject = (alur)((QQAppInterface)localObject).getManager(285);
        ((alur)localObject).Pa(this.this$0.c.bFC);
        ((alur)localObject).dJR();
      }
      ThreadManager.getUIHandler().post(new MatchingStateHandler.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1
 * JD-Core Version:    0.7.0.1
 */