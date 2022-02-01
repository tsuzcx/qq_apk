import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sru
  implements View.OnClickListener
{
  sru(srs paramsrs) {}
  
  public void onClick(View paramView)
  {
    srs.a(this.this$0).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sru
 * JD-Core Version:    0.7.0.1
 */