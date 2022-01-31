import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class abh
  implements View.OnClickListener
{
  public abh(BookShareAdviceEditActivity paramBookShareAdviceEditActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c < 0)
    {
      QQToast.a(this.a, 1, this.a.getString(2131364142), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.a, 2131362785, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (this.a.a == null)
    {
      QQToast.a(this.a, 2131364146, 0).b(this.a.getTitleBarHeight());
      return;
    }
    BookShareAdviceEditActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abh
 * JD-Core Version:    0.7.0.1
 */