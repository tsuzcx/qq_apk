package com.tencent.open.agent;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.widget.PermissionView;
import com.tencent.open.widget.PermissionView.Permission;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import hmm;
import hmn;
import hmo;
import hmq;
import hmr;
import hms;
import hmx;
import hmy;
import hmz;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  protected static final int D = 2;
  protected static final String D = AppConstants.an + "coupon/";
  public static final String E = "agent_login";
  public static final String F = "agent_query_authority";
  public static final String G = "agent_authority";
  protected static final int a = 1;
  public static final long a = 16L;
  protected static final String a = "AuthorityActivity";
  protected static boolean a = false;
  public static final int b = 110002;
  public static final String b = "Authority_Report";
  public static final int c = 110405;
  public static final String c = "Authority_TimeCost";
  public static final int d = 110503;
  protected static final String d = "AuthorityActivity";
  public static final int e = 1;
  protected static final String e = "RESTART_FLAG";
  public static final int f = 2;
  public static final String f = "isLogin";
  protected static final int g = 0;
  public static final String g = "accList";
  protected static final int h = 1;
  public static final String h = "last_account";
  protected static final int i = 2;
  public static final String i = "uin";
  protected static final int j = 3;
  public static final String j = "nick";
  protected static final int k = 4;
  public static final String k = "skey";
  protected static final int l = 5;
  public static final String l = "st_temp";
  protected static final int m = 6;
  public static final String m = "st_temp_key";
  protected static final int n = 7;
  protected static final int o = 3000;
  public static final String o = "param_uin";
  protected static final int p = 3001;
  public static final String p = "firstlogin";
  protected static final int q = 3002;
  static final String q = AppConstants.an + "qqconnect/";
  protected static final int r = 3003;
  protected static final String r = "ConnAuthSvr.get_auth_api_list";
  protected static final int s = 3004;
  protected static final String s = "ConnAuthSvr.sdk_auth_api";
  protected static final int t = 3005;
  protected static final String t = "ConnAuthSvr.get_app_info";
  protected static final int u = 3007;
  protected static final String u = "ConnAuthSvr.get_auth_api_list_emp";
  protected static final int v = 1002;
  protected static final String v = "ConnAuthSvr.sdk_auth_api_emp";
  protected static final String w = "ConnAuthSvr.get_app_info_emp";
  protected static final int x = 100;
  public static final String x = "result_data";
  public int A;
  public String A;
  public int B;
  public String B;
  public int C;
  protected String C = null;
  protected String H = "";
  protected float a;
  public ProgressDialog a;
  protected SharedPreferences a;
  protected Bundle a;
  public Handler a;
  public View a;
  public Button a;
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  public AuthorityActivity.AccountInfo a;
  public PermissionView a;
  public OpenSDKAppInterface a;
  public Runnable a;
  ArrayList a;
  protected List a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  public long b;
  protected SharedPreferences b;
  public ImageView b;
  public TextView b;
  public Runnable b;
  public boolean b;
  public long c;
  protected SharedPreferences c;
  public TextView c;
  protected boolean c;
  protected long d;
  public boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h = false;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public boolean k;
  public String n = null;
  public int w = 0;
  public int y;
  public String y;
  public int z;
  public String z;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public AuthorityActivity()
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_y_of_type_Int = 6;
    this.jdField_z_of_type_Int = 0;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new hmm(this);
    this.jdField_a_of_type_JavaLangRunnable = new hmo(this);
    this.jdField_a_of_type_AndroidOsHandler = new hms(this);
    this.jdField_b_of_type_JavaLangRunnable = new hmz(this);
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = paramString.getInputStream();
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      return localBitmap;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected String a(String paramString)
  {
    while (paramString.length() < 10) {
      paramString = "0" + paramString;
    }
    return "o" + paramString;
  }
  
  public void a(int paramInt, String paramString)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 6;
    localMessage.arg1 = 3004;
    localMessage.obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramString3 = new Bundle();
    paramString3.putInt("error", paramInt);
    paramString3.putString("response", paramString1.toString());
    paramString3.putString("msg", null);
    paramString3.putString("detail", null);
    paramString2.setData(paramString3);
    paramString2.what = 7;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString2, 1000L);
  }
  
  public void a(long paramLong)
  {
    Object localObject2 = new GetAppInfoProto.GetAppinfoRequest();
    this.w = 2;
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).client_id.set(paramLong);
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set("android");
    if (Build.VERSION.RELEASE == null) {}
    for (Object localObject1 = "";; localObject1 = Build.VERSION.RELEASE)
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).os.set((String)localObject1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).qqv.set(c());
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).setHasFlag(true);
      NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
      localNewIntent.setWithouLogin(true);
      localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
      byte[] arrayOfByte = ((GetAppInfoProto.GetAppinfoRequest)localObject2).toByteArray();
      localObject2 = "ConnAuthSvr.get_app_info";
      localObject1 = arrayOfByte;
      if (!this.i)
      {
        localObject1 = a(arrayOfByte);
        localObject2 = "ConnAuthSvr.get_app_info_emp";
      }
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.putExtra("cmd", (String)localObject2);
      localNewIntent.setObserver(new hmq(this));
      super.getAppRuntime().startServlet(localNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {}
    do
    {
      return;
      paramString = ImageUtil.a(paramString);
    } while (paramString == null);
    paramString = new FileOutputStream(paramString);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
    paramString.flush();
    paramString.close();
  }
  
  public void a(SdkAuthorize.GetAuthApiListRequest paramGetAuthApiListRequest)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    this.i = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((SimpleAccount)((Iterator)localObject).next()).getUin().equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString)) {
          this.i = true;
        }
      }
    }
    NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    byte[] arrayOfByte = paramGetAuthApiListRequest.toByteArray();
    String str = "ConnAuthSvr.get_auth_api_list";
    Object localObject = "g_a_a_l";
    paramGetAuthApiListRequest = arrayOfByte;
    if (!this.i)
    {
      if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte.length == 0))
      {
        paramGetAuthApiListRequest = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramGetAuthApiListRequest.what = 6;
        paramGetAuthApiListRequest.arg1 = 3000;
        paramGetAuthApiListRequest.obj = getResources().getString(2131562746);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramGetAuthApiListRequest);
        return;
      }
      paramGetAuthApiListRequest = a(arrayOfByte);
      str = "ConnAuthSvr.get_auth_api_list_emp";
      localObject = "g_a_a_l_emp";
    }
    localNewIntent.putExtra("data", paramGetAuthApiListRequest);
    localNewIntent.putExtra("cmd", str);
    this.w = 0;
    localNewIntent.setObserver(new hmn(this));
    super.getAppRuntime().startServlet(localNewIntent);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this, super.getString(2131562443));
  }
  
  public void a(String paramString)
  {
    String str2 = "http://face" + (Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString) % 10L + 1L) + ".qun.qq.com/cgi/svr/face/getface?cache=0&type=1&f=100&uin=" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString;
    if (this.A == null) {
      this.A = paramString;
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      String str1 = this.A;
      paramString = str1;
      if (this.A != null)
      {
        paramString = str1;
        if (this.A.length() > 12) {
          paramString = this.A.substring(0, 12) + "...";
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131562175), new Object[] { paramString }));
    }
    d(str2);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramString = DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131562321)).setPositiveButton(17039370, paramOnClickListener);
    if (!super.isFinishing()) {
      paramString.show();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("AuthorityActivity", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) && (paramString.equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.c)))
    {
      paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramBitmap);
      if (paramString == null) {}
    }
    try
    {
      a(paramString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
      paramBitmap = ImageUtil.a(paramString, 17.0F, paramString.getWidth(), paramString.getHeight());
      paramString.recycle();
      if (paramBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      return;
    }
    catch (IOException paramBitmap)
    {
      for (;;)
      {
        LogUtility.c("AuthorityActivity", "-->onTaskCompleted error", paramBitmap);
        a(3007, paramBitmap.getMessage());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.jdField_c_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 674	java/io/File
    //   6: dup
    //   7: getstatic 157	com/tencent/open/agent/AuthorityActivity:q	Ljava/lang/String;
    //   10: invokespecial 675	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: aload 9
    //   17: invokevirtual 678	java/io/File:exists	()Z
    //   20: ifne +118 -> 138
    //   23: aload 9
    //   25: invokevirtual 681	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: new 137	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 683
    //   43: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 686	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 674	java/io/File
    //   60: dup
    //   61: aload 9
    //   63: aload_2
    //   64: invokespecial 689	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 678	java/io/File:exists	()Z
    //   72: ifeq +8 -> 80
    //   75: aload_1
    //   76: invokevirtual 692	java/io/File:delete	()Z
    //   79: pop
    //   80: invokestatic 698	java/lang/System:currentTimeMillis	()J
    //   83: ldc2_w 319
    //   86: ldiv
    //   87: lstore 6
    //   89: new 700	java/io/DataOutputStream
    //   92: dup
    //   93: new 432	java/io/FileOutputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 435	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: invokespecial 703	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore_1
    //   105: aload_1
    //   106: lload 6
    //   108: lload_3
    //   109: ladd
    //   110: invokevirtual 706	java/io/DataOutputStream:writeLong	(J)V
    //   113: aload_1
    //   114: aload 5
    //   116: aload_2
    //   117: ldc_w 708
    //   120: invokevirtual 712	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   123: invokestatic 717	com/tencent/util/ThreeDes:a	([B[B)[B
    //   126: invokevirtual 721	java/io/DataOutputStream:write	([B)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 722	java/io/DataOutputStream:close	()V
    //   137: return
    //   138: aload 9
    //   140: invokevirtual 725	java/io/File:isFile	()Z
    //   143: ifeq -114 -> 29
    //   146: aload 9
    //   148: invokevirtual 692	java/io/File:delete	()Z
    //   151: pop
    //   152: aload 9
    //   154: invokevirtual 681	java/io/File:mkdirs	()Z
    //   157: pop
    //   158: goto -129 -> 29
    //   161: astore_1
    //   162: aload 8
    //   164: astore_1
    //   165: aload_1
    //   166: ifnull -29 -> 137
    //   169: aload_1
    //   170: invokevirtual 722	java/io/DataOutputStream:close	()V
    //   173: return
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   179: return
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   185: return
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 722	java/io/DataOutputStream:close	()V
    //   197: aload_2
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_2
    //   208: goto -19 -> 189
    //   211: astore_2
    //   212: goto -47 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	AuthorityActivity
    //   0	215	1	paramString1	String
    //   0	215	2	paramString2	String
    //   0	215	3	paramLong	long
    //   0	215	5	paramArrayOfByte	byte[]
    //   87	20	6	l1	long
    //   1	162	8	localObject	Object
    //   13	140	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   3	29	161	java/io/IOException
    //   29	80	161	java/io/IOException
    //   80	105	161	java/io/IOException
    //   138	158	161	java/io/IOException
    //   169	173	174	java/io/IOException
    //   133	137	180	java/io/IOException
    //   3	29	186	finally
    //   29	80	186	finally
    //   80	105	186	finally
    //   138	158	186	finally
    //   193	197	199	java/io/IOException
    //   105	129	207	finally
    //   105	129	211	java/io/IOException
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
    localAccountInfo.jdField_a_of_type_JavaLangString = paramString1;
    localAccountInfo.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
    this.n = paramString1;
    o();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i1 = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    int i2 = i1;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      i2 = i1 + this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    Intent localIntent2;
    Intent localIntent1;
    if (i2 > 1)
    {
      localIntent2 = new Intent(this, SwitchAccountActivity.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent1 = localIntent2;
      if (this.n != null)
      {
        localIntent2.putExtra("param_uin", this.n);
        localIntent1 = localIntent2;
      }
    }
    for (;;)
    {
      super.startActivityForResult(localIntent1, 1);
      return;
      localIntent2 = new Intent(this, Login.class);
      localIntent2.putExtra("key_req_src", 1);
      localIntent1 = localIntent2;
      if (paramBoolean)
      {
        localIntent2.putExtra("is_first_login", true);
        localIntent1 = localIntent2;
      }
    }
  }
  
  /* Error */
  public byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 137	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   10: aload_1
    //   11: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 683
    //   17: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_2
    //   21: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 686	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_2
    //   31: new 674	java/io/File
    //   34: dup
    //   35: new 137	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   42: getstatic 157	com/tencent/open/agent/AuthorityActivity:q	Ljava/lang/String;
    //   45: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 675	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 678	java/io/File:exists	()Z
    //   63: istore 4
    //   65: iload 4
    //   67: ifne +25 -> 92
    //   70: iconst_0
    //   71: ifeq +11 -> 82
    //   74: new 785	java/lang/NullPointerException
    //   77: dup
    //   78: invokespecial 786	java/lang/NullPointerException:<init>	()V
    //   81: athrow
    //   82: aload 5
    //   84: areturn
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 787	java/lang/Exception:printStackTrace	()V
    //   90: aconst_null
    //   91: areturn
    //   92: new 789	java/io/DataInputStream
    //   95: dup
    //   96: new 791	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 792	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 795	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 798	java/io/DataInputStream:readLong	()J
    //   112: invokestatic 698	java/lang/System:currentTimeMillis	()J
    //   115: ldc2_w 319
    //   118: ldiv
    //   119: lcmp
    //   120: ifle +61 -> 181
    //   123: aload_1
    //   124: invokevirtual 801	java/io/DataInputStream:available	()I
    //   127: istore_3
    //   128: iload_3
    //   129: ifle +52 -> 181
    //   132: iload_3
    //   133: newarray byte
    //   135: astore 6
    //   137: aload_1
    //   138: aload 6
    //   140: invokevirtual 805	java/io/DataInputStream:read	([B)I
    //   143: pop
    //   144: aload_1
    //   145: invokevirtual 806	java/io/DataInputStream:close	()V
    //   148: aload 6
    //   150: aload_2
    //   151: ldc_w 708
    //   154: invokevirtual 712	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   157: invokestatic 808	com/tencent/util/ThreeDes:b	([B[B)[B
    //   160: astore_2
    //   161: aload_2
    //   162: astore 5
    //   164: aload_1
    //   165: ifnull -83 -> 82
    //   168: aload_1
    //   169: invokevirtual 806	java/io/DataInputStream:close	()V
    //   172: aload_2
    //   173: areturn
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 787	java/lang/Exception:printStackTrace	()V
    //   179: aload_2
    //   180: areturn
    //   181: aload_1
    //   182: ifnull -100 -> 82
    //   185: aload_1
    //   186: invokevirtual 806	java/io/DataInputStream:close	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 787	java/lang/Exception:printStackTrace	()V
    //   196: aconst_null
    //   197: areturn
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull -120 -> 82
    //   205: aload_1
    //   206: invokevirtual 806	java/io/DataInputStream:close	()V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 787	java/lang/Exception:printStackTrace	()V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 806	java/io/DataInputStream:close	()V
    //   229: aload_2
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 787	java/lang/Exception:printStackTrace	()V
    //   236: goto -7 -> 229
    //   239: astore_2
    //   240: goto -19 -> 221
    //   243: astore_2
    //   244: goto -43 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	AuthorityActivity
    //   0	247	1	paramString1	String
    //   0	247	2	paramString2	String
    //   127	6	3	i1	int
    //   63	3	4	bool	boolean
    //   1	162	5	localObject	Object
    //   135	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   74	82	85	java/lang/Exception
    //   168	172	174	java/lang/Exception
    //   185	189	191	java/lang/Exception
    //   3	65	198	java/io/IOException
    //   92	108	198	java/io/IOException
    //   205	209	211	java/lang/Exception
    //   3	65	218	finally
    //   92	108	218	finally
    //   225	229	231	java/lang/Exception
    //   108	128	239	finally
    //   132	161	239	finally
    //   108	128	243	java/io/IOException
    //   132	161	243	java/io/IOException
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte;
    byte[] arrayOfByte2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte2);
    arrayOfByte2 = new byte[arrayOfByte1.length + 4 + paramArrayOfByte.length];
    byte[] arrayOfByte3 = new byte[4];
    arrayOfByte3[0] = ((byte)(arrayOfByte1.length >> 24));
    arrayOfByte3[1] = ((byte)(arrayOfByte1.length >> 16));
    arrayOfByte3[2] = ((byte)(arrayOfByte1.length >> 8));
    arrayOfByte3[3] = ((byte)(arrayOfByte1.length >> 0));
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, arrayOfByte3.length, arrayOfByte1.length);
    int i1 = arrayOfByte3.length;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length + i1, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    if (TextUtils.isEmpty(paramString)) {
      a(String.format(super.getString(2131562322), new Object[] { Integer.valueOf(paramInt) }), new hmx(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131562746);
    d(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    super.setResult(-1, localIntent);
    super.finish();
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    if (paramInt != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", this.B);
      paramString1.put("errorcode", paramInt + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() != 1) {
          break label195;
        }
        paramString1.put("network", "wifi");
      }
    }
    for (;;)
    {
      StatisticCollector.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      return;
      label195:
      if (paramString2.getType() == 0) {
        switch (paramString2.getSubtype())
        {
        case 7: 
        default: 
          paramString1.put("network", "2G");
          break;
        case 1: 
        case 2: 
        case 4: 
          paramString1.put("network", "2G");
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          paramString1.put("network", "3G");
        }
      }
    }
  }
  
  protected void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject);
        String str = new String(((WloginSimpleInfo)localObject)._nick);
        this.n = Long.toString(((WloginSimpleInfo)localObject)._uin);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str + "(" + this.n + ")" + "　");
        paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);
      } while (paramString == null);
      localObject = ImageUtil.a(paramString, 17.0F, paramString.getWidth(), paramString.getHeight());
      paramString.recycle();
    } while (localObject == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
  }
  
  public void b(String paramString1, String paramString2)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, this.B + "|" + paramString2 + "|" + this.H);
  }
  
  protected boolean b(Intent paramIntent)
  {
    m();
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.getStringExtra("result_data");
    }
    try
    {
      localObject = HttpBaseUtil.a((String)localObject);
      AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
      localAccountInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
      localAccountInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("skey");
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localAccountInfo.jdField_a_of_type_JavaLangString != null) && (localAccountInfo.jdField_b_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
      }
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
        return true;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        a(3005, paramIntent.getMessage());
      }
    }
    return false;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    return cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte);
  }
  
  public String c()
  {
    try
    {
      String str = super.getPackageManager().getPackageInfo(super.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public void c(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramInt);
    localJSONObject.put("msg", paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = String.format(super.getString(2131562322), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131561498), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      a(paramString, new hmy(this, paramInt, localJSONObject));
      return;
    }
  }
  
  public void c(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(this.B)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localEditor.putString(this.B + ":" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
      d("http://face" + (Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString) % 10L + 1L) + ".qun.qq.com/cgi/svr/face/getface?cache=0&type=1&f=100&uin=" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", this.B);
    localHashMap.put("errorcode", paramInt + "");
    localHashMap.put("errormsg", paramString);
    paramString = ((ConnectivityManager)super.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramString != null)
    {
      if (paramString.getType() != 1) {
        break label113;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      StatisticCollector.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      return;
      label113:
      if (paramString.getType() == 0) {
        switch (paramString.getSubtype())
        {
        case 7: 
        default: 
          localHashMap.put("network", "2G");
          break;
        case 1: 
        case 2: 
        case 4: 
          localHashMap.put("network", "2G");
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          localHashMap.put("network", "3G");
        }
      }
    }
  }
  
  protected void d(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (localObject != null)
    {
      paramString = ImageUtil.a((Bitmap)localObject, 17.0F, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      ((Bitmap)localObject).recycle();
      if (paramString != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
      }
    }
    while ((paramString == null) || (paramString.equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.c))) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.c = paramString;
    localObject = new Bundle();
    ((Bundle)localObject).putString("Cookie", "uin=" + a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString) + "; skey=" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
    new HttpImageDownloadAsyncTask(paramString, paramString, (Bundle)localObject, "GET", this).execute(new Void[0]);
  }
  
  public void e()
  {
    int i4 = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        i2 = localObject1.length;
        i1 = 0;
        while (i1 < i2)
        {
          Object localObject2 = localObject1[i1];
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          i1 += 1;
        }
      }
      while (this.jdField_a_of_type_JavaUtilList.contains("")) {
        this.jdField_a_of_type_JavaUtilList.remove("");
      }
      this.jdField_a_of_type_JavaUtilArrayList = MsfSdkUtils.getLoginedAccountList();
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (!((SimpleAccount)localObject1).isLogined())
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
          i2 = i1 - 1;
          i1 = i2 + 1;
        }
        else
        {
          int i3 = 0;
          for (;;)
          {
            i2 = i1;
            if (i3 >= this.jdField_a_of_type_JavaUtilList.size()) {
              break;
            }
            if (((String)this.jdField_a_of_type_JavaUtilList.get(i3)).equals(((SimpleAccount)localObject1).getUin())) {
              this.jdField_a_of_type_JavaUtilList.remove(i3);
            }
            i3 += 1;
          }
        }
      }
      i1 = i4;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        i1 = 0 + this.jdField_a_of_type_JavaUtilList.size();
      }
      int i2 = i1;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i2 = i1 + this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if ((i2 > 0) && (this.n == null)) {
        this.n = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", null);
      }
      return;
    }
  }
  
  public void e(String paramString)
  {
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", this.B);
    if (this.jdField_d_of_type_Boolean)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.jdField_e_of_type_Boolean) {
        break label87;
      }
    }
    label87:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      StatisticCollector.a(this).a("0", "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  protected void f(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          ((ArrayList)localObject2).add(localObject1[i1]);
          i1 += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (paramString = ""; ((Iterator)localObject1).hasNext(); paramString = paramString + "," + (String)localObject2) {
          localObject2 = (String)((Iterator)localObject1).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localEditor.putString("accList", paramString);
      localEditor.commit();
      return;
    }
  }
  
  protected void g()
  {
    this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232095));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131232094);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232090));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232091));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232544));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131232096));
    this.jdField_y_of_type_JavaLangString = ((String)super.getText(2131562313));
    this.jdField_z_of_type_JavaLangString = ((String)super.getText(2131561674));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232543));
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
  }
  
  protected void h()
  {
    if (!b(null)) {
      j();
    }
  }
  
  public void i()
  {
    this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      a(false);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin())
    {
      l();
      return;
    }
    String str = super.getAppRuntime().getAccount();
    if (this.C != null) {
      str = this.C;
    }
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(str, 16))
    {
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(str));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(getResources().getString(2131561676));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
      }
      b("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, str));
      return;
    }
    l();
  }
  
  protected void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("firstlogin", true);
    Bitmap localBitmap1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.B);
    if (localBitmap1 != null)
    {
      this.jdField_f_of_type_Boolean = true;
      Bitmap localBitmap2 = ImageUtil.a(localBitmap1, 24.0F, localBitmap1.getWidth(), localBitmap1.getHeight());
      localBitmap1.recycle();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap2);
    }
    if ((bool) && (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount() == null))
    {
      a(true);
      ((SharedPreferences.Editor)localObject).putBoolean("firstlogin", false);
      ((SharedPreferences.Editor)localObject).commit();
      localObject = new HashMap();
      ((HashMap)localObject).put("appid", this.B);
      ((HashMap)localObject).put("p1", "notlogged");
      ((HashMap)localObject).put("p2", "uauth");
      StatisticCollector.a(this).a("0", "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_b_of_type_Long, 0L, (HashMap)localObject, "");
      return;
    }
    e();
    i();
  }
  
  protected void k()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(super.getString(2131562311));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
  
  protected void l()
  {
    k();
    if (this.n != null)
    {
      if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.n, 16))
      {
        e(this.n);
        return;
      }
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin :*" + AuthorityUtil.a(this.n));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.n, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      b("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.n));
      return;
    }
    a(true);
    this.jdField_d_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  protected void m()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void n()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentOpenWidgetPermissionView);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232105));
  }
  
  public void o()
  {
    this.jdField_g_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "";
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label104:
      String str;
      break label104;
    }
    localGetAuthApiListRequest.client_id.set(l1);
    if (Build.VERSION.RELEASE == null)
    {
      localObject = "";
      localGetAuthApiListRequest.os.set((String)localObject);
      localGetAuthApiListRequest.qqv.set(c());
      str = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.pf.set((String)localObject);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("scope");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.scope.set((String)localObject);
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label357;
      }
      localGetAuthApiListRequest.sdkp.set("android");
      label246:
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label370;
      }
      localGetAuthApiListRequest.sdkv.set("1.5.9");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localGetAuthApiListRequest.sign.set((String)localObject);
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          l1 = Long.parseLong((String)localObject);
          localGetAuthApiListRequest.time.set(l1);
        }
      }
      a(localGetAuthApiListRequest);
      return;
      localObject = Build.VERSION.RELEASE;
      break;
      label357:
      localGetAuthApiListRequest.sdkp.set((String)localObject);
      break label246;
      label370:
      localGetAuthApiListRequest.sdkv.set((String)localObject);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    }
    if (paramInt1 == 100) {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.C = paramIntent.getStringExtra("uin");
        }
        h();
      }
    }
    do
    {
      do
      {
        return;
        super.setResult(0);
        super.finish();
        f();
        return;
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
        }
        if (paramInt2 == 0)
        {
          if (TextUtils.isEmpty(this.n))
          {
            super.setResult(0, paramIntent);
            super.finish();
            f();
          }
          this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
          LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_f_of_type_Long - this.jdField_e_of_type_Long));
          return;
        }
      } while (-1 != paramInt2);
      this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
      LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_f_of_type_Long - this.jdField_e_of_type_Long));
      this.jdField_b_of_type_Boolean = b(paramIntent);
    } while (!jdField_a_of_type_Boolean);
    this.n = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    Object localObject;
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.n, localWloginSimpleInfo);
      localObject = new String(localWloginSimpleInfo._nick);
      this.n = Long.toString(localWloginSimpleInfo._uin);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject + "(" + this.n + ")" + "　");
      if (bool) {
        f(this.n);
      }
      localObject = paramIntent.getBundleExtra("ssobundle");
      if (localObject != null)
      {
        paramIntent = ((Bundle)localObject).getByteArray("st_temp");
        localObject = ((Bundle)localObject).getByteArray("st_temp_key");
        if ((paramIntent != null) && (localObject != null))
        {
          this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent;
          this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      o();
      return;
      localObject = paramIntent.getStringExtra("nick");
    }
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null)) {}
    super.setResult(0);
    super.finish();
    f();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_k_of_type_AndroidWidgetTextView)
    {
      super.setResult(0);
      super.finish();
      f();
    }
    do
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        if (this.h)
        {
          this.h = false;
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_y_of_type_JavaLangString);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("appid", this.B);
        localHashMap.put("p1", "logged");
        localHashMap.put("p2", "uauth");
        paramView = "0";
        if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
          paramView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString + "";
        }
        StatisticCollector.a(this).a(paramView, "connect_sso_change", false, 0L, 0L, localHashMap, "");
        a(false);
        this.jdField_k_of_type_Boolean = true;
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "<user:>authorize btn is clicked.");
    }
    long l1 = System.currentTimeMillis();
    try
    {
      if (l1 - this.jdField_d_of_type_Long < 500L) {
        return;
      }
    }
    finally {}
    this.jdField_d_of_type_Long = l1;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if ((this.j) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null))
    {
      i();
      return;
    }
    if (this.w == 0)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(super.getString(2131561676));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
      }
      o();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals(super.getString(2131562746)))
    {
      i();
      return;
    }
    p();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onCreate--");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.setContentView(2130903419);
    this.jdField_k_of_type_AndroidWidgetTextView.setText(2131561690);
    super.setTitle(2131562740);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    g();
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    this.A = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
    this.B = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
    this.H = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
    this.jdField_b_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "uin_openid_store");
    this.jdField_c_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "openid_encrytoken");
    this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this);
    try
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      if (this.A != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.A);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", 0);
      String str = super.getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if ("action_login".equals(str))
      {
        jdField_a_of_type_Boolean = true;
        str = super.getAppRuntime().getAccount();
        if ((GesturePWDUtils.getJumpLock(this, str)) && (!GesturePWDUtils.getAppForground(this)))
        {
          this.C = str;
          paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
          paramBundle.putExtra("key_gesture_from_authority", true);
          super.startActivityForResult(paramBundle, 100);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AuthorityActivity", 4, "-->mProgress.show()", localException);
          }
        }
        if (paramBundle == null)
        {
          h();
          return;
        }
        m();
        e();
        if (!TextUtils.isEmpty(this.n)) {
          b("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.n));
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramBundle = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.B);
      } while (paramBundle == null);
      this.jdField_f_of_type_Boolean = true;
      Bitmap localBitmap = ImageUtil.a(paramBundle, 24.0F, paramBundle.getWidth(), paramBundle.getHeight());
      paramBundle.recycle();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onDestroy--");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Long = 0L;
    this.i = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.jdField_k_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorityActivity", 2, "-->onResume--");
      QLog.d("SDKQQAgentPref", 2, "FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
    }
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    e();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("RESTART_FLAG", true);
    super.onSaveInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onSaveInstanceState--");
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "doAuthorize");
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentOpenWidgetPermissionView != null) {
      localObject1 = this.jdField_a_of_type_ComTencentOpenWidgetPermissionView.a();
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("openapi", "");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("doAuthorize", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("need_pay", "1");
    this.jdField_a_of_type_AndroidOsBundle.putString("appid_for_getting_config", this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "");
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(getResources().getString(2131562311));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    long l1 = Long.parseLong(this.B);
    Object localObject3 = new SdkAuthorize.AuthorizeRequest();
    ((SdkAuthorize.AuthorizeRequest)localObject3).client_id.set(l1);
    ((SdkAuthorize.AuthorizeRequest)localObject3).need_pay.set(1);
    if (localObject1 != null)
    {
      int i1 = 0;
      while (i1 < localObject1.length)
      {
        if (localObject1[i1].a > 0) {
          ((SdkAuthorize.AuthorizeRequest)localObject3).openapi.add(Integer.valueOf(localObject1[i1].b));
        }
        i1 += 1;
      }
    }
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      ((SdkAuthorize.AuthorizeRequest)localObject3).os.set((String)localObject1);
      ((SdkAuthorize.AuthorizeRequest)localObject3).qqv.set(c());
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).pf.set((String)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label625;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set("android");
      label339:
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label638;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set("1.5.9");
      label370:
      ((SdkAuthorize.AuthorizeRequest)localObject3).response_type.set("token");
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l1 = Long.parseLong((String)localObject1);
          ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject4 = ((Set)localObject1).iterator();
      label528:
      if (!((Iterator)localObject4).hasNext()) {
        break label658;
      }
      localObject5 = (String)((Iterator)localObject4).next();
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.get((String)localObject5);
      if (localObject1 == null) {
        break label651;
      }
    }
    label651:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append((String)localObject5 + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label528;
      localObject1 = Build.VERSION.RELEASE;
      break;
      label625:
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set((String)localObject1);
      break label339;
      label638:
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set((String)localObject1);
      break label370;
    }
    label658:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      ((SdkAuthorize.AuthorizeRequest)localObject3).passData.set(((StringBuffer)localObject2).toString());
    }
    ((SdkAuthorize.AuthorizeRequest)localObject3).skey.set(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
    this.w = 1;
    Object localObject5 = new NewIntent(this, OpensdkServlet.class);
    ((NewIntent)localObject5).setWithouLogin(true);
    ((NewIntent)localObject5).putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    Object localObject4 = ((SdkAuthorize.AuthorizeRequest)localObject3).toByteArray();
    localObject3 = "ConnAuthSvr.sdk_auth_api";
    Object localObject2 = "s_a_a";
    localObject1 = localObject4;
    if (!this.i)
    {
      localObject1 = a((byte[])localObject4);
      localObject3 = "ConnAuthSvr.sdk_auth_api_emp";
      localObject2 = "s_a_a_emp";
    }
    ((NewIntent)localObject5).putExtra("data", (byte[])localObject1);
    ((NewIntent)localObject5).putExtra("cmd", (String)localObject3);
    ((NewIntent)localObject5).setObserver(new hmr(this));
    super.getAppRuntime().startServlet((NewIntent)localObject5);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject2 + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  public void q()
  {
    this.h = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */