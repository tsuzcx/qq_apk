import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class uwz
  implements uyg
{
  uwz(uwt paramuwt, boolean paramBoolean, long paramLong, ImageProgressCircle paramImageProgressCircle) {}
  
  public void a(URL paramURL, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadProgressed");
    }
    uwt.a(this.jdField_a_of_type_Uwt, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramInt);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadFailed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(false, this.jdField_a_of_type_Long);
    }
    uwt.a(this.jdField_a_of_type_Uwt, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
  
  public void a(URL paramURL, suk paramsuk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadSuccessed");
    }
    if (!this.jdField_a_of_type_Boolean) {
      PublicAccountImageCollectionPreloadManager.a().b(true, this.jdField_a_of_type_Long);
    }
    uwt.a(this.jdField_a_of_type_Uwt, this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwz
 * JD-Core Version:    0.7.0.1
 */