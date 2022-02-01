package com.tencent.moai.mailsdk.util;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class ParamUtility
{
  private static final String TAG = "ParamUtility";
  private static boolean splitLongParameters = false;
  
  public static String paramToString(HashMap<String, String> paramHashMap, int paramInt)
  {
    ToStringBuffer localToStringBuffer = new ToStringBuffer(paramInt);
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramHashMap = (Map.Entry)localIterator.next();
      String str = (String)paramHashMap.getKey();
      paramHashMap = (String)paramHashMap.getValue();
      if ((paramHashMap.length() > 60) && (splitLongParameters))
      {
        str = str + "*";
        paramInt = 0;
        while (paramHashMap.length() > 60)
        {
          localToStringBuffer.addNV(str + paramInt, quote(paramHashMap.substring(0, 60)));
          paramHashMap = paramHashMap.substring(60);
          paramInt += 1;
        }
        if (paramHashMap.length() > 0) {
          localToStringBuffer.addNV(str + paramInt, quote(paramHashMap));
        }
      }
      else
      {
        localToStringBuffer.addNV(str, quote(paramHashMap));
      }
    }
    return localToStringBuffer.toString();
  }
  
  public static void parseParams(HashMap<String, String> paramHashMap, String paramString)
    throws MessageException
  {
    HeaderTokenizer localHeaderTokenizer = new HeaderTokenizer(paramString, "()<>@,;:\\\"\t []/?=");
    for (;;)
    {
      int i = localHeaderTokenizer.next().getType();
      if (i == -4) {
        return;
      }
      Object localObject1;
      String str;
      Object localObject2;
      if ((char)i == ';')
      {
        for (localObject1 = localHeaderTokenizer.next(); (char)((HeaderTokenizer.Token)localObject1).getType() == ';'; localObject1 = localHeaderTokenizer.next()) {}
        if (((HeaderTokenizer.Token)localObject1).getType() == -4) {
          break;
        }
        if (((HeaderTokenizer.Token)localObject1).getType() != -1) {
          throw new MessageException(2, "In parameter list <" + paramString + ">, expected parameter name, got \"" + ((HeaderTokenizer.Token)localObject1).getValue() + "\"");
        }
        str = ((HeaderTokenizer.Token)localObject1).getValue().toLowerCase(Locale.ENGLISH);
        localObject2 = localHeaderTokenizer.next();
        if (((HeaderTokenizer.Token)localObject2).getType() == -4)
        {
          if (!Charset.isSupported(str)) {
            break;
          }
          paramHashMap.put("charset", str);
          return;
        }
        localObject1 = localObject2;
        if ((char)((HeaderTokenizer.Token)localObject2).getType() == '=') {
          localObject1 = localHeaderTokenizer.next();
        }
        i = ((HeaderTokenizer.Token)localObject1).getType();
        if ((i != -1) && (i != -2)) {
          Logger.log(5, "ParamUtility", "In parameter list <" + paramString + ">, expected parameter value, got \"" + ((HeaderTokenizer.Token)localObject1).getValue() + "\"");
        }
        localObject1 = ((HeaderTokenizer.Token)localObject1).getValue();
        if (localObject1 == null) {}
      }
      try
      {
        localObject2 = MimeUtility.decodeText((String)localObject1, "iso-8859-1");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label267:
        break label267;
      }
      paramHashMap.put(str, localObject1);
    }
  }
  
  private static String quote(String paramString)
  {
    return MimeUtility.quote(paramString, "()<>@,;:\\\"\t []/?=");
  }
  
  static class ToStringBuffer
  {
    private StringBuffer sb = new StringBuffer();
    private int used;
    
    public ToStringBuffer(int paramInt)
    {
      this.used = paramInt;
    }
    
    public void addNV(String paramString1, String paramString2)
    {
      this.sb.append("; ");
      this.used += 2;
      if (paramString1.length() + paramString2.length() + 1 + this.used > 76)
      {
        this.sb.append("\r\n\t");
        this.used = 8;
      }
      this.sb.append(paramString1).append('=');
      this.used += paramString1.length() + 1;
      if (this.used + paramString2.length() > 76)
      {
        paramString1 = MimeUtility.fold(this.used, paramString2);
        this.sb.append(paramString1);
        int i = paramString1.lastIndexOf('\n');
        if (i >= 0)
        {
          int j = this.used;
          this.used = (paramString1.length() - i - 1 + j);
          return;
        }
        i = this.used;
        this.used = (paramString1.length() + i);
        return;
      }
      this.sb.append(paramString2);
      this.used += paramString2.length();
    }
    
    public String toString()
    {
      return this.sb.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.ParamUtility
 * JD-Core Version:    0.7.0.1
 */