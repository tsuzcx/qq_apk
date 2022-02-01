import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atzm
  extends atzs
{
  private acdl d;
  
  public atzm(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
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
    auds.OS(2131695433);
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
          QLog.i("DatalineFileModel", 2, "datalineFileStopTransfer : dataline record is null");
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
      auds.OS(2131693819);
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
    localacde.a().a((DataLineMsgRecord)localObject, i, 2);
  }
  
  public atyz a()
  {
    if (this.jdField_a_of_type_Atyz == null) {
      this.jdField_a_of_type_Atyz = new atzq(this);
    }
    return this.jdField_a_of_type_Atyz;
  }
  
  public atzb a()
  {
    if (this.jdField_a_of_type_Atzb == null) {
      this.jdField_a_of_type_Atzb = new atzo(this);
    }
    return this.jdField_a_of_type_Atzb;
  }
  
  protected void a(agsd paramagsd, int paramInt)
  {
    if (aueh.fileExistsAndNotEmpty(paramagsd.getFilePath())) {
      ((ateh)this.mAppInterface.getBusinessHandler(180)).a(paramagsd.getFileName(), paramagsd.getFilePath(), paramagsd.getFileSize(), paramagsd.getFileType(), 4);
    }
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
    if (audx.mI(getFilePath())) {
      return 3;
    }
    return super.bG();
  }
  
  protected void ix()
  {
    if (this.d == null)
    {
      this.d = new atzn(this);
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.d);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "add datalineObserver");
    }
    if ((aqhq.fileExistsAndNotEmpty(getFilePath())) && (this.aab == 0L) && (getFileType() != 0)) {
      a(this.c, 4);
    }
  }
  
  protected void removeObserver()
  {
    if (this.d != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("DatalineFileModel<FileAssistant>", 1, "remove datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.d);
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzm
 * JD-Core Version:    0.7.0.1
 */