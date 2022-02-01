package com.tencent.mobileqq.msf.core.net.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsfCmdConfig
{
  private static final String CMD_DELETE_FILE = "rm";
  private static final String CMD_DELETE_SP_KEY = "rm_kv";
  private static final String CMD_NOT_AUTO_RESTART = "not_auto_restart";
  private static final String CMD_NOT_EXIT = "not_exit";
  private static final String CMD_SAFE_MODE_TEST_FLAG = "test_flag";
  public static final String KEY_NOT_AUTO_RESTART_CRASH_STACK = "key_not_restart_crash_stack";
  public static final String KEY_NOT_AUTO_RESTART_CRASH_TYPE = "key_not_restart_crash_type";
  public static final String KEY_NOT_AUTO_RESTART_DELAY_MILL = "key_not_restart_delay_mill";
  public static final String KEY_NOT_AUTO_RESTART_ENABLE = "key_not_restart_enable";
  public static final String KEY_NOT_AUTO_RESTART_MAX_CRASH_NUM = "key_not_restart_max_crash";
  public static final String KEY_NOT_AUTO_RESTART_VERSION = "key_not_restart_version";
  public static final String KEY_NOT_EXIT_CRASH_STACK = "key_not_exit_crash_stack";
  public static final String KEY_NOT_EXIT_CRASH_TYPE = "key_not_exit_crash_type";
  public static final String KEY_NOT_EXIT_ENABLE = "key_not_exit_enable";
  private static final String KEY_NOT_EXIT_VERSION = "key_not_exit_version";
  public static final String NOT_AUTO_RESTART_CONTROL_FILE = "not_restart_control_file";
  public static final String SP_SAFEMODE_NOT_EXIT = "pref_safemode_not_exit";
  private static final String TAG = "MsfCmdConfig";
  
  public static void executeSafeModeCmd(int paramInt, String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject = paramString.getJSONObject(i);
        if (localObject != null)
        {
          localObject = getCmdFactory((JSONObject)localObject);
          if (localObject != null) {
            ((a)localObject).a(paramInt);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("MsfCmdConfig", 1, "handleSafeModeCmd exception=", paramString);
    }
  }
  
  private static a getCmdFactory(JSONObject paramJSONObject)
  {
    int i = 0;
    String str1 = paramJSONObject.optString("cmd", "");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("params");
    String str2 = paramJSONObject.optString("multiprocess", "");
    paramJSONObject = paramJSONObject.optString("deleteonetimemode", "");
    if (str2.equals("true")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramJSONObject.equals("true")) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        paramJSONObject = new ArrayList();
        for (;;)
        {
          if (i < localJSONArray.length()) {
            try
            {
              Object localObject = localJSONArray.getJSONObject(i);
              str2 = ((JSONObject)localObject).optString("key", "");
              localObject = ((JSONObject)localObject).optString("value", "");
              if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                paramJSONObject.add(new Pair(str2, localObject));
              }
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                QLog.d("MsfCmdConfig", 1, "getCmdFactory JSONException=", localJSONException);
              }
            }
          }
        }
        if ("rm".equals(str1)) {
          return new b(str1, paramJSONObject, bool1, bool2);
        }
        if ("rm_kv".equals(str1)) {
          return new c(str1, paramJSONObject, bool1, bool2);
        }
        if ("not_exit".equals(str1)) {
          return new e(str1, paramJSONObject, bool1);
        }
        if ("test_flag".equals(str1)) {
          return new f(str1, paramJSONObject, bool1);
        }
        if ("not_auto_restart".equals(str1)) {
          return new d(str1, paramJSONObject, bool1);
        }
        return null;
      }
    }
  }
  
  static abstract class a
  {
    protected String a;
    protected List b;
    protected boolean c;
    
    final void a(int paramInt)
    {
      if (a())
      {
        Iterator localIterator = this.b.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (a((Pair)localIterator.next()));
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          a(paramInt, this.b);
        }
        return;
      }
    }
    
    protected abstract void a(int paramInt, List paramList);
    
    protected abstract boolean a();
    
    protected abstract boolean a(Pair paramPair);
  }
  
  static class b
    extends MsfCmdConfig.a
  {
    private static final String e = "file_del_time";
    private static final String f = "key_delete_version";
    private boolean d;
    private final Set g = new b(this);
    
    b(String paramString, List paramList, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      this.a = paramString;
      this.b = paramList;
      this.c = paramBoolean1;
      this.d = paramBoolean2;
    }
    
    private String a(String paramString)
    {
      String str1 = File.separator + paramString + File.separator;
      String str2 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
      if ("${FILE_DIR}".equals(paramString)) {
        str1 = str2 + File.separator;
      }
      do
      {
        return str1;
        if ("${SP_DIR}".equals(paramString)) {
          return str2.replace("files", "shared_prefs") + File.separator;
        }
        if ("${DATA_DIR}".equals(paramString)) {
          return str2.replace("files", "");
        }
      } while (!"${SDCARD_DIR}".equals(paramString));
      return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
    }
    
    private void a(ArrayList paramArrayList, String paramString1, int paramInt, String paramString2)
    {
      if (paramInt >= paramArrayList.size())
      {
        paramArrayList = new File(paramString1);
        if ((paramArrayList.isFile()) && (paramArrayList.exists()))
        {
          paramArrayList.delete();
          MsfPullConfigUtil.showToastForSafeModeTest("执行删除文件指令，修复闪退");
        }
      }
      Object localObject;
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
          paramString1 = a((String)paramArrayList.get(paramInt));
        } while ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists()));
        a(paramArrayList, paramString1, paramInt + 1, paramString2);
        return;
        localObject = (String)paramArrayList.get(paramInt);
        if ("plain".equals(paramString2))
        {
          localObject = new StringBuilder().append(paramString1).append((String)localObject);
          if (paramInt == paramArrayList.size() - 1) {}
          for (paramString1 = "";; paramString1 = File.separator)
          {
            a(paramArrayList, paramString1, paramInt + 1, paramString2);
            return;
          }
        }
        localObject = new File(paramString1).listFiles(new c(this, (String)localObject));
      } while ((localObject == null) || (localObject.length <= 0));
      int j = localObject.length;
      int i = 0;
      label212:
      StringBuilder localStringBuilder;
      if (i < j)
      {
        paramString1 = localObject[i];
        localStringBuilder = new StringBuilder().append(paramString1.getAbsolutePath());
        if (paramInt != paramArrayList.size() - 1) {
          break label282;
        }
      }
      label282:
      for (paramString1 = "";; paramString1 = File.separator)
      {
        a(paramArrayList, paramString1, paramInt + 1, paramString2);
        i += 1;
        break label212;
        break;
      }
    }
    
    protected void a(int paramInt, List paramList)
    {
      try
      {
        if (this.d)
        {
          localObject = BaseApplication.getContext().getSharedPreferences("file_del_time", 0);
          i = ((SharedPreferences)localObject).getInt("key_delete_version", 0);
          if (i == paramInt) {
            break label201;
          }
          localObject = ((SharedPreferences)localObject).edit();
          if (localObject != null)
          {
            ((SharedPreferences.Editor)localObject).putInt("key_delete_version", paramInt);
            ((SharedPreferences.Editor)localObject).commit();
          }
          QLog.d("MsfCmdConfig", 1, "One Time Mode,just delete file one times,localversion =" + i + ",version = " + paramInt);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject;
          int i;
          String[] arrayOfString;
          ArrayList localArrayList;
          label201:
          QLog.e("MsfCmdConfig", 1, "execute faild", localThrowable);
          continue;
          a(localArrayList, "", 0, (String)localThrowable.first);
        }
      }
      QLog.d("MsfCmdConfig", 1, "safe mode delete file");
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject = (Pair)paramList.next();
        arrayOfString = ((String)((Pair)localObject).second).split(File.separator);
        localArrayList = new ArrayList();
        i = arrayOfString.length;
        paramInt = 0;
        while (paramInt < i)
        {
          String str = arrayOfString[paramInt];
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          }
          paramInt += 1;
        }
        QLog.d("MsfCmdConfig", 1, "One Time Mode,don't delete file one more times,localversion =" + i + ",version = " + paramInt);
      }
    }
    
    protected boolean a()
    {
      return ("rm".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
    }
    
    protected boolean a(Pair paramPair)
    {
      if (!this.g.contains(paramPair.first)) {}
      while (TextUtils.isEmpty((CharSequence)paramPair.second)) {
        return false;
      }
      paramPair = ((String)paramPair.second).split(File.separator);
      int m = paramPair.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (!TextUtils.isEmpty(paramPair[i])) {
          k = j + 1;
        }
        i += 1;
      }
      if (j >= 2) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  static class c
    extends MsfCmdConfig.a
  {
    private static final String e = "sp_del_time";
    private static final String f = "key_sp_delete_version";
    private boolean d = false;
    
    c(String paramString, List paramList, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      this.a = paramString;
      this.b = paramList;
      this.c = paramBoolean1;
      this.d = paramBoolean2;
    }
    
    protected void a(int paramInt, List paramList)
    {
      int i;
      try
      {
        if (this.d)
        {
          localObject1 = BaseApplication.getContext().getSharedPreferences("sp_del_time", 0);
          i = ((SharedPreferences)localObject1).getInt("key_sp_delete_version", 0);
          if (i == paramInt) {
            break label387;
          }
          localObject1 = ((SharedPreferences)localObject1).edit();
          if (localObject1 != null)
          {
            ((SharedPreferences.Editor)localObject1).putInt("key_sp_delete_version", paramInt);
            ((SharedPreferences.Editor)localObject1).commit();
          }
          QLog.d("MsfCmdConfig", 1, "One Time Mode,just delete sp one times,localversion =" + i + ",version = " + paramInt);
        }
      }
      catch (Throwable localThrowable)
      {
        do
        {
          for (;;)
          {
            Object localObject1;
            QLog.e("MsfCmdConfig", 1, "execute delete sp faild", localThrowable);
            continue;
            paramInt = 0;
            continue;
            MsfPullConfigUtil.showToastForSafeModeTest("执行删除sp指令，修复闪退");
          }
          localObject3 = new File(localThrowable).listFiles(new d(this, (Pair)localObject2));
        } while ((localObject3 == null) || (localObject3.length <= 0));
        j = localObject3.length;
        i = 0;
      }
      localObject1 = BaseApplication.getContext().getFilesDir().getAbsolutePath().replace("files", "shared_prefs");
      if (this.c)
      {
        paramInt = 4;
        QLog.d("MsfCmdConfig", 1, new Object[] { " The SharedPreferenceMode is ", Integer.valueOf(paramInt) });
        paramList = paramList.iterator();
      }
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if (paramList.hasNext())
        {
          localObject2 = (Pair)paramList.next();
          localObject3 = new File((String)localObject1 + File.separator + (String)((Pair)localObject2).first + ".xml");
          if ((!((File)localObject3).isFile()) || (!((File)localObject3).exists())) {
            break label450;
          }
          localObject4 = BaseApplication.getContext().getSharedPreferences((String)((Pair)localObject2).first, paramInt);
          localObject3 = ((SharedPreferences)localObject4).edit();
          if (localObject3 != null)
          {
            localObject4 = ((SharedPreferences)localObject4).getAll();
            localObject2 = Pattern.compile((String)((Pair)localObject2).second);
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (String)((Map.Entry)((Iterator)localObject4).next()).getKey();
              if (((Pattern)localObject2).matcher((CharSequence)localObject5).matches())
              {
                ((SharedPreferences.Editor)localObject3).remove((String)localObject5).commit();
                QLog.d("MsfCmdConfig", 1, new Object[] { localObject5, " has been removed" });
              }
            }
            label387:
            QLog.d("MsfCmdConfig", 1, "One Time Mode,don't delete sp one more times,localversion =" + i + ",version = " + paramInt);
          }
        }
        else
        {
          return;
        }
        label450:
        int j;
        while (i < j)
        {
          localObject4 = localObject3[i];
          if ((((File)localObject4).isFile()) && (((File)localObject4).exists()))
          {
            localObject4 = ((File)localObject4).getName();
            if (((String)localObject4).endsWith(".xml"))
            {
              localObject4 = ((String)localObject4).substring(0, ((String)localObject4).length() - 4);
              localObject5 = BaseApplication.getContext().getSharedPreferences((String)localObject4, paramInt);
              localObject4 = ((SharedPreferences)localObject5).edit();
              if (localObject4 != null)
              {
                Object localObject6 = ((SharedPreferences)localObject5).getAll();
                localObject5 = Pattern.compile((String)((Pair)localObject2).second);
                localObject6 = ((Map)localObject6).entrySet().iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  String str = (String)((Map.Entry)((Iterator)localObject6).next()).getKey();
                  if (((Pattern)localObject5).matcher(str).matches())
                  {
                    ((SharedPreferences.Editor)localObject4).remove(str).commit();
                    QLog.d("MsfCmdConfig", 1, new Object[] { str, " has been removed" });
                  }
                }
              }
              MsfPullConfigUtil.showToastForSafeModeTest("执行删除sp指令，修复闪退");
            }
          }
          i += 1;
        }
      }
    }
    
    protected boolean a()
    {
      return ("rm_kv".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
    }
    
    protected boolean a(Pair paramPair)
    {
      if (TextUtils.isEmpty((CharSequence)paramPair.first)) {
        return false;
      }
      return !TextUtils.isEmpty((CharSequence)paramPair.second);
    }
  }
  
  static class d
    extends MsfCmdConfig.a
  {
    d(String paramString, List paramList, boolean paramBoolean)
    {
      super();
      this.a = paramString;
      this.b = paramList;
      this.c = paramBoolean;
    }
    
    protected void a(int paramInt, List paramList)
    {
      Object localObject1 = null;
      boolean bool = false;
      Object localObject2 = BaseApplication.getContext().getSharedPreferences("not_restart_control_file", 4);
      SharedPreferences.Editor localEditor;
      int i;
      int j;
      if (paramInt > ((SharedPreferences)localObject2).getInt("key_not_restart_version", 0))
      {
        localEditor = ((SharedPreferences)localObject2).edit();
        localEditor.putInt("key_not_restart_version", paramInt);
        Iterator localIterator = paramList.iterator();
        paramList = null;
        i = 100;
        paramInt = 2147483647;
        if (localIterator.hasNext())
        {
          localObject2 = (Pair)localIterator.next();
          if ("enable".equals(((Pair)localObject2).first))
          {
            bool = Boolean.parseBoolean((String)((Pair)localObject2).second);
            j = i;
            localObject2 = localObject1;
            i = paramInt;
            paramInt = j;
            localObject1 = paramList;
            paramList = (List)localObject2;
          }
        }
      }
      for (;;)
      {
        j = i;
        localObject2 = localObject1;
        localObject1 = paramList;
        paramList = (List)localObject2;
        i = paramInt;
        paramInt = j;
        break;
        if ("maxCrashNum".equals(((Pair)localObject2).first))
        {
          if (((Pair)localObject2).second == null) {}
          for (paramInt = 2147483647;; paramInt = Integer.parseInt((String)((Pair)localObject2).second))
          {
            j = paramInt;
            localObject2 = paramList;
            paramList = (List)localObject1;
            localObject1 = localObject2;
            paramInt = i;
            i = j;
            break;
          }
        }
        if ("crashType".equals(((Pair)localObject2).first))
        {
          if (((Pair)localObject2).second == null) {}
          for (paramList = "";; paramList = (String)((Pair)localObject2).second)
          {
            j = paramInt;
            localObject2 = paramList;
            paramList = (List)localObject1;
            localObject1 = localObject2;
            paramInt = i;
            i = j;
            break;
          }
        }
        if ("crashStack".equals(((Pair)localObject2).first))
        {
          if (((Pair)localObject2).second == null) {}
          for (localObject1 = "";; localObject1 = (String)((Pair)localObject2).second)
          {
            localObject2 = paramList;
            j = paramInt;
            paramList = (List)localObject1;
            localObject1 = localObject2;
            paramInt = i;
            i = j;
            break;
          }
        }
        if ("delayMill".equals(((Pair)localObject2).first))
        {
          if (((Pair)localObject2).second == null) {}
          for (i = 100;; i = Integer.parseInt((String)((Pair)localObject2).second))
          {
            j = paramInt;
            localObject2 = paramList;
            paramInt = i;
            paramList = (List)localObject1;
            localObject1 = localObject2;
            i = j;
            break;
          }
          QLog.d("MsfCmdConfig", 1, "enable=" + bool + ",maxCrashNum=" + paramInt + ",crashType=" + paramList + ",crashStack=" + (String)localObject1 + ",delayMill=" + i);
          localEditor.putBoolean("key_not_restart_enable", bool);
          localEditor.putInt("key_not_restart_max_crash", paramInt);
          localEditor.putString("key_not_restart_crash_type", paramList);
          localEditor.putString("key_not_restart_crash_stack", (String)localObject1);
          localEditor.putInt("key_not_restart_delay_mill", i);
          localEditor.commit();
          return;
        }
        localObject2 = paramList;
        j = paramInt;
        paramList = (List)localObject1;
        localObject1 = localObject2;
        paramInt = i;
        i = j;
      }
    }
    
    protected boolean a()
    {
      return ("not_auto_restart".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
    }
    
    protected boolean a(Pair paramPair)
    {
      if ((!"enable".equals(paramPair.first)) && (!"maxCrashNum".equals(paramPair.first)) && (!"crashType".equals(paramPair.first)) && (!"crashStack".equals(paramPair.first)) && (!"delayMill".equals(paramPair.first))) {
        return false;
      }
      return (!"enable".equals(paramPair.first)) || (!TextUtils.isEmpty((CharSequence)paramPair.second));
    }
  }
  
  static class e
    extends MsfCmdConfig.a
  {
    e(String paramString, List paramList, boolean paramBoolean)
    {
      super();
      this.a = paramString;
      this.b = paramList;
      this.c = paramBoolean;
    }
    
    protected void a(int paramInt, List paramList)
    {
      Pair localPair = null;
      boolean bool = false;
      Object localObject = BaseApplication.getContext().getSharedPreferences("pref_safemode_not_exit", 0);
      SharedPreferences.Editor localEditor;
      if (paramInt > ((SharedPreferences)localObject).getInt("key_not_exit_version", 0))
      {
        localEditor = ((SharedPreferences)localObject).edit();
        localEditor.putInt("key_not_exit_version", paramInt);
        Iterator localIterator = paramList.iterator();
        localObject = null;
        paramList = localPair;
        if (localIterator.hasNext())
        {
          localPair = (Pair)localIterator.next();
          if ("enable".equals(localPair.first)) {
            bool = Boolean.parseBoolean((String)localPair.second);
          }
        }
      }
      for (;;)
      {
        break;
        if ("crashType".equals(localPair.first))
        {
          if (localPair.second == null) {}
          for (localObject = "";; localObject = (String)localPair.second) {
            break;
          }
        }
        if ("crashStack".equals(localPair.first))
        {
          if (localPair.second == null) {}
          for (paramList = "";; paramList = (String)localPair.second) {
            break;
          }
          QLog.d("MsfCmdConfig", 1, "noExitEnable=" + bool + ",noExitCrashType=" + (String)localObject + ",noExitCrashStack=" + paramList);
          localEditor.putBoolean("key_not_exit_enable", bool);
          localEditor.putString("key_not_exit_crash_type", (String)localObject);
          localEditor.putString("key_not_exit_crash_stack", paramList);
          localEditor.commit();
          return;
        }
      }
    }
    
    protected boolean a()
    {
      return ("not_exit".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
    }
    
    protected boolean a(Pair paramPair)
    {
      if ((!"enable".equals(paramPair.first)) && (!"crashType".equals(paramPair.first)) && (!"crashStack".equals(paramPair.first))) {
        return false;
      }
      return (!"enable".equals(paramPair.first)) || (!TextUtils.isEmpty((CharSequence)paramPair.second));
    }
  }
  
  static class f
    extends MsfCmdConfig.a
  {
    f(String paramString, List paramList, boolean paramBoolean)
    {
      super();
      this.a = paramString;
      this.b = paramList;
      this.c = paramBoolean;
    }
    
    protected void a(int paramInt, List paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Pair localPair = (Pair)paramList.next();
        if ("enable".equals(localPair.first)) {
          BaseApplication.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", Boolean.parseBoolean((String)localPair.second)).commit();
        }
      }
    }
    
    protected boolean a()
    {
      return ("test_flag".equals(this.a)) && (this.b != null) && (this.b.size() > 0);
    }
    
    protected boolean a(Pair paramPair)
    {
      if (!"enable".equals(paramPair.first)) {
        return false;
      }
      return !TextUtils.isEmpty((CharSequence)paramPair.second);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig
 * JD-Core Version:    0.7.0.1
 */