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

public class opw
{
  private static stSchema a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str3 = paramstSimpleMetaFeed.new_icon.h5_url;
    String str2 = paramstSimpleMetaFeed.new_icon.schema_url;
    String str1 = str2;
    if (TextUtils.isEmpty(str3))
    {
      str1 = str2;
      if (!opb.eH(str2)) {
        str1 = opb.d(paramstSimpleMetaFeed);
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
    localWSDownloadParams.mScene = oql.aX(paramWSVerticalPageFragment.getFrom());
    localWSDownloadParams.mLinkStrategyType = ohy.a().rp();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = opn.getSceneTypeTestId(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.collection == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.getFrom();
    String str2 = paramWSVerticalPageFragment.getPlayScene();
    if ((paramstSimpleMetaFeed.collection.click_action == 2) && (a(paramstSimpleMetaFeed.collection.schema)))
    {
      new ojw(paramWSVerticalPageFragment.getActivity()).a(paramstSimpleMetaFeed.collection.schema).a(a(paramWSVerticalPageFragment, 16, paramstSimpleMetaFeed.collection.schema.schema)).a(new opx(str1, str2, paramstSimpleMetaFeed)).bfC();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstSimpleMetaFeed);
    WSVerticalPageFragment.a(paramWSVerticalPageFragment.getActivity(), "vertical_layer_collection", str2, localArrayList, 0);
    a(str1, str2, paramstSimpleMetaFeed, 1000001);
  }
  
  public static void a(String paramString, WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.poster == null) || (paramstSimpleMetaFeed.poster.avatarSchema == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.getFrom();
    String str2 = paramWSVerticalPageFragment.getPlayScene();
    stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaFeed.poster;
    new ojw(paramWSVerticalPageFragment.getActivity()).a(localstSimpleMetaPerson.avatarSchema).a(a(paramWSVerticalPageFragment, 1, localstSimpleMetaPerson.avatarSchema.schema)).a(new opz(str1, str2, paramString, paramstSimpleMetaFeed)).bfC();
  }
  
  private static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    osv.a(paramString1, paramString2, paramstSimpleMetaFeed, paramInt);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    osv.a(paramString1, paramString2, paramString3, paramInt, paramstSimpleMetaFeed);
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
    if (opb.eH(paramstSimpleMetaFeed.feed_material_jump_url)) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.feed_material_jump_url; rpw.isWeishiInstalled(BaseApplicationImpl.getContext()); paramstSimpleMetaFeed = opb.d(paramstSimpleMetaFeed))
    {
      opb.p(paramWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramstSimpleMetaFeed);
      return;
    }
    oir.a(paramWSVerticalPageFragment.getActivity(), a(paramWSVerticalPageFragment, 3, paramstSimpleMetaFeed), true);
  }
  
  private static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    osv.d(paramString1, paramString2, paramInt, paramstSimpleMetaFeed);
  }
  
  public static void c(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramWSVerticalPageFragment == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.new_icon == null)) {
      return;
    }
    String str1 = paramWSVerticalPageFragment.getFrom();
    String str2 = paramWSVerticalPageFragment.getPlayScene();
    stSchema localstSchema = a(paramstSimpleMetaFeed);
    new ojw(paramWSVerticalPageFragment.getActivity()).a(localstSchema).a(true).a(a(paramWSVerticalPageFragment, 4, localstSchema.schema)).a(new opy(str1, str2, paramstSimpleMetaFeed)).bfC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opw
 * JD-Core Version:    0.7.0.1
 */