import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class yij
  implements yjf
{
  private Context J;
  private yjh a;
  private QQAppInterface app;
  private int bZj;
  private int bZk;
  private SessionInfo sessionInfo;
  private String teamId;
  private TextView textView;
  
  public yij(QQAppInterface paramQQAppInterface, yjh paramyjh, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.app = paramQQAppInterface;
    this.a = paramyjh;
    this.J = paramContext;
    this.sessionInfo = paramSessionInfo;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.J).inflate(2131558699, null);
    this.textView = ((TextView)paramVarArgs.findViewById(2131362542));
    cit();
    paramVarArgs.setOnClickListener(new yik(this));
    arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2015", "0", false);
    return paramVarArgs;
  }
  
  public void cit()
  {
    Object localObject = (ahvn)this.app.getManager(156);
    if (((ahvn)localObject).C(this.sessionInfo.cZ, this.sessionInfo.aTl))
    {
      this.teamId = ((ahvn)localObject).teamId;
      this.bZj = ((ahvn)localObject).bZj;
      this.bZk = ((ahvn)localObject).bZk;
    }
    if (this.textView != null)
    {
      if (!this.app.getCurrentAccountUin().equals(((ahvn)localObject).bLP)) {
        break label173;
      }
      if (this.bZj >= this.bZk) {
        break label157;
      }
      localObject = String.format(this.app.getApp().getString(2131694218), new Object[] { Integer.valueOf(this.bZj), Integer.valueOf(this.bZk) });
    }
    Looper localLooper;
    for (;;)
    {
      localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        break;
      }
      this.textView.setText((CharSequence)localObject);
      return;
      label157:
      localObject = this.app.getApp().getString(2131694216);
      continue;
      label173:
      if ((((ahvn)localObject).dbw == 3) || (((ahvn)localObject).dbw == 4)) {
        localObject = this.app.getApp().getString(2131694220);
      } else if (this.bZj < this.bZk) {
        localObject = this.app.getApp().getString(2131694219);
      } else {
        localObject = this.app.getApp().getString(2131694217);
      }
    }
    new Handler(localLooper).post(new GamePartyTipsBar.2(this, (String)localObject));
  }
  
  public int getType()
  {
    return 14;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    while (!((ahvn)this.app.getManager(156)).C(this.sessionInfo.cZ, this.sessionInfo.aTl)) {
      return;
    }
    this.a.a(this, new Object[0]);
  }
  
  public int wM()
  {
    return 40;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yij
 * JD-Core Version:    0.7.0.1
 */