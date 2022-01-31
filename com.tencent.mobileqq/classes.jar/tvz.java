import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public class tvz
{
  private List<twc> jdField_a_of_type_JavaUtilList;
  private Map<String, twb> jdField_a_of_type_JavaUtilMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private WeakReference<twd> jdField_a_of_type_MqqUtilWeakReference;
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
      twc localtwc = (twc)localIterator.next();
      twe.a().a(localtwc.a, new twa(this, localtwc, i));
    }
  }
  
  public void a(twc paramtwc)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramtwc);
  }
  
  public void a(twd paramtwd)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramtwd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvz
 * JD-Core Version:    0.7.0.1
 */