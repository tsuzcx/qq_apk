import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bcw
  implements View.OnClickListener
{
  public bcw(QQMapActivity paramQQMapActivity) {}
  
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
    DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131364138)).setMessage(2131364137).setPositiveButton(2131364139, new bcy(this)).setNegativeButton(2131362790, new bcx(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcw
 * JD-Core Version:    0.7.0.1
 */