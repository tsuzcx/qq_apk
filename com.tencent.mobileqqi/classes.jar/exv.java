import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.voip.VoipAddressBookView;
import com.tencent.mobileqq.activity.voip.VoipPhoneNumber;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.List;

public class exv
  implements DialogInterface.OnClickListener
{
  public exv(VoipAddressBookView paramVoipAddressBookView, PhoneContact paramPhoneContact) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VoipAddressBookView.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipAddressBookView, (VoipPhoneNumber)this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.allPhoneNumber.get(paramInt));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exv
 * JD-Core Version:    0.7.0.1
 */