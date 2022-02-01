package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class ResolveFieldDeserializer
  extends FieldDeserializer
{
  private final Collection collection;
  private final int index;
  private final Object key;
  private final List list;
  private final Map map;
  private final DefaultJSONParser parser;
  
  public ResolveFieldDeserializer(DefaultJSONParser paramDefaultJSONParser, List paramList, int paramInt)
  {
    super(null, null, 0);
    this.parser = paramDefaultJSONParser;
    this.index = paramInt;
    this.list = paramList;
    this.key = null;
    this.map = null;
    this.collection = null;
  }
  
  public ResolveFieldDeserializer(Collection paramCollection)
  {
    super(null, null, 0);
    this.parser = null;
    this.index = -1;
    this.list = null;
    this.key = null;
    this.map = null;
    this.collection = paramCollection;
  }
  
  public ResolveFieldDeserializer(Map paramMap, Object paramObject)
  {
    super(null, null, 0);
    this.parser = null;
    this.index = -1;
    this.list = null;
    this.key = paramObject;
    this.map = paramMap;
    this.collection = null;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {}
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    if (this.map != null) {
      this.map.put(this.key, paramObject2);
    }
    JSONArray localJSONArray;
    Object localObject;
    do
    {
      do
      {
        return;
        if (this.collection != null)
        {
          this.collection.add(paramObject2);
          return;
        }
        this.list.set(this.index, paramObject2);
      } while (!(this.list instanceof JSONArray));
      localJSONArray = (JSONArray)this.list;
      localObject = localJSONArray.getRelatedArray();
    } while ((localObject == null) || (Array.getLength(localObject) <= this.index));
    paramObject1 = paramObject2;
    if (localJSONArray.getComponentType() != null) {
      paramObject1 = TypeUtils.cast(paramObject2, localJSONArray.getComponentType(), this.parser.config);
    }
    Array.set(localObject, this.index, paramObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.parser.ResolveFieldDeserializer
 * JD-Core Version:    0.7.0.1
 */