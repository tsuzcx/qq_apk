import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awyx
  implements View.OnClickListener
{
  awyx(awyw paramawyw) {}
  
  public void onClick(View paramView)
  {
    awyw.a(this.a).p(655364, new Object[] { "热门玩法", "vt_pag_jiaopiangushi" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyx
 * JD-Core Version:    0.7.0.1
 */