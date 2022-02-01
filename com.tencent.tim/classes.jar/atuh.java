import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.OnlineFileSessionCenter.1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;

public class atuh
{
  private long YU;
  private atuh.b a;
  LinkedHashMap<Long, atul> aa = new LinkedHashMap();
  private LinkedHashMap<String, LinkedHashMap<Long, atuh.a>> ab = new LinkedHashMap();
  QQAppInterface app;
  private BroadcastReceiver bf;
  private atsn f = new atuj(this);
  public Handler mMainHandler = null;
  
  public atuh(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface.a().addObserver(this.f);
    try
    {
      ThreadManager.executeOnSubThread(new OnlineFileSessionCenter.1(this, paramQQAppInterface));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 2, paramQQAppInterface.toString());
    }
  }
  
  public void NZ(int paramInt)
  {
    Iterator localIterator = this.aa.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      atul localatul = (atul)localEntry.getValue();
      localatul.Oc(paramInt);
      if (localatul.alI())
      {
        long l = ((Long)localEntry.getKey()).longValue();
        localIterator.remove();
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]. remove the worker....");
      }
    }
    stop();
  }
  
  atul a(long paramLong)
  {
    atul localatul3 = (atul)this.aa.get(Long.valueOf(paramLong));
    atul localatul1 = localatul3;
    if (localatul3 == null)
    {
      FileManagerEntity localFileManagerEntity = this.app.a().b(paramLong);
      localatul1 = localatul3;
      if (localFileManagerEntity != null)
      {
        localatul1 = new atul(this.app, localFileManagerEntity.nSessionId);
        localatul1.m(localFileManagerEntity);
      }
    }
    try
    {
      this.aa.put(Long.valueOf(paramLong), localatul1);
      if (this.app.a().cb(paramLong))
      {
        QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] getOnlineWorker, but user had deleted it, return null");
        if (localatul1 != null)
        {
          localatul1.stop();
          jp(paramLong);
        }
        return null;
      }
    }
    finally {}
    if (localatul2 != null) {
      localatul2.dhZ();
    }
    dhK();
    return localatul2;
  }
  
  atul a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.aa.values().iterator();
    atul localatul;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localatul = (atul)((Iterator)localObject).next();
    } while ((localatul == null) || (localatul.c == null) || (!paramString.equalsIgnoreCase(localatul.c.peerUin)) || (paramLong != localatul.c.nOLfileSessionId));
    for (;;)
    {
      if (localatul == null)
      {
        localObject = this.app.a().a(paramString, paramLong);
        if (localObject == null) {
          break label261;
        }
        paramLong = ((FileManagerEntity)localObject).nSessionId;
        paramString = new atul(this.app, ((FileManagerEntity)localObject).nSessionId);
        paramString.m((FileManagerEntity)localObject);
      }
      for (;;)
      {
        try
        {
          this.aa.put(Long.valueOf(paramLong), paramString);
          if (!this.app.a().cb(paramLong)) {
            break label247;
          }
          QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] getOnlineWorker, but user had deleted it, return null");
          if (paramString != null)
          {
            paramString.stop();
            jp(paramLong);
          }
          return null;
        }
        finally {}
        if (localatul.c != null)
        {
          paramLong = localatul.c.nSessionId;
          paramString = localatul;
          continue;
          label247:
          if (paramString != null) {
            paramString.dhZ();
          }
          dhK();
          return paramString;
        }
        else
        {
          label261:
          paramString = localatul;
          paramLong = 0L;
        }
      }
      localatul = null;
    }
  }
  
  void a(String paramString, long paramLong, atuh.a parama)
  {
    if ((paramString == null) || (paramLong <= 0L) || (parama == null)) {
      return;
    }
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  cacheHandleBeforeRequest handleType:" + parama.handleType + " info_1:" + parama.cXH + " info_2:" + parama.bIa + " info_3:" + parama.YV);
    LinkedHashMap localLinkedHashMap = (LinkedHashMap)this.ab.get(paramString);
    if (localLinkedHashMap == null)
    {
      localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put(Long.valueOf(paramLong), parama);
      this.ab.put(paramString, localLinkedHashMap);
      return;
    }
    localLinkedHashMap.put(Long.valueOf(paramLong), parama);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt1, String paramString3, atwg paramatwg, long paramLong2, int paramInt2)
  {
    if (paramatwg == null)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession. request come,but session = null");
      return;
    }
    if (0L == paramatwg.sessionid)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "]  onFileRequestCome sessionid error.return");
      return;
    }
    if (this.app.a().a(paramString1, paramatwg.sessionid) != null)
    {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] request come filename:" + paramatwg.name + ", but is repeat session and return");
      return;
    }
    if (this.app.a().r(paramString1, paramatwg.sessionid))
    {
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] request come filename:" + paramatwg.name + "but it had be deleted by user");
      return;
    }
    String str = aoon.a(aojs.a(this.app.getAccount(), paramatwg.name, 0, null), paramatwg.size, 0, false, null);
    long l = anbi.d(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.app.a().b(l, paramString1, 0);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.selfUin = this.app.getAccount();
    localFileManagerEntity.setCloudType(0);
    localFileManagerEntity.fileName = paramatwg.name;
    localFileManagerEntity.fileSize = paramatwg.size;
    localFileManagerEntity.nOpType = -1;
    localFileManagerEntity.peerNick = audx.a(this.app, paramString1, null, 0);
    localFileManagerEntity.peerType = 0;
    localFileManagerEntity.peerUin = paramString1;
    localFileManagerEntity.srvTime = (1000L * paramLong1);
    localFileManagerEntity.status = 4;
    localFileManagerEntity.Uuid = null;
    localFileManagerEntity.isReaded = paramBoolean;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.nFileType = -1;
    localFileManagerEntity.nOLfileSessionId = paramatwg.sessionid;
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] - nSessionId[" + localFileManagerEntity.nSessionId + "] request come filename:" + paramatwg.name);
    this.app.a().v(localFileManagerEntity);
    this.app.a().s(localFileManagerEntity);
    this.app.a().a(paramString1, paramString2, false, paramatwg.name, paramatwg.size, false, 0, str, paramShort, paramShort, paramString3, paramInt1, l, localFileManagerEntity.nSessionId, paramLong2, paramLong1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "File Coming:" + audx.d(localFileManagerEntity));
    }
    this.app.a().a(l, localFileManagerEntity.nSessionId, paramString1, 0, 17, null, 0, null);
    if (!paramString1.equals(this.app.b().oA())) {
      this.app.q(1, true, true);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new audw.a();
      paramString2.biz = "在线文件下载";
      paramString2.LE = 0L;
      paramString2.filename = localFileManagerEntity.fileName;
      paramString2.sessionId = localFileManagerEntity.nSessionId;
      paramString2.uin = this.app.getCurrentUin();
      paramString2.qi = new HashMap();
      paramString2.qi.put("errMsg", "OnlineFile Coming!");
      paramString2.qi.put("uuid", String.valueOf(localFileManagerEntity.Uuid));
      paramString2.qi.put("uinseq", String.valueOf(localFileManagerEntity.msgUid));
      paramString2.qi.put("fUin", String.valueOf(localFileManagerEntity.peerUin));
      paramString2.qi.put("fun", "onFileRequestCome");
      audw.a(paramString2);
    }
    paramString2 = new atul(this.app, localFileManagerEntity.nSessionId);
    paramString2.m(localFileManagerEntity);
    do
    {
      try
      {
        this.aa.put(Long.valueOf(localFileManagerEntity.nSessionId), paramString2);
        paramString2.dhZ();
        if (paramString2.alI())
        {
          jp(localFileManagerEntity.nSessionId);
          dhK();
          return;
        }
      }
      finally {}
    } while (!s(paramString1, paramatwg.sessionid));
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramatwg.sessionid + "] had be handled before request come");
  }
  
  public void ak(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderCancelUpload sessionid error.return");
    }
    atul localatul;
    do
    {
      do
      {
        return;
        localatul = a(paramString, paramLong);
        if (localatul != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderCancelUpload");
      } while (this.app.a().r(paramString, paramLong));
      a(paramString, paramLong, new atuh.a(10));
      return;
      localatul.dhT();
    } while (!localatul.alI());
    jp(localatul.sessionId);
  }
  
  public void al(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderReplayComeOnRecv sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderReplayComeOnRecv");
        return;
      }
      paramString.dhX();
    } while (!paramString.alI());
    jp(paramString.sessionId);
  }
  
  public void am(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onAskUpProgressAndSessionInvaid sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onAskUpProgressAndSessionInvaid");
        return;
      }
      paramString.dib();
    } while (!paramString.alI());
    jp(paramString.sessionId);
  }
  
  public void b(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    if ((paramString1 == null) || (paramLong1 <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "]onSenderUploadCompleted  sessionid error.return");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a(paramString1, paramLong1);
        if (localObject != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "]. not find worker.onSenderUploadCompleted");
      } while (this.app.a().r(paramString1, paramLong1));
      localObject = new atuh.a(11);
      ((atuh.a)localObject).cXH = paramInt;
      ((atuh.a)localObject).bIa = paramString2;
      ((atuh.a)localObject).YV = paramLong2;
      a(paramString1, paramLong1, (atuh.a)localObject);
      return;
      if (!((atul)localObject).b(paramInt, paramString2, paramLong2)) {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed. but onlineworker handle failed!!!!");
      }
    } while (!((atul)localObject).alI());
    jp(((atul)localObject).sessionId);
  }
  
  public void c(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderUploadException sessionid error.return");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a(paramString1, paramLong);
        if (localObject != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderUploadException");
      } while (this.app.a().r(paramString1, paramLong));
      localObject = new atuh.a(12);
      ((atuh.a)localObject).cXH = paramInt;
      ((atuh.a)localObject).bIa = paramString2;
      a(paramString1, paramLong, (atuh.a)localObject);
      return;
      ((atul)localObject).ct(paramInt, paramString2);
    } while (!((atul)localObject).alI());
    jp(((atul)localObject).sessionId);
  }
  
  public boolean cf(long paramLong)
  {
    boolean bool1 = false;
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] recvOnLineFile sessionid error.return");
    }
    atul localatul;
    boolean bool2;
    do
    {
      return bool1;
      localatul = a(paramLong);
      if (localatul == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.recvOnLineFile");
        return false;
      }
      audw.b localb = new audw.b();
      localb.bJE = "recv_file_online";
      audw.a(this.app.getCurrentAccountUin(), localb);
      bool2 = localatul.alJ();
      bool1 = bool2;
    } while (!localatul.alI());
    jp(paramLong);
    return bool2;
  }
  
  public void d(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderUploadProgressNotify sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderUploadProgressNotify");
        return;
      }
      paramString.ie(paramInt1, paramInt2);
    } while (!paramString.alI());
    jp(paramString.sessionId);
  }
  
  void dhK()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new atuk(this, Looper.getMainLooper());
    }
    if (this.a == null)
    {
      this.a = new atuh.b(null);
      this.a.dhN();
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] start progress make pump thread!!!");
    }
  }
  
  void dhL()
  {
    if (this.a != null)
    {
      this.a.dhO();
      this.a = null;
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] stop progress make pump thread!!!");
    }
  }
  
  void dhM()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.aa.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      atul localatul = (atul)localEntry.getValue();
      localatul.jw(l1);
      if (localatul.alI())
      {
        long l2 = ((Long)localEntry.getKey()).longValue();
        int i = this.aa.size();
        localIterator.remove();
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l2 + "]. remove the worker..[" + i + " - " + this.aa.size() + "]");
      }
    }
    if (this.aa.size() == 0) {
      dhL();
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    stop();
    super.finalize();
  }
  
  void jp(long paramLong)
  {
    try
    {
      this.aa.remove(Long.valueOf(paramLong));
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. remove the worker");
      return;
    }
    finally {}
  }
  
  public void js(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] PauseTrans sessionid error.return");
    }
    atul localatul;
    do
    {
      return;
      localatul = a(paramLong);
      if (localatul == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.PauseTrans");
        return;
      }
      localatul.dhU();
      if (this.app.a().cb(paramLong))
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] had be deleted by user. stop it");
        localatul.stop();
      }
    } while (!localatul.alI());
    jp(paramLong);
  }
  
  public void jt(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] ResumeTrans sessionid error.return");
    }
    atul localatul;
    do
    {
      return;
      localatul = a(paramLong);
      if (localatul == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.ResumeTrans");
        return;
      }
      localatul.dhV();
    } while (!localatul.alI());
    jp(paramLong);
  }
  
  public void ju(long paramLong)
  {
    try
    {
      atul localatul = (atul)this.aa.get(Long.valueOf(paramLong));
      if (localatul != null) {
        localatul.stop();
      }
      jp(paramLong);
      return;
    }
    finally {}
  }
  
  public void k(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onRecvOnLineFileResult sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onRecvOnLineFileResult");
        return;
      }
      paramString.Jk(paramBoolean);
    } while (!paramString.alI());
    jp(paramString.sessionId);
  }
  
  public void l(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onAskSenderUpProgressResult sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onAskSenderUpProgressResult");
        return;
      }
      paramString.Jl(paramBoolean);
    } while (!paramString.alI());
    jp(paramString.sessionId);
  }
  
  public void q(String paramString, long paramLong, int paramInt)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onFileRequestBeHandledByPC sessionid error.return");
    }
    atul localatul;
    do
    {
      do
      {
        return;
        localatul = a(paramString, paramLong);
        if (localatul != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onFileRequestBeHandledByPC");
      } while (this.app.a().r(paramString, paramLong));
      a(paramString, paramLong, new atuh.a(paramInt));
      return;
      localatul.Ob(paramInt);
    } while (!localatul.alI());
    jp(localatul.sessionId);
  }
  
  boolean s(String paramString, long paramLong)
  {
    boolean bool2;
    if ((paramString == null) || (paramLong <= 0L))
    {
      bool2 = false;
      return bool2;
    }
    LinkedHashMap localLinkedHashMap = (LinkedHashMap)this.ab.get(paramString);
    Object localObject;
    boolean bool1;
    if (localLinkedHashMap != null)
    {
      localObject = (atuh.a)localLinkedHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  isBeHandledBeforeRequest handleType:" + ((atuh.a)localObject).handleType + " info_1:" + ((atuh.a)localObject).cXH + " info_2:" + ((atuh.a)localObject).bIa + " info_3:" + ((atuh.a)localObject).YV);
        switch (((atuh.a)localObject).handleType)
        {
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          bool1 = false;
          localLinkedHashMap.remove(Long.valueOf(paramLong));
          if (localLinkedHashMap.size() == 0) {
            this.ab.remove(paramString);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramLong = anaz.gQ();
      bool2 = bool1;
      if (paramLong - this.YU < 3600L) {
        break;
      }
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  isBeHandledBeforeRequest handleType. start clear something");
      this.YU = paramLong;
      bool2 = bool1;
      if (this.ab.size() <= 0) {
        break;
      }
      paramString = this.ab.entrySet().iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramString.hasNext()) {
          break;
        }
        localLinkedHashMap = (LinkedHashMap)((Map.Entry)paramString.next()).getValue();
        if ((localLinkedHashMap != null) && (localLinkedHashMap.size() > 0))
        {
          localObject = localLinkedHashMap.entrySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label596;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            atuh.a locala = (atuh.a)localEntry.getValue();
            long l = ((Long)localEntry.getKey()).longValue();
            if (locala != null)
            {
              if (paramLong - locala.time < 7200L) {
                continue;
              }
              QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]  isBeHandledBeforeRequest and clear it.handleType:" + locala.handleType + " info_1:" + locala.cXH + " info_2:" + locala.bIa + " info_3:" + locala.YV);
              ((Iterator)localObject).remove();
              continue;
              q(paramString, paramLong, ((atuh.a)localObject).handleType);
              bool1 = true;
              break;
              ak(paramString, paramLong);
              bool1 = true;
              break;
              b(paramString, paramLong, ((atuh.a)localObject).cXH, ((atuh.a)localObject).bIa, ((atuh.a)localObject).YV);
              bool1 = true;
              break;
              c(paramString, paramLong, ((atuh.a)localObject).cXH, ((atuh.a)localObject).bIa);
              bool1 = true;
              break;
            }
            ((Iterator)localObject).remove();
          }
          label596:
          if (localLinkedHashMap.size() == 0) {
            paramString.remove();
          }
        }
        else
        {
          paramString.remove();
        }
      }
      bool1 = false;
    }
  }
  
  public void stop()
  {
    dhL();
    Iterator localIterator = this.aa.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((atul)localEntry.getValue()).stop();
      long l = ((Long)localEntry.getKey()).longValue();
      int i = this.aa.size();
      localIterator.remove();
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]. stop. and remove the worker..[" + i + " - " + this.aa.size() + "]");
    }
  }
  
  class a
  {
    long YV;
    String bIa;
    int cXH;
    int handleType;
    long time;
    
    a(int paramInt)
    {
      this.handleType = paramInt;
      this.time = anaz.gQ();
    }
  }
  
  public class b
  {
    private Timer mTimer;
    
    private b() {}
    
    /* Error */
    void dhN()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 26	atuh$b:mTimer	Ljava/util/Timer;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnull +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: new 29	java/util/Timer
      //   18: dup
      //   19: invokespecial 30	java/util/Timer:<init>	()V
      //   22: putfield 26	atuh$b:mTimer	Ljava/util/Timer;
      //   25: aload_0
      //   26: getfield 26	atuh$b:mTimer	Ljava/util/Timer;
      //   29: new 32	com/tencent/tim/filemanager/core/OnlineFileSessionCenter$UploadProgressMakeEvtPump$1
      //   32: dup
      //   33: aload_0
      //   34: invokespecial 35	com/tencent/tim/filemanager/core/OnlineFileSessionCenter$UploadProgressMakeEvtPump$1:<init>	(Latuh$b;)V
      //   37: ldc2_w 36
      //   40: ldc2_w 36
      //   43: invokevirtual 41	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
      //   46: ldc 43
      //   48: iconst_1
      //   49: ldc 45
      //   51: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   54: goto -43 -> 11
      //   57: astore_1
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_1
      //   61: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	62	0	this	b
      //   6	2	1	localTimer	Timer
      //   57	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	57	finally
      //   14	54	57	finally
    }
    
    void dhO()
    {
      try
      {
        if (this.mTimer != null)
        {
          this.mTimer.cancel();
          this.mTimer = null;
        }
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  exit. . .");
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atuh
 * JD-Core Version:    0.7.0.1
 */