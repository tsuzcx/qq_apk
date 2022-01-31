import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class vze
  extends SimpleObserver<Bitmap>
{
  vze(vzd paramvzd) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    vzb.b(vzd.a(this.a), "onNext, oldResult=%s, newResult=%s", vzd.a(this.a), paramBitmap);
    vzd.a(this.a, paramBitmap);
    vzd.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    vzb.a(vzd.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    vzb.c(vzd.a(this.a), "onError, oldError=%s, newError=%s", vzd.a(this.a), paramError);
    vzd.a(this.a, paramError);
    vzd.a(this.a, SystemClock.uptimeMillis());
    vzd.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vze
 * JD-Core Version:    0.7.0.1
 */