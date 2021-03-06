package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TVKVideoInfo
  extends TVKNetVideoInfo
  implements Serializable
{
  public static final String DEFINITION_MP4 = "mp4";
  public static final int DOWNLOAD_TYPE_HLS = 3;
  public static final int EXEM_DEFN_LIMIT = 3;
  public static final int FORMAT_STANDARD_MP4 = 2;
  public static final int MODEL_CODE_VBKEY = 113;
  public static final int MODEL_CODE_VINFO = 111;
  public static final int MODEL_CODE_VKEY = 112;
  public static final int SUCCESS = 0;
  public static final String TAG = "TVKVideoInfo";
  public static final int TYPE_JSON = 1;
  public static final int TYPE_XML = 2;
  private static final long serialVersionUID = -1L;
  private String actionUrl;
  private String adsid;
  private String[] backPlayUrl;
  private String bitrate;
  private int cgiCode = 0;
  private String ckc;
  private String[] clipUrl;
  private int downloadType;
  private String drmToken = "";
  private int drmType = 0;
  private int enc = 0;
  private String errMsg;
  private String exInfo;
  private String exMsg;
  private String fileName;
  private ArrayList<Object> formatList = new ArrayList();
  private int fp2p = -1;
  private int height;
  private int iFlag = 0;
  private String level = "";
  private int logHeight;
  private int logWidth;
  private int logX;
  private int logY;
  private boolean mIsLogShow;
  private boolean mVideoEncryption = false;
  private int modelCode = 0;
  private int moduleCode = 0;
  private String playUrl;
  private ArrayList<Section> sectionList = new ArrayList();
  private int sectionNum = 0;
  private String sha = "";
  private String sp = "";
  private String targetId = "";
  private int type;
  private ArrayList<ReferUrl> urlList = new ArrayList();
  private String vKey = "";
  private String vKeyXml;
  private String vid;
  private int videoType;
  private int width;
  private String xml;
  
  public void addDefinition(TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    super.addDefinition(paramDefnInfo);
  }
  
  public void addReferUrlItem(int paramInt, ReferUrl paramReferUrl)
  {
    if (paramReferUrl != null)
    {
      Object localObject = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
      if ((paramReferUrl.getUrl() != null) && (!TextUtils.isEmpty(paramReferUrl.getUrl())))
      {
        localObject = ((Pattern)localObject).matcher(paramReferUrl.getUrl());
        if ((((Matcher)localObject).find()) && (((Matcher)localObject).group() != null)) {
          addVideoDownloadHostItem(Integer.valueOf(paramInt), ((Matcher)localObject).group());
        }
      }
    }
    this.urlList.add(paramReferUrl);
  }
  
  public void addSectionItem(Section paramSection)
  {
    this.sectionList.add(paramSection);
  }
  
  public String getActionUrl()
  {
    return this.actionUrl;
  }
  
  public String getAdsid()
  {
    return this.adsid;
  }
  
  public String[] getBackPlayUrl()
  {
    return this.backPlayUrl;
  }
  
  public String getBitrate()
  {
    return this.bitrate;
  }
  
  public int getCgiCode()
  {
    return this.cgiCode;
  }
  
  public String getCkc()
  {
    return this.ckc;
  }
  
  public String[] getClipUrl()
  {
    return this.clipUrl;
  }
  
  public String getDRMToken()
  {
    return this.drmToken;
  }
  
  public int getDanmuState()
  {
    return super.getDanmuState();
  }
  
  public int getDownloadType()
  {
    return this.downloadType;
  }
  
  public int getDrm()
  {
    return this.drmType;
  }
  
  public int getDuration()
  {
    return super.getDuration();
  }
  
  public int getEnc()
  {
    return this.enc;
  }
  
  public boolean getEncryptionVideo()
  {
    return this.mVideoEncryption;
  }
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public String getExInfo()
  {
    return this.exInfo;
  }
  
  public String getExMsg()
  {
    return this.exMsg;
  }
  
  public int getExem()
  {
    return super.getExem();
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public long getFileSize()
  {
    return super.getFileSize();
  }
  
  public String getFirstCdnHlsPlayUrl()
  {
    Object localObject = null;
    String str;
    if (this.urlList.size() > 0)
    {
      localObject = (ReferUrl)this.urlList.get(0);
      str = ((ReferUrl)localObject).getUrl();
      if (((ReferUrl)localObject).getHlsNode() != null) {
        localObject = str + ((ReferUrl)localObject).getHlsNode().getPt();
      }
    }
    else
    {
      return localObject;
    }
    return str;
  }
  
  public int getFirstCdnId()
  {
    int i = 0;
    if (this.urlList.size() > 0) {
      i = ((ReferUrl)getUrlList().get(0)).getVt();
    }
    return i;
  }
  
  public String getFirstCdnServer()
  {
    String str = null;
    if (this.urlList.size() > 0) {
      str = ((ReferUrl)getUrlList().get(0)).getUrl();
    }
    return str;
  }
  
  public int getFp2p()
  {
    return this.fp2p;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getIFlag()
  {
    return this.iFlag;
  }
  
  public String getLevel()
  {
    return this.level;
  }
  
  public String getLnk()
  {
    return super.getLnk();
  }
  
  public int getLogHeight()
  {
    return this.logHeight;
  }
  
  public int getLogWidth()
  {
    return this.logWidth;
  }
  
  public int getLogX()
  {
    return this.logX;
  }
  
  public int getLogY()
  {
    return this.logY;
  }
  
  public int getModelCode()
  {
    return this.modelCode;
  }
  
  public int getModuleCode()
  {
    return this.moduleCode;
  }
  
  public String getPLString()
  {
    return super.getPLString();
  }
  
  public int getPLType()
  {
    return super.getPLType();
  }
  
  public int getPayCh()
  {
    return super.getPayCh();
  }
  
  public String getPlayUrl()
  {
    if (TextUtils.isEmpty(this.playUrl)) {
      return "";
    }
    return this.playUrl;
  }
  
  public long getPrePlayEndPos()
  {
    return super.getPrePlayEndPos();
  }
  
  public long getPrePlayStartPos()
  {
    return super.getPrePlayStartPos();
  }
  
  public long getPrePlayTime()
  {
    return super.getPrePlayTime();
  }
  
  public ArrayList<Section> getSectionList()
  {
    return this.sectionList;
  }
  
  public int getSectionNum()
  {
    return this.sectionNum;
  }
  
  public String getSha()
  {
    return this.sha;
  }
  
  public String getSp()
  {
    return this.sp;
  }
  
  public int getSt()
  {
    return super.getSt();
  }
  
  public String getTargetId()
  {
    return this.targetId;
  }
  
  public String getTitle()
  {
    return super.getTitle();
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public ArrayList<ReferUrl> getUrlList()
  {
    return this.urlList;
  }
  
  public String getVKey()
  {
    return this.vKey;
  }
  
  public String getVKeyXml()
  {
    return this.vKeyXml;
  }
  
  public String getVid()
  {
    return super.getVid();
  }
  
  public int getVideoType()
  {
    return this.videoType;
  }
  
  public String getVideoUrlWithoutVkey(String paramString)
  {
    if ((this.urlList == null) || (this.urlList.size() == 0))
    {
      Log.e("TVKVideoInfo", "vinfo is not valiad!!");
      return null;
    }
    return ((ReferUrl)this.urlList.get(0)).getUrl() + this.fileName;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public String getXml()
  {
    return this.xml;
  }
  
  public boolean isHLSDownloadType()
  {
    return this.downloadType == 3;
  }
  
  public boolean isHevc()
  {
    return super.isHevc();
  }
  
  public boolean ismIsLogShow()
  {
    return this.mIsLogShow;
  }
  
  public void setActionUrl(String paramString)
  {
    this.actionUrl = paramString;
  }
  
  public void setAdsid(String paramString)
  {
    this.adsid = paramString;
  }
  
  public void setBackPlayUrl(String[] paramArrayOfString)
  {
    this.backPlayUrl = paramArrayOfString;
  }
  
  public void setBitrate(String paramString)
  {
    this.bitrate = paramString;
  }
  
  public void setCgiCode(int paramInt)
  {
    this.cgiCode = paramInt;
  }
  
  public void setCkc(String paramString)
  {
    this.ckc = paramString;
  }
  
  public void setClipUrl(String[] paramArrayOfString)
  {
    this.clipUrl = paramArrayOfString;
  }
  
  public void setCurDefinition(TVKNetVideoInfo.DefnInfo paramDefnInfo)
  {
    super.setCurDefinition(paramDefnInfo);
  }
  
  public void setDRMToken(String paramString)
  {
    this.drmToken = paramString;
  }
  
  public void setDanmuState(int paramInt)
  {
    super.setDanmuState(paramInt);
  }
  
  public void setDownloadType(int paramInt)
  {
    this.downloadType = paramInt;
  }
  
  public void setDrm(int paramInt)
  {
    this.drmType = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    super.setDuration(paramInt);
  }
  
  public void setEnc(int paramInt)
  {
    this.enc = paramInt;
  }
  
  public void setEncryptionVideo(boolean paramBoolean)
  {
    this.mVideoEncryption = paramBoolean;
  }
  
  public void setEndPos(int paramInt)
  {
    super.setEndPos(paramInt);
  }
  
  public void setErrMsg(String paramString)
  {
    this.errMsg = paramString;
  }
  
  public void setExInfo(String paramString)
  {
    this.exInfo = paramString;
  }
  
  public void setExMsg(String paramString)
  {
    this.exMsg = paramString;
  }
  
  public void setExem(int paramInt)
  {
    super.setExem(paramInt);
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    super.setFileSize(paramLong);
  }
  
  public void setFp2p(int paramInt)
  {
    this.fp2p = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setIFlag(int paramInt)
  {
    this.iFlag = paramInt;
  }
  
  public void setIsHevc(boolean paramBoolean)
  {
    super.setIsHevc(paramBoolean);
  }
  
  public void setLevel(String paramString)
  {
    this.level = paramString;
  }
  
  public void setLnk(String paramString)
  {
    super.setLnk(paramString);
  }
  
  public void setLocalVideo(boolean paramBoolean)
  {
    super.setLocalVideo(paramBoolean);
  }
  
  public void setLogHeight(int paramInt)
  {
    this.logHeight = paramInt;
  }
  
  public void setLogWidth(int paramInt)
  {
    this.logWidth = paramInt;
  }
  
  public void setLogX(int paramInt)
  {
    this.logX = paramInt;
  }
  
  public void setLogY(int paramInt)
  {
    this.logY = paramInt;
  }
  
  public void setMediaVideoState(int paramInt)
  {
    super.setMediaVideoState(paramInt);
  }
  
  public void setMediaVideoType(int paramInt)
  {
    super.setMediaVideoType(paramInt);
  }
  
  public void setModelCode(int paramInt)
  {
    this.modelCode = paramInt;
  }
  
  public void setModuleCode(int paramInt)
  {
    this.moduleCode = paramInt;
  }
  
  public void setPLString(String paramString)
  {
    super.setPLString(paramString);
  }
  
  public void setPLType(int paramInt)
  {
    super.setPLType(paramInt);
  }
  
  public void setPayCh(int paramInt)
  {
    super.setPayCh(paramInt);
  }
  
  public void setPictureList(Object paramObject)
  {
    super.setPictureList(paramObject);
  }
  
  public void setPlayUrl(String paramString)
  {
    this.playUrl = paramString;
  }
  
  public void setPrePlayEndPos(long paramLong)
  {
    super.setPrePlayEndPos(paramLong);
  }
  
  public void setPrePlayStartPos(long paramLong)
  {
    super.setPrePlayStartPos(paramLong);
  }
  
  public void setPrePlayTime(long paramLong)
  {
    super.setPrePlayTime(paramLong);
  }
  
  public void setSectionNum(int paramInt)
  {
    this.sectionNum = paramInt;
  }
  
  public void setSha(String paramString)
  {
    this.sha = paramString;
  }
  
  public void setSp(String paramString)
  {
    this.sp = paramString;
  }
  
  public void setSt(int paramInt)
  {
    super.setSt(paramInt);
  }
  
  public void setStartPos(int paramInt)
  {
    super.setStartPos(paramInt);
  }
  
  public void setTargetId(String paramString)
  {
    this.targetId = paramString;
  }
  
  public void setTitle(String paramString)
  {
    super.setTitle(paramString);
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setVKey(String paramString)
  {
    this.vKey = paramString;
  }
  
  public void setVKeyXml(String paramString)
  {
    this.vKeyXml = paramString;
  }
  
  public void setVid(String paramString)
  {
    super.setVid(paramString);
  }
  
  public void setVideoType(int paramInt)
  {
    this.videoType = paramInt;
  }
  
  public void setWHRadio(float paramFloat)
  {
    super.setWHRadio(paramFloat);
  }
  
  public void setWanIP(String paramString)
  {
    super.setWanIP(paramString);
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public void setXml(String paramString)
  {
    this.xml = paramString;
  }
  
  public void setmIsLogShow(boolean paramBoolean)
  {
    this.mIsLogShow = paramBoolean;
  }
  
  public static class HlsNode
    implements Serializable
  {
    private static final long serialVersionUID = -1L;
    private int et;
    private int fbw;
    private int ftype;
    private String hk;
    private String hvl;
    private String pname;
    private String pt;
    private int st;
    private String stype;
    
    public int getEt()
    {
      return this.et;
    }
    
    public int getFbw()
    {
      return this.fbw;
    }
    
    public int getFtype()
    {
      return this.ftype;
    }
    
    public String getHk()
    {
      return this.hk;
    }
    
    public String getHvl()
    {
      return this.hvl;
    }
    
    public String getPname()
    {
      return this.pname;
    }
    
    public String getPt()
    {
      return this.pt;
    }
    
    public int getSt()
    {
      return this.st;
    }
    
    public String getStype()
    {
      return this.stype;
    }
    
    public void setEt(int paramInt)
    {
      this.et = paramInt;
    }
    
    public void setFbw(int paramInt)
    {
      this.fbw = paramInt;
    }
    
    public void setFtype(int paramInt)
    {
      this.ftype = paramInt;
    }
    
    public void setHk(String paramString)
    {
      this.hk = paramString;
    }
    
    public void setHvl(String paramString)
    {
      this.hvl = paramString;
    }
    
    public void setPname(String paramString)
    {
      this.pname = paramString;
    }
    
    public void setPt(String paramString)
    {
      this.pt = paramString;
    }
    
    public void setSt(int paramInt)
    {
      this.st = paramInt;
    }
    
    public void setStype(String paramString)
    {
      this.stype = paramString;
    }
  }
  
  public static class ReferUrl
    implements Serializable
  {
    private static final long serialVersionUID = -1L;
    private int dt;
    private int dtc;
    private TVKVideoInfo.HlsNode hlsNode;
    private String path;
    private int spPort;
    private String spip;
    private String url;
    private int vt;
    
    public int getDt()
    {
      return this.dt;
    }
    
    public int getDtc()
    {
      return this.dtc;
    }
    
    public TVKVideoInfo.HlsNode getHlsNode()
    {
      return this.hlsNode;
    }
    
    public String getPath()
    {
      return this.path;
    }
    
    public int getSpPort()
    {
      return this.spPort;
    }
    
    public String getSpip()
    {
      return this.spip;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public int getVt()
    {
      return this.vt;
    }
    
    public void setDt(int paramInt)
    {
      this.dt = paramInt;
    }
    
    public void setDtc(int paramInt)
    {
      this.dtc = paramInt;
    }
    
    public void setHlsNode(TVKVideoInfo.HlsNode paramHlsNode)
    {
      this.hlsNode = paramHlsNode;
    }
    
    public void setPath(String paramString)
    {
      this.path = paramString;
    }
    
    public void setSpPort(int paramInt)
    {
      this.spPort = paramInt;
    }
    
    public void setSpip(String paramString)
    {
      this.spip = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void setVt(int paramInt)
    {
      this.vt = paramInt;
    }
  }
  
  public static class Section
    implements Serializable
  {
    private static final long serialVersionUID = -1L;
    private double duration;
    private int idx;
    private String indexName;
    private int size;
    private String url;
    private String vbkey;
    private String vbkeyId;
    
    public double getDuration()
    {
      return this.duration;
    }
    
    public int getIdx()
    {
      return this.idx;
    }
    
    public String getIndexName()
    {
      return this.indexName;
    }
    
    public int getSize()
    {
      return this.size;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public String getVbkey()
    {
      return this.vbkey;
    }
    
    public String getVbkeyId()
    {
      return this.vbkeyId;
    }
    
    public void setDuration(double paramDouble)
    {
      this.duration = paramDouble;
    }
    
    public void setIdx(int paramInt)
    {
      this.idx = paramInt;
    }
    
    public void setIndexName(String paramString)
    {
      this.indexName = paramString;
    }
    
    public void setIndexName(String paramString, int paramInt)
    {
      paramString = paramString.replace(".mp4", "");
      this.indexName = (paramString + "." + paramInt + ".mp4");
    }
    
    public void setSize(int paramInt)
    {
      this.size = paramInt;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void setVbkey(String paramString)
    {
      this.vbkey = paramString;
    }
    
    public void setVbkeyId(String paramString)
    {
      this.vbkeyId = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo
 * JD-Core Version:    0.7.0.1
 */