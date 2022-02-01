package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.keyframe.PathKeyframe;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class KeyframesParser
{
  static <T> List<Keyframe<T>> parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, float paramFloat, ValueParser<T> paramValueParser)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonReader.peek() == JsonToken.STRING)
    {
      paramLottieComposition.addWarning("Lottie doesn't support expressions.");
      return localArrayList;
    }
    paramJsonReader.beginObject();
    label32:
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
          break label32;
          if (str.equals("k")) {
            i = 0;
          }
          break;
        }
      }
      if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY)
      {
        paramJsonReader.beginArray();
        if (paramJsonReader.peek() == JsonToken.NUMBER) {
          localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
        }
        for (;;)
        {
          paramJsonReader.endArray();
          break;
          while (paramJsonReader.hasNext()) {
            localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, true));
          }
        }
      }
      localArrayList.add(KeyframeParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser, false));
    }
    paramJsonReader.endObject();
    setEndFrames(localArrayList);
    return localArrayList;
  }
  
  public static <T> void setEndFrames(List<? extends Keyframe<T>> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j - 1)
    {
      localKeyframe1 = (Keyframe)paramList.get(i);
      Keyframe localKeyframe2 = (Keyframe)paramList.get(i + 1);
      localKeyframe1.endFrame = Float.valueOf(localKeyframe2.startFrame);
      if ((localKeyframe1.endValue == null) && (localKeyframe2.startValue != null))
      {
        localKeyframe1.endValue = localKeyframe2.startValue;
        if ((localKeyframe1 instanceof PathKeyframe)) {
          ((PathKeyframe)localKeyframe1).createPath();
        }
      }
      i += 1;
    }
    Keyframe localKeyframe1 = (Keyframe)paramList.get(j - 1);
    if (((localKeyframe1.startValue == null) || (localKeyframe1.endValue == null)) && (paramList.size() > 1)) {
      paramList.remove(localKeyframe1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.KeyframesParser
 * JD-Core Version:    0.7.0.1
 */