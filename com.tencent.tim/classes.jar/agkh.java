import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter.2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Observable;
import mqq.os.MqqHandler;

public class agkh
  extends Observable
{
  public QQAppInterface app;
  MqqHandler g = new agki(this, Looper.getMainLooper());
  
  public agkh(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface.setHandler(getClass(), this.g);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("averageSpeed", String.valueOf(0.0F));
    ((HashMap)localObject).put("peerUin", String.valueOf(paramFileManagerEntity.peerUin));
    ((HashMap)localObject).put("fileType", ahbj.getExtension(paramFileManagerEntity.fileName));
    switch (paramInt)
    {
    default: 
      QLog.e("FileManagerNotifyCenter<FileAssistant>", 1, "what type is report?!nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "],may be not report!");
      return;
    case 5: 
      return;
    case 6: 
      localObject = "actFileOf2Of";
    }
    for (;;)
    {
      ahav.a(this.app, paramFileManagerEntity.nSessionId, (String)localObject, 1L, paramString, paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, paramFileManagerEntity.fileSize, 0, null);
      return;
      localObject = "actFileOf2Wy";
      continue;
      localObject = "actFileWy2Of";
      continue;
      localObject = "actFileDisc2Of";
      continue;
      localObject = "actFileDisc2Disc";
      continue;
      localObject = "actFileTroop2Of";
      continue;
      localObject = "actFileTroop2Disc";
      continue;
      localObject = "actFileFav2Disc";
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2)
  {
    setChanged();
    if (paramObject == null)
    {
      notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), paramString2 });
      return;
    }
    notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), paramObject });
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    b(paramFileManagerEntity, paramInt, paramString);
    ThreadManager.executeOnSubThread(new FileManagerNotifyCenter.2(this, paramFileManagerEntity, paramInt));
  }
  
  public void b(boolean paramBoolean, int paramInt, Object paramObject)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject });
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agkh
 * JD-Core Version:    0.7.0.1
 */