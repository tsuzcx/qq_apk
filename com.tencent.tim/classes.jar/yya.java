import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yya
{
  private static boolean bpJ;
  private static boolean mIsShow;
  
  public static void Bc(boolean paramBoolean)
  {
    mIsShow = paramBoolean;
  }
  
  public static void Bd(boolean paramBoolean)
  {
    bpJ = paramBoolean;
  }
  
  public static void EJ(int paramInt)
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("remindcntofoneweak", paramInt).apply();
    }
  }
  
  public static void EK(int paramInt)
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("remindcntofoneday", paramInt).apply();
    }
  }
  
  public static boolean UN()
  {
    return mIsShow;
  }
  
  public static boolean UO()
  {
    return bpJ;
  }
  
  public static void av(int paramInt1, int paramInt2, int paramInt3)
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putInt("lastshowtime_year", paramInt1).apply();
      localSharedPreferences.edit().putInt("lastshowtime_day", paramInt2).apply();
      localSharedPreferences.edit().putInt("lastshowtime_weak", paramInt3).apply();
    }
  }
  
  public static void cmU()
  {
    new ArrayList();
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((QQAppInterface)localObject1).b().b(acbn.bkK, 0, null);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    long l1 = ey();
    localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (!(localObject2 instanceof MessageForSystemMsg)) {
        break label170;
      }
      localObject2 = ((MessageForSystemMsg)localObject2).getSystemMsg();
      if ((localObject2 == null) || (!((structmsg.StructMsg)localObject2).msg.has()) || (((structmsg.SystemMsg)((structmsg.StructMsg)localObject2).msg.get()).sub_type.get() != 1)) {
        break label170;
      }
      long l2 = ((structmsg.StructMsg)localObject2).msg_seq.get();
      if (l2 <= l1) {
        break label170;
      }
      l1 = l2;
    }
    label170:
    for (;;)
    {
      break;
      gx(l1);
      return;
    }
  }
  
  public static List<Integer> dg()
  {
    SharedPreferences localSharedPreferences = k();
    ArrayList localArrayList = new ArrayList();
    if (localSharedPreferences == null) {
      return localArrayList;
    }
    localArrayList.add(0, Integer.valueOf(localSharedPreferences.getInt("lastshowtime_year", 0)));
    localArrayList.add(1, Integer.valueOf(localSharedPreferences.getInt("lastshowtime_day", 0)));
    localArrayList.add(2, Integer.valueOf(localSharedPreferences.getInt("lastshowtime_weak", 0)));
    return localArrayList;
  }
  
  public static long ey()
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("lastundealmsgseq", 0L);
  }
  
  public static long ez()
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences == null) {
      return 0L;
    }
    return localSharedPreferences.getLong("intervelshowtime", 0L);
  }
  
  public static boolean gQ(int paramInt)
  {
    aein localaein = (aein)aeif.a().o(634);
    if (localaein == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "troopNotificationConfig is null" });
      }
      return false;
    }
    if (!localaein.bUc)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, "isGlobalOpen is false");
      }
      return false;
    }
    if ((paramInt < localaein.cNh) || (localaein.cNh == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "undealMsgCount =", Integer.valueOf(paramInt), "todoGroupVerifyMsgLevel =", Integer.valueOf(localaein.cNh) });
      }
      return false;
    }
    if (UN()) {
      return true;
    }
    Calendar.getInstance();
    List localList = dg();
    int j;
    int i;
    if (localList != null)
    {
      j = ((Integer)localList.get(0)).intValue();
      i = ((Integer)localList.get(1)).intValue();
      paramInt = ((Integer)localList.get(2)).intValue();
    }
    for (;;)
    {
      if ((1 != j) || (3 != paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Year is changed, The time update" });
        }
        EJ(0);
        EK(0);
        av(1, 6, 3);
      }
      while ((System.currentTimeMillis() - ez()) / 1000L < localaein.We)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "The TimeIntervel is  little" });
        }
        return false;
        if (6 != i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "Day is changed, The day update" });
          }
          EK(0);
          av(1, 6, 3);
        }
      }
      if ((1 == j) && (6 == i) && (xS() >= localaein.cNg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneDay =", Integer.valueOf(xS()), "totalRemindCntOfOneDay =", Integer.valueOf(localaein.cNg) });
        }
        return false;
      }
      if ((1 == j) && (3 == paramInt) && (xR() >= localaein.cNf))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyHelper", 2, new Object[] { "isShowUndealTipsInTabRecent", "RemindCntOfOneWeak =", Integer.valueOf(xS()), "totalRemindCntOfOneWeak =", Integer.valueOf(localaein.cNf) });
        }
        return false;
      }
      return true;
      paramInt = 0;
      i = 0;
      j = 0;
    }
  }
  
  public static void gx(long paramLong)
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("lastundealmsgseq", paramLong).apply();
    }
  }
  
  public static void gy(long paramLong)
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("intervelshowtime", paramLong).apply();
    }
  }
  
  private static SharedPreferences k()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "notify_redpoint" + str;
    return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0);
  }
  
  public static int xR()
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("lastshowtime_weak", 0);
  }
  
  public static int xS()
  {
    SharedPreferences localSharedPreferences = k();
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("remindcntofoneday", 0);
  }
  
  public static int xT()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return 0;
    }
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((QQAppInterface)localObject).b().b(acbn.bkK, 0, null);
    long l = ey();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg_seq.get() > l)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    return localArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yya
 * JD-Core Version:    0.7.0.1
 */