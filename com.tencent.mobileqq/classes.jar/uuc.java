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

public class uuc
{
  protected static Comparator<utx> a;
  protected static Comparator<utx> b;
  protected Handler a;
  protected HandlerThread a;
  protected final Object a;
  protected String a;
  protected volatile ArrayList<utx> a;
  protected HashMap<String, Boolean> a;
  protected Set<String> a;
  protected ConcurrentHashMap<String, QQUserUIItem> a;
  protected AtomicBoolean a;
  protected uni<uvb, uvc> a;
  protected uuq a;
  private uzb a;
  protected boolean a;
  protected Handler b;
  protected String b;
  protected volatile ArrayList<utx> b;
  boolean b;
  protected ArrayList<qqstory_service.MsgTabNodePushNotify> c;
  boolean c;
  public final ArrayList<uuj> d;
  boolean d;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new uty();
    jdField_b_of_type_JavaUtilComparator = new utz();
  }
  
  uuc(QQAppInterface paramQQAppInterface, uuq paramuuq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new ArraySet());
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandlerThread = ((HandlerThread)ThreadManagerV2.getRecentThread());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Uzb = new uud(this);
    this.jdField_a_of_type_Uni = new uuf(this);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListLoader ctor()");
    if (paramQQAppInterface == null) {
      wsv.c("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.jdField_a_of_type_Uuq = paramuuq;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Uuq.a();
    a(this.jdField_a_of_type_JavaUtilArrayList, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_AndroidOsHandler = new uui(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "create new loader");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramQQAppInterface = (utx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = 0;
      while (j < paramQQAppInterface.jdField_a_of_type_JavaUtilList.size())
      {
        paramuuq = (uup)paramQQAppInterface.jdField_a_of_type_JavaUtilList.get(j);
        String str = paramQQAppInterface.jdField_a_of_type_JavaLangString + "-" + paramuuq.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(paramuuq.jdField_a_of_type_Boolean));
        j += 1;
      }
      i += 1;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.5(this));
  }
  
  private void a(ArrayList<utx> paramArrayList) {}
  
  private static void a(ArrayList<utx> paramArrayList, boolean paramBoolean)
  {
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() listSize=%d, sortOriginList=%b", Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean));
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      utx localutx = (utx)((Iterator)localObject).next();
      if (localutx.jdField_c_of_type_Int > 0)
      {
        localArrayList.add(localutx);
        ((Iterator)localObject).remove();
      }
    }
    if (paramBoolean) {
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
    }
    int i;
    if (localArrayList.size() > 0)
    {
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, jdField_b_of_type_JavaUtilComparator);
      i = 0;
      if (i >= paramArrayList.size()) {
        break label297;
      }
      localObject = (utx)paramArrayList.get(i);
      if ((((utx)localObject).jdField_a_of_type_Int != 1) && (((utx)localObject).jdField_a_of_type_Int != 4) && (((utx)localObject).jdField_a_of_type_Int != 3)) {
        wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i));
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
          localObject = (utx)localArrayList.get(j);
          if (((utx)localObject).jdField_c_of_type_Int > 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            xmh.a(paramBoolean, "position must be greater than 0");
            int k = Math.min(((utx)localObject).jdField_c_of_type_Int + i - 1, paramArrayList.size());
            paramArrayList.add(k, localObject);
            wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(k));
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
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", xnh.a(paramMsgTabNodePushNotify) });
    }
    utx localutx = new utx();
    localutx.a((qqstory_service.MsgTabNodeInfo)paramMsgTabNodePushNotify.msg_notify_node_info.get());
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
      if (localutx.jdField_a_of_type_Int == 5)
      {
        paramMsgTabNodePushNotify = this.jdField_a_of_type_Uuq.a();
        if (paramMsgTabNodePushNotify.jdField_d_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localutx);
          if (i == -1) {
            break label329;
          }
          localutx.a((utx)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if ((localutx.jdField_a_of_type_Int != 7) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localutx) != -1)) {
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
      paramMsgTabNodePushNotify = (utx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((paramMsgTabNodePushNotify.jdField_a_of_type_Int == 9) && (TextUtils.equals(localutx.jdField_a_of_type_JavaLangString, paramMsgTabNodePushNotify.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.set(i, localutx);
        this.jdField_a_of_type_Uuq.b(paramMsgTabNodePushNotify);
        this.jdField_a_of_type_Uuq.a(localutx);
        if (paramBoolean)
        {
          a(paramMsgTabNodePushNotify, true, 3, bool1);
          a(localutx, true, 1, bool1);
        }
        wta.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localutx.jdField_a_of_type_Int) });
        return true;
        bool1 = false;
        break;
        label329:
        localutx.a(paramMsgTabNodePushNotify);
        break label168;
      }
      i += 1;
    }
    label345:
    c(localutx);
    boolean bool2 = b(localutx);
    c(Collections.singletonList(localutx));
    b(Collections.singletonList(localutx));
    if (bool2)
    {
      this.jdField_a_of_type_Uuq.a(localutx);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaLangString = str;
      if (paramBoolean) {
        a(localutx, true, 1, bool1);
      }
      wta.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localutx.jdField_a_of_type_Int) });
    }
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localutx);
    paramBoolean = bool2;
    for (;;)
    {
      return paramBoolean;
      label476:
      if (i == 2)
      {
        bool2 = c(localutx);
        if (bool2)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_Uuq.b(localutx);
          this.jdField_b_of_type_JavaLangString = str;
          if (paramBoolean) {
            a(localutx, true, 3, bool1);
          }
        }
        wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localutx);
        paramBoolean = bool2;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public static boolean a(List<utx> paramList1, List<utx> paramList2)
  {
    boolean bool2 = false;
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    if (i < paramList1.size())
    {
      localObject1 = ((utx)paramList1.get(i)).jdField_a_of_type_JavaLangString;
      if (((utx)paramList1.get(i)).jdField_a_of_type_Int == 12) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((utx)paramList1.get(i)).jdField_a_of_type_JavaUtilList;
        j = 0;
        while (j < ((List)localObject2).size())
        {
          uup localuup = (uup)((List)localObject2).get(j);
          if (!localuup.jdField_a_of_type_Boolean) {
            localHashSet.add((String)localObject1 + "-" + localuup.jdField_a_of_type_Long);
          }
          j += 1;
        }
      }
    }
    i = 0;
    boolean bool1 = bool2;
    if (i < paramList2.size())
    {
      paramList1 = ((utx)paramList2.get(i)).jdField_a_of_type_JavaLangString;
      if (((utx)paramList2.get(i)).jdField_a_of_type_Int != 12) {}
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = ((utx)paramList2.get(i)).jdField_a_of_type_JavaUtilList;
      j = 0;
      while (j < ((List)localObject1).size())
      {
        localObject2 = (uup)((List)localObject1).get(j);
        if ((!((uup)localObject2).jdField_a_of_type_Boolean) && (!localHashSet.contains(paramList1 + "-" + ((uup)localObject2).jdField_a_of_type_Long)))
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
      wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    usd localusd = (usd)urr.a(2);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = localusd.b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList.add(new usy("", str));
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
        new uza(this.jdField_a_of_type_Uzb).a(1, localArrayList);
        wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() Will fetch %s users", localArrayList);
      }
    }
    for (;;)
    {
      return bool;
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() miss %s users, did not find in db, won't request", localArrayList);
      continue;
      wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() All nodes has local cache, no need request");
    }
  }
  
  @WorkerThread
  private void b(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    if (wsv.a()) {
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "onHandlePushMsg %s", xnh.a(paramMsgTabNodePushNotify));
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
  
  private void b(List<utx> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int k;
    utx localutx;
    for (int j = 0;; j = k)
    {
      if ((j < paramList.size()) && (i < 8))
      {
        k = j + 1;
        localutx = (utx)paramList.get(j);
        if (localutx.jdField_b_of_type_Int == 0) {
          wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(j));
        }
      }
      else
      {
        label75:
        a(localArrayList2);
        if (!localArrayList1.isEmpty()) {
          break label287;
        }
        wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest is empty");
        return;
      }
      if ((localutx.jdField_a_of_type_Int == 6) || (localutx.jdField_a_of_type_Int == 9) || (localutx.jdField_a_of_type_Int == 7) || (localutx.jdField_a_of_type_Int == 5)) {
        break;
      }
    }
    Iterator localIterator = localutx.jdField_a_of_type_JavaUtilList.iterator();
    label155:
    uup localuup;
    if (localIterator.hasNext())
    {
      localuup = (uup)localIterator.next();
      if (TextUtils.isEmpty(localuup.jdField_a_of_type_JavaLangString))
      {
        localArrayList1.add(localutx);
        i += 1;
        wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(k));
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(k));
        break label75;
        if (localuup.jdField_a_of_type_Boolean) {
          break label155;
        }
        localArrayList2.add(localuup.jdField_a_of_type_JavaLangString);
        i += 1;
        wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(k), localuup.jdField_a_of_type_JavaLangString);
        j = 1;
        continue;
      }
      j = k;
      break;
      label287:
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest load vidlist size=%d", Integer.valueOf(localArrayList1.size()));
      Stream.fromIterator(localArrayList1.iterator()).map(new uuh(this)).map(new uun("MsgTabPreloader")).subscribe(new uug(this));
      return;
      j = 0;
    }
  }
  
  private boolean b(utx paramutx)
  {
    boolean bool;
    int i;
    int j;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread)
    {
      bool = true;
      xmh.a(bool);
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramutx);
      if (i != -1)
      {
        utx localutx = (utx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramutx.jdField_c_of_type_Long < localutx.jdField_c_of_type_Long) {
          break label127;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramutx);
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label136;
      }
      if (jdField_a_of_type_JavaUtilComparator.compare(paramutx, this.jdField_a_of_type_JavaUtilArrayList.get(i)) <= 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(i, paramutx);
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
    this.jdField_a_of_type_JavaUtilArrayList.add(paramutx);
    a(this.jdField_a_of_type_JavaUtilArrayList, false);
    return true;
  }
  
  @WorkerThread
  private void c()
  {
    wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    Object localObject = this.jdField_a_of_type_Uuq.a();
    if (((utx)localObject).jdField_d_of_type_Int > 0)
    {
      utx localutx = a(((utx)localObject).jdField_a_of_type_Int, ((utx)localObject).jdField_a_of_type_JavaLangString);
      if (localutx == null) {
        break label54;
      }
      localutx.a((utx)localObject);
      localObject = localutx;
    }
    label54:
    for (;;)
    {
      a((utx)localObject, false);
      return;
    }
  }
  
  private void c(List<utx> paramList)
  {
    usd localusd = (usd)urr.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (utx)paramList.get(i);
      if ((((utx)localObject).jdField_a_of_type_Int == 12) || (((utx)localObject).jdField_a_of_type_Int == 10) || (((utx)localObject).jdField_a_of_type_Int == 11) || (((utx)localObject).jdField_a_of_type_Int == 13)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((utx)localObject).jdField_a_of_type_JavaLangString;
        QQUserUIItem localQQUserUIItem = localusd.b((String)localObject);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          localArrayList.add(new usy("", (String)localObject));
        } else {
          a(localQQUserUIItem);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      new uza(this.jdField_a_of_type_Uzb).a(1, localArrayList);
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private void c(utx paramutx)
  {
    int i = paramutx.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < paramutx.jdField_a_of_type_JavaUtilList.size())
    {
      uup localuup = (uup)paramutx.jdField_a_of_type_JavaUtilList.get(j);
      Object localObject = paramutx.jdField_a_of_type_JavaLangString + "-" + localuup.jdField_a_of_type_Long;
      localObject = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localuup.jdField_a_of_type_Boolean = true;
      }
      if (!localuup.jdField_a_of_type_Boolean) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      j += 1;
      break;
      paramutx.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  private boolean c(utx paramutx)
  {
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      xmh.a(bool);
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramutx);
      if (i == -1) {
        break;
      }
      utx localutx = (utx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramutx.jdField_c_of_type_Long >= localutx.jdField_c_of_type_Long) {
        break;
      }
      return false;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.remove(paramutx);
  }
  
  public ArrayList<utx> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public utx a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    if (paramInt == -1)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      utx localutx;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localutx = (utx)localIterator.next();
      } while (!TextUtils.equals(localutx.jdField_a_of_type_JavaLangString, paramString));
      return localutx;
    }
    paramString = new utx(paramInt, paramString);
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    if (paramInt != -1) {
      return (utx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public utx a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      utx localutx = (utx)localIterator.next();
      if (TextUtils.equals(paramString, localutx.jdField_a_of_type_JavaLangString)) {
        return localutx;
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
    uvb localuvb;
    do
    {
      return;
      localuvb = new uvb();
      localuvb.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localuvb.jdField_c_of_type_Int = paramInt;
      urk localurk = (urk)urr.a(10);
      boolean bool = ((Boolean)localurk.b("key_force_refresh_msg_node_list", Boolean.valueOf(false))).booleanValue();
      if (bool) {
        localurk.b("key_force_refresh_msg_node_list", Boolean.valueOf(false));
      }
      localuvb.jdField_a_of_type_Boolean = bool;
      ung.a().a(localuvb, this.jdField_a_of_type_Uni);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", localuvb.toString() });
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null)
    {
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal is null!", new Object[0]);
      return;
    }
    if ((TextUtils.isEmpty(paramQQUserUIItem.uid)) || (!paramQQUserUIItem.isAvailable()))
    {
      wsv.d("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQUserUIItem.uid, paramQQUserUIItem);
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    boolean bool = wnh.a();
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 1) && (!bool))
    {
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is not in testEnv", xnh.a(paramMsgTabNodePushNotify));
      return;
    }
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 0) && (bool))
    {
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is in testEnv", xnh.a(paramMsgTabNodePushNotify));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.6(this, paramMsgTabNodePushNotify));
  }
  
  public void a(String paramString)
  {
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "scheduleRequireUserItem() %s", paramString);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, paramString).sendToTarget();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.12(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new uvs(paramString1, paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide request = " + paramString1.toString());
    }
    ung.a().a(paramString1, new uue(this));
  }
  
  protected void a(ArrayList<utx> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() dataList=%s, isFirstPage=%b, isEnd=%b, push=%b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3));
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.10(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
    }
    for (;;)
    {
      return;
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      uro localuro = (uro)urr.a(5);
      int i = 0;
      while (i < paramList.size())
      {
        localuro.b((String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public void a(ukn paramukn)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramukn.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramukn) });
      }
      Object localObject3 = this.jdField_a_of_type_Uuq.a();
      localObject2 = a(((utx)localObject3).jdField_a_of_type_Int, ((utx)localObject3).jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new utx(((utx)localObject3).jdField_a_of_type_Int, ((utx)localObject3).jdField_a_of_type_JavaLangString);
        ((utx)localObject1).jdField_b_of_type_Long = QQStoryContext.a().a();
        a((utx)localObject1, false);
      }
      int j = ((utx)localObject1).a();
      int k = ((utx)localObject3).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(j), "\tnewUploadStatus: ", Integer.valueOf(k) });
      }
      ((utx)localObject1).a((utx)localObject3);
      if (paramukn.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
        break label544;
      }
      paramukn = paramukn.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      if (!paramukn.isUploadSuc()) {
        break label584;
      }
      localObject2 = new uup();
      ((uup)localObject2).jdField_a_of_type_Boolean = false;
      ((uup)localObject2).jdField_a_of_type_Long = paramukn.mVideoIndex;
      if (((uup)localObject2).jdField_a_of_type_Long == 0L) {
        ((uup)localObject2).jdField_a_of_type_Long = paramukn.mCreateTime;
      }
      if (((utx)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localObject2) == -1) {
        break label552;
      }
      i = 1;
      label339:
      if (i != 0) {
        break label557;
      }
      ((utx)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
      ((utx)localObject1).jdField_b_of_type_Int += 1;
      ((utx)localObject1).g = paramukn.getThumbUrl();
      ((utx)localObject1).jdField_d_of_type_Long = (paramukn.mCreateTime / 1000L);
      if (((utx)localObject1).jdField_b_of_type_JavaUtilList == null) {
        ((utx)localObject1).jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      localObject3 = new vhg();
      ((vhg)localObject3).jdField_a_of_type_JavaLangString = paramukn.mAttachedFeedId;
      ((vhg)localObject3).jdField_b_of_type_JavaLangString = paramukn.mVid;
      ((vhg)localObject3).jdField_a_of_type_Long = paramukn.mVideoIndex;
      ((vhg)localObject3).jdField_a_of_type_Boolean = false;
      ((vhg)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramukn;
      ((utx)localObject1).jdField_b_of_type_JavaUtilList.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((utx)localObject1).jdField_a_of_type_JavaUtilList });
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
        a((utx)localObject1, true);
      }
      return;
      label544:
      paramukn = paramukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
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
  
  public void a(uqw paramuqw)
  {
    if (!paramuqw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "delete video event, event=", paramuqw });
    }
    if (paramuqw.jdField_a_of_type_Boolean)
    {
      paramuqw = this.jdField_a_of_type_Uuq.a();
      localObject = a(paramuqw.jdField_a_of_type_Int, paramuqw.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        ((utx)localObject).a(paramuqw);
        paramuqw = (uqw)localObject;
      }
      for (;;)
      {
        a(paramuqw, true);
        return;
      }
    }
    int i;
    if (!TextUtils.isEmpty(paramuqw.c))
    {
      i = 8;
      if (TextUtils.isEmpty(paramuqw.c)) {
        break label145;
      }
    }
    label145:
    for (Object localObject = paramuqw.c;; localObject = paramuqw.jdField_b_of_type_JavaLangString)
    {
      a(i, (String)localObject, paramuqw.jdField_a_of_type_Long);
      a(i, paramuqw.jdField_b_of_type_JavaLangString, paramuqw.c);
      return;
      i = 5;
      break;
    }
  }
  
  public void a(utx paramutx)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      utx localutx = (utx)localIterator.next();
      if ((localutx.jdField_a_of_type_Int == 13) && (TextUtils.equals(localutx.jdField_a_of_type_JavaLangString, paramutx.jdField_a_of_type_JavaLangString))) {
        paramutx.jdField_d_of_type_Boolean = localutx.jdField_d_of_type_Boolean;
      }
    }
  }
  
  public void a(utx paramutx, boolean paramBoolean)
  {
    int i = 1;
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramutx), Boolean.valueOf(paramBoolean));
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramutx);
    boolean bool;
    if (b(paramutx))
    {
      this.jdField_a_of_type_Uuq.a(paramutx);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramutx);
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
      a(paramutx, false, i, false);
      return;
      label156:
      bool = false;
      break;
      label162:
      i = 2;
    }
  }
  
  protected void a(utx paramutx, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(paramutx), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i;
    if (paramInt == 1)
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramutx);
      i = j;
      if (j == -1) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 1, "insert position not found:" + paramutx);
      }
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.11(this, paramutx, paramBoolean1, paramInt, i, paramBoolean2));
  }
  
  public void a(uuj paramuuj)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (this.jdField_d_of_type_JavaUtilArrayList.contains(paramuuj))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramuuj.getClass().getSimpleName() });
      }
      this.jdField_d_of_type_JavaUtilArrayList.add(paramuuj);
      return;
    }
  }
  
  @WorkerThread
  public void a(@NonNull uvb paramuvb, @Nullable uvc paramuvc, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool;
    if (((paramErrorMessage.errorCode != 0) && (paramErrorMessage.errorCode != 15000) && (paramErrorMessage.errorCode != 15001)) || (paramuvc == null))
    {
      wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() get latest failed: %s", paramErrorMessage.getErrorMessage());
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
    this.h = paramuvc.jdField_a_of_type_Boolean;
    if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramuvc.jdField_a_of_type_JavaLangString))
    {
      wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      if (paramErrorMessage.errorCode == 15001)
      {
        paramErrorMessage = null;
        paramuvb = paramErrorMessage;
        if (paramuvc.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          paramuvb = paramErrorMessage;
          if (i < paramuvc.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramuvb = (utx)paramuvc.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (paramuvb.jdField_a_of_type_Int != 12) {
              break label372;
            }
          }
        }
        if (paramuvb != null)
        {
          wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i = 0;
          label232:
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label680;
          }
          if (((utx)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != 12) {
            break label381;
          }
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramuvb);
        }
      }
    }
    label680:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramuvb);
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
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramuvc.jdField_a_of_type_JavaUtilArrayList.size()));
      i = 0;
      while (i < paramuvc.jdField_a_of_type_JavaUtilArrayList.size())
      {
        c((utx)paramuvc.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      if (paramuvb.jdField_c_of_type_Int == 1) {}
      for (bool = a(this.jdField_a_of_type_JavaUtilArrayList, paramuvc.jdField_a_of_type_JavaUtilArrayList);; bool = false)
      {
        wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
        wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
        this.jdField_b_of_type_JavaLangString = paramuvc.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_JavaLangString = paramuvc.c;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramuvc.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_a_of_type_JavaUtilArrayList, true);
        this.jdField_a_of_type_Boolean = paramuvc.jdField_b_of_type_Boolean;
        wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
        a();
        c();
        a(false, false);
        wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
        this.jdField_a_of_type_Uuq.a(this.jdField_a_of_type_JavaUtilArrayList, true);
        wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
        c(this.jdField_a_of_type_JavaUtilArrayList);
        b(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        b(bool);
        wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
        return;
      }
    }
  }
  
  @WorkerThread
  public void a(uzc paramuzc)
  {
    if ((paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuzc.jdField_a_of_type_JavaUtilList != null) && (!paramuzc.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent isSuccess userUIItems: " + paramuzc.jdField_a_of_type_JavaUtilList);
      }
      int j = paramuzc.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      if (i >= j) {
        break label183;
      }
      if (a(((QQUserUIItem)paramuzc.jdField_a_of_type_JavaUtilList.get(i)).uid) == null) {}
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
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent errorInfo: " + paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramuzc.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  protected boolean a()
  {
    wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      xmh.a(bool);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label126;
      }
      wsv.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (bool = false; localIterator.hasNext(); bool = a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false) | bool) {}
    }
    if (bool) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    for (;;)
    {
      wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
      return bool;
      label126:
      bool = false;
    }
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    label52:
    uup localuup;
    if (i >= 0)
    {
      localuup = (uup)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if (localuup.jdField_a_of_type_Long == paramLong)
      {
        paramString.jdField_a_of_type_JavaUtilList.remove(i);
        bool1 = true;
      }
    }
    for (;;)
    {
      i -= 1;
      break label52;
      if (!localuup.jdField_a_of_type_Boolean)
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
          this.jdField_a_of_type_Uuq.b(paramString);
          a(paramString, false, 3, false);
          return bool1;
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_Uuq.a(paramString);
        a(paramString, false, 2, false);
        return bool1;
      }
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidListFromWorkThread(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return uuq.a(new utx(paramInt, paramString1));
      paramString1 = paramString2;
    }
  }
  
  @WorkerThread
  public boolean a(String paramString, long paramLong)
  {
    wsv.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (uup)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if ((((uup)localObject).jdField_a_of_type_Long == paramLong) && (!((uup)localObject).jdField_a_of_type_Boolean))
      {
        ((uup)localObject).jdField_a_of_type_Boolean = true;
        paramString.jdField_b_of_type_Int -= 1;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramString.jdField_b_of_type_Int <= 0) && (!paramString.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = new uvf();
        ((uvf)localObject).jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        ((uvf)localObject).jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
        ((uvf)localObject).jdField_d_of_type_Int = 5;
        ((uvf)localObject).jdField_b_of_type_Long = paramString.e;
        ung.a().a((unk)localObject, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.jdField_a_of_type_JavaUtilList });
      }
      if (bool)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
        if (i >= 0)
        {
          localObject = (utx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((utx)localObject).copy(paramString);
          this.jdField_a_of_type_Uuq.a((utx)localObject);
        }
        a(paramString, false, 2, false);
      }
      return bool;
      i -= 1;
      break;
    }
  }
  
  public boolean a(utx paramutx)
  {
    boolean bool = c(paramutx);
    if (bool)
    {
      this.jdField_a_of_type_Uuq.b(paramutx);
      a(paramutx, false, 3, false);
    }
    return bool;
  }
  
  protected boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QQStoryContext.a() != null) {}
    return false;
  }
  
  @UiThread
  public ArrayList<utx> b()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      xmh.a(bool);
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
  }
  
  @GuardedBy("mNotifyLock")
  public void b()
  {
    if (xnv.a(52) > 0) {}
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
          ((uhk)QQStoryContext.a().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void b(ukn paramukn)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.15(this, paramukn));
  }
  
  public void b(uqw paramuqw)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.16(this, paramuqw));
  }
  
  public void b(utx paramutx)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.7(this, paramutx));
  }
  
  public void b(uuj paramuuj)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(paramuuj);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramuuj.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(uzc paramuzc)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.14(this, paramuzc));
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
            utx localutx = (utx)((Iterator)???).next();
            if ((localutx.jdField_b_of_type_Int > 0) && (localutx.jdField_a_of_type_Int == 6)) {
              this.e = true;
            }
          }
          ((uhk)QQStoryContext.a().getBusinessHandler(98)).notifyUI(1026, true, Boolean.valueOf(false));
        }
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */