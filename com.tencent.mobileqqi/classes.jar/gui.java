import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopLocationActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class gui
  implements View.OnClickListener
{
  public gui(TroopLocationActivity paramTroopLocationActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopCreateLogic)this.a.b.getManager(30);
    if (paramView != null) {
      paramView.a(this.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gui
 * JD-Core Version:    0.7.0.1
 */