import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class bp
  implements View.OnClickListener
{
  public bp(LiteVideoActivity paramLiteVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a) && (NetworkUtil.f(this.a)) && (!NetworkUtil.g(this.a)) && (LiteVideoActivity.a(this.a) > LiteVideoActivity.a()))
    {
      LiteVideoActivity.a(this.a);
      return;
    }
    LiteVideoActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bp
 * JD-Core Version:    0.7.0.1
 */