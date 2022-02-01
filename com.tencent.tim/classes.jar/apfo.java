import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class apfo
  extends smq.m
{
  apfo(apfn paramapfn) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.this$0.mTroopUin) {}
    boolean bool;
    do
    {
      String str;
      do
      {
        return;
        str = paramBundle.getString("itemKey");
      } while ((str == null) || (!UUID.fromString(str).equals(this.this$0.a())) || (this.this$0.bkn));
      i = paramBundle.getInt("thumbNail");
      bool = paramBundle.getBoolean("isPreview", false);
    } while ((i == 0) || (bool) || (i != this.this$0.bYf));
    if ((paramDownloadFileRspBody == null) || (!paramBoolean))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqFetchResult isSuccess:false  errCode:" + paramInt);
      this.this$0.WG(apue.a.dWx);
      return;
    }
    int i = paramDownloadFileRspBody.int32_ret_code.get();
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqFetchResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      if ((i != -103) && (i != -302) && (i != -301)) {
        break label784;
      }
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqFetchResult  file is not exsit. retCode:" + i);
      this.this$0.bkn = true;
      this.this$0.WE(4);
      this.this$0.c.ErrorCode = 0;
      apdw.a(this.this$0.mTroopUin, this.this$0.c, 12);
      if (this.this$0.a != null) {
        this.this$0.a.a(this.this$0.Bd(), false, i, this.this$0);
      }
    }
    this.this$0.c.cookieValue = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
    if (this.this$0.c.cookieValue != null) {
      this.this$0.c.cookieValue = this.this$0.c.cookieValue.toLowerCase();
    }
    this.this$0.c.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    this.this$0.c.DownloadDNS = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
    this.this$0.c.DownloadUrl = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    this.this$0.c.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    this.this$0.c.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if (TextUtils.isEmpty(this.this$0.c.DownloadIp))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqFetchResult DownloadIp is null");
      apue.m("gfile", "ipnull", "", "", "", "");
    }
    i = paramDownloadFileRspBody.uint32_preview_port.get();
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqFetchResult DownloadIp:" + this.this$0.c.DownloadIp + " DownloadDNS:" + this.this$0.c.DownloadDNS + " videoPort:" + i + " DownloadUrl:" + this.this$0.c.DownloadUrl + " cookieValue:" + this.this$0.c.cookieValue);
    if (paramDownloadFileRspBody.uint32_preview_port_https.has()) {}
    for (paramInt = paramDownloadFileRspBody.uint32_preview_port_https.get();; paramInt = 0)
    {
      paramBundle = null;
      if (paramDownloadFileRspBody.str_download_dns_https.has()) {
        paramBundle = paramDownloadFileRspBody.str_download_dns_https.get();
      }
      this.this$0.b(i, paramBundle, paramInt);
      return;
      label784:
      this.this$0.WG(i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfo
 * JD-Core Version:    0.7.0.1
 */