import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class apno
  extends apmr
{
  public apno(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 22;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    Object localObject = this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if ((localObject != null) && (a((MessageRecord)localObject, paramLong2, paramLong3)))
    {
      paramList = this.context.getString(2131699907);
      paramObject = apab.a.a(paramInt1, ((MessageRecord)localObject).shmsgseq, paramInt2);
      localObject = ((MessageRecord)localObject).senderuin;
      MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.sessionInfo.aTl, null);
      return new apmr.a(true, paramList, paramObject, (String)localObject);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.sessionInfo.cZ == 3000) {}
    for (paramObject = "Grp_Dis_replyMsg";; paramObject = "Grp_AIO")
    {
      anot.a(this.app, "dc00899", paramObject, "", "notice_center_new", "exp_reply", 0, 0, this.sessionInfo.aTl, "", "", "");
      return;
    }
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.sessionInfo.aTl, null);
    if (this.sessionInfo.cZ == 3000) {}
    for (paramObject = "Grp_Dis_replyMsg";; paramObject = "Grp_AIO")
    {
      anot.a(this.app, "dc00899", paramObject, "", "notice_center_new", "clk_reply", 0, 0, this.sessionInfo.aTl, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apno
 * JD-Core Version:    0.7.0.1
 */