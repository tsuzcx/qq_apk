import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class wrg
  implements wfk<wud, wvo>
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue<wly> jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public wrg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(wud paramwud, wvo paramwvo)
  {
    wae localwae = (wae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    List localList = paramwvo.a();
    localwae.a(paramwvo.a());
    if (paramwud.a() == 3)
    {
      paramwud = localList.iterator();
      while (paramwud.hasNext())
      {
        paramwvo = (wly)paramwud.next();
        localwae.b(paramwvo);
        localwae.c(paramwvo);
        localwae.d(paramwvo);
      }
    }
    localwae.a(localList);
    localwae.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (wae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    if (!this.b.get()) {}
    for (;;)
    {
      wly localwly = (wly)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localwly == null)
      {
        localObject = new wrh(true);
        wad.a().dispatch((Dispatcher.Dispatchable)localObject);
        return;
      }
      ((wae)localObject).a(localwly);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(@NonNull wud paramwud, @Nullable wvo paramwvo, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {}
    do
    {
      return;
      this.b.set(true);
      if ((paramwvo != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(paramwud, paramwvo);
    this.b.set(false);
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrg
 * JD-Core Version:    0.7.0.1
 */