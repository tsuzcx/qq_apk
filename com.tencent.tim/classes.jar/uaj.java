import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.open.agent.CardContainer.a;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class uaj
{
  public static final String TAG = "DoraemonOpenAPI." + uaj.class.getSimpleName();
  final tzg jdField_b_of_type_Tzg;
  final uag jdField_b_of_type_Uag;
  protected tzd d;
  protected List<CardContainer.a> qf;
  int status = 0;
  
  public uaj(tzg paramtzg, uag paramuag)
  {
    this.jdField_b_of_type_Tzg = paramtzg;
    this.jdField_b_of_type_Uag = paramuag;
    this.qf = new ArrayList();
  }
  
  private String a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("app_id", this.jdField_b_of_type_Tzg.mAppid);
    localLinkedHashMap.put("uin", paramAppRuntime.getAccount());
    localLinkedHashMap.put("sdkp", "a");
    localLinkedHashMap.put("response_type", "token");
    ajcn localajcn = this.jdField_b_of_type_Tzg.a();
    if (localajcn == null)
    {
      paramAppRuntime = "";
      localLinkedHashMap.put("app_name", paramAppRuntime);
      localLinkedHashMap.put("kSSOLoginTypeKey", "1");
      localLinkedHashMap.put("scope", "get_user_info,get_simple_userinfo,add_share,get_info,server_side");
      if (localajcn != null) {
        break label265;
      }
    }
    label265:
    for (paramAppRuntime = "";; paramAppRuntime = localajcn.pkgName)
    {
      localLinkedHashMap.put("bundleid", paramAppRuntime);
      localLinkedHashMap.put("skey", paramString1);
      localLinkedHashMap.put("state", paramString3);
      localLinkedHashMap.put("redirect_uri", paramString2);
      paramString2 = localLinkedHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (Map.Entry)paramString2.next();
        paramString1 = (String)paramString3.getValue();
        paramAppRuntime = paramString1;
        if (paramString1 == null) {
          paramAppRuntime = "";
        }
        localStringBuilder.append((String)paramString3.getKey() + "=" + URLEncoder.encode(paramAppRuntime) + "&");
      }
      paramAppRuntime = localajcn.appName;
      break;
    }
    int i = localStringBuilder.length();
    if (i > 0) {
      localStringBuilder.delete(i - 1, i);
    }
    return localStringBuilder.toString();
  }
  
  private boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.qf.clear();
    paramGetAuthApiListResponse = paramGetAuthApiListResponse.authorized_form_list.get().iterator();
    while (paramGetAuthApiListResponse.hasNext())
    {
      appType.AuthItem localAuthItem = (appType.AuthItem)paramGetAuthApiListResponse.next();
      if (localAuthItem.is_new.get() != 0)
      {
        CardContainer.a locala = new CardContainer.a();
        locala.api = localAuthItem.api_list.get();
        locala.flag = localAuthItem.default_flag.get();
        locala.id = localAuthItem.id.get();
        if (localAuthItem.is_new.get() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          locala.isNew = bool;
          locala.title = localAuthItem.title.get();
          this.qf.add(locala);
          break;
        }
      }
    }
    return this.qf.isEmpty();
  }
  
  private void bFf()
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "doAuthorize");
    }
    long l = Long.parseLong(this.jdField_b_of_type_Tzg.mAppid);
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(l);
    localAuthorizeRequest.need_pay.set(1);
    Object localObject1 = this.qf.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CardContainer.a)((Iterator)localObject1).next();
      if (((CardContainer.a)localObject2).flag > 0) {
        localAuthorizeRequest.openapi.add(Integer.valueOf(((CardContainer.a)localObject2).id));
      }
    }
    localAuthorizeRequest.os.set(Build.VERSION.RELEASE + "|android os|" + Build.MODEL);
    localAuthorizeRequest.qqv.set(aroi.a().getVersionName());
    localAuthorizeRequest.pf.set("openmobile_android");
    localAuthorizeRequest.sdkp.set(ubu.cq(this.jdField_b_of_type_Tzg.bDo));
    localAuthorizeRequest.sdkv.set("1.5.9");
    localAuthorizeRequest.response_type.set("token");
    if ((this.jdField_b_of_type_Tzg instanceof tzm))
    {
      localObject1 = ((tzm)this.jdField_b_of_type_Tzg).oH();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localAuthorizeRequest.appUniqueIdentifier.set((String)localObject1);
      }
    }
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    Object localObject3 = ((TicketManager)((AppRuntime)localObject1).getManager(2)).getSkey((String)localObject2);
    if (localObject3 != null) {
      localAuthorizeRequest.skey.set((String)localObject3);
    }
    if ((this.jdField_b_of_type_Tzg instanceof uaw))
    {
      uaw localuaw = (uaw)this.jdField_b_of_type_Tzg;
      if (localuaw.aQP)
      {
        localObject3 = a((AppRuntime)localObject1, (String)localObject3, localuaw.aKt, localuaw.aKs);
        localAuthorizeRequest.passData.set((String)localObject3);
      }
    }
    localObject3 = new NewIntent(BaseApplicationImpl.getApplication(), aruh.class);
    ((NewIntent)localObject3).setWithouLogin(true);
    ((NewIntent)localObject3).putExtra("uin", (String)localObject2);
    ((NewIntent)localObject3).putExtra("data", localAuthorizeRequest.toByteArray());
    ((NewIntent)localObject3).putExtra("cmd", "ConnAuthSvr.sdk_auth_api");
    ((NewIntent)localObject3).setObserver(new uao(this, (String)localObject2));
    ((AppRuntime)localObject1).startServlet((NewIntent)localObject3);
  }
  
  private void uI(String paramString)
  {
    String str = null;
    ajcn localajcn = this.jdField_b_of_type_Tzg.a();
    Object localObject;
    if (localajcn == null)
    {
      localObject = null;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label144;
      }
      localObject = BaseApplicationImpl.getApplication().getString(2131696687);
    }
    label144:
    for (;;)
    {
      if (TextUtils.isEmpty(paramString))
      {
        bFf();
        return;
        localObject = localajcn.appName;
        break;
      }
      tzg localtzg = this.jdField_b_of_type_Tzg;
      if (localajcn == null) {}
      for (;;)
      {
        localtzg.a((String)localObject, str, BaseApplicationImpl.getApplication().getString(2131696686, new Object[] { localObject }), paramString, BaseApplicationImpl.getApplication().getString(2131721897), new ual(this), BaseApplicationImpl.getApplication().getString(2131721908), new uam(this), new uan(this));
        return;
        str = localajcn.iconUrl;
      }
    }
  }
  
  private void uJ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "openBrowserForRedirect: invoked.  url: " + paramString);
    }
    Object localObject = this.jdField_b_of_type_Tzg.getActivity();
    if ((localObject != null) && ((this.jdField_b_of_type_Tzg instanceof uaw)) && ((localObject instanceof aqzs)))
    {
      localObject = ((aqzs)localObject).c();
      if (localObject != null) {
        ((WebViewFragment)localObject).j.loadUrl(paramString);
      }
    }
  }
  
  private void vE(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "-->queryAuthority");
    }
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_b_of_type_Tzg.mAppid);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2;
        Object localObject2;
        Object localObject1;
        String str3;
        PBStringField localPBStringField;
        continue;
        String str1 = "all";
      }
    }
    localGetAuthApiListRequest.client_id.set(l1);
    localGetAuthApiListRequest.os.set(Build.VERSION.RELEASE + "|android os|" + Build.MODEL);
    str2 = aroi.a().getVersionName();
    localObject2 = localGetAuthApiListRequest.qqv;
    localObject1 = str2;
    if (str2 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localGetAuthApiListRequest.pf.set("openmobile_android");
    if (((this.jdField_b_of_type_Tzg instanceof uaw)) && (((uaw)this.jdField_b_of_type_Tzg).aQP))
    {
      localObject1 = "all" + ",server_side";
      localGetAuthApiListRequest.scope.set((String)localObject1);
      localGetAuthApiListRequest.sdkp.set(ubu.cq(this.jdField_b_of_type_Tzg.bDo));
      localGetAuthApiListRequest.sdkv.set("1.5.9");
      localGetAuthApiListRequest.need_pay.set(1);
      if ((this.jdField_b_of_type_Tzg instanceof tzm))
      {
        localObject1 = ((tzm)this.jdField_b_of_type_Tzg).oH();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localGetAuthApiListRequest.appUniqueIdentifier.set((String)localObject1);
        }
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      str3 = ((AppRuntime)localObject2).getAccount();
      str2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey(str3);
      localPBStringField = localGetAuthApiListRequest.skey;
      localObject1 = str2;
      if (str2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), aruh.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("uin", str3);
      ((NewIntent)localObject1).putExtra("data", localGetAuthApiListRequest.toByteArray());
      ((NewIntent)localObject1).putExtra("cmd", "ConnAuthSvr.get_auth_api_list");
      ((NewIntent)localObject1).setObserver(new uak(this, str3, paramBoolean));
      ((AppRuntime)localObject2).startServlet((NewIntent)localObject1);
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, tzd paramtzd, boolean paramBoolean)
  {
    this.d = paramtzd;
    if (this.status != 0) {
      return;
    }
    vE(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uaj
 * JD-Core Version:    0.7.0.1
 */