import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gzz
  implements ActionSheet.OnButtonClickListener
{
  public gzz(TroopShareUtility paramTroopShareUtility) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (TroopShareUtility.b(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "OnClick.chooseLinkType: " + paramInt);
    }
    TroopShareUtility.b(this.a, true);
    switch (paramInt)
    {
    default: 
      TroopShareUtility.a(this.a, -1);
      TroopShareUtility.b(this.a, -1);
      if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
      }
      break;
    }
    for (;;)
    {
      TroopShareUtility.b(this.a).dismiss();
      return;
      TroopShareUtility.b(this.a, 1);
      TroopShareUtility.a(this.a);
      continue;
      TroopShareUtility.b(this.a, 0);
      TroopShareUtility.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gzz
 * JD-Core Version:    0.7.0.1
 */