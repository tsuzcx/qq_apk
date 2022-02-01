import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;

public class assc
  implements View.OnFocusChangeListener
{
  public assc(Login paramLogin) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.bH)
    {
      if (true == paramBoolean) {
        this.a.bH.selectAll();
      }
      if (!paramBoolean) {
        this.a.Kj.setVisibility(4);
      }
    }
    while ((paramView != this.a.bG) || (paramBoolean)) {
      return;
    }
    this.a.Ar.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assc
 * JD-Core Version:    0.7.0.1
 */