import UserGrowth.stCollection;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

public class ure
{
  private static stSchema a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str3 = paramstSimpleMetaFeed.new_icon.h5_url;
    String str2 = paramstSimpleMetaFeed.new_icon.schema_url;
    String str1 = str2;
    if (TextUtils.isEmpty(str3))
    {
      str1 = str2;
      if (!uqh.a(str2)) {
        str1 = uqh.a(paramstSimpleMetaFeed);
      }
    }
    paramstSimpleMetaFeed = new stSchema();
    paramstSimpleMetaFeed.schema = str1;
    paramstSimpleMetaFeed.H5Url = str3;
    return paramstSimpleMetaFeed;
  }
  
  private static WSDownloadParams a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt, String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = usd.a(paramWSVerticalPageFragment.a());
    localWSDownloadParams.mLinkStrategyType = ugd.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = uqt.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.collection == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.a();
    String str2 = paramWSVerticalPageFragment.b();
    if ((paramstSimpleMetaFeed.collection.click_action == 2) && (a(paramstSimpleMetaFeed.collection.schema)))
    {
      new uje(paramWSVerticalPageFragment.getActivity()).a(paramstSimpleMetaFeed.collection.schema).a(a(paramWSVerticalPageFragment, 16, paramstSimpleMetaFeed.collection.schema.schema)).a(new urf(str1, str2, paramstSimpleMetaFeed)).a();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstSimpleMetaFeed);
    WSVerticalPageFragment.a(paramWSVerticalPageFragment.getActivity(), "vertical_layer_collection", str2, localArrayList, 0);
    c(str1, str2, paramstSimpleMetaFeed, 1000001);
  }
  
  public static void a(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.poster == null) || (paramstSimpleMetaFeed.poster.avatarSchema == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.a();
    String str2 = paramWSVerticalPageFragment.b();
    stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaFeed.poster;
    new uje(paramWSVerticalPageFragment.getActivity()).a(localstSimpleMetaPerson.avatarSchema).a(a(paramWSVerticalPageFragment, 1, localstSimpleMetaPerson.avatarSchema.schema)).a(new urh(str1, str2, paramString, paramstSimpleMetaFeed)).a();
  }
  
  private static boolean a(stSchema paramstSchema)
  {
    if (paramstSchema == null) {}
    while ((TextUtils.isEmpty(paramstSchema.miniAppSchema)) && (TextUtils.isEmpty(paramstSchema.schema)) && (TextUtils.isEmpty(paramstSchema.H5Url))) {
      return false;
    }
    return true;
  }
  
  public static void b(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null)) {
      return;
    }
    if (uqh.a(paramstSimpleMetaFeed.feed_material_jump_url)) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.feed_material_jump_url; zqd.a(BaseApplicationImpl.getContext()); paramstSimpleMetaFeed = uqh.a(paramstSimpleMetaFeed))
    {
      uqh.a(paramWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramstSimpleMetaFeed);
      return;
    }
    ugz.a(paramWSVerticalPageFragment.getActivity(), a(paramWSVerticalPageFragment, 3, paramstSimpleMetaFeed), true);
  }
  
  private static void b(String paramString, int paramInt1, int paramInt2)
  {
    uoi.a(paramString, paramInt1, paramInt2);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    uvv.a(paramString1, paramString2, paramString3, paramInt, paramstSimpleMetaFeed);
  }
  
  public static void c(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.new_icon == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.a();
    String str2 = paramWSVerticalPageFragment.b();
    Object localObject = paramstSimpleMetaFeed.new_icon;
    int i = ((stNewIconStyle)localObject).tag_type;
    int j = ((stNewIconStyle)localObject).id;
    localObject = a(paramstSimpleMetaFeed);
    new uje(paramWSVerticalPageFragment.getActivity()).a((stSchema)localObject).a(true).a(a(paramWSVerticalPageFragment, 4, ((stSchema)localObject).schema)).a(new urg(str1, str2, paramstSimpleMetaFeed, i, j)).a();
  }
  
  private static void c(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    uvv.a(paramString1, paramString2, paramstSimpleMetaFeed, paramInt);
  }
  
  private static void d(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    uvv.d(paramString1, paramString2, paramInt, paramstSimpleMetaFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ure
 * JD-Core Version:    0.7.0.1
 */