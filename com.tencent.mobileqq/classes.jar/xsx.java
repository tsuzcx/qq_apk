import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;

class xsx
  implements View.OnLongClickListener
{
  xsx(xsw paramxsw) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    default: 
    case 2131371277: 
    case 2131377349: 
      do
      {
        do
        {
          return true;
          paramView = (wpf)wpm.a(10);
          if (((Boolean)paramView.b("player_show_debug_panel", Boolean.valueOf(false))).booleanValue()) {
            break;
          }
          bool = true;
          paramView.b("player_show_debug_panel", Boolean.valueOf(bool));
          paramView = ((StoryPlayerGroupHolder)this.a.a()).a();
        } while (paramView == null);
        paramView = (VideoViewVideoHolder)paramView.a(VideoViewVideoHolder.class);
      } while (paramView == null);
      if (bool) {}
      for (;;)
      {
        paramView.a(i);
        return true;
        bool = false;
        break;
        i = 8;
      }
    }
    paramView = (wpf)wpm.a(10);
    if (!((Boolean)paramView.b("player_use_tvk", Boolean.valueOf(false))).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.b("player_use_tvk", Boolean.valueOf(bool));
      QQToast.a(this.a.b(), "UserTVK: " + bool, 0).a();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsx
 * JD-Core Version:    0.7.0.1
 */