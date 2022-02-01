import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.util.List;

class qpo
  implements qpm.a
{
  qpo(qpn paramqpn, List paramList, Bitmap[] paramArrayOfBitmap, Handler paramHandler) {}
  
  public void h(String paramString, Throwable paramThrowable)
  {
    int j = this.oa.indexOf(paramString);
    qpb.c(qpn.a(this.a), "bitmap download failed index=%s, error=%s", Integer.valueOf(j), paramThrowable);
    this.val$handler.removeMessages(1);
    this.val$handler.sendMessageDelayed(Message.obtain(this.val$handler, 1, paramThrowable), 500L);
  }
  
  public void m(String paramString, Bitmap paramBitmap)
  {
    int j = this.oa.indexOf(paramString);
    qpb.b(qpn.a(this.a), "bitmap download success index=%d, url=%s", Integer.valueOf(j), paramString);
    this.i[j] = paramBitmap;
    this.val$handler.removeMessages(0);
    this.val$handler.sendMessageDelayed(Message.obtain(this.val$handler, 0, this.i), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpo
 * JD-Core Version:    0.7.0.1
 */