import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class bcb
  implements View.OnClickListener
{
  public bcb(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    QQBrowserActivity.b(this.a).setVisibility(8);
    this.a.b.setVisibility(8);
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcb
 * JD-Core Version:    0.7.0.1
 */