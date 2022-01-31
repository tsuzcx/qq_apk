import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;

public class tnq
  implements Runnable
{
  public tnq(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (QQLSActivity.c(this.a) != null) {
      QQLSActivity.a(this.a).removeView(QQLSActivity.c(this.a));
    }
    QQLSActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnq
 * JD-Core Version:    0.7.0.1
 */