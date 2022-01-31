import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.data.HotChatItemData;
import java.util.Comparator;

public class zbn
  implements Comparator
{
  public zbn(HotChatCenterManager paramHotChatCenterManager) {}
  
  public int a(HotChatItemData paramHotChatItemData1, HotChatItemData paramHotChatItemData2)
  {
    long l1 = paramHotChatItemData1.mMakeTopTime;
    long l2 = paramHotChatItemData2.mMakeTopTime;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zbn
 * JD-Core Version:    0.7.0.1
 */