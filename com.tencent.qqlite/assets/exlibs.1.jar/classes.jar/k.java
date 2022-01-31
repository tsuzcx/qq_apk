import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class k
  implements View.OnClickListener
{
  public k(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckadv");
    paramView = new Intent(this.a, LiteAdvanceActivity.class);
    this.a.startActivityForResult(paramView, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     k
 * JD-Core Version:    0.7.0.1
 */