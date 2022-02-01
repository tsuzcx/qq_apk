package com.tencent.qapmsdk.base.reporter.uploaddata.data;

import com.tencent.qapmsdk.common.reporter.BaseJsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "Lcom/tencent/qapmsdk/common/reporter/BaseJsonObject;", "reportType", "", "eventName", "", "isSucceed", "", "elapse", "", "size", "params", "Lorg/json/JSONObject;", "isRealTime", "isMerge", "uin", "(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZLjava/lang/String;)V", "dbId", "getDbId", "()I", "setDbId", "(I)V", "getElapse", "()J", "setElapse", "(J)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "()Z", "setMerge", "(Z)V", "setRealTime", "setSucceed", "getParams", "()Lorg/json/JSONObject;", "setParams", "(Lorg/json/JSONObject;)V", "getReportType", "setReportType", "getSize", "setSize", "getUin", "setUin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ResultObject
  extends BaseJsonObject
{
  private int dbId;
  private long elapse;
  @NotNull
  private String eventName;
  private boolean isMerge;
  private boolean isRealTime;
  private boolean isSucceed;
  @NotNull
  private JSONObject params;
  private int reportType;
  private long size;
  @NotNull
  private String uin;
  
  public ResultObject()
  {
    this(0, null, false, 0L, 0L, null, false, false, null, 511, null);
  }
  
  public ResultObject(int paramInt, @NotNull String paramString1, boolean paramBoolean1, long paramLong1, long paramLong2, @NotNull JSONObject paramJSONObject, boolean paramBoolean2, boolean paramBoolean3, @NotNull String paramString2)
  {
    this.reportType = paramInt;
    this.eventName = paramString1;
    this.isSucceed = paramBoolean1;
    this.elapse = paramLong1;
    this.size = paramLong2;
    this.params = paramJSONObject;
    this.isRealTime = paramBoolean2;
    this.isMerge = paramBoolean3;
    this.uin = paramString2;
  }
  
  public final int component1()
  {
    return this.reportType;
  }
  
  @NotNull
  public final String component2()
  {
    return this.eventName;
  }
  
  public final boolean component3()
  {
    return this.isSucceed;
  }
  
  public final long component4()
  {
    return this.elapse;
  }
  
  public final long component5()
  {
    return this.size;
  }
  
  @NotNull
  public final JSONObject component6()
  {
    return this.params;
  }
  
  public final boolean component7()
  {
    return this.isRealTime;
  }
  
  public final boolean component8()
  {
    return this.isMerge;
  }
  
  @NotNull
  public final String component9()
  {
    return this.uin;
  }
  
  @NotNull
  public final ResultObject copy(int paramInt, @NotNull String paramString1, boolean paramBoolean1, long paramLong1, long paramLong2, @NotNull JSONObject paramJSONObject, boolean paramBoolean2, boolean paramBoolean3, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "params");
    Intrinsics.checkParameterIsNotNull(paramString2, "uin");
    return new ResultObject(paramInt, paramString1, paramBoolean1, paramLong1, paramLong2, paramJSONObject, paramBoolean2, paramBoolean3, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof ResultObject)) {
        break label198;
      }
      paramObject = (ResultObject)paramObject;
      if (this.reportType != paramObject.reportType) {
        break label200;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label198;
      }
      bool1 = bool2;
      if (!Intrinsics.areEqual(this.eventName, paramObject.eventName)) {
        break label198;
      }
      if (this.isSucceed != paramObject.isSucceed) {
        break label205;
      }
      i = 1;
      label73:
      bool1 = bool2;
      if (i == 0) {
        break label198;
      }
      if (this.elapse != paramObject.elapse) {
        break label210;
      }
      i = 1;
      label94:
      bool1 = bool2;
      if (i == 0) {
        break label198;
      }
      if (this.size != paramObject.size) {
        break label215;
      }
      i = 1;
      label115:
      bool1 = bool2;
      if (i == 0) {
        break label198;
      }
      bool1 = bool2;
      if (!Intrinsics.areEqual(this.params, paramObject.params)) {
        break label198;
      }
      if (this.isRealTime != paramObject.isRealTime) {
        break label220;
      }
      i = 1;
      label152:
      bool1 = bool2;
      if (i == 0) {
        break label198;
      }
      if (this.isMerge != paramObject.isMerge) {
        break label225;
      }
    }
    label198:
    label200:
    label205:
    label210:
    label215:
    label220:
    label225:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (Intrinsics.areEqual(this.uin, paramObject.uin)) {
          bool1 = true;
        }
      }
      return bool1;
      i = 0;
      break;
      i = 0;
      break label73;
      i = 0;
      break label94;
      i = 0;
      break label115;
      i = 0;
      break label152;
    }
  }
  
  public final int getDbId()
  {
    return this.dbId;
  }
  
  public final long getElapse()
  {
    return this.elapse;
  }
  
  @NotNull
  public final String getEventName()
  {
    return this.eventName;
  }
  
  @NotNull
  public final JSONObject getParams()
  {
    return this.params;
  }
  
  public final int getReportType()
  {
    return this.reportType;
  }
  
  public final long getSize()
  {
    return this.size;
  }
  
  @NotNull
  public final String getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isMerge()
  {
    return this.isMerge;
  }
  
  public final boolean isRealTime()
  {
    return this.isRealTime;
  }
  
  public final boolean isSucceed()
  {
    return this.isSucceed;
  }
  
  public final void setDbId(int paramInt)
  {
    this.dbId = paramInt;
  }
  
  public final void setElapse(long paramLong)
  {
    this.elapse = paramLong;
  }
  
  public final void setEventName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.eventName = paramString;
  }
  
  public final void setMerge(boolean paramBoolean)
  {
    this.isMerge = paramBoolean;
  }
  
  public final void setParams(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "<set-?>");
    this.params = paramJSONObject;
  }
  
  public final void setRealTime(boolean paramBoolean)
  {
    this.isRealTime = paramBoolean;
  }
  
  public final void setReportType(int paramInt)
  {
    this.reportType = paramInt;
  }
  
  public final void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public final void setSucceed(boolean paramBoolean)
  {
    this.isSucceed = paramBoolean;
  }
  
  public final void setUin(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.uin = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return "ResultObject(reportType=" + this.reportType + ", eventName=" + this.eventName + ", isSucceed=" + this.isSucceed + ", elapse=" + this.elapse + ", size=" + this.size + ", params=" + this.params + ", isRealTime=" + this.isRealTime + ", isMerge=" + this.isMerge + ", uin=" + this.uin + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject
 * JD-Core Version:    0.7.0.1
 */