import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;

public class vcj
{
  public int a;
  public long a;
  public String a;
  
  public vcj(vcg paramvcg, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramvcg = ((uvn)uwa.a(19)).a(paramString);
    if (paramvcg != null) {
      a(paramvcg);
    }
  }
  
  public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
  {
    this.jdField_a_of_type_Long = paramMemoryInfoEntry.seq;
    this.jdField_a_of_type_JavaLangString = paramMemoryInfoEntry.cookie;
    this.jdField_a_of_type_Int = paramMemoryInfoEntry.timeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vcj
 * JD-Core Version:    0.7.0.1
 */