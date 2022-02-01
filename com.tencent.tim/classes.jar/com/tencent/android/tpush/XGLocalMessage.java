package com.tencent.android.tpush;

import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

public class XGLocalMessage
{
  private long A = System.currentTimeMillis() + this.z * 1000L;
  private int B = 0;
  private String C = "";
  private int D = 2;
  private String E = "";
  private String F = "";
  private String G = "";
  private int H = -1;
  private int a = 1;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "00";
  private String f = "00";
  private int g = 1;
  private int h = 1;
  private int i = 1;
  private int j = 0;
  private int k = 1;
  private String l = "";
  private String m = "";
  private String n = "";
  public String nGroupId = "";
  private int o = 1;
  private String p = "";
  public int pushChannel = 99;
  public long pushTime = 0L;
  private String q = "";
  private String r = "";
  private String s = "";
  public long source = 0L;
  private String t = "";
  public long targetType = 0L;
  public String templateId = "";
  public String traceId = "";
  private String u = "{}";
  private long v;
  private int w = 0;
  private long x = System.currentTimeMillis() * -1L;
  private long y = 0L;
  private int z = 2592000;
  
  public int getAction_type()
  {
    return this.o;
  }
  
  public String getActivity()
  {
    return this.p;
  }
  
  public int getBadgeType()
  {
    return this.H;
  }
  
  public long getBuilderId()
  {
    return this.v;
  }
  
  public long getBusiMsgId()
  {
    return this.y;
  }
  
  public String getChannelId()
  {
    return this.C;
  }
  
  public int getColor()
  {
    return this.B;
  }
  
  public String getContent()
  {
    return this.c;
  }
  
  public String getCustom_content()
  {
    return this.u;
  }
  
  public String getDate()
  {
    if (!i.b(this.d)) {}
    try
    {
      this.d = this.d.substring(0, 8);
      Long.parseLong(this.d);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
      localSimpleDateFormat.setLenient(false);
      localSimpleDateFormat.parse(this.d);
      return this.d;
    }
    catch (ParseException localParseException)
    {
      TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", localParseException);
      return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", localThrowable);
    }
    return new SimpleDateFormat("yyyyMMdd").format(new Date());
  }
  
  public long getExpirationTimeMs()
  {
    return this.A;
  }
  
  public String getHour()
  {
    if (this.e.length() < 1) {
      return "00";
    }
    if ((this.e.length() > 0) && (this.e.length() < 2)) {
      return "0" + this.e;
    }
    return this.e;
  }
  
  public String getIcon_res()
  {
    return this.m;
  }
  
  public int getIcon_type()
  {
    return this.j;
  }
  
  public String getIntent()
  {
    return this.r;
  }
  
  public int getLights()
  {
    return this.i;
  }
  
  public String getMin()
  {
    if (this.f.length() < 1) {
      return "00";
    }
    if ((this.f.length() > 0) && (this.f.length() < 2)) {
      return "0" + this.f;
    }
    return this.f;
  }
  
  public long getMsgId()
  {
    return this.x;
  }
  
  public int getNotificationId()
  {
    return this.w;
  }
  
  public int getNsModel()
  {
    return this.D;
  }
  
  public String getPackageDownloadUrl()
  {
    return this.s;
  }
  
  public String getPackageName()
  {
    return this.t;
  }
  
  public int getRing()
  {
    return this.g;
  }
  
  public String getRing_raw()
  {
    return this.l;
  }
  
  public String getSmall_icon()
  {
    return this.n;
  }
  
  public int getStyle_id()
  {
    return this.k;
  }
  
  public String getThreadId()
  {
    return this.F;
  }
  
  public String getThreadSumText()
  {
    return this.G;
  }
  
  public String getTitle()
  {
    return this.b;
  }
  
  public String getTpns_media_resources()
  {
    return this.E;
  }
  
  public int getTtl()
  {
    return this.z;
  }
  
  public int getType()
  {
    return this.a;
  }
  
  public String getUrl()
  {
    return this.q;
  }
  
  public int getVibrate()
  {
    return this.h;
  }
  
  public void setAction_type(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setActivity(String paramString)
  {
    this.p = paramString;
  }
  
  public void setBadgeType(int paramInt)
  {
    this.H = paramInt;
  }
  
  public void setBuilderId(long paramLong)
  {
    this.v = paramLong;
  }
  
  public void setBusiMsgId(long paramLong)
  {
    this.y = paramLong;
  }
  
  public void setChannelId(String paramString)
  {
    this.C = paramString;
  }
  
  public void setColor(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void setContent(String paramString)
  {
    this.c = paramString;
  }
  
  public void setCustomContent(HashMap<String, Object> paramHashMap)
  {
    this.u = new JSONObject(paramHashMap).toString();
  }
  
  public void setDate(String paramString)
  {
    this.d = paramString;
  }
  
  public void setExpirationTimeMs(long paramLong)
  {
    if (paramLong > System.currentTimeMillis())
    {
      this.z = ((int)((paramLong - System.currentTimeMillis()) / 1000L));
      if (this.z < 0) {
        this.z = 2147483647;
      }
      this.A = paramLong;
    }
  }
  
  public void setHour(String paramString)
  {
    this.e = paramString;
  }
  
  public void setIcon_res(String paramString)
  {
    this.m = paramString;
  }
  
  public void setIcon_type(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setIntent(String paramString)
  {
    String str = "";
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      this.r = paramString;
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
  }
  
  public void setLights(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setMin(String paramString)
  {
    this.f = paramString;
  }
  
  public void setMsgId(long paramLong)
  {
    this.x = paramLong;
  }
  
  public void setNotificationId(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setNsModel(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void setPackageDownloadUrl(String paramString)
  {
    this.s = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.t = paramString;
  }
  
  public void setRing(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setRing_raw(String paramString)
  {
    this.l = paramString;
  }
  
  public void setSmall_icon(String paramString)
  {
    this.n = paramString;
  }
  
  public void setStyle_id(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setThreadId(String paramString)
  {
    this.F = paramString;
  }
  
  public void setThreadSumText(String paramString)
  {
    this.G = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.b = paramString;
  }
  
  public void setTpns_media_resources(String paramString)
  {
    this.E = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.q = paramString;
  }
  
  public void setVibrate(int paramInt)
  {
    this.h = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XGLocalMessage [type=").append(this.a).append(", title=").append(this.b).append(", content=").append(this.c).append(", date=").append(this.d).append(", hour=").append(this.e).append(", min=").append(this.f).append(", builderId=").append(this.v).append(", msgid=").append(this.x).append(", templateId=").append(this.templateId).append(", traceId=").append(this.traceId).append(", busiMsgId=").append(this.y).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGLocalMessage
 * JD-Core Version:    0.7.0.1
 */