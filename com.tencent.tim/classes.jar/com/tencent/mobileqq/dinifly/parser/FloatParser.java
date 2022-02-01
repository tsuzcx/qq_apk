package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import java.io.IOException;

public class FloatParser
  implements ValueParser<Float>
{
  public static final FloatParser INSTANCE = new FloatParser();
  
  public Float parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    return Float.valueOf(JsonUtils.valueFromObject(paramJsonReader) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.FloatParser
 * JD-Core Version:    0.7.0.1
 */