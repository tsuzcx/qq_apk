import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;

class dr
  implements DialogInterface.OnClickListener
{
  dr(dq paramdq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.status < 10) {
      this.a.jdField_a_of_type_Dm.b.g(0, this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_Dm.b.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord);
    this.a.jdField_a_of_type_Dm.cj();
    this.a.jdField_a_of_type_Dm.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dr
 * JD-Core Version:    0.7.0.1
 */