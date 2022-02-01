package com.tencent.component.animation.rebound;

public class OrigamiValueConverter
{
  public static double frictionFromOrigamiValue(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return (paramDouble - 8.0D) * 3.0D + 25.0D;
  }
  
  public static double origamiValueFromFriction(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return (paramDouble - 25.0D) / 3.0D + 8.0D;
  }
  
  public static double origamiValueFromTension(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return (paramDouble - 194.0D) / 3.62D + 30.0D;
  }
  
  public static double tensionFromOrigamiValue(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return (paramDouble - 30.0D) * 3.62D + 194.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.OrigamiValueConverter
 * JD-Core Version:    0.7.0.1
 */