import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.a;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.c;
import com.tencent.qphone.base.util.QLog;

public class nwr
  implements kxv.a
{
  public nwr(VideoPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable) {}
  
  public void b(kxz paramkxz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramkxz.vid + ", url=" + paramkxz.url + ", isH265=" + paramkxz.aiJ + ", isHWCodec=" + paramkxz.Tx + ", fileBitRate=" + paramkxz.adD);
    }
    if ((VideoPlayManager.PlayStartVideoRunnable.a(this.a) != null) && (paramkxz.vid.equals(VideoPlayManager.PlayStartVideoRunnable.a(this.a).b.vid))) {
      if (TextUtils.isEmpty(paramkxz.url)) {
        if (VideoPlayManager.a(this.a.this$0) != null) {
          VideoPlayManager.a(this.a.this$0).a(null, 123, 107, 0, "vid2url failed, get null", null);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (paramkxz.videoType == 1)
      {
        VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramkxz.vid, paramkxz.url, 104, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).b.duration, paramkxz.Tx, true, false);
        return;
      }
      VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramkxz.vid, paramkxz.url, 101, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).b.duration, paramkxz.Tx, true, false);
      return;
    }
    QLog.d("Viola.VideoPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramkxz.vid + " url:" + paramkxz.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwr
 * JD-Core Version:    0.7.0.1
 */