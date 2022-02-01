import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.widget.HorizontalListView.d;

public class rnn
  implements HorizontalListView.d
{
  public rnn(ScrollFrameSelectBar paramScrollFrameSelectBar) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    ram.b("Q.qqstory.frameWidget.ScrollFrameSelectBar", "onScrollStateChanged:%s", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
    case 4098: 
    case 4099: 
      do
      {
        return;
      } while (!ScrollFrameSelectBar.a(this.b).isPlaying());
      ScrollFrameSelectBar.a(this.b).pausePlay();
      return;
    }
    this.b.bvD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnn
 * JD-Core Version:    0.7.0.1
 */