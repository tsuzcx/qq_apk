import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

public class jlj
  implements DialogInterface.OnShowListener
{
  public jlj(TraeHelper paramTraeHelper) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1E at: " + System.currentTimeMillis());
    }
    anot.a(null, "CliOper", "", "", "0X8008D1E", "0X8008D1E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlj
 * JD-Core Version:    0.7.0.1
 */