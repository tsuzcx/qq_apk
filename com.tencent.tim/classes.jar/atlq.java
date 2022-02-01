import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class atlq
  extends atgg
{
  atlq(atlo paramatlo) {}
  
  public void c(List<FileManagerEntity> paramList, int paramInt, String paramString)
  {
    super.c(paramList, paramInt, paramString);
    if (paramInt != 0)
    {
      QLog.w("CloudFileUploadingStatusController", 1, "onFetchUploadList return " + paramInt);
      return;
    }
    QLog.d("CloudFileUploadingStatusController", 1, "onFetchUploadList return entities " + paramList.size());
    atlo.a(this.c).clear();
    atlo.a(this.c, 0);
    atlo.b(this.c, 0);
    atlo.c(this.c, 0);
    paramList = paramList.iterator();
    long l2 = 0L;
    long l1 = 0L;
    while (paramList.hasNext())
    {
      paramString = (FileManagerEntity)paramList.next();
      if (paramString.uploadFile.uploadType != 0)
      {
        QLog.d("CloudFileUploadingStatusController", 1, "onFetchUploadList entity upload type " + paramString.uploadFile.uploadType);
      }
      else
      {
        atlo.i(this.c);
        QLog.e("CloudFileUploadingStatusController", 1, "onFetchUploadList task status[" + paramString.uploadFile.uploadStatus + "]");
        if (paramString.uploadFile.uploadStatus == 4)
        {
          atlo.c(this.c);
          l3 = l2;
        }
        for (;;)
        {
          atlo.a(this.c).put(Long.valueOf(paramString.uploadFile.taskId), paramString);
          l1 = paramString.fileSize + l1;
          l2 = l3;
          break;
          if ((paramString.uploadFile.uploadStatus == 1) || (paramString.uploadFile.uploadStatus == 0))
          {
            atlo.d(this.c);
            l3 = l2 + paramString.uploadFile.progressSize;
          }
          else
          {
            l3 = l2;
            if (paramString.uploadFile.uploadStatus != 3)
            {
              QLog.e("CloudFileUploadingStatusController", 1, "onFetchUploadList task status[" + paramString.uploadFile.uploadStatus + "] not processed");
              l3 = l2;
            }
          }
        }
      }
    }
    long l3 = 0L;
    if (l1 != 0L) {
      l3 = 100L * l2 / l1;
    }
    atlo.a(this.c).setProgress((int)l3);
    QLog.d("CloudFileUploadingStatusController", 1, "onFetchUploadList TotalCount[" + atlo.e(this.c) + "] FailCount[" + atlo.f(this.c) + "] UploadingCount[" + atlo.g(this.c));
    atlo.b(this.c);
    atlo.a(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlq
 * JD-Core Version:    0.7.0.1
 */