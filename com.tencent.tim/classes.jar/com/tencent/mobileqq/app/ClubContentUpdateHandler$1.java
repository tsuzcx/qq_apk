package com.tencent.mobileqq.app;

import abhh;
import accr;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;

public class ClubContentUpdateHandler$1
  implements Runnable
{
  public ClubContentUpdateHandler$1(accr paramaccr, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      abhh localabhh = (abhh)this.this$0.app.getManager(153);
      int i = ApolloUtil.gh(1);
      if (i != this.cuE) {
        localabhh.Hd(1);
      }
      QLog.i("ClubContentUpdateHandler", 1, "handleApolloPanelRelTimeUpdate name: " + this.val$name + ", ver: " + this.cuE + ", locver: " + i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 1, "handleApolloPanelRealTimeUpdate failed" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler.1
 * JD-Core Version:    0.7.0.1
 */