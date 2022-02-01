import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class atgh
  extends CloudFileCallbackCenter
{
  private List<CloudFileCallbackCenter> observers = new ArrayList();
  
  private CloudFileCallbackCenter[] a()
  {
    try
    {
      CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = new CloudFileCallbackCenter[this.observers.size()];
      this.observers.toArray(arrayOfCloudFileCallbackCenter);
      return arrayOfCloudFileCallbackCenter;
    }
    finally {}
  }
  
  public void a(CloudFileCallbackCenter paramCloudFileCallbackCenter)
  {
    if (paramCloudFileCallbackCenter != null) {
      try
      {
        if (!this.observers.contains(paramCloudFileCallbackCenter)) {
          this.observers.add(paramCloudFileCallbackCenter);
        }
        return;
      }
      finally {}
    }
  }
  
  public void b(CloudFileCallbackCenter paramCloudFileCallbackCenter)
  {
    try
    {
      this.observers.remove(paramCloudFileCallbackCenter);
      return;
    }
    finally
    {
      paramCloudFileCallbackCenter = finally;
      throw paramCloudFileCallbackCenter;
    }
  }
  
  public void onCreateUploadFileComplete(long paramLong, Map<String, String> paramMap)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onCreateUploadFileComplete(paramLong, paramMap);
        i += 1;
      }
    }
  }
  
  public void onDeleteUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onDeleteUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
        i += 1;
      }
    }
  }
  
  public void onDownloadComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onDownloadComplete(paramArrayOfByte1, paramArrayOfByte2, paramString1, paramInt, paramString2);
        i += 1;
      }
    }
  }
  
  public void onDownloadProgress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onDownloadProgress(paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, paramLong3);
        i += 1;
      }
    }
  }
  
  public void onFeedsUpdate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onFeedsUpdate(paramArrayOfByte1, paramArrayOfByte2, paramString1, paramInt, paramString2);
        i += 1;
      }
    }
  }
  
  public void onGetThumComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    aths.a().onGetThumComplete(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramString1, paramInt2, paramString2);
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onGetThumComplete(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramString1, paramInt2, paramString2);
        i += 1;
      }
    }
  }
  
  public void onGetUploadInfo(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onGetUploadInfo(paramLong, paramString1, paramString2, paramString3);
        i += 1;
      }
    }
  }
  
  public void onListUpdate(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onListUpdate(paramArrayOfByte, paramInt, paramString);
        i += 1;
      }
    }
  }
  
  public void onRecursiveRefreshFinished(int paramInt)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onRecursiveRefreshFinished(paramInt);
        i += 1;
      }
    }
  }
  
  public void onStartDownLoad(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onStartDownLoad(paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2);
        i += 1;
      }
    }
  }
  
  public void onStartTeamDownLoad(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onStartTeamDownLoad(paramString1, paramString2, paramLong1, paramLong2);
        i += 1;
      }
    }
  }
  
  public void onStartUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onStartUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile);
        i += 1;
      }
    }
  }
  
  public void onStopDownload(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onStopDownload(paramArrayOfByte1, paramArrayOfByte2, paramInt, paramString);
        i += 1;
      }
    }
  }
  
  public void onStopTeamDownload(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onStopTeamDownload(paramString1, paramString2, paramInt, paramString3);
        i += 1;
      }
    }
  }
  
  public void onStopUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onStopUpload(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString);
        i += 1;
      }
    }
  }
  
  public void onTeamDownloadComplete(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    super.onTeamDownloadComplete(paramString1, paramString2, paramString3, paramInt, paramString4);
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onTeamDownloadComplete(paramString1, paramString2, paramString3, paramInt, paramString4);
        i += 1;
      }
    }
  }
  
  public void onTeamDownloadProgress(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onTeamDownloadProgress(paramString1, paramString2, paramLong1, paramLong2, paramLong3);
        i += 1;
      }
    }
  }
  
  public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onUploadComplete(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile);
        i += 1;
      }
    }
  }
  
  public void onUploadProgress(byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onUploadProgress(paramArrayOfByte, paramLong1, paramInt, paramLong2, paramLong3, paramLong4);
        i += 1;
      }
    }
  }
  
  public void onUploadTotalProgress(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    CloudFileCallbackCenter[] arrayOfCloudFileCallbackCenter = a();
    if (arrayOfCloudFileCallbackCenter != null)
    {
      int j = arrayOfCloudFileCallbackCenter.length;
      int i = 0;
      while (i < j)
      {
        arrayOfCloudFileCallbackCenter[i].onUploadTotalProgress(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgh
 * JD-Core Version:    0.7.0.1
 */