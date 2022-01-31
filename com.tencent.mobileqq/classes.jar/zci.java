import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import java.util.Comparator;

public class zci
  implements Comparator
{
  public zci(HotchatSCMng paramHotchatSCMng) {}
  
  public int a(HotchatSCMng.HotchatNote paramHotchatNote1, HotchatSCMng.HotchatNote paramHotchatNote2)
  {
    if ((paramHotchatNote1 == null) || (paramHotchatNote2 == null)) {}
    do
    {
      return 0;
      if (paramHotchatNote1.a > paramHotchatNote2.a) {
        return 1;
      }
    } while (paramHotchatNote1.a >= paramHotchatNote2.a);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zci
 * JD-Core Version:    0.7.0.1
 */