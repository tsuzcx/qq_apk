import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class ykb
  extends yjz
{
  public ykb(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private String hk(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return "";
    }
    return new aofk(paramString, 5).v(false);
  }
  
  int a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = 4;
    if (paramSessionInfo != null) {
      i = ((Integer)aajx.a(paramQQAppInterface, paramSessionInfo.cZ, paramSessionInfo.aTl).first).intValue();
    }
    return i;
  }
  
  public ColorNote a(List<MessageRecord> paramList, long paramLong, int paramInt, SessionInfo paramSessionInfo)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramSessionInfo == null)) {
      return null;
    }
    String str4 = "提醒时间: " + yka.ba(paramLong);
    Object localObject = (MessageRecord)paramList.get(0);
    String str1 = ((MessageRecord)localObject).frienduin;
    if ((paramSessionInfo.cZ == 1) || (paramSessionInfo.cZ == 3000)) {}
    for (int i = 0;; i = 1)
    {
      String str3;
      String str2;
      if ((i != 0) && (Z(paramList)))
      {
        str3 = ((MessageRecord)paramList.get(0)).selfuin;
        if (i == 0) {
          break label313;
        }
        str2 = aqgv.A(this.mApp, str3);
        label130:
        if (paramList.size() == 1) {
          break label338;
        }
        str2 = str2 + "的" + paramList.size() + "条消息";
      }
      label397:
      label412:
      for (;;)
      {
        label176:
        if (paramSessionInfo.aTn == null)
        {
          label184:
          str1 = a(paramSessionInfo, str1);
          localObject = new Uri.Builder().scheme("uindrawable");
          if (i == 0) {
            break label397;
          }
        }
        for (i = 1;; i = a(paramSessionInfo, this.mApp))
        {
          str3 = ((Uri.Builder)localObject).appendQueryParameter("type", String.valueOf(i)).appendQueryParameter("uin", str3).toString();
          localObject = new ColorNote.a();
          ((ColorNote.a)localObject).a(17235968).a(ykf.bc(paramLong)).b(0).b(str2).c(str4).d(str3).a(a(paramList, paramInt, str1, paramSessionInfo.troopUin));
          return ((ColorNote.a)localObject).a();
          str3 = str1;
          break;
          label313:
          if (paramSessionInfo.aTn == null)
          {
            str2 = str1;
            break label130;
          }
          str2 = paramSessionInfo.aTn;
          break label130;
          label338:
          str2 = hk(((MessageRecord)localObject).msg);
          if ((!TextUtils.isEmpty(str2)) && (((localObject instanceof MessageForText)) || ((localObject instanceof MessageForLongMsg)))) {
            break label412;
          }
          str2 = ykf.a(this.mApp, (MessageRecord)localObject);
          break label176;
          str1 = paramSessionInfo.aTn;
          break label184;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykb
 * JD-Core Version:    0.7.0.1
 */