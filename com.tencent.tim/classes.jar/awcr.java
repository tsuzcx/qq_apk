import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.location.Location;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class awcr
{
  private static awcr a;
  private static final String[] ay = { "DISTINCT _data" };
  static Map<Long, Integer> map = new HashMap();
  private static long uin;
  
  private static Cursor a(Context paramContext, int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoChangeStrategy", 1);
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoMinSize", 300);
    long l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoMaxSize", 20000) * 1024;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bucket_display_name");
    ((StringBuilder)localObject).append(" != 'Screenshots' ");
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("_size");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(i * 1024);
    if (paramInt == 1)
    {
      ((StringBuilder)localObject).append(" and ");
      ((StringBuilder)localObject).append("_size");
      ((StringBuilder)localObject).append("<=");
      ((StringBuilder)localObject).append(l);
    }
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(paramLong1 / 1000L);
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(" <= ");
    ((StringBuilder)localObject).append(paramLong2 / 1000L);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      paramContext = alld.query(paramContext.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ay, (String)localObject, null, "date_modified DESC LIMIT 0,50");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static ExifInterface a(String paramString)
  {
    try
    {
      if (!JpegExifReader.isCrashJpeg(paramString))
      {
        paramString = new ExifInterface(paramString);
        return paramString;
      }
      return null;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public static awcr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awcr();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public static ArrayList<String> a(Context paramContext, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: lload_2
    //   3: lload 4
    //   5: invokestatic 129	awcr:a	(Landroid/content/Context;IJJ)Landroid/database/Cursor;
    //   8: astore_0
    //   9: aload_0
    //   10: invokeinterface 135 1 0
    //   15: istore_1
    //   16: iload_1
    //   17: ifle +366 -> 383
    //   20: new 137	java/util/ArrayList
    //   23: dup
    //   24: iload_1
    //   25: invokespecial 140	java/util/ArrayList:<init>	(I)V
    //   28: astore 9
    //   30: aload_0
    //   31: ldc 142
    //   33: invokeinterface 146 2 0
    //   38: istore_1
    //   39: new 137	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 147	java/util/ArrayList:<init>	()V
    //   46: astore 8
    //   48: iload 7
    //   50: tableswitch	default:+339 -> 389, 0:+179->229, 1:+189->239, 2:+199->249
    //   77: nop
    //   78: dload_1
    //   79: ldc 41
    //   81: ldc 43
    //   83: iconst_1
    //   84: invokevirtual 47	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   87: istore 7
    //   89: aload_0
    //   90: invokeinterface 151 1 0
    //   95: ifeq +281 -> 376
    //   98: aload_0
    //   99: iload_1
    //   100: invokeinterface 155 2 0
    //   105: astore 10
    //   107: aload 10
    //   109: ifnull -20 -> 89
    //   112: aload 8
    //   114: aload 10
    //   116: invokeinterface 161 2 0
    //   121: ifne -32 -> 89
    //   124: new 163	java/io/File
    //   127: dup
    //   128: aload 10
    //   130: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: astore 11
    //   135: aload 11
    //   137: ifnull -48 -> 89
    //   140: aload 11
    //   142: invokevirtual 167	java/io/File:exists	()Z
    //   145: ifeq -56 -> 89
    //   148: aload 11
    //   150: invokevirtual 170	java/io/File:isDirectory	()Z
    //   153: ifne -64 -> 89
    //   156: iload 7
    //   158: ifne +14 -> 172
    //   161: aload 10
    //   163: invokestatic 172	awcr:a	(Ljava/lang/String;)Landroid/media/ExifInterface;
    //   166: invokestatic 175	awcr:a	(Landroid/media/ExifInterface;)Z
    //   169: ifeq -80 -> 89
    //   172: aload 9
    //   174: aload 10
    //   176: invokevirtual 178	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload 9
    //   182: invokevirtual 181	java/util/ArrayList:size	()I
    //   185: iload 6
    //   187: if_icmplt -98 -> 89
    //   190: invokestatic 186	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +183 -> 376
    //   196: ldc 188
    //   198: iconst_4
    //   199: ldc 190
    //   201: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 9
    //   206: astore 8
    //   208: aload 8
    //   210: astore 9
    //   212: aload_0
    //   213: ifnull +13 -> 226
    //   216: aload_0
    //   217: invokeinterface 197 1 0
    //   222: aload 8
    //   224: astore 9
    //   226: aload 9
    //   228: areturn
    //   229: ldc 199
    //   231: invokestatic 205	awdi:bq	(Ljava/lang/String;)Ljava/util/List;
    //   234: astore 8
    //   236: goto -160 -> 76
    //   239: ldc 207
    //   241: invokestatic 205	awdi:bq	(Ljava/lang/String;)Ljava/util/List;
    //   244: astore 8
    //   246: goto -170 -> 76
    //   249: ldc 209
    //   251: invokestatic 205	awdi:bq	(Ljava/lang/String;)Ljava/util/List;
    //   254: astore 8
    //   256: goto -180 -> 76
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   264: aload 8
    //   266: areturn
    //   267: astore 9
    //   269: aconst_null
    //   270: astore_0
    //   271: aconst_null
    //   272: astore 8
    //   274: aload 9
    //   276: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   279: aload_0
    //   280: astore 9
    //   282: aload 8
    //   284: ifnull -58 -> 226
    //   287: aload 8
    //   289: invokeinterface 197 1 0
    //   294: aload_0
    //   295: areturn
    //   296: astore 8
    //   298: aload 8
    //   300: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   303: aload_0
    //   304: areturn
    //   305: astore 8
    //   307: aconst_null
    //   308: astore_0
    //   309: aload_0
    //   310: ifnull +9 -> 319
    //   313: aload_0
    //   314: invokeinterface 197 1 0
    //   319: aload 8
    //   321: athrow
    //   322: astore_0
    //   323: aload_0
    //   324: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   327: goto -8 -> 319
    //   330: astore 8
    //   332: goto -23 -> 309
    //   335: astore 9
    //   337: aload 8
    //   339: astore_0
    //   340: aload 9
    //   342: astore 8
    //   344: goto -35 -> 309
    //   347: astore 9
    //   349: aconst_null
    //   350: astore 10
    //   352: aload_0
    //   353: astore 8
    //   355: aload 10
    //   357: astore_0
    //   358: goto -84 -> 274
    //   361: astore 10
    //   363: aload_0
    //   364: astore 8
    //   366: aload 9
    //   368: astore_0
    //   369: aload 10
    //   371: astore 9
    //   373: goto -99 -> 274
    //   376: aload 9
    //   378: astore 8
    //   380: goto -172 -> 208
    //   383: aconst_null
    //   384: astore 8
    //   386: goto -178 -> 208
    //   389: goto -313 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramContext	Context
    //   0	392	1	paramInt1	int
    //   0	392	2	paramLong1	long
    //   0	392	4	paramLong2	long
    //   0	392	6	paramInt2	int
    //   0	392	7	paramInt3	int
    //   46	242	8	localObject1	Object
    //   296	3	8	localException1	Exception
    //   305	15	8	localObject2	Object
    //   330	8	8	localObject3	Object
    //   342	43	8	localObject4	Object
    //   28	199	9	localObject5	Object
    //   267	8	9	localException2	Exception
    //   280	1	9	localContext	Context
    //   335	6	9	localObject6	Object
    //   347	20	9	localException3	Exception
    //   371	6	9	localObject7	Object
    //   105	251	10	str	String
    //   361	9	10	localException4	Exception
    //   133	16	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   216	222	259	java/lang/Exception
    //   0	9	267	java/lang/Exception
    //   287	294	296	java/lang/Exception
    //   0	9	305	finally
    //   313	319	322	java/lang/Exception
    //   9	16	330	finally
    //   20	30	330	finally
    //   30	48	330	finally
    //   76	89	330	finally
    //   89	107	330	finally
    //   112	135	330	finally
    //   140	156	330	finally
    //   161	172	330	finally
    //   172	204	330	finally
    //   229	236	330	finally
    //   239	246	330	finally
    //   249	256	330	finally
    //   274	279	335	finally
    //   9	16	347	java/lang/Exception
    //   20	30	347	java/lang/Exception
    //   30	48	361	java/lang/Exception
    //   76	89	361	java/lang/Exception
    //   89	107	361	java/lang/Exception
    //   112	135	361	java/lang/Exception
    //   140	156	361	java/lang/Exception
    //   161	172	361	java/lang/Exception
    //   172	204	361	java/lang/Exception
    //   229	236	361	java/lang/Exception
    //   239	246	361	java/lang/Exception
    //   249	256	361	java/lang/Exception
  }
  
  private static boolean a(ExifInterface paramExifInterface)
  {
    if (paramExifInterface == null) {}
    do
    {
      return false;
      paramExifInterface = paramExifInterface.getAttribute("DateTime");
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "FDateTime:" + paramExifInterface);
      }
    } while (paramExifInterface == null);
    return true;
  }
  
  public static boolean aMl()
  {
    long l1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadGuideScanTimeInterval", 1) * 60 * 60 * 1000;
    long l2 = LocalMultiProcConfig.getLong("key_photo_guide_last_check", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "KEY_PHOTO_GUIDE_LAST_CHECK get:" + l2);
    }
    if (l2 <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck");
      }
    }
    do
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck S-L:" + (System.currentTimeMillis() - l2));
      }
    } while ((System.currentTimeMillis() - l2 >= l1) || (System.currentTimeMillis() - l2 <= 0L));
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isOverLastCheck false");
    }
    return false;
  }
  
  public static boolean aMm()
  {
    long l = LocalMultiProcConfig.getLong("key_photo_guide_enter_qzone_date", 0L);
    if (l <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
      }
    }
    do
    {
      return false;
      l = System.currentTimeMillis() - l;
      if ((l <= 86400000L) && (l > 0L)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isCurrentDayInQzone");
    }
    return true;
  }
  
  public static boolean aMn()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_album_photo_show_start_hour", 19);
    int j = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_album_photo_show_end_hour", 22);
    int k = Calendar.getInstance().get(11);
    return (k >= i) && (k < j);
  }
  
  private long aT()
  {
    return LocalMultiProcConfig.getLong("LocalRecentPhotoCheckManager.new_photo_check_lasttime", 0L);
  }
  
  @TargetApi(11)
  public static Bitmap b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap paramBitmap)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() <= 0)) {}
    while ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return null;
    }
    for (;;)
    {
      try
      {
        localOptions = new BitmapFactory.Options();
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap = null;
        System.gc();
        try
        {
          paramString = BitmapFactory.decodeFile(paramString, paramBitmap);
          return paramString;
        }
        catch (Throwable paramString)
        {
          QLog.i("PhotoUtils", 1, "decodeBitmapFromFile happen exception");
          System.gc();
          return null;
        }
      }
      try
      {
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        if ((paramInt1 == 0) || (paramInt2 == 0)) {
          break label221;
        }
        if (!paramBoolean) {
          continue;
        }
        paramInt1 = Math.max(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap = localOptions;
        continue;
        paramInt1 = 1;
        continue;
      }
      localOptions.inSampleSize = paramInt1;
      localOptions.inMutable = true;
      if ((Build.VERSION.SDK_INT >= 11) && (paramBitmap != null)) {
        localOptions.inBitmap = paramBitmap;
      }
      return BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramString), 4096), null, localOptions);
      paramInt1 = Math.min(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
    }
  }
  
  public static Bitmap b(String paramString, Bitmap paramBitmap)
  {
    return b(paramString, 0, 0, false, paramBitmap);
  }
  
  public static void eDj()
  {
    if (map != null) {
      map.clear();
    }
  }
  
  public static boolean fJ()
  {
    uin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    int i;
    if (map.get(Long.valueOf(uin)) != null) {
      i = ((Integer)map.get(Long.valueOf(uin))).intValue();
    }
    while ((i & 0x2) != 0)
    {
      return true;
      i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, uin);
      map.put(Long.valueOf(uin), Integer.valueOf(i));
    }
    return false;
  }
  
  public static int gd(String paramString)
  {
    try
    {
      int i = JpegExifReader.readOrientation(paramString);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static String p(double paramDouble)
  {
    String[] arrayOfString = Location.convert(Math.abs(paramDouble), 2).split(":");
    Object localObject = arrayOfString[2].split("\\.");
    if (localObject.length == 0) {}
    for (localObject = arrayOfString[2];; localObject = localObject[0]) {
      return arrayOfString[0] + "/1," + arrayOfString[1] + "/1," + (String)localObject + "/1";
    }
  }
  
  /* Error */
  public static boolean saveBitmapToFile(Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 163	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 167	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 447	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: new 449	java/io/BufferedOutputStream
    //   24: dup
    //   25: new 451	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 454	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 457	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore_1
    //   41: aload_0
    //   42: aload_2
    //   43: iload_3
    //   44: aload 7
    //   46: invokevirtual 463	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   49: istore 5
    //   51: aload 7
    //   53: astore_1
    //   54: aload 7
    //   56: invokevirtual 466	java/io/BufferedOutputStream:flush	()V
    //   59: iload 4
    //   61: ifeq +10 -> 71
    //   64: aload 7
    //   66: astore_1
    //   67: aload_0
    //   68: invokevirtual 469	android/graphics/Bitmap:recycle	()V
    //   71: iload 5
    //   73: istore 6
    //   75: aload 7
    //   77: ifnull +12 -> 89
    //   80: aload 7
    //   82: invokevirtual 470	java/io/BufferedOutputStream:close	()V
    //   85: iload 5
    //   87: istore 6
    //   89: iload 6
    //   91: ireturn
    //   92: astore 7
    //   94: ldc 188
    //   96: iconst_1
    //   97: ldc_w 472
    //   100: aload 7
    //   102: invokestatic 476	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: goto -84 -> 21
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 477	java/io/IOException:printStackTrace	()V
    //   113: iload 5
    //   115: ireturn
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_2
    //   119: iconst_0
    //   120: istore 4
    //   122: aload_2
    //   123: astore_1
    //   124: ldc 188
    //   126: iconst_1
    //   127: ldc_w 479
    //   130: aload_0
    //   131: invokestatic 476	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: iload 4
    //   136: istore 6
    //   138: aload_2
    //   139: ifnull -50 -> 89
    //   142: aload_2
    //   143: invokevirtual 470	java/io/BufferedOutputStream:close	()V
    //   146: iload 4
    //   148: ireturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 477	java/io/IOException:printStackTrace	()V
    //   154: iload 4
    //   156: ireturn
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 470	java/io/BufferedOutputStream:close	()V
    //   168: aload_0
    //   169: athrow
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 477	java/io/IOException:printStackTrace	()V
    //   175: goto -7 -> 168
    //   178: astore_0
    //   179: goto -19 -> 160
    //   182: astore_0
    //   183: iconst_0
    //   184: istore 4
    //   186: aload 7
    //   188: astore_2
    //   189: goto -67 -> 122
    //   192: astore_0
    //   193: iload 5
    //   195: istore 4
    //   197: aload 7
    //   199: astore_2
    //   200: goto -78 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramBitmap	Bitmap
    //   0	203	1	paramString	String
    //   0	203	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	203	3	paramInt	int
    //   0	203	4	paramBoolean	boolean
    //   49	145	5	bool1	boolean
    //   73	64	6	bool2	boolean
    //   36	45	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   92	106	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	21	92	java/lang/Exception
    //   80	85	108	java/io/IOException
    //   21	38	116	java/lang/Exception
    //   142	146	149	java/io/IOException
    //   21	38	157	finally
    //   164	168	170	java/io/IOException
    //   41	51	178	finally
    //   54	59	178	finally
    //   67	71	178	finally
    //   124	134	178	finally
    //   41	51	182	java/lang/Exception
    //   54	59	192	java/lang/Exception
    //   67	71	192	java/lang/Exception
  }
  
  public boolean aMk()
  {
    if ((QzoneConfig.getInstance().getConfig("PhotoUpload", "GuideShowOpen", 7) & 0x4) == 0) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "showGuide == CLOSE");
      }
    }
    label178:
    ArrayList localArrayList;
    do
    {
      do
      {
        return false;
        int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoMinCount", 10);
        long l4 = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoTimeRange", 6) * 60 * 60 * 1000;
        long l3 = aT();
        long l2 = System.currentTimeMillis();
        if (l3 != 0L)
        {
          l1 = l3;
          if (l2 >= l3) {}
        }
        else
        {
          l1 = l2;
        }
        if (l1 == l2) {}
        for (long l1 = l2 - l4;; l1 = Math.max(l1, l2 - l4))
        {
          if (l1 == l2 - l4) {
            break label178;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("PhotoUtils", 4, l4 + "秒以内");
          return false;
        }
        if (QLog.isDevelopLevel())
        {
          QLog.d("PhotoUtils", 4, "filterTime:" + l1);
          QLog.d("PhotoUtils", 4, "nowTime:" + l2);
        }
        localArrayList = a(BaseApplication.getContext(), 20480, l1, l2, i, 0);
        if ((localArrayList != null) && (localArrayList.size() >= i))
        {
          LocalMultiProcConfig.putLong("key_photo_guide_first_photo", new File((String)localArrayList.get(localArrayList.size() - 1)).lastModified());
          return true;
        }
        if (localArrayList != null) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("PhotoUtils", 4, "no pics");
      return false;
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "pics count:" + localArrayList.size());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awcr
 * JD-Core Version:    0.7.0.1
 */