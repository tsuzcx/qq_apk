import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class tgw
  implements View.OnClickListener
{
  public tgw(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(this.a)) {
      this.a.x();
    }
    for (;;)
    {
      QQMapRoutingHelper.a("see_streetview");
      return;
      if (NetworkUtil.a(this.a)) {
        this.a.p();
      } else {
        DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131436428)).setMessage(2131436427).setPositiveButton(2131436429, new tgy(this)).setNegativeButton(2131432998, new tgx(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgw
 * JD-Core Version:    0.7.0.1
 */