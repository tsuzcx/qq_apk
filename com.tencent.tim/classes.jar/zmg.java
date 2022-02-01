import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zmg
  implements View.OnClickListener
{
  zmg(zme paramzme) {}
  
  public void onClick(View paramView)
  {
    this.b.v.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmg
 * JD-Core Version:    0.7.0.1
 */