import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;

public class dpk
  extends BizTroopObserver
{
  public dpk(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    this.a.n();
    int i;
    if (!paramBoolean) {
      i = 2131562078;
    }
    for (;;)
    {
      QQToast.a(this.a, i, 1).b(this.a.d());
      this.a.finish();
      return;
      if ((this.a.a.q == 3) || (this.a.a.q == 2)) {
        i = 2131562983;
      } else {
        i = 2131562984;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpk
 * JD-Core Version:    0.7.0.1
 */