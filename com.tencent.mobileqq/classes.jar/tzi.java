import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;

public class tzi
{
  public int a;
  public long a;
  public String a;
  
  public tzi(tzf paramtzf, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramtzf = ((spt)sqg.a(19)).a(paramString);
    if (paramtzf != null) {
      a(paramtzf);
    }
  }
  
  public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
  {
    this.jdField_a_of_type_Long = paramMemoryInfoEntry.seq;
    this.jdField_a_of_type_JavaLangString = paramMemoryInfoEntry.cookie;
    this.jdField_a_of_type_Int = paramMemoryInfoEntry.timeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzi
 * JD-Core Version:    0.7.0.1
 */