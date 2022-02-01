import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class atiy
  extends atgg
{
  atiy(atix paramatix, int paramInt1, int paramInt2) {}
  
  public void a(byte[] paramArrayOfByte, List<Object> paramList, boolean paramBoolean, String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2)
  {
    super.a(paramArrayOfByte, paramList, paramBoolean, paramString1, paramLong1, paramLong2, paramInt1, paramInt2, paramString2);
    if (paramInt2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramList.size();
      if (QLog.isColorLevel()) {
        QLog.i("SendRecvFileHandler", 2, "fetched sendrecv type" + this.val$type);
      }
      this.a.notifyUI(this.val$type, bool, new Object[] { paramArrayOfByte, Integer.valueOf(this.epx), paramList, Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void b(List<FileManagerEntity> paramList, int paramInt, String paramString)
  {
    super.b(paramList, paramInt, paramString);
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.i("SendRecvFileHandler", 2, "fetched sendrecv downloaded list , type" + this.val$type);
      }
      paramString = new ArrayList();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label303;
      }
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
      if (this.val$type == -1)
      {
        paramString.add(localFileManagerEntity);
        continue;
        bool = false;
        break;
      }
      if (this.val$type == 1)
      {
        if ((localFileManagerEntity.nFileType == 3) || (localFileManagerEntity.nFileType == 6) || (localFileManagerEntity.nFileType == 7) || (localFileManagerEntity.nFileType == 9)) {
          paramString.add(localFileManagerEntity);
        }
      }
      else if (this.val$type == 2)
      {
        if (localFileManagerEntity.nFileType == 0) {
          paramString.add(localFileManagerEntity);
        }
      }
      else if (this.val$type == 8)
      {
        if (localFileManagerEntity.nFileType == 2) {
          paramString.add(localFileManagerEntity);
        }
      }
      else if ((this.val$type == 52) && (localFileManagerEntity.nFileType != 2) && (localFileManagerEntity.nFileType != 0) && (localFileManagerEntity.nFileType != 3) && (localFileManagerEntity.nFileType != 6) && (localFileManagerEntity.nFileType != 7) && (localFileManagerEntity.nFileType != 9)) {
        paramString.add(localFileManagerEntity);
      }
    }
    label303:
    paramList = this.a;
    paramInt = this.val$type;
    int i = this.epx;
    paramList.notifyUI(paramInt, bool, new Object[] { new byte[0], Integer.valueOf(i), paramString, Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atiy
 * JD-Core Version:    0.7.0.1
 */