import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;

public class ax
  implements DialogInterface.OnClickListener
{
  public ax(LiteActivity paramLiteActivity, AsyncTask paramAsyncTask, DataLineHandler.EFILETYPE paramEFILETYPE) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new DataLineHandler.EFILETYPE[] { this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler$EFILETYPE });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ax
 * JD-Core Version:    0.7.0.1
 */