import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar.1;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.os.MqqHandler;

public class yif
  implements yjf
{
  private Context J;
  private yjh a;
  private QQAppInterface app;
  private int bZi = 0;
  private boolean bmL;
  private SessionInfo mSessionInfo;
  private MqqHandler uiHandler;
  
  public yif(QQAppInterface paramQQAppInterface, yjh paramyjh, Context paramContext, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    this.app = paramQQAppInterface;
    this.a = paramyjh;
    this.J = paramContext;
    this.mSessionInfo = paramSessionInfo;
    this.uiHandler = paramMqqHandler;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.J).inflate(2131562064, null);
    TextView localTextView = (TextView)localView.findViewById(2131362535);
    String str = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    localTextView.setText(str);
    localView.setOnClickListener(new yig(this, i));
    return localView;
  }
  
  public void check()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "check() : ");
    }
    if (this.mSessionInfo.cZ != 0) {}
    for (;;)
    {
      return;
      if (this.bZi != 0)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FraudTipsBar", 2, "mAntiFraudTips is showing or has shown");
        return;
      }
      try
      {
        l = Long.parseLong(this.mSessionInfo.aTl);
        if (l == 0L) {
          continue;
        }
        if (!this.bmL)
        {
          this.bmL = true;
          if (abgw.a().bB(l))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FraudTipsBar", 2, "uin cache is out of date, update it! ");
            }
            ((FriendListHandler)this.app.getBusinessHandler(1)).l("OidbSvc.0x476_146", (int)l, 146);
          }
        }
        int i = abgw.a().N(l);
        if (i == 0) {
          continue;
        }
        aqfz.a().bf(this.app, "SecWarningCfg");
        Object localObject = (Bundle)aqfz.a().a("SecWarningCfg", "BannerWording", 146, i);
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getString("BannerWording");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          if (!this.a.a(this, new Object[] { localObject, Integer.valueOf(i) })) {
            continue;
          }
          this.bZi = 1;
          anot.a(null, "P_CliOper", "Safe_AntiFraud", this.mSessionInfo.aTl, "banner", "display", i, 0, "", "", "", "");
          Timer localTimer = new Timer();
          FraudTipsBar.1 local1 = new FraudTipsBar.1(this);
          localObject = (Bundle)aqfz.a().a("SecWarningCfg", "BannerTTL", 146, i);
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getString("BannerTTL");
            try
            {
              i = Integer.parseInt((String)localObject);
              l = i;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                localThrowable2.printStackTrace();
                l = 15L;
              }
            }
            l *= 1000L;
            if (l <= 0L) {
              continue;
            }
            localTimer.schedule(local1, l);
            return;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          long l = 0L;
          continue;
          String str = "0";
          continue;
          str = null;
        }
      }
    }
  }
  
  public int getType()
  {
    return 0;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    check();
  }
  
  public int wM()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yif
 * JD-Core Version:    0.7.0.1
 */