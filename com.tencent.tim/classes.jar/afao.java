import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afao
  implements View.OnClickListener
{
  public afao(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.post(this.this$0.gn, 8, null, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afao
 * JD-Core Version:    0.7.0.1
 */