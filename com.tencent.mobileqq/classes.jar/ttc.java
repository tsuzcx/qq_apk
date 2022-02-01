import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ttc<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<ttd<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ttc(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ttd)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(ttd<T> paramttd)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramttd)) {
        this.jdField_a_of_type_JavaUtilList.add(paramttd);
      }
      return;
    }
    finally
    {
      paramttd = finally;
      throw paramttd;
    }
  }
  
  public void b(ttd<T> paramttd)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramttd);
      return;
    }
    finally
    {
      paramttd = finally;
      throw paramttd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ttc
 * JD-Core Version:    0.7.0.1
 */