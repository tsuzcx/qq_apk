import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class ypy
  implements yqf
{
  private Object jdField_a_of_type_JavaLangObject;
  private yqg jdField_a_of_type_Yqg;
  private yqh jdField_a_of_type_Yqh;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(yqg paramyqg)
  {
    this.jdField_a_of_type_Yqg = paramyqg;
  }
  
  public void a(yqh paramyqh)
  {
    this.jdField_a_of_type_Yqh = paramyqh;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Yqg != null)
    {
      this.jdField_a_of_type_Yqg.a(paramErrorMessage);
      return;
    }
    yuk.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Yqh != null)
    {
      this.jdField_a_of_type_Yqh.a(a());
      return;
    }
    yuk.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypy
 * JD-Core Version:    0.7.0.1
 */