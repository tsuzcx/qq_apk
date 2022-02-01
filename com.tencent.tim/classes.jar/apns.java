import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class apns
  extends apmr
{
  public apns(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 1;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    int j = 0;
    int i;
    if (paramLong3 >= paramLong2) {
      i = 0;
    }
    while (i != 0)
    {
      return new apmr.a(true, String.format(this.context.getString(2131700035), new Object[] { Integer.valueOf(paramInt2) }), apab.a.a(paramInt1, paramLong1, paramInt2), "");
      if (paramInt2 < 30)
      {
        paramList = this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ);
        i = j;
        if (paramList != null)
        {
          long l = paramList.shmsgseq;
          for (paramLong3 = 0L;; paramLong3 += 1L)
          {
            i = j;
            if (paramLong3 >= paramInt2) {
              break;
            }
            paramList = this.app.b().d(this.sessionInfo.aTl, this.sessionInfo.cZ, l);
            if ((paramList != null) && (paramList.msgtype != -2058) && (paramList.shmsgseq < paramLong2))
            {
              i = 1;
              break;
            }
            l -= 1L;
          }
        }
      }
      else
      {
        i = 1;
      }
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2.setVisibility(8);
    paramTextView2.setTextColor(this.context.getResources().getColor(2131166502));
    paramTextView1.setTextColor(this.context.getResources().getColor(2131166502));
    paramImageView.setBackgroundResource(2130851829);
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.sessionInfo.cZ == 3000)
    {
      anot.a(this.app, "dc00899", "Grp_Dis", "", "Grp_AIO", "Appear_Oneclk_read", 0, 0, this.sessionInfo.aTl, "", "", "");
      return;
    }
    anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.sessionInfo.aTl, "", "", "");
    anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_new_msg", 0, 0, this.sessionInfo.aTl, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (this.sessionInfo.cZ == 3000)
    {
      anot.a(this.app, "dc00899", "Grp_Dis", "", "Grp_AIO", "Clk_Oneclk_read", 0, 0, this.sessionInfo.aTl, "", "", "");
      return;
    }
    anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.sessionInfo.aTl, "", "", "");
    anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_new_msg", 0, 0, this.sessionInfo.aTl, "", "", "");
  }
  
  public boolean bt(int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 15) && (paramInt2 <= 200);
  }
  
  public int getIconRes(int paramInt)
  {
    return 2130851780;
  }
  
  public boolean lX(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apns
 * JD-Core Version:    0.7.0.1
 */