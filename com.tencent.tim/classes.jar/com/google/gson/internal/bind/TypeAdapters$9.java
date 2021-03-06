package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

final class TypeAdapters$9
  extends TypeAdapter<AtomicBoolean>
{
  public AtomicBoolean read(JsonReader paramJsonReader)
    throws IOException
  {
    return new AtomicBoolean(paramJsonReader.nextBoolean());
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicBoolean paramAtomicBoolean)
    throws IOException
  {
    paramJsonWriter.value(paramAtomicBoolean.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.9
 * JD-Core Version:    0.7.0.1
 */