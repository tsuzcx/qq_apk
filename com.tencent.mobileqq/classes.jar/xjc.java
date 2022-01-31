import android.widget.Button;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;

public class xjc
  implements Runnable
{
  public xjc(CommonHbFragment paramCommonHbFragment) {}
  
  public void run()
  {
    if ("1".equals(CommonHbFragment.f(this.a))) {
      CommonHbFragment.b(this.a).performClick();
    }
    do
    {
      return;
      if ("2".equals(CommonHbFragment.f(this.a)))
      {
        CommonHbFragment.c(this.a).performClick();
        return;
      }
    } while (!"3".equals(CommonHbFragment.f(this.a)));
    CommonHbFragment.d(this.a).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjc
 * JD-Core Version:    0.7.0.1
 */