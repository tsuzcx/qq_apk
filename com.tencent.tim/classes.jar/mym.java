import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.3.1;
import com.tencent.mobileqq.app.ThreadManager;

public class mym
  implements kxv.a
{
  public mym(VideoPreDownloadMgr paramVideoPreDownloadMgr, int paramInt) {}
  
  public void b(kxz paramkxz)
  {
    if (TextUtils.isEmpty(paramkxz.url)) {
      return;
    }
    ThreadManager.post(new VideoPreDownloadMgr.3.1(this, paramkxz), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mym
 * JD-Core Version:    0.7.0.1
 */