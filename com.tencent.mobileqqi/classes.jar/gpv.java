import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountAssistantCache;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountMessageData;
import java.util.Comparator;

public class gpv
  implements Comparator
{
  private gpv(SubAccountAssistantCache paramSubAccountAssistantCache) {}
  
  public int a(SubAccountMessageData paramSubAccountMessageData1, SubAccountMessageData paramSubAccountMessageData2)
  {
    if ((paramSubAccountMessageData1 != null) && (paramSubAccountMessageData1.a() != null) && (paramSubAccountMessageData2 != null) && (paramSubAccountMessageData2.a() != null)) {
      return (int)(paramSubAccountMessageData2.a().time - paramSubAccountMessageData1.a().time);
    }
    if ((paramSubAccountMessageData2 == null) || (paramSubAccountMessageData2.a() == null)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gpv
 * JD-Core Version:    0.7.0.1
 */