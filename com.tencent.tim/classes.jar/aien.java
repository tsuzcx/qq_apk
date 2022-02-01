import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotGetReq;
import com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotSetReq;
import com.tencent.biz.huiyin.ILiveProto.iLiveRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huiyin.HuiyinUtilsImpl.2;
import com.tencent.mobileqq.intervideo.huiyin.HuiyinUtilsImpl.4;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class aien
{
  List<aien.a> Cy = new ArrayList();
  public long abt;
  public aica b;
  private IVPluginDataReporter b;
  public String bNu = "";
  public String bNv = "";
  String bNw;
  String bNx = "https://huiyin.qq.com/mobile/register/index.html?_wv=16777218";
  String bNy;
  private String bNz = "EchoMainSvc";
  private boolean ckb;
  public boolean ckg = true;
  public boolean ckh = false;
  private boolean cki;
  private boolean ckj;
  public byte[] ey;
  public int redDotNum = -1;
  
  public aien()
  {
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("huiyin");
  }
  
  public static void KY(boolean paramBoolean)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/huiyin";
    if (!new File(str).exists()) {
      new File(str).mkdir();
    }
    str = str + "/load.click";
    if (paramBoolean) {
      try
      {
        new File(str).createNewFile();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    }
    new File(localIOException).delete();
  }
  
  public void a(AppInterface paramAppInterface, aien.b paramb)
  {
    if (!aqmj.cb(paramAppInterface.getApp().getApplicationContext())) {
      return;
    }
    if (this.abt == 0L)
    {
      r(paramAppInterface);
      paramAppInterface = new aier(this, paramAppInterface, paramb);
      this.Cy.add(paramAppInterface);
      return;
    }
    b(paramAppInterface, paramb);
  }
  
  void b(AppInterface paramAppInterface, aien.b paramb)
  {
    if (this.ckg) {
      return;
    }
    ILiveProto.iLiveRequest localiLiveRequest = new ILiveProto.iLiveRequest();
    localiLiveRequest.auth_appid.set(101462571L);
    localiLiveRequest.auth_type.set(1);
    localiLiveRequest.cmd.set(10129);
    localiLiveRequest.subcmd.set(1);
    localiLiveRequest.auth_key.set(ByteStringMicro.copyFromUtf8(this.bNu));
    localiLiveRequest.tinyid.set(this.abt);
    localiLiveRequest.client_type.set(401);
    localiLiveRequest.buss_id.set(160000001L);
    Object localObject = new HuiyinRedDotProto.RedDotGetReq();
    ((HuiyinRedDotProto.RedDotGetReq)localObject).appid.set(63);
    ((HuiyinRedDotProto.RedDotGetReq)localObject).uid.set(this.abt);
    localiLiveRequest.ex.set(ByteStringMicro.copyFrom(((HuiyinRedDotProto.RedDotGetReq)localObject).toByteArray()));
    localObject = new NewIntent(paramAppInterface.getApplication(), jnl.class);
    ((NewIntent)localObject).putExtra("cmd", this.bNz + ".0x2791_0x1");
    ((NewIntent)localObject).putExtra("data", localiLiveRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new aies(this, paramb));
    paramAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void cG(int paramInt, String paramString)
  {
    IVPluginDataReporter localIVPluginDataReporter = this.jdField_b_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("huiyin").opName("step").d1(String.valueOf(paramInt));
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    localIVPluginDataReporter.d2(str).report();
    Log.i("huiyin.step", "step: " + paramInt);
  }
  
  public void f(AppInterface paramAppInterface, String paramString)
  {
    this.bNw = paramString;
    try
    {
      this.bNx = new JSONObject(paramString).getString("register_url");
      paramString = paramAppInterface.getAccount();
      if ((paramString != null) && (!paramString.equals(this.bNy)) && (this.bNy != null))
      {
        this.bNy = paramString;
        this.abt = 0L;
      }
      if (this.abt == 0L)
      {
        this.Cy.add(new aieo(this, paramAppInterface));
        r(paramAppInterface);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      q(paramAppInterface);
    }
  }
  
  public void g(AppInterface paramAppInterface, String paramString)
  {
    if (!aqmj.cb(paramAppInterface.getApp().getApplicationContext())) {}
    while ((this.cki) || (paramString == null)) {
      return;
    }
    this.cki = true;
    Object localObject = paramAppInterface.getAccount();
    if ((localObject != null) && (!((String)localObject).equals(this.bNy)) && (this.bNy != null))
    {
      this.bNy = ((String)localObject);
      this.abt = 0L;
    }
    KY(false);
    localObject = new Intent(paramAppInterface.getApp(), ODLoadingActivity.class);
    ((Intent)localObject).putExtra("is_start_huiyin", true);
    ((Intent)localObject).putExtra("uin", paramAppInterface.getCurrentAccountUin());
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtra("param_general", paramString);
    ((Intent)localObject).putExtra("preloadOnly", true);
    paramString = new JSONObject();
    try
    {
      paramString.put("preloadOnly", true);
      paramString.put("tinyid", String.valueOf(this.abt));
      paramString.put("a2", this.bNu);
      paramString.put("openid", this.jdField_b_of_type_Aica.a().mOpenID);
      paramString.put("accesstoken", this.jdField_b_of_type_Aica.a().mAccessToken);
      paramString.put("usersig", this.bNv);
      paramString.put("startTS", System.currentTimeMillis());
      paramString.put("qqVersion", "7.9.9");
      if (this.ey != null) {
        paramString.put("ex", new String(this.ey, "UTF-8"));
      }
      ((Intent)localObject).putExtra("extra", paramString.toString());
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    new Handler(Looper.getMainLooper()).postDelayed(new HuiyinUtilsImpl.4(this, paramAppInterface, (Intent)localObject), 500L);
  }
  
  void q(AppInterface paramAppInterface)
  {
    Intent localIntent;
    if (this.ckg)
    {
      cG(10, this.bNw);
      g(paramAppInterface, this.bNw);
      localIntent = new Intent(paramAppInterface.getApp().getApplicationContext(), QQBrowserActivity.class);
      localIntent.putExtra("fragmentStyle", 3);
      localIntent.putExtra("url", this.bNx);
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.setFlags(268435456);
      paramAppInterface.getApp().startActivity(localIntent);
    }
    for (;;)
    {
      s(paramAppInterface);
      return;
      JSONObject localJSONObject;
      if (this.bNw != null)
      {
        KY(true);
        localIntent = new Intent(paramAppInterface.getApp(), ODLoadingActivity.class);
        localIntent.putExtra("is_start_huiyin", true);
        localIntent.putExtra("uin", paramAppInterface.getCurrentAccountUin());
        localIntent.setFlags(268435456);
        localIntent.putExtra("param_general", this.bNw);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("tinyid", String.valueOf(this.abt));
        localJSONObject.put("a2", this.bNu);
        localJSONObject.put("openid", this.jdField_b_of_type_Aica.a().mOpenID);
        localJSONObject.put("accesstoken", this.jdField_b_of_type_Aica.a().mAccessToken);
        localJSONObject.put("usersig", this.bNv);
        localJSONObject.put("startTS", System.currentTimeMillis());
        localJSONObject.put("qqVersion", "7.9.9");
        localJSONObject.put("params", this.bNw);
        if (this.ey != null) {
          localJSONObject.put("ex", new String(this.ey, "UTF-8"));
        }
        localIntent.putExtra("extra", localJSONObject.toString());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("huiyin", 2, "tinyid " + this.abt);
      }
      paramAppInterface.getApp().startActivity(localIntent);
    }
  }
  
  public void r(AppInterface paramAppInterface)
  {
    if (!aqmj.cb(paramAppInterface.getApp().getApplicationContext())) {}
    while ((this.abt != 0L) || (this.ckh)) {
      return;
    }
    this.ckh = true;
    new Handler(Looper.getMainLooper()).postDelayed(new HuiyinUtilsImpl.2(this, paramAppInterface), 5000L);
    if (this.jdField_b_of_type_Aica == null) {
      this.jdField_b_of_type_Aica = new aica();
    }
    this.jdField_b_of_type_Aica.a(paramAppInterface, "", paramAppInterface.getApplication(), "101462571", new aiep(this, paramAppInterface));
  }
  
  public void s(AppInterface paramAppInterface)
  {
    if (!aqmj.cb(paramAppInterface.getApp().getApplicationContext())) {
      return;
    }
    ILiveProto.iLiveRequest localiLiveRequest = new ILiveProto.iLiveRequest();
    localiLiveRequest.auth_appid.set(101462571L);
    localiLiveRequest.auth_type.set(1);
    localiLiveRequest.cmd.set(10129);
    localiLiveRequest.subcmd.set(2);
    localiLiveRequest.auth_key.set(ByteStringMicro.copyFromUtf8(this.bNu));
    localiLiveRequest.tinyid.set(this.abt);
    localiLiveRequest.client_type.set(401);
    localiLiveRequest.buss_id.set(160000001L);
    Object localObject = new HuiyinRedDotProto.RedDotSetReq();
    ((HuiyinRedDotProto.RedDotSetReq)localObject).appid.set(63);
    ((HuiyinRedDotProto.RedDotSetReq)localObject).from_uid.set(this.abt);
    ((HuiyinRedDotProto.RedDotSetReq)localObject).to_uid.set(this.abt);
    ((HuiyinRedDotProto.RedDotSetReq)localObject).clear.set(true);
    localiLiveRequest.ex.set(ByteStringMicro.copyFrom(((HuiyinRedDotProto.RedDotSetReq)localObject).toByteArray()));
    localObject = new NewIntent(paramAppInterface.getApplication(), jnl.class);
    ((NewIntent)localObject).putExtra("cmd", this.bNz + ".0x2791_0x2");
    ((NewIntent)localObject).putExtra("data", localiLiveRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new aiet(this));
    paramAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static abstract interface a
  {
    public abstract void dsj();
  }
  
  public static abstract interface b
  {
    public abstract void N(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aien
 * JD-Core Version:    0.7.0.1
 */