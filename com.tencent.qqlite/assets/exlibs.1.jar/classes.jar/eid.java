import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mobileqq.troop.activity.FavOpenTroopActivity.TroopAdapter;

public class eid
  implements DialogInterface.OnDismissListener
{
  public eid(FavOpenTroopActivity.TroopAdapter paramTroopAdapter, View paramView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eid
 * JD-Core Version:    0.7.0.1
 */