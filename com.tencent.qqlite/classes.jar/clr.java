import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentAdapter;

public class clr
  implements DialogInterface.OnDismissListener
{
  public clr(RecentAdapter paramRecentAdapter, View paramView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clr
 * JD-Core Version:    0.7.0.1
 */