package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/FloatCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE", "()F", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "NaN", "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FloatCompanionObject
{
  public static final FloatCompanionObject INSTANCE = new FloatCompanionObject();
  private static final float MAX_VALUE = 3.4028235E+38F;
  private static final float MIN_VALUE = 1.4E-45F;
  private static final float NEGATIVE_INFINITY = (1.0F / -1.0F);
  private static final float NaN = (0.0F / 0.0F);
  private static final float POSITIVE_INFINITY = (1.0F / 1.0F);
  
  static
  {
    MAX_VALUE = 3.4028235E+38F;
    POSITIVE_INFINITY = (1.0F / 1.0F);
  }
  
  public final float getMAX_VALUE()
  {
    return MAX_VALUE;
  }
  
  public final float getMIN_VALUE()
  {
    return MIN_VALUE;
  }
  
  public final float getNEGATIVE_INFINITY()
  {
    return NEGATIVE_INFINITY;
  }
  
  public final float getNaN()
  {
    return NaN;
  }
  
  public final float getPOSITIVE_INFINITY()
  {
    return POSITIVE_INFINITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.FloatCompanionObject
 * JD-Core Version:    0.7.0.1
 */