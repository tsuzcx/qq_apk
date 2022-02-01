package com.tencent.qqmini.sdk.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PermissionManager
{
  private static final String TAG = "PermissionManager";
  private static final PermissionManager sInstance = new PermissionManager();
  private Map<String, EventInfo> mAllEvents = new HashMap();
  private Map<String, String> mEventScopeMap = new HashMap();
  private ParseStateListener mParseStateListener;
  private Boolean mParsed = Boolean.valueOf(false);
  private Map<String, String> mScopeEventMap = new HashMap();
  private Map<String, PermissionInfo> mScopePermissions = new HashMap();
  private Map<String, PermissionInfo> mSystemPermissions = new HashMap();
  
  private void doParse(PermissionParser... paramVarArgs)
  {
    this.mScopePermissions.clear();
    this.mSystemPermissions.clear();
    this.mAllEvents.clear();
    this.mScopeEventMap.clear();
    this.mEventScopeMap.clear();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = paramVarArgs[i];
      if (!((PermissionParser)localObject).parse()) {}
      for (;;)
      {
        i += 1;
        break;
        this.mScopePermissions.putAll(((PermissionParser)localObject).getScopePermissionMap());
        this.mSystemPermissions.putAll(((PermissionParser)localObject).getSystemPermissionMap());
        this.mAllEvents.putAll(((PermissionParser)localObject).getEventsMap());
      }
    }
    paramVarArgs = this.mAllEvents.values().iterator();
    while (paramVarArgs.hasNext())
    {
      localObject = (EventInfo)paramVarArgs.next();
      Iterator localIterator = ((EventInfo)localObject).requestPermissions.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (isScopePermissionValid(str))
        {
          this.mScopeEventMap.put(str, ((EventInfo)localObject).name);
          this.mEventScopeMap.put(((EventInfo)localObject).name, str);
        }
      }
    }
    this.mParsed = Boolean.valueOf(true);
    if (this.mParseStateListener != null) {
      this.mParseStateListener.onParsed();
    }
  }
  
  public static PermissionManager g()
  {
    return sInstance;
  }
  
  public List<String> getAllPermissions()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mScopePermissions.keySet());
    localArrayList.addAll(this.mSystemPermissions.keySet());
    return localArrayList;
  }
  
  public EventInfo getEvent(String paramString)
  {
    return (EventInfo)this.mAllEvents.get(paramString);
  }
  
  public String getEventByScopePermission(String paramString)
  {
    return (String)this.mScopeEventMap.get(paramString);
  }
  
  public String getEventRequestSystemPermission(String paramString)
  {
    paramString = getEvent(paramString);
    if (paramString != null)
    {
      paramString = paramString.requestPermissions.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (this.mSystemPermissions.containsKey(str)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public PermissionInfo getScopePermission(String paramString)
  {
    return (PermissionInfo)this.mScopePermissions.get(paramString);
  }
  
  public String getScopePermissionByEvent(String paramString)
  {
    return (String)this.mEventScopeMap.get(paramString);
  }
  
  public PermissionInfo getSystemPermission(String paramString)
  {
    return (PermissionInfo)this.mSystemPermissions.get(paramString);
  }
  
  public boolean isScopePermissionValid(String paramString)
  {
    return this.mScopePermissions.containsKey(paramString);
  }
  
  public boolean isSystemPermissionValid(String paramString)
  {
    return this.mSystemPermissions.containsKey(paramString);
  }
  
  public void setParseStateListener(ParseStateListener paramParseStateListener)
  {
    this.mParseStateListener = paramParseStateListener;
  }
  
  public void startParse(PermissionParser... paramVarArgs)
  {
    synchronized (this.mParsed)
    {
      if (!this.mParsed.booleanValue()) {
        doParse(paramVarArgs);
      }
      return;
    }
  }
  
  public void updateScopePermission(String paramString, PermissionInfo paramPermissionInfo)
  {
    this.mScopePermissions.put(paramString, paramPermissionInfo);
  }
  
  public static abstract interface ParseStateListener
  {
    public abstract void onParsed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.PermissionManager
 * JD-Core Version:    0.7.0.1
 */