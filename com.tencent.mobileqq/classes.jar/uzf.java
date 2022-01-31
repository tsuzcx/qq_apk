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

public class uzf
  implements uni<vcc, vdn>
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue<utx> jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public uzf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(vcc paramvcc, vdn paramvdn)
  {
    uhu localuhu = (uhu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    List localList = paramvdn.a();
    localuhu.a(paramvdn.a());
    if (paramvcc.a() == 3)
    {
      paramvcc = localList.iterator();
      while (paramvcc.hasNext())
      {
        paramvdn = (utx)paramvcc.next();
        localuhu.b(paramvdn);
        localuhu.c(paramvdn);
        localuhu.d(paramvdn);
      }
    }
    localuhu.a(localList);
    localuhu.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (uhu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    if (!this.b.get()) {}
    for (;;)
    {
      utx localutx = (utx)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localutx == null)
      {
        localObject = new uzg(true);
        uht.a().dispatch((Dispatcher.Dispatchable)localObject);
        return;
      }
      ((uhu)localObject).a(localutx);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(@NonNull vcc paramvcc, @Nullable vdn paramvdn, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {}
    do
    {
      return;
      this.b.set(true);
      if ((paramvdn != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(paramvcc, paramvdn);
    this.b.set(false);
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzf
 * JD-Core Version:    0.7.0.1
 */