import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class uuz<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<uva<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = uuz.class.getName();
  }
  
  public uuz()
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
  
  public void a(@NonNull uva<DATA> paramuva)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramuva)) {
      this.jdField_a_of_type_JavaUtilList.add(paramuva);
    }
  }
  
  protected abstract void a(uxs paramuxs);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uva)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    wxe.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull uva<DATA> paramuva)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramuva)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramuva);
    }
  }
  
  public void b(uxs paramuxs)
  {
    a(paramuxs);
  }
  
  public void c()
  {
    wxe.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuz
 * JD-Core Version:    0.7.0.1
 */