import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zoi
  implements View.OnClickListener
{
  public zoi(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onClick(View paramView)
  {
    EditUniqueTitleActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoi
 * JD-Core Version:    0.7.0.1
 */