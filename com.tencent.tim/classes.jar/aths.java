import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileThumbDownload.1;
import com.tencent.tim.cloudfile.CloudFileThumbDownload.2;
import com.tencent.tim.cloudfile.CloudFileThumbDownload.3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class aths
{
  public static volatile aths a;
  private CopyOnWriteArrayList<aths.a> g = new CopyOnWriteArrayList();
  private HashMap<String, aths.b> qd = new HashMap();
  
  private void V(FileManagerEntity paramFileManagerEntity)
  {
    ThreadManager.post(new CloudFileThumbDownload.2(this, paramFileManagerEntity), 8, null, false);
  }
  
  private void W(FileManagerEntity paramFileManagerEntity)
  {
    ThreadManager.post(new CloudFileThumbDownload.3(this, paramFileManagerEntity), 8, null, false);
  }
  
  public static aths a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aths();
      }
      return a;
    }
    finally {}
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      File localFile = new File(paramString);
      if ((localFile.length() < 100L) && (!aqhu.rt(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloudFileThumbDownload", 2, new Object[] { "checkImageThumb| delete invalid thumbnail, file: ", paramFileManagerEntity.fileName });
        }
        localFile.delete();
      }
    }
    else
    {
      return false;
    }
    if (paramInt == 7) {
      if ((!paramString.equals(paramFileManagerEntity.strLargeThumPath)) && (auef.u(paramFileManagerEntity)) && (!aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))) {
        V(paramFileManagerEntity);
      }
    }
    for (;;)
    {
      return true;
      if (paramInt == 5)
      {
        if ((!paramString.equals(paramFileManagerEntity.strMiddleThumPath)) && (auef.u(paramFileManagerEntity))) {
          W(paramFileManagerEntity);
        }
      }
      else {
        paramFileManagerEntity.strThumbPath = paramString;
      }
    }
  }
  
  public static boolean aX(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      if (paramInt1 <= paramInt2) {
        break label23;
      }
    }
    for (;;)
    {
      return auef.aX(i, paramInt1);
      i = paramInt2;
      break;
      label23:
      paramInt1 = paramInt2;
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((aths.a)localIterator.next()).a(paramFileManagerEntity, paramInt1, paramInt2, paramString);
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileThumbDownload", 2, "start work, but network not support.");
      }
      return;
    }
    paramString = new aths.b(paramFileManagerEntity, paramString, paramInt);
    this.qd.put(d(paramFileManagerEntity.pDirKey, paramFileManagerEntity.cloudId), paramString);
    paramString.work();
  }
  
  private String d(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramInt == 5)
    {
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        return paramFileManagerEntity.strMiddleThumPath;
      }
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) {
        return paramFileManagerEntity.strLargeThumPath;
      }
    }
    else if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
    {
      return paramFileManagerEntity.strLargeThumPath;
    }
    return null;
  }
  
  private String d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new String(paramArrayOfByte1) + new String(paramArrayOfByte2);
  }
  
  public void U(FileManagerEntity paramFileManagerEntity)
  {
    int i = 256;
    if (aqiw.isWifiConnected(BaseApplication.getContext())) {
      i = 640;
    }
    c(paramFileManagerEntity, i);
  }
  
  public void a(aths.a parama)
  {
    this.g.add(parama);
  }
  
  public void b(aths.a parama)
  {
    this.g.remove(parama);
  }
  
  public String c(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    Object localObject1;
    if (paramFileManagerEntity == null)
    {
      localObject1 = null;
      return localObject1;
    }
    if (paramInt > 256) {}
    for (int i = 7;; i = 5)
    {
      localObject1 = d(paramFileManagerEntity, i);
      if (localObject1 != null) {
        return localObject1;
      }
      Object localObject2;
      if (paramFileManagerEntity.fromCloudFile)
      {
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (((atgc)((QQAppInterface)localObject2).getManager(373)).w(paramFileManagerEntity.pDirKey))
        {
          localObject2 = ((QQAppInterface)localObject2).a().a(paramFileManagerEntity.cloudId);
          if (localObject2 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CloudFileThumbDownload", 2, new Object[] { paramFileManagerEntity.fileName, " find corresponding offline file" });
            }
            paramFileManagerEntity.strMiddleThumPath = ((FileManagerEntity)localObject2).strMiddleThumPath;
            paramFileManagerEntity.strLargeThumPath = ((FileManagerEntity)localObject2).strLargeThumPath;
            paramFileManagerEntity.strThumbPath = ((FileManagerEntity)localObject2).strThumbPath;
            localObject2 = d((FileManagerEntity)localObject2, i);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              b(paramFileManagerEntity, paramInt, 0, "");
              return localObject2;
            }
          }
        }
      }
      if (TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
        athu.X(paramFileManagerEntity);
      }
      if (paramFileManagerEntity.nFileType == 0)
      {
        localObject1 = auef.i(paramFileManagerEntity);
        localObject2 = audn.a().wb() + auef.D(7, (String)localObject1);
        String str = audn.a().wb() + auef.D(5, (String)localObject1);
        if (i == 5) {}
        boolean bool2;
        for (localObject1 = str;; localObject1 = localObject2)
        {
          paramFileManagerEntity.strLargeThumPath = ((String)localObject2);
          paramFileManagerEntity.strMiddleThumPath = str;
          boolean bool1 = a(paramFileManagerEntity, (String)localObject2, 7);
          bool2 = a(paramFileManagerEntity, str, 5);
          if (!bool1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CloudFileThumbDownload", 2, new Object[] { paramFileManagerEntity.fileName, " largeThumbExist exist!!" });
          }
          paramFileManagerEntity.strThumbPath = ((String)localObject2);
          b(paramFileManagerEntity, paramInt, 0, "");
          return localObject2;
        }
        if ((bool2) && (i == 5))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CloudFileThumbDownload", 2, new Object[] { paramFileManagerEntity.fileName, " middleThumbExist exist!!" });
          }
          paramFileManagerEntity.strThumbPath = str;
          b(paramFileManagerEntity, paramInt, 0, "");
          return str;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CloudFileThumbDownload", 2, new Object[] { paramFileManagerEntity.fileName, " thumbnail not exist!!" });
        }
        c(paramFileManagerEntity, (String)localObject1, paramInt);
        paramFileManagerEntity.strThumbPath = ((String)localObject1);
        return localObject1;
      }
      if (paramFileManagerEntity.nFileType != 2) {
        break;
      }
      localObject1 = paramFileManagerEntity.Uuid.replace("/", "");
      localObject1 = audn.a().wb() + atsy.C(7, (String)localObject1);
      if (aqhq.fileExistsAndNotEmpty((String)localObject1))
      {
        localObject2 = new File((String)localObject1);
        if ((((File)localObject2).length() > 100L) || (aqhu.rt((String)localObject1)))
        {
          paramFileManagerEntity.strLargeThumPath = ((String)localObject1);
          paramFileManagerEntity.strThumbPath = ((String)localObject1);
          return localObject1;
        }
        ((File)localObject2).delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileThumbDownload", 2, new Object[] { paramFileManagerEntity.fileName, " thumbnail not exist!!" });
      }
      if (aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloudFileThumbDownload", 2, "local video, create thumbnail.");
        }
        ThreadManager.executeOnFileThread(new CloudFileThumbDownload.1(this, paramFileManagerEntity, (String)localObject1, paramInt));
        return localObject1;
      }
      paramFileManagerEntity.strLargeThumPath = ((String)localObject1);
      paramFileManagerEntity.strThumbPath = ((String)localObject1);
      c(paramFileManagerEntity, (String)localObject1, paramInt);
      return localObject1;
    }
  }
  
  public void clear()
  {
    this.g.clear();
    this.qd.clear();
  }
  
  public void onGetThumComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    paramArrayOfByte1 = (aths.b)this.qd.remove(d(paramArrayOfByte1, paramArrayOfByte2));
    if (paramArrayOfByte1 == null) {
      return;
    }
    if (paramInt2 != 0) {
      try
      {
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("Get thumb error, name: ").append(paramArrayOfByte1.entity.fileName).append(", errCode=").append(paramInt2).append(", errMsg=").append(paramString2);
        QLog.w("CloudFileThumbDownload", 2, paramArrayOfByte2.toString());
        return;
      }
      catch (Exception paramArrayOfByte1)
      {
        QLog.e("CloudFileThumbDownload", 2, paramArrayOfByte1.getMessage());
        return;
      }
    }
    if (!aqhu.rt(paramString1))
    {
      QLog.w("CloudFileThumbDownload", 2, "onGetThumbComplete| not a valid pic! name: " + paramArrayOfByte1.entity.fileName);
      new File(paramString1).delete();
      return;
    }
    aqhq.copyFile(paramString1, paramArrayOfByte1.thumbPath);
    paramArrayOfByte2 = paramArrayOfByte1.entity;
    paramArrayOfByte2.strThumbPath = paramArrayOfByte1.thumbPath;
    if (paramArrayOfByte1.size <= 256)
    {
      paramArrayOfByte2.strMiddleThumPath = paramArrayOfByte1.thumbPath;
      if (auef.u(paramArrayOfByte2)) {
        W(paramArrayOfByte2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileThumbDownload", 2, new Object[] { paramArrayOfByte2.fileName, " download thumb success, notify observer." });
      }
      b(paramArrayOfByte2, paramInt1, paramInt2, paramString2);
      return;
      paramArrayOfByte2.strLargeThumPath = paramArrayOfByte1.thumbPath;
      if (auef.u(paramArrayOfByte2)) {
        V(paramArrayOfByte2);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, String paramString);
  }
  
  static class b
  {
    FileManagerEntity entity;
    int size;
    String thumbPath;
    
    public b(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
    {
      this.entity = paramFileManagerEntity;
      this.thumbPath = paramString;
      this.size = paramInt;
    }
    
    public void work()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.entity.cloudId);
      atgi.a().getThumbList(this.entity.pDirKey, localArrayList, this.size);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aths
 * JD-Core Version:    0.7.0.1
 */