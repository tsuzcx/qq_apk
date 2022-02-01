import com.tencent.mobileqq.data.OpenID;
import com.tencent.open.agent.TroopAbilityPreVerificationFragment;
import com.tencent.qphone.base.util.QLog;

public class arsz
  extends jqk
{
  public arsz(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    QLog.d("TroopAbility.PreVerification", 1, "-->onGetOpenId, isSuccess: " + paramBoolean + " data: " + paramOpenID);
    if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
    {
      if (!paramOpenID.openID.equals(this.this$0.mOpenId))
      {
        this.this$0.hideProgress();
        TroopAbilityPreVerificationFragment.a(this.this$0);
        return;
      }
      this.this$0.elE();
      return;
    }
    this.this$0.WY(acfp.m(2131715487));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsz
 * JD-Core Version:    0.7.0.1
 */