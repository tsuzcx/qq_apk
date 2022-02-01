import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoex
  implements View.OnClickListener
{
  aoex(aoeq paramaoeq) {}
  
  public void onClick(View paramView)
  {
    this.this$0.aR.setText("");
    this.this$0.dUp();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoex
 * JD-Core Version:    0.7.0.1
 */