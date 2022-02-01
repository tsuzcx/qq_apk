import android.app.Activity;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt.2;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class obu
  implements QQRecorder.a
{
  private static String GX = "";
  private static String apl = "";
  private static String apm = "";
  private static String apo = "";
  private static String apq = "";
  private static int bdZ;
  private static double mDuration;
  private int MAX_TIME = 60000;
  private String TAG = "PublicAccountH5AbilityForPtt";
  private aqnt.a jdField_a_of_type_Aqnt$a = new obv(this);
  aqnt jdField_a_of_type_Aqnt;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  Activity activity;
  private FileOutputStream d;
  private File mFile;
  private Handler mHandler;
  WebViewPlugin.a mRuntime;
  private String uin;
  
  public obu() {}
  
  public obu(Activity paramActivity, String paramString, WebViewPlugin.a parama)
  {
    this.mRuntime = parama;
    this.activity = paramActivity;
    this.uin = paramString;
  }
  
  private void afq()
  {
    new SpannableString(this.activity.getString(2131700685));
  }
  
  public static String le()
  {
    return apl;
  }
  
  public static String lf()
  {
    return apm;
  }
  
  public static String lg()
  {
    return apo;
  }
  
  public static void pd(String paramString)
  {
    apl = paramString;
  }
  
  public static void pe(String paramString)
  {
    apq = paramString;
  }
  
  public static int rf()
  {
    return bdZ;
  }
  
  public static int rg()
  {
    if (mDuration != 0.0D) {
      return QQRecorder.d(mDuration);
    }
    return 0;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    return this.MAX_TIME;
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (bQ(acbn.SDCARD_PATH + "c2bPTT/"))
    {
      this.mFile = new File(paramString);
      if (this.mFile.exists()) {
        this.mFile.delete();
      }
      try
      {
        this.d = new FileOutputStream(this.mFile);
        this.d.write("#!AMR\n".getBytes());
        return;
      }
      catch (FileNotFoundException paramString)
      {
        this.d = null;
        paramString.printStackTrace();
        return;
      }
      catch (IOException paramString)
      {
        this.d = null;
        return;
      }
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "no sdCard");
      if (this.mRuntime.getWebView() != null) {
        this.mRuntime.getWebView().callJs(obw.apr, new String[] { paramString.toString() });
      }
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    mDuration = paramDouble;
    paramString = new JSONObject();
    for (;;)
    {
      try
      {
        if (mDuration == this.MAX_TIME)
        {
          paramString.put("retCode", 0);
          paramString.put("localId", lh());
          if (this.mRuntime.getWebView() != null) {
            this.mRuntime.getWebView().callJs(obw.apv, new String[] { paramString.toString() });
          }
          anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2B", "0X8005D2B", 0, 0, "1", "", "", "");
          return;
        }
        if (this.mFile.exists())
        {
          paramString.put("retCode", 0);
          paramString.put("localId", lh());
          anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 0, "1", "", "", "");
          if (this.mRuntime.getWebView() == null) {
            break;
          }
          this.mRuntime.getWebView().callJs(obw.aps, new String[] { paramString.toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString.put("retCode", -1);
      paramString.put("localId", lh());
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, -1, "1", "", "", "");
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("retCode", -1);
      paramString1.put("msg", "onRecorderError");
      if (this.mRuntime.getWebView() != null) {
        this.mRuntime.getWebView().callJs(obw.apr, new String[] { paramString1.toString() });
      }
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.d != null) {
        this.d.write(paramArrayOfByte, 0, paramInt1);
      }
      return;
    }
    catch (IOException paramString) {}
  }
  
  public void aRx()
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_Aqnt != null)
    {
      this.jdField_a_of_type_Aqnt.release();
      this.jdField_a_of_type_Aqnt = null;
      this.mHandler = null;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("localId", lh());
      if (this.mRuntime.getWebView() != null) {
        this.mRuntime.getWebView().callJs(obw.apu, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void as(int paramInt) {}
  
  public void at(String paramString)
  {
    anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onRecorderAbnormal");
      if (this.mRuntime.getWebView() != null) {
        this.mRuntime.getWebView().callJs(obw.apr, new String[] { paramString.toString() });
      }
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  boolean bQ(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) || (paramString.mkdirs());
  }
  
  public void bdo()
  {
    if (isPlaying()) {
      aRx();
    }
    stopRecord();
  }
  
  public void bdp()
  {
    if ((this.jdField_a_of_type_Aqnt != null) && (this.jdField_a_of_type_Aqnt.getState() == 2)) {
      this.jdField_a_of_type_Aqnt.pause();
    }
  }
  
  public void bdq()
  {
    try
    {
      File localFile = new File(GX);
      if (localFile.exists())
      {
        apm = aszr.getFileMD5String(localFile);
        bdZ = (int)localFile.length();
        apo = apm;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void bdr() {}
  
  public int bz()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "startRecord");
      if (this.mRuntime.getWebView() != null) {
        this.mRuntime.getWebView().callJs(obw.apr, new String[] { localJSONObject.toString() });
      }
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 0, "1", "", "", "");
      bdr();
      return 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onInitFailed");
      if (this.mRuntime.getWebView() != null) {
        this.mRuntime.getWebView().callJs(obw.apr, new String[] { paramString.toString() });
      }
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void closeOutputStream()
  {
    try
    {
      if (this.d != null) {
        this.d.close();
      }
      label14:
      this.d = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void d(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.activity.runOnUiThread(new PublicAccountH5AbilityForPtt.2(this));
  }
  
  public String fn(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = apq;
    }
    paramString = str.split("/");
    str = paramString[(paramString.length - 1)];
    paramString = "";
    if (str.length() >= 21) {
      paramString = str.substring(0, str.length() - 4);
    }
    return paramString;
  }
  
  public String fo(String paramString)
  {
    return acbn.SDCARD_PATH + "c2bPTT/" + paramString + ".amr";
  }
  
  public void hB() {}
  
  public boolean isPlaying()
  {
    return (this.jdField_a_of_type_Aqnt != null) && (this.jdField_a_of_type_Aqnt.getState() == 2);
  }
  
  public String lh()
  {
    Object localObject1 = GX.split("/");
    Object localObject2 = localObject1[(localObject1.length - 1)];
    localObject1 = "";
    if (localObject2.length() >= 21) {
      localObject1 = localObject2.substring(0, localObject2.length() - 4);
    }
    return localObject1;
  }
  
  public void pc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Aqnt == null) || (this.mHandler == null) || ((this.jdField_a_of_type_Aqnt != null) && (this.jdField_a_of_type_Aqnt.getState() != 3)))
      {
        this.mHandler = new Handler();
        this.jdField_a_of_type_Aqnt = new aqnt(paramString, this.mHandler);
      }
      this.jdField_a_of_type_Aqnt.cf(this.activity);
      this.jdField_a_of_type_Aqnt.aFk();
      this.jdField_a_of_type_Aqnt.a(this.jdField_a_of_type_Aqnt$a);
      if (this.jdField_a_of_type_Aqnt.getState() == 1)
      {
        this.jdField_a_of_type_Aqnt.start();
        return;
      }
    } while (this.jdField_a_of_type_Aqnt.getState() != 3);
    this.jdField_a_of_type_Aqnt.bvB();
  }
  
  public boolean qh()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.isStop());
  }
  
  public void startRecord()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.activity);
    }
    GX = acbn.SDCARD_PATH + "c2bPTT/" + aoko.vd() + ".amr";
    aqge.m(this.activity, true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.start(GX);
  }
  
  public void stopRecord()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.stop();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = null;
    }
    closeOutputStream();
    aqge.m(this.activity, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obu
 * JD-Core Version:    0.7.0.1
 */