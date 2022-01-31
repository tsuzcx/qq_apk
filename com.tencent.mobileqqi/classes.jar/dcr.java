import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class dcr
  implements View.OnClickListener
{
  public dcr(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.i)
    {
      this.a.p();
      return;
    }
    this.a.setResult(-1, this.a.a());
    this.a.finish();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dcr
 * JD-Core Version:    0.7.0.1
 */