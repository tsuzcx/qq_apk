import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.a;
import mqq.app.QQPermissionCallback;

public final class aovr
  implements QQPermissionCallback
{
  public aovr(TroopBarPublishUtils.a parama, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.val$activity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.i(aprv.a(this.val$activity, acbn.oM, 1001));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovr
 * JD-Core Version:    0.7.0.1
 */