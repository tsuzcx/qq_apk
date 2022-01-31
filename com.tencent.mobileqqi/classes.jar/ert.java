import com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame.TroopListAdapter;
import com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask;
import java.util.Comparator;

public class ert
  implements Comparator
{
  private ert(TroopListInnerFrame.TroopListAdapter paramTroopListAdapter) {}
  
  public int a(TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask paramTroopListItemWithMask1, TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask paramTroopListItemWithMask2)
  {
    return paramTroopListItemWithMask1.a - paramTroopListItemWithMask2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ert
 * JD-Core Version:    0.7.0.1
 */