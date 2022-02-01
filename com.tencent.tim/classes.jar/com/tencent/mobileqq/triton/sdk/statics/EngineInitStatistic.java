package com.tencent.mobileqq.triton.sdk.statics;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

public class EngineInitStatistic
{
  public final long createEGLContextTimeMs;
  @NonNull
  public final List<ScriptLoadStatics> engineScriptLoadStatics;
  public final int errorCode;
  public final long loadEngineScriptTimeMs;
  public final long loadNativeLibraryTimeMs;
  @NonNull
  public final List<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics;
  public final boolean success;
  public final long totalInitTimesMs;
  
  public EngineInitStatistic(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, @NonNull List<ScriptLoadStatics> paramList, @NonNull List<NativeLibraryLoadStatistic> paramList1)
  {
    this.success = paramBoolean;
    this.errorCode = paramInt;
    this.loadNativeLibraryTimeMs = paramLong1;
    this.loadEngineScriptTimeMs = paramLong2;
    this.createEGLContextTimeMs = paramLong3;
    this.totalInitTimesMs = paramLong4;
    this.engineScriptLoadStatics = Collections.unmodifiableList(paramList);
    this.nativeLibraryLoadStatistics = paramList1;
  }
  
  public String toString()
  {
    return "EngineInitStatistic{success=" + this.success + ", errorCode=" + this.errorCode + ", loadNativeLibraryTimeMs=" + this.loadNativeLibraryTimeMs + ", loadEngineScriptTimeMs=" + this.loadEngineScriptTimeMs + ", createEGLContextTimeMs=" + this.createEGLContextTimeMs + ", totalInitTimesMs=" + this.totalInitTimesMs + ", engineScriptLoadStatics=" + this.engineScriptLoadStatics + ", nativeLibraryLoadStatistics=" + this.nativeLibraryLoadStatistics + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.statics.EngineInitStatistic
 * JD-Core Version:    0.7.0.1
 */