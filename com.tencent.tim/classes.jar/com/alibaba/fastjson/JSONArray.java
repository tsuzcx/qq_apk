package com.alibaba.fastjson;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class JSONArray
  extends JSON
  implements Serializable, Cloneable, List<Object>, RandomAccess
{
  protected transient Type componentType;
  private final List<Object> list;
  protected transient Object relatedArray;
  
  public JSONArray()
  {
    this.list = new ArrayList(10);
  }
  
  public JSONArray(int paramInt)
  {
    this.list = new ArrayList(paramInt);
  }
  
  public JSONArray(List<Object> paramList)
  {
    this.list = paramList;
  }
  
  public void add(int paramInt, Object paramObject)
  {
    this.list.add(paramInt, paramObject);
  }
  
  public boolean add(Object paramObject)
  {
    return this.list.add(paramObject);
  }
  
  public boolean addAll(int paramInt, Collection<? extends Object> paramCollection)
  {
    return this.list.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends Object> paramCollection)
  {
    return this.list.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.list.clear();
  }
  
  public Object clone()
  {
    return new JSONArray(new ArrayList(this.list));
  }
  
  public boolean contains(Object paramObject)
  {
    return this.list.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.list.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.list.equals(paramObject);
  }
  
  public Object get(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public BigDecimal getBigDecimal(int paramInt)
  {
    return TypeUtils.castToBigDecimal(get(paramInt));
  }
  
  public BigInteger getBigInteger(int paramInt)
  {
    return TypeUtils.castToBigInteger(get(paramInt));
  }
  
  public Boolean getBoolean(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return null;
    }
    return TypeUtils.castToBoolean(localObject);
  }
  
  public boolean getBooleanValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return false;
    }
    return TypeUtils.castToBoolean(localObject).booleanValue();
  }
  
  public Byte getByte(int paramInt)
  {
    return TypeUtils.castToByte(get(paramInt));
  }
  
  public byte getByteValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    return TypeUtils.castToByte(localObject).byteValue();
  }
  
  public Type getComponentType()
  {
    return this.componentType;
  }
  
  public Date getDate(int paramInt)
  {
    return TypeUtils.castToDate(get(paramInt));
  }
  
  public Double getDouble(int paramInt)
  {
    return TypeUtils.castToDouble(get(paramInt));
  }
  
  public double getDoubleValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0D;
    }
    return TypeUtils.castToDouble(localObject).doubleValue();
  }
  
  public Float getFloat(int paramInt)
  {
    return TypeUtils.castToFloat(get(paramInt));
  }
  
  public float getFloatValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0F;
    }
    return TypeUtils.castToFloat(localObject).floatValue();
  }
  
  public int getIntValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    return TypeUtils.castToInt(localObject).intValue();
  }
  
  public Integer getInteger(int paramInt)
  {
    return TypeUtils.castToInt(get(paramInt));
  }
  
  public JSONArray getJSONArray(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    if ((localObject instanceof JSONArray)) {
      return (JSONArray)localObject;
    }
    return (JSONArray)toJSON(localObject);
  }
  
  public JSONObject getJSONObject(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    if ((localObject instanceof JSONObject)) {
      return (JSONObject)localObject;
    }
    return (JSONObject)toJSON(localObject);
  }
  
  public Long getLong(int paramInt)
  {
    return TypeUtils.castToLong(get(paramInt));
  }
  
  public long getLongValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0L;
    }
    return TypeUtils.castToLong(localObject).longValue();
  }
  
  public <T> T getObject(int paramInt, Class<T> paramClass)
  {
    return TypeUtils.castToJavaBean(this.list.get(paramInt), paramClass);
  }
  
  public Object getRelatedArray()
  {
    return this.relatedArray;
  }
  
  public Short getShort(int paramInt)
  {
    return TypeUtils.castToShort(get(paramInt));
  }
  
  public short getShortValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    return TypeUtils.castToShort(localObject).shortValue();
  }
  
  public String getString(int paramInt)
  {
    return TypeUtils.castToString(get(paramInt));
  }
  
  public int hashCode()
  {
    return this.list.hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return this.list.indexOf(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.list.isEmpty();
  }
  
  public Iterator<Object> iterator()
  {
    return this.list.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return this.list.lastIndexOf(paramObject);
  }
  
  public ListIterator<Object> listIterator()
  {
    return this.list.listIterator();
  }
  
  public ListIterator<Object> listIterator(int paramInt)
  {
    return this.list.listIterator(paramInt);
  }
  
  public Object remove(int paramInt)
  {
    return this.list.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    return this.list.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.list.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.list.retainAll(paramCollection);
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    return this.list.set(paramInt, paramObject);
  }
  
  public void setComponentType(Type paramType)
  {
    this.componentType = paramType;
  }
  
  public void setRelatedArray(Object paramObject)
  {
    this.relatedArray = paramObject;
  }
  
  public int size()
  {
    return this.list.size();
  }
  
  public List<Object> subList(int paramInt1, int paramInt2)
  {
    return this.list.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray()
  {
    return this.list.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.list.toArray(paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.JSONArray
 * JD-Core Version:    0.7.0.1
 */