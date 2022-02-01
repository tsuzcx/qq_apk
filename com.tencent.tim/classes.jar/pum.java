import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.10;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.11;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.12;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.13;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.14;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.15;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.16;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.5;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.6;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.7;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.8;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.MsgTabWorkThreadHandler.1;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public class pum
{
  protected static Comparator<puh> u = new pui();
  protected static Comparator<puh> v = new puj();
  protected puy a;
  boolean aBH = false;
  boolean aBI = false;
  boolean aBJ = false;
  boolean aBK = false;
  boolean aBL = false;
  boolean aBM = false;
  protected Set<String> aD = Collections.synchronizedSet(new ArraySet());
  protected AtomicBoolean aM = new AtomicBoolean(false);
  protected ppv.b<pvf, pvf.a> b;
  private pxs.a b;
  protected ConcurrentHashMap<String, QQUserUIItem> bY = new ConcurrentHashMap();
  protected final Object bo = new Object();
  protected HashMap<String, Boolean> fj = new HashMap();
  protected String mCookie;
  protected volatile ArrayList<puh> mData;
  protected volatile ArrayList<puh> mG;
  protected ArrayList<qqstory_service.MsgTabNodePushNotify> mH = new ArrayList();
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  boolean mHasRedPoint = false;
  protected boolean mIsEnd;
  public final ArrayList<pum.b> mListeners = new ArrayList();
  protected String mSeq;
  protected Handler mWorkHandler;
  protected HandlerThread mWorkThread = (HandlerThread)ThreadManagerV2.getRecentThread();
  
  pum(QQAppInterface paramQQAppInterface, puy parampuy)
  {
    this.jdField_b_of_type_Pxs$a = new pun(this);
    this.jdField_b_of_type_Ppv$b = new pup(this);
    ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListLoader ctor()");
    if (paramQQAppInterface == null) {
      ram.e("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.a = parampuy;
    this.mData = this.a.bs();
    p(this.mData, true);
    this.mG = new ArrayList(this.mData);
    this.mWorkHandler = new pum.a(this.mWorkThread.getLooper());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "create new loader");
    }
    int i = 0;
    while (i < this.mData.size())
    {
      paramQQAppInterface = (puh)this.mData.get(i);
      int j = 0;
      while (j < paramQQAppInterface.iO.size())
      {
        parampuy = (pux)paramQQAppInterface.iO.get(j);
        String str = paramQQAppInterface.unionId + "-" + parampuy.Ak;
        this.fj.put(str, Boolean.valueOf(parampuy.aBR));
        j += 1;
      }
      i += 1;
    }
    this.mWorkHandler.post(new MsgTabNodeListLoader.5(this));
  }
  
  private boolean a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify, boolean paramBoolean)
  {
    if (paramMsgTabNodePushNotify == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "realHandlePushMsg, msg is null!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", rpf.a(paramMsgTabNodePushNotify) });
    }
    puh localpuh = new puh();
    localpuh.a((qqstory_service.MsgTabNodeInfo)paramMsgTabNodePushNotify.msg_notify_node_info.get());
    String str = paramMsgTabNodePushNotify.bytes_current_seq.get().toStringUtf8();
    int i = paramMsgTabNodePushNotify.uint32_notify_type.get();
    boolean bool1;
    label168:
    int j;
    if (paramMsgTabNodePushNotify.uint32_animate.get() == 1)
    {
      bool1 = true;
      if (i != 1) {
        break label476;
      }
      if (localpuh.nodeType == 5)
      {
        paramMsgTabNodePushNotify = this.a.a();
        if (paramMsgTabNodePushNotify.bkt > 0)
        {
          i = this.mData.indexOf(localpuh);
          if (i == -1) {
            break label329;
          }
          localpuh.e((puh)this.mData.get(i));
        }
      }
      if ((localpuh.nodeType != 7) || (this.mData.indexOf(localpuh) != -1)) {
        break label345;
      }
      j = this.mData.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label345;
      }
      paramMsgTabNodePushNotify = (puh)this.mData.get(i);
      if ((paramMsgTabNodePushNotify.nodeType == 9) && (TextUtils.equals(localpuh.unionId, paramMsgTabNodePushNotify.unionId)))
      {
        this.mData.set(i, localpuh);
        this.a.k(paramMsgTabNodePushNotify);
        this.a.j(localpuh);
        if (paramBoolean)
        {
          a(paramMsgTabNodePushNotify, true, 3, bool1);
          a(localpuh, true, 1, bool1);
        }
        rar.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localpuh.nodeType) });
        return true;
        bool1 = false;
        break;
        label329:
        localpuh.e(paramMsgTabNodePushNotify);
        break label168;
      }
      i += 1;
    }
    label345:
    f(localpuh);
    boolean bool2 = d(localpuh);
    ed(Collections.singletonList(localpuh));
    eb(Collections.singletonList(localpuh));
    if (bool2)
    {
      this.a.j(localpuh);
      this.mG = new ArrayList(this.mData);
      this.mSeq = str;
      if (paramBoolean) {
        a(localpuh, true, 1, bool1);
      }
      rar.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localpuh.nodeType) });
    }
    ram.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.mSeq, localpuh);
    paramBoolean = bool2;
    for (;;)
    {
      return paramBoolean;
      label476:
      if (i == 2)
      {
        bool2 = e(localpuh);
        if (bool2)
        {
          this.mG = new ArrayList(this.mData);
          this.a.k(localpuh);
          this.mSeq = str;
          if (paramBoolean) {
            a(localpuh, true, 3, bool1);
          }
        }
        ram.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.mSeq, localpuh);
        paramBoolean = bool2;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  @WorkerThread
  private void b(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    if (ram.isColorLevel()) {
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "onHandlePushMsg %s", rpf.a(paramMsgTabNodePushNotify));
    }
    if (this.aM.get())
    {
      this.mH.add(paramMsgTabNodePushNotify);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "refreshing, add to waiting queue");
      }
      return;
    }
    a(paramMsgTabNodePushNotify, true);
  }
  
  @WorkerThread
  private void bmO()
  {
    ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    Object localObject = this.a.a();
    if (((puh)localObject).bkt > 0)
    {
      puh localpuh = a(((puh)localObject).nodeType, ((puh)localObject).unionId);
      if (localpuh == null) {
        break label54;
      }
      localpuh.e((puh)localObject);
      localObject = localpuh;
    }
    label54:
    for (;;)
    {
      a((puh)localObject, false);
      return;
    }
  }
  
  private boolean c(List<String> paramList, boolean paramBoolean)
  {
    if (paramList.isEmpty())
    {
      ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    ptf localptf = (ptf)psx.a(2);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = localptf.b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList.add(new QQUserUIItem.a("", str));
      }
      for (;;)
      {
        i += 1;
        break;
        a(localQQUserUIItem);
        bool = true;
      }
    }
    if (!localArrayList.isEmpty()) {
      if (paramBoolean)
      {
        new pxs(this.jdField_b_of_type_Pxs$a).B(1, localArrayList);
        ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() Will fetch %s users", localArrayList);
      }
    }
    for (;;)
    {
      return bool;
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() miss %s users, did not find in db, won't request", localArrayList);
      continue;
      ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() All nodes has local cache, no need request");
    }
  }
  
  private void ci(ArrayList<puh> paramArrayList) {}
  
  private boolean d(puh parampuh)
  {
    boolean bool;
    int i;
    int j;
    if (Thread.currentThread() == this.mWorkThread)
    {
      bool = true;
      rom.assertTrue(bool);
      i = this.mData.indexOf(parampuh);
      if (i != -1)
      {
        puh localpuh = (puh)this.mData.get(i);
        if (parampuh.reqTimeStamp < localpuh.reqTimeStamp) {
          break label127;
        }
        this.mData.remove(parampuh);
      }
      j = this.mData.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label136;
      }
      if (u.compare(parampuh, this.mData.get(i)) <= 0)
      {
        this.mData.add(i, parampuh);
        p(this.mData, false);
        return true;
        bool = false;
        break;
        label127:
        return false;
      }
      i += 1;
    }
    label136:
    this.mData.add(parampuh);
    p(this.mData, false);
    return true;
  }
  
  private boolean e(puh parampuh)
  {
    if (Thread.currentThread() == this.mWorkThread) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      int i = this.mData.indexOf(parampuh);
      if (i == -1) {
        break;
      }
      puh localpuh = (puh)this.mData.get(i);
      if (parampuh.reqTimeStamp >= localpuh.reqTimeStamp) {
        break;
      }
      return false;
    }
    return this.mData.remove(parampuh);
  }
  
  private void eb(List<puh> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int k;
    puh localpuh;
    for (int j = 0;; j = k)
    {
      if ((j < paramList.size()) && (i < 8))
      {
        k = j + 1;
        localpuh = (puh)paramList.get(j);
        if (localpuh.unreadCount == 0) {
          ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(j));
        }
      }
      else
      {
        label75:
        ec(localArrayList2);
        if (!localArrayList1.isEmpty()) {
          break label287;
        }
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest is empty");
        return;
      }
      if ((localpuh.nodeType == 6) || (localpuh.nodeType == 9) || (localpuh.nodeType == 7) || (localpuh.nodeType == 5)) {
        break;
      }
    }
    Iterator localIterator = localpuh.iO.iterator();
    label155:
    pux localpux;
    if (localIterator.hasNext())
    {
      localpux = (pux)localIterator.next();
      if (TextUtils.isEmpty(localpux.vid))
      {
        localArrayList1.add(localpuh);
        i += 1;
        ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(k));
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(k));
        break label75;
        if (localpux.aBR) {
          break label155;
        }
        localArrayList2.add(localpux.vid);
        i += 1;
        ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(k), localpux.vid);
        j = 1;
        continue;
      }
      j = k;
      break;
      label287:
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest load vidlist size=%d", Integer.valueOf(localArrayList1.size()));
      Stream.fromIterator(localArrayList1.iterator()).map(new pur(this)).map(new puv("MsgTabPreloader")).subscribe(new puq(this));
      return;
      j = 0;
    }
  }
  
  private void ed(List<puh> paramList)
  {
    ptf localptf = (ptf)psx.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (puh)paramList.get(i);
      if ((((puh)localObject).nodeType == 12) || (((puh)localObject).nodeType == 10) || (((puh)localObject).nodeType == 11) || (((puh)localObject).nodeType == 13)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((puh)localObject).unionId;
        QQUserUIItem localQQUserUIItem = localptf.b((String)localObject);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          localArrayList.add(new QQUserUIItem.a("", (String)localObject));
        } else {
          a(localQQUserUIItem);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      new pxs(this.jdField_b_of_type_Pxs$a).B(1, localArrayList);
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private void f(puh parampuh)
  {
    int i = parampuh.iO.size();
    int j = 0;
    if (j < parampuh.iO.size())
    {
      pux localpux = (pux)parampuh.iO.get(j);
      Object localObject = parampuh.unionId + "-" + localpux.Ak;
      localObject = (Boolean)this.fj.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localpux.aBR = true;
      }
      if (!localpux.aBR) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      j += 1;
      break;
      parampuh.unreadCount = i;
      return;
    }
  }
  
  public static boolean f(List<puh> paramList1, List<puh> paramList2)
  {
    boolean bool2 = false;
    ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    if (i < paramList1.size())
    {
      localObject1 = ((puh)paramList1.get(i)).unionId;
      if (((puh)paramList1.get(i)).nodeType == 12) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((puh)paramList1.get(i)).iO;
        j = 0;
        while (j < ((List)localObject2).size())
        {
          pux localpux = (pux)((List)localObject2).get(j);
          if (!localpux.aBR) {
            localHashSet.add((String)localObject1 + "-" + localpux.Ak);
          }
          j += 1;
        }
      }
    }
    i = 0;
    boolean bool1 = bool2;
    if (i < paramList2.size())
    {
      paramList1 = ((puh)paramList2.get(i)).unionId;
      if (((puh)paramList2.get(i)).nodeType != 12) {}
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = ((puh)paramList2.get(i)).iO;
      j = 0;
      while (j < ((List)localObject1).size())
      {
        localObject2 = (pux)((List)localObject1).get(j);
        if ((!((pux)localObject2).aBR) && (!localHashSet.contains(paramList1 + "-" + ((pux)localObject2).Ak)))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
    }
  }
  
  private static void p(ArrayList<puh> paramArrayList, boolean paramBoolean)
  {
    ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() listSize=%d, sortOriginList=%b", Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean));
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      puh localpuh = (puh)((Iterator)localObject).next();
      if (localpuh.nodePosition > 0)
      {
        localArrayList.add(localpuh);
        ((Iterator)localObject).remove();
      }
    }
    if (paramBoolean) {
      Collections.sort(paramArrayList, u);
    }
    int i;
    if (localArrayList.size() > 0)
    {
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, v);
      i = 0;
      if (i >= paramArrayList.size()) {
        break label297;
      }
      localObject = (puh)paramArrayList.get(i);
      if ((((puh)localObject).nodeType != 1) && (((puh)localObject).nodeType != 4) && (((puh)localObject).nodeType != 3)) {
        ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i));
      }
    }
    for (;;)
    {
      if (i == -1) {
        i = paramArrayList.size();
      }
      for (;;)
      {
        int j = 0;
        label196:
        if (j < localArrayList.size())
        {
          localObject = (puh)localArrayList.get(j);
          if (((puh)localObject).nodePosition > 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            rom.assertTrue(paramBoolean, "position must be greater than 0");
            int k = Math.min(((puh)localObject).nodePosition + i - 1, paramArrayList.size());
            paramArrayList.add(k, localObject);
            ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(k));
            j += 1;
            break label196;
            i += 1;
            break;
          }
        }
        return;
      }
      label297:
      i = -1;
    }
  }
  
  protected boolean Jb()
  {
    ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    if (Thread.currentThread() == this.mWorkThread) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (this.mH.size() <= 0) {
        break label126;
      }
      ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.mH.iterator();
      for (bool = false; localIterator.hasNext(); bool = a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false) | bool) {}
    }
    if (bool) {
      this.mG = new ArrayList(this.mData);
    }
    this.mH.clear();
    for (;;)
    {
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
      return bool;
      label126:
      bool = false;
    }
  }
  
  public void K(String paramString, long paramLong)
  {
    this.mWorkHandler.post(new MsgTabNodeListLoader.12(this, paramString, paramLong));
  }
  
  public puh a(int paramInt, String paramString)
  {
    if ((this.mData == null) || (this.mData.isEmpty())) {
      return null;
    }
    if (paramInt == -1)
    {
      Iterator localIterator = this.mData.iterator();
      puh localpuh;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localpuh = (puh)localIterator.next();
      } while (!TextUtils.equals(localpuh.unionId, paramString));
      return localpuh;
    }
    paramString = new puh(paramInt, paramString);
    paramInt = this.mData.indexOf(paramString);
    if (paramInt != -1) {
      return (puh)this.mData.get(paramInt);
    }
    return null;
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null)
    {
      ram.a("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal is null!", new Object[0]);
      return;
    }
    if ((TextUtils.isEmpty(paramQQUserUIItem.uid)) || (!paramQQUserUIItem.isAvailable()))
    {
      ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
      return;
    }
    this.bY.put(paramQQUserUIItem.uid, paramQQUserUIItem);
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    boolean bool = qwv.KG();
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 1) && (!bool))
    {
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is not in testEnv", rpf.a(paramMsgTabNodePushNotify));
      return;
    }
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 0) && (bool))
    {
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is in testEnv", rpf.a(paramMsgTabNodePushNotify));
      return;
    }
    this.mWorkHandler.post(new MsgTabNodeListLoader.6(this, paramMsgTabNodePushNotify));
  }
  
  protected void a(ArrayList<puh> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ram.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() dataList=%s, isFirstPage=%b, isEnd=%b, push=%b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3));
    this.mHandler.post(new MsgTabNodeListLoader.10(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  public void a(pnx.d paramd)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramd.aAU)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramd.b.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramd.b.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramd.b.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramd.b.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramd) });
      }
      Object localObject3 = this.a.a();
      localObject2 = a(((puh)localObject3).nodeType, ((puh)localObject3).unionId);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new puh(((puh)localObject3).nodeType, ((puh)localObject3).unionId);
        ((puh)localObject1).uid = QQStoryContext.a().dE();
        a((puh)localObject1, false);
      }
      int j = ((puh)localObject1).sz();
      int k = ((puh)localObject3).sz();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(j), "\tnewUploadStatus: ", Integer.valueOf(k) });
      }
      ((puh)localObject1).e((puh)localObject3);
      if (paramd.c == null) {
        break label544;
      }
      paramd = paramd.c;
      if (!paramd.isUploadSuc()) {
        break label584;
      }
      localObject2 = new pux();
      ((pux)localObject2).aBR = false;
      ((pux)localObject2).Ak = paramd.mVideoIndex;
      if (((pux)localObject2).Ak == 0L) {
        ((pux)localObject2).Ak = paramd.mCreateTime;
      }
      if (((puh)localObject1).iO.indexOf(localObject2) == -1) {
        break label552;
      }
      i = 1;
      label339:
      if (i != 0) {
        break label557;
      }
      ((puh)localObject1).iO.add(localObject2);
      ((puh)localObject1).unreadCount += 1;
      ((puh)localObject1).videoCover = paramd.getThumbUrl();
      ((puh)localObject1).nodeInfoTimeStamp = (paramd.mCreateTime / 1000L);
      if (((puh)localObject1).mC == null) {
        ((puh)localObject1).mC = new ArrayList();
      }
      localObject3 = new qej();
      ((qej)localObject3).feedId = paramd.mAttachedFeedId;
      ((qej)localObject3).vid = paramd.mVid;
      ((qej)localObject3).Ak = paramd.mVideoIndex;
      ((qej)localObject3).aBR = false;
      ((qej)localObject3).g = paramd;
      ((puh)localObject1).mC.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((puh)localObject1).iO });
      }
      i = 1;
      label526:
      if (j != k) {
        break label589;
      }
    }
    for (;;)
    {
      if (i != 0) {
        a((puh)localObject1, true);
      }
      return;
      label544:
      paramd = paramd.b;
      break;
      label552:
      i = 0;
      break label339;
      label557:
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , but exist!!! videoInfo=", localObject2 });
      }
      label584:
      i = 0;
      break label526;
      label589:
      i = 1;
    }
  }
  
  public void a(psg parampsg)
  {
    if (!parampsg.b.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "delete video event, event=", parampsg });
    }
    if (parampsg.aBu)
    {
      parampsg = this.a.a();
      localObject = a(parampsg.nodeType, parampsg.unionId);
      if (localObject != null)
      {
        ((puh)localObject).e(parampsg);
        parampsg = (psg)localObject;
      }
      for (;;)
      {
        a(parampsg, true);
        return;
      }
    }
    int i;
    if (!TextUtils.isEmpty(parampsg.groupId))
    {
      i = 8;
      if (TextUtils.isEmpty(parampsg.groupId)) {
        break label145;
      }
    }
    label145:
    for (Object localObject = parampsg.groupId;; localObject = parampsg.uid)
    {
      a(i, (String)localObject, parampsg.Ak);
      b(i, parampsg.uid, parampsg.groupId);
      return;
      i = 5;
      break;
    }
  }
  
  public void a(puh parampuh, boolean paramBoolean)
  {
    int i = 1;
    ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(parampuh), Boolean.valueOf(paramBoolean));
    int j = this.mData.indexOf(parampuh);
    boolean bool;
    if (d(parampuh))
    {
      this.a.j(parampuh);
      this.mG = new ArrayList(this.mData);
      int k = this.mData.indexOf(parampuh);
      if (j == k) {
        break label156;
      }
      bool = true;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "insertNode: hasChangePos=", Boolean.valueOf(bool), ", oldIndex=", Integer.valueOf(j), ", newIndex=", Integer.valueOf(k) });
      }
      if (paramBoolean) {
        if (!bool) {
          break label162;
        }
      }
    }
    for (;;)
    {
      a(parampuh, false, i, false);
      return;
      label156:
      bool = false;
      break;
      label162:
      i = 2;
    }
  }
  
  protected void a(puh parampuh, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    ram.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(parampuh), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i;
    if (paramInt == 1)
    {
      int j = this.mData.indexOf(parampuh);
      i = j;
      if (j == -1) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 1, "insert position not found:" + parampuh);
      }
    }
    else
    {
      i = -1;
    }
    this.mHandler.post(new MsgTabNodeListLoader.11(this, parampuh, paramBoolean1, paramInt, i, paramBoolean2));
  }
  
  public void a(pum.b paramb)
  {
    synchronized (this.mListeners)
    {
      if (this.mListeners.contains(paramb))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramb.getClass().getSimpleName() });
      }
      this.mListeners.add(paramb);
      return;
    }
  }
  
  @WorkerThread
  public void a(@NonNull pvf parampvf, @Nullable pvf.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool;
    if (((paramErrorMessage.errorCode != 0) && (paramErrorMessage.errorCode != 15000) && (paramErrorMessage.errorCode != 15001)) || (parama == null))
    {
      ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() get latest failed: %s", paramErrorMessage.getErrorMessage());
      sl(false);
      bool = Jb();
      p(this.mData, true);
      if (bool)
      {
        this.mG = new ArrayList(this.mData);
        a(this.mG, true, this.mIsEnd, true);
      }
      this.aM.set(false);
      return;
    }
    sl(true);
    this.aBM = parama.aCd;
    if (TextUtils.equals(this.mSeq, parama.seq))
    {
      ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.mSeq, Integer.valueOf(this.mData.size()));
      if (paramErrorMessage.errorCode == 15001)
      {
        paramErrorMessage = null;
        parampvf = paramErrorMessage;
        if (parama.mL.size() > 0)
        {
          i = 0;
          parampvf = paramErrorMessage;
          if (i < parama.mL.size())
          {
            parampvf = (puh)parama.mL.get(i);
            if (parampvf.nodeType != 12) {
              break label372;
            }
          }
        }
        if (parampvf != null)
        {
          ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i = 0;
          label232:
          if (i >= this.mData.size()) {
            break label680;
          }
          if (((puh)this.mData.get(i)).nodeType != 12) {
            break label381;
          }
          this.mData.set(i, parampvf);
        }
      }
    }
    label680:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mData.add(parampvf);
      }
      p(this.mData, true);
      Jb();
      ed(this.mData);
      eb(this.mData);
      ci(this.mData);
      this.mG = new ArrayList(this.mData);
      a(this.mG, true, this.mIsEnd, false);
      this.aM.set(false);
      sm(false);
      return;
      label372:
      i += 1;
      break;
      label381:
      i += 1;
      break label232;
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(parama.mL.size()));
      i = 0;
      while (i < parama.mL.size())
      {
        f((puh)parama.mL.get(i));
        i += 1;
      }
      if (parampvf.source == 1) {}
      for (bool = f(this.mData, parama.mL);; bool = false)
      {
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
        this.mSeq = parama.seq;
        this.mCookie = parama.cookie;
        this.mData.clear();
        this.mData.addAll(parama.mL);
        ci(this.mData);
        p(this.mData, true);
        this.mIsEnd = parama.isEnd;
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
        Jb();
        bmO();
        f(false, false);
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
        this.a.A(this.mData, true);
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
        ed(this.mData);
        eb(this.mData);
        this.mG = new ArrayList(this.mData);
        a(this.mG, true, this.mIsEnd, false);
        this.aM.set(false);
        sm(bool);
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(this.mData.size()));
        return;
      }
    }
  }
  
  @WorkerThread
  public void a(pxs.b paramb)
  {
    if ((paramb.b.isSuccess()) && (paramb.mX != null) && (!paramb.mX.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent isSuccess userUIItems: " + paramb.mX);
      }
      int j = paramb.mX.size();
      i = 0;
      if (i >= j) {
        break label183;
      }
      if (c(((QQUserUIItem)paramb.mX.get(i)).uid) == null) {}
    }
    label183:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mHandler.post(new MsgTabNodeListLoader.13(this));
      }
      do
      {
        return;
        i += 1;
        break;
      } while (!QLog.isColorLevel());
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent errorInfo: " + paramb.b + ", userUIItems = " + paramb.mX);
      return;
    }
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    ram.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.iO.size() - 1;
    label52:
    pux localpux;
    if (i >= 0)
    {
      localpux = (pux)paramString.iO.get(i);
      if (localpux.Ak == paramLong)
      {
        paramString.iO.remove(i);
        bool1 = true;
      }
    }
    for (;;)
    {
      i -= 1;
      break label52;
      if (!localpux.aBR)
      {
        paramInt += 1;
        continue;
        paramString.unreadCount = paramInt;
        if ((!bool1) && (QLog.isDevelopLevel())) {
          QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "deleteNodeVideoFromNodeInfoFromWorkThread, nothing to delete", " info.unreadCount =", Integer.valueOf(paramString.unreadCount), ", info.videoInfoList=", paramString.iO });
        }
        if (paramString.iO.isEmpty())
        {
          this.mData.remove(paramString);
          this.mG = new ArrayList(this.mData);
          this.a.k(paramString);
          a(paramString, false, 3, false);
          return bool1;
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.a.j(paramString);
        a(paramString, false, 2, false);
        return bool1;
      }
    }
  }
  
  public void b(pnx.d paramd)
  {
    this.mWorkHandler.post(new MsgTabNodeListLoader.15(this, paramd));
  }
  
  public void b(psg parampsg)
  {
    this.mWorkHandler.post(new MsgTabNodeListLoader.16(this, parampsg));
  }
  
  public void b(pum.b paramb)
  {
    synchronized (this.mListeners)
    {
      this.mListeners.remove(paramb);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramb.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(pxs.b paramb)
  {
    this.mWorkHandler.post(new MsgTabNodeListLoader.14(this, paramb));
  }
  
  public boolean b(int paramInt, String paramString1, String paramString2)
  {
    ram.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidListFromWorkThread(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return puy.g(new puh(paramInt, paramString1));
      paramString1 = paramString2;
    }
  }
  
  @GuardedBy("mNotifyLock")
  public void bmP()
  {
    if (rpj.ei(52) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mHasRedPoint = bool;
      if ((!this.aBJ) || (!this.aBH)) {
        break;
      }
      return;
    }
    for (;;)
    {
      synchronized (this.bo)
      {
        this.aBH = true;
        if (this.aBJ)
        {
          this.aBJ = false;
          i = 1;
          if (i == 0) {
            break;
          }
          ((pma)QQStoryContext.c().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
          return;
        }
      }
      int i = 0;
    }
  }
  
  public ArrayList<puh> bq()
  {
    return this.mData;
  }
  
  @UiThread
  public ArrayList<puh> br()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      return this.mG;
    }
  }
  
  public puh c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mData == null) || (this.mData.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.mData.iterator();
    while (localIterator.hasNext())
    {
      puh localpuh = (puh)localIterator.next();
      if (TextUtils.equals(paramString, localpuh.unionId)) {
        return localpuh;
      }
    }
    return null;
  }
  
  public void cr(String paramString1, String paramString2)
  {
    paramString1 = new pvq(paramString1, paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide request = " + paramString1.toString());
    }
    ppv.a().a(paramString1, new puo(this));
  }
  
  public void destroy()
  {
    this.bY.clear();
    synchronized (this.mListeners)
    {
      this.mListeners.clear();
      this.mHandler.removeCallbacksAndMessages(null);
      return;
    }
  }
  
  void ec(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
    }
    for (;;)
    {
      return;
      ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      psu localpsu = (psu)psx.a(5);
      int i = 0;
      while (i < paramList.size())
      {
        localpsu.b((String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public boolean f(puh parampuh)
  {
    boolean bool = e(parampuh);
    if (bool)
    {
      this.a.k(parampuh);
      a(parampuh, false, 3, false);
    }
    return bool;
  }
  
  protected boolean f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QQStoryContext.a() != null) {}
    return false;
  }
  
  public void g(puh parampuh)
  {
    Iterator localIterator = this.mData.iterator();
    while (localIterator.hasNext())
    {
      puh localpuh = (puh)localIterator.next();
      if ((localpuh.nodeType == 13) && (TextUtils.equals(localpuh.unionId, parampuh.unionId))) {
        parampuh.firstExp = localpuh.firstExp;
      }
    }
  }
  
  public void h(puh parampuh)
  {
    this.mWorkHandler.post(new MsgTabNodeListLoader.7(this, parampuh));
  }
  
  @WorkerThread
  public boolean h(String paramString, long paramLong)
  {
    ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i = paramString.iO.size() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (pux)paramString.iO.get(i);
      if ((((pux)localObject).Ak == paramLong) && (!((pux)localObject).aBR))
      {
        ((pux)localObject).aBR = true;
        paramString.unreadCount -= 1;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramString.unreadCount <= 0) && (!paramString.iO.isEmpty()))
      {
        localObject = new pvh();
        ((pvh)localObject).unionId = paramString.unionId;
        ((pvh)localObject).nodeType = paramString.nodeType;
        ((pvh)localObject).operation = 5;
        ((pvh)localObject).recommendId = paramString.recommendId;
        ppv.a().a((ppw)localObject, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.iO });
      }
      if (bool)
      {
        i = this.mData.indexOf(paramString);
        if (i >= 0)
        {
          localObject = (puh)this.mData.get(i);
          ((puh)localObject).copy(paramString);
          this.a.j((puh)localObject);
        }
        a(paramString, false, 2, false);
      }
      return bool;
      i -= 1;
      break;
    }
  }
  
  public void rr(String paramString)
  {
    ram.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "scheduleRequireUserItem() %s", paramString);
    Message.obtain(this.mWorkHandler, 2, paramString).sendToTarget();
  }
  
  protected void sl(boolean paramBoolean)
  {
    this.mHandler.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  @GuardedBy("mNotifyLock")
  public void sm(boolean paramBoolean)
  {
    synchronized (this.bo)
    {
      this.aBI = true;
      this.aBL = paramBoolean;
      if (this.aBH)
      {
        i = 1;
        if (i != 0)
        {
          ??? = new ArrayList(this.mData).iterator();
          while (((Iterator)???).hasNext())
          {
            puh localpuh = (puh)((Iterator)???).next();
            if ((localpuh.unreadCount > 0) && (localpuh.nodeType == 6)) {
              this.aBK = true;
            }
          }
          ((pma)QQStoryContext.c().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
        }
        return;
      }
      this.aBJ = true;
      int i = 0;
    }
  }
  
  public void vY(int paramInt)
  {
    if (!this.aM.compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestLatestPage() is loading, ignore this request...");
      }
    }
    pvf localpvf;
    do
    {
      return;
      localpvf = new pvf();
      localpvf.seq = this.mSeq;
      localpvf.source = paramInt;
      psr localpsr = (psr)psx.a(10);
      boolean bool = ((Boolean)localpsr.c("key_force_refresh_msg_node_list", Boolean.valueOf(false))).booleanValue();
      if (bool) {
        localpsr.n("key_force_refresh_msg_node_list", Boolean.valueOf(false));
      }
      localpvf.forceRefresh = bool;
      ppv.a().a(localpvf, this.jdField_b_of_type_Ppv$b);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", localpvf.toString() });
  }
  
  public class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
          removeMessages(1);
          ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader.workHandler", "handleMessage() MSG_LOAD_USER_ITEM_FROM_UI");
          paramMessage = new ArrayList(pum.this.aD);
          pum.this.aD.clear();
        } while (!pum.a(pum.this, paramMessage, false));
        pum.this.mHandler.post(new MsgTabNodeListLoader.MsgTabWorkThreadHandler.1(this));
        return;
        ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader.workHandler", "handleMessage() MSG_SCHEDULE_REQUIRE_USER_ITEM");
        paramMessage = (String)paramMessage.obj;
      } while (pum.this.aD.contains(paramMessage));
      pum.this.aD.add(paramMessage);
      sendEmptyMessageDelayed(1, 2500L);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(puh parampuh, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2);
    
    public abstract void b(ArrayList<puh> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
    
    public abstract void bmQ();
    
    public abstract void sn(boolean paramBoolean);
    
    public abstract void so(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pum
 * JD-Core Version:    0.7.0.1
 */