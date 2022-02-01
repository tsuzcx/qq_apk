import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class awdp<T>
  extends Handler
{
  private WeakReference<T> jk;
  
  public awdp(T paramT)
  {
    this.jk = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, Message paramMessage);
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject = this.jk.get();
    if (localObject != null) {
      a(localObject, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdp
 * JD-Core Version:    0.7.0.1
 */