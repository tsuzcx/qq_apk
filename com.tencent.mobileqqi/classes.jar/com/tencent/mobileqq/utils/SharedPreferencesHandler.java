package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashSet;
import java.util.Set;

public class SharedPreferencesHandler
{
  static final String a = " ";
  
  public static SharedPreferences.Editor a(SharedPreferences.Editor paramEditor, String paramString, Object[] paramArrayOfObject)
  {
    String str = "";
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfObject[i];
        str = str + localObject.toString();
        str = str + " ";
        i += 1;
      }
      paramEditor.putString(paramString, str);
      return paramEditor;
    }
    paramEditor.putString(paramString, "");
    return paramEditor;
  }
  
  public static Set a(SharedPreferences paramSharedPreferences, String paramString, Set paramSet)
  {
    paramString = paramSharedPreferences.getString(paramString, "");
    paramSharedPreferences = paramSet;
    if (paramString != null)
    {
      paramSharedPreferences = paramSet;
      if (paramString.length() > 0)
      {
        String[] arrayOfString = paramString.split(" ");
        paramSharedPreferences = paramSet;
        if (paramSet == null)
        {
          paramString = new HashSet();
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            paramSharedPreferences = paramString;
            if (i >= j) {
              break;
            }
            paramSharedPreferences = arrayOfString[i];
            if ((paramSharedPreferences != null) && (paramSharedPreferences.length() > 0)) {
              paramString.add(paramSharedPreferences);
            }
            i += 1;
          }
        }
      }
    }
    return paramSharedPreferences;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SharedPreferencesHandler
 * JD-Core Version:    0.7.0.1
 */