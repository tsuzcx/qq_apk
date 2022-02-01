import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class apez
  extends smq.m
{
  apez(apey paramapey) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    this.this$0.arn = anaz.gQ();
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
    } while ((i != 0) || (bool));
    if ((paramDownloadFileRspBody == null) || (!paramBoolean))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqDownloadResult isSuccess:false  errCode:" + paramInt);
      this.this$0.a.resultCode = 1;
      this.this$0.a.dTI = paramInt;
      this.this$0.e(true, apue.a.dVY, apue.a.dWx, 103);
      return;
    }
    int i = paramDownloadFileRspBody.int32_ret_code.get();
    apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqDownloadResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0) {
      switch (i)
      {
      case -134: 
      default: 
        if ((i != -134) && (i != -133) && (i != -132))
        {
          this.this$0.a.resultCode = 1;
          this.this$0.a.dTI = i;
          this.this$0.cQh = true;
          this.this$0.e(true, apue.a.dVZ, i, 1);
          return;
        }
        break;
      case -107: 
      case -102: 
        this.this$0.a.resultCode = 1;
        this.this$0.a.dTI = i;
        this.this$0.cQh = true;
        this.this$0.e(true, apue.a.dVZ, i, 101);
        return;
      case -302: 
      case -301: 
      case -103: 
        apdw.b(this.this$0.mTroopUin, this.this$0.c, 301);
        if (this.this$0.c.TmpFile != null) {
          new VFSFile(this.this$0.c.TmpFile).delete();
        }
        this.this$0.c.deleteThumbnailFile(this.this$0.mTroopUin, 128);
        this.this$0.c.deleteThumbnailFile(this.this$0.mTroopUin, 640);
        this.this$0.a.resultCode = 1;
        this.this$0.a.dTI = i;
        this.this$0.cQh = true;
        this.this$0.v(true, apue.a.dVZ, i);
        return;
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
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqDownloadResult DownloadIp is null");
      apue.m("gfile", "ipnull", "", "", "", "");
    }
    if ((i == -133) || (i == -132)) {
      apdw.a(this.this$0.mTroopUin, this.this$0.c, this.this$0.c.Status, 309);
    }
    while (i != -134)
    {
      apef.b.i("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] onReqDownloadResult DownloadIp:" + this.this$0.c.DownloadIp + " DownloadDNS:" + this.this$0.c.DownloadDNS + " NameForSave:" + this.this$0.c.NameForSave + " DownloadUrl:" + this.this$0.c.DownloadUrl + " cookieValue:" + this.this$0.c.cookieValue);
      this.this$0.startDownload();
      return;
    }
    this.this$0.a.resultCode = 1;
    this.this$0.a.dTI = i;
    this.this$0.cQh = true;
    this.this$0.e(true, apue.a.dVZ, i, 302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apez
 * JD-Core Version:    0.7.0.1
 */