package com.tencent.qqmail.utilities.qmnetwork.ssl;

import java.util.Map;
import rx.functions.Action1;

final class SafeSSLStrategy$4
  implements Action1<String>
{
  SafeSSLStrategy$4(Map paramMap1, Map paramMap2) {}
  
  public void call(String paramString)
  {
    int i = Integer.valueOf(paramString).intValue();
    if (!SafeSSLStrategy.access$600(i))
    {
      paramString = (String)this.val$unconfirmedCertificate.get(Integer.valueOf(i));
      String str = (String)this.val$unconfirmedHost.get(Integer.valueOf(i));
      SafeSSLStrategy.access$500(Integer.valueOf(i).intValue(), paramString, str, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy.4
 * JD-Core Version:    0.7.0.1
 */