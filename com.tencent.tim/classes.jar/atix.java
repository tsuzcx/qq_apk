import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class atix
  extends accg
{
  public atix(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, Object paramObject, int paramInt2, int paramInt3)
  {
    atiy localatiy = new atiy(this, paramInt1, paramInt2);
    if (paramInt2 == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendRecvFileHandler", 2, "refresh load");
      }
      if (paramInt1 == -1) {
        atgi.a().a(paramArrayOfByte, paramInt3, localatiy);
      }
    }
    label180:
    do
    {
      return;
      atgi.a().refreshDirFileList(paramInt1, paramArrayOfByte, paramInt3, localatiy);
      return;
      if (paramInt2 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SendRecvFileHandler", 2, "loadmore load");
        }
        if (paramInt1 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SendRecvFileHandler", 2, "lastfile " + ((FileManagerEntity)paramObject).fileName);
          }
          atgi.a().a(paramArrayOfByte, paramObject, false, paramInt3, localatiy);
          return;
        }
        Object localObject = null;
        if (paramObject != null) {
          if (!(paramObject instanceof FileManagerEntity)) {
            break label180;
          }
        }
        for (paramObject = ((FileManagerEntity)paramObject).cloudFile;; paramObject = ((atin)paramObject).a)
        {
          localObject = paramObject;
          atgi.a().fetchDirFileList(paramInt1, paramArrayOfByte, localObject, false, paramInt3, localatiy);
          return;
        }
      }
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SendRecvFileHandler", 2, "initial load");
        }
        if (paramInt1 == -1)
        {
          atgi.a().a(paramArrayOfByte, null, false, paramInt3, localatiy);
          return;
        }
        atgi.a().fetchDirFileList(paramInt1, paramArrayOfByte, null, false, paramInt3, localatiy);
        return;
      }
    } while (paramInt2 != -1);
    atgi.a().d(localatiy);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return atij.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.actionListener.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atix
 * JD-Core Version:    0.7.0.1
 */