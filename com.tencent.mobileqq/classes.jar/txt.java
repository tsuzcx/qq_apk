import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class txt
  extends SimpleObserver<Bitmap>
{
  txt(txs paramtxs) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    txq.b(txs.a(this.a), "onNext, oldResult=%s, newResult=%s", txs.a(this.a), paramBitmap);
    txs.a(this.a, paramBitmap);
    txs.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    txq.a(txs.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    txq.c(txs.a(this.a), "onError, oldError=%s, newError=%s", txs.a(this.a), paramError);
    txs.a(this.a, paramError);
    txs.a(this.a, SystemClock.uptimeMillis());
    txs.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txt
 * JD-Core Version:    0.7.0.1
 */