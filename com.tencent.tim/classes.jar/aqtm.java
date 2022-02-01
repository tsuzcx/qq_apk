import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.1;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.2;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqtm
  extends VasWebviewJsPlugin
  implements DialogInterface.OnDismissListener
{
  private static aqtm.a a;
  static long atL;
  static boolean cVX;
  static boolean cVY = true;
  static int ecA;
  public static int ecz = -1;
  String Model = null;
  String cwU = null;
  String cwV;
  String cwW = null;
  String cwX = null;
  String cwY = null;
  int ecB = 0;
  int ecC = 0;
  AtomicBoolean ev = new AtomicBoolean(false);
  public HashMap<String, Long> gb = new HashMap();
  public HashMap<String, Long> gc = new HashMap();
  public HashMap<String, Long> gd = new HashMap();
  private BusinessObserver k = new aqto(this);
  public Activity mActivity;
  private arhz progressDialog;
  
  public aqtm()
  {
    this.mPluginNameSpace = "healthkit";
  }
  
  private JSONObject A(String paramString)
  {
    int i = 0;
    SharedPreferences.Editor localEditor = this.mRuntime.a().getApplication().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + ".qqsport", 4).edit();
    localJSONObject = new JSONObject();
    try
    {
      paramString = new JSONObject(paramString);
      localEditor.putInt("STEP_RED_PACK_STATUS", paramString.optInt("status"));
      boolean bool = localEditor.commit();
      paramString = paramString.getString("callback");
      if (bool == true) {}
      for (;;)
      {
        localJSONObject.put("status", i);
        QLog.i("HealthStepCounterPlugin", 1, "setStepRedPackStatus:" + localJSONObject.toString());
        callJs(paramString, new String[] { localJSONObject.toString() });
        return localJSONObject;
        i = -1;
      }
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void VF(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (a == null)
    {
      localObject1 = new aqtm.a(null);
      localObject2 = (SensorManager)this.mActivity.getSystemService("sensor");
      ((SensorManager)localObject2).registerListener((SensorEventListener)localObject1, ((SensorManager)localObject2).getDefaultSensor(1), 0);
      a = (aqtm.a)localObject1;
      QLog.d("HealthStepCounterPlugin", 1, "register shakelistener");
    }
    try
    {
      this.cwW = new JSONObject(paramString).getString("callback");
      label69:
      if (!TextUtils.isEmpty(this.cwW))
      {
        this.ev.set(true);
        localObject1 = (SensorManager)this.mActivity.getSystemService("sensor");
        localObject2 = ((SensorManager)localObject1).getDefaultSensor(19);
        if ((Build.VERSION.SDK_INT >= 19) && (localObject2 != null)) {
          break label174;
        }
        this.cwX = "Unsupported model found.";
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("retCode", ecz);
        paramString.put("msg", this.cwX);
        label154:
        callJs(this.cwW, new String[] { paramString.toString() });
        return;
        label174:
        aqtp localaqtp = new aqtp(this);
        ((SensorManager)localObject1).registerListener(localaqtp, (Sensor)localObject2, 3, 0);
        ((SensorManager)localObject1).flush(localaqtp);
        localObject1 = new NewIntent(this.mRuntime.a().getApplication(), aque.class);
        ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_refresh_steps");
        ((NewIntent)localObject1).putExtra("json_string", paramString);
        ((NewIntent)localObject1).setObserver(this.k);
        this.mRuntime.a().startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception localException)
      {
        break label154;
      }
    }
    catch (Throwable localThrowable)
    {
      break label69;
    }
  }
  
  private void cW(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject1;
    label131:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject1 = new JSONObject(paramString1);
              paramString1 = ((JSONObject)localObject1).getString("callback");
              if (!TextUtils.isEmpty(paramString1))
              {
                if (aqiw.isNetworkAvailable(this.mActivity)) {
                  break label131;
                }
                paramString2 = new JSONObject();
                paramString2.put("ssoRet", 103);
                paramString2.put("businessRet", 0);
                paramString2.put("msg", "MSF未连接");
                super.callJs(paramString1, new String[] { paramString2.toString() });
                return;
              }
            }
            catch (Exception paramString1) {}
          }
        } while (!QLog.isColorLevel());
        QLog.e("HealthStepCounterPlugin", 2, "Exception:" + paramString1);
        return;
        l1 = 10240L;
        if (this.gc.containsKey("yundong_report.steps")) {
          l1 = ((Long)this.gc.get("yundong_report.steps")).longValue();
        }
        if ((l1 > 0L) && (((JSONObject)localObject1).toString().getBytes().length > l1))
        {
          paramString2 = new JSONObject();
          paramString2.put("ssoRet", 101);
          paramString2.put("businessRet", 0);
          paramString2.put("msg", acfp.m(2131707124));
          super.callJs(paramString1, new String[] { paramString2.toString() });
          return;
        }
        if (this.gd.containsKey("yundong_report.steps"))
        {
          long l2 = ((Long)this.gd.get("yundong_report.steps")).longValue();
          l1 = 1000L;
          if (this.gb.containsKey("yundong_report.steps")) {
            l1 = ((Long)this.gb.get("yundong_report.steps")).longValue();
          }
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 < l1))
          {
            paramString2 = new JSONObject();
            paramString2.put("ssoRet", 102);
            paramString2.put("businessRet", 0);
            paramString2.put("msg", acfp.m(2131707123));
            super.callJs(paramString1, new String[] { paramString2.toString() });
            this.gd.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
            return;
          }
        }
        this.gd.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.getBoolean("isStepCounterEnable"))
        {
          QLog.i("HealthStepCounterPlugin", 1, "web process report step found step counter off!");
          return;
        }
        localObject2 = String.valueOf(aqtw.hU());
      } while ((paramString2 == null) || (!paramString2.has((String)localObject2 + "_total")) || (!paramString2.has((String)localObject2 + "_init")) || (!paramString2.has((String)localObject2 + "_offset")));
      int i = paramString2.getInt((String)localObject2 + "_total");
      int j = paramString2.getInt((String)localObject2 + "_init");
      j = paramString2.getInt((String)localObject2 + "_offset") + (i - j);
      paramString2 = aqtw.ah();
      i = j;
      if (paramString2[1] != -1)
      {
        i = j;
        if (paramString2[1] > j)
        {
          QLog.e("HealthStepCounterPlugin", 1, "use device step:" + paramString2[1] + " instead of:" + j);
          i = paramString2[1];
        }
      }
      long l1 = NetConnInfoCenter.getServerTime();
      paramString2 = new JSONArray();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", 1);
      ((JSONObject)localObject2).put("time", l1);
      ((JSONObject)localObject2).put("steps", i);
      paramString2.put(localObject2);
      ((JSONObject)localObject1).put("oauth_consumer_key", 1002);
      ((JSONObject)localObject1).put("data", paramString2);
      ((JSONObject)localObject1).put("version", "3.4.4");
      if (TextUtils.isEmpty(this.Model)) {
        this.Model = URLEncoder.encode(Build.MODEL, "utf-8");
      }
      ((JSONObject)localObject1).put("model", this.Model);
      if (TextUtils.isEmpty(this.cwV))
      {
        paramString2 = TimeZone.getDefault();
        this.cwV = (paramString2.getDisplayName(false, 0) + " " + paramString2.getID());
      }
      ((JSONObject)localObject1).put("zone", String.valueOf(this.cwV));
      if (TextUtils.isEmpty(this.cwU)) {
        this.cwU = arxr.getImei();
      }
      ((JSONObject)localObject1).put("imei", String.valueOf(this.cwU));
      ((JSONObject)localObject1).put("adcode", aczc.getCityCode());
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "parameters:" + ((JSONObject)localObject1).toString());
      }
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("3.4.4");
      paramString2 = new WebSSOAgent.UniSsoServerReq();
      paramString2.comm.set((MessageMicro)localObject2);
      paramString2.reqdata.set(((JSONObject)localObject1).toString());
      localObject1 = new aqtn(this);
    } while (this.mRuntime == null);
    Object localObject2 = new NewIntent(this.mRuntime.getActivity().getApplicationContext(), ailu.class);
    ((NewIntent)localObject2).putExtra("extra_cmd", "yundong_report.steps");
    ((NewIntent)localObject2).putExtra("extra_data", paramString2.toByteArray());
    ((NewIntent)localObject2).putExtra("extra_callbackid", paramString1);
    ((NewIntent)localObject2).setObserver((BusinessObserver)localObject1);
    this.mRuntime.a().startServlet((NewIntent)localObject2);
  }
  
  private void updateServiceWorkerBackground(String paramString)
  {
    try
    {
      IX5WebViewExtension localIX5WebViewExtension = this.mRuntime.getWebView().getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        return;
      }
      paramString = new JSONObject(paramString).optString("serviceWorkerURL");
      paramString = paramString.substring(1, paramString.length() - 1).split(",");
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        localIX5WebViewExtension.updateServiceWorkerBackground(paramString[i]);
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private JSONObject x(String paramString)
  {
    label269:
    do
    {
      do
      {
        try
        {
          localJSONObject = new JSONObject();
          paramString = new JSONObject(paramString);
          str = paramString.getString("callback");
          i = paramString.optInt("x");
          j = paramString.optInt("y");
          m = paramString.optInt("w");
          n = paramString.optInt("h");
          paramString = this.mRuntime.getWebView();
          if (QLog.isColorLevel()) {
            QLog.i("HealthStepCounterPlugin", 2, "webview:" + paramString.getWidth() + "," + paramString.getHeight());
          }
          localObject = Bitmap.createBitmap(paramString.getWidth(), paramString.getHeight(), Bitmap.Config.ARGB_8888);
          paramString.draw(new Canvas((Bitmap)localObject));
          int i1 = this.mRuntime.getActivity().getWindowManager().getDefaultDisplay().getWidth();
          int i2 = this.mRuntime.getActivity().getWindowManager().getDefaultDisplay().getHeight();
          if ((i >= 0) && (j >= 0) && (m <= i1) && (n <= i2)) {
            break label269;
          }
          localJSONObject.put("code", -1);
          localJSONObject.put("image_url", "");
          callJs(str, new String[] { localJSONObject.toString() });
          paramString = localJSONObject;
          if (this.progressDialog != null)
          {
            this.progressDialog.dismiss();
            paramString = localJSONObject;
          }
        }
        catch (Exception paramString)
        {
          JSONObject localJSONObject;
          String str;
          int i;
          int j;
          int m;
          int n;
          Object localObject;
          if (!QLog.isColorLevel()) {
            break label568;
          }
          QLog.e("HealthStepCounterPlugin", 2, "Exception:" + paramString.toString());
          paramString = null;
          return null;
        }
        finally
        {
          if (this.progressDialog == null) {
            break label601;
          }
          this.progressDialog.dismiss();
        }
        return paramString;
        paramString = (String)localObject;
        if (m > 0)
        {
          paramString = (String)localObject;
          if (n > 0) {
            paramString = Bitmap.createBitmap((Bitmap)localObject, i, j, m, n);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("HealthStepCounterPlugin", 2, "bitmap size:" + paramString.getByteCount());
        }
        localObject = new File(aqul.getSDKPrivatePath("cache"));
        ((File)localObject).mkdirs();
        localObject = ((File)localObject).getAbsolutePath();
        localObject = (String)localObject + File.separator + System.currentTimeMillis() + ".png";
        aqhu.saveBitmapToFile(paramString, new File((String)localObject));
        if (paramString == null) {
          break;
        }
        localJSONObject.put("code", 0);
        localJSONObject.put("image_url", localObject);
        callJs(str, new String[] { localJSONObject.toString() });
        paramString = localJSONObject;
      } while (this.progressDialog == null);
      this.progressDialog.dismiss();
      return localJSONObject;
      localJSONObject.put("code", -2);
      localJSONObject.put("image_url", "");
      callJs(str, new String[] { localJSONObject.toString() });
      paramString = localJSONObject;
    } while (this.progressDialog == null);
    this.progressDialog.dismiss();
    return localJSONObject;
  }
  
  /* Error */
  private JSONObject y(String paramString)
  {
    // Byte code:
    //   0: new 141	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 142	org/json/JSONObject:<init>	()V
    //   7: astore 9
    //   9: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: aload_0
    //   14: getfield 100	aqtm:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   17: ifnull +1114 -> 1131
    //   20: aload_0
    //   21: getfield 205	aqtm:mActivity	Landroid/app/Activity;
    //   24: ifnull +1107 -> 1131
    //   27: iconst_0
    //   28: istore 5
    //   30: new 141	org/json/JSONObject
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 145	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: ldc 165
    //   42: invokevirtual 169	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 10
    //   47: aload 10
    //   49: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +6 -> 58
    //   55: aload 9
    //   57: areturn
    //   58: aload_1
    //   59: ldc_w 696
    //   62: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   65: istore_2
    //   66: aload_1
    //   67: ldc_w 640
    //   70: invokevirtual 169	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 11
    //   75: new 698	android/graphics/BitmapFactory$Options
    //   78: dup
    //   79: invokespecial 699	android/graphics/BitmapFactory$Options:<init>	()V
    //   82: astore_1
    //   83: aload_1
    //   84: iconst_1
    //   85: putfield 702	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   88: aload 11
    //   90: aload_1
    //   91: invokestatic 708	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   94: astore 8
    //   96: aload_1
    //   97: iconst_0
    //   98: putfield 702	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   101: aload 11
    //   103: aload_1
    //   104: invokestatic 708	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   107: astore_1
    //   108: aload_1
    //   109: astore 8
    //   111: new 659	java/io/File
    //   114: dup
    //   115: aload 11
    //   117: invokespecial 667	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore_1
    //   121: aload_1
    //   122: ifnull +126 -> 248
    //   125: new 710	java/io/FileOutputStream
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 713	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   133: astore 7
    //   135: aload 7
    //   137: astore_1
    //   138: aload 8
    //   140: getstatic 719	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   143: bipush 80
    //   145: aload 7
    //   147: invokevirtual 723	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   150: istore 6
    //   152: aload 7
    //   154: astore_1
    //   155: aload_0
    //   156: getfield 644	aqtm:progressDialog	Larhz;
    //   159: ifnull +975 -> 1134
    //   162: aload 7
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 644	aqtm:progressDialog	Larhz;
    //   169: invokevirtual 726	arhz:isShowing	()Z
    //   172: ifeq +962 -> 1134
    //   175: aload 7
    //   177: astore_1
    //   178: aload_0
    //   179: getfield 644	aqtm:progressDialog	Larhz;
    //   182: invokevirtual 649	arhz:dismiss	()V
    //   185: goto +949 -> 1134
    //   188: aload 7
    //   190: astore_1
    //   191: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +36 -> 230
    //   197: aload 7
    //   199: astore_1
    //   200: ldc 175
    //   202: iconst_2
    //   203: new 113	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 728
    //   213: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   219: lload_3
    //   220: lsub
    //   221: invokevirtual 679	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: iload 6
    //   232: istore 5
    //   234: aload 7
    //   236: ifnull +12 -> 248
    //   239: aload 7
    //   241: invokevirtual 731	java/io/FileOutputStream:close	()V
    //   244: iload 6
    //   246: istore 5
    //   248: new 141	org/json/JSONObject
    //   251: dup
    //   252: invokespecial 142	org/json/JSONObject:<init>	()V
    //   255: astore_1
    //   256: iload 5
    //   258: ifeq +795 -> 1053
    //   261: aload_1
    //   262: ldc_w 733
    //   265: iconst_0
    //   266: invokevirtual 173	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   269: pop
    //   270: aload_1
    //   271: ldc 248
    //   273: ldc_w 734
    //   276: invokestatic 352	acfp:m	(I)Ljava/lang/String;
    //   279: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   282: pop
    //   283: aload_1
    //   284: ldc_w 736
    //   287: aload 11
    //   289: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 9
    //   295: ldc_w 638
    //   298: iconst_0
    //   299: invokevirtual 173	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   302: pop
    //   303: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +12 -> 318
    //   309: ldc 175
    //   311: iconst_2
    //   312: ldc_w 738
    //   315: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload_0
    //   319: aload 10
    //   321: iconst_1
    //   322: anewarray 186	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: aload 9
    //   329: invokevirtual 178	org/json/JSONObject:toString	()Ljava/lang/String;
    //   332: aastore
    //   333: invokevirtual 190	aqtm:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   336: aload 9
    //   338: areturn
    //   339: astore_1
    //   340: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +788 -> 1131
    //   346: ldc 175
    //   348: iconst_2
    //   349: new 113	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 317
    //   359: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_1
    //   363: invokevirtual 688	java/lang/Exception:toString	()Ljava/lang/String;
    //   366: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload 9
    //   377: areturn
    //   378: astore_1
    //   379: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +32 -> 414
    //   385: ldc 175
    //   387: iconst_2
    //   388: new 113	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 317
    //   398: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 739	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   405: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: goto -303 -> 111
    //   417: aload 7
    //   419: astore_1
    //   420: new 741	android/os/Bundle
    //   423: dup
    //   424: invokespecial 742	android/os/Bundle:<init>	()V
    //   427: astore 8
    //   429: aload 7
    //   431: astore_1
    //   432: aload 8
    //   434: ldc_w 744
    //   437: iconst_1
    //   438: invokevirtual 747	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   441: aload 7
    //   443: astore_1
    //   444: aload 8
    //   446: ldc_w 749
    //   449: aload 11
    //   451: invokevirtual 752	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload 7
    //   456: astore_1
    //   457: aload 8
    //   459: ldc_w 754
    //   462: aload 11
    //   464: invokevirtual 752	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload 7
    //   469: astore_1
    //   470: aload 8
    //   472: ldc_w 756
    //   475: aload 11
    //   477: invokevirtual 752	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload 7
    //   482: astore_1
    //   483: aload 8
    //   485: ldc_w 758
    //   488: aload 11
    //   490: invokevirtual 752	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload 7
    //   495: astore_1
    //   496: aload 8
    //   498: ldc_w 760
    //   501: iconst_1
    //   502: invokevirtual 764	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   505: aload 7
    //   507: astore_1
    //   508: new 766	android/content/Intent
    //   511: dup
    //   512: invokespecial 767	android/content/Intent:<init>	()V
    //   515: astore 12
    //   517: aload 7
    //   519: astore_1
    //   520: aload 12
    //   522: aload 8
    //   524: invokevirtual 771	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   527: pop
    //   528: aload 7
    //   530: astore_1
    //   531: aload_0
    //   532: getfield 205	aqtm:mActivity	Landroid/app/Activity;
    //   535: aload 12
    //   537: bipush 21
    //   539: invokestatic 777	ahgq:f	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   542: goto -354 -> 188
    //   545: astore 8
    //   547: aload 7
    //   549: astore_1
    //   550: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +36 -> 589
    //   556: aload 7
    //   558: astore_1
    //   559: ldc 175
    //   561: iconst_2
    //   562: new 113	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 317
    //   572: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 8
    //   577: invokevirtual 778	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   580: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: iconst_0
    //   590: istore 6
    //   592: iload 6
    //   594: istore 5
    //   596: aload 7
    //   598: ifnull -350 -> 248
    //   601: aload 7
    //   603: invokevirtual 731	java/io/FileOutputStream:close	()V
    //   606: iload 6
    //   608: istore 5
    //   610: goto -362 -> 248
    //   613: astore_1
    //   614: iload 6
    //   616: istore 5
    //   618: goto -370 -> 248
    //   621: aload 7
    //   623: astore_1
    //   624: new 741	android/os/Bundle
    //   627: dup
    //   628: invokespecial 742	android/os/Bundle:<init>	()V
    //   631: astore 8
    //   633: aload 7
    //   635: astore_1
    //   636: new 780	java/util/ArrayList
    //   639: dup
    //   640: invokespecial 781	java/util/ArrayList:<init>	()V
    //   643: astore 12
    //   645: aload 7
    //   647: astore_1
    //   648: aload 12
    //   650: aload 11
    //   652: invokestatic 786	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   655: invokevirtual 789	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   658: pop
    //   659: aload 7
    //   661: astore_1
    //   662: aload 8
    //   664: ldc_w 791
    //   667: aload 12
    //   669: invokevirtual 795	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   672: aload 7
    //   674: astore_1
    //   675: aload 8
    //   677: ldc_w 797
    //   680: ldc_w 798
    //   683: invokestatic 352	acfp:m	(I)Ljava/lang/String;
    //   686: invokevirtual 752	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: aload 7
    //   691: astore_1
    //   692: aload 8
    //   694: ldc_w 800
    //   697: bipush 7
    //   699: invokevirtual 747	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   702: aload 7
    //   704: astore_1
    //   705: aload 8
    //   707: ldc_w 802
    //   710: iconst_0
    //   711: invokevirtual 764	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   714: aload 7
    //   716: astore_1
    //   717: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   720: ifeq +33 -> 753
    //   723: aload 7
    //   725: astore_1
    //   726: ldc 175
    //   728: iconst_2
    //   729: new 113	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 804
    //   739: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 8
    //   744: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: aload 7
    //   755: astore_1
    //   756: aload_0
    //   757: getfield 100	aqtm:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   760: invokevirtual 105	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   763: aload_0
    //   764: getfield 100	aqtm:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   767: invokevirtual 535	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   770: aload 8
    //   772: aload_0
    //   773: invokestatic 809	avqq:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnDismissListener;)V
    //   776: goto -588 -> 188
    //   779: astore 8
    //   781: aload_1
    //   782: astore 7
    //   784: aload 8
    //   786: astore_1
    //   787: aload 7
    //   789: ifnull +8 -> 797
    //   792: aload 7
    //   794: invokevirtual 731	java/io/FileOutputStream:close	()V
    //   797: aload_1
    //   798: athrow
    //   799: aload 7
    //   801: astore_1
    //   802: invokestatic 814	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   805: invokevirtual 817	com/tencent/mobileqq/wxapi/WXShareHelper:isWXinstalled	()Z
    //   808: ifeq +20 -> 828
    //   811: aload 7
    //   813: astore_1
    //   814: invokestatic 814	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   817: aload 11
    //   819: aload 8
    //   821: iconst_1
    //   822: invokevirtual 820	com/tencent/mobileqq/wxapi/WXShareHelper:b	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   825: goto -637 -> 188
    //   828: aload 7
    //   830: astore_1
    //   831: aload_0
    //   832: getfield 100	aqtm:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   835: invokevirtual 558	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   838: new 822	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4
    //   841: dup
    //   842: aload_0
    //   843: invokespecial 823	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4:<init>	(Laqtm;)V
    //   846: invokevirtual 827	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   849: pop
    //   850: goto -662 -> 188
    //   853: aload 7
    //   855: astore_1
    //   856: invokestatic 814	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   859: invokevirtual 817	com/tencent/mobileqq/wxapi/WXShareHelper:isWXinstalled	()Z
    //   862: ifeq +20 -> 882
    //   865: aload 7
    //   867: astore_1
    //   868: invokestatic 814	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   871: aload 11
    //   873: aload 8
    //   875: iconst_0
    //   876: invokevirtual 820	com/tencent/mobileqq/wxapi/WXShareHelper:b	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   879: goto -691 -> 188
    //   882: aload 7
    //   884: astore_1
    //   885: aload_0
    //   886: getfield 100	aqtm:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   889: invokevirtual 558	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   892: new 829	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5
    //   895: dup
    //   896: aload_0
    //   897: invokespecial 830	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5:<init>	(Laqtm;)V
    //   900: invokevirtual 827	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   903: pop
    //   904: goto -716 -> 188
    //   907: aload 7
    //   909: astore_1
    //   910: new 659	java/io/File
    //   913: dup
    //   914: new 113	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   921: getstatic 835	acbn:oM	Ljava/lang/String;
    //   924: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: getstatic 676	java/io/File:separator	Ljava/lang/String;
    //   930: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   936: invokevirtual 679	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   939: ldc_w 681
    //   942: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokespecial 667	java/io/File:<init>	(Ljava/lang/String;)V
    //   951: astore 12
    //   953: aload 7
    //   955: astore_1
    //   956: aload 8
    //   958: aload 12
    //   960: invokestatic 687	aqhu:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   963: aload 7
    //   965: astore_1
    //   966: new 766	android/content/Intent
    //   969: dup
    //   970: ldc_w 837
    //   973: invokespecial 838	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   976: astore 8
    //   978: aload 7
    //   980: astore_1
    //   981: aload 8
    //   983: aload 12
    //   985: invokestatic 844	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   988: invokevirtual 848	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   991: pop
    //   992: aload 7
    //   994: astore_1
    //   995: aload_0
    //   996: getfield 100	aqtm:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   999: invokevirtual 535	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   1002: invokevirtual 539	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   1005: aload 8
    //   1007: invokevirtual 854	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   1010: aload 7
    //   1012: astore_1
    //   1013: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq -828 -> 188
    //   1019: aload 7
    //   1021: astore_1
    //   1022: ldc 175
    //   1024: iconst_2
    //   1025: new 113	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1032: ldc_w 856
    //   1035: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: getstatic 835	acbn:oM	Ljava/lang/String;
    //   1041: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: goto -862 -> 188
    //   1053: aload_1
    //   1054: ldc_w 733
    //   1057: iconst_m1
    //   1058: invokevirtual 173	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1061: pop
    //   1062: aload_1
    //   1063: ldc 248
    //   1065: ldc_w 857
    //   1068: invokestatic 352	acfp:m	(I)Ljava/lang/String;
    //   1071: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1074: pop
    //   1075: aload 9
    //   1077: ldc_w 638
    //   1080: iconst_m1
    //   1081: invokevirtual 173	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1084: pop
    //   1085: invokestatic 315	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1088: ifeq -770 -> 318
    //   1091: ldc 175
    //   1093: iconst_2
    //   1094: ldc_w 859
    //   1097: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1100: goto -782 -> 318
    //   1103: astore_1
    //   1104: iload 6
    //   1106: istore 5
    //   1108: goto -860 -> 248
    //   1111: astore 7
    //   1113: goto -316 -> 797
    //   1116: astore_1
    //   1117: aconst_null
    //   1118: astore 7
    //   1120: goto -333 -> 787
    //   1123: astore 8
    //   1125: aconst_null
    //   1126: astore 7
    //   1128: goto -581 -> 547
    //   1131: aload 9
    //   1133: areturn
    //   1134: iload_2
    //   1135: tableswitch	default:+33 -> 1168, 1:+-718->417, 2:+-514->621, 3:+-282->853, 4:+-336->799, 5:+-228->907
    //   1169: <illegal opcode>
    //   1170: aload_2
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1171	0	this	aqtm
    //   0	1171	1	paramString	String
    //   65	1070	2	i	int
    //   12	208	3	l	long
    //   28	1079	5	j	int
    //   150	955	6	bool	boolean
    //   133	887	7	localObject1	Object
    //   1111	1	7	localIOException	java.io.IOException
    //   1118	9	7	localObject2	Object
    //   94	429	8	localObject3	Object
    //   545	31	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   631	140	8	localBundle	android.os.Bundle
    //   779	178	8	localBitmap	Bitmap
    //   976	30	8	localIntent	Intent
    //   1123	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   7	1125	9	localJSONObject	JSONObject
    //   45	275	10	str1	String
    //   73	799	11	str2	String
    //   515	469	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   30	55	339	java/lang/Exception
    //   58	101	339	java/lang/Exception
    //   101	108	339	java/lang/Exception
    //   111	121	339	java/lang/Exception
    //   239	244	339	java/lang/Exception
    //   248	256	339	java/lang/Exception
    //   261	318	339	java/lang/Exception
    //   318	336	339	java/lang/Exception
    //   379	414	339	java/lang/Exception
    //   601	606	339	java/lang/Exception
    //   792	797	339	java/lang/Exception
    //   797	799	339	java/lang/Exception
    //   1053	1100	339	java/lang/Exception
    //   101	108	378	java/lang/OutOfMemoryError
    //   138	152	545	java/io/FileNotFoundException
    //   155	162	545	java/io/FileNotFoundException
    //   165	175	545	java/io/FileNotFoundException
    //   178	185	545	java/io/FileNotFoundException
    //   191	197	545	java/io/FileNotFoundException
    //   200	230	545	java/io/FileNotFoundException
    //   420	429	545	java/io/FileNotFoundException
    //   432	441	545	java/io/FileNotFoundException
    //   444	454	545	java/io/FileNotFoundException
    //   457	467	545	java/io/FileNotFoundException
    //   470	480	545	java/io/FileNotFoundException
    //   483	493	545	java/io/FileNotFoundException
    //   496	505	545	java/io/FileNotFoundException
    //   508	517	545	java/io/FileNotFoundException
    //   520	528	545	java/io/FileNotFoundException
    //   531	542	545	java/io/FileNotFoundException
    //   624	633	545	java/io/FileNotFoundException
    //   636	645	545	java/io/FileNotFoundException
    //   648	659	545	java/io/FileNotFoundException
    //   662	672	545	java/io/FileNotFoundException
    //   675	689	545	java/io/FileNotFoundException
    //   692	702	545	java/io/FileNotFoundException
    //   705	714	545	java/io/FileNotFoundException
    //   717	723	545	java/io/FileNotFoundException
    //   726	753	545	java/io/FileNotFoundException
    //   756	776	545	java/io/FileNotFoundException
    //   802	811	545	java/io/FileNotFoundException
    //   814	825	545	java/io/FileNotFoundException
    //   831	850	545	java/io/FileNotFoundException
    //   856	865	545	java/io/FileNotFoundException
    //   868	879	545	java/io/FileNotFoundException
    //   885	904	545	java/io/FileNotFoundException
    //   910	953	545	java/io/FileNotFoundException
    //   956	963	545	java/io/FileNotFoundException
    //   966	978	545	java/io/FileNotFoundException
    //   981	992	545	java/io/FileNotFoundException
    //   995	1010	545	java/io/FileNotFoundException
    //   1013	1019	545	java/io/FileNotFoundException
    //   1022	1050	545	java/io/FileNotFoundException
    //   601	606	613	java/io/IOException
    //   138	152	779	finally
    //   155	162	779	finally
    //   165	175	779	finally
    //   178	185	779	finally
    //   191	197	779	finally
    //   200	230	779	finally
    //   420	429	779	finally
    //   432	441	779	finally
    //   444	454	779	finally
    //   457	467	779	finally
    //   470	480	779	finally
    //   483	493	779	finally
    //   496	505	779	finally
    //   508	517	779	finally
    //   520	528	779	finally
    //   531	542	779	finally
    //   550	556	779	finally
    //   559	589	779	finally
    //   624	633	779	finally
    //   636	645	779	finally
    //   648	659	779	finally
    //   662	672	779	finally
    //   675	689	779	finally
    //   692	702	779	finally
    //   705	714	779	finally
    //   717	723	779	finally
    //   726	753	779	finally
    //   756	776	779	finally
    //   802	811	779	finally
    //   814	825	779	finally
    //   831	850	779	finally
    //   856	865	779	finally
    //   868	879	779	finally
    //   885	904	779	finally
    //   910	953	779	finally
    //   956	963	779	finally
    //   966	978	779	finally
    //   981	992	779	finally
    //   995	1010	779	finally
    //   1013	1019	779	finally
    //   1022	1050	779	finally
    //   239	244	1103	java/io/IOException
    //   792	797	1111	java/io/IOException
    //   125	135	1116	finally
    //   125	135	1123	java/io/FileNotFoundException
  }
  
  private JSONObject z(String paramString)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + ".qqsport", 4).getInt("STEP_RED_PACK_STATUS", 0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      localJSONObject.put("status", i);
      QLog.i("HealthStepCounterPlugin", 1, "getStepRedPackStatus:" + localJSONObject.toString());
      callJs(paramString, new String[] { localJSONObject.toString() });
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("HealthStepCounterPlugin", 2, "handleJsRequest!!");
    }
    if ((paramString1 == null) || (!"healthkit".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    try
    {
      if (!paramString3.equals("readHKData")) {
        break label276;
      }
      if (paramVarArgs.length <= 0) {
        break label274;
      }
      paramJsBridgeListener = (SensorManager)this.mActivity.getSystemService("sensor");
      if ((Build.VERSION.SDK_INT < 19) || (paramJsBridgeListener.getDefaultSensor(19) == null))
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          return false;
        }
        paramString1 = new JSONObject();
        paramString1.put("ssoRet", 255);
        paramString1.put("businessRet", 0);
        paramString1.put("msg", acfp.m(2131707129));
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      }
      else
      {
        paramJsBridgeListener = new NewIntent(this.mRuntime.a().getApplication(), aque.class);
        paramJsBridgeListener.putExtra("msf_cmd_type", "cmd_refresh_steps");
        paramJsBridgeListener.putExtra("json_string", paramVarArgs[0]);
        paramJsBridgeListener.setObserver(this.k);
        this.mRuntime.a().startServlet(paramJsBridgeListener);
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      QLog.d("HealthStepCounterPlugin", 2, "Err:" + paramJsBridgeListener.toString());
    }
    return false;
    label274:
    return true;
    label276:
    int i;
    if (paramString3.equals("healthSwitch"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "healthSwitch:" + paramVarArgs[0]);
      }
      paramJsBridgeListener = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.health_ban.name(), "");
      if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (Integer.parseInt(paramJsBridgeListener) == 0))
      {
        paramJsBridgeListener = new JSONObject();
        paramString1 = new JSONObject(paramVarArgs[0]).getString("callback");
        paramJsBridgeListener.put("businessRet", 202);
        paramJsBridgeListener.put("msg", acfp.m(2131707125));
        super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        return true;
      }
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject(paramVarArgs[0]);
      paramString1 = paramString2.getString("callback");
      boolean bool = paramString2.getBoolean("isOpen");
      if (this.mActivity == null) {
        break label1157;
      }
      paramString2 = new NewIntent(this.mActivity, aque.class);
      paramString2.putExtra("msf_cmd_type", "cmd_health_switch");
      paramString2.putExtra("isOpen", bool);
      this.mRuntime.a().startServlet(paramString2);
      paramJsBridgeListener.put("businessRet", 0);
      paramJsBridgeListener.put("msg", acfp.m(2131707126));
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramJsBridgeListener.put("businessRet", 201);
        paramJsBridgeListener.put("msg", acfp.m(2131707132));
        super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        break label1165;
        if (paramString3.equals("shareSnapshot"))
        {
          if (this.progressDialog == null)
          {
            paramJsBridgeListener = localObject2;
            if (this.mRuntime.b() != null) {
              paramJsBridgeListener = this.mRuntime.b().b().b();
            }
            this.progressDialog = paramJsBridgeListener;
          }
          if (this.progressDialog != null)
          {
            this.progressDialog.setMessage(2131695695);
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
          }
          ThreadManager.post(new HealthStepCounterPlugin.1(this, paramVarArgs[0]), 5, null, true);
          return true;
        }
        if (paramString3.equals("snapshot"))
        {
          paramString1 = paramVarArgs[0];
          if (this.progressDialog == null)
          {
            if (this.mRuntime.b() != null) {
              paramJsBridgeListener = this.mRuntime.b().b().b();
            }
            this.progressDialog = paramJsBridgeListener;
          }
          if (this.progressDialog != null)
          {
            this.progressDialog.setMessage(2131695695);
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
          }
          ThreadManager.post(new HealthStepCounterPlugin.2(this, paramString1), 5, null, true);
          return true;
        }
        if (paramString3.equals("TestReport"))
        {
          VF(paramVarArgs[0]);
          break;
        }
        if (paramString3.equals("getCurrentStep"))
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
          paramString1 = new NewIntent(this.mRuntime.a().getApplication(), aque.class);
          paramString1.putExtra("msf_cmd_type", "cmd_refresh_steps");
          paramString1.putExtra("json_string", paramVarArgs[0]);
          paramString1.putExtra("json_getstepcallback", paramJsBridgeListener);
          paramString1.setObserver(this.k);
          this.mRuntime.a().startServlet(paramString1);
          break;
        }
        if ("jumpToSetting".equals(paramString3))
        {
          paramString2 = new JSONObject();
          paramJsBridgeListener = localObject1;
          try
          {
            paramString3 = this.mRuntime.getActivity();
            paramJsBridgeListener = localObject1;
            paramString1 = new JSONObject(paramVarArgs[0]).getString("callback");
            paramJsBridgeListener = paramString1;
            paramVarArgs = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            paramJsBridgeListener = paramString1;
            paramVarArgs.setData(Uri.parse("package:" + paramString3.getPackageName()));
            paramJsBridgeListener = paramString1;
            paramString3.startActivity(paramVarArgs);
            paramJsBridgeListener = paramString1;
            paramString2.put("ret", 0);
            paramJsBridgeListener = paramString1;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              try
              {
                paramString2.put("ret", -1);
              }
              catch (JSONException paramString1) {}
            }
          }
          if (TextUtils.isEmpty(paramJsBridgeListener)) {
            break;
          }
          callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          break;
        }
        if (paramString3.equals("getStepRedPackStatus"))
        {
          z(paramVarArgs[0]);
          return true;
        }
        if (paramString3.equals("setStepRedPackStatus"))
        {
          A(paramVarArgs[0]);
          return true;
        }
        if (!paramString3.equals("updateServiceWorkerBackground")) {
          break;
        }
        updateServiceWorkerBackground(paramVarArgs[0]);
        break;
        label1157:
        i = 0;
        continue;
        return true;
      }
    }
    label1165:
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.getActivity();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (a != null)
    {
      ((SensorManager)this.mActivity.getSystemService("sensor")).unregisterListener(a);
      a = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  static class a
    implements SensorEventListener
  {
    private int cnt;
    private long lastTime;
    private float sR;
    private float sS;
    private float sT;
    private float sU;
    
    private void hO(long paramLong)
    {
      this.lastTime = paramLong;
      this.sR = 0.0F;
      this.sS = 0.0F;
      this.sT = 0.0F;
      this.sU = 0.0F;
      this.cnt = 0;
    }
    
    public void FZ()
    {
      aqtm.ecA = 1;
      aqtm.cVX = true;
    }
    
    public void efv()
    {
      aqtm.ecA = 3;
      QLog.d("HealthStepCounterPlugin", 1, "shaking end");
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      float f1 = 0.0F;
      float f2;
      float f3;
      float f4;
      long l1;
      long l2;
      if (paramSensorEvent.sensor.getType() == 1)
      {
        f2 = paramSensorEvent.values[0];
        f3 = paramSensorEvent.values[1];
        f4 = paramSensorEvent.values[2];
        l1 = System.currentTimeMillis();
        l2 = l1 - this.lastTime;
        if (l2 <= 5000L) {
          break label66;
        }
        hO(l1);
      }
      label66:
      do
      {
        do
        {
          return;
        } while (l2 <= 80L);
        if ((this.sR != 0.0F) || (this.sS != 0.0F) || (this.sT != 0.0F)) {
          f1 = Math.abs(f2 - this.sR) + Math.abs(f3 - this.sS) + Math.abs(f4 - this.sT);
        }
        this.sU = (f1 + this.sU);
        if ((this.sU > 180.0F) && (this.cnt >= 3))
        {
          FZ();
          hO(l1);
          return;
        }
        if (this.cnt < 10)
        {
          this.cnt += 1;
          this.sR = f2;
          this.sS = f3;
          this.sT = f4;
          this.lastTime = l1;
          return;
        }
        hO(l1);
      } while (aqtm.ecA >= 3);
      efv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtm
 * JD-Core Version:    0.7.0.1
 */