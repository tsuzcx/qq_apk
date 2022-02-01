import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class apne
  extends apmr
{
  public apne(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 26;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3)))
    {
      paramObject = this.context.getString(2131699899);
      apab.a locala = apab.a.a(paramInt1, paramLong1, paramInt2);
      String str = paramList.senderuin;
      if (jof.a(paramList)) {}
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        anot.a(this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", paramInt1, 0, this.sessionInfo.aTl, "", "", "");
        return new apmr.a(true, paramObject, locala, str);
      }
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_gift", 0, 0, this.sessionInfo.aTl, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (jof.a().dd(this.sessionInfo.aTl)) {}
    for (paramInt = 2;; paramInt = 1)
    {
      anot.a(this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", paramInt, 0, this.sessionInfo.aTl, "", "", "");
      anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_gift", 0, 0, this.sessionInfo.aTl, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apne
 * JD-Core Version:    0.7.0.1
 */