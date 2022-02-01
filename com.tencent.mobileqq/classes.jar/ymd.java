import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class ymd
  implements ymk
{
  private Object jdField_a_of_type_JavaLangObject;
  private yml jdField_a_of_type_Yml;
  private ymm jdField_a_of_type_Ymm;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(yml paramyml)
  {
    this.jdField_a_of_type_Yml = paramyml;
  }
  
  public void a(ymm paramymm)
  {
    this.jdField_a_of_type_Ymm = paramymm;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Yml != null)
    {
      this.jdField_a_of_type_Yml.a(paramErrorMessage);
      return;
    }
    yqp.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ymm != null)
    {
      this.jdField_a_of_type_Ymm.a(a());
      return;
    }
    yqp.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymd
 * JD-Core Version:    0.7.0.1
 */