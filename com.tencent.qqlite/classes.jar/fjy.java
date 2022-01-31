import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class fjy
  implements View.OnClickListener
{
  public fjy(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fjy
 * JD-Core Version:    0.7.0.1
 */