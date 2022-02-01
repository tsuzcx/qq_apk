import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ruf
  implements View.OnClickListener
{
  ruf(rud paramrud) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)this.a.view.findViewById(2131365360);
    if ((localTextView.getText() instanceof String)) {
      this.a.copyContent((String)localTextView.getText());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ruf
 * JD-Core Version:    0.7.0.1
 */