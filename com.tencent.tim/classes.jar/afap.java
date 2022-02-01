import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class afap
  implements View.OnClickListener
{
  public afap(DBFixConfigActivity paramDBFixConfigActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    boolean bool = aqhq.copyFile(this.this$0.getDatabasePath(this.val$uin + ".db"), new File(this.this$0.getExternalCacheDir(), this.val$uin + System.currentTimeMillis() + ".db"));
    QLog.e(DBFixConfigActivity.TAG, 2, "copy " + bool + this.val$uin);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afap
 * JD-Core Version:    0.7.0.1
 */