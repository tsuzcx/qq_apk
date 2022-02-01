import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class apnt
{
  private static String B(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 3000) {
      return apnu.aD(paramString, i);
    }
  }
  
  private static int a(int paramInt, MessageRecord paramMessageRecord)
  {
    int j = -1;
    boolean bool = ajpt.aL(paramMessageRecord);
    int i;
    if (paramInt != 27) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("getFlowersCounts, bizType = ").append(paramInt).append(", isNearbyFlowerMsg = ").append(bool).append(", msgType = ");
        paramInt = j;
        if (paramMessageRecord != null) {
          paramInt = paramMessageRecord.msgtype;
        }
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, paramInt + ", flowersCount = " + i);
      }
      return i;
      if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool))
      {
        i = -1;
      }
      else
      {
        if (bool)
        {
          if ((paramMessageRecord instanceof MessageForStructing)) {
            i = ajpt.a((MessageForStructing)paramMessageRecord);
          }
        }
        else
        {
          if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
          {
            i = ((MessageForDeliverGiftTips)paramMessageRecord).giftCount;
            continue;
          }
          i = -1;
          continue;
        }
        i = -1;
      }
    }
  }
  
  @Nullable
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramString, paramaozx, paramMessageRecord, paramBoolean);
    return b(paramQQAppInterface, paramString, paramaozx, paramObject, paramMessageRecord, paramBoolean);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, aozx paramaozx, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int j = paramaozx.a(paramQQAppInterface, paramBoolean, paramString);
    int i = a(j, paramMessageRecord);
    if (((!paramBoolean) && (!mb(j))) || (i == -1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, "isTroop = " + paramBoolean + ", bizType = " + j + ", flowers = " + i + ", troopCode = " + paramString + ", isTroop = " + paramBoolean);
      }
      return;
    }
    String str = B(paramString, paramBoolean);
    j = apmu.jK(j);
    paramString = null;
    if (j == 102) {
      paramString = paramMessageRecord;
    }
    long l = apab.a.a(j, paramaozx.b.shmsgseq, paramaozx.b.uniseq);
    ((apnu)paramQQAppInterface.getManager(363)).a(str, j, paramaozx.b.shmsgseq, l, "", i, paramString);
  }
  
  @Nullable
  private static Object b(QQAppInterface paramQQAppInterface, String paramString, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramaozx.a(paramQQAppInterface, paramBoolean, paramString);
    if ((!paramBoolean) && (!mb(i))) {
      return null;
    }
    paramString = ((aalm)paramQQAppInterface.getManager(366)).a(i);
    if (paramString != null) {
      return paramString.a(i, paramaozx, paramObject, paramMessageRecord, paramQQAppInterface);
    }
    return null;
  }
  
  public static boolean mb(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 24) || (paramInt == 12) || (paramInt == 20) || (paramInt == 22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnt
 * JD-Core Version:    0.7.0.1
 */