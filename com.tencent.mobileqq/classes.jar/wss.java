import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class wss
  implements wsz
{
  private Object jdField_a_of_type_JavaLangObject;
  private wta jdField_a_of_type_Wta;
  private wtb jdField_a_of_type_Wtb;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(wta paramwta)
  {
    this.jdField_a_of_type_Wta = paramwta;
  }
  
  public void a(wtb paramwtb)
  {
    this.jdField_a_of_type_Wtb = paramwtb;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Wta != null)
    {
      this.jdField_a_of_type_Wta.a(paramErrorMessage);
      return;
    }
    wxe.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Wtb != null)
    {
      this.jdField_a_of_type_Wtb.a(a());
      return;
    }
    wxe.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wss
 * JD-Core Version:    0.7.0.1
 */