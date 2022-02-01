package com.tencent.qqmail.utilities.cookieutils;

import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

public class CookieUtils
{
  private HashMap<String, String> cookieMap = new HashMap();
  
  public CookieUtils(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Iterator localIterator = StringExtention.parseParams((String)paramList.next(), ";").iterator();
      while (localIterator.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
        this.cookieMap.put(localNameValuePair.getName(), localNameValuePair.getValue());
      }
    }
  }
  
  public String getAuthImgs_id()
  {
    if (this.cookieMap == null) {
      return null;
    }
    return (String)this.cookieMap.get("qm_authimgs_id");
  }
  
  public HashMap<String, String> getCookieMap()
  {
    return this.cookieMap;
  }
  
  public String getSpcache()
  {
    if (this.cookieMap == null) {
      return null;
    }
    return (String)this.cookieMap.get("spcache");
  }
  
  public String getVerifySession()
  {
    if (this.cookieMap == null) {
      return null;
    }
    return (String)this.cookieMap.get("verifySession");
  }
  
  public void setCookieMap(HashMap<String, String> paramHashMap)
  {
    this.cookieMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cookieutils.CookieUtils
 * JD-Core Version:    0.7.0.1
 */