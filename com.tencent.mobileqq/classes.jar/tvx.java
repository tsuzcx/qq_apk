import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public class tvx
  extends TroopObserver
{
  public tvx(TroopLowCreditLevelNotifyActivity paramTroopLowCreditLevelNotifyActivity) {}
  
  protected void a(oidb_0xaf4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      paramRspBody = String.valueOf(paramRspBody.group_id.get());
      if (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramRspBody)) {
        break label119;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + paramRspBody + ", current uin=" + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    label119:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onGetNewTroopAppList group_id lost. current uin=" + this.a.jdField_a_of_type_JavaLangString);
      }
      this.a.d();
      paramRspBody = this.a.a(1101236949L);
    } while (paramRspBody == null);
    this.a.a(paramRspBody);
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "onGetTroopCreditLevelInfo:" + this.a.jdField_a_of_type_JavaLangString + "," + paramBoolean);
    }
    if (!this.a.jdField_a_of_type_JavaLangString.equals(paramLong + "")) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.a.d();
          } while (!paramBoolean);
          localObject = (TroopManager)this.a.app.getManager(51);
        } while (localObject == null);
        localObject = ((TroopManager)localObject).a(this.a.jdField_a_of_type_JavaLangString);
      } while (localObject == null);
      paramLong = ((TroopInfo)localObject).troopCreditLevel;
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "onGetTroopCreditLevelInfo:" + this.a.jdField_a_of_type_JavaLangString + "," + paramLong);
      }
    } while (paramLong == 2L);
    if (paramLong == 1L)
    {
      localObject = DialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.a.getString(2131434764)).setMessage("无法操作，此群已经完全停封");
      ((QQCustomDialog)localObject).setPositiveButton(2131430676, new tvy(this));
      ((QQCustomDialog)localObject).setNegativeButton("", null);
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).show();
      return;
    }
    Object localObject = DialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.a.getString(2131434764)).setMessage("此群临时停封已经解除");
    ((QQCustomDialog)localObject).setPositiveButton(2131430676, new tvz(this));
    ((QQCustomDialog)localObject).setNegativeButton("", null);
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvx
 * JD-Core Version:    0.7.0.1
 */