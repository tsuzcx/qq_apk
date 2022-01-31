import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicLong;

public class yks
  implements Observer
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  
  public yks(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yks
 * JD-Core Version:    0.7.0.1
 */