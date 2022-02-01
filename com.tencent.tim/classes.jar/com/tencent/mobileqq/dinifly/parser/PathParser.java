package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

public class PathParser
  implements ValueParser<PointF>
{
  public static final PathParser INSTANCE = new PathParser();
  
  public PointF parse(JsonReader paramJsonReader, float paramFloat)
    throws IOException
  {
    return JsonUtils.jsonToPoint(paramJsonReader, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.PathParser
 * JD-Core Version:    0.7.0.1
 */