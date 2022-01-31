import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.international.activity.FeedbackActivity;

public class bxk
  implements View.OnClickListener
{
  public bxk(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent(this.a, FeedbackActivity.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxk
 * JD-Core Version:    0.7.0.1
 */