import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class uqq<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<uqr<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqq.class.getName();
  }
  
  public uqq()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  public DATA a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(@NonNull uqr<DATA> paramuqr)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramuqr)) {
      this.jdField_a_of_type_JavaUtilList.add(paramuqr);
    }
  }
  
  protected abstract void a(utj paramutj);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uqr)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    wsv.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull uqr<DATA> paramuqr)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramuqr)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramuqr);
    }
  }
  
  public void b(utj paramutj)
  {
    a(paramutj);
  }
  
  public void c()
  {
    wsv.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqq
 * JD-Core Version:    0.7.0.1
 */