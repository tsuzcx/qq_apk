package com.tencent.mobileqq.apollo.process.chanel;

import aboc;
import abod;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmGameSubProcessHandler$1
  implements Runnable
{
  public CmGameSubProcessHandler$1(aboc paramaboc, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      String str = new JSONObject(this.aWQ).optString("extendInfo");
      ApolloGameUtil.a(aboc.a(this.this$0), str, new abod(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.1
 * JD-Core Version:    0.7.0.1
 */