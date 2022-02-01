import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.manager.Manager;

public class wla
  implements Manager
{
  private final aook f = new wlb(this, Looper.getMainLooper());
  private final ArrayList<wla.b> mCallbacks = new ArrayList();
  private WeakReference<QQAppInterface> n;
  
  public wla(QQAppInterface paramQQAppInterface)
  {
    this.f.addFilter(new Class[] { aojs.class, aojv.class, C2CPttDownloadProcessor.class, aojz.class, aokv.class, GroupPttDownloadProcessor.class, aoju.class, aoku.class, aokp.class, aonu.class, aonk.class, aonn.class, aomk.class, aond.class, aone.class, aokr.class, aolt.class, aokz.class, aomr.class });
    aR(paramQQAppInterface);
  }
  
  public static wla a(QQAppInterface paramQQAppInterface)
  {
    return (wla)paramQQAppInterface.getManager(23);
  }
  
  private void aR(QQAppInterface paramQQAppInterface)
  {
    if ((this.n != null) && (this.n.get() == paramQQAppInterface)) {
      return;
    }
    if ((this.n != null) && (this.n.get() != null)) {
      gB();
    }
    this.n = new WeakReference(paramQQAppInterface);
    paramQQAppInterface.a().a(this.f);
  }
  
  /* Error */
  public void a(View paramView, wla.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	wla:mCallbacks	Ljava/util/ArrayList;
    //   6: invokevirtual 127	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 133 1 0
    //   16: ifeq +39 -> 55
    //   19: aload_3
    //   20: invokeinterface 136 1 0
    //   25: checkcast 11	wla$b
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 140	wla$b:getView	()Landroid/view/View;
    //   35: aload_1
    //   36: if_acmpne -26 -> 10
    //   39: aload 4
    //   41: new 104	java/lang/ref/WeakReference
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 114	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   49: putfield 143	wla$b:callback	Ljava/lang/ref/WeakReference;
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 43	wla:mCallbacks	Ljava/util/ArrayList;
    //   59: new 11	wla$b
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: aload_2
    //   66: invokespecial 146	wla$b:<init>	(Lwla;Landroid/view/View;Lwla$a;)V
    //   69: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -21 -> 52
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	wla
    //   0	81	1	paramView	View
    //   0	81	2	parama	wla.a
    //   9	11	3	localIterator	java.util.Iterator
    //   28	12	4	localb	wla.b
    // Exception table:
    //   from	to	target	type
    //   2	10	76	finally
    //   10	52	76	finally
    //   55	73	76	finally
  }
  
  public void bZd()
  {
    try
    {
      if (this.mCallbacks != null) {
        this.mCallbacks.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void dispatchMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label203;
        }
        QLog.d("FileTransferManager", 2, "handleMessage" + ((aoko)paramMessage.obj).uniseq + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
      }
      finally {}
      if (i < this.mCallbacks.size())
      {
        Object localObject2 = (wla.b)this.mCallbacks.get(i);
        if (localObject2 != null)
        {
          Object localObject1 = ((wla.b)localObject2).getView();
          localObject2 = ((wla.b)localObject2).a();
          if ((localObject1 != null) && (localObject2 != null))
          {
            ((wla.a)localObject2).a((View)localObject1, (aoko)paramMessage.obj, paramMessage.what, paramMessage.arg1);
            break label208;
          }
          localObject1 = this.mCallbacks;
          int j = i - 1;
          ((ArrayList)localObject1).remove(i);
          i = j;
          break label208;
        }
      }
      else
      {
        OpenApiManager.getInstance().onFileTransStatusChanged((aoko)paramMessage.obj, paramMessage.what, paramMessage.arg1);
        return;
      }
      break label208;
      label203:
      int i = 0;
      continue;
      label208:
      i += 1;
    }
  }
  
  public void gB()
  {
    this.mCallbacks.clear();
    if ((this.n != null) && (this.n.get() != null))
    {
      ((QQAppInterface)this.n.get()).a().b(this.f);
      ((QQAppInterface)this.n.get()).getProtoReqManager().onDestroy();
      this.n = null;
    }
  }
  
  public void onDestroy()
  {
    gB();
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2);
  }
  
  class b
  {
    WeakReference<wla.a> callback;
    WeakReference<View> view;
    
    public b(View paramView, wla.a parama)
    {
      this.view = new WeakReference(paramView);
      this.callback = new WeakReference(parama);
    }
    
    public wla.a a()
    {
      return (wla.a)this.callback.get();
    }
    
    public View getView()
    {
      return (View)this.view.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wla
 * JD-Core Version:    0.7.0.1
 */