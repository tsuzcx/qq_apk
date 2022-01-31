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

public class vdo
  implements urr<vgl, vhw>
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue<uyg> jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public vdo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(vgl paramvgl, vhw paramvhw)
  {
    umd localumd = (umd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    List localList = paramvhw.a();
    localumd.a(paramvhw.a());
    if (paramvgl.a() == 3)
    {
      paramvgl = localList.iterator();
      while (paramvgl.hasNext())
      {
        paramvhw = (uyg)paramvgl.next();
        localumd.b(paramvhw);
        localumd.c(paramvhw);
        localumd.d(paramvhw);
      }
    }
    localumd.a(localList);
    localumd.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (umd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    if (!this.b.get()) {}
    for (;;)
    {
      uyg localuyg = (uyg)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localuyg == null)
      {
        localObject = new vdp(true);
        umc.a().dispatch((Dispatcher.Dispatchable)localObject);
        return;
      }
      ((umd)localObject).a(localuyg);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(@NonNull vgl paramvgl, @Nullable vhw paramvhw, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {}
    do
    {
      return;
      this.b.set(true);
      if ((paramvhw != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(paramvgl, paramvhw);
    this.b.set(false);
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdo
 * JD-Core Version:    0.7.0.1
 */