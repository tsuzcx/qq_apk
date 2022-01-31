package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.photo.LocalPhotoInfo;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumUtil
{
  public static final int a = 170;
  public static final long a = 60000L;
  public static String a;
  public static SimpleDateFormat a;
  public static HashMap a;
  static List jdField_a_of_type_JavaUtilList;
  private static Map jdField_a_of_type_JavaUtilMap;
  public static final String[] a;
  public static final int b = 170;
  public static long b = 0L;
  public static String b;
  public static HashMap b;
  private static List jdField_b_of_type_JavaUtilList;
  static String[] jdField_b_of_type_ArrayOfJavaLangString = { "_id", "_data", "date_modified", "orientation", "_size" };
  public static int c = 0;
  private static long jdField_c_of_type_Long = 0L;
  public static String c;
  public static HashMap c;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  public static final int d = 20;
  public static final String d = "album_file";
  private static final String[] d;
  private static final int e = 65535;
  public static final String e = "album_key_id";
  private static final int f = 65535;
  public static final String f = "album_key_name";
  private static final String g = AlbumUtil.class.getSimpleName();
  private static final String h = "_id DESC";
  private static final String i = "_size>0) GROUP BY (1";
  private static final String j = "_id DESC";
  private static final String k = "_size>0";
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_data" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "_id", "orientation" };
    d = new String[] { "count( _data) as count" };
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat();
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Long = 0L;
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("yyyy-MM-dd:HH:mm:ss:SSS");
    if (Build.VERSION.SDK_INT >= 16)
    {
      jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "date_modified", "orientation", "_size", "width" };
      return;
    }
  }
  
  public static int a()
  {
    return jdField_c_of_type_Int;
  }
  
  public static int a(Context paramContext, Uri paramUri, String[] paramArrayOfString, String paramString)
  {
    return a(paramContext, paramUri, paramArrayOfString, paramString, null);
  }
  
  /* Error */
  public static int a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 135	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: aload 4
    //   9: aconst_null
    //   10: invokevirtual 141	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: invokeinterface 147 1 0
    //   22: ifeq +27 -> 49
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: iconst_0
    //   29: invokeinterface 151 2 0
    //   34: istore 5
    //   36: aload_1
    //   37: ifnull +9 -> 46
    //   40: aload_1
    //   41: invokeinterface 154 1 0
    //   46: iload 5
    //   48: ireturn
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_1
    //   54: invokeinterface 154 1 0
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +14 -> 83
    //   72: aload_1
    //   73: astore_0
    //   74: ldc 161
    //   76: iconst_2
    //   77: ldc 163
    //   79: aload_2
    //   80: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_1
    //   84: ifnull -25 -> 59
    //   87: aload_1
    //   88: invokeinterface 154 1 0
    //   93: goto -34 -> 59
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +9 -> 109
    //   103: aload_0
    //   104: invokeinterface 154 1 0
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: goto -13 -> 99
    //   115: astore_2
    //   116: goto -52 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	Context
    //   0	119	1	paramUri	Uri
    //   0	119	2	paramArrayOfString1	String[]
    //   0	119	3	paramString	String
    //   0	119	4	paramArrayOfString2	String[]
    //   34	13	5	m	int
    // Exception table:
    //   from	to	target	type
    //   0	14	61	java/lang/Throwable
    //   0	14	96	finally
    //   16	25	111	finally
    //   27	36	111	finally
    //   66	72	111	finally
    //   74	83	111	finally
    //   16	25	115	java/lang/Throwable
    //   27	36	115	java/lang/Throwable
  }
  
  public static long a()
  {
    return jdField_c_of_type_Long;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, jdField_b_of_type_ArrayOfJavaLangString, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  private static LocalPhotoInfo a(Cursor paramCursor, int paramInt)
  {
    LocalPhotoInfo localLocalPhotoInfo = new LocalPhotoInfo();
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("_id");
    int i1 = paramCursor.getColumnIndexOrThrow("date_modified");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int[] arrayOfInt = new int[2];
    for (;;)
    {
      String str;
      long l;
      if (paramCursor.moveToNext())
      {
        str = paramCursor.getString(m);
        l = paramCursor.getLong(n);
        if ((str == null) || (str.length() <= 0)) {
          continue;
        }
        File localFile = new File(str);
        if ((!localFile.exists()) || (!localFile.isFile())) {
          break label207;
        }
        if (paramInt <= 0) {
          break label177;
        }
        a(str, localOptions, arrayOfInt);
        if ((arrayOfInt[0] >= paramInt) || (arrayOfInt[1] >= paramInt))
        {
          localLocalPhotoInfo.jdField_c_of_type_Long = l;
          localLocalPhotoInfo.jdField_a_of_type_JavaLangString = str;
          localLocalPhotoInfo.jdField_b_of_type_Long = paramCursor.getLong(i1);
        }
      }
      return localLocalPhotoInfo;
      label177:
      localLocalPhotoInfo.jdField_c_of_type_Long = l;
      localLocalPhotoInfo.jdField_a_of_type_JavaLangString = str;
      localLocalPhotoInfo.jdField_b_of_type_Long = paramCursor.getLong(i1);
      return localLocalPhotoInfo;
      label207:
      if (QLog.isColorLevel()) {
        QLog.d(g, 2, "image does not exist,imagePath is:" + str);
      }
    }
  }
  
  public static QQAlbumInfo a()
  {
    if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
    {
      QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
      localQQAlbumInfo._id = "$RecentAlbumId";
      localQQAlbumInfo.name = BaseApplicationImpl.getContext().getString(2131561293);
      localQQAlbumInfo.cover = ((LocalPhotoInfo)jdField_a_of_type_JavaUtilList.get(0));
      localQQAlbumInfo.imageCount = jdField_a_of_type_JavaUtilList.size();
      return localQQAlbumInfo;
    }
    return null;
  }
  
  /* Error */
  public static QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iload_2
    //   10: ifgt +14 -> 24
    //   13: new 295	java/lang/IllegalArgumentException
    //   16: dup
    //   17: ldc_w 297
    //   20: invokespecial 298	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: new 263	com/tencent/mobileqq/data/QQAlbumInfo
    //   27: dup
    //   28: invokespecial 264	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   31: astore 9
    //   33: aload 9
    //   35: ldc_w 266
    //   38: putfield 268	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   41: aload 9
    //   43: invokestatic 274	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   46: ldc_w 275
    //   49: invokevirtual 276	android/content/Context:getString	(I)Ljava/lang/String;
    //   52: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   55: aload 9
    //   57: new 201	com/tencent/mobileqq/activity/photo/LocalPhotoInfo
    //   60: dup
    //   61: invokespecial 202	com/tencent/mobileqq/activity/photo/LocalPhotoInfo:<init>	()V
    //   64: putfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   67: iconst_0
    //   68: istore 5
    //   70: getstatic 114	android/os/Build$VERSION:SDK_INT	I
    //   73: bipush 16
    //   75: if_icmplt +6 -> 81
    //   78: iconst_1
    //   79: istore 5
    //   81: iload 5
    //   83: ifeq +193 -> 276
    //   86: aload_0
    //   87: ldc_w 300
    //   90: iconst_3
    //   91: anewarray 55	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: iconst_0
    //   97: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: iload_1
    //   104: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: iload_1
    //   111: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   114: aastore
    //   115: iload_2
    //   116: invokestatic 302	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   119: astore_0
    //   120: aload_0
    //   121: invokeinterface 305 1 0
    //   126: istore 4
    //   128: new 307	java/util/ArrayList
    //   131: dup
    //   132: invokespecial 308	java/util/ArrayList:<init>	()V
    //   135: astore 6
    //   137: iload_3
    //   138: ifne +23 -> 161
    //   141: aload_0
    //   142: aload 6
    //   144: iload_1
    //   145: iload_3
    //   146: iload_2
    //   147: iload 5
    //   149: invokestatic 311	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IZIZ)V
    //   152: aload 6
    //   154: invokeinterface 261 1 0
    //   159: istore 4
    //   161: aload 9
    //   163: iload 4
    //   165: putfield 290	com/tencent/mobileqq/data/QQAlbumInfo:imageCount	I
    //   168: iload 4
    //   170: ifle +23 -> 193
    //   173: iload_3
    //   174: ifne +39 -> 213
    //   177: aload 9
    //   179: aload 6
    //   181: iconst_0
    //   182: invokeinterface 283 2 0
    //   187: checkcast 201	com/tencent/mobileqq/activity/photo/LocalPhotoInfo
    //   190: putfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   193: aload 9
    //   195: iload 4
    //   197: putfield 290	com/tencent/mobileqq/data/QQAlbumInfo:imageCount	I
    //   200: aload_0
    //   201: ifnull +9 -> 210
    //   204: aload_0
    //   205: invokeinterface 154 1 0
    //   210: aload 9
    //   212: areturn
    //   213: aload 9
    //   215: aload_0
    //   216: iconst_m1
    //   217: invokestatic 313	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;I)Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   220: putfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   223: goto -30 -> 193
    //   226: astore 6
    //   228: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +17 -> 248
    //   234: getstatic 53	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   237: iconst_2
    //   238: aload 6
    //   240: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: aload 6
    //   245: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_0
    //   249: ifnull -39 -> 210
    //   252: aload_0
    //   253: invokeinterface 154 1 0
    //   258: aload 9
    //   260: areturn
    //   261: astore_0
    //   262: aload 6
    //   264: ifnull +10 -> 274
    //   267: aload 6
    //   269: invokeinterface 154 1 0
    //   274: aload_0
    //   275: athrow
    //   276: iload_2
    //   277: bipush 6
    //   279: imul
    //   280: istore 4
    //   282: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +30 -> 315
    //   288: ldc 161
    //   290: iconst_2
    //   291: new 240	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 320
    //   301: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: iload 4
    //   306: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 253	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: new 208	android/graphics/BitmapFactory$Options
    //   318: dup
    //   319: invokespecial 209	android/graphics/BitmapFactory$Options:<init>	()V
    //   322: iconst_1
    //   323: putfield 327	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   326: new 307	java/util/ArrayList
    //   329: dup
    //   330: invokespecial 308	java/util/ArrayList:<init>	()V
    //   333: astore 10
    //   335: aload 8
    //   337: astore 6
    //   339: getstatic 176	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   342: invokevirtual 182	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   345: astore 11
    //   347: aload 8
    //   349: astore 6
    //   351: aload 11
    //   353: ldc 184
    //   355: iload 4
    //   357: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   360: invokevirtual 194	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   363: pop
    //   364: aload 8
    //   366: astore 6
    //   368: aload 11
    //   370: invokevirtual 198	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   373: astore 11
    //   375: aload 8
    //   377: astore 6
    //   379: aload_0
    //   380: invokevirtual 135	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   383: aload 11
    //   385: getstatic 120	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   388: ldc_w 329
    //   391: aconst_null
    //   392: ldc 36
    //   394: invokevirtual 141	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   397: astore_0
    //   398: aload_0
    //   399: aload 10
    //   401: iload_1
    //   402: iload_3
    //   403: iload_2
    //   404: iload 5
    //   406: invokestatic 311	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IZIZ)V
    //   409: aload 9
    //   411: aload 10
    //   413: invokeinterface 261 1 0
    //   418: putfield 290	com/tencent/mobileqq/data/QQAlbumInfo:imageCount	I
    //   421: aload 10
    //   423: invokeinterface 261 1 0
    //   428: ifle +33 -> 461
    //   431: aload 10
    //   433: iconst_0
    //   434: invokeinterface 283 2 0
    //   439: checkcast 201	com/tencent/mobileqq/activity/photo/LocalPhotoInfo
    //   442: astore 6
    //   444: aload 9
    //   446: aload 6
    //   448: putfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   451: aload 9
    //   453: aload 6
    //   455: getfield 238	com/tencent/mobileqq/activity/photo/LocalPhotoInfo:jdField_b_of_type_Long	J
    //   458: putfield 332	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   461: aload_0
    //   462: ifnull -252 -> 210
    //   465: aload_0
    //   466: invokeinterface 154 1 0
    //   471: aload 9
    //   473: areturn
    //   474: astore 6
    //   476: aload 7
    //   478: astore_0
    //   479: aload 6
    //   481: astore 7
    //   483: aload_0
    //   484: astore 6
    //   486: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +20 -> 509
    //   492: aload_0
    //   493: astore 6
    //   495: getstatic 53	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   498: iconst_2
    //   499: aload 7
    //   501: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   504: aload 7
    //   506: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   509: aload_0
    //   510: ifnull -300 -> 210
    //   513: aload_0
    //   514: invokeinterface 154 1 0
    //   519: aload 9
    //   521: areturn
    //   522: astore 7
    //   524: aload 6
    //   526: astore_0
    //   527: aload 7
    //   529: astore 6
    //   531: aload_0
    //   532: ifnull +9 -> 541
    //   535: aload_0
    //   536: invokeinterface 154 1 0
    //   541: aload 6
    //   543: athrow
    //   544: astore 6
    //   546: goto -15 -> 531
    //   549: astore 7
    //   551: goto -68 -> 483
    //   554: astore 7
    //   556: aload_0
    //   557: astore 6
    //   559: aload 7
    //   561: astore_0
    //   562: goto -300 -> 262
    //   565: astore 7
    //   567: aload_0
    //   568: astore 6
    //   570: aload 7
    //   572: astore_0
    //   573: goto -311 -> 262
    //   576: astore 6
    //   578: aconst_null
    //   579: astore_0
    //   580: goto -352 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	paramContext	Context
    //   0	583	1	paramInt1	int
    //   0	583	2	paramInt2	int
    //   0	583	3	paramBoolean	boolean
    //   126	230	4	m	int
    //   68	337	5	bool	boolean
    //   7	173	6	localArrayList1	java.util.ArrayList
    //   226	42	6	localException1	Exception
    //   337	117	6	localObject1	Object
    //   474	6	6	localException2	Exception
    //   484	58	6	localObject2	Object
    //   544	1	6	localObject3	Object
    //   557	12	6	localContext	Context
    //   576	1	6	localException3	Exception
    //   1	504	7	localObject4	Object
    //   522	6	7	localObject5	Object
    //   549	1	7	localException4	Exception
    //   554	6	7	localObject6	Object
    //   565	6	7	localObject7	Object
    //   4	372	8	localObject8	Object
    //   31	489	9	localQQAlbumInfo	QQAlbumInfo
    //   333	99	10	localArrayList2	java.util.ArrayList
    //   345	39	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   120	137	226	java/lang/Exception
    //   141	161	226	java/lang/Exception
    //   161	168	226	java/lang/Exception
    //   177	193	226	java/lang/Exception
    //   193	200	226	java/lang/Exception
    //   213	223	226	java/lang/Exception
    //   86	120	261	finally
    //   339	347	474	java/lang/Exception
    //   351	364	474	java/lang/Exception
    //   368	375	474	java/lang/Exception
    //   379	398	474	java/lang/Exception
    //   339	347	522	finally
    //   351	364	522	finally
    //   368	375	522	finally
    //   379	398	522	finally
    //   486	492	522	finally
    //   495	509	522	finally
    //   398	461	544	finally
    //   398	461	549	java/lang/Exception
    //   120	137	554	finally
    //   141	161	554	finally
    //   161	168	554	finally
    //   177	193	554	finally
    //   193	200	554	finally
    //   213	223	554	finally
    //   228	248	565	finally
    //   86	120	576	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static URL a(LocalPhotoInfo paramLocalPhotoInfo, int paramInt)
  {
    paramLocalPhotoInfo.f = paramInt;
    paramLocalPhotoInfo.g = paramInt;
    paramLocalPhotoInfo = LocalPhotoInfo.a(paramLocalPhotoInfo);
    try
    {
      paramLocalPhotoInfo = new URL("albumthumb", "", paramLocalPhotoInfo);
      return paramLocalPhotoInfo;
    }
    catch (MalformedURLException paramLocalPhotoInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramLocalPhotoInfo.getMessage(), paramLocalPhotoInfo);
      }
    }
    return null;
  }
  
  public static URL a(String paramString)
  {
    Object localObject1 = new File(paramString);
    do
    {
      try
      {
        localObject1 = ((File)localObject1).toURL();
        String str;
        Object localObject2 = localObject1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          str = ((URL)localObject1).toString();
          localObject2 = new URL(str + "?thumb=true");
          return localObject2;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          continue;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localObject1 = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SelectPhotoTrace", 2, "path is:" + paramString + ",path->url failed", localMalformedURLException1);
    return localObject1;
  }
  
  public static List a()
  {
    return jdField_b_of_type_JavaUtilList;
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: iload_2
    //   7: ifgt +14 -> 21
    //   10: new 295	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 297
    //   17: invokespecial 298	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 307	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 308	java/util/ArrayList:<init>	()V
    //   28: astore 9
    //   30: iconst_0
    //   31: istore 4
    //   33: getstatic 114	android/os/Build$VERSION:SDK_INT	I
    //   36: bipush 16
    //   38: if_icmplt +6 -> 44
    //   41: iconst_1
    //   42: istore 4
    //   44: iload 4
    //   46: ifeq +86 -> 132
    //   49: aload 7
    //   51: astore 6
    //   53: aload 8
    //   55: astore 5
    //   57: aload_0
    //   58: ldc_w 379
    //   61: iconst_3
    //   62: anewarray 55	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: iconst_0
    //   68: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: iload_1
    //   75: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: iload_1
    //   82: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: aastore
    //   86: iload_2
    //   87: invokestatic 302	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   90: astore_0
    //   91: aload_0
    //   92: astore 5
    //   94: aload_0
    //   95: astore 6
    //   97: aload_0
    //   98: aload 9
    //   100: iload_1
    //   101: iload_3
    //   102: iload_2
    //   103: iload 4
    //   105: invokestatic 311	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IZIZ)V
    //   108: aload_0
    //   109: astore 6
    //   111: aload_0
    //   112: astore 5
    //   114: aload 9
    //   116: putstatic 256	com/tencent/mobileqq/utils/AlbumUtil:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   119: aload_0
    //   120: ifnull +9 -> 129
    //   123: aload_0
    //   124: invokeinterface 154 1 0
    //   129: aload 9
    //   131: areturn
    //   132: aload 7
    //   134: astore 6
    //   136: aload 8
    //   138: astore 5
    //   140: getstatic 176	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   143: invokevirtual 182	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   146: astore 10
    //   148: aload 7
    //   150: astore 6
    //   152: aload 8
    //   154: astore 5
    //   156: aload 10
    //   158: ldc 184
    //   160: iload_2
    //   161: bipush 6
    //   163: imul
    //   164: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   167: invokevirtual 194	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   170: pop
    //   171: aload 7
    //   173: astore 6
    //   175: aload 8
    //   177: astore 5
    //   179: aload 10
    //   181: invokevirtual 198	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   184: astore 10
    //   186: aload 7
    //   188: astore 6
    //   190: aload 8
    //   192: astore 5
    //   194: aload_0
    //   195: invokevirtual 135	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   198: aload 10
    //   200: getstatic 120	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   203: ldc_w 381
    //   206: aconst_null
    //   207: ldc 36
    //   209: invokevirtual 141	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   212: astore_0
    //   213: aload_0
    //   214: astore 5
    //   216: aload_0
    //   217: astore 6
    //   219: aload_0
    //   220: aload 9
    //   222: iload_1
    //   223: iload_3
    //   224: iload_2
    //   225: iload 4
    //   227: invokestatic 311	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IZIZ)V
    //   230: goto -122 -> 108
    //   233: astore_0
    //   234: aload 6
    //   236: astore 5
    //   238: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +19 -> 260
    //   244: aload 6
    //   246: astore 5
    //   248: getstatic 53	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   251: iconst_2
    //   252: aload_0
    //   253: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   256: aload_0
    //   257: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload 6
    //   262: ifnull -133 -> 129
    //   265: aload 6
    //   267: invokeinterface 154 1 0
    //   272: aload 9
    //   274: areturn
    //   275: astore_0
    //   276: aload 5
    //   278: ifnull +10 -> 288
    //   281: aload 5
    //   283: invokeinterface 154 1 0
    //   288: aload_0
    //   289: athrow
    //   290: astore_0
    //   291: goto -15 -> 276
    //   294: astore_0
    //   295: goto -61 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramContext	Context
    //   0	298	1	paramInt1	int
    //   0	298	2	paramInt2	int
    //   0	298	3	paramBoolean	boolean
    //   31	195	4	bool	boolean
    //   55	227	5	localObject1	Object
    //   51	215	6	localObject2	Object
    //   4	183	7	localObject3	Object
    //   1	190	8	localObject4	Object
    //   28	245	9	localArrayList	java.util.ArrayList
    //   146	53	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   57	91	233	java/lang/Exception
    //   114	119	233	java/lang/Exception
    //   140	148	233	java/lang/Exception
    //   156	171	233	java/lang/Exception
    //   179	186	233	java/lang/Exception
    //   194	213	233	java/lang/Exception
    //   57	91	275	finally
    //   114	119	275	finally
    //   140	148	275	finally
    //   156	171	275	finally
    //   179	186	275	finally
    //   194	213	275	finally
    //   238	244	275	finally
    //   248	260	275	finally
    //   97	108	290	finally
    //   219	230	290	finally
    //   97	108	294	java/lang/Exception
    //   219	230	294	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 307	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 308	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: invokevirtual 135	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 176	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: getstatic 73	com/tencent/mobileqq/utils/AlbumUtil:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   19: ldc 39
    //   21: aconst_null
    //   22: ldc 36
    //   24: invokevirtual 141	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 9
    //   29: aload 9
    //   31: ifnull +535 -> 566
    //   34: aload 9
    //   36: astore 8
    //   38: aload 9
    //   40: invokeinterface 212 1 0
    //   45: ifeq +385 -> 430
    //   48: aload 9
    //   50: astore 8
    //   52: aload 9
    //   54: aload 9
    //   56: ldc 61
    //   58: invokeinterface 385 2 0
    //   63: invokeinterface 215 2 0
    //   68: astore 12
    //   70: aload 9
    //   72: astore 8
    //   74: aload 9
    //   76: aload 9
    //   78: ldc 63
    //   80: invokeinterface 385 2 0
    //   85: invokeinterface 215 2 0
    //   90: astore 13
    //   92: aload 9
    //   94: astore 8
    //   96: aload 12
    //   98: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne -67 -> 34
    //   104: aload 9
    //   106: astore 8
    //   108: aload 13
    //   110: invokestatic 391	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne -79 -> 34
    //   116: aload 9
    //   118: astore 8
    //   120: new 263	com/tencent/mobileqq/data/QQAlbumInfo
    //   123: dup
    //   124: invokespecial 264	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   127: astore 11
    //   129: aload 9
    //   131: astore 8
    //   133: aload 11
    //   135: aload 13
    //   137: putfield 279	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   140: aload 9
    //   142: astore 8
    //   144: aload 11
    //   146: aload 12
    //   148: putfield 268	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   151: aload 9
    //   153: astore 8
    //   155: aload 10
    //   157: aload 11
    //   159: invokevirtual 395	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   162: ifne -128 -> 34
    //   165: aload 9
    //   167: astore 8
    //   169: aload 9
    //   171: aload 9
    //   173: ldc 57
    //   175: invokeinterface 385 2 0
    //   180: invokeinterface 215 2 0
    //   185: astore 12
    //   187: iload_2
    //   188: ifne +24 -> 212
    //   191: aload 9
    //   193: astore 8
    //   195: new 224	java/io/File
    //   198: dup
    //   199: aload 12
    //   201: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: invokestatic 401	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   207: istore_3
    //   208: iload_3
    //   209: ifne -175 -> 34
    //   212: aload 9
    //   214: astore 8
    //   216: aload 9
    //   218: aload 9
    //   220: ldc 67
    //   222: invokeinterface 385 2 0
    //   227: invokeinterface 219 2 0
    //   232: lstore 4
    //   234: aload 9
    //   236: astore 8
    //   238: aload 9
    //   240: aload 9
    //   242: ldc 69
    //   244: invokeinterface 385 2 0
    //   249: invokeinterface 219 2 0
    //   254: lstore 6
    //   256: aload 9
    //   258: astore 8
    //   260: aload 11
    //   262: new 201	com/tencent/mobileqq/activity/photo/LocalPhotoInfo
    //   265: dup
    //   266: invokespecial 202	com/tencent/mobileqq/activity/photo/LocalPhotoInfo:<init>	()V
    //   269: putfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   272: aload 9
    //   274: astore 8
    //   276: aload 11
    //   278: lload 4
    //   280: putfield 332	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   283: aload 9
    //   285: astore 8
    //   287: aload 11
    //   289: getfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   292: aload 12
    //   294: putfield 237	com/tencent/mobileqq/activity/photo/LocalPhotoInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: aload 9
    //   299: astore 8
    //   301: aload 11
    //   303: getfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   306: lload 6
    //   308: putfield 236	com/tencent/mobileqq/activity/photo/LocalPhotoInfo:jdField_c_of_type_Long	J
    //   311: aload 9
    //   313: astore 8
    //   315: aload 11
    //   317: getfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   320: lload 4
    //   322: putfield 238	com/tencent/mobileqq/activity/photo/LocalPhotoInfo:jdField_b_of_type_Long	J
    //   325: aload 9
    //   327: astore 8
    //   329: getstatic 169	com/tencent/mobileqq/utils/AlbumUtil:jdField_c_of_type_Long	J
    //   332: lload 4
    //   334: lcmp
    //   335: ifge +12 -> 347
    //   338: aload 9
    //   340: astore 8
    //   342: lload 4
    //   344: putstatic 169	com/tencent/mobileqq/utils/AlbumUtil:jdField_c_of_type_Long	J
    //   347: aload 9
    //   349: astore 8
    //   351: aload 11
    //   353: getfield 287	com/tencent/mobileqq/data/QQAlbumInfo:cover	Lcom/tencent/mobileqq/activity/photo/LocalPhotoInfo;
    //   356: aload 9
    //   358: aload 9
    //   360: ldc 71
    //   362: invokeinterface 385 2 0
    //   367: invokeinterface 151 2 0
    //   372: putfield 403	com/tencent/mobileqq/activity/photo/LocalPhotoInfo:d	I
    //   375: aload 9
    //   377: astore 8
    //   379: aload 10
    //   381: aload 11
    //   383: invokevirtual 406	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   386: pop
    //   387: goto -353 -> 34
    //   390: astore_0
    //   391: aload 9
    //   393: astore 8
    //   395: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +17 -> 415
    //   401: aload 9
    //   403: astore 8
    //   405: ldc 161
    //   407: iconst_2
    //   408: ldc_w 408
    //   411: aload_0
    //   412: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   415: aload 9
    //   417: ifnull +10 -> 427
    //   420: aload 9
    //   422: invokeinterface 154 1 0
    //   427: aload 10
    //   429: areturn
    //   430: aload 9
    //   432: astore 8
    //   434: aload 10
    //   436: putstatic 376	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   439: aload 9
    //   441: astore 8
    //   443: aload 10
    //   445: invokevirtual 412	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   448: astore 11
    //   450: aload 9
    //   452: astore 8
    //   454: aload 11
    //   456: invokeinterface 417 1 0
    //   461: ifeq +105 -> 566
    //   464: aload 9
    //   466: astore 8
    //   468: aload 11
    //   470: invokeinterface 421 1 0
    //   475: checkcast 263	com/tencent/mobileqq/data/QQAlbumInfo
    //   478: astore 12
    //   480: aload 9
    //   482: astore 8
    //   484: new 240	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 423
    //   494: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 12
    //   499: getfield 268	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   502: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 425
    //   508: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: ldc_w 427
    //   514: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc 43
    //   519: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: astore 13
    //   527: aload 9
    //   529: astore 8
    //   531: aload 12
    //   533: aload_0
    //   534: getstatic 176	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   537: getstatic 77	com/tencent/mobileqq/utils/AlbumUtil:d	[Ljava/lang/String;
    //   540: aload 13
    //   542: invokestatic 429	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;)I
    //   545: putfield 290	com/tencent/mobileqq/data/QQAlbumInfo:imageCount	I
    //   548: goto -98 -> 450
    //   551: astore_0
    //   552: aload 8
    //   554: ifnull +10 -> 564
    //   557: aload 8
    //   559: invokeinterface 154 1 0
    //   564: aload_0
    //   565: athrow
    //   566: aload 9
    //   568: ifnull -141 -> 427
    //   571: aload 9
    //   573: invokeinterface 154 1 0
    //   578: aload 10
    //   580: areturn
    //   581: astore_0
    //   582: aconst_null
    //   583: astore 8
    //   585: goto -33 -> 552
    //   588: astore_0
    //   589: aconst_null
    //   590: astore 9
    //   592: goto -201 -> 391
    //   595: astore 8
    //   597: goto -385 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	paramContext	Context
    //   0	600	1	paramInt	int
    //   0	600	2	paramBoolean	boolean
    //   207	2	3	bool	boolean
    //   232	111	4	l1	long
    //   254	53	6	l2	long
    //   36	548	8	localCursor1	Cursor
    //   595	1	8	localException	Exception
    //   27	564	9	localCursor2	Cursor
    //   7	572	10	localArrayList	java.util.ArrayList
    //   127	342	11	localObject1	Object
    //   68	464	12	localObject2	Object
    //   90	451	13	str	String
    // Exception table:
    //   from	to	target	type
    //   38	48	390	java/lang/Exception
    //   52	70	390	java/lang/Exception
    //   74	92	390	java/lang/Exception
    //   96	104	390	java/lang/Exception
    //   108	116	390	java/lang/Exception
    //   120	129	390	java/lang/Exception
    //   133	140	390	java/lang/Exception
    //   144	151	390	java/lang/Exception
    //   155	165	390	java/lang/Exception
    //   169	187	390	java/lang/Exception
    //   216	234	390	java/lang/Exception
    //   238	256	390	java/lang/Exception
    //   260	272	390	java/lang/Exception
    //   276	283	390	java/lang/Exception
    //   287	297	390	java/lang/Exception
    //   301	311	390	java/lang/Exception
    //   315	325	390	java/lang/Exception
    //   329	338	390	java/lang/Exception
    //   342	347	390	java/lang/Exception
    //   351	375	390	java/lang/Exception
    //   379	387	390	java/lang/Exception
    //   434	439	390	java/lang/Exception
    //   443	450	390	java/lang/Exception
    //   454	464	390	java/lang/Exception
    //   468	480	390	java/lang/Exception
    //   484	527	390	java/lang/Exception
    //   531	548	390	java/lang/Exception
    //   38	48	551	finally
    //   52	70	551	finally
    //   74	92	551	finally
    //   96	104	551	finally
    //   108	116	551	finally
    //   120	129	551	finally
    //   133	140	551	finally
    //   144	151	551	finally
    //   155	165	551	finally
    //   169	187	551	finally
    //   195	208	551	finally
    //   216	234	551	finally
    //   238	256	551	finally
    //   260	272	551	finally
    //   276	283	551	finally
    //   287	297	551	finally
    //   301	311	551	finally
    //   315	325	551	finally
    //   329	338	551	finally
    //   342	347	551	finally
    //   351	375	551	finally
    //   379	387	551	finally
    //   395	401	551	finally
    //   405	415	551	finally
    //   434	439	551	finally
    //   443	450	551	finally
    //   454	464	551	finally
    //   468	480	551	finally
    //   484	527	551	finally
    //   531	548	551	finally
    //   9	29	581	finally
    //   9	29	588	java/lang/Exception
    //   195	208	595	java/lang/Exception
  }
  
  /* Error */
  public static List a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 307	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 308	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 302	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 114	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +30 -> 58
    //   31: iconst_1
    //   32: istore 4
    //   34: aload_0
    //   35: aload 7
    //   37: iconst_m1
    //   38: iload_3
    //   39: iload_2
    //   40: iload 4
    //   42: invokestatic 311	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IZIZ)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 154 1 0
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
    //   71: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +18 -> 92
    //   77: aload_0
    //   78: astore 5
    //   80: getstatic 53	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   83: iconst_2
    //   84: aload_1
    //   85: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: aload_1
    //   89: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: ifnull -38 -> 55
    //   96: aload_0
    //   97: invokeinterface 154 1 0
    //   102: aload 7
    //   104: areturn
    //   105: astore_1
    //   106: aload 5
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +9 -> 119
    //   113: aload_0
    //   114: invokeinterface 154 1 0
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -13 -> 109
    //   125: astore_1
    //   126: goto -58 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramString	String
    //   0	129	2	paramInt	int
    //   0	129	3	paramBoolean	boolean
    //   32	28	4	bool	boolean
    //   1	106	5	localContext	Context
    //   4	62	6	localObject	Object
    //   13	90	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	105	finally
    //   71	77	105	finally
    //   80	92	105	finally
    //   23	31	121	finally
    //   34	45	121	finally
    //   23	31	125	java/lang/Exception
    //   34	45	125	java/lang/Exception
  }
  
  public static void a()
  {
    jdField_b_of_type_JavaUtilList = null;
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968596, 2130968597);
  }
  
  public static void a(Activity paramActivity, Class paramClass, Intent paramIntent)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    a(paramActivity, true, false);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a(paramActivity);
        return;
      }
      b(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      c(paramActivity);
      return;
    }
    d(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("album_file", 0).edit();
    paramContext.putString("album_key_id", jdField_b_of_type_JavaLangString);
    paramContext.putString("album_key_name", jdField_c_of_type_JavaLangString);
    paramContext.commit();
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false))
    {
      String str = paramIntent.getStringExtra("ALBUM_ID");
      paramIntent = paramIntent.getStringExtra("PhotoConst.LAST_ALBUMPATH");
      if ((paramIntent != null) && (str != null))
      {
        jdField_a_of_type_JavaLangString = paramIntent;
        jdField_b_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  private static void a(Cursor paramCursor, List paramList, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int i4;
    int i5;
    int i6;
    int i1;
    BitmapFactory.Options localOptions;
    int[] arrayOfInt;
    int i2;
    int n;
    if (paramCursor.getCount() > 0)
    {
      i4 = paramCursor.getColumnIndexOrThrow("_data");
      i5 = paramCursor.getColumnIndexOrThrow("orientation");
      i6 = paramCursor.getColumnIndexOrThrow("date_modified");
      i1 = 0;
      if (paramBoolean2) {
        i1 = paramCursor.getColumnIndexOrThrow("width");
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      arrayOfInt = new int[2];
      i2 = 0;
      n = 0;
    }
    for (;;)
    {
      String str;
      long l;
      int i3;
      if (paramCursor.moveToNext())
      {
        str = paramCursor.getString(i4);
        l = paramCursor.getLong(i6);
        if (jdField_c_of_type_Long < l) {
          jdField_c_of_type_Long = l;
        }
        i3 = n;
        if (paramBoolean2)
        {
          i3 = n;
          if (paramCursor.getInt(i1) == 0) {
            i3 = 1;
          }
        }
        if ((paramInt2 <= 0) || (i2 < paramInt2)) {}
      }
      else
      {
        return;
      }
      int m = i2;
      if (str == null) {
        break label315;
      }
      n = i3;
      if (new File(str).exists())
      {
        if ((paramInt1 <= 0) || ((paramBoolean2) && (i3 == 0))) {
          break label325;
        }
        a(str, localOptions, arrayOfInt);
        if (arrayOfInt[0] < paramInt1)
        {
          m = i2;
          if (arrayOfInt[1] < paramInt1) {
            break label315;
          }
        }
        if (paramBoolean1) {}
      }
      try
      {
        bool = GifDrawable.isGifFile(new File(str));
        n = i3;
        if (bool) {}
      }
      catch (Exception localException2)
      {
        boolean bool;
        label264:
        LocalPhotoInfo localLocalPhotoInfo;
        break label264;
      }
    }
    localLocalPhotoInfo = new LocalPhotoInfo();
    localLocalPhotoInfo.jdField_a_of_type_JavaLangString = str;
    localLocalPhotoInfo.jdField_b_of_type_Long = l;
    localLocalPhotoInfo.d = paramCursor.getInt(i5);
    paramList.add(localLocalPhotoInfo);
    for (m = i2 + 1;; m = i2 + 1)
    {
      for (;;)
      {
        label315:
        n = 0;
        i2 = m;
        break;
        label325:
        if (!paramBoolean1) {}
        try
        {
          bool = GifDrawable.isGifFile(new File(str));
          n = i3;
          if (bool) {
            break;
          }
        }
        catch (Exception localException1)
        {
          label352:
          break label352;
        }
      }
      localLocalPhotoInfo = new LocalPhotoInfo();
      localLocalPhotoInfo.jdField_a_of_type_JavaLangString = str;
      localLocalPhotoInfo.jdField_b_of_type_Long = paramCursor.getLong(i6);
      localLocalPhotoInfo.d = paramCursor.getInt(i5);
      paramList.add(localLocalPhotoInfo);
    }
  }
  
  private static void a(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    int i1;
    int i2;
    int m;
    int n;
    if (localInteger == null)
    {
      BitmapFactory.decodeFile(paramString, paramOptions);
      i1 = paramOptions.outWidth;
      i2 = paramOptions.outHeight;
      m = i2;
      n = i1;
      if (paramOptions.outWidth <= 65535)
      {
        if (paramOptions.outHeight <= 65535) {
          break label79;
        }
        n = i1;
        m = i2;
      }
    }
    for (;;)
    {
      paramArrayOfInt[0] = n;
      paramArrayOfInt[1] = m;
      return;
      label79:
      m = paramOptions.outWidth;
      n = paramOptions.outHeight;
      jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(m << 16 & 0xFFFF0000 | n & 0xFFFF));
      m = i2;
      n = i1;
      continue;
      n = localInteger.intValue() >> 16 & 0xFFFF;
      m = localInteger.intValue() & 0xFFFF;
    }
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_Long = 0L;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
  }
  
  private static void b(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968593, 2130968594);
  }
  
  public static void c()
  {
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  private static void c(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968591, 2130968592);
  }
  
  private static void d(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968589, 2130968590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */