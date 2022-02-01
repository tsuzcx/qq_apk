import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.5;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.6;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lyrh;>;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ysf
  extends Observable
  implements Handler.Callback, Manager
{
  public static final String aZI = acfp.m(2131709029);
  private LinkedList<ysf.a> D = new LinkedList();
  private Comparator<SysSuspiciousMsg> E = new ysh(this);
  private Comparator<Object> F = new ysk(this);
  private acjf jdField_a_of_type_Acjf;
  public aelc a;
  private ajdo.a jdField_a_of_type_Ajdo$a = new ysj(this);
  private HashSet<String> aI = new HashSet();
  private QQAppInterface app;
  private acff jdField_b_of_type_Acff;
  private PhoneContactManagerImp jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  public boolean boA;
  private volatile boolean boB = true;
  private volatile boolean boC;
  private boolean bov;
  public boolean bow;
  public boolean box;
  public boolean boy;
  public boolean boz;
  private achg c;
  private int caV;
  private int caW;
  private int caX;
  private int caY = -1;
  private volatile int caZ;
  private ConcurrentHashMap<Long, SysSuspiciousMsg> dc = new ConcurrentHashMap(50);
  private EntityManager em;
  private acfd l = new ysi(this);
  private Comparator<ytv> mComparator = new ysg(this);
  private Handler mHandler;
  ArrayList<ytv> rk = new ArrayList();
  ArrayList<ytq> rl = new ArrayList();
  
  public ysf(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.em = paramQQAppInterface.a().createEntityManager();
    this.c = ((achg)paramQQAppInterface.getManager(159));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_b_of_type_Acff = ((acff)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Acjf = ((acjf)paramQQAppInterface.getManager(257));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_Ajdo$a);
    paramQQAppInterface.addObserver(this.l, true);
    this.mHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private boolean H(String paramString, int paramInt)
  {
    paramString = this.app.b().b(paramString, 0, new int[] { paramInt });
    return (paramString != null) && (paramString.size() > 0);
  }
  
  public static boolean P(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msgData == null)) {
      return false;
    }
    try
    {
      boolean bool = ytq.a(MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData));
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("NewFriendManager", 2, paramMessageRecord, new Object[0]);
    }
    return false;
  }
  
  private boolean Uk()
  {
    return !((zbq)this.app.getManager(295)).Vf();
  }
  
  private int a(boolean paramBoolean, StringBuilder paramStringBuilder, ArrayList<ytv> paramArrayList, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      long l1 = anzd.a().p(this.app);
      localObject2 = this.app.b().a(acbn.bkJ, 0, l1);
      localObject1 = new ArrayList(((List)localObject2).size());
      ((List)localObject1).addAll((Collection)localObject2);
    }
    int i;
    for (;;)
    {
      i = paramInt;
      if (localObject1 == null) {
        break;
      }
      i = paramInt;
      if (((List)localObject1).size() <= 0) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        i = paramInt;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForSystemMsg))
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append(" sys").append(((MessageRecord)localObject2).isread);
          }
          ((MessageForSystemMsg)localObject2).parse();
          i = paramInt;
          if (((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get() == 13)
          {
            if (this.jdField_b_of_type_Acff.isFriend(String.valueOf(((MessageForSystemMsg)localObject2).structMsg.req_uin.get()))) {
              continue;
            }
            paramInt += 1;
            i = paramInt;
            if (QLog.isColorLevel())
            {
              paramStringBuilder.append(" sys").append(((MessageRecord)localObject2).isread);
              i = paramInt;
            }
          }
          paramArrayList.add(new ytq((MessageForSystemMsg)localObject2));
          paramInt = i;
        }
      }
      localObject1 = this.app.b().k(acbn.bkJ, 0);
    }
    return i;
  }
  
  private ArrayList<yrh> a(int paramInt, boolean paramBoolean1, ArrayList<ytv> paramArrayList, StringBuilder paramStringBuilder, boolean paramBoolean2, ArrayList<MayKnowRecommend> paramArrayList1, ArrayList<yrh> paramArrayList2, boolean paramBoolean3)
  {
    Object localObject;
    if (paramBoolean3)
    {
      localObject = this.c.cu();
      paramArrayList2 = (ArrayList<yrh>)localObject;
      if (localObject != null)
      {
        paramArrayList2 = (ArrayList<yrh>)localObject;
        if (!((ArrayList)localObject).isEmpty())
        {
          ArrayList localArrayList = this.c.q(paramInt);
          paramArrayList2 = (ArrayList<yrh>)localObject;
          if (localArrayList != null)
          {
            paramArrayList1.addAll(localArrayList);
            paramArrayList2 = (ArrayList<yrh>)localObject;
          }
        }
      }
    }
    if ((paramBoolean1) || (paramBoolean2)) {}
    for (paramInt = 1; (paramArrayList1 != null) && (paramArrayList1.size() > 0) && (paramInt != 0); paramInt = 0)
    {
      localObject = new ArrayList(paramArrayList1.size());
      ((ArrayList)localObject).addAll(paramArrayList1);
      paramArrayList1 = ((ArrayList)localObject).iterator();
      while (paramArrayList1.hasNext())
      {
        localObject = (MayKnowRecommend)paramArrayList1.next();
        if ((localObject != null) && ((localObject instanceof MayKnowRecommend)))
        {
          paramArrayList.add(new yts((MayKnowRecommend)localObject));
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("mk uin:").append(((MayKnowRecommend)localObject).uin).append(" reason:").append(((MayKnowRecommend)localObject).recommendReason);
          }
        }
      }
    }
    return paramArrayList2;
  }
  
  private ArrayList<Entity> a(boolean paramBoolean1, ArrayList<ytv> paramArrayList, StringBuilder paramStringBuilder, ArrayList<yrh> paramArrayList1, boolean paramBoolean2, ArrayList<Entity> paramArrayList2)
  {
    if (this.box)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.bU().clone();
      paramArrayList2 = null;
      Object localObject;
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
      {
        localObject = paramArrayList1.iterator();
        for (paramArrayList1 = paramArrayList2; ((Iterator)localObject).hasNext(); paramArrayList1 = paramArrayList2)
        {
          paramArrayList2 = (yrh)((Iterator)localObject).next();
          if (!paramBoolean1) {
            break label353;
          }
        }
      }
      for (;;)
      {
        if ((paramArrayList1 != null) && (QLog.isColorLevel())) {
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg init defaultTabInfo.recommend_count = " + paramArrayList1.caI);
        }
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          paramArrayList2 = localArrayList.iterator();
          while (paramArrayList2.hasNext())
          {
            localObject = (Entity)paramArrayList2.next();
            if ((localObject instanceof ContactMatch))
            {
              if (paramBoolean2) {
                paramArrayList.add(new ytp((ContactMatch)localObject));
              }
              if (paramArrayList1 != null) {
                paramArrayList1.caI += 1;
              }
              if (QLog.isColorLevel()) {
                paramStringBuilder.append(" cm").append(((ContactMatch)localObject).mobileNo).append(((ContactMatch)localObject).isReaded);
              }
            }
            else if ((localObject instanceof ContactBinded))
            {
              if (paramBoolean2) {
                paramArrayList.add(new yto((ContactBinded)localObject));
              }
              if (QLog.isColorLevel()) {
                paramStringBuilder.append(" cb").append(((ContactBinded)localObject).isReaded);
              }
            }
          }
          if ((paramArrayList1 != null) && (QLog.isColorLevel())) {
            QLog.d("NewFriendManager", 2, "loadNewFriendMsg result defaultTabInfo.recommend_count = " + paramArrayList1.caI);
          }
        }
        return localArrayList;
        label353:
        break;
        paramArrayList1 = null;
      }
    }
    return paramArrayList2;
  }
  
  private void a(ArrayList<ytv> paramArrayList, PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    if (this.bow) {
      paramArrayList.add(new ytt());
    }
    while ((!this.boy) || ((this.box) && (!paramPhoneContactManagerImp.Uz()))) {
      return;
    }
    paramArrayList.add(new ytu(a(), this.box));
  }
  
  private void a(ArrayList<ytv> paramArrayList1, ArrayList<ytv> paramArrayList2, int paramInt1, ArrayList<yrh> paramArrayList, boolean paramBoolean, ArrayList<Entity> paramArrayList3, int paramInt2)
  {
    int j = 0;
    int i = 0;
    if (paramArrayList2.size() > 0)
    {
      Collections.sort(paramArrayList2, this.mComparator);
      NewFriendSubTitle localNewFriendSubTitle = new NewFriendSubTitle();
      localNewFriendSubTitle.title = this.app.getApp().getApplicationContext().getResources().getString(2131696302);
      boolean bool;
      if (paramInt2 == 3)
      {
        bool = true;
        localNewFriendSubTitle.showEntrance = bool;
        paramArrayList1.add(new yty(localNewFriendSubTitle));
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.caW + ",notifyListSize = " + paramArrayList2.size() + ", mSysMsgShouldAddMoreInfo = " + this.bov);
        }
        if (((!this.box) || (paramArrayList3 == null) || (paramArrayList3.size() <= 0)) && (!paramBoolean) && ((paramArrayList == null) || (paramArrayList.isEmpty()))) {
          break label311;
        }
        paramInt1 = i;
        if (this.caW == paramArrayList2.size()) {
          break label218;
        }
        k(paramArrayList1, paramArrayList2);
        label203:
        this.caW = paramArrayList2.size();
      }
      label218:
      do
      {
        return;
        bool = false;
        break;
        while (paramInt1 < this.caV)
        {
          paramArrayList1.add((ytv)paramArrayList2.get(paramInt1));
          paramInt1 += 1;
        }
        if (!this.bov) {
          break label203;
        }
        paramArrayList = new NewFriendMoreInfo();
        paramArrayList.moreInfo = this.app.getApp().getApplicationContext().getResources().getString(2131696296);
        paramArrayList.type = 1000;
        paramArrayList1.add(new ytw(paramArrayList));
        break label203;
        if (paramArrayList2.size() > 100)
        {
          paramInt1 = j;
          while (paramInt1 < 100)
          {
            paramArrayList1.add(paramArrayList2.get(paramInt1));
            paramInt1 += 1;
          }
          paramArrayList2 = new NewFriendMoreInfo();
          paramArrayList2.moreInfo = this.app.getApp().getApplicationContext().getResources().getString(2131696296);
          paramArrayList2.type = 1000;
          paramArrayList1.add(new ytw(paramArrayList2));
          return;
        }
        paramArrayList1.addAll(paramArrayList2);
      } while (((paramInt1 % 20 != 0) || (anzd.a().bI(this.app))) && ((paramInt1 <= 20) || (anzd.a().bJ(this.app))));
      label311:
      paramArrayList2 = new NewFriendMoreInfo();
      paramArrayList2.moreInfo = this.app.getApp().getApplicationContext().getResources().getString(2131696296);
      paramArrayList2.type = 1000;
      paramArrayList1.add(new ytw(paramArrayList2));
      return;
    }
    paramArrayList1.add(new ytz());
  }
  
  private void a(ArrayList<QIMFollwerAdd> paramArrayList, ArrayList<ytv> paramArrayList1, FlashChatManager paramFlashChatManager)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Acjf.b(false);
    if (localArrayList.size() > 0) {
      paramArrayList1.addAll(localArrayList);
    }
    if ((paramFlashChatManager.amY()) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        paramArrayList1.add(new yuf((QIMFollwerAdd)paramArrayList.next()));
      }
    }
  }
  
  private void a(ArrayList<PhoneContactAdd> paramArrayList, ArrayList<ytv> paramArrayList1, StringBuilder paramStringBuilder)
  {
    if ((this.box) && (paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)paramArrayList.next();
        paramArrayList1.add(new yue(localPhoneContactAdd));
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" pca").append(localPhoneContactAdd.unifiedCode);
        }
      }
    }
  }
  
  private void a(ArrayList<ytv> paramArrayList1, boolean paramBoolean1, ArrayList<ytv> paramArrayList2, StringBuilder paramStringBuilder, ArrayList<MayKnowRecommend> paramArrayList, boolean paramBoolean2)
  {
    if (paramArrayList2.size() > 0)
    {
      this.caY = paramArrayList1.size();
      Collections.sort(paramArrayList2, this.mComparator);
      if ((paramBoolean2) && (paramBoolean1)) {
        l(paramArrayList, paramArrayList2);
      }
      paramArrayList1.addAll(paramArrayList2);
    }
    this.caX = paramArrayList2.size();
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append(" mRecommendSubTitleIndex : ").append(this.caY).append(" mRecommendShowCount : ").append(this.caX).append(" shouldShowNewFriendMayknow:").append(paramBoolean2);
      QLog.d("NewFriendManager", 2, paramStringBuilder.toString());
    }
  }
  
  private void a(ArrayList<ytv> paramArrayList1, boolean paramBoolean1, ArrayList<ytv> paramArrayList2, boolean paramBoolean2, ArrayList<yrh> paramArrayList, boolean paramBoolean3)
  {
    if ((paramBoolean3) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
      if (paramArrayList.size() > 1)
      {
        paramBoolean3 = true;
        paramArrayList1.add(new yuc(paramArrayList, paramBoolean3));
        if (paramArrayList.size() > 1) {
          paramArrayList1.add(new ytx(paramArrayList));
        }
        if (!paramBoolean1) {
          break label99;
        }
        if (paramArrayList2.size() == 0) {
          paramArrayList1.add(new yua());
        }
      }
    }
    label99:
    while (paramArrayList2.size() <= 0)
    {
      do
      {
        for (;;)
        {
          return;
          paramBoolean3 = false;
        }
        if (!paramBoolean2) {
          break;
        }
      } while (paramArrayList2.size() != 0);
      paramArrayList1.add(new yua());
      return;
      paramArrayList1.add(new yub());
      return;
    }
    paramArrayList2 = new NewFriendSubTitle();
    paramArrayList2.title = this.app.getApp().getApplicationContext().getResources().getString(2131689916);
    paramArrayList1.add(new yty(paramArrayList2));
  }
  
  private boolean a(ytv paramytv)
  {
    if (this.app == null) {}
    acxw localacxw;
    do
    {
      return false;
      localacxw = this.app.a().a();
    } while ((paramytv == null) || (localacxw == null) || ((paramytv.isReaded()) && (!localacxw.R(acbn.bkA, 4000))));
    return true;
  }
  
  private void b(ytv paramytv)
  {
    if (!a(paramytv)) {}
    acxw localacxw;
    RecentUser localRecentUser;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
      }
      localacxw = this.app.a().a();
      localRecentUser = localacxw.a(acbn.bkA, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 26;
    localRecentUser.displayName = aZI;
    if ((paramytv != null) && ((paramytv instanceof yts)))
    {
      localRecentUser.lastmsgdrafttime = paramytv.Kz;
      localRecentUser.msg = paramytv.message;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | temp str = " + localRecentUser.msg);
      }
    }
    for (;;)
    {
      if (localRecentUser.msgData == null) {
        localRecentUser.msgData = String.valueOf(localRecentUser.msg).getBytes();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | ru.msg = " + localRecentUser.msg);
      }
      localacxw.e(localRecentUser);
      return;
      if ((paramytv != null) && ((paramytv instanceof ytq)) && (!TextUtils.isEmpty(paramytv.message)))
      {
        if (paramytv.Kz > 0L) {
          localRecentUser.lastmsgtime = paramytv.Kz;
        }
        localRecentUser.msg = paramytv.message;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | ru.lastmsgtime = " + localRecentUser.lastmsgtime);
        }
      }
    }
  }
  
  private ArrayList<ytq> bP()
  {
    return (ArrayList)this.rl.clone();
  }
  
  private ArrayList<ytq> bQ()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB start,old unReadNewFriendSystemMsg.size() = " + this.rl.size());
        }
        this.rl.clear();
        Object localObject1 = this.app.b().k(acbn.bkJ, 0);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
            if (!(localMessageRecord instanceof MessageForSystemMsg)) {
              continue;
            }
            ((MessageForSystemMsg)localMessageRecord).parse();
            if (((((MessageForSystemMsg)localMessageRecord).structMsg.msg.sub_type.get() == 13) && (this.jdField_b_of_type_Acff.isFriend(String.valueOf(((MessageForSystemMsg)localMessageRecord).structMsg.req_uin.get())))) || (localMessageRecord.isread)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB add a msg,mr.senderuin = " + localMessageRecord.senderuin + ",mr.time = " + localMessageRecord.time);
            }
            if (this.rl.size() <= 0) {
              break label364;
            }
            Iterator localIterator = this.rl.iterator();
            if (!localIterator.hasNext()) {
              break label364;
            }
            ytq localytq = (ytq)localIterator.next();
            if ((localytq.a == null) || (!localytq.a.senderuin.equals(localMessageRecord.senderuin))) {
              continue;
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            this.rl.add(new ytq((MessageForSystemMsg)localMessageRecord));
            continue;
          }
        }
        if (!QLog.isColorLevel()) {
          break label355;
        }
      }
      finally {}
      QLog.i("NewFriendManager", 2, "getUnReadNewFriendSystemMsgFromDB size = " + this.rl.size());
      label355:
      ArrayList localArrayList = this.rl;
      return localArrayList;
      label364:
      int i = 0;
    }
  }
  
  private void clo()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    Object localObject = (ArrayList)localEntityManager.query(QIMFollwerAdd.class);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFollwerAdd localQIMFollwerAdd = (QIMFollwerAdd)((Iterator)localObject).next();
        localQIMFollwerAdd.isRead = true;
        localEntityManager.update(localQIMFollwerAdd);
      }
    }
    localEntityManager.close();
  }
  
  private void clv()
  {
    ytv localytv = a();
    if (localytv != null)
    {
      b(localytv);
      setChanged();
      notifyObservers(localytv);
    }
    for (;;)
    {
      clp();
      return;
      clr();
    }
  }
  
  private void de(ArrayList<ytv> paramArrayList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      Iterator localIterator = paramArrayList.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        ytv localytv = (ytv)localIterator.next();
        if ((localytv == null) || (localytv.isReaded()) || (!(localytv instanceof ytq))) {
          break label101;
        }
        i += 1;
      }
    }
    label101:
    for (;;)
    {
      break;
      QLog.d("NewFriendManager", 2, "loadNewFriendMsg size = " + paramArrayList.size() + ",unReadSysMsgCountInCache = " + i);
      return;
    }
  }
  
  private void k(ArrayList<ytv> paramArrayList1, ArrayList<ytv> paramArrayList2)
  {
    int j = 0;
    boolean bool2 = true;
    if (paramArrayList2.size() > 1)
    {
      int i = paramArrayList2.size() - 1;
      int k;
      for (;;)
      {
        if ((i < 0) || (!((ytv)paramArrayList2.get(i)).isReaded()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NewFriendManager", 2, "loadNewFriendMsg|lastUnReadIndex = " + i);
          }
          k = anzd.a().ac(this.app);
          if (i > 0) {
            break label194;
          }
          i = j;
          while (i < 1)
          {
            paramArrayList1.add((ytv)paramArrayList2.get(i));
            i += 1;
          }
        }
        i -= 1;
      }
      this.caV = 1;
      boolean bool1 = bool2;
      label194:
      do
      {
        do
        {
          this.bov = bool1;
          if (bool1)
          {
            paramArrayList2 = new NewFriendMoreInfo();
            paramArrayList2.moreInfo = this.app.getApp().getApplicationContext().getResources().getString(2131696296);
            paramArrayList2.type = 1000;
            paramArrayList1.add(new ytw(paramArrayList2));
          }
          return;
          j = 0;
          while (j <= i)
          {
            paramArrayList1.add((ytv)paramArrayList2.get(j));
            j += 1;
          }
          this.caV = (i + 1);
          bool1 = bool2;
        } while (k > 99);
        bool1 = bool2;
      } while (i + 1 != paramArrayList2.size());
      if (!anzd.a().bJ(this.app)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
    }
    paramArrayList1.addAll(paramArrayList2);
    this.bov = false;
    this.caV = paramArrayList2.size();
  }
  
  private void l(ArrayList<MayKnowRecommend> paramArrayList, ArrayList<ytv> paramArrayList1)
  {
    if (paramArrayList1 == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localObject = ((acff)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      localArrayList = ((adyp)this.app.getManager(112)).cN();
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "loadNewFriendMsg|card.strSchool = " + ((Card)localObject).strSchool + "schoolInfos =" + localArrayList);
      }
    } while ((!TextUtils.isEmpty(((Card)localObject).strSchool)) || ((localArrayList != null) && (!localArrayList.isEmpty())) || (paramArrayList == null) || (paramArrayList.size() <= 0));
    Object localObject = new ConnectsExplorationBanner();
    ((ConnectsExplorationBanner)localObject).setBanner(true);
    localObject = new ytr((ConnectsExplorationBanner)localObject);
    if (paramArrayList.size() <= 4)
    {
      paramArrayList1.add(localObject);
      return;
    }
    paramArrayList1.add(4, localObject);
  }
  
  public static boolean u(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.equals(acbn.bkA)) && (!paramString.equals(acbn.blu)) && (!paramString.equals(acbn.bkJ)) && (!paramString.equals(acbn.blC))) {
      return false;
    }
    return true;
  }
  
  private void x(ArrayList<ytv> paramArrayList, int paramInt)
  {
    String str = "";
    if (paramInt == 1)
    {
      str = yqv.a(this.app).aZy;
      paramArrayList.add(new yud(str));
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.loadNewFriendMsg, type=" + paramInt + ",blockedUin=" + str);
    }
  }
  
  private void y(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "insertMsgForAIOShowNewsMsg" + paramString2 + ",msgType:" + paramInt);
    }
    long l2 = anaz.gQ() - 60L;
    Object localObject = this.app.b().f(paramString2, 0);
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (!((List)localObject).isEmpty()) {
        l1 = ((ChatMessage)((List)localObject).get(0)).time - 360L;
      }
    }
    localObject = this.app.b().b(paramString2, 0, new int[] { paramInt });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null) {
          this.app.b().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    localObject = anbi.d(paramInt);
    ((MessageRecord)localObject).init(this.app.getCurrentAccountUin(), paramString2, paramString2, paramString1, l1, paramInt, 0, l1);
    ((MessageRecord)localObject).isread = true;
    if (!achp.a(this.app, (MessageRecord)localObject, false))
    {
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      this.app.b().d(paramString2, 0, paramString1);
    }
  }
  
  public void AI(boolean paramBoolean)
  {
    aF(paramBoolean, 23);
  }
  
  public void EA(int paramInt)
  {
    this.caZ = paramInt;
  }
  
  public void Ez(int paramInt)
  {
    this.caW = paramInt;
  }
  
  public boolean Ul()
  {
    ytv localytv = a();
    return (localytv != null) && (localytv.G(this.app));
  }
  
  public aelc a()
  {
    if (this.jdField_a_of_type_Aelc == null) {
      this.jdField_a_of_type_Aelc = aeld.b();
    }
    return this.jdField_a_of_type_Aelc;
  }
  
  public ytv a()
  {
    int j = 0;
    Object localObject = bO();
    int i = 0;
    ytv localytv1;
    if (i < ((ArrayList)localObject).size())
    {
      localytv1 = (ytv)((ArrayList)localObject).get(i);
      if ((localytv1 == null) || (localytv1.isReaded())) {}
    }
    for (;;)
    {
      if ((localytv1 != null) && (!(localytv1 instanceof yto)) && (!(localytv1 instanceof yts)))
      {
        i = j;
        if (!(localytv1 instanceof ytp)) {
          break label80;
        }
      }
      for (;;)
      {
        return localytv1;
        i += 1;
        break;
        label80:
        ytv localytv2;
        do
        {
          i += 1;
          if (i >= ((ArrayList)localObject).size()) {
            break;
          }
          localytv2 = (ytv)((ArrayList)localObject).get(i);
        } while ((localytv2 == null) || (localytv2.isReaded()) || ((localytv2 instanceof ytq)));
        while (localytv2 != null)
        {
          localObject = localytv2;
          if (localytv1.Kz >= localytv2.Kz) {
            localObject = localytv1;
          }
          return localObject;
          localytv2 = null;
        }
      }
      localytv1 = null;
    }
  }
  
  public void a(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.app.a().createEntityManager().remove(paramQIMFollwerAdd);
  }
  
  public void a(SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if ((paramSysSuspiciousMsg != null) && (this.em != null) && (this.em.isOpen()))
    {
      this.em.persistOrReplace(paramSysSuspiciousMsg);
      this.dc.put(Long.valueOf(paramSysSuspiciousMsg.uin), paramSysSuspiciousMsg);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "updateOrInsertSysSuspiciousMsg " + paramSysSuspiciousMsg.uin + " " + paramSysSuspiciousMsg.time);
      }
    }
  }
  
  public void a(ysf.a parama)
  {
    synchronized (this.D)
    {
      if (!this.D.contains(parama)) {
        this.D.add(parama);
      }
      return;
    }
  }
  
  /* Error */
  public void aF(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 85	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 86	java/util/ArrayList:<init>	()V
    //   9: astore 7
    //   11: aload_0
    //   12: getfield 176	ysf:jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;
    //   15: invokevirtual 971	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:bV	()Ljava/util/ArrayList;
    //   18: astore 11
    //   20: aload_0
    //   21: invokevirtual 974	ysf:bN	()Ljava/util/ArrayList;
    //   24: astore 12
    //   26: iload_2
    //   27: bipush 23
    //   29: if_icmpne +323 -> 352
    //   32: iconst_1
    //   33: istore 4
    //   35: new 85	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 86	java/util/ArrayList:<init>	()V
    //   42: astore 8
    //   44: new 85	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 86	java/util/ArrayList:<init>	()V
    //   51: astore 9
    //   53: new 294	java/lang/StringBuilder
    //   56: dup
    //   57: sipush 256
    //   60: invokespecial 975	java/lang/StringBuilder:<init>	(I)V
    //   63: astore 10
    //   65: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +12 -> 80
    //   71: aload 10
    //   73: ldc_w 977
    //   76: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_0
    //   81: getfield 138	ysf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   84: bipush 11
    //   86: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   89: checkcast 174	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp
    //   92: astore 13
    //   94: aload_0
    //   95: aload 13
    //   97: invokevirtual 980	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:Uy	()Z
    //   100: putfield 398	ysf:box	Z
    //   103: aload_0
    //   104: getfield 138	ysf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   107: sipush 217
    //   110: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   113: checkcast 569	com/tencent/mobileqq/flashchat/FlashChatManager
    //   116: astore 14
    //   118: aload_0
    //   119: aload 7
    //   121: aload 13
    //   123: invokespecial 982	ysf:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;)V
    //   126: aload_0
    //   127: iload_1
    //   128: aload 10
    //   130: aload 8
    //   132: iconst_0
    //   133: invokespecial 984	ysf:a	(ZLjava/lang/StringBuilder;Ljava/util/ArrayList;I)I
    //   136: istore_3
    //   137: aload_0
    //   138: aload 12
    //   140: aload 8
    //   142: aload 14
    //   144: invokespecial 986	ysf:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/mobileqq/flashchat/FlashChatManager;)V
    //   147: aload_0
    //   148: aload 11
    //   150: aload 8
    //   152: aload 10
    //   154: invokespecial 988	ysf:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/StringBuilder;)V
    //   157: aload_0
    //   158: invokespecial 990	ysf:Uk	()Z
    //   161: istore 5
    //   163: new 85	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 86	java/util/ArrayList:<init>	()V
    //   170: astore 11
    //   172: aload_0
    //   173: getfield 172	ysf:c	Lachg;
    //   176: invokevirtual 993	achg:aaG	()Z
    //   179: istore 6
    //   181: aload_0
    //   182: iload_2
    //   183: iload 4
    //   185: aload 9
    //   187: aload 10
    //   189: iload 5
    //   191: aload 11
    //   193: aconst_null
    //   194: iload 6
    //   196: invokespecial 995	ysf:a	(IZLjava/util/ArrayList;Ljava/lang/StringBuilder;ZLjava/util/ArrayList;Ljava/util/ArrayList;Z)Ljava/util/ArrayList;
    //   199: astore 12
    //   201: iconst_0
    //   202: istore_1
    //   203: iload 4
    //   205: ifeq +5 -> 210
    //   208: iconst_1
    //   209: istore_1
    //   210: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +42 -> 255
    //   216: ldc 236
    //   218: iconst_2
    //   219: new 294	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 997
    //   229: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: getfield 398	ysf:box	Z
    //   236: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   239: ldc_w 999
    //   242: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload_1
    //   246: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   249: invokevirtual 419	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_0
    //   256: iload 4
    //   258: aload 9
    //   260: aload 10
    //   262: aload 12
    //   264: iload_1
    //   265: aconst_null
    //   266: invokespecial 1001	ysf:a	(ZLjava/util/ArrayList;Ljava/lang/StringBuilder;Ljava/util/ArrayList;ZLjava/util/ArrayList;)Ljava/util/ArrayList;
    //   269: astore 13
    //   271: aload_0
    //   272: getfield 138	ysf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: invokestatic 845	yqv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lyqv;
    //   278: invokevirtual 1004	yqv:th	()I
    //   281: istore_2
    //   282: aload_0
    //   283: aload 7
    //   285: iload_2
    //   286: invokespecial 1006	ysf:x	(Ljava/util/ArrayList;I)V
    //   289: aload_0
    //   290: aload 7
    //   292: aload 8
    //   294: iload_3
    //   295: aload 12
    //   297: iload 6
    //   299: aload 13
    //   301: iload_2
    //   302: invokespecial 1008	ysf:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;ILjava/util/ArrayList;ZLjava/util/ArrayList;I)V
    //   305: aload_0
    //   306: aload 7
    //   308: iload 4
    //   310: aload 9
    //   312: iload 5
    //   314: aload 12
    //   316: iload 6
    //   318: invokespecial 1010	ysf:a	(Ljava/util/ArrayList;ZLjava/util/ArrayList;ZLjava/util/ArrayList;Z)V
    //   321: aload_0
    //   322: aload 7
    //   324: iload 4
    //   326: aload 9
    //   328: aload 10
    //   330: aload 11
    //   332: iload 6
    //   334: invokespecial 1012	ysf:a	(Ljava/util/ArrayList;ZLjava/util/ArrayList;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Z)V
    //   337: aload_0
    //   338: aload 7
    //   340: invokespecial 1014	ysf:de	(Ljava/util/ArrayList;)V
    //   343: aload_0
    //   344: aload 7
    //   346: putfield 88	ysf:rk	Ljava/util/ArrayList;
    //   349: aload_0
    //   350: monitorexit
    //   351: return
    //   352: iconst_0
    //   353: istore 4
    //   355: goto -320 -> 35
    //   358: astore 7
    //   360: aload_0
    //   361: monitorexit
    //   362: aload 7
    //   364: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	ysf
    //   0	365	1	paramBoolean	boolean
    //   0	365	2	paramInt	int
    //   136	159	3	i	int
    //   33	321	4	bool1	boolean
    //   161	152	5	bool2	boolean
    //   179	154	6	bool3	boolean
    //   9	336	7	localArrayList1	ArrayList
    //   358	5	7	localObject1	Object
    //   42	251	8	localArrayList2	ArrayList
    //   51	276	9	localArrayList3	ArrayList
    //   63	266	10	localStringBuilder	StringBuilder
    //   18	313	11	localArrayList4	ArrayList
    //   24	291	12	localArrayList5	ArrayList
    //   92	208	13	localObject2	Object
    //   116	27	14	localFlashChatManager	FlashChatManager
    // Exception table:
    //   from	to	target	type
    //   2	26	358	finally
    //   35	80	358	finally
    //   80	201	358	finally
    //   210	255	358	finally
    //   255	349	358	finally
  }
  
  public void addObserver(Observer paramObserver)
  {
    super.addObserver(paramObserver);
  }
  
  public void b(QIMFollwerAdd paramQIMFollwerAdd)
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localEntityManager.persistOrReplace(paramQIMFollwerAdd);
    localEntityManager.close();
    cln();
    this.app.cLO();
  }
  
  public void b(ysf.a parama)
  {
    synchronized (this.D)
    {
      this.D.remove(parama);
      return;
    }
  }
  
  public void b(ytq paramytq)
  {
    long l1 = anzd.a().p(this.app);
    Object localObject = this.app.b().a(acbn.bkJ, 0, l1).iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while ((localMessageRecord.isread) || (!(localMessageRecord instanceof MessageForSystemMsg)));
    for (localObject = new ytq((MessageForSystemMsg)localMessageRecord);; localObject = null)
    {
      if (localObject != null)
      {
        ((ytq)localObject).Kz = paramytq.Kz;
        ((ytq)localObject).message = paramytq.message;
        b((ytv)localObject);
        setChanged();
        notifyObservers(localObject);
      }
      for (;;)
      {
        clp();
        return;
        clr();
      }
    }
  }
  
  public ArrayList<QIMFollwerAdd> bN()
  {
    return (ArrayList)this.app.a().createEntityManager().query(QIMFollwerAdd.class);
  }
  
  public ArrayList<ytv> bO()
  {
    return (ArrayList)this.rk.clone();
  }
  
  public List<Object> cR()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = bO().iterator();
    int i = 0;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (ytv)localIterator.next();
      if ((localObject != null) && (!((ytv)localObject).isReaded())) {
        if ((localObject instanceof ytq))
        {
          i += 1;
        }
        else if ((localObject instanceof yto))
        {
          localObject = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.cV();
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.addAll((Collection)localObject);
          }
        }
        else if ((localObject instanceof ytp))
        {
          localArrayList.add(localObject);
        }
        else
        {
          localArrayList.add(localObject);
          QLog.d("NewFriendManager", 1, "getAllUnreadMsg unexpected nfm = " + localObject);
        }
      }
    }
    localArrayList.addAll(bP());
    if (localArrayList.size() > 0) {}
    try
    {
      Collections.sort(localArrayList, this.F);
      if (QLog.isColorLevel())
      {
        QLog.d("NewFriendManager", 2, "getAllUnreadMsg size = " + localArrayList.size() + ",unReadSysMsgCountInCache = " + i);
        if (localArrayList.size() > 0)
        {
          localIterator = localArrayList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              return localArrayList;
            }
            localObject = localIterator.next();
            if (!(localObject instanceof PhoneContact)) {
              break;
            }
            QLog.d("NewFriendManager", 2, "getAllUnreadMsg PhoneContact time  = " + ((PhoneContact)localObject).lastScanTime);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("NewFriendManager", 1, "getAllUnreadMsg sort exception ", localException);
        continue;
        if ((localObject instanceof ytq)) {
          QLog.d("NewFriendManager", 2, "getAllUnreadMsg FriendSystemMessage time  = " + ((ytq)localObject).Kz * 1000L);
        } else if ((localObject instanceof ytp)) {
          QLog.d("NewFriendManager", 2, "getAllUnreadMsg ContactMatchMessage time  = " + ((ytp)localObject).Kz * 1000L);
        }
      }
    }
    return localArrayList;
  }
  
  public List<SysSuspiciousMsg> cS()
  {
    Object localObject1 = null;
    Object localObject2;
    if (!this.boB)
    {
      localObject2 = this.dc.values();
      if (localObject2 != null) {
        localObject1 = new ArrayList((Collection)localObject2);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        Collections.sort((List)localObject1, this.E);
      }
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("getAllSysSuspiciousMsg ").append(this.boB).append(" ");
        if (localObject1 == null) {
          break label197;
        }
      }
      label197:
      for (localObject2 = Integer.valueOf(((List)localObject1).size());; localObject2 = "null")
      {
        QLog.i("NewFriendManager", 2, localObject2);
        return localObject1;
        if ((this.em == null) || (!this.em.isOpen())) {
          break label204;
        }
        localObject1 = this.em.query(SysSuspiciousMsg.class);
        this.dc.clear();
        if (localObject1 != null)
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SysSuspiciousMsg)((Iterator)localObject2).next();
            this.dc.put(Long.valueOf(((SysSuspiciousMsg)localObject3).uin), localObject3);
          }
        }
        this.boB = false;
        break;
      }
      label204:
      localObject1 = null;
    }
  }
  
  public void clm()
  {
    this.boy = false;
    this.app.getPreferences().edit().putBoolean("contact_guide_user_close", true).putInt("new_friend_show_count_after_user_close", 0).apply();
  }
  
  public void cln()
  {
    AI(true);
    clv();
  }
  
  public void clp()
  {
    int i = xq();
    bQ();
    this.app.runOnUiThread(new NewFriendManager.5(this, i));
  }
  
  public void clq()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      clp();
      return;
    }
    ThreadManager.postImmediately(new NewFriendManager.6(this), null, false);
  }
  
  public void clr()
  {
    if (this.app == null) {}
    acxw localacxw;
    RecentUser localRecentUser;
    do
    {
      return;
      localacxw = this.app.a().a();
      localRecentUser = localacxw.b(acbn.bkA, 4000);
    } while (localRecentUser == null);
    localacxw.f(localRecentUser);
  }
  
  public void cls()
  {
    this.mHandler.sendEmptyMessage(3);
  }
  
  public void clt()
  {
    this.mHandler.sendEmptyMessage(5);
  }
  
  public void clu()
  {
    this.mHandler.sendEmptyMessage(8);
  }
  
  public void clw()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "initNewFriendList hasInitNewFriendList: " + this.boC);
    }
    if (this.boC) {}
    do
    {
      return;
      this.boC = true;
      ??? = BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).getString("new_friend_list", "");
    } while (TextUtils.isEmpty((CharSequence)???));
    String[] arrayOfString = ((String)???).split("#");
    for (;;)
    {
      synchronized (this.aI)
      {
        int j = arrayOfString.length;
        if (i < j)
        {
          if (!TextUtils.isEmpty(arrayOfString[i])) {
            this.aI.add(arrayOfString[i]);
          }
        }
        else {
          return;
        }
      }
      i += 1;
    }
  }
  
  public void clx()
  {
    Object localObject = (ajdo)this.app.getManager(11);
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    int i = ((ajdo)localObject).xy();
    if ((i == 1) || (i == 5))
    {
      i = localSharedPreferences.getInt("system_msg_list_showcount", 0) + 1;
      if (i <= 3)
      {
        this.bow = true;
        localSharedPreferences.edit().putInt("system_msg_list_showcount", i).apply();
      }
    }
    for (;;)
    {
      if (!this.bow) {
        break label161;
      }
      this.boy = false;
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", 0).putBoolean("contact_guide_user_close", false).apply();
      return;
      this.bow = false;
      break;
      this.bow = false;
      localSharedPreferences.edit().putInt("system_msg_list_showcount", 0).apply();
    }
    label161:
    boolean bool = localSharedPreferences.getBoolean("contact_guide_user_close", false);
    i = localSharedPreferences.getInt("new_friend_show_count_after_user_close", 0);
    localObject = a();
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, String.format("updateBindContactGuideState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(((aelc)localObject).bUU), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(((aelc)localObject).totalCount) }));
    }
    if ((((aelc)localObject).bUU) && ((!bool) || (i >= ((aelc)localObject).totalCount)))
    {
      this.boy = true;
      localSharedPreferences.edit().putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
      return;
    }
    if (bool) {
      localSharedPreferences.edit().putInt("new_friend_show_count_after_user_close", i + 1).apply();
    }
    this.boy = false;
  }
  
  public void cly()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendManager", 2, "clearAllSysSuspiciousCache ");
    }
    if (!this.dc.isEmpty()) {
      this.dc.clear();
    }
    this.boB = true;
  }
  
  public void clz()
  {
    this.dc.clear();
    if ((this.em != null) && (this.em.isOpen()))
    {
      boolean bool = this.em.drop(SysSuspiciousMsg.class);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "clearAllSysSuspiciousMsg " + bool);
      }
    }
  }
  
  public void dN(String paramString1, String paramString2)
  {
    if (!H(paramString2, -2023)) {
      y(paramString1, paramString2, -2015);
    }
  }
  
  public void dO(String paramString1, String paramString2)
  {
    if (!H(paramString2, -2015)) {
      y(paramString1, paramString2, -2023);
    }
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    try
    {
      super.deleteObserver(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void gq(long paramLong)
  {
    SysSuspiciousMsg localSysSuspiciousMsg = (SysSuspiciousMsg)this.dc.remove(Long.valueOf(paramLong));
    if ((this.em != null) && (this.em.isOpen()))
    {
      if (localSysSuspiciousMsg != null) {
        break label114;
      }
      localSysSuspiciousMsg = (SysSuspiciousMsg)this.em.find(SysSuspiciousMsg.class, paramLong);
    }
    label114:
    for (;;)
    {
      boolean bool = false;
      if (localSysSuspiciousMsg != null) {
        bool = this.em.remove(localSysSuspiciousMsg);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "deleteSysSuspiciousMsg " + paramLong + " " + bool);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "HandleMessage what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 4: 
    case 6: 
    case 7: 
    default: 
      return true;
    case 1: 
      AI(true);
      return true;
    case 2: 
      cln();
      return true;
    case 3: 
      this.app.b().a(acbn.bkJ, 0, true, true);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.clu();
      clo();
      this.jdField_a_of_type_Acjf.cLk();
      anzd.a().M(this.app, 0);
      this.app.a().a().cOc();
      cln();
      return true;
    case 5: 
      this.app.b().a(acbn.bkJ, 0, true, true);
      anzd.a().M(this.app, 0);
      this.app.a().a().cOc();
      this.jdField_a_of_type_Acjf.cLk();
      cln();
      return true;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.clu();
    cln();
    return true;
  }
  
  public boolean ig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool;
    synchronized (this.aI)
    {
      bool = this.aI.remove(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.aI.iterator();
      if (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
    return bool;
  }
  
  public boolean ih(String paramString)
  {
    synchronized (this.aI)
    {
      boolean bool = this.aI.contains(paramString);
      return bool;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onDestroy");
    }
    this.rk.clear();
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.jdField_a_of_type_Ajdo$a);
    this.app.removeObserver(this.l);
  }
  
  public void x(ArrayList<SysSuspiciousMsg> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "updateSuspiciousMsgListFromServer " + paramBoolean + " " + paramArrayList.size() + " " + paramArrayList.toString());
      }
      Object localObject = cS();
      int i;
      if (localObject != null)
      {
        i = paramArrayList.size();
        if ((i == 0) && (paramBoolean)) {
          clz();
        }
      }
      for (;;)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          a((SysSuspiciousMsg)paramArrayList.next());
        }
        if (i > 0)
        {
          Collections.sort(paramArrayList, this.E);
          SysSuspiciousMsg localSysSuspiciousMsg1 = (SysSuspiciousMsg)paramArrayList.get(0);
          SysSuspiciousMsg localSysSuspiciousMsg2 = (SysSuspiciousMsg)paramArrayList.get(paramArrayList.size() - 1);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SysSuspiciousMsg localSysSuspiciousMsg3 = (SysSuspiciousMsg)((Iterator)localObject).next();
            if (!paramBoolean)
            {
              if ((localSysSuspiciousMsg3.time <= localSysSuspiciousMsg1.time) && (localSysSuspiciousMsg3.time >= localSysSuspiciousMsg2.time)) {
                gq(localSysSuspiciousMsg3.uin);
              }
            }
            else if (localSysSuspiciousMsg3.time <= localSysSuspiciousMsg1.time) {
              gq(localSysSuspiciousMsg3.uin);
            }
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("NewFriendManager", 2, "updateSuspiciousMsgListFromServer local empty");
          }
        }
      }
    }
  }
  
  public int xn()
  {
    return this.caX;
  }
  
  public int xo()
  {
    return this.caY;
  }
  
  public int xp()
  {
    return anzd.a().ac(this.app);
  }
  
  public int xq()
  {
    int k = anzd.a().ac(this.app);
    Iterator localIterator = bO().iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      ytv localytv = (ytv)localIterator.next();
      if ((localytv == null) || (localytv.isReaded())) {
        break label158;
      }
      if ((localytv instanceof ytq)) {
        j += 1;
      } else if ((localytv instanceof yto)) {
        i = this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.xv() + i;
      } else {
        i += 1;
      }
    }
    label158:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "getAllUnreadMessageCount|total unread = " + i + ",unReadSysMsgCount = " + k + ",unReadSysMsgCountInCache = " + j);
      }
      return i + k;
    }
  }
  
  public int xr()
  {
    return this.caZ;
  }
  
  public void zj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.aI)
    {
      this.aI.add(paramString);
      paramString = new StringBuilder();
      Iterator localIterator = this.aI.iterator();
      if (localIterator.hasNext())
      {
        paramString.append((String)localIterator.next());
        paramString.append("#");
      }
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", paramString.toString()).apply();
  }
  
  public static abstract interface a
  {
    public abstract void Az(int paramInt);
    
    public abstract void bLU();
    
    public abstract void bLV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysf
 * JD-Core Version:    0.7.0.1
 */