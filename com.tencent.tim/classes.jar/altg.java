import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;

public class altg
{
  private static String TAG = "ReceiptUtil";
  private static boolean init;
  private static aure<Integer> m;
  
  private static void G(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setSentNum: " + paramInt);
    }
    m.put(parseLong(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(paramInt));
    paramQQAppInterface.getPreferences().edit().putInt("receipt_msg_sent_num", paramInt).apply();
  }
  
  public static int Y(QQAppInterface paramQQAppInterface)
  {
    if (!init) {
      z(paramQQAppInterface);
    }
    return wiq.bNA;
  }
  
  public static int Z(QQAppInterface paramQQAppInterface)
  {
    if (!init) {
      z(paramQQAppInterface);
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong("receipt_msg_store_time", 0L);
    long l2 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!z(l1, l2))
    {
      G(paramQQAppInterface, 0);
      localSharedPreferences.edit().putLong("receipt_msg_store_time", l2).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getLeftNum max is " + Y(paramQQAppInterface));
    }
    return Y(paramQQAppInterface) - aa(paramQQAppInterface);
  }
  
  public static boolean aM(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        bool1 = bool2;
        if (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static int aa(QQAppInterface paramQQAppInterface)
  {
    int i = ((Integer)m.get(parseLong(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getSentNum is " + i);
    }
    return i;
  }
  
  public static void dL(QQAppInterface paramQQAppInterface)
  {
    if (!init) {
      z(paramQQAppInterface);
    }
    int i = aa(paramQQAppInterface) + 1;
    G(paramQQAppInterface, i);
    if (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(TAG, 2, "increaseSentNum with result:  " + Integer.toString(i));
  }
  
  private static long parseLong(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, QLog.getStackTraceString(paramString));
      }
    }
    return -1L;
  }
  
  private static void z(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    m = new aure(1);
    int i = localSharedPreferences.getInt("receipt_msg_sent_num", 0);
    m.put(parseLong(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(i));
    init = true;
  }
  
  private static boolean z(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    Date localDate = localCalendar.getTime();
    localCalendar.setTimeInMillis(paramLong1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    if (localDate.compareTo(localCalendar.getTime()) == 0) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, paramLong1 + " and " + paramLong2 + "isToday? " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altg
 * JD-Core Version:    0.7.0.1
 */