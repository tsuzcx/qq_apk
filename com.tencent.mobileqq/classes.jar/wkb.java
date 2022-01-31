import android.widget.ImageView;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessActivity.AnimationDrawable2;

public class wkb
  implements Runnable
{
  public wkb(BlessActivity paramBlessActivity) {}
  
  public void run()
  {
    BlessActivity.a(this.a).setBackgroundDrawable(this.a.a);
    BlessActivity.a(this.a).setVisibility(0);
    this.a.a.start();
    BlessActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkb
 * JD-Core Version:    0.7.0.1
 */