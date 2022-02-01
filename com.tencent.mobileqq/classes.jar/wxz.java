import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class wxz
{
  public ConcurrentHashMap<String, Object> a;
  public wya a;
  public boolean a;
  public final String b;
  public boolean b;
  
  public wxz()
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
      ykq.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result %s, stack = %s", String.valueOf(paramString), String.valueOf(localObject), zdz.a(7));
      return localObject;
    }
    ykq.a(this.jdField_b_of_type_JavaLangString, "getResult key %s, result null, stack = %s", String.valueOf(paramString), zdz.a(7));
    return null;
  }
  
  public final wxz a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    return this;
  }
  
  public abstract void a();
  
  public void a(String paramString, Object paramObject)
  {
    ykq.a(this.jdField_b_of_type_JavaLangString, "putResult key %s, value %s, stack = %s", String.valueOf(paramString), String.valueOf(paramObject), zdz.a(7));
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramObject);
    }
  }
  
  protected abstract void a(Map<String, Object> paramMap);
  
  public final void a(boolean paramBoolean)
  {
    ykq.a(this.jdField_b_of_type_JavaLangString, "onJobFinish %b, stack = %s", Boolean.valueOf(paramBoolean), zdz.a(7));
    if (this.jdField_a_of_type_Wya != null) {
      this.jdField_a_of_type_Wya.b(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected final void b(boolean paramBoolean)
  {
    ykq.a(this.jdField_b_of_type_JavaLangString, "onRunFinish %b, stack = %s", Boolean.valueOf(paramBoolean), zdz.a(7));
    if (this.jdField_a_of_type_Wya != null) {
      this.jdField_a_of_type_Wya.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxz
 * JD-Core Version:    0.7.0.1
 */