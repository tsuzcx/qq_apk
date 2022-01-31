import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class wdn
  extends SimpleObserver<Bitmap>
{
  wdn(wdm paramwdm) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    wdk.b(wdm.a(this.a), "onNext, oldResult=%s, newResult=%s", wdm.a(this.a), paramBitmap);
    wdm.a(this.a, paramBitmap);
    wdm.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    wdk.a(wdm.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wdk.c(wdm.a(this.a), "onError, oldError=%s, newError=%s", wdm.a(this.a), paramError);
    wdm.a(this.a, paramError);
    wdm.a(this.a, SystemClock.uptimeMillis());
    wdm.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdn
 * JD-Core Version:    0.7.0.1
 */