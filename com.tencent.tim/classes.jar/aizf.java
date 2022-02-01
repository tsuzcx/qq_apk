import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class aizf
  implements Observer, Manager
{
  public static long aaO;
  public static long acb;
  public static long acc = -1L;
  private static CopyOnWriteArrayList<RecentBaseData> aj = new CopyOnWriteArrayList();
  public static boolean cmQ;
  public static volatile boolean cmR;
  public static boolean cmS;
  public static boolean cmT;
  public static boolean cmU;
  public static boolean cmV;
  public static String deviceInfo;
  public static int dhe;
  public static int dhf;
  private static ConcurrentHashMap<String, Integer> fN = new ConcurrentHashMap();
  public static boolean hasReport;
  private static byte[] lock = new byte[0];
  public static boolean needReport = true;
  private QQAppInterface app;
  alkm jdField_b_of_type_Alkm = null;
  private ysf jdField_b_of_type_Ysf;
  
  static
  {
    deviceInfo = "";
  }
  
  public aizf(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    deviceInfo = AppSetting.aHR;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + deviceInfo);
    }
    if (this.jdField_b_of_type_Ysf == null) {
      this.jdField_b_of_type_Ysf = ((ysf)this.app.getManager(34));
    }
    if (this.jdField_b_of_type_Alkm == null) {
      this.jdField_b_of_type_Alkm = ((alkm)this.app.getManager(38));
    }
  }
  
  public static boolean apZ()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      cmT = true;
      return cmT;
    }
    cmT = DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.lock_screen.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + cmT);
    }
    return cmT;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    aurk.o(paramQQAppInterface, paramMessageRecord);
    a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramBoolean, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "startQQLs but  app is null ,return");
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramQQAppInterface.isLogin()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("QQLSActivity", 2, "startQQLs but is not login ,return");
          return;
          if (((aury)paramQQAppInterface.getBusinessHandler(146)).ax(paramString, paramInt1)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQLSActivity", 2, "startQQLs but is Notification not permitted ,return");
        return;
      } while (deviceInfo.equalsIgnoreCase("HUAWEI-HUAWEI T8833"));
      bool = aqa();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, String.format("needStartQQLS frienduin[%s], uitype[%s], isFromMisscall[%s], isStartTime[%s]", new Object[] { paramString, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
      }
    } while (!bool);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label684;
      }
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "locking activity:" + (String)localObject);
      }
      if ((!((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) && (!((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) && (!((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        break label646;
      }
      i = 1;
    }
    for (;;)
    {
      label267:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLSalive:" + cmR);
      }
      if (paramInt1 == 1)
      {
        cmS = true;
        label310:
        if (i != 0) {
          break label657;
        }
        if ((!jkg.isCalling(BaseApplicationImpl.getApplication())) && ((!cmR) || (paramBoolean)))
        {
          if ((!a(paramQQAppInterface, paramString, paramInt1, paramBoolean, paramInt2, true)) || (Build.VERSION.SDK_INT > 28)) {
            break label659;
          }
          localObject = new Intent(paramQQAppInterface.getApp(), QQLSActivity.class);
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).addFlags(262144);
          ((Intent)localObject).putExtra("notifyId", paramInt2);
          ((Intent)localObject).putExtra("uitype", paramInt1);
          ((Intent)localObject).putExtra("frienduin", paramString);
          paramQQAppInterface.getApp().startActivity((Intent)localObject);
          cmU = true;
          dhf += 1;
          if (QLog.isColorLevel()) {
            QLog.d("qqls", 2, "need report  LS report needReport=" + needReport + "hasReport=" + hasReport + "startTimes=" + dhf);
          }
          if ((!hasReport) && (dhf > 2))
          {
            paramString = new HashMap();
            paramString.put("param_hasshowedLs", needReport + "");
            anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "qqlsReprotTag", true, 0L, 0L, paramString, "");
            if (QLog.isColorLevel()) {
              QLog.d("qqls", 2, "need report  LS report needReport=" + needReport);
            }
            hasReport = true;
          }
        }
      }
      for (;;)
      {
        if (!QLog.isDevelopLevel()) {
          break label682;
        }
        QLog.d("QQLSActivity", 4, String.format("needStartQQLS end...", new Object[0]));
        return;
        label646:
        i = 0;
        break label267;
        cmS = false;
        break label310;
        label657:
        break;
        label659:
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, String.format("needStartQQLS updateLSRencentUser fail...", new Object[0]));
        }
      }
      label682:
      break;
      label684:
      i = 0;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    synchronized (lock)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!, thread[" + Thread.currentThread().getId() + "], uin[" + paramString + "], uinType[" + paramInt1 + "], isFromMisscall[" + paramBoolean1);
      }
      localObject3 = paramQQAppInterface.b().d(paramString, paramInt1);
      if ((paramInt1 != 1001) || (afcw.am((MessageRecord)localObject3))) {
        break label2495;
      }
      paramString = acbn.bkF;
      if ((!acbn.blf.equals(paramString)) && (!acbn.ble.equals(paramString)) && (!acbn.bkF.equals(paramString))) {
        break label314;
      }
      paramQQAppInterface = aaiv.a(new RecentUser(paramString, paramInt1), paramQQAppInterface, paramQQAppInterface.getApp());
      localObject1 = aj.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (TextUtils.equals(((RecentBaseData)localObject2).qx(), paramString))
        {
          aj.remove(localObject2);
          fN.remove(((RecentBaseData)localObject2).qx() + ((RecentBaseData)localObject2).ng());
        }
      }
    }
    if (paramQQAppInterface != null)
    {
      aj.add(0, paramQQAppInterface);
      if (paramBoolean2) {
        fN.put(paramQQAppInterface.qx() + paramQQAppInterface.ng(), Integer.valueOf(paramInt2));
      }
    }
    return true;
    label314:
    int i;
    label348:
    acxw localacxw;
    label485:
    boolean bool;
    label513:
    label546:
    label547:
    label555:
    label637:
    int j;
    if ((!awit.cA(paramQQAppInterface)) && (paramInt1 == 7220) && (acbn.blx.equals(paramString)))
    {
      localObject1 = acbn.blw;
      i = 1008;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + aj.size() + "threadId =" + Thread.currentThread().getId());
      }
      if ((FriendsStatusUtil.g((String)localObject1, paramQQAppInterface)) || (wvo.a((String)localObject1, i, paramQQAppInterface))) {
        return false;
      }
      localacxw = paramQQAppInterface.a().a();
      localObject2 = localacxw.b(true, false).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        paramString = (RecentUser)((Iterator)localObject2).next();
        if (paramString != null)
        {
          RecentBaseData localRecentBaseData;
          if (TextUtils.isEmpty(paramString.uin))
          {
            paramString = null;
            if (!QLog.isColorLevel()) {
              break label2498;
            }
            localObject2 = new StringBuilder().append("updateLSRencentUser curUser is not null: ");
            if (paramString == null) {
              break label2588;
            }
            bool = true;
            QLog.d("QQLSActivity", 2, bool + "threadId =" + Thread.currentThread().getId());
            break label2498;
            break label1036;
            localObject2 = aj.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
            } while ((TextUtils.equals(localRecentBaseData.qx(), acbn.blf)) || (TextUtils.equals(localRecentBaseData.qx(), acbn.ble)));
            paramInt1 = 0;
            if (!TextUtils.equals(localRecentBaseData.qx(), acbn.bkE)) {
              break label1060;
            }
            paramInt1 = paramQQAppInterface.a().A(acbn.bkE, localRecentBaseData.ng());
          }
          for (;;)
          {
            label701:
            Object localObject4;
            if ((localRecentBaseData.ng() == 3000) || (localRecentBaseData.ng() == 0) || (localRecentBaseData.ng() == 8))
            {
              localRecentBaseData.c(paramQQAppInterface, BaseApplication.getContext());
              if (this.jdField_b_of_type_Alkm == null) {
                break label2470;
              }
              j = this.jdField_b_of_type_Alkm.ae(localRecentBaseData.qx(), localRecentBaseData.ng());
              if (!QLog.isColorLevel()) {
                break label2577;
              }
              localObject4 = localRecentBaseData.qx();
              int k = localRecentBaseData.ng();
              if (this.jdField_b_of_type_Alkm == null) {
                break label2600;
              }
              bool = true;
              label731:
              QLog.d("QQLSActivity", 2, String.format("QQLSRecentManager.updateLSRencentUser miscallUnread[%s], Uin[%s], type[%s]", new Object[] { Integer.valueOf(j), localObject4, Integer.valueOf(k), Boolean.valueOf(bool) }));
              break label2577;
            }
            label779:
            if (paramInt1 != 0) {
              break label2583;
            }
            aj.remove(localRecentBaseData);
            fN.remove(localRecentBaseData.qx() + localRecentBaseData.ng());
            break label555;
            if ((paramString != null) && (((String)localObject1).equals(paramString.uin)) && (paramString.getType() == i)) {
              break label485;
            }
            if ((paramString != null) && (paramString.getType() == i) && (acbn.bku.equals(paramString.uin)))
            {
              paramString = new RecentUser((String)localObject1, i);
              break label485;
            }
            if (((paramString != null) && (paramString.getType() == i) && (acbn.bkE.equals(paramString.uin))) || ((paramString != null) && (paramString.getType() == i) && (acbn.bkY.equals(paramString.uin)))) {
              break label485;
            }
            if ((paramString != null) && (acbn.bkA.equals(paramString.uin)) && ((acbn.bkJ.equals(localObject1)) || (acbn.blu.equals(localObject1)) || (acbn.blC.equals(localObject1)))) {
              break label2585;
            }
            if ((paramString == null) || (paramString.getType() != 1032) || (top.eD(i) != 1032)) {
              break;
            }
            break label485;
            label1036:
            if (((alkm)paramQQAppInterface.getManager(38)).ae((String)localObject1, i) != 0) {
              break label547;
            }
            return false;
            label1060:
            if (TextUtils.equals(localRecentBaseData.qx(), acbn.bkA))
            {
              if (((String)localObject1).equals(acbn.bkJ)) {
                paramInt1 = paramQQAppInterface.a().A(acbn.bkJ, localRecentBaseData.ng());
              } else {
                paramInt1 = ((ysf)paramQQAppInterface.getManager(34)).xq();
              }
            }
            else if (TextUtils.equals(localRecentBaseData.qx(), acbn.bkY))
            {
              paramInt1 = paramQQAppInterface.a().A(acbn.bkY, localRecentBaseData.ng());
            }
            else
            {
              if (TextUtils.equals(localRecentBaseData.qx(), acbn.blc))
              {
                localObject4 = (afci)paramQQAppInterface.getManager(71);
                if (localObject4 == null) {
                  break label2476;
                }
                paramInt1 = ((afci)localObject4).a().getUnreadCount();
                break label2594;
              }
              if (TextUtils.equals(localRecentBaseData.qx(), acbn.blt))
              {
                localObject4 = (aizc)paramQQAppInterface.getManager(145);
                if (localObject4 == null) {
                  break label2597;
                }
                paramInt1 = ((aizc)localObject4).getUnreadCount();
                break label2597;
              }
              paramInt1 = paramQQAppInterface.a().A(localRecentBaseData.qx(), localRecentBaseData.ng());
            }
          }
          j = 0;
          localObject2 = null;
          if (paramString == null) {
            break label2606;
          }
          if (paramString.uin.equals(acbn.bkE))
          {
            paramInt1 = paramQQAppInterface.a().A(acbn.bkE, paramString.getType());
            paramString = aaiv.a(paramString, paramQQAppInterface, paramQQAppInterface.getApp());
          }
          for (;;)
          {
            label1304:
            if ((paramInt1 <= 0) || (paramString == null)) {
              break label2375;
            }
            if ((ysf.u(paramQQAppInterface, paramString.qx())) && (acbn.bla.equals(paramString.qx()))) {
              paramString.mTitleName = paramQQAppInterface.getApp().getString(2131689681);
            }
            localObject1 = aj.iterator();
            label1358:
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (RecentBaseData)((Iterator)localObject1).next();
              if ((!ysf.u(paramQQAppInterface, ((RecentBaseData)localObject2).qx())) || (!ysf.u(paramQQAppInterface, paramString.qx()))) {
                break label2021;
              }
              aj.remove(localObject2);
              fN.remove(paramString.qx() + paramString.ng());
            }
            label1443:
            aj.add(0, paramString);
            if (paramBoolean2) {
              fN.put(paramString.qx() + paramString.ng(), Integer.valueOf(paramInt2));
            }
            label1492:
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + aj.size());
            }
            if (aj.size() <= 0) {
              break label2461;
            }
            return true;
            if (paramString.uin.equals(acbn.bkA))
            {
              if (((String)localObject1).equals(acbn.bkJ))
              {
                paramInt1 = paramQQAppInterface.a().A(acbn.bkJ, paramString.getType());
                break;
              }
              paramInt1 = ((ysf)paramQQAppInterface.getManager(34)).xq();
              anot.a(paramQQAppInterface, "dc00898", "", "", "0X80077D5", "0X80077D5", 0, 0, "", "", "", "");
              break;
            }
            if (paramString.uin.equals(acbn.bkY))
            {
              paramInt1 = paramQQAppInterface.a().A(acbn.bkY, paramString.getType());
              break;
            }
            paramInt1 = paramQQAppInterface.a().A(paramString.uin, paramString.getType());
            break;
            label1678:
            paramString = (String)localObject2;
            paramInt1 = j;
            if (!anwa.aze())
            {
              i = paramQQAppInterface.a().A((String)localObject1, i);
              paramString = (String)localObject2;
              paramInt1 = i;
              if (localObject3 != null)
              {
                paramString = (String)localObject2;
                paramInt1 = i;
                if (((MessageRecord)localObject3).senderuin != null)
                {
                  paramString = new RecentMatchChatListItem((MessageRecord)localObject3);
                  paramString.c(paramQQAppInterface, BaseApplication.getContext());
                  paramInt1 = i;
                  continue;
                  label1752:
                  if (i == 1012)
                  {
                    paramString = (afci)paramQQAppInterface.getManager(71);
                    if (paramString == null) {
                      break label2463;
                    }
                    paramInt1 = paramString.a().getUnreadCount();
                    paramString = paramString.a().b();
                    break label2625;
                  }
                  if (i == 1030)
                  {
                    paramString = (String)localObject2;
                    paramInt1 = j;
                    if (paramQQAppInterface.iz(240))
                    {
                      paramString = (aeam)paramQQAppInterface.getManager(240);
                      paramInt1 = paramString.getUnreadCount();
                      paramString = paramString.b();
                    }
                  }
                  else
                  {
                    if (i != 9653) {
                      break label2628;
                    }
                    paramString = (aizc)paramQQAppInterface.getManager(145);
                    paramInt1 = paramString.getUnreadCount();
                    paramString = paramString.a;
                  }
                }
              }
            }
          }
        }
      }
    }
    label2375:
    for (;;)
    {
      label1873:
      paramString = (String)localObject2;
      paramInt1 = j;
      if (!paramQQAppInterface.iz(284)) {
        break label1304;
      }
      paramString = (aizd)paramQQAppInterface.getManager(284);
      paramInt1 = 1;
      paramString = paramString.b();
      break label1304;
      label2021:
      do
      {
        localObject3 = localacxw.a((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject3 == null) {
          break label1304;
        }
        ((RecentUser)localObject3).lastmsgtime = anaz.gQ();
        localObject2 = aaiv.a((RecentUser)localObject3, paramQQAppInterface, paramQQAppInterface.getApp());
        paramString = (String)localObject2;
        paramInt1 = j;
        if (i != 8) {
          break label1304;
        }
        localObject1 = paramQQAppInterface.a().a().b((String)localObject1, i);
        paramString = (String)localObject2;
        paramInt1 = j;
        if (localObject1 == null) {
          break label1304;
        }
        ((RecentBaseData)localObject2).mExtraType = ((QCallRecent)localObject1).extraType;
        ((RecentBaseData)localObject2).mPhoneNumber = ((QCallRecent)localObject1).phoneNumber;
        paramString = (String)localObject2;
        paramInt1 = j;
        break label1304;
        if ((TextUtils.equals(((RecentBaseData)localObject2).qx(), paramString.qx())) && (((RecentBaseData)localObject2).ng() == paramString.ng()))
        {
          aj.remove(localObject2);
          fN.remove(paramString.qx() + paramString.ng());
          break label1443;
        }
        if ((TextUtils.equals(paramString.qx(), acbn.bkE)) && (TextUtils.equals(((RecentBaseData)localObject2).qx(), paramString.qx())))
        {
          aj.remove(localObject2);
          fN.remove(paramString.qx() + paramString.ng());
          break label1443;
        }
        if ((TextUtils.equals(paramString.qx(), acbn.bln)) && (TextUtils.equals(((RecentBaseData)localObject2).qx(), paramString.qx())))
        {
          aj.remove(localObject2);
          fN.remove(paramString.qx() + paramString.ng());
          break label1443;
        }
        if ((TextUtils.equals(paramString.qx(), acbn.bkY)) && (TextUtils.equals(((RecentBaseData)localObject2).qx(), paramString.qx())))
        {
          aj.remove(localObject2);
          fN.remove(paramString.qx() + paramString.ng());
          break label1443;
        }
        if ((!TextUtils.equals(paramString.qx(), acbn.bkA)) || (!TextUtils.equals(((RecentBaseData)localObject2).qx(), paramString.qx()))) {
          break label1358;
        }
        aj.remove(localObject2);
        fN.remove(paramString.qx() + paramString.ng());
        break label1443;
        if ((!paramBoolean1) || (paramString == null) || (aj.contains(paramString))) {
          break label1492;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
        }
        aj.add(0, paramString);
        if (!paramBoolean2) {
          break label1492;
        }
        fN.put(paramString.qx() + paramString.ng(), Integer.valueOf(paramInt2));
        break label1492;
        return false;
        paramString = null;
        paramInt1 = 0;
        break label2625;
        j = 0;
        break label701;
        paramInt1 = 0;
        break label2594;
        paramString = null;
        break label485;
        localObject1 = paramString;
        i = paramInt1;
        break label348;
        break;
        if ((paramString != null) || (i == 1012) || (i == 7432) || (i == 9653) || (i == 1030) || (i == 1035) || (i == 1041) || (i == 1042) || (i == 1044)) {
          break label547;
        }
        if (i != 1045) {
          break label546;
        }
        break label547;
        if (j > 0) {
          break label555;
        }
        break label779;
        break label555;
        break label485;
        bool = false;
        break label513;
        break label637;
        break label637;
        bool = false;
        break label731;
        if (i == 1044) {
          break label1678;
        }
        if (i != 1045) {
          break label1752;
        }
        break label1678;
        break label1304;
        if ((i == 1035) || (i == 1041)) {
          break label1873;
        }
      } while (i != 1042);
    }
  }
  
  public boolean aqa()
  {
    long l = System.currentTimeMillis();
    if ((acc > 0L) && (l - acc < 5000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "isNeedStart false ,less than 5sec");
      }
      return false;
    }
    return true;
  }
  
  public void cOx()
  {
    aj.clear();
    fN.clear();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mDataList clear");
    }
  }
  
  public int du(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "getNotifyIDForUin mNotifyIdList.size = " + fN.size());
    }
    if (fN.containsKey(paramString))
    {
      Integer localInteger = (Integer)fN.get(paramString);
      if (localInteger != null) {}
      for (int i = localInteger.intValue();; i = -1)
      {
        fN.remove(paramString);
        return i;
      }
    }
    return -1;
  }
  
  public void eY(String paramString, int paramInt)
  {
    for (;;)
    {
      RecentBaseData localRecentBaseData;
      int j;
      int i;
      synchronized (lock)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "removeUnreadMsg mDataList= " + aj.size());
        }
        Iterator localIterator = aj.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localRecentBaseData = (RecentBaseData)localIterator.next();
        j = this.app.a().A(localRecentBaseData.qx(), localRecentBaseData.ng());
        int k = this.jdField_b_of_type_Alkm.ae(localRecentBaseData.qx(), localRecentBaseData.ng());
        if (localRecentBaseData.qx().equals(acbn.bkE))
        {
          i = this.app.a().A(acbn.bkE, localRecentBaseData.ng());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          aj.remove(localRecentBaseData);
          fN.remove(localRecentBaseData.qx() + localRecentBaseData.ng());
        }
      }
      if (localRecentBaseData.qx().equals(acbn.bkA))
      {
        i = ((ysf)this.app.getManager(34)).xq();
      }
      else if (localRecentBaseData.qx().equals(acbn.bkY))
      {
        i = this.app.a().A(acbn.bkY, localRecentBaseData.ng());
      }
      else
      {
        i = j;
        if (localRecentBaseData.qx().equals(paramString))
        {
          i = j;
          if (paramInt == localRecentBaseData.ng())
          {
            aj.remove(localRecentBaseData);
            fN.remove(localRecentBaseData.qx() + localRecentBaseData.ng());
            i = j;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + aj.size());
    }
  }
  
  public CopyOnWriteArrayList<RecentBaseData> f()
  {
    return aj;
  }
  
  public void onDestroy()
  {
    if (this.jdField_b_of_type_Ysf != null) {
      this.jdField_b_of_type_Ysf = null;
    }
    if (this.jdField_b_of_type_Alkm != null) {
      this.jdField_b_of_type_Alkm = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ytv)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (aqlr.isScreenLocked(this.app.getApp())) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
      }
    }
    label77:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = ((ysf)this.app.getManager(34)).xq();
        } while ((TextUtils.isEmpty(((ytv)paramObject).o(this.app))) || (((ytv)paramObject).Kz == 0L));
        if ((i != 0) && (!cmV)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + cmV);
      return;
      bool1 = SettingCloneUtil.readValue(this.app.getApp(), this.app.getAccount(), this.app.getApp().getString(2131695500), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.app.getApp(), this.app.getAccount(), this.app.getApp().getString(2131718988), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.app, acbn.bkA, 4000, false, aizb.a(acbn.bkA, 4000, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizf
 * JD-Core Version:    0.7.0.1
 */