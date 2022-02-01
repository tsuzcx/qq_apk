package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKCGIVInfoRequestParams
{
  private String appVer;
  private Map<String, String> ckeyExtraParamsMap;
  private int dlType;
  private int drm;
  private int encryptVer;
  private Map<String, String> extraParamsMap;
  private String fd;
  private String format;
  private String guid;
  private int ipstack;
  private int isCharge;
  private String loginCookie;
  private int networkType;
  private OpenApiParam openApiParam;
  private int platForm;
  private int playerCapacity;
  private String requestID;
  private int requestType;
  private String sdtFrom;
  private String uin;
  private String upc;
  private boolean useIpV6Dns;
  private String vid;
  private String wxOpenId;
  
  public TVKCGIVInfoRequestParams(TVKCGIVInfoRequestParasBuilder paramTVKCGIVInfoRequestParasBuilder)
  {
    this.vid = paramTVKCGIVInfoRequestParasBuilder.vid;
    this.uin = paramTVKCGIVInfoRequestParasBuilder.uin;
    this.ipstack = paramTVKCGIVInfoRequestParasBuilder.ipstack;
    this.dlType = paramTVKCGIVInfoRequestParasBuilder.dlType;
    this.isCharge = paramTVKCGIVInfoRequestParasBuilder.isCharge;
    this.drm = paramTVKCGIVInfoRequestParasBuilder.drm;
    this.ckeyExtraParamsMap = paramTVKCGIVInfoRequestParasBuilder.ckeyExtraParamsMap;
    this.extraParamsMap = paramTVKCGIVInfoRequestParasBuilder.extraParamsMap;
    this.openApiParam = paramTVKCGIVInfoRequestParasBuilder.openApiParam;
    this.format = paramTVKCGIVInfoRequestParasBuilder.format;
    this.loginCookie = paramTVKCGIVInfoRequestParasBuilder.loginCookie;
    this.platForm = paramTVKCGIVInfoRequestParasBuilder.platForm;
    this.sdtFrom = paramTVKCGIVInfoRequestParasBuilder.sdtFrom;
    this.fd = paramTVKCGIVInfoRequestParasBuilder.fd;
    this.requestType = paramTVKCGIVInfoRequestParasBuilder.requestType;
    this.requestID = paramTVKCGIVInfoRequestParasBuilder.requestID;
    this.playerCapacity = paramTVKCGIVInfoRequestParasBuilder.playerCapacity;
    this.upc = paramTVKCGIVInfoRequestParasBuilder.upc;
    this.appVer = paramTVKCGIVInfoRequestParasBuilder.appVer;
    this.encryptVer = paramTVKCGIVInfoRequestParasBuilder.encryptVer;
    this.networkType = paramTVKCGIVInfoRequestParasBuilder.networkType;
    this.wxOpenId = paramTVKCGIVInfoRequestParasBuilder.wxOpenId;
    this.guid = paramTVKCGIVInfoRequestParasBuilder.guid;
    this.useIpV6Dns = paramTVKCGIVInfoRequestParasBuilder.useIpV6Dns;
  }
  
  public String getAppVer()
  {
    return this.appVer;
  }
  
  public Map<String, String> getCkeyExtraParamsMap()
  {
    return this.ckeyExtraParamsMap;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public int getDrm()
  {
    return this.drm;
  }
  
  public int getEncrypVer()
  {
    return this.encryptVer;
  }
  
  public Map<String, String> getExtraParamsMap()
  {
    return this.extraParamsMap;
  }
  
  public String getFd()
  {
    return this.fd;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public String getLoginCookie()
  {
    return this.loginCookie;
  }
  
  public int getNetworkType()
  {
    return this.networkType;
  }
  
  public OpenApiParam getOpenApiParam()
  {
    return this.openApiParam;
  }
  
  public int getPlatForm()
  {
    return this.platForm;
  }
  
  public int getPlayerCapacity()
  {
    return this.playerCapacity;
  }
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public int getRequestType()
  {
    return this.requestType;
  }
  
  public String getSdtFrom()
  {
    return this.sdtFrom;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public String getUpc()
  {
    return this.upc;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public String getWxOpenId()
  {
    return this.wxOpenId;
  }
  
  public int getipstack()
  {
    return this.ipstack;
  }
  
  public int isCharge()
  {
    return this.isCharge;
  }
  
  public boolean useIpV6Dns()
  {
    return this.useIpV6Dns;
  }
  
  public static class OpenApiParam
  {
    private String accessToken;
    private String oauthConsumerKey;
    private String openId;
    private String pf;
    
    public OpenApiParam(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.openId = paramString1;
      this.accessToken = paramString2;
      this.oauthConsumerKey = paramString3;
      this.pf = paramString4;
    }
    
    public String getAccessToken()
    {
      return this.accessToken;
    }
    
    public String getOauthConsumeKey()
    {
      return this.oauthConsumerKey;
    }
    
    public String getOpenId()
    {
      return this.openId;
    }
    
    public String getPf()
    {
      return this.pf;
    }
  }
  
  public static class TVKCGIVInfoRequestParasBuilder
  {
    private String appVer;
    private Map<String, String> ckeyExtraParamsMap;
    private int dlType;
    private int drm;
    private int encryptVer;
    private Map<String, String> extraParamsMap;
    private String fd;
    private String format;
    private String guid;
    private int ipstack;
    private int isCharge;
    private String loginCookie;
    private int networkType;
    private TVKCGIVInfoRequestParams.OpenApiParam openApiParam;
    private int platForm;
    private int playerCapacity;
    private String requestID;
    private int requestType;
    private String sdtFrom;
    private String uin;
    private String upc;
    private boolean useIpV6Dns;
    private final String vid;
    private String wxOpenId;
    
    public TVKCGIVInfoRequestParasBuilder(String paramString)
    {
      this.vid = paramString;
    }
    
    public TVKCGIVInfoRequestParasBuilder appVer(String paramString)
    {
      this.appVer = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParams build()
    {
      return new TVKCGIVInfoRequestParams(this);
    }
    
    public TVKCGIVInfoRequestParasBuilder builder(boolean paramBoolean)
    {
      this.useIpV6Dns = paramBoolean;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder ckeyExtraParamsMap(Map<String, String> paramMap)
    {
      this.ckeyExtraParamsMap = paramMap;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder dlType(int paramInt)
    {
      this.dlType = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder drm(int paramInt)
    {
      this.drm = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder encryptVer(int paramInt)
    {
      this.encryptVer = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder extraParamsMap(Map<String, String> paramMap)
    {
      this.extraParamsMap = paramMap;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder fd(String paramString)
    {
      this.fd = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder format(String paramString)
    {
      this.format = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder guid(String paramString)
    {
      this.guid = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder ipstack(int paramInt)
    {
      this.ipstack = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder isCharge(int paramInt)
    {
      this.isCharge = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder loginCookie(String paramString)
    {
      this.loginCookie = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder networkType(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder openApiParam(TVKCGIVInfoRequestParams.OpenApiParam paramOpenApiParam)
    {
      this.openApiParam = paramOpenApiParam;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder platForm(int paramInt)
    {
      this.platForm = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder playerCapacity(int paramInt)
    {
      this.playerCapacity = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder requestID(String paramString)
    {
      this.requestID = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder requestType(int paramInt)
    {
      this.requestType = paramInt;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder sdtFrom(String paramString)
    {
      this.sdtFrom = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder uin(String paramString)
    {
      this.uin = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder upc(String paramString)
    {
      this.upc = paramString;
      return this;
    }
    
    public TVKCGIVInfoRequestParasBuilder wxOpenId(String paramString)
    {
      this.wxOpenId = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequestParams
 * JD-Core Version:    0.7.0.1
 */