package com.tencent.qqmail.ftn.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.QMApplicationContext;
import java.util.Map;

public class SharedUrlUtil
{
  private static final int MODE_PRIVATE = 0;
  private static final String NAME = "shareurl";
  private static final SharedPreferences.Editor editor = sharedPreferences.edit();
  private static final SharedPreferences sharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("shareurl", 0);
  
  public static void clearAll()
  {
    editor.clear();
  }
  
  public static boolean contain(String paramString)
  {
    return sharedPreferences.contains(paramString);
  }
  
  private static int getCount()
  {
    int i = 0;
    Map localMap = sharedPreferences.getAll();
    if (localMap != null) {
      i = localMap.size();
    }
    return i;
  }
  
  public static String getUrl(String paramString)
  {
    return sharedPreferences.getString(paramString, null);
  }
  
  public static void put(String paramString1, String paramString2)
  {
    if (getCount() >= 50) {
      clearAll();
    }
    editor.putString(paramString1, paramString2);
    editor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.util.SharedUrlUtil
 * JD-Core Version:    0.7.0.1
 */