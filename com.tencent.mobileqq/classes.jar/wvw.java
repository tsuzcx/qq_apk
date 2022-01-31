import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class wvw
  implements Runnable
{
  public wvw(qfileJumpActivity paramqfileJumpActivity) {}
  
  public void run()
  {
    DataLineReportUtil.r(this.a.app);
    Intent localIntent = new Intent(this.a, LiteActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("targetUin", this.a.a);
    localIntent.putExtra("leftViewText", this.a.app.getApp().getString(2131433681));
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     wvw
 * JD-Core Version:    0.7.0.1
 */