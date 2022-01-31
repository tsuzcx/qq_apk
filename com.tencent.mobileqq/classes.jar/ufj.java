import android.content.Context;
import android.net.Uri;
import java.util.Map;

public class ufj
  implements ufh
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private Uri jdField_b_of_type_AndroidNetUri;
  private Map<String, String> jdField_b_of_type_JavaUtilMap;
  
  public ufj(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public ufc a()
  {
    ufc localufc = new ufc();
    localufc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaUtilMap);
    return localufc;
  }
  
  public ufc b()
  {
    if (this.jdField_b_of_type_AndroidNetUri != null)
    {
      ufc localufc = new ufc();
      localufc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidNetUri, this.jdField_b_of_type_JavaUtilMap);
      return localufc;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufj
 * JD-Core Version:    0.7.0.1
 */