import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class qiq
  implements View.OnClickListener
{
  qiq(qip paramqip) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
    if (localObject != null) {
      ((VideoViewVideoHolder)localObject).bmH = 2;
    }
    this.a.n().finish();
    String str = "";
    localObject = str;
    if (this.a.bmu >= 0)
    {
      localObject = str;
      if (this.a.bmu < this.a.nR.size()) {
        localObject = ((qjq)this.a.nR.get(this.a.bmu)).vid;
      }
    }
    rar.a("play_video", "clk_quit", 0, 0, new String[] { "", "", "", localObject });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qiq
 * JD-Core Version:    0.7.0.1
 */