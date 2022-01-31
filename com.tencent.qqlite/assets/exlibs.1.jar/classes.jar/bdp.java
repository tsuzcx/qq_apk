import android.content.res.Resources;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;

class bdp
  implements Runnable
{
  bdp(bdm parambdm) {}
  
  public void run()
  {
    this.a.a.a.a(this.a.a.getString(2131362609));
    int i = QQMapActivity.c(this.a.a).getDimensionPixelSize(2131492887);
    QQToast.a(this.a.a, 1, this.a.a.getString(2131362603), 1).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bdp
 * JD-Core Version:    0.7.0.1
 */