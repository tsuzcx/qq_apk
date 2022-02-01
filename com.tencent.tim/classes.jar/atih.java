import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class atih
  extends atgg
{
  atih(atie paramatie) {}
  
  public void c(List<FileManagerEntity> paramList, int paramInt, String paramString)
  {
    super.c(paramList, paramInt, paramString);
    if (paramInt != 0)
    {
      QLog.w("CloudFileAdapter", 1, "onFetchUploadList return " + paramInt);
      return;
    }
    QLog.d("CloudFileAdapter", 1, "onFetchUploadList return entities " + paramList.size());
    atie.a(this.this$0).clear();
    long l1 = 0L;
    long l2 = 0L;
    atie.b(this.this$0, 0);
    atie.c(this.this$0, 0);
    atie.d(this.this$0, 0);
    paramString = null;
    Iterator localIterator = paramList.iterator();
    paramList = paramString;
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (localFileManagerEntity.uploadFile.uploadType != 0)
      {
        QLog.d("CloudFileAdapter", 1, "onFetchUploadList entity upload type " + localFileManagerEntity.uploadFile.uploadType);
      }
      else
      {
        atie.d(this.this$0);
        if (localFileManagerEntity.uploadFile.uploadStatus == 4)
        {
          atie.f(this.this$0);
          l1 += localFileManagerEntity.fileSize;
        }
        for (;;)
        {
          atie.a(this.this$0).put(Long.valueOf(localFileManagerEntity.uploadFile.taskId), localFileManagerEntity.uploadFile);
          paramString = paramList;
          if (localFileManagerEntity.uploadFile.uploadPath != null)
          {
            paramString = paramList;
            if (localFileManagerEntity.uploadFile.uploadPath.length() > 0) {
              paramString = localFileManagerEntity.uploadFile.uploadPath;
            }
          }
          l2 += localFileManagerEntity.fileSize;
          paramList = paramString;
          break;
          if ((localFileManagerEntity.uploadFile.uploadStatus == 1) || (localFileManagerEntity.uploadFile.uploadStatus == 0))
          {
            atie.e(this.this$0);
            l1 += localFileManagerEntity.uploadFile.progressSize;
          }
          else if (localFileManagerEntity.uploadFile.uploadStatus == 3)
          {
            l1 += localFileManagerEntity.fileSize;
          }
          else
          {
            QLog.e("CloudFileAdapter", 1, "onFetchUploadList task status[" + localFileManagerEntity.uploadFile.uploadStatus + "] not processed");
          }
        }
      }
    }
    if (l2 != 0L) {}
    for (l1 = l1 * 100L / l2;; l1 = 0L)
    {
      atie.a(this.this$0, paramList);
      atie.a(this.this$0, (int)l1);
      atie.b(this.this$0);
      atie.a(this.this$0, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atih
 * JD-Core Version:    0.7.0.1
 */