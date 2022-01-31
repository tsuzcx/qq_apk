package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FontManager
  implements Manager
{
  static final String jdField_a_of_type_JavaLangString = "FontManager";
  private static final int b = 10;
  public static final String b;
  public static boolean b = false;
  public static final String c;
  public static final String d = "http://i.gtimg.cn/qqshow/admindata/comdata/vipfont_%d/android.zip";
  public static volatile boolean d = false;
  public static final String e = "font_local.cfg";
  public static final String f = ".ttf";
  protected static final String g = "Font_download_succ";
  protected static final String h = "Font_download_cancel";
  protected static final String i = "Font_download";
  protected static final String j = "AIO_Font_download";
  public static final String k = "isUserOpenFontSwitch_";
  public static final String l = "font_open_switch";
  private int jdField_a_of_type_Int = 5000000;
  public long a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public AtomicBoolean a;
  public JSONArray a;
  public boolean a;
  public AtomicBoolean b;
  public AtomicBoolean c;
  public volatile boolean c;
  public AtomicBoolean d;
  public boolean e;
  
  static
  {
    jdField_b_of_type_JavaLangString = AppConstants.as + "font_info";
    jdField_c_of_type_JavaLangString = AppConstants.as + "font_tmp";
    jdField_b_of_type_Boolean = false;
  }
  
  public FontManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.d = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(41));
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    this.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
    this.e = false;
    a();
  }
  
  public static Drawable a(AppInterface paramAppInterface, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = (Pair)BaseApplicationImpl.a.get("font_thumb_" + paramInt);
    if (localObject1 != null)
    {
      paramAppInterface = ((Drawable.ConstantState)((Pair)localObject1).first).newDrawable(paramAppInterface.a().getResources());
      return paramAppInterface;
    }
    for (;;)
    {
      try
      {
        m = paramAppInterface.getApplication().getResources().getDimensionPixelSize(2131493067);
        n = paramAppInterface.getApplication().getResources().getDimensionPixelSize(2131493068);
        if (paramInt != 0) {
          continue;
        }
        localObject1 = BitmapManager.a(paramAppInterface.a().getResources(), 2130838981, m, n);
      }
      catch (Throwable localThrowable)
      {
        int n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FontManager", 2, "getFontDrawable fail," + localThrowable.getMessage());
        Object localObject2 = null;
        continue;
        int m = Utils.getBitmapSize((Bitmap)localObject2);
        localObject2 = new BitmapDrawable(paramAppInterface.a().getResources(), (Bitmap)localObject2);
        ((BitmapDrawable)localObject2).setTargetDensity(paramAppInterface.a().getResources().getDisplayMetrics());
        paramAppInterface = new Pair(localObject2, Integer.valueOf(m));
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
        localObject1 = BitmapManager.a(jdField_b_of_type_JavaLangString + File.separator + paramInt + File.separator + "chat_font_thumbnail.png", m, n);
        continue;
      }
      BaseApplicationImpl.a.put("font_thumb_" + paramInt, new Pair(((Drawable)paramAppInterface.first).getConstantState(), paramAppInterface.second));
    }
    label350:
    for (paramAppInterface = (Drawable)paramAppInterface.first;; paramAppInterface = null) {
      return paramAppInterface;
    }
  }
  
  private static String a(int paramInt)
  {
    String str = String.format("http://i.gtimg.cn/qqshow/admindata/comdata/vipfont_%d/android.zip", new Object[] { Integer.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getDownLoadResUri" + str);
    }
    return EmosmUtils.insertMtype("VIP_font", str);
  }
  
  private String a(ChatMessage paramChatMessage)
  {
    switch (paramChatMessage.istroop)
    {
    default: 
      return null;
    case 0: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1009: 
    case 1020: 
    case 1022: 
    case 1025: 
      if (paramChatMessage.isSend()) {
        return paramChatMessage.selfuin;
      }
      return paramChatMessage.frienduin;
    case 1: 
      if (paramChatMessage.isSend()) {
        return paramChatMessage.selfuin;
      }
      return paramChatMessage.senderuin;
    }
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    return paramChatMessage.senderuin;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: new 222	java/io/File
    //   3: dup
    //   4: getstatic 74	com/etrump/mixlayout/FontManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7: ldc 22
    //   9: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 321	java/io/File:exists	()Z
    //   17: ifeq +205 -> 222
    //   20: new 323	java/io/FileReader
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 326	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokespecial 329	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: sipush 4096
    //   37: newarray char
    //   39: astore 4
    //   41: aload_3
    //   42: astore_2
    //   43: new 54	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   50: astore 5
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: aload 4
    //   57: invokevirtual 333	java/io/FileReader:read	([C)I
    //   60: istore_1
    //   61: iload_1
    //   62: ifle +103 -> 165
    //   65: aload_3
    //   66: astore_2
    //   67: aload 5
    //   69: aload 4
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual 336	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -25 -> 52
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +16 -> 103
    //   90: aload_3
    //   91: astore_2
    //   92: ldc 10
    //   94: iconst_2
    //   95: aload 4
    //   97: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 342	java/io/FileReader:close	()V
    //   111: aload_0
    //   112: getfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   115: ifnonnull +14 -> 129
    //   118: aload_0
    //   119: new 344	org/json/JSONArray
    //   122: dup
    //   123: invokespecial 345	org/json/JSONArray:<init>	()V
    //   126: putfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   129: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +32 -> 164
    //   135: ldc 10
    //   137: iconst_2
    //   138: new 54	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 347
    //   148: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   155: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: return
    //   165: aload_3
    //   166: astore_2
    //   167: aload 5
    //   169: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore 4
    //   174: aload 4
    //   176: ifnull +18 -> 194
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: new 344	org/json/JSONArray
    //   185: dup
    //   186: aload 4
    //   188: invokespecial 351	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   191: putfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   194: aload_3
    //   195: ifnull -84 -> 111
    //   198: aload_3
    //   199: invokevirtual 342	java/io/FileReader:close	()V
    //   202: goto -91 -> 111
    //   205: astore_2
    //   206: goto -95 -> 111
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 342	java/io/FileReader:close	()V
    //   220: aload_3
    //   221: athrow
    //   222: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq -114 -> 111
    //   228: ldc 10
    //   230: iconst_2
    //   231: new 54	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   238: aload_2
    //   239: invokevirtual 326	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   242: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 353
    //   248: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   60	13	1	m	int
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
    //   50	118	5	localStringBuilder	java.lang.StringBuilder
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
  
  /* Error */
  private boolean b()
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
    //   15: new 222	java/io/File
    //   18: dup
    //   19: getstatic 74	com/etrump/mixlayout/FontManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   22: ldc 22
    //   24: invokespecial 318	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 321	java/io/File:exists	()Z
    //   32: ifeq +8 -> 40
    //   35: aload_3
    //   36: invokevirtual 358	java/io/File:delete	()Z
    //   39: pop
    //   40: new 360	java/io/RandomAccessFile
    //   43: dup
    //   44: aload_3
    //   45: ldc_w 362
    //   48: invokespecial 365	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload 4
    //   55: astore_3
    //   56: aload 4
    //   58: aload_0
    //   59: getfield 91	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   62: invokevirtual 366	org/json/JSONArray:toString	()Ljava/lang/String;
    //   65: invokevirtual 370	java/lang/String:getBytes	()[B
    //   68: invokevirtual 374	java/io/RandomAccessFile:write	([B)V
    //   71: aload 4
    //   73: astore_3
    //   74: aload 4
    //   76: invokevirtual 375	java/io/RandomAccessFile:close	()V
    //   79: iconst_1
    //   80: istore_2
    //   81: iload_2
    //   82: istore_1
    //   83: aload 4
    //   85: ifnull +10 -> 95
    //   88: aload 4
    //   90: invokevirtual 375	java/io/RandomAccessFile:close	()V
    //   93: iload_2
    //   94: istore_1
    //   95: iload_1
    //   96: istore_2
    //   97: invokestatic 215	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -87 -> 13
    //   103: ldc 10
    //   105: iconst_2
    //   106: new 54	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 377
    //   116: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 380	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload_1
    //   130: ireturn
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 383	java/io/IOException:printStackTrace	()V
    //   136: iload_2
    //   137: istore_1
    //   138: goto -43 -> 95
    //   141: astore 5
    //   143: aconst_null
    //   144: astore 4
    //   146: aload 4
    //   148: astore_3
    //   149: aload 5
    //   151: invokevirtual 384	java/io/FileNotFoundException:printStackTrace	()V
    //   154: iload_2
    //   155: istore_1
    //   156: aload 4
    //   158: ifnull -63 -> 95
    //   161: aload 4
    //   163: invokevirtual 375	java/io/RandomAccessFile:close	()V
    //   166: iload_2
    //   167: istore_1
    //   168: goto -73 -> 95
    //   171: astore_3
    //   172: aload_3
    //   173: invokevirtual 383	java/io/IOException:printStackTrace	()V
    //   176: iload_2
    //   177: istore_1
    //   178: goto -83 -> 95
    //   181: astore 5
    //   183: aconst_null
    //   184: astore 4
    //   186: aload 4
    //   188: astore_3
    //   189: aload 5
    //   191: invokevirtual 383	java/io/IOException:printStackTrace	()V
    //   194: iload_2
    //   195: istore_1
    //   196: aload 4
    //   198: ifnull -103 -> 95
    //   201: aload 4
    //   203: invokevirtual 375	java/io/RandomAccessFile:close	()V
    //   206: iload_2
    //   207: istore_1
    //   208: goto -113 -> 95
    //   211: astore_3
    //   212: aload_3
    //   213: invokevirtual 383	java/io/IOException:printStackTrace	()V
    //   216: iload_2
    //   217: istore_1
    //   218: goto -123 -> 95
    //   221: astore 4
    //   223: aconst_null
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 375	java/io/RandomAccessFile:close	()V
    //   233: aload 4
    //   235: athrow
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 383	java/io/IOException:printStackTrace	()V
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
  
  public int a(int paramInt)
  {
    String str = a(paramInt);
    int m = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(false, str);
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "stopDownload  id=" + paramInt + ", ret=" + m);
    }
    return m;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public FontInfo a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          FontInfo localFontInfo = (FontInfo)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          if (localFontInfo.jdField_a_of_type_Int == paramInt) {
            return localFontInfo;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      m += 1;
    }
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      if (QLog.isColorLevel()) {
        QLog.i("FontManager", 2, "inited=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ",ready=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = a();
    } while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
  }
  
  void a(String paramString, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "Font_Mall", paramString, 0, 1, String.valueOf(paramInt), Integer.toString(NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext())), "", String.valueOf(paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("font_open_switch", 4).edit().putBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramBoolean).commit();
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean1);
      return;
    }
    this.d.set(paramBoolean1);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {}
    for (;;)
    {
      return false;
      int m = 0;
      while (m < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
        try
        {
          int n = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(m).getInt("id");
          if (n == paramInt) {
            return true;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          m += 1;
        }
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
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
      int m = 0;
      for (;;)
      {
        if (m >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
          break label92;
        }
        try
        {
          JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(m);
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
        m += 1;
        localObject1 = localObject2;
      }
      label92:
      bool1 = bool2;
      if (localJSONException != null)
      {
        this.jdField_a_of_type_OrgJsonJSONArray = localJSONException;
        bool1 = b();
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
      for (bool1 = b();; bool1 = true)
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
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onDestroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager
 * JD-Core Version:    0.7.0.1
 */