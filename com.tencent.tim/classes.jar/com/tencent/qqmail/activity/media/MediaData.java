package com.tencent.qqmail.activity.media;

import android.content.Context;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaData
{
  private static final int DEFAULT_ID_IMAGE = 1;
  private static final int DEFAULT_ID_IMAGE_AND_VIDEO = 3;
  private static final int DEFAULT_ID_VIDEO = 2;
  private static final String TAG = "MediaData";
  private static final Map<String, List<MediaItemInfo>> buckets = new ConcurrentHashMap();
  private static final List<MediaItemInfo> covers = new ArrayList();
  private static final String[] imageColumns;
  private static final String imageOrderBy = "date_modified DESC";
  private static Comparator<MediaItemInfo> mediaItemInfoComparator = new MediaData.1();
  private static final List<MediaItemInfo> selectedInfoList = new ArrayList();
  private static final String[] videoColumns;
  private static final String videoOrderBy = "date_modified DESC";
  
  static
  {
    imageColumns = new String[] { "_data", "_id", "_display_name", "bucket_display_name", "_size", "orientation", "date_modified" };
    videoColumns = new String[] { "_data", "_id", "_display_name", "bucket_display_name", "_size", "date_modified" };
  }
  
  public static void clear()
  {
    buckets.clear();
    covers.clear();
    selectedInfoList.clear();
  }
  
  public static Map<String, List<MediaItemInfo>> getBuckets()
  {
    return buckets;
  }
  
  public static int[] getCoverCounts()
  {
    int k = covers.size();
    int[] arrayOfInt = new int[k];
    int i = 0;
    if (i < k)
    {
      Object localObject = (MediaItemInfo)covers.get(i);
      localObject = (List)buckets.get(((MediaItemInfo)localObject).getBucketName());
      if (localObject == null) {}
      for (int j = 0;; j = ((List)localObject).size())
      {
        arrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfInt;
  }
  
  public static List<MediaItemInfo> getCovers()
  {
    return covers;
  }
  
  public static List<MediaItemInfo> getSelectedInfoList()
  {
    return selectedInfoList;
  }
  
  public static void loadImageAndVideo(Context paramContext, boolean paramBoolean)
  {
    loadImageData(paramContext, paramBoolean);
    loadVideoData(paramContext, paramBoolean);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (List)buckets.get(paramContext.getString(2131695697));
    Object localObject1 = (List)buckets.get(paramContext.getString(2131695703));
    if (localObject1 != null)
    {
      localArrayList.addAll((Collection)localObject1);
      buckets.remove(paramContext.getString(2131695703));
    }
    for (localObject1 = removeFromCovers(2);; localObject1 = null)
    {
      if (localObject2 != null)
      {
        localArrayList.addAll((Collection)localObject2);
        buckets.remove(paramContext.getString(2131695697));
        localObject1 = removeFromCovers(1);
      }
      for (;;)
      {
        localObject2 = new MediaItemInfo();
        if (localObject1 != null)
        {
          ((MediaItemInfo)localObject2).setId(3);
          ((MediaItemInfo)localObject2).setDataPath(((MediaItemInfo)localObject1).getDataPath());
          ((MediaItemInfo)localObject2).setFileName(((MediaItemInfo)localObject1).getFileName());
          ((MediaItemInfo)localObject2).setFileSize(((MediaItemInfo)localObject1).getFileSize());
          ((MediaItemInfo)localObject2).setModifyDate(((MediaItemInfo)localObject1).getModifyDate());
          ((MediaItemInfo)localObject2).setOrientation(((MediaItemInfo)localObject1).getOrientation());
        }
        ((MediaItemInfo)localObject2).setBucketName(paramContext.getString(2131695698));
        buckets.put(((MediaItemInfo)localObject2).getBucketName(), localArrayList);
        covers.add(0, localObject2);
        return;
      }
    }
  }
  
  /* Error */
  public static void loadImageData(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +253 -> 254
    //   4: getstatic 195	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 10
    //   9: aload_0
    //   10: invokevirtual 199	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 10
    //   15: getstatic 66	com/tencent/qqmail/activity/media/MediaData:imageColumns	[Ljava/lang/String;
    //   18: aconst_null
    //   19: aconst_null
    //   20: ldc 26
    //   22: invokestatic 205	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 11
    //   27: aload 11
    //   29: ifnull +779 -> 808
    //   32: aload 11
    //   34: astore 10
    //   36: aload 11
    //   38: ldc 54
    //   40: invokeinterface 211 2 0
    //   45: istore_3
    //   46: aload 11
    //   48: astore 10
    //   50: aload 11
    //   52: ldc 52
    //   54: invokeinterface 211 2 0
    //   59: istore 4
    //   61: aload 11
    //   63: astore 10
    //   65: aload 11
    //   67: ldc 58
    //   69: invokeinterface 211 2 0
    //   74: istore 5
    //   76: aload 11
    //   78: astore 10
    //   80: aload 11
    //   82: ldc 56
    //   84: invokeinterface 211 2 0
    //   89: istore 6
    //   91: aload 11
    //   93: astore 10
    //   95: aload 11
    //   97: ldc 60
    //   99: invokeinterface 211 2 0
    //   104: istore 7
    //   106: aload 11
    //   108: astore 10
    //   110: aload 11
    //   112: ldc 62
    //   114: invokeinterface 211 2 0
    //   119: istore 8
    //   121: aload 11
    //   123: astore 10
    //   125: aload 11
    //   127: ldc 64
    //   129: invokeinterface 211 2 0
    //   134: istore 9
    //   136: iconst_0
    //   137: istore_2
    //   138: aload 11
    //   140: astore 10
    //   142: iload_2
    //   143: aload 11
    //   145: invokeinterface 214 1 0
    //   150: if_icmpge +658 -> 808
    //   153: aload 11
    //   155: astore 10
    //   157: aload 11
    //   159: iload_2
    //   160: invokeinterface 218 2 0
    //   165: pop
    //   166: aload 11
    //   168: astore 10
    //   170: new 99	com/tencent/qqmail/activity/media/MediaItemInfo
    //   173: dup
    //   174: invokespecial 138	com/tencent/qqmail/activity/media/MediaItemInfo:<init>	()V
    //   177: astore 12
    //   179: iload_3
    //   180: iflt +20 -> 200
    //   183: aload 11
    //   185: astore 10
    //   187: aload 12
    //   189: aload 11
    //   191: iload_3
    //   192: invokeinterface 222 2 0
    //   197: invokevirtual 142	com/tencent/qqmail/activity/media/MediaItemInfo:setId	(I)V
    //   200: iload 4
    //   202: iflt +60 -> 262
    //   205: aload 11
    //   207: astore 10
    //   209: aload 12
    //   211: aload 11
    //   213: iload 4
    //   215: invokeinterface 223 2 0
    //   220: invokevirtual 149	com/tencent/qqmail/activity/media/MediaItemInfo:setDataPath	(Ljava/lang/String;)V
    //   223: aload 11
    //   225: astore 10
    //   227: new 225	java/io/File
    //   230: dup
    //   231: aload 12
    //   233: invokevirtual 145	com/tencent/qqmail/activity/media/MediaItemInfo:getDataPath	()Ljava/lang/String;
    //   236: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 231	java/io/File:exists	()Z
    //   242: istore_1
    //   243: iload_1
    //   244: ifne +18 -> 262
    //   247: iload_2
    //   248: iconst_1
    //   249: iadd
    //   250: istore_2
    //   251: goto -113 -> 138
    //   254: getstatic 234	android/provider/MediaStore$Images$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   257: astore 10
    //   259: goto -250 -> 9
    //   262: iload 6
    //   264: iflt +21 -> 285
    //   267: aload 11
    //   269: astore 10
    //   271: aload 12
    //   273: aload 11
    //   275: iload 6
    //   277: invokeinterface 223 2 0
    //   282: invokevirtual 155	com/tencent/qqmail/activity/media/MediaItemInfo:setFileName	(Ljava/lang/String;)V
    //   285: iload 7
    //   287: iflt +21 -> 308
    //   290: aload 11
    //   292: astore 10
    //   294: aload 12
    //   296: aload 11
    //   298: iload 7
    //   300: invokeinterface 238 2 0
    //   305: invokevirtual 163	com/tencent/qqmail/activity/media/MediaItemInfo:setFileSize	(J)V
    //   308: iload 9
    //   310: iflt +21 -> 331
    //   313: aload 11
    //   315: astore 10
    //   317: aload 12
    //   319: aload 11
    //   321: iload 9
    //   323: invokeinterface 238 2 0
    //   328: invokevirtual 169	com/tencent/qqmail/activity/media/MediaItemInfo:setModifyDate	(J)V
    //   331: iload 8
    //   333: iflt +21 -> 354
    //   336: aload 11
    //   338: astore 10
    //   340: aload 12
    //   342: aload 11
    //   344: iload 8
    //   346: invokeinterface 223 2 0
    //   351: invokevirtual 175	com/tencent/qqmail/activity/media/MediaItemInfo:setOrientation	(Ljava/lang/String;)V
    //   354: iload 5
    //   356: iflt -109 -> 247
    //   359: aload 11
    //   361: astore 10
    //   363: aload 11
    //   365: iload 5
    //   367: invokeinterface 223 2 0
    //   372: astore 13
    //   374: aload 13
    //   376: ifnull -129 -> 247
    //   379: aload 11
    //   381: astore 10
    //   383: aload 12
    //   385: invokevirtual 159	com/tencent/qqmail/activity/media/MediaItemInfo:getFileSize	()J
    //   388: lconst_0
    //   389: lcmp
    //   390: ifgt +25 -> 415
    //   393: aload 11
    //   395: astore 10
    //   397: new 225	java/io/File
    //   400: dup
    //   401: aload 12
    //   403: invokevirtual 145	com/tencent/qqmail/activity/media/MediaItemInfo:getDataPath	()Ljava/lang/String;
    //   406: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   409: invokevirtual 231	java/io/File:exists	()Z
    //   412: ifeq -165 -> 247
    //   415: aload 11
    //   417: astore 10
    //   419: aload 12
    //   421: aload 13
    //   423: invokevirtual 179	com/tencent/qqmail/activity/media/MediaItemInfo:setBucketName	(Ljava/lang/String;)V
    //   426: aload 11
    //   428: astore 10
    //   430: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   433: aload_0
    //   434: ldc 119
    //   436: invokevirtual 125	android/content/Context:getString	(I)Ljava/lang/String;
    //   439: invokeinterface 106 2 0
    //   444: checkcast 82	java/util/List
    //   447: astore 14
    //   449: aload 14
    //   451: ifnonnull +298 -> 749
    //   454: aload 11
    //   456: astore 10
    //   458: new 43	java/util/ArrayList
    //   461: dup
    //   462: invokespecial 44	java/util/ArrayList:<init>	()V
    //   465: astore 14
    //   467: aload 11
    //   469: astore 10
    //   471: aload 14
    //   473: aload 12
    //   475: invokeinterface 241 2 0
    //   480: pop
    //   481: aload 11
    //   483: astore 10
    //   485: new 99	com/tencent/qqmail/activity/media/MediaItemInfo
    //   488: dup
    //   489: invokespecial 138	com/tencent/qqmail/activity/media/MediaItemInfo:<init>	()V
    //   492: astore 15
    //   494: aload 11
    //   496: astore 10
    //   498: aload 15
    //   500: iconst_1
    //   501: invokevirtual 142	com/tencent/qqmail/activity/media/MediaItemInfo:setId	(I)V
    //   504: aload 11
    //   506: astore 10
    //   508: aload 15
    //   510: aload 12
    //   512: invokevirtual 145	com/tencent/qqmail/activity/media/MediaItemInfo:getDataPath	()Ljava/lang/String;
    //   515: invokevirtual 149	com/tencent/qqmail/activity/media/MediaItemInfo:setDataPath	(Ljava/lang/String;)V
    //   518: aload 11
    //   520: astore 10
    //   522: aload 15
    //   524: aload 12
    //   526: invokevirtual 152	com/tencent/qqmail/activity/media/MediaItemInfo:getFileName	()Ljava/lang/String;
    //   529: invokevirtual 155	com/tencent/qqmail/activity/media/MediaItemInfo:setFileName	(Ljava/lang/String;)V
    //   532: aload 11
    //   534: astore 10
    //   536: aload 15
    //   538: aload 12
    //   540: invokevirtual 159	com/tencent/qqmail/activity/media/MediaItemInfo:getFileSize	()J
    //   543: invokevirtual 163	com/tencent/qqmail/activity/media/MediaItemInfo:setFileSize	(J)V
    //   546: aload 11
    //   548: astore 10
    //   550: aload 15
    //   552: aload 12
    //   554: invokevirtual 166	com/tencent/qqmail/activity/media/MediaItemInfo:getModifyDate	()J
    //   557: invokevirtual 169	com/tencent/qqmail/activity/media/MediaItemInfo:setModifyDate	(J)V
    //   560: aload 11
    //   562: astore 10
    //   564: aload 15
    //   566: aload 12
    //   568: invokevirtual 172	com/tencent/qqmail/activity/media/MediaItemInfo:getOrientation	()Ljava/lang/String;
    //   571: invokevirtual 175	com/tencent/qqmail/activity/media/MediaItemInfo:setOrientation	(Ljava/lang/String;)V
    //   574: aload 11
    //   576: astore 10
    //   578: aload 15
    //   580: aload_0
    //   581: ldc 119
    //   583: invokevirtual 125	android/content/Context:getString	(I)Ljava/lang/String;
    //   586: invokevirtual 179	com/tencent/qqmail/activity/media/MediaItemInfo:setBucketName	(Ljava/lang/String;)V
    //   589: aload 11
    //   591: astore 10
    //   593: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   596: aload 15
    //   598: invokevirtual 103	com/tencent/qqmail/activity/media/MediaItemInfo:getBucketName	()Ljava/lang/String;
    //   601: aload 14
    //   603: invokeinterface 183 3 0
    //   608: pop
    //   609: aload 11
    //   611: astore 10
    //   613: getstatic 46	com/tencent/qqmail/activity/media/MediaData:covers	Ljava/util/List;
    //   616: aload 15
    //   618: invokeinterface 241 2 0
    //   623: pop
    //   624: aload 11
    //   626: astore 10
    //   628: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   631: aload 13
    //   633: invokeinterface 106 2 0
    //   638: checkcast 82	java/util/List
    //   641: astore 14
    //   643: aload 14
    //   645: ifnonnull +146 -> 791
    //   648: aload 11
    //   650: astore 10
    //   652: new 43	java/util/ArrayList
    //   655: dup
    //   656: invokespecial 44	java/util/ArrayList:<init>	()V
    //   659: astore 14
    //   661: aload 11
    //   663: astore 10
    //   665: aload 14
    //   667: aload 12
    //   669: invokeinterface 241 2 0
    //   674: pop
    //   675: aload 11
    //   677: astore 10
    //   679: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   682: aload 13
    //   684: aload 14
    //   686: invokeinterface 183 3 0
    //   691: pop
    //   692: aload 11
    //   694: astore 10
    //   696: getstatic 46	com/tencent/qqmail/activity/media/MediaData:covers	Ljava/util/List;
    //   699: aload 12
    //   701: invokeinterface 241 2 0
    //   706: pop
    //   707: goto -460 -> 247
    //   710: astore_0
    //   711: aload 11
    //   713: astore 10
    //   715: bipush 6
    //   717: ldc 15
    //   719: aload_0
    //   720: invokestatic 247	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   723: invokestatic 253	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   726: aload 11
    //   728: ifnull +20 -> 748
    //   731: aload 11
    //   733: invokeinterface 256 1 0
    //   738: ifne +10 -> 748
    //   741: aload 11
    //   743: invokeinterface 259 1 0
    //   748: return
    //   749: aload 11
    //   751: astore 10
    //   753: aload 14
    //   755: aload 12
    //   757: invokeinterface 241 2 0
    //   762: pop
    //   763: goto -139 -> 624
    //   766: astore_0
    //   767: aload 10
    //   769: ifnull +20 -> 789
    //   772: aload 10
    //   774: invokeinterface 256 1 0
    //   779: ifne +10 -> 789
    //   782: aload 10
    //   784: invokeinterface 259 1 0
    //   789: aload_0
    //   790: athrow
    //   791: aload 11
    //   793: astore 10
    //   795: aload 14
    //   797: aload 12
    //   799: invokeinterface 241 2 0
    //   804: pop
    //   805: goto -558 -> 247
    //   808: aload 11
    //   810: ifnull -62 -> 748
    //   813: aload 11
    //   815: invokeinterface 256 1 0
    //   820: ifne -72 -> 748
    //   823: aload 11
    //   825: invokeinterface 259 1 0
    //   830: return
    //   831: astore_0
    //   832: aconst_null
    //   833: astore 10
    //   835: goto -68 -> 767
    //   838: astore_0
    //   839: aconst_null
    //   840: astore 11
    //   842: goto -131 -> 711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	845	0	paramContext	Context
    //   0	845	1	paramBoolean	boolean
    //   137	114	2	i	int
    //   45	147	3	j	int
    //   59	155	4	k	int
    //   74	292	5	m	int
    //   89	187	6	n	int
    //   104	195	7	i1	int
    //   119	226	8	i2	int
    //   134	188	9	i3	int
    //   7	827	10	localObject1	Object
    //   25	816	11	localCursor	android.database.Cursor
    //   177	621	12	localMediaItemInfo1	MediaItemInfo
    //   372	311	13	str	String
    //   447	349	14	localObject2	Object
    //   492	125	15	localMediaItemInfo2	MediaItemInfo
    // Exception table:
    //   from	to	target	type
    //   36	46	710	java/lang/Exception
    //   50	61	710	java/lang/Exception
    //   65	76	710	java/lang/Exception
    //   80	91	710	java/lang/Exception
    //   95	106	710	java/lang/Exception
    //   110	121	710	java/lang/Exception
    //   125	136	710	java/lang/Exception
    //   142	153	710	java/lang/Exception
    //   157	166	710	java/lang/Exception
    //   170	179	710	java/lang/Exception
    //   187	200	710	java/lang/Exception
    //   209	223	710	java/lang/Exception
    //   227	243	710	java/lang/Exception
    //   271	285	710	java/lang/Exception
    //   294	308	710	java/lang/Exception
    //   317	331	710	java/lang/Exception
    //   340	354	710	java/lang/Exception
    //   363	374	710	java/lang/Exception
    //   383	393	710	java/lang/Exception
    //   397	415	710	java/lang/Exception
    //   419	426	710	java/lang/Exception
    //   430	449	710	java/lang/Exception
    //   458	467	710	java/lang/Exception
    //   471	481	710	java/lang/Exception
    //   485	494	710	java/lang/Exception
    //   498	504	710	java/lang/Exception
    //   508	518	710	java/lang/Exception
    //   522	532	710	java/lang/Exception
    //   536	546	710	java/lang/Exception
    //   550	560	710	java/lang/Exception
    //   564	574	710	java/lang/Exception
    //   578	589	710	java/lang/Exception
    //   593	609	710	java/lang/Exception
    //   613	624	710	java/lang/Exception
    //   628	643	710	java/lang/Exception
    //   652	661	710	java/lang/Exception
    //   665	675	710	java/lang/Exception
    //   679	692	710	java/lang/Exception
    //   696	707	710	java/lang/Exception
    //   753	763	710	java/lang/Exception
    //   795	805	710	java/lang/Exception
    //   36	46	766	finally
    //   50	61	766	finally
    //   65	76	766	finally
    //   80	91	766	finally
    //   95	106	766	finally
    //   110	121	766	finally
    //   125	136	766	finally
    //   142	153	766	finally
    //   157	166	766	finally
    //   170	179	766	finally
    //   187	200	766	finally
    //   209	223	766	finally
    //   227	243	766	finally
    //   271	285	766	finally
    //   294	308	766	finally
    //   317	331	766	finally
    //   340	354	766	finally
    //   363	374	766	finally
    //   383	393	766	finally
    //   397	415	766	finally
    //   419	426	766	finally
    //   430	449	766	finally
    //   458	467	766	finally
    //   471	481	766	finally
    //   485	494	766	finally
    //   498	504	766	finally
    //   508	518	766	finally
    //   522	532	766	finally
    //   536	546	766	finally
    //   550	560	766	finally
    //   564	574	766	finally
    //   578	589	766	finally
    //   593	609	766	finally
    //   613	624	766	finally
    //   628	643	766	finally
    //   652	661	766	finally
    //   665	675	766	finally
    //   679	692	766	finally
    //   696	707	766	finally
    //   715	726	766	finally
    //   753	763	766	finally
    //   795	805	766	finally
    //   9	27	831	finally
    //   9	27	838	java/lang/Exception
  }
  
  /* Error */
  public static void loadVideoData(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +238 -> 239
    //   4: getstatic 262	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 9
    //   9: aload_0
    //   10: invokevirtual 199	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 9
    //   15: getstatic 68	com/tencent/qqmail/activity/media/MediaData:videoColumns	[Ljava/lang/String;
    //   18: aconst_null
    //   19: aconst_null
    //   20: ldc 26
    //   22: invokestatic 205	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 10
    //   27: aload 10
    //   29: ifnull +751 -> 780
    //   32: aload 10
    //   34: astore 9
    //   36: aload 10
    //   38: ldc 54
    //   40: invokeinterface 211 2 0
    //   45: istore_3
    //   46: aload 10
    //   48: astore 9
    //   50: aload 10
    //   52: ldc 52
    //   54: invokeinterface 211 2 0
    //   59: istore 4
    //   61: aload 10
    //   63: astore 9
    //   65: aload 10
    //   67: ldc 58
    //   69: invokeinterface 211 2 0
    //   74: istore 5
    //   76: aload 10
    //   78: astore 9
    //   80: aload 10
    //   82: ldc 56
    //   84: invokeinterface 211 2 0
    //   89: istore 6
    //   91: aload 10
    //   93: astore 9
    //   95: aload 10
    //   97: ldc 60
    //   99: invokeinterface 211 2 0
    //   104: istore 7
    //   106: aload 10
    //   108: astore 9
    //   110: aload 10
    //   112: ldc 64
    //   114: invokeinterface 211 2 0
    //   119: istore 8
    //   121: iconst_0
    //   122: istore_2
    //   123: aload 10
    //   125: astore 9
    //   127: iload_2
    //   128: aload 10
    //   130: invokeinterface 214 1 0
    //   135: if_icmpge +645 -> 780
    //   138: aload 10
    //   140: astore 9
    //   142: aload 10
    //   144: iload_2
    //   145: invokeinterface 218 2 0
    //   150: pop
    //   151: aload 10
    //   153: astore 9
    //   155: new 99	com/tencent/qqmail/activity/media/MediaItemInfo
    //   158: dup
    //   159: invokespecial 138	com/tencent/qqmail/activity/media/MediaItemInfo:<init>	()V
    //   162: astore 11
    //   164: iload_3
    //   165: iflt +20 -> 185
    //   168: aload 10
    //   170: astore 9
    //   172: aload 11
    //   174: aload 10
    //   176: iload_3
    //   177: invokeinterface 222 2 0
    //   182: invokevirtual 142	com/tencent/qqmail/activity/media/MediaItemInfo:setId	(I)V
    //   185: iload 4
    //   187: iflt +60 -> 247
    //   190: aload 10
    //   192: astore 9
    //   194: aload 11
    //   196: aload 10
    //   198: iload 4
    //   200: invokeinterface 223 2 0
    //   205: invokevirtual 149	com/tencent/qqmail/activity/media/MediaItemInfo:setDataPath	(Ljava/lang/String;)V
    //   208: aload 10
    //   210: astore 9
    //   212: new 225	java/io/File
    //   215: dup
    //   216: aload 11
    //   218: invokevirtual 145	com/tencent/qqmail/activity/media/MediaItemInfo:getDataPath	()Ljava/lang/String;
    //   221: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   224: invokevirtual 231	java/io/File:exists	()Z
    //   227: istore_1
    //   228: iload_1
    //   229: ifne +18 -> 247
    //   232: iload_2
    //   233: iconst_1
    //   234: iadd
    //   235: istore_2
    //   236: goto -113 -> 123
    //   239: getstatic 263	android/provider/MediaStore$Video$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   242: astore 9
    //   244: goto -235 -> 9
    //   247: iload 6
    //   249: iflt +21 -> 270
    //   252: aload 10
    //   254: astore 9
    //   256: aload 11
    //   258: aload 10
    //   260: iload 6
    //   262: invokeinterface 223 2 0
    //   267: invokevirtual 155	com/tencent/qqmail/activity/media/MediaItemInfo:setFileName	(Ljava/lang/String;)V
    //   270: iload 7
    //   272: iflt +21 -> 293
    //   275: aload 10
    //   277: astore 9
    //   279: aload 11
    //   281: aload 10
    //   283: iload 7
    //   285: invokeinterface 238 2 0
    //   290: invokevirtual 163	com/tencent/qqmail/activity/media/MediaItemInfo:setFileSize	(J)V
    //   293: iload 8
    //   295: iflt +21 -> 316
    //   298: aload 10
    //   300: astore 9
    //   302: aload 11
    //   304: aload 10
    //   306: iload 8
    //   308: invokeinterface 238 2 0
    //   313: invokevirtual 169	com/tencent/qqmail/activity/media/MediaItemInfo:setModifyDate	(J)V
    //   316: iload 5
    //   318: iflt -86 -> 232
    //   321: aload 10
    //   323: astore 9
    //   325: aload 10
    //   327: iload 5
    //   329: invokeinterface 223 2 0
    //   334: astore 12
    //   336: aload 12
    //   338: ifnull -106 -> 232
    //   341: aload 10
    //   343: astore 9
    //   345: aload 11
    //   347: invokevirtual 159	com/tencent/qqmail/activity/media/MediaItemInfo:getFileSize	()J
    //   350: lconst_0
    //   351: lcmp
    //   352: ifgt +25 -> 377
    //   355: aload 10
    //   357: astore 9
    //   359: new 225	java/io/File
    //   362: dup
    //   363: aload 11
    //   365: invokevirtual 145	com/tencent/qqmail/activity/media/MediaItemInfo:getDataPath	()Ljava/lang/String;
    //   368: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   371: invokevirtual 231	java/io/File:exists	()Z
    //   374: ifeq -142 -> 232
    //   377: aload 10
    //   379: astore 9
    //   381: aload 11
    //   383: aload 12
    //   385: invokevirtual 179	com/tencent/qqmail/activity/media/MediaItemInfo:setBucketName	(Ljava/lang/String;)V
    //   388: aload 10
    //   390: astore 9
    //   392: aload 11
    //   394: iconst_1
    //   395: invokevirtual 267	com/tencent/qqmail/activity/media/MediaItemInfo:setIsVideo	(Z)V
    //   398: aload 10
    //   400: astore 9
    //   402: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   405: aload_0
    //   406: ldc 126
    //   408: invokevirtual 125	android/content/Context:getString	(I)Ljava/lang/String;
    //   411: invokeinterface 106 2 0
    //   416: checkcast 82	java/util/List
    //   419: astore 13
    //   421: aload 13
    //   423: ifnonnull +298 -> 721
    //   426: aload 10
    //   428: astore 9
    //   430: new 43	java/util/ArrayList
    //   433: dup
    //   434: invokespecial 44	java/util/ArrayList:<init>	()V
    //   437: astore 13
    //   439: aload 10
    //   441: astore 9
    //   443: aload 13
    //   445: aload 11
    //   447: invokeinterface 241 2 0
    //   452: pop
    //   453: aload 10
    //   455: astore 9
    //   457: new 99	com/tencent/qqmail/activity/media/MediaItemInfo
    //   460: dup
    //   461: invokespecial 138	com/tencent/qqmail/activity/media/MediaItemInfo:<init>	()V
    //   464: astore 14
    //   466: aload 10
    //   468: astore 9
    //   470: aload 14
    //   472: iconst_2
    //   473: invokevirtual 142	com/tencent/qqmail/activity/media/MediaItemInfo:setId	(I)V
    //   476: aload 10
    //   478: astore 9
    //   480: aload 14
    //   482: aload 11
    //   484: invokevirtual 145	com/tencent/qqmail/activity/media/MediaItemInfo:getDataPath	()Ljava/lang/String;
    //   487: invokevirtual 149	com/tencent/qqmail/activity/media/MediaItemInfo:setDataPath	(Ljava/lang/String;)V
    //   490: aload 10
    //   492: astore 9
    //   494: aload 14
    //   496: aload 11
    //   498: invokevirtual 152	com/tencent/qqmail/activity/media/MediaItemInfo:getFileName	()Ljava/lang/String;
    //   501: invokevirtual 155	com/tencent/qqmail/activity/media/MediaItemInfo:setFileName	(Ljava/lang/String;)V
    //   504: aload 10
    //   506: astore 9
    //   508: aload 14
    //   510: aload 11
    //   512: invokevirtual 159	com/tencent/qqmail/activity/media/MediaItemInfo:getFileSize	()J
    //   515: invokevirtual 163	com/tencent/qqmail/activity/media/MediaItemInfo:setFileSize	(J)V
    //   518: aload 10
    //   520: astore 9
    //   522: aload 14
    //   524: aload 11
    //   526: invokevirtual 166	com/tencent/qqmail/activity/media/MediaItemInfo:getModifyDate	()J
    //   529: invokevirtual 169	com/tencent/qqmail/activity/media/MediaItemInfo:setModifyDate	(J)V
    //   532: aload 10
    //   534: astore 9
    //   536: aload 14
    //   538: aload 11
    //   540: invokevirtual 172	com/tencent/qqmail/activity/media/MediaItemInfo:getOrientation	()Ljava/lang/String;
    //   543: invokevirtual 175	com/tencent/qqmail/activity/media/MediaItemInfo:setOrientation	(Ljava/lang/String;)V
    //   546: aload 10
    //   548: astore 9
    //   550: aload 14
    //   552: aload_0
    //   553: ldc 126
    //   555: invokevirtual 125	android/content/Context:getString	(I)Ljava/lang/String;
    //   558: invokevirtual 179	com/tencent/qqmail/activity/media/MediaItemInfo:setBucketName	(Ljava/lang/String;)V
    //   561: aload 10
    //   563: astore 9
    //   565: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   568: aload 14
    //   570: invokevirtual 103	com/tencent/qqmail/activity/media/MediaItemInfo:getBucketName	()Ljava/lang/String;
    //   573: aload 13
    //   575: invokeinterface 183 3 0
    //   580: pop
    //   581: aload 10
    //   583: astore 9
    //   585: getstatic 46	com/tencent/qqmail/activity/media/MediaData:covers	Ljava/util/List;
    //   588: aload 14
    //   590: invokeinterface 241 2 0
    //   595: pop
    //   596: aload 10
    //   598: astore 9
    //   600: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   603: aload 12
    //   605: invokeinterface 106 2 0
    //   610: checkcast 82	java/util/List
    //   613: astore 13
    //   615: aload 13
    //   617: ifnonnull +146 -> 763
    //   620: aload 10
    //   622: astore 9
    //   624: new 43	java/util/ArrayList
    //   627: dup
    //   628: invokespecial 44	java/util/ArrayList:<init>	()V
    //   631: astore 13
    //   633: aload 10
    //   635: astore 9
    //   637: aload 13
    //   639: aload 11
    //   641: invokeinterface 241 2 0
    //   646: pop
    //   647: aload 10
    //   649: astore 9
    //   651: getstatic 41	com/tencent/qqmail/activity/media/MediaData:buckets	Ljava/util/Map;
    //   654: aload 12
    //   656: aload 13
    //   658: invokeinterface 183 3 0
    //   663: pop
    //   664: aload 10
    //   666: astore 9
    //   668: getstatic 46	com/tencent/qqmail/activity/media/MediaData:covers	Ljava/util/List;
    //   671: aload 11
    //   673: invokeinterface 241 2 0
    //   678: pop
    //   679: goto -447 -> 232
    //   682: astore_0
    //   683: aload 10
    //   685: astore 9
    //   687: bipush 6
    //   689: ldc 15
    //   691: aload_0
    //   692: invokestatic 247	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   695: invokestatic 253	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   698: aload 10
    //   700: ifnull +20 -> 720
    //   703: aload 10
    //   705: invokeinterface 256 1 0
    //   710: ifne +10 -> 720
    //   713: aload 10
    //   715: invokeinterface 259 1 0
    //   720: return
    //   721: aload 10
    //   723: astore 9
    //   725: aload 13
    //   727: aload 11
    //   729: invokeinterface 241 2 0
    //   734: pop
    //   735: goto -139 -> 596
    //   738: astore_0
    //   739: aload 9
    //   741: ifnull +20 -> 761
    //   744: aload 9
    //   746: invokeinterface 256 1 0
    //   751: ifne +10 -> 761
    //   754: aload 9
    //   756: invokeinterface 259 1 0
    //   761: aload_0
    //   762: athrow
    //   763: aload 10
    //   765: astore 9
    //   767: aload 13
    //   769: aload 11
    //   771: invokeinterface 241 2 0
    //   776: pop
    //   777: goto -545 -> 232
    //   780: aload 10
    //   782: ifnull -62 -> 720
    //   785: aload 10
    //   787: invokeinterface 256 1 0
    //   792: ifne -72 -> 720
    //   795: aload 10
    //   797: invokeinterface 259 1 0
    //   802: return
    //   803: astore_0
    //   804: aconst_null
    //   805: astore 9
    //   807: goto -68 -> 739
    //   810: astore_0
    //   811: aconst_null
    //   812: astore 10
    //   814: goto -131 -> 683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	817	0	paramContext	Context
    //   0	817	1	paramBoolean	boolean
    //   122	114	2	i	int
    //   45	132	3	j	int
    //   59	140	4	k	int
    //   74	254	5	m	int
    //   89	172	6	n	int
    //   104	180	7	i1	int
    //   119	188	8	i2	int
    //   7	799	9	localObject1	Object
    //   25	788	10	localCursor	android.database.Cursor
    //   162	608	11	localMediaItemInfo1	MediaItemInfo
    //   334	321	12	str	String
    //   419	349	13	localObject2	Object
    //   464	125	14	localMediaItemInfo2	MediaItemInfo
    // Exception table:
    //   from	to	target	type
    //   36	46	682	java/lang/Exception
    //   50	61	682	java/lang/Exception
    //   65	76	682	java/lang/Exception
    //   80	91	682	java/lang/Exception
    //   95	106	682	java/lang/Exception
    //   110	121	682	java/lang/Exception
    //   127	138	682	java/lang/Exception
    //   142	151	682	java/lang/Exception
    //   155	164	682	java/lang/Exception
    //   172	185	682	java/lang/Exception
    //   194	208	682	java/lang/Exception
    //   212	228	682	java/lang/Exception
    //   256	270	682	java/lang/Exception
    //   279	293	682	java/lang/Exception
    //   302	316	682	java/lang/Exception
    //   325	336	682	java/lang/Exception
    //   345	355	682	java/lang/Exception
    //   359	377	682	java/lang/Exception
    //   381	388	682	java/lang/Exception
    //   392	398	682	java/lang/Exception
    //   402	421	682	java/lang/Exception
    //   430	439	682	java/lang/Exception
    //   443	453	682	java/lang/Exception
    //   457	466	682	java/lang/Exception
    //   470	476	682	java/lang/Exception
    //   480	490	682	java/lang/Exception
    //   494	504	682	java/lang/Exception
    //   508	518	682	java/lang/Exception
    //   522	532	682	java/lang/Exception
    //   536	546	682	java/lang/Exception
    //   550	561	682	java/lang/Exception
    //   565	581	682	java/lang/Exception
    //   585	596	682	java/lang/Exception
    //   600	615	682	java/lang/Exception
    //   624	633	682	java/lang/Exception
    //   637	647	682	java/lang/Exception
    //   651	664	682	java/lang/Exception
    //   668	679	682	java/lang/Exception
    //   725	735	682	java/lang/Exception
    //   767	777	682	java/lang/Exception
    //   36	46	738	finally
    //   50	61	738	finally
    //   65	76	738	finally
    //   80	91	738	finally
    //   95	106	738	finally
    //   110	121	738	finally
    //   127	138	738	finally
    //   142	151	738	finally
    //   155	164	738	finally
    //   172	185	738	finally
    //   194	208	738	finally
    //   212	228	738	finally
    //   256	270	738	finally
    //   279	293	738	finally
    //   302	316	738	finally
    //   325	336	738	finally
    //   345	355	738	finally
    //   359	377	738	finally
    //   381	388	738	finally
    //   392	398	738	finally
    //   402	421	738	finally
    //   430	439	738	finally
    //   443	453	738	finally
    //   457	466	738	finally
    //   470	476	738	finally
    //   480	490	738	finally
    //   494	504	738	finally
    //   508	518	738	finally
    //   522	532	738	finally
    //   536	546	738	finally
    //   550	561	738	finally
    //   565	581	738	finally
    //   585	596	738	finally
    //   600	615	738	finally
    //   624	633	738	finally
    //   637	647	738	finally
    //   651	664	738	finally
    //   668	679	738	finally
    //   687	698	738	finally
    //   725	735	738	finally
    //   767	777	738	finally
    //   9	27	803	finally
    //   9	27	810	java/lang/Exception
  }
  
  private static MediaItemInfo removeFromCovers(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = covers.iterator();
    if (localIterator.hasNext())
    {
      MediaItemInfo localMediaItemInfo = (MediaItemInfo)localIterator.next();
      if (localMediaItemInfo.getId() != paramInt) {
        break label51;
      }
      localIterator.remove();
      localObject = localMediaItemInfo;
    }
    label51:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  public static void selectItem(MediaItemInfo paramMediaItemInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!selectedInfoList.contains(paramMediaItemInfo)) {
        selectedInfoList.add(paramMediaItemInfo);
      }
      return;
    }
    selectedInfoList.remove(paramMediaItemInfo);
  }
  
  public static void sortAllBuckets()
  {
    Iterator localIterator = buckets.entrySet().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)((Map.Entry)localIterator.next()).getValue();
      if (localList != null) {
        try
        {
          Collections.sort(localList, mediaItemInfoComparator);
        }
        catch (Exception localException)
        {
          QMLog.log(5, "MediaData", "sort media list failed", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaData
 * JD-Core Version:    0.7.0.1
 */