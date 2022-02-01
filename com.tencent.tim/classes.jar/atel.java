import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class atel
  extends atgg
{
  atel(ateh paramateh, byte[] paramArrayOfByte, List paramList, int paramInt, boolean paramBoolean) {}
  
  public void f(int paramInt, String paramString, List<BatchResult> paramList)
  {
    super.f(paramInt, paramString, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "deleteFileFolder pdirKey" + Arrays.toString(this.hE) + " errorCode:" + paramInt + "errorMsg:" + paramString);
    }
    Object localObject1 = (atgc)this.this$0.app.getManager(373);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BatchResult localBatchResult = (BatchResult)localIterator.next();
      if (Arrays.equals(localBatchResult.pDirKey, ((atgc)localObject1).aF()))
      {
        Object localObject2 = this.Kp.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          CloudBase localCloudBase = (CloudBase)((Iterator)localObject2).next();
          if (((localCloudBase instanceof CloudFile)) && (localBatchResult.errCode == 0) && (Arrays.equals(localBatchResult.cloudId, localCloudBase.cloudId)))
          {
            localObject2 = (CloudFile)localCloudBase;
            localObject2 = this.this$0.app.a().a(((CloudFile)localObject2).cloudId);
            if (localObject2 != null)
            {
              ((FileManagerEntity)localObject2).setCloudType(1);
              this.this$0.app.a().u((FileManagerEntity)localObject2);
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "deleteFileFolder dirKey" + Arrays.toString(localBatchResult.cloudId) + " errorCode:" + localBatchResult.errCode + "errorMsg:" + localBatchResult.errMsg);
      }
    }
    localObject1 = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ateh)localObject1).notifyUI(11, bool, new Object[] { this.hE, Integer.valueOf(this.epy), paramList, Integer.valueOf(paramInt), paramString, Boolean.valueOf(this.bER) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atel
 * JD-Core Version:    0.7.0.1
 */