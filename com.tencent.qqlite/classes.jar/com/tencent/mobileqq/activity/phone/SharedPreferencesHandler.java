package com.tencent.mobileqq.activity.phone;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class SharedPreferencesHandler
{
  static final String a = "|";
  
  public static SharedPreferences.Editor a(SharedPreferences.Editor paramEditor, String paramString, Set paramSet)
  {
    int j = 1;
    int k = 0;
    int i;
    if (paramSet != null)
    {
      i = 1;
      if (paramSet.isEmpty()) {
        break label114;
      }
    }
    for (;;)
    {
      label21:
      if ((i | j) != 0)
      {
        Object[] arrayOfObject = paramSet.toArray();
        j = arrayOfObject.length;
        paramSet = "";
        i = k;
        for (;;)
        {
          if (i < j)
          {
            Object localObject = arrayOfObject[i];
            paramSet = paramSet + localObject.toString();
            paramSet = paramSet + "|";
            i += 1;
            continue;
            i = 0;
            break;
            label114:
            j = 0;
            break label21;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SharedPreferences", 2, "SharedPreferences, putStringSet: " + paramSet);
        }
        paramEditor.putString(paramString, paramSet);
      }
    }
    return paramEditor;
  }
  
  public static Set a(SharedPreferences paramSharedPreferences, String paramString, Set paramSet)
  {
    paramString = paramSharedPreferences.getString(paramString, "");
    paramSharedPreferences = paramSet;
    if (paramString != null)
    {
      paramSharedPreferences = paramSet;
      if (paramString.length() != 0)
      {
        String[] arrayOfString = paramString.split("\\|");
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
            if ((paramSharedPreferences != null) && (paramSharedPreferences.length() != 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SharedPreferencesHandler
 * JD-Core Version:    0.7.0.1
 */