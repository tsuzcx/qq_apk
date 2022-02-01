import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;

class qmp
  implements View.OnLongClickListener
{
  qmp(qmo paramqmo) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    default: 
    case 2131371927: 
    case 2131378168: 
      do
      {
        do
        {
          return true;
          paramView = (psr)psx.a(10);
          if (((Boolean)paramView.c("player_show_debug_panel", Boolean.valueOf(false))).booleanValue()) {
            break;
          }
          bool = true;
          paramView.n("player_show_debug_panel", Boolean.valueOf(bool));
          paramView = ((StoryPlayerGroupHolder)this.this$0.a()).a();
        } while (paramView == null);
        paramView = (VideoViewVideoHolder)paramView.a(VideoViewVideoHolder.class);
      } while (paramView == null);
      if (bool) {}
      for (;;)
      {
        paramView.wp(i);
        return true;
        bool = false;
        break;
        i = 8;
      }
    }
    paramView = (psr)psx.a(10);
    if (!((Boolean)paramView.c("player_use_tvk", Boolean.valueOf(false))).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.n("player_use_tvk", Boolean.valueOf(bool));
      QQToast.a(this.this$0.getActivity(), "UserTVK: " + bool, 0).show();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmp
 * JD-Core Version:    0.7.0.1
 */