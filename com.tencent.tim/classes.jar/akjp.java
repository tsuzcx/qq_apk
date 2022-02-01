import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager.1;
import com.tencent.mobileqq.nearby.redtouch.RedPointConfig;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cd.PullRedpointReq;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6ce.ReadRedpointReq;
import tencent.im.oidb.cmd0x6f5.RspBody;
import tencent.im.oidb.cmd0x6f5.TaskInfo;

public class akjp
  implements Handler.Callback, Manager
{
  @Deprecated
  public static final int[] me;
  public static Map<Integer, Integer> mj = new HashMap(5);
  private Vector<RedTouchItem> J = new Vector();
  private akjw jdField_a_of_type_Akjw;
  akjx jdField_a_of_type_Akjx;
  private QQAppInterface app;
  private String bTy;
  private ConcurrentHashMap<Integer, RedPointConfig> gp = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, akjw> gq = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, RedTouchItem> gr = new ConcurrentHashMap();
  private MqqHandler m = new MqqHandler(ThreadManager.getFileThreadLooper(), this);
  final Object mInitLock = new Object();
  boolean mInited = false;
  
  static
  {
    me = new int[] { 10001 };
    mj.put(Integer.valueOf(10005), Integer.valueOf(100601));
  }
  
  public akjp(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Akjx = new akjo(paramQQAppInterface, this);
    dBu();
  }
  
  private boolean PN()
  {
    synchronized (this.mInitLock)
    {
      boolean bool = this.mInited;
      return bool;
    }
  }
  
  private void RS(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "updateParents:" + paramInt);
    }
    RedTouchItem localRedTouchItem1 = (RedTouchItem)this.gr.get(Integer.valueOf(paramInt));
    if ((localRedTouchItem1 != null) && (localRedTouchItem1.passThroughLevel > 0))
    {
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < localRedTouchItem1.passThroughLevel)
      {
        akjw localakjw = (akjw)this.gq.get(Integer.valueOf(i));
        if ((localakjw == null) || (localakjw.b == null)) {
          break;
        }
        RedTouchItem localRedTouchItem2 = (RedTouchItem)this.gr.get(Integer.valueOf(localakjw.b.id));
        if (localRedTouchItem2 != null) {
          localRedTouchItem2.unReadFlag = false;
        }
        if (localakjw.b.children != null)
        {
          i = 0;
          while (i < localakjw.b.children.size())
          {
            j = ((akjw)localakjw.b.children.get(i)).id;
            localRedTouchItem2 = (RedTouchItem)this.gr.get(Integer.valueOf(j));
            if ((localRedTouchItem2 != null) && (localRedTouchItem2.unReadFlag) && (!localRedTouchItem2.isClosed) && (localRedTouchItem2.passThroughLevel > 0)) {
              b(localRedTouchItem2, localakjw.b.id);
            }
            i += 1;
          }
        }
        i = localakjw.b.id;
        paramInt += 1;
      }
    }
  }
  
  private void a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, String.format(Locale.getDefault(), "handleRedPoint item=%s saveToFile=%s", new Object[] { paramRedTouchItem, Boolean.valueOf(paramBoolean) }));
    }
    RedPointConfig localRedPointConfig1 = (RedPointConfig)this.gp.get(Integer.valueOf(paramRedTouchItem.taskId));
    RedTouchItem localRedTouchItem;
    int i;
    if (localRedPointConfig1 != null)
    {
      this.jdField_a_of_type_Akjx.a(paramRedTouchItem, localRedPointConfig1.redPointId);
      localRedTouchItem = a(localRedPointConfig1.redPointId);
      if (localRedTouchItem == null) {
        break label162;
      }
      RedPointConfig localRedPointConfig2 = (RedPointConfig)this.gp.get(Integer.valueOf(localRedTouchItem.taskId));
      if ((localRedPointConfig2 == null) || (localRedPointConfig2.priority <= localRedPointConfig1.priority) || (!localRedTouchItem.unReadFlag)) {
        break label157;
      }
      if (!QLog.isColorLevel()) {
        break label295;
      }
      QLog.i("LocalRedTouchManager", 2, "handleRedPoint, ignore lower priority");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {}
      label157:
      label162:
      do
      {
        do
        {
          return;
          i = 1;
          break;
          i = 1;
          break;
        } while (!this.gq.containsKey(Integer.valueOf(localRedPointConfig1.redPointId)));
        localRedTouchItem = (RedTouchItem)this.gr.get(Integer.valueOf(localRedPointConfig1.redPointId));
        if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (localRedTouchItem.redtouchType == 2) && (paramRedTouchItem.redtouchType == 2))
        {
          i = paramRedTouchItem.count;
          localRedTouchItem.count += i;
        }
        paramRedTouchItem.passThroughLevel = localRedPointConfig1.passThroughLevel;
        this.gr.put(Integer.valueOf(localRedPointConfig1.redPointId), paramRedTouchItem);
        RS(localRedPointConfig1.redPointId);
      } while (!paramBoolean);
      dBz();
      return;
      label295:
      i = 0;
    }
  }
  
  private void b(RedTouchItem paramRedTouchItem, int paramInt)
  {
    int j = 0;
    int i = 0;
    RedTouchItem localRedTouchItem = (RedTouchItem)this.gr.get(Integer.valueOf(paramInt));
    if (localRedTouchItem == null)
    {
      localRedTouchItem = new RedTouchItem();
      akjy.a(localRedTouchItem, paramRedTouchItem);
      if (paramRedTouchItem.passThroughLevel - 1 >= 0)
      {
        i = paramRedTouchItem.passThroughLevel - 1;
        localRedTouchItem.passThroughLevel = i;
        this.gr.put(Integer.valueOf(paramInt), localRedTouchItem);
      }
    }
    int k;
    do
    {
      return;
      i = 0;
      break;
      if (!localRedTouchItem.unReadFlag) {
        break label200;
      }
      j = akjy.is(localRedTouchItem.redtouchType);
      k = akjy.is(paramRedTouchItem.redtouchType);
      if (k > j)
      {
        localRedTouchItem = new RedTouchItem();
        akjy.a(localRedTouchItem, paramRedTouchItem);
        if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
          i = paramRedTouchItem.passThroughLevel - 1;
        }
        localRedTouchItem.passThroughLevel = i;
        this.gr.put(Integer.valueOf(paramInt), localRedTouchItem);
        return;
      }
    } while ((k != j) || (paramRedTouchItem.redtouchType != 2));
    localRedTouchItem.count += paramRedTouchItem.count;
    return;
    label200:
    localRedTouchItem = new RedTouchItem();
    akjy.a(localRedTouchItem, paramRedTouchItem);
    i = j;
    if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
      i = paramRedTouchItem.passThroughLevel - 1;
    }
    localRedTouchItem.passThroughLevel = i;
    this.gr.put(Integer.valueOf(paramInt), localRedTouchItem);
  }
  
  private boolean b(RedTouchItem paramRedTouchItem)
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if ((paramRedTouchItem == null) || (!paramRedTouchItem.unReadFlag) || (paramRedTouchItem.isClosed)) {
      bool = true;
    }
    int i;
    do
    {
      do
      {
        return bool;
        if (paramRedTouchItem.validTimeRemained >= 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LocalRedTouchManager", 2, "validTimeRemained < 0");
      return false;
      i = (int)((l - paramRedTouchItem.receiveTime) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "isOutOfDate,remain:" + paramRedTouchItem.validTimeRemained + " consume:" + i);
      }
    } while (i < paramRedTouchItem.validTimeRemained);
    if (paramRedTouchItem.unReadFlag)
    {
      paramRedTouchItem.unReadFlag = false;
      paramRedTouchItem = (RedPointConfig)this.gp.get(Integer.valueOf(paramRedTouchItem.taskId));
      if (paramRedTouchItem != null) {
        RS(paramRedTouchItem.redPointId);
      }
      dBz();
    }
    return true;
  }
  
  private void dBu()
  {
    this.jdField_a_of_type_Akjw = new akjw();
    this.jdField_a_of_type_Akjw.id = -1;
    this.gq.put(Integer.valueOf(this.jdField_a_of_type_Akjw.id), this.jdField_a_of_type_Akjw);
    akjw localakjw1 = new akjw();
    localakjw1.id = 10018;
    localakjw1.b = this.jdField_a_of_type_Akjw;
    this.gq.put(Integer.valueOf(localakjw1.id), localakjw1);
    localakjw1 = new akjw();
    localakjw1.id = -3;
    localakjw1.b = this.jdField_a_of_type_Akjw;
    this.gq.put(Integer.valueOf(localakjw1.id), localakjw1);
    localakjw1.children = new ArrayList();
    Object localObject1 = new akjw();
    ((akjw)localObject1).id = -7;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    ((akjw)localObject1).b = localakjw1;
    localakjw1.children.add(localObject1);
    ((akjw)localObject1).children = new ArrayList();
    akjw localakjw2 = new akjw();
    localakjw2.id = -4;
    this.gq.put(Integer.valueOf(localakjw2.id), localakjw2);
    localakjw2.b = localakjw1;
    localakjw1.children.add(localakjw2);
    localakjw2.children = new ArrayList();
    Object localObject2 = new akjw();
    ((akjw)localObject2).id = 10015;
    this.gq.put(Integer.valueOf(((akjw)localObject2).id), localObject2);
    ((akjw)localObject2).b = ((akjw)localObject1);
    ((akjw)localObject1).children.add(localObject2);
    localObject2 = new akjw();
    ((akjw)localObject2).id = 10016;
    this.gq.put(Integer.valueOf(((akjw)localObject2).id), localObject2);
    ((akjw)localObject2).b = ((akjw)localObject1);
    ((akjw)localObject1).children.add(localObject2);
    localObject2 = new akjw();
    ((akjw)localObject2).id = 100601;
    ((akjw)localObject2).b = ((akjw)localObject1);
    ((akjw)localObject1).children.add(localObject2);
    this.gq.put(Integer.valueOf(100601), localObject2);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10019;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    ((akjw)localObject1).b = localakjw2;
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10020;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    ((akjw)localObject1).b = localakjw2;
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10022;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    ((akjw)localObject1).b = localakjw2;
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10021;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    ((akjw)localObject1).b = localakjw2;
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10023;
    ((akjw)localObject1).b = localakjw2;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10024;
    ((akjw)localObject1).b = localakjw2;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10025;
    ((akjw)localObject1).b = localakjw2;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10026;
    ((akjw)localObject1).b = localakjw2;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    localakjw2.children.add(localObject1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10027;
    ((akjw)localObject1).b = localakjw2;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    localakjw2.children.add(localObject1);
    localakjw2 = new akjw();
    localakjw2.id = -2;
    localakjw2.b = this.jdField_a_of_type_Akjw;
    this.gq.put(Integer.valueOf(localakjw2.id), localakjw2);
    this.jdField_a_of_type_Akjw.children = Arrays.asList(new akjw[] { localakjw1, localakjw2 });
    localakjw2.children = new ArrayList();
    localObject1 = new akjw();
    ((akjw)localObject1).id = 100510;
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    ((akjw)localObject1).b = localakjw2;
    localakjw2.children.add(localObject1);
    localakjw1 = new akjw();
    localakjw1.id = 10011;
    localakjw1.b = ((akjw)localObject1);
    this.gq.put(Integer.valueOf(localakjw1.id), localakjw1);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localakjw1);
    ((akjw)localObject1).children = ((List)localObject2);
    localObject1 = new ArrayList();
    localObject2 = new akjw();
    ((akjw)localObject2).id = 100523;
    ((akjw)localObject2).b = localakjw1;
    this.gq.put(Integer.valueOf(((akjw)localObject2).id), localObject2);
    ((List)localObject1).add(localObject2);
    localObject2 = new akjw();
    ((akjw)localObject2).id = 100517;
    ((akjw)localObject2).b = localakjw1;
    this.gq.put(Integer.valueOf(((akjw)localObject2).id), localObject2);
    ((List)localObject1).add(localObject2);
    localakjw1.children = ((List)localObject1);
    localakjw1 = new akjw();
    localakjw1.id = -5;
    localakjw1.b = localakjw2;
    localakjw2.children.add(localakjw1);
    localakjw1.children = new ArrayList();
    this.gq.put(Integer.valueOf(localakjw1.id), localakjw1);
    localakjw1 = new akjw();
    localakjw1.id = -6;
    localakjw1.b = localakjw2;
    localakjw2.children.add(localakjw1);
    localakjw1.children = new ArrayList();
    this.gq.put(Integer.valueOf(localakjw1.id), localakjw1);
    localObject1 = new akjw();
    ((akjw)localObject1).id = 10014;
    ((akjw)localObject1).b = localakjw1;
    localakjw1.children.add(localObject1);
    this.gq.put(Integer.valueOf(((akjw)localObject1).id), localObject1);
    localakjw1 = new akjw();
    localakjw1.id = 10013;
    localakjw1.b = localakjw2;
    localakjw2.children.add(localakjw1);
    this.gq.put(Integer.valueOf(localakjw1.id), localakjw1);
  }
  
  private void dBw()
  {
    aqhq.y("red_point_info_" + this.app.getCurrentAccountUin(), this.gr);
  }
  
  private void dBy()
  {
    if (!PN()) {
      init();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.gp);
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.size() > 0))
    {
      QLog.d("LocalRedTouchManager", 1, "pullRedPointInfo using config");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        RedPointConfig localRedPointConfig = (RedPointConfig)localConcurrentHashMap.get(localInteger);
        RedTouchItem localRedTouchItem = a(localRedPointConfig.redPointId);
        cmd0x6cd.PullRedpointReq localPullRedpointReq = new cmd0x6cd.PullRedpointReq();
        localPullRedpointReq.uint32_taskid.set(localInteger.intValue());
        if (localRedTouchItem != null) {
          localPullRedpointReq.uint64_last_pull_seq.set(localRedTouchItem.curSeq);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, String.format("pullRedPointInfo. addPull, taskId=%d seq=%d redpointId=%d pLevel=%d bLevel=%d", new Object[] { localInteger, Long.valueOf(localPullRedpointReq.uint64_last_pull_seq.get()), Integer.valueOf(localRedPointConfig.redPointId), Integer.valueOf(localRedPointConfig.passThroughLevel), Integer.valueOf(localRedPointConfig.bindLevel) }));
          }
          localArrayList.add(localPullRedpointReq);
          break;
          localPullRedpointReq.uint64_last_pull_seq.set(0L);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((akjz)this.app.getBusinessHandler(91)).ay(localArrayList, false);
        long l = SystemClock.elapsedRealtime();
        ajrb.c(this.app.getAccount(), "pull_red_touch_time2", Long.valueOf(l));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "pull config on null");
    }
    ((akjz)this.app.getBusinessHandler(91)).dBA();
  }
  
  private void init()
  {
    if (this.mInited) {
      return;
    }
    xD();
    ??? = (ConcurrentHashMap)aqhq.o("red_point_configs_" + this.app.getCurrentAccountUin());
    if (??? != null)
    {
      this.gp.clear();
      this.gp.putAll((Map)???);
    }
    try
    {
      ??? = (ConcurrentHashMap)aqhq.o("red_point_info_" + this.app.getCurrentAccountUin());
      if (??? != null)
      {
        this.gr.clear();
        this.gr.putAll((Map)???);
      }
      synchronized (this.mInitLock)
      {
        this.mInited = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("LocalRedTouchManager", 1, localThrowable.getMessage(), localThrowable);
        Object localObject2 = null;
      }
    }
  }
  
  public int GR()
  {
    Object localObject1 = a(10016);
    RedTouchItem localRedTouchItem = a(10015);
    if ((localObject1 != null) && (localRedTouchItem != null)) {
      if (((RedTouchItem)localObject1).curSeq <= localRedTouchItem.curSeq) {}
    }
    for (int i = 4;; i = 1)
    {
      for (;;)
      {
        int j = i;
        if (localObject1 != null)
        {
          j = i;
          if (((RedTouchItem)localObject1).bytes != null)
          {
            j = i;
            if (((RedTouchItem)localObject1).bytes.length <= 0) {}
          }
        }
        try
        {
          j = new JSONObject(new String(((RedTouchItem)localObject1).bytes, "utf-8")).optInt("type", 1);
          return j;
          i = 3;
          localObject1 = localRedTouchItem;
          continue;
          if (localObject1 != null)
          {
            i = 4;
          }
          else if (localRedTouchItem != null)
          {
            i = 3;
            localObject1 = localRedTouchItem;
          }
        }
        catch (Exception localException)
        {
          do
          {
            j = i;
          } while (!QLog.isColorLevel());
          QLog.e("LocalRedTouchManager", 2, localException, new Object[0]);
          return i;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void MP(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onProfileRedTouchClick, isFromFriendElseNearby:" + paramBoolean);
    }
    RT(100601);
    if (paramBoolean)
    {
      RU(10016);
      RU(10015);
    }
    altq localaltq = (altq)this.app.getManager(36);
    if (localaltq == null) {
      return;
    }
    localaltq.OT("100510");
    localaltq.OT("100460");
    RT(100510);
    RT(-7);
  }
  
  public void Nv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "setRedPointConfigVersion, version = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.bTy = paramString;
      ajrb.c(this.app.getAccount(), "red_point_config_version", paramString);
    }
  }
  
  public void RT(int paramInt)
  {
    a(paramInt, false, 0L, false, true);
  }
  
  public void RU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "clearParentsButSelf, redPointId=" + paramInt);
    }
    if (this.gr == null) {}
    RedTouchItem localRedTouchItem;
    do
    {
      return;
      localRedTouchItem = (RedTouchItem)this.gr.get(Integer.valueOf(paramInt));
    } while ((localRedTouchItem == null) || (!localRedTouchItem.unReadFlag) || (localRedTouchItem.passThroughLevel <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, "rt=" + localRedTouchItem.toString());
    }
    localRedTouchItem.unReadFlag = false;
    RS(paramInt);
    localRedTouchItem.passThroughLevel = 0;
    localRedTouchItem.unReadFlag = true;
    dBz();
    if (this.m.hasMessages(1)) {
      this.m.removeMessages(1);
    }
    this.m.sendEmptyMessage(1);
  }
  
  public void RV(int paramInt)
  {
    if (paramInt != 1) {}
  }
  
  public void RW(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onRedPointChanged redPointId:" + paramInt);
    }
    RS(paramInt);
    dBz();
    if (this.m.hasMessages(1)) {
      this.m.removeMessages(1);
    }
    this.m.sendEmptyMessage(1);
  }
  
  public RedTouchItem a(int paramInt)
  {
    RedTouchItem localRedTouchItem = null;
    if (this.gr != null) {
      localRedTouchItem = (RedTouchItem)this.gr.get(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel())
    {
      if (localRedTouchItem != null) {
        break label68;
      }
      QLog.d("LocalRedTouchManager", 2, "getRedPointInfo: " + paramInt + ", not found");
    }
    label68:
    while (!QLog.isColorLevel()) {
      return localRedTouchItem;
    }
    QLog.d("LocalRedTouchManager", 2, "getRedPointInfo id=" + paramInt + " info=" + localRedTouchItem.toString());
    return localRedTouchItem;
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onRedPointClick, redPointId=" + paramInt + ", bCustom=" + paramBoolean1 + ", customSeq=" + paramLong + ", customReadFlag=" + paramBoolean2 + ", bReport=" + paramBoolean3);
    }
    if (this.gr == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (RedTouchItem)this.gr.get(Integer.valueOf(paramInt));
    } while ((localObject == null) || (!((RedTouchItem)localObject).unReadFlag));
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, "rt=" + ((RedTouchItem)localObject).toString());
    }
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((RedTouchItem)localObject).unReadFlag = paramBoolean2;
      if (QLog.isColorLevel()) {
        QLog.d("LocalRedTouchManager", 2, "rt.unReadFlag set to " + ((RedTouchItem)localObject).unReadFlag);
      }
      RS(paramInt);
      dBz();
      if (this.m.hasMessages(1)) {
        this.m.removeMessages(1);
      }
      this.m.sendEmptyMessage(1);
      if (!paramBoolean3) {
        break;
      }
      localObject = new cmd0x6ce.ReadRedpointReq();
      ((cmd0x6ce.ReadRedpointReq)localObject).uint32_appid.set(paramInt);
      if (paramBoolean1) {
        ((cmd0x6ce.ReadRedpointReq)localObject).uint64_read_seq.set(paramLong);
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      ((akjz)this.app.getBusinessHandler(91)).lF(localArrayList);
      return;
    }
  }
  
  public void a(cmd0x6f5.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs");
    }
    if (!PN()) {
      init();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramRspBody != null) && (paramRspBody.rpt_task_info != null) && (paramRspBody.rpt_task_info.has()))
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      paramRspBody = paramRspBody.rpt_task_info.get();
      Iterator localIterator = paramRspBody.iterator();
      while (localIterator.hasNext())
      {
        cmd0x6f5.TaskInfo localTaskInfo = (cmd0x6f5.TaskInfo)localIterator.next();
        RedPointConfig localRedPointConfig = new RedPointConfig();
        localRedPointConfig.taskId = localTaskInfo.uint32_task_id.get();
        localRedPointConfig.redPointId = localTaskInfo.uint32_appid.get();
        localRedPointConfig.passThroughLevel = localTaskInfo.uint32_passthrough_level.get();
        localRedPointConfig.bindLevel = localTaskInfo.uint32_show_level.get();
        localRedPointConfig.priority = localTaskInfo.uint32_priority.get();
        localConcurrentHashMap.put(Integer.valueOf(localRedPointConfig.taskId), localRedPointConfig);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("\n").append(localRedPointConfig.toString());
        }
      }
      this.gp.clear();
      this.gp.putAll(localConcurrentHashMap);
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs, config size = " + paramRspBody.size() + " " + localStringBuilder.toString());
      }
      aqhq.y("red_point_configs_" + this.app.getCurrentAccountUin(), localConcurrentHashMap);
    }
  }
  
  public boolean a(RedTouchItem paramRedTouchItem)
  {
    return (paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!b(paramRedTouchItem));
  }
  
  public boolean a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    if ((paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!paramRedTouchItem.isClosed)) {
      if (paramBoolean) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if ((paramRedTouchItem != null) && (paramRedTouchItem.redtouchType == 2))
      {
        if ((paramBoolean) && (paramRedTouchItem.count > 0))
        {
          return true;
          if (!b(paramRedTouchItem)) {
            break;
          }
          paramBoolean = false;
          continue;
        }
        return false;
      }
    }
    return paramBoolean;
  }
  
  public void ax(List<RedTouchItem> paramList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetRedPointInfo, list size=");
    Object localObject;
    if (paramList == null)
    {
      localObject = "null";
      QLog.i("LocalRedTouchManager", 1, localObject + ", hasMore=" + paramBoolean);
      if ((paramList != null) && (paramList.size() != 0)) {
        break label78;
      }
    }
    label78:
    do
    {
      return;
      localObject = Integer.valueOf(paramList.size());
      break;
      this.J.addAll(paramList);
    } while (paramBoolean);
    int i = this.J.size() - 1;
    while (i >= 0)
    {
      if (((RedTouchItem)this.J.get(i)).taskId == 10001) {
        this.J.remove(i);
      }
      i -= 1;
    }
    if (((RedTouchItem)paramList.get(0)).configVersion.equals(this.bTy))
    {
      dBv();
      return;
    }
    ((akjz)this.app.getBusinessHandler(91)).dBA();
  }
  
  public void bG(int paramInt, boolean paramBoolean)
  {
    a(paramInt, false, 0L, false, paramBoolean);
  }
  
  public void bn(byte[] paramArrayOfByte)
  {
    QLog.i("LocalRedTouchManager", 1, "onLinePush");
    if (!PN()) {
      init();
    }
    cmd0x6cd.RedpointInfo localRedpointInfo = new cmd0x6cd.RedpointInfo();
    try
    {
      localRedpointInfo.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = RedTouchItem.getRedTouchItem(localRedpointInfo);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      RedPointConfig localRedPointConfig;
      if (QLog.isColorLevel())
      {
        localRedPointConfig = (RedPointConfig)this.gp.get(Integer.valueOf(paramArrayOfByte.taskId));
        if (localRedPointConfig != null) {
          break label162;
        }
      }
      label162:
      for (int i = 0;; i = localRedPointConfig.redPointId)
      {
        QLog.i("LocalRedTouchManager", 2, String.format("onLinePush item:%s appid=%d version=%s", new Object[] { paramArrayOfByte, Integer.valueOf(i), this.bTy }));
        if (!localRedpointInfo.str_config_version.get().equals(this.bTy)) {
          break;
        }
        a(paramArrayOfByte, true);
        acks.cw(this.app);
        this.jdField_a_of_type_Akjx.lE(Collections.singletonList(paramArrayOfByte));
        return;
      }
      this.J.add(paramArrayOfByte);
      ((akjz)this.app.getBusinessHandler(91)).dBA();
    }
  }
  
  public void dBv()
  {
    if (this.J.size() > 0)
    {
      Iterator localIterator = this.J.iterator();
      while (localIterator.hasNext()) {
        a((RedTouchItem)localIterator.next(), false);
      }
      dBw();
      this.jdField_a_of_type_Akjx.lE(this.J);
      this.J.clear();
      acks.cw(this.app);
    }
  }
  
  public void dBx()
  {
    ThreadManager.excute(new LocalRedTouchManager.1(this), 64, null, true);
  }
  
  public void dBz()
  {
    if (this.m.hasMessages(0)) {
      this.m.removeMessages(0);
    }
    this.m.sendEmptyMessage(0);
  }
  
  public void f(short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onGetUnreadRedTouchFlag: " + paramShort);
    }
    long l1 = ((Long)ajrb.c(this.app.getAccount(), "pull_red_touch_time2", Long.valueOf(0L))).longValue();
    long l2 = SystemClock.elapsedRealtime();
    if ((paramShort > 0) || (l2 - l1 > 43200000L)) {
      dBx();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      dBw();
      return false;
    }
    acks.cw(this.app);
    return false;
  }
  
  public boolean n(int paramInt, boolean paramBoolean)
  {
    return a(a(paramInt), paramBoolean);
  }
  
  public void onDestroy() {}
  
  public String xD()
  {
    if (this.bTy == null) {
      this.bTy = ((String)ajrb.c(this.app.getAccount(), "red_point_config_version", ""));
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "getRedPointConfigVersion, version = " + this.bTy);
    }
    return this.bTy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjp
 * JD-Core Version:    0.7.0.1
 */