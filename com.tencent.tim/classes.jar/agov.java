import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator.1;
import com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator.2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class agov
  extends agie
  implements agpa, agpb
{
  long HO = 0L;
  final String TAG = "DiscFileOperator<FileAssistant>";
  agow a;
  public agoz a;
  public QQAppInterface app = null;
  public agox b = null;
  public FileManagerEntity c = null;
  final int cXw = 1000;
  public boolean ceF = true;
  agie fileTransferObserver = null;
  
  public agov(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Agoz = null;
    this.jdField_a_of_type_Agow = null;
    this.app = paramQQAppInterface;
    this.c = paramFileManagerEntity;
    this.c.status = 2;
    this.jdField_a_of_type_Agoz = new agoz(paramQQAppInterface.getCurrentAccountUin(), "actDiscussFileUp");
  }
  
  private void Jr(boolean paramBoolean)
  {
    QLog.i("DiscFileOperator<FileAssistant>", 1, "nID[" + this.c.nSessionId + "]notifyUIRefresh[" + paramBoolean + "]");
    this.app.a().jp(this.c.nSessionId);
    if (paramBoolean)
    {
      this.c.status = 1;
      this.c.fProgress = 1.0F;
      this.app.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 14, new Object[] { this.c.getFilePath(), Long.valueOf(this.c.fileSize), Boolean.valueOf(true), this.c.strServerPath }, 0, null);
      String str2 = this.c.fileName;
      String str1 = str2;
      if (this.c.nFileType == 5)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.c.strApkPackageName))
        {
          str1 = str2;
          if (str2.indexOf(".apk") < 0) {
            str1 = str2 + ".apk";
          }
        }
      }
      this.app.a().a(this.c.nSessionId, this.c.peerUin, this.app.getCurrentAccountUin(), str1, this.c.fileSize, this.c.Uuid, this.c.uniseq, this.c.msgUid, this);
    }
    for (;;)
    {
      this.app.a().u(this.c);
      return;
      this.c.status = 0;
      this.app.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 15, null, 5, null);
      if (this.b != null) {
        this.b.stop();
      }
    }
  }
  
  private boolean b(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.c.nSessionId + "]checkParam-->Host null");
      this.c.status = 0;
      if (paramLong == 0L)
      {
        this.jdField_a_of_type_Agoz.Zs = 9048L;
        this.jdField_a_of_type_Agoz.strErrMsg = "onSendDiscFile Host null";
        this.jdField_a_of_type_Agoz.diE();
        Jr(false);
        bool = false;
      }
    }
    while ((paramString2 != null) && (paramString2.length() != 0) && (paramString3 != null) && (paramString3.length() != 0)) {
      for (;;)
      {
        return bool;
        this.jdField_a_of_type_Agoz.Zs = ((int)paramLong);
      }
    }
    QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.c.nSessionId + "]checkParam-->param error");
    this.c.status = 0;
    if (paramLong == 0L) {}
    for (this.jdField_a_of_type_Agoz.Zs = 9005L;; this.jdField_a_of_type_Agoz.Zs = ((int)paramLong))
    {
      this.jdField_a_of_type_Agoz.strErrMsg = "onSendDiscFile param error";
      this.jdField_a_of_type_Agoz.diE();
      Jr(false);
      return false;
    }
  }
  
  public FileManagerEntity a()
  {
    return this.c;
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (this.ceF)
    {
      QLog.w("DiscFileOperator<FileAssistant>", 1, "nID[" + this.c.nSessionId + "],onSendDiscFile user canceled!");
      return;
    }
    this.jdField_a_of_type_Agoz.Zu = System.currentTimeMillis();
    if (!paramBoolean)
    {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "=_= ^! Id[" + this.c.nSessionId + "]onSendDiscFile-->failed");
      this.c.status = 0;
      if (paramLong == -100001L) {}
      for (this.jdField_a_of_type_Agoz.Zs = 9043L;; this.jdField_a_of_type_Agoz.Zs = 9045L)
      {
        this.jdField_a_of_type_Agoz.strErrMsg = "server retError";
        if (paramString6 != null) {
          this.jdField_a_of_type_Agoz.strErrMsg = paramString6;
        }
        this.jdField_a_of_type_Agoz.diE();
        Jr(false);
        return;
      }
    }
    QLog.d("DiscFileOperator<FileAssistant>", 2, "=_= ^> [CS Replay]Id[" + this.c.nSessionId + "]onSendDiscFile, Go [Upload Step]");
    if (!b(paramLong, paramString4, paramString3, paramString2))
    {
      QLog.d("DiscFileOperator<FileAssistant>", 2, "=_= ^! [Check Param]Id[" + this.c.nSessionId + "]checkParam error!");
      return;
    }
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      QLog.e("DiscFileOperator<FileAssistant>", 1, "id[" + String.valueOf(this.c.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramString6);
      this.app.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 4, null, (int)paramLong, paramString6);
    }
    paramBoolean = false;
    int i;
    if ((agmx.aI(this.app)) && (paramBundle != null))
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort", (short)0);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramBoolean = true;
        if (i == 0) {
          paramInt = 443;
        }
      }
    }
    for (;;)
    {
      paramString5 = "";
      if (paramBundle != null) {
        paramString5 = paramBundle.getString("IPv6Dns");
      }
      QLog.i("DiscFileOperator<FileAssistant>", 1, "=_= ^> nSessionID[" + String.valueOf(this.c.nSessionId) + "],retCode[" + String.valueOf(paramLong) + "] useHttps:" + paramBoolean + " httpsDomain:" + paramString2 + " uploadPort:" + paramInt);
      this.c.Uuid = paramString1;
      this.c.status = 0;
      this.app.a().u(this.c);
      this.c.status = 2;
      this.jdField_a_of_type_Agow = new agow();
      this.jdField_a_of_type_Agow.a(paramString3, this.c.strFileSHA, this.c.fileSize, this);
      this.b = new agox(this.app, this.jdField_a_of_type_Agoz, paramString4, paramInt, this.c.getFilePath(), this.c.nSessionId, this.jdField_a_of_type_Agow, paramBoolean, paramString2, paramString5);
      ThreadManager.post(new DiscFileOperator.1(this), 8, null, true);
      return;
      paramInt = i;
      continue;
      paramString2 = null;
    }
  }
  
  public void as(long paramLong1, long paramLong2)
  {
    this.c.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.c.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.HO >= 1000L)
    {
      this.HO = paramLong1;
      this.c.setCloudType(3);
      this.app.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 16, null, 0, null);
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_Agoz.vq();
        QLog.i("DiscFileOperator<FileAssistant>.Speed", 1, "Id[" + String.valueOf(this.c.nSessionId) + "], speed[" + str + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  public void clearTask()
  {
    this.ceF = true;
    if (this.b != null) {
      this.b.stop();
    }
  }
  
  protected void d(boolean paramBoolean, Long paramLong)
  {
    this.jdField_a_of_type_Agoz.Zs = paramLong.longValue();
    this.app.a().jp(this.c.nSessionId);
  }
  
  public void dgu()
  {
    this.ceF = false;
    diB();
  }
  
  public void dgv()
  {
    this.ceF = true;
    if (this.b != null) {
      this.b.stop();
    }
    this.jdField_a_of_type_Agoz.Zs = 9004L;
    this.jdField_a_of_type_Agoz.Zx = System.currentTimeMillis();
    this.jdField_a_of_type_Agoz.diE();
  }
  
  public void dgw()
  {
    this.ceF = true;
    if (this.b != null) {
      this.b.stop();
    }
    this.jdField_a_of_type_Agoz.Zs = 9037L;
    this.jdField_a_of_type_Agoz.Zx = System.currentTimeMillis();
    this.jdField_a_of_type_Agoz.diE();
    this.app.a().b(true, 3, null);
  }
  
  public void dgx()
  {
    clearTask();
  }
  
  public void dgy()
  {
    Jr(true);
  }
  
  public void diB()
  {
    this.jdField_a_of_type_Agoz.cYu = 3000;
    this.jdField_a_of_type_Agoz.strFileName = this.c.fileName;
    this.jdField_a_of_type_Agoz.uFileSize = this.c.fileSize;
    this.jdField_a_of_type_Agoz.bIM = this.c.peerUin;
    this.c.status = 0;
    this.app.a().u(this.c);
    this.c.status = 2;
    if (QLog.isColorLevel()) {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "start sendFile:" + anaz.gQ());
    }
    ahav.a.getExecutor().execute(new DiscFileOperator.2(this));
  }
  
  public int getActionType()
  {
    return this.c.nOpType;
  }
  
  public String getFileId()
  {
    return null;
  }
  
  public long getFileSize()
  {
    return this.c.fileSize;
  }
  
  public int getProgress()
  {
    return (int)(this.c.fProgress * 100.0F);
  }
  
  public int getStatus()
  {
    return this.c.status;
  }
  
  public boolean isStop()
  {
    return this.ceF;
  }
  
  public void j(Object paramObject, int paramInt)
  {
    Jr(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agov
 * JD-Core Version:    0.7.0.1
 */