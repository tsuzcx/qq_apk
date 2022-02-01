package com.tencent.moai.mailsdk.protocol.activesync;

import com.tencent.moai.mailsdk.protocol.activesync.model.DeviceInfo;

public class DeviceInfoHandler
{
  private static DeviceInfoHandler instance = new DeviceInfoHandler();
  private DeviceInfo deviceInfo;
  
  public static DeviceInfoHandler getInstance()
  {
    return instance;
  }
  
  public DeviceInfo getDeviceInfo()
  {
    return this.deviceInfo;
  }
  
  public void initDeviceInfo(DeviceInfo paramDeviceInfo)
  {
    this.deviceInfo = paramDeviceInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.DeviceInfoHandler
 * JD-Core Version:    0.7.0.1
 */