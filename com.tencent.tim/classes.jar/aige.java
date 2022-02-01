import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class aige
  implements URLDrawable.URLDrawableListener
{
  aige(aigd paramaigd, long paramLong, AtomicBoolean paramAtomicBoolean, Bundle paramBundle) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    System.currentTimeMillis();
    long l = this.abw;
    if (!this.dh.get())
    {
      this.dh.set(true);
      aigd.a(this.this$0, this.val$extras);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("DynamicNow | NowEntry", 1, "download cover pic failed!");
    long l1 = System.currentTimeMillis();
    long l2 = this.abw;
    this.this$0.a.b("download_cover").c("1").d(paramThrowable.getMessage()).i(String.valueOf(l1 - l2)).report();
    if (!this.dh.get())
    {
      this.dh.set(true);
      aigd.a(this.this$0, this.val$extras);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l = System.currentTimeMillis() - this.abw;
    QLog.i("DynamicNow | NowEntry", 1, " download cover pic  success  timeconsume = " + l);
    this.this$0.a.b("download_cover").c("0").i(String.valueOf(l)).report();
    if (!this.dh.get())
    {
      this.dh.set(true);
      aigd.a(this.this$0, this.val$extras);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aige
 * JD-Core Version:    0.7.0.1
 */