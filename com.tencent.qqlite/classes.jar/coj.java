import com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame.TroopListAdapter;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import java.util.Comparator;

public class coj
  implements Comparator
{
  private coj(TroopListInnerFrame.TroopListAdapter paramTroopListAdapter) {}
  
  public int a(CommonlyUsedTroop paramCommonlyUsedTroop1, CommonlyUsedTroop paramCommonlyUsedTroop2)
  {
    if (paramCommonlyUsedTroop1.addedTimestamp < paramCommonlyUsedTroop2.addedTimestamp) {
      return 1;
    }
    if (paramCommonlyUsedTroop1.addedTimestamp > paramCommonlyUsedTroop2.addedTimestamp) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     coj
 * JD-Core Version:    0.7.0.1
 */