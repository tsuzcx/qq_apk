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

public class wvs
{
  protected static Comparator<wvn> a;
  protected static Comparator<wvn> b;
  protected Handler a;
  protected HandlerThread a;
  protected final Object a;
  protected String a;
  protected volatile ArrayList<wvn> a;
  protected HashMap<String, Boolean> a;
  protected Set<String> a;
  protected ConcurrentHashMap<String, QQUserUIItem> a;
  protected AtomicBoolean a;
  protected woy<wwr, wws> a;
  protected wwg a;
  private xar a;
  protected boolean a;
  protected Handler b;
  protected String b;
  protected volatile ArrayList<wvn> b;
  boolean b;
  protected ArrayList<qqstory_service.MsgTabNodePushNotify> c;
  boolean c;
  public final ArrayList<wvz> d;
  boolean d;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new wvo();
    jdField_b_of_type_JavaUtilComparator = new wvp();
  }
  
  wvs(QQAppInterface paramQQAppInterface, wwg paramwwg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new ArraySet());
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandlerThread = ((HandlerThread)ThreadManagerV2.getRecentThread());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Xar = new wvt(this);
    this.jdField_a_of_type_Woy = new wvv(this);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListLoader ctor()");
    if (paramQQAppInterface == null) {
      yuk.c("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.jdField_a_of_type_Wwg = paramwwg;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Wwg.a();
    a(this.jdField_a_of_type_JavaUtilArrayList, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_AndroidOsHandler = new wvy(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "create new loader");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramQQAppInterface = (wvn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = 0;
      while (j < paramQQAppInterface.jdField_a_of_type_JavaUtilList.size())
      {
        paramwwg = (wwf)paramQQAppInterface.jdField_a_of_type_JavaUtilList.get(j);
        String str = paramQQAppInterface.jdField_a_of_type_JavaLangString + "-" + paramwwg.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(paramwwg.jdField_a_of_type_Boolean));
        j += 1;
      }
      i += 1;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.5(this));
  }
  
  private void a(ArrayList<wvn> paramArrayList) {}
  
  private static void a(ArrayList<wvn> paramArrayList, boolean paramBoolean)
  {
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() listSize=%d, sortOriginList=%b", Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean));
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      wvn localwvn = (wvn)((Iterator)localObject).next();
      if (localwvn.jdField_c_of_type_Int > 0)
      {
        localArrayList.add(localwvn);
        ((Iterator)localObject).remove();
      }
    }
    if (paramBoolean) {
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
    }
    int i;
    if (localArrayList.size() > 0)
    {
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, jdField_b_of_type_JavaUtilComparator);
      i = 0;
      if (i >= paramArrayList.size()) {
        break label297;
      }
      localObject = (wvn)paramArrayList.get(i);
      if ((((wvn)localObject).jdField_a_of_type_Int != 1) && (((wvn)localObject).jdField_a_of_type_Int != 4) && (((wvn)localObject).jdField_a_of_type_Int != 3)) {
        yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i));
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
          localObject = (wvn)localArrayList.get(j);
          if (((wvn)localObject).jdField_c_of_type_Int > 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            znw.a(paramBoolean, "position must be greater than 0");
            int k = Math.min(((wvn)localObject).jdField_c_of_type_Int + i - 1, paramArrayList.size());
            paramArrayList.add(k, localObject);
            yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(k));
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
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", zow.a(paramMsgTabNodePushNotify) });
    }
    wvn localwvn = new wvn();
    localwvn.a((qqstory_service.MsgTabNodeInfo)paramMsgTabNodePushNotify.msg_notify_node_info.get());
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
      if (localwvn.jdField_a_of_type_Int == 5)
      {
        paramMsgTabNodePushNotify = this.jdField_a_of_type_Wwg.a();
        if (paramMsgTabNodePushNotify.jdField_d_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localwvn);
          if (i == -1) {
            break label329;
          }
          localwvn.a((wvn)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if ((localwvn.jdField_a_of_type_Int != 7) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localwvn) != -1)) {
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
      paramMsgTabNodePushNotify = (wvn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((paramMsgTabNodePushNotify.jdField_a_of_type_Int == 9) && (TextUtils.equals(localwvn.jdField_a_of_type_JavaLangString, paramMsgTabNodePushNotify.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, localwvn);
        this.jdField_a_of_type_Wwg.b(paramMsgTabNodePushNotify);
        this.jdField_a_of_type_Wwg.a(localwvn);
        if (paramBoolean)
        {
          a(paramMsgTabNodePushNotify, true, 3, bool1);
          a(localwvn, true, 1, bool1);
        }
        yup.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localwvn.jdField_a_of_type_Int) });
        return true;
        bool1 = false;
        break;
        label329:
        localwvn.a(paramMsgTabNodePushNotify);
        break label168;
      }
      i += 1;
    }
    label345:
    c(localwvn);
    boolean bool2 = b(localwvn);
    c(Collections.singletonList(localwvn));
    b(Collections.singletonList(localwvn));
    if (bool2)
    {
      this.jdField_a_of_type_Wwg.a(localwvn);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaLangString = str;
      if (paramBoolean) {
        a(localwvn, true, 1, bool1);
      }
      yup.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localwvn.jdField_a_of_type_Int) });
    }
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localwvn);
    paramBoolean = bool2;
    for (;;)
    {
      return paramBoolean;
      label476:
      if (i == 2)
      {
        bool2 = c(localwvn);
        if (bool2)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_Wwg.b(localwvn);
          this.jdField_b_of_type_JavaLangString = str;
          if (paramBoolean) {
            a(localwvn, true, 3, bool1);
          }
        }
        yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localwvn);
        paramBoolean = bool2;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public static boolean a(List<wvn> paramList1, List<wvn> paramList2)
  {
    boolean bool2 = false;
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    if (i < paramList1.size())
    {
      localObject1 = ((wvn)paramList1.get(i)).jdField_a_of_type_JavaLangString;
      if (((wvn)paramList1.get(i)).jdField_a_of_type_Int == 12) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((wvn)paramList1.get(i)).jdField_a_of_type_JavaUtilList;
        j = 0;
        while (j < ((List)localObject2).size())
        {
          wwf localwwf = (wwf)((List)localObject2).get(j);
          if (!localwwf.jdField_a_of_type_Boolean) {
            localHashSet.add((String)localObject1 + "-" + localwwf.jdField_a_of_type_Long);
          }
          j += 1;
        }
      }
    }
    i = 0;
    boolean bool1 = bool2;
    if (i < paramList2.size())
    {
      paramList1 = ((wvn)paramList2.get(i)).jdField_a_of_type_JavaLangString;
      if (((wvn)paramList2.get(i)).jdField_a_of_type_Int != 12) {}
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = ((wvn)paramList2.get(i)).jdField_a_of_type_JavaUtilList;
      j = 0;
      while (j < ((List)localObject1).size())
      {
        localObject2 = (wwf)((List)localObject1).get(j);
        if ((!((wwf)localObject2).jdField_a_of_type_Boolean) && (!localHashSet.contains(paramList1 + "-" + ((wwf)localObject2).jdField_a_of_type_Long)))
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
      yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    wtt localwtt = (wtt)wth.a(2);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = localwtt.b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList.add(new wuo("", str));
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
        new xaq(this.jdField_a_of_type_Xar).a(1, localArrayList);
        yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() Will fetch %s users", localArrayList);
      }
    }
    for (;;)
    {
      return bool;
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() miss %s users, did not find in db, won't request", localArrayList);
      continue;
      yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() All nodes has local cache, no need request");
    }
  }
  
  @WorkerThread
  private void b(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    if (yuk.a()) {
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "onHandlePushMsg %s", zow.a(paramMsgTabNodePushNotify));
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
  
  private void b(List<wvn> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int k;
    wvn localwvn;
    for (int j = 0;; j = k)
    {
      if ((j < paramList.size()) && (i < 8))
      {
        k = j + 1;
        localwvn = (wvn)paramList.get(j);
        if (localwvn.jdField_b_of_type_Int == 0) {
          yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(j));
        }
      }
      else
      {
        label75:
        a(localArrayList2);
        if (!localArrayList1.isEmpty()) {
          break label287;
        }
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest is empty");
        return;
      }
      if ((localwvn.jdField_a_of_type_Int == 6) || (localwvn.jdField_a_of_type_Int == 9) || (localwvn.jdField_a_of_type_Int == 7) || (localwvn.jdField_a_of_type_Int == 5)) {
        break;
      }
    }
    Iterator localIterator = localwvn.jdField_a_of_type_JavaUtilList.iterator();
    label155:
    wwf localwwf;
    if (localIterator.hasNext())
    {
      localwwf = (wwf)localIterator.next();
      if (TextUtils.isEmpty(localwwf.jdField_a_of_type_JavaLangString))
      {
        localArrayList1.add(localwvn);
        i += 1;
        yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(k));
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(k));
        break label75;
        if (localwwf.jdField_a_of_type_Boolean) {
          break label155;
        }
        localArrayList2.add(localwwf.jdField_a_of_type_JavaLangString);
        i += 1;
        yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(k), localwwf.jdField_a_of_type_JavaLangString);
        j = 1;
        continue;
      }
      j = k;
      break;
      label287:
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest load vidlist size=%d", Integer.valueOf(localArrayList1.size()));
      Stream.fromIterator(localArrayList1.iterator()).map(new wvx(this)).map(new wwd("MsgTabPreloader")).subscribe(new wvw(this));
      return;
      j = 0;
    }
  }
  
  private boolean b(wvn paramwvn)
  {
    boolean bool;
    int i;
    int j;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread)
    {
      bool = true;
      znw.a(bool);
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwvn);
      if (i != -1)
      {
        wvn localwvn = (wvn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramwvn.jdField_c_of_type_Long < localwvn.jdField_c_of_type_Long) {
          break label127;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramwvn);
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label136;
      }
      if (jdField_a_of_type_JavaUtilComparator.compare(paramwvn, this.jdField_a_of_type_JavaUtilArrayList.get(i)) <= 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(i, paramwvn);
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
    this.jdField_a_of_type_JavaUtilArrayList.add(paramwvn);
    a(this.jdField_a_of_type_JavaUtilArrayList, false);
    return true;
  }
  
  @WorkerThread
  private void c()
  {
    yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    Object localObject = this.jdField_a_of_type_Wwg.a();
    if (((wvn)localObject).jdField_d_of_type_Int > 0)
    {
      wvn localwvn = a(((wvn)localObject).jdField_a_of_type_Int, ((wvn)localObject).jdField_a_of_type_JavaLangString);
      if (localwvn == null) {
        break label54;
      }
      localwvn.a((wvn)localObject);
      localObject = localwvn;
    }
    label54:
    for (;;)
    {
      a((wvn)localObject, false);
      return;
    }
  }
  
  private void c(List<wvn> paramList)
  {
    wtt localwtt = (wtt)wth.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (wvn)paramList.get(i);
      if ((((wvn)localObject).jdField_a_of_type_Int == 12) || (((wvn)localObject).jdField_a_of_type_Int == 10) || (((wvn)localObject).jdField_a_of_type_Int == 11) || (((wvn)localObject).jdField_a_of_type_Int == 13)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((wvn)localObject).jdField_a_of_type_JavaLangString;
        QQUserUIItem localQQUserUIItem = localwtt.b((String)localObject);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          localArrayList.add(new wuo("", (String)localObject));
        } else {
          a(localQQUserUIItem);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      new xaq(this.jdField_a_of_type_Xar).a(1, localArrayList);
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private void c(wvn paramwvn)
  {
    int i = paramwvn.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < paramwvn.jdField_a_of_type_JavaUtilList.size())
    {
      wwf localwwf = (wwf)paramwvn.jdField_a_of_type_JavaUtilList.get(j);
      Object localObject = paramwvn.jdField_a_of_type_JavaLangString + "-" + localwwf.jdField_a_of_type_Long;
      localObject = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localwwf.jdField_a_of_type_Boolean = true;
      }
      if (!localwwf.jdField_a_of_type_Boolean) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      j += 1;
      break;
      paramwvn.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  private boolean c(wvn paramwvn)
  {
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      znw.a(bool);
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwvn);
      if (i == -1) {
        break;
      }
      wvn localwvn = (wvn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramwvn.jdField_c_of_type_Long >= localwvn.jdField_c_of_type_Long) {
        break;
      }
      return false;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.remove(paramwvn);
  }
  
  public ArrayList<wvn> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public wvn a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    if (paramInt == -1)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      wvn localwvn;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localwvn = (wvn)localIterator.next();
      } while (!TextUtils.equals(localwvn.jdField_a_of_type_JavaLangString, paramString));
      return localwvn;
    }
    paramString = new wvn(paramInt, paramString);
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    if (paramInt != -1) {
      return (wvn)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public wvn a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      wvn localwvn = (wvn)localIterator.next();
      if (TextUtils.equals(paramString, localwvn.jdField_a_of_type_JavaLangString)) {
        return localwvn;
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
    wwr localwwr;
    do
    {
      return;
      localwwr = new wwr();
      localwwr.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localwwr.jdField_c_of_type_Int = paramInt;
      wta localwta = (wta)wth.a(10);
      boolean bool = ((Boolean)localwta.b("key_force_refresh_msg_node_list", Boolean.valueOf(false))).booleanValue();
      if (bool) {
        localwta.b("key_force_refresh_msg_node_list", Boolean.valueOf(false));
      }
      localwwr.jdField_a_of_type_Boolean = bool;
      wow.a().a(localwwr, this.jdField_a_of_type_Woy);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", localwwr.toString() });
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null)
    {
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal is null!", new Object[0]);
      return;
    }
    if ((TextUtils.isEmpty(paramQQUserUIItem.uid)) || (!paramQQUserUIItem.isAvailable()))
    {
      yuk.d("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQUserUIItem.uid, paramQQUserUIItem);
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    boolean bool = yow.a();
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 1) && (!bool))
    {
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is not in testEnv", zow.a(paramMsgTabNodePushNotify));
      return;
    }
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 0) && (bool))
    {
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is in testEnv", zow.a(paramMsgTabNodePushNotify));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.6(this, paramMsgTabNodePushNotify));
  }
  
  public void a(String paramString)
  {
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "scheduleRequireUserItem() %s", paramString);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, paramString).sendToTarget();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.12(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new wxi(paramString1, paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide request = " + paramString1.toString());
    }
    wow.a().a(paramString1, new wvu(this));
  }
  
  protected void a(ArrayList<wvn> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() dataList=%s, isFirstPage=%b, isEnd=%b, push=%b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3));
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.10(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
    }
    for (;;)
    {
      return;
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      wte localwte = (wte)wth.a(5);
      int i = 0;
      while (i < paramList.size())
      {
        localwte.b((String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public void a(wmd paramwmd)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramwmd.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramwmd) });
      }
      Object localObject3 = this.jdField_a_of_type_Wwg.a();
      localObject2 = a(((wvn)localObject3).jdField_a_of_type_Int, ((wvn)localObject3).jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new wvn(((wvn)localObject3).jdField_a_of_type_Int, ((wvn)localObject3).jdField_a_of_type_JavaLangString);
        ((wvn)localObject1).jdField_b_of_type_Long = QQStoryContext.a().a();
        a((wvn)localObject1, false);
      }
      int j = ((wvn)localObject1).a();
      int k = ((wvn)localObject3).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(j), "\tnewUploadStatus: ", Integer.valueOf(k) });
      }
      ((wvn)localObject1).a((wvn)localObject3);
      if (paramwmd.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
        break label544;
      }
      paramwmd = paramwmd.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      if (!paramwmd.isUploadSuc()) {
        break label584;
      }
      localObject2 = new wwf();
      ((wwf)localObject2).jdField_a_of_type_Boolean = false;
      ((wwf)localObject2).jdField_a_of_type_Long = paramwmd.mVideoIndex;
      if (((wwf)localObject2).jdField_a_of_type_Long == 0L) {
        ((wwf)localObject2).jdField_a_of_type_Long = paramwmd.mCreateTime;
      }
      if (((wvn)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localObject2) == -1) {
        break label552;
      }
      i = 1;
      label339:
      if (i != 0) {
        break label557;
      }
      ((wvn)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
      ((wvn)localObject1).jdField_b_of_type_Int += 1;
      ((wvn)localObject1).g = paramwmd.getThumbUrl();
      ((wvn)localObject1).jdField_d_of_type_Long = (paramwmd.mCreateTime / 1000L);
      if (((wvn)localObject1).jdField_b_of_type_JavaUtilList == null) {
        ((wvn)localObject1).jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      localObject3 = new xiw();
      ((xiw)localObject3).jdField_a_of_type_JavaLangString = paramwmd.mAttachedFeedId;
      ((xiw)localObject3).jdField_b_of_type_JavaLangString = paramwmd.mVid;
      ((xiw)localObject3).jdField_a_of_type_Long = paramwmd.mVideoIndex;
      ((xiw)localObject3).jdField_a_of_type_Boolean = false;
      ((xiw)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramwmd;
      ((wvn)localObject1).jdField_b_of_type_JavaUtilList.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((wvn)localObject1).jdField_a_of_type_JavaUtilList });
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
        a((wvn)localObject1, true);
      }
      return;
      label544:
      paramwmd = paramwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
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
  
  public void a(wsm paramwsm)
  {
    if (!paramwsm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "delete video event, event=", paramwsm });
    }
    if (paramwsm.jdField_a_of_type_Boolean)
    {
      paramwsm = this.jdField_a_of_type_Wwg.a();
      localObject = a(paramwsm.jdField_a_of_type_Int, paramwsm.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        ((wvn)localObject).a(paramwsm);
        paramwsm = (wsm)localObject;
      }
      for (;;)
      {
        a(paramwsm, true);
        return;
      }
    }
    int i;
    if (!TextUtils.isEmpty(paramwsm.c))
    {
      i = 8;
      if (TextUtils.isEmpty(paramwsm.c)) {
        break label145;
      }
    }
    label145:
    for (Object localObject = paramwsm.c;; localObject = paramwsm.jdField_b_of_type_JavaLangString)
    {
      a(i, (String)localObject, paramwsm.jdField_a_of_type_Long);
      a(i, paramwsm.jdField_b_of_type_JavaLangString, paramwsm.c);
      return;
      i = 5;
      break;
    }
  }
  
  public void a(wvn paramwvn)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      wvn localwvn = (wvn)localIterator.next();
      if ((localwvn.jdField_a_of_type_Int == 13) && (TextUtils.equals(localwvn.jdField_a_of_type_JavaLangString, paramwvn.jdField_a_of_type_JavaLangString))) {
        paramwvn.jdField_d_of_type_Boolean = localwvn.jdField_d_of_type_Boolean;
      }
    }
  }
  
  public void a(wvn paramwvn, boolean paramBoolean)
  {
    int i = 1;
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramwvn), Boolean.valueOf(paramBoolean));
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwvn);
    boolean bool;
    if (b(paramwvn))
    {
      this.jdField_a_of_type_Wwg.a(paramwvn);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwvn);
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
      a(paramwvn, false, i, false);
      return;
      label156:
      bool = false;
      break;
      label162:
      i = 2;
    }
  }
  
  protected void a(wvn paramwvn, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(paramwvn), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i;
    if (paramInt == 1)
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramwvn);
      i = j;
      if (j == -1) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 1, "insert position not found:" + paramwvn);
      }
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.11(this, paramwvn, paramBoolean1, paramInt, i, paramBoolean2));
  }
  
  public void a(wvz paramwvz)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (this.jdField_d_of_type_JavaUtilArrayList.contains(paramwvz))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramwvz.getClass().getSimpleName() });
      }
      this.jdField_d_of_type_JavaUtilArrayList.add(paramwvz);
      return;
    }
  }
  
  @WorkerThread
  public void a(@NonNull wwr paramwwr, @Nullable wws paramwws, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool;
    if (((paramErrorMessage.errorCode != 0) && (paramErrorMessage.errorCode != 15000) && (paramErrorMessage.errorCode != 15001)) || (paramwws == null))
    {
      yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() get latest failed: %s", paramErrorMessage.getErrorMessage());
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
    this.h = paramwws.jdField_a_of_type_Boolean;
    if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramwws.jdField_a_of_type_JavaLangString))
    {
      yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      if (paramErrorMessage.errorCode == 15001)
      {
        paramErrorMessage = null;
        paramwwr = paramErrorMessage;
        if (paramwws.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          paramwwr = paramErrorMessage;
          if (i < paramwws.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramwwr = (wvn)paramwws.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (paramwwr.jdField_a_of_type_Int != 12) {
              break label372;
            }
          }
        }
        if (paramwwr != null)
        {
          yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i = 0;
          label232:
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label680;
          }
          if (((wvn)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != 12) {
            break label381;
          }
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramwwr);
        }
      }
    }
    label680:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwwr);
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
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramwws.jdField_a_of_type_JavaUtilArrayList.size()));
      i = 0;
      while (i < paramwws.jdField_a_of_type_JavaUtilArrayList.size())
      {
        c((wvn)paramwws.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      if (paramwwr.jdField_c_of_type_Int == 1) {}
      for (bool = a(this.jdField_a_of_type_JavaUtilArrayList, paramwws.jdField_a_of_type_JavaUtilArrayList);; bool = false)
      {
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
        this.jdField_b_of_type_JavaLangString = paramwws.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_JavaLangString = paramwws.c;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramwws.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList, true);
        this.jdField_a_of_type_Boolean = paramwws.jdField_b_of_type_Boolean;
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
        a();
        c();
        a(false, false);
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
        this.jdField_a_of_type_Wwg.a(this.jdField_a_of_type_JavaUtilArrayList, true);
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
        c(this.jdField_a_of_type_JavaUtilArrayList);
        b(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        b(bool);
        yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
        return;
      }
    }
  }
  
  @WorkerThread
  public void a(xas paramxas)
  {
    if ((paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxas.jdField_a_of_type_JavaUtilList != null) && (!paramxas.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent isSuccess userUIItems: " + paramxas.jdField_a_of_type_JavaUtilList);
      }
      int j = paramxas.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      if (i >= j) {
        break label183;
      }
      if (a(((QQUserUIItem)paramxas.jdField_a_of_type_JavaUtilList.get(i)).uid) == null) {}
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
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent errorInfo: " + paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramxas.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  protected boolean a()
  {
    yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      znw.a(bool);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label126;
      }
      yuk.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (bool = false; localIterator.hasNext(); bool = a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false) | bool) {}
    }
    if (bool) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    for (;;)
    {
      yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
      return bool;
      label126:
      bool = false;
    }
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    label52:
    wwf localwwf;
    if (i >= 0)
    {
      localwwf = (wwf)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if (localwwf.jdField_a_of_type_Long == paramLong)
      {
        paramString.jdField_a_of_type_JavaUtilList.remove(i);
        bool1 = true;
      }
    }
    for (;;)
    {
      i -= 1;
      break label52;
      if (!localwwf.jdField_a_of_type_Boolean)
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
          this.jdField_a_of_type_Wwg.b(paramString);
          a(paramString, false, 3, false);
          return bool1;
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_Wwg.a(paramString);
        a(paramString, false, 2, false);
        return bool1;
      }
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidListFromWorkThread(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return wwg.a(new wvn(paramInt, paramString1));
      paramString1 = paramString2;
    }
  }
  
  @WorkerThread
  public boolean a(String paramString, long paramLong)
  {
    yuk.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (wwf)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if ((((wwf)localObject).jdField_a_of_type_Long == paramLong) && (!((wwf)localObject).jdField_a_of_type_Boolean))
      {
        ((wwf)localObject).jdField_a_of_type_Boolean = true;
        paramString.jdField_b_of_type_Int -= 1;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramString.jdField_b_of_type_Int <= 0) && (!paramString.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = new wwv();
        ((wwv)localObject).jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        ((wwv)localObject).jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
        ((wwv)localObject).jdField_d_of_type_Int = 5;
        ((wwv)localObject).jdField_b_of_type_Long = paramString.e;
        wow.a().a((wpa)localObject, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.jdField_a_of_type_JavaUtilList });
      }
      if (bool)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
        if (i >= 0)
        {
          localObject = (wvn)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((wvn)localObject).copy(paramString);
          this.jdField_a_of_type_Wwg.a((wvn)localObject);
        }
        a(paramString, false, 2, false);
      }
      return bool;
      i -= 1;
      break;
    }
  }
  
  public boolean a(wvn paramwvn)
  {
    boolean bool = c(paramwvn);
    if (bool)
    {
      this.jdField_a_of_type_Wwg.b(paramwvn);
      a(paramwvn, false, 3, false);
    }
    return bool;
  }
  
  protected boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QQStoryContext.a() != null) {}
    return false;
  }
  
  @UiThread
  public ArrayList<wvn> b()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      znw.a(bool);
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
  }
  
  @GuardedBy("mNotifyLock")
  public void b()
  {
    if (zpk.a(52) > 0) {}
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
          ((wja)QQStoryContext.a().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void b(wmd paramwmd)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.15(this, paramwmd));
  }
  
  public void b(wsm paramwsm)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.16(this, paramwsm));
  }
  
  public void b(wvn paramwvn)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.7(this, paramwvn));
  }
  
  public void b(wvz paramwvz)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(paramwvz);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramwvz.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(xas paramxas)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.14(this, paramxas));
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
            wvn localwvn = (wvn)((Iterator)???).next();
            if ((localwvn.jdField_b_of_type_Int > 0) && (localwvn.jdField_a_of_type_Int == 6)) {
              this.e = true;
            }
          }
          ((wja)QQStoryContext.a().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
        }
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvs
 * JD-Core Version:    0.7.0.1
 */