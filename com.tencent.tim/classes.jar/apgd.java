import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody;

class apgd
  extends smq.o
{
  apgd(apgb paramapgb) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.ResendRspBody paramResendRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.this$0.mTroopUin) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.this$0.a())));
    if (this.this$0.bkn)
    {
      apef.b.w("TroopFileUploadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqResendFileResult.but stoped");
      return;
    }
    if ((paramResendRspBody == null) || (!paramBoolean))
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqResendFileResult isSuccess:false  errCode:" + paramInt);
      paramResendRspBody = new apsd.a(this.this$0.c.FileName, this.this$0.mTroopUin, 3, 207);
      this.this$0.a.resultCode = 1;
      this.this$0.a.dTI = paramInt;
      this.this$0.a(true, apue.a.dVY, apue.a.dWx, paramResendRspBody);
      return;
    }
    int i = paramResendRspBody.int32_ret_code.get();
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqResendFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      switch (paramResendRspBody.int32_ret_code.get())
      {
      default: 
        paramInt = 1;
      }
      for (;;)
      {
        this.this$0.a.resultCode = 1;
        this.this$0.a.dTI = i;
        if (paramInt != 206) {
          break;
        }
        apdw.b(this.this$0.mTroopUin, this.this$0.c, paramInt);
        this.this$0.v(false, apue.a.dVZ, i);
        return;
        paramInt = 101;
        continue;
        paramInt = 102;
        continue;
        paramInt = 206;
        continue;
        paramInt = -136;
        continue;
        paramInt = -138;
      }
      this.this$0.e(true, apue.a.dVZ, i, paramInt);
      return;
    }
    this.this$0.c.UploadIp = paramResendRspBody.str_upload_ip.get();
    this.this$0.c.CheckKey = paramResendRspBody.bytes_check_key.get().toByteArray();
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqResendFileResult fileid:" + this.this$0.c.FilePath + " UploadIp:" + this.this$0.c.UploadIp + " busId:" + this.this$0.c.BusId);
    this.this$0.RE(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgd
 * JD-Core Version:    0.7.0.1
 */