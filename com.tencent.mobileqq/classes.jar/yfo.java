import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class yfo
{
  public int a;
  public final PBRepeatMessageField<qqstory_struct.UserVidList> a;
  public String a;
  public final ArrayList<String> a;
  public wkv a;
  public boolean a;
  
  public yfo()
  {
    this(0, null);
  }
  
  public yfo(int paramInt, PBRepeatMessageField<qqstory_struct.UserVidList> paramPBRepeatMessageField)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Wkv = new wkv();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField = paramPBRepeatMessageField;
  }
  
  public static yfo a(String paramString)
  {
    yfo localyfo = new yfo();
    localyfo.jdField_a_of_type_JavaLangString = paramString;
    return localyfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfo
 * JD-Core Version:    0.7.0.1
 */