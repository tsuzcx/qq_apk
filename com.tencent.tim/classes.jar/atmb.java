import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class atmb
  extends atgg
{
  public atmb(CloudUploadingListActivity paramCloudUploadingListActivity) {}
  
  public void c(List<FileManagerEntity> paramList, int paramInt, String paramString)
  {
    super.c(paramList, paramInt, paramString);
    QLog.w("CloudUploadingListActivity", 1, "onFetchUploadList end at " + System.currentTimeMillis());
    if (paramInt != 0) {
      QLog.w("CloudUploadingListActivity", 1, "onFetchUploadList return " + paramInt);
    }
    do
    {
      return;
      QLog.d("CloudUploadingListActivity", 1, "onFetchUploadList return entities " + paramList.size());
      CloudUploadingListActivity.a(this.this$0).clear();
      paramList = paramList.iterator();
      paramInt = 0;
      while (paramList.hasNext())
      {
        paramString = (FileManagerEntity)paramList.next();
        if (paramString.uploadFile.uploadType != 0)
        {
          QLog.d("CloudUploadingListActivity", 1, "onFetchUploadList entity upload type " + paramString.uploadFile.uploadType);
        }
        else
        {
          int i;
          if (paramString.uploadFile.uploadStatus != 1)
          {
            i = paramInt;
            if (paramString.uploadFile.uploadStatus != 0) {}
          }
          else
          {
            i = paramInt + 1;
          }
          CloudUploadingListActivity.a(this.this$0).put(Long.valueOf(paramString.uploadFile.taskId), new atmh.a(paramString));
          paramInt = i;
        }
      }
      CloudUploadingListActivity.a(this.this$0);
    } while (paramInt != 0);
    this.this$0.eua();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmb
 * JD-Core Version:    0.7.0.1
 */