import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class umy
  implements unf
{
  private Object jdField_a_of_type_JavaLangObject;
  private ung jdField_a_of_type_Ung;
  private unh jdField_a_of_type_Unh;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(ung paramung)
  {
    this.jdField_a_of_type_Ung = paramung;
  }
  
  public void a(unh paramunh)
  {
    this.jdField_a_of_type_Unh = paramunh;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Ung != null)
    {
      this.jdField_a_of_type_Ung.a(paramErrorMessage);
      return;
    }
    urk.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Unh != null)
    {
      this.jdField_a_of_type_Unh.a(a());
      return;
    }
    urk.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umy
 * JD-Core Version:    0.7.0.1
 */