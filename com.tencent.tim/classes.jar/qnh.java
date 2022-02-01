import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class qnh
  implements View.OnLongClickListener
{
  qnh(qng paramqng) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = 0;
    paramView = (psr)psx.a(10);
    boolean bool;
    if (!((Boolean)paramView.c("player_show_debug_panel", Boolean.valueOf(false))).booleanValue())
    {
      bool = true;
      paramView.n("player_show_debug_panel", Boolean.valueOf(bool));
      paramView = ((StoryPlayerGroupHolder)this.a.a()).a();
      if (paramView != null)
      {
        paramView = (VideoViewVideoHolder)paramView.a(VideoViewVideoHolder.class);
        if (paramView != null) {
          if (!bool) {
            break label90;
          }
        }
      }
    }
    for (;;)
    {
      paramView.wp(i);
      return true;
      bool = false;
      break;
      label90:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qnh
 * JD-Core Version:    0.7.0.1
 */