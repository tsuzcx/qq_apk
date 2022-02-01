import QQService.BindUin;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.System;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SubAccountBaseActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.subaccount.SubAccountControll.4;
import com.tencent.mobileqq.subaccount.SubAccountControll.5;
import com.tencent.mobileqq.subaccount.SubAccountControll.6;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class anxk
  implements Manager
{
  public static long aob = 600L;
  public static String ciB = "yyyy-MM-dd";
  private ArrayList<aqju> AY;
  private ArrayList<Pair<String, Integer>> AZ;
  private ArrayList<anxk.a> Ba = new ArrayList();
  private long aeo = 300L;
  private long aoc = 300L;
  public long aod = 600L;
  public long aoe;
  public QQAppInterface app;
  private boolean cKr = true;
  private boolean cKs = true;
  public boolean cKt;
  private Runnable hB;
  Runnable hC = new SubAccountControll.4(this);
  Runnable hD = new SubAccountControll.5(this);
  Lock k = new ReentrantLock();
  Lock lock = new ReentrantLock();
  
  public anxk(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.Ba.clear();
    try
    {
      str = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "date_format");
      if (!TextUtils.isEmpty(str)) {
        ciB = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "subaccountMsgFreq");
          if ((str != null) && (!TextUtils.isEmpty(str)))
          {
            this.aeo = Long.parseLong(str);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "init msgDelayTime = " + this.aeo);
            }
          }
          int i = ex(paramQQAppInterface.getCurrentUin() + "_unread_msg_num_interval");
          if (i != 0) {
            Vz(i);
          }
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  public static void G(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((!acbn.bku.equals(paramString)) && ((paramString == null) || (paramString.length() < 5))) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() return, subUin==null || subUin.length()<5");
      }
    }
    do
    {
      return;
      acxw localacxw = paramQQAppInterface.a().a();
      if ((localacxw.b(acbn.bku, 7000) != null) && (QLog.isColorLevel())) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
      }
      a(paramQQAppInterface, localacxw, paramString, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + paramString);
  }
  
  public static void H(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString)) || (!TextUtils.equals(paramString, paramQQAppInterface.getCurrentUin()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "storeThirdQQUnreadMsgNumInterval mainAccount=" + paramString + " interval=" + paramInt);
      }
      paramString = (anxk)paramQQAppInterface.getManager(62);
    } while (paramString == null);
    paramString.c(paramQQAppInterface.getCurrentUin() + "_unread_msg_num_interval", Integer.valueOf(paramInt));
    paramString.Vz(paramInt);
  }
  
  public static void J(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindAllRecentitem() defAct=" + paramInt);
    }
    acxw localacxw = paramQQAppInterface.a().a();
    Object localObject = localacxw.q(false);
    int i = paramInt;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        i = paramInt;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((localRecentUser != null) && (localRecentUser.getType() == 7000) && (!acbn.bku.equals(localRecentUser.uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "RecentUserProxy.deleteRecentUserByType, uin=" + localRecentUser.uin + " type=" + localRecentUser.getType());
          }
          paramQQAppInterface.b().ca(localRecentUser.uin, localRecentUser.getType());
          localacxw.f(localRecentUser);
          paramInt = 7;
        }
      }
    }
    a(paramQQAppInterface, localacxw, acbn.bku, i);
  }
  
  public static boolean S(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramString == null)
    {
      bool2 = bool1;
      return bool2;
    }
    bool1 = bool2;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = (anxr)paramQQAppInterface.getManager(61);
      if (localObject == null) {
        break label344;
      }
      localObject = ((anxr)localObject).dK();
      label45:
      paramQQAppInterface = (anxk)paramQQAppInterface.getManager(62);
      bool1 = bool2;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.lock.lock();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if ((paramQQAppInterface.AZ == null) || (paramQQAppInterface.AZ.size() <= 0)) {
          break label339;
        }
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          i = paramQQAppInterface.AZ.size() - 1;
          if (i >= 0)
          {
            Pair localPair = (Pair)paramQQAppInterface.AZ.get(i);
            if (((ArrayList)localObject).contains(localPair.first))
            {
              if (((Integer)localPair.second).intValue() == 1) {
                paramQQAppInterface.AZ.remove(i);
              }
            }
            else if (((Integer)localPair.second).intValue() == 0) {
              paramQQAppInterface.AZ.remove(i);
            }
          }
        }
      }
      finally
      {
        paramQQAppInterface.lock.unlock();
      }
      if ((paramQQAppInterface.AZ != null) && (paramQQAppInterface.AZ.size() > 0))
      {
        bool1 = "sub.uin.all".equals(paramString);
        if (bool1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        paramQQAppInterface.lock.unlock();
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "needShowHintDialog() subUin=" + paramString + " bool=" + bool1);
        return bool1;
        localObject = paramQQAppInterface.AZ.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            bool1 = paramString.equals(((Pair)((Iterator)localObject).next()).first);
            if (bool1)
            {
              bool1 = true;
              break;
            }
          }
        }
        label339:
        bool1 = false;
      }
      label344:
      localObject = null;
      break label45;
      i -= 1;
    }
  }
  
  public static void T(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {}
    anxk localanxk;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setDisplayThirdQQChecked checked=" + paramBoolean);
      }
      localanxk = (anxk)paramQQAppInterface.getManager(62);
    } while (localanxk == null);
    localanxk.c(paramQQAppInterface.getCurrentUin() + "_display_third_qq_checked", String.valueOf(paramBoolean));
  }
  
  private void Vz(int paramInt)
  {
    if (paramInt > 86400L)
    {
      this.aoc = 86400L;
      return;
    }
    if (paramInt < 60L)
    {
      this.aoc = 60L;
      return;
    }
    this.aoc = paramInt;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, tog paramtog)
  {
    int i;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (paramtog == null))
    {
      i = 0;
      return i;
    }
    anxr localanxr = (anxr)paramQQAppInterface.getManager(61);
    Object localObject;
    if (localanxr != null)
    {
      Iterator localIterator = localanxr.dL().iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label193;
      }
      localObject = (SubAccountInfo)localIterator.next();
      if ((localObject == null) || (TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)) || (localanxr.ey(((SubAccountInfo)localObject).subuin) != 1)) {
        break label242;
      }
    }
    label181:
    label193:
    label242:
    for (int j = paramtog.A(((SubAccountInfo)localObject).subuin, 7000);; j = 0)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("getAllSubAccountMsgUnreadNum() subuin=");
        if (localObject != null) {
          break label181;
        }
      }
      for (localObject = Integer.valueOf(0);; localObject = ((SubAccountInfo)localObject).subuin)
      {
        QLog.d("SUB_ACCOUNT", 2, localObject + " num=" + j);
        i += j;
        break;
      }
      j = 0;
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "getAllSubAccountMsgUnreadNum() currentUin=" + paramQQAppInterface.getCurrentUin() + " allNum=" + j);
      return j;
    }
  }
  
  private anxk.a a(String paramString)
  {
    if (this.Ba != null) {
      try
      {
        int j = this.Ba.size();
        int i = 0;
        while (i < j)
        {
          if (i < this.Ba.size()) {}
          for (anxk.a locala = (anxk.a)this.Ba.get(i); locala != null; locala = null)
          {
            boolean bool = TextUtils.equals(locala.key, paramString);
            if (!bool) {
              break;
            }
            return locala;
          }
          i += 1;
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.i("SUB_ACCOUNT", 1, " findAssociatedQQCacheItemByKey error: " + paramString.getMessage());
      }
    }
  }
  
  public static anxk.b a(QQAppInterface paramQQAppInterface, String paramString)
  {
    anxk.b localb = new anxk.b();
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return localb;
    }
    paramQQAppInterface = (anxr)paramQQAppInterface.getManager(61);
    int i = paramQQAppInterface.eA(paramString);
    if (i > 0)
    {
      localb.unReadCount = i;
      return localb;
    }
    aeoa localaeoa = (aeoa)aeif.a().o(607);
    if ((localaeoa == null) || (localaeoa.bVj)) {
      return localb;
    }
    i = paramQQAppInterface.eB(paramString);
    if (i > 0)
    {
      localb.unReadCount = i;
      localb.showRedDot = true;
    }
    return localb;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, SimpleAccount paramSimpleAccount)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin())) || (paramSimpleAccount == null)) {
      paramSimpleAccount = "";
    }
    do
    {
      return paramSimpleAccount;
      String str2 = n(paramQQAppInterface, paramSimpleAccount.getUin());
      String str1 = str2;
      if (paramSimpleAccount.isLogined()) {
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (!str2.equals(paramSimpleAccount.getUin())) {}
        }
        else
        {
          str1 = o(paramQQAppInterface, paramSimpleAccount.getUin());
        }
      }
      paramQQAppInterface = str1;
      if (TextUtils.isEmpty(str1)) {
        paramQQAppInterface = paramSimpleAccount.getUin();
      }
      paramSimpleAccount = paramQQAppInterface;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getShowName() showName=" + paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() subUin=" + paramString + " cmd=" + paramByte);
    }
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramQQAppInterface, paramByte, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("setBindUinStatus() return, listSubUin:");
        if (paramArrayList != null) {
          break label56;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label56:
    do
    {
      return;
      paramQQAppInterface = "size=0";
      break;
      if ((paramByte == 0) || (paramByte == 1)) {
        break label105;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, cmd=" + paramByte);
    return;
    label105:
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    label120:
    if (localIterator.hasNext()) {}
    for (paramArrayList = (String)localIterator.next();; paramArrayList = null)
    {
      try
      {
        l1 = Long.parseLong(paramArrayList);
        if ((l1 == 0L) || (l1 <= 10000L)) {
          break label120;
        }
        long l2 = 21L;
        if (paramByte == 1) {
          l2 = paramQQAppInterface.getApp().getSharedPreferences("acc_info" + paramArrayList, 0).getLong("getProfileStatusNew", 11L);
        }
        Object localObject2 = (anxr)paramQQAppInterface.getManager(61);
        if (localObject2 == null) {
          continue;
        }
        paramArrayList = ((anxr)localObject2).getA2(paramArrayList);
        if (paramArrayList == null)
        {
          paramArrayList = new byte[0];
          localObject2 = new BindUin();
          ((BindUin)localObject2).lUin = l1;
          ((BindUin)localObject2).iStatus = ((int)l2);
          ((BindUin)localObject2).sKey = paramArrayList;
          ((ArrayList)localObject1).add(localObject2);
          if (!QLog.isColorLevel()) {
            break label120;
          }
          localObject2 = new StringBuilder().append("setBindUinStatus() add<QQService.BindUin>:lUin=").append(l1).append(" cmd=").append(paramByte).append(" status=").append(l2).append(" sKey=");
          if (paramArrayList != null) {
            break label377;
          }
          paramArrayList = "null";
          QLog.d("SUB_ACCOUNT", 2, paramArrayList);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          long l1 = 0L;
          continue;
          paramArrayList = aqhs.hexStr2Bytes(paramArrayList);
          continue;
          label377:
          paramArrayList = Integer.valueOf(paramArrayList.length);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.a(paramByte, (ArrayList)localObject1);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, ArrayList<QQService.BindUin> list.size=0");
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, acxw paramacxw, String paramString, int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramInt == 0)) {
      if (QLog.isColorLevel())
      {
        paramacxw = new StringBuilder().append("updateRecentUser() return,");
        if (paramString != null) {
          break label102;
        }
        paramQQAppInterface = "subUin==null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label102:
    do
    {
      do
      {
        return;
        paramQQAppInterface = "subUin.len=0 action=" + paramInt;
        break;
        if (paramacxw != null) {
          break label146;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() return, ruProxy==null");
      return;
      if (!acbn.bku.equals(paramString))
      {
        localRecentUser = paramacxw.b(paramString, 7000);
        if (localRecentUser != null) {
          paramacxw.f(localRecentUser);
        }
      }
      localRecentUser = paramacxw.b(acbn.bku, 7000);
      if (localRecentUser != null) {
        break label653;
      }
    } while ((paramInt == 5) || (paramInt == 0));
    label146:
    RecentUser localRecentUser = new RecentUser();
    localRecentUser.setType(7000);
    label650:
    label653:
    for (;;)
    {
      localRecentUser.uin = acbn.bku;
      long l1;
      long l2;
      if (acbn.bku.equals(paramString))
      {
        paramQQAppInterface = (anxr)paramQQAppInterface.getManager(61);
        paramString = paramQQAppInterface.dK().iterator();
        l1 = 0L;
        while (paramString.hasNext())
        {
          l2 = paramQQAppInterface.aN((String)paramString.next());
          if (l1 < l2) {
            l1 = l2;
          }
        }
        if (l1 > 0L) {
          break label650;
        }
        l1 = anaz.gQ();
      }
      for (;;)
      {
        switch (paramInt)
        {
        case 3: 
        default: 
          paramInt = 0;
        }
        while (paramInt != 0)
        {
          paramacxw.e(localRecentUser);
          return;
          if (paramInt == 7) {
            l1 = anaz.gQ();
          }
          localRecentUser.lastmsgtime = l1;
          paramInt = 1;
          continue;
          localRecentUser.lastmsgtime = l1;
          localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
          paramInt = 1;
          continue;
          localRecentUser.showUpTime = 0L;
          paramInt = 1;
          continue;
          paramQQAppInterface = (anxr)paramQQAppInterface.getManager(61);
          l2 = paramQQAppInterface.aN(paramString);
          l1 = l2;
          if (l2 <= 0L) {
            l1 = anaz.gQ();
          }
          switch (paramInt)
          {
          case 3: 
          default: 
            paramInt = 0;
            break;
          case 1: 
          case 2: 
          case 6: 
          case 7: 
            l2 = anaz.gQ();
            ArrayList localArrayList = (ArrayList)paramQQAppInterface.nH.get(paramString);
            l1 = l2;
            if (paramInt == 6)
            {
              l1 = l2;
              if (localArrayList != null)
              {
                l1 = l2;
                if (localArrayList.size() != 0) {
                  l1 = ((SubAccountMessage)localArrayList.get(0)).time;
                }
              }
            }
            paramQQAppInterface.aY(paramString, l1);
            paramInt = i;
            if (localRecentUser.lastmsgtime < l1)
            {
              localRecentUser.lastmsgtime = l1;
              paramInt = i;
            }
            break;
          case 5: 
            if (localRecentUser.lastmsgtime < l1) {
              localRecentUser.lastmsgtime = l1;
            }
            localRecentUser.showUpTime = 0L;
            paramInt = i;
            break;
          case 4: 
            localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
            paramInt = i;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, RecentItemSubAccount paramRecentItemSubAccount, MsgSummary paramMsgSummary)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (paramRecentItemSubAccount == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() params error");
      }
    }
    anxr localanxr;
    do
    {
      return;
      localanxr = (anxr)paramQQAppInterface.getManager(61);
      if (localanxr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() subMgr == null");
    return;
    ArrayList localArrayList = localanxr.dL();
    Object localObject1 = new ArrayList();
    Object localObject3 = paramQQAppInterface.getApplication().getAllAccounts();
    if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
      ((List)localObject1).addAll((Collection)localObject3);
    }
    paramRecentItemSubAccount.mMsgExtroInfo = "";
    if ((localArrayList.size() == 0) && (((List)localObject1).size() <= 1))
    {
      paramMsgSummary.strContent = paramContext.getString(2131720577);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() no sub & other account");
      }
      paramRecentItemSubAccount.showSubUin = null;
      return;
    }
    long l = 0L;
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (SubAccountInfo)((Iterator)localObject1).next();
      if ((localObject3 != null) && (l < ((SubAccountInfo)localObject3).lasttime)) {
        l = ((SubAccountInfo)localObject3).lasttime;
      }
    }
    ab(paramQQAppInterface);
    tog localtog = paramQQAppInterface.a();
    int m = a(paramQQAppInterface, localtog);
    int n = b(paramQQAppInterface, localtog);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subUnreadNum=" + m + " subTroopUnreadNum=" + n);
    }
    Object localObject5 = null;
    localObject3 = null;
    Object localObject4 = null;
    localObject1 = null;
    int j = 0;
    int i = 0;
    for (;;)
    {
      SubAccountInfo localSubAccountInfo;
      try
      {
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label1391;
        }
        localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if ((localSubAccountInfo == null) || (TextUtils.isEmpty(localSubAccountInfo.subuin)) || (localanxr.ey(localSubAccountInfo.subuin) != 1)) {
          continue;
        }
        localObject8 = localanxr.aQ(localSubAccountInfo.subuin);
        localObject9 = localObject4;
        localObject10 = localObject5;
        localObject11 = localObject1;
        localObject12 = localObject3;
        if (localObject8 != null)
        {
          localObject9 = localObject4;
          localObject10 = localObject5;
          localObject11 = localObject1;
          localObject12 = localObject3;
          if (((List)localObject8).size() > 0)
          {
            localObject7 = (SubAccountMessage)((List)localObject8).get(0);
            localObject6 = null;
            if (!acbn.blA.equals(((SubAccountMessage)localObject7).senderuin)) {
              break label1381;
            }
            localObject9 = localObject7;
            if (((List)localObject8).size() > 1)
            {
              localObject6 = (SubAccountMessage)((List)localObject8).get(1);
              localObject9 = localObject7;
            }
            if (localObject3 == null) {
              break label1332;
            }
            localObject7 = localObject5;
            localObject8 = localObject3;
            if (localObject9 != null)
            {
              localObject7 = localObject5;
              localObject8 = localObject3;
              if (((SubAccountMessage)localObject3).time < ((SubAccountMessage)localObject9).time) {
                break label1332;
              }
            }
            if (localObject1 == null) {
              break label1343;
            }
            localObject9 = localObject4;
            localObject10 = localObject7;
            localObject11 = localObject1;
            localObject12 = localObject8;
            if (localObject6 != null)
            {
              localObject9 = localObject4;
              localObject10 = localObject7;
              localObject11 = localObject1;
              localObject12 = localObject8;
              if (((SubAccountMessage)localObject1).time < ((SubAccountMessage)localObject6).time) {
                break label1343;
              }
            }
          }
        }
        localObject1 = a(paramQQAppInterface, localSubAccountInfo.subuin);
        if (((anxk.b)localObject1).showRedDot)
        {
          i = ((anxk.b)localObject1).unReadCount + i;
          break label1362;
        }
        j = ((anxk.b)localObject1).unReadCount + j;
        break label1362;
        if ((localObject1 != null) && (localObject3 != null))
        {
          paramMsgSummary.strContent = paramContext.getString(2131720516);
          paramRecentItemSubAccount.mUnreadNum = 0;
          paramRecentItemSubAccount.mUnreadFlag = 0;
          paramRecentItemSubAccount.showSubUin = null;
          localObject6 = new SpannableStringBuilder();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() subUin=" + ((SubAccountInfo)localObject1).subuin + " mMsgExtroInfo=" + paramRecentItemSubAccount.mMsgExtroInfo);
          }
          localObject4 = (aeoa)aeif.a().o(607);
          if ((j <= 0) && ((j != 0) || (i != 0))) {
            continue;
          }
          localObject5 = ((SubAccountMessage)localObject3).frienduin;
          localObject4 = ((SubAccountMessage)localObject3).sendername;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            continue;
          }
          ((SpannableStringBuilder)localObject6).append((CharSequence)localObject4);
          ((SpannableStringBuilder)localObject6).append(": ");
          if (((((SubAccountMessage)localObject3).mEmoRecentMsg == null) || (((SubAccountMessage)localObject3).mEmoRecentMsg.length() == 0)) && (((SubAccountMessage)localObject3).msg != null)) {
            ((SubAccountMessage)localObject3).mEmoRecentMsg = new aofk(((SubAccountMessage)localObject3).msg, 3, 16);
          }
          ((SpannableStringBuilder)localObject6).append(((SubAccountMessage)localObject3).mEmoRecentMsg);
          if (((SubAccountMessage)localObject3).isread) {
            continue;
          }
          if (!b(paramQQAppInterface, ((SubAccountInfo)localObject1).subuin).contains(((SubAccountMessage)localObject3).senderuin)) {
            continue;
          }
          paramRecentItemSubAccount.mMsgExtroInfo = ("[" + paramContext.getString(2131717467) + "]");
          paramMsgSummary.strContent = ((CharSequence)localObject6);
          paramRecentItemSubAccount.showSubUin = ((SubAccountInfo)localObject1).subuin;
          paramRecentItemSubAccount.mUnreadNum = m;
          paramRecentItemSubAccount.mUnreadFlag = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SUB_ACCOUNT", 1, localThrowable, new Object[0]);
        if ((m > 0) && (localtog != null))
        {
          localObject2 = localArrayList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
            if ((localObject3 == null) || (TextUtils.isEmpty(((SubAccountInfo)localObject3).subuin))) {
              continue;
            }
            i = localtog.A(((SubAccountInfo)localObject3).subuin, 7000);
            if (i > 0)
            {
              localObject4 = paramQQAppInterface.b();
              if (localObject4 != null) {
                ((QQMessageFacade)localObject4).a(((SubAccountInfo)localObject3).subuin, 7000, true, false);
              }
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountContentAndUnread some error clean unread subuin= " + ((SubAccountInfo)localObject3).subuin + "  num=" + i);
            continue;
            if ((j == 0) && (i > 0))
            {
              localObject2 = localObject5;
              continue;
            }
            if ((j != 0) || (i != 0)) {
              break label1323;
            }
            localObject3 = localObject2;
            localObject2 = localObject4;
            continue;
            localObject4 = localObject5;
            if (localObject5 == null) {
              localObject4 = "";
            }
            ((SpannableStringBuilder)localObject6).append((CharSequence)localObject4);
            ((SpannableStringBuilder)localObject6).append(": ");
            continue;
            if ("RED_PACKET".equals(((SubAccountMessage)localObject3).subExtr))
            {
              paramRecentItemSubAccount.mMsgExtroInfo = ((CharSequence)localObject6);
              continue;
            }
            paramMsgSummary.strContent = ((CharSequence)localObject6);
            continue;
            paramMsgSummary.strContent = ((CharSequence)localObject6);
            continue;
            if ((i <= 0) || (localObject4 == null) || (((aeoa)localObject4).bVj)) {
              break;
            }
            paramMsgSummary.strContent = "有新的群消息";
            paramRecentItemSubAccount.showSubUin = ((SubAccountInfo)localObject2).subuin;
            paramRecentItemSubAccount.mUnreadNum = n;
            paramRecentItemSubAccount.mUnreadFlag = 2;
            return;
          }
        }
        paramRecentItemSubAccount.showSubUin = null;
        paramRecentItemSubAccount.mUnreadNum = 0;
        paramRecentItemSubAccount.mUnreadFlag = 0;
        paramMsgSummary.strContent = paramContext.getString(2131720516);
        return;
      }
      label1323:
      localObject3 = null;
      Object localObject2 = null;
      continue;
      label1332:
      Object localObject8 = localObject9;
      Object localObject7 = localSubAccountInfo;
      continue;
      label1343:
      Object localObject9 = localSubAccountInfo;
      Object localObject10 = localObject7;
      Object localObject11 = localObject6;
      Object localObject12 = localObject8;
      continue;
      label1362:
      localObject4 = localObject9;
      localObject5 = localObject10;
      localObject2 = localObject11;
      localObject3 = localObject12;
      continue;
      label1381:
      Object localObject6 = localObject7;
      localObject9 = null;
      continue;
      label1391:
      if (j > 0)
      {
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("showMaxHintDialog() actCaller=");
      if (paramBaseActivity != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject1 = "null";; localObject1 = paramBaseActivity.getClass().getSimpleName())
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      if (paramBaseActivity != null) {
        break;
      }
      return;
    }
    localObject1 = paramBaseActivity.getString(2131720583);
    Object localObject2 = paramBaseActivity.getString(2131720544, new Object[] { Integer.valueOf(2) });
    localObject1 = aqha.a(paramBaseActivity, 230).setTitle((String)localObject1).setMessage((CharSequence)localObject2);
    ((aqju)localObject1).setOwnerActivity(paramBaseActivity);
    ((aqju)localObject1).setPositiveButton(paramBaseActivity.getString(2131720564), new anxn(paramQQAppInterface, paramBaseActivity));
    ((aqju)localObject1).setCancelable(false);
    ((aqju)localObject1).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "storeSubAccountSpecialCare mainUin=" + paramString1 + " subUin=" + paramString2 + "  specialCareList=" + paramArrayList + " sysTime=" + paramInt1);
    }
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString1)) || (!TextUtils.equals(paramString1, paramQQAppInterface.getCurrentUin())) || (paramArrayList == null)) {}
    anxk localanxk;
    do
    {
      return;
      localanxk = (anxk)paramQQAppInterface.getManager(62);
    } while (localanxk == null);
    paramString1 = paramString1 + "_" + paramString2 + "_spcares";
    localanxk.k.lock();
    for (;;)
    {
      try
      {
        paramString2 = localanxk.a(paramString1);
        if ((paramString2 != null) && (paramString2.value != null) && ((paramString2.value instanceof ArrayList)))
        {
          paramString2 = (ArrayList)paramString2.value;
          paramString2.clear();
          paramString2.addAll(paramArrayList);
          localanxk.k.unlock();
          paramString2 = new StringBuilder();
          int i = 0;
          if (i >= paramArrayList.size()) {
            break;
          }
          if (i > 0) {
            paramString2.append(";");
          }
          paramString2.append((String)paramArrayList.get(i));
          i += 1;
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(paramArrayList);
        if (paramString2 != null) {
          paramString2.value = localArrayList;
        } else {
          localanxk.Ba.add(new anxk.a(paramString1, localArrayList));
        }
      }
      finally
      {
        localanxk.k.unlock();
      }
    }
    paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0).edit().putString(paramString1, paramString2.toString()).commit();
    localanxk.c(paramString1 + "_sysTime", Integer.valueOf(paramInt1));
    localanxk.aod = paramInt2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString2)) || (!TextUtils.equals(paramString1, paramQQAppInterface.getCurrentUin()))) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "storeThirdQQUnreadInfo mainAccount=" + paramString1 + " thirdUin=" + paramString2 + " msgNum=" + paramInt1 + " msgFlag=" + paramInt2 + " lastMsgTime=" + paramInt5);
        }
        paramString1 = (anxk)paramQQAppInterface.getManager(62);
      } while (paramString1 == null);
      paramQQAppInterface = paramQQAppInterface.getCurrentUin() + "_" + paramString2;
      paramString2 = aqoj.C(paramArrayOfByte);
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.c(paramQQAppInterface + "_last_cookie", paramString2);
      }
      paramString1.c(paramQQAppInterface + "_msgNum", Integer.valueOf(paramInt1));
      paramString1.c(paramQQAppInterface + "_msgFlag", Integer.valueOf(paramInt2));
      paramString1.c(paramQQAppInterface + "_redBagTime", Integer.valueOf(paramInt3));
      paramString1.c(paramQQAppInterface + "_status", Integer.valueOf(paramInt4));
    } while (paramInt5 == 0);
    paramString1.c(paramQQAppInterface + "_lastMsgTime", Integer.valueOf(paramInt5));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList<String> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() list=" + String.valueOf(paramArrayList) + " actionType=" + paramInt);
    }
    Object localObject;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("bindRecentItem() return, list=");
        if (paramArrayList != null) {
          break label98;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    for (;;)
    {
      return;
      label98:
      paramQQAppInterface = Integer.valueOf(paramArrayList.size());
      break;
      localObject = paramQQAppInterface.a().a();
      if ((((acxw)localObject).b(acbn.bku, 7000) != null) && (QLog.isColorLevel())) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        a(paramQQAppInterface, (acxw)localObject, str, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + str);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SimpleAccount paramSimpleAccount)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin())) || (paramSimpleAccount == null)) {
      return false;
    }
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    if (localanxk == null) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = paramQQAppInterface + "_" + paramSimpleAccount.getUin();
    paramSimpleAccount = localanxk.nL(paramQQAppInterface + "_last_cookie");
    if (!TextUtils.isEmpty(paramSimpleAccount)) {
      localanxk.c(paramQQAppInterface + "_cookie", paramSimpleAccount);
    }
    localanxk.c(paramQQAppInterface + "_msgNum", Integer.valueOf(0));
    localanxk.c(paramQQAppInterface + "_msgFlag", Integer.valueOf(0));
    localanxk.c(paramQQAppInterface + "_redBagTime", Integer.valueOf(0));
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
    }
    return true;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      return null;
    }
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    if (localanxk != null)
    {
      paramQQAppInterface = localanxk.nL(paramQQAppInterface.getCurrentUin() + "_" + paramString + "_cookie");
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return aqoj.ag(paramQQAppInterface);
      }
    }
    return null;
  }
  
  public static void aJ(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearAllData() subUin=" + paramString);
    }
    if ("sub.uin.all".equals(paramString))
    {
      paramString = (anxr)paramQQAppInterface.getManager(61);
      if (paramString == null) {
        break label183;
      }
    }
    label183:
    for (paramString = paramString.dK();; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "clearAllData() clear all_sub_uin. list=" + paramString);
      }
      if (paramString != null)
      {
        paramString = paramString.iterator();
        int i = 0;
        while (paramString.hasNext())
        {
          Object localObject = (String)paramString.next();
          if (!"sub.uin.all".equals(localObject))
          {
            i += 1;
            aJ(paramQQAppInterface, (String)localObject);
            continue;
            if (paramQQAppInterface != null)
            {
              localObject = (anxr)paramQQAppInterface.getManager(61);
              if (localObject != null)
              {
                ((anxr)localObject).Rx(paramString);
                ((anxr)localObject).RA(paramString);
                if (aqgv.c(paramQQAppInterface, paramString, false) != null) {
                  break;
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  public static void aK(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ciB = paramString;
      paramQQAppInterface = (anxr)paramQQAppInterface.getManager(61);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.RB(ciB);
      }
    }
  }
  
  public static void aL(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() < 4)) {}
    do
    {
      acxw localacxw;
      do
      {
        return;
        paramQQAppInterface.b().ca(paramString, 7000);
        localacxw = paramQQAppInterface.a().a();
        paramString = localacxw.b(paramString, 7000);
        if (paramString != null)
        {
          localacxw.f(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem() unbind,delete subUin:" + paramString.uin + " type=" + paramString.getType());
          }
        }
      } while (((anxr)paramQQAppInterface.getManager(61)).Kx() != 0);
      a(paramQQAppInterface, localacxw, acbn.bku, 7);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() unbind, add default RecentUser");
  }
  
  public static int ab(QQAppInterface paramQQAppInterface)
  {
    int j;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin())))
    {
      j = 0;
      return j;
    }
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    if (localanxk != null) {}
    for (int i = localanxk.ex(paramQQAppInterface.getCurrentUin() + "_all_third_last_msg_time");; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getAllThirdQQMsgUnreadLastTime() lastTime=" + i);
      }
      long l = anaz.gQ();
      j = i;
      if (i <= l) {
        break;
      }
      i = (int)l;
      o(paramQQAppInterface, i);
      return i;
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface, tog paramtog)
  {
    int i;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (paramtog == null))
    {
      i = 0;
      return i;
    }
    anxr localanxr = (anxr)paramQQAppInterface.getManager(61);
    Object localObject;
    if (localanxr != null)
    {
      Iterator localIterator = localanxr.dL().iterator();
      i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label193;
      }
      localObject = (SubAccountInfo)localIterator.next();
      if ((localObject == null) || (TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)) || (localanxr.ey(((SubAccountInfo)localObject).subuin) != 1)) {
        break label242;
      }
    }
    label181:
    label193:
    label242:
    for (int j = paramtog.B(((SubAccountInfo)localObject).subuin, 7000);; j = 0)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("getAllSubAccountTroopMsgUnreadNum() subuin=");
        if (localObject != null) {
          break label181;
        }
      }
      for (localObject = Integer.valueOf(0);; localObject = ((SubAccountInfo)localObject).subuin)
      {
        QLog.d("SUB_ACCOUNT", 2, localObject + " num=" + j);
        i += j;
        break;
      }
      j = 0;
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "getAllSubAccountTroopMsgUnreadNum() currentUin=" + paramQQAppInterface.getCurrentUin() + " allNum=" + j);
      return j;
    }
  }
  
  public static Pair<Boolean, Boolean> b(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool4 = false;
    Object localObject;
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("checkSubAccountLoginStatus() app is null?=>");
        if (paramQQAppInterface != null) {
          break label96;
        }
        bool1 = true;
        paramQQAppInterface = ((StringBuilder)localObject).append(bool1).append(" subUin is null?=>");
        if (paramString != null) {
          break label101;
        }
      }
      label96:
      label101:
      for (bool1 = bool2;; bool1 = false)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        bool1 = false;
        break;
      }
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getAllAccounts();
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("checkSubAccountLoginStatus() app.getAllAccounts() is null? =>");
        if (paramQQAppInterface != null) {
          break label181;
        }
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        label181:
        bool1 = false;
      }
    }
    int i = 0;
    if (i < paramQQAppInterface.size())
    {
      localObject = (SimpleAccount)paramQQAppInterface.get(i);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount == null");
        }
      }
      label263:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (((SimpleAccount)localObject).getUin() != null) {
            break label263;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount.getUin() == null");
          }
        }
      } while (!((SimpleAccount)localObject).getUin().equalsIgnoreCase(paramString));
      bool1 = bool3;
      bool2 = bool4;
      if (((SimpleAccount)localObject).isLogined())
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() hasAccount=" + bool1 + " isLogin=" + bool2);
      }
      return new Pair(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      bool1 = false;
      bool2 = bool4;
    }
  }
  
  public static ArrayList<String> b(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin())) || (TextUtils.isEmpty(paramString))) {
      return localArrayList;
    }
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    if (localanxk != null)
    {
      paramString = paramQQAppInterface.getCurrentUin() + "_" + paramString + "_spcares";
      localanxk.k.lock();
    }
    for (;;)
    {
      try
      {
        anxk.a locala = localanxk.a(paramString);
        if (locala != null)
        {
          localArrayList.addAll((ArrayList)locala.value);
          localanxk.k.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareList  list=" + localArrayList);
          }
          return localArrayList;
        }
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0).getString(paramString, "").split(";");
        if ((paramQQAppInterface != null) && (i < paramQQAppInterface.length))
        {
          if ((!TextUtils.isEmpty(paramQQAppInterface[i])) && (!TextUtils.equals("0", paramQQAppInterface[i]))) {
            localArrayList.add(paramQQAppInterface[i]);
          }
        }
        else
        {
          localanxk.Ba.add(new anxk.a(paramString, localArrayList));
          continue;
        }
        i += 1;
      }
      finally
      {
        localanxk.k.unlock();
      }
    }
  }
  
  public static boolean bE(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (anxr)paramQQAppInterface.getManager(61);
    if (paramQQAppInterface != null) {}
    for (int i = paramQQAppInterface.Kx();; i = 0)
    {
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkAccountBind, bindedNum=" + i + " ret=" + bool);
        }
        return bool;
      }
    }
  }
  
  public static boolean bF(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (anxr)paramQQAppInterface.getManager(61);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.dL();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)paramQQAppInterface.next();
          if ((localSubAccountInfo != null) && (localSubAccountInfo.isTop)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean bG(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      return false;
    }
    Object localObject1 = (anxr)paramQQAppInterface.getManager(61);
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    if ((localObject1 == null) || (localanxk == null)) {
      return false;
    }
    localObject1 = ((anxr)localObject1).dK();
    Object localObject2 = new ArrayList();
    Object localObject3 = paramQQAppInterface.getApplication().getAllAccounts();
    if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
      ((List)localObject2).addAll((Collection)localObject3);
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SimpleAccount)((Iterator)localObject2).next();
      if ((localObject3 != null) && (!TextUtils.isEmpty(((SimpleAccount)localObject3).getUin())) && (!((SimpleAccount)localObject3).getUin().equals(paramQQAppInterface)) && (!((List)localObject1).contains(((SimpleAccount)localObject3).getUin())))
      {
        localObject3 = paramQQAppInterface + "_" + ((SimpleAccount)localObject3).getUin();
        String str = localanxk.nL((String)localObject3 + "_last_cookie");
        if (!TextUtils.isEmpty(str)) {
          localanxk.c((String)localObject3 + "_cookie", str);
        }
        localanxk.c((String)localObject3 + "_msgNum", Integer.valueOf(0));
        localanxk.c((String)localObject3 + "_msgFlag", Integer.valueOf(0));
        localanxk.c((String)localObject3 + "_redBagTime", Integer.valueOf(0));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
    }
    return true;
  }
  
  public static boolean bH(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      return true;
    }
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    return (localanxk == null) || (!TextUtils.equals(localanxk.nL(paramQQAppInterface.getCurrentUin() + "_display_third_qq_checked"), String.valueOf(false)));
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = null;
    Object localObject = null;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    if (SystemMsg.isSystemMessage(paramInt)) {
      switch (paramInt)
      {
      default: 
        paramString1 = localObject;
      }
    }
    for (;;)
    {
      paramQQAppInterface = aqgv.b(paramQQAppInterface, paramString2, true);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramString2))) {
        break;
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramQQAppInterface).append(paramString1);
      paramString1 = paramString2.toString();
      return paramString1;
      paramString1 = localBaseApplication.getString(2131689802);
      continue;
      paramString1 = localBaseApplication.getString(2131689600);
      continue;
      paramString1 = localBaseApplication.getString(2131689599);
      continue;
      paramString1 = localBaseApplication.getString(2131718685);
      continue;
      paramString1 = localBaseApplication.getString(2131689856);
    }
    return paramString2 + paramString1;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    label11:
    do
    {
      int i;
      do
      {
        anxr localanxr;
        do
        {
          break label11;
          do
          {
            return;
          } while (TextUtils.isEmpty(paramString2));
          localanxr = (anxr)paramQQAppInterface.getManager(61);
          paramQQAppInterface = (MessageHandler)paramQQAppInterface.getBusinessHandler(0);
        } while ((localanxr == null) || (paramQQAppInterface == null));
        i = localanxr.eA(paramString2);
        localanxr.Ry(paramString2);
      } while ((!paramBoolean) && (i <= 0));
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=" + paramString2 + " needConfirm=" + paramBoolean);
      }
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.fi(paramString2, paramString1);
  }
  
  private boolean c(String paramString, Object paramObject)
  {
    boolean bool2;
    if ((TextUtils.isEmpty(paramString)) || (this.app == null) || (this.app.getApp() == null))
    {
      bool2 = false;
      return bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "putAssociatedQQCache key=" + paramString + " value=" + paramObject);
    }
    this.k.lock();
    for (;;)
    {
      Object localObject;
      boolean bool1;
      try
      {
        if (this.Ba == null) {
          break label306;
        }
        localObject = a(paramString);
        if (localObject == null)
        {
          this.Ba.add(new anxk.a(paramString, paramObject));
          bool1 = true;
          this.k.unlock();
          bool2 = bool1;
          if (!bool1) {
            break;
          }
          localObject = this.app.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
          bool2 = bool1;
          if (localObject == null) {
            break;
          }
          if (!(paramObject instanceof Integer)) {
            break label311;
          }
          ((SharedPreferences)localObject).edit().putInt(paramString, ((Integer)paramObject).intValue()).commit();
          return bool1;
        }
        if (((paramObject instanceof Integer)) && ((((anxk.a)localObject).value instanceof Integer)))
        {
          if ((Integer)((anxk.a)localObject).value == (Integer)paramObject) {
            break label346;
          }
          bool2 = true;
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          ((anxk.a)localObject).value = paramObject;
          bool1 = bool2;
          continue;
        }
        if (!(paramObject instanceof String)) {
          break label346;
        }
      }
      finally
      {
        this.k.unlock();
      }
      if ((((anxk.a)localObject).value instanceof String))
      {
        bool1 = TextUtils.equals((String)((anxk.a)localObject).value, (String)paramObject);
        if (!bool1)
        {
          bool2 = true;
          continue;
          label306:
          bool1 = true;
          continue;
          label311:
          bool2 = bool1;
          if (!(paramObject instanceof String)) {
            break;
          }
          ((SharedPreferences)localObject).edit().putString(paramString, (String)paramObject).commit();
          return bool1;
        }
      }
      label346:
      bool2 = false;
    }
  }
  
  public static int d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int j;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString1)) || (!TextUtils.equals(paramString1, paramQQAppInterface.getCurrentUin())))
    {
      j = 0;
      return j;
    }
    paramQQAppInterface = (anxk)paramQQAppInterface.getManager(62);
    if (paramQQAppInterface != null) {}
    for (int i = paramQQAppInterface.ex(paramString1 + "_" + paramString2 + "_spcares_sysTime");; i = 0)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "getReqSubAccountSpecialCareListSysTime mainUin=" + paramString1 + " subUin=" + paramString2 + " sysTime=" + i);
      return i;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    for (;;)
    {
      return;
      anxr localanxr = (anxr)paramQQAppInterface.getManager(61);
      paramQQAppInterface = (MessageHandler)paramQQAppInterface.getBusinessHandler(0);
      if ((localanxr != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = localanxr.dK().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!TextUtils.isEmpty(str))
          {
            int i = localanxr.eA(str);
            localanxr.Ry(str);
            if ((paramBoolean) || (i > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=" + str + " needConfirm=" + paramBoolean);
              }
              acrl localacrl = paramQQAppInterface.a();
              if (localacrl != null) {
                localacrl.fi(str, paramString);
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() subUin=" + paramString + " isFromPush=" + paramBoolean);
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning()))
    {
      localObject = (anxr)paramQQAppInterface.getManager(61);
      if (localObject == null) {
        break label381;
      }
    }
    label381:
    for (Object localObject = ((anxr)localObject).getA2(paramString);; localObject = null)
    {
      anxo localanxo = (anxo)paramQQAppInterface.getManager(28);
      if (localanxo != null)
      {
        paramBoolean = localanxo.azi();
        if (!paramBoolean)
        {
          localObject = new anxs();
          ((anxs)localObject).errorMsg = "";
          ((anxs)localObject).aLa = paramQQAppInterface.getAccount();
          ((anxs)localObject).aQf = paramString;
          ((anxs)localObject).errorType = 1009;
          paramQQAppInterface.a().notifyUI(8003, false, localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, get bind subaccount isFinish = " + paramBoolean);
          }
          return false;
        }
      }
      if ((paramString == null) || (paramString.length() == 0) || (localObject == null) || (((String)localObject).length() == 0) || (((String)localObject).trim().equals("")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, subUin=" + paramString + " a2=" + (String)localObject);
        }
        localObject = new anxs();
        ((anxs)localObject).errorMsg = "";
        ((anxs)localObject).aLa = paramQQAppInterface.getAccount();
        ((anxs)localObject).aQf = paramString;
        ((anxs)localObject).errorType = 1010;
        paramQQAppInterface.a().notifyUI(8003, false, localObject);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() lockMsg later really start get subaccount message account = " + paramQQAppInterface.getAccount() + "; sAccount = " + paramString);
      }
      paramQQAppInterface = (MessageHandler)paramQQAppInterface.getBusinessHandler(0);
      if (paramQQAppInterface.a() != null) {
        paramQQAppInterface.a().a((byte)3, 0, paramString, (String)localObject, null);
      }
      return true;
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    Object localObject1;
    label110:
    do
    {
      long l1;
      long l2;
      do
      {
        return;
        localObject1 = (anxk)paramQQAppInterface.getManager(62);
        if (localObject1 == null) {
          break label110;
        }
        l1 = System.currentTimeMillis();
        l2 = (l1 - ((anxk)localObject1).aoe) / 1000L;
        if (l2 >= ((anxk)localObject1).aod) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareListFromService skip adviseGap=" + ((anxk)localObject1).aod + "  realGap=" + l2);
      return;
      ((anxk)localObject1).aoe = l1;
      localObject1 = (anxr)paramQQAppInterface.getManager(61);
    } while (localObject1 == null);
    Object localObject2 = new ArrayList();
    if (paramBoolean) {
      ((List)localObject2).addAll(((anxr)localObject1).dL());
    }
    for (;;)
    {
      paramString = ((List)localObject2).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (SubAccountInfo)paramString.next();
        if ((localObject1 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareListFromService uin=" + ((SubAccountInfo)localObject1).subuin);
          }
          localObject2 = (MessageHandler)paramQQAppInterface.getBusinessHandler(0);
          if (((MessageHandler)localObject2).a() != null) {
            ((MessageHandler)localObject2).a().a((SubAccountInfo)localObject1);
          }
        }
      }
      break;
      ((List)localObject2).add(((anxr)localObject1).a(paramString));
    }
  }
  
  public static void ed(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() return, app == null");
      }
    }
    label425:
    label471:
    do
    {
      do
      {
        return;
        localObject2 = (anxr)paramQQAppInterface.getManager(61);
      } while (localObject2 == null);
      long l1 = aqgx.a().aK(paramQQAppInterface.getApp());
      long l2 = aewh.getVersionCode(paramQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData()..start, historyVersion=" + l1 + " thisApkVersion=" + l2);
      }
      boolean bool;
      Object localObject1;
      SubAccountInfo localSubAccountInfo;
      if (l1 < l2)
      {
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() need to update (v5.0 or lower) data");
          }
          bool = aqgx.a().am(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
          localObject1 = ((anxr)localObject2).a("sub.uin.default");
          if ((localObject1 != null) && (((SubAccountInfo)localObject1).subuin != null))
          {
            ((anxr)localObject2).RE(((SubAccountInfo)localObject1).subuin);
            i = ((anxr)localObject2).eA(((SubAccountInfo)localObject1).subuin) - paramQQAppInterface.a().A(((SubAccountInfo)localObject1).subuin, 7000);
            if (i != 0)
            {
              paramQQAppInterface.a().G(((SubAccountInfo)localObject1).subuin, 7000, i);
              paramQQAppInterface.b().as(new String[] { acbn.bku, ((SubAccountInfo)localObject1).subuin });
            }
            if (bool)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "initAllData(), setTopInRecentList, isTop=" + bool);
              }
              o(paramQQAppInterface, ((SubAccountInfo)localObject1).subuin, true);
            }
          }
          aqgx.a().fy(paramQQAppInterface.getApp());
        }
      }
      else
      {
        if (!aqgx.a().an(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() showedBefore:false, isFirstTime to user SubAccount.");
          }
          aqgx.a().h(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), true);
          J(paramQQAppInterface, 7);
        }
        localObject1 = paramQQAppInterface.a().a();
        localObject3 = ((acxw)localObject1).b(acbn.bku, 7000);
        if (((anxr)localObject2).Kx() <= 0) {
          break label788;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "initAllData() getBindedNumber > 0, go to initAllData");
        }
        localObject4 = ((anxr)localObject2).dL();
        int m = ((ArrayList)localObject4).size();
        i = 0;
        if (i >= m) {
          break label788;
        }
        localSubAccountInfo = (SubAccountInfo)((ArrayList)localObject4).get(i);
        if (localSubAccountInfo != null) {
          break label471;
        }
      }
      for (;;)
      {
        i += 1;
        break label425;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "initAllData() (v5.1 or later) update..");
        break;
        if ((localObject3 != null) && (QLog.isColorLevel())) {
          QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() delete defaultRU:" + ((RecentUser)localObject3).uin + " type=" + ((RecentUser)localObject3).getType());
        }
        if ((localObject3 != null) && (l1 == 0L))
        {
          G(paramQQAppInterface, localSubAccountInfo.subuin, 7);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() add RU:" + localSubAccountInfo.subuin);
          }
          int n = paramQQAppInterface.a().A(localSubAccountInfo.subuin, 7000);
          j = 0;
          if (localObject2 != null) {
            j = ((anxr)localObject2).eA(localSubAccountInfo.subuin);
          }
          int i1 = j - n;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() setReaded subaccount,old:" + n + " target:" + j + " increase:" + i1);
          }
          if (i1 != 0)
          {
            paramQQAppInterface.a().G(localSubAccountInfo.subuin, 7000, i1);
            paramQQAppInterface.b().as(new String[] { acbn.bku, localSubAccountInfo.subuin });
          }
        }
        bool = false;
        Pair localPair = b(paramQQAppInterface, localSubAccountInfo.subuin);
        if (localPair != null) {
          bool = ((Boolean)localPair.second).booleanValue();
        }
        if (bool) {
          paramQQAppInterface.getSubAccountKey(paramQQAppInterface.getAccount(), localSubAccountInfo.subuin, new anxl(paramQQAppInterface));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() delete subaccount recentuser, add default subaccount box");
      }
      Object localObject2 = ((anxr)localObject2).dL();
      int j = ((ArrayList)localObject2).size();
      int i = 0;
      if (i < j)
      {
        localObject3 = (SubAccountInfo)((ArrayList)localObject2).get(i);
        if ((localObject3 == null) || (acbn.bku.equals(((SubAccountInfo)localObject3).subuin))) {}
        for (;;)
        {
          i += 1;
          break;
          localObject3 = ((acxw)localObject1).b(((SubAccountInfo)localObject3).subuin, 7000);
          if (localObject3 != null) {
            ((acxw)localObject1).f((RecentUser)localObject3);
          }
        }
      }
      localObject2 = ((acxw)localObject1).b(acbn.bku, 7000);
      Object localObject3 = paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
      Object localObject4 = paramQQAppInterface.getAccount() + "_initDataTimes";
      i = ((SharedPreferences)localObject3).getInt((String)localObject4, 0);
      if (((localObject2 == null) && (i == 0)) || ((localObject2 != null) && (i < 3)))
      {
        a(paramQQAppInterface, (acxw)localObject1, acbn.bku, 7);
        ((SharedPreferences)localObject3).edit().putInt((String)localObject4, i + 1).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() end");
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    } while (paramQQAppInterface == null);
    label788:
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  public static void ef(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {}
    for (;;)
    {
      return;
      Object localObject1 = (anxr)paramQQAppInterface.getManager(61);
      if (localObject1 != null)
      {
        Object localObject2 = new ArrayList();
        ((List)localObject2).addAll(((anxr)localObject1).dL());
        localObject1 = paramQQAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
        if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
            localObject3 = ((SubAccountInfo)localObject3).subuin + "_" + paramQQAppInterface.getCurrentUin() + "_spcares_sysTime";
            ((SharedPreferences)localObject1).edit().putInt((String)localObject3, 0).commit();
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "cleanReqSubAccountSpecialCareListSysTime key=" + (String)localObject3);
            }
          }
        }
      }
    }
  }
  
  private int ex(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app == null) || (this.app.getApp() == null)) {
      return 0;
    }
    this.k.lock();
    try
    {
      Object localObject = a(paramString);
      int i;
      if (localObject != null)
      {
        i = ((Integer)((anxk.a)localObject).value).intValue();
        return i;
      }
      localObject = this.app.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
      if (localObject != null)
      {
        i = ((SharedPreferences)localObject).getInt(paramString, 0);
        if (this.Ba != null) {
          this.Ba.add(new anxk.a(paramString, Integer.valueOf(i)));
        }
        return i;
      }
      return 0;
    }
    finally
    {
      this.k.unlock();
    }
  }
  
  public static boolean j(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startGetThirdQQUnreadNum()");
    }
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    if (localanxk != null)
    {
      if (!localanxk.cKr) {
        return false;
      }
      if (BaseActivity.mAppForground)
      {
        bool = localanxk.k(paramQQAppInterface, paramBoolean);
        paramBoolean = bool;
        if (bool) {
          localanxk.ee(paramQQAppInterface);
        }
      }
      for (paramBoolean = bool;; paramBoolean = bool)
      {
        if ((!paramBoolean) && (localanxk.hB != null)) {
          ThreadManager.getSubThreadHandler().removeCallbacks(localanxk.hB);
        }
        return paramBoolean;
        localanxk.cKt = true;
      }
    }
    return false;
  }
  
  private boolean k(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {
      return false;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = paramQQAppInterface.getApplication().getAllAccounts();
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      ((List)localObject2).addAll((Collection)localObject1);
    }
    Object localObject3 = (anxr)paramQQAppInterface.getManager(61);
    if ((((List)localObject2).size() >= 1) && (localObject3 != null))
    {
      localObject1 = new ArrayList();
      String str = paramQQAppInterface.getCurrentUin();
      localObject3 = ((anxr)localObject3).dK();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
        if ((localSimpleAccount != null) && (!TextUtils.isEmpty(localSimpleAccount.getUin())) && (!localSimpleAccount.getUin().equals(str)) && (!((List)localObject3).contains(localSimpleAccount.getUin())) && (localSimpleAccount.isLogined())) {
          ((ArrayList)localObject1).add(localSimpleAccount);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "requestThirdQQUnreadMsgNum() really start get other qq unread message mainUin=" + str + " isCronJob=" + paramBoolean);
        }
        paramQQAppInterface = (MessageHandler)paramQQAppInterface.getBusinessHandler(0);
        if (paramQQAppInterface.a() != null) {
          paramQQAppInterface.a().i(paramBoolean, (ArrayList)localObject1);
        }
        return true;
      }
    }
    return false;
  }
  
  public static int l(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i;
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
      if (localanxk == null) {
        break;
      }
      j = localanxk.ex(paramQQAppInterface.getCurrentUin() + "_" + paramString + "_msgNum");
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getLocalThirdUnreadMsgNum() currentUin=" + paramQQAppInterface.getCurrentUin() + " thirdUin=" + paramString + " num=" + j);
    return j;
    return 0;
  }
  
  public static boolean l(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return true;
  }
  
  public static boolean m(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      return false;
    }
    paramQQAppInterface = (anxk)paramQQAppInterface.getManager(62);
    if (paramQQAppInterface != null)
    {
      if (paramBoolean)
      {
        Object localObject = DeviceProfileManager.b().jf(DeviceProfileManager.DpcNames.aio_config.name());
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "aioConfig:" + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if ((localObject != null) && (localObject.length > 11) && (!TextUtils.isEmpty(localObject[11])))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subAccountConfig:" + localObject[11]);
            }
            localObject = localObject[11].split("_");
            if ((localObject == null) || (localObject.length <= 0) || (!TextUtils.equals("1", localObject[0]))) {
              break label234;
            }
          }
        }
      }
      label234:
      for (paramQQAppInterface.cKs = true;; paramQQAppInterface.cKs = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "isHeadIconLongClickFunc isHeadIconLongClick=" + paramQQAppInterface.cKs);
        }
        return paramQQAppInterface.cKs;
      }
    }
    return false;
  }
  
  public static String n(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = null;
    }
    label91:
    label94:
    for (;;)
    {
      return paramString;
      String str = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
      if (TextUtils.isEmpty(str))
      {
        paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = localObject;
          if (paramQQAppInterface == null) {
            break label91;
          }
        }
      }
      for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = str)
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label94;
        }
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.b(paramString);
        break;
      }
    }
  }
  
  private String nL(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app == null) || (this.app.getApp() == null)) {
      return "";
    }
    this.k.lock();
    try
    {
      Object localObject = a(paramString);
      if (localObject != null)
      {
        paramString = (String)((anxk.a)localObject).value;
        return paramString;
      }
      localObject = this.app.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).getString(paramString, "");
        if (this.Ba != null) {
          this.Ba.add(new anxk.a(paramString, localObject));
        }
        return localObject;
      }
      return "";
    }
    finally
    {
      this.k.unlock();
    }
  }
  
  public static String o(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    Object localObject = paramQQAppInterface.b(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      paramQQAppInterface = ((Friends)localObject).name;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = paramQQAppInterface.a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(((Card)localObject).strNick));
    return ((Card)localObject).strNick;
  }
  
  public static void o(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("setSBTopInRecentList() return, ");
        if (paramQQAppInterface != null) {
          break label51;
        }
      }
      label51:
      for (paramQQAppInterface = "app==null";; paramQQAppInterface = "subUin==null")
      {
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
        return;
      }
    }
    if (acbn.bku.equals(paramString)) {
      if (paramBoolean) {
        a(paramQQAppInterface, paramQQAppInterface.a().a(), acbn.bku, 7);
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface.sendEmptyMessage(1009);
      return;
      ((anxr)paramQQAppInterface.getManager(61)).cV(paramString, paramBoolean);
      acxw localacxw = paramQQAppInterface.a().a();
      if (paramBoolean) {
        a(paramQQAppInterface, localacxw, paramString, 4);
      } else {
        a(paramQQAppInterface, localacxw, paramString, 5);
      }
    }
  }
  
  public static boolean o(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning()) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateAllThirdQQMsgUnreadLastTime() lastMsgTime=" + paramInt);
    }
    anxk localanxk = (anxk)paramQQAppInterface.getManager(62);
    if (localanxk != null) {
      return localanxk.c(paramQQAppInterface.getCurrentUin() + "_all_third_last_msg_time", Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public void K(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("launchTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject + " fetchMsgType=" + paramInt);
      }
    }
    else
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      localObject = Boolean.valueOf(paramQQAppInterface.isRunning());
      break;
      L(paramQQAppInterface, paramInt);
      if (paramInt != 2) {
        ThreadManager.getSubThreadHandler().postDelayed(this.hC, this.aeo * 1000L);
      }
      if (paramInt != 1) {
        ThreadManager.getSubThreadHandler().postDelayed(this.hD, aob * 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "launchTimedMsgTask() schedule msgTimer after " + this.aeo + "*1000 ms.");
  }
  
  public void L(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("cancelTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject + " fetchMsgType=" + paramInt);
      }
    }
    else
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      localObject = Boolean.valueOf(paramQQAppInterface.isRunning());
      break;
      if (paramInt != 2) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.hC);
      }
    } while (paramInt == 1);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.hD);
  }
  
  /* Error */
  public ArrayList<Pair<String, Integer>> W(String paramString)
  {
    // Byte code:
    //   0: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 149
    //   8: iconst_2
    //   9: new 151	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1334
    //   19: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 76	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 77	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: aload_1
    //   41: ifnonnull +5 -> 46
    //   44: aload_3
    //   45: areturn
    //   46: aload_0
    //   47: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   50: invokeinterface 315 1 0
    //   55: aload_0
    //   56: getfield 317	anxk:AZ	Ljava/util/ArrayList;
    //   59: ifnull +29 -> 88
    //   62: ldc_w 347
    //   65: aload_1
    //   66: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +30 -> 99
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 317	anxk:AZ	Ljava/util/ArrayList;
    //   77: invokevirtual 814	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   80: pop
    //   81: aload_0
    //   82: getfield 317	anxk:AZ	Ljava/util/ArrayList;
    //   85: invokevirtual 98	java/util/ArrayList:clear	()V
    //   88: aload_0
    //   89: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   92: invokeinterface 345 1 0
    //   97: aload_3
    //   98: areturn
    //   99: aload_0
    //   100: getfield 317	anxk:AZ	Ljava/util/ArrayList;
    //   103: invokevirtual 320	java/util/ArrayList:size	()I
    //   106: iconst_1
    //   107: isub
    //   108: istore_2
    //   109: iload_2
    //   110: iflt -22 -> 88
    //   113: aload_0
    //   114: getfield 317	anxk:AZ	Ljava/util/ArrayList;
    //   117: iload_2
    //   118: invokevirtual 324	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   121: checkcast 326	com/tencent/util/Pair
    //   124: astore 4
    //   126: aload_1
    //   127: aload 4
    //   129: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   132: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +19 -> 154
    //   138: aload_3
    //   139: aload 4
    //   141: invokevirtual 464	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: aload_0
    //   146: getfield 317	anxk:AZ	Ljava/util/ArrayList;
    //   149: iload_2
    //   150: invokevirtual 342	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   153: pop
    //   154: iload_2
    //   155: iconst_1
    //   156: isub
    //   157: istore_2
    //   158: goto -49 -> 109
    //   161: astore_1
    //   162: aload_0
    //   163: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   166: invokeinterface 345 1 0
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	anxk
    //   0	173	1	paramString	String
    //   108	50	2	i	int
    //   39	100	3	localArrayList	ArrayList
    //   124	16	4	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   55	88	161	finally
    //   99	109	161	finally
    //   113	154	161	finally
  }
  
  public Pair<String, Integer> a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "addHintPair() subUin=" + paramString + " type=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() < 5) || ((paramInt != 0) && (paramInt != 1))) {
      return null;
    }
    Pair localPair1 = new Pair(paramString, Integer.valueOf(paramInt));
    this.lock.lock();
    for (;;)
    {
      try
      {
        if (this.AZ != null)
        {
          paramInt = this.AZ.size() - 1;
          if (paramInt >= 0)
          {
            Pair localPair2 = (Pair)this.AZ.get(paramInt);
            if (!paramString.equals(localPair2.first)) {
              break label248;
            }
            this.AZ.remove(paramInt);
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.d("SUB_ACCOUNT", 2, "addHintPair() remove old, subUin=" + (String)localPair2.first + " type=" + localPair2.second);
            break label248;
          }
        }
        if (this.AZ == null) {
          this.AZ = new ArrayList();
        }
        this.AZ.add(localPair1);
        return localPair1;
      }
      finally
      {
        this.lock.unlock();
      }
      label248:
      paramInt -= 1;
    }
  }
  
  public void a(SubAccountBaseActivity paramSubAccountBaseActivity)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("cancelUnbindDialog() act=");
      if (paramSubAccountBaseActivity == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, (String)localObject);
      }
    }
    else
    {
      if (paramSubAccountBaseActivity != null) {
        break label60;
      }
    }
    label60:
    while (this.AY == null)
    {
      return;
      localObject = paramSubAccountBaseActivity.getClass().getSimpleName();
      break;
    }
    int i = this.AY.size() - 1;
    while (i >= 0)
    {
      localObject = (aqju)this.AY.get(i);
      if ((localObject == null) || (((aqju)localObject).getOwnerActivity() != paramSubAccountBaseActivity) || (((aqju)localObject).isShowing())) {}
      try
      {
        ((aqju)localObject).dismiss();
        label116:
        this.AY.remove(i);
        for (;;)
        {
          i -= 1;
          break;
          this.AY.remove(i);
        }
      }
      catch (Exception localException)
      {
        break label116;
      }
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Pair<String, Integer> paramPair, android.content.DialogInterface.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +116 -> 119
    //   6: new 151	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 1359
    //   16: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 9
    //   21: aload_3
    //   22: ifnonnull +115 -> 137
    //   25: ldc_w 471
    //   28: astore 8
    //   30: aload 9
    //   32: aload 8
    //   34: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1361
    //   40: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 9
    //   45: aload_2
    //   46: ifnonnull +129 -> 175
    //   49: ldc_w 471
    //   52: astore 8
    //   54: aload 9
    //   56: aload 8
    //   58: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1363
    //   64: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: astore 9
    //   69: aload_1
    //   70: ifnonnull +117 -> 187
    //   73: ldc_w 471
    //   76: astore 8
    //   78: aload 9
    //   80: aload 8
    //   82: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 1365
    //   88: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore 9
    //   93: aload 4
    //   95: ifnonnull +100 -> 195
    //   98: ldc_w 471
    //   101: astore 8
    //   103: ldc 149
    //   105: iconst_2
    //   106: aload 9
    //   108: aload 8
    //   110: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_1
    //   120: ifnull +16 -> 136
    //   123: aload_2
    //   124: ifnull +12 -> 136
    //   127: aload_3
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: ifnonnull +70 -> 203
    //   136: return
    //   137: new 151	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   144: aload_3
    //   145: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   148: checkcast 201	java/lang/String
    //   151: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 1367
    //   157: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_3
    //   161: getfield 336	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   164: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 8
    //   172: goto -142 -> 30
    //   175: aload_2
    //   176: invokevirtual 747	java/lang/Object:getClass	()Ljava/lang/Class;
    //   179: invokevirtual 752	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   182: astore 8
    //   184: goto -130 -> 54
    //   187: ldc_w 1369
    //   190: astore 8
    //   192: goto -114 -> 78
    //   195: ldc_w 1369
    //   198: astore 8
    //   200: goto -97 -> 103
    //   203: aload_3
    //   204: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   207: checkcast 201	java/lang/String
    //   210: astore 8
    //   212: aload_3
    //   213: getfield 336	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   216: checkcast 248	java/lang/Integer
    //   219: invokevirtual 339	java/lang/Integer:intValue	()I
    //   222: istore 6
    //   224: aload_0
    //   225: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   228: invokeinterface 315 1 0
    //   233: aload_0
    //   234: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   237: ifnull +141 -> 378
    //   240: aload_0
    //   241: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   244: invokevirtual 320	java/util/ArrayList:size	()I
    //   247: iconst_1
    //   248: isub
    //   249: istore 5
    //   251: iload 5
    //   253: iflt +125 -> 378
    //   256: aload_0
    //   257: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   260: iload 5
    //   262: invokevirtual 324	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   265: checkcast 767	aqju
    //   268: astore 10
    //   270: aload 10
    //   272: ifnull +298 -> 570
    //   275: aload 10
    //   277: invokevirtual 1372	aqju:getTag	()Ljava/lang/Object;
    //   280: instanceof 326
    //   283: ifeq +287 -> 570
    //   286: aload 10
    //   288: invokevirtual 1372	aqju:getTag	()Ljava/lang/Object;
    //   291: checkcast 326	com/tencent/util/Pair
    //   294: astore 9
    //   296: aload 8
    //   298: aload 9
    //   300: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   303: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq +264 -> 570
    //   309: aload 10
    //   311: invokevirtual 1353	aqju:isShowing	()Z
    //   314: istore 7
    //   316: iload 7
    //   318: ifeq +8 -> 326
    //   321: aload 10
    //   323: invokevirtual 1356	aqju:dismiss	()V
    //   326: aload_0
    //   327: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   330: iload 5
    //   332: invokevirtual 342	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   335: pop
    //   336: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +231 -> 570
    //   342: ldc 149
    //   344: iconst_2
    //   345: new 151	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 1374
    //   355: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 9
    //   360: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   363: checkcast 201	java/lang/String
    //   366: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto +195 -> 570
    //   378: aload_2
    //   379: ldc_w 753
    //   382: invokevirtual 756	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   385: astore 10
    //   387: aload_1
    //   388: aload 8
    //   390: iconst_0
    //   391: invokestatic 907	aqgv:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   394: astore 9
    //   396: aload 9
    //   398: ifnull +181 -> 579
    //   401: aload 9
    //   403: astore_1
    //   404: aload 9
    //   406: invokevirtual 209	java/lang/String:length	()I
    //   409: ifne +6 -> 415
    //   412: goto +167 -> 579
    //   415: iload 6
    //   417: ifne +117 -> 534
    //   420: aload_2
    //   421: ldc_w 1375
    //   424: iconst_1
    //   425: anewarray 4	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_1
    //   431: aastore
    //   432: invokevirtual 760	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   435: astore_1
    //   436: aload_2
    //   437: sipush 230
    //   440: invokestatic 765	aqha:a	(Landroid/content/Context;I)Laqju;
    //   443: aload 10
    //   445: invokevirtual 771	aqju:setTitle	(Ljava/lang/String;)Laqju;
    //   448: aload_1
    //   449: invokevirtual 775	aqju:setMessage	(Ljava/lang/CharSequence;)Laqju;
    //   452: astore_1
    //   453: aload_1
    //   454: aload_3
    //   455: invokevirtual 1378	aqju:setTag	(Ljava/lang/Object;)V
    //   458: aload_1
    //   459: aload_2
    //   460: invokevirtual 779	aqju:setOwnerActivity	(Landroid/app/Activity;)V
    //   463: aload_1
    //   464: aload_2
    //   465: ldc_w 780
    //   468: invokevirtual 756	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   471: aload 4
    //   473: invokevirtual 788	aqju:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Laqju;
    //   476: pop
    //   477: aload_1
    //   478: new 1380	anxm
    //   481: dup
    //   482: aload_0
    //   483: aload 8
    //   485: iload 6
    //   487: invokespecial 1383	anxm:<init>	(Lanxk;Ljava/lang/String;I)V
    //   490: invokevirtual 1387	aqju:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   493: aload_1
    //   494: invokevirtual 795	aqju:show	()V
    //   497: aload_0
    //   498: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   501: ifnonnull +14 -> 515
    //   504: aload_0
    //   505: new 76	java/util/ArrayList
    //   508: dup
    //   509: invokespecial 77	java/util/ArrayList:<init>	()V
    //   512: putfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   515: aload_0
    //   516: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   519: aload_1
    //   520: invokevirtual 464	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   523: pop
    //   524: aload_0
    //   525: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   528: invokeinterface 345 1 0
    //   533: return
    //   534: aload_2
    //   535: ldc_w 1388
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload_1
    //   545: aastore
    //   546: invokevirtual 760	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   549: astore_1
    //   550: goto -114 -> 436
    //   553: astore_1
    //   554: aload_0
    //   555: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   558: invokeinterface 345 1 0
    //   563: aload_1
    //   564: athrow
    //   565: astore 10
    //   567: goto -241 -> 326
    //   570: iload 5
    //   572: iconst_1
    //   573: isub
    //   574: istore 5
    //   576: goto -325 -> 251
    //   579: aload 8
    //   581: astore_1
    //   582: goto -167 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	anxk
    //   0	585	1	paramQQAppInterface	QQAppInterface
    //   0	585	2	paramBaseActivity	BaseActivity
    //   0	585	3	paramPair	Pair<String, Integer>
    //   0	585	4	paramOnClickListener	android.content.DialogInterface.OnClickListener
    //   249	326	5	i	int
    //   222	264	6	j	int
    //   314	3	7	bool	boolean
    //   28	552	8	str	String
    //   19	386	9	localObject1	Object
    //   268	176	10	localObject2	Object
    //   565	1	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   233	251	553	finally
    //   256	270	553	finally
    //   275	316	553	finally
    //   321	326	553	finally
    //   326	375	553	finally
    //   378	396	553	finally
    //   404	412	553	finally
    //   420	436	553	finally
    //   436	515	553	finally
    //   515	524	553	finally
    //   534	550	553	finally
    //   321	326	565	java/lang/Exception
  }
  
  public void ee(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isRunning())) {}
    do
    {
      return;
      if (this.hB != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.hB);
      }
      if (this.hB == null) {
        this.hB = new SubAccountControll.6(this, paramQQAppInterface);
      }
      ThreadManager.getSubThreadHandler().postDelayed(this.hB, this.aoc * 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "launchTimedThirdQQUnreadNumTask() next req after " + this.aoc + "s.");
  }
  
  public void onDestroy()
  {
    this.lock.lock();
    try
    {
      if (this.AY != null)
      {
        Iterator localIterator = this.AY.iterator();
        while (localIterator.hasNext())
        {
          aqju localaqju = (aqju)localIterator.next();
          try
          {
            if (localaqju.isShowing()) {
              localaqju.dismiss();
            }
          }
          catch (Exception localException) {}
        }
        this.AY.clear();
      }
      this.AY = null;
      if (this.AZ != null) {
        this.AZ.clear();
      }
      this.AZ = null;
      this.lock.unlock();
      ThreadManager.getSubThreadHandler().removeCallbacks(this.hC);
      ThreadManager.getSubThreadHandler().removeCallbacks(this.hD);
      if (this.hB != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.hB);
        this.hB = null;
      }
      if (this.Ba != null) {
        this.Ba.clear();
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  /* Error */
  public void v(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 149
    //   8: iconst_2
    //   9: new 151	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1403
    //   19: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 290
    //   29: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +11 -> 54
    //   46: aload_1
    //   47: invokevirtual 209	java/lang/String:length	()I
    //   50: iconst_5
    //   51: if_icmpge +4 -> 55
    //   54: return
    //   55: aload_0
    //   56: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   59: invokeinterface 315 1 0
    //   64: aload_0
    //   65: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   68: ifnull +253 -> 321
    //   71: aload_0
    //   72: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   75: invokevirtual 320	java/util/ArrayList:size	()I
    //   78: iconst_1
    //   79: isub
    //   80: istore 5
    //   82: iload 5
    //   84: iflt +237 -> 321
    //   87: aload_0
    //   88: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   91: iload 5
    //   93: invokevirtual 324	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   96: checkcast 767	aqju
    //   99: astore 7
    //   101: aload 7
    //   103: ifnull +162 -> 265
    //   106: aload 7
    //   108: invokevirtual 1372	aqju:getTag	()Ljava/lang/Object;
    //   111: astore 8
    //   113: aload 8
    //   115: ifnull +193 -> 308
    //   118: aload 8
    //   120: instanceof 326
    //   123: ifeq +185 -> 308
    //   126: aload 8
    //   128: checkcast 326	com/tencent/util/Pair
    //   131: astore 8
    //   133: iload_3
    //   134: ifeq +156 -> 290
    //   137: aload_1
    //   138: aload 8
    //   140: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   143: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +190 -> 336
    //   149: iload_2
    //   150: aload 8
    //   152: getfield 336	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   155: checkcast 248	java/lang/Integer
    //   158: invokevirtual 339	java/lang/Integer:intValue	()I
    //   161: if_icmpne +175 -> 336
    //   164: iconst_1
    //   165: istore 4
    //   167: iload 4
    //   169: ifeq +173 -> 342
    //   172: aload 7
    //   174: invokevirtual 1353	aqju:isShowing	()Z
    //   177: istore 6
    //   179: iload 6
    //   181: ifeq +8 -> 189
    //   184: aload 7
    //   186: invokevirtual 1356	aqju:dismiss	()V
    //   189: aload_0
    //   190: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   193: iload 5
    //   195: invokevirtual 342	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   198: pop
    //   199: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +140 -> 342
    //   205: ldc 149
    //   207: iconst_2
    //   208: new 151	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 1405
    //   218: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 8
    //   223: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   226: checkcast 201	java/lang/String
    //   229: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 290
    //   235: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 8
    //   240: getfield 336	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   243: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: ldc_w 1407
    //   249: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_3
    //   253: invokevirtual 354	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto +80 -> 342
    //   265: aload_0
    //   266: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   269: iload 5
    //   271: invokevirtual 342	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   274: pop
    //   275: goto +67 -> 342
    //   278: astore_1
    //   279: aload_0
    //   280: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   283: invokeinterface 345 1 0
    //   288: aload_1
    //   289: athrow
    //   290: aload_1
    //   291: aload 8
    //   293: getfield 330	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   296: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +37 -> 336
    //   302: iconst_1
    //   303: istore 4
    //   305: goto -138 -> 167
    //   308: aload_0
    //   309: getfield 1346	anxk:AY	Ljava/util/ArrayList;
    //   312: iload 5
    //   314: invokevirtual 342	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   317: pop
    //   318: goto +24 -> 342
    //   321: aload_0
    //   322: getfield 62	anxk:lock	Ljava/util/concurrent/locks/Lock;
    //   325: invokeinterface 345 1 0
    //   330: return
    //   331: astore 7
    //   333: goto -144 -> 189
    //   336: iconst_0
    //   337: istore 4
    //   339: goto -172 -> 167
    //   342: iload 5
    //   344: iconst_1
    //   345: isub
    //   346: istore 5
    //   348: goto -266 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	anxk
    //   0	351	1	paramString	String
    //   0	351	2	paramInt	int
    //   0	351	3	paramBoolean	boolean
    //   165	173	4	i	int
    //   80	267	5	j	int
    //   177	3	6	bool	boolean
    //   99	86	7	localaqju	aqju
    //   331	1	7	localException	Exception
    //   111	181	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   64	82	278	finally
    //   87	101	278	finally
    //   106	113	278	finally
    //   118	133	278	finally
    //   137	164	278	finally
    //   172	179	278	finally
    //   184	189	278	finally
    //   189	262	278	finally
    //   265	275	278	finally
    //   290	302	278	finally
    //   308	318	278	finally
    //   184	189	331	java/lang/Exception
  }
  
  static class a
  {
    String key;
    Object value;
    
    public a(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.value = paramObject;
    }
  }
  
  public static class b
  {
    public boolean showRedDot;
    public int unReadCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxk
 * JD-Core Version:    0.7.0.1
 */