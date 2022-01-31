import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public class tvo
{
  private List<tvr> jdField_a_of_type_JavaUtilList;
  private Map<String, tvq> jdField_a_of_type_JavaUtilMap;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private WeakReference<tvs> jdField_a_of_type_MqqUtilWeakReference;
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
      tvr localtvr = (tvr)localIterator.next();
      tvt.a().a(localtvr.a, new tvp(this, localtvr, i));
    }
  }
  
  public void a(tvr paramtvr)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramtvr);
  }
  
  public void a(tvs paramtvs)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramtvs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvo
 * JD-Core Version:    0.7.0.1
 */