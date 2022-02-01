import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class apga
  extends smq.q
{
  apga(apfz paramapfz) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    apfz.a(this.a, null);
    if (apfz.a(this.a))
    {
      apef.b.w("TroopFileUploadSimpleWorker", apef.b.USR, "[" + apfz.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      apef.b.e("TroopFileUploadSimpleWorker", apef.b.USR, "[" + apfz.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      apfz.a(this.a, apue.a.dWx);
      apfz.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + apfz.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      apfz.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        apfz.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (apfz.a(this.a) != 104)
        {
          apfz.a(this.a, 104);
          apfz.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          apfz.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    apfz.b(this.a, paramUploadFileRspBody.str_file_id.get());
    apfz.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    apfz.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    apfz.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    apfz.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    apef.b.i("TroopFileUploadSimpleWorker", apef.b.USR, "[" + apfz.a(this.a) + "] onReqUploadFileResult fileid:" + apfz.b(this.a) + " UploadIp:" + apfz.c(this.a) + " ServerDns:" + apfz.d(this.a) + " busId:" + apfz.a(this.a));
    this.a.RE(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apga
 * JD-Core Version:    0.7.0.1
 */