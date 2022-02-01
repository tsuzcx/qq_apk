import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.C2CFileObserver.1;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class agth
  extends agts
{
  private aghq i;
  
  public agth(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("C2CFileModel<FileAssistant>", 1, "FileBrowserModel init: type = c2c");
    }
    V(paramList, paramInt);
  }
  
  private void m(long paramLong, int paramInt, String paramString)
  {
    ahav.n(paramLong, paramInt, paramString);
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
  
  public agss a()
  {
    if (this.jdField_a_of_type_Agss == null) {
      this.jdField_a_of_type_Agss = new agti(this);
    }
    return this.jdField_a_of_type_Agss;
  }
  
  public agsv a()
  {
    if (this.jdField_a_of_type_Agsv == null) {
      this.jdField_a_of_type_Agsv = new agtk(this);
    }
    return this.jdField_a_of_type_Agsv;
  }
  
  public agsw a()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (localFileManagerEntity == null) {
      return null;
    }
    if (localFileManagerEntity.peerType == 0) {
      return new agta(this.mAppInterface, localFileManagerEntity);
    }
    if (localFileManagerEntity.peerType == 3000) {
      return new agtd(this.mAppInterface, localFileManagerEntity);
    }
    QLog.w("C2CFileModel<FileAssistant>", 1, "unsuporrt peer type:" + localFileManagerEntity.peerType);
    return null;
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
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    label155:
    for (;;)
    {
      return;
      FileManagerEntity localFileManagerEntity = this.c.b();
      if (localFileManagerEntity != null)
      {
        int k = paramActionSheetItem.action;
        int j;
        if (k == 52)
        {
          j = localFileManagerEntity.getCloudType();
          if (j == 2)
          {
            j = -1006;
            Object localObject = localFileManagerEntity.strFileMd5;
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramActionSheetItem = localFileManagerEntity.str10Md5;
            }
            String str = getFilePath();
            localObject = str;
            if (!aqhq.fileExistsAndNotEmpty(str)) {
              localObject = localFileManagerEntity.strLargeThumPath;
            }
            if (aqhq.fileExistsAndNotEmpty((String)localObject)) {
              OCRPerformFragment.b(this.mContext, (String)localObject, 1, j, paramActionSheetItem);
            }
            j = 1;
          }
        }
        for (;;)
        {
          if (j == 0) {
            break label155;
          }
          Ow(k);
          return;
          if (j == 1)
          {
            j = -1001;
            break;
          }
          j = -1004;
          break;
          j = 0;
          super.a(paramActionSheetItem);
        }
      }
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (bG() == 0) {
      return null;
    }
    return super.a();
  }
  
  public boolean amt()
  {
    return true;
  }
  
  public String ax()
  {
    return "biz_src_jc_file";
  }
  
  public aebf b()
  {
    Object localObject3 = this.c.b();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = ahav.a(new FileInfo(getFilePath()));
      if (localObject1 == null) {
        return new agsm();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject2;
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
      }
      if ((this.cYK == 14) && (this.ba != null) && (this.ba.containsKey("file_color_note_subType")))
      {
        int j = this.ba.getInt("file_color_note_subType", -1);
        localObject3 = getFilePath();
        if ((j == 4) && (aqhq.fileExistsAndNotEmpty((String)localObject3))) {
          return new agsn(localObject2.getFilePath());
        }
      }
      localObject3 = getFilePath();
      if ((TextUtils.isEmpty(localObject2.Uuid)) && (aqhq.fileExistsAndNotEmpty((String)localObject3))) {
        return new agso(localObject2.getFilePath());
      }
      if (!TextUtils.isEmpty(localObject2.Uuid)) {
        return new agsp(this.c.b());
      }
      if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
        return new agsk(localObject2);
      }
    }
    return new agsm();
  }
  
  public int bE()
  {
    int j = 2;
    int k = bG();
    if (k == 0) {
      j = 9;
    }
    do
    {
      return j;
      int m = super.bE();
      if (m != 0) {
        return m;
      }
      switch (getFileType())
      {
      case 3: 
      default: 
        return 7;
      }
    } while ((k != 2) && (!cj()));
    return 1;
    if ((ahav.b(this.mAppInterface, this.c, false)) && (ahav.b(this.mContext, getFileName(), getFileSize()))) {
      return 5;
    }
    return 7;
    return 6;
    return 1;
    return 11;
  }
  
  public int bL()
  {
    int j = super.bL();
    if (bI() == 10) {
      j = 6;
    }
    return j;
  }
  
  public int bM()
  {
    int j = getFileType();
    if ((j != 0) && (j != 2) && (j != 13)) {}
    for (j = 1;; j = 0)
    {
      if (j == 0) {
        return 0;
      }
      String str = getFilePath();
      boolean bool = ahbj.fileExistsAndNotEmpty(str);
      Object localObject = this.c.b();
      if ((bool) && (localObject == null)) {}
      for (;;)
      {
        try
        {
          FileManagerEntity localFileManagerEntity = ahav.a(new FileInfo(str));
          localObject = localFileManagerEntity;
          if ((localObject == null) || (((FileManagerEntity)localObject).status == 16)) {
            break;
          }
          if (bI() == 0)
          {
            j = bF();
            if ((j == 0) || (j == 3) || (j == 2)) {
              break;
            }
          }
          if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)) && (!aqhq.fileExistsAndNotEmpty(str))) {
            break;
          }
          if ((this.e == null) || (!this.e.bZ())) {
            break label173;
          }
          return 2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      label173:
      return 1;
    }
  }
  
  public boolean cn()
  {
    int j = bI();
    if ((bG() == 0) && ((j == 11) || (j == 12) || (j == 13))) {
      return false;
    }
    return super.cn();
  }
  
  public void cqt()
  {
    super.cqt();
    if ((ahav.a(this.mAppInterface, this.c, true)) && (ahav.b(this.mAppInterface, this.c, true))) {
      this.mAppInterface.a().dhn();
    }
  }
  
  public void djr()
  {
    super.djr();
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (bG() == 1)
    {
      if (bH() == 3000) {
        this.mAppInterface.a().a(new agjx(this.mAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.mAppInterface.a().a(new aglj(this.mAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
  }
  
  public Intent f()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (localFileManagerEntity == null) {
      return null;
    }
    return ahbr.a(this.mAppInterface, this.mContext, localFileManagerEntity);
  }
  
  public void iC()
  {
    if ((ahav.a(this.mAppInterface, this.c, true)) && (ahav.b(this.mAppInterface, this.c, true)))
    {
      long l = V();
      if (bG() == 2) {
        l = ahav.N(getFileSize());
      }
      this.mAppInterface.a().aq(l, this.c.b().WeiYunFileId);
    }
    super.iC();
  }
  
  protected void ix()
  {
    if (this.i != null) {}
    do
    {
      return;
      this.i = new agth.a(null);
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().addObserver(this.i);
    } while ((!aqhq.fileExistsAndNotEmpty(getFilePath())) || (this.aab != 0L) || (getFileType() == 0));
    a(this.c, 4);
  }
  
  protected void removeObserver()
  {
    if (this.i != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.i);
      this.i = null;
    }
    if (this.c.b() == null) {}
  }
  
  public String vM()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public String vN()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String vO()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String vP()
  {
    if (getFileType() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.c.b();
      if (localFileManagerEntity != null) {
        return localFileManagerEntity.yybApkIconUrl;
      }
    }
    return "";
  }
  
  public class a
    extends aghq
  {
    private a() {}
    
    protected void Q(long paramLong1, long paramLong2)
    {
      super.Q(paramLong1, paramLong2);
      if ((paramLong1 == agth.this.c.fR()) && (agth.this.e != null)) {
        agth.this.e.ir();
      }
    }
    
    protected void a(agnk paramagnk)
    {
      if ((TextUtils.isEmpty(paramagnk.fileId)) || (TextUtils.isEmpty(paramagnk.filePath))) {
        if (QLog.isColorLevel()) {
          QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramagnk.fileId + " [path] = " + paramagnk.filePath);
        }
      }
      while (agth.this.jdField_a_of_type_Aguk$c == null) {
        return;
      }
      agth.this.jdField_a_of_type_Aguk$c.fP(paramagnk.fileId, paramagnk.filePath);
    }
    
    protected void a(Integer paramInteger, long paramLong, String paramString)
    {
      ahav.n(paramLong, paramInteger.intValue(), paramString);
    }
    
    protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
    {
      if (!paramBoolean) {}
      do
      {
        do
        {
          do
          {
            return;
            paramInt = agth.this.getFileType();
            if (paramInt != 4) {
              break;
            }
          } while (agth.this.jdField_a_of_type_Aguk$c == null);
          agth.this.jdField_a_of_type_Aguk$c.fP(String.valueOf(paramLong), paramString2);
          return;
          if (paramInt != 0) {
            break;
          }
        } while ((agth.this.V() != paramLong) || (agth.this.jdField_a_of_type_Aguk$c == null));
        agth.this.jdField_a_of_type_Aguk$c.fP(String.valueOf(paramLong), paramString2);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
    }
    
    protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
    {
      if (!paramBoolean) {
        ahav.n(paramLong3, paramInt, paramString1);
      }
    }
    
    protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      if (paramLong2 != agth.this.c.fR()) {}
      do
      {
        return;
        paramString = agth.this.c.b();
      } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (agth.this.jdField_a_of_type_Aguk$d == null));
      agth.this.jdField_a_of_type_Aguk$d.aO(paramString.fProgress);
    }
    
    protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
      }
      awrl.u(agth.this.mContext, paramInt2);
      if (paramLong2 != agth.this.c.fR()) {}
      while (agth.this.jdField_a_of_type_Aguk$d == null) {
        return;
      }
      if (!paramBoolean)
      {
        agth.a(agth.this, paramLong2, paramInt2, paramString2);
        ahav.n(paramLong2, paramInt2, paramString2);
        agth.this.jdField_a_of_type_Aguk$d.djH();
        return;
      }
      if (agth.this.getFileType() == 2) {
        new Handler().postDelayed(new C2CFileModel.C2CFileObserver.1(this), 1000L);
      }
      for (;;)
      {
        agth.this.a(agth.this.c, 4);
        return;
        agth.this.jdField_a_of_type_Aguk$d.djG();
      }
    }
    
    protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
    {
      if (paramLong != agth.this.c.b().nSessionId) {}
      while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
        return;
      }
      ahav.JI(paramString2);
    }
    
    protected void bJl() {}
    
    protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      if (paramLong2 != agth.this.c.fR()) {}
      while (agth.this.jdField_a_of_type_Aguk$d == null) {
        return;
      }
      agth.this.jdField_a_of_type_Aguk$d.djE();
    }
    
    protected void cq(int paramInt, String paramString)
    {
      ahav.JI(paramString);
    }
    
    protected void e(int paramInt, long paramLong, String paramString)
    {
      awrl.u(agth.this.mContext, paramInt);
      if (paramLong != agth.this.c.b().nSessionId) {
        return;
      }
      ahav.n(paramLong, paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agth
 * JD-Core Version:    0.7.0.1
 */