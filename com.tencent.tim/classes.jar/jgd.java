import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jgd
  implements View.OnClickListener
{
  jgd(jfz paramjfz) {}
  
  public void onClick(View paramView)
  {
    if ((jfz.a(this.a) != null) && (jfz.a(this.a).isShown())) {
      this.a.avV();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jfz.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgd
 * JD-Core Version:    0.7.0.1
 */