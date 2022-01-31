import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileTaskInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ee
{
  public Map a;
  public Map b = new HashMap();
  
  private ee(MpfileDataCenter paramMpfileDataCenter)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public MpfileTaskInfo a(long paramLong)
  {
    return (MpfileTaskInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
  }
  
  public MpfileTaskInfo a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!this.b.containsKey(paramString)) {
      return null;
    }
    return a(((Long)this.b.get(paramString)).longValue());
  }
  
  public ArrayList a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
  }
  
  public void a(MpfileTaskInfo paramMpfileTaskInfo)
  {
    if (paramMpfileTaskInfo == null) {}
    while ((paramMpfileTaskInfo.c == null) || (paramMpfileTaskInfo.c.length() == 0) || (paramMpfileTaskInfo.d == 0L)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMpfileTaskInfo.d), paramMpfileTaskInfo);
    this.b.put(paramMpfileTaskInfo.c, Long.valueOf(paramMpfileTaskInfo.d));
    this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(paramMpfileTaskInfo);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramString.d));
    this.b.remove(paramString.c);
    this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.d(paramString.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ee
 * JD-Core Version:    0.7.0.1
 */