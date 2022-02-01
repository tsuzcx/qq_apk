import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jga
  implements View.OnClickListener
{
  jga(jfz paramjfz) {}
  
  public void onClick(View paramView)
  {
    jfz.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jga
 * JD-Core Version:    0.7.0.1
 */