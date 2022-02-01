import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ynu
  implements View.OnClickListener
{
  public ynu(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.aN.setText("");
    if ((this.this$0.mSource == ClassificationSearchActivity.cad) || (this.this$0.mSource == ClassificationSearchActivity.cag)) {
      ClassificationSearchActivity.a(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.a.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynu
 * JD-Core Version:    0.7.0.1
 */