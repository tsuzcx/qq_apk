import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class ypi
{
  public int a;
  public final PBRepeatMessageField<qqstory_struct.UserVidList> a;
  public String a;
  public final ArrayList<String> a;
  public wuk a;
  public boolean a;
  
  public ypi()
  {
    this(0, null);
  }
  
  public ypi(int paramInt, PBRepeatMessageField<qqstory_struct.UserVidList> paramPBRepeatMessageField)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Wuk = new wuk();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramPBRepeatMessageField;
  }
  
  public static ypi a(String paramString)
  {
    ypi localypi = new ypi();
    localypi.jdField_a_of_type_JavaLangString = paramString;
    return localypi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypi
 * JD-Core Version:    0.7.0.1
 */