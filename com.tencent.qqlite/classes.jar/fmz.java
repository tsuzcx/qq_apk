import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qqfav.QfavBuilder;

public class fmz
  implements View.OnClickListener
{
  public fmz(QfavBuilder paramQfavBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((QfavBuilder.a(this.a) != null) && (QfavBuilder.a(this.a).isShowing())) {
      QfavBuilder.a(this.a).dismiss();
    }
    QfavBuilder.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fmz
 * JD-Core Version:    0.7.0.1
 */