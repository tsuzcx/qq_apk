package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/DoubleCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE", "()D", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "NaN", "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class DoubleCompanionObject
{
  public static final DoubleCompanionObject INSTANCE = new DoubleCompanionObject();
  private static final double MAX_VALUE = 1.7976931348623157E+308D;
  private static final double MIN_VALUE = 4.9E-324D;
  private static final double NEGATIVE_INFINITY = (-1.0D / 0.0D);
  private static final double NaN = (0.0D / 0.0D);
  private static final double POSITIVE_INFINITY = (1.0D / 0.0D);
  
  static
  {
    MAX_VALUE = 1.7976931348623157E+308D;
    POSITIVE_INFINITY = (1.0D / 0.0D);
  }
  
  public final double getMAX_VALUE()
  {
    return MAX_VALUE;
  }
  
  public final double getMIN_VALUE()
  {
    return MIN_VALUE;
  }
  
  public final double getNEGATIVE_INFINITY()
  {
    return NEGATIVE_INFINITY;
  }
  
  public final double getNaN()
  {
    return NaN;
  }
  
  public final double getPOSITIVE_INFINITY()
  {
    return POSITIVE_INFINITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.DoubleCompanionObject
 * JD-Core Version:    0.7.0.1
 */