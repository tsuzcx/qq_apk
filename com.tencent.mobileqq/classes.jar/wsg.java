import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class wsg<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<wsh<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = wsg.class.getName();
  }
  
  public wsg()
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
  
  public void a(@NonNull wsh<DATA> paramwsh)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramwsh)) {
      this.jdField_a_of_type_JavaUtilList.add(paramwsh);
    }
  }
  
  protected abstract void a(wuz paramwuz);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wsh)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    yuk.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull wsh<DATA> paramwsh)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramwsh)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramwsh);
    }
  }
  
  public void b(wuz paramwuz)
  {
    a(paramwuz);
  }
  
  public void c()
  {
    yuk.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsg
 * JD-Core Version:    0.7.0.1
 */