import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;

public class zmj
  implements blmh
{
  public zmj(ScrollFrameSelectBar paramScrollFrameSelectBar) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    yuk.a("Q.qqstory.frameWidget.ScrollFrameSelectBar", "onScrollStateChanged:%s", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
    case 4098: 
    case 4099: 
      do
      {
        return;
      } while (!ScrollFrameSelectBar.a(this.a).isPlaying());
      ScrollFrameSelectBar.a(this.a).c();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmj
 * JD-Core Version:    0.7.0.1
 */