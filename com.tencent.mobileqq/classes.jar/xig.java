import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class xig
{
  private static final xii jdField_a_of_type_Xii = new xii(null);
  private CopyOnWriteArrayList<xhy> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static xig a()
  {
    return (xig)jdField_a_of_type_Xii.getInstance();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((xhy)localIterator.next()).b();
      }
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((xhy)localIterator.next()).a(paramLong);
      }
    }
  }
  
  public void a(xhy paramxhy)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramxhy);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((xhy)localIterator.next()).a();
      }
    }
  }
  
  public void b(xhy paramxhy)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramxhy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xig
 * JD-Core Version:    0.7.0.1
 */