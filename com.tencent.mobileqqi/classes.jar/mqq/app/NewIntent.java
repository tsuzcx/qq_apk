package mqq.app;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import java.util.HashMap;
import mqq.observer.BusinessObserver;

public class NewIntent
  extends Intent
{
  public static final String ACTION_ACCOUNT_CHANGED = "mqq.intent.action.ACCOUNT_CHANGED";
  public static final String ACTION_ACCOUNT_EXPIRED = "mqq.i.intent.action.ACCOUNT_EXPIRED";
  public static final String ACTION_ACCOUNT_KICKED = "mqq.i.intent.action.ACCOUNT_KICKED";
  public static final String ACTION_ACCOUNT_TIPS = "mqq.i.intent.action.ACCOUNT_TIPS";
  public static final String ACTION_EXIT = "mqq.intent.action.EXIT";
  public static final String ACTION_FORCE_LOGOUT = "mqq.i.intent.action.FORCE_LOGOUT";
  public static final String ACTION_GRAY = "mqq.i.intent.action.GRAY";
  public static final String ACTION_LAUNCH = "mqq.intent.action.LAUNCH";
  public static final String ACTION_LOGIN = "mqq.i.intent.action.LOGIN";
  public static final String ACTION_LOGOUT = "mqq.i.intent.action.LOGOUT";
  public static final String ACTION_SUSPEND = "mqq.i.intent.action.SUSPEND";
  public static final String ACTION_VERYFYCODE = "mqq.i.intent.action.VERIFYCODE";
  public static final String ACTION_VERYFYCODE_OPENSDK = "mqq.opensdk.intent.action.VERIFYCODE";
  public static final String ACTION_VERYFY_LOCK_CODE = "mqq.i.intent.action.ACTION_VERYFY_LOCK_CODE";
  public static final String ACTION_VERYFY_LOCK_CODE_OPENSDK = "mqq.opensdk.intent.action.ACTION_VERYFY_LOCK_CODE";
  HashMap<String, Parcelable> intentMap = null;
  private BusinessObserver observer;
  boolean runNow;
  boolean withouLogin;
  
  public NewIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public BusinessObserver getObserver()
  {
    return this.observer;
  }
  
  public boolean isWithouLogin()
  {
    return this.withouLogin;
  }
  
  public void setObserver(BusinessObserver paramBusinessObserver)
  {
    this.observer = paramBusinessObserver;
  }
  
  public void setWithouLogin(boolean paramBoolean)
  {
    this.withouLogin = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.NewIntent
 * JD-Core Version:    0.7.0.1
 */