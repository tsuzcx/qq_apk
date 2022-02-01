import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.timfiletab.dialog.FileApplicationDialog.1.1;
import com.tencent.tim.timfiletab.dialog.FileApplicationDialog.1.2;
import java.lang.ref.WeakReference;

public class aunm
  implements aulh.a
{
  aunm(aunl paramaunl) {}
  
  public void b(Long paramLong1, Long paramLong2)
  {
    Activity localActivity = (Activity)aunl.a(this.a).get();
    if (localActivity != null) {
      localActivity.runOnUiThread(new FileApplicationDialog.1.1(this, paramLong1, paramLong2));
    }
    QLog.d("FileApplicationDialog", 1, "file_app: onResult= " + paramLong1 + "    " + paramLong2);
  }
  
  public void onError(String paramString)
  {
    Activity localActivity = (Activity)aunl.a(this.a).get();
    if (localActivity != null) {
      localActivity.runOnUiThread(new FileApplicationDialog.1.2(this));
    }
    QLog.e("FileApplicationDialog", 1, "file_app: onError= " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunm
 * JD-Core Version:    0.7.0.1
 */