import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class apni
  extends apmr
{
  public apni(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 5;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      new apmr.a(true, this.context.getString(2131699667), apab.a.a(paramInt1, paramLong1, paramInt2), "");
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apni
 * JD-Core Version:    0.7.0.1
 */