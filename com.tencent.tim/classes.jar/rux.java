import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class rux
  implements URLDrawable.URLDrawableListener
{
  public rux(QRDisplayActivity paramQRDisplayActivity, boolean paramBoolean, int paramInt, aeng.a parama) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QRDisplayActivity.e(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadCanceled:" + this.a.bzR);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadFialed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.a.bzR);
    }
    if (paramURLDrawable != null) {
      this.this$0.pt.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
    QRDisplayActivity.e(this.this$0);
    QQToast.a(this.this$0, this.this$0.getString(2131698697), 0).show();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.aJR) {
      this.this$0.bwD();
    }
    rwt.d(this.this$0.app, this.val$currentIndex);
    QRDisplayActivity.e(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener onLoadSuccessed: urlDrawable = " + paramURLDrawable + " bkgURL = " + this.a.bzR);
    }
    if (paramURLDrawable != null) {
      this.this$0.pt.setBackgroundDrawable(paramURLDrawable.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rux
 * JD-Core Version:    0.7.0.1
 */