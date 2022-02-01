package com.tencent.qapmsdk.battery.config;

public class BatteryConfig
{
  public CmdMeta cmdConfig;
  public CpuMeta cpuConfig;
  public GPSMeta gpsConfig;
  public LogMeta logConfig;
  public long monitorEndTime;
  public boolean reportfile;
  public TrafficMeta trafficConfig;
  public WakeLockMeta wakeLockConfig;
  public WifiMeta wifiConfig;
  
  public BatteryConfig(boolean paramBoolean, long paramLong)
  {
    this.reportfile = paramBoolean;
    this.monitorEndTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.config.BatteryConfig
 * JD-Core Version:    0.7.0.1
 */