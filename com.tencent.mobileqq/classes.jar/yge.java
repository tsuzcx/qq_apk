import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class yge
  implements ygl
{
  private Object jdField_a_of_type_JavaLangObject;
  private ygm jdField_a_of_type_Ygm;
  private ygn jdField_a_of_type_Ygn;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(ygm paramygm)
  {
    this.jdField_a_of_type_Ygm = paramygm;
  }
  
  public void a(ygn paramygn)
  {
    this.jdField_a_of_type_Ygn = paramygn;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Ygm != null)
    {
      this.jdField_a_of_type_Ygm.a(paramErrorMessage);
      return;
    }
    ykq.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ygn != null)
    {
      this.jdField_a_of_type_Ygn.a(a());
      return;
    }
    ykq.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yge
 * JD-Core Version:    0.7.0.1
 */