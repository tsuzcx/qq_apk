import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class ukp
  extends SimpleObserver<Bitmap>
{
  ukp(uko paramuko) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    ukm.b(uko.a(this.a), "onNext, oldResult=%s, newResult=%s", uko.a(this.a), paramBitmap);
    uko.a(this.a, paramBitmap);
    uko.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    ukm.a(uko.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ukm.c(uko.a(this.a), "onError, oldError=%s, newError=%s", uko.a(this.a), paramError);
    uko.a(this.a, paramError);
    uko.a(this.a, SystemClock.uptimeMillis());
    uko.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukp
 * JD-Core Version:    0.7.0.1
 */