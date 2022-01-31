package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.pathtracker.VipPathTracker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class PayBridgeActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "PayBridgeActivity";
  public static final int b = 2;
  public static final String b = "release";
  private static boolean b = false;
  public static final int c = 3;
  public static final String c = "pay_requestcode";
  public static final int d = 4;
  public static final String d = "payparmas_from_native";
  public static final int e = 5;
  public static final String e = "payparmas_from_pcpush";
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = -5;
  public static final int l = 11;
  public static final int m = 12;
  public static final int n = -1;
  public static final int o = 0;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 4;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private DataFactory.EmojiPayReqData jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData;
  protected boolean a;
  private boolean c = false;
  private int v = -1;
  private int w = -1;
  
  public PayBridgeActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624119);
    localDialog.setContentView(2130903135);
    TextView localTextView = (TextView)localDialog.findViewById(2131296915);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296470);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296918);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296919);
    if (paramString1 != null) {
      paramString1.setText(2131362772);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    Object localObject1 = "";
    String str5 = "";
    Object localObject4 = "";
    Object localObject2 = "";
    String str3 = "";
    String str2 = "";
    int i2 = paramString1.lastIndexOf("|channel#");
    Object localObject3 = localObject4;
    String str1 = str5;
    String str4;
    int i1;
    if (i2 != -1)
    {
      str4 = paramString1.substring("|channel#".length() + i2);
      i1 = paramString1.indexOf("|bargainor_id#");
      localObject3 = localObject4;
      str1 = str5;
      localObject1 = str4;
      if (i1 != -1)
      {
        str5 = paramString1.substring("|bargainor_id#".length() + i1, i2);
        i2 = paramString1.indexOf("appid#");
        localObject3 = localObject4;
        str1 = str5;
        localObject1 = str4;
        if (i2 != -1)
        {
          localObject3 = paramString1.substring("appid#".length() + i2, i1);
          localObject1 = str4;
          str1 = str5;
        }
      }
    }
    i2 = paramString2.lastIndexOf("|channel#");
    localObject4 = str2;
    paramString1 = str3;
    if (i2 != -1)
    {
      str4 = paramString2.substring("|channel#".length() + i2);
      i1 = paramString2.indexOf("|bargainor_id#");
      localObject4 = str2;
      paramString1 = str3;
      localObject2 = str4;
      if (i1 != -1)
      {
        str3 = paramString2.substring("|bargainor_id#".length() + i1, i2);
        i2 = paramString2.indexOf("appid#");
        localObject4 = str2;
        paramString1 = str3;
        localObject2 = str4;
        if (i2 != -1)
        {
          localObject4 = paramString2.substring("appid#".length() + i2, i1);
          localObject2 = str4;
          paramString1 = str3;
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      paramString2 = "appid#" + (String)localObject4;
      paramString2 = paramString2 + "|bargainor_id#";
      if (!TextUtils.isEmpty(str1)) {
        break label436;
      }
      paramString1 = paramString2 + paramString1;
      label362:
      paramString1 = paramString1 + "|channel#";
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label491;
      }
    }
    label436:
    label491:
    for (paramString1 = paramString1 + (String)localObject2;; paramString1 = paramString1 + (String)localObject1)
    {
      return paramString1;
      paramString2 = "appid#" + (String)localObject3;
      break;
      if (str1.compareTo("0") == 0)
      {
        paramString1 = paramString2 + paramString1;
        break label362;
      }
      paramString1 = paramString2 + str1;
      break label362;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt1);
    localBundle.putInt("realSaveNum", paramInt2);
    localBundle.putInt("payChannel", paramInt3);
    localBundle.putInt("payState", paramInt4);
    localBundle.putInt("provideState", paramInt5);
    localBundle.putString("message", paramString);
    localIntent.putExtras(localBundle);
    setResult(paramInt1, localIntent);
    a(paramInt1, localIntent);
    finish();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((!this.c) && (this.jdField_a_of_type_AndroidContentIntent == null))
    {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.w = paramInt;
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(paramInt1, paramString);
    a(paramInt1, paramString);
    finish();
  }
  
  private void a(Intent paramIntent)
  {
    int i1 = -1;
    label68:
    for (;;)
    {
      try
      {
        String str = new JSONObject(getIntent().getStringExtra("json")).optString("aid", "");
        int i2;
        paramIntent.printStackTrace();
      }
      catch (Exception paramIntent)
      {
        try
        {
          i2 = new JSONObject(paramIntent.getStringExtra("result")).getInt("resultCode");
          i1 = i2;
          VipPathTracker.a().a(this.app, str, i1);
          return;
        }
        catch (Exception paramIntent)
        {
          break label68;
        }
        paramIntent = paramIntent;
        str = "";
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (!paramString.contains(";")) {
        break;
      }
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length != 0))
      {
        int i2 = paramString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          StatisticCollector.a(BaseApplication.getContext()).d(paramQQAppInterface, paramString[i1]);
          i1 += 1;
        }
      }
    }
    StatisticCollector.a(BaseApplication.getContext()).d(paramQQAppInterface, paramString);
  }
  
  private void a(DataFactory.EmojiPayReqData paramEmojiPayReqData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    if (paramEmojiPayReqData == null)
    {
      finish();
      return;
    }
    Intent localIntent = new Intent();
    paramString = new DataFactory.EmojiPayRespData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    localIntent.putExtras(paramEmojiPayReqData.getBundleData());
    localIntent.putExtras(paramString.getBundleData());
    setResult(-1, localIntent);
    a(-1, localIntent);
    finish();
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramString2);
    localIntent.putExtra("callbackSn", paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("PayBridgeActivity", 2, "PayBridgeActivity tenpayResult:callbackSn=" + paramString1 + ",result=" + paramString2);
    }
    setResult(-1, localIntent);
    a(-1, localIntent);
    finish();
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    return a(paramActivity, paramString1, paramInt, paramString2, "", false);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return a(paramActivity, paramString1, paramInt, paramString2, paramString3, false);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    d();
    return false;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    d();
    return false;
  }
  
  private boolean a(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    return (paramEmojiPayReqData != null) && (!TextUtils.isEmpty(paramEmojiPayReqData.appid)) && (!TextUtils.isEmpty(paramEmojiPayReqData.callbackid)) && (!TextUtils.isEmpty(paramEmojiPayReqData.userId)) && (!TextUtils.isEmpty(paramEmojiPayReqData.userKey)) && (!TextUtils.isEmpty(paramEmojiPayReqData.tokenUrl));
  }
  
  private String c()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("payState", -1);
      ((JSONObject)localObject).put("provideState", -1);
      ((JSONObject)localObject).put("resultMsg", "");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private void c()
  {
    QQToast.a(BaseApplication.getContext(), 2131364506, 0).a();
    finish();
  }
  
  public static boolean c()
  {
    return b;
  }
  
  private String d()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("retmsg", "error");
      ((JSONObject)localObject).put("data", new JSONObject());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static void d()
  {
    QQToast.a(BaseApplication.getContext(), 2131364506, 0).a();
  }
  
  private String e()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.app.a());
    }
    return "";
  }
  
  private void e() {}
  
  public static boolean startGoldCharge(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean startOpenQQReaderVip(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public void finish() {}
  
  public int getPathNodeID()
  {
    return 20;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(paramIntent);
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      paramInt1 = paramIntent.getIntExtra("PayInvokerId", -1);
      if (QLog.isColorLevel()) {
        QLog.d("PayBridgeActivity", 2, "QvipPayBridge Unknown InvokerId : " + paramInt1);
      }
      finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PayBridgeActivity", 2, "QvipPayBridge Unknown data");
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427345);
    if ((getIntent() != null) && (getIntent().getExtras() == null))
    {
      finish();
      return;
    }
    this.v = getIntent().getExtras().getInt("pay_requestcode", -1);
    this.c = getIntent().getExtras().getBoolean("payparmas_from_pcpush", false);
    if (this.v == 12)
    {
      if (b)
      {
        super.finish();
        return;
      }
      b = true;
      this.c = true;
      this.jdField_a_of_type_Boolean = true;
      if ((!mAppForground) && (this.t) && (this.app != null) && (this.app.a() != null) && (GesturePWDUtils.getJumpLock(this, this.app.a())))
      {
        super.finish();
        return;
      }
      c();
      return;
    }
    b = true;
    if (this.v == 1)
    {
      c();
      return;
    }
    if (this.v == 2)
    {
      c();
      return;
    }
    if (this.v == 3)
    {
      c();
      return;
    }
    if (this.v == 4)
    {
      c();
      return;
    }
    if (this.v == 5)
    {
      c();
      return;
    }
    if (this.v == 6)
    {
      c();
      return;
    }
    if (this.v == 7)
    {
      c();
      return;
    }
    if (this.v == 8)
    {
      c();
      return;
    }
    if (this.v == 9)
    {
      c();
      return;
    }
    if (this.v == 10)
    {
      c();
      return;
    }
    if (this.v == 11)
    {
      c();
      return;
    }
    finish();
  }
  
  protected void onDestroy()
  {
    b = false;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PayBridgeActivity
 * JD-Core Version:    0.7.0.1
 */