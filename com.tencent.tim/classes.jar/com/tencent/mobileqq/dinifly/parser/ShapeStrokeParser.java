package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineCapType;
import com.tencent.mobileqq.dinifly.model.content.ShapeStroke.LineJoinType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ShapeStrokeParser
{
  static ShapeStroke parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    String str1 = null;
    AnimatableColorValue localAnimatableColorValue = null;
    AnimatableFloatValue localAnimatableFloatValue = null;
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    ShapeStroke.LineCapType localLineCapType = null;
    ShapeStroke.LineJoinType localLineJoinType = null;
    Object localObject1 = null;
    float f = 0.0F;
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    label35:
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
          break label35;
          if (((String)localObject2).equals("nm"))
          {
            i = 0;
            continue;
            if (((String)localObject2).equals("c"))
            {
              i = 1;
              continue;
              if (((String)localObject2).equals("w"))
              {
                i = 2;
                continue;
                if (((String)localObject2).equals("o"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject2).equals("lc"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject2).equals("lj"))
                    {
                      i = 5;
                      continue;
                      if (((String)localObject2).equals("ml"))
                      {
                        i = 6;
                        continue;
                        if (((String)localObject2).equals("hd"))
                        {
                          i = 7;
                          continue;
                          if (((String)localObject2).equals("d")) {
                            i = 8;
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
      localAnimatableColorValue = AnimatableValueParser.parseColor(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableFloatValue = AnimatableValueParser.parseFloat(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
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
        label445:
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
              break label445;
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
        switch (str2.hashCode())
        {
        default: 
          label616:
          i = -1;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            localObject2 = localObject1;
            break;
            if (!str2.equals("o")) {
              break label616;
            }
            i = 0;
            continue;
            if (!str2.equals("d")) {
              break label616;
            }
            i = 1;
            continue;
            if (!str2.equals("g")) {
              break label616;
            }
            i = 2;
          }
        }
        paramLottieComposition.setHasDashPattern(true);
        localArrayList.add(localObject1);
      }
      paramJsonReader.endArray();
      localObject1 = localObject2;
      if (localArrayList.size() == 1)
      {
        localArrayList.add(localArrayList.get(0));
        localObject1 = localObject2;
      }
    }
    return new ShapeStroke(str1, (AnimatableFloatValue)localObject1, localArrayList, localAnimatableColorValue, localAnimatableIntegerValue, localAnimatableFloatValue, localLineCapType, localLineJoinType, f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeStrokeParser
 * JD-Core Version:    0.7.0.1
 */