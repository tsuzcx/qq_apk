import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class vfy
{
  public ConcurrentHashMap<String, Object> a;
  public vfz a;
  public boolean a;
  public final String b;
  public boolean b;
  
  public vfy()
  {
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.share" + getClass().getSimpleName());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public <T> T a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      wsv.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result %s, stack = %s", String.valueOf(paramString), String.valueOf(localObject), xmv.a(7));
      return localObject;
    }
    wsv.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result null, stack = %s", String.valueOf(paramString), xmv.a(7));
    return null;
  }
  
  public final vfy a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    return this;
  }
  
  public abstract void a();
  
  public void a(String paramString, Object paramObject)
  {
    wsv.a(this.jdField_b_of_type_JavaLangString, "putResult key %s, value %s, stack = %s", String.valueOf(paramString), String.valueOf(paramObject), xmv.a(7));
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramObject);
    }
  }
  
  protected abstract void a(Map<String, Object> paramMap);
  
  public final void a(boolean paramBoolean)
  {
    wsv.a(this.jdField_b_of_type_JavaLangString, "onJobFinish %b, stack = %s", Boolean.valueOf(paramBoolean), xmv.a(7));
    if (this.jdField_a_of_type_Vfz != null) {
      this.jdField_a_of_type_Vfz.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected final void b(boolean paramBoolean)
  {
    wsv.a(this.jdField_b_of_type_JavaLangString, "onRunFinish %b, stack = %s", Boolean.valueOf(paramBoolean), xmv.a(7));
    if (this.jdField_a_of_type_Vfz != null) {
      this.jdField_a_of_type_Vfz.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfy
 * JD-Core Version:    0.7.0.1
 */