import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;

public class mvx
  implements kxv.a
{
  public mvx(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, kxv paramkxv) {}
  
  public void b(kxz paramkxz)
  {
    VideoFeedsPlayManager.b localb = (VideoFeedsPlayManager.b)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.a).get();
    Object localObject1 = (myi)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.a).get();
    if (paramkxz == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
    }
    label399:
    label541:
    label672:
    label682:
    label690:
    label698:
    do
    {
      Object localObject2;
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback code=" + paramkxz.errorCode + ", vid=" + paramkxz.vid + ", url=" + paramkxz.url + ", isH265=" + paramkxz.aiJ + ", isHWCodec=" + paramkxz.Tx + ", fileBitRate=" + paramkxz.adD + ", hwBackupUrl=" + paramkxz.adF);
              }
            } while ((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.a)) && (!VideoFeedsPlayManager.a(this.a.this$0, (myi)localObject1)));
            if ((localb == null) || (!paramkxz.vid.equals(localb.d.vid))) {
              break label698;
            }
            if (paramkxz.errorCode != 2) {
              break;
            }
          } while (VideoFeedsPlayManager.a(this.a.this$0) == null);
          VideoFeedsPlayManager.a(this.a.this$0).a((myi)localObject1, 123, 108, 0, "vid2url failed, video deleted", null);
          return;
          if (!TextUtils.isEmpty(paramkxz.url)) {
            break;
          }
        } while (VideoFeedsPlayManager.a(this.a.this$0) == null);
        VideoFeedsPlayManager.a(this.a.this$0).a((myi)localObject1, 123, 107, 0, "vid2url failed, get null", null);
        return;
        localObject2 = VideoFeedsPlayManager.a(this.a.this$0);
        if (localObject2 != null)
        {
          ((myi)localObject1).aqr = ((VideoPreDownloadMgr)localObject2).I(paramkxz.url, paramkxz.vid);
          ((VideoPreDownloadMgr)localObject2).ak(localb.d.vid, ((myi)localObject1).aqr);
        }
        if (paramkxz.videoType != 1) {
          break;
        }
        ((myi)localObject1).a(paramkxz.vid, paramkxz.url, 104, this.val$position, 0L, localb.d.duration, paramkxz.Tx, true, localb.apw);
        if (!paramkxz.aiJ) {
          break label672;
        }
        i = 1;
        ((myi)localObject1).aVZ = i;
      } while (localb.c == null);
      localb.c.vz = this.c.r.longValue();
      localb.c.aSo = paramkxz.errorCode;
      localb.c.aiJ = paramkxz.aiJ;
      localb.c.adD = paramkxz.adD;
      localb.c.Tx = paramkxz.Tx;
      localb.c.amE = false;
      localb.c.ahy = "";
      localb.c.videoReportInfo = paramkxz.videoReportInfo;
      localb.c.adE = paramkxz.adE;
      localObject1 = localb.c;
      boolean bool;
      if (!TextUtils.isEmpty(paramkxz.adF))
      {
        bool = true;
        ((mhu)localObject1).amG = bool;
      }
      for (;;)
      {
        try
        {
          localObject1 = new URL(paramkxz.url).getHost();
          paramkxz = aopd.a().a((String)localObject1, 1006);
          localObject2 = localb.c;
          if (paramkxz != null) {
            break label682;
          }
          i = 0;
          ((mhu)localObject2).aSv = i;
          localObject2 = localb.c;
          if (paramkxz != null) {
            break label690;
          }
          paramkxz = "";
          ((mhu)localObject2).ahB = paramkxz;
          localb.c.ahA = ((String)localObject1);
          return;
        }
        catch (Exception paramkxz)
        {
          return;
        }
        ((myi)localObject1).a(paramkxz.vid, paramkxz.url, 101, this.val$position, 0L, localb.d.duration, paramkxz.Tx, true, localb.apw, paramkxz.adF);
        break;
        i = 0;
        break label399;
        bool = false;
        break label541;
        i = paramkxz.size();
        continue;
        paramkxz = paramkxz.toString();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramkxz.vid + " url:" + paramkxz.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvx
 * JD-Core Version:    0.7.0.1
 */