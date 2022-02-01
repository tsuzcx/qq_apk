import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public class zwk
{
  private List<zwn> jdField_a_of_type_JavaUtilList;
  private Map<String, zwm> jdField_a_of_type_JavaUtilMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private WeakReference<zwo> jdField_a_of_type_MqqUtilWeakReference;
  private AtomicInteger b;
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.b = new AtomicInteger(0);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zwn localzwn = (zwn)localIterator.next();
      zwj.a(localzwn.jdField_a_of_type_Zwd).a(localzwn.jdField_a_of_type_JavaLangString, new zwl(this, localzwn, i));
    }
  }
  
  public void a(zwn paramzwn)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramzwn);
  }
  
  public void a(zwo paramzwo)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramzwo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwk
 * JD-Core Version:    0.7.0.1
 */