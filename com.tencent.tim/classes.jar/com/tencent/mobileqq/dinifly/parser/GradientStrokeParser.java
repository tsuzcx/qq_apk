package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.content.GradientStroke;
import com.tencent.mobileqq.dinifly.model.content.GradientType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GradientStrokeParser
{
  static GradientStroke parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    String str1 = null;
    AnimatableGradientColorValue localAnimatableGradientColorValue = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    GradientType localGradientType = null;
    AnimatablePointValue localAnimatablePointValue2 = null;
    AnimatablePointValue localAnimatablePointValue1 = null;
    AnimatableFloatValue localAnimatableFloatValue = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    Object localObject1 = null;
    float f = 0.0F;
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    label44:
    while (paramJsonReader.hasNext())
    {
      Object localObject2 = paramJsonReader.nextName();
      int i = -1;
      switch (((String)localObject2).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label44;
          if (((String)localObject2).equals("nm"))
          {
            i = 0;
            continue;
            if (((String)localObject2).equals("g"))
            {
              i = 1;
              continue;
              if (((String)localObject2).equals("o"))
              {
                i = 2;
                continue;
                if (((String)localObject2).equals("t"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject2).equals("s"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject2).equals("e"))
                    {
                      i = 5;
                      continue;
                      if (((String)localObject2).equals("w"))
                      {
                        i = 6;
                        continue;
                        if (((String)localObject2).equals("lc"))
                        {
                          i = 7;
                          continue;
                          if (((String)localObject2).equals("lj"))
                          {
                            i = 8;
                            continue;
                            if (((String)localObject2).equals("ml"))
                            {
                              i = 9;
                              continue;
                              if (((String)localObject2).equals("hd"))
                              {
                                i = 10;
                                continue;
                                if (((String)localObject2).equals("d")) {
                                  i = 11;
                                }
                              }
                            }
                          }
                        }
                      }
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
      int j = -1;
      paramJsonReader.beginObject();
      label445:
      while (paramJsonReader.hasNext())
      {
        localObject2 = paramJsonReader.nextName();
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramJsonReader.skipValue();
            break label445;
            if (((String)localObject2).equals("p"))
            {
              i = 0;
              continue;
              if (((String)localObject2).equals("k")) {
                i = 1;
              }
            }
            break;
          }
        }
        j = paramJsonReader.nextInt();
        continue;
        localAnimatableGradientColorValue = AnimatableValueParser.parseGradientColor(paramJsonReader, paramLottieComposition, j);
      }
      paramJsonReader.endObject();
      continue;
      localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
      continue;
      if (paramJsonReader.nextInt() == 1)
      {
        localGradientType = GradientType.LINEAR;
      }
      else
      {
        localGradientType = GradientType.RADIAL;
        continue;
        localAnimatablePointValue2 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        continue;
        localAnimatablePointValue1 = AnimatableValueParser.parsePoint(paramJsonReader, paramLottieComposition);
        continue;
        localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
        continue;
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJsonReader.nextInt() - 1)];
        continue;
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJsonReader.nextInt() - 1)];
        continue;
        f = (float)paramJsonReader.nextDouble();
        continue;
        bool = paramJsonReader.nextBoolean();
        continue;
        paramJsonReader.beginArray();
        localObject2 = localObject1;
        while (paramJsonReader.hasNext())
        {
          String str2 = null;
          localObject1 = null;
          paramJsonReader.beginObject();
          label718:
          while (paramJsonReader.hasNext())
          {
            String str3 = paramJsonReader.nextName();
            i = -1;
            switch (str3.hashCode())
            {
            }
            for (;;)
            {
              switch (i)
              {
              default: 
                paramJsonReader.skipValue();
                break label718;
                if (str3.equals("n"))
                {
                  i = 0;
                  continue;
                  if (str3.equals("v")) {
                    i = 1;
                  }
                }
                break;
              }
            }
            str2 = paramJsonReader.nextString();
            continue;
            localObject1 = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
          }
          paramJsonReader.endObject();
          if (str2.equals("o"))
          {
            localObject2 = localObject1;
          }
          else if ((str2.equals("d")) || (str2.equals("g")))
          {
            paramLottieComposition.setHasDashPattern(true);
            localArrayList.add(localObject1);
          }
        }
        paramJsonReader.endArray();
        localObject1 = localObject2;
        if (localArrayList.size() == 1)
        {
          localArrayList.add(localArrayList.get(0));
          localObject1 = localObject2;
        }
      }
    }
    return new GradientStroke(str1, localGradientType, localAnimatableGradientColorValue, localAnimatableIntegerValue, localAnimatablePointValue2, localAnimatablePointValue1, localAnimatableFloatValue, localLineCapType, localLineJoinType, f, localArrayList, (AnimatableFloatValue)localObject1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.GradientStrokeParser
 * JD-Core Version:    0.7.0.1
 */