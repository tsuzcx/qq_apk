import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;

public class gyy
  implements View.OnClickListener
{
  public gyy(TroopTagViewActivity paramTroopTagViewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, TroopTagViewActivity.class);
    paramView.putExtra("troopuin", TroopTagViewActivity.a(this.a));
    paramView.putExtra("tags", TroopTagViewActivity.b(this.a));
    paramView.putExtra("act_type", 2);
    paramView.putExtra("modifyToSrv", this.a.d);
    if ((this.a.getAppRuntime() instanceof BrowserAppInterface)) {
      paramView.putExtra("uin", ((BrowserAppInterface)this.a.getAppRuntime()).a());
    }
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gyy
 * JD-Core Version:    0.7.0.1
 */