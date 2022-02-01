import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class afrp
  implements akxb, akye
{
  private WeakReference<afrp.a> e;
  private MessageForPic g;
  private Handler mHandler;
  
  public afrp(MessageForPic paramMessageForPic, Handler paramHandler, afrp.a parama)
  {
    this.g = paramMessageForPic;
    this.mHandler = paramHandler;
    this.e = new WeakReference(parama);
  }
  
  public void Nc(int paramInt) {}
  
  public void a(int paramInt, akxr paramakxr)
  {
    if (this.e.get() == null) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload fail, callback is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onDownload ", Integer.valueOf(paramakxr.mResult) });
      }
      if (paramakxr.mResult == 0)
      {
        ((afrp.a)this.e.get()).a(true, this.g);
        return;
      }
    } while (-1 != paramakxr.mResult);
    if (paramakxr.c != null) {
      QLog.d("EmotionDownGIFCallback", 1, new Object[] { "onDownloadFail errDec:", paramakxr.c.bUJ });
    }
    ((afrp.a)this.e.get()).a(false, this.g);
  }
  
  public void a(akxb.a parama)
  {
    this.mHandler.post(new EmotionDownGIFCallback.1(this, parama));
  }
  
  public void aO(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 2, new Object[] { "onUpdateProgress:", paramInt + " needRefresh:" + paramBoolean, " picMr:", Long.valueOf(this.g.uniseq) });
    }
    if (this.e.get() != null) {
      ((afrp.a)this.e.get()).a(paramInt, this.g);
    }
  }
  
  public void aS(int paramInt, boolean paramBoolean)
  {
    this.mHandler.post(new EmotionDownGIFCallback.2(this, paramInt));
  }
  
  public void b(int paramInt, akxr paramakxr) {}
  
  public void c(int paramInt, akxr paramakxr) {}
  
  public void d(int paramInt, akxr paramakxr) {}
  
  public void o(int paramInt, ArrayList<akxr> paramArrayList) {}
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, MessageForPic paramMessageForPic);
    
    public abstract void a(boolean paramBoolean, MessageForPic paramMessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrp
 * JD-Core Version:    0.7.0.1
 */