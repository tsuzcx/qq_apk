import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stNewIconStyle;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.List;

public class tmo
{
  public static int a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    if (paramWSVerticalPageFragment != null) {
      return a(paramWSVerticalPageFragment.a());
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    return i;
  }
  
  public static List<thx> a(List<tmv> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    int i = paramInt;
    if (i < paramInt + 3)
    {
      tmv localtmv;
      if (paramList.size() > i)
      {
        localtmv = (tmv)paramList.get(i);
        if ((localtmv.a() instanceof stSimpleMetaFeed)) {
          break label66;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label66:
        localArrayList.add(a((stSimpleMetaFeed)localtmv.a()));
      }
    }
    return localArrayList;
  }
  
  private static thx a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    thx localthx = new thx(paramstSimpleMetaFeed.video_url, paramstSimpleMetaFeed.video.duration);
    localthx.a = paramstSimpleMetaFeed.id;
    return localthx;
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt3, Object paramObject)
  {
    paramstSimpleMetaFeed = new stReportItem();
    if (xoo.a(paramActivity))
    {
      paramstSimpleMetaFeed.optype = 114;
      if (paramInt1 == 8)
      {
        paramstSimpleMetaFeed.pagetype = 10;
        paramstSimpleMetaFeed.optype = 129;
      }
    }
    for (;;)
    {
      paramObject = new WSDownloadParams();
      paramObject.mScene = paramInt2;
      paramObject.mLinkStrategyType = tee.a().a();
      paramObject.mEventId = paramInt1;
      paramObject.mTestId = tlv.a(paramInt2);
      paramObject.mStReportItem = paramstSimpleMetaFeed;
      paramObject.mScheme = paramString;
      a(paramActivity, paramString, paramObject);
      return;
      paramstSimpleMetaFeed.optype = 115;
      if (paramInt1 == 8)
      {
        paramstSimpleMetaFeed.pagetype = 10;
        paramstSimpleMetaFeed.optype = 130;
      }
    }
  }
  
  private static void a(Activity paramActivity, String paramString, WSDownloadParams paramWSDownloadParams)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramWSDownloadParams != null))
    {
      tlo.b("WSVerticalUtils", "downloadOrGoWeishiSchema:" + paramWSDownloadParams.toString());
      if (xoo.a(paramActivity)) {
        tlq.a(paramActivity, "biz_src_jc_gzh_weishi", paramString, paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
      }
    }
    else
    {
      return;
    }
    tfa.a(paramActivity, paramWSDownloadParams, true);
  }
  
  public static void a(Context paramContext, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2)
  {
    if ((paramContext == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.new_icon == null)) {
      return;
    }
    Object localObject = paramstSimpleMetaFeed.new_icon;
    String str2 = ((stNewIconStyle)localObject).h5_url;
    String str1 = ((stNewIconStyle)localObject).schema_url;
    tlo.b("WSVerticalUtils", "BottomButton schemeUrl = " + str1 + ", h5Url = " + str2);
    localObject = str1;
    if (TextUtils.isEmpty(str2))
    {
      localObject = str1;
      if (!tlq.a(str1)) {
        localObject = tlq.a(paramstSimpleMetaFeed);
      }
    }
    tlv.a(paramContext, (String)localObject, str2, "", 0, new tmp(paramContext, paramInt2, paramstSimpleMetaFeed, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmo
 * JD-Core Version:    0.7.0.1
 */