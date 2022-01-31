package com.tencent.qphone.base.remote;

import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SimpleAccount
{
  public static final String _ISLOGINED = "_isLogined";
  public static final String _LOGINPROCESS = "_loginedProcess";
  public static final String _LOGINTIME = "_loginTime";
  public static final String _UIN = "_uin";
  private static final String tag = "SimpleAccount";
  private HashMap attributes = new HashMap();
  
  public static boolean isSameAccount(SimpleAccount paramSimpleAccount1, SimpleAccount paramSimpleAccount2)
  {
    return (paramSimpleAccount1.getUin().equals(paramSimpleAccount2.getUin())) && (paramSimpleAccount1.isLogined() == paramSimpleAccount2.isLogined());
  }
  
  public static SimpleAccount parseSimpleAccount(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      SimpleAccount localSimpleAccount = new SimpleAccount();
      String[] arrayOfString = paramString.split(",");
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        paramString = localSimpleAccount;
        if (i >= j) {
          return paramString;
        }
        paramString = arrayOfString[i];
        if (paramString.length() > 0) {
          paramString = paramString.split("=");
        }
        try
        {
          if (paramString.length == 2)
          {
            String str = new String(HexUtil.hexStr2Bytes(paramString[1]), "UTF-8");
            localSimpleAccount.attributes.put(paramString[0], str);
          }
          i += 1;
        }
        catch (UnsupportedEncodingException paramString)
        {
          for (;;)
          {
            QLog.d("SimpleAccount", 1, paramString.toString(), paramString);
          }
        }
      }
    }
    paramString = null;
    return paramString;
  }
  
  public boolean containsKey(String paramString)
  {
    return this.attributes.containsKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SimpleAccount)) {
      return isSameAccount(this, (SimpleAccount)paramObject);
    }
    return false;
  }
  
  public String getAttribute(String paramString1, String paramString2)
  {
    if (this.attributes.containsKey(paramString1)) {
      return (String)this.attributes.get(paramString1);
    }
    return paramString2;
  }
  
  public HashMap getAttributes()
  {
    return this.attributes;
  }
  
  public String getLoginProcess()
  {
    return getAttribute("_loginedProcess", "");
  }
  
  public String getUin()
  {
    return getAttribute("_uin", "");
  }
  
  public boolean isLogined()
  {
    return Boolean.parseBoolean(getAttribute("_isLogined", String.valueOf(false)));
  }
  
  public String removeAttribute(String paramString)
  {
    return (String)this.attributes.remove(paramString);
  }
  
  public void setAttribute(String paramString1, String paramString2)
  {
    if (paramString1.indexOf(" ") > 0) {
      throw new RuntimeException("key found space ");
    }
    this.attributes.put(paramString1, paramString2);
  }
  
  public void setLoginProcess(String paramString)
  {
    setAttribute("_loginedProcess", paramString);
  }
  
  public void setUin(String paramString)
  {
    setAttribute("_uin", paramString);
  }
  
  public String toStoreString()
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.attributes.keySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      try
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = (String)this.attributes.get(str1);
        if (str2 != null) {
          ((StringBuffer)localObject1).append(str1 + "=" + HexUtil.bytes2HexStr(str2.getBytes("UTF-8")) + ",");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.d("SimpleAccount", 1, localUnsupportedEncodingException.toString(), localUnsupportedEncodingException);
      }
    }
    localObject2 = ((StringBuffer)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith(",")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    return localObject1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.attributes.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)this.attributes.get(str1);
      localStringBuffer.append(str1 + ":" + str2 + ",");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.SimpleAccount
 * JD-Core Version:    0.7.0.1
 */