import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vni
  implements View.OnClickListener
{
  public vni(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.I.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vni
 * JD-Core Version:    0.7.0.1
 */