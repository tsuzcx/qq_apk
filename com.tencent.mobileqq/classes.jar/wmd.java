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
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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

public class wmd
{
  protected static Comparator<wly> a;
  protected static Comparator<wly> b;
  protected Handler a;
  protected HandlerThread a;
  protected final Object a;
  protected String a;
  protected volatile ArrayList<wly> a;
  protected HashMap<String, Boolean> a;
  protected Set<String> a;
  protected ConcurrentHashMap<String, QQUserUIItem> a;
  protected AtomicBoolean a;
  protected wfk<wnc, wnd> a;
  protected wmr a;
  private wrc a;
  protected boolean a;
  protected Handler b;
  protected String b;
  protected volatile ArrayList<wly> b;
  boolean b;
  protected ArrayList<qqstory_service.MsgTabNodePushNotify> c;
  boolean c;
  public final ArrayList<wmk> d;
  boolean d;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new wlz();
    jdField_b_of_type_JavaUtilComparator = new wma();
  }
  
  wmd(QQAppInterface paramQQAppInterface, wmr paramwmr)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new ArraySet());
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandlerThread = ((HandlerThread)ThreadManagerV2.getRecentThread());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Wrc = new wme(this);
    this.jdField_a_of_type_Wfk = new wmg(this);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListLoader ctor()");
    if (paramQQAppInterface == null) {
      ykq.c("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.jdField_a_of_type_Wmr = paramwmr;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Wmr.a();
    a(this.jdField_a_of_type_JavaUtilArrayList, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_AndroidOsHandler = new wmj(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "create new loader");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramQQAppInterface = (wly)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = 0;
      while (j < paramQQAppInterface.jdField_a_of_type_JavaUtilList.size())
      {
        paramwmr = (wmq)paramQQAppInterface.jdField_a_of_type_JavaUtilList.get(j);
        String str = paramQQAppInterface.jdField_a_of_type_JavaLangString + "-" + paramwmr.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(paramwmr.jdField_a_of_type_Boolean));
        j += 1;
      }
      i += 1;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.5(this));
  }
  
  private void a(ArrayList<wly> paramArrayList) {}
  
  private static void a(ArrayList<wly> paramArrayList, boolean paramBoolean)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() listSize=%d, sortOriginList=%b", Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean));
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      wly localwly = (wly)((Iterator)localObject).next();
      if (localwly.jdField_c_of_type_Int > 0)
      {
        localArrayList.add(localwly);
        ((Iterator)localObject).remove();
      }
    }
    if (paramBoolean) {
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
    }
    int i;
    if (localArrayList.size() > 0)
    {
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, jdField_b_of_type_JavaUtilComparator);
      i = 0;
      if (i >= paramArrayList.size()) {
        break label297;
      }
      localObject = (wly)paramArrayList.get(i);
      if ((((wly)localObject).jdField_a_of_type_Int != 1) && (((wly)localObject).jdField_a_of_type_Int != 4) && (((wly)localObject).jdField_a_of_type_Int != 3)) {
        ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i));
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
          localObject = (wly)localArrayList.get(j);
          if (((wly)localObject).jdField_c_of_type_Int > 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            zdl.a(paramBoolean, "position must be greater than 0");
            int k = Math.min(((wly)localObject).jdField_c_of_type_Int + i - 1, paramArrayList.size());
            paramArrayList.add(k, localObject);
            ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(k));
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
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", zel.a(paramMsgTabNodePushNotify) });
    }
    wly localwly = new wly();
    localwly.a((qqstory_service.MsgTabNodeInfo)paramMsgTabNodePushNotify.msg_notify_node_info.get());
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
      if (localwly.jdField_a_of_type_Int == 5)
      {
        paramMsgTabNodePushNotify = this.jdField_a_of_type_Wmr.a();
        if (paramMsgTabNodePushNotify.jdField_d_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localwly);
          if (i == -1) {
            break label329;
          }
          localwly.a((wly)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if ((localwly.jdField_a_of_type_Int != 7) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localwly) != -1)) {
        break label345;
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label345;
      }
      paramMsgTabNodePushNotify = (wly)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((paramMsgTabNodePushNotify.jdField_a_of_type_Int == 9) && (TextUtils.equals(localwly.jdField_a_of_type_JavaLangString, paramMsgTabNodePushNotify.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, localwly);
        this.jdField_a_of_type_Wmr.b(paramMsgTabNodePushNotify);
        this.jdField_a_of_type_Wmr.a(localwly);
        if (paramBoolean)
        {
          a(paramMsgTabNodePushNotify, true, 3, bool1);
          a(localwly, true, 1, bool1);
        }
        ykv.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localwly.jdField_a_of_type_Int) });
        return true;
        bool1 = false;
        break;
        label329:
        localwly.a(paramMsgTabNodePushNotify);
        break label168;
      }
      i += 1;
    }
    label345:
    c(localwly);
    boolean bool2 = b(localwly);
    c(Collections.singletonList(localwly));
    b(Collections.singletonList(localwly));
    if (bool2)
    {
      this.jdField_a_of_type_Wmr.a(localwly);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaLangString = str;
      if (paramBoolean) {
        a(localwly, true, 1, bool1);
      }
      ykv.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localwly.jdField_a_of_type_Int) });
    }
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localwly);
    paramBoolean = bool2;
    for (;;)
    {
      return paramBoolean;
      label476:
      if (i == 2)
      {
        bool2 = c(localwly);
        if (bool2)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_Wmr.b(localwly);
          this.jdField_b_of_type_JavaLangString = str;
          if (paramBoolean) {
            a(localwly, true, 3, bool1);
          }
        }
        ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localwly);
        paramBoolean = bool2;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public static boolean a(List<wly> paramList1, List<wly> paramList2)
  {
    boolean bool2 = false;
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    if (i < paramList1.size())
    {
      localObject1 = ((wly)paramList1.get(i)).jdField_a_of_type_JavaLangString;
      if (((wly)paramList1.get(i)).jdField_a_of_type_Int == 12) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((wly)paramList1.get(i)).jdField_a_of_type_JavaUtilList;
        j = 0;
        while (j < ((List)localObject2).size())
        {
          wmq localwmq = (wmq)((List)localObject2).get(j);
          if (!localwmq.jdField_a_of_type_Boolean) {
            localHashSet.add((String)localObject1 + "-" + localwmq.jdField_a_of_type_Long);
          }
          j += 1;
        }
      }
    }
    i = 0;
    boolean bool1 = bool2;
    if (i < paramList2.size())
    {
      paramList1 = ((wly)paramList2.get(i)).jdField_a_of_type_JavaLangString;
      if (((wly)paramList2.get(i)).jdField_a_of_type_Int != 12) {}
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = ((wly)paramList2.get(i)).jdField_a_of_type_JavaUtilList;
      j = 0;
      while (j < ((List)localObject1).size())
      {
        localObject2 = (wmq)((List)localObject1).get(j);
        if ((!((wmq)localObject2).jdField_a_of_type_Boolean) && (!localHashSet.contains(paramList1 + "-" + ((wmq)localObject2).jdField_a_of_type_Long)))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
    }
  }
  
  private boolean a(List<String> paramList, boolean paramBoolean)
  {
    if (paramList.isEmpty())
    {
      ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    wke localwke = (wke)wjs.a(2);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = localwke.b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList.add(new wkz("", str));
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
        new wrb(this.jdField_a_of_type_Wrc).a(1, localArrayList);
        ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() Will fetch %s users", localArrayList);
      }
    }
    for (;;)
    {
      return bool;
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() miss %s users, did not find in db, won't request", localArrayList);
      continue;
      ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() All nodes has local cache, no need request");
    }
  }
  
  @WorkerThread
  private void b(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    if (ykq.a()) {
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "onHandlePushMsg %s", zel.a(paramMsgTabNodePushNotify));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramMsgTabNodePushNotify);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "refreshing, add to waiting queue");
      }
      return;
    }
    a(paramMsgTabNodePushNotify, true);
  }
  
  private void b(List<wly> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int k;
    wly localwly;
    for (int j = 0;; j = k)
    {
      if ((j < paramList.size()) && (i < 8))
      {
        k = j + 1;
        localwly = (wly)paramList.get(j);
        if (localwly.jdField_b_of_type_Int == 0) {
          ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(j));
        }
      }
      else
      {
        label75:
        a(localArrayList2);
        if (!localArrayList1.isEmpty()) {
          break label287;
        }
        ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest is empty");
        return;
      }
      if ((localwly.jdField_a_of_type_Int == 6) || (localwly.jdField_a_of_type_Int == 9) || (localwly.jdField_a_of_type_Int == 7) || (localwly.jdField_a_of_type_Int == 5)) {
        break;
      }
    }
    Iterator localIterator = localwly.jdField_a_of_type_JavaUtilList.iterator();
    label155:
    wmq localwmq;
    if (localIterator.hasNext())
    {
      localwmq = (wmq)localIterator.next();
      if (TextUtils.isEmpty(localwmq.jdField_a_of_type_JavaLangString))
      {
        localArrayList1.add(localwly);
        i += 1;
        ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(k));
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(k));
        break label75;
        if (localwmq.jdField_a_of_type_Boolean) {
          break label155;
        }
        localArrayList2.add(localwmq.jdField_a_of_type_JavaLangString);
        i += 1;
        ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(k), localwmq.jdField_a_of_type_JavaLangString);
        j = 1;
        continue;
      }
      j = k;
      break;
      label287:
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest load vidlist size=%d", Integer.valueOf(localArrayList1.size()));
      Stream.fromIterator(localArrayList1.iterator()).map(new wmi(this)).map(new wmo("MsgTabPreloader")).subscribe(new wmh(this));
      return;
      j = 0;
    }
  }
  
  private boolean b(wly paramwly)
  {
    boolean bool;
    int i;
    int j;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread)
    {
      bool = true;
      zdl.a(bool);
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwly);
      if (i != -1)
      {
        wly localwly = (wly)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramwly.jdField_c_of_type_Long < localwly.jdField_c_of_type_Long) {
          break label127;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramwly);
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label136;
      }
      if (jdField_a_of_type_JavaUtilComparator.compare(paramwly, this.jdField_a_of_type_JavaUtilArrayList.get(i)) <= 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(i, paramwly);
        a(this.jdField_a_of_type_JavaUtilArrayList, false);
        return true;
        bool = false;
        break;
        label127:
        return false;
      }
      i += 1;
    }
    label136:
    this.jdField_a_of_type_JavaUtilArrayList.add(paramwly);
    a(this.jdField_a_of_type_JavaUtilArrayList, false);
    return true;
  }
  
  @WorkerThread
  private void c()
  {
    ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    Object localObject = this.jdField_a_of_type_Wmr.a();
    if (((wly)localObject).jdField_d_of_type_Int > 0)
    {
      wly localwly = a(((wly)localObject).jdField_a_of_type_Int, ((wly)localObject).jdField_a_of_type_JavaLangString);
      if (localwly == null) {
        break label54;
      }
      localwly.a((wly)localObject);
      localObject = localwly;
    }
    label54:
    for (;;)
    {
      a((wly)localObject, false);
      return;
    }
  }
  
  private void c(List<wly> paramList)
  {
    wke localwke = (wke)wjs.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (wly)paramList.get(i);
      if ((((wly)localObject).jdField_a_of_type_Int == 12) || (((wly)localObject).jdField_a_of_type_Int == 10) || (((wly)localObject).jdField_a_of_type_Int == 11) || (((wly)localObject).jdField_a_of_type_Int == 13)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((wly)localObject).jdField_a_of_type_JavaLangString;
        QQUserUIItem localQQUserUIItem = localwke.b((String)localObject);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          localArrayList.add(new wkz("", (String)localObject));
        } else {
          a(localQQUserUIItem);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      new wrb(this.jdField_a_of_type_Wrc).a(1, localArrayList);
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private void c(wly paramwly)
  {
    int i = paramwly.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < paramwly.jdField_a_of_type_JavaUtilList.size())
    {
      wmq localwmq = (wmq)paramwly.jdField_a_of_type_JavaUtilList.get(j);
      Object localObject = paramwly.jdField_a_of_type_JavaLangString + "-" + localwmq.jdField_a_of_type_Long;
      localObject = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localwmq.jdField_a_of_type_Boolean = true;
      }
      if (!localwmq.jdField_a_of_type_Boolean) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      j += 1;
      break;
      paramwly.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  private boolean c(wly paramwly)
  {
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool);
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwly);
      if (i == -1) {
        break;
      }
      wly localwly = (wly)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramwly.jdField_c_of_type_Long >= localwly.jdField_c_of_type_Long) {
        break;
      }
      return false;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.remove(paramwly);
  }
  
  public ArrayList<wly> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public wly a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    if (paramInt == -1)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      wly localwly;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localwly = (wly)localIterator.next();
      } while (!TextUtils.equals(localwly.jdField_a_of_type_JavaLangString, paramString));
      return localwly;
    }
    paramString = new wly(paramInt, paramString);
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    if (paramInt != -1) {
      return (wly)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public wly a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      wly localwly = (wly)localIterator.next();
      if (TextUtils.equals(paramString, localwly.jdField_a_of_type_JavaLangString)) {
        return localwly;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestLatestPage() is loading, ignore this request...");
      }
    }
    wnc localwnc;
    do
    {
      return;
      localwnc = new wnc();
      localwnc.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localwnc.jdField_c_of_type_Int = paramInt;
      wjl localwjl = (wjl)wjs.a(10);
      boolean bool = ((Boolean)localwjl.b("key_force_refresh_msg_node_list", Boolean.valueOf(false))).booleanValue();
      if (bool) {
        localwjl.b("key_force_refresh_msg_node_list", Boolean.valueOf(false));
      }
      localwnc.jdField_a_of_type_Boolean = bool;
      wfi.a().a(localwnc, this.jdField_a_of_type_Wfk);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", localwnc.toString() });
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null)
    {
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal is null!", new Object[0]);
      return;
    }
    if ((TextUtils.isEmpty(paramQQUserUIItem.uid)) || (!paramQQUserUIItem.isAvailable()))
    {
      ykq.d("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQUserUIItem.uid, paramQQUserUIItem);
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    boolean bool = yfc.a();
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 1) && (!bool))
    {
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is not in testEnv", zel.a(paramMsgTabNodePushNotify));
      return;
    }
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 0) && (bool))
    {
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is in testEnv", zel.a(paramMsgTabNodePushNotify));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.6(this, paramMsgTabNodePushNotify));
  }
  
  public void a(String paramString)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "scheduleRequireUserItem() %s", paramString);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, paramString).sendToTarget();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.12(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new wnt(paramString1, paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide request = " + paramString1.toString());
    }
    wfi.a().a(paramString1, new wmf(this));
  }
  
  protected void a(ArrayList<wly> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() dataList=%s, isFirstPage=%b, isEnd=%b, push=%b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3));
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.10(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
    }
    for (;;)
    {
      return;
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      wjp localwjp = (wjp)wjs.a(5);
      int i = 0;
      while (i < paramList.size())
      {
        localwjp.b((String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public void a(wcx paramwcx)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramwcx.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramwcx) });
      }
      Object localObject3 = this.jdField_a_of_type_Wmr.a();
      localObject2 = a(((wly)localObject3).jdField_a_of_type_Int, ((wly)localObject3).jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new wly(((wly)localObject3).jdField_a_of_type_Int, ((wly)localObject3).jdField_a_of_type_JavaLangString);
        ((wly)localObject1).jdField_b_of_type_Long = QQStoryContext.a().a();
        a((wly)localObject1, false);
      }
      int j = ((wly)localObject1).a();
      int k = ((wly)localObject3).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(j), "\tnewUploadStatus: ", Integer.valueOf(k) });
      }
      ((wly)localObject1).a((wly)localObject3);
      if (paramwcx.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
        break label544;
      }
      paramwcx = paramwcx.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      if (!paramwcx.isUploadSuc()) {
        break label584;
      }
      localObject2 = new wmq();
      ((wmq)localObject2).jdField_a_of_type_Boolean = false;
      ((wmq)localObject2).jdField_a_of_type_Long = paramwcx.mVideoIndex;
      if (((wmq)localObject2).jdField_a_of_type_Long == 0L) {
        ((wmq)localObject2).jdField_a_of_type_Long = paramwcx.mCreateTime;
      }
      if (((wly)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localObject2) == -1) {
        break label552;
      }
      i = 1;
      label339:
      if (i != 0) {
        break label557;
      }
      ((wly)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
      ((wly)localObject1).jdField_b_of_type_Int += 1;
      ((wly)localObject1).g = paramwcx.getThumbUrl();
      ((wly)localObject1).jdField_d_of_type_Long = (paramwcx.mCreateTime / 1000L);
      if (((wly)localObject1).jdField_b_of_type_JavaUtilList == null) {
        ((wly)localObject1).jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      localObject3 = new wzh();
      ((wzh)localObject3).jdField_a_of_type_JavaLangString = paramwcx.mAttachedFeedId;
      ((wzh)localObject3).jdField_b_of_type_JavaLangString = paramwcx.mVid;
      ((wzh)localObject3).jdField_a_of_type_Long = paramwcx.mVideoIndex;
      ((wzh)localObject3).jdField_a_of_type_Boolean = false;
      ((wzh)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramwcx;
      ((wly)localObject1).jdField_b_of_type_JavaUtilList.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((wly)localObject1).jdField_a_of_type_JavaUtilList });
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
        a((wly)localObject1, true);
      }
      return;
      label544:
      paramwcx = paramwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
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
  
  public void a(wix paramwix)
  {
    if (!paramwix.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "delete video event, event=", paramwix });
    }
    if (paramwix.jdField_a_of_type_Boolean)
    {
      paramwix = this.jdField_a_of_type_Wmr.a();
      localObject = a(paramwix.jdField_a_of_type_Int, paramwix.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        ((wly)localObject).a(paramwix);
        paramwix = (wix)localObject;
      }
      for (;;)
      {
        a(paramwix, true);
        return;
      }
    }
    int i;
    if (!TextUtils.isEmpty(paramwix.c))
    {
      i = 8;
      if (TextUtils.isEmpty(paramwix.c)) {
        break label145;
      }
    }
    label145:
    for (Object localObject = paramwix.c;; localObject = paramwix.jdField_b_of_type_JavaLangString)
    {
      a(i, (String)localObject, paramwix.jdField_a_of_type_Long);
      a(i, paramwix.jdField_b_of_type_JavaLangString, paramwix.c);
      return;
      i = 5;
      break;
    }
  }
  
  public void a(wly paramwly)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      wly localwly = (wly)localIterator.next();
      if ((localwly.jdField_a_of_type_Int == 13) && (TextUtils.equals(localwly.jdField_a_of_type_JavaLangString, paramwly.jdField_a_of_type_JavaLangString))) {
        paramwly.jdField_d_of_type_Boolean = localwly.jdField_d_of_type_Boolean;
      }
    }
  }
  
  public void a(wly paramwly, boolean paramBoolean)
  {
    int i = 1;
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramwly), Boolean.valueOf(paramBoolean));
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwly);
    boolean bool;
    if (b(paramwly))
    {
      this.jdField_a_of_type_Wmr.a(paramwly);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwly);
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
      a(paramwly, false, i, false);
      return;
      label156:
      bool = false;
      break;
      label162:
      i = 2;
    }
  }
  
  protected void a(wly paramwly, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(paramwly), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i;
    if (paramInt == 1)
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwly);
      i = j;
      if (j == -1) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 1, "insert position not found:" + paramwly);
      }
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.11(this, paramwly, paramBoolean1, paramInt, i, paramBoolean2));
  }
  
  public void a(wmk paramwmk)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (this.jdField_d_of_type_JavaUtilArrayList.contains(paramwmk))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramwmk.getClass().getSimpleName() });
      }
      this.jdField_d_of_type_JavaUtilArrayList.add(paramwmk);
      return;
    }
  }
  
  @WorkerThread
  public void a(@NonNull wnc paramwnc, @Nullable wnd paramwnd, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool;
    if (((paramErrorMessage.errorCode != 0) && (paramErrorMessage.errorCode != 15000) && (paramErrorMessage.errorCode != 15001)) || (paramwnd == null))
    {
      ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() get latest failed: %s", paramErrorMessage.getErrorMessage());
      a(false);
      bool = a();
      a(this.jdField_a_of_type_JavaUtilArrayList, true);
      if (bool)
      {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, true);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    a(true);
    this.h = paramwnd.jdField_a_of_type_Boolean;
    if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramwnd.jdField_a_of_type_JavaLangString))
    {
      ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      if (paramErrorMessage.errorCode == 15001)
      {
        paramErrorMessage = null;
        paramwnc = paramErrorMessage;
        if (paramwnd.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          paramwnc = paramErrorMessage;
          if (i < paramwnd.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramwnc = (wly)paramwnd.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (paramwnc.jdField_a_of_type_Int != 12) {
              break label372;
            }
          }
        }
        if (paramwnc != null)
        {
          ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i = 0;
          label232:
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label673;
          }
          if (((wly)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != 12) {
            break label381;
          }
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramwnc);
        }
      }
    }
    label673:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwnc);
      }
      a(this.jdField_a_of_type_JavaUtilArrayList, true);
      a();
      c(this.jdField_a_of_type_JavaUtilArrayList);
      b(this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      b(false);
      return;
      label372:
      i += 1;
      break;
      label381:
      i += 1;
      break label232;
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramwnd.jdField_a_of_type_JavaUtilArrayList.size()));
      i = 0;
      while (i < paramwnd.jdField_a_of_type_JavaUtilArrayList.size())
      {
        c((wly)paramwnd.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      if (paramwnc.jdField_c_of_type_Int == 1) {}
      for (bool = a(this.jdField_a_of_type_JavaUtilArrayList, paramwnd.jdField_a_of_type_JavaUtilArrayList);; bool = false)
      {
        ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
        ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
        this.jdField_b_of_type_JavaLangString = paramwnd.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_JavaLangString = paramwnd.c;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramwnd.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList, true);
        this.jdField_a_of_type_Boolean = paramwnd.jdField_b_of_type_Boolean;
        ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
        a();
        c();
        ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
        this.jdField_a_of_type_Wmr.a(this.jdField_a_of_type_JavaUtilArrayList, true);
        ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
        c(this.jdField_a_of_type_JavaUtilArrayList);
        b(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        b(bool);
        ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
        return;
      }
    }
  }
  
  @WorkerThread
  public void a(wrd paramwrd)
  {
    if ((paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwrd.jdField_a_of_type_JavaUtilList != null) && (!paramwrd.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent isSuccess userUIItems: " + paramwrd.jdField_a_of_type_JavaUtilList);
      }
      int j = paramwrd.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      if (i >= j) {
        break label183;
      }
      if (a(((QQUserUIItem)paramwrd.jdField_a_of_type_JavaUtilList.get(i)).uid) == null) {}
    }
    label183:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.13(this));
      }
      do
      {
        return;
        i += 1;
        break;
      } while (!QLog.isColorLevel());
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent errorInfo: " + paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramwrd.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  protected boolean a()
  {
    ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label126;
      }
      ykq.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (bool = false; localIterator.hasNext(); bool = a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false) | bool) {}
    }
    if (bool) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    for (;;)
    {
      ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
      return bool;
      label126:
      bool = false;
    }
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    label52:
    wmq localwmq;
    if (i >= 0)
    {
      localwmq = (wmq)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if (localwmq.jdField_a_of_type_Long == paramLong)
      {
        paramString.jdField_a_of_type_JavaUtilList.remove(i);
        bool1 = true;
      }
    }
    for (;;)
    {
      i -= 1;
      break label52;
      if (!localwmq.jdField_a_of_type_Boolean)
      {
        paramInt += 1;
        continue;
        paramString.jdField_b_of_type_Int = paramInt;
        if ((!bool1) && (QLog.isDevelopLevel())) {
          QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "deleteNodeVideoFromNodeInfoFromWorkThread, nothing to delete", " info.unreadCount =", Integer.valueOf(paramString.jdField_b_of_type_Int), ", info.videoInfoList=", paramString.jdField_a_of_type_JavaUtilList });
        }
        if (paramString.jdField_a_of_type_JavaUtilList.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_Wmr.b(paramString);
          a(paramString, false, 3, false);
          return bool1;
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_Wmr.a(paramString);
        a(paramString, false, 2, false);
        return bool1;
      }
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidListFromWorkThread(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return wmr.a(new wly(paramInt, paramString1));
      paramString1 = paramString2;
    }
  }
  
  @WorkerThread
  public boolean a(String paramString, long paramLong)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (wmq)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if ((((wmq)localObject).jdField_a_of_type_Long == paramLong) && (!((wmq)localObject).jdField_a_of_type_Boolean))
      {
        ((wmq)localObject).jdField_a_of_type_Boolean = true;
        paramString.jdField_b_of_type_Int -= 1;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramString.jdField_b_of_type_Int <= 0) && (!paramString.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = new wng();
        ((wng)localObject).jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        ((wng)localObject).jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
        ((wng)localObject).jdField_d_of_type_Int = 5;
        ((wng)localObject).jdField_b_of_type_Long = paramString.e;
        wfi.a().a((wfm)localObject, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.jdField_a_of_type_JavaUtilList });
      }
      if (bool)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
        if (i >= 0)
        {
          localObject = (wly)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((wly)localObject).copy(paramString);
          this.jdField_a_of_type_Wmr.a((wly)localObject);
        }
        a(paramString, false, 2, false);
      }
      return bool;
      i -= 1;
      break;
    }
  }
  
  public boolean a(wly paramwly)
  {
    boolean bool = c(paramwly);
    if (bool)
    {
      this.jdField_a_of_type_Wmr.b(paramwly);
      a(paramwly, false, 3, false);
    }
    return bool;
  }
  
  @UiThread
  public ArrayList<wly> b()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zdl.a(bool);
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
  }
  
  @GuardedBy("mNotifyLock")
  public void b()
  {
    if (zez.a(52) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          i = 1;
          if (i == 0) {
            break;
          }
          ((vzu)QQStoryContext.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1026, true, Boolean.valueOf(false));
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void b(wcx paramwcx)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.15(this, paramwcx));
  }
  
  public void b(wix paramwix)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.16(this, paramwix));
  }
  
  public void b(wly paramwly)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.7(this, paramwly));
  }
  
  public void b(wmk paramwmk)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(paramwmk);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramwmk.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(wrd paramwrd)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.14(this, paramwrd));
  }
  
  @GuardedBy("mNotifyLock")
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Boolean = true;
      this.f = paramBoolean;
      if (this.jdField_b_of_type_Boolean)
      {
        i = 1;
        if (i != 0)
        {
          ??? = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
          while (((Iterator)???).hasNext())
          {
            wly localwly = (wly)((Iterator)???).next();
            if ((localwly.jdField_b_of_type_Int > 0) && (localwly.jdField_a_of_type_Int == 6)) {
              this.e = true;
            }
          }
          ((vzu)QQStoryContext.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1026, true, Boolean.valueOf(false));
        }
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmd
 * JD-Core Version:    0.7.0.1
 */