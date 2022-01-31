import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class esf
  implements Runnable
{
  public esf(qfileJumpActivity paramqfileJumpActivity) {}
  
  public void run()
  {
    DataLineReportUtil.r(this.a.b);
    Intent localIntent = new Intent(this.a, LiteActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("leftViewText", this.a.b.a().getString(2131561692));
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     esf
 * JD-Core Version:    0.7.0.1
 */