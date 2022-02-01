package com.tencent.mobileqq.theme;

import afgc;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import aogy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeCleaner
  extends BroadcastReceiver
  implements Runnable
{
  private static final HashSet<String> by;
  private static final HashSet<String> bz = new HashSet();
  private static final AtomicBoolean dS;
  private static final AtomicBoolean sInit = new AtomicBoolean(false);
  
  static
  {
    dS = new AtomicBoolean(false);
    HashSet localHashSet = new HashSet();
    localHashSet.add("1103");
    localHashSet.add("2971");
    localHashSet.add("2921");
    localHashSet.add("3064");
    localHashSet.add("3063");
    localHashSet.add("3066");
    localHashSet.add("3065");
    localHashSet.add("3067");
    localHashSet.add("2920");
    by = localHashSet;
  }
  
  private static void A(File paramFile)
  {
    VasQuickUpdateEngine.safeDeleteFile(paramFile, "theme_move_");
    int i = ThemeUtil.getFileNumInFile(paramFile);
    QLog.e("ThemeCleaner", 1, "clean " + paramFile.getName() + ", remain " + i);
  }
  
  public static void RQ(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("ThemeCleaner", 1, "addThemeToClean null appRuntime");
      return;
    }
    if (!c(localAppRuntime, paramString))
    {
      QLog.e("ThemeCleaner", 1, paramString + " should not clean");
      return;
    }
    QLog.e("ThemeCleaner", 1, "addThemeToClean: " + paramString);
    synchronized (bz)
    {
      n(localAppRuntime);
      bz.add(paramString);
      o(localAppRuntime);
      return;
    }
  }
  
  private static boolean c(AppRuntime paramAppRuntime, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!afgc.lO(paramString)) || ("1000".equals(paramString)) || (by.contains(paramString))) {}
    for (;;)
    {
      return false;
      paramAppRuntime = ThemeUtil.getUinThemePreferences(paramAppRuntime);
      try
      {
        Object localObject = paramAppRuntime.getString("themeArray", null);
        if ((!TextUtils.isEmpty(paramAppRuntime.getString("seriesID", null))) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localObject = new JSONArray((String)localObject);
          int i = 0;
          label87:
          if (i < ((JSONArray)localObject).length())
          {
            paramAppRuntime = ((JSONArray)localObject).getJSONObject(i);
            if (paramAppRuntime != null) {}
            for (paramAppRuntime = paramAppRuntime.getString("id");; paramAppRuntime = null)
            {
              boolean bool = paramString.equals(paramAppRuntime);
              if (bool) {
                break;
              }
              i += 1;
              break label87;
            }
          }
        }
        return true;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ThemeCleaner", 1, "shouldClean: ", paramAppRuntime);
        return false;
      }
    }
  }
  
  public static void fl(Context paramContext)
  {
    A(paramContext.getDir("theme_810", 0));
    A(paramContext.getDir("mobileqq_theme", 0));
    ThemeSwitcher.a(ThemeUtil.getCurrentThemeId(), "210", null);
  }
  
  public static void j(AppRuntime paramAppRuntime, String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new ThemeCleaner.1(paramString, paramAppRuntime));
  }
  
  private static void k(AppRuntime paramAppRuntime, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!afgc.lO(paramString)))
    {
      QLog.e("ThemeCleaner", 1, "cleanTheme error id: " + paramString);
      return;
    }
    if (paramString.equals(ThemeUtil.getCurrentThemeId()))
    {
      QLog.e("ThemeCleaner", 1, paramString + " is current, should not clean");
      return;
    }
    A(new File(new aogy().a(paramString).aR(paramAppRuntime.getApplication())));
  }
  
  private static void n(AppRuntime paramAppRuntime)
  {
    int i = 0;
    if (sInit.compareAndSet(false, true))
    {
      paramAppRuntime = ThemeUtil.getUinThemePreferences(paramAppRuntime);
      Object localObject = paramAppRuntime.getString("cleanList", "[]");
      try
      {
        localObject = new JSONArray((String)localObject);
        while (i < ((JSONArray)localObject).length())
        {
          bz.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ThemeCleaner", 1, "load: ", localJSONException);
        paramAppRuntime.edit().putString("cleanList", "[]").commit();
      }
    }
  }
  
  private static void o(AppRuntime paramAppRuntime)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = bz.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    ThemeUtil.getUinThemePreferences(paramAppRuntime).edit().putString("cleanList", localJSONArray.toString()).commit();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
      return;
    }
    ThreadManagerV2.excute(this, 64, null, false);
  }
  
  public void run()
  {
    if (!dS.compareAndSet(false, true))
    {
      QLog.e("ThemeCleaner", 1, "another thread is cleaning");
      return;
    }
    AppRuntime localAppRuntime1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime1 == null) {
      QLog.e("ThemeCleaner", 1, "cleanList null appRuntime");
    }
    for (;;)
    {
      dS.set(false);
      return;
      Object localObject2;
      synchronized (bz)
      {
        n(localAppRuntime1);
        localObject2 = new ArrayList(bz);
        if (((ArrayList)localObject2).isEmpty()) {
          QLog.e("ThemeCleaner", 1, "empty list");
        }
      }
      ??? = ((ArrayList)localObject2).iterator();
      while (((Iterator)???).hasNext()) {
        k(localAppRuntime2, (String)((Iterator)???).next());
      }
      synchronized (bz)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          bz.remove(str);
        }
      }
      o(localAppRuntime3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeCleaner
 * JD-Core Version:    0.7.0.1
 */