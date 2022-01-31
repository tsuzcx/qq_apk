import com.tencent.mobileqq.widget.QZoneCoverView;
import com.tencent.mobileqq.widget.QZoneCoverView.PhotoInfo;
import com.tencent.qphone.base.util.QLog;

public class hlp
  extends Thread
{
  public hlp(QZoneCoverView paramQZoneCoverView, QZoneCoverView.PhotoInfo paramPhotoInfo) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView$PhotoInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.f();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.qzonecover.", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hlp
 * JD-Core Version:    0.7.0.1
 */