import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wde
  implements View.OnClickListener
{
  public wde(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    TroopRequestActivity.a(this.this$0).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, "close warning tips");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wde
 * JD-Core Version:    0.7.0.1
 */