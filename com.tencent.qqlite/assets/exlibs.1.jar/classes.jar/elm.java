import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class elm
  implements ActionSheet.OnButtonClickListener
{
  public elm(TroopLocationModifyActivity paramTroopLocationModifyActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    TroopLocationModifyActivity.a(this.a);
    if (paramInt == 0) {
      TroopLocationModifyActivity.a(this.a, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     elm
 * JD-Core Version:    0.7.0.1
 */