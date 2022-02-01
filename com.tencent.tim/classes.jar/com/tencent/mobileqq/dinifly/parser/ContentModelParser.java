package com.tencent.mobileqq.dinifly.parser;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import java.io.IOException;

class ContentModelParser
{
  @Nullable
  static ContentModel parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    int k = 2;
    paramJsonReader.beginObject();
    int j = 2;
    label9:
    label52:
    int i;
    if (paramJsonReader.hasNext())
    {
      localObject = paramJsonReader.nextName();
      switch (((String)localObject).hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label9;
          if (!((String)localObject).equals("ty")) {
            break label52;
          }
          i = 0;
          continue;
          if (!((String)localObject).equals("d")) {
            break label52;
          }
          i = 1;
        }
      }
    }
    for (Object localObject = paramJsonReader.nextString();; localObject = null)
    {
      if (localObject == null)
      {
        return null;
        j = paramJsonReader.nextInt();
        break;
      }
      switch (((String)localObject).hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label254:
          Log.w("LOTTIE", "Unknown shape type " + (String)localObject);
          paramLottieComposition = null;
        }
        break;
      }
      for (;;)
      {
        if (!paramJsonReader.hasNext()) {
          break label692;
        }
        paramJsonReader.skipValue();
        continue;
        if (!((String)localObject).equals("gr")) {
          break;
        }
        i = 0;
        break label254;
        if (!((String)localObject).equals("st")) {
          break;
        }
        i = 1;
        break label254;
        if (!((String)localObject).equals("gs")) {
          break;
        }
        i = k;
        break label254;
        if (!((String)localObject).equals("fl")) {
          break;
        }
        i = 3;
        break label254;
        if (!((String)localObject).equals("gf")) {
          break;
        }
        i = 4;
        break label254;
        if (!((String)localObject).equals("tr")) {
          break;
        }
        i = 5;
        break label254;
        if (!((String)localObject).equals("sh")) {
          break;
        }
        i = 6;
        break label254;
        if (!((String)localObject).equals("el")) {
          break;
        }
        i = 7;
        break label254;
        if (!((String)localObject).equals("rc")) {
          break;
        }
        i = 8;
        break label254;
        if (!((String)localObject).equals("tm")) {
          break;
        }
        i = 9;
        break label254;
        if (!((String)localObject).equals("sr")) {
          break;
        }
        i = 10;
        break label254;
        if (!((String)localObject).equals("mm")) {
          break;
        }
        i = 11;
        break label254;
        if (!((String)localObject).equals("rp")) {
          break;
        }
        i = 12;
        break label254;
        paramLottieComposition = ShapeGroupParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = ShapeStrokeParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = GradientStrokeParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = ShapeFillParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = GradientFillParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = AnimatableTransformParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = ShapePathParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = CircleShapeParser.parse(paramJsonReader, paramLottieComposition, j);
        continue;
        paramLottieComposition = RectangleShapeParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = ShapeTrimPathParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        paramLottieComposition = PolystarShapeParser.parse(paramJsonReader, paramLottieComposition);
        continue;
        localObject = MergePathsParser.parse(paramJsonReader);
        paramLottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
        paramLottieComposition = (LottieComposition)localObject;
        continue;
        paramLottieComposition = RepeaterParser.parse(paramJsonReader, paramLottieComposition);
      }
      label692:
      paramJsonReader.endObject();
      return paramLottieComposition;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ContentModelParser
 * JD-Core Version:    0.7.0.1
 */