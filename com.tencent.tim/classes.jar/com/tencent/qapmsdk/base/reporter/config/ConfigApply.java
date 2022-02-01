package com.tencent.qapmsdk.base.reporter.config;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.config.SDKConfig.Companion;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.table.ConfigsTable;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.authorization.Authorization;
import com.tencent.qapmsdk.base.reporter.proxy.AuthorizationProxy;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "configMd5", "", "serviceSwitch", "", "getServiceSwitch", "()I", "setServiceSwitch", "(I)V", "userMode", "getUserMode", "setUserMode", "flushConfigSp", "", "hit", "getHit", "getLastMode", "loadConfigs", "loadLocalConfigs", "pId", "version", "loadServiceConfigs", "Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode;", "parseConfig", "json", "Lorg/json/JSONObject;", "request", "Companion", "LoadConfigMode", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ConfigApply
  extends QAPMUpload
{
  public static final Companion Companion = new Companion(null);
  private static final int STATUS_UPDATE_CONFIG = 1000;
  private static final String TAG = "QAPM_base_ConfigApply";
  private String configMd5 = "";
  private int serviceSwitch = PluginCombination.Companion.getModeStable();
  private int userMode;
  
  public ConfigApply(@NotNull URL paramURL)
  {
    super(paramURL);
  }
  
  private final void flushConfigSp(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      if ((paramInt == 0) && (this.serviceSwitch > 0)) {
        BaseInfo.editor.putLong("config_hit_over_time", System.currentTimeMillis() + 2592000000L).putInt("config_hit", 1);
      }
      AsyncSPEditor localAsyncSPEditor = BaseInfo.editor;
      paramInt = this.serviceSwitch;
      localAsyncSPEditor.putInt("config_last_mode", localSharedPreferences.getInt("config_last_mode", 0) | paramInt);
    }
  }
  
  private final int getHit()
  {
    int i = 0;
    long l = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      if (localSharedPreferences.getLong("config_hit_over_time", 0L) < l) {
        BaseInfo.editor.putLong("config_hit_over_time", l + 2592000000L).putInt("config_hit", 0);
      }
      i = localSharedPreferences.getInt("config_hit", 0);
    }
    return i;
  }
  
  private final int getLastMode()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    int i;
    int j;
    if (localSharedPreferences != null)
    {
      i = localSharedPreferences.getInt("config_last_day", 0);
      j = Calendar.getInstance().get(6);
      if (i == 0) {
        break label79;
      }
      if (i == j) {
        break label61;
      }
      BaseInfo.editor.putInt("config_last_day", j).putInt("config_last_mode", 0).apply();
    }
    label61:
    do
    {
      return 0;
      i = 0;
      break;
      localSharedPreferences = BaseInfo.sharePreference;
    } while (localSharedPreferences == null);
    return localSharedPreferences.getInt("config_last_mode", 0);
    label79:
    BaseInfo.editor.putInt("config_last_day", j).apply();
    return 0;
  }
  
  private final void loadLocalConfigs(int paramInt, String paramString)
  {
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).getDbHandler();
      if (localObject != null) {
        ((DBHandler)localObject).search((BaseTable)new ConfigsTable(paramInt, paramString), (Function0)ConfigApply.loadLocalConfigs.1.INSTANCE);
      }
    }
    paramString = BaseInfo.sharePreference;
    float f;
    if (paramString != null)
    {
      f = paramString.getFloat("config_user_sample_ratio", 0.0F);
      if (f > 0) {
        SDKConfig.Companion.setUSER_SAMPLE_RATIO(f);
      }
      paramString = BaseInfo.sharePreference;
      if (paramString == null) {
        break label197;
      }
      paramInt = paramString.getInt("config_max_austerity_report_number", 0);
      label96:
      if (paramInt >= 0) {
        SDKConfig.Companion.setMAX_AUSTERITY_REPORT_NUM(paramInt);
      }
      paramString = BaseInfo.sharePreference;
      if (paramString == null) {
        break label202;
      }
      paramInt = paramString.getInt("config_max_loose_report_number", 0);
      label125:
      if (paramInt >= 0) {
        SDKConfig.Companion.setMAX_LOOSE_REPORT_NUM(paramInt);
      }
      paramString = BaseInfo.sharePreference;
      if (paramString == null) {
        break label207;
      }
      paramInt = paramString.getInt("config_version_type", 0);
      label154:
      if (paramInt > 0) {
        SDKConfig.Companion.setVER_TYPE(paramInt);
      }
      paramString = BaseInfo.sharePreference;
      if (paramString == null) {
        break label212;
      }
    }
    label197:
    label202:
    label207:
    label212:
    for (paramInt = paramString.getInt("config_resource_type", 2);; paramInt = 2)
    {
      if (paramInt >= 0) {
        SDKConfig.RES_TYPE = paramInt;
      }
      return;
      f = 0.0F;
      break;
      paramInt = 0;
      break label96;
      paramInt = 0;
      break label125;
      paramInt = 0;
      break label154;
    }
  }
  
  private final LoadConfigMode loadServiceConfigs(int paramInt)
  {
    LoadConfigMode localLoadConfigMode = LoadConfigMode.NO_AUTHORITY;
    if ((TextUtils.isEmpty((CharSequence)BaseInfo.token)) && (!AuthorizationProxy.INSTANCE.getAuthorization().getToken(BaseInfo.userMeta.appKey, true))) {}
    for (;;)
    {
      return localLoadConfigMode;
      Object localObject4 = new HashMap();
      ((Map)localObject4).put("Content-Type", "application/x-gzip");
      ((Map)localObject4).put("Content-Encoding", "gzip");
      ((Map)localObject4).put("Authorize", BaseInfo.token);
      HttpURLConnection localHttpURLConnection = connectionBuilder((HashMap)localObject4);
      Object localObject7;
      if (localHttpURLConnection != null)
      {
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
      }
      try
      {
        i = getHit();
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
        localObject12 = new JSONObject(UserMeta.copy$default(BaseInfo.userMeta, null, null, null, 0, null, null, null, null, null, null, null, null, null, 8191, null).toJSON());
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
        ((JSONObject)localObject12).put("userSwitch", paramInt);
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
        ((JSONObject)localObject12).put("lastSwitch", getLastMode());
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
        ((JSONObject)localObject12).put("pid", ((JSONObject)localObject12).get("p_id").toString());
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
        ((JSONObject)localObject12).put("hit", i);
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
        ((JSONObject)localObject12).remove("p_id");
        localObject7 = localLoadConfigMode;
        localObject4 = localLoadConfigMode;
        if (((CharSequence)this.configMd5).length() > 0)
        {
          paramInt = 1;
          if (paramInt != 0)
          {
            localObject7 = localLoadConfigMode;
            localObject4 = localLoadConfigMode;
            ((JSONObject)localObject12).put("md5code", this.configMd5);
          }
          localObject7 = localLoadConfigMode;
          localObject4 = localLoadConfigMode;
          localObject8 = Logger.INSTANCE;
          localObject7 = localLoadConfigMode;
          localObject4 = localLoadConfigMode;
          Object localObject9 = ((JSONObject)localObject12).toString();
          localObject7 = localLoadConfigMode;
          localObject4 = localLoadConfigMode;
          Intrinsics.checkExpressionValueIsNotNull(localObject9, "json.toString()");
          localObject7 = localLoadConfigMode;
          localObject4 = localLoadConfigMode;
          ((Logger)localObject8).i(new String[] { "QAPM_base_ConfigApply", localObject9 });
          localObject7 = localLoadConfigMode;
          localObject4 = localLoadConfigMode;
          localCloseable = (Closeable)new GZIPOutputStream((OutputStream)new DataOutputStream(localHttpURLConnection.getOutputStream()));
          localObject7 = localLoadConfigMode;
          localObject4 = localLoadConfigMode;
          localObject9 = (Throwable)null;
          localObject8 = localObject9;
          try
          {
            localObject4 = (GZIPOutputStream)localCloseable;
            localObject8 = localObject9;
            localObject7 = ((JSONObject)localObject12).toString();
            localObject8 = localObject9;
            Intrinsics.checkExpressionValueIsNotNull(localObject7, "json.toString()");
            localObject8 = localObject9;
            localObject12 = Charset.forName("utf-8");
            localObject8 = localObject9;
            Intrinsics.checkExpressionValueIsNotNull(localObject12, "Charset.forName(charsetName)");
            if (localObject7 == null)
            {
              localObject8 = localObject9;
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
          catch (Throwable localThrowable2)
          {
            localObject8 = localThrowable2;
            throw localThrowable2;
          }
          finally
          {
            localObject7 = localLoadConfigMode;
            localObject5 = localLoadConfigMode;
            CloseableKt.closeFinally(localCloseable, (Throwable)localObject8);
            localObject7 = localLoadConfigMode;
            localObject5 = localLoadConfigMode;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        int i;
        Object localObject12;
        for (;;)
        {
          Logger.INSTANCE.exception("QAPM_base_ConfigApply", (Throwable)localJSONException);
          return localObject7;
          paramInt = 0;
        }
        Object localObject8 = localThrowable4;
        localObject7 = ((String)localObject7).getBytes((Charset)localObject12);
        localObject8 = localThrowable4;
        Intrinsics.checkExpressionValueIsNotNull(localObject7, "(this as java.lang.String).getBytes(charset)");
        localObject8 = localThrowable4;
        ((GZIPOutputStream)localObject5).write((byte[])localObject7);
        localObject8 = localThrowable4;
        ((GZIPOutputStream)localObject5).finish();
        localObject8 = localThrowable4;
        Object localObject5 = Unit.INSTANCE;
        localObject7 = localJSONException;
        localObject5 = localJSONException;
        CloseableKt.closeFinally(localCloseable, localThrowable4);
        localObject7 = localJSONException;
        localObject5 = localJSONException;
        Closeable localCloseable = (Closeable)new BufferedInputStream(localHttpURLConnection.getInputStream());
        localObject7 = localJSONException;
        localObject5 = localJSONException;
        Object localObject10 = (Throwable)null;
        localObject8 = localObject10;
        try
        {
          localObject5 = (BufferedInputStream)localCloseable;
          localObject8 = localObject10;
          localObject12 = FileUtil.Companion.readStream((InputStream)localObject5, 8192);
          localObject8 = localObject10;
          Logger.INSTANCE.i(new String[] { "QAPM_base_ConfigApply", localObject12 });
          localObject8 = localObject10;
          localObject5 = Unit.INSTANCE;
          localObject7 = localJSONException;
          localObject5 = localJSONException;
          CloseableKt.closeFinally(localCloseable, (Throwable)localObject10);
          localObject7 = localJSONException;
          localObject5 = localJSONException;
          localObject8 = new JSONObject((String)localObject12);
          localObject7 = localJSONException;
          localObject5 = localJSONException;
          this.serviceSwitch = ((JSONObject)localObject8).getInt("switch");
          localObject7 = localJSONException;
          localObject5 = localJSONException;
          if (((JSONObject)localObject8).getInt("status") == 1000)
          {
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            localObject10 = ((JSONObject)localObject8).getJSONObject("data");
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            Intrinsics.checkExpressionValueIsNotNull(localObject10, "serviceConfigJson.getJSONObject(\"data\")");
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            parseConfig((JSONObject)localObject10);
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            localObject8 = ((JSONObject)localObject8).getString("md5");
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            Intrinsics.checkExpressionValueIsNotNull(localObject8, "serviceConfigJson.getString(\"md5\")");
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            this.configMd5 = ((String)localObject8);
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            localObject8 = BaseInfo.dbHelper;
            if (localObject8 != null)
            {
              localObject7 = localJSONException;
              localObject5 = localJSONException;
              localObject8 = ((DBHelper)localObject8).getDbHandler();
              if (localObject8 != null)
              {
                localObject7 = localJSONException;
                localObject5 = localJSONException;
                ((DBHandler)localObject8).insert((BaseTable)new ConfigsTable(BaseInfo.userMeta.appId, BaseInfo.userMeta.version), (Function0)ConfigApply.loadServiceConfigs.1.3.INSTANCE);
              }
            }
            localObject7 = localJSONException;
            localObject5 = localJSONException;
            localObject1 = LoadConfigMode.FROM_SERVICE;
            localObject7 = localObject1;
            localObject5 = localObject1;
            flushConfigSp(i);
            localObject7 = localObject1;
            localObject5 = localObject1;
            BaseInfo.editor.apply();
            localObject5 = localObject1;
            localObject1 = localObject5;
            return localObject5;
          }
        }
        catch (Throwable localThrowable3)
        {
          localObject8 = localThrowable3;
          throw localThrowable3;
        }
        finally
        {
          Object localObject1;
          localObject7 = localObject1;
          localObject6 = localObject1;
          CloseableKt.closeFinally(localCloseable, (Throwable)localObject8);
          localObject7 = localObject1;
          localObject6 = localObject1;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          Logger.INSTANCE.exception("QAPM_base_ConfigApply", localThrowable1);
          Object localObject2 = localObject6;
          return localObject6;
          localObject7 = localObject2;
          Object localObject6 = localObject2;
          localObject2 = LoadConfigMode.FROM_LOCAL;
          continue;
          localObject6 = localObject2;
        }
      }
      finally
      {
        if (localHttpURLConnection != null) {
          localHttpURLConnection.disconnect();
        }
      }
    }
  }
  
  private final void parseConfig(JSONObject paramJSONObject)
    throws JSONException
  {
    Logger.INSTANCE.i(new String[] { "QAPM_base_ConfigApply", "parseConfig json: " + paramJSONObject });
    Object localObject1;
    label95:
    int k;
    int i;
    label199:
    Object localObject3;
    if (paramJSONObject.getInt("pid") == BaseInfo.userMeta.appId)
    {
      Iterator localIterator = paramJSONObject.keys();
      Intrinsics.checkExpressionValueIsNotNull(localIterator, "json.keys()");
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (localObject1 == null)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
          if (!StringsKt.startsWith$default((String)localObject1, "p_", false, 2, null)) {
            break label329;
          }
          k = Integer.parseInt(StringsKt.replace$default((String)localObject1, "p_", "", false, 4, null));
          localObject1 = paramJSONObject.getString((String)localObject1);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "json.getString(it)");
          localObject1 = (CharSequence)localObject1;
          Object localObject2 = (Iterable)new Regex(",").split((CharSequence)localObject1, 0);
          localObject1 = new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label531;
          }
          localObject3 = ((Iterator)localObject2).next();
          if (i == 0) {
            break label491;
          }
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    label329:
    label491:
    label623:
    for (;;)
    {
      break label199;
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case 3476: 
        if (!((String)localObject1).equals("ma")) {
          break;
        }
        SDKConfig.Companion.setMAX_AUSTERITY_REPORT_NUM(paramJSONObject.getInt((String)localObject1));
        BaseInfo.editor.putInt("config_max_austerity_report_number", SDKConfig.Companion.getMAX_AUSTERITY_REPORT_NUM());
      case 3650: 
      case 116116: 
      case 3477: 
      case 3774: 
        for (;;)
        {
          break;
          if (!((String)localObject1).equals("rt")) {
            break label95;
          }
          SDKConfig.RES_TYPE = paramJSONObject.getInt((String)localObject1);
          BaseInfo.editor.putInt("config_resource_type", SDKConfig.RES_TYPE);
          continue;
          if (!((String)localObject1).equals("usr")) {
            break label95;
          }
          SDKConfig.Companion.setUSER_SAMPLE_RATIO((float)paramJSONObject.getDouble((String)localObject1));
          BaseInfo.editor.putFloat("config_user_sample_ratio", SDKConfig.Companion.getUSER_SAMPLE_RATIO());
          continue;
          if (!((String)localObject1).equals("mb")) {
            break label95;
          }
          SDKConfig.Companion.setMAX_LOOSE_REPORT_NUM(paramJSONObject.getInt((String)localObject1));
          BaseInfo.editor.putInt("config_max_loose_report_number", SDKConfig.Companion.getMAX_LOOSE_REPORT_NUM());
          continue;
          if (!((String)localObject1).equals("vt")) {
            break label95;
          }
          SDKConfig.Companion.setVER_TYPE(paramJSONObject.getInt((String)localObject1));
          BaseInfo.editor.putInt("config_version_type", SDKConfig.Companion.getVER_TYPE());
          continue;
          if (((CharSequence)localObject3).length() == 0) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0) {
              break label623;
            }
            ((ArrayList)localObject1).add(localObject3);
            i = 1;
            break;
          }
          localObject1 = (List)localObject1;
          if (((List)localObject1).size() >= 4) {
            PluginController.INSTANCE.resetPlugin(k, Integer.parseInt((String)((List)localObject1).get(0)), Integer.parseInt((String)((List)localObject1).get(1)), Float.parseFloat((String)((List)localObject1).get(2)), Integer.parseInt((String)((List)localObject1).get(3)));
          }
        }
        BaseInfo.editor.apply();
        return;
      }
    }
  }
  
  public final int getServiceSwitch()
  {
    return this.serviceSwitch;
  }
  
  public final int getUserMode()
  {
    return this.userMode;
  }
  
  public final void loadConfigs(int paramInt)
  {
    PluginController.INSTANCE.resetReportNum();
    for (;;)
    {
      try
      {
        Object localObject = BaseInfo.sharePreference;
        if (localObject == null) {
          break label133;
        }
        localObject = ((SharedPreferences)localObject).getString("config_data", "");
        if (localObject == null) {
          break label133;
        }
        this.configMd5 = ((String)localObject);
        localObject = loadServiceConfigs(paramInt);
        switch (ConfigApply.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        case 1: 
          this.serviceSwitch = 0;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.serviceSwitch = 0;
        Logger.INSTANCE.exception("QAPM_base_ConfigApply", localThrowable);
        return;
      }
      loadLocalConfigs(BaseInfo.userMeta.appId, BaseInfo.userMeta.version);
      return;
      BaseInfo.editor.putString("config_data", this.configMd5).apply();
      return;
      return;
      label133:
      String str = "";
    }
  }
  
  public void request()
  {
    loadConfigs(this.userMode);
  }
  
  public final void setServiceSwitch(int paramInt)
  {
    this.serviceSwitch = paramInt;
  }
  
  public final void setUserMode(int paramInt)
  {
    this.userMode = paramInt;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$Companion;", "", "()V", "STATUS_UPDATE_CONFIG", "", "TAG", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode;", "", "(Ljava/lang/String;I)V", "NO_AUTHORITY", "FROM_LOCAL", "FROM_SERVICE", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static enum LoadConfigMode
  {
    static
    {
      LoadConfigMode localLoadConfigMode1 = new LoadConfigMode("NO_AUTHORITY", 0);
      NO_AUTHORITY = localLoadConfigMode1;
      LoadConfigMode localLoadConfigMode2 = new LoadConfigMode("FROM_LOCAL", 1);
      FROM_LOCAL = localLoadConfigMode2;
      LoadConfigMode localLoadConfigMode3 = new LoadConfigMode("FROM_SERVICE", 2);
      FROM_SERVICE = localLoadConfigMode3;
      $VALUES = new LoadConfigMode[] { localLoadConfigMode1, localLoadConfigMode2, localLoadConfigMode3 };
    }
    
    private LoadConfigMode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.config.ConfigApply
 * JD-Core Version:    0.7.0.1
 */