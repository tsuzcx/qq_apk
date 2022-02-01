import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yvl
  implements View.OnClickListener
{
  yvl(yvj paramyvj) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)this.a.a.findViewById(2131365073);
    if ((localTextView.getText() instanceof String)) {
      this.a.a((String)localTextView.getText());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvl
 * JD-Core Version:    0.7.0.1
 */