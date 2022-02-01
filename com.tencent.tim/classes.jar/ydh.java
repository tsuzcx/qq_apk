import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class ydh
  extends adai.a
{
  boolean blP;
  
  ydh(ycd paramycd) {}
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    this.blP = true;
  }
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    if (this.blP) {
      this.this$0.aAt();
    }
  }
  
  public int dI()
  {
    return 4;
  }
  
  public void onSuccess(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.this$0.sessionInfo.aTl, "", "", "", false);
      paramObject = (acja)this.this$0.app.getManager(56);
      if (paramObject == null) {
        break label260;
      }
      paramObject = paramObject.a(this.this$0.sessionInfo.aTl);
      if (paramObject == null) {
        break label244;
      }
      if (this.this$0.a == null) {
        this.this$0.a = ((PublicAccountHandler)this.this$0.app.getBusinessHandler(11));
      }
      this.this$0.a.bb(paramObject);
    }
    for (;;)
    {
      this.this$0.blm = true;
      this.this$0.blu = true;
      this.this$0.cgN();
      if (this.this$0.blJ)
      {
        paramObject = (PlusPanel)ycd.b(this.this$0).B(8);
        if (paramObject != null) {
          paramObject.update();
        }
      }
      this.this$0.br(this.this$0.mActivity.getIntent());
      return;
      label244:
      this.this$0.Tj();
      this.blP = false;
      continue;
      label260:
      this.this$0.Tj();
      this.blP = false;
    }
  }
  
  public void p(Object paramObject)
  {
    this.this$0.oh(2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydh
 * JD-Core Version:    0.7.0.1
 */