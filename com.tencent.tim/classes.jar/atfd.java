import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atfd
  extends CloudFileCallback
{
  atfd(atfb paramatfb, String paramString1, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString2) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    super.onGetCloudItemCallBack(paramCloudBase);
    if ((paramCloudBase != null) && ((paramCloudBase instanceof CloudFile)))
    {
      paramCloudBase = (CloudFile)paramCloudBase;
      paramCloudBase = this.a.this$0.app.a().a(paramCloudBase.cloudId);
      if (paramCloudBase != null)
      {
        if (paramCloudBase.cloudFile != null)
        {
          paramCloudBase.cloudFile.finalPath = this.val$path;
          paramCloudBase.cloudFile.downloadStatus = 5;
        }
        paramCloudBase.strFilePath = this.val$path;
        paramCloudBase.status = 1;
        atgi.a().a(paramCloudBase, this.val$path, true);
        paramCloudBase = this.a.this$0;
        if (this.val$errCode != 0) {
          break label164;
        }
      }
    }
    label164:
    for (boolean bool = true;; bool = false)
    {
      paramCloudBase.notifyUI(24, bool, new Object[] { this.hE, this.hG, this.val$path, Integer.valueOf(this.val$errCode), this.val$errMsg });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfd
 * JD-Core Version:    0.7.0.1
 */