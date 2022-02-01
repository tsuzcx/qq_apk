import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.8.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.b;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class aacj
  extends Handler
{
  private LinkedList<PreloadManager.b> F = new LinkedList();
  private boolean bva;
  
  public aacj(PreloadManager paramPreloadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void ctM()
  {
    WeakReference localWeakReference = new WeakReference(this.this$0);
    PreloadManager.b localb = (PreloadManager.b)this.F.getFirst();
    this.F.removeFirst();
    ThreadManager.excute(new PreloadManager.8.1(this, localWeakReference, localb), 64, null, false);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.this$0.Vn) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        this.F.addLast((PreloadManager.b)paramMessage.obj);
      }
    } while (this.bva);
    this.bva = true;
    sendEmptyMessage(2);
    return;
    if (this.F.size() > 0)
    {
      ctM();
      return;
    }
    this.bva = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacj
 * JD-Core Version:    0.7.0.1
 */