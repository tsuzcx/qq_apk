import android.annotation.TargetApi;
import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1;

public class wvk
  implements wxh
{
  public wvk(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a(wwz paramwwz, int paramInt1, int paramInt2)
  {
    if (this.a.getHandler() == null) {
      return;
    }
    this.a.getHandler().post(new TextureVideoView.1.1(this, paramwwz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvk
 * JD-Core Version:    0.7.0.1
 */