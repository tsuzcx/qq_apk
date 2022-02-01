package com.tencent.qapmsdk.common.resource;

import android.os.Process;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/ResourceConstant;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ResourceConstant
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  private static final long[] LOCAL_IFACE_HASHES = { "dummy0".hashCode(), "lo".hashCode() };
  @NotNull
  private static final String PID_STATS_PATH = "/proc/" + Process.myPid() + "/stat";
  @NotNull
  public static final String STATS_PATH = "/proc/net/xt_qtaguid/stats";
  @NotNull
  public static final String SYS_STATS_PATH = "/proc/stat";
  private static final long UID = Process.myUid();
  private static final long WLAN0_HASH = "wlan0".hashCode();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/ResourceConstant$Companion;", "", "()V", "LOCAL_IFACE_HASHES", "", "getLOCAL_IFACE_HASHES", "()[J", "PID_STATS_PATH", "", "getPID_STATS_PATH", "()Ljava/lang/String;", "STATS_PATH", "SYS_STATS_PATH", "UID", "", "getUID", "()J", "WLAN0_HASH", "getWLAN0_HASH", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @NotNull
    public final long[] getLOCAL_IFACE_HASHES()
    {
      return ResourceConstant.access$getLOCAL_IFACE_HASHES$cp();
    }
    
    @NotNull
    public final String getPID_STATS_PATH()
    {
      return ResourceConstant.access$getPID_STATS_PATH$cp();
    }
    
    public final long getUID()
    {
      return ResourceConstant.access$getUID$cp();
    }
    
    public final long getWLAN0_HASH()
    {
      return ResourceConstant.access$getWLAN0_HASH$cp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.ResourceConstant
 * JD-Core Version:    0.7.0.1
 */