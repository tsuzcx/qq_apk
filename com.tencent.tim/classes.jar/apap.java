import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4.1;
import java.util.List;

public class apap
  extends acms.g
{
  apap(apan paramapan, MessageRecord paramMessageRecord, apan.a parama) {}
  
  protected void M(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        apan.a(this.this$0, this.k, (TroopAioKeywordTipInfo)paramList.get(0), this.a);
        synchronized (this.this$0.dz)
        {
          this.this$0.dz.put(((TroopAioKeywordTipInfo)paramList.get(0)).ruleId, paramList.get(0));
          ThreadManager.post(new TroopAioKeywordTipManager.4.1(this, paramList), 2, null, true);
          return;
        }
      }
      apan.a(this.this$0, this.k, null, this.a);
      return;
    }
    apan.a(this.this$0, this.k, null, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apap
 * JD-Core Version:    0.7.0.1
 */