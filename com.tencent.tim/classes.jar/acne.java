import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class acne
  extends accg
{
  private volatile boolean bJF;
  SparseArray<acne.c> cl = new SparseArray();
  private volatile int cyq = 0;
  private Handler cz;
  private ServiceConnection h = new acng(this);
  public Handler handler;
  private HandlerThread handlerThread;
  public Messenger i = null;
  private volatile boolean isDestroyed;
  private final ArrayList<acne.b> mCallbacks = new ArrayList();
  public Messenger mMessenger = null;
  private final LinkedBlockingQueue<Integer> n = new LinkedBlockingQueue();
  
  public acne(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.handler = new acnf(this, Looper.getMainLooper(), paramQQAppInterface);
  }
  
  private void Ka(int paramInt)
  {
    if ((this.isDestroyed) && (QLog.isColorLevel())) {
      QLog.w("UploadPhoto", 2, "TroopQZoneUploadAlbumHandler 已经被销毁，不能sumbmit");
    }
    bzj();
    if (!this.n.contains(Integer.valueOf(paramInt))) {
      this.n.offer(Integer.valueOf(paramInt));
    }
  }
  
  private void Kb(int paramInt)
  {
    this.cl.remove(paramInt);
    if (this.cl.size() == 0) {
      abQ();
    }
    while (this.i == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 999, paramInt, 0);
    try
    {
      this.i.send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private void a(int paramInt1, acne.c paramc, int paramInt2, int paramInt3)
  {
    Message localMessage = this.handler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), paramc, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) };
    localMessage.sendToTarget();
  }
  
  private void bzj()
  {
    if ((this.cyq == 2) || (this.cyq == 1)) {}
    do
    {
      return;
      if (!this.isDestroyed) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("UploadPhoto", 2, "TroopQZoneUploadAlbumHandler 已经被销毁，不能doBindService");
    return;
    this.cyq = 1;
    avpw.a(this.app, this.h);
  }
  
  private void cNa()
  {
    if (this.handlerThread == null)
    {
      this.handlerThread = ThreadManager.newFreeHandlerThread("UploadPhoto", 5);
      this.handlerThread.start();
      this.cz = new Handler(this.handlerThread.getLooper());
    }
    this.cz.post(new TroopQZoneUploadAlbumHandler.2(this));
  }
  
  void J(long paramLong, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (j < this.mCallbacks.size())
    {
      Object localObject = (acne.b)this.mCallbacks.get(j);
      View localView = ((acne.b)localObject).getView();
      localObject = ((acne.b)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((acne.a)localObject).a(localView, paramLong, paramInt1, paramInt2);
      }
      for (;;)
      {
        j += 1;
        break;
        this.mCallbacks.remove(j);
        j -= 1;
      }
    }
  }
  
  public void a(View paramView, acne.a parama)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      acne.b localb = (acne.b)localIterator.next();
      if (localb.getView() == paramView)
      {
        localb.callback = new WeakReference(parama);
        return;
      }
    }
    this.mCallbacks.add(new acne.b(paramView, parama));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject1 = paramQQAppInterface.b().a(paramString, 1, paramLong);
    if (localObject1 == null)
    {
      Kb(paramInt1);
      return;
    }
    if (((MessageRecord)localObject1).msgtype == -2011)
    {
      localObject2 = ((MessageForStructing)localObject1).structingMsg;
      if (!(localObject2 instanceof StructMsgForGeneralShare)) {}
    }
    for (Object localObject2 = (StructMsgForGeneralShare)localObject2;; localObject2 = null)
    {
      if ((localObject2 == null) || (((StructMsgForGeneralShare)localObject2).getProgress() < 0))
      {
        Kb(paramInt1);
        return;
      }
      if ((paramInt2 == 1001) && (((MessageRecord)localObject1).extraflag != 32768))
      {
        ((StructMsgForGeneralShare)localObject2).setSummary(BaseApplication.getContext().getResources().getString(2131691470));
        ((StructMsgForGeneralShare)localObject2).setProgress(paramInt3);
        return;
      }
      paramInt1 = 32772;
      localObject1 = BaseApplication.getContext().getResources().getString(2131691471);
      if ((paramInt2 == 1000) || (paramInt2 == 1004))
      {
        localObject1 = BaseApplication.getContext().getResources().getString(2131691471);
        paramInt1 = 32772;
      }
      for (;;)
      {
        ((StructMsgForGeneralShare)localObject2).setProgress(100);
        ((StructMsgForGeneralShare)localObject2).setSummary((String)localObject1);
        ((StructMsgForGeneralShare)localObject2).mMsgBrief = (acfp.m(2131716076) + (String)localObject1);
        paramQQAppInterface.a().e(paramString, 1, paramLong);
        paramQQAppInterface.b().b(paramString, 1, paramLong, paramInt1, 0);
        paramQQAppInterface.b().c(paramString, 1, paramLong, ((StructMsgForGeneralShare)localObject2).getBytes());
        notifyUI(999, true, paramString);
        return;
        if (paramInt2 == 1003)
        {
          localObject1 = BaseApplication.getContext().getResources().getString(2131691469);
          paramInt1 = 32768;
        }
        else if (paramInt2 == 1005)
        {
          localObject1 = BaseApplication.getContext().getResources().getString(2131691468);
          paramInt1 = 32770;
          ((StructMsgForGeneralShare)localObject2).mMsgActionData = "";
          ((StructMsgForGeneralShare)localObject2).mMsg_A_ActionData = "";
        }
      }
    }
  }
  
  protected void aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    acne.c localc = (acne.c)this.cl.get(paramInt2, null);
    if (localc == null) {
      return;
    }
    a(paramInt2, localc, paramInt1, paramInt3);
  }
  
  public boolean abQ()
  {
    cMZ();
    try
    {
      avpw.gw(this.app.getApp());
      this.cl.clear();
      return true;
    }
    catch (Exception localException)
    {
      QLog.i("UploadPhoto", 1, "", localException);
    }
    return false;
  }
  
  public void cMZ()
  {
    if (this.cyq == 3) {
      return;
    }
    BaseApplication.getContext().unbindService(this.h);
    this.cyq = 3;
  }
  
  public void f(int paramInt, String paramString, long paramLong)
  {
    if (this.cl.get(paramInt) == null) {
      this.cl.append(paramInt, new acne.c(paramString, paramLong));
    }
    Ka(paramInt);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acnh.class;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UploadPhoto", 2, "onDestroy");
    }
    this.isDestroyed = true;
    this.bJF = true;
    this.cl.clear();
    if (this.handlerThread != null) {
      this.handlerThread.interrupt();
    }
    abQ();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public static abstract interface a
  {
    public abstract void a(View paramView, long paramLong, int paramInt1, int paramInt2);
  }
  
  class b
  {
    WeakReference<acne.a> callback;
    WeakReference<View> view;
    
    public b(View paramView, acne.a parama)
    {
      this.view = new WeakReference(paramView);
      this.callback = new WeakReference(parama);
    }
    
    public acne.a a()
    {
      return (acne.a)this.callback.get();
    }
    
    public View getView()
    {
      return (View)this.view.get();
    }
  }
  
  class c
  {
    public String peerUin;
    public long uniseq;
    
    c(String paramString, long paramLong)
    {
      this.peerUin = paramString;
      this.uniseq = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acne
 * JD-Core Version:    0.7.0.1
 */