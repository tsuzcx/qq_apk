import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import java.io.File;

public class qlo
  implements qlb
{
  private String TAG = "VideoViewTextureImpl";
  TextureVideoView b;
  qle.a c = new qle.a();
  
  public qlo(Context paramContext, String paramString)
  {
    this.b = new TextureVideoView(paramContext.getApplicationContext());
    this.TAG += paramString;
  }
  
  public qle.a a()
  {
    return this.c;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.c.vid = paramString1;
    this.c.isLocal = true;
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString3;
      if (pnh.s(new File(paramString2))) {
        paramString1 = paramString2;
      }
    }
    ram.w(this.TAG, "setVideoPath");
    this.b.setVideoPath(paramString1);
  }
  
  public void a(qlb.a parama)
  {
    TextureVideoView localTextureVideoView = this.b;
    if (parama == null) {}
    for (parama = null;; parama = new qlp(this, parama))
    {
      localTextureVideoView.setOnCompletionListener(parama);
      return;
    }
  }
  
  public void a(qlb.b paramb) {}
  
  public void a(qlb.c paramc)
  {
    Object localObject = null;
    TextureVideoView localTextureVideoView = this.b;
    if (paramc == null) {}
    for (paramc = localObject;; paramc = new qlq(this, paramc, null))
    {
      localTextureVideoView.setOnErrorListener(paramc);
      return;
    }
  }
  
  public void a(qlb.d paramd)
  {
    TextureVideoView localTextureVideoView = this.b;
    if (paramd == null) {}
    for (paramd = null;; paramd = new qlr(this, paramd))
    {
      localTextureVideoView.setOnInfoListener(paramd);
      return;
    }
  }
  
  public void a(qlb.e parame)
  {
    TextureVideoView localTextureVideoView = this.b;
    if (parame == null) {}
    for (parame = null;; parame = new qls(this, parame))
    {
      localTextureVideoView.setOnPreparedListener(parame);
      return;
    }
  }
  
  public void destroy() {}
  
  public long getCurrentPosition()
  {
    return this.b.getCurrentPosition();
  }
  
  public long getDuration()
  {
    return this.b.getDuration();
  }
  
  public int getPlayType()
  {
    return 0;
  }
  
  public View getView()
  {
    return this.b;
  }
  
  public boolean isPlaying()
  {
    return this.b.isPlaying();
  }
  
  public void pause()
  {
    ram.w(this.TAG, "pause");
    this.b.pause();
  }
  
  public void restart()
  {
    ram.w(this.TAG, "restart");
    start();
  }
  
  public int sI()
  {
    return 1;
  }
  
  @TargetApi(14)
  public void setVisibility(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void start()
  {
    ram.w(this.TAG, "start");
    this.b.start();
  }
  
  public void stopPlayback()
  {
    ram.w(this.TAG, "stopPlayback");
    this.b.stopPlayback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlo
 * JD-Core Version:    0.7.0.1
 */