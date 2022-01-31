import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class toa
  extends tjt
{
  public final ErrorMessage a;
  public final boolean a;
  public final String b;
  
  public toa(@NonNull ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    super(new tjs("ERROR_" + paramErrorMessage));
    this.b = null;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add("ERROR");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put("ERROR", "ERROR");
  }
  
  public toa(@NonNull String paramString, boolean paramBoolean)
  {
    super(new tjs("LOADING_" + paramString));
    this.b = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = null;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add("LOADING");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put("LOADING", "LOADING");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null;
  }
  
  public boolean c()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     toa
 * JD-Core Version:    0.7.0.1
 */