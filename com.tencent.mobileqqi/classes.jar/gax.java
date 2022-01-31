import com.tencent.mobileqq.filemanager.core.ThumbDownLoader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.FileOutputStream;

public class gax
{
  public int a;
  public long a;
  public FileManagerEntity a;
  public HttpMsg a;
  public FileOutputStream a;
  public String a;
  public int[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  
  public gax(ThumbDownLoader paramThumbDownLoader)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_a_of_type_JavaIoFileOutputStream = null;
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
  }
  
  public String toString()
  {
    String str = "taskid[" + String.valueOf(this.jdField_d_of_type_Long) + "]";
    str = str + "EntitySessionId[" + String.valueOf(this.jdField_a_of_type_Long) + "]";
    StringBuilder localStringBuilder = new StringBuilder().append(str);
    if ("discUin[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    for (str = "entity null";; str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin) + "]")
    {
      str = str;
      str = str + "recvdSize[" + String.valueOf(this.jdField_c_of_type_Long) + "]";
      str = str + "thumbSize[" + String.valueOf(this.jdField_a_of_type_Int) + "]";
      return str + "retryTimes[" + String.valueOf(this.jdField_b_of_type_Int) + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gax
 * JD-Core Version:    0.7.0.1
 */