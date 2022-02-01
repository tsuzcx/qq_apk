package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongArray;

final class Gson$5
  extends TypeAdapter<AtomicLongArray>
{
  Gson$5(TypeAdapter paramTypeAdapter) {}
  
  public AtomicLongArray read(JsonReader paramJsonReader)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(Long.valueOf(((Number)this.val$longAdapter.read(paramJsonReader)).longValue()));
    }
    paramJsonReader.endArray();
    int j = localArrayList.size();
    paramJsonReader = new AtomicLongArray(j);
    int i = 0;
    while (i < j)
    {
      paramJsonReader.set(i, ((Long)localArrayList.get(i)).longValue());
      i += 1;
    }
    return paramJsonReader;
  }
  
  public void write(JsonWriter paramJsonWriter, AtomicLongArray paramAtomicLongArray)
    throws IOException
  {
    paramJsonWriter.beginArray();
    int i = 0;
    int j = paramAtomicLongArray.length();
    while (i < j)
    {
      this.val$longAdapter.write(paramJsonWriter, Long.valueOf(paramAtomicLongArray.get(i)));
      i += 1;
    }
    paramJsonWriter.endArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.Gson.5
 * JD-Core Version:    0.7.0.1
 */