import android.util.SparseArray;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2;
import java.util.Iterator;
import java.util.List;

public class apao
  extends acms.g
{
  public apao(TroopAioKeywordTipManager.2 param2) {}
  
  protected void M(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    SparseArray localSparseArray;
    if (paramBoolean)
    {
      localSparseArray = this.a.this$0.dz;
      if (paramList != null) {
        try
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)paramList.next();
            this.a.this$0.dz.put(localTroopAioKeywordTipInfo.ruleId, localTroopAioKeywordTipInfo);
          }
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apao
 * JD-Core Version:    0.7.0.1
 */