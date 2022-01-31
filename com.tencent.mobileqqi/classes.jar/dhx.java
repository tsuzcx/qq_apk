import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dhx
  implements View.OnClickListener
{
  public dhx(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a))
    {
      this.a.q();
      return;
    }
    if (NetworkUtil.b(this.a))
    {
      this.a.m();
      return;
    }
    DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131562272)).setMessage(2131563235).setPositiveButton(2131563186, new dhz(this)).setNegativeButton(2131561746, new dhy(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhx
 * JD-Core Version:    0.7.0.1
 */