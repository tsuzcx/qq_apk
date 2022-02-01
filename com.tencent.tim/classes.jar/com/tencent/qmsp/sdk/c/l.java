package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.app.QmspSDK;
import java.util.HashMap;

public class l
  implements c
{
  private HashMap<String, e> a = new HashMap();
  
  public void a(e parame)
  {
    String str = parame.a();
    if ((str != null) && (!this.a.containsKey(str))) {
      this.a.put(str, parame);
    }
  }
  
  public Object getApplicationContext()
  {
    return QmspSDK.getContext();
  }
  
  public int getRuntimeVersion()
  {
    return 512;
  }
  
  public e queryRuntimeInterface(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    e locale2 = (e)this.a.get(paramString);
    e locale1 = locale2;
    if (locale2 != null)
    {
      locale1 = locale2;
      if (!paramString.equals(locale2.a())) {
        locale1 = null;
      }
    }
    return locale1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.l
 * JD-Core Version:    0.7.0.1
 */