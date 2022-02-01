package org.apache.commons.lang3.math;

import org.apache.commons.lang3.Validate;

public class IEEE754rUtils
{
  public static double max(double paramDouble1, double paramDouble2)
  {
    if (Double.isNaN(paramDouble1)) {
      return paramDouble2;
    }
    if (Double.isNaN(paramDouble2)) {
      return paramDouble1;
    }
    return Math.max(paramDouble1, paramDouble2);
  }
  
  public static double max(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return max(max(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double max(double... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length != 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Array cannot be empty.", new Object[0]);
      d = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        d = max(paramVarArgs[i], d);
        i += 1;
      }
    }
    return d;
  }
  
  public static float max(float paramFloat1, float paramFloat2)
  {
    if (Float.isNaN(paramFloat1)) {
      return paramFloat2;
    }
    if (Float.isNaN(paramFloat2)) {
      return paramFloat1;
    }
    return Math.max(paramFloat1, paramFloat2);
  }
  
  public static float max(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return max(max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public static float max(float... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length != 0) {}
    float f;
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Array cannot be empty.", new Object[0]);
      f = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        f = max(paramVarArgs[i], f);
        i += 1;
      }
    }
    return f;
  }
  
  public static double min(double paramDouble1, double paramDouble2)
  {
    if (Double.isNaN(paramDouble1)) {
      return paramDouble2;
    }
    if (Double.isNaN(paramDouble2)) {
      return paramDouble1;
    }
    return Math.min(paramDouble1, paramDouble2);
  }
  
  public static double min(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return min(min(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double min(double... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length != 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Array cannot be empty.", new Object[0]);
      d = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        d = min(paramVarArgs[i], d);
        i += 1;
      }
    }
    return d;
  }
  
  public static float min(float paramFloat1, float paramFloat2)
  {
    if (Float.isNaN(paramFloat1)) {
      return paramFloat2;
    }
    if (Float.isNaN(paramFloat2)) {
      return paramFloat1;
    }
    return Math.min(paramFloat1, paramFloat2);
  }
  
  public static float min(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return min(min(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public static float min(float... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("The Array must not be null");
    }
    if (paramVarArgs.length != 0) {}
    float f;
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Array cannot be empty.", new Object[0]);
      f = paramVarArgs[0];
      while (i < paramVarArgs.length)
      {
        f = min(paramVarArgs[i], f);
        i += 1;
      }
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.math.IEEE754rUtils
 * JD-Core Version:    0.7.0.1
 */