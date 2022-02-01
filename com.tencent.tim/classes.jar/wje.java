import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class wje
{
  private static ArrayMap<Integer, wje.a> d = new ArrayMap();
  
  static
  {
    d.put(Integer.valueOf(1010), new wjf());
    d.put(Integer.valueOf(1001), new wjo());
    d.put(Integer.valueOf(10002), new wjp());
    d.put(Integer.valueOf(10004), new wjq());
    d.put(Integer.valueOf(0), new wjr());
    d.put(Integer.valueOf(1000), new wjs());
    d.put(Integer.valueOf(1020), new wjt());
    d.put(Integer.valueOf(1), new wju());
    d.put(Integer.valueOf(3000), new wjv());
    d.put(Integer.valueOf(1004), new wjg());
    d.put(Integer.valueOf(1005), new wjh());
    d.put(Integer.valueOf(1023), new wji());
    d.put(Integer.valueOf(1009), new wjj());
    d.put(Integer.valueOf(1006), new wjk());
    d.put(Integer.valueOf(1021), new wjl());
    d.put(Integer.valueOf(1022), new wjm());
    d.put(Integer.valueOf(10008), new wjn());
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1) {
      paramMessageRecord = new ProfileActivity.AllInOne(paramString, 20);
    }
    for (;;)
    {
      paramMessageRecord.nickname = aqgv.o(paramQQAppInterface, paramString);
      return paramMessageRecord;
      if (paramMessageRecord.istroop == 3000) {
        paramMessageRecord = new ProfileActivity.AllInOne(paramString, 45);
      } else {
        paramMessageRecord = new ProfileActivity.AllInOne(paramString, 1);
      }
    }
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    if (d.containsKey(Integer.valueOf(paramMessageRecord.istroop))) {
      return ((wje.a)d.get(Integer.valueOf(paramMessageRecord.istroop))).b(paramQQAppInterface, paramString, paramSessionInfo, paramMessageRecord);
    }
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 19);
    paramQQAppInterface.nickname = paramSessionInfo.aTn;
    return paramQQAppInterface;
  }
  
  static abstract interface a
  {
    public abstract ProfileActivity.AllInOne b(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wje
 * JD-Core Version:    0.7.0.1
 */