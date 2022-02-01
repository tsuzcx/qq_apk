import android.app.Activity;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.5.1.1.1;

public class auaq
  extends atgg
{
  auaq(auap paramauap, FileManagerEntity paramFileManagerEntity) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TIMCloudFileModel", 2, "start download cloud file, peerType:" + this.g.peerType + " uuid:" + this.g.Uuid + "name:" + this.g.fileName + "isExist:" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.g.nOpType = -1;
      atgi.a().startDownloadFile(this.g.cloudFile.pLogicDirKey, this.g.cloudFile.cloudId, acbn.bmg + this.g.fileName);
      return;
    }
    this.a.a.this$0.mContext.runOnUiThread(new TIMCloudFileModel.5.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auaq
 * JD-Core Version:    0.7.0.1
 */