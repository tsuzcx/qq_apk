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

public class xav
  implements woy<xds, xfd>
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue<wvn> jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public xav(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(xds paramxds, xfd paramxfd)
  {
    wjk localwjk = (wjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    List localList = paramxfd.a();
    localwjk.a(paramxfd.a());
    if (paramxds.a() == 3)
    {
      paramxds = localList.iterator();
      while (paramxds.hasNext())
      {
        paramxfd = (wvn)paramxds.next();
        localwjk.b(paramxfd);
        localwjk.c(paramxfd);
        localwjk.d(paramxfd);
      }
    }
    localwjk.a(localList);
    localwjk.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (wjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    if (!this.b.get()) {}
    for (;;)
    {
      wvn localwvn = (wvn)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localwvn == null)
      {
        localObject = new xaw(true);
        wjj.a().dispatch((Dispatcher.Dispatchable)localObject);
        return;
      }
      ((wjk)localObject).a(localwvn);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(@NonNull xds paramxds, @Nullable xfd paramxfd, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {}
    do
    {
      return;
      this.b.set(true);
      if ((paramxfd != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(paramxds, paramxfd);
    this.b.set(false);
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xav
 * JD-Core Version:    0.7.0.1
 */