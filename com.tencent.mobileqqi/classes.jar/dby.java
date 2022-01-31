import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.widget.XEditTextEx;

public class dby
  implements Runnable
{
  public dby(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if ((QQLSActivity.a(this.a).getVisibility() == 0) && (!TextUtils.isEmpty(QQLSActivity.a(this.a).getText()))) {
      return;
    }
    QQLSActivity.a(this.a);
    QQLSActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dby
 * JD-Core Version:    0.7.0.1
 */