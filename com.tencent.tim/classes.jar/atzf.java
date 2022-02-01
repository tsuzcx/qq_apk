import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atzf
  extends atzs
{
  private atsn a;
  private atgd b;
  
  public atzf(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    V(paramList, paramInt);
  }
  
  private void m(long paramLong, int paramInt, String paramString)
  {
    audx.n(paramLong, paramInt, paramString);
    if ((paramInt == 1020) || (paramInt == -7003))
    {
      paramString = this.c.b();
      if (paramString != null) {
        break label38;
      }
    }
    label38:
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString.WeiYunFileId))
      {
        eH(paramString.WeiYunFileId, this.c.getFileType());
        return;
      }
    } while (TextUtils.isEmpty(paramString.Uuid));
    eH(paramString.Uuid, this.c.getFileType());
  }
  
  public atyz a()
  {
    if (this.jdField_a_of_type_Atyz == null) {
      this.jdField_a_of_type_Atyz = new atzi(this);
    }
    return this.jdField_a_of_type_Atyz;
  }
  
  public atzb a()
  {
    if (this.jdField_a_of_type_Atzb == null) {
      this.jdField_a_of_type_Atzb = new atzk(this);
    }
    return this.jdField_a_of_type_Atzb;
  }
  
  protected void a(agsd paramagsd, int paramInt)
  {
    ateh localateh = (ateh)this.mAppInterface.getBusinessHandler(180);
    if ((paramagsd instanceof atyh))
    {
      if (aqhq.fileExistsAndNotEmpty(paramagsd.getFilePath())) {
        localateh.a(paramagsd.getFileName(), paramagsd.getFilePath(), paramagsd.getFileSize(), paramagsd.getFileType(), 8);
      }
      return;
    }
    localateh.a(paramagsd.b(), paramInt, audx.g(paramagsd.b()));
  }
  
  public int bE()
  {
    int i = 2;
    int j = bG();
    if (j == 0) {
      i = 9;
    }
    do
    {
      return i;
      int k = super.bE();
      if (k != 0) {
        return k;
      }
      switch (getFileType())
      {
      case 3: 
      default: 
        return 7;
      }
    } while ((j != 2) && (!cj()));
    return 1;
    if ((audx.b(this.mAppInterface, this.c)) && (audx.b(this.mContext, getFileName(), getFileSize()))) {
      return 5;
    }
    return 7;
    return 6;
    return 1;
  }
  
  public int bL()
  {
    int i = super.bL();
    if (bI() == 10) {
      i = 6;
    }
    return i;
  }
  
  public void cqt()
  {
    super.cqt();
    if ((audx.a(this.mAppInterface, this.c)) && (audx.b(this.mAppInterface, this.c))) {
      this.mAppInterface.a().dhn();
    }
  }
  
  public void djr()
  {
    super.djr();
    FileManagerEntity localFileManagerEntity = this.c.b();
    atvw localatvw;
    if (bG() == 1)
    {
      if (!aJm()) {
        break label162;
      }
      if (bH() != 3000) {
        break label142;
      }
      localatvw = new atvw(2);
      localatvw.setUin(localFileManagerEntity.peerUin);
      localatvw.g(null, localFileManagerEntity.Uuid);
      localatvw.y(localFileManagerEntity.strFileSHA, localFileManagerEntity.strFileMd5, localFileManagerEntity.fileSize);
      localatvw.o(Boolean.valueOf(localFileManagerEntity.isSend()));
      this.mAppInterface.a().a(localatvw);
    }
    for (;;)
    {
      ((ateh)this.mAppInterface.getBusinessHandler(180)).a(this.c.b(), 5, audx.g(this.c.b()));
      return;
      label142:
      localatvw = new atvw(1);
      localatvw.setUin(localFileManagerEntity.selfUin);
      break;
      label162:
      if (bH() == 3000) {
        this.mAppInterface.a().a(new atsz(this.mAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      } else {
        this.mAppInterface.a().a(new atub(this.mAppInterface, localFileManagerEntity.Uuid));
      }
    }
  }
  
  public ArrayList<aufa.b> er()
  {
    if (bG() == 0) {
      return null;
    }
    return super.er();
  }
  
  public void iC()
  {
    if ((audx.a(this.mAppInterface, this.c)) && (audx.b(this.mAppInterface, this.c)))
    {
      long l = V();
      if (bG() == 2) {
        l = audx.N(getFileSize());
      }
      this.mAppInterface.a().aq(l, this.c.b().WeiYunFileId);
    }
    super.iC();
  }
  
  protected void ix()
  {
    if (this.jdField_a_of_type_Atsn == null)
    {
      this.jdField_a_of_type_Atsn = new atzg(this);
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.jdField_a_of_type_Atsn);
    }
    if (this.b == null)
    {
      this.b = new atzh(this);
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.b);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("C2CFileModel<FileAssistant>", 1, "add fmObserver");
    }
    if ((aqhq.fileExistsAndNotEmpty(getFilePath())) && (this.aab == 0L) && (getFileType() != 0)) {
      a(this.c, 4);
    }
  }
  
  protected void removeObserver()
  {
    if (this.jdField_a_of_type_Atsn != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.jdField_a_of_type_Atsn);
      this.jdField_a_of_type_Atsn = null;
    }
    if (this.b != null)
    {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.b);
      if (QLog.isDevelopLevel()) {
        QLog.i("C2CFileModel<FileAssistant>", 1, "remove cloudFileObserver");
      }
      this.b = null;
    }
    if (this.c.b() == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzf
 * JD-Core Version:    0.7.0.1
 */