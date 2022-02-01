import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

public class alkm
  extends Observable
  implements Manager
{
  private acfd a = new alkn(this);
  private QQAppInterface app;
  private acdv b = new alko(this);
  
  public alkm(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.a);
    paramQQAppInterface.addObserver(this.b);
  }
  
  public static void C(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int[] arrayOfInt = top.eW;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (k != paramInt) {
        p(paramQQAppInterface, paramString, k);
      }
      i += 1;
    }
  }
  
  public static String E(QQAppInterface paramQQAppInterface)
  {
    try
    {
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      if (paramQQAppInterface == null) {
        return null;
      }
      paramQQAppInterface = localBaseApplication.getSharedPreferences("call_time_use_up", 0).getString(paramQQAppInterface + "_wording", null);
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface) {}
    return null;
  }
  
  private void SS(int paramInt)
  {
    setChanged();
    notifyObservers(Integer.valueOf(paramInt));
    if (a().atJ())
    {
      setChanged();
      notifyObservers(Boolean.valueOf(true));
    }
  }
  
  public static int X(QQAppInterface paramQQAppInterface)
  {
    alkm localalkm = (alkm)paramQQAppInterface.getManager(38);
    if (localalkm != null) {}
    for (int i = localalkm.HD();; i = 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCountWhenCallTabHidden, callUnReadCount[%s], isConversationTabShow[%s], isInCallList[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramQQAppInterface.bJc), Boolean.valueOf(paramQQAppInterface.bJd) }));
      }
      return i;
    }
  }
  
  public static alkm.a a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, QQMessageFacade.Message paramMessage)
  {
    return new alkm.a(paramQQAppInterface, paramString, paramInt1, paramInt2, paramMessage, null);
  }
  
  private QCallRecent a(MessageForVideo paramMessageForVideo)
  {
    int i = 1;
    Object localObject = paramMessageForVideo.frienduin;
    long l = paramMessageForVideo.time;
    QCallRecent localQCallRecent = a().b((String)localObject, paramMessageForVideo.istroop);
    localQCallRecent.uin = ((String)localObject);
    localQCallRecent.type = paramMessageForVideo.istroop;
    localQCallRecent.sendFlag = paramMessageForVideo.issend;
    localQCallRecent.lastCallMsg = aqiu.N(this.app.getApp(), paramMessageForVideo.text);
    if (l > localQCallRecent.lastCallTime)
    {
      localQCallRecent.lastCallTime = l;
      localQCallRecent.isSystemCall = 0;
    }
    if ((localQCallRecent.type == 1000) || (localQCallRecent.type == 1020) || (localQCallRecent.type == 1004)) {
      localQCallRecent.troopUin = paramMessageForVideo.senderuin;
    }
    int j = localQCallRecent.missedCallCount;
    localQCallRecent.missedCallCount = af(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("getMessageToRecentCall, uin[%s], type[%s], count[%s], src[%s]", new Object[] { paramMessageForVideo.frienduin, Integer.valueOf(paramMessageForVideo.istroop), Integer.valueOf(localQCallRecent.missedCallCount), Integer.valueOf(j) }));
    }
    localObject = paramMessageForVideo.msg;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 3)) {
        break label308;
      }
      if (!"1".equals(localObject[3])) {
        break label303;
      }
    }
    label303:
    label308:
    for (localQCallRecent.isVideo = i;; localQCallRecent.isVideo = 1)
    {
      localQCallRecent.isLastCallRealMissed = af(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      localQCallRecent.callType = b(paramMessageForVideo, localQCallRecent.type);
      return localQCallRecent;
      i = 0;
      break;
    }
  }
  
  private QCallRecord a(MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "getMessageToCallRecord message is null");
      }
      return null;
    }
    QCallRecord localQCallRecord = new QCallRecord();
    localQCallRecord.friendUin = paramMessageForVideo.frienduin;
    localQCallRecord.time = paramMessageForVideo.time;
    localQCallRecord.uinType = paramMessageForVideo.istroop;
    localQCallRecord.senderuin = paramMessageForVideo.senderuin;
    localQCallRecord.issend = paramMessageForVideo.issend;
    localQCallRecord.uniseq = paramMessageForVideo.uniseq;
    String str = paramMessageForVideo.msg;
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "getMessageToCallRecord message's msg is null");
      }
      return null;
    }
    String[] arrayOfString = str.split("\\|");
    int i;
    label155:
    Object localObject;
    if ((arrayOfString != null) && (arrayOfString.length > 3)) {
      if ("1".equals(arrayOfString[3]))
      {
        i = 1;
        localQCallRecord.isVideo = i;
        if (arrayOfString.length <= 3) {
          break label506;
        }
        localObject = arrayOfString[0].trim();
      }
    }
    try
    {
      localQCallRecord.state = Integer.parseInt(arrayOfString[1]);
      paramMessageForVideo = (MessageForVideo)localObject;
    }
    catch (Exception paramMessageForVideo)
    {
      for (;;)
      {
        label184:
        if ((str != null) && (str.length() > 0) && (str.charAt(0) == '\026'))
        {
          paramMessageForVideo = (MessageForVideo)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("QCallFacade", 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg is " + str);
            paramMessageForVideo = (MessageForVideo)localObject;
          }
        }
        else
        {
          localQCallRecord.state = 5;
          paramMessageForVideo = (MessageForVideo)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("QCallFacade", 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg byte " + aqft.pk(str));
            paramMessageForVideo = (MessageForVideo)localObject;
          }
        }
      }
    }
    if (((localQCallRecord.state == 0) || (localQCallRecord.state == 2) || (localQCallRecord.state == 24) || (localQCallRecord.state == 46) || (localQCallRecord.state == 47) || (localQCallRecord.state == 48) || (localQCallRecord.state == 57) || (localQCallRecord.state == 9) || (localQCallRecord.state == 15)) && (paramMessageForVideo != null))
    {
      paramMessageForVideo = paramMessageForVideo.split(" ");
      if (paramMessageForVideo != null)
      {
        if (paramMessageForVideo.length <= 1) {
          break label519;
        }
        localQCallRecord.talkTime = paramMessageForVideo[1];
      }
    }
    label301:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getMessageToCallRecord:");
      if (localQCallRecord == null) {
        break label572;
      }
    }
    label519:
    label572:
    for (paramMessageForVideo = localQCallRecord.toString();; paramMessageForVideo = "")
    {
      QLog.d("QCallFacade", 2, paramMessageForVideo);
      return localQCallRecord;
      i = 0;
      break;
      localQCallRecord.isVideo = 1;
      break label155;
      label506:
      paramMessageForVideo = "";
      localQCallRecord.state = 5;
      break label184;
      if (paramMessageForVideo.length != 1) {
        break label301;
      }
      if ((2 == localQCallRecord.state) || (24 == localQCallRecord.state))
      {
        localQCallRecord.state = 12;
        break label301;
      }
      if (localQCallRecord.state != 0) {
        break label301;
      }
      localQCallRecord.state = 12;
      break label301;
    }
  }
  
  private void a(QCallRecent paramQCallRecent, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, String.format("saveRecentCall[%s], [%s]", new Object[] { paramString, paramQCallRecent }));
    }
    a().f(paramQCallRecent);
    if ((top.fv(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      SS(1);
      return;
    }
    SS(0);
  }
  
  private int af(String paramString, int paramInt)
  {
    List localList = s(paramString, paramInt);
    int j;
    if ((localList == null) || (localList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount count 0, uin[%s], type[%s]]", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      j = 0;
    }
    int i;
    do
    {
      return j;
      j = 0;
      int k;
      for (i = 0; j < localList.size(); i = k)
      {
        QCallRecord localQCallRecord = (QCallRecord)localList.get(j);
        k = i;
        if (localQCallRecord != null)
        {
          k = i;
          if (localQCallRecord.type == QCallRecord.TYPE_REALRECORD)
          {
            if (!localQCallRecord.isMissCall()) {
              break;
            }
            k = i + 1;
          }
        }
        j += 1;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount, uin[%s], type[%s], count[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i) }));
    return i;
  }
  
  private boolean af(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "checkIsRealMissed friendUin:" + paramString + ",uinType:" + paramInt);
    }
    paramString = s(paramString, paramInt);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QCallFacade", 2, "checkIsRealMissed CallRecord count 0");
        bool2 = bool1;
      }
      return bool2;
    }
    paramInt = 0;
    for (;;)
    {
      bool1 = bool2;
      if (paramInt < paramString.size())
      {
        QCallRecord localQCallRecord = (QCallRecord)paramString.get(paramInt);
        if ((localQCallRecord == null) || (localQCallRecord.type != QCallRecord.TYPE_REALRECORD)) {
          break label196;
        }
        if (!localQCallRecord.isMissCall())
        {
          bool1 = bool2;
          if (localQCallRecord.state != 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QCallFacade", 2, "checkIsRealMissed ret:" + bool1);
      return bool1;
      label196:
      paramInt += 1;
    }
  }
  
  private void b(QCallRecent paramQCallRecent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "save " + paramQCallRecent);
    }
    a().b(paramQCallRecent);
    if ((top.fv(paramQCallRecent.type)) && (paramQCallRecent.state == 5))
    {
      SS(1);
      return;
    }
    SS(0);
  }
  
  public static boolean by(QQAppInterface paramQQAppInterface)
  {
    try
    {
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      if (paramQQAppInterface == null) {
        return false;
      }
      boolean bool = localBaseApplication.getSharedPreferences("call_time_use_up", 0).getBoolean(paramQQAppInterface + "_show_flag", false);
      return bool;
    }
    catch (Exception paramQQAppInterface) {}
    return false;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    try
    {
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      if (paramQQAppInterface == null) {
        return;
      }
      localBaseApplication.getSharedPreferences("call_time_use_up", 0).edit().putBoolean(paramQQAppInterface + "_show_flag", paramBoolean).putString(paramQQAppInterface + "_wording", paramString).commit();
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  private void eX()
  {
    if (this.app != null) {
      this.app.a().a().init();
    }
  }
  
  private long n(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    return localBaseApplication.getSharedPreferences("voice_tab_time", 0).getLong(paramQQAppInterface, 0L);
  }
  
  public static boolean p(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = (alkm)paramQQAppInterface.getManager(38);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.ad(paramString, paramInt) > 0))
    {
      paramQQAppInterface.fC(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public static void q(QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public int HD()
  {
    if (this.app == null) {}
    do
    {
      do
      {
        do
        {
          return 0;
        } while (a().fO() == null);
        localObject1 = this.app.a().a();
      } while (localObject1 == null);
      localObject1 = ((acxw)localObject1).q(false);
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    Object localObject1 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject1).next();
      if (localRecentUser.getType() == 3000)
      {
        Object localObject2 = (acdu)this.app.getManager(53);
        DiscussionMemberInfo localDiscussionMemberInfo = ((acdu)localObject2).a(localRecentUser.uin, this.app.getCurrentAccountUin());
        if ((localDiscussionMemberInfo != null) && ((localDiscussionMemberInfo.flag & 0x1) == 1))
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, 开启了免打扰, disc[%s]", new Object[] { localRecentUser.uin }));
          continue;
        }
        localObject2 = ((acdu)localObject2).a(localRecentUser.uin);
        if ((localObject2 == null) || (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()) || (((DiscussionInfo)localObject2).isHidden()))
        {
          if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
            continue;
          }
          QLog.i("QCallFacade", 2, "getMissCallTotalCount, invalid discussion, uin[" + localRecentUser.uin + "]");
          QLog.i("QCallFacade", 2, "getMissCallTotalCount, invalid discussion, uin[" + localRecentUser.uin + "], unread[" + ad(localRecentUser.uin, localRecentUser.getType()) + "]");
          continue;
        }
      }
      if ((localRecentUser.getType() != 0) || ((!FriendsStatusUtil.g(localRecentUser.uin, this.app)) && (!wvo.a(localRecentUser.uin, localRecentUser.getType(), this.app)))) {
        i = ad(localRecentUser.uin, localRecentUser.getType()) + i;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, count[%s]", new Object[] { Integer.valueOf(i) }));
    }
    return i;
  }
  
  public int HE()
  {
    Object localObject = a().fO();
    if (localObject == null) {
      return 0;
    }
    long l2 = n(this.app);
    localObject = ((List)localObject).iterator();
    int i = 0;
    long l1;
    if (((Iterator)localObject).hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        label76:
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall())) {
          break label109;
        }
        i += 1;
      }
    }
    label109:
    for (;;)
    {
      break;
      l1 = l2;
      break label76;
      return i;
    }
  }
  
  public void NR(boolean paramBoolean)
  {
    a().NR(paramBoolean);
  }
  
  public void Op(String paramString)
  {
    fD(paramString, 0);
    fD(paramString, 1000);
    fD(paramString, 1020);
    fD(paramString, 1004);
    fD(paramString, 1024);
    fD(paramString, 8);
  }
  
  @Deprecated
  public void Oq(String paramString)
  {
    int k = 0;
    Object localObject2 = (ajdo)this.app.getManager(11);
    Object localObject1 = (acff)this.app.getManager(51);
    int i;
    label57:
    int j;
    if (localObject2 == null)
    {
      localObject2 = null;
      if (localObject2 != null)
      {
        if (TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {
          break label152;
        }
        i = 1;
        if ((i == 0) || (((PhoneContact)localObject2).uin.equals("0"))) {
          break label157;
        }
        j = 1;
        label77:
        if ((j != 0) && (localObject1 != null)) {
          break label162;
        }
        localObject1 = null;
        label89:
        if ((localObject1 == null) || (!((Friends)localObject1).isFriend())) {
          break label177;
        }
        j = 1;
        label104:
        if (j == 0) {
          break label182;
        }
        localObject1 = ((PhoneContact)localObject2).uin;
        i = k;
      }
    }
    for (;;)
    {
      long l = anaz.gQ();
      b((String)localObject1, i, ((PhoneContact)localObject2).contactID, l, paramString);
      return;
      localObject2 = ((ajdo)localObject2).c(paramString);
      break;
      label152:
      i = 0;
      break label57;
      label157:
      j = 0;
      break label77;
      label162:
      localObject1 = ((acff)localObject1).e(((PhoneContact)localObject2).uin);
      break label89;
      label177:
      j = 0;
      break label104;
      label182:
      if (i != 0)
      {
        localObject1 = ((PhoneContact)localObject2).mobileCode;
        i = 1006;
      }
      else
      {
        localObject1 = ((PhoneContact)localObject2).mobileNo;
        i = 56938;
      }
    }
  }
  
  public void U(int paramInt, String paramString1, String paramString2)
  {
    c(paramInt, paramString1, "-1", paramString2, 2);
  }
  
  public alkq a()
  {
    eX();
    if (this.app != null) {
      return this.app.a().a();
    }
    return null;
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    return a().c(paramString, paramInt);
  }
  
  public List<QCallRecent> a(alkq.a parama)
  {
    if (((atdc)this.app.getManager(746)).Og() == 0)
    {
      Object localObject = new alkp(this, parama);
      parama = new ArrayList();
      localObject = a().a((alkq.a)localObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
          if (localQCallRecent.type == 3000)
          {
            if ((TextUtils.isEmpty(localQCallRecent.pstnInfo)) || ((!TextUtils.isEmpty(localQCallRecent.pstnInfo)) && (localQCallRecent.pstnInfo.equals("[]")))) {
              parama.add(localQCallRecent);
            }
          }
          else if (localQCallRecent.callType != 2) {
            parama.add(localQCallRecent);
          }
        }
      }
      return parama;
    }
    return a().a(parama);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "updateDissCall-->discussid=" + paramLong1 + " friendUin=" + paramLong2 + " b=" + paramBoolean1 + " time=" + paramLong3 + " isSend=" + paramBoolean2);
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    while ((((acdu)this.app.getManager(53)).a(String.valueOf(paramLong1)) == null) || (!this.app.getCurrentAccountUin().equals(String.valueOf(paramLong2)))) {
      return;
    }
    QCallRecent localQCallRecent = a().b(String.valueOf(paramLong1), 3000);
    localQCallRecent.lastCallTime = anaz.gQ();
    if (paramBoolean1) {
      localQCallRecent.state = 1;
    }
    for (;;)
    {
      a(localQCallRecent, "when_updateDissCall");
      return;
      localQCallRecent.state = 3;
      localQCallRecent.time = paramLong3;
      if (paramLong3 > 0L)
      {
        localQCallRecord = new QCallRecord();
        localQCallRecord.friendUin = String.valueOf(paramLong1);
        localQCallRecord.isVideo = 0;
        localQCallRecord.time = anaz.gQ();
        localQCallRecord.talkTime = String.valueOf(paramLong3);
        localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
        localQCallRecord.uinType = 3000;
        if (paramBoolean2) {
          localQCallRecord.state = 4;
        }
        for (localQCallRecord.issend = 1;; localQCallRecord.issend = 0)
        {
          a().a(localQCallRecord);
          break;
          localQCallRecord.state = 3;
        }
      }
      QCallRecord localQCallRecord = new QCallRecord();
      localQCallRecord.friendUin = String.valueOf(paramLong1);
      localQCallRecord.issend = 1;
      localQCallRecord.isVideo = 0;
      localQCallRecord.time = anaz.gQ();
      localQCallRecord.type = QCallRecord.TYPE_REALRECORD;
      localQCallRecord.state = 4;
      localQCallRecord.uinType = 3000;
      a().a(localQCallRecord);
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo)
  {
    paramMessageForVideo.parse();
    paramMessageForVideo = a(paramMessageForVideo);
    a(paramMessageForVideo, "when_insertMessage");
    if (this.app != null)
    {
      if ((paramMessageForVideo == null) || (paramMessageForVideo.type != 3000)) {
        break label146;
      }
      localQQAppInterface = this.app;
      if (!paramMessageForVideo.isSend()) {
        break label139;
      }
    }
    label139:
    for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "0X8004067", "0X8004067", 0, 0, paramMessageForVideo, "", "", "");
      if ((this.app.bIS) && (this.app.bJc) && (this.app.bJd)) {
        kH(anaz.gQ());
      }
      this.app.ba(true, 0);
      this.app.cLO();
      return;
    }
    label146:
    QQAppInterface localQQAppInterface = this.app;
    if (paramMessageForVideo.isSend()) {}
    for (paramMessageForVideo = "1";; paramMessageForVideo = "0")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_count", 0, 0, paramMessageForVideo, "", "", "");
      break;
    }
  }
  
  public void a(MessageForVideo paramMessageForVideo, boolean paramBoolean)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "insertCallRecord updateRecentMissedCallCount: msg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "insertCallRecord updateRecentMissedCallCount:" + paramBoolean + ", msg :" + paramMessageForVideo.toString());
    }
    Object localObject = a(paramMessageForVideo);
    a().a((QCallRecord)localObject);
    if (paramBoolean)
    {
      localObject = a().c(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
      if (localObject != null)
      {
        ((QCallRecent)localObject).missedCallCount = af(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        if (QLog.isColorLevel()) {
          QLog.d("QCallFacade", 2, "insertCallRecord QCallRecent update MissCallCount" + ((QCallRecent)localObject).missedCallCount);
        }
        ((QCallRecent)localObject).isLastCallRealMissed = af(paramMessageForVideo.frienduin, paramMessageForVideo.istroop);
        a((QCallRecent)localObject, "when_insertCallRecord");
      }
    }
    setChanged();
    notifyObservers(s(paramMessageForVideo.frienduin, paramMessageForVideo.istroop));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    QLog.d("QCallFacade", 1, String.format("updateDoubleCallStatus, peerUin[%s], uinType[%s], extraType[%s], bindType[%s], bindId[%s], status[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2, Integer.valueOf(paramInt4) }));
    if ((paramInt1 == 1011) || (paramInt1 == -1)) {}
    do
    {
      acff localacff;
      do
      {
        do
        {
          return;
        } while (this.app == null);
        if (paramInt1 != 0) {
          break;
        }
        localacff = (acff)this.app.getManager(51);
      } while ((localacff != null) && (!localacff.isFriend(paramString1)));
    } while ((paramString1 == null) || ((paramInt1 == 3000) && (((acdu)this.app.getManager(53)).a(paramString1) == null)));
    paramString1 = a().b(paramString1, paramInt1);
    if ((paramInt4 == 6) || (paramInt4 == 5) || (paramString1.isMissedCall())) {
      paramString1.lastCallTime = anaz.gQ();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "updateDoubleCallStatus lastCallTime = " + paramString1.lastCallTime);
    }
    paramString1.state = paramInt4;
    paramString1.extraType = paramInt2;
    paramString1.bindId = paramString2;
    paramString1.bindType = paramInt3;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1.callType = 1;
    }
    if (paramInt4 == 0)
    {
      a(paramString1, "when_updateDoubleCallStatus");
      return;
    }
    b(paramString1);
  }
  
  public int ac(String paramString, int paramInt)
  {
    int i = 0;
    paramString = a().c(paramString, paramInt);
    paramInt = i;
    if (paramString != null) {
      paramInt = paramString.state;
    }
    return paramInt;
  }
  
  public int ad(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.isMissedCall()))
    {
      long l2 = n(this.app);
      long l1 = l2;
      if (paramString.readTime > l2) {
        l1 = paramString.readTime;
      }
      return h(paramString.uin, paramString.type, l1);
    }
    return 0;
  }
  
  public int ae(String paramString, int paramInt)
  {
    Object localObject1 = a().fO();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount fail, friendUin[%s], uinType[%s]", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      return 0;
    }
    long l2 = n(this.app);
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    long l1;
    label132:
    int j;
    int i;
    label176:
    QCallRecord localQCallRecord;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
        if ((paramString.equals(((QCallRecent)localObject2).uin)) && (paramInt == ((QCallRecent)localObject2).type)) {
          if (((QCallRecent)localObject2).readTime > l2)
          {
            l1 = ((QCallRecent)localObject2).readTime;
            if ((((QCallRecent)localObject2).lastCallTime <= l1) || (!((QCallRecent)localObject2).isMissedCall()) || (((QCallRecent)localObject2).uin == null)) {
              break label230;
            }
            localObject2 = a().s(paramString, paramInt);
            j = 0;
            i = k;
            k = i;
            if (j >= ((List)localObject2).size()) {
              continue;
            }
            localQCallRecord = (QCallRecord)((List)localObject2).get(j);
            if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
              break label232;
            }
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label176;
      l1 = l2;
      break label132;
      label230:
      break;
      label232:
      k = i;
      if (!localQCallRecord.isMissCall()) {
        break;
      }
      if (localQCallRecord.time > l1)
      {
        i += 1;
        continue;
        return k;
      }
    }
  }
  
  public void az(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, 0, 0, null, paramInt2);
  }
  
  public int b(MessageRecord paramMessageRecord, int paramInt)
  {
    int i = 0;
    if (paramMessageRecord.msgtype == -2046) {
      i = 2;
    }
    while ((paramMessageRecord.msgtype != -2026) && (!top.fv(paramInt))) {
      return i;
    }
    return 1;
  }
  
  @Deprecated
  public void b(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    alkq localalkq = a();
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).uinType = paramInt1;
    ((QCallRecord)localObject).state = 58;
    ((QCallRecord)localObject).contactId = paramInt2;
    ((QCallRecord)localObject).friendUin = paramString1;
    ((QCallRecord)localObject).time = paramLong;
    localalkq.a((QCallRecord)localObject);
    localObject = localalkq.b(paramString1, paramInt1);
    ((QCallRecent)localObject).uin = paramString1;
    ((QCallRecent)localObject).type = paramInt1;
    if (paramLong > ((QCallRecent)localObject).lastCallTime) {
      ((QCallRecent)localObject).lastCallTime = paramLong;
    }
    ((QCallRecent)localObject).contactId = paramInt2;
    ((QCallRecent)localObject).isSystemCall = 1;
    ((QCallRecent)localObject).sendFlag = 1;
    ((QCallRecent)localObject).phoneNumber = paramString2;
    localalkq.f((QCallRecent)localObject);
    notifyObservers(s(paramString1, paramInt1));
    setChanged();
  }
  
  public void c(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    i = 2;
    if (QLog.isColorLevel()) {
      QLog.e("QCallFacade", 2, String.format("addMissCallMsg, uinType[%s], discussId[%s], peerUin[%s], senderUin[%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3 }));
    }
    if (this.app == null) {}
    while ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        continue;
        i = 1;
      }
    }
    if (paramInt1 == 3000) {}
    for (;;)
    {
      paramString2 = new QCallRecord();
      paramString2.friendUin = paramString1;
      paramString2.issend = 0;
      paramString2.isVideo = 0;
      paramString2.time = anaz.gQ();
      paramString2.type = QCallRecord.TYPE_REALRECORD;
      paramString2.state = paramInt2;
      paramString2.uinType = paramInt1;
      a().a(paramString2);
      paramString2 = a().b(paramString1, paramInt1);
      paramString2.uin = paramString1;
      paramString2.lastCallTime = anaz.gQ();
      paramString2.type = paramInt1;
      paramString2.sendFlag = 0;
      paramString2.troopUin = paramString1;
      paramString2.memberCount = this.app.a().d(i, l1);
      paramString2.state = paramInt2;
      paramString2.missedCallCount = af(paramString1, paramInt1);
      paramString2.senderUin = paramString3;
      paramString2.isLastCallRealMissed = af(paramString1, paramInt1);
      paramString2.isSystemCall = 0;
      a(paramString2, "when_addMissCallMsg");
      this.app.cLO();
      return;
      if (paramInt1 == 1)
      {
        i = 1;
      }
      else
      {
        if (paramInt1 != 0) {
          break;
        }
        i = 3;
      }
    }
  }
  
  public void c(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent == null) {
      return;
    }
    a().d(paramQCallRecent);
    SS(-1);
  }
  
  public void d(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QCallFacade", 2, String.format("addQCallRecent, issend[%s], discussId[%s], senderUin[%s] , pstnUserInfo[%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString1, paramString2 }));
    }
    QCallRecent localQCallRecent = a().b(String.valueOf(paramLong), 3000);
    localQCallRecent.uin = String.valueOf(paramLong);
    localQCallRecent.lastCallTime = anaz.gQ();
    localQCallRecent.type = 3000;
    localQCallRecent.sendFlag = paramInt;
    localQCallRecent.troopUin = String.valueOf(paramLong);
    localQCallRecent.memberCount = this.app.a().d(2, paramLong);
    localQCallRecent.missedCallCount = af(String.valueOf(paramLong), 3000);
    if (localQCallRecent.state != 1) {
      if (paramInt != 1) {
        break label202;
      }
    }
    label202:
    for (localQCallRecent.state = 4;; localQCallRecent.state = 0)
    {
      localQCallRecent.pstnInfo = paramString2;
      localQCallRecent.senderUin = paramString1;
      localQCallRecent.isLastCallRealMissed = af(String.valueOf(paramLong), 3000);
      localQCallRecent.isSystemCall = 0;
      a(localQCallRecent, "when_addQCallRecent");
      return;
    }
  }
  
  public ArrayList<MessageRecord> dq()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().fO();
    if (localObject == null) {
      return localArrayList;
    }
    long l2 = n(this.app);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
      long l1;
      label84:
      int i;
      label131:
      QCallRecord localQCallRecord;
      if (localQCallRecent.readTime > l2)
      {
        l1 = localQCallRecent.readTime;
        if ((localQCallRecent.lastCallTime <= l1) || (!localQCallRecent.isMissedCall()) || (localQCallRecent.uin == null)) {
          break label177;
        }
        List localList = a().s(localQCallRecent.uin, localQCallRecent.type);
        i = 0;
        if (i < localList.size())
        {
          localQCallRecord = (QCallRecord)localList.get(i);
          if (localQCallRecord.type != QCallRecord.TYPE_DATE) {
            break label179;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label131;
        break;
        l1 = l2;
        break label84;
        label177:
        break;
        label179:
        if (!localQCallRecord.isMissCall()) {
          break;
        }
        if (localQCallRecord.time > l1)
        {
          if (localQCallRecent.type != 3000) {
            break label291;
          }
          localObject = anbi.d(-2016);
          ((MessageRecord)localObject).msg = this.app.getApp().getString(2131697822);
          ((MessageRecord)localObject).frienduin = localQCallRecent.troopUin;
          ((MessageRecord)localObject).msgtype = -2016;
          ((MessageRecord)localObject).senderuin = "";
          ((MessageRecord)localObject).istroop = localQCallRecent.type;
          ((MessageRecord)localObject).time = localQCallRecord.time;
          localArrayList.add(localObject);
        }
      }
      label291:
      localObject = anbi.d(-2009);
      ((MessageRecord)localObject).frienduin = localQCallRecent.uin;
      ((MessageRecord)localObject).msgtype = -2009;
      if (localQCallRecord.isVideo()) {}
      for (((MessageRecord)localObject).msg = this.app.getApp().getString(2131697823);; ((MessageRecord)localObject).msg = this.app.getApp().getString(2131697821))
      {
        ((MessageRecord)localObject).senderuin = localQCallRecord.senderuin;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "getMissCallMessageRecordList = list size" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void fC(String paramString, int paramInt)
  {
    QCallRecent localQCallRecent = a().c(paramString, paramInt);
    if (localQCallRecent == null) {
      return;
    }
    long l = localQCallRecent.readTime;
    localQCallRecent.readTime = anaz.gQ();
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("updateQCallRecentReadTime, uin[%s], type[%s], readTime[%s], src[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(localQCallRecent.readTime), Long.valueOf(l) }));
    }
    a(localQCallRecent, "when_updateQCallRecentReadTime");
  }
  
  public void fD(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QCallRecent localQCallRecent = a().c(paramString, paramInt);
    if (localQCallRecent != null) {
      c(localQCallRecent);
    }
    fE(paramString, paramInt);
    this.app.cLO();
  }
  
  public void fE(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "clearAllRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    a().fF(paramString, paramInt);
  }
  
  public void g(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a().g(paramString1, paramInt1, paramString2, paramInt2);
  }
  
  public int h(String paramString, int paramInt, long paramLong)
  {
    int k;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount, uin为空, uin[%s], type[%s], time[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      }
      k = 0;
      return k;
    }
    paramString = a().s(paramString, paramInt);
    int i = 0;
    int j = 0;
    for (;;)
    {
      for (;;)
      {
        k = i;
        try
        {
          if (j >= paramString.size()) {
            break;
          }
          QCallRecord localQCallRecord = (QCallRecord)paramString.get(j);
          if (localQCallRecord.type == QCallRecord.TYPE_DATE) {
            break label235;
          }
          k = i;
          if (!localQCallRecord.isMissCall()) {
            break;
          }
          if (localQCallRecord.time <= paramLong) {
            break label235;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("fetchUnReadCount", 4, String.format("getMissCallRecordCount, uinType[%s], qcr.time[%s], time[%s], %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localQCallRecord.time), Long.valueOf(paramLong), localQCallRecord }));
          }
          i += 1;
        }
        catch (Exception paramString)
        {
          k = i;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QCallFacade", 2, "getMissCallRecordCount:" + paramString);
      return i;
      label235:
      j += 1;
    }
  }
  
  public void k(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QCallFacade", 2, "addQCallRecentAndCallRecord issend=" + paramInt + ", discussId=" + paramLong + ", senderUin=" + paramString);
    }
    Object localObject = new QCallRecord();
    ((QCallRecord)localObject).friendUin = String.valueOf(paramLong);
    ((QCallRecord)localObject).issend = paramInt;
    ((QCallRecord)localObject).isVideo = 0;
    ((QCallRecord)localObject).time = anaz.gQ();
    ((QCallRecord)localObject).type = QCallRecord.TYPE_REALRECORD;
    if (paramInt == 1)
    {
      ((QCallRecord)localObject).state = 4;
      ((QCallRecord)localObject).uinType = 3000;
      a().a((QCallRecord)localObject);
      localObject = a().b(String.valueOf(paramLong), 3000);
      ((QCallRecent)localObject).uin = String.valueOf(paramLong);
      ((QCallRecent)localObject).lastCallTime = anaz.gQ();
      ((QCallRecent)localObject).type = 3000;
      ((QCallRecent)localObject).sendFlag = paramInt;
      ((QCallRecent)localObject).troopUin = String.valueOf(paramLong);
      ((QCallRecent)localObject).memberCount = this.app.a().d(2, paramLong);
      ((QCallRecent)localObject).missedCallCount = af(String.valueOf(paramLong), 3000);
      if (paramInt != 1) {
        break label276;
      }
    }
    label276:
    for (((QCallRecent)localObject).state = 4;; ((QCallRecent)localObject).state = 3)
    {
      ((QCallRecent)localObject).senderUin = paramString;
      ((QCallRecent)localObject).isLastCallRealMissed = af(String.valueOf(paramLong), 3000);
      ((QCallRecent)localObject).isSystemCall = 0;
      a((QCallRecent)localObject, "when_addQCallRecentAndCallRecord");
      return;
      ((QCallRecord)localObject).state = 3;
      break;
    }
  }
  
  public void kH(long paramLong)
  {
    BaseApplication localBaseApplication = this.app.getApp();
    String str = this.app.getCurrentAccountUin();
    localBaseApplication.getSharedPreferences("voice_tab_time", 0).edit().putLong(str, paramLong).commit();
    if (QLog.isColorLevel()) {
      QLog.d("fetchUnReadCount", 2, String.format("设置saveVoiceTabTime, time[%s]", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.a);
    this.app.removeObserver(this.b);
    deleteObservers();
  }
  
  public List<QCallRecord> s(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallFacade", 2, "getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    return a().s(paramString, paramInt);
  }
  
  public List<QCallRecord> t(String paramString, int paramInt)
  {
    if (((atdc)this.app.getManager(746)).Og() == 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramString = s(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          QCallRecord localQCallRecord = (QCallRecord)paramString.next();
          if (localQCallRecord.state != 57) {
            localArrayList.add(localQCallRecord);
          }
        }
      }
      return localArrayList;
    }
    return s(paramString, paramInt);
  }
  
  public String v(String paramString, boolean paramBoolean)
  {
    Object localObject1 = a().fO();
    if (localObject1 == null) {
      return "";
    }
    int j = 0;
    int i = 0;
    long l2 = n(this.app);
    QCallRecord localQCallRecord1 = null;
    localObject1 = ((List)localObject1).iterator();
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QCallRecent)((Iterator)localObject1).next();
      long l1;
      if (((QCallRecent)localObject2).readTime > l2) {
        l1 = ((QCallRecent)localObject2).readTime;
      }
      for (;;)
      {
        if ((((QCallRecent)localObject2).lastCallTime > l1) && (((QCallRecent)localObject2).isMissedCall()))
        {
          k = i + 1;
          if (((QCallRecent)localObject2).uin == null)
          {
            i = k;
            break;
            l1 = l2;
            continue;
          }
          localObject2 = a().s(((QCallRecent)localObject2).uin, ((QCallRecent)localObject2).type);
          int m = 0;
          i = j;
          if (m >= ((List)localObject2).size()) {
            break label461;
          }
          QCallRecord localQCallRecord2 = (QCallRecord)((List)localObject2).get(m);
          if (localQCallRecord2.type == QCallRecord.TYPE_DATE) {}
          for (;;)
          {
            label192:
            m += 1;
            break;
            if (!localQCallRecord2.isMissCall()) {
              break label461;
            }
            if (localQCallRecord2.time <= l1) {
              break label458;
            }
            if (i != 0) {
              break label455;
            }
            localQCallRecord1 = (QCallRecord)((List)localObject2).get(m);
            label238:
            i += 1;
          }
        }
      }
      k = i;
      i = j;
    }
    label455:
    label458:
    label461:
    for (j = k;; j = k)
    {
      k = j;
      j = i;
      i = k;
      break;
      localObject1 = new StringBuilder();
      if ((j == 1) || (i == 1)) {
        if (paramBoolean) {
          if (paramString != null) {
            ((StringBuilder)localObject1).append(paramString).append(this.app.getApp().getString(2131697773));
          }
        }
      }
      for (;;)
      {
        return ((StringBuilder)localObject1).toString();
        if ((localQCallRecord1 != null) && (localQCallRecord1.isVideo()))
        {
          ((StringBuilder)localObject1).append(this.app.getApp().getString(2131698171));
        }
        else
        {
          ((StringBuilder)localObject1).append(this.app.getApp().getString(2131697563));
          continue;
          ((StringBuilder)localObject1).append(this.app.getApp().getString(2131697730, new Object[] { "" + i, "" + j }));
        }
      }
      break label238;
      break label192;
    }
  }
  
  public static class a
  {
    protected String bWU;
    protected int duQ;
    protected int duR;
    protected QQAppInterface mApp;
    protected int mType;
    protected String mUin;
    
    private a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, QQMessageFacade.Message paramMessage)
    {
      this.duR = paramInt2;
      this.mUin = paramString;
      this.mType = paramInt1;
      this.mApp = paramQQAppInterface;
      try
      {
        alkm localalkm = (alkm)paramQQAppInterface.getManager(38);
        if (localalkm == null) {
          break label241;
        }
        this.duQ = localalkm.ad(paramString, paramInt1);
        if (this.duQ <= 0) {
          break label241;
        }
        if (paramMessage == null) {
          break label235;
        }
        if (!aqfw.fJ(paramMessage.msgtype))
        {
          bool = aqfw.cJ(paramMessage.msgtype);
          if (!bool) {
            break label235;
          }
        }
        bool = true;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          boolean bool = false;
          continue;
          bool = false;
          continue;
          bool = false;
        }
      }
      if (bool) {}
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fetchUnReadCount", 4, String.format("CallUnreadCountInfo, isCallTabShow[%s], isConversationTabShow[%s], isInCallList[%s], uin[%s], type[%s], mUnreadMsgNum[%s], mMissCallCount[%s], mMsgExtroInfo[%s], isVideoMsg[%s]", new Object[] { Boolean.valueOf(paramQQAppInterface.bJb), Boolean.valueOf(paramQQAppInterface.bJc), Boolean.valueOf(paramQQAppInterface.bJd), paramString, Integer.valueOf(paramInt1), Integer.valueOf(this.duR), Integer.valueOf(this.duQ), this.bWU, Boolean.valueOf(bool) }));
        }
        return;
        try
        {
          this.bWU = acfp.m(2131710987);
        }
        catch (Exception paramMessage) {}
        QLog.w("fetchUnReadCount", 1, "CallUnreadCountInfo , Exception", paramMessage);
      }
    }
    
    public int HF()
    {
      return this.duQ;
    }
    
    public String xZ()
    {
      return this.bWU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkm
 * JD-Core Version:    0.7.0.1
 */