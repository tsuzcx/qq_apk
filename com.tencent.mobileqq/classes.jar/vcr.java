import org.jetbrains.annotations.NotNull;

public class vcr
{
  private static volatile vcr jdField_a_of_type_Vcr;
  private String jdField_a_of_type_JavaLangString;
  
  public static vcr a()
  {
    if (jdField_a_of_type_Vcr == null) {}
    try
    {
      if (jdField_a_of_type_Vcr == null) {
        jdField_a_of_type_Vcr = new vcr();
      }
      return jdField_a_of_type_Vcr;
    }
    finally {}
  }
  
  @NotNull
  private vfg a(String paramString, vct paramvct)
  {
    return new vcs(this, paramvct, paramString);
  }
  
  public void a(String paramString1, String paramString2, vct paramvct)
  {
    vmp.e("WSJoinGroupDataProcessor", "requestGroupSign: UserConfig request  groupId = " + paramString1);
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (paramvct != null) {
      paramvct.b();
    }
    paramString2 = new vlh(paramString1, paramString2);
    paramString2.b = paramString1;
    paramString1 = new vfr(paramString2, null, a(paramString1, paramvct), 4014);
    vfk.a().a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcr
 * JD-Core Version:    0.7.0.1
 */