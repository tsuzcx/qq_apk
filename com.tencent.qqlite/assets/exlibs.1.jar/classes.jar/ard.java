import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.qphone.base.util.QLog;

public class ard
  implements Runnable
{
  public ard(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void run()
  {
    int i = (int)(35.0F * this.a.a);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "reqWidth is:" + i + ",reqHeight is:" + i);
    }
    Bitmap localBitmap = IndividuationSetActivity.a(this.a, i, i);
    if (localBitmap != null) {
      this.a.runOnUiThread(new are(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ard
 * JD-Core Version:    0.7.0.1
 */