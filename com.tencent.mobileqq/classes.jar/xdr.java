import android.view.View;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;

public class xdr
  implements Runnable
{
  public xdr(QzoneHbFragment paramQzoneHbFragment) {}
  
  public void run()
  {
    QzoneHbFragment.a(this.a).startAnimation(QzoneHbFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdr
 * JD-Core Version:    0.7.0.1
 */