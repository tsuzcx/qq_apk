import android.view.View;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class erf
  implements ActionSheet.OnButtonClickListener
{
  public erf(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(View paramView, int paramInt)
  {
    if (TroopShareUtility.a(this.a)) {
      return;
    }
    TroopShareUtility.a(this.a, -1);
    TroopShareUtility.b(this.a, -1);
    TroopShareUtility.a(this.a, true);
    TroopShareUtility.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erf
 * JD-Core Version:    0.7.0.1
 */