import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;

public class naq
{
  public static abstract interface a
  {
    public abstract void Jw();
    
    public abstract naq.b a(int paramInt);
    
    public abstract void a(View paramView, int paramInt, FrameLayout.LayoutParams paramLayoutParams);
    
    public abstract void a(nap.a<naq.b> parama);
    
    public abstract void aRC();
    
    public abstract void aRD();
    
    public abstract void aUp();
    
    public abstract void aVf();
    
    public abstract long cX();
    
    public abstract void dc(int paramInt1, int paramInt2);
    
    public abstract void ox(boolean paramBoolean);
    
    public abstract void td(int paramInt);
    
    public abstract void te(int paramInt);
    
    public abstract void tf(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void HN();
    
    public abstract void S(float paramFloat);
    
    public abstract void aEz();
    
    public abstract VideoFeedsPlayManager.b b();
    
    public abstract void d(VideoInfo paramVideoInfo);
    
    public abstract VideoInfo i();
    
    public abstract void mq(boolean paramBoolean);
    
    public abstract void nY(boolean paramBoolean);
    
    public abstract void onScrollStateChanged(int paramInt);
    
    public abstract void ox(boolean paramBoolean);
    
    public abstract int qn();
  }
  
  static abstract interface c
  {
    public abstract void aVg();
    
    public abstract void doOnDestory();
    
    public abstract void tg(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void Q(VideoInfo paramVideoInfo);
    
    public abstract boolean Q(boolean paramBoolean);
    
    public abstract void R(VideoInfo paramVideoInfo);
    
    public abstract void S(VideoInfo paramVideoInfo);
    
    public abstract void T(VideoInfo paramVideoInfo);
    
    public abstract void U(VideoInfo paramVideoInfo);
    
    public abstract VideoFeedsPlayManager a();
    
    public abstract msx a();
    
    public abstract void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2);
    
    public abstract void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, naf paramnaf, View paramView);
    
    public abstract void a(naq.b paramb);
    
    public abstract boolean a(nai paramnai);
    
    public abstract boolean a(naq.b paramb);
    
    public abstract void aTi();
    
    public abstract void aVh();
    
    public abstract ArrayList<VideoInfo> bg();
    
    public abstract void doOnDestory();
    
    public abstract void doOnPause();
    
    public abstract void doOnResume();
    
    @Nullable
    public abstract VideoInfo f();
    
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     naq
 * JD-Core Version:    0.7.0.1
 */