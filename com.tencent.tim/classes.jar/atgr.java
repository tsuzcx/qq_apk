import android.text.TextUtils;
import com.tencent.cloudfile.BatchCheckResult;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.cloudfile.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileSendRecvActivity;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class atgr
  extends atgg
{
  public atgr(CloudFileSendRecvActivity paramCloudFileSendRecvActivity, List paramList1, List paramList2) {}
  
  public void onBatchCheckExistInRecentFolderCallback(List<BatchCheckResult> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BatchCheckResult localBatchCheckResult = (BatchCheckResult)paramList.next();
      if (!localBatchCheckResult.isExist)
      {
        Iterator localIterator = this.Ku.iterator();
        label271:
        label276:
        label281:
        label285:
        for (;;)
        {
          label46:
          Object localObject;
          int i;
          label158:
          int j;
          if (localIterator.hasNext())
          {
            localObject = (FileManagerEntity)localIterator.next();
            if ((((FileManagerEntity)localObject).cloudId == null) || (localBatchCheckResult.cloudId == null) || (!Arrays.equals(((FileManagerEntity)localObject).cloudId, localBatchCheckResult.cloudId))) {
              continue;
            }
            long l1 = ((FileManagerEntity)localObject).srvTime / 1000L;
            long l2 = ((FileManagerEntity)localObject).srvTime / 1000L;
            long l3 = NetConnInfoCenter.getServerTime();
            k = ((FileManagerEntity)localObject).peerType;
            if ((TextUtils.isEmpty(((FileManagerEntity)localObject).strFilePath)) || (!aueh.isFileExists(((FileManagerEntity)localObject).getFilePath()))) {
              break label271;
            }
            i = 1;
            if ((k != 3000) || (604800L + l1 >= l3)) {
              break label276;
            }
            j = 1;
            label180:
            if ((k == 3000) || (k == 1) || (2592000L + l2 >= l3)) {
              break label281;
            }
          }
          for (int k = 1;; k = 0)
          {
            if ((i == 0) || ((j == 0) && (k == 0))) {
              break label285;
            }
            localObject = athu.a(this.this$0.app, (FileManagerEntity)localObject, false);
            localObject = atgi.a().a((FileInfo)localObject);
            this.Kv.add(Long.valueOf(((FileManagerEntity)localObject).uploadFile.taskId));
            break label46;
            break;
            i = 0;
            break label158;
            j = 0;
            break label180;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SendRecvActivity", 2, "after checking " + this.Kv.size());
    }
    paramList = this.this$0;
    if (this.Kv.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      CloudFileSendRecvActivity.a(paramList, bool, this.Kv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgr
 * JD-Core Version:    0.7.0.1
 */