import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker.1.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class apgc
  extends smq.q
{
  apgc(apgb paramapgb) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    if (!apgb.a(this.this$0, paramBundle, l)) {
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      apef.b.e("TroopFileUploadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      this.this$0.a.resultCode = 1;
      this.this$0.a.dTI = paramInt;
      paramUploadFileRspBody = new apsd.a(this.this$0.c.FileName, this.this$0.mTroopUin, 3, 207);
      this.this$0.a(true, apue.a.dVY, apue.a.dWx, paramUploadFileRspBody);
      return;
    }
    int j = paramUploadFileRspBody.int32_ret_code.get();
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + j);
    if (j < 0)
    {
      paramBundle = null;
      int i;
      switch (j)
      {
      default: 
        i = 207;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
      }
      for (;;)
      {
        this.this$0.a.resultCode = 1;
        this.this$0.a.dTI = j;
        paramBundle = paramUploadFileRspBody;
        if (paramUploadFileRspBody == null) {
          paramBundle = new apsd.a(this.this$0.c.FileName, l, 3, i);
        }
        this.this$0.a(paramBoolean, apue.a.dVZ, paramInt, paramBundle);
        return;
        i = 202;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = 208;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        new Handler(Looper.getMainLooper()).postDelayed(new TroopFileUploadWorker.1.1(this, l), 1000L);
        return;
        if (this.this$0.c.BusId != 104)
        {
          this.this$0.c.BusId = 104;
          this.this$0.dZn();
          return;
        }
        i = 204;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = 209;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = -136;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = -138;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        paramUploadFileRspBody = paramUploadFileRspBody.str_client_wording.get();
        paramUploadFileRspBody = new apsd.a(this.this$0.c.FileName, l, 3, 704, paramUploadFileRspBody);
        i = 207;
        paramBoolean = false;
      }
    }
    this.this$0.c.FilePath = paramUploadFileRspBody.str_file_id.get();
    this.this$0.c.UploadIp = paramUploadFileRspBody.str_upload_ip.get();
    this.this$0.c.ServerDns = paramUploadFileRspBody.str_server_dns.get();
    this.this$0.c.CheckKey = paramUploadFileRspBody.bytes_check_key.get().toByteArray();
    this.this$0.c.BusId = paramUploadFileRspBody.uint32_bus_id.get();
    apef.b.i("TroopFileUploadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqUploadFileResult fileid:" + this.this$0.c.FilePath + " UploadIp:" + this.this$0.c.UploadIp + " ServerDns:" + this.this$0.c.ServerDns + " busId:" + this.this$0.c.BusId);
    this.this$0.a(paramUploadFileRspBody);
    this.this$0.RE(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgc
 * JD-Core Version:    0.7.0.1
 */