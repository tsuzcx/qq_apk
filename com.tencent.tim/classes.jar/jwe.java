import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;

public class jwe
  implements kbu.b<OACProfilePb.ProfileDataRsp>
{
  public jwe(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void a(int paramInt, boolean paramBoolean, OACProfilePb.ProfileDataRsp paramProfileDataRsp, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    paramBundle = this.this$0;
    paramBundle.aDG -= 1;
    if (this.this$0.aDG == 0) {
      this.this$0.aAt();
    }
    if (!paramBoolean)
    {
      if (this.this$0.isFirst)
      {
        if (this.this$0.a != null)
        {
          this.this$0.a.hq(false);
          this.this$0.a.notifyDataSetChanged();
        }
      }
      else {
        return;
      }
      this.this$0.oh(2131697432);
      return;
    }
    paramBundle = new AccountDetail(paramProfileDataRsp);
    kaw.a().a(this.this$0.app, this.this$0.uin, paramProfileDataRsp.menu_rsp);
    this.this$0.a(paramBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwe
 * JD-Core Version:    0.7.0.1
 */