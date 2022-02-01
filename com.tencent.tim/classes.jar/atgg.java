import com.tencent.cloudfile.BatchCheckResult;
import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudDir;
import com.tencent.cloudfile.CloudFeed;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.cloudfile.CloudUserInfo;
import com.tencent.cloudfile.GridThumResult;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileSDKCallback.1;
import com.tencent.tim.cloudfile.CloudFileSDKCallback.2;
import com.tencent.tim.cloudfile.CloudFileSDKCallback.3;
import com.tencent.tim.cloudfile.CloudFileSDKCallback.4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class atgg
  extends CloudFileCallback
{
  public void a(atin paramatin, int paramInt, String paramString) {}
  
  public void a(CloudUserInfo paramCloudUserInfo, int paramInt, String paramString) {}
  
  public void a(List<Object> paramList, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt, String paramString) {}
  
  public void a(byte[] paramArrayOfByte, List<Object> paramList, boolean paramBoolean, String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, List<GridThumResult> paramList) {}
  
  public void b(List<FileManagerEntity> paramList, int paramInt, String paramString) {}
  
  public void b(List<Object> paramList, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void c(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {}
  
  public void c(List<FileManagerEntity> paramList, int paramInt, String paramString) {}
  
  public void ek(int paramInt, String paramString) {}
  
  public void el(int paramInt, String paramString) {}
  
  public void em(int paramInt, String paramString) {}
  
  public void en(int paramInt, String paramString) {}
  
  public void f(int paramInt, String paramString, List<BatchResult> paramList) {}
  
  public void g(int paramInt, String paramString, List<BatchResult> paramList) {}
  
  public void nF(List<BatchCheckResult> paramList) {}
  
  public final void onAirCopyToOtherBizCallBack(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    a(paramArrayOfByte, paramInt, paramString);
  }
  
  public void onBatchCheckExistInRecentFolderCallback(List<BatchCheckResult> paramList)
  {
    nF(paramList);
  }
  
  public final void onCancelSearchCallback(int paramInt, String paramString)
  {
    en(paramInt, paramString);
  }
  
  public void onCheckExistInRecentFolderCallback(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    a(paramBoolean, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
  }
  
  public void onCopyTMCFileCallBack(int paramInt, String paramString, CloudFile paramCloudFile)
  {
    em(paramInt, paramString);
  }
  
  public final void onCreateFolderCallback(CloudDir paramCloudDir, int paramInt, String paramString)
  {
    a(athu.a(paramCloudDir), paramInt, paramString);
  }
  
  public final void onDeleteFolderCallBack(int paramInt, String paramString, List<BatchResult> paramList)
  {
    f(paramInt, paramString, paramList);
  }
  
  public final void onFetchDirFileListCallback(byte[] paramArrayOfByte, List<CloudBase> paramList, boolean paramBoolean, String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CloudBase localCloudBase = (CloudBase)paramList.next();
        if (localCloudBase.type == 2) {
          localArrayList.add(athu.a((CloudFile)localCloudBase));
        } else if (localCloudBase.type == 1) {
          localArrayList.add(athu.a((CloudDir)localCloudBase));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileSDKCallback", 2, new Object[] { "onFetchDirFileListCallback|size=", Integer.valueOf(localArrayList.size()), ", errCode=", Integer.valueOf(paramInt2), ", errMsg=", paramString2 });
    }
    ThreadManager.post(new CloudFileSDKCallback.1(this, localArrayList), 8, null, true);
    a(paramArrayOfByte, localArrayList, paramBoolean, paramString1, paramLong1, paramLong2, paramInt1, paramInt2, paramString2);
  }
  
  public final void onFetchDownloadListCallback(List<CloudFile> paramList, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(athu.a((CloudFile)paramList.next()));
      }
    }
    ThreadManager.post(new CloudFileSDKCallback.4(this, localArrayList), 8, null, true);
    b(localArrayList, paramInt, paramString);
  }
  
  public final void onFetchFeedsListCallback(List<CloudFeed> paramList, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CloudFeed localCloudFeed = (CloudFeed)paramList.next();
        if (localCloudFeed.feedType == 2) {
          localArrayList.add(athu.a(localCloudFeed.fileInfo));
        } else if (localCloudFeed.feedType == 1) {
          localArrayList.add(athu.a(localCloudFeed.dirInfo));
        } else if (localCloudFeed.feedType == 3) {
          localArrayList.add(athu.a(localCloudFeed));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileSDKCallback", 2, new Object[] { "onFetchFeedsListCallback|size=", Integer.valueOf(localArrayList.size()), ", errCode=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    }
    ThreadManager.post(new CloudFileSDKCallback.2(this, localArrayList), 8, null, true);
    a(localArrayList, paramBoolean, paramLong1, paramLong2, paramInt, paramString);
  }
  
  public final void onFetchGridThumListCallback(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, List<GridThumResult> paramList)
  {
    a(paramArrayOfByte, paramBoolean1, paramBoolean2, paramList);
  }
  
  public final void onFetchUploadListCallback(List<CloudUploadFile> paramList, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(athu.a((CloudUploadFile)paramList.next()));
      }
    }
    c(localArrayList, paramInt, paramString);
  }
  
  public final void onFetchUserInfoCallback(CloudUserInfo paramCloudUserInfo, int paramInt, String paramString)
  {
    a(paramCloudUserInfo, paramInt, paramString);
  }
  
  public void onGetDownloadUrlCallBack(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    c(paramString1, paramString2, paramString3, paramInt, paramString4);
  }
  
  public final void onMoveFolderCallBack(int paramInt, String paramString, List<BatchResult> paramList)
  {
    g(paramInt, paramString, paramList);
  }
  
  public final void onRenameFileCallback(int paramInt, String paramString)
  {
    el(paramInt, paramString);
  }
  
  public final void onRenameFolderCallback(int paramInt, String paramString)
  {
    ek(paramInt, paramString);
  }
  
  public final void onSearchListCallback(List<CloudBase> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CloudBase localCloudBase = (CloudBase)paramList.next();
        if (localCloudBase.type == 2) {
          localArrayList.add(athu.a((CloudFile)localCloudBase));
        } else if (localCloudBase.type == 1) {
          localArrayList.add(athu.a((CloudDir)localCloudBase));
        }
      }
      ThreadManager.post(new CloudFileSDKCallback.3(this, localArrayList), 8, null, true);
      b(localArrayList, paramBoolean, paramInt, paramString);
      return;
    }
    b(null, paramBoolean, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgg
 * JD-Core Version:    0.7.0.1
 */