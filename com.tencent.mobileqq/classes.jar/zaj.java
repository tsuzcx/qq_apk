public class zaj
{
  private static volatile zaj jdField_a_of_type_Zaj;
  private zak jdField_a_of_type_Zak;
  
  public static zaj a()
  {
    if (jdField_a_of_type_Zaj == null) {}
    try
    {
      if (jdField_a_of_type_Zaj == null) {
        jdField_a_of_type_Zaj = new zaj();
      }
      return jdField_a_of_type_Zaj;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zak = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Zak != null) {
      this.jdField_a_of_type_Zak.a(paramString1, paramString2);
    }
  }
  
  public void a(zak paramzak)
  {
    this.jdField_a_of_type_Zak = paramzak;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Zak != null) {
      this.jdField_a_of_type_Zak.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zaj
 * JD-Core Version:    0.7.0.1
 */