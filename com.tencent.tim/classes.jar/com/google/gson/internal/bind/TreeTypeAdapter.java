package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T>
  extends TypeAdapter<T>
{
  private final TreeTypeAdapter<T>.GsonContextImpl context = new GsonContextImpl(null);
  private TypeAdapter<T> delegate;
  private final JsonDeserializer<T> deserializer;
  final Gson gson;
  private final JsonSerializer<T> serializer;
  private final TypeAdapterFactory skipPast;
  private final TypeToken<T> typeToken;
  
  public TreeTypeAdapter(JsonSerializer<T> paramJsonSerializer, JsonDeserializer<T> paramJsonDeserializer, Gson paramGson, TypeToken<T> paramTypeToken, TypeAdapterFactory paramTypeAdapterFactory)
  {
    this.serializer = paramJsonSerializer;
    this.deserializer = paramJsonDeserializer;
    this.gson = paramGson;
    this.typeToken = paramTypeToken;
    this.skipPast = paramTypeAdapterFactory;
  }
  
  private TypeAdapter<T> delegate()
  {
    TypeAdapter localTypeAdapter = this.delegate;
    if (localTypeAdapter != null) {
      return localTypeAdapter;
    }
    localTypeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
    this.delegate = localTypeAdapter;
    return localTypeAdapter;
  }
  
  public static TypeAdapterFactory newFactory(TypeToken<?> paramTypeToken, Object paramObject)
  {
    return new SingleTypeFactory(paramObject, paramTypeToken, false, null);
  }
  
  public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> paramTypeToken, Object paramObject)
  {
    if (paramTypeToken.getType() == paramTypeToken.getRawType()) {}
    for (boolean bool = true;; bool = false) {
      return new SingleTypeFactory(paramObject, paramTypeToken, bool, null);
    }
  }
  
  public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> paramClass, Object paramObject)
  {
    return new SingleTypeFactory(paramObject, null, false, paramClass);
  }
  
  public T read(JsonReader paramJsonReader)
    throws IOException
  {
    if (this.deserializer == null) {
      return delegate().read(paramJsonReader);
    }
    paramJsonReader = Streams.parse(paramJsonReader);
    if (paramJsonReader.isJsonNull()) {
      return null;
    }
    return this.deserializer.deserialize(paramJsonReader, this.typeToken.getType(), this.context);
  }
  
  public void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (this.serializer == null)
    {
      delegate().write(paramJsonWriter, paramT);
      return;
    }
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    Streams.write(this.serializer.serialize(paramT, this.typeToken.getType(), this.context), paramJsonWriter);
  }
  
  final class GsonContextImpl
    implements JsonDeserializationContext, JsonSerializationContext
  {
    private GsonContextImpl() {}
    
    public <R> R deserialize(JsonElement paramJsonElement, Type paramType)
      throws JsonParseException
    {
      return TreeTypeAdapter.this.gson.fromJson(paramJsonElement, paramType);
    }
    
    public JsonElement serialize(Object paramObject)
    {
      return TreeTypeAdapter.this.gson.toJsonTree(paramObject);
    }
    
    public JsonElement serialize(Object paramObject, Type paramType)
    {
      return TreeTypeAdapter.this.gson.toJsonTree(paramObject, paramType);
    }
  }
  
  static final class SingleTypeFactory
    implements TypeAdapterFactory
  {
    private final JsonDeserializer<?> deserializer;
    private final TypeToken<?> exactType;
    private final Class<?> hierarchyType;
    private final boolean matchRawType;
    private final JsonSerializer<?> serializer;
    
    SingleTypeFactory(Object paramObject, TypeToken<?> paramTypeToken, boolean paramBoolean, Class<?> paramClass)
    {
      JsonSerializer localJsonSerializer;
      if ((paramObject instanceof JsonSerializer))
      {
        localJsonSerializer = (JsonSerializer)paramObject;
        this.serializer = localJsonSerializer;
        if (!(paramObject instanceof JsonDeserializer)) {
          break label85;
        }
        paramObject = (JsonDeserializer)paramObject;
        label35:
        this.deserializer = paramObject;
        if ((this.serializer == null) && (this.deserializer == null)) {
          break label90;
        }
      }
      label85:
      label90:
      for (boolean bool = true;; bool = false)
      {
        .Gson.Preconditions.checkArgument(bool);
        this.exactType = paramTypeToken;
        this.matchRawType = paramBoolean;
        this.hierarchyType = paramClass;
        return;
        localJsonSerializer = null;
        break;
        paramObject = null;
        break label35;
      }
    }
    
    public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
    {
      boolean bool;
      if (this.exactType != null) {
        if ((this.exactType.equals(paramTypeToken)) || ((this.matchRawType) && (this.exactType.getType() == paramTypeToken.getRawType()))) {
          bool = true;
        }
      }
      while (bool)
      {
        return new TreeTypeAdapter(this.serializer, this.deserializer, paramGson, paramTypeToken, this);
        bool = false;
        continue;
        bool = this.hierarchyType.isAssignableFrom(paramTypeToken.getRawType());
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.TreeTypeAdapter
 * JD-Core Version:    0.7.0.1
 */