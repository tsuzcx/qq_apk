import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class srv
  implements View.OnClickListener
{
  srv(srs paramsrs) {}
  
  public void onClick(View paramView)
  {
    srs.b(this.this$0).setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srv
 * JD-Core Version:    0.7.0.1
 */