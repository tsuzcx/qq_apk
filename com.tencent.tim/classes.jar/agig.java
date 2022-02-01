import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.NewDiscFileUploader.2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class agig
  implements agpb
{
  long Yv;
  agig.a jdField_a_of_type_Agig$a;
  agow jdField_a_of_type_Agow = new agow();
  public agox a;
  boolean isStop = true;
  QQAppInterface mApp;
  long nSessionId = ahav.d().longValue();
  
  public agig(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, int paramInt2, String paramString5, String paramString6, agig.a parama)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Agig$a = parama;
    this.Yv = paramLong;
    paramQQAppInterface = new agoz(this.mApp.getCurrentAccountUin(), "actDiscussFileUp");
    this.jdField_a_of_type_Agow.a(paramString1, paramString2, paramLong, new agih(this, parama));
    this.jdField_a_of_type_Agox = new agox(this.mApp, paramQQAppInterface, paramString3, paramInt1, paramString5, this.nSessionId, this.jdField_a_of_type_Agow, paramBoolean, paramString4, paramString6);
  }
  
  public FileManagerEntity a()
  {
    return null;
  }
  
  public void clearTask()
  {
    if (!this.isStop)
    {
      this.isStop = true;
      QLog.e("FileMultiMsg", 1, "sendDiscFile faild:clearTask");
      this.jdField_a_of_type_Agig$a.IZ(false);
    }
  }
  
  public void dgu()
  {
    this.isStop = false;
    ahav.a.getExecutor().execute(new NewDiscFileUploader.2(this));
  }
  
  public void dgv()
  {
    this.isStop = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:networkBroken");
    this.jdField_a_of_type_Agig$a.IZ(false);
  }
  
  public void dgw()
  {
    this.isStop = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:userCancel");
    this.jdField_a_of_type_Agig$a.IZ(false);
  }
  
  public void dgx()
  {
    this.isStop = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild:exceptBroken");
    this.jdField_a_of_type_Agig$a.IZ(false);
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
    return this.Yv;
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
    return this.isStop;
  }
  
  public void j(Object paramObject, int paramInt)
  {
    this.isStop = true;
    QLog.e("FileMultiMsg", 1, "sendDiscFile faild errCode" + paramInt);
    this.jdField_a_of_type_Agig$a.IZ(false);
  }
  
  public static abstract interface a
  {
    public abstract void IZ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agig
 * JD-Core Version:    0.7.0.1
 */