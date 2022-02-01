import org.jetbrains.annotations.NotNull;

public class uor
{
  private static volatile uor jdField_a_of_type_Uor;
  private String jdField_a_of_type_JavaLangString;
  
  public static uor a()
  {
    if (jdField_a_of_type_Uor == null) {}
    try
    {
      if (jdField_a_of_type_Uor == null) {
        jdField_a_of_type_Uor = new uor();
      }
      return jdField_a_of_type_Uor;
    }
    finally {}
  }
  
  @NotNull
  private uqy a(String paramString, uot paramuot)
  {
    return new uos(this, paramuot, paramString);
  }
  
  public void a(String paramString1, String paramString2, uot paramuot)
  {
    uya.e("WSJoinGroupDataProcessor", "requestGroupSign: UserConfig request  groupId = " + paramString1);
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (paramuot != null) {
      paramuot.b();
    }
    paramString2 = new uws(paramString1, paramString2);
    paramString2.b = paramString1;
    paramString1 = new urj(paramString2, null, a(paramString1, paramuot), 4014);
    urc.a().a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uor
 * JD-Core Version:    0.7.0.1
 */