import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class wnt
{
  public int a;
  public final PBRepeatMessageField<qqstory_struct.UserVidList> a;
  public String a;
  public final ArrayList<String> a;
  public usu a;
  public boolean a;
  
  public wnt()
  {
    this(0, null);
  }
  
  public wnt(int paramInt, PBRepeatMessageField<qqstory_struct.UserVidList> paramPBRepeatMessageField)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Usu = new usu();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramPBRepeatMessageField;
  }
  
  public static wnt a(String paramString)
  {
    wnt localwnt = new wnt();
    localwnt.jdField_a_of_type_JavaLangString = paramString;
    return localwnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnt
 * JD-Core Version:    0.7.0.1
 */