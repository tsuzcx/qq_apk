import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

class ayhr
  implements View.OnClickListener
{
  ayhr(ayhq paramayhq) {}
  
  public void onClick(View paramView)
  {
    if (ayhq.a(this.a) != null)
    {
      if ((ayhq.a(this.a).RU() != 1) || (ayhq.a(this.a) != 1)) {
        break label71;
      }
      ayhq.a(this.a);
      ayhq.a(this.a).setImageResource(2130848553);
      ayhq.a(this.a, 2);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label71:
      if ((ayhq.a(this.a).RU() == 2) && (ayhq.a(this.a) == 2))
      {
        ayhq.b(this.a);
        ayhq.a(this.a).setImageResource(2130848554);
        ayhq.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhr
 * JD-Core Version:    0.7.0.1
 */