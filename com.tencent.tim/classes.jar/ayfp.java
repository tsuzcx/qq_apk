import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;

class ayfp
  implements DialogInterface.OnDismissListener
{
  ayfp(ayfh paramayfh, ayov paramayov) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Ayfh.b.changeState(0);
    ayfh.a(this.jdField_a_of_type_Ayfh).setText(this.jdField_a_of_type_Ayov.getText());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfp
 * JD-Core Version:    0.7.0.1
 */