import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class agvd
  extends smq.m
{
  agvd(aguu paramaguu, aguk.b paramb) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (this.a == null) {}
    Object localObject;
    label525:
    do
    {
      do
      {
        return;
        if (paramDownloadFileRspBody == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error DownloadFileRspBody is null!");
          this.a.djD();
          return;
        }
        long l = paramBundle.getLong("troopUin");
        localObject = TroopFileTransferManager.a(l);
        if (localObject == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad troopUin[" + l + "]");
          this.a.djD();
          return;
        }
        paramBundle = paramBundle.getString("itemKey");
        if (paramBundle == null)
        {
          this.a.djD();
          return;
        }
        localObject = ((TroopFileTransferManager)localObject).a(UUID.fromString(paramBundle));
        if (localObject == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad item key" + paramBundle + "]");
          this.a.djD();
          return;
        }
        paramInt = paramDownloadFileRspBody.int32_ret_code.get();
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: onRspDownload - retCode[" + paramInt + "]");
        }
      } while (aguu.a(this.this$0, paramInt, this.a));
      ((TroopFileTransferManager.Item)localObject).cookieValue = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      if (((TroopFileTransferManager.Item)localObject).cookieValue != null) {
        ((TroopFileTransferManager.Item)localObject).cookieValue = ((TroopFileTransferManager.Item)localObject).cookieValue.toLowerCase();
      }
      ((TroopFileTransferManager.Item)localObject).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
      ((TroopFileTransferManager.Item)localObject).DownloadUrl = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      ((TroopFileTransferManager.Item)localObject).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
      ((TroopFileTransferManager.Item)localObject).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
      paramDownloadFileRspBody = agrn.c(((TroopFileTransferManager.Item)localObject).DownloadIp, ((TroopFileTransferManager.Item)localObject).DownloadUrl, ((TroopFileTransferManager.Item)localObject).FilePath, ((TroopFileTransferManager.Item)localObject).cookieValue, "");
      if (!TextUtils.isEmpty(paramDownloadFileRspBody))
      {
        this.a.fO(paramDownloadFileRspBody, ((TroopFileTransferManager.Item)localObject).cookieValue);
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + paramDownloadFileRspBody + "], cookies [" + ((TroopFileTransferManager.Item)localObject).cookieValue + "]");
        }
        if (this.this$0.c.b() != null)
        {
          paramDownloadFileRspBody = String.valueOf(this.this$0.c.b().TroopUin);
          if (this.this$0.c.b() == null) {
            break label525;
          }
        }
        for (paramBundle = ahav.el(this.this$0.c.b().nFileType);; paramBundle = "unknow")
        {
          anot.a(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramDownloadFileRspBody, "", paramBundle, "1");
          return;
          paramDownloadFileRspBody = "";
          break;
        }
      }
      this.a.djD();
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + paramDownloadFileRspBody + "], cookies [" + ((TroopFileTransferManager.Item)localObject).cookieValue + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvd
 * JD-Core Version:    0.7.0.1
 */