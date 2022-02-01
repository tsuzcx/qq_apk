import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.2;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.3;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.4;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.5;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.6;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ajeb
  implements Handler.Callback, Comparator<MessageRecord>
{
  public static String TAG = "MsgBackup_MsgBackupController";
  private static int dih = 500;
  private static int dii = 5000;
  private static int dij = 1000;
  private static int dik = 10000;
  private List<ajdz> CZ;
  private MqqHandler I;
  private HandlerThread Q;
  private ajek a;
  private AtomicInteger bx = new AtomicInteger(0);
  private AtomicInteger by = new AtomicInteger(0);
  private int dil;
  private AtomicBoolean dq = new AtomicBoolean(false);
  private ConcurrentHashMap<String, ajep> fT;
  private ConcurrentHashMap<String, ajel> fU;
  private ConcurrentHashMap<String, ajel> fV;
  private ConcurrentHashMap<String, ajel> fW;
  private ConcurrentHashMap<String, String> fX;
  private QQAppInterface mApp;
  private HandlerThread mSubThread;
  private Executor p;
  private MqqHandler t;
  private ArrayList<String> xG = new ArrayList();
  private ArrayList<String> xH = new ArrayList();
  
  public ajeb(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1) {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
    }
    this.mApp = ((QQAppInterface)localObject);
    if (this.mSubThread == null)
    {
      this.mSubThread = ThreadManager.newFreeHandlerThread("MsgbackupController_request", 5);
      this.mSubThread.start();
      this.t = new MqqHandler(this.mSubThread.getLooper(), this);
    }
    if (this.I == null)
    {
      this.Q = ThreadManager.newFreeHandlerThread("MsgbackupController_flow", 5);
      this.Q.start();
      this.I = new MqqHandler(this.Q.getLooper(), new ajec(this));
    }
    if (this.p == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      ajgv.b(TAG, "MsgBackupController cpuCount = %d ", new Object[] { Integer.valueOf(i) });
      paramQQAppInterface = new ThreadPoolParams();
      int j = i * 2 + 1;
      paramQQAppInterface.corePoolsize = i;
      paramQQAppInterface.maxPooolSize = j;
      paramQQAppInterface.priority = 5;
      paramQQAppInterface.poolThreadName = "msgbackupThreadPool";
      this.p = ThreadManager.newFreeThreadPool(paramQQAppInterface);
      dii = dih * j;
      dik = dij * j;
    }
    this.fU = new ConcurrentHashMap();
    this.fV = new ConcurrentHashMap();
    this.fW = new ConcurrentHashMap();
    this.fT = new ConcurrentHashMap();
    this.fX = new ConcurrentHashMap();
    this.CZ = new ArrayList();
    paramQQAppInterface = new ajei(this.mApp);
    localObject = new ajen(this.mApp);
    ajed localajed = new ajed(this.mApp);
    this.CZ.add(paramQQAppInterface);
    this.CZ.add(localObject);
    this.CZ.add(localajed);
  }
  
  private void a(ajel paramajel)
  {
    this.fW.clear();
    this.fX.clear();
    String str = ap(paramajel.uin, paramajel.uinType);
    this.fW.put(str, paramajel);
    this.I.sendEmptyMessage(5);
    ajgu.MA("statis_qianchums_start");
  }
  
  private void a(List<MsgBackupResEntity> paramList, ajel paramajel, int paramInt)
  {
    ajgv.c(TAG, "segmentExcuteQianru step:query res.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label286;
      }
      MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
      Object localObject2 = this.CZ.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (ajdz)((Iterator)localObject2).next();
        if (!((ajdz)localObject1).b(localMsgBackupResEntity)) {
          break;
        }
        ajgt.dxs();
        localObject2 = ajgt.a;
        ((ajgs)localObject2).acs += 1L;
        localObject2 = ((ajdz)localObject1).a(null, localMsgBackupResEntity);
        if (((ajem)localObject2).aqx())
        {
          localObject1 = ((ajem)localObject2).a((ajdz)localObject1, null, localMsgBackupResEntity);
          ajgv.b(TAG, "segmentExcuteQianru step:need res:uin = %s,uinType = %d,msgType = %d,filePath = %s,clientPath = %s, filesize = %s", new Object[] { paramajel.uin, Integer.valueOf(paramajel.uinType), Integer.valueOf(localMsgBackupResEntity.msgType), localMsgBackupResEntity.filePath, localObject1, Long.valueOf(localMsgBackupResEntity.fileSize) });
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            ajgv.b(TAG, "segmentExcuteQianru step:need res,but clientPath is empty", new Object[0]);
          }
          else if (!this.fX.containsKey(localObject1))
          {
            this.fX.put(localObject1, "");
            p(localMsgBackupResEntity.filePath, (String)localObject1, localMsgBackupResEntity.fileSize);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        label286:
        paramajel.diu += paramList.size();
        this.dil -= paramInt;
        ajgv.c(TAG, "segmentExcuteQianru step segment startNext,,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramajel.diu), Integer.valueOf(this.dil), Integer.valueOf(paramajel.totalCount) });
        if (paramajel.diu >= paramajel.totalCount)
        {
          this.dil = 0;
          if (this.fX.size() > 0)
          {
            p(null, null, 0L);
            this.fX.clear();
            ajgu.MA("statis_qianchums_end");
            ajgu.dxy();
            return;
          }
          this.I.removeCallbacksAndMessages(null);
          this.I.sendEmptyMessage(6);
          continue;
        }
        this.I.removeCallbacksAndMessages(null);
      }
      finally {}
      this.I.sendEmptyMessage(5);
    }
  }
  
  private void aR(Message paramMessage)
  {
    if (!this.dq.get()) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          dwv();
          return;
        case 2: 
          dww();
          return;
        case 3: 
          dwz();
          return;
        case 4: 
          dwy();
          return;
        case 6: 
          dwu();
          return;
        }
      } while (this.fW.size() <= 0);
      paramMessage = (ajel)this.fW.elements().nextElement();
    } while (paramMessage == null);
    d(paramMessage);
  }
  
  private String ap(String paramString, int paramInt)
  {
    return String.format("%s_%d", new Object[] { paramString, Integer.valueOf(ajgv.cS(paramInt)) });
  }
  
  private void c(ajel paramajel)
  {
    paramajel = ajgv.a(paramajel);
    ajgv.c(TAG, "analysisFileMeta:start dbName = %s ", new Object[] { paramajel });
    ajgv.aqD();
    paramajel = new ajep(paramajel);
    Object localObject1 = paramajel.fC();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MsgBackupExtraEntity)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).name)) && (((MsgBackupExtraEntity)localObject2).name.equalsIgnoreCase("key_meta")) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).value)))
        {
          ajee.bQR = ((MsgBackupExtraEntity)localObject2).value;
          localObject2 = (String)ajee.fY.get(((MsgBackupExtraEntity)localObject2).value);
          ajee.bQT = (String)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            ajee.a().dwD();
          }
        }
      }
    }
    paramajel.close();
  }
  
  private void dwu()
  {
    dwx();
  }
  
  private void dwv()
  {
    if (this.a != null)
    {
      if (this.a.curIndex != -1) {
        break label268;
      }
      ajgu.track(null, "single_uin_cost");
    }
    for (;;)
    {
      Object localObject1 = this.a;
      ((ajek)localObject1).curIndex += 1;
      int i = this.a.curIndex;
      int j = this.a.totalCount;
      if (i == 0) {
        ajgu.MA("statis_qianchums_start");
      }
      if (i == j)
      {
        ajgu.MA("statis_qianchums_end");
        ajgu.dxx();
      }
      if (i < j)
      {
        localObject1 = (String)this.xG.get(i);
        localObject1 = (ajel)this.fU.get(localObject1);
        ((ajel)localObject1).div = 0;
        Object localObject2 = ajgv.a((ajel)localObject1);
        ajep.Mu((String)localObject2);
        localObject2 = new ajep((String)localObject2);
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(ajee.bQR))
        {
          ajgv.c(TAG, "file meta is %s, key is %s", new Object[] { ajee.bQR, ajee.bQS });
          MsgBackupExtraEntity localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "key_meta";
          localMsgBackupExtraEntity.value = ajee.bQR;
          localArrayList.add(localMsgBackupExtraEntity);
          localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "db_version";
          localMsgBackupExtraEntity.value = String.valueOf(1);
          localArrayList.add(localMsgBackupExtraEntity);
        }
        ((ajep)localObject2).lt(localArrayList);
        ((ajep)localObject2).close();
        b((ajel)localObject1);
      }
      return;
      label268:
      ajgu.track("single_uin_cost", null);
      ajgu.track(null, "single_uin_cost");
    }
  }
  
  private void dww()
  {
    if (this.a != null)
    {
      int i = this.a.curIndex;
      int j = this.a.totalCount;
      if (i < j)
      {
        Object localObject = (String)this.xG.get(i);
        localObject = (ajel)this.fU.get(localObject);
        ajgv.c(TAG, "singleNextQianchu curUin = %s,curQueryCount = %d,sessionMsgTotalCount = %d,mPendingMsgCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(((ajel)localObject).div), Integer.valueOf(((ajel)localObject).totalCount), Integer.valueOf(this.dil) });
        if ((((ajel)localObject).div < ((ajel)localObject).totalCount) && (this.dil < dii)) {
          b((ajel)localObject);
        }
      }
      ajgv.c(TAG, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  private void dwx()
  {
    ajgp.b().kq(1);
  }
  
  private void dwy()
  {
    if (this.a != null)
    {
      int i = this.a.curIndex;
      int j = this.a.totalCount;
      if (i < j)
      {
        Object localObject = (String)this.xH.get(i);
        localObject = (ajel)this.fV.get(localObject);
        if ((((ajel)localObject).div < ((ajel)localObject).totalCount) && (this.dil < dii)) {
          e((ajel)localObject);
        }
        ajgv.c(TAG, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d,querySingleIndex = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((ajel)localObject).div) });
      }
    }
  }
  
  private void dwz()
  {
    if (this.a != null)
    {
      Object localObject = this.a;
      ((ajek)localObject).curIndex += 1;
      int i = this.a.curIndex;
      int j = this.a.totalCount;
      ajgv.c(TAG, "nextDaoru curIndex = %d,totalCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i == 0) {
        ajgu.MA("statis_qianchums_start");
      }
      if (i == j)
      {
        ajgu.MA("statis_qianchums_end");
        ajgu.dxz();
      }
      if (i < j)
      {
        localObject = (String)this.xH.get(i);
        localObject = (ajel)this.fV.get(localObject);
        ((ajel)localObject).div = 0;
        ajgv.b(TAG, "nextDaoru uin = %s,uinType = %d", new Object[] { ((ajel)localObject).uin, Integer.valueOf(((ajel)localObject).uinType) });
        e((ajel)localObject);
      }
    }
  }
  
  private void p(String paramString1, String paramString2, long paramLong)
  {
    ajgp.b().q(paramString1, paramString2, paramLong);
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.istroop == 1) {
      return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
    }
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
  
  public void a(ajek paramajek)
  {
    if ((!this.dq.get()) || (!ajgv.aqD())) {
      ajgv.c(TAG, "handleRequest checkDBDirs result = false,requestType = %d ", new Object[] { Integer.valueOf(paramajek.dir) });
    }
    do
    {
      return;
      switch (paramajek.dir)
      {
      default: 
        return;
      case 0: 
        int i = paramajek.bj.size();
        ajgv.c(TAG, "requestQianchu start,request.dataList.size() = %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          break label125;
        }
      }
    } while (paramajek.a == null);
    paramajek.a.a(1, paramajek, null);
    return;
    label125:
    b(paramajek);
    return;
    ajgv.c(TAG, "requestQianru start ", new Object[0]);
    ajel localajel = new ajel();
    ajgv.a(paramajek.bQV.substring(paramajek.bQV.lastIndexOf("/") + 1), localajel);
    ajee.bQU = localajel.uin;
    ajee.dip = localajel.uinType;
    a(localajel);
    return;
    ajgv.c(TAG, "requestDaoru start ", new Object[0]);
    c(paramajek);
  }
  
  public void a(ajek paramajek, int paramInt)
  {
    this.dq.set(true);
    ajgv.c(TAG, "sendRequest is called from = %d", new Object[] { Integer.valueOf(paramInt) });
    this.a = paramajek;
    if (ajgv.cow)
    {
      if (paramInt == 10000)
      {
        localMessage = this.t.obtainMessage(5);
        localMessage.obj = paramajek;
        this.t.sendMessageDelayed(localMessage, 100L);
        return;
      }
      if (paramInt == 10001)
      {
        ajee.bQR = null;
        ajee.bQT = null;
        localMessage = this.t.obtainMessage(7);
        localMessage.obj = paramajek;
        this.t.sendMessageDelayed(localMessage, 100L);
        return;
      }
      localMessage = this.t.obtainMessage(0);
      localMessage.obj = paramajek;
      this.t.sendMessageDelayed(localMessage, 100L);
      return;
    }
    Message localMessage = this.t.obtainMessage(0);
    localMessage.obj = paramajek;
    this.t.sendMessage(localMessage);
  }
  
  public void a(ajep paramajep, ajel paramajel, List<MsgBackupMsgEntity> paramList)
  {
    paramList.size();
    Object localObject2 = this.mApp.a().a();
    ajgv.c(TAG, "segmentDaoru step:query done ,msgEntity.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject1 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject3 = (MsgBackupMsgEntity)paramList.next();
      if (((MsgBackupMsgEntity)localObject3).extensionData == null)
      {
        i += 1;
        ajgv.c(TAG, "segmentDaoru step has encounter msgEntity.extensionData == null,msgType = %d,invalidMsgCount = %d", new Object[] { Integer.valueOf(((MsgBackupMsgEntity)localObject3).msgType), Integer.valueOf(i) });
      }
      else
      {
        try
        {
          localObject3 = ((ajes)localObject2).a((MsgBackupMsgEntity)localObject3);
          if (localObject3 != null) {
            ((List)localObject1).add(localObject3);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(TAG, 1, "transToMessageRecord " + localThrowable);
        }
      }
    }
    ajgv.b(TAG, "segmentDaoru step:trans done ,msg.size = %d ", new Object[] { Integer.valueOf(((List)localObject1).size()) });
    if (((List)localObject1).size() > 0) {
      localObject2 = ((List)localObject1).iterator();
    }
    label533:
    label815:
    label1204:
    label1215:
    label1219:
    label1224:
    for (;;)
    {
      label243:
      Object localObject4;
      Object localObject5;
      Iterator localIterator1;
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        if (ajlg.P((ChatMessage)localObject4))
        {
          localObject5 = paramajep.j(((MessageRecord)localObject4).msgBackupMsgSeq, ((MessageRecord)localObject4).msgBackupMsgRandom);
          if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
            continue;
          }
          localIterator1 = ((List)localObject5).iterator();
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            paramList = (MsgBackupResEntity)localIterator1.next();
          } while (paramList.msgType != 4);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label1224;
        }
        paramList = ajei.b((MessageRecord)localObject4, paramList);
        ajgv.b(TAG, "multimsg_tempFilPath = %s", new Object[] { paramList });
        paramList = new File(paramList);
        if (!paramList.exists()) {
          break label243;
        }
        ajgv.b(TAG, "multimsg_tempFilPath exist = %b", new Object[] { Boolean.valueOf(true) });
        paramList = aqhq.fileToBytes(paramList);
        paramList = this.mApp.a().a(paramList, null, (MessageRecord)localObject4, null);
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label243;
        }
        localIterator1 = ajei.d(paramList).iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label533;
          }
          MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
          Iterator localIterator2 = this.CZ.iterator();
          if (localIterator2.hasNext())
          {
            ajdz localajdz = (ajdz)localIterator2.next();
            if (!localajdz.aI(localMessageRecord)) {
              break;
            }
            localajdz.f(localMessageRecord, (List)localObject5);
          }
        }
        this.mApp.a().a((MessageRecord)localObject4, paramList, null);
        break label243;
        localObject5 = this.CZ.iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label243;
        }
        paramList = (ajdz)((Iterator)localObject5).next();
        if (!paramList.aI((MessageRecord)localObject4)) {
          break;
        }
        localObject5 = paramajep.j(((MessageRecord)localObject4).msgBackupMsgSeq, ((MessageRecord)localObject4).msgBackupMsgRandom);
        if (localObject5 != null) {}
        for (i = ((List)localObject5).size();; i = 0)
        {
          ajgv.b(TAG, "segmentDaoru step:rich process ,query.res.size = %d ", new Object[] { Integer.valueOf(i) });
          paramList.f((MessageRecord)localObject4, (List)localObject5);
          break;
        }
        paramajep = new ArrayList();
        localObject2 = (MessageRecord)((List)localObject1).get(0);
        paramList = this.mApp.b().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, null);
        localObject4 = TAG;
        if (paramList != null)
        {
          i = paramList.size();
          ajgv.c((String)localObject4, "segmentDaoru step:mainMsg.size = %d,uin = %s,istroop = %d ", new Object[] { Integer.valueOf(i), ((MessageRecord)localObject2).frienduin, Integer.valueOf(((MessageRecord)localObject2).istroop) });
          localObject1 = ((List)localObject1).iterator();
        }
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((paramList == null) || (paramList.size() <= 0)) {
              break label1215;
            }
            localObject4 = paramList.iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = (MessageRecord)((Iterator)localObject4).next();
                if ((((MessageRecord)localObject2).istroop == 1) || (((MessageRecord)localObject2).istroop == 1026) || (((MessageRecord)localObject2).istroop == 3000))
                {
                  if (((MessageRecord)localObject2).shmsgseq == 0L) {
                    ajgv.c(TAG, "segmentDaoru step:msgfilter duplicated troopMsg ,mr.msgshseq = 0.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg, Integer.valueOf(((MessageRecord)localObject2).msgtype) });
                  }
                  if ((((MessageRecord)localObject2).shmsgseq != ((MessageRecord)localObject5).shmsgseq) || (((MessageRecord)localObject2).msgtype != ((MessageRecord)localObject5).msgtype)) {
                    continue;
                  }
                  ajgv.c(TAG, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg, Integer.valueOf(((MessageRecord)localObject2).msgtype) });
                  i = 1;
                }
              }
            }
          }
          for (;;)
          {
            if (i != 0) {
              break label1219;
            }
            paramajep.add(localObject2);
            break label772;
            i = 0;
            break;
            if ((((MessageRecord)localObject2).msgUid != ((MessageRecord)localObject5).msgUid) || (((MessageRecord)localObject2).msgtype != ((MessageRecord)localObject5).msgtype)) {
              break label815;
            }
            ajgv.c(TAG, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg });
            i = 1;
            continue;
            ajgv.c(TAG, "segmentDaoru step:msgfilter done ,msgNew.size = %d ,uin = %s", new Object[] { Integer.valueOf(paramajep.size()), paramajel.uin });
            if (paramajep.size() > 0)
            {
              Collections.sort(paramajep, this);
              this.mApp.b().fs(paramajep);
              if (ajgv.cov)
              {
                ((MessageRecord)paramajep.get(0)).getTableName();
                paramajep = this.mApp.b().b(paramajel.uin, paramajel.uinType, null);
                if (paramajep != null) {
                  break label1204;
                }
              }
            }
            for (i = 0;; i = paramajep.size())
            {
              ajgv.b(TAG, "daoru step:seqmentDaoru done result size =  %d", new Object[] { Integer.valueOf(i) });
              ajgv.c(TAG, "segmentDaoru step:saveToDb done ", new Object[0]);
              return;
            }
            i = 0;
          }
        }
        paramList = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ajep paramajep, ajel paramajel, List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramajep == null) || (paramList == null)) {
      return;
    }
    int i = paramList.size();
    a(paramQQAppInterface, paramajep, paramList);
    for (;;)
    {
      try
      {
        paramajel.diu = (i + paramajel.diu);
        this.dil -= paramInt;
        ajgv.c(TAG, "segmentExcuteQianchu step segment startNext,startIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramajel.diu), Integer.valueOf(this.dil), Integer.valueOf(paramajel.totalCount) });
        if (paramajel.diu >= paramajel.totalCount)
        {
          if ((this.a != null) && (this.a.a != null))
          {
            paramQQAppInterface = new ajew();
            paramQQAppInterface.uin = paramajel.uin;
            paramQQAppInterface.uinType = paramajel.uinType;
            this.a.a.a(this.a, paramQQAppInterface);
          }
          ajgv.c(TAG, "segmentExcuteQianchu step this session has process done ,uin = %s,uintype = %d,msgSize = %d", new Object[] { paramajel.uin, Integer.valueOf(paramajel.uinType), Integer.valueOf(paramajep.Gk()) });
          this.fT.remove(paramajep.getDbName());
          paramajep.close();
          ajej.dwK();
          ajgu.MA("statis_qianchums_end");
          this.I.removeCallbacksAndMessages(null);
          this.I.sendEmptyMessage(1);
          return;
        }
      }
      finally {}
      this.I.sendEmptyMessage(2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ajep paramajep, List<MessageRecord> paramList)
  {
    if ((paramQQAppInterface == null) || (paramajep == null) || (paramList == null)) {
      return;
    }
    paramList.size();
    paramList = bk(paramList);
    paramQQAppInterface = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    MessageRecord localMessageRecord;
    Object localObject3;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label492;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
      Object localObject4;
      if (ajlg.P((ChatMessage)localMessageRecord))
      {
        localObject4 = this.mApp.a().a(localMessageRecord);
        Object localObject5 = ajei.d((HashMap)localObject4);
        if (((List)localObject5).size() > 0)
        {
          localObject3 = new ArrayList();
          localObject5 = ((List)localObject5).iterator();
          for (;;)
          {
            if (!((Iterator)localObject5).hasNext()) {
              break label227;
            }
            localObject6 = (MessageRecord)((Iterator)localObject5).next();
            Iterator localIterator = this.CZ.iterator();
            if (localIterator.hasNext())
            {
              ajdz localajdz = (ajdz)localIterator.next();
              if (!localajdz.aI((MessageRecord)localObject6)) {
                break;
              }
              localajdz.e((MessageRecord)localObject6, (List)localObject1);
              ((ArrayList)localObject3).addAll((Collection)localObject1);
              ((ArrayList)localObject1).clear();
            }
          }
          label227:
          long l1 = ajgv.c(localMessageRecord);
          long l2 = ajgv.d(localMessageRecord);
          localObject5 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (MsgBackupResEntity)((Iterator)localObject5).next();
            ((MsgBackupResEntity)localObject6).msgSeq = l1;
            ((MsgBackupResEntity)localObject6).msgRandom = l2;
          }
          localObject4 = this.mApp.a().a((HashMap)localObject4, null, true);
          localObject5 = ajgv.mc(((MessageForStructing)localMessageRecord).structingMsg.mFileName);
          aqhq.writeFile((byte[])localObject4, (String)localObject5);
          Object localObject6 = new MsgBackupResEntity();
          ((MsgBackupResEntity)localObject6).msgSeq = l1;
          ((MsgBackupResEntity)localObject6).msgRandom = l2;
          ((MsgBackupResEntity)localObject6).filePath = ((String)localObject5);
          ((MsgBackupResEntity)localObject6).fileSize = localObject4.length;
          ((MsgBackupResEntity)localObject6).msgSubType = 10;
          ((MsgBackupResEntity)localObject6).msgType = 4;
          ((MsgBackupResEntity)localObject6).extraDataStr = ajei.b(this.mApp.getCurrentUin(), localMessageRecord);
          paramQQAppInterface.add(localObject6);
          if (((ArrayList)localObject3).size() > 0) {
            paramQQAppInterface.addAll((Collection)localObject3);
          }
        }
      }
      else
      {
        localObject3 = this.CZ.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ajdz)((Iterator)localObject3).next();
          if (!((ajdz)localObject4).aI(localMessageRecord)) {
            break;
          }
          ((ajdz)localObject4).e(localMessageRecord, (List)localObject1);
          paramQQAppInterface.addAll((Collection)localObject1);
          ((ArrayList)localObject1).clear();
        }
      }
    }
    label492:
    localObject1 = this.mApp.a().a();
    localObject2 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localMessageRecord = (MessageRecord)paramList.next();
      try
      {
        localObject3 = ((ajes)localObject1).a(localMessageRecord);
        if (localObject3 == null) {
          break label604;
        }
        ((ArrayList)localObject2).add(localObject3);
      }
      catch (Throwable localThrowable)
      {
        QLog.e(TAG, 1, "transToBackupEntity : " + localThrowable);
      }
      continue;
      label604:
      ajgv.b(TAG, "segmentExcuteQianchu generate pb failed ..unsupport not chatMessage _id = %d,msgtype = %d .mr =%s ", new Object[] { Long.valueOf(localThrowable.getId()), Integer.valueOf(localThrowable.msgtype), localThrowable.toString() });
    }
    ajgv.c(TAG, "segmentExcuteQianchu step segment msg process  + msg.size = %d ", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
    paramajep.lr((List)localObject2);
    paramajep.ls(paramQQAppInterface);
    ajgv.c(TAG, "segmentExcuteQianchu step segment insert db done", new Object[0]);
  }
  
  public void b(ajek paramajek)
  {
    ajgu.acK = 0L;
    HashSet localHashSet = paramajek.bj;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      ajgv.c(TAG, "qianchu no recentdBaseData ", new Object[0]);
      return;
    }
    this.xG.clear();
    this.fU.clear();
    this.fT.clear();
    ajej.clear();
    ajgu.dxw();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).qx();
      int i = ((RecentBaseData)localObject).ng();
      ajgv.c(TAG, "requestQianchu uin = %s ", new Object[] { str });
      localObject = new ajel();
      ((ajel)localObject).uin = str;
      ((ajel)localObject).uinType = i;
      ((ajel)localObject).dir = 0;
      ((ajel)localObject).startTime = paramajek.startTime;
      ((ajel)localObject).endTime = paramajek.endTime;
      ((ajel)localObject).cnN = paramajek.cnN;
      ((ajel)localObject).div = -1;
      ((ajel)localObject).diw = 0;
      str = ap(str, i);
      this.xG.add(str);
      this.fU.put(str, localObject);
    }
    paramajek.totalCount = localHashSet.size();
    paramajek.curIndex = -1;
    this.I.sendEmptyMessage(1);
  }
  
  public void b(ajel paramajel)
  {
    Object localObject1 = ajgv.a(paramajel);
    ajgv.c(TAG, "singleExcuteQianchu,start uin = %s,dbPath = %s,request.startQueryIndex = %d ", new Object[] { paramajel.uin, localObject1, Integer.valueOf(paramajel.diw) });
    if (this.fT.get(localObject1) == null)
    {
      localObject2 = new ajep((String)localObject1);
      this.fT.put(localObject1, localObject2);
    }
    localObject1 = (ajep)this.fT.get(localObject1);
    Object localObject2 = MessageRecord.getTableName(paramajel.uin, paramajel.uinType);
    QQMessageFacade localQQMessageFacade = this.mApp.b();
    int j;
    int k;
    int m;
    if (paramajel.totalCount == 0)
    {
      j = localQQMessageFacade.a((String)localObject2, paramajel.startTime, paramajel.endTime, paramajel.cnN);
      k = localQQMessageFacade.b((String)localObject2, paramajel.startTime, paramajel.endTime, paramajel.cnN);
      m = j + k;
      paramajel.dis = j;
      paramajel.dit = k;
      paramajel.totalCount = m;
      if ((m != 0) && ((paramajel.div < m) || (this.dil != 0))) {
        break label301;
      }
      if ((this.a != null) && (this.a.a != null))
      {
        localObject2 = new ajew();
        ((ajew)localObject2).uin = paramajel.uin;
        ((ajew)localObject2).uinType = paramajel.uinType;
        this.a.a.a(this.a, localObject2);
      }
      ((ajep)localObject1).close();
      this.I.sendEmptyMessage(1);
      return;
      break label766;
      break label766;
    }
    label280:
    label301:
    label1383:
    label1386:
    label1389:
    for (;;)
    {
      j = paramajel.dis;
      k = paramajel.dit;
      m = paramajel.totalCount;
      break;
      ajgv.c(TAG, "singleExcuteQianchu dbName = %s,quickDBCount = %d,slowDBCount = %d,totalCount = %d,request.queryIndex = %d,queryCount = %d", new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramajel.diw), Integer.valueOf(paramajel.div) });
      int i;
      Object localObject3;
      Object localObject4;
      label1276:
      if (k == 0)
      {
        i = paramajel.div;
        if (i < paramajel.dis)
        {
          for (;;)
          {
            k = paramajel.diw + 1;
            localObject3 = localQQMessageFacade.a((String)localObject2, paramajel.startTime, paramajel.endTime, k, dih, paramajel.cnN);
            ajgv.b(TAG, "singleExcuteQianchu querySql = %s", new Object[] { localObject3 });
            localObject3 = localQQMessageFacade.g((String)localObject3, (String)localObject2);
            if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
              break label654;
            }
            m = ((List)localObject3).size();
            ajgv.b(TAG, "singleExcuteQianchu queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
            localObject4 = new MsgBackupController.2(this, (ajep)localObject1, paramajel, (List)localObject3, k);
            this.dil += dih;
            i += dih;
            paramajel.div += dih;
            paramajel.diw = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
            ajgv.b(TAG, "singleExcuteQianchu querySql lastQueryIndex = %d", new Object[] { Integer.valueOf(paramajel.diw) });
            this.p.execute((Runnable)localObject4);
            ajgv.b(TAG, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.dil), Integer.valueOf(paramajel.diw) });
            if ((i >= j) || (this.dil >= dii)) {
              break;
            }
          }
          ajgv.b(TAG, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.dil) });
          if ((this.dil == 0) && (this.a != null) && (this.a.a != null))
          {
            localObject2 = new ajew();
            ((ajew)localObject2).uin = paramajel.uin;
            ((ajew)localObject2).uinType = paramajel.uinType;
            this.a.a.a(this.a, localObject2);
            this.I.sendEmptyMessage(1);
            ((ajep)localObject1).close();
          }
        }
      }
      else
      {
        i = paramajel.div;
        label766:
        if (i < m)
        {
          if (i < k)
          {
            j = paramajel.diw + 1;
            localObject3 = localQQMessageFacade.f(localQQMessageFacade.a((String)localObject2, paramajel.startTime, paramajel.endTime, j, dih, paramajel.cnN), (String)localObject2);
            if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
              break label1386;
            }
            m = ((List)localObject3).size();
            ajgv.b(TAG, "singleExcuteQianchu slowDB queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
            localObject4 = new MsgBackupController.3(this, (ajep)localObject1, paramajel, (List)localObject3, j);
            this.dil += dih;
            i += dih;
            paramajel.div += dih;
            paramajel.diw = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
            this.p.execute((Runnable)localObject4);
            ajgv.b(TAG, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.dil), Integer.valueOf(paramajel.diw) });
            j = i;
            if (i < k) {
              if (this.dil < dii) {
                break label1383;
              }
            }
          }
          for (j = i;; j = i)
          {
            if (j < k) {
              break label1389;
            }
            paramajel.div = k;
            paramajel.diw = 0;
            return;
            int n = i - k;
            i = n;
            if (j <= 0) {
              break;
            }
            i = n;
            if (n >= j) {
              break;
            }
            i = n;
            for (;;)
            {
              k = paramajel.diw + 1;
              localObject3 = localQQMessageFacade.g(localQQMessageFacade.a((String)localObject2, paramajel.startTime, paramajel.endTime, k, dih, paramajel.cnN), (String)localObject2);
              if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
                break label1276;
              }
              m = ((List)localObject3).size();
              ajgv.b(TAG, "singleExcuteQianchu quickDB queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
              localObject4 = new MsgBackupController.4(this, (ajep)localObject1, paramajel, (List)localObject3, k);
              this.dil += dih;
              i += dih;
              paramajel.div += dih;
              paramajel.diw = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
              this.p.execute((Runnable)localObject4);
              ajgv.b(TAG, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.dil), Integer.valueOf(paramajel.diw) });
              if ((i >= j) || (this.dil >= dii)) {
                break;
              }
            }
            ajgv.b(TAG, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.dil) });
            if ((this.dil != 0) || (this.a == null) || (this.a.a == null)) {
              break label280;
            }
            localObject2 = new ajew();
            ((ajew)localObject2).uin = paramajel.uin;
            ((ajew)localObject2).uinType = paramajel.uinType;
            this.a.a.a(this.a, localObject2);
            this.I.sendEmptyMessage(1);
            ((ajep)localObject1).close();
            return;
            break label778;
          }
        }
      }
    }
  }
  
  public void b(ajep paramajep, ajel paramajel, List<MsgBackupMsgEntity> paramList)
  {
    if ((paramajep != null) && (paramajel != null) && (paramList != null))
    {
      int i = paramList.size();
      a(paramajep, paramajel, paramList);
      try
      {
        this.dil -= dih;
        paramajel.diu = (i + paramajel.diu);
        ajgv.c(TAG, "segmentDaoru step segment startNext,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d,uin = %s ", new Object[] { Integer.valueOf(paramajel.diu), Integer.valueOf(this.dil), Integer.valueOf(paramajel.totalCount), paramajel.uin });
        if (paramajel.diu >= paramajel.totalCount)
        {
          if ((this.a != null) && (this.a.a != null))
          {
            paramList = new ajew();
            paramList.uin = paramajel.uin;
            paramList.uinType = paramajel.uinType;
            this.a.a.a(this.a, paramList);
          }
          ajgv.c(TAG, "segmentDaoru step this session has process done ,uin = %s,uintype = %d", new Object[] { paramajel.uin, Integer.valueOf(paramajel.uinType) });
          this.fT.remove(paramajep.getDbName());
          paramajep.close();
          this.I.removeCallbacksAndMessages(null);
          this.I.sendEmptyMessage(3);
        }
        for (;;)
        {
          return;
          this.I.sendEmptyMessage(4);
        }
        return;
      }
      finally {}
    }
  }
  
  public List<MessageRecord> bk(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.msgtype != -2006) {
        if (((localMessageRecord.extraflag == 32768) || (localMessageRecord.extraflag == 32772)) && (localMessageRecord.isSendFromLocal()))
        {
          ajgv.c(TAG, "preHandleQianchu..unsupport send not sucess msg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (!(localMessageRecord instanceof ChatMessage))
        {
          ajgv.c(TAG, "preHandleQianchu..unsupport not chatMessage _id = %d...,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if ((top.fC(localMessageRecord.msgtype)) || (top.fB(localMessageRecord.msgtype)))
        {
          ajgv.c(TAG, "preHandleQianchu..unsupport graytipMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (wkh.i((ChatMessage)localMessageRecord))
        {
          ajgv.c(TAG, "preHandleQianchu..unsupport BeancurdMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (jof.a(localMessageRecord))
        {
          ajgv.c(TAG, "preHandleQianchu..unsupport AnonymousMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else
        {
          if ((localMessageRecord instanceof MessageForFile)) {
            ahav.a(this.mApp, (MessageForFile)localMessageRecord);
          }
          if ((localMessageRecord instanceof MessageForCommonHobbyForAIOShow))
          {
            ajgv.c(TAG, "preHandleQianchu..unsupport msgtype MessageForCommonHobbyForAIOShow MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW", new Object[0]);
          }
          else if (((localMessageRecord.istroop == 1) || (localMessageRecord.istroop == 1)) && (localMessageRecord.shmsgseq <= 0L))
          {
            ajgv.c(TAG, "preHandleQianchu..unsupport troop or discurss msg shmsgseq <= 0", new Object[0]);
          }
          else
          {
            boolean bool = ajlg.e(this.mApp, (ChatMessage)localMessageRecord);
            if (localMessageRecord.msgtype == -2002) {
              bool = true;
            }
            for (;;)
            {
              if (!bool) {
                break label508;
              }
              localArrayList.add(localMessageRecord);
              break;
              if (localMessageRecord.msgtype == -2071) {
                bool = true;
              } else if (localMessageRecord.msgtype == -2007) {
                bool = true;
              } else if (localMessageRecord.msgtype == -5008) {
                bool = true;
              } else if (localMessageRecord.msgtype == -5017) {
                bool = true;
              }
            }
            label508:
            String str = ajlg.d(this.mApp, localMessageRecord);
            ajgv.c(TAG, "preHandleQianchu..unsupport trans to txtMessage _id = %d...,msgtype = %d .msgStr = %s", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype), str });
            localMessageRecord = this.mApp.a().a(localMessageRecord, str, false);
            if (TextUtils.equals(localMessageRecord.senderuin, this.mApp.getCurrentAccountUin())) {
              ((acle)this.mApp.getBusinessHandler(13)).W(localMessageRecord);
            }
            localMessageRecord.setStatus(1000);
            localMessageRecord.msgData = localMessageRecord.msg.getBytes();
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    ajgv.b(TAG, "preHandleQianchu..msgSize = %d...", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  public void c(ajek paramajek)
  {
    HashSet localHashSet = paramajek.bj;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      ajgv.b(TAG, "daoru no recentdBaseData ", new Object[0]);
      return;
    }
    this.xH.clear();
    this.fV.clear();
    this.fT.clear();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).qx();
      int i = ((RecentBaseData)localObject).ng();
      ajgv.c(TAG, "daoru uin = %s ", new Object[] { str });
      localObject = new ajel();
      ((ajel)localObject).uin = str;
      ((ajel)localObject).uinType = i;
      ((ajel)localObject).dir = 2;
      ((ajel)localObject).div = -1;
      ((ajel)localObject).diw = -1;
      str = ap(str, i);
      this.xH.add(str);
      this.fV.put(str, localObject);
    }
    paramajek.totalCount = localHashSet.size();
    paramajek.curIndex = -1;
    this.I.sendEmptyMessage(3);
  }
  
  public void d(ajel paramajel)
  {
    Object localObject1 = ajgv.a(paramajel);
    ajgv.c(TAG, "singleNextQianru step:start dbName = %s， request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { localObject1, Integer.valueOf(paramajel.diw), Integer.valueOf(paramajel.diu), Integer.valueOf(this.dil), Integer.valueOf(paramajel.totalCount) });
    ajgv.aqD();
    localObject1 = new ajep((String)localObject1);
    if (paramajel.totalCount == 0) {
      paramajel.totalCount = ((ajep)localObject1).Gl();
    }
    int i = paramajel.totalCount;
    if ((i == 0) || ((paramajel.div >= paramajel.totalCount) && (this.dil == 0)))
    {
      ajgv.c(TAG, "singleNextQianru step queryResList.size = 0,", new Object[0]);
      this.I.removeCallbacksAndMessages(null);
      this.I.sendEmptyMessage(6);
      ((ajep)localObject1).close();
      return;
    }
    while ((paramajel.div < i) && (this.dil < dik))
    {
      ajgv.c(TAG, "singleNextQianru step:,request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramajel.diw), Integer.valueOf(paramajel.diu), Integer.valueOf(this.dil), Integer.valueOf(paramajel.totalCount) });
      Object localObject2 = ((ajep)localObject1).h(paramajel.diw + 1, dij);
      paramajel.div += dih;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramajel.diw = ((int)((MsgBackupResEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        this.dil += dij;
        localObject2 = new MsgBackupController.5(this, (List)localObject2, paramajel);
        this.p.execute((Runnable)localObject2);
      }
      else if (this.dil == 0)
      {
        if ((paramajel.diu == paramajel.totalCount) || (this.fW.size() <= 0)) {
          break label372;
        }
        p(null, null, 0L);
      }
    }
    for (;;)
    {
      ((ajep)localObject1).close();
      return;
      label372:
      this.I.removeCallbacksAndMessages(null);
      this.I.sendEmptyMessage(6);
    }
  }
  
  public void e(ajel paramajel)
  {
    ajee.bQR = null;
    ajee.bQT = null;
    c(paramajel);
    Object localObject1;
    if (TextUtils.isEmpty(ajee.bQT))
    {
      if (this.a.a != null)
      {
        localObject1 = new ajew();
        ((ajew)localObject1).uin = paramajel.uin;
        ((ajew)localObject1).uinType = paramajel.uinType;
        ajgv.c(TAG, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramajel.diw), Integer.valueOf(paramajel.totalCount) });
        this.a.a.a(this.a, localObject1);
      }
      this.I.removeCallbacksAndMessages(null);
      this.I.sendEmptyMessage(3);
    }
    do
    {
      return;
      localObject1 = ajgv.a(paramajel);
      if (this.fT.get(localObject1) == null)
      {
        localObject2 = new ajep((String)localObject1);
        this.fT.put(localObject1, localObject2);
      }
      localObject1 = (ajep)this.fT.get(localObject1);
      int i = ((ajep)localObject1).Gk();
      if (paramajel.totalCount == 0) {
        paramajel.totalCount = ((ajep)localObject1).Gk();
      }
      if ((paramajel.totalCount == 0) || ((paramajel.div >= i) && (this.dil == 0)))
      {
        if (this.a.a != null)
        {
          localObject2 = new ajew();
          ((ajew)localObject2).uin = paramajel.uin;
          ((ajew)localObject2).uinType = paramajel.uinType;
          ajgv.c(TAG, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramajel.diw), Integer.valueOf(paramajel.totalCount) });
          this.a.a.a(this.a, localObject2);
        }
        ((ajep)localObject1).close();
        this.I.sendEmptyMessage(3);
        return;
      }
      do
      {
        paramajel.diw = ((int)((MsgBackupMsgEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        ajgv.b(TAG, "singleDaoru queryMsg result.size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        this.dil += dih;
        localObject2 = new MsgBackupController.6(this, (ajep)localObject1, paramajel, (List)localObject2);
        this.p.execute((Runnable)localObject2);
        if ((paramajel.div >= i) || (this.dil >= dii)) {
          break;
        }
        ajgv.c(TAG, "singleDaoru queryMsgBefore  curIndex = %d,totalCount = %d,doneCount = %d ", new Object[] { Integer.valueOf(paramajel.diw), Integer.valueOf(paramajel.totalCount), Integer.valueOf(paramajel.diu) });
        if (paramajel.div <= 0) {
          ajes.startTime = 0L;
        }
        localObject2 = ((ajep)localObject1).a(paramajel.diw + 1, dih);
        paramajel.div += dih;
      } while ((localObject2 != null) && (((List)localObject2).size() != 0));
      ajgv.c(TAG, "singleDaoru..query result == 0", new Object[0]);
    } while ((this.dil != 0) || (this.a.a == null));
    ajgv.b(TAG, "singleDaoru queryMsgAfter  msgSize = = 0 ", new Object[0]);
    Object localObject2 = new ajew();
    ((ajew)localObject2).uin = paramajel.uin;
    ((ajew)localObject2).uinType = paramajel.uinType;
    this.a.a.a(this.a, localObject2);
    ((ajep)localObject1).close();
    this.I.sendEmptyMessage(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.dq.get())
    {
      bool1 = false;
      return bool1;
    }
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      return true;
    case 0: 
      localObject = TAG;
      if (paramMessage.obj != null) {}
      for (bool1 = true;; bool1 = false)
      {
        ajgv.b((String)localObject, "MSG_WHAT_SUB_REQUEST_POST msg.obj = %b", new Object[] { Boolean.valueOf(bool1) });
        bool1 = bool2;
        if (!(paramMessage.obj instanceof ajek)) {
          break;
        }
        a((ajek)paramMessage.obj);
        return true;
      }
    case 5: 
      if (TextUtils.isEmpty(ajee.bQS))
      {
        localObject = this.t.obtainMessage(5);
        ((Message)localObject).obj = paramMessage.obj;
        this.t.sendMessageDelayed((Message)localObject, 1000L);
        return true;
      }
      localObject = this.t.obtainMessage(0);
      ((Message)localObject).what = 0;
      ((Message)localObject).obj = paramMessage.obj;
      this.t.sendMessage((Message)localObject);
      return true;
    case 7: 
      if ((TextUtils.isEmpty(ajee.bQR)) && ((paramMessage.obj instanceof ajek)))
      {
        localObject = (ajek)paramMessage.obj;
        ajel localajel = new ajel();
        ajgv.a(((ajek)localObject).bQV.substring(((ajek)localObject).bQV.lastIndexOf("/") + 1), localajel);
        c(localajel);
      }
      localObject = this.t.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.t.sendMessage((Message)localObject);
      return true;
    }
    if (TextUtils.isEmpty(ajee.bQR))
    {
      ajgv.b(TAG, "MSG_WHAT_SUB_DECRYPT_KEY_VALID sFileMeta is null, so skip this session!", new Object[0]);
      dwx();
      return true;
    }
    Object localObject = (String)ajee.fY.get(ajee.bQR);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.t.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.t.sendMessageDelayed((Message)localObject, 1000L);
      return true;
    }
    ajee.bQT = (String)localObject;
    localObject = this.t.obtainMessage(0);
    ((Message)localObject).obj = paramMessage.obj;
    this.t.sendMessage((Message)localObject);
    return true;
  }
  
  public void onDestroy()
  {
    this.dq.set(false);
    if (this.t != null) {
      this.t.removeCallbacksAndMessages(null);
    }
    if (this.I != null) {
      this.I.removeCallbacksAndMessages(null);
    }
    this.fT.clear();
    this.xG.clear();
    this.fU.clear();
    this.xH.clear();
    this.fU.clear();
    ajej.clear();
    ajgu.dxw();
  }
  
  public void release()
  {
    if (this.t != null)
    {
      this.t.removeCallbacksAndMessages(null);
      this.mSubThread.quit();
    }
    if (this.I != null)
    {
      this.I.removeCallbacksAndMessages(null);
      this.Q.quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajeb
 * JD-Core Version:    0.7.0.1
 */