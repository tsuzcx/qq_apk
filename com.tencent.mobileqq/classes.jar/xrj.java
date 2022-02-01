import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class xrj
  implements xrq
{
  private Object jdField_a_of_type_JavaLangObject;
  private xrr jdField_a_of_type_Xrr;
  private xrs jdField_a_of_type_Xrs;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(xrr paramxrr)
  {
    this.jdField_a_of_type_Xrr = paramxrr;
  }
  
  public void a(xrs paramxrs)
  {
    this.jdField_a_of_type_Xrs = paramxrs;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Xrr != null)
    {
      this.jdField_a_of_type_Xrr.a(paramErrorMessage);
      return;
    }
    xvv.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Xrs != null)
    {
      this.jdField_a_of_type_Xrs.a(a());
      return;
    }
    xvv.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrj
 * JD-Core Version:    0.7.0.1
 */