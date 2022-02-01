import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class prc
  implements View.OnClickListener
{
  public prc(EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.val$editText.append("@");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prc
 * JD-Core Version:    0.7.0.1
 */