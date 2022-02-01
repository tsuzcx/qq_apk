import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import mqq.manager.Manager;

public class tog
  extends Observable
  implements Manager
{
  private final String TAG = "Q.unread.Facade";
  private final QQAppInterface app;
  private Set<String> bd;
  private Set<String> be;
  private Object object = new Object();
  
  public tog(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static int a(ConfessConvInfo paramConfessConvInfo)
  {
    if (paramConfessConvInfo == null) {
      return 0;
    }
    return paramConfessConvInfo.unreadCount;
  }
  
  public static int a(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return Math.max(paramConversationInfo.unreadCount, paramConversationInfo.unreadMark);
  }
  
  private aegz a()
  {
    return this.app.a().a();
  }
  
  private static SharedPreferences a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 1001) {}
    for (String str = "sp_nearby_summary_" + paramQQAppInterface.getCurrentAccountUin(); !TextUtils.isEmpty(str); str = "") {
      return BaseApplicationImpl.sApplication.getSharedPreferences("sp_nearby_summary_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    return null;
  }
  
  private QQMessageFacade a()
  {
    return this.app.b();
  }
  
  private Set<String> a(int paramInt)
  {
    if (paramInt == 1010)
    {
      if (this.bd == null) {
        this.bd = a(acbn.blh, paramInt, "date_box_last_read_time");
      }
      return this.bd;
    }
    if (paramInt == 1001)
    {
      if (this.be == null) {
        this.be = a(acbn.blg, paramInt, "lbs_box_last_read_time");
      }
      return this.be;
    }
    return null;
  }
  
  private Set<String> a(String paramString1, int paramInt, String paramString2)
  {
    long l1 = 0L;
    if (QLog.isColorLevel())
    {
      l1 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,boxType:" + paramInt + ",startTime:" + l1);
    }
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
    HashSet localHashSet = new HashSet();
    paramString1 = this.app.a(paramInt).g(paramString1, paramInt);
    long l2 = localSharedPreferences.getLong(paramString2, 0L);
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (MessageRecord)paramString1.next();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg_box", 4, "lastTime:" + l2 + ",mr.time:" + paramString2.time + ",uin:" + paramString2.senderuin + ",istroop:" + paramString2.istroop);
      }
      if ((A(paramString2.senderuin, paramInt) > 0) && (paramString2.time > l2)) {
        localHashSet.add(paramString2.senderuin);
      }
    }
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 2, "initSayHelloSet,endTime:" + l2 + ",costTime:" + (l2 - l1));
    }
    return localHashSet;
  }
  
  private toh a()
  {
    return this.app.a().a();
  }
  
  private ton a(int paramInt)
  {
    return this.app.a(paramInt);
  }
  
  private boolean a(MessageRecord paramMessageRecord, Set<MessageRecord> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (top.c(paramMessageRecord, (MessageRecord)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static int b(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.extInt2;
  }
  
  private static String b(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "lastuin";; str = "sm") {
      return String.format("%s_%s_%s", new Object[] { str, paramString, Integer.valueOf(paramInt) });
    }
  }
  
  private void bEn()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      MsgLruCache localMsgLruCache = this.app.a(0).a().b();
      if ((localMsgLruCache.get(top.u(acbn.bkE, 1001)) != null) || (localMsgLruCache.get(top.u(acbn.bkt, 1009)) != null) || (localMsgLruCache.get(top.u(acbn.bkY, 1010)) != null) || (localMsgLruCache.get(top.u(acbn.blK, 1032)) != null) || (localMsgLruCache.get(top.u(acbn.bkF, 1001)) != null) || (localMsgLruCache.get(top.u(acbn.blR, 1044)) != null)) {
        ThreadManager.post(new ConversationFacade.1(this), 8, null, false);
      }
      return;
    }
    bEo();
  }
  
  private void bEo()
  {
    bQ(acbn.bkF, 1001);
    bQ(acbn.bkE, 1001);
    bQ(acbn.bkt, 1009);
    bQ(acbn.bkY, 1010);
    bQ(acbn.blK, 1032);
    bQ(acbn.blR, 1044);
  }
  
  public static int c(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadCount;
  }
  
  public static int d(ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo == null) {
      return 0;
    }
    return paramConversationInfo.unreadMark;
  }
  
  public static boolean fr(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1);
  }
  
  public int A(String paramString, int paramInt)
  {
    return a(a().a(paramString, paramInt));
  }
  
  public int B(String paramString, int paramInt)
  {
    return b(a().a(paramString, paramInt));
  }
  
  public int C(String paramString, int paramInt)
  {
    return c(a().a(paramString, paramInt));
  }
  
  public int D(String paramString, int paramInt)
  {
    return d(a().a(paramString, paramInt));
  }
  
  public void D(String paramString, int paramInt1, int paramInt2)
  {
    a().I(paramString, paramInt1, paramInt2);
  }
  
  public int E(String paramString, int paramInt)
  {
    return a().I(paramString, paramInt);
  }
  
  public void E(String paramString, int paramInt1, int paramInt2)
  {
    a().J(paramString, paramInt1, paramInt2);
  }
  
  public int F(String paramString, int paramInt)
  {
    return a().J(paramString, paramInt);
  }
  
  public void F(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "rewriteUnreadCount uin=" + paramString + ",type" + paramInt1 + ",unread" + paramInt2);
    }
    a().K(paramString, paramInt1, paramInt2);
  }
  
  public int G(String paramString, int paramInt)
  {
    return a().G(paramString, paramInt);
  }
  
  public void G(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt1 + ",count" + paramInt2);
    }
    a().G(paramString, paramInt1, paramInt2);
    if (top.fv(paramInt1)) {
      bEn();
    }
  }
  
  public void T(int paramInt, long paramLong)
  {
    Set localSet = a(paramInt);
    if (localSet == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.object)
      {
        localSet.clear();
        ??? = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
        if (paramInt == 1010)
        {
          ((SharedPreferences)???).edit().putLong("date_box_last_read_time", paramLong).commit();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg_box", 2, "clearNewSayHelloSet,boxType:" + paramInt + ",time:" + paramLong);
          return;
        }
      }
      if (paramInt == 1001) {
        ((SharedPreferences)???).edit().putLong("lbs_box_last_read_time", paramLong).commit();
      }
    }
  }
  
  public ConversationInfo a(String paramString, int paramInt)
  {
    try
    {
      paramString = a().a(paramString, paramInt);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!top.fO(paramInt1))) {}
    for (;;)
    {
      return paramString2;
      SharedPreferences localSharedPreferences = a(this.app, paramInt1);
      String str;
      if ((paramInt1 == 1001) || (paramInt1 == 10002))
      {
        if ((paramInt2 < 0) || (paramInt2 > 0)) {
          continue;
        }
        if (acbn.bkE.equals(paramString1))
        {
          paramString1 = localSharedPreferences.getString(b(acbn.bkE, paramInt2, true), "");
          str = paramString1;
          if (acbn.blg.equals(paramString1)) {
            str = localSharedPreferences.getString(b(acbn.blg, paramInt2, true), "");
          }
        }
      }
      while (!TextUtils.isEmpty(str))
      {
        return SecurityUtile.decode(localSharedPreferences.getString(b(str, paramInt2, false), paramString2));
        str = paramString1;
        if (acbn.blg.equals(paramString1))
        {
          str = localSharedPreferences.getString(b(acbn.blg, paramInt2, true), "");
          continue;
          str = null;
        }
      }
    }
  }
  
  public void a(ConversationInfo paramConversationInfo, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg_box", 2, "updateSummaryLastUin info = " + paramConversationInfo + ", lbsHongbaoLastUin = " + paramString);
    }
    if ((paramConversationInfo == null) || (!top.fO(paramConversationInfo.type)) || (TextUtils.isEmpty(paramConversationInfo.uin))) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = a(this.app, paramConversationInfo.type).edit();
      if ((paramConversationInfo.type != 1001) && (paramConversationInfo.type != 10002)) {
        break;
      }
    } while ((!acbn.blg.equals(paramConversationInfo.uin)) && (!acbn.bkE.equals(paramConversationInfo.uin)));
    if ((paramConversationInfo.extInt1 <= 0) || (TextUtils.isEmpty(paramString))) {
      localEditor.remove(b(paramConversationInfo.uin, 0, true));
    }
    for (;;)
    {
      i = 1;
      if (i == 0) {
        break;
      }
      localEditor.commit();
      return;
      localEditor.putString(b(paramConversationInfo.uin, 0, true), paramString);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, 0);
  }
  
  protected void a(String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    long l;
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      l = a().H(paramString, paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "cleanUnread uin=" + paramString + ",type" + paramInt1 + ",unread" + l + " ,lastread" + paramLong + ",needDelMark" + paramBoolean2);
      }
      if (paramBoolean2) {
        a().I(paramString, paramInt1, 0);
      }
      a().a(paramString, paramInt1, paramLong, 0, 0, 0);
    }
    for (paramLong = l;; paramLong = l)
    {
      if (paramLong > 0L)
      {
        if ((top.fv(paramInt1)) && (paramBoolean1)) {
          bEn();
        }
        QQMessageFacade.Message localMessage = a().a(paramString, paramInt1, paramInt2);
        if (localMessage != null) {
          a(paramInt1).c(paramString, paramInt1, localMessage, paramInt2);
        }
      }
      OpenApiManager.getInstance().onMessageReaded(paramString, paramInt1, true, 0L);
      return;
      l = a().h(paramString, paramInt1, paramInt2);
      a().a(paramString, paramInt1, paramInt2, paramLong, 0);
    }
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int j = 0;
    int i;
    if (paramMessageRecord != null)
    {
      i = c(paramMessageRecord) * -1;
      j = d(paramMessageRecord) * -1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + i + ",unreadRedPacketDiff=" + j + ",mr=" + paramMessageRecord);
      }
      a().b(paramString, paramInt, -1, i, j);
      if (top.fv(paramInt)) {
        bEn();
      }
      return;
      i = 0;
    }
  }
  
  protected void a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    int i = 0;
    Iterator localIterator = paramList.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      int n = c(localMessageRecord) * -1;
      int i1 = d(localMessageRecord) * -1;
      if (localMessageRecord != null)
      {
        int k = j + n;
        int m = i + i1;
        j = k;
        i = m;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt + ",unreadDiff" + -1 + ",unreadGiftDiff=" + n + ",unreadRedPacketDiff=" + i1 + ",mr=" + localMessageRecord);
          j = k;
          i = m;
        }
      }
    }
    a().b(paramString, paramInt, paramList.size(), j, i);
    if (top.fv(paramInt)) {
      bEn();
    }
  }
  
  public void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanAllUnread needUpdateMsgtable=" + paramBoolean1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      Iterator localIterator = a().y().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (ConversationInfo)localIterator.next();
        if ((a((ConversationInfo)localObject) > 0) && (!acbn.bkJ.equals(((ConversationInfo)localObject).uin)) && ((!acbn.bla.equals(((ConversationInfo)localObject).uin)) || (acbn.bla.equals(((ConversationInfo)localObject).uin)))) {
          h(((ConversationInfo)localObject).uin, ((ConversationInfo)localObject).type, paramBoolean2);
        }
      }
      localIterator = a().B().iterator();
      while (localIterator.hasNext())
      {
        localObject = (ConfessConvInfo)localIterator.next();
        if (a((ConfessConvInfo)localObject) > 0) {
          d(((ConfessConvInfo)localObject).uin, ((ConfessConvInfo)localObject).type, ((ConfessConvInfo)localObject).topicId, paramBoolean2);
        }
      }
    }
    a().bEr();
    a().bEr();
  }
  
  public void aX(int paramInt, String paramString)
  {
    Set localSet = a(paramInt);
    if ((localSet == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    synchronized (this.object)
    {
      if (!localSet.contains(paramString)) {
        localSet.add(paramString);
      }
      return;
    }
  }
  
  public ConversationInfo b(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public void bEp()
  {
    Iterator localIterator = a().B().iterator();
    while (localIterator.hasNext())
    {
      ConfessConvInfo localConfessConvInfo = (ConfessConvInfo)localIterator.next();
      if (a(localConfessConvInfo) > 0) {
        d(localConfessConvInfo.uin, localConfessConvInfo.type, localConfessConvInfo.topicId, true);
      }
    }
  }
  
  public void bEq()
  {
    SharedPreferences localSharedPreferences = a(this.app, 1001);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    tog localtog = this.app.a();
    Iterator localIterator = this.app.a(1001).g(acbn.bkE, 1001).iterator();
    int i = 0;
    int j = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (MessageRecord)localIterator.next();
      if (localtog.F(((MessageRecord)localObject).senderuin, 1001) > 0) {
        break label289;
      }
      localObject = b(((MessageRecord)localObject).senderuin, 0, false);
      if (!localSharedPreferences.contains((String)localObject)) {
        break label289;
      }
      localEditor.remove((String)localObject);
      i += 1;
      j = 1;
    }
    label289:
    for (;;)
    {
      break;
      localIterator = this.app.a(1001).g(acbn.blg, 1001).iterator();
      while (localIterator.hasNext())
      {
        localObject = (MessageRecord)localIterator.next();
        if (localtog.F(((MessageRecord)localObject).senderuin, 1001) <= 0)
        {
          localObject = b(((MessageRecord)localObject).senderuin, 0, false);
          if (localSharedPreferences.contains((String)localObject))
          {
            localEditor.remove((String)localObject);
            i += 1;
            j = 1;
          }
        }
      }
      if (j != 0) {
        localEditor.commit();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box", 2, "clearMrSummary2, count=" + i);
      }
      return;
    }
  }
  
  protected void bP(String paramString, int paramInt)
  {
    h(paramString, paramInt, true);
    a().bP(paramString, paramInt);
  }
  
  public void bQ(String paramString, int paramInt)
  {
    if (acbn.blK.equals(paramString)) {
      bS(paramString, paramInt);
    }
    do
    {
      return;
      localObject1 = a(paramInt).g(paramString, paramInt);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    if (top.gR(paramString))
    {
      bR(paramString, paramInt);
      return;
    }
    if (acbn.bkE.equals(paramString))
    {
      bT(paramString, paramInt);
      return;
    }
    if (acbn.bkF.equals(paramString))
    {
      bT(paramString, paramInt);
      this.app.a().Rq(0);
      return;
    }
    String str = "";
    Object localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    label124:
    Object localObject2;
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (top.gR(((MessageRecord)localObject2).senderuin))
      {
        bR(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        m = k;
        label175:
        j += E(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        i += F(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        if ((!TextUtils.isEmpty(str)) || (i <= 0)) {
          break label458;
        }
        str = ((MessageRecord)localObject2).senderuin;
      }
    }
    label284:
    label448:
    label458:
    for (;;)
    {
      k = m;
      break label124;
      m = k;
      if (top.v((MessageRecord)localObject2)) {
        break label175;
      }
      m = k + A(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
      break label175;
      if (F(paramString, paramInt) != i)
      {
        m = 1;
        if ((A(paramString, paramInt) != k) || (E(paramString, paramInt) != j) || (m != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label448;
          }
        }
      }
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((toh)localObject2).a(paramString, paramInt, l, k, j, i);
        if ((top.fO(paramInt)) && (m != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + k + ", giftCount=" + j + ", redPacketCount=" + i);
        return;
        m = 0;
        break label284;
      }
    }
  }
  
  public void bR(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).g(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    int m = 0;
    int i = 0;
    int j = 0;
    String str = "";
    long l1 = this.app.getPreferences().getLong("sp_key_nearby_clean_unread_time", 0L);
    long l2 = this.app.getPreferences().getLong("sp_key_say_hello_msg_clean_unread_time", 0L);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    label88:
    Object localObject2;
    int n;
    int i1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      Iterator localIterator = a(((MessageRecord)localObject2).istroop).h(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop).iterator();
      MessageRecord localMessageRecord;
      while (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        n = k;
        if (localMessageRecord.time > l1)
        {
          n = k;
          if (!localMessageRecord.isread) {
            n = k + 1;
          }
        }
        k = n;
        if (localMessageRecord.time > l2)
        {
          k = n;
          if (!localMessageRecord.isread)
          {
            m += 1;
            k = n;
          }
        }
      }
      if (E(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0)
      {
        n = i;
        i1 = j;
        if (F(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {}
      }
      else
      {
        localIterator = this.app.b().i(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, A(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) * 2).iterator();
        for (;;)
        {
          n = i;
          i1 = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord.time > l2)
          {
            i += c(localMessageRecord);
            j += d(localMessageRecord);
          }
        }
      }
      if ((i1 <= 0) || (!TextUtils.isEmpty(str))) {
        break label626;
      }
      str = ((MessageRecord)localObject2).senderuin;
    }
    label453:
    label616:
    label626:
    for (;;)
    {
      i = n;
      j = i1;
      break label88;
      this.app.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", k).commit();
      if (F(paramString, paramInt) != j)
      {
        k = 1;
        if ((A(paramString, paramInt) != m) || (E(paramString, paramInt) != i) || (k != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label616;
          }
        }
      }
      for (l1 = 0L;; l1 = ((ConversationInfo)localObject1).lastread)
      {
        ((toh)localObject2).a(paramString, paramInt, l1, m, i, j);
        if ((top.fO(paramInt)) && (k != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateSayHelloBoxUnreadCount boxUin=" + paramString + ", unread=" + m + ", giftCount=" + i + ", redPacketCount=" + j);
        return;
        k = 0;
        break label453;
      }
    }
  }
  
  public void bS(String paramString, int paramInt)
  {
    Object localObject2 = a(paramInt).g(paramString, paramInt);
    Object localObject1;
    int i;
    int j;
    if (!aegu.c(this.app, true))
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (((MessageRecord)localObject2).isSelfConfessor()) {}
        for (j = 1033;; j = 1034)
        {
          aegu.g(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId());
          i = e(((MessageRecord)localObject2).senderuin, j, ((MessageRecord)localObject2).getConfessTopicId()) + i;
          break;
        }
      }
      if ((((aegs)this.app.getManager(269)).a() != null) && (aegp.B(this.app, "redpoint_box_show")))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.unread.Facade", 2, "calcConfessBoxUnreadCount box redpoint show +1");
        }
        i += 1;
      }
    }
    for (;;)
    {
      if (F(paramString, paramInt) != 0)
      {
        j = 1;
        if ((A(paramString, paramInt) != i) || (E(paramString, paramInt) != 0) || (j != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label353;
          }
        }
      }
      label353:
      for (long l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((toh)localObject2).a(paramString, paramInt, l, i, 0, 0);
        if ((top.fO(paramInt)) && (j != 0)) {
          a(a().a(paramString, paramInt), "");
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "calcConfessBoxUnreadCount boxUin=" + paramString + ", unread=" + i + ", giftCount=" + 0 + ", redPacketCount=" + 0);
        }
        return;
        j = 0;
        break;
      }
      continue;
      i = 0;
    }
  }
  
  public void bT(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt).g(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    int k = 0;
    int i = 0;
    int j = 0;
    String str = "";
    long l = this.app.getPreferences().getLong("sp_key_nearby_clean_unread_time", 0L);
    localObject1 = ((List)localObject1).iterator();
    label67:
    Object localObject2;
    int m;
    int n;
    int i1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (top.gR(((MessageRecord)localObject2).senderuin))
      {
        bR(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        m = k;
      }
      MessageRecord localMessageRecord;
      do
      {
        do
        {
          do
          {
            if (E(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0)
            {
              n = i;
              i1 = j;
              if (F(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
                break label410;
              }
            }
            localObject3 = this.app.b().i(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, A(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) * 2).iterator();
            for (;;)
            {
              n = i;
              i1 = j;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
              if (localMessageRecord.time > l)
              {
                i += c(localMessageRecord);
                j += d(localMessageRecord);
              }
            }
            if ((top.gS(((MessageRecord)localObject2).senderuin)) || (top.gT(((MessageRecord)localObject2).senderuin))) {
              break;
            }
            m = k;
          } while (top.v((MessageRecord)localObject2));
          m = k;
        } while (((MessageRecord)localObject2).time <= l);
        localObject3 = a(((MessageRecord)localObject2).istroop).h(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        m = k;
      } while (localObject3 == null);
      Object localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        m = k;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
        if ((localMessageRecord.time > l) && (!localMessageRecord.isread)) {
          k += 1;
        }
      }
      label410:
      if ((!TextUtils.isEmpty(str)) || (i1 <= 0)) {
        break label631;
      }
      str = ((MessageRecord)localObject2).senderuin;
    }
    label458:
    label621:
    label631:
    for (;;)
    {
      k = m;
      i = n;
      j = i1;
      break label67;
      if (F(paramString, paramInt) != j)
      {
        m = 1;
        if ((A(paramString, paramInt) != k) || (E(paramString, paramInt) != i) || (m != 0))
        {
          localObject1 = a().a(paramString, paramInt);
          localObject2 = a();
          if (localObject1 != null) {
            break label621;
          }
        }
      }
      for (l = 0L;; l = ((ConversationInfo)localObject1).lastread)
      {
        ((toh)localObject2).a(paramString, paramInt, l, k, i, j);
        if ((top.fO(paramInt)) && (m != 0)) {
          a(a().a(paramString, paramInt), str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + k + ", giftCount=" + i + ", redPacketCount=" + j);
        return;
        m = 0;
        break label458;
      }
    }
  }
  
  public int c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!paramMessageRecord.isSend()) && (!paramMessageRecord.isread) && (paramMessageRecord.msgtype == -2038)) {
      return 1;
    }
    return 0;
  }
  
  protected void c(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramString, paramInt, paramLong, true, paramBoolean);
  }
  
  public int d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while ((paramMessageRecord.isSend()) || (paramMessageRecord.isread) || (!MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
      return 0;
    }
    return 1;
  }
  
  public void d(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != 1033) && (paramInt1 != 1034))
    {
      c(paramString, paramInt1, a().f(paramString, paramInt1), paramBoolean);
      return;
    }
    a(paramString, paramInt1, a().a(paramString, paramInt1, paramInt2), true, paramBoolean, paramInt2);
  }
  
  @Deprecated
  public void d(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramInt2 = a().H(paramString2, paramInt2);
    int i = a().H(paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "moveBoxToMessageTab innerItemUnread=" + paramInt2 + ", convsItemUnread=" + i);
    }
    bQ(paramString1, paramInt1);
  }
  
  public int e(String paramString, int paramInt1, int paramInt2)
  {
    return a(a().a(paramString, paramInt1, paramInt2));
  }
  
  public long e(String paramString, int paramInt)
  {
    return a().f(paramString, paramInt);
  }
  
  public int eA(int paramInt)
  {
    Set localSet = a(paramInt);
    int i = 0;
    if (localSet != null) {}
    synchronized (this.object)
    {
      i = localSet.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "getUnreadSayHelloNum,boxType:" + paramInt + ",num:" + i);
      }
      return i;
    }
  }
  
  public boolean f(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString2 = a(paramInt).g(paramString2, paramInt);
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext()) {
        if (paramString1.equals(((MessageRecord)paramString2.next()).senderuin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void fp(List<MessageRecord> paramList)
  {
    HashSet localHashSet = null;
    int i;
    MessageRecord localMessageRecord;
    Object localObject;
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "addUnread msg size=" + paramList.size());
      }
      Iterator localIterator = paramList.iterator();
      for (i = 0;; i = 1) {
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localMessageRecord = (MessageRecord)localIterator.next();
            if ((localMessageRecord.isSendFromLocal()) || (localMessageRecord.isread)) {
              break label1116;
            }
            if ((localMessageRecord.msgtype != -2006) || (!(localMessageRecord instanceof MessageForFoldMsg)))
            {
              if (!localMessageRecord.isLongMsg()) {
                break label1113;
              }
              localObject = top.f(localMessageRecord);
              if (localHashSet != null) {
                break label1110;
              }
              localHashSet = new HashSet();
              label140:
              if (top.u(localMessageRecord))
              {
                if ((this.app.a().aQ(localMessageRecord)) || (localHashSet.contains(localObject))) {
                  continue;
                }
                localHashSet.add(localObject);
                label191:
                if ((1001 != localMessageRecord.istroop) && (10002 != localMessageRecord.istroop)) {
                  break label409;
                }
                if (localMessageRecord.msgtype != -2055) {
                  break label291;
                }
                localObject = (MessageForInteractAndFollow)localMessageRecord;
                F(localMessageRecord.senderuin, localMessageRecord.istroop, ((MessageForInteractAndFollow)localObject).unReadCount);
                label250:
                if (!top.fv(localMessageRecord.istroop)) {
                  break label1104;
                }
              }
            }
          }
        }
      }
    }
    label291:
    label1104:
    label1107:
    label1110:
    label1113:
    label1116:
    for (;;)
    {
      break;
      if (localHashSet.contains(localObject)) {
        localHashSet.remove(localObject);
      }
      break label191;
      if (localMessageRecord.msgtype == -2053)
      {
        if (!((MessageForNearbyLiveTip)localMessageRecord).isLiving) {
          break label1107;
        }
        if (A(localMessageRecord.frienduin, localMessageRecord.msgtype) > 0) {
          break;
        }
      }
      if (acbn.bkE.equals(localMessageRecord.frienduin))
      {
        a().b(localMessageRecord.senderuin, 1001, 1, c(localMessageRecord), d(localMessageRecord));
        break label250;
      }
      a().b(localMessageRecord.frienduin, 1001, 1, c(localMessageRecord), d(localMessageRecord));
      break label250;
      if (1009 == localMessageRecord.istroop)
      {
        a().b(localMessageRecord.frienduin, 1009, 1, c(localMessageRecord), d(localMessageRecord));
        break label250;
      }
      if ((1033 == localMessageRecord.istroop) || (1034 == localMessageRecord.istroop))
      {
        a().i(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId(), 1);
        aegu.d(this.app, false, true);
        break label250;
      }
      if (1008 == localMessageRecord.istroop)
      {
        if ("1".equals(localMessageRecord.getExtInfoFromExtStr("public_account_msg_unread_flag")))
        {
          a().bV(localMessageRecord.frienduin, localMessageRecord.istroop);
          break label250;
        }
        if ((acbn.blO.equals(localMessageRecord.frienduin)) || (acbn.blP.equals(localMessageRecord.frienduin))) {
          a().bU(localMessageRecord.frienduin, localMessageRecord.istroop);
        }
        a().b(localMessageRecord.frienduin, localMessageRecord.istroop, 1, c(localMessageRecord), d(localMessageRecord));
        break label250;
      }
      if (1044 == top.eD(localMessageRecord.istroop))
      {
        a().b(localMessageRecord.frienduin, localMessageRecord.istroop, 1, c(localMessageRecord), d(localMessageRecord));
        ((afsg)this.app.getBusinessHandler(127)).dbL();
        break label250;
      }
      localObject = a().a(localMessageRecord.frienduin, localMessageRecord.istroop);
      if ((localObject != null) && (((ConversationInfo)localObject).type == 1037) && (localMessageRecord.istroop != 1037))
      {
        bP(localMessageRecord.frienduin, 1037);
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + localMessageRecord.frienduin + ",new type" + localMessageRecord.istroop);
        }
      }
      if ((localObject != null) && (((ConversationInfo)localObject).type == 1044) && (localMessageRecord.istroop != 1044))
      {
        bP(localMessageRecord.frienduin, 1044);
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + localMessageRecord.frienduin + ",new type" + localMessageRecord.istroop);
        }
      }
      if ((localObject != null) && (((ConversationInfo)localObject).type == 1045) && (localMessageRecord.istroop != 1045))
      {
        bP(localMessageRecord.frienduin, 1045);
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "addUnread, remove old ConversationInfo,  uin=" + localMessageRecord.frienduin + ",new type" + localMessageRecord.istroop);
        }
      }
      if (localMessageRecord.istroop == 10005) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label1025;
        }
        a().H(localMessageRecord.frienduin, localMessageRecord.istroop, 1);
        break;
      }
      if (1038 == localMessageRecord.istroop)
      {
        localObject = (adag)this.app.getBusinessHandler(148);
        if (localObject != null) {
          ((adag)localObject).jw(paramList);
        }
      }
      a().b(localMessageRecord.frienduin, localMessageRecord.istroop, 1, c(localMessageRecord), d(localMessageRecord));
      break label250;
      if (i != 0) {
        bEn();
      }
      return;
      continue;
      break;
      break label140;
      break label191;
    }
  }
  
  public boolean gO(String paramString)
  {
    return this.app.a().a().gO(paramString);
  }
  
  public void h(String paramString, int paramInt, boolean paramBoolean)
  {
    d(paramString, paramInt, 0, paramBoolean);
  }
  
  protected void n(String paramString, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnreadFrom uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    if (paramInt == 1008) {}
    for (boolean bool1 = nyn.f(this.app, paramString);; bool1 = false)
    {
      if ((paramInt == 1008) && (oan.a().j(this.app, paramString)) && (!bool1)) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "isTroopBarAccount");
        }
      }
      do
      {
        return;
        if ((paramInt != 1008) || (!TextUtils.equals(paramString, acbn.blw))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.unread.Facade", 2, "NEW_KANDIAN_UIN not unread");
      return;
      o(paramString, paramInt, paramLong);
      a(paramInt).p(paramString, paramInt, paramLong);
      if ((paramInt == 1008) && (bool1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "inServiceAccountFolder uin=" + paramString);
        }
        nyn.a().k(this.app, paramString);
      }
      this.app.cLO();
      OpenApiManager localOpenApiManager = OpenApiManager.getInstance();
      bool1 = bool2;
      if (A(paramString, paramInt) == 0) {
        bool1 = true;
      }
      localOpenApiManager.onMessageReaded(paramString, paramInt, bool1, paramLong);
      return;
    }
  }
  
  protected void o(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = a(paramInt).h(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (a().H(paramString, paramInt) > 0) {
        c(paramString, paramInt, paramLong, true);
      }
      return;
    }
    ConversationInfo localConversationInfo;
    long l;
    label216:
    int i1;
    if (((fr(paramInt)) && (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq <= paramLong)) || ((fr(paramInt)) || (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > paramLong) || (top.ft(paramInt)) || (top.fu(paramInt))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "updateLastReadSeq uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
      }
      localConversationInfo = a().a(paramString, paramInt);
      if (localConversationInfo == null) {
        break label1201;
      }
      if (!fr(paramInt)) {
        break label1195;
      }
      l = Math.max(paramLong, localConversationInfo.lastread);
      i1 = localConversationInfo.unreadCount;
    }
    for (;;)
    {
      label256:
      int i;
      int n;
      int m;
      Object localObject2;
      label314:
      MessageRecord localMessageRecord;
      if (fr(paramInt))
      {
        paramLong = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq - l;
        i = (int)paramLong;
        n = 0;
        m = 0;
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "updateLastReadSeq unread =" + i);
        }
        localObject2 = null;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label1028;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        if (!fr(paramInt)) {
          break label648;
        }
        paramLong = localMessageRecord.shmsgseq;
        label349:
        if (paramLong > l) {
          break label1173;
        }
        if (!localMessageRecord.isLongMsg()) {
          break label707;
        }
        if (localObject1 != null) {
          break label1188;
        }
      }
      label648:
      label1163:
      label1166:
      label1173:
      label1188:
      for (Object localObject3 = new HashMap();; localObject3 = localObject1)
      {
        localObject1 = top.f(localMessageRecord);
        Object localObject4;
        int i2;
        int j;
        int k;
        if (((Map)localObject3).containsKey(top.f(localMessageRecord)))
        {
          localObject4 = (Set)((Map)localObject3).get(localObject1);
          localObject1 = localObject3;
          i2 = i;
          j = n;
          k = m;
          if (localObject4 != null)
          {
            localObject1 = localObject3;
            i2 = i;
            j = n;
            k = m;
            if (!((Set)localObject4).isEmpty())
            {
              localObject1 = localObject3;
              i2 = i;
              j = n;
              k = m;
              if (!a(localMessageRecord, (Set)localObject4))
              {
                ((Set)localObject4).add(localMessageRecord);
                k = m;
                j = n;
                i2 = i;
                localObject1 = localObject3;
              }
            }
          }
        }
        for (;;)
        {
          localObject3 = localObject2;
          n = j;
          m = k;
          if (paramLong > l)
          {
            if (top.fK(localMessageRecord.msgtype))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
              if ((a().H(paramString, paramInt) > 0) || (a().I(paramString, paramInt) > 0) || (a().J(paramString, paramInt) > 0))
              {
                c(paramString, paramInt, paramLong, false);
                return;
              }
              if ((paramLong <= 0L) || (e(paramString, paramInt) >= paramLong)) {
                break;
              }
              c(paramString, paramInt, paramLong, false);
              return;
              paramLong = a(paramInt).e(paramString, paramInt, paramLong);
              break label256;
              paramLong = localMessageRecord.time;
              break label349;
              localObject4 = new HashSet();
              ((Set)localObject4).add(localMessageRecord);
              ((Map)localObject3).put(localObject1, localObject4);
              localObject1 = localObject3;
              i2 = i;
              j = n;
              k = m;
              continue;
              label707:
              if ((!top.fF(localMessageRecord.msgtype)) || (localMessageRecord.isread)) {
                break label1173;
              }
              i2 = i + 1;
              j = n + c(localMessageRecord);
              k = m + d(localMessageRecord);
              continue;
            }
            if ((fr(paramInt)) && (ahwb.aB(localMessageRecord)))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            if (!localMessageRecord.isLongMsg()) {
              break label1166;
            }
            if ((localObject1 != null) && (((Map)localObject1).containsKey(top.f(localMessageRecord))) && (a(localMessageRecord, (Set)((Map)localObject1).get(top.f(localMessageRecord)))))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            if (localObject2 != null) {
              break label1163;
            }
            localObject2 = new HashSet();
            label872:
            localObject4 = top.f(localMessageRecord);
            if (!top.u(localMessageRecord)) {
              break label995;
            }
            if (this.app.a().aQ(localMessageRecord))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            if (((Set)localObject2).contains(localObject4))
            {
              i = i2 - 1;
              n = j;
              m = k;
              break label314;
            }
            ((Set)localObject2).add(localObject4);
            localObject3 = localObject2;
          }
          for (;;)
          {
            n = j + c(localMessageRecord);
            m = k + d(localMessageRecord);
            localObject2 = localObject3;
            i = i2;
            break label314;
            label995:
            localObject3 = localObject2;
            if (((Set)localObject2).contains(localObject4))
            {
              ((Set)localObject2).remove(localObject4);
              localObject3 = localObject2;
              continue;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder().append("updateLastReadSeq before=");
                if (localConversationInfo == null) {
                  break label1157;
                }
              }
              for (localObject1 = localConversationInfo.toString();; localObject1 = null)
              {
                QLog.d("Q.unread.Facade", 2, (String)localObject1 + " , end unread=" + i + ", lastread=" + l + ",unreadGift=" + n + ",unreadRedPacket=" + m);
                a().a(paramString, paramInt, l, i, n, m);
                if ((i == i1) || (!top.fv(paramInt))) {
                  break;
                }
                bEn();
                return;
              }
              break label872;
              localObject3 = localObject2;
            }
          }
          i2 = i;
          j = n;
          k = m;
        }
      }
      label1028:
      label1157:
      label1195:
      l = paramLong;
      break label216;
      label1201:
      i1 = 0;
      l = paramLong;
    }
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
  
  public void qh()
  {
    a().qh();
    a().qh();
    Object localObject2 = a().y();
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    label297:
    while (((Iterator)localObject2).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject2).next();
      if (u(localConversationInfo.uin, localConversationInfo.type))
      {
        if (top.x(localConversationInfo.uin, localConversationInfo.type)) {
          bQ(localConversationInfo.uin, localConversationInfo.type);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache info=" + localConversationInfo.toString());
        }
      }
      for (;;)
      {
        if ((a(localConversationInfo) != 0) || ((localConversationInfo.unreadGiftCount == 0) && (localConversationInfo.extInt1 == 0))) {
          break label297;
        }
        h(localConversationInfo.uin, localConversationInfo.unreadGiftCount, false);
        break;
        if ((top.fL(localConversationInfo.type)) && (!top.x(localConversationInfo.uin, localConversationInfo.type)) && (!t(localConversationInfo.uin, top.eD(localConversationInfo.type)))) {
          ((Set)localObject1).add(localConversationInfo);
        }
        if ((QLog.isColorLevel()) && ((a(localConversationInfo) != 0) || (localConversationInfo.unreadGiftCount != 0) || (localConversationInfo.extInt1 != 0))) {
          QLog.d("Q.unread.Facade", 2, "initCache [not in recent] info=" + localConversationInfo.toString());
        }
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "initCache remove info=" + ((ConversationInfo)localObject2).toString());
        }
        a().bP(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      }
    }
  }
  
  public boolean t(String paramString, int paramInt)
  {
    if (paramString == null) {}
    label300:
    label301:
    label303:
    label310:
    for (;;)
    {
      return false;
      Object localObject;
      String str;
      if (paramInt == 1009)
      {
        localObject = a(paramInt).g(acbn.bkt, 1009);
        str = null;
      }
      for (;;)
      {
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label310;
        }
        localObject = ((List)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (paramString.equals(localMessageRecord.senderuin))
          {
            return true;
            if (paramInt == 1001)
            {
              localObject = a(paramInt).g(acbn.bkE, 1001);
              if (localObject != null) {
                ((List)localObject).addAll(a(paramInt).g(acbn.bkF, 1001));
              }
              for (;;)
              {
                str = acbn.blg;
                break;
                localObject = a(paramInt).g(acbn.bkF, 1001);
              }
            }
            if (paramInt == 1010)
            {
              localObject = a(paramInt).g(acbn.bkY, 1010);
              str = acbn.blh;
              continue;
            }
            if (paramInt == 1032)
            {
              localObject = a(paramInt).g(acbn.blK, 1032);
              str = null;
              continue;
            }
            if (paramInt != 1044) {
              break label303;
            }
            localObject = a(paramInt).g(acbn.blR, 1044);
            str = null;
            continue;
          }
          if ((str == null) || (i != 0) || (!str.equals(localMessageRecord.senderuin))) {
            break label300;
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if (i == 0) {
            break label301;
          }
          return f(paramString, paramInt, str);
        }
        break;
        str = null;
        localObject = null;
      }
    }
  }
  
  public boolean u(String paramString, int paramInt)
  {
    if (this.app.a().a().b(paramString, paramInt) != null) {}
    do
    {
      return true;
      if (7000 == paramInt) {
        return false;
      }
      if (!fr(paramInt)) {
        return gO(paramString);
      }
    } while (aizp.a().J(this.app, paramString));
    return false;
  }
  
  public int va()
  {
    return this.app.getPreferences().getInt("sp_key_sayhello_box_unread_count", 0);
  }
  
  public int vb()
  {
    return va() + this.app.a().getInterFollowMsgBoxUnreadCount();
  }
  
  public Set<ConversationInfo> x()
  {
    return a().y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tog
 * JD-Core Version:    0.7.0.1
 */