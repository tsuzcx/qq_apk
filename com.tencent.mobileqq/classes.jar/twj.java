import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import java.util.Comparator;

class twj
  implements Comparator<TroopBarData>
{
  twj(twi paramtwi) {}
  
  public int a(TroopBarData paramTroopBarData1, TroopBarData paramTroopBarData2)
  {
    long l1 = Math.max(paramTroopBarData1.mLastMsgTime, paramTroopBarData1.mLastDraftTime);
    long l2 = Math.max(paramTroopBarData2.mLastMsgTime, paramTroopBarData2.mLastDraftTime);
    if ((paramTroopBarData2.mIsSticky) && (!paramTroopBarData1.mIsSticky)) {}
    do
    {
      do
      {
        return 1;
        if ((!paramTroopBarData2.mIsSticky) && (paramTroopBarData1.mIsSticky)) {
          return -1;
        }
        if ((!paramTroopBarData2.mIsSticky) || (!paramTroopBarData1.mIsSticky)) {
          break;
        }
      } while (paramTroopBarData2.mLastStickyTime > paramTroopBarData1.mLastStickyTime);
      if (paramTroopBarData2.mLastStickyTime == paramTroopBarData1.mLastStickyTime) {
        return 0;
      }
      return -1;
    } while (l1 < l2);
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twj
 * JD-Core Version:    0.7.0.1
 */