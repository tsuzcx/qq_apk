package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.content.Mask;
import com.tencent.mobileqq.dinifly.model.content.Mask.MaskMode;
import java.io.IOException;

class MaskParser
{
  static Mask parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    AnimatableIntegerValue localAnimatableIntegerValue = null;
    paramJsonReader.beginObject();
    boolean bool = false;
    AnimatableShapeValue localAnimatableShapeValue = null;
    Object localObject = null;
    label15:
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      label76:
      int i;
      switch (str.hashCode())
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
          break label15;
          if (!str.equals("mode")) {
            break label76;
          }
          i = 0;
          continue;
          if (!str.equals("pt")) {
            break label76;
          }
          i = 1;
          continue;
          if (!str.equals("o")) {
            break label76;
          }
          i = 2;
          continue;
          if (!str.equals("inv")) {
            break label76;
          }
          i = 3;
        }
      }
      localObject = paramJsonReader.nextString();
      switch (((String)localObject).hashCode())
      {
      default: 
        label220:
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          Log.w("LOTTIE", "Unknown mask mode " + str + ". Defaulting to Add.");
          localObject = Mask.MaskMode.MASK_MODE_ADD;
          break label15;
          if (!((String)localObject).equals("a")) {
            break label220;
          }
          i = 0;
          continue;
          if (!((String)localObject).equals("s")) {
            break label220;
          }
          i = 1;
          continue;
          if (!((String)localObject).equals("i")) {
            break label220;
          }
          i = 2;
        }
      }
      localObject = Mask.MaskMode.MASK_MODE_ADD;
      continue;
      localObject = Mask.MaskMode.MASK_MODE_SUBTRACT;
      continue;
      paramLottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
      localObject = Mask.MaskMode.MASK_MODE_INTERSECT;
      continue;
      localAnimatableShapeValue = AnimatableValueParser.parseShapeData(paramJsonReader, paramLottieComposition);
      continue;
      localAnimatableIntegerValue = AnimatableValueParser.parseInteger(paramJsonReader, paramLottieComposition);
      continue;
      bool = paramJsonReader.nextBoolean();
    }
    paramJsonReader.endObject();
    return new Mask((Mask.MaskMode)localObject, localAnimatableShapeValue, localAnimatableIntegerValue, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.MaskParser
 * JD-Core Version:    0.7.0.1
 */