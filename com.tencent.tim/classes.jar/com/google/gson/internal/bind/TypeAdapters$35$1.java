package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters$35$1
  extends TypeAdapter<T1>
{
  TypeAdapters$35$1(TypeAdapters.35 param35, Class paramClass) {}
  
  public T1 read(JsonReader paramJsonReader)
    throws IOException
  {
    paramJsonReader = this.this$0.val$typeAdapter.read(paramJsonReader);
    if ((paramJsonReader != null) && (!this.val$requestedType.isInstance(paramJsonReader))) {
      throw new JsonSyntaxException("Expected a " + this.val$requestedType.getName() + " but was " + paramJsonReader.getClass().getName());
    }
    return paramJsonReader;
  }
  
  public void write(JsonWriter paramJsonWriter, T1 paramT1)
    throws IOException
  {
    this.this$0.val$typeAdapter.write(paramJsonWriter, paramT1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.35.1
 * JD-Core Version:    0.7.0.1
 */