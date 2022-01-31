import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.qphone.base.util.QLog;

public class cxd
  implements Runnable
{
  public cxd(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void run()
  {
    int i = (int)(this.a.getResources().getDisplayMetrics().density * 35.0F);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "reqWidth is:" + i + ",reqHeight is:" + i);
    }
    Bitmap localBitmap = IndividuationSetActivity.a(this.a, i, i);
    if (localBitmap != null) {
      this.a.runOnUiThread(new cxe(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxd
 * JD-Core Version:    0.7.0.1
 */