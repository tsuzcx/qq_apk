import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

public class uzc
{
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    vmp.e("WSVideoPreloadManager", "[prepareRecommendFloatPageData] download cache video");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstSimpleMetaFeed);
    b(paramstSimpleMetaFeed);
    vnd.a(localArrayList, false);
    uzf.a().b(localArrayList);
  }
  
  public static void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {}
    WSVideoPreDownloadManager localWSVideoPreDownloadManager;
    boolean bool;
    do
    {
      return;
      localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.sApplication);
      bool = localWSVideoPreDownloadManager.a(paramstSimpleMetaFeed.video_url);
      vmp.a("WSVideoPreloadManager", "sec itemInfo : " + paramstSimpleMetaFeed + "; isCached = " + bool);
    } while (bool);
    localWSVideoPreDownloadManager.a(new uzd(paramstSimpleMetaFeed));
    localWSVideoPreDownloadManager.a(new uze(localWSVideoPreDownloadManager, paramstSimpleMetaFeed.video_url));
    localWSVideoPreDownloadManager.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzc
 * JD-Core Version:    0.7.0.1
 */