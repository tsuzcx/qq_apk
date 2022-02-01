import android.app.Activity;
import android.content.res.Resources;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.5;
import com.tencent.qqmini.proxyimpl.ShareProxyImpl.5.1;
import java.io.File;

public class aswt
  implements URLDrawable.URLDrawableListener
{
  public aswt(ShareProxyImpl.5.1 param1) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("ShareProxyImpl", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {}
    for (int i = 1;; i = 0)
    {
      this.a.val$loadingDialog.dismiss();
      if (i == 0) {
        QQToast.a(this.a.a.val$activity, 1, acfp.m(2131704612), 1).show(this.a.a.val$activity.getResources().getDimensionPixelSize(2131299627));
      }
      if (i == 0) {
        break;
      }
      this.a.a.val$shareData.isLocalPic = true;
      this.a.a.val$shareData.sharePicPath = paramURLDrawable.getPath();
      aswo.a(this.a.a.this$0, this.a.a.val$shareData);
      return;
    }
    QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswt
 * JD-Core Version:    0.7.0.1
 */