package com.tencent.weiyun.poi;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class PoiHelper
{
  private static final String[] PROJ_ALL = { "longitude", "latitude", "nation_type", "nation_name", "city_id", "city_name", "poi_id", "poi_name", "address" };
  private static final String[] PROJ_KEY = { "longitude", "latitude" };
  private static final int SINGLE_QUERY_LIMIT = 200;
  private static final String TAG = "PoiHelper";
  
  public static String generateKey(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 + ',' + paramDouble2;
  }
  
  public static void insertPoi(List<PoiItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    PoiDbWrapper localPoiDbWrapper = PoiDbManager.getInstance().openPoiDb(true);
    if (localPoiDbWrapper == null)
    {
      WyLog.e("PoiHelper", "insertPoi: Job db is null.");
      return;
    }
    localPoiDbWrapper.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PoiItem localPoiItem = (PoiItem)paramList.next();
      if ((localPoiItem != null) && ((!TextUtils.isEmpty(localPoiItem.poiId)) || (!TextUtils.isEmpty(localPoiItem.poiName))))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("longitude", Double.valueOf(localPoiItem.longitude));
        localContentValues.put("latitude", Double.valueOf(localPoiItem.latitude));
        localContentValues.put("nation_type", Integer.valueOf(localPoiItem.nationType));
        localContentValues.put("nation_name", localPoiItem.nationName);
        localContentValues.put("city_id", Integer.valueOf(localPoiItem.cityId));
        localContentValues.put("city_name", localPoiItem.cityName);
        localContentValues.put("poi_id", localPoiItem.poiId);
        localContentValues.put("poi_name", localPoiItem.poiName);
        localContentValues.put("address", localPoiItem.address);
        localPoiDbWrapper.insert("poi", null, localContentValues);
      }
    }
    localPoiDbWrapper.setTransactionSuccessful();
    localPoiDbWrapper.endTransaction();
    PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
  }
  
  public static List<PoiItem> queryPoi(List<PoiItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    PoiDbWrapper localPoiDbWrapper = PoiDbManager.getInstance().openPoiDb(false);
    if (localPoiDbWrapper == null)
    {
      WyLog.e("PoiHelper", "queryPoi: Poi db is null.");
      return localArrayList;
    }
    Object localObject = (PoiItem)paramList.get(0);
    double d2 = ((PoiItem)localObject).longitude;
    double d4 = ((PoiItem)localObject).longitude;
    double d1 = ((PoiItem)localObject).latitude;
    double d3 = ((PoiItem)localObject).latitude;
    localObject = paramList.iterator();
    PoiItem localPoiItem;
    while (((Iterator)localObject).hasNext())
    {
      localPoiItem = (PoiItem)((Iterator)localObject).next();
      d5 = d2;
      if (localPoiItem.longitude < d2) {
        d5 = localPoiItem.longitude;
      }
      double d6 = d4;
      if (localPoiItem.longitude > d4) {
        d6 = localPoiItem.longitude;
      }
      double d7 = d1;
      if (localPoiItem.latitude < d1) {
        d7 = localPoiItem.latitude;
      }
      d1 = d7;
      d4 = d6;
      d2 = d5;
      if (localPoiItem.latitude > d3)
      {
        d3 = localPoiItem.latitude;
        d1 = d7;
        d4 = d6;
        d2 = d5;
      }
    }
    int i = 1;
    double d5 = d1;
    d1 = d2;
    label227:
    if (i != 0)
    {
      localObject = singleQuery(localPoiDbWrapper, d1, d4, d5, d3);
      if ((localObject == null) || (((List)localObject).size() < 200)) {
        i = 0;
      }
    }
    for (;;)
    {
      int j = i;
      if (localObject != null)
      {
        j = i;
        if (!((List)localObject).isEmpty())
        {
          ((List)localObject).retainAll(paramList);
          localArrayList.addAll((Collection)localObject);
          paramList.removeAll((Collection)localObject);
          j = i;
          if (paramList.isEmpty()) {
            j = 0;
          }
        }
      }
      i = j;
      break label227;
      localPoiItem = (PoiItem)((List)localObject).get(((List)localObject).size() - 1);
      d2 = d1;
      if (localPoiItem.longitude > d1) {
        d2 = localPoiItem.longitude;
      }
      if (localPoiItem.longitude == d4)
      {
        d5 = localPoiItem.latitude;
        d1 = d2;
        continue;
        PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
        break;
      }
      d1 = d2;
    }
  }
  
  /* Error */
  public static java.util.HashSet<String> queryPoiKeys()
  {
    // Byte code:
    //   0: new 213	java/util/HashSet
    //   3: dup
    //   4: invokespecial 214	java/util/HashSet:<init>	()V
    //   7: astore_3
    //   8: invokestatic 74	com/tencent/weiyun/poi/PoiDbManager:getInstance	()Lcom/tencent/weiyun/poi/PoiDbManager;
    //   11: iconst_0
    //   12: invokevirtual 78	com/tencent/weiyun/poi/PoiDbManager:openPoiDb	(Z)Lcom/tencent/weiyun/poi/PoiDbWrapper;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +12 -> 31
    //   22: ldc 14
    //   24: ldc 216
    //   26: invokestatic 86	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_3
    //   30: areturn
    //   31: aload 4
    //   33: ldc 161
    //   35: getstatic 24	com/tencent/weiyun/poi/PoiHelper:PROJ_KEY	[Ljava/lang/String;
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 220	com/tencent/weiyun/poi/PoiDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +64 -> 112
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: invokeinterface 225 1 0
    //   59: ifeq +53 -> 112
    //   62: aload_1
    //   63: astore_0
    //   64: aload_3
    //   65: aload_1
    //   66: iconst_0
    //   67: invokeinterface 229 2 0
    //   72: aload_1
    //   73: iconst_1
    //   74: invokeinterface 229 2 0
    //   79: invokestatic 231	com/tencent/weiyun/poi/PoiHelper:generateKey	(DD)Ljava/lang/String;
    //   82: invokevirtual 235	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   85: pop
    //   86: goto -35 -> 51
    //   89: astore_2
    //   90: aload_1
    //   91: astore_0
    //   92: ldc 14
    //   94: aload_2
    //   95: invokestatic 238	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_1
    //   99: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   102: invokestatic 74	com/tencent/weiyun/poi/PoiDbManager:getInstance	()Lcom/tencent/weiyun/poi/PoiDbManager;
    //   105: aload 4
    //   107: invokevirtual 175	com/tencent/weiyun/poi/PoiDbManager:closePoiDb	(Lcom/tencent/weiyun/poi/PoiDbWrapper;)V
    //   110: aload_3
    //   111: areturn
    //   112: aload_1
    //   113: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   116: goto -14 -> 102
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: goto -7 -> 122
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_1
    //   135: goto -45 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   52	71	0	localCursor1	android.database.Cursor
    //   46	67	1	localCursor2	android.database.Cursor
    //   119	8	1	localObject1	Object
    //   128	1	1	localObject2	Object
    //   134	1	1	localObject3	Object
    //   89	6	2	localThrowable1	java.lang.Throwable
    //   132	1	2	localThrowable2	java.lang.Throwable
    //   7	104	3	localHashSet	java.util.HashSet
    //   15	91	4	localPoiDbWrapper	PoiDbWrapper
    // Exception table:
    //   from	to	target	type
    //   53	62	89	java/lang/Throwable
    //   64	86	89	java/lang/Throwable
    //   31	47	119	finally
    //   53	62	128	finally
    //   64	86	128	finally
    //   92	98	128	finally
    //   31	47	132	java/lang/Throwable
  }
  
  /* Error */
  private static List<PoiItem> singleQuery(PoiDbWrapper paramPoiDbWrapper, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    // Byte code:
    //   0: new 48	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   7: ldc 20
    //   9: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: ldc 250
    //   14: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 22
    //   19: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 252
    //   24: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore 15
    //   29: dload_1
    //   30: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   33: astore 9
    //   35: dload_3
    //   36: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   39: astore 10
    //   41: dload 5
    //   43: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   46: astore 11
    //   48: dload 7
    //   50: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   53: astore 12
    //   55: new 48	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   62: ldc 20
    //   64: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: bipush 44
    //   69: invokevirtual 56	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   72: ldc 22
    //   74: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 257
    //   80: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: sipush 200
    //   86: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: astore 14
    //   91: getstatic 40	com/tencent/weiyun/poi/PoiHelper:PROJ_ALL	[Ljava/lang/String;
    //   94: astore 13
    //   96: aload 15
    //   98: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore 15
    //   103: aload 14
    //   105: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: astore 14
    //   110: aload_0
    //   111: ldc 161
    //   113: aload 13
    //   115: aload 15
    //   117: iconst_4
    //   118: anewarray 18	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: aload 9
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload 10
    //   130: aastore
    //   131: dup
    //   132: iconst_2
    //   133: aload 11
    //   135: aastore
    //   136: dup
    //   137: iconst_3
    //   138: aload 12
    //   140: aastore
    //   141: aconst_null
    //   142: aconst_null
    //   143: aload 14
    //   145: invokevirtual 220	com/tencent/weiyun/poi/PoiDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +202 -> 352
    //   153: aload_0
    //   154: astore 9
    //   156: new 181	java/util/ArrayList
    //   159: dup
    //   160: aload_0
    //   161: invokeinterface 263 1 0
    //   166: invokespecial 266	java/util/ArrayList:<init>	(I)V
    //   169: astore 10
    //   171: aload 10
    //   173: astore 11
    //   175: aload_0
    //   176: astore 9
    //   178: aload_0
    //   179: invokeinterface 225 1 0
    //   184: ifeq +171 -> 355
    //   187: aload_0
    //   188: astore 9
    //   190: aload_0
    //   191: iconst_0
    //   192: invokeinterface 229 2 0
    //   197: aload_0
    //   198: iconst_1
    //   199: invokeinterface 229 2 0
    //   204: invokestatic 270	com/tencent/weiyun/data/PoiItem:createGpsInfo	(DD)Lcom/tencent/weiyun/data/PoiItem;
    //   207: astore 11
    //   209: aload_0
    //   210: astore 9
    //   212: aload 11
    //   214: aload_0
    //   215: iconst_2
    //   216: invokeinterface 274 2 0
    //   221: putfield 138	com/tencent/weiyun/data/PoiItem:nationType	I
    //   224: aload_0
    //   225: astore 9
    //   227: aload 11
    //   229: aload_0
    //   230: iconst_3
    //   231: invokeinterface 278 2 0
    //   236: putfield 149	com/tencent/weiyun/data/PoiItem:nationName	Ljava/lang/String;
    //   239: aload_0
    //   240: astore 9
    //   242: aload 11
    //   244: aload_0
    //   245: iconst_4
    //   246: invokeinterface 274 2 0
    //   251: putfield 154	com/tencent/weiyun/data/PoiItem:cityId	I
    //   254: aload_0
    //   255: astore 9
    //   257: aload 11
    //   259: aload_0
    //   260: iconst_5
    //   261: invokeinterface 278 2 0
    //   266: putfield 157	com/tencent/weiyun/data/PoiItem:cityName	Ljava/lang/String;
    //   269: aload_0
    //   270: astore 9
    //   272: aload 11
    //   274: aload_0
    //   275: bipush 6
    //   277: invokeinterface 278 2 0
    //   282: putfield 109	com/tencent/weiyun/data/PoiItem:poiId	Ljava/lang/String;
    //   285: aload_0
    //   286: astore 9
    //   288: aload 11
    //   290: aload_0
    //   291: bipush 7
    //   293: invokeinterface 278 2 0
    //   298: putfield 117	com/tencent/weiyun/data/PoiItem:poiName	Ljava/lang/String;
    //   301: aload_0
    //   302: astore 9
    //   304: aload 11
    //   306: aload_0
    //   307: bipush 8
    //   309: invokeinterface 278 2 0
    //   314: putfield 159	com/tencent/weiyun/data/PoiItem:address	Ljava/lang/String;
    //   317: aload_0
    //   318: astore 9
    //   320: aload 10
    //   322: aload 11
    //   324: invokeinterface 279 2 0
    //   329: pop
    //   330: goto -159 -> 171
    //   333: astore 11
    //   335: aload_0
    //   336: astore 9
    //   338: ldc 14
    //   340: aload 11
    //   342: invokestatic 238	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   345: aload_0
    //   346: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   349: aload 10
    //   351: areturn
    //   352: aconst_null
    //   353: astore 11
    //   355: aload_0
    //   356: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   359: aload 11
    //   361: areturn
    //   362: astore_0
    //   363: aconst_null
    //   364: astore 9
    //   366: aload 9
    //   368: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   371: aload_0
    //   372: athrow
    //   373: astore_0
    //   374: goto -8 -> 366
    //   377: astore 11
    //   379: aconst_null
    //   380: astore_0
    //   381: aconst_null
    //   382: astore 10
    //   384: goto -49 -> 335
    //   387: astore 11
    //   389: aconst_null
    //   390: astore 10
    //   392: goto -57 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramPoiDbWrapper	PoiDbWrapper
    //   0	395	1	paramDouble1	double
    //   0	395	3	paramDouble2	double
    //   0	395	5	paramDouble3	double
    //   0	395	7	paramDouble4	double
    //   33	334	9	localObject1	Object
    //   39	352	10	localObject2	Object
    //   46	277	11	localObject3	Object
    //   333	8	11	localThrowable1	java.lang.Throwable
    //   353	7	11	localList	List<PoiItem>
    //   377	1	11	localThrowable2	java.lang.Throwable
    //   387	1	11	localThrowable3	java.lang.Throwable
    //   53	86	12	str	String
    //   94	20	13	arrayOfString	String[]
    //   89	55	14	localObject4	Object
    //   27	89	15	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   178	187	333	java/lang/Throwable
    //   190	209	333	java/lang/Throwable
    //   212	224	333	java/lang/Throwable
    //   227	239	333	java/lang/Throwable
    //   242	254	333	java/lang/Throwable
    //   257	269	333	java/lang/Throwable
    //   272	285	333	java/lang/Throwable
    //   288	301	333	java/lang/Throwable
    //   304	317	333	java/lang/Throwable
    //   320	330	333	java/lang/Throwable
    //   91	149	362	finally
    //   156	171	373	finally
    //   178	187	373	finally
    //   190	209	373	finally
    //   212	224	373	finally
    //   227	239	373	finally
    //   242	254	373	finally
    //   257	269	373	finally
    //   272	285	373	finally
    //   288	301	373	finally
    //   304	317	373	finally
    //   320	330	373	finally
    //   338	345	373	finally
    //   91	149	377	java/lang/Throwable
    //   156	171	387	java/lang/Throwable
  }
  
  public static int updatePoi(PoiItem paramPoiItem)
  {
    if ((paramPoiItem == null) || ((TextUtils.isEmpty(paramPoiItem.poiId)) && (TextUtils.isEmpty(paramPoiItem.poiName)))) {
      return 0;
    }
    PoiDbWrapper localPoiDbWrapper = PoiDbManager.getInstance().openPoiDb(true);
    if (localPoiDbWrapper == null)
    {
      WyLog.e("PoiHelper", "updatePoi: Poi db is null.");
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("longitude", Double.valueOf(paramPoiItem.longitude));
    localContentValues.put("latitude", Double.valueOf(paramPoiItem.latitude));
    localContentValues.put("nation_type", Integer.valueOf(paramPoiItem.nationType));
    localContentValues.put("nation_name", paramPoiItem.nationName);
    localContentValues.put("city_id", Integer.valueOf(paramPoiItem.cityId));
    localContentValues.put("city_name", paramPoiItem.cityName);
    localContentValues.put("poi_id", paramPoiItem.poiId);
    localContentValues.put("poi_name", paramPoiItem.poiName);
    localContentValues.put("address", paramPoiItem.address);
    StringBuilder localStringBuilder = new StringBuilder().append("longitude").append("=? AND ").append("latitude").append("=?");
    String str = Double.toString(paramPoiItem.longitude);
    paramPoiItem = Double.toString(paramPoiItem.latitude);
    localPoiDbWrapper.beginTransaction();
    int i = localPoiDbWrapper.update("poi", localContentValues, localStringBuilder.toString(), new String[] { str, paramPoiItem });
    localPoiDbWrapper.setTransactionSuccessful();
    localPoiDbWrapper.endTransaction();
    PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiHelper
 * JD-Core Version:    0.7.0.1
 */