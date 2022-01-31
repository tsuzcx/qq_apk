package com.etrump.mixlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderFactory.DownloadConfig;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ff;
import fg;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FontManager
  implements Manager
{
  public static long a = 0L;
  public static MQLruCache a;
  public static final String a;
  public static final String b;
  public static final String c = "http://imgcache.qq.com/qqshow/admindata/comdata/vipfont_%d/android.zip";
  public static final String d = "font_local.cfg";
  public static final String e = ".ttf";
  protected static final String f = "Font_download_succ";
  protected static final String g = "Font_download_cancel";
  protected static final String h = "Font_download";
  protected static final String i = "AIO_Font_download";
  private static final String j = "FontManager";
  public ETEngine a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new fg(this, "param_WIFIFontDownloadFlow", "param_XGFontDownloadFlow");
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = null;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  public IPCDownloadListener a;
  public AtomicBoolean a;
  public JSONArray a;
  public boolean a;
  public AtomicBoolean b;
  public AtomicBoolean c;
  public AtomicBoolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.an + "font_info";
    jdField_b_of_type_JavaLangString = AppConstants.an + "font_tmp";
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache = null;
  }
  
  public FontManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_OrgJsonJSONArray = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.c = new AtomicBoolean(false);
    this.d = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = new DownloaderFactory.DownloadConfig(2, 1, true, false);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(43));
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(16);
    this.jdField_a_of_type_Boolean = DeviceProfileManager.a().b(DeviceProfileManager.DpcNames.chat_font.name());
    a();
  }
  
  public static Drawable a(AppInterface paramAppInterface, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = (Pair)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("font_thumb_" + paramInt);
    if (localObject1 != null)
    {
      paramAppInterface = ((Drawable.ConstantState)((Pair)localObject1).first).newDrawable(paramAppInterface.a().getResources());
      return paramAppInterface;
    }
    for (;;)
    {
      try
      {
        k = paramAppInterface.getApplication().getResources().getDimensionPixelSize(2131427580);
        m = paramAppInterface.getApplication().getResources().getDimensionPixelSize(2131427581);
        if (paramInt != 0) {
          continue;
        }
        localObject1 = BitmapManager.a(paramAppInterface.a().getResources(), 2130839110, k, m);
      }
      catch (Throwable localThrowable)
      {
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FontManager", 2, "getFontDrawable fail," + localThrowable.getMessage());
        Object localObject2 = null;
        continue;
        int k = Utils.getBitmapSize((Bitmap)localObject2);
        localObject2 = new BitmapDrawable(paramAppInterface.a().getResources(), (Bitmap)localObject2);
        ((BitmapDrawable)localObject2).setTargetDensity(paramAppInterface.a().getResources().getDisplayMetrics());
        paramAppInterface = new Pair(localObject2, Integer.valueOf(k));
        if (paramAppInterface == null) {
          break label350;
        }
      }
      if (localObject1 == null)
      {
        paramAppInterface = localObject3;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FontManager", 2, "getFontDrawable|bitmap null fontid=" + paramInt);
        return null;
        localObject1 = BitmapManager.a(jdField_a_of_type_JavaLangString + File.separator + paramInt + File.separator + "chat_font_thumbnail.png", k, m);
        continue;
      }
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("font_thumb_" + paramInt, new Pair(((Drawable)paramAppInterface.first).getConstantState(), paramAppInterface.second));
    }
    label350:
    for (paramAppInterface = (Drawable)paramAppInterface.first;; paramAppInterface = null) {
      return paramAppInterface;
    }
  }
  
  private FontInfo a(int paramInt)
  {
    ??? = (FontInfo)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Integer.valueOf(paramInt));
    boolean bool1;
    Object localObject4;
    boolean bool2;
    Object localObject1;
    if (??? == null)
    {
      bool1 = a(paramInt);
      localObject4 = new File(jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + paramInt + ".ttf");
      bool2 = ((File)localObject4).exists();
      localObject1 = ???;
      if (bool1)
      {
        localObject1 = ???;
        if (bool2) {
          localObject1 = new FontInfo(paramInt, "", ((File)localObject4).getAbsolutePath());
        }
      }
    }
    do
    {
      do
      {
        synchronized (jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
        {
          jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(Integer.valueOf(paramInt), localObject1);
          localObject4 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("FontManager", 2, "findFontInfo|find from local|isDownload=" + bool1 + ",fontExists=" + bool2);
            localObject4 = localObject1;
          }
          return localObject4;
        }
        localObject4 = ???;
      } while (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null);
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(paramInt) == null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(jdField_a_of_type_JavaLangString);
      }
      localObject4 = ???;
    } while (!QLog.isColorLevel());
    QLog.d("FontManager", 2, "findFontInfo|find from cache");
    return ???;
  }
  
  private static String a(int paramInt)
  {
    String str = String.format("http://imgcache.qq.com/qqshow/admindata/comdata/vipfont_%d/android.zip", new Object[] { Integer.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getDownLoadResUri" + str);
    }
    return str;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: new 226	java/io/File
    //   3: dup
    //   4: getstatic 70	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: ldc 19
    //   9: invokespecial 341	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 299	java/io/File:exists	()Z
    //   17: ifeq +205 -> 222
    //   20: new 343	java/io/FileReader
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 304	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokespecial 344	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: sipush 4096
    //   37: newarray char
    //   39: astore 4
    //   41: aload_3
    //   42: astore_2
    //   43: new 50	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   50: astore 5
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: aload 4
    //   57: invokevirtual 348	java/io/FileReader:read	([C)I
    //   60: istore_1
    //   61: iload_1
    //   62: ifle +103 -> 165
    //   65: aload_3
    //   66: astore_2
    //   67: aload 5
    //   69: aload 4
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual 351	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -25 -> 52
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +16 -> 103
    //   90: aload_3
    //   91: astore_2
    //   92: ldc 37
    //   94: iconst_2
    //   95: aload 4
    //   97: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 357	java/io/FileReader:close	()V
    //   111: aload_0
    //   112: getfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   115: ifnonnull +14 -> 129
    //   118: aload_0
    //   119: new 359	org/json/JSONArray
    //   122: dup
    //   123: invokespecial 360	org/json/JSONArray:<init>	()V
    //   126: putfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   129: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +32 -> 164
    //   135: ldc 37
    //   137: iconst_2
    //   138: new 50	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 362
    //   148: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   155: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: return
    //   165: aload_3
    //   166: astore_2
    //   167: aload 5
    //   169: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore 4
    //   174: aload 4
    //   176: ifnull +18 -> 194
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: new 359	org/json/JSONArray
    //   185: dup
    //   186: aload 4
    //   188: invokespecial 366	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   191: putfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   194: aload_3
    //   195: ifnull -84 -> 111
    //   198: aload_3
    //   199: invokevirtual 357	java/io/FileReader:close	()V
    //   202: goto -91 -> 111
    //   205: astore_2
    //   206: goto -95 -> 111
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 357	java/io/FileReader:close	()V
    //   220: aload_3
    //   221: athrow
    //   222: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq -114 -> 111
    //   228: ldc 37
    //   230: iconst_2
    //   231: new 50	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   238: aload_2
    //   239: invokevirtual 304	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   242: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 368
    //   248: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -146 -> 111
    //   260: astore_2
    //   261: goto -150 -> 111
    //   264: astore_2
    //   265: goto -45 -> 220
    //   268: astore_3
    //   269: goto -57 -> 212
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_3
    //   276: goto -194 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	FontManager
    //   60	13	1	k	int
    //   12	169	2	localObject1	Object
    //   205	1	2	localIOException1	java.io.IOException
    //   211	28	2	localObject2	Object
    //   260	1	2	localIOException2	java.io.IOException
    //   264	1	2	localIOException3	java.io.IOException
    //   31	168	3	localFileReader	java.io.FileReader
    //   209	12	3	localObject3	Object
    //   268	1	3	localObject4	Object
    //   275	1	3	localObject5	Object
    //   39	31	4	arrayOfChar	char[]
    //   80	16	4	localException1	java.lang.Exception
    //   172	15	4	str	String
    //   272	1	4	localException2	java.lang.Exception
    //   50	118	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	41	80	java/lang/Exception
    //   43	52	80	java/lang/Exception
    //   54	61	80	java/lang/Exception
    //   67	77	80	java/lang/Exception
    //   167	174	80	java/lang/Exception
    //   181	194	80	java/lang/Exception
    //   198	202	205	java/io/IOException
    //   20	32	209	finally
    //   107	111	260	java/io/IOException
    //   216	220	264	java/io/IOException
    //   34	41	268	finally
    //   43	52	268	finally
    //   54	61	268	finally
    //   67	77	268	finally
    //   84	90	268	finally
    //   92	103	268	finally
    //   167	174	268	finally
    //   181	194	268	finally
    //   20	32	272	java/lang/Exception
  }
  
  private void a(String paramString, int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "Font_Mall", paramString, 0, 1, String.valueOf(paramInt), Integer.toString(NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext())), "", "");
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   8: ifnonnull +7 -> 15
    //   11: iload_1
    //   12: istore_2
    //   13: iload_2
    //   14: ireturn
    //   15: new 226	java/io/File
    //   18: dup
    //   19: getstatic 70	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: ldc 19
    //   24: invokespecial 341	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 299	java/io/File:exists	()Z
    //   32: ifeq +8 -> 40
    //   35: aload_3
    //   36: invokevirtual 400	java/io/File:delete	()Z
    //   39: pop
    //   40: new 402	java/io/RandomAccessFile
    //   43: dup
    //   44: aload_3
    //   45: ldc_w 404
    //   48: invokespecial 407	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload 4
    //   55: astore_3
    //   56: aload 4
    //   58: aload_0
    //   59: getfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   62: invokevirtual 408	org/json/JSONArray:toString	()Ljava/lang/String;
    //   65: invokevirtual 412	java/lang/String:getBytes	()[B
    //   68: invokevirtual 416	java/io/RandomAccessFile:write	([B)V
    //   71: aload 4
    //   73: astore_3
    //   74: aload 4
    //   76: invokevirtual 417	java/io/RandomAccessFile:close	()V
    //   79: iconst_1
    //   80: istore_2
    //   81: iload_2
    //   82: istore_1
    //   83: aload 4
    //   85: ifnull +10 -> 95
    //   88: aload 4
    //   90: invokevirtual 417	java/io/RandomAccessFile:close	()V
    //   93: iload_2
    //   94: istore_1
    //   95: iload_1
    //   96: istore_2
    //   97: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -87 -> 13
    //   103: ldc 37
    //   105: iconst_2
    //   106: new 50	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 419
    //   116: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 312	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 224	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload_1
    //   130: ireturn
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 422	java/io/IOException:printStackTrace	()V
    //   136: iload_2
    //   137: istore_1
    //   138: goto -43 -> 95
    //   141: astore 5
    //   143: aconst_null
    //   144: astore 4
    //   146: aload 4
    //   148: astore_3
    //   149: aload 5
    //   151: invokevirtual 423	java/io/FileNotFoundException:printStackTrace	()V
    //   154: iload_2
    //   155: istore_1
    //   156: aload 4
    //   158: ifnull -63 -> 95
    //   161: aload 4
    //   163: invokevirtual 417	java/io/RandomAccessFile:close	()V
    //   166: iload_2
    //   167: istore_1
    //   168: goto -73 -> 95
    //   171: astore_3
    //   172: aload_3
    //   173: invokevirtual 422	java/io/IOException:printStackTrace	()V
    //   176: iload_2
    //   177: istore_1
    //   178: goto -83 -> 95
    //   181: astore 5
    //   183: aconst_null
    //   184: astore 4
    //   186: aload 4
    //   188: astore_3
    //   189: aload 5
    //   191: invokevirtual 422	java/io/IOException:printStackTrace	()V
    //   194: iload_2
    //   195: istore_1
    //   196: aload 4
    //   198: ifnull -103 -> 95
    //   201: aload 4
    //   203: invokevirtual 417	java/io/RandomAccessFile:close	()V
    //   206: iload_2
    //   207: istore_1
    //   208: goto -113 -> 95
    //   211: astore_3
    //   212: aload_3
    //   213: invokevirtual 422	java/io/IOException:printStackTrace	()V
    //   216: iload_2
    //   217: istore_1
    //   218: goto -123 -> 95
    //   221: astore 4
    //   223: aconst_null
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 417	java/io/RandomAccessFile:close	()V
    //   233: aload 4
    //   235: athrow
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 422	java/io/IOException:printStackTrace	()V
    //   241: goto -8 -> 233
    //   244: astore 4
    //   246: goto -21 -> 225
    //   249: astore 5
    //   251: goto -65 -> 186
    //   254: astore 5
    //   256: goto -110 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	FontManager
    //   3	215	1	bool1	boolean
    //   1	216	2	bool2	boolean
    //   27	47	3	localObject1	Object
    //   131	2	3	localIOException1	java.io.IOException
    //   148	1	3	localObject2	Object
    //   171	2	3	localIOException2	java.io.IOException
    //   188	1	3	localObject3	Object
    //   211	2	3	localIOException3	java.io.IOException
    //   224	6	3	localObject4	Object
    //   236	2	3	localIOException4	java.io.IOException
    //   51	151	4	localRandomAccessFile	java.io.RandomAccessFile
    //   221	13	4	localObject5	Object
    //   244	1	4	localObject6	Object
    //   141	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   181	9	5	localIOException5	java.io.IOException
    //   249	1	5	localIOException6	java.io.IOException
    //   254	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   88	93	131	java/io/IOException
    //   40	53	141	java/io/FileNotFoundException
    //   161	166	171	java/io/IOException
    //   40	53	181	java/io/IOException
    //   201	206	211	java/io/IOException
    //   40	53	221	finally
    //   229	233	236	java/io/IOException
    //   56	71	244	finally
    //   74	79	244	finally
    //   149	154	244	finally
    //   189	194	244	finally
    //   56	71	249	java/io/IOException
    //   74	79	249	java/io/IOException
    //   56	71	254	java/io/FileNotFoundException
    //   74	79	254	java/io/FileNotFoundException
  }
  
  private boolean a(int paramInt, File arg2)
  {
    boolean bool2 = DownloaderFactory.a(???, new File(jdField_a_of_type_JavaLangString, String.valueOf(paramInt)));
    boolean bool1 = bool2;
    FontInfo localFontInfo;
    if (bool2)
    {
      bool2 = c(paramInt);
      bool1 = bool2;
      if (bool2) {
        localFontInfo = new FontInfo(paramInt, "", jdField_a_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + paramInt + ".ttf");
      }
    }
    synchronized (jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
    {
      jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(Integer.valueOf(paramInt), localFontInfo);
      bool1 = bool2;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(jdField_a_of_type_JavaLangString);
        bool1 = bool2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "saveFont|fontId=" + paramInt + ",result=" + bool1);
      }
      return bool1;
    }
  }
  
  public int a(int paramInt)
  {
    String str = a(paramInt);
    int k = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a(false, str);
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "stopDownload  id=" + paramInt + ", ret=" + k);
    }
    return k;
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FontManager", 2, "fontFeatureSupported=" + this.jdField_a_of_type_Boolean + ",inited=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      return 0;
    }
    ExtensionInfo localExtensionInfo = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramString);
    if ((localExtensionInfo == null) || (0L == localExtensionInfo.uVipFont) || (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a((int)localExtensionInfo.uVipFont, paramBoolean)))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("uin=").append(paramString).append(", fontId=");
        if (localExtensionInfo != null) {
          break label180;
        }
      }
      label180:
      for (paramString = null;; paramString = Integer.valueOf(0))
      {
        QLog.i("FontManager", 2, paramString);
        return 0;
      }
    }
    return (int)localExtensionInfo.uVipFont;
  }
  
  public int a(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {}
    do
    {
      do
      {
        return 0;
        if (paramBoolean) {
          break;
        }
      } while (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(2, paramBoolean));
      return 2;
    } while (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(1, paramBoolean));
    return 1;
  }
  
  public JSONObject a(int paramInt)
  {
    int k = 1;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (a(paramInt) != null)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", BaseApplicationImpl.getContext().getString(2131559341));
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "queryInfo fontId=" + paramInt + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        Object localObject = a(paramInt);
        localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a((String)localObject);
        if (localObject == null) {
          break;
        }
        switch (((DownloadTask)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
        {
        case 0: 
        case 1: 
          localJSONObject2.put("status", 1);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", BaseApplicationImpl.getContext().getString(2131559345));
          if (!((DownloadTask)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            break label470;
          }
          localJSONObject2.put("canceling", k);
          localJSONObject2.put("progress", ((DownloadTask)localObject).jdField_a_of_type_Float);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localJSONException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", BaseApplicationImpl.getContext().getString(2131559342));
        continue;
        localJSONException.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", BaseApplicationImpl.getContext().getString(2131559343));
        continue;
        localJSONException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", BaseApplicationImpl.getContext().getString(2131559344));
        continue;
        localJSONException.put("status", 1);
        localJSONException.put("progress", 0);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", BaseApplicationImpl.getContext().getString(2131559345));
        continue;
        continue;
        label470:
        k = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramString == null) && (!DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))) {}
    do
    {
      do
      {
        return;
      } while (a(paramInt) != null);
      String str = a(paramInt);
      File localFile = new File(jdField_b_of_type_JavaLangString, paramInt + ".zip");
      Bundle localBundle = null;
      if (paramString != null)
      {
        localBundle = new Bundle();
        localBundle.putInt("srcType", 2);
        localBundle.putString("callbackId", paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a(paramInt, str, localFile, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("FontManager", 2, "startDownload  id=" + paramInt);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = DeviceProfileManager.a().b(DeviceProfileManager.DpcNames.chat_font.name());
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      ExtensionInfo localExtensionInfo = localFriendsManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if ((localExtensionInfo == null) || (localExtensionInfo.uVipFont == 0L))
      {
        paramString = localFriendsManagerImp.a(paramString);
        if ((paramString != null) && (paramString.uVipFont != 0L)) {}
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FontManager", 2, "fontFeatureSupported=" + this.jdField_a_of_type_Boolean + ",inited=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ",ready=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    return;
    ThreadManager.a(new ff(this));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.c.set(paramBoolean1);
      return;
    }
    this.d.set(paramBoolean1);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {}
    for (;;)
    {
      return false;
      int k = 0;
      while (k < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
        try
        {
          int m = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(k).getInt("id");
          if (m == paramInt) {
            return true;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          k += 1;
        }
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.c.get();
    }
    return this.d.get();
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_OrgJsonJSONArray != null)
    {
      Object localObject1 = new JSONArray();
      int k = 0;
      for (;;)
      {
        if (k >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
          break label92;
        }
        try
        {
          JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(k);
          localObject2 = localObject1;
          if (localJSONObject.getInt("id") != paramInt)
          {
            ((JSONArray)localObject1).put(localJSONObject);
            localObject2 = localObject1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
        k += 1;
        localObject1 = localObject2;
      }
      label92:
      bool1 = bool2;
      if (localJSONException != null)
      {
        this.jdField_a_of_type_OrgJsonJSONArray = localJSONException;
        bool1 = a();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "delFontInfo|res=" + bool1 + ",fontId=" + paramInt);
    }
    return bool1;
  }
  
  public boolean c(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {}
    try
    {
      if (!a(paramInt))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", paramInt);
        localJSONObject.put("updateFlag", 0);
        this.jdField_a_of_type_OrgJsonJSONArray.put(localJSONObject);
      }
      for (bool1 = a();; bool1 = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "addFontInfo|res=" + bool1 + ",fontId=" + paramInt);
        }
        return bool1;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        bool1 = bool2;
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a();
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.c();
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onDestroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager
 * JD-Core Version:    0.7.0.1
 */