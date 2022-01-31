import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class uzr
  implements uzy
{
  private Object jdField_a_of_type_JavaLangObject;
  private uzz jdField_a_of_type_Uzz;
  private vaa jdField_a_of_type_Vaa;
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(uzz paramuzz)
  {
    this.jdField_a_of_type_Uzz = paramuzz;
  }
  
  public void a(vaa paramvaa)
  {
    this.jdField_a_of_type_Vaa = paramvaa;
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_Uzz != null)
    {
      this.jdField_a_of_type_Uzz.a(paramErrorMessage);
      return;
    }
    ved.d("SimpleStep", a() + " errorCallBack is null.");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Vaa != null)
    {
      this.jdField_a_of_type_Vaa.a(a());
      return;
    }
    ved.d("SimpleStep", a() + " finishCallBack is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzr
 * JD-Core Version:    0.7.0.1
 */