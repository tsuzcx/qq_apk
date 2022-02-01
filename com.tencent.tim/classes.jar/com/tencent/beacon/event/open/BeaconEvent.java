package com.tencent.beacon.event.open;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.event.c.d;
import java.util.HashMap;
import java.util.Map;

public final class BeaconEvent
{
  private String a;
  private String b;
  private EventType c;
  private boolean d;
  private Map<String, String> e;
  
  private BeaconEvent(String paramString1, String paramString2, EventType paramEventType, boolean paramBoolean, Map<String, String> paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramEventType;
    this.d = paramBoolean;
    this.e = paramMap;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static Builder newBuilder(BeaconEvent paramBeaconEvent)
  {
    return new Builder(paramBeaconEvent, null);
  }
  
  public String getAppKey()
  {
    return this.a;
  }
  
  public String getCode()
  {
    return this.b;
  }
  
  public String getLogidPrefix()
  {
    switch (a.a[this.c.ordinal()])
    {
    default: 
      return "";
    case 5: 
    case 6: 
      return "Y";
    case 3: 
    case 4: 
      return "I";
    }
    return "N";
  }
  
  public Map<String, String> getParams()
  {
    return this.e;
  }
  
  public EventType getType()
  {
    return this.c;
  }
  
  public boolean isSucceed()
  {
    return this.d;
  }
  
  public void setAppKey(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setParams(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  public void setSucceed(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setType(EventType paramEventType)
  {
    this.c = paramEventType;
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public static final class Builder
  {
    private String a;
    private String b;
    private EventType c = EventType.NORMAL;
    private boolean d = true;
    private Map<String, String> e = new HashMap();
    
    private Builder() {}
    
    private Builder(BeaconEvent paramBeaconEvent)
    {
      this.a = BeaconEvent.a(paramBeaconEvent);
      this.b = BeaconEvent.b(paramBeaconEvent);
      this.c = BeaconEvent.c(paramBeaconEvent);
      this.d = BeaconEvent.d(paramBeaconEvent);
      this.e.putAll(BeaconEvent.e(paramBeaconEvent));
    }
    
    public BeaconEvent build()
    {
      String str = d.b(this.b);
      if (TextUtils.isEmpty(this.a)) {
        this.a = c.d().f();
      }
      return new BeaconEvent(this.a, str, this.c, this.d, this.e, null);
    }
    
    public Builder withAppKey(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public Builder withCode(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public Builder withIsSucceed(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public Builder withParams(@NonNull String paramString1, String paramString2)
    {
      this.e.put(paramString1, paramString2);
      return this;
    }
    
    public Builder withParams(Map<String, String> paramMap)
    {
      if (paramMap != null) {
        this.e.putAll(paramMap);
      }
      return this;
    }
    
    public Builder withType(EventType paramEventType)
    {
      this.c = paramEventType;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconEvent
 * JD-Core Version:    0.7.0.1
 */