import android.app.Activity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;

public class kmc
{
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = jzk.a(paramVideoInfo.b);
    if (paramVideoInfo.j(paramActivity))
    {
      jzk.a(new kku.a().a(paramActivity).a(jzk.aEJ).b(jzk.aFA).a(localAdvertisementInfo).a(paramVideoInfo.b).d(paramInt).a());
      return;
    }
    jzk.a(new kku.a().a(paramActivity).a(jzk.aEJ).b(jzk.aFy).a(localAdvertisementInfo).a(paramVideoInfo.b).d(paramInt).a());
  }
  
  public static void a(Activity paramActivity, int paramInt, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    if (paramVideoInfo.isAD)
    {
      if (!paramADVideoAppDownloadManager.d(paramVideoInfo)) {
        break label33;
      }
      ods.b(paramActivity, paramAdvertisementInfo, null, 3, true, null);
    }
    for (;;)
    {
      a(paramActivity, paramInt, paramVideoInfo);
      return;
      label33:
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramADVideoAppDownloadManager = new kks();
      paramADVideoAppDownloadManager.afZ = true;
      ods.b(paramActivity, paramAdvertisementInfo, null, 3, true, paramADVideoAppDownloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmc
 * JD-Core Version:    0.7.0.1
 */