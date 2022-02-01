import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class aswr
  implements URLDrawable.URLDrawableListener
{
  aswr(aswq paramaswq, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadCanceled get an exception when handling URLbmp:");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadFialed when handling URLbmp");
    aswo.a(this.a.this$0, this.a.val$activity, this.a.val$shareType, this.a.val$finalDescription, this.a.val$miniAppInfo.name, this.cFU);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadProgressed get an exception when handling URLbmp:");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.drawableToBitmap(paramURLDrawable.getCurrDrawable());
    if (paramURLDrawable != null) {
      aswo.a(this.a.this$0, this.a.val$shareType, this.a.val$finalDescription, this.a.val$miniAppInfo.name, aswo.a(this.a.this$0, paramURLDrawable), this.cFU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswr
 * JD-Core Version:    0.7.0.1
 */