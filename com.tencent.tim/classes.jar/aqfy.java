import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;

public class aqfy
  extends QAlbumUtil
{
  private static long asE;
  public static final int[] oV = { 0, 3000, 1 };
  
  public static int LP()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "MaxSelectVideoNum", 50);
  }
  
  public static int LQ()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "ShuoShuoMaxSelectVideoNum", 10);
  }
  
  public static String W(List<String> paramList)
  {
    Object localObject1 = new StringBuilder("_data");
    ((StringBuilder)localObject1).append(" IS NOT NULL AND ");
    ((StringBuilder)localObject1).append("_size");
    ((StringBuilder)localObject1).append(" > 0 ");
    Object localObject2 = localObject1;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (paramList.size() > 0)
      {
        ((StringBuilder)localObject1).append(" AND (");
        localObject2 = paramList.iterator();
        paramList = (List<String>)localObject1;
        int i = 1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          if (i == 0) {
            paramList.append(" OR ");
          }
          for (;;)
          {
            paramList.append(" ( ");
            paramList = a("bucket_id", paramList, (String)localObject1);
            paramList.append(" ) ");
            break;
            i = 0;
          }
        }
        paramList.append(" ) ");
        localObject2 = paramList;
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public static int a(List<String> paramList, int paramInt, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      if (paramMap2 != null) {
        paramList = (LocalMediaInfo)paramMap2.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = paramList;
        if (paramMap1 != null) {
          localObject = (LocalMediaInfo)paramMap1.get(str);
        }
      }
      if ((localObject == null) || (getMediaType((LocalMediaInfo)localObject) != 1))
      {
        long l = new File(str).length();
        if (l <= paramInt) {
          break label148;
        }
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "sendQualityPicLimit", true, paramInt, l, null, "");
        i += 1;
      }
    }
    label148:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static int a(List<String> paramList, long paramLong, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      if (paramMap2 != null) {
        paramList = (LocalMediaInfo)paramMap2.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = paramList;
        if (paramMap1 != null) {
          localObject = (LocalMediaInfo)paramMap1.get(str);
        }
      }
      if ((localObject == null) || (getMediaType((LocalMediaInfo)localObject) == 1))
      {
        if (new File(str).length() <= paramLong) {
          break label123;
        }
        i += 1;
      }
    }
    label123:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static int a(List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l;
      if ((paramHashMap != null) && (NetworkUtils.isNetworkUrl(str))) {
        if (paramHashMap.get(str) != null) {
          l = ((PhotoSendParams)paramHashMap.get(str)).fileSize;
        }
      }
      for (;;)
      {
        i = (int)(i + l);
        if (QLog.isColorLevel()) {
          QLog.d("_photo", 2, "setQualityTextViewText, path:" + str + ",len:" + l);
        }
        break;
        QLog.w("_photo", 1, "mSelectedSendParams.get(p) == null path:" + str);
        l = 0L;
        continue;
        paramList = null;
        if (paramMap2 != null) {
          paramList = (LocalMediaInfo)paramMap2.get(str);
        }
        if ((paramList == null) && (paramMap1 != null)) {
          paramList = (LocalMediaInfo)paramMap1.get(str);
        }
        l = new File(str).length();
      }
    }
    return i;
  }
  
  private static StringBuilder a(String paramString1, StringBuilder paramStringBuilder, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" = ");
    paramStringBuilder.append(paramString2);
    return paramStringBuilder;
  }
  
  public static List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    return queryRecentImages(paramContext, paramInt1, paramInt2, paramMediaFileFilter, false, 0, null, false);
  }
  
  /* Error */
  public static List<LocalMediaInfo> a(Context paramContext, int paramInt, List<String> paramList, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 189	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 190	java/util/ArrayList:<init>	()V
    //   10: astore 5
    //   12: aload_2
    //   13: invokestatic 192	aqfy:W	(Ljava/util/List;)Ljava/lang/String;
    //   16: astore_2
    //   17: getstatic 198	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: invokevirtual 204	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   23: astore 6
    //   25: aload 6
    //   27: ldc 206
    //   29: iload_1
    //   30: invokestatic 210	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: invokevirtual 216	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   36: pop
    //   37: aload 6
    //   39: invokevirtual 220	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   42: astore 6
    //   44: aload_0
    //   45: invokevirtual 226	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   48: aload 6
    //   50: getstatic 230	aqfy:columns	[Ljava/lang/String;
    //   53: aload_2
    //   54: aconst_null
    //   55: ldc 232
    //   57: invokestatic 238	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore_0
    //   61: aload_0
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_1
    //   66: iconst_0
    //   67: aload_3
    //   68: aconst_null
    //   69: iconst_0
    //   70: invokestatic 242	aqfy:getImageList	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/MediaFileFilter;Ljava/util/ArrayList;Z)V
    //   73: aload_0
    //   74: ifnull +9 -> 83
    //   77: aload_0
    //   78: invokeinterface 247 1 0
    //   83: aload 5
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +14 -> 106
    //   95: ldc 249
    //   97: iconst_2
    //   98: aload_2
    //   99: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: aload_2
    //   103: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: ifnull -24 -> 83
    //   110: aload_0
    //   111: invokeinterface 247 1 0
    //   116: aload 5
    //   118: areturn
    //   119: astore_0
    //   120: aload 4
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 247 1 0
    //   133: aload_0
    //   134: athrow
    //   135: astore_3
    //   136: aload_0
    //   137: astore_2
    //   138: aload_3
    //   139: astore_0
    //   140: goto -17 -> 123
    //   143: astore_3
    //   144: aload_0
    //   145: astore_2
    //   146: aload_3
    //   147: astore_0
    //   148: goto -25 -> 123
    //   151: astore_2
    //   152: goto -63 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramContext	Context
    //   0	155	1	paramInt	int
    //   0	155	2	paramList	List<String>
    //   0	155	3	paramMediaFileFilter	MediaFileFilter
    //   1	120	4	localObject1	Object
    //   10	107	5	localArrayList	java.util.ArrayList
    //   23	26	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	61	86	java/lang/Exception
    //   44	61	119	finally
    //   61	73	135	finally
    //   89	106	143	finally
    //   61	73	151	java/lang/Exception
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
  
  public static void a(TextView paramTextView, List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Activity paramActivity, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    label254:
    label255:
    for (;;)
    {
      LocalMediaInfo localLocalMediaInfo;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (NetworkUtils.isNetworkUrl(str)) {
          continue;
        }
        localLocalMediaInfo = null;
        if (paramMap2 != null) {
          localLocalMediaInfo = (LocalMediaInfo)paramMap2.get(str);
        }
        if ((localLocalMediaInfo != null) || (paramMap1 == null)) {
          break label254;
        }
        localLocalMediaInfo = (LocalMediaInfo)paramMap1.get(str);
      }
      for (;;)
      {
        if ((localLocalMediaInfo == null) || (getMediaType(localLocalMediaInfo) != 1)) {
          break label255;
        }
        break;
        int i = a(paramList, paramMap1, paramBoolean, paramHashMap, paramMap2);
        if (i == 0) {
          paramTextView.setVisibility(4);
        }
        do
        {
          return;
          paramMap1 = PhotoUtils.a(paramActivity, i);
          if (paramMap1.equals("0"))
          {
            paramMap1 = "(999K)";
            paramTextView.setVisibility(4);
          }
          for (;;)
          {
            int j = paramMap1.length();
            i = 0;
            while (i < 6 - j)
            {
              paramMap1 = paramMap1 + " ";
              i += 1;
            }
            paramMap1 = "(" + paramMap1 + ")";
            paramTextView.setVisibility(0);
          }
          paramTextView.setText(paramMap1);
        } while (!paramList.isEmpty());
        paramTextView.setVisibility(4);
        return;
      }
    }
  }
  
  public static void a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      paramLocalMediaInfo.mediaHeight = localOptions.outHeight;
      paramLocalMediaInfo.mediaWidth = localOptions.outWidth;
      paramLocalMediaInfo.mMimeType = localOptions.outMimeType;
      paramLocalMediaInfo.addedDate = System.currentTimeMillis();
      paramLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      paramLocalMediaInfo.path = paramString;
      paramLocalMediaInfo.panoramaPhotoType = 3;
      paramLocalMediaInfo.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramLocalMediaInfo)
    {
      QLog.e("AlbumUtil", 2, "decode image error", paramLocalMediaInfo);
    }
  }
  
  public static boolean a(Context paramContext, int paramInt, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramLocalMediaInfo != null) && (getMediaType(paramLocalMediaInfo) == 1)) {
      if (!paramBoolean) {
        break label222;
      }
    }
    label222:
    for (int i = LQ();; i = LP())
    {
      paramBoolean = bool;
      if (paramInt >= i)
      {
        if (System.currentTimeMillis() - asE > 2000L)
        {
          QQToast.a(paramContext, acfp.m(2131702364) + i + acfp.m(2131702365), 0).show();
          asE = System.currentTimeMillis();
        }
        paramBoolean = false;
      }
      long l = avpw.iO();
      if (paramLocalMediaInfo.fileSize > l)
      {
        QQToast.a(paramContext, acfp.m(2131702363) + (float)l / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).show();
        paramBoolean = false;
      }
      if (paramLocalMediaInfo.mDuration <= 601000L) {
        break;
      }
      QQToast.a(paramContext, acfp.m(2131702362) + 10L + acfp.m(2131702366), 0).show();
      return false;
    }
    return paramBoolean;
  }
  
  public static boolean a(List<String> paramList, Activity paramActivity, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() >= paramInt))
    {
      QQToast.a(paramActivity, String.format(paramActivity.getResources().getString(2131718884), new Object[] { Integer.valueOf(paramInt) }), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299627));
      return true;
    }
    return false;
  }
  
  public static String ba(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static String bb(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  public static float bz()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "photoGroupListImageCropSpaceRatio", 0.25F);
  }
  
  public static void clearCache() {}
  
  public static void dN(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false))
    {
      String str = paramIntent.getStringExtra("ALBUM_ID");
      paramIntent = paramIntent.getStringExtra("PhotoConst.LAST_ALBUMPATH");
      if ((paramIntent != null) && (str != null))
      {
        sLastAlbumPath = paramIntent;
        sLastAlbumRecordTime = System.currentTimeMillis();
      }
    }
  }
  
  public static void edD()
  {
    sLastAlbumPhotoCountMap.clear();
    sLastAlbumPath = null;
    sLastAlbumRecordTime = 0L;
    sLastAlbumId = null;
    sLastAlbumName = null;
  }
  
  public static void edE()
  {
    anot.a(null, "CliOper", "", "", "0X8009E98", "0X8009E98", 0, 0, "", "", "", "");
  }
  
  public static void ki(int paramInt1, int paramInt2)
  {
    anot.a(null, "CliOper", "", "", "0X8009E99", "0X8009E99", 0, 0, paramInt1 + "", paramInt2 + "", "", "");
  }
  
  public static boolean mq(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = oV;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfy
 * JD-Core Version:    0.7.0.1
 */