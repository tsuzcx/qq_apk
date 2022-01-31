import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;

public class bhr
  implements View.OnLongClickListener
{
  public bhr(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131298937, this.a.getString(2131363564));
    RegisterQQNumberActivity.a(this.a, MenuPopupDialog.a(RegisterQQNumberActivity.a(this.a), this.a.getString(2131363277), paramView, new bhs(this), new bht(this)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bhr
 * JD-Core Version:    0.7.0.1
 */