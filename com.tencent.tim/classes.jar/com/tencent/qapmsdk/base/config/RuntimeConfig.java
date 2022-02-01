package com.tencent.qapmsdk.base.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/RuntimeConfig;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class RuntimeConfig
{
  public static final Companion Companion = new Companion(null);
  @JvmField
  public static volatile int globalMonitorCount;
  @JvmField
  public static volatile boolean resourceMonitorPublicMode;
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/RuntimeConfig$Companion;", "", "()V", "globalMonitorCount", "", "resourceMonitorPublicMode", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.RuntimeConfig
 * JD-Core Version:    0.7.0.1
 */