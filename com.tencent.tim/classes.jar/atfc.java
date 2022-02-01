import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atfc
  extends CloudFileCallback
{
  atfc(atfb paramatfb, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong3) {}
  
  public void onGetCloudItemCallBack(CloudBase paramCloudBase)
  {
    super.onGetCloudItemCallBack(paramCloudBase);
    if ((paramCloudBase != null) && ((paramCloudBase instanceof CloudFile)))
    {
      paramCloudBase = (CloudFile)paramCloudBase;
      paramCloudBase = this.a.this$0.app.a().a(paramCloudBase.cloudId);
      if (paramCloudBase != null)
      {
        paramCloudBase.setfProgress((float)this.axV / (float)this.axW);
        paramCloudBase.status = 2;
        this.a.this$0.notifyUI(23, true, new Object[] { this.hE, this.hG, Long.valueOf(this.axX), Long.valueOf(this.axV), Long.valueOf(this.axW) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfc
 * JD-Core Version:    0.7.0.1
 */