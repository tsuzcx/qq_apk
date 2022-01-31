import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopLocationActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class elo
  implements View.OnClickListener
{
  public elo(TroopLocationActivity paramTroopLocationActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopCreateLogic)this.a.app.getManager(29);
    if (paramView != null) {
      paramView.a(this.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     elo
 * JD-Core Version:    0.7.0.1
 */