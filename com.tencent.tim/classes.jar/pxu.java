import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class pxu
  implements ppv.b<pzp, qaw>
{
  private AtomicBoolean aT = new AtomicBoolean(false);
  private final QQAppInterface mApp;
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  private Queue<puh> r;
  
  public pxu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    init();
  }
  
  private void a(pzp parampzp, qaw paramqaw)
  {
    pmj localpmj = (pmj)this.mApp.getManager(197);
    List localList = paramqaw.bO();
    localpmj.qS(paramqaw.mH());
    if (parampzp.sA() == 3)
    {
      parampzp = localList.iterator();
      while (parampzp.hasNext())
      {
        paramqaw = (puh)parampzp.next();
        localpmj.b(paramqaw);
        localpmj.c(paramqaw);
        localpmj.d(paramqaw);
      }
    }
    localpmj.dS(localList);
    localpmj.v(localList, true);
  }
  
  private void bnB()
  {
    Object localObject = (pmj)this.mApp.getManager(197);
    if (!this.aT.get()) {}
    for (;;)
    {
      puh localpuh = (puh)this.r.poll();
      if (localpuh == null)
      {
        localObject = new pxu.a(true);
        pmi.a().dispatch((Dispatcher.Dispatchable)localObject);
        return;
      }
      ((pmj)localObject).a(localpuh);
    }
  }
  
  private void init()
  {
    this.r = new ConcurrentLinkedQueue();
  }
  
  public void a(@NonNull pzp parampzp, @Nullable qaw paramqaw, @NonNull ErrorMessage paramErrorMessage)
  {
    if (isDestroyed()) {}
    do
    {
      return;
      this.aT.set(true);
      if ((paramqaw != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(parampzp, paramqaw);
    this.aT.set(false);
    bnB();
  }
  
  public void destroy()
  {
    this.mIsDestroy.set(true);
  }
  
  public boolean isDestroyed()
  {
    return this.mIsDestroy.get();
  }
  
  public static class a
    extends plt
  {
    private qaw a;
    public boolean aCC;
    
    public a(ErrorMessage paramErrorMessage)
    {
      this.b = paramErrorMessage;
    }
    
    public a(boolean paramBoolean)
    {
      this(new ErrorMessage());
      this.aCC = paramBoolean;
    }
    
    public qaw a()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxu
 * JD-Core Version:    0.7.0.1
 */