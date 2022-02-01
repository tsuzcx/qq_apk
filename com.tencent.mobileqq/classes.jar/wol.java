import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class wol<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<wom<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = wol.class.getName();
  }
  
  public wol()
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
  
  public void a(@NonNull wom<DATA> paramwom)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramwom)) {
      this.jdField_a_of_type_JavaUtilList.add(paramwom);
    }
  }
  
  protected abstract void a(wre paramwre);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wom)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    yqp.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull wom<DATA> paramwom)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramwom)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramwom);
    }
  }
  
  public void b(wre paramwre)
  {
    a(paramwre);
  }
  
  public void c()
  {
    yqp.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wol
 * JD-Core Version:    0.7.0.1
 */