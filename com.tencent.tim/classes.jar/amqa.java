import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import java.text.SimpleDateFormat;

public class amqa
  extends ampy
{
  private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yy/MM/dd");
  private CharSequence ae;
  private QQAppInterface app;
  private RecentUser d;
  private String keyword;
  private CharSequence message;
  private MessageRecord messageRecord;
  private CharSequence title;
  
  public amqa(QQAppInterface paramQQAppInterface, String paramString, RecentUser paramRecentUser, MessageRecord paramMessageRecord)
  {
    this.app = paramQQAppInterface;
    this.keyword = paramString;
    this.d = paramRecentUser;
    this.messageRecord = paramMessageRecord;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    aalb.bwg = true;
    aalb.r = this.messageRecord;
    aalb.a(paramView.getContext(), this.app, this.d.uin, this.d.getType(), aqgv.d(this.app, this.d.uin, this.d.getType()), false);
    aclj.Q(this.app, this.keyword);
    amxk.a(this.keyword, 40, paramView, true);
  }
  
  public CharSequence f()
  {
    if (this.message == null) {
      this.message = amxk.a(this.messageRecord.msg, this.keyword);
    }
    return this.message;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    if (TextUtils.isEmpty(this.ae)) {
      this.ae = aqmu.a(BaseApplicationImpl.sApplication, 3, this.messageRecord.time * 1000L);
    }
    return this.ae;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if (this.title == null) {
      if (!jof.a(this.messageRecord)) {
        break label60;
      }
    }
    label60:
    SessionInfo localSessionInfo;
    for (this.title = (BaseApplicationImpl.sApplication.getString(2131699453) + jof.a(this.messageRecord).TG);; this.title = aqgv.a(this.app, localSessionInfo, this.messageRecord.isSend(), this.messageRecord.senderuin))
    {
      return this.title;
      localSessionInfo = new SessionInfo();
      localSessionInfo.cZ = this.d.getType();
      localSessionInfo.aTl = this.d.uin;
    }
  }
  
  public String getUin()
  {
    return this.messageRecord.senderuin;
  }
  
  public int pG()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqa
 * JD-Core Version:    0.7.0.1
 */