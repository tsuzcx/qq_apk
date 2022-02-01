import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchHistoryManager.1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class afvv
  implements Handler.Callback
{
  private static final Object mLock = new Object();
  List<String> Ay = new ArrayList();
  private aurf e = new aurf(ThreadManager.getFileThreadLooper(), this);
  WeakReference<afvv.a> gM;
  private boolean init;
  WeakReference<QQAppInterface> mAppRef;
  private int mType;
  
  public afvv(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.mType = paramInt;
    ThreadManager.postImmediately(new ExtendFriendSearchHistoryManager.1(this), null, true);
  }
  
  private void dcZ()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
    if (localQQAppInterface == null) {
      return;
    }
    aqhq.y(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.mType), localQQAppInterface.getCurrentAccountUin() }), this.Ay);
  }
  
  private void init()
  {
    ??? = (QQAppInterface)this.mAppRef.get();
    if (??? == null) {}
    do
    {
      return;
      ??? = aqhq.o(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.mType), ((QQAppInterface)???).getCurrentAccountUin() }));
    } while (this.init);
    if ((??? != null) && ((??? instanceof List))) {}
    for (??? = (List)???;; ??? = null)
    {
      Object localObject2 = ???;
      if (??? == null) {
        localObject2 = new ArrayList();
      }
      synchronized (mLock)
      {
        if (this.init) {
          break label201;
        }
        this.Ay.addAll((Collection)localObject2);
        if (this.Ay.size() > 10) {
          this.Ay.remove(this.Ay.size() - 1);
        }
      }
      this.init = true;
      label201:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (this.gM == null) || (this.gM.get() == null)) {
          break;
        }
        ((afvv.a)this.gM.get()).dct();
        return;
      }
    }
  }
  
  public void Ir(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (!this.init) {
        init();
      }
      synchronized (mLock)
      {
        if (this.Ay.contains(paramString)) {
          this.Ay.remove(paramString);
        }
        this.Ay.add(0, paramString);
        if (this.Ay.size() > 10) {
          this.Ay.remove(this.Ay.size() - 1);
        }
        if ((this.gM != null) && (this.gM.get() != null)) {
          ((afvv.a)this.gM.get()).dct();
        }
        if (this.e.hasMessages(0)) {
          continue;
        }
        this.e.sendEmptyMessageDelayed(0, 300L);
        return;
      }
    }
  }
  
  public void a(afvv.a parama)
  {
    if (parama != null)
    {
      this.gM = new WeakReference(parama);
      return;
    }
    this.gM = null;
  }
  
  public void clear()
  {
    synchronized (mLock)
    {
      this.Ay.clear();
      this.init = true;
      if ((this.gM != null) && (this.gM.get() != null)) {
        ((afvv.a)this.gM.get()).dct();
      }
      if (!this.e.hasMessages(0)) {
        this.e.sendEmptyMessageDelayed(0, 300L);
      }
      return;
    }
  }
  
  public List<String> eP()
  {
    return this.Ay;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      dcZ();
    }
  }
  
  public static abstract interface a
  {
    public abstract void dct();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvv
 * JD-Core Version:    0.7.0.1
 */