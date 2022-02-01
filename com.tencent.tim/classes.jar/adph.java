import android.os.Build;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class adph
{
  public static boolean bPZ = true;
  public static boolean bQa;
  public static boolean bQb;
  public static boolean bQc = true;
  public static boolean bQd;
  public static boolean bQe;
  public static boolean bQf;
  public static boolean bQg;
  public static String buT;
  public static Map<String, List<adph.a>> jJ = new HashMap();
  public static volatile boolean sARMv7Compatible;
  public static volatile boolean sIsX86Emulator;
  private static List<String> yo = new ArrayList();
  private adpo jdField_a_of_type_Adpo;
  private adpq jdField_a_of_type_Adpq;
  private ArkAppCenter jdField_a_of_type_ComTencentMobileqqArkArkAppCenter;
  
  static
  {
    if (Build.MODEL.contains("Android SDK built for x86")) {
      sIsX86Emulator = true;
    }
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if ((!sIsX86Emulator) && ((checkCPUABIStringV7(str1).booleanValue()) || (checkCPUABIStringV7(str2).booleanValue()))) {
      sARMv7Compatible = true;
    }
  }
  
  public adph(ArkAppCenter paramArkAppCenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter = paramArkAppCenter;
    Object localObject = aeiy.b(159).a();
    if ((localObject != null) && (((aeix.d)localObject).a() != null))
    {
      localObject = ((aeix.d)localObject).a();
      bPZ = ((aeje.g)localObject).bUj;
      bQc = ((aeje.g)localObject).bUk;
    }
    this.jdField_a_of_type_Adpo = new adpo(paramArkAppCenter.a());
    this.jdField_a_of_type_Adpq = new adpq(paramArkAppCenter.a());
    cTy();
    cTz();
    paramArkAppCenter = aeiy.b(186).a();
    if ((paramArkAppCenter != null) && (paramArkAppCenter.a() != null))
    {
      ArkAppCenter.r("ArkApp.AI", "ArkAiAppCenter updateDialogConfig content =" + paramArkAppCenter.getContent());
      a(paramArkAppCenter.a());
    }
  }
  
  public static void GD(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "open";; str = "close")
    {
      aqfe.J(BaseApplication.getContext(), "ark_use_android_http_" + getCurrentUin(), str);
      return;
    }
  }
  
  public static void GE(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "open";; str = "close") {
      try
      {
        aqfe.J(BaseApplication.getContext(), "ark_support_android9_emoji", str);
        return;
      }
      catch (Exception localException)
      {
        ArkAppCenter.r("ArkApp.AI", "setAndroid9EmojiSupportState exception: " + localException.getMessage());
      }
    }
  }
  
  public static boolean afo()
  {
    try
    {
      boolean bool = "open".equals(aqfe.get(BaseApplication.getContext(), "ark_use_android_http_" + getCurrentUin()));
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean afp()
  {
    try
    {
      boolean bool = "open".equals(aqfe.get(BaseApplication.getContext(), "ark_support_android9_emoji"));
      return bool;
    }
    catch (Exception localException)
    {
      ArkAppCenter.r("ArkApp.AI", "getAndroid9EmojiSupportState exception: " + localException.getMessage());
    }
    return false;
  }
  
  private void cTy()
  {
    adpo.n(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter.a());
  }
  
  private static Boolean checkCPUABIStringV7(String paramString)
  {
    if ((paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a"))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static void fs(String paramString1, String paramString2)
  {
    aqfe.J(BaseApplication.getContext(), paramString1 + getCurrentUin(), paramString2);
  }
  
  public static String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    return localAppRuntime.getAccount();
  }
  
  public static String jT(String paramString)
  {
    return aqfe.get(BaseApplication.getContext(), paramString + getCurrentUin());
  }
  
  public static boolean lb(String paramString)
  {
    return yo.contains(paramString);
  }
  
  public void a(aeje.l paraml)
  {
    if (paraml == null)
    {
      ArkAppCenter.r("ArkApp.AI", String.format("updateDialogConfig,dialogConfig is null", new Object[0]));
      return;
    }
    bQb = paraml.bUo;
    bQa = this.jdField_a_of_type_Adpq.lc(paraml.bxV);
    bQd = paraml.bUp;
    GD(bQd);
    if (ArkAppCenter.bQm) {
      ark.SetUseAndroidHTTP(bQd);
    }
    bQe = paraml.bUq;
    GE(bQe);
    if (ArkAppCenter.bQm) {
      ark.arkSetAndroid9EmojiFeatureSupport(bQe);
    }
    bQf = paraml.bUr;
    Object localObject;
    if (bQf) {
      localObject = "true";
    }
    for (;;)
    {
      fs("ark_engine_multi_thread", (String)localObject);
      buT = paraml.bxU;
      boolean bool;
      if (ArkAppCenter.bQm)
      {
        localObject = ArkEnvironmentManager.getInstance();
        if (bQf) {
          break label184;
        }
        bool = true;
        ((ArkEnvironmentManager)localObject).setSingleThreadMode(bool);
        ArkEnvironmentManager.getInstance().setThreadMode();
      }
      try
      {
        localObject = new JSONObject(buT);
        ArkEnvironmentManager.getInstance().setHardwareDisableList((JSONObject)localObject);
        bQg = paraml.bUs;
        return;
        localObject = "false";
        continue;
        label184:
        bool = false;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ArkAppCenter.r("ArkApp.AI", String.format("updateDialogConfig, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
        }
      }
    }
  }
  
  public void cTA()
  {
    adpo localadpo = this.jdField_a_of_type_Adpo;
    adpo.o(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter.getAppInterface());
  }
  
  public void cTB()
  {
    this.jdField_a_of_type_Adpo.cTB();
  }
  
  public void cTz()
  {
    this.jdField_a_of_type_Adpq.cTz();
  }
  
  public class a
  {
    public long Vl;
    public String buU;
    public long mPeriod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adph
 * JD-Core Version:    0.7.0.1
 */