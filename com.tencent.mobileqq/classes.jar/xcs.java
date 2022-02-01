import com.tencent.biz.qqstory.app.QQStoryContext;

public abstract class xcs
  extends xcu
{
  protected int a;
  protected boolean a;
  protected int b = -1;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h = QQStoryContext.a().b();
  protected String i;
  protected String j;
  
  public xcs()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public final void a(xdy paramxdy)
  {
    super.a(paramxdy);
    paramxdy.jdField_a_of_type_JavaLangString = a(6);
    a(paramxdy);
  }
  
  protected void a(xdz paramxdz) {}
  
  public void a(xea paramxea)
  {
    super.a(paramxea);
    paramxea.b = 1;
    paramxea.m = this.g;
    paramxea.jdField_d_of_type_JavaLangString = this.f;
    paramxea.l = this.e;
    paramxea.k = this.jdField_d_of_type_JavaLangString;
    paramxea.jdField_a_of_type_JavaLangString = this.i;
    paramxea.h = a(1);
    if (this.jdField_a_of_type_Int != -1) {
      paramxea.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    }
    if (this.b != -1) {
      paramxea.e = this.b;
    }
    a(paramxea);
  }
  
  public void a(xeb paramxeb)
  {
    super.a(paramxeb);
    paramxeb.c = this.jdField_d_of_type_JavaLangString;
    paramxeb.jdField_d_of_type_JavaLangString = this.e;
    paramxeb.jdField_a_of_type_JavaLangString = this.i;
    paramxeb.e = a(2);
    a(paramxeb);
  }
  
  public void a(xec paramxec)
  {
    super.a(paramxec);
    paramxec.jdField_a_of_type_JavaLangString = this.j;
    paramxec.e = this.i;
    paramxec.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    paramxec.jdField_d_of_type_JavaLangString = xek.a(this.i);
    paramxec.c = a(5);
    a(paramxec);
  }
  
  public void a(xed paramxed)
  {
    super.a(paramxed);
    paramxed.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramxed.c = this.e;
    paramxed.jdField_d_of_type_JavaLangString = a(3);
    paramxed.e = this.i;
    paramxed.b = true;
    a(paramxed);
  }
  
  public void b(xed paramxed)
  {
    super.b(paramxed);
    paramxed.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramxed.c = this.e;
    paramxed.jdField_d_of_type_JavaLangString = a(4);
    paramxed.e = this.i;
    paramxed.b = true;
    a(paramxed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcs
 * JD-Core Version:    0.7.0.1
 */