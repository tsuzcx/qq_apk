package com.tencent.mobileqq.dinifly.parser;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableGradientColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableIntegerValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatablePointValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableScaleValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableShapeValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.Keyframe;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser
{
  @Nullable
  private static <T> List<Keyframe<T>> parse(JsonReader paramJsonReader, float paramFloat, LottieComposition paramLottieComposition, ValueParser<T> paramValueParser)
    throws IOException
  {
    return KeyframesParser.parse(paramJsonReader, paramLottieComposition, paramFloat, paramValueParser);
  }
  
  @Nullable
  private static <T> List<Keyframe<T>> parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition, ValueParser<T> paramValueParser)
    throws IOException
  {
    return KeyframesParser.parse(paramJsonReader, paramLottieComposition, 1.0F, paramValueParser);
  }
  
  static AnimatableColorValue parseColor(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableColorValue(parse(paramJsonReader, paramLottieComposition, ColorParser.INSTANCE));
  }
  
  static AnimatableTextFrame parseDocumentData(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableTextFrame(parse(paramJsonReader, paramLottieComposition, DocumentDataParser.INSTANCE));
  }
  
  public static AnimatableFloatValue parseFloat(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return parseFloat(paramJsonReader, paramLottieComposition, true);
  }
  
  public static AnimatableFloatValue parseFloat(JsonReader paramJsonReader, LottieComposition paramLottieComposition, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (float f = Utils.dpScale();; f = 1.0F) {
      return new AnimatableFloatValue(parse(paramJsonReader, f, paramLottieComposition, FloatParser.INSTANCE));
    }
  }
  
  static AnimatableGradientColorValue parseGradientColor(JsonReader paramJsonReader, LottieComposition paramLottieComposition, int paramInt)
    throws IOException
  {
    return new AnimatableGradientColorValue(parse(paramJsonReader, paramLottieComposition, new GradientColorParser(paramInt)));
  }
  
  static AnimatableIntegerValue parseInteger(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableIntegerValue(parse(paramJsonReader, paramLottieComposition, IntegerParser.INSTANCE));
  }
  
  static AnimatablePointValue parsePoint(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatablePointValue(parse(paramJsonReader, Utils.dpScale(), paramLottieComposition, PointFParser.INSTANCE));
  }
  
  static AnimatableScaleValue parseScale(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableScaleValue(parse(paramJsonReader, paramLottieComposition, ScaleXYParser.INSTANCE));
  }
  
  static AnimatableShapeValue parseShapeData(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
    throws IOException
  {
    return new AnimatableShapeValue(parse(paramJsonReader, Utils.dpScale(), paramLottieComposition, ShapeDataParser.INSTANCE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.AnimatableValueParser
 * JD-Core Version:    0.7.0.1
 */