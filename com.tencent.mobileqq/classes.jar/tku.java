import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tku<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<tkv<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public tku(T paramT)
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
        ((tkv)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(tkv<T> paramtkv)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramtkv)) {
        this.jdField_a_of_type_JavaUtilList.add(paramtkv);
      }
      return;
    }
    finally
    {
      paramtkv = finally;
      throw paramtkv;
    }
  }
  
  public void b(tkv<T> paramtkv)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramtkv);
      return;
    }
    finally
    {
      paramtkv = finally;
      throw paramtkv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tku
 * JD-Core Version:    0.7.0.1
 */