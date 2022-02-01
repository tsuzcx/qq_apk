import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ywr
  implements View.OnClickListener
{
  public ywr(ShowExternalTroopListActivity paramShowExternalTroopListActivity, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    aqep.a(this.this$0.context, this.ug, this.this$0.aZM, 0);
    QQAppInterface localQQAppInterface = this.this$0.app;
    String str2 = this.this$0.aZM;
    if (this.this$0.xv) {}
    for (String str1 = "0";; str1 = "1")
    {
      anot.a(localQQAppInterface, "P_CliOper", "Grp_join", "", "person_data", "Clk_user", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywr
 * JD-Core Version:    0.7.0.1
 */