import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.multiVideo.MultiVideoAdFooterView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import java.util.HashSet;
import java.util.Set;

public class kme
  extends nba
{
  private Set<String> M = new HashSet();
  public kme.a a;
  private Handler mUIHandler = new kmf(this, Looper.getMainLooper());
  
  public kme(kme.a parama, nba.a parama1, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    super(parama1, paramVideoFeedsPlayManager, paramBoolean);
    this.a = parama;
  }
  
  public void a(VideoFeedsPlayManager.b paramb)
  {
    super.a(paramb);
    Log.d("MultiVideoAd", "onVideoStart");
    this.mUIHandler.sendEmptyMessageDelayed(101, 3000L);
    if ((this.a.d != null) && (this.a.d.isAD) && (this.a.d.b != null))
    {
      paramb = this.a.d.b.We;
      if (!this.M.contains(paramb))
      {
        this.M.add(paramb);
        paramb = jzk.a(this.a.d.b);
        if (!this.a.d.j(this.a.activity)) {
          break label187;
        }
        jzk.a(new kku.a().a(this.a.activity).a(jzk.aEK).b(jzk.aFA).a(paramb).a(this.a.d.b).a());
      }
    }
    return;
    label187:
    jzk.a(new kku.a().a(this.a.activity).a(jzk.aEK).b(jzk.aFy).a(paramb).a(this.a.d.b).a());
  }
  
  public void b(VideoFeedsPlayManager.b paramb)
  {
    super.b(paramb);
    Log.d("MultiVideoAd", "onVideoRestart");
    this.mUIHandler.removeMessages(101);
    this.mUIHandler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void c(VideoFeedsPlayManager.b paramb)
  {
    super.c(paramb);
    Log.d("MultiVideoAd", "onVideoStop");
    this.mUIHandler.removeMessages(101);
  }
  
  public void d(VideoFeedsPlayManager.b paramb)
  {
    super.d(paramb);
    Log.d("MultiVideoAd", "onVideoPause");
    this.mUIHandler.removeMessages(101);
  }
  
  public static class a
  {
    public Activity activity;
    public VideoInfo d;
    public MultiVideoAdFooterView d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kme
 * JD-Core Version:    0.7.0.1
 */