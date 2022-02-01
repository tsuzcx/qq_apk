import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class zky
  implements URLDrawable.URLDrawableListener
{
  public zky(QRDisplayActivity paramQRDisplayActivity, arfa paramarfa, int paramInt, boolean paramBoolean) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.e(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadCanceled:" + this.jdField_a_of_type_Arfa.a);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadFialed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.jdField_a_of_type_Arfa.a);
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.i.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
    QRDisplayActivity.e(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    QQToast.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.getString(2131696194), 0).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_Arfa, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadSuccessed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.jdField_a_of_type_Arfa.a);
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.i.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zky
 * JD-Core Version:    0.7.0.1
 */