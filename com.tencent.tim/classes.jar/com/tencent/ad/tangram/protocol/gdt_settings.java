package com.tencent.ad.tangram.protocol;

public final class gdt_settings
{
  public static final class Settings
  {
    public int intervalMillis = 0;
    public SettingsForAnalysis settingsForAnalysis = new SettingsForAnalysis();
    public SettingsForExposure settingsForExposure = new SettingsForExposure();
    public SettingsForIMEI settingsForIMEI = new SettingsForIMEI();
    public SettingsForInterstitial settingsForInterstitial = new SettingsForInterstitial();
    public SettingsForSdkMsg settingsForSdkMsg = new SettingsForSdkMsg();
    public SettingsForXJ settingsForXJ = new SettingsForXJ();
    public String timeExpiredMillis;
    public String urlForSettings;
    public int version = 0;
    
    public static final class SettingsForAnalysis
    {
      public static final int DB_ONLY = 2;
      public static final int DEFAULT = 1;
      public static final int SHUTDOWN = 3;
      public gdt_abtest.ABTest abTest = new gdt_abtest.ABTest();
      public Batch batch = new Batch();
      public int mode = 1;
      public String urlForReport;
      
      public static final class Batch
      {
        public int intervalMillis = 0;
        public int intervalMillisMax = 0;
        public int limit = 0;
      }
    }
    
    public static final class SettingsForExposure
    {
      public long durationMillis = 0L;
    }
    
    public static final class SettingsForIMEI
    {
      public Item[] items;
      
      public static final class Item
      {
        public int androidSDK = 0;
        public int phoneType = 0;
      }
    }
    
    public static final class SettingsForInterstitial
    {
      public gdt_abtest.ABTest abTestForProcess = new gdt_abtest.ABTest();
      public boolean enablePreDownload = false;
      public int timeoutMillis = 0;
    }
    
    public static final class SettingsForSdkMsg
    {
      public String key;
    }
    
    public static final class SettingsForXJ
    {
      public boolean canvas = false;
      public boolean enableOfflineReportForTianQin = false;
      public boolean offline = false;
      public int queueLength = -2147483648;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.protocol.gdt_settings
 * JD-Core Version:    0.7.0.1
 */