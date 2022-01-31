import android.support.annotation.Nullable;

public class vpp
{
  @Nullable
  public String a;
  public vpm a;
  @Nullable
  public vpn a;
  @Nullable
  public String b;
  
  public vpp(@Nullable vpm paramvpm, @Nullable String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_Vpm = paramvpm;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public vpp(vpp paramvpp)
  {
    this.jdField_a_of_type_Vpm = paramvpp.jdField_a_of_type_Vpm;
    this.jdField_a_of_type_JavaLangString = paramvpp.jdField_a_of_type_JavaLangString;
    this.b = paramvpp.b;
    this.jdField_a_of_type_Vpn = paramvpp.jdField_a_of_type_Vpn;
  }
  
  public String toString()
  {
    return "StartInfo{mGroupId=" + this.jdField_a_of_type_Vpm + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", feedId='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpp
 * JD-Core Version:    0.7.0.1
 */