package wifiphoto;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.dataline.util.file.FileUtil;
import com.tencent.open.base.MD5Utils;
import idl;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WifiPhotoDataCenter
{
  public static final String[] a;
  private static final String jdField_b_of_type_JavaLangString = "date_modified DESC";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  private static final String jdField_c_of_type_JavaLangString = "_size>0) GROUP BY (1";
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  private static final String d = "MAX(date_modified) DESC";
  private static final String e = "_size>0";
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public final String a;
  private Comparator jdField_a_of_type_JavaUtilComparator = new idl(this);
  public Map a;
  public WifiPhotoMsgStrategy a;
  public WifiPhotoStatusMgr a;
  public boolean a;
  public Map b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "date_modified", "datetaken", "_data", "_display_name", "bucket_id", "_size" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "bucket_id", "_id", "bucket_display_name", "date_modified", "_data" };
    c = new String[] { "DISTINCT _data" };
  }
  
  public WifiPhotoDataCenter(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = a(16);
    this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr = new WifiPhotoStatusMgr();
    this.jdField_a_of_type_WifiphotoWifiPhotoMsgStrategy = new WifiPhotoMsgStrategy();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
    //   1: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: aload 4
    //   9: aconst_null
    //   10: invokevirtual 111	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: invokeinterface 117 1 0
    //   22: istore 5
    //   24: aload_1
    //   25: ifnull +9 -> 34
    //   28: aload_1
    //   29: invokeinterface 120 1 0
    //   34: iload 5
    //   36: ireturn
    //   37: astore_2
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 123	java/lang/Throwable:printStackTrace	()V
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_1
    //   51: invokeinterface 120 1 0
    //   56: iconst_0
    //   57: ireturn
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +9 -> 71
    //   65: aload_0
    //   66: invokeinterface 120 1 0
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: goto -13 -> 61
    //   77: astore_2
    //   78: goto -38 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramContext	Context
    //   0	81	1	paramUri	Uri
    //   0	81	2	paramArrayOfString1	String[]
    //   0	81	3	paramString	String
    //   0	81	4	paramArrayOfString2	String[]
    //   22	13	5	i	int
    // Exception table:
    //   from	to	target	type
    //   0	14	37	java/lang/Throwable
    //   0	14	58	finally
    //   16	24	73	finally
    //   42	46	73	finally
    //   16	24	77	java/lang/Throwable
  }
  
  public static String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghigklmnopkrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789".charAt(localRandom.nextInt(62)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    return MD5Utils.b("android\\" + paramString);
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  private String b(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf(File.separator));
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    Cursor localCursor = this.jdField_a_of_type_AndroidContentContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, jdField_a_of_type_ArrayOfJavaLangString, null, null, null);
    if (localCursor != null) {
      for (;;)
      {
        try
        {
          if (!localCursor.moveToNext()) {
            break label460;
          }
          str1 = localCursor.getString(localCursor.getColumnIndex("_display_name"));
          str2 = localCursor.getString(localCursor.getColumnIndex("_data"));
          str3 = String.valueOf(localCursor.getLong(localCursor.getColumnIndex("_size")));
          localObject2 = a(localCursor.getString(localCursor.getColumnIndex("bucket_id")));
          long l2 = localCursor.getLong(localCursor.getColumnIndex("datetaken"));
          long l1 = l2;
          if (l2 == 0L) {
            l1 = localCursor.getLong(localCursor.getColumnIndex("date_modified"));
          }
          str4 = String.valueOf(l1 / 1000L);
          str5 = MD5Utils.b("andoird" + str2 + str4 + str3 + str1);
          str6 = a(str2);
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2)) {
            continue;
          }
          localWpBucketData1 = (WifiPhotoDataCenter.WpBucketData)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        }
        catch (Exception localException)
        {
          String str1;
          String str2;
          String str3;
          Object localObject2;
          String str4;
          String str5;
          String str6;
          WifiPhotoDataCenter.WpBucketData localWpBucketData1;
          localException.printStackTrace();
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
          c();
          return;
          localWpBucketData2 = new WifiPhotoDataCenter.WpBucketData(this);
          localWpBucketData2.jdField_b_of_type_JavaLangString = ((String)localObject2);
          localWpBucketData2.jdField_a_of_type_Int = 0;
          localWpBucketData2.c = str6;
          localWpBucketData2.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilMap.put(localObject2, localWpBucketData2);
          continue;
        }
        finally
        {
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
        }
        if (localWpBucketData1 != null)
        {
          localObject2 = new WifiPhotoDataCenter.WpPhotoData(this);
          ((WifiPhotoDataCenter.WpPhotoData)localObject2).jdField_a_of_type_JavaLangString = str6;
          ((WifiPhotoDataCenter.WpPhotoData)localObject2).c = str2;
          ((WifiPhotoDataCenter.WpPhotoData)localObject2).jdField_b_of_type_JavaLangString = str4;
          ((WifiPhotoDataCenter.WpPhotoData)localObject2).e = str5;
          ((WifiPhotoDataCenter.WpPhotoData)localObject2).f = str1;
          ((WifiPhotoDataCenter.WpPhotoData)localObject2).g = str3;
          ((WifiPhotoDataCenter.WpPhotoData)localObject2).d = FileUtil.d(this.jdField_a_of_type_AndroidContentContext, str2);
          localWpBucketData1.jdField_a_of_type_JavaUtilList.add(str6);
          this.jdField_b_of_type_JavaUtilMap.put(str6, localObject2);
        }
      }
    }
    for (;;)
    {
      WifiPhotoDataCenter.WpBucketData localWpBucketData2;
      label460:
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 283	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 284	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: aload_0
    //   10: getfield 93	wifiphoto/WifiPhotoDataCenter:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: getstatic 202	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   19: getstatic 50	wifiphoto/WifiPhotoDataCenter:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   22: ldc 13
    //   24: aconst_null
    //   25: ldc 16
    //   27: invokevirtual 111	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore 7
    //   32: aload 7
    //   34: ifnull +282 -> 316
    //   37: aload 7
    //   39: astore 6
    //   41: aload 7
    //   43: invokeinterface 206 1 0
    //   48: ifeq +268 -> 316
    //   51: aload 7
    //   53: astore 6
    //   55: aload 7
    //   57: aload 7
    //   59: ldc 42
    //   61: invokeinterface 209 2 0
    //   66: invokeinterface 212 2 0
    //   71: astore 10
    //   73: aload 7
    //   75: astore 6
    //   77: aload 7
    //   79: aload 7
    //   81: ldc 48
    //   83: invokeinterface 209 2 0
    //   88: invokeinterface 212 2 0
    //   93: astore 9
    //   95: aload 10
    //   97: ifnull -60 -> 37
    //   100: aload 7
    //   102: astore 6
    //   104: aload 10
    //   106: invokevirtual 287	java/lang/String:length	()I
    //   109: ifle -72 -> 37
    //   112: aload 9
    //   114: ifnull -77 -> 37
    //   117: aload 7
    //   119: astore 6
    //   121: aload 9
    //   123: invokevirtual 287	java/lang/String:length	()I
    //   126: ifle -89 -> 37
    //   129: aload 7
    //   131: astore 6
    //   133: aload 10
    //   135: invokestatic 222	wifiphoto/WifiPhotoDataCenter:a	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 10
    //   140: aload 7
    //   142: astore 6
    //   144: aload_0
    //   145: getfield 189	wifiphoto/WifiPhotoDataCenter:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   148: aload 10
    //   150: invokeinterface 234 2 0
    //   155: checkcast 236	wifiphoto/WifiPhotoDataCenter$WpBucketData
    //   158: astore 11
    //   160: aload 11
    //   162: ifnull -125 -> 37
    //   165: aload 7
    //   167: astore 6
    //   169: aload 7
    //   171: aload 7
    //   173: ldc 38
    //   175: invokeinterface 209 2 0
    //   180: invokeinterface 212 2 0
    //   185: astore 12
    //   187: aload 7
    //   189: astore 6
    //   191: aload 7
    //   193: aload 7
    //   195: ldc 34
    //   197: invokeinterface 209 2 0
    //   202: invokeinterface 216 2 0
    //   207: lstore 4
    //   209: aload 7
    //   211: astore 6
    //   213: aload 12
    //   215: invokestatic 222	wifiphoto/WifiPhotoDataCenter:a	(Ljava/lang/String;)Ljava/lang/String;
    //   218: astore 13
    //   220: aload 7
    //   222: astore 6
    //   224: aload 11
    //   226: aload 10
    //   228: putfield 276	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   231: aload 7
    //   233: astore 6
    //   235: aload 11
    //   237: aload 9
    //   239: putfield 288	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: aload 7
    //   244: astore 6
    //   246: aload 11
    //   248: aload 13
    //   250: putfield 280	wifiphoto/WifiPhotoDataCenter$WpBucketData:c	Ljava/lang/String;
    //   253: aload 7
    //   255: astore 6
    //   257: aload 11
    //   259: lload 4
    //   261: putfield 289	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_a_of_type_Long	J
    //   264: aload 7
    //   266: astore 6
    //   268: aload 11
    //   270: aload 12
    //   272: putfield 290	wifiphoto/WifiPhotoDataCenter$WpBucketData:d	Ljava/lang/String;
    //   275: aload 7
    //   277: astore 6
    //   279: aload 8
    //   281: aload 11
    //   283: invokeinterface 267 2 0
    //   288: pop
    //   289: goto -252 -> 37
    //   292: astore 8
    //   294: aload 7
    //   296: astore 6
    //   298: aload 8
    //   300: invokevirtual 272	java/lang/Exception:printStackTrace	()V
    //   303: aload 7
    //   305: ifnull +10 -> 315
    //   308: aload 7
    //   310: invokeinterface 120 1 0
    //   315: return
    //   316: aload 7
    //   318: astore 6
    //   320: aload 8
    //   322: invokeinterface 293 1 0
    //   327: istore_2
    //   328: aload 7
    //   330: astore 6
    //   332: new 283	java/util/ArrayList
    //   335: dup
    //   336: invokespecial 284	java/util/ArrayList:<init>	()V
    //   339: astore 9
    //   341: iconst_0
    //   342: istore_1
    //   343: iload_1
    //   344: iload_2
    //   345: if_icmpge +53 -> 398
    //   348: aload 7
    //   350: astore 6
    //   352: aload 8
    //   354: iload_1
    //   355: invokeinterface 296 2 0
    //   360: checkcast 236	wifiphoto/WifiPhotoDataCenter$WpBucketData
    //   363: astore 10
    //   365: aload 7
    //   367: astore 6
    //   369: aload_0
    //   370: aload 10
    //   372: getfield 288	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   375: invokespecial 298	wifiphoto/WifiPhotoDataCenter:a	(Ljava/lang/String;)Z
    //   378: ifeq +262 -> 640
    //   381: aload 7
    //   383: astore 6
    //   385: aload 9
    //   387: aload 10
    //   389: invokeinterface 267 2 0
    //   394: pop
    //   395: goto +245 -> 640
    //   398: aload 7
    //   400: astore 6
    //   402: aload 8
    //   404: aload 9
    //   406: invokeinterface 302 2 0
    //   411: pop
    //   412: aload 7
    //   414: astore 6
    //   416: aload 8
    //   418: aload_0
    //   419: getfield 91	wifiphoto/WifiPhotoDataCenter:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   422: invokestatic 308	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   425: aload 7
    //   427: astore 6
    //   429: aload 9
    //   431: aload_0
    //   432: getfield 91	wifiphoto/WifiPhotoDataCenter:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   435: invokestatic 308	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   438: aload 7
    //   440: astore 6
    //   442: aload 8
    //   444: iconst_0
    //   445: aload 9
    //   447: invokeinterface 312 3 0
    //   452: pop
    //   453: aload 7
    //   455: astore 6
    //   457: aload 8
    //   459: invokeinterface 293 1 0
    //   464: istore_2
    //   465: iconst_0
    //   466: istore_1
    //   467: iload_1
    //   468: iload_2
    //   469: if_icmpge +125 -> 594
    //   472: aload 7
    //   474: astore 6
    //   476: aload 8
    //   478: iload_1
    //   479: invokeinterface 296 2 0
    //   484: checkcast 236	wifiphoto/WifiPhotoDataCenter$WpBucketData
    //   487: astore 9
    //   489: aload 7
    //   491: astore 6
    //   493: aload 9
    //   495: iload_1
    //   496: putfield 279	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_a_of_type_Int	I
    //   499: aload 7
    //   501: astore 6
    //   503: new 150	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 314
    //   513: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 9
    //   518: getfield 276	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   521: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 316
    //   527: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: ldc_w 318
    //   533: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: ldc 19
    //   538: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: astore 10
    //   546: aload 7
    //   548: astore 6
    //   550: aload_0
    //   551: getfield 93	wifiphoto/WifiPhotoDataCenter:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   554: getstatic 202	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   557: getstatic 54	wifiphoto/WifiPhotoDataCenter:c	[Ljava/lang/String;
    //   560: aload 10
    //   562: invokestatic 320	wifiphoto/WifiPhotoDataCenter:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;)I
    //   565: istore_3
    //   566: aload 7
    //   568: astore 6
    //   570: aload 9
    //   572: iload_1
    //   573: putfield 279	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_a_of_type_Int	I
    //   576: aload 7
    //   578: astore 6
    //   580: aload 9
    //   582: iload_3
    //   583: i2l
    //   584: putfield 322	wifiphoto/WifiPhotoDataCenter$WpBucketData:jdField_b_of_type_Long	J
    //   587: iload_1
    //   588: iconst_1
    //   589: iadd
    //   590: istore_1
    //   591: goto -124 -> 467
    //   594: aload 7
    //   596: ifnull -281 -> 315
    //   599: aload 7
    //   601: invokeinterface 120 1 0
    //   606: return
    //   607: astore 7
    //   609: aconst_null
    //   610: astore 6
    //   612: aload 6
    //   614: ifnull +10 -> 624
    //   617: aload 6
    //   619: invokeinterface 120 1 0
    //   624: aload 7
    //   626: athrow
    //   627: astore 7
    //   629: goto -17 -> 612
    //   632: astore 8
    //   634: aconst_null
    //   635: astore 7
    //   637: goto -343 -> 294
    //   640: iload_1
    //   641: iconst_1
    //   642: iadd
    //   643: istore_1
    //   644: goto -301 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	WifiPhotoDataCenter
    //   342	302	1	i	int
    //   327	143	2	j	int
    //   565	18	3	k	int
    //   207	53	4	l	long
    //   39	579	6	localCursor1	Cursor
    //   30	570	7	localCursor2	Cursor
    //   607	18	7	localObject1	Object
    //   627	1	7	localObject2	Object
    //   635	1	7	localObject3	Object
    //   7	273	8	localArrayList	java.util.ArrayList
    //   292	185	8	localException1	Exception
    //   632	1	8	localException2	Exception
    //   93	488	9	localObject4	Object
    //   71	490	10	localObject5	Object
    //   158	124	11	localWpBucketData	WifiPhotoDataCenter.WpBucketData
    //   185	86	12	str1	String
    //   218	31	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   41	51	292	java/lang/Exception
    //   55	73	292	java/lang/Exception
    //   77	95	292	java/lang/Exception
    //   104	112	292	java/lang/Exception
    //   121	129	292	java/lang/Exception
    //   133	140	292	java/lang/Exception
    //   144	160	292	java/lang/Exception
    //   169	187	292	java/lang/Exception
    //   191	209	292	java/lang/Exception
    //   213	220	292	java/lang/Exception
    //   224	231	292	java/lang/Exception
    //   235	242	292	java/lang/Exception
    //   246	253	292	java/lang/Exception
    //   257	264	292	java/lang/Exception
    //   268	275	292	java/lang/Exception
    //   279	289	292	java/lang/Exception
    //   320	328	292	java/lang/Exception
    //   332	341	292	java/lang/Exception
    //   352	365	292	java/lang/Exception
    //   369	381	292	java/lang/Exception
    //   385	395	292	java/lang/Exception
    //   402	412	292	java/lang/Exception
    //   416	425	292	java/lang/Exception
    //   429	438	292	java/lang/Exception
    //   442	453	292	java/lang/Exception
    //   457	465	292	java/lang/Exception
    //   476	489	292	java/lang/Exception
    //   493	499	292	java/lang/Exception
    //   503	546	292	java/lang/Exception
    //   550	566	292	java/lang/Exception
    //   570	576	292	java/lang/Exception
    //   580	587	292	java/lang/Exception
    //   9	32	607	finally
    //   41	51	627	finally
    //   55	73	627	finally
    //   77	95	627	finally
    //   104	112	627	finally
    //   121	129	627	finally
    //   133	140	627	finally
    //   144	160	627	finally
    //   169	187	627	finally
    //   191	209	627	finally
    //   213	220	627	finally
    //   224	231	627	finally
    //   235	242	627	finally
    //   246	253	627	finally
    //   257	264	627	finally
    //   268	275	627	finally
    //   279	289	627	finally
    //   298	303	627	finally
    //   320	328	627	finally
    //   332	341	627	finally
    //   352	365	627	finally
    //   369	381	627	finally
    //   385	395	627	finally
    //   402	412	627	finally
    //   416	425	627	finally
    //   429	438	627	finally
    //   442	453	627	finally
    //   457	465	627	finally
    //   476	489	627	finally
    //   493	499	627	finally
    //   503	546	627	finally
    //   550	566	627	finally
    //   570	576	627	finally
    //   580	587	627	finally
    //   9	32	632	java/lang/Exception
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap = null;
      }
      if (this.jdField_b_of_type_JavaUtilMap != null)
      {
        this.jdField_b_of_type_JavaUtilMap.clear();
        this.jdField_b_of_type_JavaUtilMap = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      if (this.jdField_b_of_type_JavaUtilMap == null) {
        this.jdField_b_of_type_JavaUtilMap = new HashMap();
      }
      if ((paramBoolean) || (this.jdField_a_of_type_JavaUtilMap.size() == 0) || (this.jdField_b_of_type_JavaUtilMap.size() == 0)) {
        b();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     wifiphoto.WifiPhotoDataCenter
 * JD-Core Version:    0.7.0.1
 */