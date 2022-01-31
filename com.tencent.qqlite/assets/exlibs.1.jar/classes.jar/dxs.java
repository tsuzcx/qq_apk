import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;

public class dxs
  implements DialogInterface.OnDismissListener
{
  public dxs(RoamLocalSearchBar paramRoamLocalSearchBar) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog = null;
    paramDialogInterface = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130968605);
    this.a.startAnimation(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dxs
 * JD-Core Version:    0.7.0.1
 */