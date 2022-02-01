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

class auax
  extends smq.m
{
  auax(auau paramauau, atzy.b paramb) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (this.a == null) {}
    Object localObject;
    label646:
    do
    {
      do
      {
        do
        {
          return;
          if (paramDownloadFileRspBody == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("TroopFileModel", 4, "error DownloadFileRspBody is null!!!!!");
            }
            this.a.djD();
            return;
          }
          long l = paramBundle.getLong("troopUin");
          TroopFileTransferManager localTroopFileTransferManager;
          try
          {
            localTroopFileTransferManager = TroopFileTransferManager.a(l);
            if (localTroopFileTransferManager == null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("TroopFileModel", 4, "bad troopUin" + l);
              }
              this.a.djD();
              return;
            }
          }
          finally {}
          paramBundle = paramBundle.getString("itemKey");
          if (paramBundle == null)
          {
            this.a.djD();
            return;
          }
          localObject = UUID.fromString(paramBundle);
          try
          {
            localObject = localTroopFileTransferManager.a((UUID)localObject);
            if (localObject == null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("TroopFileModel", 4, "bad item key" + paramBundle);
              }
              this.a.djD();
              return;
            }
          }
          finally {}
          paramInt = paramDownloadFileRspBody.int32_ret_code.get();
          if (QLog.isDevelopLevel()) {
            QLog.e("TroopFileModel", 4, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(paramInt) }));
          }
          ((TroopFileTransferManager.Item)localObject).cookieValue = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
          if (((TroopFileTransferManager.Item)localObject).cookieValue != null) {
            ((TroopFileTransferManager.Item)localObject).cookieValue = ((TroopFileTransferManager.Item)localObject).cookieValue.toLowerCase();
          }
          ((TroopFileTransferManager.Item)localObject).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
          ((TroopFileTransferManager.Item)localObject).DownloadUrl = aqhs.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
          ((TroopFileTransferManager.Item)localObject).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
          ((TroopFileTransferManager.Item)localObject).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
          if ((paramInt != -133) && (paramInt != -132) && (paramInt != -134)) {
            break;
          }
          this.a.djD();
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopFileModel", 4, "file invalidate retCode = " + paramInt);
        return;
        if ((paramInt != -103) && (paramInt != -301)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("TroopFileModel", 4, "file invalidate retCode = " + paramInt);
      return;
      paramDownloadFileRspBody = atye.c(((TroopFileTransferManager.Item)localObject).DownloadIp, ((TroopFileTransferManager.Item)localObject).DownloadUrl, ((TroopFileTransferManager.Item)localObject).FilePath, ((TroopFileTransferManager.Item)localObject).cookieValue, "");
      if (!TextUtils.isEmpty(paramDownloadFileRspBody))
      {
        this.a.fO(paramDownloadFileRspBody, ((TroopFileTransferManager.Item)localObject).cookieValue);
        if (QLog.isColorLevel()) {
          QLog.e("zivonchen", 2, "url = " + paramDownloadFileRspBody + ", cookies = " + ((TroopFileTransferManager.Item)localObject).cookieValue);
        }
        if (this.this$0.c.b() != null)
        {
          paramDownloadFileRspBody = String.valueOf(this.this$0.c.b().TroopUin);
          if (this.this$0.c.b() == null) {
            break label646;
          }
        }
        for (paramBundle = audx.el(this.this$0.c.b().nFileType);; paramBundle = "unknow")
        {
          anot.a(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramDownloadFileRspBody, "", paramBundle, "1");
          return;
          paramDownloadFileRspBody = "";
          break;
        }
      }
      this.a.djD();
    } while (!QLog.isColorLevel());
    QLog.e("zivonchen", 2, "url = " + paramDownloadFileRspBody + ", cookies = " + ((TroopFileTransferManager.Item)localObject).cookieValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auax
 * JD-Core Version:    0.7.0.1
 */