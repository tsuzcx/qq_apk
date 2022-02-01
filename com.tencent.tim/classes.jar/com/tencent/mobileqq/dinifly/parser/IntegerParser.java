package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import java.io.IOException;

public class IntegerParser
  implements ValueParser<Integer>
{
  public static final IntegerParser INSTANCE = new IntegerParser();
  
  public Integer parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    return Integer.valueOf(Math.round(JsonUtils.valueFromObject(paramJsonReader) * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.IntegerParser
 * JD-Core Version:    0.7.0.1
 */