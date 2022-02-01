package com.tencent.qqlive.module.videoreport.dtreport.verifydata;

import android.util.Pair;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class VerifyDataHelper
{
  private static final String KEEP_FIELD_A = "^[Aa][0-9]+";
  private static final String KEEP_FIELD_DT = "dt_";
  private static final String KEEP_FIELD_RQD = "rqd_";
  private static final String TAG = "DT_DataCheck";
  private static final String WARNING = " 参数key不能为空，且不能以^[Aa][0-9]+, dt_, rqd_开头";
  
  public static void checkMap(Map<String, ?> paramMap)
  {
    paramMap = isValidMap(paramMap);
    if (!((Boolean)paramMap.second).booleanValue())
    {
      paramMap = (String)paramMap.first;
      doCrash("invalid input key:" + paramMap + "," + " 参数key不能为空，且不能以^[Aa][0-9]+, dt_, rqd_开头");
    }
  }
  
  private static void doCrash(String paramString)
  {
    if (VideoReport.isDebugMode())
    {
      Log.e("DT_DataCheck", paramString);
      throw new RuntimeException(paramString);
    }
  }
  
  private static boolean isValidKey(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((paramString.startsWith("dt_")) || (paramString.startsWith("rqd_")) || (Pattern.matches("^[Aa][0-9]+", paramString))) {
      return false;
    }
    return true;
  }
  
  private static Pair<String, Boolean> isValidMap(Map<String, ?> paramMap)
  {
    if (paramMap == null) {
      return new Pair("map is null", Boolean.valueOf(false));
    }
    if (paramMap.size() > 0)
    {
      paramMap = paramMap.keySet().iterator();
      while (paramMap.hasNext())
      {
        String str = (String)paramMap.next();
        if (!isValidKey(str)) {
          return new Pair(str, Boolean.valueOf(false));
        }
      }
    }
    return new Pair("", Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.verifydata.VerifyDataHelper
 * JD-Core Version:    0.7.0.1
 */