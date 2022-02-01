package com.tencent.qapmsdk.base.meta;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.DBHelper.Companion;
import com.tencent.qapmsdk.base.reporter.uploaddata.verifier.QAPMNameVerifier;
import com.tencent.qapmsdk.common.ssl.NameVerifierFactory;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/BaseInfo;", "", "()V", "Info", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class BaseInfo
{
  public static final Info Info;
  @JvmField
  @Nullable
  public static Application app;
  @JvmField
  @Nullable
  public static DBHelper dbHelper;
  @JvmField
  @NotNull
  public static AsyncSPEditor editor;
  @JvmField
  @NotNull
  public static JSONObject pubJson;
  @JvmField
  @Nullable
  public static SharedPreferences sharePreference;
  @JvmField
  @NotNull
  public static String token;
  @JvmField
  @NotNull
  public static final UrlMeta urlMeta;
  @JvmField
  @NotNull
  public static final UserMeta userMeta;
  
  static
  {
    Object localObject2 = null;
    Info = new Info(null);
    userMeta = new UserMeta(null, null, null, 0, null, null, null, null, null, null, null, null, null, 8191, null);
    urlMeta = new UrlMeta(null, null, null, null, null, null, 63, null);
    Object localObject1 = app;
    if (localObject1 != null) {}
    for (localObject1 = ((Application)localObject1).getSharedPreferences("QAPM_SP", 0);; localObject1 = null)
    {
      sharePreference = (SharedPreferences)localObject1;
      SharedPreferences localSharedPreferences = sharePreference;
      localObject1 = localObject2;
      if (localSharedPreferences != null) {
        localObject1 = localSharedPreferences.edit();
      }
      editor = new AsyncSPEditor((SharedPreferences.Editor)localObject1);
      token = "";
      pubJson = new JSONObject();
      return;
    }
  }
  
  @JvmStatic
  public static final void initInfo()
  {
    Info.initInfo();
  }
  
  @JvmStatic
  public static final void initUrl()
  {
    Info.initUrl();
  }
  
  @JvmStatic
  public static final void reset()
  {
    Info.reset();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/BaseInfo$Info;", "", "()V", "app", "Landroid/app/Application;", "dbHelper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "editor", "Lcom/tencent/qapmsdk/common/util/AsyncSPEditor;", "pubJson", "Lorg/json/JSONObject;", "sharePreference", "Landroid/content/SharedPreferences;", "token", "", "urlMeta", "Lcom/tencent/qapmsdk/base/meta/UrlMeta;", "userMeta", "Lcom/tencent/qapmsdk/base/meta/UserMeta;", "initInfo", "", "initUrl", "reset", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Info
  {
    @JvmStatic
    public final void initInfo()
    {
      Object localObject2 = BaseInfo.app;
      Object localObject1;
      UserMeta localUserMeta;
      if (localObject2 != null)
      {
        FileUtil.Companion.setApp((Application)localObject2);
        NameVerifierFactory.INSTANCE.setNameVerifier((HostnameVerifier)new QAPMNameVerifier());
        BaseInfo.sharePreference = ((Application)localObject2).getSharedPreferences("QAPM_SP", 0);
        localObject1 = BaseInfo.sharePreference;
        if (localObject1 == null) {
          break label153;
        }
        localObject1 = ((SharedPreferences)localObject1).edit();
        BaseInfo.editor = new AsyncSPEditor((SharedPreferences.Editor)localObject1);
        if (Intrinsics.areEqual(BaseInfo.userMeta.uin, "10000"))
        {
          localUserMeta = BaseInfo.userMeta;
          localObject1 = BaseInfo.sharePreference;
          if (localObject1 == null) {
            break label158;
          }
          localObject1 = ((SharedPreferences)localObject1).getString("config_uin", "10000");
          if (localObject1 == null) {
            break label158;
          }
        }
      }
      for (;;)
      {
        localUserMeta.uin = ((String)localObject1);
        localObject1 = DBHelper.Companion;
        localObject2 = ((Application)localObject2).getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.applicationContext");
        BaseInfo.dbHelper = ((DBHelper.Companion)localObject1).getInstance((Context)localObject2);
        BaseInfo.pubJson = new JSONObject(BaseInfo.userMeta.toJSON());
        return;
        label153:
        localObject1 = null;
        break;
        label158:
        localObject1 = "10000";
      }
    }
    
    @JvmStatic
    public final void initUrl()
    {
      BaseInfo.urlMeta.setConfigUrl(BaseInfo.urlMeta.qapmDomain + "/appconfig/v5/config/" + BaseInfo.userMeta.appId + '/');
      BaseInfo.urlMeta.setAuthorizationUrl(BaseInfo.urlMeta.qapmDomain + "/entrance/" + BaseInfo.userMeta.appId + "/authorize/");
      BaseInfo.urlMeta.setJsonUploadUrl(BaseInfo.urlMeta.qapmDomain + "/entrance/" + BaseInfo.userMeta.appId + "/uploadJson/");
      BaseInfo.urlMeta.setFileUploadUrl(BaseInfo.urlMeta.qapmDomain + "/entrance/" + BaseInfo.userMeta.appId + "/uploadFile/");
    }
    
    @JvmStatic
    public final void reset()
    {
      ((Info)this).initUrl();
      BaseInfo.pubJson = new JSONObject(BaseInfo.userMeta.toJSON());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.BaseInfo
 * JD-Core Version:    0.7.0.1
 */