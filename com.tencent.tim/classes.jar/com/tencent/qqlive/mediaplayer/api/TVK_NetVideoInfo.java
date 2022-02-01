package com.tencent.qqlive.mediaplayer.api;

import java.io.Serializable;
import java.util.ArrayList;

public class TVK_NetVideoInfo
  implements Serializable
{
  public static final String FORMAT_AUDIO = "audio";
  public static final String FORMAT_FHD = "fhd";
  public static final String FORMAT_HD = "hd";
  public static final String FORMAT_MP4 = "mp4";
  public static final String FORMAT_MSD = "msd";
  public static final String FORMAT_SD = "sd";
  public static final String FORMAT_SHD = "shd";
  public static final int TYPE_JSON = 1;
  public static final int TYPE_XML = 2;
  private static final long serialVersionUID = -1L;
  private DefnInfo a;
  private ArrayList<DefnInfo> b;
  private int c = 0;
  private int d = 0;
  private int e = 2;
  private int f = 0;
  private long g = 0L;
  private long h = 0L;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m;
  private int n;
  private String o;
  private int p;
  private int q;
  private int r;
  private String s;
  private String t;
  private int u;
  private String v;
  private int w = 0;
  private String x;
  private int y = 0;
  private String z;
  
  public void addDefinition(DefnInfo paramDefnInfo)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramDefnInfo);
  }
  
  public int getChargeState()
  {
    return this.d;
  }
  
  public DefnInfo getCurDefinition()
  {
    return this.a;
  }
  
  public int getDanmuState()
  {
    return this.c;
  }
  
  public ArrayList<DefnInfo> getDefinitionList()
  {
    return this.b;
  }
  
  public int getDuration()
  {
    return this.f;
  }
  
  public String getErrInfo()
  {
    return this.o;
  }
  
  public String getErrtitle()
  {
    return this.z;
  }
  
  public long getFileSize()
  {
    return this.g;
  }
  
  public int getIretdetailcode()
  {
    return this.y;
  }
  
  public int getPrePlayCountPerDay()
  {
    return this.i;
  }
  
  public long getPrePlayTime()
  {
    return this.h;
  }
  
  public int getQueue_rank()
  {
    return this.q;
  }
  
  public String getQueue_session_key()
  {
    return this.s;
  }
  
  public int getQueue_status()
  {
    return this.p;
  }
  
  public int getQueue_vip_jump()
  {
    return this.r;
  }
  
  public int getRestPrePlayCount()
  {
    return this.j;
  }
  
  public int getRetCode()
  {
    return this.m;
  }
  
  public int getState()
  {
    return this.e;
  }
  
  public int getSubErrType()
  {
    return this.n;
  }
  
  public int getmExem()
  {
    return this.u;
  }
  
  public String getmLnk()
  {
    return this.x;
  }
  
  public String getmPLString()
  {
    return this.v;
  }
  
  public int getmPLType()
  {
    return this.w;
  }
  
  public String getmTitle()
  {
    return this.t;
  }
  
  public int isNeedPay()
  {
    return this.l;
  }
  
  public int isPay()
  {
    return this.k;
  }
  
  public void removeDefinition(DefnInfo paramDefnInfo)
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      return;
    }
    this.b.remove(paramDefnInfo);
  }
  
  public void setChargeState(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setCurDefinition(DefnInfo paramDefnInfo)
  {
    this.a = paramDefnInfo;
  }
  
  public void setDanmuState(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setErrInfo(String paramString)
  {
    this.o = paramString;
  }
  
  public void setErrtitle(String paramString)
  {
    this.z = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void setIretdetailcode(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setNeedPay(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setPay(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setPrePlayCountPerDay(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setPrePlayTime(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void setQueue_rank(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setQueue_session_key(String paramString)
  {
    this.s = paramString;
  }
  
  public void setQueue_status(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setQueue_vip_jump(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setRestPrePlayCount(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setRetCode(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setState(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSubErrType(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setmExem(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void setmLnk(String paramString)
  {
    this.x = paramString;
  }
  
  public void setmPLString(String paramString)
  {
    this.v = paramString;
  }
  
  public void setmPLType(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setmTitle(String paramString)
  {
    this.t = paramString;
  }
  
  public static class DefnInfo
    implements Serializable
  {
    private static final long serialVersionUID = -1L;
    private String a;
    private String b;
    private int c;
    private int d;
    
    public String getmDefn()
    {
      return this.a;
    }
    
    public int getmDefnId()
    {
      return this.d;
    }
    
    public String getmDefnName()
    {
      return this.b;
    }
    
    public boolean isAudioOnly()
    {
      return "audio".equalsIgnoreCase(this.a);
    }
    
    public int isVip()
    {
      return this.c;
    }
    
    public void setVip(int paramInt)
    {
      this.c = paramInt;
    }
    
    public void setmDefn(String paramString)
    {
      this.a = paramString;
    }
    
    public void setmDefnId(int paramInt)
    {
      this.d = paramInt;
    }
    
    public void setmDefnName(String paramString)
    {
      this.b = paramString;
    }
  }
  
  public static class RecommadInfo
    implements Serializable
  {
    private static final long serialVersionUID = -1L;
    private String a;
    private String b;
    private String c;
    private boolean d;
    
    public String getmCid()
    {
      return this.b;
    }
    
    public String getmTargetId()
    {
      return this.c;
    }
    
    public String getmVid()
    {
      return this.a;
    }
    
    public boolean ismDanmuOpen()
    {
      return this.d;
    }
    
    public void setmCid(String paramString)
    {
      this.b = paramString;
    }
    
    public void setmDanmuOpen(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }
    
    public void setmTargetId(String paramString)
    {
      this.c = ("targetid=" + paramString + "&type=2");
    }
    
    public void setmVid(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo
 * JD-Core Version:    0.7.0.1
 */