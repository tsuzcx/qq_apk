import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine.1;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;

public class aghw
{
  aghw.a jdField_a_of_type_Aghw$a = null;
  private agia jdField_a_of_type_Agia;
  private agik jdField_a_of_type_Agik;
  private agil jdField_a_of_type_Agil;
  private agir jdField_a_of_type_Agir;
  private agjz jdField_a_of_type_Agjz;
  private agkb jdField_a_of_type_Agkb;
  private agln jdField_a_of_type_Agln;
  aglw jdField_a_of_type_Aglw;
  private agly jdField_a_of_type_Agly;
  agmf jdField_a_of_type_Agmf;
  public QQAppInterface app = null;
  aghr b;
  
  public aghw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if (this.jdField_a_of_type_Agmf == null) {
      a();
    }
    ahav.dkT();
    if (this.jdField_a_of_type_Aghw$a == null) {
      this.jdField_a_of_type_Aghw$a = new aghw.a(null);
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
      BaseApplicationImpl.sApplication.registerReceiver(this.jdField_a_of_type_Aghw$a, paramQQAppInterface);
      return;
    }
    catch (Throwable paramQQAppInterface) {}
  }
  
  private void jl(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong);
    if (localFileManagerEntity == null)
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "queryFileManagerEntity is fail!,check sessionID[" + String.valueOf(paramLong) + "]");
      return;
    }
    switch (localFileManagerEntity.nOpType)
    {
    default: 
      QLog.e("FileManagerEngine<FileAssistant>", 1, "unknow operation type!");
      return;
    case 0: 
    case 1: 
    case 5: 
    case 6: 
    case 8: 
    case 50: 
      if (localFileManagerEntity.getCloudType() == 0)
      {
        localFileManagerEntity.setCloudType(1);
        this.app.a().u(localFileManagerEntity);
      }
      this.app.a().y(localFileManagerEntity);
      return;
    case 3: 
      a().a(localFileManagerEntity, localFileManagerEntity.peerType, true);
      return;
    case 7: 
    case 28: 
      j(localFileManagerEntity);
      return;
    case 4: 
      k(localFileManagerEntity);
      return;
    case 20: 
    case 21: 
    case 22: 
      a(localFileManagerEntity, localFileManagerEntity.nOpType);
      return;
    case 9: 
    case 10: 
    case 13: 
      if (localFileManagerEntity.getCloudType() == 0)
      {
        localFileManagerEntity.bDelInFM = false;
        this.app.a().t(localFileManagerEntity);
        this.app.a().b(true, 3, null);
        this.app.a().jt(paramLong);
        return;
      }
      QLog.e("FileManagerEngine<FileAssistant>", 1, "err cloud type.when reTry :" + localFileManagerEntity.getCloudType());
      return;
    case 24: 
    case 25: 
      TroopFileTransferManager.a(this.app, localFileManagerEntity.TroopUin).a(localFileManagerEntity.forwardTroopFileEntrance, localFileManagerEntity.TroopUin, localFileManagerEntity.busId, Long.valueOf(localFileManagerEntity.peerUin).longValue(), localFileManagerEntity.peerType, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, true, paramLong, ahav.a(this.app));
      return;
    }
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
    ahav.jR(paramFileManagerEntity.nSessionId);
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      ahav.a(this.app, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    awou.eEJ();
    this.app.a().a(25, paramFileManagerEntity);
  }
  
  public void IB(String paramString)
  {
    a().IB(paramString);
  }
  
  public void IY(boolean paramBoolean)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + paramBoolean + "]");
    }
    Object localObject = new ArrayList();
    Iterator localIterator = agmz.D().iterator();
    while (localIterator.hasNext())
    {
      String str = ((FileInfo)localIterator.next()).getPath();
      try
      {
        VFSFile localVFSFile = new VFSFile(str);
        ((List)localObject).add(str);
        localVFSFile.delete();
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles local exception:" + localException.toString());
      }
    }
    if (((List)localObject).size() > 0) {
      MediaScannerConnection.scanFile(BaseApplication.getContext(), (String[])((List)localObject).toArray(new String[0]), null, null);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= agmz.dd().size()) {
        break;
      }
      b((WeiYunFileInfo)agmz.dd().get(i));
      i += 1;
    }
    while (j < agmz.db().size())
    {
      localObject = (FileManagerEntity)agmz.db().get(j);
      ahap.G((FileManagerEntity)localObject);
      ca(((FileManagerEntity)localObject).nSessionId);
      j += 1;
    }
  }
  
  /* Error */
  public aghr a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 428	aghw:b	Laghr;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 430	aghr
    //   15: dup
    //   16: aload_0
    //   17: getfield 31	aghw:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 432	aghr:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 428	aghw:b	Laghr;
    //   26: aload_0
    //   27: getfield 428	aghw:b	Laghr;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aghw
    //   30	6	1	localaghr	aghr
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public agia a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 435	aghw:jdField_a_of_type_Agia	Lagia;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 437	agia
    //   15: dup
    //   16: aload_0
    //   17: getfield 31	aghw:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 438	agia:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 435	aghw:jdField_a_of_type_Agia	Lagia;
    //   26: aload_0
    //   27: getfield 435	aghw:jdField_a_of_type_Agia	Lagia;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aghw
    //   30	6	1	localagia	agia
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public agik a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 441	aghw:jdField_a_of_type_Agik	Lagik;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 443	agik
    //   15: dup
    //   16: aload_0
    //   17: getfield 31	aghw:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 444	agik:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 441	aghw:jdField_a_of_type_Agik	Lagik;
    //   26: aload_0
    //   27: getfield 441	aghw:jdField_a_of_type_Agik	Lagik;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aghw
    //   30	6	1	localagik	agik
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public agil a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 447	aghw:jdField_a_of_type_Agil	Lagil;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 449	agil
    //   15: dup
    //   16: aload_0
    //   17: getfield 31	aghw:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 450	agil:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 447	aghw:jdField_a_of_type_Agil	Lagil;
    //   26: aload_0
    //   27: getfield 447	aghw:jdField_a_of_type_Agil	Lagil;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aghw
    //   30	6	1	localagil	agil
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public agir a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 453	aghw:jdField_a_of_type_Agir	Lagir;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 455	agir
    //   15: dup
    //   16: aload_0
    //   17: getfield 31	aghw:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 456	agir:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 453	aghw:jdField_a_of_type_Agir	Lagir;
    //   26: aload_0
    //   27: getfield 453	aghw:jdField_a_of_type_Agir	Lagir;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	aghw
    //   30	6	1	localagir	agir
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  public aglw a()
  {
    try
    {
      if (this.jdField_a_of_type_Aglw == null) {
        this.jdField_a_of_type_Aglw = new aglw(this.app);
      }
      aglw localaglw = this.jdField_a_of_type_Aglw;
      return localaglw;
    }
    finally {}
  }
  
  public agly a()
  {
    if (this.jdField_a_of_type_Agly == null) {}
    try
    {
      if (this.jdField_a_of_type_Agly == null)
      {
        QLog.i("FileManagerEngine<FileAssistant>", 1, "getThumbHttpDownloader need new ThumbHttpDownloader, thread id:" + Thread.currentThread().getId());
        this.jdField_a_of_type_Agly = new agly(this.app);
      }
      return this.jdField_a_of_type_Agly;
    }
    finally {}
  }
  
  public agmf a()
  {
    try
    {
      if (this.jdField_a_of_type_Agmf == null) {
        this.jdField_a_of_type_Agmf = new agmf(this.app);
      }
      agmf localagmf = this.jdField_a_of_type_Agmf;
      return localagmf;
    }
    finally {}
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    localFileManagerEntity.Uuid = paramFileManagerEntity.Uuid;
    localFileManagerEntity.selfUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.fileName = paramFileManagerEntity.fileName;
    localFileManagerEntity.fileSize = paramFileManagerEntity.fileSize;
    localFileManagerEntity.strThumbPath = paramFileManagerEntity.strThumbPath;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = 29;
    localFileManagerEntity.busId = 3;
    this.app.a().v(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = a().b(paramFileManagerEntity, paramString);
    if (paramFileManagerEntity.peerType == 3000)
    {
      a(paramString, 20);
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramString.nSessionId + "] SendDisc2Weiyun[" + paramString.fileName + "]");
      return paramString;
    }
    k(paramString);
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramString.nSessionId + "] SendOffline2Weiyun[" + paramString.fileName + "]");
    return paramString;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      ahav.ti();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = ahav.getFileName(localFileManagerEntity.getFilePath());
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
    localFileManagerEntity.peerNick = ahav.a(this.app, paramString, null, paramInt);
    if ((paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1)) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.app.getCurrentUin())
    {
      localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
      localFileManagerEntity.setCloudType(paramFileManagerEntity.cloudType);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.msgSeq = ahav.bA();
      localFileManagerEntity.msgUid = ahav.ge();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + ahav.d(localFileManagerEntity));
      }
      this.app.a().v(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramFileManagerEntity, paramString1, paramString2, paramInt, paramBoolean, 0L, 0);
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      ahav.ti();
      return null;
    }
    String str = aoon.a("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = ahav.getFileName(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    long l = anbi.d(-1000).uniseq;
    wte.a().i(l, paramLong, paramInt2);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = ahav.a(this.app, paramString2, null, paramInt1);
    localFileManagerEntity.selfUin = paramString1;
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = ahav.bA();
    localFileManagerEntity.msgUid = ahav.ge();
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + ahav.d(localFileManagerEntity));
    }
    ahav.a(this.app, paramString1, paramString2, localFileManagerEntity);
    if (paramBoolean)
    {
      this.app.a().jo(paramFileManagerEntity.nSessionId);
      this.app.a().s(localFileManagerEntity);
      this.app.a().a(paramString2, paramString1, true, localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, localFileManagerEntity.Uuid, 1, l, localFileManagerEntity.msgUid, -1L, anaz.gQ());
      return localFileManagerEntity;
    }
    this.app.a().v(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramString3, paramInt, paramBoolean, 0L, 0);
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
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
    String str1 = ahav.getFileName(paramString1);
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
        break label435;
      }
      j = 3;
      if (paramBoolean)
      {
        l = anbi.d(-1000).uniseq;
        wte.a().i(l, paramLong, paramInt2);
      }
      localFileManagerEntity = this.app.a().b(l, paramString3, paramInt1);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.fileSize = ahav.getFileSizes(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(paramBoolean) + "], filepath[" + paramString1 + "]:size[" + String.valueOf(localFileManagerEntity.fileSize) + "]");
      }
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = paramString3;
      localFileManagerEntity.peerNick = ahav.a(this.app, paramString3, null, paramInt1);
      localFileManagerEntity.setFilePath(paramString1);
      localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
      localFileManagerEntity.fileName = str1;
      localFileManagerEntity.nFileType = ahav.getFileType(paramString1);
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.msgSeq = ahav.bA();
      localFileManagerEntity.msgUid = ahav.ge();
      localFileManagerEntity.strThumbPath = ahav.h(paramString1, 150, 150);
      ahav.a(this.app, paramString2, paramString3, localFileManagerEntity);
      this.app.a().s(localFileManagerEntity);
      str1 = this.app.getAccount();
      if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
        break label441;
      }
      str1 = paramString2;
    }
    for (;;)
    {
      paramString2 = new FileManagerEngine.1(this, localFileManagerEntity, paramBoolean, paramString3, str1, paramString1, paramInt1, str2, j, l);
      if (localFileManagerEntity.nFileType != 5) {
        break label467;
      }
      paramString1 = localFileManagerEntity;
      if (ahap.a(localFileManagerEntity.getFilePath(), new aghx(this, localFileManagerEntity, paramString2))) {
        break;
      }
      ahav.a.getExecutor().execute(paramString2);
      return localFileManagerEntity;
      i = 6;
      break label57;
      label435:
      j = 2;
      break label65;
      label441:
      if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString2;
        localFileManagerEntity.tmpSessionToPhone = paramString3;
        str1 = paramString2;
      }
    }
    label467:
    ahav.a.getExecutor().execute(paramString2);
    return localFileManagerEntity;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Agln == null) {}
    try
    {
      if (this.jdField_a_of_type_Agln == null) {
        this.jdField_a_of_type_Agln = new agln(this.app);
      }
      return this.jdField_a_of_type_Agln.b(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_Agjz == null) {}
    try
    {
      if (this.jdField_a_of_type_Agjz == null) {
        this.jdField_a_of_type_Agjz = new agjz(this.app);
      }
      return this.jdField_a_of_type_Agjz.b(paramFileManagerEntity, paramInt);
    }
    finally {}
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().d(paramString1, paramString2, paramInt, paramObject);
  }
  
  public void a(int paramInt1, long paramLong1, String paramString, long paramLong2, int paramInt2)
  {
    Object localObject = this.app.a().b(paramLong1);
    FileManagerEntity localFileManagerEntity = this.app.a().a((FileManagerEntity)localObject, paramString, 1);
    localFileManagerEntity.fProgress = 0.0F;
    try
    {
      localFileManagerEntity.TroopUin = Long.parseLong(paramString);
      localFileManagerEntity.status = 2;
      if (((FileManagerEntity)localObject).peerType == 0)
      {
        localFileManagerEntity.nOpType = 26;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + localFileManagerEntity.nSessionId + "] sendOffline2Troop[" + localFileManagerEntity.fileName + "]");
        if ((TextUtils.isEmpty(localFileManagerEntity.strTroopFileUuid)) || (localFileManagerEntity.mContext == null))
        {
          ahbm localahbm = ahav.b(this.app);
          localFileManagerEntity.strTroopFileUuid = localahbm.a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject).peerType, paramString, ((FileManagerEntity)localObject).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId, paramLong2, paramInt2);
          localFileManagerEntity.mContext = localahbm;
        }
        if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
          localFileManagerEntity.busId = 102;
        }
        if (aqiw.isNetSupport(BaseApplication.getContext())) {
          break label520;
        }
        localObject = BaseApplicationImpl.getContext().getString(2131696348);
        localFileManagerEntity.status = 0;
        this.app.a().b(false, 19, new Object[] { Integer.valueOf(9004), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
        if ((localFileManagerEntity.mContext instanceof ahbm)) {
          ((ahbm)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong1, 9004, (String)localObject, paramString, "");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerEngine<FileAssistant>", 2, ahav.ti());
          continue;
          if (((FileManagerEntity)localObject).peerType == 3000)
          {
            localFileManagerEntity.nOpType = 27;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + localFileManagerEntity.nSessionId + "] sendDisce2Troop[" + localFileManagerEntity.fileName + "]");
          }
          else if (((FileManagerEntity)localObject).peerType == 6000)
          {
            localFileManagerEntity.nOpType = 32;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + localFileManagerEntity.nSessionId + "] sendDataline2Troop[" + localFileManagerEntity.fileName + "]");
          }
        }
      }
      label520:
      this.app.a().a(102, paramInt1, localFileManagerEntity);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.app.a().b(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
  }
  
  public void a(MessageRecord paramMessageRecord, FileManagerEntity paramFileManagerEntity, agmy.a parama)
  {
    if (paramFileManagerEntity.peerType == 3000)
    {
      this.app.a().a(paramMessageRecord.frienduin, paramMessageRecord.senderuin, paramFileManagerEntity.Uuid, parama);
      return;
    }
    this.app.a().a(paramFileManagerEntity, parama);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    a(paramFileManagerEntity, paramInt, 0L, 0);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.nOpType = paramInt1;
    QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nOperationType[" + paramInt1 + "]");
    ahav.jR(paramFileManagerEntity.nSessionId);
    if ((paramInt1 != 27) && (!aqiw.isNetSupport(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      ahav.a(this.app, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt1 + "]");
    paramFileManagerEntity.bSend = true;
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = paramInt1;
    int j = 0;
    int i = j;
    switch (paramInt1)
    {
    default: 
      i = j;
    }
    while (paramFileManagerEntity.selfUin.equalsIgnoreCase(this.app.getCurrentAccountUin()))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + paramFileManagerEntity.nSessionId + "], type[" + paramInt1 + "] error");
      if (QLog.isDevelopLevel())
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "多人聊天转发，selfUin不能为自己！！！");
        throw new NullPointerException(acfp.m(2131706273));
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Disc[" + paramFileManagerEntity.fileName + "]");
        this.app.a().a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.fileSize, paramFileManagerEntity.selfUin, paramFileManagerEntity.fileName, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5);
        return;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Offline[" + paramFileManagerEntity.fileName + "]");
        i = 3;
        continue;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Weiyun[" + paramFileManagerEntity.fileName + "]");
        i = 25;
        continue;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] Disc2Troop[" + paramFileManagerEntity.fileName + "]");
        Object localObject;
        if ((TextUtils.isEmpty(paramFileManagerEntity.strTroopFileUuid)) || (paramFileManagerEntity.mContext == null))
        {
          localObject = ahav.b(this.app);
          paramFileManagerEntity.strTroopFileUuid = ((ahbm)localObject).a(this.app.getCurrentAccountUin(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId, paramLong, paramInt2);
          paramFileManagerEntity.mContext = localObject;
        }
        if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
          paramFileManagerEntity.busId = 102;
        }
        paramInt2 = paramFileManagerEntity.busId;
        i = paramInt2;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          i = paramInt2;
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
      QLog.i("FileManagerEngine<FileAssistant>", 2, "ForwardDisc2X" + ahav.d(paramFileManagerEntity));
    }
    if (paramInt1 == 20) {
      awou.eEJ();
    }
    this.app.a().c(paramFileManagerEntity, i);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    a(paramFileManagerEntity, paramString1, paramString2, paramInt, 0);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt1, paramInt2);
    ahav.jR(paramFileManagerEntity.nSessionId);
    ahav.a(this.app, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt1, false);
  }
  
  public boolean a(int paramInt1, FileManagerEntity paramFileManagerEntity, int paramInt2)
  {
    Object localObject;
    if (0L == paramFileManagerEntity.datalineEntitySessionId)
    {
      localObject = ahav.a(this.app, paramInt2);
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
        paramFileManagerEntity.mContext = ahav.a(this.app, paramInt2);
      }
    }
    this.app.a().a(38, paramInt1, paramFileManagerEntity);
    return true;
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    return a(paramLong1, paramString, paramLong2, paramLong3, paramInt1, paramInt2, 0L, 0);
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, int paramInt3)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong1);
    if (localFileManagerEntity == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerEngine<FileAssistant>", 2, String.format("ForwardTroopFile==>fileName:%s|mEntrySessionID:%s|old filePath:%s", new Object[] { localFileManagerEntity.fileName, paramLong1 + "", localFileManagerEntity.strTroopFilePath }));
    }
    Object localObject = apsv.a(this.app, paramLong2, localFileManagerEntity.Uuid, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
    if ((localObject == null) || (((apcy)localObject).FilePath == null)) {
      return false;
    }
    if (paramInt1 == 1)
    {
      int j = Math.abs(new Random().nextInt());
      apcy localapcy = TroopFileTransferManager.a(this.app, paramLong3).a(((apcy)localObject).FilePath, paramLong2, ((apcy)localObject).FileName, ((apcy)localObject).LocalFile, ((apcy)localObject).ProgressTotal, ((apcy)localObject).BusId, j, paramLong1);
      if (localapcy == null)
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "infoNew is null!!!");
        return false;
      }
      paramInt1 = ahav.getFileType(((apcy)localObject).FileName);
      if (paramInt1 == 0) {
        if (ahbj.isFileExists(((apcy)localObject).LocalFile))
        {
          paramString = new BitmapFactory.Options();
          paramString.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(((apcy)localObject).LocalFile, paramString);
          paramLong2 = apsv.a(this.app, String.valueOf(paramLong3), localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), j, String.valueOf(((apcy)localObject).TroopUin), paramLong1, paramString.outWidth, paramString.outHeight, paramLong4, paramInt3);
        }
      }
      for (;;)
      {
        localFileManagerEntity.structMsgSeq = paramLong2;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "ForwardTroopFile, startCopyToGroup, entrySessionID:" + paramLong1 + "|InsertAIOMsg, msgSeq:" + paramLong2);
        }
        return true;
        paramString = (MessageForTroopFile)this.app.b().a(String.valueOf(((apcy)localObject).TroopUin), 1, ((apcy)localObject).FilePath);
        if (paramString != null)
        {
          paramLong2 = apsv.a(this.app, String.valueOf(paramLong3), localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), j, String.valueOf(((apcy)localObject).TroopUin), paramLong1, paramString.width, paramString.height, paramLong4, paramInt3);
        }
        else
        {
          paramLong2 = apsv.a(this.app, String.valueOf(paramLong3), localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), j, String.valueOf(((apcy)localObject).TroopUin), paramLong1, paramLong4, paramInt3);
          continue;
          if (paramInt1 == 2)
          {
            paramInt1 = 0;
            paramInt2 = 0;
            int i = 0;
            if (ahbj.isFileExists(((apcy)localObject).LocalFile))
            {
              paramString = ShortVideoUtils.n(paramString);
              paramInt1 = paramString[0];
              paramInt2 = paramString[1];
              i = paramString[3];
            }
            for (;;)
            {
              paramLong2 = apsv.a(this.app, String.valueOf(paramLong3), localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), j, String.valueOf(((apcy)localObject).TroopUin), paramLong1, paramInt1, paramInt2, i, paramLong4, paramInt3);
              break;
              paramString = (MessageForTroopFile)this.app.b().a(String.valueOf(((apcy)localObject).TroopUin), 1, ((apcy)localObject).FilePath);
              if (paramString != null)
              {
                paramInt1 = paramString.width;
                paramInt2 = paramString.height;
                i = paramString.duration;
              }
            }
          }
          paramLong2 = apsv.a(this.app, String.valueOf(paramLong3), localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), j, String.valueOf(((apcy)localObject).TroopUin), paramLong1, paramLong4, paramInt3);
        }
      }
    }
    if ((paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramString = TroopFileTransferManager.a(this.app, paramLong2);
      if (paramLong2 != 0L) {
        break label1113;
      }
    }
    label1107:
    label1113:
    for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
    {
      localObject = new Bundle();
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkPackageName)) {
        ((Bundle)localObject).putString("yyb_apk_package_name_key", localFileManagerEntity.yybApkPackageName);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkName)) {
        ((Bundle)localObject).putString("yyb_apk_name_key", localFileManagerEntity.yybApkName);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkIconUrl)) {
        ((Bundle)localObject).putString("yyb_apk_icon_url_key", localFileManagerEntity.yybApkIconUrl);
      }
      paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, false, 0L, ahav.a(this.app), paramLong4, paramInt3, (Bundle)localObject);
      return true;
      if (paramInt1 == 7)
      {
        paramString = TroopFileTransferManager.a(this.app, paramLong2);
        if (paramLong2 != 0L) {
          break label1107;
        }
      }
      for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
      {
        if (localFileManagerEntity.datalineEntitySessionId != 0L) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, ahav.a(this.app, 0), paramLong4, paramInt3, null);
          break;
        }
        if (paramInt1 != 6003) {
          break;
        }
        paramString = TroopFileTransferManager.a(this.app, paramLong2);
        if (paramLong2 == 0L) {}
        for (paramLong1 = localFileManagerEntity.TroopUin;; paramLong1 = paramLong2)
        {
          if (localFileManagerEntity.datalineEntitySessionId != 0L) {}
          for (bool = true;; bool = false)
          {
            paramString.a(paramInt2, paramLong1, localFileManagerEntity.busId, paramLong3, 7, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, ahav.a(this.app, 1), paramLong4, paramInt3, null);
            break;
          }
        }
      }
    }
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramLong, paramString1, paramString2, paramInt, paramBoolean, 0);
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
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
      QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + ahav.d(localFileManagerEntity) + " ]");
    }
    if (5 != localFileManagerEntity.cloudType) {
      ahav.I(localFileManagerEntity);
    }
    if ((localFileManagerEntity.getCloudType() == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + localFileManagerEntity.WeiYunFileId + "], filename[" + localFileManagerEntity.fileName + "], filename[" + localFileManagerEntity.fileSize + "]");
      }
      ahav.jR(localFileManagerEntity.nSessionId);
      if (TextUtils.isEmpty(paramString1)) {
        a(localFileManagerEntity, this.app.getCurrentAccountUin(), paramString2, paramInt1);
      }
    }
    for (;;)
    {
      return false;
      b(localFileManagerEntity, paramString1, paramString2, paramInt1);
      continue;
      if (agmy.mt(localFileManagerEntity.Uuid))
      {
        aobw.a(this.app, localFileManagerEntity, paramString2, paramInt1);
      }
      else if ((localFileManagerEntity.getCloudType() == 1) && (!TextUtils.isEmpty(localFileManagerEntity.Uuid)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + paramLong + "], strSendUin[" + ahav.kZ(paramString1) + "], recvUin[" + ahav.kZ(paramString2) + "], peerType[" + paramInt1 + "], toOffline[" + paramBoolean + "]");
        }
        Object localObject = this.app.getAccount();
        if ((paramInt1 == 1004) || (paramInt1 == 1000)) {
          localObject = paramString1;
        }
        while (paramInt1 == 1)
        {
          ao(paramLong, paramString2);
          return false;
          if (paramInt1 == 1006) {
            localObject = paramString1;
          }
        }
        localObject = a(localFileManagerEntity, (String)localObject, paramString2, paramInt1, true, 0L, paramInt2);
        ahav.jR(((FileManagerEntity)localObject).nSessionId);
        ahav.a(this.app, paramString1, paramString2, (FileManagerEntity)localObject);
        ((FileManagerEntity)localObject).peerType = localFileManagerEntity.peerType;
        if (localFileManagerEntity.peerType == 3000)
        {
          ((FileManagerEntity)localObject).selfUin = localFileManagerEntity.peerUin;
          if (paramInt1 == 3000)
          {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendDisc2Disc[" + ((FileManagerEntity)localObject).fileName + "]");
            this.app.a().a((FileManagerEntity)localObject, 22);
          }
          else
          {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendDisc2Offline[" + ((FileManagerEntity)localObject).fileName + "]");
            this.app.a().a((FileManagerEntity)localObject, 21);
          }
        }
        else
        {
          if (paramInt1 == 3000)
          {
            ((FileManagerEntity)localObject).nOpType = 28;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendOfline2Disc[" + ((FileManagerEntity)localObject).fileName + "]");
          }
          for (;;)
          {
            j((FileManagerEntity)localObject);
            break;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject).nSessionId + "] SendOfline2Offline[" + ((FileManagerEntity)localObject).fileName + "]");
          }
        }
      }
      else if (localFileManagerEntity.getFilePath() != null)
      {
        if (paramInt1 == 1) {
          aV(localFileManagerEntity.getFilePath(), paramString2);
        } else {
          return a(localFileManagerEntity.getFilePath(), paramString1, paramString2, paramInt1, paramBoolean) != null;
        }
      }
      else
      {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt1, int paramInt2)
  {
    avjm localavjm;
    if (paramInt1 == 1)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send FavFile to Troop ");
      if (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
      {
        this.app.a().a(paramFileManagerEntity.getFilePath(), paramString, 0L, paramInt2);
        return true;
      }
      localavjm = new avjm(this.app);
      if (localavjm != null) {
        localavjm.a(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
      }
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 6000)
      {
        localavjm = new avjm(this.app);
        if (localavjm != null) {
          localavjm.c(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
        }
      }
      else if (paramInt1 == 0)
      {
        localavjm = new avjm(this.app);
        if (localavjm != null) {
          localavjm.b(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
        }
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send QfavFile to offline ");
      }
      else
      {
        if (paramInt1 != 3000) {
          break label274;
        }
        if (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) {
          break;
        }
        this.app.a().a(paramFileManagerEntity.getFilePath(), this.app.getCurrentUin(), paramString, paramInt1, true, 0L, paramInt2);
      }
    }
    ahao.OS(2131694140);
    return false;
    label274:
    QLog.e("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send QfavFile to peerType:" + paramInt1);
    ahao.OS(2131694140);
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = TroopFileTransferManager.a(this.app, Long.parseLong(paramString2));
    int i;
    VFSFile localVFSFile;
    if (localObject != null)
    {
      i = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, i);
      localVFSFile = new VFSFile(paramString1);
      if (ahav.getFileType(paramString1) != 0) {
        break label138;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      ahbh.d(paramString1, localOptions);
      apsv.a(this.app, paramString2, localVFSFile.getName(), localVFSFile.length(), ((apcy)localObject).Id.toString(), i, null, 0L, localOptions.outWidth, localOptions.outHeight, paramLong, paramInt);
    }
    for (;;)
    {
      return true;
      label138:
      if (ahav.getFileType(paramString1) == 2)
      {
        paramString1 = ShortVideoUtils.n(paramString1);
        apsv.a(this.app, paramString2, localVFSFile.getName(), localVFSFile.length(), ((apcy)localObject).Id.toString(), i, null, 0L, paramString1[0], paramString1[1], paramString1[2], paramLong, paramInt);
      }
      else
      {
        apsv.a(this.app, paramString2, localVFSFile.getName(), localVFSFile.length(), ((apcy)localObject).Id.toString(), i, null, 0L, paramLong, paramInt);
      }
    }
  }
  
  public void aIH()
  {
    this.app.a().aIH();
  }
  
  public boolean aV(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 0L, 0);
  }
  
  public void al(long paramLong, String paramString)
  {
    i(38, paramLong, paramString);
  }
  
  public boolean alc()
  {
    return false;
  }
  
  public void am(long paramLong, String paramString) {}
  
  public void an(long paramLong, String paramString) {}
  
  public void ao(long paramLong, String paramString)
  {
    i(3, paramLong, paramString);
  }
  
  public String b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_Agkb == null) {}
    try
    {
      if (this.jdField_a_of_type_Agkb == null) {
        this.jdField_a_of_type_Agkb = new agkb(this.app);
      }
      return this.jdField_a_of_type_Agkb.b(paramFileManagerEntity, 7);
    }
    finally {}
  }
  
  public String b(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().c(paramString1, paramString2, paramInt, paramObject);
  }
  
  public void b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    a().c(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
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
    b(paramFileManagerEntity, paramString1, paramString2, paramInt, 0);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send WeiYun to Troop ");
      a().a(paramFileManagerEntity, paramString2, paramInt2);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      paramString1 = this.app.getCurrentAccountUin();
    }
    for (;;)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]Send WeiYun to offline ");
      a(paramFileManagerEntity, paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
  }
  
  public void b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    a().b(paramWeiYunFileInfo);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + ahav.kZ(paramString1) + "],fileName[" + paramString2 + "],uuid[" + paramString3 + "]");
    this.app.a().c(paramString1, paramString3, paramString4, paramString2, paramBoolean);
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
    ahau.a locala;
    if (1 == localFileManagerEntity.nOpType)
    {
      locala = new ahau.a();
      locala.bJE = "recv_file_cancel";
      ahau.a(this.app.getCurrentAccountUin(), locala);
    }
    while (paramLong > 0L)
    {
      return this.app.a().cc(paramLong);
      if (localFileManagerEntity.nOpType == 0)
      {
        locala = new ahau.a();
        locala.bJE = "send_file_cancel";
        ahau.a(this.app.getCurrentAccountUin(), locala);
      }
    }
    if ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq == -1L)) {
      return this.app.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.uniseq, localFileManagerEntity.peerType);
    }
    QLog.e("FileManagerEngine<FileAssistant>", 2, "Pause: can not find file entity info.");
    return false;
  }
  
  public String c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    String str = ahav.g(paramFileManagerEntity);
    if (ahbj.fileExistsAndNotEmpty(str)) {
      return str;
    }
    a().q(paramFileManagerEntity.nSessionId, str, paramFileManagerEntity.strServerPath);
    return null;
  }
  
  public void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int i = agmz.dd().size();
    int j = agmz.dc().size();
    int k = agmz.db().size();
    int m = agmz.D().size();
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^> Send All Select File Start!, weiyun[" + i + "],offline[" + j + "],recent[" + k + "],local[" + m + "] sendUin[" + ahav.kZ(paramString1) + "] recvUin[" + ahav.kZ(paramString2) + "] peerType[" + paramInt + "]");
    for (;;)
    {
      try
      {
        Object localObject1 = this.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("last_select_send", true);
        ((SharedPreferences.Editor)localObject1).commit();
        if ((agmz.dd().size() == 0) && (agmz.dc().size() == 0))
        {
          localObject1 = agmz.D();
          Object localObject2 = agmz.db();
          i = 0;
          Object localObject3 = ((Set)localObject1).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            if (!ahbj.fileExistsAndNotEmpty(((FileInfo)((Iterator)localObject3).next()).getPath())) {
              i += 1;
            }
          }
          else
          {
            localObject3 = ((ArrayList)localObject2).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              if (((FileManagerEntity)((Iterator)localObject3).next()).status == 16)
              {
                i += 1;
                continue;
              }
            }
            else
            {
              if (i != ((Set)localObject1).size() + ((ArrayList)localObject2).size()) {
                continue;
              }
              QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^! Send All Select File is INVALID ");
              ahao.OS(2131694128);
              return;
              if (i >= agmz.dd().size()) {
                continue;
              }
              localObject1 = (WeiYunFileInfo)agmz.dd().get(i);
              ahau.JH("0X8005415");
              b(ahav.b((WeiYunFileInfo)localObject1), paramString1, paramString2, paramInt);
              i += 1;
              continue;
              if (i >= agmz.dc().size()) {
                break label1093;
              }
              localObject1 = (OfflineFileInfo)agmz.dc().get(i);
              localObject1 = this.app.a().a(ahav.a((OfflineFileInfo)localObject1, paramInt), paramString1, paramString2, paramInt, true);
              ((FileManagerEntity)localObject1).peerType = paramInt;
              ((FileManagerEntity)localObject1).status = 2;
              if (paramInt == 3000)
              {
                ((FileManagerEntity)localObject1).nOpType = 28;
                QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject1).nSessionId + "] sendOffline2Disc[" + ((FileManagerEntity)localObject1).fileName + "]");
                j((FileManagerEntity)localObject1);
                i += 1;
                continue;
              }
              QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + ((FileManagerEntity)localObject1).nSessionId + "] sendOffline2Offline[" + ((FileManagerEntity)localObject1).fileName + "]");
              continue;
              if (i < agmz.db().size())
              {
                localObject1 = (FileManagerEntity)agmz.db().get(i);
                if (((FileManagerEntity)localObject1).sendCloudUnsuccessful())
                {
                  QLog.w("FileManagerEngine<FileAssistant>", 1, "Id[" + ((FileManagerEntity)localObject1).nSessionId + "] unSend success!");
                  break label1099;
                }
                if ((((FileManagerEntity)localObject1).fileSize <= 20971520L) && (paramBoolean) && (agmz.n((FileManagerEntity)localObject1)))
                {
                  new aobs(this.app).c((FileManagerEntity)localObject1, paramString1, paramString2, paramInt);
                  break label1099;
                }
                ahap.G((FileManagerEntity)localObject1);
                ahau.JH("0X8005413");
                a(((FileManagerEntity)localObject1).nSessionId, paramString1, paramString2, paramInt, true);
                break label1099;
              }
              localObject1 = agmz.D().iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (FileInfo)((Iterator)localObject1).next();
                localObject3 = ((FileInfo)localObject2).getPath();
                if ((paramBoolean) && (((FileInfo)localObject2).getSize() <= 20971520L) && (agmz.e((FileInfo)localObject2)))
                {
                  new aobs(this.app).u((String)localObject3, paramString1, paramString2, paramInt);
                  continue;
                }
                ahau.JH("0X8005414");
                if (paramInt == 1)
                {
                  aV((String)localObject3, paramString2);
                  continue;
                }
                a((String)localObject3, paramString1, paramString2, paramInt, true).strApkPackageName = ((FileInfo)localObject2).getApkPackeageName();
                continue;
              }
              if (paramInt == 1)
              {
                i = 0;
                if (agmz.dd().size() > 0) {
                  i = 1;
                }
                j = i;
                if (agmz.D().size() > 0) {
                  j = i + 10;
                }
                if (agmz.db().size() > 0)
                {
                  i = j + 100;
                  anot.a(this.app, "dc00899", "Grp_files", "", "oper", "Clk_send", 0, 0, paramString2, String.format("%03d", new Object[] { Integer.valueOf(i) }), "", "");
                }
              }
              else
              {
                i = ahav.dc(this.app.getCurrentAccountUin());
                if ((paramInt != 0) || (i >= 3) || (!ahav.ba(this.app.getCurrentAccountUin(), paramString2))) {
                  continue;
                }
                ahav.L(this.app.getCurrentAccountUin(), paramString2, false);
                paramString1 = BaseApplicationImpl.getContext().getString(2131700475);
                this.app.a().a(paramString2, this.app.getCurrentAccountUin(), paramInt, -3009, paramString1);
                ahav.eI(this.app.getCurrentAccountUin(), i + 1);
                return;
              }
              i = j;
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
      }
      catch (Exception paramString1)
      {
        return;
      }
      label1093:
      continue;
      label1099:
      i += 1;
    }
  }
  
  public ArrayList<FileManagerEntity> cZ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "saveAllSelectFileToWeiYun");
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < agmz.dc().size())
    {
      localObject = (OfflineFileInfo)agmz.dc().get(i);
      localArrayList.add(a(ahav.a((OfflineFileInfo)localObject, 0), String.valueOf(((OfflineFileInfo)localObject).uFriendUin)));
      i += 1;
    }
    i = 0;
    while (i < agmz.db().size())
    {
      localObject = (FileManagerEntity)agmz.db().get(i);
      if (((FileManagerEntity)localObject).sendCloudUnsuccessful())
      {
        i += 1;
      }
      else
      {
        ahap.G((FileManagerEntity)localObject);
        switch (((FileManagerEntity)localObject).getCloudType())
        {
        case 2: 
        case 4: 
        default: 
          localObject = null;
        }
        while (localObject != null)
        {
          localArrayList.add(localObject);
          break;
          if (!aqhq.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath())) {
            break;
          }
          localObject = a(((FileManagerEntity)localObject).getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
          continue;
          localObject = a((FileManagerEntity)localObject, String.valueOf(((FileManagerEntity)localObject).peerUin));
        }
      }
    }
    Object localObject = agmz.D().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
      FileManagerEntity localFileManagerEntity = a(localFileInfo.getPath(), "", this.app.getAccount(), 0, false);
      localFileManagerEntity.strApkPackageName = localFileInfo.getApkPackeageName();
      localArrayList.add(localFileManagerEntity);
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
      if (!ahav.mI(localFileManagerEntity.getFilePath())) {
        break label237;
      }
      localFileManagerEntity.cloudType = 3;
    }
    for (;;)
    {
      if ((!localFileManagerEntity.bDelInAio) || (!localFileManagerEntity.bDelInFM)) {
        break label247;
      }
      return true;
      if ((this.app.a().cc(paramLong)) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.w("FileManagerEngine<FileAssistant>", 2, "Pause[" + String.valueOf(paramLong) + "] faild!,status[" + String.valueOf(localFileManagerEntity.status) + "]");
      break;
      label237:
      localFileManagerEntity.status = 16;
    }
    label247:
    this.app.a().u(localFileManagerEntity);
    return bool;
  }
  
  public void dfZ()
  {
    a().dfZ();
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
  
  public void el(Context paramContext)
  {
    int k = agmz.dd().size();
    int j = agmz.dc().size();
    Iterator localIterator = agmz.db().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((FileManagerEntity)localIterator.next()).nFileType != 13) {
        break label806;
      }
      i += 1;
    }
    label806:
    for (;;)
    {
      break;
      int m = agmz.db().size() - i;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= v> Download All Select File Start!, weiyun[" + k + "],offline[" + j + "],recent[" + m + "]");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + agmz.dd().size() + "], offline[" + agmz.dc().size() + "], recent[" + (agmz.db().size() - i) + "], localfile[" + agmz.D().size() + "]");
      }
      if ((i > 0) && (m == 0) && (k == 0) && (j == 0))
      {
        aqha.a(paramContext, 230).setMessage(paramContext.getString(2131693834)).setNegativeButton(2131720227, new aghz(this)).show();
        return;
      }
      i = 0;
      while (i < k)
      {
        paramContext = ahav.b((WeiYunFileInfo)agmz.dd().get(i));
        this.app.a().s(paramContext);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downWeiYunFiles,weiyun[" + i + "]");
        }
        a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 5);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramContext = ahav.a((OfflineFileInfo)agmz.dc().get(i), 0);
        paramContext.status = 2;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerEngine<FileAssistant>", 2, "downOfflineFiles,weiyun[" + i + "]");
        }
        a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 8);
        i += 1;
      }
      i = 0;
      label460:
      if (i < agmz.db().size())
      {
        paramContext = (FileManagerEntity)agmz.db().get(i);
        ahap.G(paramContext);
        if (paramContext.status != 16) {
          break label501;
        }
      }
      for (;;)
      {
        i += 1;
        break label460;
        break;
        label501:
        if (paramContext.nFileType != 13) {
          switch (paramContext.getCloudType())
          {
          default: 
            QLog.e("FileManagerEngine<FileAssistant>", 2, "unknow type,Engity:" + ahav.d(paramContext));
            break;
          case 3: 
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerEngine<FileAssistant>", 2, "=_= v> downRecentFiles,local[" + i + "] break");
            }
            break;
          case 1: 
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,offline[" + i + "]");
            }
            if ((paramContext.bSend == true) && (paramContext.status != 1) && (paramContext.status != -1) && (paramContext.status != 3)) {
              QLog.w("FileManagerEngine<FileAssistant>", 2, "=_= v> downRecentFiles,but Id[" + paramContext.nSessionId + "] is sendStatus but no Success! continiu");
            } else {
              a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 8);
            }
            break;
          case 2: 
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerEngine<FileAssistant>", 2, "downRecentFiles,weiyun[" + i + "]");
            }
            a(paramContext.nSessionId, paramContext.uniseq, paramContext.peerUin, paramContext.peerType, 5);
          }
        }
      }
    }
  }
  
  public void fA(String paramString1, String paramString2)
  {
    this.app.a().fE(paramString1, paramString2);
  }
  
  public void fB(String paramString1, String paramString2)
  {
    this.app.a().fF(paramString1, paramString2);
  }
  
  public void fC(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Agmf.fK(paramString1, paramString2);
  }
  
  public void free()
  {
    BaseApplicationImpl.sApplication.unregisterReceiver(this.jdField_a_of_type_Aghw$a);
    this.jdField_a_of_type_Aghw$a = null;
    ahaf.a().free();
    agrt.a().stop();
    agkw.releaseAll();
    this.app.a().Jh(false);
    try
    {
      this.app.a().deleteObservers();
      QLog.i("FileManagerEngine<FileAssistant><QFile>", 1, "free: remove all file observers.");
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean hasQueriedVerifyPassword()
  {
    return a().hasQueriedVerifyPassword();
  }
  
  public void i(int paramInt, long paramLong, String paramString)
  {
    a(paramInt, paramLong, paramString, 0L, 0);
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
    ahav.jR(paramFileManagerEntity.nSessionId);
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131693819);
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 19, new Object[] { Integer.valueOf(0), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      ahav.a(this.app, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + paramFileManagerEntity.nSessionId + "], opType[" + paramFileManagerEntity.nOpType + "]");
    Object localObject = (aizg)this.app.getManager(16);
    if ((localObject != null) && (((aizg)localObject).nf(paramFileManagerEntity.peerUin)))
    {
      ahav.JI(acfp.m(2131706275));
      paramFileManagerEntity.status = 0;
      this.app.a().b(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      this.app.a().u(paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    if (paramFileManagerEntity.nOpType == 28)
    {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] SendOf2Disc[" + paramFileManagerEntity.fileName + "]");
      this.app.a().a(106, paramFileManagerEntity);
      return;
    }
    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] SendOf2Of[" + paramFileManagerEntity.fileName + "]");
    this.app.a().m(paramFileManagerEntity);
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
  
  public void m(long paramLong, String paramString, int paramInt)
  {
    a(3, paramLong, paramString, 0L, paramInt);
  }
  
  public void n(int paramInt1, long paramLong, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong);
    if (localFileManagerEntity != null) {
      a(paramInt1, a(localFileManagerEntity), paramInt2);
    }
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
        ahaf.a().remove("externalSdCard");
      }
      try
      {
        aghw.this.app.a().Jh(true);
        label96:
        if ((paramContext.equalsIgnoreCase("android.intent.action.MEDIA_MOUNTED")) || (paramContext.equalsIgnoreCase("android.intent.action.MEDIA_SCANNER_STARTED"))) {
          ahaf.a().dkR();
        }
        aghw.this.app.a().b(true, 3, null);
        return;
      }
      catch (Exception paramIntent)
      {
        break label96;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aghw
 * JD-Core Version:    0.7.0.1
 */