import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class ycv
  extends adai.a
{
  ycv(ycd paramycd, String paramString) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    ycd.c(this.this$0);
    if (ycd.d(this.this$0) == 0) {
      this.this$0.aAt();
    }
  }
  
  public int dI()
  {
    return 5;
  }
  
  public void onSuccess(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      ycd.a(this.this$0, ycd.a(this.this$0));
      kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.val$uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.aP(this.this$0.app, this.val$uin);
      ((apsa)this.this$0.app.getManager(132)).TL(this.this$0.sessionInfo.aTl);
      ycd.b(this.this$0, false);
      if ((this.this$0.sessionInfo != null) && (this.this$0.sessionInfo.aTl.equals(paramObject.appid.get() + ""))) {
        this.this$0.fV(1);
      }
    }
    else
    {
      return;
    }
    this.this$0.br(this.this$0.mActivity.getIntent());
  }
  
  public void p(Object paramObject)
  {
    this.this$0.oh(2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycv
 * JD-Core Version:    0.7.0.1
 */