import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gul
  implements ActionSheet.OnButtonClickListener
{
  public gul(TroopLocationModifyActivity paramTroopLocationModifyActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TroopLocationModifyActivity.a(this.a);
    if (paramInt == 0) {
      TroopLocationModifyActivity.a(this.a, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gul
 * JD-Core Version:    0.7.0.1
 */