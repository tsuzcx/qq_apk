import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar.a;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar.b;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar.b.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qgm
  implements View.OnClickListener
{
  public qgm(VideoCoverListBar.b.a parama, VideoCoverListBar.b paramb) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverListBar.a(this.a.b.this$0) != null) {
      VideoCoverListBar.a(this.a.b.this$0).rG(VideoCoverListBar.b.a.a(this.a));
    }
    rar.a("play_video", "clk_mini", 0, 0, new String[] { "2", "", "", VideoCoverListBar.b.a.a(this.a) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgm
 * JD-Core Version:    0.7.0.1
 */