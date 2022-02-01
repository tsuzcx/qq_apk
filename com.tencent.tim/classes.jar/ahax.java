import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class ahax
  implements ahbm
{
  ahax(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong, paramInt3, 0L, 0);
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong1, int paramInt3, long paramLong2, int paramInt4)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.fileUuid = paramString3;
    if (paramString2 != null) {
      localDataLineMsgRecord.uOwnerUin = Long.valueOf(paramString2).longValue();
    }
    localDataLineMsgRecord.selfuin = paramString1;
    localDataLineMsgRecord.filename = paramString4;
    if (paramString5 != null)
    {
      localDataLineMsgRecord.thumbPath = ahbj.ba(ahbj.aC(this.val$app.getApplication()), ahav.getFileName(paramString5));
      aqhq.copyFile(paramString5, localDataLineMsgRecord.thumbPath);
    }
    localDataLineMsgRecord.filesize = paramLong1;
    localDataLineMsgRecord.busId = paramInt2;
    localDataLineMsgRecord.forwardTroopFileEntrance = paramInt3;
    if (paramInt1 == 0) {
      localDataLineMsgRecord.fileFrom = 1;
    }
    for (localDataLineMsgRecord.nOpType = 29;; localDataLineMsgRecord.nOpType = 31)
    {
      localDataLineMsgRecord.istroop = paramInt1;
      paramString1 = (acde)this.val$app.getBusinessHandler(8);
      localDataLineMsgRecord.sessionid = paramString1.a(0, this.cuS).longValue();
      localDataLineMsgRecord.msg = "";
      localDataLineMsgRecord.issend = 1;
      localDataLineMsgRecord.isread = true;
      localDataLineMsgRecord.issuc = false;
      ((acle)this.val$app.getBusinessHandler(13)).W(localDataLineMsgRecord);
      localDataLineMsgRecord.time = anaz.gQ();
      localDataLineMsgRecord.progress = 0.2F;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      localDataLineMsgRecord.msgtype = acde.gu(0);
      localDataLineMsgRecord.bIsTransfering = true;
      this.val$app.b().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
      paramString1.e(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)acde.gv(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
      return localDataLineMsgRecord.sessionid;
      localDataLineMsgRecord.fileFrom = 2;
    }
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    return null;
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt3)
  {
    return null;
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "getDatalineProcessCallBack->onResult bSuccess[" + paramBoolean + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString1 + "],uuid[" + paramString2 + "],troopUin[" + paramString3 + "],strNewPath[" + paramString4 + "]");
    }
    if (paramInt != 0)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        ahao.JF(BaseApplicationImpl.getContext().getString(2131693824));
        paramBoolean = false;
      }
    }
    else
    {
      paramString1 = (acde)this.val$app.getBusinessHandler(8);
      if (paramBoolean) {
        break label159;
      }
      paramString1.OnSessionComplete(paramLong, 41, paramInt);
    }
    label159:
    do
    {
      do
      {
        return;
        ahao.JF(paramString1);
        break;
        if (TextUtils.isEmpty(paramString4))
        {
          paramString1.OnSessionComplete(paramLong, 0, paramInt);
          return;
        }
        paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong);
        paramString2 = this.val$app.b().a(paramInt).a(paramLong);
      } while (paramString2 == null);
      paramString2.serverPath = paramString4;
      paramString2.nOpType = 1;
      paramString2.bIsSended = true;
      paramString2.bIsTransfering = false;
      if (paramString2.entityID != 0L)
      {
        paramString3 = this.val$app.a().b(paramString2.entityID);
        if (paramString3 != null)
        {
          paramString3.status = 1;
          paramString3.Uuid = paramString2.serverPath;
        }
      }
    } while (!paramString1.c(paramString2));
    paramString1.e(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahax
 * JD-Core Version:    0.7.0.1
 */