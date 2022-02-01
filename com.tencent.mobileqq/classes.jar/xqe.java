import android.annotation.TargetApi;
import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1;

public class xqe
  implements xsb
{
  public xqe(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a(xrt paramxrt, int paramInt1, int paramInt2)
  {
    if (this.a.getHandler() == null) {
      return;
    }
    this.a.getHandler().post(new TextureVideoView.1.1(this, paramxrt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqe
 * JD-Core Version:    0.7.0.1
 */