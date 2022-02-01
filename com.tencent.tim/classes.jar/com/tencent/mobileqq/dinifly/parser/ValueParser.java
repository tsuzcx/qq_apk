package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import java.io.IOException;

abstract interface ValueParser<V>
{
  public abstract V parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ValueParser
 * JD-Core Version:    0.7.0.1
 */