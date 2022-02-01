import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class yat
  extends SimpleObserver<Bitmap>
{
  yat(yas paramyas) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    yaq.b(yas.a(this.a), "onNext, oldResult=%s, newResult=%s", yas.a(this.a), paramBitmap);
    yas.a(this.a, paramBitmap);
    yas.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    yaq.a(yas.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yaq.c(yas.a(this.a), "onError, oldError=%s, newError=%s", yas.a(this.a), paramError);
    yas.a(this.a, paramError);
    yas.a(this.a, SystemClock.uptimeMillis());
    yas.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yat
 * JD-Core Version:    0.7.0.1
 */