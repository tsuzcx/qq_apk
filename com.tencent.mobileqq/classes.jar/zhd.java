import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class zhd
  implements SensorEventListener
{
  private WeakReference<ScannerView> a;
  
  public zhd(ScannerView paramScannerView)
  {
    this.a = new WeakReference(paramScannerView);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    ScannerView localScannerView = (ScannerView)this.a.get();
    if (localScannerView != null) {
      localScannerView.a(paramSensorEvent);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ScannerView", 2, "onSensorChanged but mRef got null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zhd
 * JD-Core Version:    0.7.0.1
 */