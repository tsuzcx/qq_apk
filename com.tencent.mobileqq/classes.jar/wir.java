import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class wir<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<wis<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = wir.class.getName();
  }
  
  public wir()
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
  
  public void a(@NonNull wis<DATA> paramwis)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramwis)) {
      this.jdField_a_of_type_JavaUtilList.add(paramwis);
    }
  }
  
  protected abstract void a(wlk paramwlk);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wis)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    ykq.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull wis<DATA> paramwis)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramwis)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramwis);
    }
  }
  
  public void b(wlk paramwlk)
  {
    a(paramwlk);
  }
  
  public void c()
  {
    ykq.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wir
 * JD-Core Version:    0.7.0.1
 */