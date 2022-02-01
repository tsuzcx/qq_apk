import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class vtp
  implements vuw
{
  vtp(vtj paramvtj, boolean paramBoolean, long paramLong, ImageProgressCircle paramImageProgressCircle) {}
  
  public void a(URL paramURL, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadProgressed");
    }
    vtj.a(this.jdField_a_of_type_Vtj, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadFailed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(false, this.jdField_a_of_type_Long);
    }
    vtj.a(this.jdField_a_of_type_Vtj, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
  
  public void a(URL paramURL, tls paramtls)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadSuccessed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(true, this.jdField_a_of_type_Long);
    }
    vtj.a(this.jdField_a_of_type_Vtj, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtp
 * JD-Core Version:    0.7.0.1
 */