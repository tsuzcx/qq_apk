import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Iterator;
import java.util.List;

public class vzl
  extends accd
{
  public vzl(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void b(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 != 0L) {}
    this.this$0.Hd = paramLong2;
    this.this$0.He = paramLong3;
  }
  
  protected void e(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((this.this$0.b != null) && (paramBoolean))
    {
      if (this.this$0.a.troopTypeExt == 2) {}
      TroopManager localTroopManager;
      TroopInfo localTroopInfo;
      StringBuffer localStringBuffer;
      for (this.this$0.b.troopTypeExt = 3;; this.this$0.b.troopTypeExt = this.this$0.a.troopTypeExt)
      {
        localTroopManager = (TroopManager)this.this$0.app.getManager(52);
        localTroopInfo = localTroopManager.c(this.this$0.a.troopUin);
        if (localTroopInfo == null) {
          break label359;
        }
        localTroopInfo.troopname = this.this$0.a.troopName;
        localTroopInfo.dwGroupClassExt = this.this$0.a.dwGroupClassExt;
        localTroopInfo.mGroupClassExtText = this.this$0.a.mTroopClassExtText;
        localTroopInfo.mRichFingerMemo = this.this$0.a.mRichFingerMemo;
        localTroopInfo.hasSetNewTroopName = this.this$0.a.hasSetNewTroopName;
        localTroopInfo.strLocation = this.this$0.a.troopLocation;
        localTroopInfo.troopLat = this.this$0.a.troopLat;
        localTroopInfo.troopLon = this.this$0.a.troopLon;
        if ((this.this$0.a.troopTags == null) || (this.this$0.a.troopTags.size() <= 0)) {
          break label352;
        }
        localStringBuffer = new StringBuffer();
        Iterator localIterator = this.this$0.a.troopTags.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localStringBuffer.append(str + "\n");
        }
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localTroopInfo.mTags = localStringBuffer.toString();
      label352:
      localTroopManager.i(localTroopInfo);
    }
    label359:
    if ((this.this$0.bLu == 0) || (1 == this.this$0.bLu)) {
      anot.a(this.this$0.app, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.this$0.a.troopUin, this.this$0.aQw, "", "");
    }
    TroopInfoActivity.a(this.this$0, paramBoolean, paramLong, paramString, 0L, this.this$0.a.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzl
 * JD-Core Version:    0.7.0.1
 */