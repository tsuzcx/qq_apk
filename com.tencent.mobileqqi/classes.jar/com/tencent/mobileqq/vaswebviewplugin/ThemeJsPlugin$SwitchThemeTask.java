package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class ThemeJsPlugin$SwitchThemeTask
  extends AsyncTask
{
  private int THEME_OPTION_ERROR = -1;
  private int THEME_OPTION_PKG_NOT_EXISTS = 1;
  private int THEME_OPTION_PKG_UNZIP_ERROR = 2;
  private int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
  private int THEME_OPTION_SUCCESS = 0;
  public String callbackId;
  
  public ThemeJsPlugin$SwitchThemeTask(ThemeJsPlugin paramThemeJsPlugin, String paramString)
  {
    this.callbackId = paramString;
  }
  
  public void clearChatBackground()
  {
    SharedPreferences localSharedPreferences = ThemeJsPlugin.access$100(this.this$0).getSharedPreferences("chat_background_path_" + ThemeJsPlugin.access$000(this.this$0).a(), 0);
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
      QLog.d("ThemeJsPlugin", 2, "oldPicPath is:" + str1 + ",newPicPath is:" + "null");
    }
    if (!str1.equals("null")) {
      ChatBackgroundSettingActivity.a(ThemeJsPlugin.access$100(this.this$0), ThemeJsPlugin.access$000(this.this$0).a());
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
                  QLog.d("ThemeJsPlugin", 2, "delete old theme res dir,themeId=" + paramString1 + ",dirName=" + str);
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
  protected JSONObject doInBackground(java.lang.Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 81	java/lang/String
    //   6: astore_3
    //   7: aload_1
    //   8: iconst_1
    //   9: aaload
    //   10: checkcast 81	java/lang/String
    //   13: astore 6
    //   15: new 189	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 190	org/json/JSONObject:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 192
    //   26: aload_3
    //   27: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_1
    //   32: ldc 198
    //   34: aload 6
    //   36: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_1
    //   41: ldc 200
    //   43: aload_0
    //   44: getfield 23	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_ERROR	I
    //   47: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload_1
    //   52: ldc 205
    //   54: ldc 207
    //   56: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_3
    //   61: ifnull +12 -> 73
    //   64: aload_3
    //   65: ldc 209
    //   67: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +119 -> 189
    //   73: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +38 -> 114
    //   79: ldc 108
    //   81: iconst_2
    //   82: new 43	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   89: ldc 211
    //   91: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_3
    //   95: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 213
    //   100: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 6
    //   105: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_3
    //   115: ifnonnull +12 -> 127
    //   118: aload_1
    //   119: ldc 192
    //   121: ldc 209
    //   123: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: ldc2_w 217
    //   130: invokestatic 224	java/lang/Thread:sleep	(J)V
    //   133: aload_1
    //   134: ldc 200
    //   136: aload_0
    //   137: getfield 25	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   140: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc 205
    //   147: ldc 226
    //   149: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   152: pop
    //   153: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +31 -> 187
    //   159: ldc 108
    //   161: iconst_2
    //   162: new 43	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   169: ldc 228
    //   171: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   178: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_1
    //   188: areturn
    //   189: aload_0
    //   190: getfield 18	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   193: invokestatic 41	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   196: aload_3
    //   197: invokestatic 235	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   200: astore 5
    //   202: aload_0
    //   203: getfield 18	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   206: invokestatic 41	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   209: aload_3
    //   210: aload 6
    //   212: invokestatic 239	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 4
    //   217: aload_0
    //   218: getfield 18	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   221: invokestatic 41	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   224: aload_3
    //   225: aload 6
    //   227: invokestatic 242	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 6
    //   232: new 142	java/io/File
    //   235: dup
    //   236: aload 6
    //   238: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: astore 7
    //   243: aload 5
    //   245: ifnull +140 -> 385
    //   248: aload 5
    //   250: getfield 247	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   253: ldc 249
    //   255: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +127 -> 385
    //   261: new 142	java/io/File
    //   264: dup
    //   265: aload 4
    //   267: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: invokevirtual 252	java/io/File:exists	()Z
    //   273: istore_2
    //   274: iload_2
    //   275: ifeq +77 -> 352
    //   278: ldc2_w 217
    //   281: invokestatic 224	java/lang/Thread:sleep	(J)V
    //   284: aload_1
    //   285: ldc 200
    //   287: aload_0
    //   288: getfield 25	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   291: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload_1
    //   296: ldc 254
    //   298: aload 4
    //   300: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_1
    //   305: ldc 205
    //   307: ldc_w 256
    //   310: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   313: pop
    //   314: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +582 -> 899
    //   320: ldc 108
    //   322: iconst_2
    //   323: new 43	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 258
    //   333: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_1
    //   337: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   340: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: goto +550 -> 899
    //   352: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +30 -> 385
    //   358: ldc 108
    //   360: iconst_2
    //   361: new 43	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   368: ldc_w 260
    //   371: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 4
    //   376: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload 5
    //   387: ifnull +335 -> 722
    //   390: aload 7
    //   392: invokevirtual 252	java/io/File:exists	()Z
    //   395: ifeq +327 -> 722
    //   398: aload 7
    //   400: invokevirtual 263	java/io/File:length	()J
    //   403: aload 5
    //   405: getfield 267	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   408: lcmp
    //   409: ifne +313 -> 722
    //   412: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +44 -> 459
    //   418: ldc 108
    //   420: iconst_2
    //   421: new 43	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 269
    //   431: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 7
    //   436: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: ldc_w 274
    //   442: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 5
    //   447: getfield 247	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   450: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: aload_0
    //   460: aload_3
    //   461: aload 4
    //   463: invokevirtual 276	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:delOldResDir	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload 6
    //   468: aload 4
    //   470: invokestatic 278	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: new 142	java/io/File
    //   476: dup
    //   477: aload 4
    //   479: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   482: invokevirtual 252	java/io/File:exists	()Z
    //   485: ifeq +207 -> 692
    //   488: aload 5
    //   490: ldc 249
    //   492: putfield 247	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   495: aload_0
    //   496: getfield 18	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   499: invokestatic 41	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   502: aload 5
    //   504: invokestatic 282	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   507: invokevirtual 287	java/lang/Boolean:booleanValue	()Z
    //   510: iconst_1
    //   511: if_icmpne +114 -> 625
    //   514: aload_1
    //   515: ldc 200
    //   517: aload_0
    //   518: getfield 25	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   521: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   524: pop
    //   525: aload_1
    //   526: ldc 254
    //   528: aload 4
    //   530: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   533: pop
    //   534: aload_1
    //   535: ldc 205
    //   537: ldc_w 289
    //   540: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   543: pop
    //   544: goto -391 -> 153
    //   547: astore_3
    //   548: aload_1
    //   549: ldc 205
    //   551: ldc_w 291
    //   554: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   557: pop
    //   558: aload_1
    //   559: ldc 200
    //   561: aload_0
    //   562: getfield 29	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   565: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   568: pop
    //   569: aload 6
    //   571: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   574: pop
    //   575: aload_3
    //   576: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   579: goto -426 -> 153
    //   582: astore_3
    //   583: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq +32 -> 618
    //   589: ldc 108
    //   591: iconst_2
    //   592: new 43	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   599: ldc_w 296
    //   602: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_3
    //   606: invokevirtual 299	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   609: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_3
    //   619: invokevirtual 300	org/json/JSONException:printStackTrace	()V
    //   622: goto -469 -> 153
    //   625: aload_1
    //   626: ldc 205
    //   628: ldc_w 302
    //   631: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   634: pop
    //   635: aload_1
    //   636: ldc 200
    //   638: aload_0
    //   639: getfield 31	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SAVE_THEMEINFO_ERROR	I
    //   642: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   645: pop
    //   646: goto -493 -> 153
    //   649: astore_3
    //   650: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq +32 -> 685
    //   656: ldc 108
    //   658: iconst_2
    //   659: new 43	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   666: ldc_w 304
    //   669: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload_3
    //   673: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   676: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   685: aload_3
    //   686: invokevirtual 178	java/lang/Exception:printStackTrace	()V
    //   689: goto -536 -> 153
    //   692: aload_1
    //   693: ldc 205
    //   695: ldc_w 307
    //   698: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   701: pop
    //   702: aload_1
    //   703: ldc 200
    //   705: aload_0
    //   706: getfield 29	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   709: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   712: pop
    //   713: aload 6
    //   715: invokestatic 293	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   718: pop
    //   719: goto -566 -> 153
    //   722: aload 5
    //   724: ifnonnull +27 -> 751
    //   727: aload_1
    //   728: ldc 205
    //   730: ldc_w 309
    //   733: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   736: pop
    //   737: aload_1
    //   738: ldc 200
    //   740: aload_0
    //   741: getfield 27	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_PKG_NOT_EXISTS	I
    //   744: invokevirtual 203	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   747: pop
    //   748: goto -595 -> 153
    //   751: aload 7
    //   753: invokevirtual 252	java/io/File:exists	()Z
    //   756: ifne +62 -> 818
    //   759: aload 5
    //   761: ifnull +44 -> 805
    //   764: aload 5
    //   766: getfield 247	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   769: ldc_w 311
    //   772: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   775: ifne +30 -> 805
    //   778: aload 5
    //   780: ldc_w 311
    //   783: putfield 247	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   786: aload 5
    //   788: lconst_0
    //   789: putfield 314	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   792: aload_0
    //   793: getfield 18	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   796: invokestatic 41	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   799: aload 5
    //   801: invokestatic 282	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   804: pop
    //   805: aload_1
    //   806: ldc 205
    //   808: ldc_w 316
    //   811: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   814: pop
    //   815: goto -78 -> 737
    //   818: aload 7
    //   820: invokevirtual 263	java/io/File:length	()J
    //   823: aload 5
    //   825: getfield 267	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   828: lcmp
    //   829: ifeq -92 -> 737
    //   832: aload 5
    //   834: ifnull +44 -> 878
    //   837: aload 5
    //   839: getfield 247	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   842: ldc_w 318
    //   845: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   848: ifne +30 -> 878
    //   851: aload 5
    //   853: ldc_w 318
    //   856: putfield 247	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   859: aload 5
    //   861: lconst_0
    //   862: putfield 314	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   865: aload_0
    //   866: getfield 18	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   869: invokestatic 41	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   872: aload 5
    //   874: invokestatic 282	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   877: pop
    //   878: aload_1
    //   879: ldc 205
    //   881: ldc_w 320
    //   884: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   887: pop
    //   888: goto -151 -> 737
    //   891: astore_3
    //   892: goto -759 -> 133
    //   895: astore_3
    //   896: goto -612 -> 284
    //   899: aload_1
    //   900: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	this	SwitchThemeTask
    //   0	901	1	paramVarArgs	java.lang.Object[]
    //   273	2	2	bool	boolean
    //   6	455	3	str1	String
    //   547	29	3	localIOException	java.io.IOException
    //   582	37	3	localJSONException	JSONException
    //   649	37	3	localException1	Exception
    //   891	1	3	localException2	Exception
    //   895	1	3	localException3	Exception
    //   215	314	4	str2	String
    //   200	673	5	localThemeInfo	com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
    //   13	701	6	str3	String
    //   241	578	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   459	544	547	java/io/IOException
    //   625	646	547	java/io/IOException
    //   692	719	547	java/io/IOException
    //   23	60	582	org/json/JSONException
    //   64	73	582	org/json/JSONException
    //   73	114	582	org/json/JSONException
    //   118	127	582	org/json/JSONException
    //   127	133	582	org/json/JSONException
    //   133	153	582	org/json/JSONException
    //   189	243	582	org/json/JSONException
    //   248	274	582	org/json/JSONException
    //   278	284	582	org/json/JSONException
    //   284	349	582	org/json/JSONException
    //   352	385	582	org/json/JSONException
    //   390	459	582	org/json/JSONException
    //   459	544	582	org/json/JSONException
    //   548	579	582	org/json/JSONException
    //   625	646	582	org/json/JSONException
    //   692	719	582	org/json/JSONException
    //   727	737	582	org/json/JSONException
    //   737	748	582	org/json/JSONException
    //   751	759	582	org/json/JSONException
    //   764	805	582	org/json/JSONException
    //   805	815	582	org/json/JSONException
    //   818	832	582	org/json/JSONException
    //   837	878	582	org/json/JSONException
    //   878	888	582	org/json/JSONException
    //   23	60	649	java/lang/Exception
    //   64	73	649	java/lang/Exception
    //   73	114	649	java/lang/Exception
    //   118	127	649	java/lang/Exception
    //   133	153	649	java/lang/Exception
    //   189	243	649	java/lang/Exception
    //   248	274	649	java/lang/Exception
    //   284	349	649	java/lang/Exception
    //   352	385	649	java/lang/Exception
    //   390	459	649	java/lang/Exception
    //   459	544	649	java/lang/Exception
    //   548	579	649	java/lang/Exception
    //   625	646	649	java/lang/Exception
    //   692	719	649	java/lang/Exception
    //   727	737	649	java/lang/Exception
    //   737	748	649	java/lang/Exception
    //   751	759	649	java/lang/Exception
    //   764	805	649	java/lang/Exception
    //   805	815	649	java/lang/Exception
    //   818	832	649	java/lang/Exception
    //   837	878	649	java/lang/Exception
    //   878	888	649	java/lang/Exception
    //   127	133	891	java/lang/Exception
    //   278	284	895	java/lang/Exception
  }
  
  protected void onPostExecute(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler switchThemeTask result:" + paramJSONObject.toString());
    }
    for (;;)
    {
      try
      {
        int i = paramJSONObject.getInt("ret");
        String str3 = paramJSONObject.getString("msg");
        String str1 = paramJSONObject.getString("themeId");
        String str2 = paramJSONObject.getString("version");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", i);
        localJSONObject.put("message", str3);
        if (i == this.THEME_OPTION_SUCCESS)
        {
          if (str1.equals("1000"))
          {
            paramJSONObject = null;
            this.this$0.doScreenShot();
            if (SkinEngine.getInstances().setSkinRootPath(ThemeJsPlugin.access$100(this.this$0), paramJSONObject) == true)
            {
              clearImageCache();
              clearChatBackground();
              ThemeUtil.setCurrentThemeIdVersion(ThemeJsPlugin.access$000(this.this$0), str1, str2);
              this.this$0.callJs(this.callbackId + "(" + localJSONObject.toString() + ");");
            }
          }
          else
          {
            paramJSONObject = paramJSONObject.getString("themeResPath");
            continue;
          }
          localJSONObject.put("result", -1);
          localJSONObject.put("message", "set skin theme error");
          if ((this.this$0.themeSwitchDialog != null) && (this.this$0.themeSwitchDialog.isShowing())) {
            this.this$0.themeSwitchDialog.dismiss();
          }
          this.this$0.isSwitchTheme = Boolean.valueOf(false);
          continue;
        }
        if (this.this$0.themeSwitchDialog == null) {
          break label391;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler switchThemeTask JSONException:" + paramJSONObject.getMessage());
        }
        this.this$0.themeSwitchDialog.dismiss();
        this.this$0.isSwitchTheme = Boolean.valueOf(false);
        this.this$0.callJsOnError(this.callbackId, paramJSONObject.getMessage());
        return;
      }
      if (this.this$0.themeSwitchDialog.isShowing()) {
        this.this$0.themeSwitchDialog.dismiss();
      }
      label391:
      this.this$0.isSwitchTheme = Boolean.valueOf(false);
    }
  }
  
  protected void onPreExecute()
  {
    if ((this.this$0.mRuntime.a() != null) && ((this.this$0.mRuntime.a() instanceof IphoneTitleBarActivity)))
    {
      this.this$0.isSwitchTheme = Boolean.valueOf(true);
      this.this$0.themeSwitchDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((IphoneTitleBarActivity)this.this$0.mRuntime.a()).d());
      this.this$0.themeSwitchDialog.setCancelable(false);
      this.this$0.themeSwitchDialog.b(2131563004);
      this.this$0.themeSwitchDialog.show();
    }
    for (;;)
    {
      super.onPreExecute();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "activity is not TitleBarActivity");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.SwitchThemeTask
 * JD-Core Version:    0.7.0.1
 */