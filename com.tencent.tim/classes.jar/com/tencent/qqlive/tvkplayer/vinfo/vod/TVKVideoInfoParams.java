package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKVideoInfoParams
{
  private String appVer;
  private Map<String, String> ckeyExtraParamsMap;
  private int dlType;
  private int drm;
  private int encryptVer;
  private Map<String, String> extraParamsMap;
  private String format;
  private String guid;
  private int ipstack;
  private int isCharge;
  private String loginCookie;
  private String loginQQ;
  private int networkType;
  private OpenApiParam openApiParam;
  private int platForm;
  private int playerCapacity;
  private int requestType;
  private String sdtFrom;
  private String uin;
  private String upc;
  private String vid;
  private String wxOpenId;
  
  public TVKVideoInfoParams(TVKVInfoRequestParasBuilder paramTVKVInfoRequestParasBuilder)
  {
    this.vid = paramTVKVInfoRequestParasBuilder.vid;
    this.uin = paramTVKVInfoRequestParasBuilder.uin;
    this.ipstack = paramTVKVInfoRequestParasBuilder.ipstack;
    this.dlType = paramTVKVInfoRequestParasBuilder.dlType;
    this.isCharge = paramTVKVInfoRequestParasBuilder.isCharge;
    this.drm = paramTVKVInfoRequestParasBuilder.drm;
    this.ckeyExtraParamsMap = paramTVKVInfoRequestParasBuilder.ckeyExtraParamsMap;
    this.extraParamsMap = paramTVKVInfoRequestParasBuilder.extraParamsMap;
    this.openApiParam = paramTVKVInfoRequestParasBuilder.openApiParam;
    this.format = paramTVKVInfoRequestParasBuilder.format;
    this.loginCookie = paramTVKVInfoRequestParasBuilder.loginCookie;
    this.sdtFrom = paramTVKVInfoRequestParasBuilder.sdtFrom;
    this.requestType = paramTVKVInfoRequestParasBuilder.requestType;
    this.upc = paramTVKVInfoRequestParasBuilder.upc;
    this.platForm = paramTVKVInfoRequestParasBuilder.platForm;
    this.playerCapacity = paramTVKVInfoRequestParasBuilder.playerCapacity;
    this.appVer = paramTVKVInfoRequestParasBuilder.appVer;
    this.encryptVer = paramTVKVInfoRequestParasBuilder.encryptVer;
    this.networkType = paramTVKVInfoRequestParasBuilder.networkType;
    this.wxOpenId = paramTVKVInfoRequestParasBuilder.wxOpenId;
    this.loginQQ = paramTVKVInfoRequestParasBuilder.loginQQ;
    this.guid = paramTVKVInfoRequestParasBuilder.guid;
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
  
  public int getEncryptVer()
  {
    return this.encryptVer;
  }
  
  public Map<String, String> getExtraParamsMap()
  {
    return this.extraParamsMap;
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
  
  public String getLoginQQ()
  {
    return this.loginQQ;
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
  
  public static class TVKVInfoRequestParasBuilder
  {
    private String appVer;
    private Map<String, String> ckeyExtraParamsMap;
    private int dlType;
    private int drm;
    private int encryptVer;
    private Map<String, String> extraParamsMap;
    private String format;
    private String guid;
    private int ipstack;
    private int isCharge;
    private String loginCookie;
    private String loginQQ;
    private int networkType;
    private TVKVideoInfoParams.OpenApiParam openApiParam;
    private int platForm;
    private int playerCapacity;
    private int requestType;
    private String sdtFrom;
    private String uin;
    private String upc;
    private final String vid;
    private String wxOpenId;
    
    public TVKVInfoRequestParasBuilder(String paramString)
    {
      this.vid = paramString;
    }
    
    public TVKVInfoRequestParasBuilder appVer(String paramString)
    {
      this.appVer = paramString;
      return this;
    }
    
    public TVKVideoInfoParams build()
    {
      return new TVKVideoInfoParams(this);
    }
    
    public TVKVInfoRequestParasBuilder ckeyExtraParamsMap(Map<String, String> paramMap)
    {
      this.ckeyExtraParamsMap = paramMap;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder dlType(int paramInt)
    {
      this.dlType = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder drm(int paramInt)
    {
      this.drm = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder encryptVer(int paramInt)
    {
      this.encryptVer = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder extraParamsMap(Map<String, String> paramMap)
    {
      this.extraParamsMap = paramMap;
      if ((this.extraParamsMap != null) && (this.extraParamsMap.containsKey("cookie")))
      {
        this.loginCookie = ((String)this.extraParamsMap.get("cookie"));
        this.extraParamsMap.remove("cookie");
      }
      return this;
    }
    
    public TVKVInfoRequestParasBuilder format(String paramString)
    {
      this.format = paramString;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder guid(String paramString)
    {
      this.guid = paramString;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder ipstack(int paramInt)
    {
      this.ipstack = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder isCharge(int paramInt)
    {
      this.isCharge = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder loginCookie(String paramString)
    {
      this.loginCookie = paramString;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder loginQQ(String paramString)
    {
      this.loginQQ = paramString;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder networkType(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder openApiParam(TVKVideoInfoParams.OpenApiParam paramOpenApiParam)
    {
      this.openApiParam = paramOpenApiParam;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder platForm(int paramInt)
    {
      this.platForm = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder playerCapacity(int paramInt)
    {
      this.playerCapacity = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder requestType(int paramInt)
    {
      this.requestType = paramInt;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder sdtFrom(String paramString)
    {
      this.sdtFrom = paramString;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder uin(String paramString)
    {
      this.uin = paramString;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder upc(String paramString)
    {
      this.upc = paramString;
      return this;
    }
    
    public TVKVInfoRequestParasBuilder wxOpenId(String paramString)
    {
      this.wxOpenId = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoParams
 * JD-Core Version:    0.7.0.1
 */