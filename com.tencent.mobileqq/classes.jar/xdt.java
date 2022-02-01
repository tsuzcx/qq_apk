import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;

public class xdt
{
  public int a;
  public long a;
  public String a;
  
  public xdt(xdq paramxdq, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramxdq = ((vuk)vux.a(19)).a(paramString);
    if (paramxdq != null) {
      a(paramxdq);
    }
  }
  
  public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
  {
    this.jdField_a_of_type_Long = paramMemoryInfoEntry.seq;
    this.jdField_a_of_type_JavaLangString = paramMemoryInfoEntry.cookie;
    this.jdField_a_of_type_Int = paramMemoryInfoEntry.timeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdt
 * JD-Core Version:    0.7.0.1
 */