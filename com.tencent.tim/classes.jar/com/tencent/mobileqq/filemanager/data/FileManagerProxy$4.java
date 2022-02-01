package com.tencent.mobileqq.filemanager.data;

import agne;
import ahbj;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileManagerProxy$4
  implements Runnable
{
  public FileManagerProxy$4(agne paramagne, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject2 = "select * from ( select * from " + FileManagerEntity.tableName() + " where bDelInFM = 0  and nRelatedSessionId = " + this.Zi + "  order by srvTime desc limit " + 2000 + ") ";
    EntityManager localEntityManager = agne.a(this.this$0).a().createEntityManager();
    localObject2 = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject2, null);
    for (;;)
    {
      synchronized (agne.a(this.this$0))
      {
        agne.a(this.this$0, new HashMap());
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("find ZipList file:");
          if (localObject2 == null)
          {
            i = 0;
            QLog.i("FileManagerProxy<FileAssistant>", 1, i);
          }
        }
        else
        {
          if (localObject2 == null) {
            return;
          }
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            return;
          }
          ??? = (FileManagerEntity)((Iterator)localObject2).next();
          if ((this.fb == null) || (((FileManagerEntity)???).zipFileId == null) || (((FileManagerEntity)???).zipFileId.equalsIgnoreCase(this.fb))) {
            break label259;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": fileId is error! continiu");
        }
      }
      int i = ((List)localObject2).size();
      continue;
      label259:
      if (TextUtils.isEmpty(((FileManagerEntity)???).strServerPath))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": serverPath is empty!");
        }
        ((FileManagerEntity)???).setStatus(1001);
        localObject1.remove((Entity)???);
      }
      else if (!ahbj.fileExistsAndNotEmpty(((FileManagerEntity)???).getFilePath()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + ": file not exist!");
        }
        ((FileManagerEntity)???).setStatus(1001);
        localObject1.remove((Entity)???);
      }
      else
      {
        try
        {
          synchronized (agne.a(this.this$0))
          {
            agne.a(this.this$0).put(((FileManagerEntity)???).zipInnerPath, ???);
          }
        }
        catch (Exception localException)
        {
          QLog.e("FileManagerProxy<FileAssistant>", 1, ((FileManagerEntity)???).fileName + " getPath error:" + localException.toString());
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy.4
 * JD-Core Version:    0.7.0.1
 */