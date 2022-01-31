import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class ukm
  extends SimpleObserver<Bitmap>
{
  ukm(ukl paramukl) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    ukj.b(ukl.a(this.a), "onNext, oldResult=%s, newResult=%s", ukl.a(this.a), paramBitmap);
    ukl.a(this.a, paramBitmap);
    ukl.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    ukj.a(ukl.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ukj.c(ukl.a(this.a), "onError, oldError=%s, newError=%s", ukl.a(this.a), paramError);
    ukl.a(this.a, paramError);
    ukl.a(this.a, SystemClock.uptimeMillis());
    ukl.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukm
 * JD-Core Version:    0.7.0.1
 */