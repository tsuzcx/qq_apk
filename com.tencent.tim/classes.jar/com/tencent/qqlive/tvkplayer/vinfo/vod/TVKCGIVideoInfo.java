package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

public class TVKCGIVideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TVKCGIVideoInfo> CREATOR = new TVKCGIVideoInfo.1();
  private String action;
  private String actualFormat;
  private String adsid;
  private ArrayList<TVKCGIVideoAudioTrackInfo> audioTrackInfos = new ArrayList();
  private String base;
  private int br;
  private int ch;
  private String ckc;
  private int ct;
  private int dltype;
  private int dm;
  private int drm;
  private double duration;
  private int em;
  private int enc;
  private int exem;
  private int fc;
  private String fmd5;
  private String fn;
  private ArrayList<TVKCGIVideoFormatInfo> formatInfos = new ArrayList();
  private int fp2p = 0;
  private String fps;
  private long fs;
  private int fst;
  private String fvkey;
  private int head;
  private int hevc;
  private int iflag;
  private String ip;
  private String keyid;
  private String lnk;
  private boolean localVideo;
  private String m3u8;
  private ArrayList<TVKCGIVideoMp4ClipInfo> mp4ClipInfos = new ArrayList();
  private int mst;
  private ArrayList<TVKCGIVideoPictureInfo> pictureInfos = new ArrayList();
  private String plInfoXml;
  private int preview;
  private long responseTime;
  private String s;
  private long selectedFilesize;
  private String selectedFormat;
  private int selectedFormatID;
  private int st;
  private ArrayList<TVKCGIVideoSubtitleInfo> subtitleInfos = new ArrayList();
  private int swhdcp;
  private int tail;
  private long targetid;
  private float td;
  private String ti;
  private int tie;
  private long tm;
  private int tstid = 0;
  private ArrayList<TVKCGIVideoTVLogoInfo> tvLogoInfos = new ArrayList();
  private int type;
  private String url = "";
  private ArrayList<TVKCGIVideoUrlInfo> urlInfos = new ArrayList();
  private ArrayList<String> urlList = new ArrayList();
  private int vh;
  private String vid;
  private int videotype;
  private String vinfoXml = "";
  private int vr;
  private int vst;
  private int vw;
  private ArrayList<TVKCGIVideoWatermarkInfo> watermarkInfos = new ArrayList();
  private float wh;
  
  public TVKCGIVideoInfo() {}
  
  private TVKCGIVideoInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public void addAudioTrackInfos(TVKCGIVideoAudioTrackInfo paramTVKCGIVideoAudioTrackInfo)
  {
    this.audioTrackInfos.add(paramTVKCGIVideoAudioTrackInfo);
  }
  
  public void addFormatInfo(TVKCGIVideoFormatInfo paramTVKCGIVideoFormatInfo)
  {
    this.formatInfos.add(paramTVKCGIVideoFormatInfo);
  }
  
  public void addMp4ClipInfo(TVKCGIVideoMp4ClipInfo paramTVKCGIVideoMp4ClipInfo)
  {
    this.mp4ClipInfos.add(paramTVKCGIVideoMp4ClipInfo);
  }
  
  public void addPictureInfo(TVKCGIVideoPictureInfo paramTVKCGIVideoPictureInfo)
  {
    this.pictureInfos.add(paramTVKCGIVideoPictureInfo);
  }
  
  public void addSubtitleInfo(TVKCGIVideoSubtitleInfo paramTVKCGIVideoSubtitleInfo)
  {
    this.subtitleInfos.add(paramTVKCGIVideoSubtitleInfo);
  }
  
  public void addTVLogoInfo(TVKCGIVideoTVLogoInfo paramTVKCGIVideoTVLogoInfo)
  {
    this.tvLogoInfos.add(paramTVKCGIVideoTVLogoInfo);
  }
  
  public void addUrlInfos(TVKCGIVideoUrlInfo paramTVKCGIVideoUrlInfo)
  {
    this.urlInfos.add(paramTVKCGIVideoUrlInfo);
  }
  
  public void addWatermarkInfos(TVKCGIVideoWatermarkInfo paramTVKCGIVideoWatermarkInfo)
  {
    this.watermarkInfos.add(paramTVKCGIVideoWatermarkInfo);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public String getActualFormat()
  {
    return this.actualFormat;
  }
  
  public String getAdsid()
  {
    return this.adsid;
  }
  
  public ArrayList<TVKCGIVideoAudioTrackInfo> getAudioTrackInfos()
  {
    return this.audioTrackInfos;
  }
  
  public String getBase()
  {
    return this.base;
  }
  
  public int getBr()
  {
    return this.br;
  }
  
  public int getCh()
  {
    return this.ch;
  }
  
  public String getCkc()
  {
    return this.ckc;
  }
  
  public int getCt()
  {
    return this.ct;
  }
  
  public int getDltype()
  {
    return this.dltype;
  }
  
  public int getDm()
  {
    return this.dm;
  }
  
  public int getDrm()
  {
    return this.drm;
  }
  
  public double getDuration()
  {
    return this.duration;
  }
  
  public int getEm()
  {
    return this.em;
  }
  
  public int getEnc()
  {
    return this.enc;
  }
  
  public int getExem()
  {
    return this.exem;
  }
  
  public int getFc()
  {
    return this.fc;
  }
  
  public String getFmd5()
  {
    return this.fmd5;
  }
  
  public String getFn()
  {
    return this.fn;
  }
  
  public ArrayList<TVKCGIVideoFormatInfo> getFormatInfos()
  {
    return this.formatInfos;
  }
  
  public int getFp2p()
  {
    return this.fp2p;
  }
  
  public String getFps()
  {
    return this.fps;
  }
  
  public long getFs()
  {
    return this.fs;
  }
  
  public int getFst()
  {
    return this.fst;
  }
  
  public String getFvkey()
  {
    return this.fvkey;
  }
  
  public int getHead()
  {
    return this.head;
  }
  
  public int getHevc()
  {
    return this.hevc;
  }
  
  public int getIflag()
  {
    return this.iflag;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public String getKeyid()
  {
    return this.keyid;
  }
  
  public String getLnk()
  {
    return this.lnk;
  }
  
  public String getM3u8()
  {
    return this.m3u8;
  }
  
  public ArrayList<TVKCGIVideoMp4ClipInfo> getMp4ClipInfos()
  {
    return this.mp4ClipInfos;
  }
  
  public int getMst()
  {
    return this.mst;
  }
  
  public ArrayList<TVKCGIVideoPictureInfo> getPictureInfos()
  {
    return this.pictureInfos;
  }
  
  public String getPlInfoXml()
  {
    return this.plInfoXml;
  }
  
  public int getPreview()
  {
    return this.preview;
  }
  
  public long getResponseTime()
  {
    return this.responseTime;
  }
  
  public String getS()
  {
    return this.s;
  }
  
  public long getSelectedFilesize()
  {
    return this.selectedFilesize;
  }
  
  public String getSelectedFormat()
  {
    return this.selectedFormat;
  }
  
  public int getSelectedFormatID()
  {
    return this.selectedFormatID;
  }
  
  public int getSt()
  {
    return this.st;
  }
  
  public ArrayList<TVKCGIVideoSubtitleInfo> getSubtitleInfos()
  {
    return this.subtitleInfos;
  }
  
  public int getSwhdcp()
  {
    return this.swhdcp;
  }
  
  public int getTail()
  {
    return this.tail;
  }
  
  public long getTargetid()
  {
    return this.targetid;
  }
  
  public float getTd()
  {
    return this.td;
  }
  
  public String getTi()
  {
    return this.ti;
  }
  
  public int getTie()
  {
    return this.tie;
  }
  
  public long getTm()
  {
    return this.tm;
  }
  
  public int getTstid()
  {
    return this.tstid;
  }
  
  public ArrayList<TVKCGIVideoTVLogoInfo> getTvLogoInfos()
  {
    return this.tvLogoInfos;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public ArrayList<TVKCGIVideoUrlInfo> getUrlInfos()
  {
    return this.urlInfos;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public int getVh()
  {
    return this.vh;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public int getVideotype()
  {
    return this.videotype;
  }
  
  public String getVinfoXml()
  {
    return this.vinfoXml;
  }
  
  public int getVr()
  {
    return this.vr;
  }
  
  public int getVst()
  {
    return this.vst;
  }
  
  public int getVw()
  {
    return this.vw;
  }
  
  public ArrayList<TVKCGIVideoWatermarkInfo> getWatermarkInfos()
  {
    return this.watermarkInfos;
  }
  
  public float getWh()
  {
    return this.wh;
  }
  
  public boolean isLocalVideo()
  {
    return this.localVideo;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.s = paramParcel.readString();
    this.em = paramParcel.readInt();
    this.exem = paramParcel.readInt();
    this.preview = paramParcel.readInt();
    this.dltype = paramParcel.readInt();
    this.tm = paramParcel.readLong();
    this.fp2p = paramParcel.readInt();
    this.tstid = paramParcel.readInt();
    this.ip = paramParcel.readString();
    this.base = paramParcel.readString();
    this.ch = paramParcel.readInt();
    this.ckc = paramParcel.readString();
    this.ct = paramParcel.readInt();
    this.dm = paramParcel.readInt();
    this.drm = paramParcel.readInt();
    this.enc = paramParcel.readInt();
    this.fmd5 = paramParcel.readString();
    this.fn = paramParcel.readString();
    this.fps = paramParcel.readString();
    this.keyid = paramParcel.readString();
    this.fs = paramParcel.readLong();
    this.fst = paramParcel.readInt();
    this.head = paramParcel.readInt();
    this.hevc = paramParcel.readInt();
    this.iflag = paramParcel.readInt();
    this.lnk = paramParcel.readString();
    this.mst = paramParcel.readInt();
    this.st = paramParcel.readInt();
    this.tail = paramParcel.readInt();
    this.targetid = paramParcel.readLong();
    this.td = paramParcel.readFloat();
    this.ti = paramParcel.readString();
    this.tie = paramParcel.readInt();
    this.type = paramParcel.readInt();
    this.vh = paramParcel.readInt();
    this.vw = paramParcel.readInt();
    this.wh = paramParcel.readFloat();
    this.vid = paramParcel.readString();
    this.videotype = paramParcel.readInt();
    this.vr = paramParcel.readInt();
    this.vst = paramParcel.readInt();
    this.swhdcp = paramParcel.readInt();
    this.br = paramParcel.readInt();
    this.fc = paramParcel.readInt();
    this.fvkey = paramParcel.readString();
    this.duration = paramParcel.readDouble();
    this.action = paramParcel.readString();
    this.adsid = paramParcel.readString();
    this.formatInfos = paramParcel.readArrayList(TVKCGIVideoFormatInfo.class.getClassLoader());
    this.audioTrackInfos = paramParcel.readArrayList(TVKCGIVideoAudioTrackInfo.class.getClassLoader());
    this.subtitleInfos = paramParcel.readArrayList(TVKCGIVideoSubtitleInfo.class.getClassLoader());
    this.pictureInfos = paramParcel.readArrayList(TVKCGIVideoPictureInfo.class.getClassLoader());
    this.urlInfos = paramParcel.readArrayList(TVKCGIVideoUrlInfo.class.getClassLoader());
    this.watermarkInfos = paramParcel.readArrayList(TVKCGIVideoWatermarkInfo.class.getClassLoader());
    this.mp4ClipInfos = paramParcel.readArrayList(TVKCGIVideoMp4ClipInfo.class.getClassLoader());
    this.tvLogoInfos = paramParcel.readArrayList(TVKCGIVideoTVLogoInfo.class.getClassLoader());
    this.url = paramParcel.readString();
    this.vinfoXml = paramParcel.readString();
    this.actualFormat = paramParcel.readString();
    this.plInfoXml = paramParcel.readString();
    this.selectedFormat = paramParcel.readString();
    this.selectedFormatID = paramParcel.readInt();
    this.selectedFilesize = paramParcel.readLong();
    if (paramParcel.readInt() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.localVideo = bool;
      return;
    }
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setActualFormat(String paramString)
  {
    this.actualFormat = paramString;
  }
  
  public void setAdsid(String paramString)
  {
    this.adsid = paramString;
  }
  
  public void setBase(String paramString)
  {
    this.base = paramString;
  }
  
  public void setBr(int paramInt)
  {
    this.br = paramInt;
  }
  
  public void setCh(int paramInt)
  {
    this.ch = paramInt;
  }
  
  public void setCkc(String paramString)
  {
    this.ckc = paramString;
  }
  
  public void setCt(int paramInt)
  {
    this.ct = paramInt;
  }
  
  public void setDltype(int paramInt)
  {
    this.dltype = paramInt;
  }
  
  public void setDm(int paramInt)
  {
    this.dm = paramInt;
  }
  
  public void setDrm(int paramInt)
  {
    this.drm = paramInt;
  }
  
  public void setDuration(double paramDouble)
  {
    this.duration = paramDouble;
  }
  
  public void setEm(int paramInt)
  {
    this.em = paramInt;
  }
  
  public void setEnc(int paramInt)
  {
    this.enc = paramInt;
  }
  
  public void setExem(int paramInt)
  {
    this.exem = paramInt;
  }
  
  public void setFc(int paramInt)
  {
    this.fc = paramInt;
  }
  
  public void setFmd5(String paramString)
  {
    this.fmd5 = paramString;
  }
  
  public void setFn(String paramString)
  {
    this.fn = paramString;
  }
  
  public void setFp2p(int paramInt)
  {
    this.fp2p = paramInt;
  }
  
  public void setFps(String paramString)
  {
    this.fps = paramString;
  }
  
  public void setFs(long paramLong)
  {
    this.fs = paramLong;
  }
  
  public void setFst(int paramInt)
  {
    this.fst = paramInt;
  }
  
  public void setFvkey(String paramString)
  {
    this.fvkey = paramString;
  }
  
  public void setHead(int paramInt)
  {
    this.head = paramInt;
  }
  
  public void setHevc(int paramInt)
  {
    this.hevc = paramInt;
  }
  
  public void setIflag(int paramInt)
  {
    this.iflag = paramInt;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setIsLocalVideo(boolean paramBoolean)
  {
    this.localVideo = paramBoolean;
  }
  
  public void setKeyid(String paramString)
  {
    this.keyid = paramString;
  }
  
  public void setLnk(String paramString)
  {
    this.lnk = paramString;
  }
  
  public void setM3u8(String paramString)
  {
    this.m3u8 = paramString;
  }
  
  public void setMst(int paramInt)
  {
    this.mst = paramInt;
  }
  
  public void setPlInfoXml(String paramString)
  {
    this.plInfoXml = paramString;
  }
  
  public void setPreview(int paramInt)
  {
    this.preview = paramInt;
  }
  
  public void setResponseTime(long paramLong)
  {
    this.responseTime = paramLong;
  }
  
  public void setS(String paramString)
  {
    this.s = paramString;
  }
  
  public void setSelectedFilesize(long paramLong)
  {
    this.selectedFilesize = paramLong;
  }
  
  public void setSelectedFormat(String paramString)
  {
    this.selectedFormat = paramString;
  }
  
  public void setSelectedFormatID(int paramInt)
  {
    this.selectedFormatID = paramInt;
  }
  
  public void setSt(int paramInt)
  {
    this.st = paramInt;
  }
  
  public void setSwhdcp(int paramInt)
  {
    this.swhdcp = paramInt;
  }
  
  public void setTail(int paramInt)
  {
    this.tail = paramInt;
  }
  
  public void setTargetid(long paramLong)
  {
    this.targetid = paramLong;
  }
  
  public void setTd(float paramFloat)
  {
    this.td = paramFloat;
  }
  
  public void setTi(String paramString)
  {
    this.ti = paramString;
  }
  
  public void setTie(int paramInt)
  {
    this.tie = paramInt;
  }
  
  public void setTm(long paramLong)
  {
    this.tm = paramLong;
  }
  
  public void setTstid(int paramInt)
  {
    this.tstid = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setUrlList(ArrayList<String> paramArrayList)
  {
    this.urlList = paramArrayList;
  }
  
  public void setVh(int paramInt)
  {
    this.vh = paramInt;
  }
  
  public void setVid(String paramString)
  {
    this.vid = paramString;
  }
  
  public void setVideotype(int paramInt)
  {
    this.videotype = paramInt;
  }
  
  public void setVinfoXml(String paramString)
  {
    this.vinfoXml = paramString;
  }
  
  public void setVr(int paramInt)
  {
    this.vr = paramInt;
  }
  
  public void setVst(int paramInt)
  {
    this.vst = paramInt;
  }
  
  public void setVw(int paramInt)
  {
    this.vw = paramInt;
  }
  
  public void setWh(float paramFloat)
  {
    this.wh = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.em);
    paramParcel.writeInt(this.exem);
    paramParcel.writeInt(this.preview);
    paramParcel.writeInt(this.dltype);
    paramParcel.writeLong(this.tm);
    paramParcel.writeInt(this.fp2p);
    paramParcel.writeInt(this.tstid);
    paramParcel.writeString(this.ip);
    paramParcel.writeString(this.base);
    paramParcel.writeInt(this.ch);
    paramParcel.writeString(this.ckc);
    paramParcel.writeInt(this.ct);
    paramParcel.writeInt(this.dm);
    paramParcel.writeInt(this.drm);
    paramParcel.writeInt(this.enc);
    paramParcel.writeString(this.fmd5);
    paramParcel.writeString(this.fn);
    paramParcel.writeString(this.fps);
    paramParcel.writeString(this.keyid);
    paramParcel.writeLong(this.fs);
    paramParcel.writeInt(this.fst);
    paramParcel.writeInt(this.head);
    paramParcel.writeInt(this.hevc);
    paramParcel.writeInt(this.iflag);
    paramParcel.writeString(this.lnk);
    paramParcel.writeInt(this.mst);
    paramParcel.writeInt(this.st);
    paramParcel.writeInt(this.tail);
    paramParcel.writeLong(this.targetid);
    paramParcel.writeFloat(this.td);
    paramParcel.writeString(this.ti);
    paramParcel.writeInt(this.tie);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.vh);
    paramParcel.writeInt(this.vw);
    paramParcel.writeFloat(this.wh);
    paramParcel.writeString(this.vid);
    paramParcel.writeInt(this.videotype);
    paramParcel.writeInt(this.vr);
    paramParcel.writeInt(this.vst);
    paramParcel.writeInt(this.swhdcp);
    paramParcel.writeInt(this.br);
    paramParcel.writeInt(this.fc);
    paramParcel.writeString(this.fvkey);
    paramParcel.writeDouble(this.duration);
    paramParcel.writeString(this.action);
    paramParcel.writeString(this.adsid);
    paramParcel.writeList(this.formatInfos);
    paramParcel.writeList(this.audioTrackInfos);
    paramParcel.writeList(this.subtitleInfos);
    paramParcel.writeList(this.pictureInfos);
    paramParcel.writeList(this.urlInfos);
    paramParcel.writeList(this.watermarkInfos);
    paramParcel.writeList(this.mp4ClipInfos);
    paramParcel.writeList(this.tvLogoInfos);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.vinfoXml);
    paramParcel.writeString(this.actualFormat);
    paramParcel.writeString(this.plInfoXml);
    paramParcel.writeString(this.selectedFormat);
    paramParcel.writeInt(this.selectedFormatID);
    paramParcel.writeLong(this.selectedFilesize);
    if (this.localVideo) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  public static class TVKCGIVideoAudioTrackInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoAudioTrackInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoAudioTrackInfo.1();
    private String action;
    private int audio;
    private String keyid;
    private int lmt;
    private String name;
    private int preview;
    private int sl;
    private String track;
    private ArrayList<String> urlList = null;
    
    public TVKCGIVideoAudioTrackInfo() {}
    
    private TVKCGIVideoAudioTrackInfo(Parcel paramParcel)
    {
      this();
      readFromParcel(paramParcel);
    }
    
    public void addUrlList(String paramString)
    {
      if (this.urlList == null) {
        this.urlList = new ArrayList();
      }
      this.urlList.add(paramString);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAction()
    {
      return this.action;
    }
    
    public int getAudio()
    {
      return this.audio;
    }
    
    public String getKeyid()
    {
      return this.keyid;
    }
    
    public int getLmt()
    {
      return this.lmt;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public int getPreview()
    {
      return this.preview;
    }
    
    public int getSl()
    {
      return this.sl;
    }
    
    public String getTrack()
    {
      return this.track;
    }
    
    public ArrayList<String> getUrlList()
    {
      return this.urlList;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      this.sl = paramParcel.readInt();
      this.action = paramParcel.readString();
      this.audio = paramParcel.readInt();
      this.keyid = paramParcel.readString();
      this.lmt = paramParcel.readInt();
      this.name = paramParcel.readString();
      this.preview = paramParcel.readInt();
      this.track = paramParcel.readString();
      this.urlList = paramParcel.readArrayList(TVKCGIVideoAudioTrackInfo.class.getClassLoader());
    }
    
    public void setAction(String paramString)
    {
      this.action = paramString;
    }
    
    public void setAudio(int paramInt)
    {
      this.audio = paramInt;
    }
    
    public void setKeyid(String paramString)
    {
      this.keyid = paramString;
    }
    
    public void setLmt(int paramInt)
    {
      this.lmt = paramInt;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setPreview(int paramInt)
    {
      this.preview = paramInt;
    }
    
    public void setSl(int paramInt)
    {
      this.sl = paramInt;
    }
    
    public void setTrack(String paramString)
    {
      this.track = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.sl);
      paramParcel.writeString(this.action);
      paramParcel.writeInt(this.audio);
      paramParcel.writeString(this.keyid);
      paramParcel.writeInt(this.lmt);
      paramParcel.writeString(this.name);
      paramParcel.writeInt(this.preview);
      paramParcel.writeString(this.track);
      paramParcel.writeList(this.urlList);
    }
  }
  
  public static class TVKCGIVideoFormatInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoFormatInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoFormatInfo.1();
    private int audio;
    private int br;
    private String cname;
    private int drm;
    private long fs;
    private int hdr10enh;
    private int id;
    private int lmt;
    private String name;
    private int profile;
    private String resolution;
    private int sb;
    private int sl;
    private String sname;
    private int superNode;
    private int video;
    
    public TVKCGIVideoFormatInfo() {}
    
    public TVKCGIVideoFormatInfo(Parcel paramParcel)
    {
      this();
      readFromParce(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getAudio()
    {
      return this.audio;
    }
    
    public int getBr()
    {
      return this.br;
    }
    
    public String getCname()
    {
      return this.cname;
    }
    
    public int getDrm()
    {
      return this.drm;
    }
    
    public long getFs()
    {
      return this.fs;
    }
    
    public int getHdr10enh()
    {
      return this.hdr10enh;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public int getLmt()
    {
      return this.lmt;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public int getProfile()
    {
      return this.profile;
    }
    
    public String getResolution()
    {
      return this.resolution;
    }
    
    public int getSb()
    {
      return this.sb;
    }
    
    public int getSl()
    {
      return this.sl;
    }
    
    public String getSname()
    {
      return this.sname;
    }
    
    public int getSuper()
    {
      return this.superNode;
    }
    
    public int getVideo()
    {
      return this.video;
    }
    
    public void readFromParce(Parcel paramParcel)
    {
      this.name = paramParcel.readString();
      this.cname = paramParcel.readString();
      this.id = paramParcel.readInt();
      this.sl = paramParcel.readInt();
      this.lmt = paramParcel.readInt();
      this.sb = paramParcel.readInt();
      this.drm = paramParcel.readInt();
      this.video = paramParcel.readInt();
      this.audio = paramParcel.readInt();
      this.profile = paramParcel.readInt();
      this.superNode = paramParcel.readInt();
      this.br = paramParcel.readInt();
      this.fs = paramParcel.readLong();
      this.hdr10enh = paramParcel.readInt();
      this.sname = paramParcel.readString();
      this.resolution = paramParcel.readString();
    }
    
    public void setAudio(int paramInt)
    {
      this.audio = paramInt;
    }
    
    public void setBr(int paramInt)
    {
      this.br = paramInt;
    }
    
    public void setCname(String paramString)
    {
      this.cname = paramString;
    }
    
    public void setDrm(int paramInt)
    {
      this.drm = paramInt;
    }
    
    public void setFs(long paramLong)
    {
      this.fs = paramLong;
    }
    
    public void setHdr10enh(int paramInt)
    {
      this.hdr10enh = paramInt;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setLmt(int paramInt)
    {
      this.lmt = paramInt;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setProfile(int paramInt)
    {
      this.profile = paramInt;
    }
    
    public void setResolution(String paramString)
    {
      this.resolution = paramString;
    }
    
    public void setSb(int paramInt)
    {
      this.sb = paramInt;
    }
    
    public void setSl(int paramInt)
    {
      this.sl = paramInt;
    }
    
    public void setSname(String paramString)
    {
      this.sname = paramString;
    }
    
    public void setSuper(int paramInt)
    {
      this.superNode = paramInt;
    }
    
    public void setVideo(int paramInt)
    {
      this.video = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.cname);
      paramParcel.writeInt(this.id);
      paramParcel.writeInt(this.sl);
      paramParcel.writeInt(this.lmt);
      paramParcel.writeInt(this.sb);
      paramParcel.writeInt(this.drm);
      paramParcel.writeInt(this.video);
      paramParcel.writeInt(this.audio);
      paramParcel.writeInt(this.profile);
      paramParcel.writeInt(this.superNode);
      paramParcel.writeInt(this.br);
      paramParcel.writeLong(this.fs);
      paramParcel.writeInt(this.hdr10enh);
      paramParcel.writeString(this.sname);
      paramParcel.writeString(this.resolution);
    }
  }
  
  public static class TVKCGIVideoMp4ClipInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoMp4ClipInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoMp4ClipInfo.1();
    private String cmd5;
    private double duration;
    private int idx;
    private String keyid;
    private long size;
    private String url;
    private ArrayList<String> urlList = new ArrayList();
    private String vkey;
    
    public TVKCGIVideoMp4ClipInfo() {}
    
    private TVKCGIVideoMp4ClipInfo(Parcel paramParcel)
    {
      this();
      readFromParcel(paramParcel);
    }
    
    public void addUrlList(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.urlList.add(paramString);
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getCmd5()
    {
      return this.cmd5;
    }
    
    public double getDuration()
    {
      return this.duration;
    }
    
    public int getIdx()
    {
      return this.idx;
    }
    
    public String getKeyid()
    {
      return this.keyid;
    }
    
    public long getSize()
    {
      return this.size;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public ArrayList<String> getUrlList()
    {
      return this.urlList;
    }
    
    public String getVkey()
    {
      return this.vkey;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      this.duration = paramParcel.readDouble();
      this.size = paramParcel.readLong();
      this.idx = paramParcel.readInt();
      this.cmd5 = paramParcel.readString();
      this.keyid = paramParcel.readString();
      this.url = paramParcel.readString();
      this.vkey = paramParcel.readString();
      this.urlList = paramParcel.readArrayList(TVKCGIVideoMp4ClipInfo.class.getClassLoader());
    }
    
    public void setCmd5(String paramString)
    {
      this.cmd5 = paramString;
    }
    
    public void setDuration(double paramDouble)
    {
      this.duration = paramDouble;
    }
    
    public void setIdx(int paramInt)
    {
      this.idx = paramInt;
    }
    
    public void setKeyid(String paramString)
    {
      this.keyid = paramString;
    }
    
    public void setSize(long paramLong)
    {
      this.size = paramLong;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void setVkey(String paramString)
    {
      this.vkey = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeDouble(this.duration);
      paramParcel.writeLong(this.size);
      paramParcel.writeInt(this.idx);
      paramParcel.writeString(this.cmd5);
      paramParcel.writeString(this.keyid);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.vkey);
      paramParcel.writeList(this.urlList);
    }
  }
  
  public static class TVKCGIVideoPictureInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoPictureInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoPictureInfo.1();
    private int c;
    private int cd;
    private int fmt;
    private String fn;
    private int h;
    private int r;
    private String url;
    private int w;
    
    public TVKCGIVideoPictureInfo() {}
    
    private TVKCGIVideoPictureInfo(Parcel paramParcel)
    {
      this();
      readFromParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getC()
    {
      return this.c;
    }
    
    public int getCd()
    {
      return this.cd;
    }
    
    public int getFmt()
    {
      return this.fmt;
    }
    
    public String getFn()
    {
      return this.fn;
    }
    
    public int getH()
    {
      return this.h;
    }
    
    public int getR()
    {
      return this.r;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public int getW()
    {
      return this.w;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      this.fmt = paramParcel.readInt();
      this.cd = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.w = paramParcel.readInt();
      this.r = paramParcel.readInt();
      this.url = paramParcel.readString();
      this.fn = paramParcel.readString();
    }
    
    public void setC(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void setCd(int paramInt)
    {
      this.cd = paramInt;
    }
    
    public void setFmt(int paramInt)
    {
      this.fmt = paramInt;
    }
    
    public void setFn(String paramString)
    {
      this.fn = paramString;
    }
    
    public void setH(int paramInt)
    {
      this.h = paramInt;
    }
    
    public void setR(int paramInt)
    {
      this.r = paramInt;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void setW(int paramInt)
    {
      this.w = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.fmt);
      paramParcel.writeInt(this.cd);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.w);
      paramParcel.writeInt(this.r);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.fn);
    }
  }
  
  public static class TVKCGIVideoSubtitleInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoSubtitleInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoSubtitleInfo.1();
    private String keyid;
    private String name;
    private String url;
    
    public TVKCGIVideoSubtitleInfo() {}
    
    private TVKCGIVideoSubtitleInfo(Parcel paramParcel)
    {
      this();
      readFromParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getKeyid()
    {
      return this.keyid;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      this.name = paramParcel.readString();
      this.url = paramParcel.readString();
      this.keyid = paramParcel.readString();
    }
    
    public void setKeyid(String paramString)
    {
      this.keyid = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.keyid);
    }
  }
  
  public static class TVKCGIVideoTVLogoInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoTVLogoInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoTVLogoInfo.1();
    private int tvLogoH;
    private int tvLogoShow;
    private int tvLogoW;
    private int tvLogoX;
    private int tvLogoY;
    
    public TVKCGIVideoTVLogoInfo() {}
    
    private TVKCGIVideoTVLogoInfo(Parcel paramParcel)
    {
      this();
      readFromParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getTvLogoH()
    {
      return this.tvLogoH;
    }
    
    public int getTvLogoShow()
    {
      return this.tvLogoShow;
    }
    
    public int getTvLogoW()
    {
      return this.tvLogoW;
    }
    
    public int getTvLogoX()
    {
      return this.tvLogoX;
    }
    
    public int getTvLogoY()
    {
      return this.tvLogoY;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      this.tvLogoH = paramParcel.readInt();
      this.tvLogoW = paramParcel.readInt();
      this.tvLogoX = paramParcel.readInt();
      this.tvLogoY = paramParcel.readInt();
      this.tvLogoShow = paramParcel.readInt();
    }
    
    public void setTvLogoH(int paramInt)
    {
      this.tvLogoH = paramInt;
    }
    
    public void setTvLogoShow(int paramInt)
    {
      this.tvLogoShow = paramInt;
    }
    
    public void setTvLogoW(int paramInt)
    {
      this.tvLogoW = paramInt;
    }
    
    public void setTvLogoX(int paramInt)
    {
      this.tvLogoX = paramInt;
    }
    
    public void setTvLogoY(int paramInt)
    {
      this.tvLogoY = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.tvLogoH);
      paramParcel.writeInt(this.tvLogoW);
      paramParcel.writeInt(this.tvLogoX);
      paramParcel.writeInt(this.tvLogoY);
      paramParcel.writeInt(this.tvLogoShow);
    }
  }
  
  public static class TVKCGIVideoUrlInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoUrlInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoUrlInfo.1();
    private String hk;
    private String path;
    private String pt;
    private String spip;
    private String spport;
    private String url = "";
    private int vt;
    
    public TVKCGIVideoUrlInfo() {}
    
    private TVKCGIVideoUrlInfo(Parcel paramParcel)
    {
      this();
      readFromParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getHk()
    {
      return this.hk;
    }
    
    public String getPath()
    {
      return this.path;
    }
    
    public String getPt()
    {
      return this.pt;
    }
    
    public String getSpip()
    {
      return this.spip;
    }
    
    public String getSpport()
    {
      return this.spport;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public int getVt()
    {
      return this.vt;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      this.vt = paramParcel.readInt();
      this.url = paramParcel.readString();
      this.spip = paramParcel.readString();
      this.spport = paramParcel.readString();
      this.path = paramParcel.readString();
      this.hk = paramParcel.readString();
      this.pt = paramParcel.readString();
    }
    
    public void setHk(String paramString)
    {
      this.hk = paramString;
    }
    
    public void setPath(String paramString)
    {
      this.path = paramString;
    }
    
    public void setPt(String paramString)
    {
      this.pt = paramString;
    }
    
    public void setSpip(String paramString)
    {
      this.spip = paramString;
    }
    
    public void setSpport(String paramString)
    {
      this.spport = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void setVt(int paramInt)
    {
      this.vt = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.vt);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.spip);
      paramParcel.writeString(this.spport);
      paramParcel.writeString(this.path);
      paramParcel.writeString(this.hk);
      paramParcel.writeString(this.pt);
    }
  }
  
  public static class TVKCGIVideoWatermarkInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TVKCGIVideoWatermarkInfo> CREATOR = new TVKCGIVideoInfo.TVKCGIVideoWatermarkInfo.1();
    private int a;
    private int h;
    private int id;
    private String md5;
    private String surl;
    private String url;
    private int w;
    private int x;
    private int y;
    
    public TVKCGIVideoWatermarkInfo() {}
    
    private TVKCGIVideoWatermarkInfo(Parcel paramParcel)
    {
      this();
      readFromParcel(paramParcel);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getA()
    {
      return this.a;
    }
    
    public int getH()
    {
      return this.h;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getMd5()
    {
      return this.md5;
    }
    
    public String getSurl()
    {
      return this.surl;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public int getW()
    {
      return this.w;
    }
    
    public int getX()
    {
      return this.x;
    }
    
    public int getY()
    {
      return this.y;
    }
    
    public void readFromParcel(Parcel paramParcel)
    {
      this.id = paramParcel.readInt();
      this.x = paramParcel.readInt();
      this.y = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.w = paramParcel.readInt();
      this.a = paramParcel.readInt();
      this.md5 = paramParcel.readString();
      this.url = paramParcel.readString();
      this.surl = paramParcel.readString();
    }
    
    public void setA(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void setH(int paramInt)
    {
      this.h = paramInt;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setMd5(String paramString)
    {
      this.md5 = paramString;
    }
    
    public void setSurl(String paramString)
    {
      this.surl = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
    
    public void setW(int paramInt)
    {
      this.w = paramInt;
    }
    
    public void setX(int paramInt)
    {
      this.x = paramInt;
    }
    
    public void setY(int paramInt)
    {
      this.y = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.id);
      paramParcel.writeInt(this.x);
      paramParcel.writeInt(this.y);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.w);
      paramParcel.writeInt(this.a);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.surl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVideoInfo
 * JD-Core Version:    0.7.0.1
 */