import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask.1;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask.2;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class kbv
  implements ljc.c
{
  private kbv.a a;
  private QQAppInterface app;
  private MqqHandler g;
  private Context mContext;
  private String puin;
  private int retryCount;
  
  public kbv(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    this(paramQQAppInterface, paramString, paramContext, null);
  }
  
  public kbv(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, kbv.a parama)
  {
    this.app = paramQQAppInterface;
    this.puin = paramString;
    this.a = parama;
    this.mContext = paramContext.getApplicationContext();
    this.g = ThreadManager.getSubThreadHandler();
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    int i = this.retryCount;
    this.retryCount = (i + 1);
    if (i < 3)
    {
      QLog.d("PublicAccountUnfollowTask", 2, "unfollow account fail ! uin : " + this.puin + " , errCode : " + paramInt + ", retry : " + this.retryCount);
      this.g.post(new PublicAccountUnfollowTask.2(this));
    }
    while (this.a == null) {
      return;
    }
    this.a.q(false, this.puin);
  }
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      QLog.d("PublicAccountUnfollowTask", 2, "unfollow account success ! uin : " + paramString + ",retry : " + this.retryCount);
      paramInt = ocp.e(this.app, this.puin);
      aalb.l(this.app, this.puin, paramInt);
      this.app.b().ca(this.puin, 1008);
      ((lcd)this.app.getManager(163)).b().aJk();
      if (this.a != null) {
        this.a.q(true, paramString);
      }
      return;
    }
    a(-1, null);
  }
  
  public void start()
  {
    if ((this.retryCount >= 3) || (this.app == null))
    {
      QLog.d("PublicAccountUnfollowTask", 2, "retry count reach max value or app = null ! retryCount : " + this.retryCount);
      return;
    }
    this.g.post(new PublicAccountUnfollowTask.1(this));
  }
  
  public static abstract interface a
  {
    public abstract void q(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbv
 * JD-Core Version:    0.7.0.1
 */