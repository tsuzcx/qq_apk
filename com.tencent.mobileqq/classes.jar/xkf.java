import android.annotation.TargetApi;
import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1;

public class xkf
  implements xmc
{
  public xkf(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a(xlu paramxlu, int paramInt1, int paramInt2)
  {
    if (this.a.getHandler() == null) {
      return;
    }
    this.a.getHandler().post(new TextureVideoView.1.1(this, paramxlu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkf
 * JD-Core Version:    0.7.0.1
 */