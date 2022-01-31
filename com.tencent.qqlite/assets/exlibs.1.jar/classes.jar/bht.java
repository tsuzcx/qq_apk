import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;

public class bht
  implements View.OnLongClickListener
{
  public bht(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131298988, this.a.getString(2131363570));
    RegisterQQNumberActivity.a(this.a, MenuPopupDialog.a(RegisterQQNumberActivity.a(this.a), this.a.getString(2131363274), paramView, new bhu(this), new bhv(this)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bht
 * JD-Core Version:    0.7.0.1
 */