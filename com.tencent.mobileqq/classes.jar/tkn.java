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

public class tkn
  implements syq<tnk, tov>
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue<tff> jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public tkn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(tnk paramtnk, tov paramtov)
  {
    stc localstc = (stc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    List localList = paramtov.a();
    localstc.a(paramtov.a());
    if (paramtnk.a() == 3)
    {
      paramtnk = localList.iterator();
      while (paramtnk.hasNext())
      {
        paramtov = (tff)paramtnk.next();
        localstc.b(paramtov);
        localstc.c(paramtov);
        localstc.d(paramtov);
      }
    }
    localstc.a(localList);
    localstc.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (stc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    if (!this.b.get()) {}
    for (;;)
    {
      tff localtff = (tff)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localtff == null)
      {
        localObject = new tko(true);
        stb.a().dispatch((Dispatcher.Dispatchable)localObject);
        return;
      }
      ((stc)localObject).a(localtff);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(@NonNull tnk paramtnk, @Nullable tov paramtov, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {}
    do
    {
      return;
      this.b.set(true);
      if ((paramtov != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(paramtnk, paramtov);
    this.b.set(false);
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkn
 * JD-Core Version:    0.7.0.1
 */