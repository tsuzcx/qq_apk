package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import java.io.IOException;

public class AnimatableTextPropertiesParser
{
  public static AnimatableTextProperties parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    paramJsonReader.beginObject();
    AnimatableTextProperties localAnimatableTextProperties = null;
    label6:
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label6;
          if (str.equals("a")) {
            i = 0;
          }
          break;
        }
      }
      localAnimatableTextProperties = parseAnimatableTextProperties(paramJsonReader, paramLottieComposition);
    }
    paramJsonReader.endObject();
    paramJsonReader = localAnimatableTextProperties;
    if (localAnimatableTextProperties == null) {
      paramJsonReader = new AnimatableTextProperties(null, null, null, null);
    }
    return paramJsonReader;
  }
  
  private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    AnimatableFloatValue localAnimatableFloatValue2 = null;
    paramJsonReader.beginObject();
    AnimatableFloatValue localAnimatableFloatValue1 = null;
    AnimatableColorValue localAnimatableColorValue2 = null;
    AnimatableColorValue localAnimatableColorValue1 = null;
    label15:
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label15;
          if (str.equals("fc"))
          {
            i = 0;
            continue;
            if (str.equals("sc"))
            {
              i = 1;
              continue;
              if (str.equals("sw"))
              {
                i = 2;
                continue;
                if (str.equals("t")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      localAnimatableColorValue1 = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableColorValue2 = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableFloatValue1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableFloatValue2 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
    }
    paramJsonReader.endObject();
    return new AnimatableTextProperties(localAnimatableColorValue1, localAnimatableColorValue2, localAnimatableFloatValue1, localAnimatableFloatValue2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatableTextPropertiesParser
 * JD-Core Version:    0.7.0.1
 */