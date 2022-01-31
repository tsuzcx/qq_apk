import android.content.Context;

public class vqi
{
  protected int a;
  Context a;
  protected beqz a;
  protected vqk a;
  protected boolean a;
  
  public vqi(beqz parambeqz, Context paramContext)
  {
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Beqz = parambeqz;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(vqk paramvqk)
  {
    this.jdField_a_of_type_Vqk = paramvqk;
    if (paramvqk != null)
    {
      a(true);
      a(true, false);
    }
    this.jdField_a_of_type_Beqz.setOnClickListener(new vqj(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Beqz.a(3);
      return;
    }
    this.jdField_a_of_type_Beqz.a(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_Beqz.a(5);
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Beqz.a(i);
      if ((!this.jdField_a_of_type_Beqz.b(i)) || (this.jdField_a_of_type_Vqk == null)) {
        break;
      }
      this.jdField_a_of_type_Vqk.a();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Beqz.a() == 0) || (!this.jdField_a_of_type_Beqz.b(2)));
      bool = true;
      if (this.jdField_a_of_type_Vqk != null) {
        bool = this.jdField_a_of_type_Vqk.a(paramBoolean);
      }
    } while (!bool);
    this.jdField_a_of_type_Beqz.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqi
 * JD-Core Version:    0.7.0.1
 */