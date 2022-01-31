import com.tencent.mobileqq.ar.FaceUIController;
import com.tencent.mobileqq.ar.ScanningData;
import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.qphone.base.util.QLog;

public class zzn
  implements Runnable
{
  public zzn(ScanningSurfaceView paramScanningSurfaceView, ScanningData paramScanningData1, ScanningData paramScanningData2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArScanningData != null) && (this.jdField_a_of_type_ComTencentMobileqqArScanningData.a) && (this.jdField_a_of_type_ComTencentMobileqqArScanningData.f))
    {
      this.jdField_a_of_type_ComTencentMobileqqArScanningData.c();
      this.jdField_a_of_type_ComTencentMobileqqArScanningData.w();
      this.jdField_a_of_type_ComTencentMobileqqArScanningData.a = false;
      if (QLog.isColorLevel()) {
        QLog.d("ScanningSurfaceView", 2, "4=" + this.jdField_a_of_type_ComTencentMobileqqArScanningData.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqArScanningData.c = false;
      ScanningSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView, this.jdField_a_of_type_ComTencentMobileqqArScanningData);
    }
    if (this.b != null)
    {
      this.b.c();
      this.b.w();
      this.b.a = true;
      if (QLog.isColorLevel()) {
        QLog.d("ScanningSurfaceView", 2, "5=" + this.b.a);
      }
      this.b.c = true;
      this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView.a.a.a(3, this.b.g, this.b.h, new zzo(this));
      ScanningSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zzn
 * JD-Core Version:    0.7.0.1
 */