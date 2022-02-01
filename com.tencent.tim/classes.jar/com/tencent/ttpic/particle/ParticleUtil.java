package com.tencent.ttpic.particle;

import java.util.Random;

public class ParticleUtil
{
  public static float dot(Vector2 paramVector21, Vector2 paramVector22)
  {
    return paramVector21.x * paramVector22.x + paramVector21.y * paramVector22.y;
  }
  
  public static float getRotateAngle(float paramFloat1, float paramFloat2)
  {
    double d = Math.sin(paramFloat2);
    return (float)Math.toDegrees(Math.atan2(Math.sin(paramFloat1), d));
  }
  
  public static float random0to1()
  {
    return new Random().nextFloat();
  }
  
  public static float randomMinus1to1()
  {
    return 1.0F - new Random().nextFloat() * 2.0F;
  }
  
  public static Vector2 revert(Vector2 paramVector2)
  {
    return new Vector2(-paramVector2.x, -paramVector2.y);
  }
  
  public static void saturate(Vector3 paramVector3, float paramFloat1, float paramFloat2)
  {
    paramVector3.x = Math.min(Math.max(paramVector3.x, paramFloat1), paramFloat2);
    paramVector3.y = Math.min(Math.max(paramVector3.y, paramFloat1), paramFloat2);
    paramVector3.z = Math.min(Math.max(paramVector3.z, paramFloat1), paramFloat2);
  }
  
  public static void saturateZ(Vector3 paramVector3, float paramFloat1, float paramFloat2)
  {
    paramVector3.z = Math.min(Math.max(paramVector3.z, paramFloat1), paramFloat2);
  }
  
  public static Vector2 vectorAdd(Vector2 paramVector21, Vector2 paramVector22)
  {
    return new Vector2(paramVector21.x + paramVector22.x, paramVector21.y + paramVector22.y);
  }
  
  public static Vector3 vectorAdd(Vector3 paramVector31, Vector3 paramVector32)
  {
    return new Vector3(paramVector31.x + paramVector32.x, paramVector31.y + paramVector32.y, paramVector31.z + paramVector32.z);
  }
  
  public static Vector3 vectorCrossProduct(Vector3 paramVector31, Vector3 paramVector32)
  {
    return new Vector3(paramVector31.y * paramVector32.z - paramVector31.z * paramVector32.y, paramVector31.z * paramVector32.x - paramVector31.x * paramVector32.z, paramVector31.x * paramVector32.y - paramVector31.y * paramVector32.x);
  }
  
  public static Vector2 vectorMultiplyScalar(Vector2 paramVector2, float paramFloat)
  {
    return new Vector2(paramVector2.x * paramFloat, paramVector2.y * paramFloat);
  }
  
  public static Vector3 vectorMultiplyScalar(Vector3 paramVector3, float paramFloat)
  {
    return new Vector3(paramVector3.x * paramFloat, paramVector3.y * paramFloat, paramVector3.z * paramFloat);
  }
  
  public static Vector3 vectorNormalization(Vector3 paramVector3)
  {
    Vector3 localVector3 = new Vector3(0.0F, 0.0F, 0.0F);
    float f = (float)Math.sqrt(paramVector3.x * paramVector3.x + paramVector3.y * paramVector3.y + paramVector3.z * paramVector3.z);
    if (f > 0.0D)
    {
      paramVector3.x /= f;
      paramVector3.y /= f;
      paramVector3.z /= f;
    }
    return localVector3;
  }
  
  public static Vector2 vectorNormalize(Vector2 paramVector2)
  {
    if ((Float.compare(paramVector2.x, 0.0F) == 0) && (Float.compare(paramVector2.y, 0.0F) == 0)) {
      return null;
    }
    float f = (float)Math.sqrt(Math.pow(paramVector2.x, 2.0D) + Math.pow(paramVector2.y, 2.0D));
    return new Vector2(paramVector2.x / f, paramVector2.y / f);
  }
  
  public static Vector3 vectorNormalize(Vector3 paramVector3)
  {
    if ((Float.compare(paramVector3.x, 0.0F) == 0) && (Float.compare(paramVector3.y, 0.0F) == 0)) {
      return paramVector3;
    }
    float f = (float)Math.sqrt(Math.pow(paramVector3.x, 2.0D) + Math.pow(paramVector3.y, 2.0D) + Math.pow(paramVector3.z, 2.0D));
    return new Vector3(paramVector3.x / f, paramVector3.y / f, paramVector3.z / f);
  }
  
  public static Vector2 vectorSubtract(Vector2 paramVector21, Vector2 paramVector22)
  {
    return new Vector2(paramVector21.x - paramVector22.x, paramVector21.y - paramVector22.y);
  }
  
  public static Vector3 vectorSubtract(Vector3 paramVector31, Vector3 paramVector32)
  {
    return new Vector3(paramVector31.x - paramVector32.x, paramVector31.y - paramVector32.y, paramVector31.z - paramVector32.z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleUtil
 * JD-Core Version:    0.7.0.1
 */