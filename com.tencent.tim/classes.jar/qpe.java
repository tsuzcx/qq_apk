import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class qpe
  extends SimpleObserver<Bitmap>
{
  qpe(qpd paramqpd) {}
  
  public void onCancel()
  {
    super.onCancel();
    qpb.d(qpd.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    qpb.c(qpd.a(this.a), "onError, oldError=%s, newError=%s", qpd.a(this.a), paramError);
    qpd.a(this.a, paramError);
    qpd.a(this.a, SystemClock.uptimeMillis());
    qpd.a(this.a, false);
  }
  
  public void r(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    qpb.b(qpd.a(this.a), "onNext, oldResult=%s, newResult=%s", qpd.a(this.a), paramBitmap);
    qpd.a(this.a, paramBitmap);
    qpd.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpe
 * JD-Core Version:    0.7.0.1
 */