import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.app.FileManagerEngine.1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;

public class atso
{
  atso.a jdField_a_of_type_Atso$a = null;
  private attb jdField_a_of_type_Attb;
  private attd jdField_a_of_type_Attd;
  private atuf jdField_a_of_type_Atuf;
  private atuq jdField_a_of_type_Atuq;
  atuw jdField_a_of_type_Atuw;
  public QQAppInterface app = null;
  SparseArray<atsk> dS;
  SparseArray<atsk> dT;
  
  public atso(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if (this.jdField_a_of_type_Atuw == null) {
      a();
    }
    audx.dkT();
    if (this.jdField_a_of_type_Atso$a == null) {
      this.jdField_a_of_type_Atso$a = new atso.a(null);
    }
    try
    {
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("android.intent.action.MEDIA_MOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_EJECT");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_REMOVED");
      paramQQAppInterface.addDataScheme("file");
      BaseApplicationImpl.sApplication.registerReceiver(this.jdField_a_of_type_Atso$a, paramQQAppInterface);
      return;
    }
    catch (Throwable paramQQAppInterface) {}
  }
  
  private void jl(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong);
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "queryFileManagerEntity is fail!,check sessionID[" + String.valueOf(paramLong) + "]");
      }
    }
    do
    {
      do
      {
        return;
        switch (localFileManagerEntity.nOpType)
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow operation type!");
      return;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        localFileManagerEntity.setCloudType(1);
        this.app.a().u(localFileManagerEntity);
      }
      this.app.a().y(localFileManagerEntity);
      return;
      a().a(localFileManagerEntity, localFileManagerEntity.peerType, true);
      return;
      j(localFileManagerEntity);
      return;
      k(localFileManagerEntity);
      return;
      a(localFileManagerEntity, localFileManagerEntity.nOpType);
      return;
      if (localFileManagerEntity.getCloudType() == 0)
      {
        if (localFileManagerEntity.bDelInFM == true)
        {
          localFileManagerEntity.bDelInFM = false;
          this.app.a().t(localFileManagerEntity);
          this.app.a().b(true, 3, null);
        }
        this.app.a().jt(paramLong);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileManagerEngine<FileAssistant>", 2, "err cloud type.when reTry :" + localFileManagerEntity.getCloudType());
    return;
    TroopFileTransferManager.a(this.app, localFileManagerEntity.TroopUin).a(localFileManagerEntity.forwardTroopFileEntrance, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.peerType, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, true, paramLong, audx.a(this.app));
    return;
    if (localFileManagerEntity.peerUin.equals(acbn.bkx)) {}
    for (int i = 1;; i = 0)
    {
      this.app.a().a(3, localFileManagerEntity, i);
      return;
    }
  }
  
  private void k(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    audx.jR(paramFileManagerEntity.nSessionId);
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      audx.a(this.app, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    paramFileManagerEntity.setfProgress(0.0F);
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    this.app.a().b(25, paramFileManagerEntity);
  }
  
  public static void m(int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void IY(boolean paramBoolean)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + paramBoolean + "]");
    }
    int i = 0;
    for (;;)
    {
      if (i < atwb.ep().size())
      {
        String str = ((FileInfo)atwb.ep().get(i)).getPath();
        try
        {
          aueh.deleteFile(new File(str));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles local exception:" + localException.toString());
            }
          }
        }
      }
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= atwb.dd().size()) {
        break;
      }
      b((WeiYunFileInfo)atwb.dd().get(i));
      i += 1;
    }
    while (j < atwb.db().size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)atwb.db().get(j);
      audt.G(localFileManagerEntity);
      ca(localFileManagerEntity.nSessionId);
      j += 1;
    }
  }
  
  public void YY(String paramString)
  {
    this.app.a().Zc(paramString);
  }
  
  public void YZ(String paramString)
  {
    this.jdField_a_of_type_Atuw.Ze(paramString);
  }
  
  public atsk a(int paramInt)
  {
    if (this.dS == null) {
      return null;
    }
    return (atsk)this.dS.get(paramInt);
  }
  
  public atuq a()
  {
    if (this.jdField_a_of_type_Atuq == null) {}
    try
    {
      if (this.jdField_a_of_type_Atuq == null)
      {
        QLog.i("FileManagerEngine<FileAssistant>", 1, "getThumbHttpDownloader need new ThumbHttpDownloader, thread id:" + Thread.currentThread().getId());
        this.jdField_a_of_type_Atuq = new atuq(this.app);
      }
      return this.jdField_a_of_type_Atuq;
    }
    finally {}
  }
  
  public atuw a()
  {
    try
    {
      if (this.jdField_a_of_type_Atuw == null) {
        this.jdField_a_of_type_Atuw = new atuw(this.app);
      }
      atuw localatuw = this.jdField_a_of_type_Atuw;
      return localatuw;
    }
    finally {}
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = a().b(paramFileManagerEntity, paramString);
    if (paramFileManagerEntity.peerType == 3000)
    {
      a(paramString, 20);
      return paramString;
    }
    k(paramString);
    return paramString;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      audx.ti();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = audx.d().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = audx.getFileName(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    localFileManagerEntity.uniseq = anbi.d(-1000).uniseq;
    localFileManagerEntity.nOpType = 26;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerNick = audx.a(this.app, paramString, null, paramInt);
    if ((paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1)) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.app.getCurrentUin())
    {
      localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
      localFileManagerEntity.setCloudType(paramFileManagerEntity.cloudType);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = audx.bA();
      localFileManagerEntity.msgUid = audx.ge();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + audx.d(localFileManagerEntity));
      }
      this.app.a().v(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      audx.ti();
      return null;
    }
    String str = aoon.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = audx.d().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = audx.getFileName(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    long l = anbi.d(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = audx.a(this.app, paramString2, null, paramInt);
    localFileManagerEntity.selfUin = paramString1;
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = audx.bA();
    localFileManagerEntity.msgUid = audx.ge();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + audx.d(localFileManagerEntity));
    }
    audx.a(this.app, paramString1, paramString2, localFileManagerEntity);
    if (paramBoolean)
    {
      this.app.a().jo(paramFileManagerEntity.nSessionId);
      this.app.a().s(localFileManagerEntity);
      this.app.a().a(paramString2, paramString1, true, localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, true, paramInt, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, anaz.gQ());
    }
    for (;;)
    {
      return localFileManagerEntity;
      this.app.a().v(localFileManagerEntity);
    }
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    if (this.app.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why FileManagerRSCenter is null???");
      }
      paramString1 = null;
      return paramString1;
    }
    String str2 = aoon.a(paramString1, 0L, 0, true);
    String str1 = audx.getFileName(paramString1);
    long l = -1L;
    int i;
    label57:
    int j;
    label65:
    FileManagerEntity localFileManagerEntity;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label423;
      }
      j = 3;
      if (paramBoolean) {
        l = anbi.d(-1000).uniseq;
      }
      localFileManagerEntity = this.app.a().b(l, paramString3, paramInt);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = audx.getFileSizes(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = audx.a(this.app, paramString3, null, paramInt);
      localFileManagerEntity.setFilePath(paramString1);
      localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = audx.fM(paramString1);
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = audx.bA();
      localFileManagerEntity.msgUid = audx.ge();
      localFileManagerEntity.strThumbPath = audx.h(paramString1, 150, 150);
      audx.a(this.app, paramString2, paramString3, localFileManagerEntity);
      this.app.a().s(localFileManagerEntity);
      str1 = this.app.getAccount();
      if ((paramInt != 1004) && (paramInt != 1000)) {
        break label429;
      }
      str1 = paramString2;
    }
    for (;;)
    {
      paramString2 = new FileManagerEngine.1(this, localFileManagerEntity, paramBoolean, paramString3, str1, paramString1, paramInt, str2, j, l);
      if (localFileManagerEntity.nFileType != 5) {
        break label455;
      }
      paramString1 = localFileManagerEntity;
      if (audt.a(localFileManagerEntity.getFilePath(), new atsp(this, localFileManagerEntity, paramString2))) {
        break;
      }
      audx.a.getExecutor().execute(paramString2);
      return localFileManagerEntity;
      i = 6;
      break label57;
      label423:
      j = 2;
      break label65;
      label429:
      if (paramInt == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString2;
        localFileManagerEntity.tmpSessionToPhone = paramString3;
        str1 = paramString2;
      }
    }
    label455:
    audx.a.getExecutor().execute(paramString2);
    return localFileManagerEntity;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Atuf == null) {}
    try
    {
      if (this.jdField_a_of_type_Atuf == null) {
        this.jdField_a_of_type_Atuf = new atuf(this.app);
      }
      return this.jdField_a_of_type_Atuf.b(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_Attb == null) {}
    try
    {
      if (this.jdField_a_of_type_Attb == null) {
        this.jdField_a_of_type_Attb = new attb(this.app);
      }
      return this.jdField_a_of_type_Attb.b(paramFileManagerEntity, paramInt);
    }
    finally {}
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().d(paramString1, paramString2, paramInt, paramObject);
  }
  
  public void a(int paramInt, atsk paramatsk)
  {
    if (this.dT == null) {
      this.dT = new SparseArray();
    }
    atsk localatsk = (atsk)this.dT.get(paramInt);
    if (localatsk != null)
    {
      localatsk.a(paramatsk);
      return;
    }
    this.dT.put(paramInt, paramatsk);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.app.a().b(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.nOpType = paramInt;
    QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nOperationType[" + paramInt + "]");
    audx.jR(paramFileManagerEntity.nSessionId);
    if ((paramInt != 27) && (!aqiw.isNetSupport(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      audx.a(this.app, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "]");
    paramFileManagerEntity.bSend = true;
    paramFileManagerEntity.setfProgress(0.0F);
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = paramInt;
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.selfUin.equalsIgnoreCase(this.app.getCurrentAccountUin()))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt + "] error");
      if (QLog.isDevelopLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "多人聊天转发，selfUin不能为自己！！！");
        throw new NullPointerException("多人聊天转发，selfUin不能为自己！！！");
        this.app.a().b(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.fileSize, paramFileManagerEntity.selfUin, paramFileManagerEntity.fileName, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5);
        return;
        i = 3;
        continue;
        i = 25;
        continue;
        Object localObject;
        if ((TextUtils.isEmpty(paramFileManagerEntity.strTroopFileUuid)) || (paramFileManagerEntity.mContext == null))
        {
          localObject = audx.b(this.app);
          paramFileManagerEntity.strTroopFileUuid = ((ahbm)localObject).a(this.app.getCurrentAccountUin(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId);
          paramFileManagerEntity.mContext = localObject;
        }
        if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
          paramFileManagerEntity.busId = 102;
        }
        j = paramFileManagerEntity.busId;
        i = j;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          i = j;
          if ((paramFileManagerEntity.mContext instanceof ahbm))
          {
            localObject = BaseApplicationImpl.getContext().getString(2131696348);
            ((ahbm)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, 9004, (String)localObject, String.valueOf(paramFileManagerEntity.peerUin), "");
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "ForwardDisc2X" + audx.d(paramFileManagerEntity));
    }
    this.app.a().e(paramFileManagerEntity, i);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt);
    audx.jR(paramFileManagerEntity.nSessionId);
    audx.a(this.app, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt, false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Activity paramActivity)
  {
    String str2 = BaseApplicationImpl.getContext().getString(2131720968);
    String str1 = "";
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt1 == 1)
    {
      str1 = aull.Az();
      if (TextUtils.isEmpty(str1)) {
        break label163;
      }
    }
    for (;;)
    {
      label45:
      if (paramInt2 == 6000)
      {
        paramString2 = (acde)localQQAppInterface.getBusinessHandler(8);
        if (paramString2 != null) {
          paramString2.a(paramString1, 0);
        }
        return;
        if (paramInt1 != 2) {
          continue;
        }
        str1 = aull.AA();
        if (TextUtils.isEmpty(str1)) {
          break label155;
        }
      }
      for (;;)
      {
        str2 = BaseApplicationImpl.getContext().getString(2131720969);
        break label45;
        paramActivity = new aujz(paramActivity, localQQAppInterface);
        paramActivity.g(paramString1, paramString2, str2, str1, paramInt1);
        paramString1 = paramActivity.d();
        if (paramString1 == null) {
          break;
        }
        aqmf.a(localQQAppInterface, paramString3, paramInt2, paramString1, null);
        return;
        label155:
        str1 = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
      }
      label163:
      str1 = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
    }
  }
  
  public boolean a(int paramInt1, FileManagerEntity paramFileManagerEntity, int paramInt2)
  {
    Object localObject;
    if (0L == paramFileManagerEntity.datalineEntitySessionId)
    {
      localObject = audx.a(this.app, paramInt2);
      paramFileManagerEntity.datalineEntitySessionId = ((ahbm)localObject).a(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.selfUin, paramInt1, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.fileSize, 0);
      paramFileManagerEntity.mContext = localObject;
    }
    while (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131696348);
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      if ((paramFileManagerEntity.mContext instanceof ahbm)) {
        ((ahbm)paramFileManagerEntity.mContext).b(false, paramFileManagerEntity.datalineEntitySessionId, 9004, (String)localObject, null, null, null);
      }
      return false;
      if (paramFileManagerEntity.mContext == null) {
        paramFileManagerEntity.mContext = audx.a(this.app, paramInt2);
      }
    }
    this.app.a().a(38, paramInt1, paramFileManagerEntity);
    return true;
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().c(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + audx.d(localFileManagerEntity) + " ]");
    }
    if (5 != localFileManagerEntity.cloudType) {
      audx.I(localFileManagerEntity);
    }
    if ((localFileManagerEntity.getCloudType() == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
      }
      audx.jR(localFileManagerEntity.nSessionId);
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        a(localFileManagerEntity, this.app.getCurrentAccountUin(), paramString2, paramInt);
      }
    }
    for (;;)
    {
      return false;
      b(localFileManagerEntity, paramString1, paramString2, paramInt);
      continue;
      if ((localFileManagerEntity.getCloudType() == 1) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + audx.kZ(paramString1) + "], recvUin[" + audx.kZ(paramString2) + "], peerType[" + paramInt + "], toOffline[" + paramBoolean + "]");
        }
        Object localObject = this.app.getAccount();
        if ((paramInt == 1004) || (paramInt == 1000)) {
          localObject = paramString1;
        }
        while (paramInt == 1)
        {
          ao(paramLong, paramString2);
          return false;
          if (paramInt == 1006) {
            localObject = paramString1;
          }
        }
        localObject = a(localFileManagerEntity, (String)localObject, paramString2, paramInt, true);
        audx.jR(((FileManagerEntity)localObject).nSessionId);
        audx.a(this.app, paramString1, paramString2, (FileManagerEntity)localObject);
        ((FileManagerEntity)localObject).peerType = localFileManagerEntity.peerType;
        if (localFileManagerEntity.peerType == 3000)
        {
          ((FileManagerEntity)localObject).selfUin = localFileManagerEntity.peerUin;
          if (paramInt == 3000) {
            this.app.a().a((FileManagerEntity)localObject, 22);
          } else {
            this.app.a().a((FileManagerEntity)localObject, 21);
          }
        }
        else
        {
          if (paramInt == 3000) {
            ((FileManagerEntity)localObject).nOpType = 28;
          }
          j((FileManagerEntity)localObject);
        }
      }
      else if (localFileManagerEntity.getCloudType() == 9)
      {
        this.app.a().d(localFileManagerEntity, paramString1, paramString2, paramInt, 0);
      }
      else if (localFileManagerEntity.getFilePath() != null)
      {
        if (paramInt == 1) {
          aV(localFileManagerEntity.getFilePath(), paramString2);
        } else {
          return a(localFileManagerEntity.getFilePath(), paramString1, paramString2, paramInt, paramBoolean) != null;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void aIH()
  {
    this.app.a().aIH();
  }
  
  public boolean aV(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = TroopFileTransferManager.a(this.app, Long.parseLong(paramString2));
    int k;
    File localFile;
    if (localObject != null)
    {
      k = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, k);
      localFile = new File(paramString1);
      if (audx.fM(paramString1) != 0) {
        break label175;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      auef.d(paramString1, localOptions);
      int m = aoop.eI(paramString1);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if ((m == 90) || (m == 270))
      {
        i = localOptions.outHeight;
        j = localOptions.outWidth;
      }
      apsv.a(this.app, paramString2, localFile.getName(), localFile.length(), ((apcy)localObject).Id.toString(), k, null, 0L, i, j);
    }
    for (;;)
    {
      return true;
      label175:
      if (audx.fM(paramString1) == 2)
      {
        paramString1 = ShortVideoUtils.n(paramString1);
        apsv.a(this.app, paramString2, localFile.getName(), localFile.length(), ((apcy)localObject).Id.toString(), k, null, 0L, paramString1[0], paramString1[1], paramString1[2]);
      }
      else
      {
        apsv.a(this.app, paramString2, localFile.getName(), localFile.length(), ((apcy)localObject).Id.toString(), k, null, 0L);
      }
    }
  }
  
  public void ae(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "sendAllSelectedFiles, strSendUin[" + audx.kZ(paramString1) + "], recvUin[" + audx.kZ(paramString2) + "], peerType[" + paramInt + "]");
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("last_select_send", true);
        ((SharedPreferences.Editor)localObject).commit();
        if ((atwb.dd().size() == 0) && (atwb.dc().size() == 0))
        {
          localObject = atwb.ep();
          ArrayList localArrayList = atwb.db();
          Iterator localIterator = ((ArrayList)localObject).iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            if (!aueh.fileExistsAndNotEmpty(((FileInfo)localIterator.next()).getPath())) {
              i += 1;
            }
          }
          else
          {
            localIterator = localArrayList.iterator();
            if (localIterator.hasNext())
            {
              if (((FileManagerEntity)localIterator.next()).status == 16)
              {
                i += 1;
                continue;
              }
            }
            else
            {
              if (i != ((ArrayList)localObject).size() + localArrayList.size()) {
                continue;
              }
              auds.OS(2131694128);
              return;
              if (i >= atwb.dd().size()) {
                continue;
              }
              localObject = (WeiYunFileInfo)atwb.dd().get(i);
              audw.JH("0X8005415");
              localObject = audx.b((WeiYunFileInfo)localObject);
              b((FileManagerEntity)localObject, paramString1, paramString2, paramInt);
              m(((FileManagerEntity)localObject).nFileType, this.app);
              i += 1;
              continue;
              if (i >= atwb.dc().size()) {
                continue;
              }
              localObject = (OfflineFileInfo)atwb.dc().get(i);
              localObject = this.app.a().a(audx.a((OfflineFileInfo)localObject, paramInt), paramString1, paramString2, paramInt, true);
              ((FileManagerEntity)localObject).peerType = paramInt;
              ((FileManagerEntity)localObject).status = 2;
              if (paramInt == 3000) {
                ((FileManagerEntity)localObject).nOpType = 28;
              }
              j((FileManagerEntity)localObject);
              m(((FileManagerEntity)localObject).nFileType, this.app);
              i += 1;
              continue;
              if (i >= atwb.db().size()) {
                break label839;
              }
              localObject = (FileManagerEntity)atwb.db().get(i);
              if (((FileManagerEntity)localObject).sendCloudUnsuccessful()) {
                continue;
              }
              audt.G((FileManagerEntity)localObject);
              audw.JH("0X8005413");
              a(((FileManagerEntity)localObject).nSessionId, paramString1, paramString2, paramInt, true);
              m(((FileManagerEntity)localObject).nFileType, this.app);
              continue;
              if (i < atwb.ep().size())
              {
                localObject = ((FileInfo)atwb.ep().get(i)).getPath();
                audw.JH("0X8005414");
                m(((FileInfo)atwb.ep().get(i)).getType(), this.app);
                if (paramInt == 1)
                {
                  aV((String)localObject, paramString2);
                  break label845;
                }
                a((String)localObject, paramString1, paramString2, paramInt, true).strApkPackageName = ((FileInfo)atwb.ep().get(i)).getApkPackeageName();
                break label845;
              }
              int j;
              if (paramInt == 1)
              {
                if (atwb.dd().size() <= 0) {
                  continue;
                }
                i = 1;
                j = i;
                if (atwb.ep().size() > 0) {
                  j = i + 10;
                }
                if (atwb.db().size() > 0)
                {
                  i = j + 100;
                  anot.a(this.app, "P_CliOper", "Grp_files", "", "oper", "Clk_send", 0, 0, paramString2, String.format("%03d", new Object[] { Integer.valueOf(i) }), "", "");
                }
              }
              else
              {
                i = audx.dc(this.app.getCurrentAccountUin());
                if ((paramInt != 0) || (i >= 3) || (!audx.ba(this.app.getCurrentAccountUin(), paramString2))) {
                  continue;
                }
                audx.L(this.app.getCurrentAccountUin(), paramString2, false);
                paramString1 = BaseApplicationImpl.getContext().getString(2131700475);
                this.app.a().a(paramString2, this.app.getCurrentAccountUin(), paramInt, -3009, paramString1);
                audx.eI(this.app.getCurrentAccountUin(), i + 1);
                return;
              }
              i = j;
              continue;
              i = 0;
              continue;
            }
            continue;
          }
          continue;
          continue;
          return;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i += 1;
        continue;
        i = 0;
      }
      catch (Exception paramString1)
      {
        return;
      }
      label839:
      continue;
      label845:
      i += 1;
    }
  }
  
  public void ao(long paramLong, String paramString)
  {
    i(3, paramLong, paramString);
  }
  
  public String b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Attd == null) {}
    try
    {
      if (this.jdField_a_of_type_Attd == null) {
        this.jdField_a_of_type_Attd = new attd(this.app);
      }
      return this.jdField_a_of_type_Attd.b(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.nFileType == 0)
    {
      a(paramFileManagerEntity, paramInt);
      return;
    }
    if (paramFileManagerEntity.peerType == 3000)
    {
      b(paramFileManagerEntity);
      return;
    }
    a(paramFileManagerEntity);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1)
    {
      a().f(paramFileManagerEntity, paramString2);
      return;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = this.app.getCurrentAccountUin();
    }
    a(paramFileManagerEntity, str, paramString2, paramInt);
  }
  
  public void b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    a().b(paramWeiYunFileInfo);
  }
  
  public boolean bZ(long paramLong)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "sessionid[" + String.valueOf(paramLong) + "] call Pause");
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "sessionid[" + String.valueOf(paramLong) + "] item is not exist");
      }
      return false;
    }
    if ((localFileManagerEntity.getCloudType() == 0) && (1 != localFileManagerEntity.nOpType))
    {
      this.app.a().js(paramLong);
      return true;
    }
    audw.b localb;
    if (1 == localFileManagerEntity.nOpType)
    {
      localb = new audw.b();
      localb.bJE = "recv_file_cancel";
      audw.a(this.app.getCurrentAccountUin(), localb);
    }
    while ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq == -1L))
    {
      return this.app.a().cc(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        localb = new audw.b();
        localb.bJE = "send_file_cancel";
        audw.a(this.app.getCurrentAccountUin(), localb);
      }
    }
    return this.app.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.uniseq, localFileManagerEntity.peerType);
  }
  
  public void bi(int paramInt1, int paramInt2, int paramInt3)
  {
    a().bj(paramInt1, paramInt2, paramInt3);
  }
  
  public String c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    String str = audx.g(paramFileManagerEntity);
    if (aueh.fileExistsAndNotEmpty(str)) {
      return str;
    }
    atuo.a(this.app).q(paramFileManagerEntity.nSessionId, str, paramFileManagerEntity.strServerPath);
    return null;
  }
  
  public void c(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ateh localateh = (ateh)this.app.getBusinessHandler(180);
    paramFileManagerEntity = localateh.b(paramFileManagerEntity, paramString1, paramString2, paramInt1, paramInt2);
    audx.jR(paramFileManagerEntity.nSessionId);
    audx.a(this.app, paramString1, paramString2, paramFileManagerEntity);
    localateh.b(paramFileManagerEntity, paramInt1, false);
  }
  
  public ArrayList<FileManagerEntity> cZ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "saveAllSelectFileToWeiYun");
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    while (i < atwb.dc().size())
    {
      localObject = (OfflineFileInfo)atwb.dc().get(i);
      localArrayList.add(a(audx.a((OfflineFileInfo)localObject, 0), String.valueOf(((OfflineFileInfo)localObject).uFriendUin)));
      i += 1;
    }
    i = 0;
    while (i < atwb.db().size())
    {
      localObject = (FileManagerEntity)atwb.db().get(i);
      if (((FileManagerEntity)localObject).sendCloudUnsuccessful())
      {
        i += 1;
      }
      else
      {
        audt.G((FileManagerEntity)localObject);
        switch (((FileManagerEntity)localObject).getCloudType())
        {
        case 2: 
        default: 
          localObject = null;
        }
        while (localObject != null)
        {
          localArrayList.add(localObject);
          break;
          localObject = a(((FileManagerEntity)localObject).getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
          continue;
          localObject = a((FileManagerEntity)localObject, String.valueOf(((FileManagerEntity)localObject).peerUin));
        }
      }
    }
    i = 0;
    while (i < atwb.ep().size())
    {
      localObject = a(((FileInfo)atwb.ep().get(i)).getPath(), "", this.app.getAccount(), 0, false);
      ((FileManagerEntity)localObject).strApkPackageName = ((FileInfo)atwb.ep().get(i)).getApkPackeageName();
      localArrayList.add(localObject);
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean ca(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delete record fail. entity is null, sessionid: " + paramLong);
      }
      return false;
    }
    boolean bool;
    if (localFileManagerEntity.getCloudType() == 0)
    {
      this.app.a().js(paramLong);
      bool = this.app.a().k(localFileManagerEntity);
      if ((localFileManagerEntity != null) && (localFileManagerEntity.bDelInAio) && (localFileManagerEntity.bDelInFM) && (localFileManagerEntity.getCloudType() == 0)) {
        this.app.a().ju(localFileManagerEntity.nSessionId);
      }
      if ((3000 != localFileManagerEntity.peerType) && (!TextUtils.isEmpty(localFileManagerEntity.Uuid))) {
        n(localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.bSend);
      }
      if (!audx.mI(localFileManagerEntity.getFilePath())) {
        break label283;
      }
      localFileManagerEntity.cloudType = 3;
    }
    for (;;)
    {
      if ((!localFileManagerEntity.bDelInAio) || (!localFileManagerEntity.bDelInFM)) {
        break label293;
      }
      return true;
      if ((this.app.a().cc(paramLong)) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "Pause[" + String.valueOf(paramLong) + "] faild!,status[" + String.valueOf(localFileManagerEntity.status) + "]");
      break;
      label283:
      localFileManagerEntity.status = 16;
    }
    label293:
    this.app.a().u(localFileManagerEntity);
    return bool;
  }
  
  public void d(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      ((ateh)this.app.getBusinessHandler(180)).b(paramFileManagerEntity, paramString2, paramInt2);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      paramString1 = this.app.getCurrentAccountUin();
    }
    for (;;)
    {
      c(paramFileManagerEntity, paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
  }
  
  public void dgm()
  {
    this.app.a().dgm();
  }
  
  public void dgn()
  {
    this.app.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", false).commit();
  }
  
  public void dgo()
  {
    this.app.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", true).commit();
  }
  
  public void euw()
  {
    int k = atwb.dd().size();
    int j = atwb.dc().size();
    atwb.db().size();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + atwb.dd().size() + "], offline[" + atwb.dc().size() + "], recent[" + atwb.db().size() + "], localfile[" + atwb.ep().size() + "]");
    }
    int i = 0;
    FileManagerEntity localFileManagerEntity;
    while (i < k)
    {
      localFileManagerEntity = audx.b((WeiYunFileInfo)atwb.dd().get(i));
      this.app.a().s(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downWeiYunFiles,weiyun[" + i + "]");
      }
      a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 5);
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      localFileManagerEntity = audx.a((OfflineFileInfo)atwb.dc().get(i), 0);
      localFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downOfflineFiles,weiyun[" + i + "]");
      }
      a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 8);
      i += 1;
    }
    i = 0;
    if (i < atwb.db().size())
    {
      localFileManagerEntity = (FileManagerEntity)atwb.db().get(i);
      audt.G(localFileManagerEntity);
      if (localFileManagerEntity.status == 16) {}
      for (;;)
      {
        i += 1;
        break;
        switch (localFileManagerEntity.getCloudType())
        {
        default: 
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "unknow type,Engity:" + audx.d(localFileManagerEntity));
          }
          break;
        case 3: 
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,local[" + i + "] break");
          }
          break;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,offline[" + i + "]");
          }
          if ((localFileManagerEntity.bSend == true) && (localFileManagerEntity.status != 1)) {
            QLog.w("FileManagerEngine<FileAssistant>", 2, "=_= v> downRecentFiles,but Id[" + localFileManagerEntity.nSessionId + "] is sendStatus but no Success! continiu");
          } else {
            a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 8);
          }
          break;
        case 2: 
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,weiyun[" + i + "]");
          }
          a(localFileManagerEntity.nSessionId, localFileManagerEntity.uniseq, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 5);
        }
      }
    }
  }
  
  public void eux()
  {
    if (this.dT == null) {
      return;
    }
    if (this.dS == null) {
      this.dS = new SparseArray();
    }
    int i = 0;
    if (i < this.dT.size())
    {
      int j = this.dT.keyAt(i);
      atsk localatsk1 = (atsk)this.dT.get(j);
      atsk localatsk2 = (atsk)this.dS.get(j);
      if (localatsk2 != null) {
        localatsk2.a(localatsk1);
      }
      for (;;)
      {
        i += 1;
        break;
        this.dS.put(j, localatsk1);
      }
    }
    this.dT.clear();
  }
  
  public void euy()
  {
    if (this.dT != null) {
      this.dT.clear();
    }
  }
  
  public void f(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    a().g(paramString, paramInt1, paramInt2, paramLong);
  }
  
  public void fB(String paramString1, String paramString2)
  {
    this.app.a().jf(paramString1, paramString2);
  }
  
  public void i(int paramInt, long paramLong, String paramString)
  {
    Object localObject = this.app.a().b(paramLong);
    FileManagerEntity localFileManagerEntity = this.app.a().a((FileManagerEntity)localObject, paramString, 1);
    localFileManagerEntity.setfProgress(0.0F);
    try
    {
      localFileManagerEntity.TroopUin = Long.parseLong(paramString);
      localFileManagerEntity.status = 2;
      if (((FileManagerEntity)localObject).peerType == 0)
      {
        localFileManagerEntity.nOpType = 26;
        if ((TextUtils.isEmpty(localFileManagerEntity.strTroopFileUuid)) || (localFileManagerEntity.mContext == null))
        {
          ahbm localahbm = audx.b(this.app);
          localFileManagerEntity.strTroopFileUuid = localahbm.a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject).peerType, paramString, ((FileManagerEntity)localObject).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId);
          localFileManagerEntity.mContext = localahbm;
        }
        if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
          localFileManagerEntity.busId = 102;
        }
        if (aqiw.isNetSupport(BaseApplication.getContext())) {
          break label369;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131696348);
        localFileManagerEntity.status = 0;
        this.app.a().b(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
        if ((localFileManagerEntity.mContext instanceof ahbm)) {
          ((ahbm)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong, 9004, (String)localObject, paramString, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerEngine<FileAssistant>", 2, audx.ti());
          continue;
          if (((FileManagerEntity)localObject).peerType == 3000) {
            localFileManagerEntity.nOpType = 27;
          } else if (((FileManagerEntity)localObject).peerType == 6000) {
            localFileManagerEntity.nOpType = 32;
          }
        }
      }
      label369:
      this.app.a().a(102, paramInt, localFileManagerEntity);
    }
  }
  
  public void j(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    audx.jR(paramFileManagerEntity.nSessionId);
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      audx.a(this.app, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], opYype[" + paramFileManagerEntity.nOpType + "]");
    aizg localaizg = (aizg)this.app.getManager(16);
    if ((localaizg != null) && (localaizg.nf(paramFileManagerEntity.peerUin)))
    {
      audx.JI("该好友已被屏蔽！请先解除屏蔽！");
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      this.app.a().u(paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity.setfProgress(0.0F);
    paramFileManagerEntity.status = 2;
    if (paramFileManagerEntity.nOpType == 28)
    {
      this.app.a().b(106, paramFileManagerEntity);
      return;
    }
    this.app.a().j(paramFileManagerEntity);
  }
  
  public void jk(long paramLong)
  {
    jl(paramLong);
  }
  
  public void l(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "ReviceFile,entity is null!");
      }
      return;
    }
    switch (paramFileManagerEntity.getCloudType())
    {
    }
    for (;;)
    {
      dgo();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, but entity is localFile");
      return;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_OFFLINE ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 1);
      continue;
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_WEIYUN ,peerType[" + paramFileManagerEntity.peerType + "]");
      }
      this.app.a().s(paramFileManagerEntity);
      if (paramFileManagerEntity.nOpType == 50) {
        a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 50);
      } else {
        a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 5);
      }
    }
  }
  
  public void n(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + audx.kZ(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.app.a().o(paramString1, paramString3, paramString2, paramBoolean);
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "!!!extCard changed[" + paramIntent.getAction() + "]!!!");
      paramContext = paramIntent.getAction();
      if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_UNMOUNTABLE")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_EJECT")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED"))) {
        audn.a().remove("externalSdCard");
      }
      try
      {
        atso.this.app.a().Jh(true);
        label96:
        if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_MOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_SCANNER_STARTED"))) {
          audn.a().dkR();
        }
        atso.this.app.a().b(true, 3, null);
        return;
      }
      catch (Exception paramIntent)
      {
        break label96;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atso
 * JD-Core Version:    0.7.0.1
 */