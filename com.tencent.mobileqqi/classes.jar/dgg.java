import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class dgg
  implements View.OnLongClickListener
{
  public dgg(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131234878, this.a.getString(2131561879));
    RegisterQQNumberActivity.a(this.a, BubbleContextMenu.a(RegisterQQNumberActivity.a(this.a), paramView, new dgh(this), null));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgg
 * JD-Core Version:    0.7.0.1
 */