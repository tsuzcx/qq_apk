package com.tencent.qapmsdk.base.statistics;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.table.StatisticsTable;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.proxy.QAPMUploadProxy;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.json.JsonDispose;
import com.tencent.qapmsdk.common.json.JsonDispose.Companion;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.reporter.BaseJsonObject;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import com.tencent.qapmsdk.common.util.TimeUtil;
import com.tencent.qapmsdk.common.util.TimeUtil.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/statistics/ErrorStatistics;", "", "()V", "TAG", "", "addLost", "", "plugin", "", "returnCode", "errorCode", "category", "doReport", "getLostData", "Lorg/json/JSONObject;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ErrorStatistics
{
  public static final ErrorStatistics INSTANCE = new ErrorStatistics();
  private static final String TAG = "QAPM_base_ErrorStatistics";
  
  private final JSONObject getLostData()
  {
    Object localObject1 = new StatisticsTable(BaseInfo.userMeta.appId);
    Object localObject2 = BaseInfo.dbHelper;
    if (localObject2 != null)
    {
      localObject2 = ((DBHelper)localObject2).getDbHandler();
      if (localObject2 != null)
      {
        localObject1 = ((DBHandler)localObject2).search((BaseTable)localObject1, (Function0)ErrorStatistics.getLostData.params.1.INSTANCE);
        localObject2 = localObject1;
        if (!(localObject1 instanceof JSONObject)) {
          localObject2 = null;
        }
        localObject1 = (JSONObject)localObject2;
        if (localObject1 == null) {
          break label87;
        }
        if (!((JSONObject)localObject1).has("parts")) {
          break label82;
        }
      }
    }
    for (;;)
    {
      return localObject1;
      localObject1 = null;
      break;
      label82:
      localObject1 = null;
    }
    label87:
    return null;
  }
  
  public final void addLost(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "returnCode");
    Intrinsics.checkParameterIsNotNull(paramString2, "errorCode");
    Intrinsics.checkParameterIsNotNull(paramString3, "category");
    Logger.INSTANCE.w(new String[] { "QAPM_base_ErrorStatistics", paramString3 + " report may be error, plugin : " + paramInt + ", returnCode : " + paramString1 + ", errorCode : " + paramString2 });
    paramString1 = new StatisticsTable(BaseInfo.userMeta.appId, paramInt, paramString1, paramString2, paramString3, TimeUtil.Companion.getFormatDateByZone());
    paramString2 = BaseInfo.dbHelper;
    if (paramString2 != null)
    {
      paramString2 = paramString2.getDbHandler();
      if (paramString2 != null) {
        paramString2.insert((BaseTable)paramString1, (Function0)ErrorStatistics.addLost.1.INSTANCE);
      }
    }
  }
  
  public final void doReport()
  {
    JSONObject localJSONObject = getLostData();
    if (localJSONObject != null)
    {
      localJSONObject.put("plugin", PluginCombination.statisticsPlugin.plugin);
      ResultObject localResultObject = new ResultObject(0, "Error", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
      localResultObject.setParams(JsonDispose.Companion.copyJson(BaseInfo.pubJson, localJSONObject));
      new QAPMUploadProxy().report((BaseJsonObject)localResultObject, (IReporter.ReportResultCallback)new ErrorStatistics.doReport.1.1());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.statistics.ErrorStatistics
 * JD-Core Version:    0.7.0.1
 */