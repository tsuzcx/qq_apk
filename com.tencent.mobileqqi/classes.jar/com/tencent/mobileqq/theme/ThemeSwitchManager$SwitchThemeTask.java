package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

class ThemeSwitchManager$SwitchThemeTask
  extends AsyncTask
{
  private int THEME_OPTION_ERROR = -1;
  private int THEME_OPTION_PKG_NOT_EXISTS = 1;
  private int THEME_OPTION_PKG_UNZIP_ERROR = 2;
  private int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
  private int THEME_OPTION_SUCCESS = 0;
  private AppRuntime mRuntime;
  
  public ThemeSwitchManager$SwitchThemeTask(ThemeSwitchManager paramThemeSwitchManager, AppRuntime paramAppRuntime)
  {
    this.mRuntime = paramAppRuntime;
  }
  
  public void clearChatBackground()
  {
    SharedPreferences localSharedPreferences = this.mRuntime.getApplication().getSharedPreferences("chat_background_path_" + ((QQAppInterface)this.mRuntime).a(), 0);
    String str2 = localSharedPreferences.getString("chat_uniform_bg", "null");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.trim().length() != 0) {}
    }
    else
    {
      str1 = "null";
    }
    localSharedPreferences.edit().clear().commit();
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "oldPicPath is:" + str1 + ",newPicPath is:" + "null");
    }
    if (!str1.equals("null")) {
      ChatBackgroundSettingActivity.a(this.mRuntime.getApplication(), ((QQAppInterface)this.mRuntime).a());
    }
  }
  
  public void clearImageCache()
  {
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
  }
  
  public void delOldResDir(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString1 != null) {
      try
      {
        if ((paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
        {
          paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
          File[] arrayOfFile = new File(paramString2).listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
            while (i < arrayOfFile.length)
            {
              String str = arrayOfFile[i].getName();
              if (str.startsWith(paramString1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeSwitch", 2, "delete old theme res dir,themeId=" + paramString1 + ",dirName=" + str);
                }
                FileUtils.a(paramString2 + File.separator + str);
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  /* Error */
  protected JSONObject doInBackground(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 77	java/lang/String
    //   6: astore_3
    //   7: aload_1
    //   8: iconst_1
    //   9: aaload
    //   10: checkcast 77	java/lang/String
    //   13: astore 6
    //   15: new 186	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 187	org/json/JSONObject:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 189
    //   26: aload_3
    //   27: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_1
    //   32: ldc 195
    //   34: aload 6
    //   36: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_1
    //   41: ldc 197
    //   43: aload_0
    //   44: getfield 23	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_ERROR	I
    //   47: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload_1
    //   52: ldc 202
    //   54: ldc 204
    //   56: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_3
    //   61: ifnull +12 -> 73
    //   64: aload_3
    //   65: ldc 206
    //   67: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +119 -> 189
    //   73: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +38 -> 114
    //   79: ldc 104
    //   81: iconst_2
    //   82: new 43	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   89: ldc 208
    //   91: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_3
    //   95: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 210
    //   100: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 6
    //   105: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_3
    //   115: ifnonnull +12 -> 127
    //   118: aload_1
    //   119: ldc 189
    //   121: ldc 206
    //   123: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: ldc2_w 214
    //   130: invokestatic 221	java/lang/Thread:sleep	(J)V
    //   133: aload_1
    //   134: ldc 197
    //   136: aload_0
    //   137: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   140: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc 202
    //   147: ldc 223
    //   149: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   152: pop
    //   153: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +31 -> 187
    //   159: ldc 104
    //   161: iconst_2
    //   162: new 43	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   169: ldc 225
    //   171: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: invokevirtual 226	org/json/JSONObject:toString	()Ljava/lang/String;
    //   178: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_1
    //   188: areturn
    //   189: aload_0
    //   190: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   193: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   196: aload_3
    //   197: invokestatic 232	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   200: astore 5
    //   202: aload_0
    //   203: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   206: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   209: aload_3
    //   210: aload 6
    //   212: invokestatic 236	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 4
    //   217: aload_0
    //   218: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   221: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   224: aload_3
    //   225: aload 6
    //   227: invokestatic 239	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 6
    //   232: new 138	java/io/File
    //   235: dup
    //   236: aload 6
    //   238: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: astore 7
    //   243: aload 5
    //   245: ifnull +138 -> 383
    //   248: aload 5
    //   250: getfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   253: ldc 246
    //   255: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +125 -> 383
    //   261: new 138	java/io/File
    //   264: dup
    //   265: aload 4
    //   267: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: invokevirtual 249	java/io/File:exists	()Z
    //   273: istore_2
    //   274: iload_2
    //   275: ifeq +75 -> 350
    //   278: ldc2_w 214
    //   281: invokestatic 221	java/lang/Thread:sleep	(J)V
    //   284: aload_1
    //   285: ldc 197
    //   287: aload_0
    //   288: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   291: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload_1
    //   296: ldc 251
    //   298: aload 4
    //   300: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_1
    //   305: ldc 202
    //   307: ldc 253
    //   309: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   312: pop
    //   313: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +581 -> 897
    //   319: ldc 104
    //   321: iconst_2
    //   322: new 43	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   329: ldc 255
    //   331: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_1
    //   335: invokevirtual 226	org/json/JSONObject:toString	()Ljava/lang/String;
    //   338: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: goto +550 -> 897
    //   350: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +30 -> 383
    //   356: ldc 104
    //   358: iconst_2
    //   359: new 43	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 257
    //   369: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 4
    //   374: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload 5
    //   385: ifnull +335 -> 720
    //   388: aload 7
    //   390: invokevirtual 249	java/io/File:exists	()Z
    //   393: ifeq +327 -> 720
    //   396: aload 7
    //   398: invokevirtual 260	java/io/File:length	()J
    //   401: aload 5
    //   403: getfield 264	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   406: lcmp
    //   407: ifne +313 -> 720
    //   410: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +44 -> 457
    //   416: ldc 104
    //   418: iconst_2
    //   419: new 43	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 266
    //   429: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 7
    //   434: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   437: ldc_w 271
    //   440: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 5
    //   445: getfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   448: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: aload_0
    //   458: aload_3
    //   459: aload 4
    //   461: invokevirtual 273	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:delOldResDir	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload 6
    //   466: aload 4
    //   468: invokestatic 275	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: new 138	java/io/File
    //   474: dup
    //   475: aload 4
    //   477: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   480: invokevirtual 249	java/io/File:exists	()Z
    //   483: ifeq +207 -> 690
    //   486: aload 5
    //   488: ldc 246
    //   490: putfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   497: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   500: aload 5
    //   502: invokestatic 279	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   505: invokevirtual 284	java/lang/Boolean:booleanValue	()Z
    //   508: iconst_1
    //   509: if_icmpne +114 -> 623
    //   512: aload_1
    //   513: ldc 197
    //   515: aload_0
    //   516: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   519: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   522: pop
    //   523: aload_1
    //   524: ldc 251
    //   526: aload 4
    //   528: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   531: pop
    //   532: aload_1
    //   533: ldc 202
    //   535: ldc_w 286
    //   538: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   541: pop
    //   542: goto -389 -> 153
    //   545: astore_3
    //   546: aload_1
    //   547: ldc 202
    //   549: ldc_w 288
    //   552: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload_1
    //   557: ldc 197
    //   559: aload_0
    //   560: getfield 29	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   563: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   566: pop
    //   567: aload 6
    //   569: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   572: pop
    //   573: aload_3
    //   574: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   577: goto -424 -> 153
    //   580: astore_3
    //   581: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq +32 -> 616
    //   587: ldc 104
    //   589: iconst_2
    //   590: new 43	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   597: ldc_w 293
    //   600: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_3
    //   604: invokevirtual 296	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   607: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload_3
    //   617: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   620: goto -467 -> 153
    //   623: aload_1
    //   624: ldc 202
    //   626: ldc_w 299
    //   629: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   632: pop
    //   633: aload_1
    //   634: ldc 197
    //   636: aload_0
    //   637: getfield 31	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SAVE_THEMEINFO_ERROR	I
    //   640: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   643: pop
    //   644: goto -491 -> 153
    //   647: astore_3
    //   648: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   651: ifeq +32 -> 683
    //   654: ldc 104
    //   656: iconst_2
    //   657: new 43	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 301
    //   667: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_3
    //   671: invokevirtual 302	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   674: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: aload_3
    //   684: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   687: goto -534 -> 153
    //   690: aload_1
    //   691: ldc 202
    //   693: ldc_w 304
    //   696: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   699: pop
    //   700: aload_1
    //   701: ldc 197
    //   703: aload_0
    //   704: getfield 29	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   707: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   710: pop
    //   711: aload 6
    //   713: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   716: pop
    //   717: goto -564 -> 153
    //   720: aload 5
    //   722: ifnonnull +27 -> 749
    //   725: aload_1
    //   726: ldc 202
    //   728: ldc_w 306
    //   731: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   734: pop
    //   735: aload_1
    //   736: ldc 197
    //   738: aload_0
    //   739: getfield 27	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_NOT_EXISTS	I
    //   742: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   745: pop
    //   746: goto -593 -> 153
    //   749: aload 7
    //   751: invokevirtual 249	java/io/File:exists	()Z
    //   754: ifne +62 -> 816
    //   757: aload 5
    //   759: ifnull +44 -> 803
    //   762: aload 5
    //   764: getfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   767: ldc_w 308
    //   770: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   773: ifne +30 -> 803
    //   776: aload 5
    //   778: ldc_w 308
    //   781: putfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   784: aload 5
    //   786: lconst_0
    //   787: putfield 311	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   790: aload_0
    //   791: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   794: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   797: aload 5
    //   799: invokestatic 279	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   802: pop
    //   803: aload_1
    //   804: ldc 202
    //   806: ldc_w 313
    //   809: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   812: pop
    //   813: goto -78 -> 735
    //   816: aload 7
    //   818: invokevirtual 260	java/io/File:length	()J
    //   821: aload 5
    //   823: getfield 264	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   826: lcmp
    //   827: ifeq -92 -> 735
    //   830: aload 5
    //   832: ifnull +44 -> 876
    //   835: aload 5
    //   837: getfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   840: ldc_w 315
    //   843: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   846: ifne +30 -> 876
    //   849: aload 5
    //   851: ldc_w 315
    //   854: putfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   857: aload 5
    //   859: lconst_0
    //   860: putfield 311	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   863: aload_0
    //   864: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   867: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   870: aload 5
    //   872: invokestatic 279	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   875: pop
    //   876: aload_1
    //   877: ldc 202
    //   879: ldc_w 317
    //   882: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   885: pop
    //   886: goto -151 -> 735
    //   889: astore_3
    //   890: goto -757 -> 133
    //   893: astore_3
    //   894: goto -610 -> 284
    //   897: aload_1
    //   898: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	899	0	this	SwitchThemeTask
    //   0	899	1	paramVarArgs	Object[]
    //   273	2	2	bool	boolean
    //   6	453	3	str1	String
    //   545	29	3	localIOException	java.io.IOException
    //   580	37	3	localJSONException	JSONException
    //   647	37	3	localException1	Exception
    //   889	1	3	localException2	Exception
    //   893	1	3	localException3	Exception
    //   215	312	4	str2	String
    //   200	671	5	localThemeInfo	ThemeUtil.ThemeInfo
    //   13	699	6	str3	String
    //   241	576	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   457	542	545	java/io/IOException
    //   623	644	545	java/io/IOException
    //   690	717	545	java/io/IOException
    //   23	60	580	org/json/JSONException
    //   64	73	580	org/json/JSONException
    //   73	114	580	org/json/JSONException
    //   118	127	580	org/json/JSONException
    //   127	133	580	org/json/JSONException
    //   133	153	580	org/json/JSONException
    //   189	243	580	org/json/JSONException
    //   248	274	580	org/json/JSONException
    //   278	284	580	org/json/JSONException
    //   284	347	580	org/json/JSONException
    //   350	383	580	org/json/JSONException
    //   388	457	580	org/json/JSONException
    //   457	542	580	org/json/JSONException
    //   546	577	580	org/json/JSONException
    //   623	644	580	org/json/JSONException
    //   690	717	580	org/json/JSONException
    //   725	735	580	org/json/JSONException
    //   735	746	580	org/json/JSONException
    //   749	757	580	org/json/JSONException
    //   762	803	580	org/json/JSONException
    //   803	813	580	org/json/JSONException
    //   816	830	580	org/json/JSONException
    //   835	876	580	org/json/JSONException
    //   876	886	580	org/json/JSONException
    //   23	60	647	java/lang/Exception
    //   64	73	647	java/lang/Exception
    //   73	114	647	java/lang/Exception
    //   118	127	647	java/lang/Exception
    //   133	153	647	java/lang/Exception
    //   189	243	647	java/lang/Exception
    //   248	274	647	java/lang/Exception
    //   284	347	647	java/lang/Exception
    //   350	383	647	java/lang/Exception
    //   388	457	647	java/lang/Exception
    //   457	542	647	java/lang/Exception
    //   546	577	647	java/lang/Exception
    //   623	644	647	java/lang/Exception
    //   690	717	647	java/lang/Exception
    //   725	735	647	java/lang/Exception
    //   735	746	647	java/lang/Exception
    //   749	757	647	java/lang/Exception
    //   762	803	647	java/lang/Exception
    //   803	813	647	java/lang/Exception
    //   816	830	647	java/lang/Exception
    //   835	876	647	java/lang/Exception
    //   876	886	647	java/lang/Exception
    //   127	133	889	java/lang/Exception
    //   278	284	893	java/lang/Exception
  }
  
  protected void onPostExecute(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "ThemeJsHandler switchThemeTask result:" + paramJSONObject.toString());
    }
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("ret");
        paramJSONObject.getString("msg");
        localObject1 = paramJSONObject.getString("themeId");
        String str = paramJSONObject.getString("version");
        if (i != this.THEME_OPTION_SUCCESS) {
          continue;
        }
        if (!((String)localObject1).equals("1000")) {
          continue;
        }
        paramJSONObject = null;
        this.this$0.doScreenShot();
        Object localObject2 = ThemeUtil.getCurrentThemeInfo();
        if (SkinEngine.getInstances().setSkinRootPath(this.mRuntime.getApplication(), paramJSONObject) != true) {
          continue;
        }
        clearImageCache();
        clearChatBackground();
        paramJSONObject = ((Bundle)localObject2).getString("themeId");
        localObject2 = ((Bundle)localObject2).getString("version");
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "currentTheme currThemeId=" + paramJSONObject + ", currVersion=" + (String)localObject2);
        }
        if (!paramJSONObject.equals("1103")) {
          ThemeSwitchUtil.setPreviousThemeIdVersion((QQAppInterface)this.mRuntime, paramJSONObject, (String)localObject2);
        }
        ThemeUtil.setCurrentThemeIdVersion((QQAppInterface)this.mRuntime, (String)localObject1, str);
        localBundle.putInt("result", 2);
        ThemeSwitchManager.isSwitchTheme = false;
        ThemeSwitchManager.access$200(this.this$0, true, false, localBundle);
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ThemeSwitch", 2, "ThemeJsHandler switchThemeTask JSONException:" + paramJSONObject.getMessage());
        localBundle.putInt("result", 512);
        localBundle.putCharSequence("message", "set skin theme error");
        if ((this.this$0.themeSwitchDialog == null) || (!this.this$0.themeSwitchDialog.isShowing())) {
          continue;
        }
        this.this$0.themeSwitchDialog.dismiss();
        this.this$0.themeSwitchDialog = null;
        Object localObject1 = this.this$0;
        ThemeSwitchManager.isSwitchTheme = false;
        paramJSONObject.printStackTrace();
        continue;
        localBundle.putInt("result", 512);
        localBundle.putCharSequence("message", "set skin theme error");
        if ((this.this$0.themeSwitchDialog == null) || (!this.this$0.themeSwitchDialog.isShowing())) {
          continue;
        }
        this.this$0.themeSwitchDialog.dismiss();
        this.this$0.themeSwitchDialog = null;
        paramJSONObject = this.this$0;
        ThemeSwitchManager.isSwitchTheme = false;
        continue;
      }
      if ((localBundle.getInt("result", -1) & 0x200) == 512) {
        ThemeSwitchManager.access$800(this.this$0, localBundle);
      }
      this.mRuntime = null;
      return;
      paramJSONObject = paramJSONObject.getString("themeResPath");
      continue;
      localBundle.putInt("result", 512);
      localBundle.putCharSequence("message", "set skin theme error");
      if ((this.this$0.themeSwitchDialog != null) && (this.this$0.themeSwitchDialog.isShowing()))
      {
        this.this$0.themeSwitchDialog.dismiss();
        this.this$0.themeSwitchDialog = null;
      }
      paramJSONObject = this.this$0;
      ThemeSwitchManager.isSwitchTheme = false;
    }
  }
  
  protected void onPreExecute()
  {
    Activity localActivity = null;
    if (ThemeSwitchManager.access$400(this.this$0) != null) {
      localActivity = (Activity)ThemeSwitchManager.access$400(this.this$0).get();
    }
    if (localActivity != null)
    {
      ThemeSwitchManager localThemeSwitchManager = this.this$0;
      ThemeSwitchManager.isSwitchTheme = true;
      this.this$0.themeSwitchDialog = new QQProgressDialog(localActivity, ((BaseActivity)localActivity).d());
      this.this$0.themeSwitchDialog.setCancelable(false);
      this.this$0.themeSwitchDialog.b(2131563004);
      this.this$0.themeSwitchDialog.show();
    }
    for (;;)
    {
      super.onPreExecute();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "activity is not TitleBarActivity");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.SwitchThemeTask
 * JD-Core Version:    0.7.0.1
 */