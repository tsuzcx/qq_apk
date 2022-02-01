package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKCGIVKeyRequestParams
{
  private String appVer;
  private Map<String, String> ckeyExtraParamsMap;
  private int dlType;
  private int encryptVer;
  private int endClipNo;
  private Map<String, String> extraParamsMap;
  private String fd;
  private String fileName;
  private String format;
  private int formatId;
  private String guid;
  private int isCharge;
  private boolean isDrm;
  private String lnk;
  private String loginCookie;
  private String loginQQ;
  private int networkType;
  private OpenApiParam openApiParam;
  private int platForm;
  private String requestID;
  private int requestType;
  private int requestUrlTargetType;
  private String sdtFrom;
  private int startClipNo;
  private int taskID;
  private String uin;
  private String upc;
  private String upcPaths;
  private String upcSPIPs;
  private String upcSPPORTs;
  private boolean useIpV6Dns;
  private String vid;
  private int vkeyType;
  private String vt;
  private String wxOpenId;
  
  public TVKCGIVKeyRequestParams(VKeyRequestParasBuilder paramVKeyRequestParasBuilder)
  {
    this.vid = paramVKeyRequestParasBuilder.vid;
    this.uin = paramVKeyRequestParasBuilder.uin;
    this.dlType = paramVKeyRequestParasBuilder.dlType;
    this.isCharge = paramVKeyRequestParasBuilder.isCharge;
    this.isDrm = paramVKeyRequestParasBuilder.isDrm;
    this.ckeyExtraParamsMap = paramVKeyRequestParasBuilder.ckeyExtraParamsMap;
    this.extraParamsMap = paramVKeyRequestParasBuilder.extraParamsMap;
    this.openApiParam = paramVKeyRequestParasBuilder.openApiParam;
    this.upc = paramVKeyRequestParasBuilder.upc;
    this.upcPaths = paramVKeyRequestParasBuilder.upcPaths;
    this.upcSPIPs = paramVKeyRequestParasBuilder.upcSPIPs;
    this.upcSPPORTs = paramVKeyRequestParasBuilder.upcSPPORTs;
    this.format = paramVKeyRequestParasBuilder.format;
    this.loginCookie = paramVKeyRequestParasBuilder.loginCookie;
    this.requestUrlTargetType = paramVKeyRequestParasBuilder.requestUrlTargetType;
    this.fileName = paramVKeyRequestParasBuilder.fileName;
    this.formatId = paramVKeyRequestParasBuilder.formatId;
    this.vt = paramVKeyRequestParasBuilder.vt;
    this.startClipNo = paramVKeyRequestParasBuilder.startClipNo;
    this.endClipNo = paramVKeyRequestParasBuilder.endClipNo;
    this.requestType = paramVKeyRequestParasBuilder.requestType;
    this.vkeyType = paramVKeyRequestParasBuilder.vkeyType;
    this.sdtFrom = paramVKeyRequestParasBuilder.sdtFrom;
    this.fd = paramVKeyRequestParasBuilder.fd;
    this.requestID = paramVKeyRequestParasBuilder.requestID;
    this.lnk = paramVKeyRequestParasBuilder.lnk;
    this.taskID = paramVKeyRequestParasBuilder.taskID;
    this.platForm = paramVKeyRequestParasBuilder.platForm;
    this.appVer = paramVKeyRequestParasBuilder.appVer;
    this.networkType = paramVKeyRequestParasBuilder.networkType;
    this.encryptVer = paramVKeyRequestParasBuilder.encryptVer;
    this.loginQQ = paramVKeyRequestParasBuilder.loginQQ;
    this.wxOpenId = paramVKeyRequestParasBuilder.wxOpenId;
    this.guid = paramVKeyRequestParasBuilder.guid;
    this.useIpV6Dns = paramVKeyRequestParasBuilder.useIpV6Dns;
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
  
  public int getDltype()
  {
    return this.dlType;
  }
  
  public int getEncryptVer()
  {
    return this.encryptVer;
  }
  
  public int getEndClipNo()
  {
    return this.endClipNo;
  }
  
  public Map<String, String> getExtraParamsMap()
  {
    return this.extraParamsMap;
  }
  
  public String getFd()
  {
    return this.fd;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public int getFormatId()
  {
    return this.formatId;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public String getLnk()
  {
    return this.lnk;
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
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public int getRequestType()
  {
    return this.requestType;
  }
  
  public int getRequestUrlTargetType()
  {
    return this.requestUrlTargetType;
  }
  
  public String getSdtFrom()
  {
    return this.sdtFrom;
  }
  
  public int getStartClipNo()
  {
    return this.startClipNo;
  }
  
  public int getTaskID()
  {
    return this.taskID;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public String getUpc()
  {
    return this.upc;
  }
  
  public String getUpcPaths()
  {
    return this.upcPaths;
  }
  
  public String getUpcSPIPs()
  {
    return this.upcSPIPs;
  }
  
  public String getUpcSPPORTs()
  {
    return this.upcSPPORTs;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public int getVkeyType()
  {
    return this.vkeyType;
  }
  
  public String getVt()
  {
    return this.vt;
  }
  
  public String getWxOpenId()
  {
    return this.wxOpenId;
  }
  
  public int isCharge()
  {
    return this.isCharge;
  }
  
  public boolean isDrm()
  {
    return this.isDrm;
  }
  
  public boolean isUseIpV6Dns()
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
  
  public static class VKeyRequestParasBuilder
  {
    private String appVer;
    private Map<String, String> ckeyExtraParamsMap;
    private int dlType;
    private int encryptVer;
    private int endClipNo;
    private Map<String, String> extraParamsMap;
    private String fd;
    private String fileName;
    private String format;
    private int formatId;
    private String guid;
    private int isCharge;
    private boolean isDrm;
    private String lnk;
    private String loginCookie;
    private String loginQQ;
    private int networkType;
    private TVKCGIVKeyRequestParams.OpenApiParam openApiParam;
    private int platForm;
    private String requestID;
    private int requestType;
    private int requestUrlTargetType;
    private String sdtFrom;
    private int startClipNo;
    private int taskID;
    private String uin;
    private String upc;
    private String upcPaths;
    private String upcSPIPs;
    private String upcSPPORTs;
    private boolean useIpV6Dns;
    private String vid;
    private int vkeyType;
    private String vt;
    private String wxOpenId;
    
    public VKeyRequestParasBuilder(String paramString)
    {
      this.vid = paramString;
    }
    
    public VKeyRequestParasBuilder appVer(String paramString)
    {
      this.appVer = paramString;
      return this;
    }
    
    public TVKCGIVKeyRequestParams build()
    {
      return new TVKCGIVKeyRequestParams(this);
    }
    
    public VKeyRequestParasBuilder ckeyExtraParamsMap(Map<String, String> paramMap)
    {
      this.ckeyExtraParamsMap = paramMap;
      return this;
    }
    
    public VKeyRequestParasBuilder dlType(int paramInt)
    {
      this.dlType = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder encryptVer(int paramInt)
    {
      this.encryptVer = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder endClipNo(int paramInt)
    {
      this.endClipNo = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder extraParamsMap(Map<String, String> paramMap)
    {
      this.extraParamsMap = paramMap;
      return this;
    }
    
    public VKeyRequestParasBuilder fd(String paramString)
    {
      this.fd = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder fileName(String paramString)
    {
      this.fileName = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder format(String paramString)
    {
      this.format = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder formatId(int paramInt)
    {
      this.formatId = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder guid(String paramString)
    {
      this.guid = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder isCharge(int paramInt)
    {
      this.isCharge = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder isDrm(boolean paramBoolean)
    {
      this.isDrm = paramBoolean;
      return this;
    }
    
    public VKeyRequestParasBuilder lnk(String paramString)
    {
      this.lnk = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder loginCookie(String paramString)
    {
      this.loginCookie = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder loginQQ(String paramString)
    {
      this.loginQQ = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder networkType(int paramInt)
    {
      this.networkType = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder openApi(TVKCGIVKeyRequestParams.OpenApiParam paramOpenApiParam)
    {
      this.openApiParam = paramOpenApiParam;
      return this;
    }
    
    public VKeyRequestParasBuilder platForm(int paramInt)
    {
      this.platForm = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder requestID(String paramString)
    {
      this.requestID = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder requestType(int paramInt)
    {
      this.requestType = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder requestUrlTargetType(int paramInt)
    {
      this.requestUrlTargetType = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder sdtFrom(String paramString)
    {
      this.sdtFrom = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder startClipNo(int paramInt)
    {
      this.startClipNo = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder taskID(int paramInt)
    {
      this.taskID = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder uin(String paramString)
    {
      this.uin = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder upc(String paramString)
    {
      this.upc = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder upcPaths(String paramString)
    {
      this.upcPaths = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder upcSPIPs(String paramString)
    {
      this.upcSPIPs = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder upcSPPORTs(String paramString)
    {
      this.upcSPPORTs = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder useIpV6Dns(boolean paramBoolean)
    {
      this.useIpV6Dns = paramBoolean;
      return this;
    }
    
    public VKeyRequestParasBuilder vkeyType(int paramInt)
    {
      this.vkeyType = paramInt;
      return this;
    }
    
    public VKeyRequestParasBuilder vt(String paramString)
    {
      this.vt = paramString;
      return this;
    }
    
    public VKeyRequestParasBuilder wxOpenId(String paramString)
    {
      this.wxOpenId = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVKeyRequestParams
 * JD-Core Version:    0.7.0.1
 */