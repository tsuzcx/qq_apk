import android.view.View;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;

public class xjk
  implements Runnable
{
  public xjk(QzoneHbFragment paramQzoneHbFragment) {}
  
  public void run()
  {
    QzoneHbFragment.a(this.a).startAnimation(QzoneHbFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjk
 * JD-Core Version:    0.7.0.1
 */