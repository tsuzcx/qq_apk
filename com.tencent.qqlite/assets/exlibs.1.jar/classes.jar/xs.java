import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class xs
  implements View.OnClickListener
{
  public xs(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      long l = Long.valueOf(this.a.app.a()).longValue();
      this.a.a.a(l, Long.valueOf(AddRequestActivity.a(this.a)).longValue(), 1);
      return;
    }
    QQToast.a(this.a, 2131363516, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xs
 * JD-Core Version:    0.7.0.1
 */