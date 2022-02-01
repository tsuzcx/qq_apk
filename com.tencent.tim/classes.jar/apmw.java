import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class apmw
  extends apmr
{
  public apmw(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 20;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if (((paramList instanceof MessageForArkApp)) && (a(paramList, paramLong2, paramLong3))) {
      return new apmr.a(true, adrm.b((MessageForArkApp)paramList), apab.a.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (!(paramObject instanceof apab.a)) {}
    do
    {
      do
      {
        return;
        paramObject = (apab.a)paramObject;
        paramObject = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramObject.uniseq);
      } while (!(paramObject instanceof MessageForArkApp));
      paramObject = ((MessageForArkApp)paramObject).ark_app_message;
    } while (paramObject == null);
    adqu.a(this.app, paramObject.appName, "AIOMsgRemindShow", 0, 0, 0L, 0L, 0L, "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    anot.a(this.app, "dc00898", "", "", "0X800AA11", "0X800AA11", 0, 0, "", "", "", "");
  }
  
  public boolean lX(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmw
 * JD-Core Version:    0.7.0.1
 */