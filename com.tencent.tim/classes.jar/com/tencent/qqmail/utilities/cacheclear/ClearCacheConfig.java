package com.tencent.qqmail.utilities.cacheclear;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class ClearCacheConfig
{
  private static final long unit = 1024L;
  private long clearAttachTime;
  private long clearAvatarSize;
  private long clearCardTime;
  private long clearImageCacheTime;
  private long clearLogTime;
  private long key;
  private long preLoad;
  
  public long getClearAttachTime()
  {
    return this.clearAttachTime;
  }
  
  public long getClearAvatarSize()
  {
    return this.clearAvatarSize;
  }
  
  public long getClearCardTime()
  {
    return this.clearCardTime;
  }
  
  public long getClearImageCacheTime()
  {
    return this.clearImageCacheTime;
  }
  
  public long getClearLogTime()
  {
    return this.clearLogTime;
  }
  
  public long getKey()
  {
    return this.key;
  }
  
  public long getPreLoad()
  {
    return this.preLoad;
  }
  
  public void parseWithDictionary(String paramString)
  {
    int i = 0;
    long l = FileUtil.getSdcardUsableSpace() / 1073741824L;
    JSONObject localJSONObject = JSONObject.parseObject(paramString);
    ArrayList localArrayList = new ArrayList();
    paramString = localJSONObject.keySet().iterator();
    while (paramString.hasNext()) {
      localArrayList.add(Long.valueOf(Long.valueOf((String)paramString.next()).longValue()));
    }
    Collections.sort(localArrayList);
    if (localArrayList.size() > 0)
    {
      paramString = String.valueOf(localArrayList.get(0));
      if (i >= localArrayList.size()) {
        break label323;
      }
      if (i != localArrayList.size() - 1) {
        break label286;
      }
      paramString = String.valueOf(localArrayList.get(localArrayList.size() - 1));
    }
    label286:
    label323:
    for (;;)
    {
      setKey(Long.valueOf(paramString).longValue());
      paramString = localJSONObject.getJSONObject(paramString);
      if (paramString != null)
      {
        if (paramString.getLong("b") != null) {
          setClearCardTime(paramString.getLong("b").longValue());
        }
        if (paramString.getLong("c") != null) {
          setClearAvatarSize(paramString.getLong("c").longValue());
        }
        if (paramString.getLong("d") != null) {
          setClearLogTime(paramString.getLong("d").longValue());
        }
        if (paramString.getLong("e") != null) {
          setClearImageCacheTime(paramString.getLong("e").longValue());
        }
        if (paramString.getLong("f") != null) {
          setClearAttachTime(paramString.getLong("f").longValue());
        }
        if (paramString.getLong("p") != null) {
          setPreLoad(paramString.getLong("p").longValue());
        }
      }
      return;
      if (l <= ((Long)localArrayList.get(i)).longValue())
      {
        paramString = String.valueOf(localArrayList.get(i));
      }
      else
      {
        i += 1;
        break;
      }
    }
  }
  
  public void setClearAttachTime(long paramLong)
  {
    this.clearAttachTime = paramLong;
  }
  
  public void setClearAvatarSize(long paramLong)
  {
    this.clearAvatarSize = paramLong;
  }
  
  public void setClearCardTime(long paramLong)
  {
    this.clearCardTime = paramLong;
  }
  
  public void setClearImageCacheTime(long paramLong)
  {
    this.clearImageCacheTime = paramLong;
  }
  
  public void setClearLogTime(long paramLong)
  {
    this.clearLogTime = paramLong;
  }
  
  public void setKey(long paramLong)
  {
    this.key = paramLong;
  }
  
  public void setPreLoad(long paramLong)
  {
    this.preLoad = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cacheclear.ClearCacheConfig
 * JD-Core Version:    0.7.0.1
 */