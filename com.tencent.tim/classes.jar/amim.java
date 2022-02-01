import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class amim
{
  public static final String caf = acfp.m(2131715400);
  
  private static void a(BaseChatPie paramBaseChatPie, long paramLong, String paramString)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.selfuin = paramBaseChatPie.app.getCurrentAccountUin();
    localMessageForText.frienduin = paramBaseChatPie.sessionInfo.aTl;
    localMessageForText.istroop = paramBaseChatPie.sessionInfo.cZ;
    localMessageForText.senderuin = paramBaseChatPie.sessionInfo.aTl;
    if (paramLong != 0L) {}
    for (;;)
    {
      localMessageForText.time = paramLong;
      localMessageForText.msg = paramString;
      localMessageForText.uniseq = 0L;
      localMessageForText.msgUid = -1L;
      localMessageForText.shmsgseq = 1L;
      localMessageForText.sb = paramString;
      paramBaseChatPie.d(localMessageForText);
      return;
      paramLong = NetConnInfoCenter.getServerTime();
    }
  }
  
  public static final boolean a(BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    paramIntent.getStringExtra("key_aio_reply_time");
    String str = paramIntent.getStringExtra("key_aio_reply_content");
    paramIntent.getIntExtra("key_aio_reply_type", 0);
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBaseChatPie.sessionInfo.aTl));
  }
  
  public static final boolean b(BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("key_aio_reply_time");
    String str1 = paramIntent.getStringExtra("key_aio_reply_content");
    int i = paramIntent.getIntExtra("key_aio_reply_type", 0);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramBaseChatPie.sessionInfo.aTl))) {
      return false;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(str2).longValue();
      l1 = l2;
    }
    catch (Exception paramIntent)
    {
      label62:
      break label62;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicReplyUtil", 2, String.format("checkAIOReplyNInsert [%s, %d, %s]", new Object[] { paramBaseChatPie.sessionInfo.aTl, Long.valueOf(l1), str1 }));
    }
    paramIntent = str1;
    if (i == 0) {
      paramIntent = caf + str1;
    }
    a(paramBaseChatPie, l1, paramIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amim
 * JD-Core Version:    0.7.0.1
 */