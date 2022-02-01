import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agtm
  extends agts
{
  private acdl d;
  
  public agtm(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
    }
    V(paramList, paramInt);
  }
  
  private void djs()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    acde localacde = (acde)this.mAppInterface.getBusinessHandler(8);
    int i = DataLineMsgRecord.getDevTypeBySeId(this.c.b().uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.mAppInterface.b().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localacde.F(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label187;
        }
        cu.d(this.mAppInterface);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localacde.af(localArrayList)) {
        break;
      }
      localFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      if (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0) {
        localDataLineMsgRecord.progress = 0.0F;
      }
      this.mAppInterface.b().a(i).ig(localDataLineMsgRecord.msgId);
      return;
      label187:
      cu.e(this.mAppInterface);
    }
    ahao.OS(2131695433);
  }
  
  private void djt()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    acde localacde;
    DataLineMsgRecord localDataLineMsgRecord;
    if ((localFileManagerEntity.getCloudType() == 6) && (localFileManagerEntity.peerDin == 0L))
    {
      localacde = (acde)this.mAppInterface.getBusinessHandler(8);
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
      localDataLineMsgRecord = this.mAppInterface.b().a(i).a(localFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DatalineFileModel<FileAssistant>", 2, "datalineFileStopTransfer : dataline record is null");
        }
        return;
      }
      if ((localDataLineMsgRecord.strMoloKey == null) || (!DataLineMsgSet.isSingle(localDataLineMsgRecord))) {
        break label147;
      }
      if (!localDataLineMsgRecord.isReportPause)
      {
        localDataLineMsgRecord.isReportPause = true;
        cu.k(this.mAppInterface);
      }
    }
    for (;;)
    {
      localacde.g(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      localFileManagerEntity.status = 3;
      return;
      label147:
      if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == -2335))
      {
        localDataLineMsgRecord.isReportPause = true;
        cu.m(this.mAppInterface);
      }
    }
  }
  
  private void dju()
  {
    if (!aqiw.isNetSupport(this.mContext)) {
      ahao.OS(2131693819);
    }
    Object localObject;
    acde localacde;
    int i;
    do
    {
      return;
      localObject = this.c.b();
      localacde = (acde)this.e.getApp().getBusinessHandler(8);
      i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.e.getApp().b().a(i).a(((FileManagerEntity)localObject).uniseq);
    } while ((localObject == null) || (bH() != 6000));
    ((DataLineMsgRecord)localObject).bIsResendOrRecvFile = true;
    switch (getFileType())
    {
    default: 
      return;
    case -1: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      if (aqhq.fileExists(getFilePath()))
      {
        localacde.a(getFilePath(), ((DataLineMsgRecord)localObject).thumbPath, 0, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      break;
    case 0: 
      localacde.a(getFilePath(), ((DataLineMsgRecord)localObject).thumbPath, 1, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    case 2: 
      localacde.a(getFilePath(), ((DataLineMsgRecord)localObject).thumbPath, 2, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    }
    if (((DataLineMsgRecord)localObject).nOpType == 35)
    {
      localacde.h((DataLineMsgRecord)localObject);
      return;
    }
    localacde.a().a((DataLineMsgRecord)localObject, i, 2);
  }
  
  public agss a()
  {
    if (this.jdField_a_of_type_Agss == null) {
      this.jdField_a_of_type_Agss = new agtq(this);
    }
    return this.jdField_a_of_type_Agss;
  }
  
  public agsv a()
  {
    if (this.jdField_a_of_type_Agsv == null) {
      this.jdField_a_of_type_Agsv = new agto(this);
    }
    return this.jdField_a_of_type_Agsv;
  }
  
  protected void a(agsd paramagsd, int paramInt)
  {
    if (ahbj.fileExistsAndNotEmpty(paramagsd.getFilePath())) {
      ((ateh)this.mAppInterface.getBusinessHandler(180)).a(paramagsd.getFileName(), paramagsd.getFilePath(), paramagsd.getFileSize(), paramagsd.getFileType(), 4);
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList[] arrayOfArrayList = super.a();
    if (!ahbj.fileExistsAndNotEmpty(getFilePath())) {
      arrayOfArrayList = null;
    }
    return arrayOfArrayList;
  }
  
  public String aC()
  {
    String str2 = super.aC();
    int i = bL();
    String str1;
    if (i == 5) {
      str1 = "";
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return str1;
              if (i == 0) {
                break;
              }
              str1 = str2;
            } while (i != 6);
            str1 = str2;
          } while (this.c == null);
          localFileManagerEntity = this.c.b();
          str1 = str2;
        } while (localFileManagerEntity == null);
        str1 = str2;
      } while (ahav.isLocalFile(localFileManagerEntity.getFilePath()));
      str1 = str2;
    } while (!ahav.o(localFileManagerEntity));
    return "";
  }
  
  public String ax()
  {
    return "biz_src_jc_file";
  }
  
  public aebf b()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    return new agsl(this.e.getApp().b().a(i).a(localFileManagerEntity.uniseq));
  }
  
  public int bE()
  {
    int i = getFileType();
    int j = super.bE();
    if (j != 0) {
      return j;
    }
    switch (i)
    {
    default: 
      return 1;
    }
    return 6;
  }
  
  public int bG()
  {
    if (ahav.mI(getFilePath())) {
      return 3;
    }
    return super.bG();
  }
  
  public int bL()
  {
    int j = super.bL();
    int i;
    if (j != 0)
    {
      i = j;
      if (j != 6) {}
    }
    else
    {
      i = j;
      if (this.c != null)
      {
        FileManagerEntity localFileManagerEntity = this.c.b();
        i = j;
        if (localFileManagerEntity != null)
        {
          i = j;
          if (!ahav.isLocalFile(localFileManagerEntity.getFilePath()))
          {
            i = j;
            if (ahav.o(localFileManagerEntity)) {
              i = 5;
            }
          }
        }
      }
    }
    return i;
  }
  
  public int bM()
  {
    int j = 2;
    int i = getFileType();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        return 0;
      }
      FileManagerEntity localFileManagerEntity = this.c.b();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.uniseq != 0L)) {
        if ((this.e != null) && (this.e.bZ())) {
          i = j;
        }
      }
      for (;;)
      {
        return i;
        if (i != 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public boolean cn()
  {
    if (bI() == 35) {
      return false;
    }
    return super.cn();
  }
  
  public Intent f()
  {
    FileManagerEntity localFileManagerEntity = this.c.b();
    if (localFileManagerEntity == null) {
      return null;
    }
    return ahbr.a(this.mAppInterface, this.mContext, localFileManagerEntity);
  }
  
  protected void ix()
  {
    if (this.d != null) {}
    do
    {
      return;
      this.d = new agtn(this);
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.d);
    } while ((!aqhq.fileExistsAndNotEmpty(getFilePath())) || (this.aab != 0L) || (getFileType() == 0));
    a(this.c, 4);
  }
  
  protected void removeObserver()
  {
    if (this.d != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.d);
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtm
 * JD-Core Version:    0.7.0.1
 */