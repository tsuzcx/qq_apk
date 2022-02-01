import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class zwt
  implements URLDrawable.URLDrawableListener
{
  public zwt(QRDisplayActivity paramQRDisplayActivity, arie paramarie, int paramInt, boolean paramBoolean) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.e(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadCanceled:" + this.jdField_a_of_type_Arie.a);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadFialed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.jdField_a_of_type_Arie.a);
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.l.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
    QRDisplayActivity.e(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity);
    QQToast.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.getString(2131695802), 0).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.b(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, this.jdField_a_of_type_Arie, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadSuccessed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.jdField_a_of_type_Arie.a);
    }
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.l.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwt
 * JD-Core Version:    0.7.0.1
 */