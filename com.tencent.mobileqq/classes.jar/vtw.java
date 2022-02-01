import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class vtw<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<vtx<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = vtw.class.getName();
  }
  
  public vtw()
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
  
  public void a(@NonNull vtx<DATA> paramvtx)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramvtx)) {
      this.jdField_a_of_type_JavaUtilList.add(paramvtx);
    }
  }
  
  protected abstract void a(vwp paramvwp);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vtx)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    xvv.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull vtx<DATA> paramvtx)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramvtx)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramvtx);
    }
  }
  
  public void b(vwp paramvwp)
  {
    a(paramvwp);
  }
  
  public void c()
  {
    xvv.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtw
 * JD-Core Version:    0.7.0.1
 */