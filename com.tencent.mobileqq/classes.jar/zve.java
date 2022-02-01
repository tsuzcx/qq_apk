import android.text.TextUtils;

public class zve
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private zwd jdField_a_of_type_Zwd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  private zve(zvg paramzvg)
  {
    if (!TextUtils.isEmpty(zvg.a(paramzvg))) {
      this.jdField_a_of_type_JavaLangString = zvg.a(paramzvg);
    }
    this.jdField_a_of_type_Boolean = zvg.a(paramzvg);
    long l;
    int i;
    if (zvg.a(paramzvg) > 0L)
    {
      l = zvg.a(paramzvg);
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = zvg.a(paramzvg);
      if (zvg.b(paramzvg) <= 0) {
        break label107;
      }
      i = zvg.b(paramzvg);
      label69:
      this.jdField_b_of_type_Int = i;
      this.jdField_b_of_type_Boolean = zvg.b(paramzvg);
      if (zvg.a(paramzvg) == null) {
        break label113;
      }
    }
    label107:
    label113:
    for (paramzvg = zvg.a(paramzvg);; paramzvg = new zwb())
    {
      this.jdField_a_of_type_Zwd = paramzvg;
      return;
      l = 1000L;
      break;
      i = 50;
      break label69;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public zwd a()
  {
    return this.jdField_a_of_type_Zwd;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zve
 * JD-Core Version:    0.7.0.1
 */