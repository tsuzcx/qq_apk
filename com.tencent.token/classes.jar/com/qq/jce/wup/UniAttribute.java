package com.qq.jce.wup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class UniAttribute
  extends OldUniAttribute
{
  JceInputStream _is = new JceInputStream();
  protected HashMap _newData = null;
  private HashMap cachedData = new HashMap();
  
  private Object decodeData(byte[] paramArrayOfByte, Object paramObject)
  {
    this._is.wrap(paramArrayOfByte);
    this._is.setServerEncoding(this.encodeName);
    return this._is.read(paramObject, 0, true);
  }
  
  private void saveDataCache(String paramString, Object paramObject)
  {
    this.cachedData.put(paramString, paramObject);
  }
  
  public void clearCacheData()
  {
    this.cachedData.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    if (this._newData != null) {
      return this._newData.containsKey(paramString);
    }
    return this._data.containsKey(paramString);
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    try
    {
      super.decode(paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      this._is.wrap(paramArrayOfByte);
      this._is.setServerEncoding(this.encodeName);
      paramArrayOfByte = new HashMap(1);
      paramArrayOfByte.put("", new byte[0]);
      this._newData = this._is.readMap(paramArrayOfByte, 0, false);
    }
  }
  
  public void decodeVersion2(byte[] paramArrayOfByte)
  {
    super.decode(paramArrayOfByte);
  }
  
  public void decodeVersion3(byte[] paramArrayOfByte)
  {
    this._is.wrap(paramArrayOfByte);
    this._is.setServerEncoding(this.encodeName);
    paramArrayOfByte = new HashMap(1);
    paramArrayOfByte.put("", new byte[0]);
    this._newData = this._is.readMap(paramArrayOfByte, 0, false);
  }
  
  public byte[] encode()
  {
    if (this._newData != null)
    {
      JceOutputStream localJceOutputStream = new JceOutputStream(0);
      localJceOutputStream.setServerEncoding(this.encodeName);
      localJceOutputStream.write(this._newData, 0);
      return JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    }
    return super.encode();
  }
  
  public Object get(String paramString, Object paramObject1, Object paramObject2)
  {
    if (!this._newData.containsKey(paramString)) {
      return paramObject2;
    }
    return getByClass(paramString, paramObject1);
  }
  
  public Object getByClass(String paramString, Object paramObject)
  {
    Object localObject = null;
    if (this._newData != null) {
      if (this._newData.containsKey(paramString)) {}
    }
    while (!this._data.containsKey(paramString)) {
      for (;;)
      {
        return localObject;
        if (this.cachedData.containsKey(paramString)) {
          return this.cachedData.get(paramString);
        }
        localObject = (byte[])this._newData.get(paramString);
        try
        {
          paramObject = decodeData((byte[])localObject, paramObject);
          localObject = paramObject;
          if (paramObject != null)
          {
            saveDataCache(paramString, paramObject);
            return paramObject;
          }
        }
        catch (Exception paramString)
        {
          throw new ObjectCreateException(paramString);
        }
      }
    }
    if (this.cachedData.containsKey(paramString)) {
      return this.cachedData.get(paramString);
    }
    localObject = ((HashMap)this._data.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (Map.Entry)((Iterator)localObject).next();
      String str = (String)((Map.Entry)localObject).getKey();
    }
    for (localObject = (byte[])((Map.Entry)localObject).getValue();; localObject = new byte[0]) {
      try
      {
        this._is.wrap((byte[])localObject);
        this._is.setServerEncoding(this.encodeName);
        paramObject = this._is.read(paramObject, 0, true);
        saveDataCache(paramString, paramObject);
        return paramObject;
      }
      catch (Exception paramString)
      {
        throw new ObjectCreateException(paramString);
      }
    }
  }
  
  public Object getByClass(String paramString, Object paramObject1, Object paramObject2)
  {
    if (this._newData != null) {
      if (this._newData.containsKey(paramString)) {}
    }
    while (!this._data.containsKey(paramString)) {
      for (;;)
      {
        return paramObject2;
        if (this.cachedData.containsKey(paramString)) {
          return this.cachedData.get(paramString);
        }
        paramObject2 = (byte[])this._newData.get(paramString);
        try
        {
          paramObject1 = decodeData(paramObject2, paramObject1);
          paramObject2 = paramObject1;
          if (paramObject1 != null)
          {
            saveDataCache(paramString, paramObject1);
            return paramObject1;
          }
        }
        catch (Exception paramString)
        {
          throw new ObjectCreateException(paramString);
        }
      }
    }
    if (this.cachedData.containsKey(paramString)) {
      return this.cachedData.get(paramString);
    }
    paramObject2 = ((HashMap)this._data.get(paramString)).entrySet().iterator();
    if (paramObject2.hasNext())
    {
      paramObject2 = (Map.Entry)paramObject2.next();
      String str = (String)paramObject2.getKey();
    }
    for (paramObject2 = (byte[])paramObject2.getValue();; paramObject2 = new byte[0]) {
      try
      {
        this._is.wrap(paramObject2);
        this._is.setServerEncoding(this.encodeName);
        paramObject1 = this._is.read(paramObject1, 0, true);
        saveDataCache(paramString, paramObject1);
        return paramObject1;
      }
      catch (Exception paramString)
      {
        throw new ObjectCreateException(paramString);
      }
    }
  }
  
  public Object getJceStruct(String paramString, Object paramObject)
  {
    if (!this._newData.containsKey(paramString)) {
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      if (this.cachedData.containsKey(paramString)) {
        return this.cachedData.get(paramString);
      }
      Object localObject = (byte[])this._newData.get(paramString);
      try
      {
        localObject = decodeData((byte[])localObject, paramObject);
        paramObject = localObject;
        if (localObject == null) {
          continue;
        }
        saveDataCache(paramString, localObject);
        return localObject;
      }
      catch (Exception paramString)
      {
        throw new ObjectCreateException(paramString);
      }
    }
  }
  
  public Set getKeySet()
  {
    if (this._newData != null) {
      return Collections.unmodifiableSet(this._newData.keySet());
    }
    return Collections.unmodifiableSet(this._data.keySet());
  }
  
  public boolean isEmpty()
  {
    if (this._newData != null) {
      return this._newData.isEmpty();
    }
    return this._data.isEmpty();
  }
  
  public void put(String paramString, Object paramObject)
  {
    if (this._newData != null)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("put key can not is null");
      }
      if (paramObject == null) {
        throw new IllegalArgumentException("put value can not is null");
      }
      if ((paramObject instanceof Set)) {
        throw new IllegalArgumentException("can not support Set");
      }
      JceOutputStream localJceOutputStream = new JceOutputStream();
      localJceOutputStream.setServerEncoding(this.encodeName);
      localJceOutputStream.write(paramObject, 0);
      paramObject = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
      this._newData.put(paramString, paramObject);
      return;
    }
    super.put(paramString, paramObject);
  }
  
  public Object remove(String paramString)
  {
    if (this._newData != null)
    {
      if (!this._newData.containsKey(paramString)) {
        return null;
      }
      this._newData.remove(paramString);
      return null;
    }
    return super.remove(paramString);
  }
  
  public Object remove(String paramString, Object paramObject)
  {
    if (!this._newData.containsKey(paramString)) {
      return null;
    }
    if (paramObject != null) {
      return decodeData((byte[])this._newData.remove(paramString), paramObject);
    }
    this._newData.remove(paramString);
    return null;
  }
  
  public int size()
  {
    if (this._newData != null) {
      return this._newData.size();
    }
    return this._data.size();
  }
  
  public void useVersion3()
  {
    this._newData = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.qq.jce.wup.UniAttribute
 * JD-Core Version:    0.7.0.1
 */