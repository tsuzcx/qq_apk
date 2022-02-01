package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class MiniappHttpUtil
{
  public static final int LOCAL_RET_CODE_ABORTED = -5;
  public static final int LOCAL_RET_CODE_CONNECT = -2;
  public static final int LOCAL_RET_CODE_EXCEPTION = -1;
  public static final int LOCAL_RET_CODE_METHOD_NOT_SUPPORT = -3;
  public static final int LOCAL_RET_CODE_URL_INVALID = -4;
  private static final String TAG = "MiniappHttpUtil";
  
  public static void fillErrMsg(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    switch (paramInt)
    {
    case -4: 
    default: 
    case -5: 
      try
      {
        paramJSONObject.put("errMsg", "unknown reason");
        return;
      }
      catch (Throwable paramString)
      {
        QMLog.e("MiniappHttpUtil", "fillErrMsg", paramString);
        return;
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "abort";; paramString = paramString + ":fail abort")
      {
        paramJSONObject.put("errMsg", paramString);
        return;
      }
    }
    paramJSONObject.put("errMsg", "request protocol error");
  }
  
  public static boolean isRefererVersionValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("MiniappHttpUtil", "version is null, return.");
      return false;
    }
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label59;
      }
      int k = paramString.charAt(i);
      if (((k <= 31) && (k != 9)) || (k >= 127)) {
        break;
      }
      i += 1;
    }
    label59:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil
 * JD-Core Version:    0.7.0.1
 */