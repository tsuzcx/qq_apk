import android.os.Bundle;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.NewFileUploader.1;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class agii
  implements agkv.b, agpb
{
  private final String TAG = "NewFileUploader";
  private agii.a jdField_a_of_type_Agii$a;
  private agkv jdField_a_of_type_Agkv;
  private final VFSFile jdField_a_of_type_ComTencentMmVfsVFSFile;
  private QQAppInterface mApp;
  private long mFileSize;
  private boolean mIsStop = true;
  private long nSessionId = ahav.d().longValue();
  
  public agii(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, agii.a parama)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramString1);
    this.mFileSize = paramLong;
    this.jdField_a_of_type_Agkv = agkv.a(this.mApp, this.nSessionId, 0, 0, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5);
    if (this.jdField_a_of_type_Agkv != null) {
      this.jdField_a_of_type_Agkv.a(this);
    }
    this.jdField_a_of_type_Agii$a = parama;
  }
  
  public void IC(String paramString) {}
  
  public FileManagerEntity a()
  {
    return null;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    QLog.i("FileMultiMsg", 1, "sendBuddyFile onError bFinished[" + paramBoolean + "], errCode[" + paramInt + "], errMsg[" + paramString1 + "]");
    this.jdField_a_of_type_Agii$a.IZ(false);
  }
  
  public byte[] a(Bundle paramBundle)
  {
    return null;
  }
  
  public void c(boolean paramBoolean, long paramLong, String paramString1, String paramString2) {}
  
  public void clearTask()
  {
    this.mIsStop = true;
  }
  
  public void dgA()
  {
    this.jdField_a_of_type_Agii$a.IZ(true);
    QLog.i("FileMultiMsg", 1, "sendBuddyFile upload success");
  }
  
  public void dgB() {}
  
  public void dgC() {}
  
  public void dgu()
  {
    this.mIsStop = false;
    ahav.a.getExecutor().execute(new NewFileUploader.1(this));
  }
  
  public void dgv()
  {
    this.mIsStop = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile networkBroken");
    this.jdField_a_of_type_Agii$a.IZ(false);
  }
  
  public void dgw()
  {
    this.mIsStop = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile userCancel");
    this.jdField_a_of_type_Agii$a.IZ(false);
  }
  
  public void dgx()
  {
    this.mIsStop = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile exceptBroken");
    this.jdField_a_of_type_Agii$a.IZ(false);
  }
  
  public void dgz()
  {
    this.jdField_a_of_type_Agii$a.IZ(true);
    QLog.i("FileMultiMsg", 1, "sendBuddyFile upload onHit");
  }
  
  public int getActionType()
  {
    return 41;
  }
  
  public String getFileId()
  {
    return null;
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public int getProgress()
  {
    return 0;
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  public boolean isStop()
  {
    return this.mIsStop;
  }
  
  public void j(Object paramObject, int paramInt)
  {
    this.mIsStop = true;
    QLog.i("FileMultiMsg", 1, "sendBuddyFile NotifyUIError:" + paramInt);
    this.jdField_a_of_type_Agii$a.IZ(false);
  }
  
  public void jm(long paramLong) {}
  
  public static abstract interface a
  {
    public abstract void IZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agii
 * JD-Core Version:    0.7.0.1
 */