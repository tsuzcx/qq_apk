package com.tencent.aekit.api.standard;

import android.content.SharedPreferences;
import com.tencent.ttpic.filter.aifilter.NetworkRequest;

public class AEModuleConfig
{
  private int authMode;
  private boolean debugMode;
  private boolean enableDataReport;
  private boolean enableDefaultBasic3;
  private boolean enableDumpFilterParams;
  private boolean enableProfiler;
  private boolean enableReducedMeidaLibrary;
  private boolean enableResourceCheck;
  private boolean isFramebufferFetchEnable;
  private boolean isLoadSo;
  private String license;
  private int licenseInitType;
  private String lutDir;
  private String modelDir;
  private NetworkRequest networkRequest;
  private SharedPreferences preferences;
  private String soDir;
  private boolean strictMode;
  
  private AEModuleConfig(Builder paramBuilder)
  {
    this.isLoadSo = paramBuilder.isLoadSo;
    this.lutDir = paramBuilder.lutDir;
    this.modelDir = paramBuilder.modelDir;
    this.enableDefaultBasic3 = paramBuilder.enableDefaultBasic3;
    this.soDir = paramBuilder.soDir;
    this.license = paramBuilder.license;
    this.licenseInitType = paramBuilder.licenseInitType;
    this.preferences = paramBuilder.preferences;
    this.isFramebufferFetchEnable = paramBuilder.isFramebufferFetchEnable;
    this.debugMode = paramBuilder.debugMode;
    this.strictMode = paramBuilder.strictMode;
    this.enableResourceCheck = paramBuilder.enableResourceCheck;
    this.enableDataReport = paramBuilder.enableDataReport;
    this.enableProfiler = paramBuilder.enableProfiler;
    this.enableDumpFilterParams = paramBuilder.enableDumpFilterParams;
    this.enableReducedMeidaLibrary = paramBuilder.enableReducedMeidaLibrary;
    this.networkRequest = paramBuilder.networkRequest;
    this.authMode = paramBuilder.authMode;
  }
  
  public static Builder newBuilder()
  {
    return new Builder();
  }
  
  public int getAuthMode()
  {
    return this.authMode;
  }
  
  public boolean getIsLoadSo()
  {
    return this.isLoadSo;
  }
  
  public String getLicense()
  {
    return this.license;
  }
  
  public int getLicenseInitType()
  {
    return this.licenseInitType;
  }
  
  public String getLutDir()
  {
    return this.lutDir;
  }
  
  public String getModelDir()
  {
    return this.modelDir;
  }
  
  public NetworkRequest getNetworkRequest()
  {
    return this.networkRequest;
  }
  
  public SharedPreferences getPreferences()
  {
    return this.preferences;
  }
  
  public String getSoDir()
  {
    return this.soDir;
  }
  
  public boolean isDebugMode()
  {
    return this.debugMode;
  }
  
  public boolean isEnableDataReport()
  {
    return this.enableDataReport;
  }
  
  public boolean isEnableDefaultBasic3()
  {
    return this.enableDefaultBasic3;
  }
  
  public boolean isEnableDumpFilterParams()
  {
    return this.enableDumpFilterParams;
  }
  
  public boolean isEnableProfiler()
  {
    return this.enableProfiler;
  }
  
  public boolean isEnableReducedMeidaLibrary()
  {
    return this.enableReducedMeidaLibrary;
  }
  
  public boolean isEnableResourceCheck()
  {
    return this.enableResourceCheck;
  }
  
  public boolean isFramebufferFetchEnable()
  {
    return this.isFramebufferFetchEnable;
  }
  
  public boolean isStrictMode()
  {
    return this.strictMode;
  }
  
  public static class Builder
  {
    private int authMode;
    private boolean debugMode;
    private boolean enableDataReport = true;
    private boolean enableDefaultBasic3 = true;
    private boolean enableDumpFilterParams = false;
    private boolean enableProfiler = false;
    private boolean enableReducedMeidaLibrary = false;
    private boolean enableResourceCheck;
    private boolean isFramebufferFetchEnable = true;
    private boolean isLoadSo = true;
    private String license;
    private int licenseInitType;
    private String lutDir;
    private String modelDir;
    private NetworkRequest networkRequest;
    private SharedPreferences preferences;
    private String soDir;
    private boolean strictMode;
    
    public AEModuleConfig build()
    {
      return new AEModuleConfig(this, null);
    }
    
    public Builder setAuthMode(int paramInt)
    {
      this.authMode = paramInt;
      return this;
    }
    
    public Builder setEnableDataReport(boolean paramBoolean)
    {
      this.enableDataReport = paramBoolean;
      return this;
    }
    
    public Builder setEnableDebug(boolean paramBoolean)
    {
      this.debugMode = paramBoolean;
      return this;
    }
    
    public Builder setEnableDefaultBasic3(boolean paramBoolean)
    {
      this.enableDefaultBasic3 = paramBoolean;
      return this;
    }
    
    public Builder setEnableDumpFilterParams(boolean paramBoolean)
    {
      this.enableDumpFilterParams = paramBoolean;
      return this;
    }
    
    public Builder setEnableProfiler(boolean paramBoolean)
    {
      this.enableProfiler = paramBoolean;
      return this;
    }
    
    public Builder setEnableReducedMeidaLibrary(boolean paramBoolean)
    {
      this.enableReducedMeidaLibrary = paramBoolean;
      return this;
    }
    
    public Builder setEnableResourceCheck(boolean paramBoolean)
    {
      this.enableResourceCheck = paramBoolean;
      return this;
    }
    
    public Builder setEnableStrcitMode(boolean paramBoolean)
    {
      this.strictMode = paramBoolean;
      return this;
    }
    
    public Builder setFramebufferFetchEnable(boolean paramBoolean)
    {
      this.isFramebufferFetchEnable = paramBoolean;
      return this;
    }
    
    public Builder setLicense(String paramString)
    {
      return setLicense(paramString, 0);
    }
    
    public Builder setLicense(String paramString, int paramInt)
    {
      this.license = paramString;
      this.licenseInitType = paramInt;
      return this;
    }
    
    public Builder setLoadSo(boolean paramBoolean)
    {
      this.isLoadSo = paramBoolean;
      return this;
    }
    
    public Builder setLutDir(String paramString)
    {
      this.lutDir = paramString;
      return this;
    }
    
    public Builder setModelDir(String paramString)
    {
      this.modelDir = paramString;
      return this;
    }
    
    public Builder setNetworkRequest(NetworkRequest paramNetworkRequest)
    {
      this.networkRequest = paramNetworkRequest;
      return this;
    }
    
    public Builder setPreferences(SharedPreferences paramSharedPreferences)
    {
      this.preferences = paramSharedPreferences;
      return this;
    }
    
    public Builder setSoDir(String paramString)
    {
      this.soDir = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModuleConfig
 * JD-Core Version:    0.7.0.1
 */