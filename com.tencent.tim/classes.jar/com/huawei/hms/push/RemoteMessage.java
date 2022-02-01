package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.huawei.hms.push.c.c;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.api.push.c.a.a.a;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class RemoteMessage
  implements Parcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessage.1();
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_NORMAL = 2;
  public static final int PRIORITY_UNKNOWN = 0;
  private static final String[] a = new String[0];
  private static final int[] b = new int[0];
  private static final long[] c = new long[0];
  private static final HashMap<String, Object> d = new HashMap(6);
  private static final HashMap<String, Object> e;
  private static final HashMap<String, Object> f;
  private static final HashMap<String, Object> g;
  private static final HashMap<String, Object> h;
  private Bundle i;
  private Notification j;
  
  static
  {
    d.put("from", "");
    d.put("collapseKey", "");
    d.put("sendTime", "");
    d.put("ttl", Integer.valueOf(86400));
    d.put("urgency", Integer.valueOf(2));
    d.put("oriUrgency", Integer.valueOf(2));
    e = new HashMap(8);
    e.put("title_loc_key", "");
    e.put("body_loc_key", "");
    e.put("notifyIcon", "");
    e.put("title_loc_args", a);
    e.put("body_loc_args", a);
    e.put("ticker", "");
    e.put("notifyTitle", "");
    e.put("content", "");
    f = new HashMap(8);
    f.put("icon", "");
    f.put("color", "");
    f.put("sound", "");
    f.put("defaultLightSettings", Integer.valueOf(1));
    f.put("lightSettings", b);
    f.put("defaultSound", Integer.valueOf(1));
    f.put("defaultVibrateTimings", Integer.valueOf(1));
    f.put("vibrateTimings", c);
    g = new HashMap(8);
    g.put("tag", "");
    g.put("when", "");
    g.put("localOnly", Integer.valueOf(1));
    g.put("badgeSetNum", "");
    g.put("priority", "");
    g.put("autoCancel", Integer.valueOf(1));
    g.put("visibility", "");
    g.put("channelId", "");
    h = new HashMap(3);
    h.put("acn", "");
    h.put("intentUri", "");
    h.put("url", "");
  }
  
  public RemoteMessage(Bundle paramBundle)
  {
    this.i = a(paramBundle);
  }
  
  public RemoteMessage(Parcel paramParcel)
  {
    this.i = paramParcel.readBundle();
    this.j = ((Notification)paramParcel.readSerializable());
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = b(paramBundle);
    JSONObject localJSONObject2 = a(localJSONObject1);
    String str1 = c.a(localJSONObject2, "data", null);
    localBundle.putString("device_token", paramBundle.getString("device_token"));
    JSONObject localJSONObject3 = b(localJSONObject2);
    JSONObject localJSONObject4 = c(localJSONObject3);
    JSONObject localJSONObject5 = d(localJSONObject3);
    if ((paramBundle.getInt("inputType") == 1) && (a(localJSONObject2, localJSONObject3, str1)))
    {
      localBundle.putString("data", a.b(paramBundle.getByteArray("message_body")));
      return localBundle;
    }
    String str2 = paramBundle.getString("to");
    paramBundle = paramBundle.getString("message_type");
    String str3 = c.a(localJSONObject2, "msgId", null);
    localBundle.putString("to", str2);
    localBundle.putString("data", str1);
    localBundle.putString("msgId", str3);
    localBundle.putString("message_type", paramBundle);
    c.a(localJSONObject1, localBundle, d);
    localBundle.putBundle("notification", a(localJSONObject1, localJSONObject2, localJSONObject3, localJSONObject4, localJSONObject5));
    return localBundle;
  }
  
  private Bundle a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3, JSONObject paramJSONObject4, JSONObject paramJSONObject5)
  {
    Bundle localBundle = new Bundle();
    c.a(paramJSONObject3, localBundle, e);
    c.a(paramJSONObject4, localBundle, f);
    c.a(paramJSONObject1, localBundle, g);
    c.a(paramJSONObject5, localBundle, h);
    localBundle.putInt("notifyId", c.a(paramJSONObject2, "notifyId", 0));
    return localBundle;
  }
  
  private static JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("msgContent");
    }
    return null;
  }
  
  private boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    return (paramJSONObject1 == null) || ((TextUtils.isEmpty(paramString)) && (paramJSONObject2 == null));
  }
  
  private static JSONObject b(Bundle paramBundle)
  {
    try
    {
      paramBundle = new JSONObject(a.b(paramBundle.getByteArray("message_body")));
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
    }
    return null;
  }
  
  private static JSONObject b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("psContent");
    }
    return null;
  }
  
  private static JSONObject c(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("notifyDetail");
    }
    return null;
  }
  
  private static JSONObject d(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("param");
    }
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public String getCollapseKey()
  {
    return this.i.getString("collapseKey");
  }
  
  public String getData()
  {
    return this.i.getString("data");
  }
  
  public Map<String, String> getDataOfMap()
  {
    localHashMap = new HashMap();
    Object localObject = this.i.getString("data");
    if ((localObject != null) && (!((String)localObject).trim().isEmpty())) {
      try
      {
        localObject = new JSONObject((String)localObject);
        Iterator localIterator = ((JSONObject)localObject).keys();
        while (localIterator.hasNext())
        {
          String str = String.valueOf(localIterator.next());
          localHashMap.put(str, String.valueOf(((JSONObject)localObject).get(str)));
        }
        return localHashMap;
      }
      catch (JSONException localJSONException)
      {
        HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
      }
    }
  }
  
  public String getFrom()
  {
    return this.i.getString("from");
  }
  
  public String getMessageId()
  {
    return this.i.getString("msgId");
  }
  
  public String getMessageType()
  {
    return this.i.getString("message_type");
  }
  
  public Notification getNotification()
  {
    Bundle localBundle = this.i.getBundle("notification");
    if ((this.j == null) && (localBundle != null)) {
      this.j = new Notification(localBundle, null);
    }
    if (this.j == null) {
      this.j = new Notification(new Bundle(), null);
    }
    return this.j;
  }
  
  public int getOriginalUrgency()
  {
    int m = this.i.getInt("oriUrgency");
    int k = m;
    if (m != 1)
    {
      k = m;
      if (m != 2) {
        k = 0;
      }
    }
    return k;
  }
  
  public long getSentTime()
  {
    long l = 0L;
    try
    {
      String str = this.i.getString("sendTime");
      if (!TextUtils.isEmpty(str)) {
        l = Long.parseLong(str);
      }
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
    }
    return 0L;
  }
  
  public String getTo()
  {
    return this.i.getString("to");
  }
  
  public String getToken()
  {
    return this.i.getString("device_token");
  }
  
  public int getTtl()
  {
    return this.i.getInt("ttl");
  }
  
  public int getUrgency()
  {
    int m = this.i.getInt("urgency");
    int k = m;
    if (m != 1)
    {
      k = m;
      if (m != 2) {
        k = 0;
      }
    }
    return k;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.i);
    paramParcel.writeSerializable(this.j);
  }
  
  public static class Builder
  {
    private final Bundle a = new Bundle();
    private final Map<String, String> b = new HashMap();
    
    public Builder(String paramString)
    {
      this.a.putString("to", paramString);
    }
    
    public Builder addData(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("add data failed, key is null.");
      }
      this.b.put(paramString1, paramString2);
      return this;
    }
    
    public RemoteMessage build()
    {
      Bundle localBundle = new Bundle();
      localJSONObject1 = new JSONObject();
      try
      {
        Object localObject1 = this.b.entrySet().iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localJSONObject1.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        }
        try
        {
          localObject1 = this.a.getString("msgId");
          localObject2 = localJSONObject1.toString();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("collapseKey", this.a.getString("collapseKey"));
          localJSONObject2.put("ttl", this.a.getInt("ttl"));
          JSONObject localJSONObject3 = new JSONObject();
          if (localJSONObject1.length() != 0) {
            localJSONObject3.put("data", localObject2);
          }
          localJSONObject3.put("msgId", localObject1);
          localJSONObject2.put("msgContent", localJSONObject3);
          localJSONException1.putByteArray("message_body", localJSONObject2.toString().getBytes(com.huawei.hms.support.api.push.c.a.a.b.a));
          localJSONException1.putString("to", this.a.getString("to"));
          localJSONException1.putString("message_type", this.a.getString("message_type"));
          return new RemoteMessage(localJSONException1);
        }
        catch (JSONException localJSONException2)
        {
          HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
          throw new PushException("send message failed");
        }
      }
      catch (JSONException localJSONException1)
      {
        HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
        throw new PushException("send message failed");
      }
    }
    
    public Builder clearData()
    {
      this.b.clear();
      return this;
    }
    
    public Builder setCollapseKey(String paramString)
    {
      this.a.putString("collapseKey", paramString);
      return this;
    }
    
    public Builder setData(Map<String, String> paramMap)
    {
      this.b.clear();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        this.b.put(localEntry.getKey(), localEntry.getValue());
      }
      return this;
    }
    
    public Builder setMessageId(String paramString)
    {
      this.a.putString("msgId", paramString);
      return this;
    }
    
    public Builder setMessageType(String paramString)
    {
      this.a.putString("message_type", paramString);
      return this;
    }
    
    public Builder setTtl(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1209600)) {
        throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
      }
      this.a.putInt("ttl", paramInt);
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MessagePriority {}
  
  public static class Notification
    implements Serializable
  {
    private final long[] A;
    private final String B;
    private final String a;
    private final String b;
    private final String[] c;
    private final String d;
    private final String e;
    private final String[] f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final Uri n;
    private final int o;
    private final String p;
    private final int q;
    private final int r;
    private final int s;
    private final int[] t;
    private final String u;
    private final int v;
    private final String w;
    private final int x;
    private final String y;
    private final String z;
    
    private Notification(Bundle paramBundle)
    {
      this.a = paramBundle.getString("notifyTitle");
      this.d = paramBundle.getString("content");
      this.b = paramBundle.getString("title_loc_key");
      this.e = paramBundle.getString("body_loc_key");
      this.c = paramBundle.getStringArray("title_loc_args");
      this.f = paramBundle.getStringArray("body_loc_args");
      this.g = paramBundle.getString("icon");
      this.j = paramBundle.getString("color");
      this.h = paramBundle.getString("sound");
      this.i = paramBundle.getString("tag");
      this.m = paramBundle.getString("channelId");
      this.k = paramBundle.getString("acn");
      this.l = paramBundle.getString("intentUri");
      this.o = paramBundle.getInt("notifyId");
      Object localObject = paramBundle.getString("url");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = Uri.parse((String)localObject);; localObject = null)
      {
        this.n = ((Uri)localObject);
        this.p = paramBundle.getString("notifyIcon");
        this.q = paramBundle.getInt("defaultLightSettings");
        this.r = paramBundle.getInt("defaultSound");
        this.s = paramBundle.getInt("defaultVibrateTimings");
        this.t = paramBundle.getIntArray("lightSettings");
        this.u = paramBundle.getString("when");
        this.v = paramBundle.getInt("localOnly");
        this.w = paramBundle.getString("badgeSetNum", null);
        this.x = paramBundle.getInt("autoCancel");
        this.y = paramBundle.getString("priority", null);
        this.z = paramBundle.getString("ticker");
        this.A = paramBundle.getLongArray("vibrateTimings");
        this.B = paramBundle.getString("visibility", null);
        return;
      }
    }
    
    private Integer a(String paramString)
    {
      Integer localInteger = null;
      if (paramString != null) {}
      try
      {
        localInteger = Integer.valueOf(paramString);
        return localInteger;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        HMSLog.w("RemoteMessage", "NumberFormatException: get " + paramString + " failed.");
      }
      return null;
    }
    
    public Integer getBadgeNumber()
    {
      return a(this.w);
    }
    
    public String getBody()
    {
      return this.d;
    }
    
    public String[] getBodyLocalizationArgs()
    {
      if (this.f == null) {
        return null;
      }
      return (String[])this.f.clone();
    }
    
    public String getBodyLocalizationKey()
    {
      return this.e;
    }
    
    public String getChannelId()
    {
      return this.m;
    }
    
    public String getClickAction()
    {
      return this.k;
    }
    
    public String getColor()
    {
      return this.j;
    }
    
    public String getIcon()
    {
      return this.g;
    }
    
    public Uri getImageUrl()
    {
      if (this.p == null) {
        return null;
      }
      return Uri.parse(this.p);
    }
    
    public Integer getImportance()
    {
      return a(this.y);
    }
    
    public String getIntentUri()
    {
      return this.l;
    }
    
    public int[] getLightSettings()
    {
      if (this.t == null) {
        return null;
      }
      return (int[])this.t.clone();
    }
    
    public Uri getLink()
    {
      return this.n;
    }
    
    public int getNotifyId()
    {
      return this.o;
    }
    
    public String getSound()
    {
      return this.h;
    }
    
    public String getTag()
    {
      return this.i;
    }
    
    public String getTicker()
    {
      return this.z;
    }
    
    public String getTitle()
    {
      return this.a;
    }
    
    public String[] getTitleLocalizationArgs()
    {
      if (this.c == null) {
        return null;
      }
      return (String[])this.c.clone();
    }
    
    public String getTitleLocalizationKey()
    {
      return this.b;
    }
    
    public long[] getVibrateConfig()
    {
      if (this.A == null) {
        return null;
      }
      return (long[])this.A.clone();
    }
    
    public Integer getVisibility()
    {
      return a(this.B);
    }
    
    public Long getWhen()
    {
      Long localLong = null;
      if (!TextUtils.isEmpty(this.u)) {}
      try
      {
        long l1 = com.huawei.hms.push.c.b.a(this.u);
        localLong = Long.valueOf(l1);
        return localLong;
      }
      catch (ParseException localParseException)
      {
        HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
        return null;
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
      {
        HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
      }
      return null;
    }
    
    public boolean isAutoCancel()
    {
      return this.x == 1;
    }
    
    public boolean isDefaultLight()
    {
      return this.q == 1;
    }
    
    public boolean isDefaultSound()
    {
      return this.r == 1;
    }
    
    public boolean isDefaultVibrate()
    {
      return this.s == 1;
    }
    
    public boolean isLocalOnly()
    {
      return this.v == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.RemoteMessage
 * JD-Core Version:    0.7.0.1
 */