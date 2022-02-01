import android.text.TextUtils;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.cloudfile.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class atvu
  extends Observable
{
  private CloudFileCallbackCenter d;
  private Map<Long, Long> pA = new HashMap();
  
  private void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    if (paramInt2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      long l = b(paramLong, bool);
      if (l != 0L)
      {
        setChanged();
        notifyObservers(new Object[] { Integer.valueOf(3), { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramCloudUploadFile, Long.valueOf(paramLong) } });
      }
      return;
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, int paramInt, String paramString)
  {
    long l = b(paramLong, false);
    if (l != 0L)
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(1), { Long.valueOf(l), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) } });
    }
  }
  
  private long b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Long localLong = (Long)this.pA.remove(Long.valueOf(paramLong)); localLong != null; localLong = (Long)this.pA.get(Long.valueOf(paramLong))) {
      return localLong.longValue();
    }
    return 0L;
  }
  
  private void b(byte[] paramArrayOfByte, long paramLong, int paramInt, String paramString)
  {
    long l = b(paramLong, false);
    if (l != 0L)
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(2), { Long.valueOf(l), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) } });
    }
  }
  
  private void c(byte[] paramArrayOfByte, long paramLong, int paramInt, String paramString)
  {
    long l = b(paramLong, true);
    if (l != 0L)
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(4), { Long.valueOf(l), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong) } });
    }
    atvp.a().nq(paramLong);
  }
  
  private void init()
  {
    if (this.d == null)
    {
      QLog.i("WpsFileEditUploader", 1, "[WPSEDIT] init");
      this.d = new atvv(this);
      atgi.a().a(this.d);
    }
  }
  
  public int a(long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("WpsFileEditUploader", 1, "[WPSEDIT]<" + paramLong + "> startUploadFile. param err");
      return -1;
    }
    init();
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.fileName = paramString2;
    localFileInfo.fileSize = ahav.getFileSizes(paramString1);
    localFileInfo.localPath = paramString1;
    localFileInfo.fileSrcType = 1;
    if (paramBoolean)
    {
      localFileInfo.fileExistOption = 1;
      localFileInfo.addHistoryafterUpload = false;
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList();
      paramArrayOfByte = atgi.a().a(paramArrayOfByte, localFileInfo);
      if (paramArrayOfByte.uploadFile.taskId != 0L) {
        break;
      }
      QLog.e("WpsFileEditUploader", 1, "[WPSEDIT]<" + paramLong + "> startUploadFile. createUploadTask failed");
      return -2;
      localFileInfo.fileExistOption = 0;
    }
    QLog.i("WpsFileEditUploader", 1, "[WPSEDIT]<" + paramLong + "> startUploadFile. filePath:" + paramString1 + " fileName:" + paramString2 + " bOverwrite:" + paramBoolean + " taskid:" + paramArrayOfByte.uploadFile.taskId);
    localArrayList.add(Long.valueOf(paramArrayOfByte.uploadFile.taskId));
    atgi.a().startUploadFile(localArrayList);
    this.pA.put(Long.valueOf(paramArrayOfByte.uploadFile.taskId), Long.valueOf(paramLong));
    return 0;
  }
  
  public boolean dl(long paramLong)
  {
    return this.pA.containsKey(Long.valueOf(paramLong));
  }
  
  public void nr(long paramLong)
  {
    long l = 0L;
    Object localObject = this.pA.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (((Long)localEntry.getValue()).longValue() == paramLong)
      {
        l = ((Long)localEntry.getKey()).longValue();
        ((Iterator)localObject).remove();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        QLog.i("WpsFileEditUploader", 1, "[WPSEDIT]<" + paramLong + "> deleteUploadFile. taskid:" + l);
        localObject = new ArrayList();
        ((List)localObject).add(Long.valueOf(l));
        atgi.a().deleteUploadFile((List)localObject);
        return;
      }
      QLog.w("WpsFileEditUploader", 1, "[WPSEDIT]<" + paramLong + "> deleteUploadFile failed. not find");
      return;
    }
  }
  
  public void ns(long paramLong)
  {
    QLog.i("WpsFileEditUploader", 1, "[WPSEDIT] deleteUploadFileByTaskId. taskid:" + paramLong);
    this.pA.remove(Long.valueOf(paramLong));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    atgi.a().deleteUploadFile(localArrayList);
  }
  
  public static class a
    implements Observer
  {
    public void a(long paramLong1, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile, long paramLong2) {}
    
    public void b(long paramLong1, int paramInt, String paramString, long paramLong2) {}
    
    public void c(long paramLong1, int paramInt, String paramString, long paramLong2) {}
    
    public void d(long paramLong1, int paramInt, String paramString, long paramLong2) {}
    
    public final void update(Observable paramObservable, Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramObservable = (Object[])paramObject;
              int i = ((Integer)paramObservable[0]).intValue();
              paramObservable = (Object[])paramObservable[1];
              switch (i)
              {
              default: 
                return;
              }
            } while (paramObservable == null);
            paramObject = (Long)paramObservable[0];
            localInteger = (Integer)paramObservable[1];
            localObject = (String)paramObservable[2];
            paramObservable = (Long)paramObservable[3];
            b(paramObject.longValue(), localInteger.intValue(), (String)localObject, paramObservable.longValue());
            return;
          } while (paramObservable == null);
          paramObject = (Long)paramObservable[0];
          localInteger = (Integer)paramObservable[1];
          localObject = (String)paramObservable[2];
          paramObservable = (Long)paramObservable[3];
          c(paramObject.longValue(), localInteger.intValue(), (String)localObject, paramObservable.longValue());
          return;
        } while (paramObservable == null);
        paramObject = (Long)paramObservable[0];
        localInteger = (Integer)paramObservable[1];
        localObject = (Integer)paramObservable[2];
        String str = (String)paramObservable[3];
        CloudUploadFile localCloudUploadFile = (CloudUploadFile)paramObservable[4];
        paramObservable = (Long)paramObservable[5];
        a(paramObject.longValue(), localInteger.intValue(), ((Integer)localObject).intValue(), str, localCloudUploadFile, paramObservable.longValue());
        return;
      } while (paramObservable == null);
      paramObject = (Long)paramObservable[0];
      Integer localInteger = (Integer)paramObservable[1];
      Object localObject = (String)paramObservable[2];
      paramObservable = (Long)paramObservable[3];
      d(paramObject.longValue(), localInteger.intValue(), (String)localObject, paramObservable.longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvu
 * JD-Core Version:    0.7.0.1
 */