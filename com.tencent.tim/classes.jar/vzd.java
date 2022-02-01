import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class vzd
  implements jrs.b
{
  public vzd(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void azf()
  {
    if (this.this$0.b != null) {
      this.this$0.b.troopTypeExt = 4;
    }
    anot.a(this.this$0.app, "P_CliOper", "Grp_create", "", "edit_data", "local_suc", 0, 0, this.this$0.a.troopUin, this.this$0.aQw, "", "");
    TroopInfoActivity.a(this.this$0, true, 0L, "", this.this$0.a.dwGroupClassExt, this.this$0.a.dwGroupClassExt);
  }
  
  public void onFailed(String paramString)
  {
    this.this$0.CA();
    TroopInfoActivity.a(this.this$0, false, 0L, paramString, this.this$0.a.dwGroupClassExt, this.this$0.a.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzd
 * JD-Core Version:    0.7.0.1
 */