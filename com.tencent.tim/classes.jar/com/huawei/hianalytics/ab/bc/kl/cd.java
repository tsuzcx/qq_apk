package com.huawei.hianalytics.ab.bc.kl;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ef.ab;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cd
{
  public static String ab(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      ab.cd("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + paramString1);
    }
    while (!ab(paramString1, paramString2, paramString3)) {
      return paramString4;
    }
    return paramString2;
  }
  
  public static boolean ab(String paramString)
  {
    return !ab("eventId", paramString, 256);
  }
  
  public static boolean ab(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ab.cd("hmsSdk", "checkString() Parameter is empty : " + paramString1);
      return false;
    }
    if (paramString2.length() > paramInt)
    {
      ab.cd("hmsSdk", "checkString() Failure of parameter length check! Parameter:" + paramString1);
      return false;
    }
    return true;
  }
  
  public static boolean ab(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      ab.cd("hmsSdk", "checkString() Parameter is null! Parameter:" + paramString1);
      return false;
    }
    if (Pattern.compile(paramString3).matcher(paramString2).matches()) {
      return true;
    }
    ab.cd("hmsSdk", "checkString() Parameter verification failure! Parameter:" + paramString1);
    return false;
  }
  
  public static boolean ab(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      ab.cd("hmsSdk", "onEvent() mapValue has not data.so,The data will be empty");
      return false;
    }
    if ((paramMap.size() == 1) && ((paramMap.get("constants") != null) || (paramMap.get("_constants") != null)))
    {
      ab.cd("hmsSdk", "checkMap() the key can't be constants or _constants");
      return false;
    }
    if ((paramMap.size() > 2048) || (paramMap.toString().length() > 204800))
    {
      ab.cd("hmsSdk", "checkMap Map data is too big! size: " + paramMap.size() + " length: " + paramMap.toString().length());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.kl.cd
 * JD-Core Version:    0.7.0.1
 */