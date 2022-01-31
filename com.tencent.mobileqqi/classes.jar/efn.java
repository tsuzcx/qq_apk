import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;

public class efn
  implements DialogInterface.OnDismissListener
{
  public efn(BaseTroopView paramBaseTroopView, int paramInt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.b.setVisibility(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efn
 * JD-Core Version:    0.7.0.1
 */