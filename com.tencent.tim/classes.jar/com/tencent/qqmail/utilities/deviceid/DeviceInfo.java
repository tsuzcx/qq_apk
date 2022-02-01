package com.tencent.qqmail.utilities.deviceid;

public class DeviceInfo
{
  public String BOARD;
  public String BOOTLOADER;
  public String BRAND;
  public String CPU_ABI;
  public String CPU_ABI2;
  public String DEVICE;
  public String DEVICE_ID;
  public String DISPLAY;
  public String FINGERPRINT;
  public String HARDWARE;
  public String HOST;
  public String ID;
  public String IMEI;
  public String IS_DEBUGGABLE;
  public String MANUFACTURER;
  public String MODEL;
  public String PHONE_NUMBER;
  public String PRODUCT;
  public String RADIO;
  public String SERIAL;
  public String TAGS;
  public String TIME;
  public String TYPE;
  public String USER;
  public String releaseVersion;
  public String sdkIntVersion;
  public String userAgent;
  
  public String toString()
  {
    return "DeviceInfo [BRAND=" + this.BRAND + ", TYPE=" + this.TYPE + ", sdkIntVersion=" + this.sdkIntVersion + ", TIME=" + this.TIME + ", FINGERPRINT=" + this.FINGERPRINT + ", USER=" + this.USER + ", DEVICE=" + this.DEVICE + ", MODEL=" + this.MODEL + ", SERIAL=" + this.SERIAL + ", PHONE_NUMBER=" + this.PHONE_NUMBER + ", DISPLAY=" + this.DISPLAY + ", PRODUCT=" + this.PRODUCT + ", BOARD=" + this.BOARD + ", BOOTLOADER=" + this.BOOTLOADER + ", HARDWARE=" + this.HARDWARE + ", RADIO=" + this.RADIO + ", TAGS=" + this.TAGS + ", ID=" + this.ID + ", MANUFACTURER=" + this.MANUFACTURER + ", IMEI=" + this.IMEI + ", CPU_ABI=" + this.CPU_ABI + ", CPU_ABI2=" + this.CPU_ABI2 + ", IS_DEBUGGABLE=" + this.IS_DEBUGGABLE + ", releaseVersion=" + this.releaseVersion + ", userAgent=" + this.userAgent + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.deviceid.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */