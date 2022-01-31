import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class uzb
{
  public int a;
  public final PBRepeatMessageField<qqstory_struct.UserVidList> a;
  public String a;
  public final ArrayList<String> a;
  public tec a;
  public boolean a;
  
  public uzb()
  {
    this(0, null);
  }
  
  public uzb(int paramInt, PBRepeatMessageField<qqstory_struct.UserVidList> paramPBRepeatMessageField)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Tec = new tec();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramPBRepeatMessageField;
  }
  
  public static uzb a(String paramString)
  {
    uzb localuzb = new uzb();
    localuzb.jdField_a_of_type_JavaLangString = paramString;
    return localuzb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzb
 * JD-Core Version:    0.7.0.1
 */