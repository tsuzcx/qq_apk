import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yoi
  implements View.OnClickListener
{
  public yoi(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.aN.setText("");
    if (this.a.mFrom != 1) {
      this.a.a.clear();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoi
 * JD-Core Version:    0.7.0.1
 */