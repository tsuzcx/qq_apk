import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class yiq
  implements yim
{
  private volatile long JY = -1L;
  private yjh a;
  private QQAppInterface app;
  private Time b;
  private final String[] cM = { acfp.m(2131707177), acfp.m(2131707178), acfp.m(2131707179) };
  private wki g;
  private SessionInfo sessionInfo;
  
  public yiq(QQAppInterface paramQQAppInterface, yjh paramyjh, Activity paramActivity, SessionInfo paramSessionInfo, wki paramwki)
  {
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.a = paramyjh;
    this.g = paramwki;
  }
  
  private void L(ChatMessage paramChatMessage)
  {
    boolean bool = x(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoKeywordGrayTips", 2, "detect : matchKeywords=" + bool);
    }
    SharedPreferences localSharedPreferences;
    long l1;
    if (bool)
    {
      paramChatMessage = "key_hongbao_keyword_gray_tips" + this.app.getCurrentAccountUin();
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      String str = localSharedPreferences.getString(paramChatMessage, "");
      l1 = anaz.gQ() * 1000L;
      if (TextUtils.isEmpty(str)) {
        break label303;
      }
      long l2 = Long.parseLong(str);
      this.b.set(l2);
      int i = this.b.year;
      int j = this.b.month;
      int k = this.b.monthDay;
      int m = this.b.hour;
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "lastShowDate :" + i + " - " + (j + 1) + " - " + k + " - " + m);
      }
      if (l1 - l2 > 86400000L) {
        break label249;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "has show in a day, just return;");
      }
    }
    label249:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips show time interval > 1day, can show.");
        }
      } while (!this.a.a(this, new Object[0]));
      localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips has never been shown, can show.");
      }
    } while (!this.a.a(this, new Object[0]));
    label303:
    localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
  }
  
  private boolean x(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!(paramChatMessage instanceof MessageForText))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("HongbaoKeywordGrayTips", 2, "match : not MessageForText");
        bool2 = bool1;
      }
      return bool2;
    }
    bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(paramChatMessage.msg))
    {
      arrayOfString = this.cM;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (paramChatMessage.msg.contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HongbaoKeywordGrayTips", 2, "match : ret=" + bool1);
        return bool1;
      }
      i += 1;
    }
  }
  
  public int[] E()
  {
    return null;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = anbi.d(-1045);
    long l = anaz.gQ();
    String str = this.app.getCurrentAccountUin();
    paramVarArgs.init(str, this.sessionInfo.aTl, str, "", l, -1045, this.sessionInfo.cZ, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public int getType()
  {
    return 1004;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    int j = 1;
    if ((this.sessionInfo.cZ != 0) && (this.sessionInfo.cZ != 3000) && (this.sessionInfo.cZ != 1)) {}
    label103:
    long l;
    int i;
    Object localObject;
    label204:
    label358:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.sessionInfo.cZ != 1) {
              break;
            }
            paramVarArgs = (HotChatManager)this.app.getManager(60);
          } while ((paramVarArgs != null) && (paramVarArgs.kj(this.sessionInfo.aTl)));
        } while ((paramInt != 1000) && (paramInt != 1001));
        if (paramInt == 1000)
        {
          paramInt = 1;
          l = anaz.gQ();
          if (this.b == null) {
            this.b = new Time();
          }
          this.b.set(l * 1000L);
          i = this.b.year;
          int k = this.b.month + 1;
          int m = this.b.monthDay;
          int n = this.b.hour;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("onAIOEvent() :");
            if (paramInt == 0) {
              break label313;
            }
            paramVarArgs = " TYPE_ON_SHOW ";
            QLog.d("HongbaoKeywordGrayTips", 2, paramVarArgs + ", curDate :" + i + " - " + k + " - " + m + " - " + n);
          }
          if ((i != 2015) || (k != 2) || (m > 21) || (m < 18)) {
            break label320;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label325;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HongbaoKeywordGrayTips", 2, "time not match, just return");
          return;
          paramInt = 0;
          break label103;
          paramVarArgs = " TYPE_ON_MSG_SENT_RECV";
          break label204;
        }
        if (paramInt != 0)
        {
          ThreadManager.getSubThreadHandler().post(new HongbaoKeywordGrayTips.1(this));
          return;
        }
        if (this.sessionInfo.cZ != 0) {
          break;
        }
        paramInt = j;
        l = this.JY;
        paramVarArgs = this.g.getList();
        i = paramVarArgs.size();
      } while (i <= 0);
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject = (ChatMessage)paramVarArgs.get(i);
      if (paramInt == 0) {
        break label507;
      }
    } while (((ChatMessage)localObject).time <= l);
    label313:
    label320:
    label325:
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
    }
    label387:
    if ((((ChatMessage)localObject).isSendFromLocal()) && (((ChatMessage)localObject).extraflag != 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : msg send not success");
      }
    }
    for (;;)
    {
      i -= 1;
      break label387;
      break;
      paramInt = 0;
      break label358;
      L((ChatMessage)localObject);
      if (((ChatMessage)localObject).time > this.JY)
      {
        this.JY = ((ChatMessage)localObject).time;
        continue;
        label507:
        if (((ChatMessage)localObject).shmsgseq <= l) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
        }
        L((ChatMessage)localObject);
        if (((ChatMessage)localObject).shmsgseq > this.JY) {
          this.JY = ((ChatMessage)localObject).shmsgseq;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yiq
 * JD-Core Version:    0.7.0.1
 */