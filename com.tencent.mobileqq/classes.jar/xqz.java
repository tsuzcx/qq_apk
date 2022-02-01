import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class xqz
  extends SimpleObserver<Bitmap>
{
  xqz(xqy paramxqy) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    xqw.b(xqy.a(this.a), "onNext, oldResult=%s, newResult=%s", xqy.a(this.a), paramBitmap);
    xqy.a(this.a, paramBitmap);
    xqy.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    xqw.a(xqy.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xqw.c(xqy.a(this.a), "onError, oldError=%s, newError=%s", xqy.a(this.a), paramError);
    xqy.a(this.a, paramError);
    xqy.a(this.a, SystemClock.uptimeMillis());
    xqy.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqz
 * JD-Core Version:    0.7.0.1
 */