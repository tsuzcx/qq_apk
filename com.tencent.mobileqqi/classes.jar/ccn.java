import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ccn
  implements View.OnClickListener
{
  public ccn(BookShareAdviceEditActivity paramBookShareAdviceEditActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c < 0)
    {
      QQToast.a(this.a, 1, this.a.getString(2131561490), 0).b(this.a.d());
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.a, 2131562452, 0).b(this.a.d());
      return;
    }
    if (this.a.a == null)
    {
      QQToast.a(this.a, 2131561769, 0).b(this.a.d());
      return;
    }
    BookShareAdviceEditActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ccn
 * JD-Core Version:    0.7.0.1
 */