import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class xwy
  extends SimpleObserver<Bitmap>
{
  xwy(xwx paramxwx) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    xwv.b(xwx.a(this.a), "onNext, oldResult=%s, newResult=%s", xwx.a(this.a), paramBitmap);
    xwx.a(this.a, paramBitmap);
    xwx.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    xwv.a(xwx.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xwv.c(xwx.a(this.a), "onError, oldError=%s, newError=%s", xwx.a(this.a), paramError);
    xwx.a(this.a, paramError);
    xwx.a(this.a, SystemClock.uptimeMillis());
    xwx.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwy
 * JD-Core Version:    0.7.0.1
 */