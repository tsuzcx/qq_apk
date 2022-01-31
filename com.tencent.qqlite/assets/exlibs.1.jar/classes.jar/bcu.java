import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bcu
  implements View.OnClickListener
{
  public bcu(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a))
    {
      this.a.p();
      return;
    }
    if (NetworkUtil.b(this.a))
    {
      this.a.l();
      return;
    }
    DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131364123)).setMessage(2131364122).setPositiveButton(2131364124, new bcw(this)).setNegativeButton(2131362794, new bcv(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcu
 * JD-Core Version:    0.7.0.1
 */