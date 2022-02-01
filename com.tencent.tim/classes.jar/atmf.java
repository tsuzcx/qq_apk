import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.1;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.2;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.3;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.4;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity.6.5;
import mqq.os.MqqHandler;

public class atmf
  extends CloudFileCallbackCenter
{
  public atmf(CloudUploadingListActivity paramCloudUploadingListActivity) {}
  
  public void onDeleteUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    super.onDeleteUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("CloudUploadingListActivity", 2, paramLong + "onDeleteUpload  type" + paramInt1);
    }
    if (paramInt1 != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new CloudUploadingListActivity.6.3(this, paramInt2, paramLong));
  }
  
  public void onStartUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    super.onStartUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile);
    if (paramInt1 != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new CloudUploadingListActivity.6.1(this, paramLong, paramInt2));
  }
  
  public void onStopUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    super.onStopUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
    if (paramInt1 != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new CloudUploadingListActivity.6.2(this, paramLong, paramInt2));
  }
  
  public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CloudUploadingListActivity", 2, paramLong + "UploadComplete  errCode " + paramInt2);
    }
    if (paramInt1 != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new CloudUploadingListActivity.6.5(this, paramLong, paramInt2));
  }
  
  public void onUploadProgress(byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4)
  {
    super.onUploadProgress(paramArrayOfByte, paramLong1, paramInt, paramLong2, paramLong3, paramLong4);
    if (QLog.isColorLevel()) {
      QLog.i("CloudUploadingListActivity", 2, paramLong1 + "onUploadProgress " + paramLong3 + "/" + paramLong4 + "  speed" + paramLong2);
    }
    if (paramInt != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new CloudUploadingListActivity.6.4(this, paramLong1, paramLong3, paramLong2, paramLong4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmf
 * JD-Core Version:    0.7.0.1
 */