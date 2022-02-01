import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import java.util.HashMap;

class atif
  extends CloudFileCallbackCenter
{
  atif(atie paramatie) {}
  
  public void onDeleteUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    super.onDeleteUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
    if (paramInt1 != 0) {
      return;
    }
    if (paramInt2 != 0)
    {
      QLog.w("CloudFileAdapter", 1, "onDeleteUpload return " + paramInt2);
      paramArrayOfByte = atgi.a().getErrorMsgOf(paramInt2);
      QQToast.a(this.this$0.mContext, 1, paramArrayOfByte, 3000).show();
      return;
    }
    QLog.d("CloudFileAdapter", 1, "onDeleteUpload taskId[" + paramLong + "]");
    paramArrayOfByte = (CloudUploadFile)atie.a(this.this$0).get(Long.valueOf(paramLong));
    if (paramArrayOfByte != null)
    {
      atie.a(this.this$0);
      if ((paramArrayOfByte.uploadStatus != 1) && (paramArrayOfByte.uploadStatus != 0)) {
        break label169;
      }
      atie.b(this.this$0);
    }
    for (;;)
    {
      atie.b(this.this$0);
      return;
      label169:
      if (paramArrayOfByte.uploadStatus == 4) {
        atie.c(this.this$0);
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
      QLog.w("CloudFileAdapter", 1, "onStartUpload taskId[" + paramLong + "] return " + paramInt2);
    }
    for (;;)
    {
      paramArrayOfByte = (CloudUploadFile)atie.a(this.this$0).get(Long.valueOf(paramLong));
      if (paramArrayOfByte != null) {
        break;
      }
      QLog.d("CloudFileAdapter", 1, "onStartUpload taskId[" + paramLong + "] can not find task in fetchlist, so check fetch again");
      atie.a(this.this$0);
      return;
      QLog.d("CloudFileAdapter", 1, "onStartUpload taskId[" + paramLong + "]");
    }
    atie.a(this.this$0);
    if ((paramArrayOfByte.uploadStatus == 1) || (paramArrayOfByte.uploadStatus == 0))
    {
      atie.b(this.this$0);
      atie.a(this.this$0).put(Long.valueOf(paramLong), paramCloudUploadFile);
      atie.d(this.this$0);
      if ((paramCloudUploadFile.uploadStatus != 1) && (paramCloudUploadFile.uploadStatus != 0)) {
        break label304;
      }
      atie.e(this.this$0);
    }
    for (;;)
    {
      paramString = null;
      paramArrayOfByte = paramString;
      if (paramCloudUploadFile.uploadPath != null)
      {
        paramArrayOfByte = paramString;
        if (paramCloudUploadFile.uploadPath.length() > 0) {
          paramArrayOfByte = paramCloudUploadFile.uploadPath;
        }
      }
      atie.a(this.this$0, paramArrayOfByte);
      atie.b(this.this$0);
      return;
      if (paramArrayOfByte.uploadStatus != 4) {
        break;
      }
      atie.c(this.this$0);
      break;
      label304:
      if (paramCloudUploadFile.uploadStatus == 4) {
        atie.f(this.this$0);
      }
    }
  }
  
  public void onStopUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    super.onStopUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
    if (paramInt1 != 0) {
      return;
    }
    if (paramInt2 != 0) {
      QLog.w("CloudFileAdapter", 1, "onStopUpload taskId[" + paramLong + "] return " + paramInt2);
    }
    for (;;)
    {
      paramArrayOfByte = (CloudUploadFile)atie.a(this.this$0).get(Long.valueOf(paramLong));
      if (paramArrayOfByte != null) {
        break;
      }
      QLog.w("CloudFileAdapter", 1, "onStopUpload taskId[" + paramLong + "] but task is no exist");
      return;
      QLog.d("CloudFileAdapter", 1, "onStopUpload taskId[" + paramLong + "]");
    }
    if ((paramArrayOfByte.uploadStatus == 1) || (paramArrayOfByte.uploadStatus == 0))
    {
      atie.b(this.this$0);
      if ((paramInt2 != 3) && (paramInt2 != 0)) {
        break label241;
      }
      paramArrayOfByte.uploadStatus = 3;
      label183:
      if ((paramArrayOfByte.uploadPath == null) || (paramArrayOfByte.uploadPath.length() <= 0)) {
        break label269;
      }
    }
    label269:
    for (paramArrayOfByte = paramArrayOfByte.uploadPath;; paramArrayOfByte = null)
    {
      atie.a(this.this$0, paramArrayOfByte);
      atie.b(this.this$0);
      return;
      if (paramArrayOfByte.uploadStatus != 4) {
        break;
      }
      atie.c(this.this$0);
      break;
      label241:
      atie.f(this.this$0);
      paramArrayOfByte.uploadStatus = 4;
      paramArrayOfByte.resultMsg = atgi.a().getErrorMsgOf(paramInt2);
      break label183;
    }
  }
  
  public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    super.onUploadComplete(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile);
    if (paramInt1 != 0) {
      return;
    }
    if (paramInt2 != 0) {
      QLog.w("CloudFileAdapter", 1, "onUploadComplete taskId[" + paramLong + "] return " + paramInt2);
    }
    for (;;)
    {
      paramArrayOfByte = (CloudUploadFile)atie.a(this.this$0).get(Long.valueOf(paramLong));
      if (paramArrayOfByte != null) {
        break;
      }
      QLog.w("CloudFileAdapter", 1, "onUploadComplete taskId[" + paramLong + "] but task is no exist");
      return;
      QLog.d("CloudFileAdapter", 1, "onUploadComplete taskId[" + paramLong + "]");
    }
    if ((paramArrayOfByte.uploadStatus == 1) || (paramArrayOfByte.uploadStatus == 0))
    {
      atie.b(this.this$0);
      if (paramInt2 != 0) {
        break label280;
      }
      atie.a(this.this$0);
      atie.a(this.this$0).remove(Long.valueOf(paramLong));
    }
    for (;;)
    {
      if (atie.g(this.this$0) == 0) {
        CloudFileUploadingStatusBar.setNeedShowCompletedState();
      }
      paramString = null;
      paramArrayOfByte = paramString;
      if (paramCloudUploadFile.uploadPath != null)
      {
        paramArrayOfByte = paramString;
        if (paramCloudUploadFile.uploadPath.length() > 0) {
          paramArrayOfByte = paramCloudUploadFile.uploadPath;
        }
      }
      atie.a(this.this$0, paramArrayOfByte);
      atie.b(this.this$0);
      return;
      if (paramArrayOfByte.uploadStatus != 4) {
        break;
      }
      atie.c(this.this$0);
      break;
      label280:
      atie.a(this.this$0).put(Long.valueOf(paramLong), paramCloudUploadFile);
      if (paramInt2 != 3) {
        atie.f(this.this$0);
      }
    }
  }
  
  public void onUploadProgress(byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void onUploadTotalProgress(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    super.onUploadTotalProgress(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
    if (paramLong1 == paramLong2)
    {
      QLog.w("CloudFileAdapter", 1, "onUploadTotalProgress Progress[" + paramLong1 + "] == ProgressMax[" + paramLong2 + "]");
      return;
    }
    long l = 100L * paramLong1 / paramLong2;
    QLog.d("CloudFileAdapter", 1, "onUploadTotalProgress Progress[" + paramLong1 + "], ProgressMax[" + paramLong2 + "], Speed[" + paramLong3 + "]");
    atie.a(this.this$0, (int)l);
    atie.a(this.this$0, paramLong3);
    atie.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atif
 * JD-Core Version:    0.7.0.1
 */