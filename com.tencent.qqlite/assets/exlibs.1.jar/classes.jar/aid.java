import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DetailProfileActivity;

public class aid
  implements View.OnClickListener
{
  public aid(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (this.a.a.getWindow() != null)) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aid
 * JD-Core Version:    0.7.0.1
 */