import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class zcc
  implements HorizontalListView.OnScrollStateChangedListener
{
  public zcc(ScrollFrameSelectBar paramScrollFrameSelectBar) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    ykq.a("Q.qqstory.frameWidget.ScrollFrameSelectBar", "onScrollStateChanged:%s", Integer.valueOf(paramInt));
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
 * Qualified Name:     zcc
 * JD-Core Version:    0.7.0.1
 */