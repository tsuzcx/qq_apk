import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.widget.ActionSheet;

public class bcf
  implements View.OnClickListener
{
  public bcf(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcf
 * JD-Core Version:    0.7.0.1
 */