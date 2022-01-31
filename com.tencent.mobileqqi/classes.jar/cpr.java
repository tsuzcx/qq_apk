import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;

public class cpr
  implements View.OnClickListener
{
  public cpr(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!EditActivity.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      EditActivity.a(paramView, bool);
      if (!EditActivity.a(this.a)) {
        break;
      }
      this.a.f();
      EditActivity.a(this.a).setImageResource(2130837653);
      if (EditActivity.a(this.a) != null) {
        EditActivity.a(this.a).setVisibility(0);
      }
      return;
    }
    if (EditActivity.a(this.a) != null) {
      EditActivity.a(this.a).setVisibility(4);
    }
    EditActivity.a(this.a).setImageResource(2130839367);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cpr
 * JD-Core Version:    0.7.0.1
 */