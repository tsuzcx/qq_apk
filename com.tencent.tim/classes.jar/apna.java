import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apna
  extends apmr
{
  private String eventType;
  
  public apna(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 21;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if ((paramObject != null) && (a(paramObject, paramLong2, paramLong3)))
    {
      if ((StructMsgForGeneralShare)anre.a(paramObject.msgData) == null) {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
        }
      }
      for (paramList = this.context.getString(2131699495);; paramList = StructMsgForGeneralShare.remindBrief)
      {
        apab.a locala = apab.a.a(paramInt1, paramLong1, paramInt2);
        paramObject = paramObject.senderuin;
        this.eventType = StructMsgForGeneralShare.eventType;
        anot.a(this.app, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.sessionInfo.aTl, this.eventType, "", "");
        return new apmr.a(true, paramList, locala, paramObject);
      }
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    anot.a(this.app, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.sessionInfo.aTl, this.eventType, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apna
 * JD-Core Version:    0.7.0.1
 */