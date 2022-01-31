import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;

public class ab
  implements DialogInterface.OnClickListener
{
  public ab(LiteActivity paramLiteActivity, AsyncTask paramAsyncTask, DataLineHandler.EFILETYPE paramEFILETYPE) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new DataLineHandler.EFILETYPE[] { this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler$EFILETYPE });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ab
 * JD-Core Version:    0.7.0.1
 */