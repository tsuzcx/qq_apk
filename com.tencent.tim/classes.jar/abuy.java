import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class abuy
{
  private final ConcurrentHashMap<String, abuy.d> dz;
  private WeakReference<abvd> z;
  
  abuy(abvd paramabvd)
  {
    this.z = new WeakReference(paramabvd);
    this.dz = new ConcurrentHashMap();
    if (!Zj())
    {
      paramabvd = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (paramabvd != null)
      {
        int i = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "new ApolloSSOConfig updateConfigsFromDb=false, checkUpdateApolloWebViewConfig");
        }
        a(this, paramabvd, i, true);
      }
    }
  }
  
  private boolean Zj()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(abuj.rm());
    Object localObject2;
    int i;
    Object localObject4;
    int i1;
    int j;
    label240:
    Object localObject6;
    Object localObject5;
    Object localObject7;
    int i2;
    int k;
    label353:
    Object localObject8;
    String str1;
    String str2;
    if (((File)localObject1).exists())
    {
      try
      {
        localObject2 = abuj.m((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (!QLog.isColorLevel()) {
            break label1031;
          }
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, ApolloClientUtil.readFileSafety null");
          break label1031;
        }
        localObject1 = new JSONObject((String)localObject2).optJSONObject("data").optJSONArray("thunderConfig");
        this.dz.clear();
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, content:" + (String)localObject2);
        }
        if (localObject1 == null) {
          break label920;
        }
        int m = ((JSONArray)localObject1).length();
        i = 0;
        if (i >= m) {
          break label920;
        }
        localObject3 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject3 == null) {
          break label1033;
        }
        n = ((JSONObject)localObject3).optInt("pageId");
        localObject4 = ((JSONObject)localObject3).optString("md5");
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label1033;
        }
        localObject2 = new abuy.d();
        ((abuy.d)localObject2).bJo = n;
        ((abuy.d)localObject2).mMd5 = ((String)localObject4);
        this.dz.put(String.valueOf(n), localObject2);
        localObject4 = ((JSONObject)localObject3).optJSONArray("cmds");
        if (localObject4 == null) {
          break label532;
        }
        i1 = ((JSONArray)localObject4).length();
        j = 0;
        if (j >= i1) {
          break label532;
        }
        localObject6 = ((JSONArray)localObject4).optJSONObject(j);
        if (localObject6 == null) {
          break label1040;
        }
        localObject5 = ((JSONObject)localObject6).optString("name");
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          break label1040;
        }
        localObject7 = ((JSONObject)localObject6).optJSONArray("parameters");
        if (localObject7 == null) {
          break label1040;
        }
        i2 = ((JSONArray)localObject7).length();
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 1, "updateConfigsFromDb, cmdName:" + (String)localObject5 + ",parameterLength:" + i2);
        }
        localObject6 = new ArrayList();
        k = 0;
        if (k < i2)
        {
          localObject8 = ((JSONArray)localObject7).optJSONObject(k);
          if (localObject8 == null) {
            break label1047;
          }
          str1 = ((JSONObject)localObject8).optString("key");
          if (TextUtils.isEmpty(str1)) {
            break label1047;
          }
          str2 = ((JSONObject)localObject8).optString("value");
          int i3 = ((JSONObject)localObject8).optInt("valueType");
          localObject8 = new abuy.c(null);
          ((abuy.c)localObject8).mKey = str1;
          ((abuy.c)localObject8).mType = i3;
          ((abuy.c)localObject8).mValue = str2;
          ((List)localObject6).add(localObject8);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        QLog.e("apollo_client_ApolloSSOConfig", 1, localException.getMessage());
        return false;
      }
      localObject7 = new abuy.b();
      ((abuy.b)localObject7).bhX = ((String)localObject5);
      ((abuy.b)localObject7).mClientId = n;
      ((abuy.b)localObject7).wC.addAll((Collection)localObject6);
      ((abuy.d)localObject2).wD.add(localObject7);
      break label1040;
      label532:
      Object localObject3 = ((JSONObject)localObject3).optJSONArray("cgis");
      if (localObject3 == null) {
        break label1033;
      }
      int n = ((JSONArray)localObject3).length();
      j = 0;
      label556:
      if (j >= n) {
        break label1033;
      }
      localObject5 = ((JSONArray)localObject3).optJSONObject(j);
      if (localObject5 == null) {
        break label1054;
      }
      str1 = ((JSONObject)localObject5).optString("url");
      if (TextUtils.isEmpty(str1)) {
        break label1054;
      }
      str2 = ((JSONObject)localObject5).optString("method");
      if (TextUtils.isEmpty(str2)) {
        break label1054;
      }
      localObject4 = new abuy.a();
      ((abuy.a)localObject4).mUrl = str1;
      ((abuy.a)localObject4).mMethod = str2;
      localObject6 = ((JSONObject)localObject5).optJSONArray("parameters");
      if (localObject6 != null)
      {
        i1 = ((JSONArray)localObject6).length();
        localObject7 = new ArrayList();
        if (!QLog.isColorLevel()) {
          break label1061;
        }
        QLog.d("apollo_client_ApolloSSOConfig", 2, "updateConfigsFromDb cgis url:" + str1 + " method:" + str2 + " parameterLength:" + i1);
        break label1061;
      }
    }
    for (;;)
    {
      if (k < i1)
      {
        localObject8 = ((JSONArray)localObject6).optJSONObject(k);
        if (localObject8 != null)
        {
          str1 = ((JSONObject)localObject8).optString("key");
          if (!TextUtils.isEmpty(str1))
          {
            str2 = ((JSONObject)localObject8).optString("value");
            i2 = ((JSONObject)localObject8).optInt("valueType");
            localObject8 = new abuy.c(null);
            ((abuy.c)localObject8).mKey = str1;
            ((abuy.c)localObject8).mType = i2;
            ((abuy.c)localObject8).mValue = str2;
            ((List)localObject7).add(localObject8);
          }
        }
      }
      else
      {
        ((abuy.a)localObject4).wC.addAll((Collection)localObject7);
        localObject5 = ((JSONObject)localObject5).optJSONObject("headers");
        if (localObject5 != null)
        {
          localObject6 = ((JSONObject)localObject5).keys();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (String)((Iterator)localObject6).next();
            ((abuy.a)localObject4).mHeaders.put(localObject7, ((JSONObject)localObject5).optString((String)localObject7));
          }
        }
        ((abuy.d)localObject2).wE.add(localObject4);
        break label1054;
        label920:
        if (QLog.isColorLevel())
        {
          i = BaseApplicationImpl.getContext().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mCurrentConfigVersion:").append(i).append("mThunderConfigs:").append(this.dz);
          QLog.d("apollo_client_ApolloSSOConfig", 2, localStringBuilder.toString());
        }
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "updateConfigsFromDb use:" + (System.currentTimeMillis() - l));
        }
        return false;
        label1031:
        return false;
        label1033:
        i += 1;
        break;
        label1040:
        j += 1;
        break label240;
        label1047:
        k += 1;
        break label353;
        label1054:
        j += 1;
        break label556;
        label1061:
        k = 0;
        continue;
      }
      k += 1;
    }
  }
  
  public static void a(abuy paramabuy, AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramAppInterface == null) {}
    do
    {
      do
      {
        return;
        SharedPreferences localSharedPreferences = paramAppInterface.getApplication().getSharedPreferences("sp_apollo_webView", 4);
        int i = localSharedPreferences.getInt("sp_key_apollo_webView_config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloSSOConfig", 2, "apollo_client checkUpdateApolloWebViewConfig, oldVersion" + i + ",version:" + paramInt);
        }
        Object localObject = new File(abuj.rm());
        boolean bool1 = paramBoolean;
        if (paramInt > 0)
        {
          bool1 = paramBoolean;
          if (!((File)localObject).exists()) {
            bool1 = true;
          }
        }
        localSharedPreferences.edit().putLong("sp_key_sso_check_time", System.currentTimeMillis()).commit();
        if ((!bool1) && (paramInt <= i)) {
          break;
        }
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        ((File)localObject).getParentFile().mkdirs();
        localObject = new aquz("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_thunder_config/xydata.json", (File)localObject);
        ((aquz)localObject).cWy = true;
        ((aquz)localObject).cWw = true;
        ((aquz)localObject).cxX = "apollo_res";
        ((aquz)localObject).retryCount = 1;
        ((aquz)localObject).cWz = true;
        ((aquz)localObject).cWA = true;
        ((aquz)localObject).c(new abva(localSharedPreferences, paramInt, paramabuy));
        paramabuy = (aqva)paramAppInterface.getManager(47);
        paramBoolean = bool2;
        if (paramabuy != null)
        {
          paramabuy = paramabuy.a(3);
          paramBoolean = bool2;
          if (paramabuy != null)
          {
            paramabuy.a((aquz)localObject, ((aquz)localObject).a(), null);
            paramBoolean = false;
          }
        }
        if (paramBoolean) {
          ThreadManager.executeOnNetWorkThread(new ApolloSSOConfig.3((aquz)localObject));
        }
      } while (!QLog.isColorLevel());
      QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig async:" + paramBoolean);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloSSOConfig", 2, "checkUpdateApolloWebViewConfig local config is new， not need to download");
  }
  
  public static String aG(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public JSONObject a(String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramAppInterface == null)) {
      return null;
    }
    paramString2 = (abuy.d)this.dz.get(paramString2);
    if (paramString2 != null)
    {
      paramString2 = paramString2.wD.iterator();
      while (paramString2.hasNext())
      {
        abuy.b localb = (abuy.b)paramString2.next();
        if ((localb != null) && (paramString3.equals(localb.bhX))) {
          return localb.a(paramString1, paramAppInterface);
        }
      }
    }
    return null;
  }
  
  void a(AppInterface paramAppInterface, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramAppInterface == null) || (paramBundle == null)) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        Object localObject;
        try
        {
          localObject = new ClubContentUpdateInfoPb.RspBody();
          ((ClubContentUpdateInfoPb.RspBody)localObject).mergeFrom(paramBundle.getByteArray("extra_data"));
          if (((ClubContentUpdateInfoPb.RspBody)localObject).int_result.get() != 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("apollo_client_ApolloSSOConfig", 2, "handleReceiveSSO, result=" + ((ClubContentUpdateInfoPb.RspBody)localObject).int_result.get());
            return;
          }
        }
        catch (Exception paramAppInterface)
        {
          paramAppInterface.printStackTrace();
          return;
        }
        paramBundle = ((ArrayList)((ClubContentUpdateInfoPb.RspBody)localObject).rpt_msg_rspappinfo.get()).iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ClubContentUpdateInfoPb.RspAppInfo)paramBundle.next();
          if (localObject != null) {
            switch (((ClubContentUpdateInfoPb.RspAppInfo)localObject).uint_appid.get())
            {
            case 205: 
              if ((((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.has()) && (((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.size() > 0))
              {
                localObject = (ClubContentUpdateInfoPb.RspItemInfo)((ClubContentUpdateInfoPb.RspAppInfo)localObject).rpt_msg_rspiteminfo.get().get(0);
                String str1 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
                int i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
                String str2 = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
                int j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
                if (1 == (j & 0x1)) {}
                for (paramBoolean = true;; paramBoolean = false)
                {
                  a(this, paramAppInterface, i, paramBoolean);
                  QLog.i("apollo_client_ApolloSSOConfig", 1, "handleApolloWebViewResponse apollo_client ApolloWebView Config json: " + str1 + ", ver: " + i + ", updateFlag: " + j + ", extStr: " + str2);
                  break;
                }
              }
              break;
            }
          }
        }
      }
    }
  }
  
  public List<abuy.a> aj(String paramString)
  {
    paramString = (abuy.d)this.dz.get(paramString);
    if (paramString != null) {
      return paramString.wE;
    }
    return null;
  }
  
  public boolean ap(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (abuy.d)this.dz.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.wD.iterator();
        while (paramString1.hasNext())
        {
          abuy.b localb = (abuy.b)paramString1.next();
          if ((localb != null) && (paramString2.equals(localb.bhX))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public Set<String> c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (abuy.d)this.dz.get(paramString);
      if (localObject != null)
      {
        paramString = new HashSet();
        localObject = ((abuy.d)localObject).wD.iterator();
        while (((Iterator)localObject).hasNext())
        {
          abuy.b localb = (abuy.b)((Iterator)localObject).next();
          if ((localb != null) && (!TextUtils.isEmpty(localb.bhX))) {
            paramString.add(localb.bhX);
          }
        }
        return paramString;
      }
    }
    return null;
  }
  
  void h(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    long l;
    do
    {
      return;
      localObject1 = paramAppInterface.getApplication().getSharedPreferences("sp_apollo_webView", 4);
      l = ((SharedPreferences)localObject1).getLong("sp_key_sso_check_time", 0L);
    } while (System.currentTimeMillis() - l <= 1800000L);
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject2 = paramAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.e("apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO account is null!");
      return;
    }
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("3.4.4.3058");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject2));
    int i = ((SharedPreferences)localObject1).getInt("sp_key_apollo_webView_config_version", 0);
    localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
    ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("apollo_thunder_json_v670");
    Object localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(205);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.add((MessageMicro)localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    localReqBody.rpt_msg_reqappinfo.set((List)localObject2);
    localObject1 = new NewIntent(paramAppInterface.getApp(), ailu.class);
    ((NewIntent)localObject1).putExtra("extra_cmd", "ClubContentUpdate.Req");
    ((NewIntent)localObject1).putExtra("extra_data", localReqBody.toByteArray());
    ((NewIntent)localObject1).putExtra("extra_callbackid", paramAppInterface.getCurrentAccountUin());
    ((NewIntent)localObject1).setObserver(new abuz(this, paramAppInterface));
    paramAppInterface.startServlet((NewIntent)localObject1);
    QLog.i("apollo_client_ApolloSSOConfig", 1, "checkRequestSendSSO local ver: " + i);
  }
  
  public String iP(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (abuy.d)this.dz.get(paramString);
      if (paramString != null) {
        return paramString.mMd5;
      }
    }
    return "";
  }
  
  public boolean jD(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.dz.containsKey(paramString);
    }
    return false;
  }
  
  public static class a
  {
    public final HashMap<String, String> mHeaders = new HashMap();
    public String mMethod;
    public String mUrl;
    public final List<abuy.c> wC = new ArrayList();
    
    public boolean jQ()
    {
      return (!TextUtils.isEmpty(this.mUrl)) && (!TextUtils.isEmpty(this.mMethod));
    }
    
    public String p(boolean paramBoolean)
    {
      if (!jQ()) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        int j;
        int i;
        try
        {
          j = this.wC.size();
          i = 0;
          if (i < j)
          {
            abuy.c localc = (abuy.c)this.wC.get(i);
            if ((localc == null) || (TextUtils.isEmpty(localc.mKey))) {
              break label397;
            }
            if ((localc.mType != 6) && (localc.mType != 7)) {
              break label236;
            }
            if (TextUtils.isEmpty(Uri.parse(this.mUrl).getQueryParameter(localc.mValue))) {
              break label397;
            }
            if (paramBoolean)
            {
              localStringBuilder.append(aurr.encodeUrl(localc.mKey)).append("=").append(aurr.encodeUrl(localc.mValue));
              if (i == j - 1) {
                break label397;
              }
              localStringBuilder.append("&");
              break label397;
            }
            localStringBuilder.append(localc.mKey).append("=").append(localc.mValue);
            continue;
          }
          if (localException.mType != 8) {
            break label318;
          }
        }
        catch (Exception localException)
        {
          QLog.e("apollo_client_ApolloSSOConfig", 1, localException, new Object[0]);
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloSSOConfig", 2, new Object[] { "getParameterStr parameterBuilder:", localStringBuilder.toString() });
          }
          return localStringBuilder.toString();
        }
        label236:
        if (paramBoolean) {
          localStringBuilder.append(aurr.encodeUrl(localException.mKey)).append("=").append(System.currentTimeMillis());
        }
        while (i != j - 1)
        {
          localStringBuilder.append("&");
          break;
          localStringBuilder.append(localException.mKey).append("=").append(System.currentTimeMillis());
          continue;
          label318:
          if (paramBoolean) {
            localStringBuilder.append(aurr.encodeUrl(localException.mKey)).append("=").append(aurr.encodeUrl(localException.mValue));
          }
          while (i != j - 1)
          {
            localStringBuilder.append("&");
            break;
            localStringBuilder.append(localException.mKey).append("=").append(localException.mValue);
          }
        }
        label397:
        i += 1;
      }
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("CGIConfig{");
      localStringBuffer.append("mUrl='").append(this.mUrl).append('\'');
      localStringBuffer.append(", mMethod='").append(this.mMethod).append('\'');
      localStringBuffer.append(", mHeaders=").append(this.mHeaders);
      localStringBuffer.append(", mParameters=").append(this.wC);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
  
  static class b
  {
    public String bhX;
    public int mClientId;
    public final List<abuy.c> wC = new ArrayList();
    
    public JSONObject a(String paramString, AppInterface paramAppInterface)
    {
      if ((this.wC == null) || (paramAppInterface == null)) {
        return null;
      }
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = this.wC.iterator();
      while (localIterator.hasNext()) {
        ((abuy.c)localIterator.next()).a(paramString, localJSONObject, paramAppInterface);
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mClientId:").append(this.mClientId).append(" mCmdSSOName:").append(this.bhX).append(" mParameters:").append(this.wC);
      return localStringBuilder.toString();
    }
  }
  
  static class c
  {
    public String mKey;
    public int mType = 0;
    public String mValue;
    
    public void a(String paramString, JSONObject paramJSONObject, AppInterface paramAppInterface)
    {
      if (paramJSONObject != null)
      {
        try
        {
          if (TextUtils.isEmpty(this.mKey)) {
            return;
          }
          if (this.mType == 0)
          {
            paramJSONObject.put(this.mKey, this.mValue);
            return;
          }
          if (this.mType == 1)
          {
            paramJSONObject.put(this.mKey, Integer.parseInt(this.mValue));
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("apollo_client_ApolloSSOConfig", 1, paramString, new Object[0]);
          return;
        }
        if (this.mType == 2)
        {
          paramJSONObject.put(this.mKey, Long.parseLong(this.mValue));
          return;
        }
        if (this.mType == 3)
        {
          paramJSONObject.put(this.mKey, Float.parseFloat(this.mValue));
          return;
        }
        if (this.mType == 4)
        {
          paramJSONObject.put(this.mKey, Long.parseLong(paramAppInterface.getCurrentAccountUin()));
          return;
        }
        if (this.mType == 5)
        {
          paramJSONObject.put(this.mKey, paramAppInterface.getCurrentAccountUin());
          return;
        }
        if (this.mType == 8)
        {
          paramJSONObject.put(this.mKey, System.currentTimeMillis());
          return;
        }
        if (this.mType == 6)
        {
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = Uri.parse(paramString).getQueryParameter(this.mValue);
            if (!TextUtils.isEmpty(paramString)) {
              paramJSONObject.put(this.mKey, Long.parseLong(paramString));
            }
          }
        }
        else if ((this.mType == 7) && (!TextUtils.isEmpty(paramString)))
        {
          paramString = Uri.parse(paramString).getQueryParameter(this.mValue);
          if (!TextUtils.isEmpty(paramString)) {
            paramJSONObject.put(this.mKey, paramString);
          }
        }
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mKey:").append(this.mKey).append(" mValue:").append(this.mValue).append(" mType:").append(this.mType);
      return localStringBuilder.toString();
    }
  }
  
  static class d
  {
    public int bJo;
    public String mMd5;
    public List<abuy.b> wD = new ArrayList();
    public List<abuy.a> wE = new ArrayList();
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("ThunderConfig{");
      localStringBuffer.append("mPageId=").append(this.bJo);
      localStringBuffer.append(", mMd5='").append(this.mMd5).append('\'');
      localStringBuffer.append(", mCmdConfigs=").append(this.wD);
      localStringBuffer.append(", mCGIConfigs=").append(this.wE);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuy
 * JD-Core Version:    0.7.0.1
 */