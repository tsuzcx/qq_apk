import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class ae
  implements View.OnClickListener
{
  public ae(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    StatisticAssist.a(this.a.b.getApplication().getApplicationContext(), this.a.b.a(), "dl_ckadv");
    paramView = new Intent(this.a, LiteAdvanceActivity.class);
    this.a.startActivityForResult(paramView, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ae
 * JD-Core Version:    0.7.0.1
 */