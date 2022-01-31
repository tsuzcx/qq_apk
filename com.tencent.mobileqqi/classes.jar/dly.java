import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class dly
  implements View.OnLongClickListener
{
  public dly(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131234877, this.a.getString(2131561879));
    RegisterQQNumberActivity.a(this.a, BubbleContextMenu.a(RegisterQQNumberActivity.a(this.a), paramView, new dlz(this), null));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dly
 * JD-Core Version:    0.7.0.1
 */