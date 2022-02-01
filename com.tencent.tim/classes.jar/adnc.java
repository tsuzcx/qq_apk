import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.10;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.5;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.8;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.9;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class adnc
  extends adnq.b
{
  private adnc.a jdField_a_of_type_Adnc$a;
  private adnc.b jdField_a_of_type_Adnc$b;
  private adnc.c jdField_a_of_type_Adnc$c;
  private awoe jdField_a_of_type_Awoe;
  private boolean bPV;
  private boolean bPW;
  private INetInfoHandler e;
  private ArrayList<Long> uC;
  
  adnc(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    awok.a().eEG();
    this.uC = new ArrayList();
    this.jdField_a_of_type_Awoe = new adnl(this);
    awok.a().a(this.jdField_a_of_type_Awoe);
    this.e = new adnm(this);
    paramApplication = BaseActivity.sTopActivity;
    if (paramApplication != null) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramApplication, this.e);
    }
  }
  
  private int a(Context paramContext, double paramDouble, WadlParams paramWadlParams)
  {
    SharedPreferences localSharedPreferences;
    String str1;
    if (paramContext != null)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
      str1 = "key_download_show_not_wifi_dialog" + paramWadlParams.appId;
      if (localSharedPreferences == null) {
        break label178;
      }
    }
    label178:
    for (boolean bool = localSharedPreferences.getBoolean(str1, true);; bool = true)
    {
      if (paramDouble > awol.getAvailableBytes())
      {
        ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.9(this, paramContext, paramWadlParams));
        return 2;
      }
      if ((bool) && (aqiw.isNetworkAvailable(paramContext)) && (aqiw.getNetworkType(paramContext) != 1))
      {
        String str2 = String.format(paramContext.getString(2131690508), new Object[] { aqhp.bO(paramDouble) });
        String str3 = paramContext.getString(2131690507);
        ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.10(this, paramContext, str2, paramWadlParams, localSharedPreferences, str1, str3));
        return 2;
      }
      awok.a().h(paramWadlParams);
      this.bPW = true;
      return 1;
    }
  }
  
  private JSONArray a(ArrayList<WadlResult> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (WadlResult)paramArrayList.next();
      if (localObject != null)
      {
        localObject = a((WadlResult)localObject, paramString);
        if (localObject != null) {
          localJSONArray.put(localObject);
        }
      }
    }
    return localJSONArray;
  }
  
  private JSONObject a(WadlParams paramWadlParams, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramWadlParams != null)
      {
        localJSONObject.put("actionCode", paramWadlParams.ekZ);
        localJSONObject.put("appId", paramWadlParams.appId);
        localJSONObject.put("apkUrl", paramWadlParams.apkUrl);
        localJSONObject.put("apkSign", paramWadlParams.bLD);
        localJSONObject.put("versionCode", paramWadlParams.versionCode);
        localJSONObject.put("packageName", paramWadlParams.packageName);
        localJSONObject.put("appName", paramWadlParams.appName);
        if (!paramWadlParams.dra) {
          break label252;
        }
      }
      label252:
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("delayDownload", i);
        localJSONObject.put("fromWebUrl", paramWadlParams.bLE);
        localJSONObject.put("apkChannel", paramWadlParams.apkChannel);
        localJSONObject.put("via", paramWadlParams.via);
        localJSONObject.put("yyStartTime", paramWadlParams.aBo);
        localJSONObject.put("yyEndTime", paramWadlParams.aBp);
        localJSONObject.put("adtag", paramWadlParams.bLF);
        localJSONObject.put("from", paramWadlParams.from);
        localJSONObject.put("flags", paramWadlParams.flags);
        localJSONObject.put("extraData", paramWadlParams.extraData);
        localJSONObject.put("sourceId", paramWadlParams.sourceId);
        return localJSONObject;
      }
      return null;
    }
    catch (Exception paramWadlParams)
    {
      QLog.i("ark.download.module", 1, paramString + " parseWadlParams error::", paramWadlParams);
    }
  }
  
  private JSONObject a(WadlResult paramWadlResult, String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      if (paramWadlResult == null)
      {
        localJSONObject1.put("taskStatus", -1);
        localJSONObject1.put("progress", 0);
        return localJSONObject1;
      }
      if (paramWadlResult.a != null)
      {
        JSONObject localJSONObject2 = a(paramWadlResult.a, paramString);
        if (localJSONObject2 != null) {
          localJSONObject1.put("wadlParams", localJSONObject2.toString());
        }
      }
      localJSONObject1.put("event", paramWadlResult.aqA);
      localJSONObject1.put("taskId", paramWadlResult.taskId);
      localJSONObject1.put("taskStatus", paramWadlResult.bBa);
      localJSONObject1.put("fileSize", paramWadlResult.fileSize);
      localJSONObject1.put("downloadFileSize", paramWadlResult.DZ);
      localJSONObject1.put("downloadFilePath", paramWadlResult.aJb);
      localJSONObject1.put("createTime", paramWadlResult.createTime);
      localJSONObject1.put("errCode", ascc.kS(paramWadlResult.errCode));
      localJSONObject1.put("progress", paramWadlResult.progress);
      return localJSONObject1;
    }
    catch (Exception paramWadlResult)
    {
      QLog.i("ark.download.module", 1, paramString + " parseWadlResult error::", paramWadlResult);
    }
    return null;
  }
  
  private String dJ(int paramInt)
  {
    String str = "";
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {}
    switch (paramInt)
    {
    case 2: 
    default: 
      str = localBaseActivity.getString(2131690505);
      return str;
    case 1: 
      return localBaseActivity.getString(2131690503);
    }
    return localBaseActivity.getString(2131690504);
  }
  
  private boolean kZ(String paramString)
  {
    try
    {
      ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.8(this, paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.i("ark.download.module", 1, " showToast error::", paramString);
    }
    return false;
  }
  
  public void Destruct()
  {
    super.Destruct();
    awok.a().b(this.jdField_a_of_type_Awoe);
    this.jdField_a_of_type_Awoe = null;
    this.jdField_a_of_type_Adnc$b = null;
    this.jdField_a_of_type_Adnc$c = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.e);
    this.e = null;
    if ((this.uC != null) && (this.uC.size() > 0))
    {
      int i = 0;
      while (i < this.uC.size())
      {
        a(((Long)this.uC.get(i)).longValue());
        i += 1;
      }
      this.uC.clear();
    }
  }
  
  public String GetTypeName()
  {
    return "QQDownload";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("QueryPackageState")) {}
    while ((paramString.equals("QueryPackageStateVia")) || (paramString.equals("StartDownload")) || (paramString.equals("PauseDownload")) || (paramString.equals("ContinueDownload")) || (paramString.equals("InstallPackage")) || (paramString.equals("DownloadInit"))) {
      return true;
    }
    return paramString.equals("DeletePackage");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!adnq.a(this.mAppName, this.Vj, this.mApplication, "permission.DOWNLOAD"))
    {
      QLog.i("ark.download.module", 1, "ark.dctrl.ArkAppDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        kZ(paramString.getString(2131690510));
      }
      return false;
    }
    QLog.i("ark.download.module", 1, String.format("ark.dctrl.ArkAppDownloadModule.invokeFunc.%s", new Object[] { paramString }));
    long l;
    if (paramString.equals("QueryPackageState"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        l = a(paramArrayOfVariantWrapper[1].Copy());
        paramArrayOfVariantWrapper = new ArrayList();
        paramArrayOfVariantWrapper.add(paramString);
        QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageState.appid:%s", new Object[] { Long.valueOf(l) }));
        this.jdField_a_of_type_Adnc$b = new adnd(this, l);
        if (paramArrayOfVariantWrapper.size() > 0) {
          awok.a().fz(paramArrayOfVariantWrapper);
        }
        return true;
      }
      return false;
    }
    if (paramString.equals("QueryPackageStateVia"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageStateVia.via:%s", new Object[] { paramString }));
        this.jdField_a_of_type_Adnc$c = new adng(this, a(paramArrayOfVariantWrapper[1].Copy()));
        if (!TextUtils.isEmpty(paramString)) {
          awok.a().XE(paramString);
        }
        return true;
      }
      return false;
    }
    if (paramString.equals("DownloadInit"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        l = a(paramArrayOfVariantWrapper[0].Copy());
        QLog.i("ark.download.module", 1, "ark.dctrl.DownloadInit callbackid=" + l);
        this.jdField_a_of_type_Adnc$a = new adnh(this);
        this.uC.add(Long.valueOf(l));
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    Object localObject;
    boolean bool1;
    int i;
    if (paramString.equals("StartDownload"))
    {
      if (this.jdField_a_of_type_Adnc$a == null)
      {
        QLog.e("ark.download.module", 1, "should DownloadInit first ");
        paramVariantWrapper.SetInt(-1);
        return true;
      }
      paramString = BaseActivity.sTopActivity;
      double d;
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        localObject = paramArrayOfVariantWrapper[0].GetString();
        d = paramArrayOfVariantWrapper[1].GetDouble();
        paramArrayOfVariantWrapper = new WadlParams((String)localObject);
        if (paramArrayOfVariantWrapper.ekZ == 12)
        {
          anot.c(null, "dc00898", "", "", "0X8009E12", "0X8009E12", 0, 0, "", "", paramArrayOfVariantWrapper.appId, "");
          boolean bool2 = true;
          localObject = aeiy.b(380).a();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((aeix.e)localObject).a() != null)
            {
              localObject = ((aeix.e)localObject).a();
              bool1 = bool2;
              if (((aeje.h)localObject).vD != null)
              {
                bool1 = bool2;
                if (((aeje.h)localObject).vD.contains(this.mAppName)) {
                  bool1 = false;
                }
              }
            }
          }
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl [StartDownload] mAppName:", this.mAppName, ",showDownloadCtrlDialog=", Boolean.valueOf(bool1), ",appid=", paramArrayOfVariantWrapper.appId, ",name=", paramArrayOfVariantWrapper.appName, ",iconUrl:", paramArrayOfVariantWrapper.iconUrl });
          if (!bool1) {
            break label772;
          }
          adso.a().a(this.mAppName, paramArrayOfVariantWrapper.appId, paramArrayOfVariantWrapper.appName, paramArrayOfVariantWrapper.iconUrl, new adni(this, paramArrayOfVariantWrapper, paramString, d));
          i = 2;
        }
      }
      for (;;)
      {
        paramVariantWrapper.SetInt(i);
        return true;
        if (paramArrayOfVariantWrapper.ekZ != 2) {
          break;
        }
        anot.c(null, "dc00898", "", "", "0X8009E11", "0X8009E11", 0, 0, "", "", paramArrayOfVariantWrapper.appId, "");
        break;
        label772:
        i = a(paramString, d, paramArrayOfVariantWrapper);
        continue;
        i = -2;
      }
    }
    if (paramString.equals("PauseDownload"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.pause download appid:", paramString, ",from:", Integer.valueOf(i) });
        awok.a().eE(i, paramString);
        paramVariantWrapper.SetBool(true);
        anot.c(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "1", "", paramString, "");
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("ContinueDownload"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.continue download appid:", paramString, ",from:", Integer.valueOf(i) });
        paramArrayOfVariantWrapper = BaseActivity.sTopActivity;
        bool1 = true;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
        String str1 = "key_download_show_not_wifi_dialog" + paramString;
        if (localObject != null) {
          bool1 = ((SharedPreferences)localObject).getBoolean(str1, true);
        }
        if ((bool1) && (paramArrayOfVariantWrapper != null) && (aqiw.isNetworkAvailable(paramArrayOfVariantWrapper)) && (aqiw.getNetworkType(paramArrayOfVariantWrapper) != 1))
        {
          String str2 = paramArrayOfVariantWrapper.getString(2131690500);
          String str3 = paramArrayOfVariantWrapper.getString(2131690507);
          ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.5(this, paramArrayOfVariantWrapper, str2, i, paramString, (SharedPreferences)localObject, str1, str3));
          paramVariantWrapper.SetBool(true);
          return true;
        }
        awok.a().eF(i, paramString);
        this.bPW = true;
        anot.c(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "2", "", paramString, "");
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("InstallPackage"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.install package:", paramString });
        paramString = new WadlParams(paramString);
        awok.a().c(paramString);
        anot.c(null, "dc00898", "", "", "0X8009E16", "0X8009E16", 0, 0, "", "", paramString.appId, "");
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("DeletePackage"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.delete package appId:", paramString, ",from:", Integer.valueOf(i) });
        awok.a().cC(i, paramString);
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    return false;
  }
  
  static abstract interface a
  {
    public abstract void j(WadlResult paramWadlResult);
  }
  
  static abstract interface b
  {
    public abstract void dT(ArrayList<WadlResult> paramArrayList);
  }
  
  static abstract interface c
  {
    public abstract void dU(ArrayList<WadlResult> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnc
 * JD-Core Version:    0.7.0.1
 */