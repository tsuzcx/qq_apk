import android.os.Bundle;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.4.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class apex
  extends smq.h
{
  apex(apew paramapew, TroopFileTransferManager.Item paramItem, QQAppInterface paramQQAppInterface, long paramLong, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if (paramFileInfo != null)
    {
      this.b.Md5 = paramFileInfo.bytes_md5.get().toByteArray();
      String str1 = agoy.t(this.b.Md5);
      this.b.Sha = paramFileInfo.bytes_sha.get().toByteArray();
      String str2 = agoy.t(this.b.Sha);
      this.b.Sha3 = agoy.t(paramFileInfo.bytes_sha3.get().toByteArray());
      if (QLog.isColorLevel()) {
        QLog.i("CHECK_FILE_EXISTED", 1, "troop findFile md5[" + str1 + "], sha3[" + this.b.Sha3 + "], sha[" + str2 + "]");
      }
      paramFileInfo = this.val$app.a().d(this.b.FileName, this.b.ProgressTotal).iterator();
      while (paramFileInfo.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramFileInfo.next();
        if (QLog.isColorLevel()) {
          QLog.i("CHECK_FILE_EXISTED", 1, "troop findFile md5[" + localFileManagerEntity.str10Md5 + "], sha3[" + localFileManagerEntity.strFileSha3 + "], md5[" + localFileManagerEntity.strFileMd5 + "]");
        }
        if (((localFileManagerEntity.strFileMd5 != null) && (localFileManagerEntity.strFileMd5.equals(str1))) || ((localFileManagerEntity.strFileMd5 != null) && (localFileManagerEntity.strFileMd5.equals(str1))) || ((localFileManagerEntity.str10Md5 != null) && (localFileManagerEntity.str10Md5.equals(str1))) || ((localFileManagerEntity.strFileSha3 != null) && (localFileManagerEntity.strFileSha3.equals(this.b.Sha3))) || ((localFileManagerEntity.strFileSHA != null) && (localFileManagerEntity.strFileSHA.equals(str2))) || ((localFileManagerEntity.strTroopFileSha1 != null) && (localFileManagerEntity.strTroopFileSha1.equals(str2))))
        {
          long l = new VFSFile(localFileManagerEntity.getFilePath()).lastModified();
          if (localFileManagerEntity.localModifyTime != l)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, bug file is modified,item.localModifyTime[" + localFileManagerEntity.localModifyTime + "], lastModified[" + l + "]");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, set file download sucessed!");
            }
            this.b.LocalFile = localFileManagerEntity.getFilePath();
            if ((!aqhq.fileExistsAndNotEmpty(this.b.middleThumbnailFile)) && (aqhq.fileExistsAndNotEmpty(localFileManagerEntity.strMiddleThumPath))) {
              this.b.middleThumbnailFile = localFileManagerEntity.strMiddleThumPath;
            }
            if ((!aqhq.fileExistsAndNotEmpty(this.b.largeThumbnailFile)) && (aqhq.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath))) {
              this.b.largeThumbnailFile = localFileManagerEntity.strLargeThumPath;
            }
            apdw.a(this.Hg, this.b, 11);
            this.this$0.a(this.b.getInfo(this.Hg), str1, str2, this.b.Sha3);
            return;
          }
        }
      }
    }
    paramFileInfo = (QQAppInterface)this.n.get();
    if ((paramFileInfo != null) && (ahav.getFileType(this.b.FileName) == 2) && (ahbr.aM(paramFileInfo)))
    {
      agkw.a(new agtf(paramFileInfo, this.b.getInfo(this.Hg))).ZE();
      return;
    }
    apdz.b(new TroopFileDownloadMgr.4.1(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apex
 * JD-Core Version:    0.7.0.1
 */