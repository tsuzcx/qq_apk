import android.content.Context;
import android.net.Uri;
import java.util.Map;

public class xrs
  implements xrq
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Uri jdField_a_of_type_AndroidNetUri;
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private Uri jdField_b_of_type_AndroidNetUri;
  private Map<String, String> jdField_b_of_type_JavaUtilMap;
  
  public xrs(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidNetUri = paramUri;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public xrl a()
  {
    xrl localxrl = new xrl();
    localxrl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaUtilMap);
    return localxrl;
  }
  
  public xrl b()
  {
    if (this.jdField_b_of_type_AndroidNetUri != null)
    {
      xrl localxrl = new xrl();
      localxrl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidNetUri, this.jdField_b_of_type_JavaUtilMap);
      return localxrl;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrs
 * JD-Core Version:    0.7.0.1
 */