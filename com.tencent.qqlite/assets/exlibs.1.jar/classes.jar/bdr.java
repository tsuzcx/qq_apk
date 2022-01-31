import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class bdr
  implements View.OnClickListener
{
  public bdr(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.i)
    {
      this.a.o();
      return;
    }
    this.a.setResult(-1, this.a.a());
    this.a.finish();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bdr
 * JD-Core Version:    0.7.0.1
 */