import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class apmy
  extends apmr
{
  public apmy(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 23;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new apmr.a(true, this.context.getString(2131699464), apab.a.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.sessionInfo.aTl, "", "", "");
    anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_at", 0, 0, this.sessionInfo.aTl, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.sessionInfo.aTl, "", "", "");
    anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_at", 0, 0, this.sessionInfo.aTl, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmy
 * JD-Core Version:    0.7.0.1
 */