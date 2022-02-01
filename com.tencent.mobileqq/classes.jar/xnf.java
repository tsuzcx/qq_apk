import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class xnf
  extends xiy
{
  public final ErrorMessage a;
  public final boolean a;
  public final String b;
  
  public xnf(@NonNull ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    super(new xix("ERROR_" + paramErrorMessage));
    this.b = null;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add("ERROR");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put("ERROR", "ERROR");
  }
  
  public xnf(@NonNull String paramString, boolean paramBoolean)
  {
    super(new xix("LOADING_" + paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */