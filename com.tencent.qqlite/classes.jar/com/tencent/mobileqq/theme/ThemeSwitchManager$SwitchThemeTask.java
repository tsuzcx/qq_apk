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
    //   316: ifeq +582 -> 898
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
    //   347: goto +551 -> 898
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
    //   385: ifnull +336 -> 721
    //   388: aload 7
    //   390: invokevirtual 249	java/io/File:exists	()Z
    //   393: ifeq +328 -> 721
    //   396: aload 7
    //   398: invokevirtual 260	java/io/File:length	()J
    //   401: aload 5
    //   403: getfield 264	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   406: lcmp
    //   407: ifne +314 -> 721
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
    //   468: iconst_0
    //   469: invokestatic 276	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   472: new 138	java/io/File
    //   475: dup
    //   476: aload 4
    //   478: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   481: invokevirtual 249	java/io/File:exists	()Z
    //   484: ifeq +207 -> 691
    //   487: aload 5
    //   489: ldc 246
    //   491: putfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   498: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   501: aload 5
    //   503: invokestatic 280	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   506: invokevirtual 285	java/lang/Boolean:booleanValue	()Z
    //   509: iconst_1
    //   510: if_icmpne +114 -> 624
    //   513: aload_1
    //   514: ldc 197
    //   516: aload_0
    //   517: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   520: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   523: pop
    //   524: aload_1
    //   525: ldc 251
    //   527: aload 4
    //   529: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   532: pop
    //   533: aload_1
    //   534: ldc 202
    //   536: ldc_w 287
    //   539: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   542: pop
    //   543: goto -390 -> 153
    //   546: astore_3
    //   547: aload_1
    //   548: ldc 202
    //   550: ldc_w 289
    //   553: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload_1
    //   558: ldc 197
    //   560: aload_0
    //   561: getfield 29	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   564: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   567: pop
    //   568: aload 6
    //   570: invokestatic 291	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   573: pop
    //   574: aload_3
    //   575: invokevirtual 292	java/io/IOException:printStackTrace	()V
    //   578: goto -425 -> 153
    //   581: astore_3
    //   582: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +32 -> 617
    //   588: ldc 104
    //   590: iconst_2
    //   591: new 43	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   598: ldc_w 294
    //   601: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload_3
    //   605: invokevirtual 297	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   608: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: aload_3
    //   618: invokevirtual 298	org/json/JSONException:printStackTrace	()V
    //   621: goto -468 -> 153
    //   624: aload_1
    //   625: ldc 202
    //   627: ldc_w 300
    //   630: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   633: pop
    //   634: aload_1
    //   635: ldc 197
    //   637: aload_0
    //   638: getfield 31	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SAVE_THEMEINFO_ERROR	I
    //   641: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   644: pop
    //   645: goto -492 -> 153
    //   648: astore_3
    //   649: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   652: ifeq +32 -> 684
    //   655: ldc 104
    //   657: iconst_2
    //   658: new 43	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   665: ldc_w 302
    //   668: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload_3
    //   672: invokevirtual 303	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   675: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   684: aload_3
    //   685: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   688: goto -535 -> 153
    //   691: aload_1
    //   692: ldc 202
    //   694: ldc_w 305
    //   697: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: aload_1
    //   702: ldc 197
    //   704: aload_0
    //   705: getfield 29	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   708: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   711: pop
    //   712: aload 6
    //   714: invokestatic 291	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   717: pop
    //   718: goto -565 -> 153
    //   721: aload 5
    //   723: ifnonnull +27 -> 750
    //   726: aload_1
    //   727: ldc 202
    //   729: ldc_w 307
    //   732: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   735: pop
    //   736: aload_1
    //   737: ldc 197
    //   739: aload_0
    //   740: getfield 27	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_NOT_EXISTS	I
    //   743: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   746: pop
    //   747: goto -594 -> 153
    //   750: aload 7
    //   752: invokevirtual 249	java/io/File:exists	()Z
    //   755: ifne +62 -> 817
    //   758: aload 5
    //   760: ifnull +44 -> 804
    //   763: aload 5
    //   765: getfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   768: ldc_w 309
    //   771: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   774: ifne +30 -> 804
    //   777: aload 5
    //   779: ldc_w 309
    //   782: putfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   785: aload 5
    //   787: lconst_0
    //   788: putfield 312	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   791: aload_0
    //   792: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   795: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   798: aload 5
    //   800: invokestatic 280	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   803: pop
    //   804: aload_1
    //   805: ldc 202
    //   807: ldc_w 314
    //   810: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   813: pop
    //   814: goto -78 -> 736
    //   817: aload 7
    //   819: invokevirtual 260	java/io/File:length	()J
    //   822: aload 5
    //   824: getfield 264	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   827: lcmp
    //   828: ifeq -92 -> 736
    //   831: aload 5
    //   833: ifnull +44 -> 877
    //   836: aload 5
    //   838: getfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   841: ldc_w 316
    //   844: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   847: ifne +30 -> 877
    //   850: aload 5
    //   852: ldc_w 316
    //   855: putfield 244	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   858: aload 5
    //   860: lconst_0
    //   861: putfield 312	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   864: aload_0
    //   865: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   868: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   871: aload 5
    //   873: invokestatic 280	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   876: pop
    //   877: aload_1
    //   878: ldc 202
    //   880: ldc_w 318
    //   883: invokevirtual 193	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   886: pop
    //   887: goto -151 -> 736
    //   890: astore_3
    //   891: goto -758 -> 133
    //   894: astore_3
    //   895: goto -611 -> 284
    //   898: aload_1
    //   899: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	900	0	this	SwitchThemeTask
    //   0	900	1	paramVarArgs	Object[]
    //   273	2	2	bool	boolean
    //   6	453	3	str1	String
    //   546	29	3	localIOException	java.io.IOException
    //   581	37	3	localJSONException	JSONException
    //   648	37	3	localException1	Exception
    //   890	1	3	localException2	Exception
    //   894	1	3	localException3	Exception
    //   215	313	4	str2	String
    //   200	672	5	localThemeInfo	ThemeUtil.ThemeInfo
    //   13	700	6	str3	String
    //   241	577	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   457	543	546	java/io/IOException
    //   624	645	546	java/io/IOException
    //   691	718	546	java/io/IOException
    //   23	60	581	org/json/JSONException
    //   64	73	581	org/json/JSONException
    //   73	114	581	org/json/JSONException
    //   118	127	581	org/json/JSONException
    //   127	133	581	org/json/JSONException
    //   133	153	581	org/json/JSONException
    //   189	243	581	org/json/JSONException
    //   248	274	581	org/json/JSONException
    //   278	284	581	org/json/JSONException
    //   284	347	581	org/json/JSONException
    //   350	383	581	org/json/JSONException
    //   388	457	581	org/json/JSONException
    //   457	543	581	org/json/JSONException
    //   547	578	581	org/json/JSONException
    //   624	645	581	org/json/JSONException
    //   691	718	581	org/json/JSONException
    //   726	736	581	org/json/JSONException
    //   736	747	581	org/json/JSONException
    //   750	758	581	org/json/JSONException
    //   763	804	581	org/json/JSONException
    //   804	814	581	org/json/JSONException
    //   817	831	581	org/json/JSONException
    //   836	877	581	org/json/JSONException
    //   877	887	581	org/json/JSONException
    //   23	60	648	java/lang/Exception
    //   64	73	648	java/lang/Exception
    //   73	114	648	java/lang/Exception
    //   118	127	648	java/lang/Exception
    //   133	153	648	java/lang/Exception
    //   189	243	648	java/lang/Exception
    //   248	274	648	java/lang/Exception
    //   284	347	648	java/lang/Exception
    //   350	383	648	java/lang/Exception
    //   388	457	648	java/lang/Exception
    //   457	543	648	java/lang/Exception
    //   547	578	648	java/lang/Exception
    //   624	645	648	java/lang/Exception
    //   691	718	648	java/lang/Exception
    //   726	736	648	java/lang/Exception
    //   736	747	648	java/lang/Exception
    //   750	758	648	java/lang/Exception
    //   763	804	648	java/lang/Exception
    //   804	814	648	java/lang/Exception
    //   817	831	648	java/lang/Exception
    //   836	877	648	java/lang/Exception
    //   877	887	648	java/lang/Exception
    //   127	133	890	java/lang/Exception
    //   278	284	894	java/lang/Exception
  }
  
  protected void onPostExecute(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "ThemeJsHandler switchThemeTask result:" + paramObject.toString());
    }
    Bundle localBundle = new Bundle();
    if ((paramObject instanceof JSONObject)) {
      paramObject = (JSONObject)paramObject;
    }
    for (;;)
    {
      try
      {
        int i = paramObject.getInt("ret");
        localObject1 = paramObject.getString("themeId");
        String str = paramObject.getString("version");
        if (i != this.THEME_OPTION_SUCCESS) {
          continue;
        }
        if (!((String)localObject1).equals("1000")) {
          continue;
        }
        paramObject = null;
        this.this$0.doScreenShot();
        Object localObject2 = ThemeUtil.getCurrentThemeInfo();
        if (SkinEngine.getInstances().setSkinRootPath(this.mRuntime.getApplication(), paramObject) != true) {
          continue;
        }
        clearImageCache();
        paramObject = ((Bundle)localObject2).getString("themeId");
        localObject2 = ((Bundle)localObject2).getString("version");
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "currentTheme currThemeId=" + paramObject + ", currVersion=" + (String)localObject2);
        }
        if (!paramObject.equals("1103")) {
          ThemeSwitchUtil.setPreviousThemeIdVersion((QQAppInterface)this.mRuntime, paramObject, (String)localObject2);
        }
        ThemeUtil.setCurrentThemeIdVersion((QQAppInterface)this.mRuntime, (String)localObject1, str);
        localBundle.putInt("result", 2);
        ThemeSwitchManager.isSwitchTheme = false;
        this.this$0.notifyCallbacks(true, false, localBundle);
      }
      catch (JSONException paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ThemeSwitch", 2, "ThemeJsHandler switchThemeTask JSONException:" + paramObject.getMessage());
        localBundle.putInt("result", 512);
        localBundle.putCharSequence("message", "set skin theme error");
        if ((this.this$0.themeSwitchDialog == null) || (!this.this$0.themeSwitchDialog.isShowing())) {
          continue;
        }
        this.this$0.themeSwitchDialog.dismiss();
        this.this$0.themeSwitchDialog = null;
        Object localObject1 = this.this$0;
        ThemeSwitchManager.isSwitchTheme = false;
        paramObject.printStackTrace();
        continue;
        localBundle.putInt("result", 512);
        localBundle.putCharSequence("message", "set skin theme error");
        if ((this.this$0.themeSwitchDialog == null) || (!this.this$0.themeSwitchDialog.isShowing())) {
          continue;
        }
        this.this$0.themeSwitchDialog.dismiss();
        this.this$0.themeSwitchDialog = null;
        paramObject = this.this$0;
        ThemeSwitchManager.isSwitchTheme = false;
        continue;
      }
      if ((localBundle.getInt("result", -1) & 0x200) == 512) {
        this.this$0.failAlert(localBundle);
      }
      this.mRuntime = null;
      return;
      paramObject = paramObject.getString("themeResPath");
      continue;
      localBundle.putInt("result", 512);
      localBundle.putCharSequence("message", "set skin theme error");
      if ((this.this$0.themeSwitchDialog != null) && (this.this$0.themeSwitchDialog.isShowing()))
      {
        this.this$0.themeSwitchDialog.dismiss();
        this.this$0.themeSwitchDialog = null;
      }
      paramObject = this.this$0;
      ThemeSwitchManager.isSwitchTheme = false;
      continue;
      QLog.i("ThemeSwitch", 2, "parameter cast error");
    }
  }
  
  protected void onPreExecute()
  {
    Activity localActivity = null;
    if (this.this$0.currActivityRef != null) {
      localActivity = (Activity)this.this$0.currActivityRef.get();
    }
    if (localActivity != null)
    {
      ThemeSwitchManager localThemeSwitchManager = this.this$0;
      ThemeSwitchManager.isSwitchTheme = true;
      this.this$0.themeSwitchDialog = new QQProgressDialog(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
      this.this$0.themeSwitchDialog.setCancelable(false);
      this.this$0.themeSwitchDialog.b(2131363263);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.SwitchThemeTask
 * JD-Core Version:    0.7.0.1
 */