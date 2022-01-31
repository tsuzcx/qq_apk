import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class woj
  implements woq
{
  private Object jdField_a_of_type_JavaLangObject;
  private wor jdField_a_of_type_Wor;
  private wos jdField_a_of_type_Wos;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(wor paramwor)
  {
    this.jdField_a_of_type_Wor = paramwor;
  }
  
  public void a(wos paramwos)
  {
    this.jdField_a_of_type_Wos = paramwos;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Wor != null)
    {
      this.jdField_a_of_type_Wor.a(paramErrorMessage);
      return;
    }
    wsv.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Wos != null)
    {
      this.jdField_a_of_type_Wos.a(a());
      return;
    }
    wsv.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     woj
 * JD-Core Version:    0.7.0.1
 */