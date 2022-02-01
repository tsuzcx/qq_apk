import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class ai
  implements View.OnClickListener
{
  public ai(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    anpb.F(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_ckadv");
    Intent localIntent = new Intent(this.this$0, LiteAdvanceActivity.class);
    localIntent.putExtra("targetUin", this.this$0.aR);
    this.this$0.startActivityForResult(localIntent, 7);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ai
 * JD-Core Version:    0.7.0.1
 */