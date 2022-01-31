import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class bl
  implements DialogInterface.OnClickListener
{
  public bl(LiteActivity paramLiteActivity, AbsShareMsg paramAbsShareMsg, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(LiteActivity.a, 2, "qbShowShareResultDialog back");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
        ForwardOperations.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid);
      }
      Util.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.finish();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bl
 * JD-Core Version:    0.7.0.1
 */