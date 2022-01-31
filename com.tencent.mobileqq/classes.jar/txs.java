import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class txs
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  public txs(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    TroopInfoActivity.a(this.a, true, 0L, "", this.a.a.dwGroupClassExt, this.a.a.dwGroupClassExt);
  }
  
  public void a(String paramString)
  {
    this.a.j();
    TroopInfoActivity.a(this.a, false, 0L, paramString, this.a.a.dwGroupClassExt, this.a.a.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txs
 * JD-Core Version:    0.7.0.1
 */