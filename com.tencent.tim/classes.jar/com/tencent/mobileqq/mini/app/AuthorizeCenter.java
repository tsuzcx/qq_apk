package com.tencent.mobileqq.mini.app;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import acfp;
import aekv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApiScopeEntry;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.apkg.UserAuthScope;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AuthorizeCenter
{
  public static final int AUTH_FLAG_FALSE = 4;
  public static final int AUTH_FLAG_NONE = 1;
  public static final int AUTH_FLAG_TRUE = 2;
  public static final String IS_ONCE_SUB_ITEM_MAINTAIN = "once_sub_item_maintain";
  public static final String KEY_API_NAME = "api_name";
  public static final String KEY_API_NAME_CLICK_ADVERT = "advert_tap";
  public static final String KEY_API_NAME_GET_ADVERT = "webapi_getadvert";
  public static final String KEY_API_NAME_GET_BLOCK_AD = "getBlockAd";
  public static final String KEY_API_NAME_GET_NAVIGATE_WX_APPINFO = "webapi_getnavigatewxaappinfo";
  public static final String KEY_API_NAME_GET_SUBJECT_ALTER_INFO = "getSubjectalterInfo";
  public static final String KEY_API_NAME_GET_USER_INFO = "webapi_getuserinfo";
  public static final String KEY_API_NAME_GET_USER_INFO_OPEN_DATA = "webapi_getuserinfo_opendata";
  public static final String KEY_API_NAME_RUN_STEP_HISTORY = "webapi_getwerunstep_history";
  public static final String KEY_API_NAME_WXA_SUBSCRIBE_BIZ = "webapi_wxa_subscribe_biz";
  public static final String KEY_AUTHORITY_SYNCHRONIZED = "authority_synchronized";
  public static final String KEY_IS_REQUEST_USER_INFO_AUTH_BY_USER = "from_component";
  public static final String SCOPE_ADDRESS = "scope.address";
  public static final String SCOPE_CAMERA = "scope.camera";
  public static final String SCOPE_GET_PHONE_NUMBER = "scope.getPhoneNumber";
  public static final String SCOPE_INVOICE = "scope.invoice";
  public static final String SCOPE_INVOICE_TITLE = "scope.invoiceTitle";
  public static final String SCOPE_PERSONALIZE = "scope.personalize";
  public static final String SCOPE_RECORD = "scope.record";
  public static final String SCOPE_USER_INFO = "scope.userInfo";
  public static final String SCOPE_USER_LOCATION = "scope.userLocation";
  public static final String SCOPE_WEREN = "scope.qqrun";
  public static final String SCOPE_WRITE_PHOTOS_ALBUM = "scope.writePhotosAlbum";
  public static final String SETTING_ADD_FRIEND = "setting.addFriend";
  public static final String SETTING_APP_MSG_SUBSCRIBED = "setting.appMsgSubscribed";
  public static final String SETTING_APP_ONCE_MSG_SUBSCRIBED = "setting.onceMsgSubscribed";
  public static final String TAG = "AuthorizeCenter";
  private static ExtConfigInfo extConfigInfo;
  public static final HashMap<String, String> negativeButtonDesMap = new HashMap();
  private static final HashMap<String, Integer> scopeAuthTypeMap = new HashMap();
  public static final HashMap<String, String> scopeDescMap;
  public static final List<String> scopeList;
  private static final HashMap<String, String> scopeMap;
  public static final HashMap<String, String> scopeTitleMap;
  public static final HashMap<String, String> settingScopeTitleMap;
  private static String systemPermissionConfig = aekv.aT("miniappsustempermissionconfig", "{\"chooseLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"openLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"getLocation\":\"android.permission.ACCESS_FINE_LOCATION\",\"chooseVideo\":\"android.permission.CAMERA\",\"chooseImage\":\"android.permission.CAMERA\",\"saveImageToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"saveVideoToPhotosAlbum\":\"android.permission.WRITE_EXTERNAL_STORAGE\",\"startRecord\":\"android.permission.RECORD_AUDIO\",\"operateRecorder\":\"android.permission.RECORD_AUDIO\",\"joinVoIPChat\":\"android.permission.RECORD_AUDIO\",\"operateCamera\":\"android.permission.CAMERA\",\"updateCamera\":\"android.permission.CAMERA\",\"insertCamera\":\"android.permission.CAMERA\"}");
  public static final HashMap<String, String> systemPermissionMap;
  private int ANTH_DELAY = 60;
  private String appid;
  private SharedPreferences sp;
  
  static
  {
    scopeMap = new HashMap();
    scopeList = new ArrayList();
    scopeTitleMap = new HashMap();
    scopeDescMap = new HashMap();
    settingScopeTitleMap = new HashMap();
    systemPermissionMap = new HashMap();
  }
  
  @Deprecated
  public AuthorizeCenter() {}
  
  public AuthorizeCenter(String paramString1, String paramString2)
  {
    this.sp = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + paramString2, 4);
    this.appid = paramString1;
    if ((scopeMap == null) || (scopeMap.size() == 0)) {
      staticInit();
    }
  }
  
  public static void clearAuth(String paramString1, String paramString2)
  {
    QLog.i("AuthorizeCenter", 1, "clear all auth ");
    paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + paramString2, 4);
    paramString2 = scopeMap.values().iterator();
    while (paramString2.hasNext())
    {
      String str = (String)paramString2.next();
      if (paramString1.getInt(str, 1) != 1) {
        paramString1.edit().putInt(str, 1).commit();
      }
    }
    paramString1.edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public static String getEventNameByScopeName(String paramString)
  {
    Iterator localIterator = scopeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.equals(localEntry.getValue())) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  public static String getScopeName(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      str = getScopeNameByParams(paramString2);
      if (isScopeNameValid(str)) {
        return str;
      }
    }
    String str = null;
    try
    {
      paramString2 = new JSONObject(paramString2).optString("api_name");
      if (TextUtils.isEmpty(paramString2)) {}
      for (;;)
      {
        return (String)scopeMap.get(paramString1);
        paramString1 = paramString1 + "." + paramString2;
      }
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        paramString2 = str;
      }
    }
  }
  
  private static String getScopeNameByParams(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("scope").getString(0);
      String str = paramString;
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          str = paramString.trim();
        }
        return str;
      }
      catch (Throwable localThrowable2)
      {
        break label40;
      }
      localThrowable1 = localThrowable1;
      paramString = "";
    }
    label40:
    return paramString;
  }
  
  public static String getSystemPermission(String paramString1, String paramString2)
  {
    if ("authorize".equals(paramString1))
    {
      paramString1 = getEventNameByScopeName(getScopeNameByParams(paramString2));
      return (String)systemPermissionMap.get(paramString1);
    }
    return (String)systemPermissionMap.get(paramString1);
  }
  
  public static boolean isInScopeList(String paramString1, String paramString2)
  {
    return !TextUtils.isEmpty(getScopeName(paramString1, paramString2));
  }
  
  public static boolean isScopeNameValid(String paramString)
  {
    Iterator localIterator = scopeList.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private static void mergeExtConfigInfo()
  {
    if (extConfigInfo != null) {}
    for (;;)
    {
      return;
      String str = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppExtConfigDetail", 4).getString("MiniAppExtConfigDetail", null);
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2;
        for (;;)
        {
          try
          {
            extConfigInfo = ExtConfigInfo.fromJson(new JSONObject(str));
            localObject2 = extConfigInfo.apiScopeEntries.iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            ApiScopeEntry localApiScopeEntry = (ApiScopeEntry)((Iterator)localObject2).next();
            if ((localApiScopeEntry != null) && (!TextUtils.isEmpty(localApiScopeEntry.eventName)) && (!TextUtils.isEmpty(localApiScopeEntry.scope))) {
              if (TextUtils.isEmpty(localApiScopeEntry.apiName))
              {
                str = localApiScopeEntry.eventName;
                scopeMap.put(str, localApiScopeEntry.scope);
                if (!scopeList.contains(localApiScopeEntry.scope)) {
                  scopeList.add(localApiScopeEntry.scope);
                }
              }
              else
              {
                localObject1 = localApiScopeEntry.eventName + "." + localApiScopeEntry.apiName;
              }
            }
          }
          catch (Exception localException)
          {
            QLog.e("AuthorizeCenter", 1, "mergeExtConfigInfo error:", localException);
            return;
          }
        }
        Object localObject1 = extConfigInfo.userAuthScopes.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (UserAuthScope)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((UserAuthScope)localObject2).scope)))
          {
            if (!TextUtils.isEmpty(((UserAuthScope)localObject2).desc)) {
              scopeTitleMap.put(((UserAuthScope)localObject2).scope, ((UserAuthScope)localObject2).desc);
            }
            if (!TextUtils.isEmpty(((UserAuthScope)localObject2).settingPageTitle)) {
              settingScopeTitleMap.put(((UserAuthScope)localObject2).scope, ((UserAuthScope)localObject2).settingPageTitle);
            }
            if (!scopeDescMap.containsKey(((UserAuthScope)localObject2).scope)) {
              scopeDescMap.put(((UserAuthScope)localObject2).scope, "");
            }
            if (!scopeAuthTypeMap.containsKey(((UserAuthScope)localObject2).scope)) {
              scopeAuthTypeMap.put(((UserAuthScope)localObject2).scope, Integer.valueOf(((UserAuthScope)localObject2).authType));
            }
          }
        }
      }
    }
  }
  
  private static void staticInit()
  {
    try
    {
      if (!TextUtils.isEmpty(systemPermissionConfig))
      {
        JSONObject localJSONObject = new JSONObject(systemPermissionConfig);
        if (localJSONObject.length() > 0)
        {
          Iterator localIterator = localJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = localJSONObject.optString(str1);
            systemPermissionMap.put(str1, str2);
            QLog.i("AuthorizeCenter", 1, "event : " + str1 + "; permissionname : " + str2);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AuthorizeCenter", 1, "systemPermissionConfig error", localThrowable);
      systemPermissionMap.put("chooseLocation", "android.permission.ACCESS_FINE_LOCATION");
      systemPermissionMap.put("openLocation", "android.permission.ACCESS_FINE_LOCATION");
      systemPermissionMap.put("getLocation", "android.permission.ACCESS_FINE_LOCATION");
      if (Build.VERSION.SDK_INT >= 16)
      {
        systemPermissionMap.put("chooseVideo", "android.permission.CAMERA");
        systemPermissionMap.put("chooseImage", "android.permission.CAMERA");
        systemPermissionMap.put("saveImageToPhotosAlbum", "android.permission.WRITE_EXTERNAL_STORAGE");
        systemPermissionMap.put("saveVideoToPhotosAlbum", "android.permission.WRITE_EXTERNAL_STORAGE");
      }
      systemPermissionMap.put("startRecord", "android.permission.RECORD_AUDIO");
      systemPermissionMap.put("operateRecorder", "android.permission.RECORD_AUDIO");
      systemPermissionMap.put("joinVoIPChat", "android.permission.RECORD_AUDIO");
      systemPermissionMap.put("operateCamera", "android.permission.CAMERA");
      systemPermissionMap.put("updateCamera", "android.permission.CAMERA");
      scopeMap.put("chooseLocation", "scope.userLocation");
      scopeMap.put("getLocation", "scope.userLocation");
      scopeMap.put("saveImageToPhotosAlbum", "scope.writePhotosAlbum");
      scopeMap.put("saveVideoToPhotosAlbum", "scope.writePhotosAlbum");
      scopeMap.put("startRecord", "scope.record");
      scopeMap.put("operateWXData", "scope.userInfo");
      scopeMap.put("chooseInvoiceTitle", "scope.invoiceTitle");
      scopeMap.put("openAddress", "scope.address");
      scopeMap.put("openWeRunSetting", "scope.qqrun");
      scopeMap.put("getNativeWeRunData", "scope.qqrun");
      scopeMap.put("subscribeAppMsg", "setting.appMsgSubscribed");
      scopeMap.put("subscribeOnceAppMsg", "setting.onceMsgSubscribed");
      scopeMap.put("insertCamera", "scope.camera");
      scopeMap.put("Personalize", "scope.personalize");
      scopeMap.put("getPhoneNumber", "scope.getPhoneNumber");
      scopeList.add("scope.userLocation");
      scopeList.add("scope.userInfo");
      scopeList.add("scope.address");
      scopeList.add("scope.invoiceTitle");
      scopeList.add("scope.qqrun");
      scopeList.add("scope.record");
      scopeList.add("scope.writePhotosAlbum");
      scopeList.add("scope.camera");
      scopeList.add("scope.personalize");
      scopeList.add("setting.appMsgSubscribed");
      scopeList.add("setting.addFriend");
      scopeList.add("scope.getPhoneNumber");
      scopeTitleMap.put("scope.userLocation", acfp.m(2131702940));
      scopeTitleMap.put("scope.userInfo", acfp.m(2131702939));
      scopeTitleMap.put("scope.address", acfp.m(2131702946));
      scopeTitleMap.put("scope.invoiceTitle", acfp.m(2131702951));
      scopeTitleMap.put("scope.qqrun", acfp.m(2131695923));
      scopeTitleMap.put("scope.record", acfp.m(2131702952));
      scopeTitleMap.put("scope.writePhotosAlbum", acfp.m(2131702954));
      scopeTitleMap.put("scope.camera", acfp.m(2131702960));
      scopeTitleMap.put("scope.personalize", acfp.m(2131702948));
      scopeTitleMap.put("setting.appMsgSubscribed", acfp.m(2131702964));
      scopeTitleMap.put("setting.addFriend", acfp.m(2131702962));
      scopeTitleMap.put("scope.getPhoneNumber", acfp.m(2131695921));
      scopeDescMap.put("scope.userLocation", "");
      scopeDescMap.put("scope.userInfo", acfp.m(2131695916));
      scopeDescMap.put("scope.address", "");
      scopeDescMap.put("scope.invoiceTitle", "");
      scopeDescMap.put("scope.qqrun", "");
      scopeDescMap.put("scope.record", "");
      scopeDescMap.put("scope.writePhotosAlbum", "");
      scopeDescMap.put("scope.camera", "");
      scopeDescMap.put("scope.personalize", "");
      scopeDescMap.put("setting.appMsgSubscribed", acfp.m(2131702947));
      scopeDescMap.put("setting.addFriend", "");
      scopeDescMap.put("scope.getPhoneNumber", "");
      settingScopeTitleMap.put("scope.userLocation", acfp.m(2131702941));
      settingScopeTitleMap.put("scope.userInfo", acfp.m(2131702942));
      settingScopeTitleMap.put("scope.address", acfp.m(2131702937));
      settingScopeTitleMap.put("scope.invoiceTitle", acfp.m(2131702958));
      settingScopeTitleMap.put("scope.qqrun", acfp.m(2131702938));
      settingScopeTitleMap.put("scope.record", acfp.m(2131702959));
      settingScopeTitleMap.put("scope.writePhotosAlbum", acfp.m(2131702965));
      settingScopeTitleMap.put("scope.camera", acfp.m(2131702950));
      settingScopeTitleMap.put("scope.personalize", acfp.m(2131702943));
      settingScopeTitleMap.put("setting.appMsgSubscribed", acfp.m(2131695917));
      settingScopeTitleMap.put("setting.addFriend", acfp.m(2131702963));
      negativeButtonDesMap.put("setting.appMsgSubscribed", acfp.m(2131702953));
      scopeAuthTypeMap.put("scope.getPhoneNumber", Integer.valueOf(1));
      mergeExtConfigInfo();
    }
  }
  
  public static void updateScopeDescription(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = scopeDescMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        updateScopeDescriptionMap((String)((Map.Entry)localIterator.next()).getKey(), paramJSONObject);
      }
    }
  }
  
  private static void updateScopeDescriptionMap(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has(paramString))
    {
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      if (paramJSONObject.has("desc")) {
        scopeDescMap.put(paramString, paramJSONObject.optString("desc"));
      }
    }
  }
  
  public int getAuthFlag(String paramString1, String paramString2)
  {
    String str = getScopeName(paramString1, paramString2);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return 2;
      if ("operateWXData".equals(paramString1)) {}
      try
      {
        paramString1 = new JSONObject(paramString2).optJSONObject("data").optString("api_name");
        if ((!"webapi_getuserinfo_opendata".equals(paramString1)) && (!"webapi_getadvert".equals(paramString1)) && (!"webapi_getwerunstep_history".equals(paramString1)) && (!"advert_tap".equals(paramString1)) && (!"getBlockAd".equals(paramString1)))
        {
          boolean bool = "webapi_getnavigatewxaappinfo".equals(paramString1);
          if (bool) {}
        }
      }
      catch (Throwable paramString1)
      {
        label103:
        break label103;
      }
    }
    return this.sp.getInt(str, 1);
  }
  
  public int getAuthFlagFromAuthorize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 2;
    }
    return this.sp.getInt(paramString, 1);
  }
  
  public List<AuthorizeInfo> getAuthorizeList(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = scopeList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Integer localInteger = (Integer)scopeAuthTypeMap.get(str);
      if ((localInteger == null) || (localInteger.intValue() != 1))
      {
        int i = this.sp.getInt(str, 1);
        if (i == 2)
        {
          if ((paramInt & 0x2) == 2) {
            localArrayList.add(new AuthorizeInfo(str, 2));
          }
        }
        else if (i == 1)
        {
          if ((paramInt & 0x1) == 1) {
            localArrayList.add(new AuthorizeInfo(str, 1));
          }
        }
        else if ((paramInt & 0x4) == 4) {
          localArrayList.add(new AuthorizeInfo(str, 4));
        }
      }
    }
    return localArrayList;
  }
  
  public boolean isAuthorizeSynchronized()
  {
    return this.sp.getBoolean("authority_synchronized", false);
  }
  
  public boolean isOnceSubMaintain()
  {
    return this.sp.getBoolean("once_sub_item_maintain", false);
  }
  
  public void setAuthorize(String paramString, boolean paramBoolean)
  {
    setAuthorize(paramString, paramBoolean, new AuthorizeCenter.1(this));
  }
  
  public void setAuthorize(String paramString, boolean paramBoolean, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    int j = 1;
    int k = 2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (int i = 2;; i = 4)
    {
      this.sp.edit().putInt(paramString, i).commit();
      if (!paramString.startsWith("setting")) {
        break;
      }
      localObject = new INTERFACE.StUserSettingInfo();
      ((INTERFACE.StUserSettingInfo)localObject).settingItem.set(paramString);
      paramString = (String)scopeTitleMap.get(paramString);
      if (!TextUtils.isEmpty(paramString)) {
        ((INTERFACE.StUserSettingInfo)localObject).desc.set(paramString);
      }
      paramString = ((INTERFACE.StUserSettingInfo)localObject).authState;
      i = k;
      if (paramBoolean) {
        i = 1;
      }
      paramString.set(i);
      MiniAppCmdUtil.getInstance().updateUserSetting(null, this.appid, (INTERFACE.StUserSettingInfo)localObject, new AuthorizeCenter.3(this, paramMiniAppCmdInterface));
      return;
    }
    Object localObject = new INTERFACE.StUserAuthInfo();
    ((INTERFACE.StUserAuthInfo)localObject).scope.set(paramString);
    paramString = (String)scopeTitleMap.get(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      ((INTERFACE.StUserAuthInfo)localObject).desc.set(paramString);
    }
    paramString = ((INTERFACE.StUserAuthInfo)localObject).authState;
    if (paramBoolean) {}
    for (i = j;; i = 2)
    {
      paramString.set(i);
      MiniAppCmdUtil.getInstance().setAuth(null, this.appid, (INTERFACE.StUserAuthInfo)localObject, paramMiniAppCmdInterface);
      return;
    }
  }
  
  public void setAuthorizeSynchronized()
  {
    this.sp.edit().putBoolean("authority_synchronized", true).commit();
  }
  
  public boolean shouldAskEveryTime(String paramString1, String paramString2)
  {
    paramString1 = getScopeName(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString1 = (Integer)scopeAuthTypeMap.get(paramString1);
    if ((paramString1 != null) && (paramString1.intValue() == 1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void updateAuth(String paramString, boolean paramBoolean)
  {
    if (this.sp == null) {
      return;
    }
    if (paramBoolean)
    {
      this.sp.edit().putInt(paramString, 2).commit();
      return;
    }
    this.sp.edit().putInt(paramString, 4).commit();
  }
  
  public void updateAuthList(List<INTERFACE.StUserAuthInfo> paramList, List<INTERFACE.StUserSettingInfo> paramList1)
  {
    int j = 0;
    int i;
    Object localObject;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject = (INTERFACE.StUserAuthInfo)paramList.get(i);
        String str = ((INTERFACE.StUserAuthInfo)localObject).scope.get();
        int k = ((INTERFACE.StUserAuthInfo)localObject).authState.get();
        if (k == 1) {
          this.sp.edit().putInt(str, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 2) {
            this.sp.edit().putInt(str, 4).commit();
          }
        }
      }
    }
    if (paramList1 != null)
    {
      i = j;
      if (i < paramList1.size())
      {
        paramList = (INTERFACE.StUserSettingInfo)paramList1.get(i);
        localObject = paramList.settingItem.get();
        j = paramList.authState.get();
        if (j == 1) {
          this.sp.edit().putInt((String)localObject, 2).commit();
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == 2) {
            this.sp.edit().putInt((String)localObject, 4).commit();
          }
        }
      }
    }
  }
  
  public void updateIsOnceSubMsgMaintain(boolean paramBoolean)
  {
    this.sp.edit().putBoolean("once_sub_item_maintain", paramBoolean).apply();
  }
  
  public void updateOnceSubMsgSetting(boolean paramBoolean, List<INTERFACE.StSubscribeMessage> paramList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    INTERFACE.StUserSettingInfo localStUserSettingInfo = new INTERFACE.StUserSettingInfo();
    localStUserSettingInfo.settingItem.set("setting.onceMsgSubscribed");
    Object localObject = (String)scopeTitleMap.get("setting.onceMsgSubscribed");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localStUserSettingInfo.desc.set((String)localObject);
    }
    localObject = localStUserSettingInfo.authState;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((PBInt32Field)localObject).set(i);
      localStUserSettingInfo.subItems.set(paramList);
      MiniAppCmdUtil.getInstance().updateUserSetting(null, this.appid, localStUserSettingInfo, new AuthorizeCenter.2(this, paramMiniAppCmdInterface));
      return;
    }
  }
  
  public static class AuthorizeInfo
  {
    public int authFlag;
    public String scopeName;
    
    public AuthorizeInfo(String paramString, int paramInt)
    {
      this.scopeName = paramString;
      this.authFlag = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter
 * JD-Core Version:    0.7.0.1
 */