import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class wnf
  implements View.OnClickListener
{
  public wnf(EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    this.a.append("@");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnf
 * JD-Core Version:    0.7.0.1
 */