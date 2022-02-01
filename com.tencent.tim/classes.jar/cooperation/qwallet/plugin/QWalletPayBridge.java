package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public abstract class QWalletPayBridge
{
  public static final String TAG = "Q.qwallet.pay.QWalletPayBridge";
  
  public static boolean launchBackground(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putInt("launch_type", 1);
    }
    return launchPlugin(paramContext, paramAppInterface, paramBundle);
  }
  
  public static boolean launchForeground(Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putInt("launch_type", 0);
    }
    return launchPlugin(paramActivity, paramAppInterface, paramBundle);
  }
  
  private static boolean launchPlugin(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null) || (paramAppInterface == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, "launchPlugin comeFrom = " + paramBundle.getInt("comeForm"));
    }
    QWalletHelper.launchPayBridgeService(paramContext, paramAppInterface, paramBundle);
    if ((paramBundle.getInt("launch_type", 0) == 0) && ((paramContext instanceof Activity)))
    {
      paramContext = (Activity)paramContext;
      ThreadManager.getSubThreadHandler().post(new QWalletPayBridge.1(paramAppInterface, paramContext));
    }
    return true;
  }
  
  public static abstract class Key
  {
    public static final String LAUNCH_TYPE = "launch_type";
    public static final String PAY_INVOKER_ID = "PayInvokerId";
  }
  
  public static abstract class LaunchType
  {
    public static final int BACKGROUND_REQ_DATA = 1;
    public static final int FOREGROUND_PAY = 0;
  }
  
  public static abstract class PayInvokerId
  {
    public static final int PAY_INVOKER_ACTIVITY_JUMP = 13;
    public static final int PAY_INVOKER_BUY_GOODS = 7;
    public static final int PAY_INVOKER_DATA_TENWACTH = 15;
    public static final int PAY_INVOKER_EMOJIMALL_PAY = 1;
    public static final int PAY_INVOKER_GET_QB_RECORD = 16;
    public static final int PAY_INVOKER_GOLD_CHARGE = 2;
    public static final int PAY_INVOKER_LAUNCH_WECHAT = 17;
    public static final int PAY_INVOKER_OPEN_QQREADER_VIP = 3;
    public static final int PAY_INVOKER_OPEN_QZONE_VIP = 10;
    public static final int PAY_INVOKER_OPEN_SERVICE = 4;
    public static final int PAY_INVOKER_OPEN_SVIP = 11;
    public static final int PAY_INVOKER_OPEN_TENPAY_VIEW = 5;
    public static final int PAY_INVOKER_PAY = 9;
    public static final int PAY_INVOKER_PAY_DATA = 22;
    public static final int PAY_INVOKER_PREGET_QRCODE = 23;
    public static final int PAY_INVOKER_PRE_CONNECT = 21;
    public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
    public static final int PAY_INVOKER_RECHARGE_QB = 8;
    public static final int PAY_INVOKER_SUBSCRIBE_MONTH_CARD = 14;
    public static final int PAY_INVOKER_WEBANK_CHECK = 12;
  }
  
  public static abstract class PayResult
  {
    public static final int PAY_REQUEST_CODE = 3001;
    public static final int PAY_RESULT_ERROR_PARAMS = 2;
    public static final String PAY_RESULT_EXTRA_KEY = "QWalletPayBridge.PayResult.ExtraKey";
    public static final int PAY_RESULT_OK = 1;
  }
  
  public static abstract class PayRetCode
  {
    public static final int ERR_CODE_GET_SKEY_FAIL = -97;
    public static final int ERR_CODE_NULL_ACTIVITY = -94;
    public static final int ERR_CODE_PARSE_PARAM_BUNDLE_NULL = -95;
    public static final int ERR_CODE_PARSE_PARAM_INTENT_NULL = -96;
    public static final int ERR_CODE_SUCC = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayBridge
 * JD-Core Version:    0.7.0.1
 */