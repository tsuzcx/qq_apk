public class rfl
{
  private static volatile rfl jdField_a_of_type_Rfl;
  private rfl.a jdField_a_of_type_Rfl$a;
  
  public static rfl a()
  {
    if (jdField_a_of_type_Rfl == null) {}
    try
    {
      if (jdField_a_of_type_Rfl == null) {
        jdField_a_of_type_Rfl = new rfl();
      }
      return jdField_a_of_type_Rfl;
    }
    finally {}
  }
  
  public void a(rfl.a parama)
  {
    this.jdField_a_of_type_Rfl$a = parama;
  }
  
  public void brY()
  {
    if (this.jdField_a_of_type_Rfl$a != null) {
      this.jdField_a_of_type_Rfl$a.brY();
    }
  }
  
  public void btK()
  {
    this.jdField_a_of_type_Rfl$a = null;
  }
  
  public void cA(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Rfl$a != null) {
      this.jdField_a_of_type_Rfl$a.cA(paramString1, paramString2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void brY();
    
    public abstract void cA(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfl
 * JD-Core Version:    0.7.0.1
 */