import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.RspBody;

public class wac
  extends acnd
{
  public wac(TroopLowCreditLevelNotifyActivity paramTroopLowCreditLevelNotifyActivity) {}
  
  protected void a(oidb_0xea4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      paramRspBody = String.valueOf(paramRspBody.group_id.get());
      if (TextUtils.equals(this.a.mTroopUin, paramRspBody)) {
        break label119;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + paramRspBody + ", current uin=" + this.a.mTroopUin);
      }
    }
    label119:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList group_id lost. current uin=" + this.a.mTroopUin);
      }
      this.a.hideProgressDialog();
      paramRspBody = this.a.a(1101236949L);
    } while (paramRspBody == null);
    this.a.a(paramRspBody);
  }
  
  protected void y(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "onGetTroopCreditLevelInfo:" + this.a.mTroopUin + "," + paramBoolean);
    }
    if (!this.a.mTroopUin.equals(paramLong + "")) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.a.hideProgressDialog();
          } while (!paramBoolean);
          localObject = (TroopManager)this.a.app.getManager(52);
        } while (localObject == null);
        localObject = ((TroopManager)localObject).b(this.a.mTroopUin);
      } while (localObject == null);
      paramLong = ((TroopInfo)localObject).troopCreditLevel;
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "onGetTroopCreditLevelInfo:" + this.a.mTroopUin + "," + paramLong);
      }
    } while (paramLong == 2L);
    if (paramLong == 1L)
    {
      localObject = aqha.a(this.a.mContext, 230).setTitle(this.a.getString(2131721103)).setMessage(acfp.m(2131715835));
      ((aqju)localObject).setPositiveButton(2131699773, new wad(this));
      ((aqju)localObject).setNegativeButton("", null);
      ((aqju)localObject).setCancelable(false);
      ((aqju)localObject).show();
      return;
    }
    Object localObject = aqha.a(this.a.mContext, 230).setTitle(this.a.getString(2131721103)).setMessage(acfp.m(2131715836));
    ((aqju)localObject).setPositiveButton(2131699773, new wae(this));
    ((aqju)localObject).setNegativeButton("", null);
    ((aqju)localObject).setCancelable(false);
    ((aqju)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wac
 * JD-Core Version:    0.7.0.1
 */