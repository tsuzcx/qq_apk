import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class uzu
  implements vab
{
  private Object jdField_a_of_type_JavaLangObject;
  private vac jdField_a_of_type_Vac;
  private vad jdField_a_of_type_Vad;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(vac paramvac)
  {
    this.jdField_a_of_type_Vac = paramvac;
  }
  
  public void a(vad paramvad)
  {
    this.jdField_a_of_type_Vad = paramvad;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Vac != null)
    {
      this.jdField_a_of_type_Vac.a(paramErrorMessage);
      return;
    }
    veg.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Vad != null)
    {
      this.jdField_a_of_type_Vad.a(a());
      return;
    }
    veg.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzu
 * JD-Core Version:    0.7.0.1
 */