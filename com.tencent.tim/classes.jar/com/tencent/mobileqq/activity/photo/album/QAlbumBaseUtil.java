package com.tencent.mobileqq.activity.photo.album;

import alld;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import anow;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.activity.photo.LocalMediaInfo;>;
import java.util.Map;

public class QAlbumBaseUtil
{
  public static int CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 0;
  protected static final String IMAGE_ORDER_BY = "_id DESC";
  private static final int MAX_PHOTO_HEIGHT_OF_CACHE = 65535;
  private static final int MAX_PHOTO_WIDTH_OF_CACHE = 65535;
  protected static final String TAG = "QAlbumUtil";
  public static final int TYPE_SLIDESHOW = 1;
  private static String[] VIDEO_COLUMNS;
  public static String[] columns;
  private static Map<String, Integer> pathWHMap;
  public static boolean sAlbumQueryFailReport = false;
  private static long sLastModify;
  
  static
  {
    CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE = 10485760;
    if (Build.VERSION.SDK_INT >= 16)
    {
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size", "width", "height" };
      if (Build.VERSION.SDK_INT < 16) {
        break label207;
      }
    }
    label207:
    for (columns = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size", "width", "height" };; columns = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size" })
    {
      pathWHMap = new HashMap();
      return;
      VIDEO_COLUMNS = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" };
      break;
    }
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong)
  {
    return getAlbumMedias(paramContext, paramString1, paramString2, paramInt1, paramMediaFileFilter, paramInt2, paramInt3, paramBoolean1, paramArrayList, paramBoolean2, paramLong, -1);
  }
  
  /* Error */
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 19
    //   3: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 17
    //   11: iconst_2
    //   12: ldc 110
    //   14: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: ldc 116
    //   19: aload_1
    //   20: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +125 -> 148
    //   26: aload_0
    //   27: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 132	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   33: getstatic 63	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   36: aconst_null
    //   37: aconst_null
    //   38: ldc 11
    //   40: invokestatic 138	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 16
    //   45: aload 16
    //   47: astore 17
    //   49: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 16
    //   54: if_icmplt +47 -> 101
    //   57: iconst_1
    //   58: istore 15
    //   60: aload 16
    //   62: astore 17
    //   64: aload_0
    //   65: aload 16
    //   67: aconst_null
    //   68: iload_3
    //   69: aload 4
    //   71: iload 15
    //   73: lload 10
    //   75: invokestatic 142	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSystemAndAppVideoList	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/ArrayList;
    //   78: astore 18
    //   80: aload 18
    //   82: astore_0
    //   83: aload_0
    //   84: astore_1
    //   85: aload 16
    //   87: ifnull +12 -> 99
    //   90: aload 16
    //   92: invokeinterface 147 1 0
    //   97: aload_0
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: iconst_0
    //   102: istore 15
    //   104: goto -44 -> 60
    //   107: astore 18
    //   109: aconst_null
    //   110: astore 16
    //   112: aload 16
    //   114: astore 17
    //   116: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +17 -> 136
    //   122: aload 16
    //   124: astore 17
    //   126: ldc 17
    //   128: iconst_2
    //   129: ldc 149
    //   131: aload 18
    //   133: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload 16
    //   138: ifnull +10 -> 148
    //   141: aload 16
    //   143: invokeinterface 147 1 0
    //   148: aload 19
    //   150: astore 16
    //   152: aload 4
    //   154: ifnull +42 -> 196
    //   157: aload 19
    //   159: astore 16
    //   161: aload 4
    //   163: invokevirtual 158	com/tencent/mobileqq/activity/photo/MediaFileFilter:showImage	()Z
    //   166: ifeq +30 -> 196
    //   169: iload 12
    //   171: iconst_1
    //   172: if_icmpne +225 -> 397
    //   175: aload_0
    //   176: aload_1
    //   177: aload_2
    //   178: iload_3
    //   179: aload 4
    //   181: iload 5
    //   183: iload 6
    //   185: iload 7
    //   187: aload 8
    //   189: iload 9
    //   191: invokestatic 162	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getSlideShowAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   194: astore 16
    //   196: aload 4
    //   198: ifnull +570 -> 768
    //   201: aload 4
    //   203: invokevirtual 165	com/tencent/mobileqq/activity/photo/MediaFileFilter:showVideo	()Z
    //   206: ifeq +562 -> 768
    //   209: aload_0
    //   210: aload_1
    //   211: aload_2
    //   212: iload_3
    //   213: aload 4
    //   215: lload 10
    //   217: invokestatic 169	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumVideos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   220: astore_0
    //   221: ldc 171
    //   223: aload_1
    //   224: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifeq +62 -> 289
    //   230: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   233: lstore 10
    //   235: aload 16
    //   237: ifnull +8 -> 245
    //   240: aload 16
    //   242: invokestatic 182	java/util/Collections:sort	(Ljava/util/List;)V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokestatic 182	java/util/Collections:sort	(Ljava/util/List;)V
    //   253: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +33 -> 289
    //   259: ldc 17
    //   261: iconst_2
    //   262: new 184	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   269: ldc 187
    //   271: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   277: lload 10
    //   279: lsub
    //   280: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   283: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +71 -> 363
    //   295: new 184	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   302: ldc 200
    //   304: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: astore_2
    //   308: aload 16
    //   310: ifnull +111 -> 421
    //   313: aload 16
    //   315: invokeinterface 206 1 0
    //   320: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: astore_1
    //   324: aload_2
    //   325: aload_1
    //   326: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: ldc 217
    //   331: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: astore_2
    //   335: aload_0
    //   336: ifnull +91 -> 427
    //   339: aload_0
    //   340: invokeinterface 206 1 0
    //   345: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: astore_1
    //   349: ldc 17
    //   351: iconst_2
    //   352: aload_2
    //   353: aload_1
    //   354: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: ifnull +12 -> 376
    //   367: aload_0
    //   368: invokeinterface 220 1 0
    //   373: ifeq +60 -> 433
    //   376: aload 16
    //   378: areturn
    //   379: astore_0
    //   380: aconst_null
    //   381: astore 17
    //   383: aload 17
    //   385: ifnull +10 -> 395
    //   388: aload 17
    //   390: invokeinterface 147 1 0
    //   395: aload_0
    //   396: athrow
    //   397: aload_0
    //   398: aload_1
    //   399: aload_2
    //   400: iload_3
    //   401: aload 4
    //   403: iload 5
    //   405: iload 6
    //   407: iload 7
    //   409: aload 8
    //   411: iload 9
    //   413: invokestatic 223	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getAlbumPhotos	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   416: astore 16
    //   418: goto -222 -> 196
    //   421: ldc 225
    //   423: astore_1
    //   424: goto -100 -> 324
    //   427: ldc 225
    //   429: astore_1
    //   430: goto -81 -> 349
    //   433: aload_0
    //   434: astore_1
    //   435: aload 16
    //   437: ifnull -338 -> 99
    //   440: aload_0
    //   441: astore_1
    //   442: aload 16
    //   444: invokeinterface 220 1 0
    //   449: ifne -350 -> 99
    //   452: aload 16
    //   454: invokeinterface 206 1 0
    //   459: istore 5
    //   461: iconst_0
    //   462: istore 6
    //   464: iconst_0
    //   465: istore 12
    //   467: iload 12
    //   469: aload_0
    //   470: invokeinterface 206 1 0
    //   475: if_icmpge +266 -> 741
    //   478: aload_0
    //   479: iload 12
    //   481: invokeinterface 229 2 0
    //   486: checkcast 231	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   489: astore_1
    //   490: aload 16
    //   492: iload 5
    //   494: iconst_1
    //   495: isub
    //   496: invokeinterface 229 2 0
    //   501: checkcast 231	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   504: astore_2
    //   505: aload_1
    //   506: getfield 234	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   509: aload_2
    //   510: getfield 234	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   513: lcmp
    //   514: ifgt +95 -> 609
    //   517: iload_3
    //   518: iconst_m1
    //   519: if_icmpne +39 -> 558
    //   522: iload 12
    //   524: aload_0
    //   525: invokeinterface 206 1 0
    //   530: if_icmpge +211 -> 741
    //   533: aload 16
    //   535: aload_0
    //   536: iload 12
    //   538: invokeinterface 229 2 0
    //   543: invokeinterface 237 2 0
    //   548: pop
    //   549: iload 12
    //   551: iconst_1
    //   552: iadd
    //   553: istore 12
    //   555: goto -33 -> 522
    //   558: aload_0
    //   559: invokeinterface 206 1 0
    //   564: iload 12
    //   566: isub
    //   567: iload_3
    //   568: iload 5
    //   570: isub
    //   571: invokestatic 243	java/lang/Math:min	(II)I
    //   574: istore 5
    //   576: iconst_0
    //   577: istore_3
    //   578: iload_3
    //   579: iload 5
    //   581: if_icmpge +160 -> 741
    //   584: aload 16
    //   586: aload_0
    //   587: iload_3
    //   588: iload 12
    //   590: iadd
    //   591: invokeinterface 229 2 0
    //   596: invokeinterface 237 2 0
    //   601: pop
    //   602: iload_3
    //   603: iconst_1
    //   604: iadd
    //   605: istore_3
    //   606: goto -28 -> 578
    //   609: iload 6
    //   611: istore 13
    //   613: iload 13
    //   615: iload 5
    //   617: if_icmpge +136 -> 753
    //   620: aload 16
    //   622: iload 13
    //   624: invokeinterface 229 2 0
    //   629: checkcast 231	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   632: astore_2
    //   633: aload_1
    //   634: getfield 234	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   637: aload_2
    //   638: getfield 234	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   641: lcmp
    //   642: ifgt +12 -> 654
    //   645: iload 13
    //   647: iconst_1
    //   648: iadd
    //   649: istore 13
    //   651: goto -38 -> 613
    //   654: aload 16
    //   656: iload 13
    //   658: aload_1
    //   659: invokeinterface 246 3 0
    //   664: iload_3
    //   665: iconst_m1
    //   666: if_icmpeq +24 -> 690
    //   669: aload 16
    //   671: invokeinterface 206 1 0
    //   676: iload_3
    //   677: if_icmple +13 -> 690
    //   680: aload 16
    //   682: iload 5
    //   684: invokeinterface 249 2 0
    //   689: pop
    //   690: aload 16
    //   692: invokeinterface 206 1 0
    //   697: istore 14
    //   699: iload 5
    //   701: istore 6
    //   703: iload 5
    //   705: iload 14
    //   707: if_icmpeq +7 -> 714
    //   710: iload 14
    //   712: istore 6
    //   714: iload 13
    //   716: iconst_1
    //   717: iadd
    //   718: istore 5
    //   720: iload 12
    //   722: iconst_1
    //   723: iadd
    //   724: istore 12
    //   726: iload 6
    //   728: istore 13
    //   730: iload 5
    //   732: istore 6
    //   734: iload 13
    //   736: istore 5
    //   738: goto -271 -> 467
    //   741: aload 16
    //   743: areturn
    //   744: astore_0
    //   745: goto -362 -> 383
    //   748: astore 18
    //   750: goto -638 -> 112
    //   753: iload 5
    //   755: istore 13
    //   757: iload 6
    //   759: istore 5
    //   761: iload 13
    //   763: istore 6
    //   765: goto -45 -> 720
    //   768: aconst_null
    //   769: astore_0
    //   770: goto -549 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	paramContext	Context
    //   0	773	1	paramString1	String
    //   0	773	2	paramString2	String
    //   0	773	3	paramInt1	int
    //   0	773	4	paramMediaFileFilter	MediaFileFilter
    //   0	773	5	paramInt2	int
    //   0	773	6	paramInt3	int
    //   0	773	7	paramBoolean1	boolean
    //   0	773	8	paramArrayList	ArrayList<String>
    //   0	773	9	paramBoolean2	boolean
    //   0	773	10	paramLong	long
    //   0	773	12	paramInt4	int
    //   611	151	13	i	int
    //   697	14	14	j	int
    //   58	45	15	bool	boolean
    //   43	699	16	localObject1	Object
    //   47	342	17	localObject2	Object
    //   78	3	18	localArrayList	ArrayList
    //   107	25	18	localException1	java.lang.Exception
    //   748	1	18	localException2	java.lang.Exception
    //   1	157	19	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   26	45	107	java/lang/Exception
    //   26	45	379	finally
    //   49	57	744	finally
    //   64	80	744	finally
    //   116	122	744	finally
    //   126	136	744	finally
    //   49	57	748	java/lang/Exception
    //   64	80	748	java/lang/Exception
  }
  
  public static List<LocalMediaInfo> getAlbumMedias(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    return getAlbumMedias(paramContext, paramString1, paramString2, paramInt, paramMediaFileFilter, 0, -1, false, null, false, paramLong);
  }
  
  public static List<LocalMediaInfo> getAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAlbumUtil", 2, "getAlbumPhotos");
    }
    if ((paramString2 == null) || ("$RecentAlbumId".equals(paramString1))) {
      paramContext = queryRecentImages(paramContext, paramInt3, paramInt1, paramMediaFileFilter, paramBoolean1, paramInt2, paramArrayList, paramBoolean2);
    }
    do
    {
      do
      {
        return paramContext;
        paramString1 = queryImages(paramContext, "bucket_id='" + paramString1 + "'", paramInt1, paramMediaFileFilter);
        paramContext = paramString1;
      } while (paramString1 == null);
      paramContext = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("QAlbumUtil", 2, "photo list size is:" + paramString1.size());
    return paramString1;
  }
  
  /* Error */
  public static List<LocalMediaInfo> getAlbumVideos(Context paramContext, String paramString1, String paramString2, int paramInt, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +12 -> 13
    //   4: ldc 171
    //   6: aload_1
    //   7: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +16 -> 26
    //   13: aload_0
    //   14: sipush 210
    //   17: iload_3
    //   18: aload 4
    //   20: lload 5
    //   22: invokestatic 276	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryRecentVideos	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;J)Ljava/util/List;
    //   25: areturn
    //   26: new 278	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 279	java/util/ArrayList:<init>	()V
    //   33: astore 8
    //   35: new 184	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 260
    //   45: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 262
    //   55: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_1
    //   62: aload_0
    //   63: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   66: getstatic 132	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   69: getstatic 63	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   72: aload_1
    //   73: aconst_null
    //   74: ldc 11
    //   76: invokestatic 138	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_1
    //   80: aload_1
    //   81: astore_0
    //   82: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   85: bipush 16
    //   87: if_icmplt +35 -> 122
    //   90: iconst_1
    //   91: istore 7
    //   93: aload_1
    //   94: astore_0
    //   95: aload_1
    //   96: aload 8
    //   98: iload_3
    //   99: aload 4
    //   101: iload 7
    //   103: lload 5
    //   105: invokestatic 283	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   108: pop
    //   109: aload_1
    //   110: ifnull +76 -> 186
    //   113: aload_1
    //   114: invokeinterface 147 1 0
    //   119: aload 8
    //   121: areturn
    //   122: iconst_0
    //   123: istore 7
    //   125: goto -32 -> 93
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: astore_0
    //   133: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +14 -> 150
    //   139: aload_1
    //   140: astore_0
    //   141: ldc 17
    //   143: iconst_2
    //   144: ldc 149
    //   146: aload_2
    //   147: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_1
    //   151: ifnull +35 -> 186
    //   154: aload_1
    //   155: invokeinterface 147 1 0
    //   160: aload 8
    //   162: areturn
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +9 -> 176
    //   170: aload_0
    //   171: invokeinterface 147 1 0
    //   176: aload_1
    //   177: athrow
    //   178: astore_1
    //   179: goto -13 -> 166
    //   182: astore_2
    //   183: goto -52 -> 131
    //   186: aload 8
    //   188: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramContext	Context
    //   0	189	1	paramString1	String
    //   0	189	2	paramString2	String
    //   0	189	3	paramInt	int
    //   0	189	4	paramMediaFileFilter	MediaFileFilter
    //   0	189	5	paramLong	long
    //   91	33	7	bool	boolean
    //   33	154	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   62	80	128	java/lang/Exception
    //   62	80	163	finally
    //   82	90	178	finally
    //   95	109	178	finally
    //   133	139	178	finally
    //   141	150	178	finally
    //   82	90	182	java/lang/Exception
    //   95	109	182	java/lang/Exception
  }
  
  private static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, MediaFileFilter paramMediaFileFilter)
  {
    getImageList(paramCursor, paramList, paramInt1, paramInt2, paramBoolean, paramMediaFileFilter, null, false);
  }
  
  public static void getImageList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean1, MediaFileFilter paramMediaFileFilter, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    Object localObject1;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int n;
    if (paramCursor.getCount() > 0)
    {
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      i3 = paramCursor.getColumnIndexOrThrow("_id");
      i4 = paramCursor.getColumnIndexOrThrow("_data");
      i5 = paramCursor.getColumnIndexOrThrow("orientation");
      i6 = paramCursor.getColumnIndexOrThrow("date_added");
      i7 = paramCursor.getColumnIndexOrThrow("date_modified");
      i8 = paramCursor.getColumnIndexOrThrow("mime_type");
      i9 = paramCursor.getColumnIndexOrThrow("_size");
      i10 = paramCursor.getColumnIndexOrThrow("latitude");
      i11 = paramCursor.getColumnIndexOrThrow("longitude");
      if (!paramBoolean1) {
        break label1304;
      }
      n = paramCursor.getColumnIndexOrThrow("width");
    }
    for (int m = paramCursor.getColumnIndexOrThrow("height");; m = 0)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      if (QLog.isColorLevel()) {
        QLog.i("QAlbumUtil", 2, "getImageList imageCursor count:" + paramCursor.getCount());
      }
      int k = 0;
      int i = 0;
      int j = 0;
      for (;;)
      {
        String str;
        label252:
        Object localObject2;
        if (paramCursor.moveToNext())
        {
          str = paramCursor.getString(i4);
          if (!fileExistsAndNotEmpty(str))
          {
            if (str == null)
            {
              i1 = j;
              j = i + 1;
              i = i1;
              if (!QLog.isColorLevel()) {
                break label1289;
              }
              localObject2 = new StringBuilder().append("getImageList file not exists:");
              if (str == null) {
                break label328;
              }
            }
            label328:
            for (paramList = str;; paramList = "null")
            {
              QLog.i("QAlbumUtil", 2, paramList);
              i1 = j;
              j = i;
              i = i1;
              break;
              i1 = j + 1;
              j = i;
              i = i1;
              break label252;
            }
          }
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            paramList = paramArrayList.iterator();
            do
            {
              if (!paramList.hasNext()) {
                break;
              }
            } while (!str.contains((String)paramList.next()));
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label1287;
          }
          localObject2 = paramCursor.getString(i8);
          paramList = (List<LocalMediaInfo>)localObject2;
          if (paramMediaFileFilter != null)
          {
            paramList = (List<LocalMediaInfo>)localObject2;
            if (paramMediaFileFilter.filter((String)localObject2))
            {
              if ((!"*/*".equals(localObject2)) && (!"image/*".equals(localObject2))) {
                break label971;
              }
              if ((str.indexOf(".jpg") == -1) && (str.indexOf(".jpeg") == -1)) {
                break label867;
              }
              paramList = "image/jpeg";
            }
          }
          label468:
          long l1 = paramCursor.getLong(i6);
          long l2 = paramCursor.getLong(i7);
          if (sLastModify < l2) {
            sLastModify = l2;
          }
          int i2 = 0;
          i1 = i2;
          if (paramBoolean1)
          {
            i1 = i2;
            if (paramCursor.getInt(n) == 0) {
              i1 = 1;
            }
          }
          long l3 = paramCursor.getLong(i3);
          if ((paramInt1 > 0) && ((!paramBoolean1) || (i1 != 0)))
          {
            getWHByPath(str, localOptions, arrayOfInt);
            if ((arrayOfInt[0] < paramInt1) && (arrayOfInt[1] < paramInt1)) {
              break label1280;
            }
            localObject2 = new LocalMediaInfo();
            ((LocalMediaInfo)localObject2)._id = l3;
            ((LocalMediaInfo)localObject2).path = str;
            ((LocalMediaInfo)localObject2).addedDate = l1;
            ((LocalMediaInfo)localObject2).modifiedDate = l2;
            ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i5);
            ((LocalMediaInfo)localObject2).mMimeType = paramList;
            ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i9);
            ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
            ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
            ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i10) * 1000000.0D));
            ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i11) * 1000000.0D));
            if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
              QLog.i("QAlbumUtil", 2, "no size " + str);
            }
            ((List)localObject1).add(localObject2);
            k += 1;
          }
          label1280:
          for (;;)
          {
            if ((paramInt2 > 0) && (k >= paramInt2))
            {
              if (!sAlbumQueryFailReport)
              {
                if ((i > 0) || (j > 0))
                {
                  paramCursor = new StringBuffer();
                  paramCursor.append("imagePathNullCount:");
                  paramCursor.append(i);
                  paramCursor.append(" imagePathFileNotExistCount:");
                  paramCursor.append(j);
                  paramCursor = paramCursor.toString();
                  if (i > 0) {
                    anow.report("Album_Query_File_Path_Null", paramCursor);
                  }
                  if (j > 0) {
                    anow.report("Album_Query_File_Not_Exist", paramCursor);
                  }
                }
                sAlbumQueryFailReport = true;
              }
              return;
              label867:
              if (str.indexOf(".gif") != -1)
              {
                paramList = "image/gif";
                break label468;
              }
              if (str.indexOf(".bmp") != -1)
              {
                paramList = "image/bmp";
                break label468;
              }
              if (str.indexOf(".png") != -1)
              {
                paramList = "image/png";
                break label468;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("QAlbumUtil", 2, "Filter mime type:" + (String)localObject2 + ", path is " + str);
              break;
              label971:
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("QAlbumUtil", 2, "Filter unknown " + (String)localObject2 + ", path is " + str);
              break;
              localObject2 = new LocalMediaInfo();
              ((LocalMediaInfo)localObject2)._id = l3;
              ((LocalMediaInfo)localObject2).path = str;
              ((LocalMediaInfo)localObject2).addedDate = paramCursor.getLong(i6);
              ((LocalMediaInfo)localObject2).modifiedDate = paramCursor.getLong(i7);
              ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i5);
              ((LocalMediaInfo)localObject2).mMimeType = paramList;
              ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i9);
              ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i10) * 1000000.0D));
              ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i11) * 1000000.0D));
              if (paramBoolean1)
              {
                ((LocalMediaInfo)localObject2).mediaWidth = paramCursor.getInt(n);
                ((LocalMediaInfo)localObject2).mediaHeight = paramCursor.getInt(m);
              }
              if ((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0))
              {
                getWHByPath(str, localOptions, arrayOfInt);
                ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
                ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
              }
              if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
                QLog.i("QAlbumUtil", 2, "no size " + str);
              }
              ((List)localObject1).add(localObject2);
              k += 1;
              continue;
            }
            break;
          }
        }
        label1287:
        continue;
        label1289:
        i1 = j;
        j = i;
        i = i1;
      }
      label1304:
      n = 0;
    }
  }
  
  /* Error */
  public static List<LocalMediaInfo> getSlideShowAlbumPhotos(Context paramContext, String paramString1, String paramString2, int paramInt1, MediaFileFilter paramMediaFileFilter, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 278	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 279	java/util/ArrayList:<init>	()V
    //   7: astore 13
    //   9: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 17
    //   17: iconst_2
    //   18: ldc 254
    //   20: invokestatic 446	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: astore 12
    //   26: new 184	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   33: astore 14
    //   35: iconst_0
    //   36: istore 10
    //   38: aload_2
    //   39: ifnull +12 -> 51
    //   42: ldc 171
    //   44: aload_1
    //   45: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +6 -> 54
    //   51: iconst_1
    //   52: istore 10
    //   54: iload 10
    //   56: ifeq +18 -> 74
    //   59: iload_3
    //   60: ifgt +55 -> 115
    //   63: new 448	java/lang/IllegalArgumentException
    //   66: dup
    //   67: ldc_w 450
    //   70: invokespecial 451	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   73: athrow
    //   74: aload 14
    //   76: new 184	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 260
    //   86: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 262
    //   96: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 14
    //   108: ldc_w 453
    //   111: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   118: bipush 16
    //   120: if_icmplt +515 -> 635
    //   123: iconst_1
    //   124: istore 11
    //   126: iload 11
    //   128: ifeq +313 -> 441
    //   131: iload 7
    //   133: ifeq +194 -> 327
    //   136: aload 14
    //   138: new 184	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 455
    //   148: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   154: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: ldc_w 457
    //   160: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 59
    //   165: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 459
    //   171: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 59
    //   176: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc_w 461
    //   182: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 61
    //   187: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 459
    //   193: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 61
    //   198: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 463
    //   204: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc 61
    //   209: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 465
    //   215: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc 59
    //   220: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 467
    //   226: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 61
    //   231: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 465
    //   237: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 59
    //   242: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 469
    //   248: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_0
    //   259: aload 14
    //   261: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: iconst_3
    //   265: anewarray 43	java/lang/String
    //   268: dup
    //   269: iconst_0
    //   270: iload 5
    //   272: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: iload 6
    //   280: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: iload 6
    //   288: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   291: aastore
    //   292: iload_3
    //   293: invokestatic 474	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   296: astore_0
    //   297: aload_0
    //   298: aload 13
    //   300: iload 6
    //   302: iload_3
    //   303: iload 11
    //   305: aload 4
    //   307: aload 8
    //   309: iload 9
    //   311: invokestatic 288	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   314: aload_0
    //   315: ifnull +9 -> 324
    //   318: aload_0
    //   319: invokeinterface 147 1 0
    //   324: aload 13
    //   326: areturn
    //   327: aload 14
    //   329: new 184	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 455
    //   339: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   345: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: ldc_w 457
    //   351: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc 59
    //   356: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 459
    //   362: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc 59
    //   367: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc_w 476
    //   373: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 61
    //   378: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc_w 459
    //   384: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc 61
    //   389: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc_w 478
    //   395: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: goto -147 -> 258
    //   408: astore_1
    //   409: aconst_null
    //   410: astore_0
    //   411: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +14 -> 428
    //   417: ldc 17
    //   419: iconst_2
    //   420: aload_1
    //   421: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   424: aload_1
    //   425: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: aload_0
    //   429: ifnull -105 -> 324
    //   432: aload_0
    //   433: invokeinterface 147 1 0
    //   438: aload 13
    //   440: areturn
    //   441: iload 5
    //   443: ifle +114 -> 557
    //   446: aload 14
    //   448: new 184	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 485
    //   458: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: iload 5
    //   463: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: ldc_w 487
    //   469: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc 57
    //   474: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc_w 489
    //   480: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   486: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   489: ldc_w 491
    //   492: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc 47
    //   497: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: getstatic 494	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   510: invokevirtual 500	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   513: astore_1
    //   514: aload_1
    //   515: ldc_w 502
    //   518: iload_3
    //   519: bipush 6
    //   521: imul
    //   522: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   525: invokevirtual 508	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   528: pop
    //   529: aload_1
    //   530: invokevirtual 512	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   533: astore_1
    //   534: aload_0
    //   535: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   538: aload_1
    //   539: getstatic 71	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:columns	[Ljava/lang/String;
    //   542: aload 14
    //   544: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: aconst_null
    //   548: ldc 11
    //   550: invokestatic 138	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   553: astore_0
    //   554: goto -257 -> 297
    //   557: aload 14
    //   559: new 184	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 514
    //   569: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: getstatic 36	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE	I
    //   575: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   578: ldc_w 491
    //   581: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc 47
    //   586: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: goto -89 -> 507
    //   599: astore_0
    //   600: aload 12
    //   602: astore_1
    //   603: aload_1
    //   604: ifnull +9 -> 613
    //   607: aload_1
    //   608: invokeinterface 147 1 0
    //   613: aload_0
    //   614: athrow
    //   615: astore_2
    //   616: aload_0
    //   617: astore_1
    //   618: aload_2
    //   619: astore_0
    //   620: goto -17 -> 603
    //   623: astore_2
    //   624: aload_0
    //   625: astore_1
    //   626: aload_2
    //   627: astore_0
    //   628: goto -25 -> 603
    //   631: astore_1
    //   632: goto -221 -> 411
    //   635: iconst_0
    //   636: istore 11
    //   638: goto -512 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	641	0	paramContext	Context
    //   0	641	1	paramString1	String
    //   0	641	2	paramString2	String
    //   0	641	3	paramInt1	int
    //   0	641	4	paramMediaFileFilter	MediaFileFilter
    //   0	641	5	paramInt2	int
    //   0	641	6	paramInt3	int
    //   0	641	7	paramBoolean1	boolean
    //   0	641	8	paramArrayList	ArrayList<String>
    //   0	641	9	paramBoolean2	boolean
    //   36	19	10	i	int
    //   124	513	11	bool	boolean
    //   24	577	12	localObject	Object
    //   7	432	13	localArrayList	ArrayList
    //   33	525	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   136	258	408	java/lang/Exception
    //   258	297	408	java/lang/Exception
    //   327	405	408	java/lang/Exception
    //   446	507	408	java/lang/Exception
    //   507	554	408	java/lang/Exception
    //   557	596	408	java/lang/Exception
    //   136	258	599	finally
    //   258	297	599	finally
    //   327	405	599	finally
    //   446	507	599	finally
    //   507	554	599	finally
    //   557	596	599	finally
    //   297	314	615	finally
    //   411	428	623	finally
    //   297	314	631	java/lang/Exception
  }
  
  private static ArrayList<LocalMediaInfo> getSystemAndAppVideoList(Context paramContext, Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    paramContext = new ArrayList();
    paramCursor = (ArrayList)getVideoList(paramCursor, paramList, paramInt, paramMediaFileFilter, paramBoolean, paramLong);
    if (paramCursor != null) {
      paramContext.addAll(paramCursor);
    }
    if (QLog.isColorLevel()) {
      QLog.e("QAlbumUtil", 2, "getSystemAndAppVideoList listsize=" + paramContext.size());
    }
    paramCursor = MediaScanner.getInstance(BaseApplication.getContext());
    if (paramCursor != null)
    {
      paramCursor = paramCursor.getMediaScannerInfos(false, -1);
      if (paramCursor != null)
      {
        paramCursor = paramCursor.iterator();
        while (paramCursor.hasNext())
        {
          paramList = (MediaScannerInfo)paramCursor.next();
          paramMediaFileFilter = new LocalMediaInfo();
          paramMediaFileFilter._id = paramList.id;
          paramMediaFileFilter.mDuration = paramList.duration;
          paramMediaFileFilter.fileSize = paramList.fileSize;
          paramMediaFileFilter.path = paramList.path;
          paramMediaFileFilter.modifiedDate = paramList.modifiedDate;
          paramMediaFileFilter.mMimeType = paramList.mimeType;
          paramMediaFileFilter.isSystemMeidaStore = false;
          paramContext.add(paramMediaFileFilter);
        }
      }
    }
    Collections.sort(paramContext);
    return paramContext;
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  private static List<LocalMediaInfo> getVideoList(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, MediaFileFilter paramMediaFileFilter, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 292 1 0
    //   6: istore 7
    //   8: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc 17
    //   16: iconst_2
    //   17: new 184	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 564
    //   27: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload 7
    //   32: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iload 7
    //   43: ifgt +7 -> 50
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: aload_1
    //   51: astore 22
    //   53: aload_1
    //   54: ifnonnull +12 -> 66
    //   57: new 278	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 279	java/util/ArrayList:<init>	()V
    //   64: astore 22
    //   66: aload_0
    //   67: ldc 45
    //   69: invokeinterface 296 2 0
    //   74: istore 11
    //   76: aload_0
    //   77: ldc 47
    //   79: invokeinterface 296 2 0
    //   84: istore 12
    //   86: aload_0
    //   87: ldc 51
    //   89: invokeinterface 296 2 0
    //   94: istore 13
    //   96: aload_0
    //   97: ldc 53
    //   99: invokeinterface 296 2 0
    //   104: istore 14
    //   106: aload_0
    //   107: ldc 49
    //   109: invokeinterface 296 2 0
    //   114: istore 15
    //   116: aload_0
    //   117: ldc 55
    //   119: invokeinterface 296 2 0
    //   124: istore 16
    //   126: aload_0
    //   127: ldc 57
    //   129: invokeinterface 296 2 0
    //   134: istore 17
    //   136: iconst_0
    //   137: istore 8
    //   139: iconst_0
    //   140: istore 7
    //   142: iload 4
    //   144: ifeq +23 -> 167
    //   147: aload_0
    //   148: ldc 59
    //   150: invokeinterface 296 2 0
    //   155: istore 8
    //   157: aload_0
    //   158: ldc 61
    //   160: invokeinterface 296 2 0
    //   165: istore 7
    //   167: iconst_0
    //   168: istore 9
    //   170: aconst_null
    //   171: astore 24
    //   173: aload_0
    //   174: invokeinterface 310 1 0
    //   179: ifeq +420 -> 599
    //   182: aload_0
    //   183: iload 12
    //   185: invokeinterface 314 2 0
    //   190: astore 25
    //   192: aload 25
    //   194: invokestatic 568	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +18 -> 215
    //   200: new 84	java/io/File
    //   203: dup
    //   204: aload 25
    //   206: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: invokevirtual 91	java/io/File:exists	()Z
    //   212: ifne +56 -> 268
    //   215: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -45 -> 173
    //   221: new 184	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 570
    //   231: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: astore 23
    //   236: aload 25
    //   238: ifnull +24 -> 262
    //   241: aload 25
    //   243: astore_1
    //   244: ldc 17
    //   246: iconst_2
    //   247: aload 23
    //   249: aload_1
    //   250: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -86 -> 173
    //   262: ldc 225
    //   264: astore_1
    //   265: goto -21 -> 244
    //   268: aload_0
    //   269: iload 16
    //   271: invokeinterface 314 2 0
    //   276: astore 23
    //   278: aload_3
    //   279: ifnull +70 -> 349
    //   282: aload_3
    //   283: aload 23
    //   285: invokevirtual 339	com/tencent/mobileqq/activity/photo/MediaFileFilter:filter	(Ljava/lang/String;)Z
    //   288: ifeq +61 -> 349
    //   291: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq -121 -> 173
    //   297: aload 24
    //   299: astore_1
    //   300: aload 24
    //   302: ifnonnull +11 -> 313
    //   305: new 184	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   312: astore_1
    //   313: aload_1
    //   314: ldc_w 439
    //   317: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 23
    //   322: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 441
    //   328: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 25
    //   333: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc_w 572
    //   339: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_1
    //   344: astore 24
    //   346: goto -173 -> 173
    //   349: aload_0
    //   350: iload 13
    //   352: invokeinterface 356 2 0
    //   357: lstore 18
    //   359: aload_0
    //   360: iload 14
    //   362: invokeinterface 356 2 0
    //   367: lstore 20
    //   369: new 231	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   372: dup
    //   373: invokespecial 367	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   376: astore 26
    //   378: aload 26
    //   380: aload_0
    //   381: iload 11
    //   383: invokeinterface 356 2 0
    //   388: putfield 369	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   391: aload 26
    //   393: aload 25
    //   395: putfield 372	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   398: aload 26
    //   400: aload 23
    //   402: putfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   405: aload 26
    //   407: lload 18
    //   409: putfield 375	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   412: aload 26
    //   414: lload 20
    //   416: putfield 234	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   419: aload 26
    //   421: aload_0
    //   422: iload 15
    //   424: invokeinterface 356 2 0
    //   429: putfield 546	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   432: aload 26
    //   434: aload_0
    //   435: iload 17
    //   437: invokeinterface 356 2 0
    //   442: putfield 383	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   445: iload 4
    //   447: ifeq +243 -> 690
    //   450: aload 26
    //   452: aload_0
    //   453: iload 8
    //   455: invokeinterface 362 2 0
    //   460: putfield 386	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   463: aload 26
    //   465: aload_0
    //   466: iload 7
    //   468: invokeinterface 362 2 0
    //   473: putfield 389	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   476: aload 26
    //   478: getfield 546	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   481: lconst_0
    //   482: lcmp
    //   483: ifne +50 -> 533
    //   486: new 574	android/media/MediaMetadataRetriever
    //   489: dup
    //   490: invokespecial 575	android/media/MediaMetadataRetriever:<init>	()V
    //   493: astore 23
    //   495: aload 23
    //   497: astore_1
    //   498: aload 23
    //   500: aload 25
    //   502: invokevirtual 578	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   505: aload 23
    //   507: astore_1
    //   508: aload 26
    //   510: aload 23
    //   512: bipush 9
    //   514: invokevirtual 581	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   517: invokestatic 587	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   520: putfield 546	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   523: aload 23
    //   525: ifnull +8 -> 533
    //   528: aload 23
    //   530: invokevirtual 590	android/media/MediaMetadataRetriever:release	()V
    //   533: lload 5
    //   535: lconst_0
    //   536: lcmp
    //   537: ifle +14 -> 551
    //   540: aload 26
    //   542: getfield 546	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   545: lload 5
    //   547: lcmp
    //   548: ifgt -375 -> 173
    //   551: aload 22
    //   553: aload 26
    //   555: invokeinterface 237 2 0
    //   560: pop
    //   561: iload 9
    //   563: iconst_1
    //   564: iadd
    //   565: istore 10
    //   567: getstatic 358	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sLastModify	J
    //   570: lload 20
    //   572: lcmp
    //   573: ifge +8 -> 581
    //   576: lload 20
    //   578: putstatic 358	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:sLastModify	J
    //   581: iload 10
    //   583: istore 9
    //   585: iload_2
    //   586: ifle -413 -> 173
    //   589: iload 10
    //   591: istore 9
    //   593: iload 10
    //   595: iload_2
    //   596: if_icmplt -423 -> 173
    //   599: aload 22
    //   601: astore_0
    //   602: aload 24
    //   604: ifnull -556 -> 48
    //   607: aload 22
    //   609: astore_0
    //   610: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq -565 -> 48
    //   616: ldc 17
    //   618: iconst_2
    //   619: aload 24
    //   621: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: aload 22
    //   629: areturn
    //   630: astore 25
    //   632: aconst_null
    //   633: astore 23
    //   635: aload 23
    //   637: astore_1
    //   638: aload 25
    //   640: invokevirtual 593	java/lang/Exception:printStackTrace	()V
    //   643: aload 23
    //   645: astore_1
    //   646: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq +15 -> 664
    //   652: aload 23
    //   654: astore_1
    //   655: ldc 17
    //   657: iconst_2
    //   658: ldc_w 595
    //   661: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: aload 23
    //   666: ifnull -133 -> 533
    //   669: aload 23
    //   671: invokevirtual 590	android/media/MediaMetadataRetriever:release	()V
    //   674: goto -141 -> 533
    //   677: astore_0
    //   678: aconst_null
    //   679: astore_1
    //   680: aload_1
    //   681: ifnull +7 -> 688
    //   684: aload_1
    //   685: invokevirtual 590	android/media/MediaMetadataRetriever:release	()V
    //   688: aload_0
    //   689: athrow
    //   690: new 574	android/media/MediaMetadataRetriever
    //   693: dup
    //   694: invokespecial 575	android/media/MediaMetadataRetriever:<init>	()V
    //   697: astore_1
    //   698: aload_1
    //   699: aload 25
    //   701: invokevirtual 578	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   704: aload_1
    //   705: bipush 18
    //   707: invokevirtual 581	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   710: astore 23
    //   712: aload_1
    //   713: bipush 19
    //   715: invokevirtual 581	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   718: astore 25
    //   720: aload_1
    //   721: invokevirtual 590	android/media/MediaMetadataRetriever:release	()V
    //   724: aload 26
    //   726: aload 23
    //   728: invokestatic 598	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   731: putfield 386	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   734: aload 26
    //   736: aload 25
    //   738: invokestatic 598	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   741: putfield 389	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   744: goto -211 -> 533
    //   747: astore_1
    //   748: aload 26
    //   750: iconst_0
    //   751: putfield 386	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   754: aload 26
    //   756: iconst_0
    //   757: putfield 389	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   760: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   763: ifeq -230 -> 533
    //   766: ldc 17
    //   768: iconst_2
    //   769: ldc_w 600
    //   772: invokestatic 307	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: goto -242 -> 533
    //   778: astore_0
    //   779: goto -99 -> 680
    //   782: astore 25
    //   784: goto -149 -> 635
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	787	0	paramCursor	Cursor
    //   0	787	1	paramList	List<LocalMediaInfo>
    //   0	787	2	paramInt	int
    //   0	787	3	paramMediaFileFilter	MediaFileFilter
    //   0	787	4	paramBoolean	boolean
    //   0	787	5	paramLong	long
    //   6	461	7	i	int
    //   137	317	8	j	int
    //   168	424	9	k	int
    //   565	32	10	m	int
    //   74	308	11	n	int
    //   84	100	12	i1	int
    //   94	257	13	i2	int
    //   104	257	14	i3	int
    //   114	309	15	i4	int
    //   124	146	16	i5	int
    //   134	302	17	i6	int
    //   357	51	18	l1	long
    //   367	210	20	l2	long
    //   51	577	22	localObject1	Object
    //   234	493	23	localObject2	Object
    //   171	449	24	localList	List<LocalMediaInfo>
    //   190	311	25	str1	String
    //   630	70	25	localException1	java.lang.Exception
    //   718	19	25	str2	String
    //   782	1	25	localException2	java.lang.Exception
    //   376	379	26	localLocalMediaInfo	LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   486	495	630	java/lang/Exception
    //   486	495	677	finally
    //   724	744	747	java/lang/NumberFormatException
    //   498	505	778	finally
    //   508	523	778	finally
    //   638	643	778	finally
    //   646	652	778	finally
    //   655	664	778	finally
    //   498	505	782	java/lang/Exception
    //   508	523	782	java/lang/Exception
  }
  
  private static void getWHByPath(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    Integer localInteger = (Integer)pathWHMap.get(paramString);
    if (localInteger == null) {}
    for (;;)
    {
      try
      {
        SafeBitmapFactory.decodeFile(paramString, paramOptions);
        k = paramOptions.outWidth;
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = 0;
        continue;
      }
      try
      {
        m = paramOptions.outHeight;
        i = m;
        j = k;
        if (k <= 65535)
        {
          i = m;
          j = k;
          if (m > 65535) {}
        }
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = k;
        continue;
      }
      try
      {
        i = paramOptions.outWidth;
        j = paramOptions.outHeight;
        pathWHMap.put(paramString, Integer.valueOf(i << 16 & 0xFFFF0000 | j & 0xFFFF));
        j = k;
        i = m;
      }
      catch (OutOfMemoryError paramString)
      {
        i = m;
        j = k;
        continue;
      }
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      return;
      j = localInteger.intValue() >> 16 & 0xFFFF;
      i = localInteger.intValue() & 0xFFFF;
    }
  }
  
  private static Cursor queryImages(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return alld.query(paramContext.getContentResolver(), (Uri)localObject, columns, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  /* Error */
  private static List<LocalMediaInfo> queryImages(Context paramContext, String paramString, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 278	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 279	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 474	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +30 -> 58
    //   31: iconst_1
    //   32: istore 4
    //   34: aload_0
    //   35: aload 7
    //   37: iconst_m1
    //   38: iload_2
    //   39: iload 4
    //   41: aload_3
    //   42: invokestatic 631	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 147 1 0
    //   55: aload 7
    //   57: areturn
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -27 -> 34
    //   64: astore_1
    //   65: aload 6
    //   67: astore_0
    //   68: aload_0
    //   69: astore 5
    //   71: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +17 -> 91
    //   77: aload_0
    //   78: astore 5
    //   80: ldc 17
    //   82: iconst_2
    //   83: aload_1
    //   84: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: aload_1
    //   88: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_0
    //   92: ifnull -37 -> 55
    //   95: aload_0
    //   96: invokeinterface 147 1 0
    //   101: aload 7
    //   103: areturn
    //   104: astore_1
    //   105: aload 5
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull +9 -> 118
    //   112: aload_0
    //   113: invokeinterface 147 1 0
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -13 -> 108
    //   124: astore_1
    //   125: goto -57 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramString	String
    //   0	128	2	paramInt	int
    //   0	128	3	paramMediaFileFilter	MediaFileFilter
    //   32	28	4	bool	boolean
    //   1	105	5	localContext	Context
    //   4	62	6	localObject	Object
    //   13	89	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	104	finally
    //   71	77	104	finally
    //   80	91	104	finally
    //   23	31	120	finally
    //   34	45	120	finally
    //   23	31	124	java/lang/Exception
    //   34	45	124	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryRecentImages(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, boolean paramBoolean1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 9
    //   5: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 17
    //   13: iconst_2
    //   14: new 184	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 634
    //   24: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 9
    //   29: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 12
    //   41: iload_2
    //   42: ifgt +14 -> 56
    //   45: new 448	java/lang/IllegalArgumentException
    //   48: dup
    //   49: ldc_w 636
    //   52: invokespecial 451	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: new 278	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 279	java/util/ArrayList:<init>	()V
    //   63: astore 13
    //   65: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   68: bipush 16
    //   70: if_icmplt +334 -> 404
    //   73: iconst_1
    //   74: istore 8
    //   76: iload 8
    //   78: ifeq +148 -> 226
    //   81: iload 4
    //   83: ifeq +135 -> 218
    //   86: ldc_w 638
    //   89: astore 11
    //   91: aload_0
    //   92: aload 11
    //   94: iconst_3
    //   95: anewarray 43	java/lang/String
    //   98: dup
    //   99: iconst_0
    //   100: iload 5
    //   102: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: iload_1
    //   109: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: iload_1
    //   116: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   119: aastore
    //   120: iload_2
    //   121: invokestatic 474	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   124: astore_0
    //   125: aload_0
    //   126: aload 13
    //   128: iload_1
    //   129: iload_2
    //   130: iload 8
    //   132: aload_3
    //   133: aload 6
    //   135: iload 7
    //   137: invokestatic 288	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   140: aload_0
    //   141: ifnull +9 -> 150
    //   144: aload_0
    //   145: invokeinterface 147 1 0
    //   150: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +62 -> 215
    //   156: new 184	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 640
    //   166: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   172: lload 9
    //   174: lsub
    //   175: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 642
    //   181: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: astore_3
    //   185: aload 13
    //   187: ifnull +187 -> 374
    //   190: aload 13
    //   192: invokeinterface 206 1 0
    //   197: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: astore_0
    //   201: ldc 17
    //   203: iconst_2
    //   204: aload_3
    //   205: aload_0
    //   206: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload 13
    //   217: areturn
    //   218: ldc_w 644
    //   221: astore 11
    //   223: goto -132 -> 91
    //   226: iload 5
    //   228: ifle +89 -> 317
    //   231: new 184	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 485
    //   241: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload 5
    //   246: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 646
    //   252: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 47
    //   257: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 11
    //   265: getstatic 494	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   268: invokevirtual 500	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   271: astore 14
    //   273: aload 14
    //   275: ldc_w 502
    //   278: iload_2
    //   279: bipush 6
    //   281: imul
    //   282: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 508	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   288: pop
    //   289: aload 14
    //   291: invokevirtual 512	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   294: astore 14
    //   296: aload_0
    //   297: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   300: aload 14
    //   302: getstatic 71	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:columns	[Ljava/lang/String;
    //   305: aload 11
    //   307: aconst_null
    //   308: ldc 11
    //   310: invokestatic 138	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   313: astore_0
    //   314: goto -189 -> 125
    //   317: ldc_w 648
    //   320: astore 11
    //   322: goto -57 -> 265
    //   325: astore_3
    //   326: aconst_null
    //   327: astore_0
    //   328: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +14 -> 345
    //   334: ldc 17
    //   336: iconst_2
    //   337: aload_3
    //   338: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   341: aload_3
    //   342: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   345: aload_0
    //   346: ifnull -196 -> 150
    //   349: aload_0
    //   350: invokeinterface 147 1 0
    //   355: goto -205 -> 150
    //   358: astore_0
    //   359: aload 12
    //   361: astore_3
    //   362: aload_3
    //   363: ifnull +9 -> 372
    //   366: aload_3
    //   367: invokeinterface 147 1 0
    //   372: aload_0
    //   373: athrow
    //   374: ldc 225
    //   376: astore_0
    //   377: goto -176 -> 201
    //   380: astore 6
    //   382: aload_0
    //   383: astore_3
    //   384: aload 6
    //   386: astore_0
    //   387: goto -25 -> 362
    //   390: astore 6
    //   392: aload_0
    //   393: astore_3
    //   394: aload 6
    //   396: astore_0
    //   397: goto -35 -> 362
    //   400: astore_3
    //   401: goto -73 -> 328
    //   404: iconst_0
    //   405: istore 8
    //   407: goto -331 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramContext	Context
    //   0	410	1	paramInt1	int
    //   0	410	2	paramInt2	int
    //   0	410	3	paramMediaFileFilter	MediaFileFilter
    //   0	410	4	paramBoolean1	boolean
    //   0	410	5	paramInt3	int
    //   0	410	6	paramArrayList	ArrayList<String>
    //   0	410	7	paramBoolean2	boolean
    //   74	332	8	bool	boolean
    //   3	170	9	l	long
    //   89	232	11	str	String
    //   39	321	12	localObject1	Object
    //   63	153	13	localArrayList	ArrayList
    //   271	30	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   91	125	325	java/lang/Exception
    //   231	265	325	java/lang/Exception
    //   265	314	325	java/lang/Exception
    //   91	125	358	finally
    //   231	265	358	finally
    //   265	314	358	finally
    //   125	140	380	finally
    //   328	345	390	finally
    //   125	140	400	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> queryRecentVideos(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 17
    //   13: iconst_2
    //   14: new 184	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 651
    //   24: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 6
    //   29: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 9
    //   41: iload_2
    //   42: ifgt +14 -> 56
    //   45: new 448	java/lang/IllegalArgumentException
    //   48: dup
    //   49: ldc_w 636
    //   52: invokespecial 451	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: new 278	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 279	java/util/ArrayList:<init>	()V
    //   63: astore 11
    //   65: getstatic 132	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   68: invokevirtual 500	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   71: astore 10
    //   73: aload 10
    //   75: ldc_w 502
    //   78: iload_2
    //   79: bipush 6
    //   81: imul
    //   82: invokestatic 471	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 508	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   88: pop
    //   89: aload 10
    //   91: invokevirtual 512	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   94: astore 10
    //   96: aload_0
    //   97: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: aload 10
    //   102: getstatic 63	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:VIDEO_COLUMNS	[Ljava/lang/String;
    //   105: ldc_w 648
    //   108: aconst_null
    //   109: ldc 11
    //   111: invokestatic 138	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore_0
    //   115: aload_0
    //   116: astore 9
    //   118: aload 9
    //   120: astore_0
    //   121: getstatic 41	android/os/Build$VERSION:SDK_INT	I
    //   124: bipush 16
    //   126: if_icmplt +188 -> 314
    //   129: iconst_1
    //   130: istore 8
    //   132: aload 9
    //   134: astore_0
    //   135: aload 9
    //   137: aload 11
    //   139: iload_2
    //   140: aload_3
    //   141: iload 8
    //   143: lload 4
    //   145: invokestatic 283	com/tencent/mobileqq/activity/photo/album/QAlbumBaseUtil:getVideoList	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;ZJ)Ljava/util/List;
    //   148: pop
    //   149: aload 9
    //   151: ifnull +10 -> 161
    //   154: aload 9
    //   156: invokeinterface 147 1 0
    //   161: invokestatic 526	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   164: invokestatic 532	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +212 -> 381
    //   172: aload_0
    //   173: iconst_1
    //   174: bipush 100
    //   176: invokevirtual 536	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +200 -> 381
    //   184: aload_0
    //   185: invokevirtual 323	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   188: astore_0
    //   189: aload_0
    //   190: invokeinterface 328 1 0
    //   195: ifeq +186 -> 381
    //   198: aload_0
    //   199: invokeinterface 332 1 0
    //   204: checkcast 538	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   207: astore 9
    //   209: new 231	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   212: dup
    //   213: invokespecial 367	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   216: astore 10
    //   218: aload 10
    //   220: aload 9
    //   222: getfield 541	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   225: i2l
    //   226: putfield 369	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   229: aload 10
    //   231: aload 9
    //   233: getfield 543	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   236: putfield 546	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   239: aload 10
    //   241: aload 9
    //   243: getfield 547	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   246: putfield 383	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   249: aload 10
    //   251: aload 9
    //   253: getfield 548	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   256: putfield 372	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   259: aload 10
    //   261: aload 9
    //   263: getfield 549	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   266: putfield 234	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   269: aload 10
    //   271: aload 9
    //   273: getfield 552	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   276: putfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   279: aload 10
    //   281: iconst_0
    //   282: putfield 555	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   285: aload_3
    //   286: ifnull +15 -> 301
    //   289: aload_3
    //   290: aload 9
    //   292: getfield 552	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   295: invokevirtual 339	com/tencent/mobileqq/activity/photo/MediaFileFilter:filter	(Ljava/lang/String;)Z
    //   298: ifne -109 -> 189
    //   301: aload 11
    //   303: aload 10
    //   305: invokeinterface 237 2 0
    //   310: pop
    //   311: goto -122 -> 189
    //   314: iconst_0
    //   315: istore 8
    //   317: goto -185 -> 132
    //   320: astore 10
    //   322: aconst_null
    //   323: astore 9
    //   325: aload 9
    //   327: astore_0
    //   328: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +19 -> 350
    //   334: aload 9
    //   336: astore_0
    //   337: ldc 17
    //   339: iconst_2
    //   340: aload 10
    //   342: invokevirtual 481	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   345: aload 10
    //   347: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   350: aload 9
    //   352: ifnull -191 -> 161
    //   355: aload 9
    //   357: invokeinterface 147 1 0
    //   362: goto -201 -> 161
    //   365: astore_0
    //   366: aload 9
    //   368: astore_3
    //   369: aload_3
    //   370: ifnull +9 -> 379
    //   373: aload_3
    //   374: invokeinterface 147 1 0
    //   379: aload_0
    //   380: athrow
    //   381: aload 11
    //   383: invokestatic 182	java/util/Collections:sort	(Ljava/util/List;)V
    //   386: new 278	java/util/ArrayList
    //   389: dup
    //   390: invokespecial 279	java/util/ArrayList:<init>	()V
    //   393: astore_3
    //   394: iload_2
    //   395: aload 11
    //   397: invokeinterface 206 1 0
    //   402: invokestatic 243	java/lang/Math:min	(II)I
    //   405: istore_2
    //   406: iconst_0
    //   407: istore_1
    //   408: iload_1
    //   409: iload_2
    //   410: if_icmpge +25 -> 435
    //   413: aload_3
    //   414: aload 11
    //   416: iload_1
    //   417: invokeinterface 229 2 0
    //   422: invokeinterface 237 2 0
    //   427: pop
    //   428: iload_1
    //   429: iconst_1
    //   430: iadd
    //   431: istore_1
    //   432: goto -24 -> 408
    //   435: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +62 -> 500
    //   441: new 184	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 653
    //   451: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokestatic 176	android/os/SystemClock:uptimeMillis	()J
    //   457: lload 6
    //   459: lsub
    //   460: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: ldc_w 655
    //   466: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: astore 9
    //   471: aload_3
    //   472: ifnull +30 -> 502
    //   475: aload_3
    //   476: invokeinterface 206 1 0
    //   481: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: astore_0
    //   485: ldc 17
    //   487: iconst_2
    //   488: aload 9
    //   490: aload_0
    //   491: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: aload_3
    //   501: areturn
    //   502: ldc 225
    //   504: astore_0
    //   505: goto -20 -> 485
    //   508: astore 9
    //   510: aload_0
    //   511: astore_3
    //   512: aload 9
    //   514: astore_0
    //   515: goto -146 -> 369
    //   518: astore 10
    //   520: goto -195 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramContext	Context
    //   0	523	1	paramInt1	int
    //   0	523	2	paramInt2	int
    //   0	523	3	paramMediaFileFilter	MediaFileFilter
    //   0	523	4	paramLong	long
    //   3	455	6	l	long
    //   130	186	8	bool	boolean
    //   39	450	9	localObject1	Object
    //   508	5	9	localObject2	Object
    //   71	233	10	localObject3	Object
    //   320	26	10	localException1	java.lang.Exception
    //   518	1	10	localException2	java.lang.Exception
    //   63	352	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   65	115	320	java/lang/Exception
    //   65	115	365	finally
    //   121	129	508	finally
    //   135	149	508	finally
    //   328	334	508	finally
    //   337	350	508	finally
    //   121	129	518	java/lang/Exception
    //   135	149	518	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil
 * JD-Core Version:    0.7.0.1
 */