import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.qphone.base.util.QLog;

public class at
  implements DialogInterface.OnClickListener
{
  public at(LiteActivity paramLiteActivity, long paramLong, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).dismiss();
      return;
      if (QLog.isColorLevel()) {
        QLog.i(LiteActivity.a, 2, "qbShowShareResultDialog back");
      }
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("MigSdkShareNotDone", false))
      {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().putExtra("MigSdkShareNotDone", false);
        ForwardOperations.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true, "sendToMyComputer", this.jdField_a_of_type_Long);
      }
      for (;;)
      {
        Util.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.finish();
        break;
        ForwardOperations.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true, "shareToQQ", this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("MigSdkShareNotDone", false)) {
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().putExtra("MigSdkShareNotDone", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     at
 * JD-Core Version:    0.7.0.1
 */