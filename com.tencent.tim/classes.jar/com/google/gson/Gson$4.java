package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

final class Gson$4
  extends TypeAdapter<AtomicLong>
{
  Gson$4(TypeAdapter paramTypeAdapter) {}
  
  public AtomicLong read(JsonReader paramJsonReader)
    throws IOException
  {
    return new AtomicLong(((Number)this.val$longAdapter.read(paramJsonReader)).longValue());
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicLong paramAtomicLong)
    throws IOException
  {
    this.val$longAdapter.write(paramJsonWriter, Long.valueOf(paramAtomicLong.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.Gson.4
 * JD-Core Version:    0.7.0.1
 */