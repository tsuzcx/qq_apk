import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ske
  implements View.OnClickListener
{
  public ske(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(View paramView)
  {
    EditUniqueTitleActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ske
 * JD-Core Version:    0.7.0.1
 */