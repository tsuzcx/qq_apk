import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.a;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public class aoto
  implements AdapterView.e
{
  public aoto(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      this.this$0.mIndex = paramInt;
      if (this.this$0.a != null) {
        this.this$0.a.onItemSelect(paramInt);
      }
      if (!this.this$0.cOD) {
        anot.a(this.this$0.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.this$0.mTroopUin, "0", "", "");
      }
      while (TroopAvatarWallEditActivity.a(this.this$0) != null)
      {
        TroopAvatarWallEditActivity.a(this.this$0).Wh(paramInt);
        return;
        anot.a(this.this$0.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.this$0.mTroopUin, "1", "", "");
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoto
 * JD-Core Version:    0.7.0.1
 */