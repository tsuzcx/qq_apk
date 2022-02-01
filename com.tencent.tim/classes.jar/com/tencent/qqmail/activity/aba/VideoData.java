package com.tencent.qqmail.activity.aba;

import java.util.ArrayList;
import java.util.List;

public final class VideoData
{
  public static final String TAG = "VideoData";
  private static final String[] columns = { "_data", "_id", "_display_name", "_size", "date_modified" };
  private static final String orderBy = "date_modified DESC";
  public static final List<VideoItemInfo> selectedInfo;
  public static final List<VideoItemInfo> videoInfo = new ArrayList();
  
  static
  {
    selectedInfo = new ArrayList();
  }
  
  public static void clear()
  {
    videoInfo.clear();
  }
  
  public static void clearSelected()
  {
    selectedInfo.clear();
  }
  
  /* Error */
  public static void loadData(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +198 -> 199
    //   4: getstatic 60	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 7
    //   9: aload_0
    //   10: invokevirtual 66	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload 7
    //   15: getstatic 42	com/tencent/qqmail/activity/aba/VideoData:columns	[Ljava/lang/String;
    //   18: aconst_null
    //   19: aconst_null
    //   20: ldc 13
    //   22: invokestatic 72	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 7
    //   27: aload 7
    //   29: ifnull +284 -> 313
    //   32: aload 7
    //   34: astore_0
    //   35: aload 7
    //   37: ldc 34
    //   39: invokeinterface 78 2 0
    //   44: istore_3
    //   45: aload 7
    //   47: astore_0
    //   48: aload 7
    //   50: ldc 32
    //   52: invokeinterface 78 2 0
    //   57: istore 4
    //   59: aload 7
    //   61: astore_0
    //   62: aload 7
    //   64: ldc 36
    //   66: invokeinterface 78 2 0
    //   71: istore 5
    //   73: aload 7
    //   75: astore_0
    //   76: aload 7
    //   78: ldc 38
    //   80: invokeinterface 78 2 0
    //   85: istore 6
    //   87: iconst_0
    //   88: istore_2
    //   89: aload 7
    //   91: astore_0
    //   92: iload_2
    //   93: aload 7
    //   95: invokeinterface 82 1 0
    //   100: if_icmpge +213 -> 313
    //   103: aload 7
    //   105: astore_0
    //   106: aload 7
    //   108: iload_2
    //   109: invokeinterface 86 2 0
    //   114: pop
    //   115: aload 7
    //   117: astore_0
    //   118: new 88	com/tencent/qqmail/activity/aba/VideoItemInfo
    //   121: dup
    //   122: invokespecial 89	com/tencent/qqmail/activity/aba/VideoItemInfo:<init>	()V
    //   125: astore 8
    //   127: iload_3
    //   128: iflt +19 -> 147
    //   131: aload 7
    //   133: astore_0
    //   134: aload 8
    //   136: aload 7
    //   138: iload_3
    //   139: invokeinterface 93 2 0
    //   144: putfield 97	com/tencent/qqmail/activity/aba/VideoItemInfo:id	I
    //   147: iload 4
    //   149: iflt +58 -> 207
    //   152: aload 7
    //   154: astore_0
    //   155: aload 8
    //   157: aload 7
    //   159: iload 4
    //   161: invokeinterface 101 2 0
    //   166: putfield 104	com/tencent/qqmail/activity/aba/VideoItemInfo:dataPath	Ljava/lang/String;
    //   169: aload 7
    //   171: astore_0
    //   172: new 106	java/io/File
    //   175: dup
    //   176: aload 8
    //   178: getfield 104	com/tencent/qqmail/activity/aba/VideoItemInfo:dataPath	Ljava/lang/String;
    //   181: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: invokevirtual 113	java/io/File:exists	()Z
    //   187: istore_1
    //   188: iload_1
    //   189: ifne +18 -> 207
    //   192: iload_2
    //   193: iconst_1
    //   194: iadd
    //   195: istore_2
    //   196: goto -107 -> 89
    //   199: getstatic 116	android/provider/MediaStore$Video$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   202: astore 7
    //   204: goto -195 -> 9
    //   207: iload 5
    //   209: iflt +20 -> 229
    //   212: aload 7
    //   214: astore_0
    //   215: aload 8
    //   217: aload 7
    //   219: iload 5
    //   221: invokeinterface 101 2 0
    //   226: putfield 119	com/tencent/qqmail/activity/aba/VideoItemInfo:fileName	Ljava/lang/String;
    //   229: iload 6
    //   231: iflt +20 -> 251
    //   234: aload 7
    //   236: astore_0
    //   237: aload 8
    //   239: aload 7
    //   241: iload 6
    //   243: invokeinterface 123 2 0
    //   248: putfield 127	com/tencent/qqmail/activity/aba/VideoItemInfo:fileSize	J
    //   251: aload 8
    //   253: ifnull -61 -> 192
    //   256: aload 7
    //   258: astore_0
    //   259: getstatic 26	com/tencent/qqmail/activity/aba/VideoData:videoInfo	Ljava/util/List;
    //   262: aload 8
    //   264: invokeinterface 131 2 0
    //   269: pop
    //   270: goto -78 -> 192
    //   273: astore 8
    //   275: aload 7
    //   277: astore_0
    //   278: bipush 6
    //   280: ldc 8
    //   282: aload 8
    //   284: invokestatic 137	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   287: invokestatic 143	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   290: aload 7
    //   292: ifnull +20 -> 312
    //   295: aload 7
    //   297: invokeinterface 146 1 0
    //   302: ifne +10 -> 312
    //   305: aload 7
    //   307: invokeinterface 149 1 0
    //   312: return
    //   313: aload 7
    //   315: ifnull -3 -> 312
    //   318: aload 7
    //   320: invokeinterface 146 1 0
    //   325: ifne -13 -> 312
    //   328: aload 7
    //   330: invokeinterface 149 1 0
    //   335: return
    //   336: astore 7
    //   338: aconst_null
    //   339: astore_0
    //   340: aload_0
    //   341: ifnull +18 -> 359
    //   344: aload_0
    //   345: invokeinterface 146 1 0
    //   350: ifne +9 -> 359
    //   353: aload_0
    //   354: invokeinterface 149 1 0
    //   359: aload 7
    //   361: athrow
    //   362: astore 7
    //   364: goto -24 -> 340
    //   367: astore 8
    //   369: aconst_null
    //   370: astore 7
    //   372: goto -97 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramContext	android.content.Context
    //   0	375	1	paramBoolean	boolean
    //   88	108	2	i	int
    //   44	95	3	j	int
    //   57	103	4	k	int
    //   71	149	5	m	int
    //   85	157	6	n	int
    //   7	322	7	localObject1	Object
    //   336	24	7	localObject2	Object
    //   362	1	7	localObject3	Object
    //   370	1	7	localObject4	Object
    //   125	138	8	localVideoItemInfo	VideoItemInfo
    //   273	10	8	localException1	java.lang.Exception
    //   367	1	8	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   35	45	273	java/lang/Exception
    //   48	59	273	java/lang/Exception
    //   62	73	273	java/lang/Exception
    //   76	87	273	java/lang/Exception
    //   92	103	273	java/lang/Exception
    //   106	115	273	java/lang/Exception
    //   118	127	273	java/lang/Exception
    //   134	147	273	java/lang/Exception
    //   155	169	273	java/lang/Exception
    //   172	188	273	java/lang/Exception
    //   215	229	273	java/lang/Exception
    //   237	251	273	java/lang/Exception
    //   259	270	273	java/lang/Exception
    //   9	27	336	finally
    //   35	45	362	finally
    //   48	59	362	finally
    //   62	73	362	finally
    //   76	87	362	finally
    //   92	103	362	finally
    //   106	115	362	finally
    //   118	127	362	finally
    //   134	147	362	finally
    //   155	169	362	finally
    //   172	188	362	finally
    //   215	229	362	finally
    //   237	251	362	finally
    //   259	270	362	finally
    //   278	290	362	finally
    //   9	27	367	java/lang/Exception
  }
  
  public static void selectItem(VideoItemInfo paramVideoItemInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!selectedInfo.contains(paramVideoItemInfo)) {
        selectedInfo.add(paramVideoItemInfo);
      }
      return;
    }
    selectedInfo.remove(paramVideoItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.aba.VideoData
 * JD-Core Version:    0.7.0.1
 */