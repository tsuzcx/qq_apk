package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.content.ShapePath;
import java.io.IOException;

class ShapePathParser
{
  static ShapePath parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    AnimatableShapeValue localAnimatableShapeValue = null;
    boolean bool = false;
    int j = 0;
    String str1 = null;
    label11:
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
          break label11;
          if (str2.equals("nm"))
          {
            i = 0;
            continue;
            if (str2.equals("ind"))
            {
              i = 1;
              continue;
              if (str2.equals("ks"))
              {
                i = 2;
                continue;
                if (str2.equals("hd")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      str1 = paramJsonReader.nextString();
      continue;
      j = paramJsonReader.nextInt();
      continue;
      localAnimatableShapeValue = AnimatableValueParser.parseShapeData(paramJsonReader, paramLottieComposition);
      continue;
      bool = paramJsonReader.nextBoolean();
    }
    return new ShapePath(str1, j, localAnimatableShapeValue, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapePathParser
 * JD-Core Version:    0.7.0.1
 */