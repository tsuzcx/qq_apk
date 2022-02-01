import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class pxv
  implements IEventReceiver
{
  private pxv.a jdField_a_of_type_Pxv$a;
  private pxv.b jdField_a_of_type_Pxv$b;
  private pxv.c jdField_a_of_type_Pxv$c;
  private final QQAppInterface mApp;
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  
  public pxv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    init();
  }
  
  private void bnC()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Pxv$a);
    }
    if (this.jdField_a_of_type_Pxv$a != null) {
      this.jdField_a_of_type_Pxv$a.Gr();
    }
  }
  
  private void init()
  {
    this.jdField_a_of_type_Pxv$b = new pxv.b(this);
    this.jdField_a_of_type_Pxv$c = new pxv.c(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Pxv$b);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Pxv$c);
  }
  
  public void a(pxv.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + parama);
    }
    this.jdField_a_of_type_Pxv$a = parama;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Pxv$b);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Pxv$c);
    this.jdField_a_of_type_Pxv$a = null;
    this.mIsDestroy.set(true);
  }
  
  public boolean isDestroyed()
  {
    return this.mIsDestroy.get();
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public static abstract interface a
  {
    public abstract void Gr();
  }
  
  public static class b
    extends QQUIEventReceiver<pxv, pxu.a>
  {
    public b(pxv parampxv)
    {
      super();
    }
    
    public void a(@NonNull pxv parampxv, @NonNull pxu.a parama)
    {
      if (parampxv.isDestroyed()) {}
      do
      {
        return;
        if (parama.aCC)
        {
          pxv.a(parampxv);
          return;
        }
        if ((parama.a() != null) && (!parama.b.isFail())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + parama.b);
      return;
      pxv.a(parampxv);
    }
    
    public Class acceptEventClass()
    {
      return pxu.a.class;
    }
  }
  
  public static final class c
    extends QQUIEventReceiver<pxv, ptk>
  {
    public c(@NonNull pxv parampxv)
    {
      super();
    }
    
    private void b(pxv parampxv, ptk paramptk)
    {
      Object localObject = ((puy)pxv.a(parampxv).getManager(251)).a().a(3, "");
      if ((localObject != null) && (paramptk.vid.equals(((puh)localObject).nodeVid))) {
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
        }
      }
      puh localpuh;
      do
      {
        return;
        localObject = (pmj)pxv.a(parampxv).getManager(197);
        localpuh = ((pmj)localObject).b(paramptk.unionId);
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localpuh + "\nmanager: " + localObject);
        }
      } while (localpuh == null);
      int i = localpuh.iO.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          pux localpux = (pux)localpuh.iO.get(i);
          if ((localpux.Ak == paramptk.Ak) && (!localpux.aBR))
          {
            localpux.aBR = true;
            localpuh.unreadCount -= 1;
          }
        }
        else
        {
          ((pmj)localObject).c(localpuh);
          ((pmj)localObject).b(localpuh);
          parampxv = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, parampxv);
          ThreadManager.getUIHandler().post(parampxv);
          return;
        }
        i -= 1;
      }
    }
    
    public void a(@NonNull pxv parampxv, @NonNull ptk paramptk)
    {
      ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, parampxv, paramptk), 8, null, true);
    }
    
    public Class acceptEventClass()
    {
      return ptk.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxv
 * JD-Core Version:    0.7.0.1
 */