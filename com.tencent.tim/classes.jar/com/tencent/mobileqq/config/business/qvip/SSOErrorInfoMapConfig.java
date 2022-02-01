package com.tencent.mobileqq.config.business.qvip;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

public class SSOErrorInfoMapConfig
  implements Serializable
{
  public HashMap<String, a> mErrorMap = new HashMap();
  
  public String getErrorInfo(String paramString1, String paramString2)
  {
    if (this.mErrorMap.containsKey(paramString1))
    {
      paramString1 = (a)this.mErrorMap.get(paramString1);
      if (paramString1.kb.containsKey(paramString2))
      {
        paramString1 = (b)paramString1.kb.get(paramString2);
        paramString2 = Locale.getDefault().getCountry();
        String str = Locale.getDefault().getLanguage();
        paramString2 = str.toLowerCase() + "_" + paramString2.toLowerCase();
        if (paramString1.kc.containsKey(paramString2)) {
          return (String)paramString1.kc.get(paramString2);
        }
      }
    }
    return null;
  }
  
  public static class a
  {
    public HashMap<String, SSOErrorInfoMapConfig.b> kb = new HashMap();
  }
  
  public static class b
  {
    public HashMap<String, String> kc = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig
 * JD-Core Version:    0.7.0.1
 */