import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troopreward.OrientationAdapterImageView;
import com.tencent.qphone.base.util.QLog;

public class apze
  extends Handler
{
  public apze(OrientationAdapterImageView paramOrientationAdapterImageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.gA != null) {
      this.a.invalidate();
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrientationAdapterImageView", 2, "handleMessage:" + this.a.che + "," + this.a.gA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apze
 * JD-Core Version:    0.7.0.1
 */