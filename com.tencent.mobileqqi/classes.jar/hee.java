import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hee
  implements ActionSheet.OnButtonClickListener
{
  public hee(TroopShareUtility paramTroopShareUtility) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (TroopShareUtility.a(this.a)) {}
    do
    {
      return;
      TroopShareUtility.a(this.a, -1);
      TroopShareUtility.b(this.a, -1);
      TroopShareUtility.a(this.a, true);
      TroopShareUtility.a(this.a).dismiss();
      switch (paramInt)
      {
      default: 
        TroopShareUtility.a(this.a, TroopShareUtility.a(this.a).e());
        return;
      case 0: 
        TroopShareUtility.a(this.a, 3);
        TroopShareUtility.a(this.a, TroopShareUtility.a(this.a).e());
        return;
      case 1: 
        TroopShareUtility.a(this.a, 4);
        TroopShareUtility.a(this.a, TroopShareUtility.a(this.a).e());
        return;
      case 2: 
        TroopShareUtility.a(this.a, 0);
        if (!TroopShareUtility.a(this.a).a) {
          break label208;
        }
        this.a.g();
      }
    } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
    ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
    return;
    label208:
    TroopShareUtility.a(this.a, TroopShareUtility.a(this.a).e());
    return;
    TroopShareUtility.a(this.a, 5);
    TroopShareUtility.a(this.a, TroopShareUtility.a(this.a).e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hee
 * JD-Core Version:    0.7.0.1
 */