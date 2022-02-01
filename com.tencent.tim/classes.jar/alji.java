import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class alji
{
  public HashMap<String, String> attributes = new HashMap();
  public String bWD;
  public String bWE;
  public String bWF;
  public String bWG;
  public String bWH;
  public boolean cxs;
  public String host;
  public String strName;
  
  public static boolean isDebugMode()
  {
    return false;
  }
  
  protected void a(aqhv paramaqhv, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      aljk.R(this.host, this.bWH, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      aljk.a(this, paramBoolean, localIntent);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant QAssistantConfigItem.Jump item_server = " + this.bWE + "|" + paramBaseActivity.getClass().toString());
      paramBaseActivity.startActivity(localIntent);
      return true;
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("fragment_id", 1);
    }
  }
  
  public boolean d(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, isDebugMode());
  }
  
  public boolean d(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null))
    {
      aljk.R(this.host, this.bWH, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    i(paramQQAppInterface, paramContext);
    if (!e(paramQQAppInterface, paramContext))
    {
      aljk.R(this.host, this.bWH, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((aqmr.isEmpty(this.bWD)) && (aqmr.isEmpty(this.bWE)))
    {
      aljk.R(this.host, this.bWH, 100);
      return false;
    }
    aqhv localaqhv2;
    aqhv localaqhv1;
    if (!aqmr.isEmpty(this.bWD))
    {
      localaqhv2 = aqik.c(paramQQAppInterface, paramContext, this.bWD);
      localaqhv1 = localaqhv2;
      if (localaqhv2 != null)
      {
        localaqhv1 = localaqhv2;
        if (!aqmr.isEmpty(this.bWG))
        {
          localaqhv1 = localaqhv2;
          if (!aqmr.isEmpty(this.bWG))
          {
            localaqhv2.setPkgName(this.bWG);
            localaqhv1 = localaqhv2;
          }
        }
      }
    }
    while (localaqhv1 == null)
    {
      aljk.R(this.host, this.bWH, 102);
      return false;
      localaqhv2 = new aqhv(paramQQAppInterface, paramContext);
      localaqhv2.cti = this.bWE;
      if ((!aqmr.isEmpty(this.bWF)) && (!aqmr.isEmpty(this.bWF))) {
        localaqhv2.ctj = this.bWF;
      }
      localaqhv1 = localaqhv2;
      if (!this.attributes.isEmpty())
      {
        localaqhv2.K(this.attributes);
        localaqhv1 = localaqhv2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.bWE);
    a(localaqhv1, paramQQAppInterface, paramContext);
    if (localaqhv1.ace())
    {
      aljk.R(this.host, this.bWH, 0);
      aljk.Ok(this.bWH);
    }
    for (;;)
    {
      return true;
      aljk.R(this.host, this.bWH, 103);
    }
  }
  
  protected boolean e(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.bWH != null)
    {
      if (!this.bWH.equalsIgnoreCase("ecchat")) {
        break label79;
      }
      int i = aqmj.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
      if ((i != 1) || (!paramQQAppInterface.isResourceReady())) {
        break label73;
      }
      bool1 = true;
    }
    label73:
    label79:
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        bool1 = bool2;
      } while (!this.bWH.equalsIgnoreCase("confessmsg"));
      bool1 = bool2;
    } while (((aegs)paramQQAppInterface.getManager(269)).a() != null);
    return false;
  }
  
  protected void i(QQAppInterface paramQQAppInterface, Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alji
 * JD-Core Version:    0.7.0.1
 */