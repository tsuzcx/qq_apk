import com.tencent.mobileqq.ar.FaceUIController;
import com.tencent.mobileqq.ar.ScanningData;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class zzm
  implements ARTipsManager.BaikeClickListener
{
  public zzm(ScanningSurfaceView paramScanningSurfaceView, ScanningData paramScanningData) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "onContentClick wikiurl = " + this.jdField_a_of_type_ComTencentMobileqqArScanningData.c);
    }
    ScanningSurfaceView.b(this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView, this.jdField_a_of_type_ComTencentMobileqqArScanningData.c);
    ReportController.b(null, "dc00898", "", "", "0X8008351", "0X8008351", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzm
 * JD-Core Version:    0.7.0.1
 */