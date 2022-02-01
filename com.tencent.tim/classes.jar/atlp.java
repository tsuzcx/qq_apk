import android.os.Handler;
import android.os.Looper;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusController.1.1;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusController.1.2;
import java.util.HashMap;

public class atlp
  extends CloudFileCallbackCenter
{
  atlp(atlo paramatlo) {}
  
  public void onDeleteUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    super.onDeleteUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
    if (paramInt1 != 0) {}
    do
    {
      return;
      if (paramInt2 != 0)
      {
        QLog.w("CloudFileUploadingStatusController", 1, "onDeleteUpload return " + paramInt2);
        paramArrayOfByte = atgi.a().getErrorMsgOf(paramInt2);
        QQToast.a(atlo.a(this.c), 1, paramArrayOfByte, 3000).show();
        return;
      }
      QLog.d("CloudFileUploadingStatusController", 1, "onDeleteUpload taskId[" + paramLong + "]");
      paramArrayOfByte = (FileManagerEntity)atlo.a(this.c).get(Long.valueOf(paramLong));
    } while (paramArrayOfByte == null);
    atlo.h(this.c);
    if ((paramArrayOfByte.uploadFile.uploadStatus == 1) || (paramArrayOfByte.uploadFile.uploadStatus == 0)) {
      atlo.a(this.c);
    }
    for (;;)
    {
      atlo.a(this.c).remove(Long.valueOf(paramLong));
      QLog.d("CloudFileUploadingStatusController", 1, "onDeleteUpload TotalCount[" + atlo.e(this.c) + "] FailCount[" + atlo.f(this.c) + "] UploadingCount[" + atlo.g(this.c));
      if (atlo.a(this.c) != null) {
        break;
      }
      atlo.a(this.c, new CloudFileUploadingStatusController.1.1(this));
      new Handler(Looper.getMainLooper()).postDelayed(atlo.a(this.c), 500L);
      return;
      if (paramArrayOfByte.uploadFile.uploadStatus == 4) {
        atlo.b(this.c);
      }
    }
  }
  
  public void onStartUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    super.onStartUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile);
    if (paramInt1 != 0) {
      return;
    }
    if (paramInt2 != 0) {
      QLog.w("CloudFileUploadingStatusController", 1, "onStartUpload taskId[" + paramLong + "] return " + paramInt2);
    }
    while (paramInt2 == -107)
    {
      QLog.w("CloudFileUploadingStatusController", 1, "onStartUpload taskId[" + paramLong + "] return " + paramInt2);
      return;
      QLog.d("CloudFileUploadingStatusController", 1, "onStartUpload taskId[" + paramLong + "] uploadFile.uploadStatus " + paramCloudUploadFile.uploadStatus);
    }
    paramArrayOfByte = (FileManagerEntity)atlo.a(this.c).get(Long.valueOf(paramLong));
    if (paramArrayOfByte == null)
    {
      QLog.d("CloudFileUploadingStatusController", 1, "onStartUpload taskId[" + paramLong + "] can not find task in fetchlist, so check fetch again");
      atlo.a(this.c);
      return;
    }
    if ((paramArrayOfByte.uploadFile.uploadStatus == 1) || (paramArrayOfByte.uploadFile.uploadStatus == 0))
    {
      atlo.a(this.c);
      if (paramInt2 == 0) {
        break label470;
      }
      paramCloudUploadFile = new CloudUploadFile();
      paramCloudUploadFile.fileInfo = paramArrayOfByte.uploadFile.fileInfo;
      paramCloudUploadFile.taskId = paramArrayOfByte.uploadFile.taskId;
      paramCloudUploadFile.uploadStatus = 4;
      paramCloudUploadFile.uploadType = paramArrayOfByte.uploadFile.uploadType;
      paramCloudUploadFile.uploadPath = paramArrayOfByte.uploadFile.uploadPath;
      paramCloudUploadFile.fileInfo = paramArrayOfByte.uploadFile.fileInfo;
      paramCloudUploadFile.progressSize = paramArrayOfByte.uploadFile.progressSize;
      paramCloudUploadFile.result = paramArrayOfByte.uploadFile.result;
      paramCloudUploadFile.resultMsg = paramArrayOfByte.uploadFile.resultMsg;
      atlo.c(this.c);
    }
    for (;;)
    {
      paramArrayOfByte = athu.a(paramCloudUploadFile);
      atlo.a(this.c).put(Long.valueOf(paramLong), paramArrayOfByte);
      QLog.d("CloudFileUploadingStatusController", 1, "onStartUpload TotalCount[" + atlo.e(this.c) + "] FailCount[" + atlo.f(this.c) + "] UploadingCount[" + atlo.g(this.c));
      atlo.b(this.c);
      return;
      if (paramArrayOfByte.uploadFile.uploadStatus != 4) {
        break;
      }
      atlo.b(this.c);
      break;
      label470:
      atlo.d(this.c);
    }
  }
  
  public void onStopUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    super.onStopUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
    if (paramInt1 != 0) {
      return;
    }
    if (paramInt2 != 0) {
      QLog.w("CloudFileUploadingStatusController", 1, "onStopUpload taskId[" + paramLong + "] return " + paramInt2);
    }
    for (;;)
    {
      paramArrayOfByte = (FileManagerEntity)atlo.a(this.c).get(Long.valueOf(paramLong));
      if (paramArrayOfByte != null) {
        break;
      }
      QLog.w("CloudFileUploadingStatusController", 1, "onStopUpload taskId[" + paramLong + "] but task is no exist");
      return;
      QLog.d("CloudFileUploadingStatusController", 1, "onStopUpload taskId[" + paramLong + "]");
    }
    QLog.d("CloudFileUploadingStatusController", 1, "onStopUpload taskId[" + paramLong + "] entity.uploadFile.uploadStatus " + paramArrayOfByte.uploadFile.uploadStatus);
    if ((paramArrayOfByte.uploadFile.uploadStatus == 1) || (paramArrayOfByte.uploadFile.uploadStatus == 0))
    {
      atlo.a(this.c);
      label213:
      paramString = new CloudUploadFile();
      paramString.fileInfo = paramArrayOfByte.uploadFile.fileInfo;
      paramString.taskId = paramArrayOfByte.uploadFile.taskId;
      paramString.uploadStatus = paramArrayOfByte.uploadFile.uploadStatus;
      paramString.uploadType = paramArrayOfByte.uploadFile.uploadType;
      paramString.uploadPath = paramArrayOfByte.uploadFile.uploadPath;
      paramString.fileInfo = paramArrayOfByte.uploadFile.fileInfo;
      paramString.progressSize = paramArrayOfByte.uploadFile.progressSize;
      paramString.result = paramArrayOfByte.uploadFile.result;
      paramString.resultMsg = paramArrayOfByte.uploadFile.resultMsg;
      if ((paramInt2 != 3) && (paramInt2 != 0)) {
        break label503;
      }
      paramString.uploadStatus = 3;
    }
    for (;;)
    {
      paramArrayOfByte = athu.a(paramString);
      atlo.a(this.c).put(Long.valueOf(paramLong), paramArrayOfByte);
      QLog.d("CloudFileUploadingStatusController", 1, "onStopUpload TotalCount[" + atlo.e(this.c) + "] FailCount[" + atlo.f(this.c) + "] UploadingCount[" + atlo.g(this.c));
      if (atlo.a(this.c) != null) {
        break;
      }
      atlo.a(this.c, new CloudFileUploadingStatusController.1.2(this));
      new Handler(Looper.getMainLooper()).postDelayed(atlo.a(this.c), 500L);
      return;
      if (paramArrayOfByte.uploadFile.uploadStatus != 4) {
        break label213;
      }
      atlo.b(this.c);
      break label213;
      label503:
      atlo.c(this.c);
      paramString.uploadStatus = 4;
      paramString.resultMsg = atgi.a().getErrorMsgOf(paramInt2);
    }
  }
  
  public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    super.onUploadComplete(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile);
    if (paramInt1 != 0) {
      return;
    }
    if (paramInt2 != 0) {
      QLog.w("CloudFileUploadingStatusController", 1, "onUploadComplete taskId[" + paramLong + "] return " + paramInt2);
    }
    for (;;)
    {
      paramArrayOfByte = (FileManagerEntity)atlo.a(this.c).get(Long.valueOf(paramLong));
      if (paramArrayOfByte != null) {
        break;
      }
      QLog.w("CloudFileUploadingStatusController", 1, "onUploadComplete taskId[" + paramLong + "] but task is no exist");
      return;
      QLog.d("CloudFileUploadingStatusController", 1, "onUploadComplete taskId[" + paramLong + "] uploadFile.uploadStatus " + paramCloudUploadFile.uploadStatus);
    }
    if ((paramArrayOfByte.uploadFile.uploadStatus == 1) || (paramArrayOfByte.uploadFile.uploadStatus == 0)) {
      atlo.a(this.c);
    }
    while (paramInt2 == 0)
    {
      atlo.h(this.c);
      atlo.a(this.c).remove(Long.valueOf(paramLong));
      if (atlo.e(this.c) == 0) {
        CloudFileUploadingStatusBar.setNeedShowCompletedState();
      }
      QLog.d("CloudFileUploadingStatusController", 1, "onUploadComplete TotalCount[" + atlo.e(this.c) + "] FailCount[" + atlo.f(this.c) + "] UploadingCount[" + atlo.g(this.c));
      atlo.b(this.c);
      return;
      if (paramArrayOfByte.uploadFile.uploadStatus == 4) {
        atlo.b(this.c);
      }
    }
    if (paramCloudUploadFile == null)
    {
      paramCloudUploadFile = new CloudUploadFile();
      paramCloudUploadFile.fileInfo = paramArrayOfByte.uploadFile.fileInfo;
      paramCloudUploadFile.taskId = paramArrayOfByte.uploadFile.taskId;
      paramCloudUploadFile.uploadStatus = 4;
      paramCloudUploadFile.uploadType = paramArrayOfByte.uploadFile.uploadType;
      paramCloudUploadFile.uploadPath = paramArrayOfByte.uploadFile.uploadPath;
      paramCloudUploadFile.fileInfo = paramArrayOfByte.uploadFile.fileInfo;
      paramCloudUploadFile.progressSize = paramArrayOfByte.uploadFile.progressSize;
      paramCloudUploadFile.result = paramArrayOfByte.uploadFile.result;
      paramCloudUploadFile.resultMsg = paramArrayOfByte.uploadFile.resultMsg;
    }
    for (;;)
    {
      paramArrayOfByte = athu.a(paramCloudUploadFile);
      atlo.a(this.c).put(Long.valueOf(paramLong), paramArrayOfByte);
      if (paramInt2 == 3) {
        break;
      }
      atlo.c(this.c);
      break;
      QLog.e("CloudFileUploadingStatusController", 1, "onUploadComplete taskId[" + paramLong + "] uploadFile.uploadStatus " + paramCloudUploadFile.uploadStatus);
    }
  }
  
  public void onUploadProgress(byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void onUploadTotalProgress(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = 0L;
    super.onUploadTotalProgress(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
    if (paramLong1 == paramLong2)
    {
      QLog.w("CloudFileUploadingStatusController", 1, "onUploadTotalProgress Progress[" + paramLong1 + "] == ProgressMax[" + paramLong2 + "]");
      return;
    }
    if (paramLong2 == 0L) {}
    for (;;)
    {
      QLog.d("CloudFileUploadingStatusController", 1, "onUploadTotalProgress Progress[" + paramLong1 + "], ProgressMax[" + paramLong2 + "], Speed[" + paramLong3 + "]");
      atlo.a(this.c).setProgress((int)l);
      atlo.a(this.c).setSpeed(paramLong3);
      return;
      l = 100L * paramLong1 / paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlp
 * JD-Core Version:    0.7.0.1
 */