import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.MessageForText;

class xjb
  implements DialogInterface.OnClickListener
{
  xjb(xiz paramxiz, MessageForText paramMessageForText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ujt.b(this.jdField_a_of_type_Xiz.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText);
    ujt.e(this.jdField_a_of_type_Xiz.app, this.jdField_a_of_type_Xiz.mContext, this.jdField_a_of_type_Xiz.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg);
    this.jdField_a_of_type_Xiz.adapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjb
 * JD-Core Version:    0.7.0.1
 */