import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class xce
  extends SimpleObserver<Bitmap>
{
  xce(xcd paramxcd) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    xcb.b(xcd.a(this.a), "onNext, oldResult=%s, newResult=%s", xcd.a(this.a), paramBitmap);
    xcd.a(this.a, paramBitmap);
    xcd.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    xcb.a(xcd.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xcb.c(xcd.a(this.a), "onError, oldError=%s, newError=%s", xcd.a(this.a), paramError);
    xcd.a(this.a, paramError);
    xcd.a(this.a, SystemClock.uptimeMillis());
    xcd.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xce
 * JD-Core Version:    0.7.0.1
 */