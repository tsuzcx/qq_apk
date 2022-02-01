import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class ahak
  implements ahbm
{
  private final String TAG = "C2CProcessCallBack<FileAssistant>";
  QQAppInterface app;
  
  public ahak(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong, paramInt3, 0L, 0);
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong1, int paramInt3, long paramLong2, int paramInt4)
  {
    paramString5 = apsf.a(this.app, Long.parseLong(paramString2));
    if (paramString5 != null) {
      paramString5.c(paramString3, paramString4, paramLong1, paramInt2);
    }
    String str = aoon.a("", 0L, 0, true);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString2);
      l1 = l2;
      paramString5 = apsf.a(this.app, l2).a(paramString3);
      l1 = l2;
    }
    catch (Exception paramString5)
    {
      do
      {
        for (;;)
        {
          FileManagerEntity localFileManagerEntity;
          paramString5 = null;
          continue;
          if (paramInt1 != 3000) {
            break;
          }
          localFileManagerEntity.nOpType = 25;
          if (QLog.isColorLevel()) {
            QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + localFileManagerEntity.nSessionId + "],[troopToDisc]");
          }
        }
      } while (!QLog.isDevelopLevel());
      throw new NullPointerException("群同事传递的peerType不对！");
    }
    localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    localFileManagerEntity.fileName = paramString4;
    if ((paramString5 != null) && (ahbj.fileExistsAndNotEmpty(paramString5.coc)))
    {
      paramString4 = new BitmapFactory.Options();
      paramString4.inJustDecodeBounds = true;
      ahbh.d(paramString5.coc, paramString4);
      if ((paramString4.outHeight > 0) && (paramString4.outWidth > 0))
      {
        localFileManagerEntity.imgWidth = paramString4.outWidth;
        localFileManagerEntity.imgHeight = paramString4.outHeight;
      }
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "[" + localFileManagerEntity.nSessionId + "]entity forward from troop no size, get and use thumb size(wh)[" + localFileManagerEntity.imgWidth + ":" + localFileManagerEntity.imgHeight + "]");
      }
    }
    paramString4 = anbi.d(-1000);
    wte.a().i(paramString4.uniseq, paramLong2, paramInt4);
    paramLong2 = paramString4.uniseq;
    localFileManagerEntity.uniseq = paramLong2;
    if (paramInt1 == 0)
    {
      localFileManagerEntity.nOpType = 24;
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->prepareForward nSessionId[" + localFileManagerEntity.nSessionId + "],[troopToOffline]");
      }
      localFileManagerEntity.bSend = true;
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerType = paramInt1;
      localFileManagerEntity.peerUin = paramString1;
      localFileManagerEntity.peerNick = ahav.a(this.app, paramString1, null, paramInt1);
      localFileManagerEntity.selfUin = paramString2;
      localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
      localFileManagerEntity.setCloudType(4);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = ahav.bA();
      localFileManagerEntity.msgUid = ahav.ge();
      localFileManagerEntity.fileSize = paramLong1;
      localFileManagerEntity.TroopUin = l1;
      localFileManagerEntity.busId = paramInt2;
      localFileManagerEntity.strTroopFilePath = paramString3;
      if (paramString5 != null)
      {
        localFileManagerEntity.strTroopFileID = paramString5.Id.toString();
        localFileManagerEntity.lastTime = paramString5.dTh;
      }
      localFileManagerEntity.TroopUin = l1;
      localFileManagerEntity.forwardTroopFileEntrance = paramInt3;
      paramString2 = TroopFileTransferManager.a(l1);
      if (paramString2 != null)
      {
        paramString2 = paramString2.a(paramString3);
        if (paramString2 != null)
        {
          localFileManagerEntity.yybApkPackageName = paramString2.yybApkPackageName;
          localFileManagerEntity.yybApkName = paramString2.yybApkName;
          localFileManagerEntity.yybApkIconUrl = paramString2.yybApkIconUrl;
        }
      }
      paramString2 = this.app.getCurrentAccountUin();
      this.app.a().a(paramString1, paramString2, true, "", paramLong1, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, paramString3, 1, paramLong2, localFileManagerEntity.msgUid, -1L, anaz.gQ());
      this.app.a().s(localFileManagerEntity);
      return localFileManagerEntity.nSessionId;
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
      QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult bSuccess[" + paramBoolean + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString1 + "],uuid[" + paramString2 + "],troopUin[" + paramString3 + "],strNewPath[" + paramString4 + "]");
    }
    FileManagerEntity localFileManagerEntity = this.app.a().c(paramLong);
    if (localFileManagerEntity == null)
    {
      QLog.e("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult,but entity is null SessionId[" + paramLong + "]");
      return;
    }
    label214:
    label232:
    String str;
    if (localFileManagerEntity.nOpType == 24)
    {
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToOffline]");
      }
      if ((paramBoolean) && (TextUtils.isEmpty(paramString4) != true)) {
        break label444;
      }
      localFileManagerEntity.status = 0;
      if (TextUtils.isEmpty(paramString4) == true) {
        QLog.e("C2CProcessCallBack<FileAssistant>", 1, "!!!!!!!！！！new uuid is null!!!!!!!");
      }
      if (paramInt != 0)
      {
        if (TextUtils.isEmpty(paramString1)) {
          break label793;
        }
        ahao.JF(paramString1);
        paramBoolean = false;
      }
      if (localFileManagerEntity.peerType != 0) {
        break label816;
      }
      paramString4 = this.app;
      str = localFileManagerEntity.forwardTroopFileEntrance + "";
      if (paramBoolean != true) {
        break label808;
      }
      paramString2 = "1";
      label283:
      anot.a(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_fri", 0, 0, paramString3, str, paramString2, localFileManagerEntity.peerUin);
      label315:
      paramString2 = this.app.a();
      if (localFileManagerEntity.status != 1) {
        break label908;
      }
    }
    label908:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString2.b(paramBoolean, 46, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Integer.valueOf(paramInt), paramString1 });
      return;
      if (localFileManagerEntity.nOpType == 25)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult [troopToDisc]");
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("C2CProcessCallBack<FileAssistant>", 1, "getC2CProcessCallBack->onResult operation Error![" + localFileManagerEntity.nOpType + "]");
      break;
      label444:
      localFileManagerEntity.status = 1;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.Uuid = paramString4;
      localFileManagerEntity.TroopUin = 0L;
      localFileManagerEntity.strTroopFileID = null;
      localFileManagerEntity.strTroopFilePath = null;
      if (QLog.isColorLevel()) {
        QLog.i("C2CProcessCallBack<FileAssistant>", 1, "onResult bSuccess[true],peerType[" + localFileManagerEntity.peerType + "],peerUin[" + localFileManagerEntity.peerUin + "],uuid[" + localFileManagerEntity.Uuid + "]");
      }
      paramString2 = null;
      if (localFileManagerEntity.peerType == 3000)
      {
        this.app.a().a(localFileManagerEntity, 64, "");
        this.app.a().a(localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, this.app.getCurrentAccountUin(), localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramString4, localFileManagerEntity.uniseq, localFileManagerEntity.msgUid, null);
        if (ahav.getFileType(localFileManagerEntity.fileName) == 0) {
          paramString2 = this.app.a().a(localFileManagerEntity, 5);
        }
      }
      for (;;)
      {
        if (paramString2 == null) {
          break label791;
        }
        localFileManagerEntity.strLargeThumPath = paramString2;
        break;
        if (ahav.getFileType(localFileManagerEntity.fileName) == 2)
        {
          paramString2 = this.app.a().b(localFileManagerEntity);
          continue;
          this.app.a().a(localFileManagerEntity, 63, "");
          this.app.a().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
          if (ahav.getFileType(localFileManagerEntity.fileName) == 0) {
            paramString2 = this.app.a().a(localFileManagerEntity, 5);
          } else if (ahav.getFileType(localFileManagerEntity.fileName) == 2) {
            paramString2 = this.app.a().a(localFileManagerEntity);
          }
        }
      }
      label791:
      break label214;
      label793:
      ahao.JF(BaseApplicationImpl.getContext().getString(2131693824));
      break label232;
      label808:
      paramString2 = "2";
      break label283;
      label816:
      if (localFileManagerEntity.peerType != 3000) {
        break label315;
      }
      paramString4 = this.app;
      str = localFileManagerEntity.forwardTroopFileEntrance + "";
      if (paramBoolean == true) {}
      for (paramString2 = "1";; paramString2 = "2")
      {
        anot.a(paramString4, "P_CliOper", "Grp_files", "", "transfer", "Clk_talk", 0, 0, paramString3, str, paramString2, "");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahak
 * JD-Core Version:    0.7.0.1
 */