import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ruv
  implements URLDrawable.URLDrawableListener
{
  public ruv(QRDisplayActivity paramQRDisplayActivity, aeng.a parama, int paramInt, boolean paramBoolean) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.e(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadCanceled:" + this.a.bzR);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadFialed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.a.bzR);
    }
    if (paramURLDrawable != null) {
      this.this$0.E.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
    QRDisplayActivity.e(this.this$0);
    QQToast.a(this.this$0, this.this$0.getString(2131698697), 0).show();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.a(this.this$0, this.a, this.val$currentIndex, this.aJR);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onLoadSuccessed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.a.bzR);
    }
    if (paramURLDrawable != null) {
      this.this$0.E.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ruv
 * JD-Core Version:    0.7.0.1
 */