package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Path.FillType;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeFill;
import java.io.IOException;

class ShapeFillParser
{
  static ShapeFill parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    String str1 = null;
    boolean bool1 = false;
    int j = 1;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    boolean bool2 = false;
    AnimatableColorValue localAnimatableColorValue = null;
    label17:
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = -1;
      switch (str2.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label17;
          if (str2.equals("nm"))
          {
            i = 0;
            continue;
            if (str2.equals("c"))
            {
              i = 1;
              continue;
              if (str2.equals("o"))
              {
                i = 2;
                continue;
                if (str2.equals("fillEnabled"))
                {
                  i = 3;
                  continue;
                  if (str2.equals("r"))
                  {
                    i = 4;
                    continue;
                    if (str2.equals("hd")) {
                      i = 5;
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      str1 = paramJsonReader.nextString();
      continue;
      localAnimatableColorValue = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
      continue;
      bool2 = paramJsonReader.nextBoolean();
      continue;
      j = paramJsonReader.nextInt();
      continue;
      bool1 = paramJsonReader.nextBoolean();
    }
    if (j == 1) {}
    for (paramJsonReader = Path.FillType.WINDING;; paramJsonReader = Path.FillType.EVEN_ODD) {
      return new ShapeFill(str1, bool2, paramJsonReader, localAnimatableColorValue, localAnimatableIntegerValue, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeFillParser
 * JD-Core Version:    0.7.0.1
 */