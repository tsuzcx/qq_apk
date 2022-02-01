package com.tencent.mobileqq.apollo.process.chanel;

import abnq;
import abnr;
import abvy;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class CmGameAvHandler$11
  implements Runnable
{
  public CmGameAvHandler$11(abnq paramabnq, Boolean paramBoolean) {}
  
  public void run()
  {
    if (this.al.booleanValue()) {
      if (abnq.a(this.this$0).size() > 0)
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
          break label115;
        }
      }
    }
    label115:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      localObject = ((QQAppInterface)localObject).getCurrentUin();
      abnq.a(this.this$0, (String[])abnq.a(this.this$0).toArray(new String[abnq.a(this.this$0).size()]), (String)localObject);
      return;
      abvy.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new abnr(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.11
 * JD-Core Version:    0.7.0.1
 */