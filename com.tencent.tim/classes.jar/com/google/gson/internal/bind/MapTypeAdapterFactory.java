package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapTypeAdapterFactory
  implements TypeAdapterFactory
{
  final boolean complexMapKeySerialization;
  private final ConstructorConstructor constructorConstructor;
  
  public MapTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, boolean paramBoolean)
  {
    this.constructorConstructor = paramConstructorConstructor;
    this.complexMapKeySerialization = paramBoolean;
  }
  
  private TypeAdapter<?> getKeyAdapter(Gson paramGson, Type paramType)
  {
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class)) {
      return TypeAdapters.BOOLEAN_AS_STRING;
    }
    return paramGson.getAdapter(TypeToken.get(paramType));
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Object localObject = paramTypeToken.getType();
    if (!Map.class.isAssignableFrom(paramTypeToken.getRawType())) {
      return null;
    }
    localObject = .Gson.Types.getMapKeyAndValueTypes((Type)localObject, .Gson.Types.getRawType((Type)localObject));
    TypeAdapter localTypeAdapter1 = getKeyAdapter(paramGson, localObject[0]);
    TypeAdapter localTypeAdapter2 = paramGson.getAdapter(TypeToken.get(localObject[1]));
    paramTypeToken = this.constructorConstructor.get(paramTypeToken);
    return new Adapter(paramGson, localObject[0], localTypeAdapter1, localObject[1], localTypeAdapter2, paramTypeToken);
  }
  
  final class Adapter<K, V>
    extends TypeAdapter<Map<K, V>>
  {
    private final ObjectConstructor<? extends Map<K, V>> constructor;
    private final TypeAdapter<K> keyTypeAdapter;
    private final TypeAdapter<V> valueTypeAdapter;
    
    public Adapter(Type paramType1, TypeAdapter<K> paramTypeAdapter, Type paramType2, TypeAdapter<V> paramTypeAdapter1, ObjectConstructor<? extends Map<K, V>> paramObjectConstructor)
    {
      this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(paramType1, paramType2, paramTypeAdapter);
      this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(paramType1, paramObjectConstructor, paramTypeAdapter1);
      Object localObject;
      this.constructor = localObject;
    }
    
    private String keyToString(JsonElement paramJsonElement)
    {
      if (paramJsonElement.isJsonPrimitive())
      {
        paramJsonElement = paramJsonElement.getAsJsonPrimitive();
        if (paramJsonElement.isNumber()) {
          return String.valueOf(paramJsonElement.getAsNumber());
        }
        if (paramJsonElement.isBoolean()) {
          return Boolean.toString(paramJsonElement.getAsBoolean());
        }
        if (paramJsonElement.isString()) {
          return paramJsonElement.getAsString();
        }
        throw new AssertionError();
      }
      if (paramJsonElement.isJsonNull()) {
        return "null";
      }
      throw new AssertionError();
    }
    
    public Map<K, V> read(JsonReader paramJsonReader)
      throws IOException
    {
      Object localObject = paramJsonReader.peek();
      if (localObject == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      Map localMap = (Map)this.constructor.construct();
      if (localObject == JsonToken.BEGIN_ARRAY)
      {
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginArray();
          localObject = this.keyTypeAdapter.read(paramJsonReader);
          if (localMap.put(localObject, this.valueTypeAdapter.read(paramJsonReader)) != null) {
            throw new JsonSyntaxException("duplicate key: " + localObject);
          }
          paramJsonReader.endArray();
        }
        paramJsonReader.endArray();
        return localMap;
      }
      paramJsonReader.beginObject();
      while (paramJsonReader.hasNext())
      {
        JsonReaderInternalAccess.INSTANCE.promoteNameToValue(paramJsonReader);
        localObject = this.keyTypeAdapter.read(paramJsonReader);
        if (localMap.put(localObject, this.valueTypeAdapter.read(paramJsonReader)) != null) {
          throw new JsonSyntaxException("duplicate key: " + localObject);
        }
      }
      paramJsonReader.endObject();
      return localMap;
    }
    
    public void write(JsonWriter paramJsonWriter, Map<K, V> paramMap)
      throws IOException
    {
      int m = 0;
      int k = 0;
      if (paramMap == null)
      {
        paramJsonWriter.nullValue();
        return;
      }
      if (!MapTypeAdapterFactory.this.complexMapKeySerialization)
      {
        paramJsonWriter.beginObject();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          paramJsonWriter.name(String.valueOf(((Map.Entry)localObject).getKey()));
          this.valueTypeAdapter.write(paramJsonWriter, ((Map.Entry)localObject).getValue());
        }
        paramJsonWriter.endObject();
        return;
      }
      Object localObject = new ArrayList(paramMap.size());
      ArrayList localArrayList = new ArrayList(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      int i = 0;
      if (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        JsonElement localJsonElement = this.keyTypeAdapter.toJsonTree(localEntry.getKey());
        ((List)localObject).add(localJsonElement);
        localArrayList.add(localEntry.getValue());
        if ((localJsonElement.isJsonArray()) || (localJsonElement.isJsonObject())) {}
        for (j = 1;; j = 0)
        {
          i = j | i;
          break;
        }
      }
      if (i != 0)
      {
        paramJsonWriter.beginArray();
        j = ((List)localObject).size();
        i = k;
        while (i < j)
        {
          paramJsonWriter.beginArray();
          Streams.write((JsonElement)((List)localObject).get(i), paramJsonWriter);
          this.valueTypeAdapter.write(paramJsonWriter, localArrayList.get(i));
          paramJsonWriter.endArray();
          i += 1;
        }
        paramJsonWriter.endArray();
        return;
      }
      paramJsonWriter.beginObject();
      int j = ((List)localObject).size();
      i = m;
      while (i < j)
      {
        paramJsonWriter.name(keyToString((JsonElement)((List)localObject).get(i)));
        this.valueTypeAdapter.write(paramJsonWriter, localArrayList.get(i));
        i += 1;
      }
      paramJsonWriter.endObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.MapTypeAdapterFactory
 * JD-Core Version:    0.7.0.1
 */