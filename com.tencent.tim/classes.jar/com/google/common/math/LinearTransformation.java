package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@Beta
@GwtIncompatible
public abstract class LinearTransformation
{
  public static LinearTransformation forNaN()
  {
    return NaNLinearTransformation.INSTANCE;
  }
  
  public static LinearTransformation horizontal(double paramDouble)
  {
    Preconditions.checkArgument(DoubleUtils.isFinite(paramDouble));
    return new RegularLinearTransformation(0.0D, paramDouble);
  }
  
  public static LinearTransformationBuilder mapping(double paramDouble1, double paramDouble2)
  {
    if ((DoubleUtils.isFinite(paramDouble1)) && (DoubleUtils.isFinite(paramDouble2))) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new LinearTransformationBuilder(paramDouble1, paramDouble2, null);
    }
  }
  
  public static LinearTransformation vertical(double paramDouble)
  {
    Preconditions.checkArgument(DoubleUtils.isFinite(paramDouble));
    return new VerticalLinearTransformation(paramDouble);
  }
  
  public abstract LinearTransformation inverse();
  
  public abstract boolean isHorizontal();
  
  public abstract boolean isVertical();
  
  public abstract double slope();
  
  public abstract double transform(double paramDouble);
  
  public static final class LinearTransformationBuilder
  {
    private final double x1;
    private final double y1;
    
    private LinearTransformationBuilder(double paramDouble1, double paramDouble2)
    {
      this.x1 = paramDouble1;
      this.y1 = paramDouble2;
    }
    
    public LinearTransformation and(double paramDouble1, double paramDouble2)
    {
      boolean bool2 = true;
      if ((DoubleUtils.isFinite(paramDouble1)) && (DoubleUtils.isFinite(paramDouble2)))
      {
        bool1 = true;
        Preconditions.checkArgument(bool1);
        if (paramDouble1 != this.x1) {
          break label76;
        }
        if (paramDouble2 == this.y1) {
          break label70;
        }
      }
      label70:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1);
        return new LinearTransformation.VerticalLinearTransformation(this.x1);
        bool1 = false;
        break;
      }
      label76:
      return withSlope((paramDouble2 - this.y1) / (paramDouble1 - this.x1));
    }
    
    public LinearTransformation withSlope(double paramDouble)
    {
      if (!Double.isNaN(paramDouble)) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        if (!DoubleUtils.isFinite(paramDouble)) {
          break;
        }
        return new LinearTransformation.RegularLinearTransformation(paramDouble, this.y1 - this.x1 * paramDouble);
      }
      return new LinearTransformation.VerticalLinearTransformation(this.x1);
    }
  }
  
  static final class NaNLinearTransformation
    extends LinearTransformation
  {
    static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();
    
    public LinearTransformation inverse()
    {
      return this;
    }
    
    public boolean isHorizontal()
    {
      return false;
    }
    
    public boolean isVertical()
    {
      return false;
    }
    
    public double slope()
    {
      return (0.0D / 0.0D);
    }
    
    public String toString()
    {
      return "NaN";
    }
    
    public double transform(double paramDouble)
    {
      return (0.0D / 0.0D);
    }
  }
  
  static final class RegularLinearTransformation
    extends LinearTransformation
  {
    @LazyInit
    LinearTransformation inverse;
    final double slope;
    final double yIntercept;
    
    RegularLinearTransformation(double paramDouble1, double paramDouble2)
    {
      this.slope = paramDouble1;
      this.yIntercept = paramDouble2;
      this.inverse = null;
    }
    
    RegularLinearTransformation(double paramDouble1, double paramDouble2, LinearTransformation paramLinearTransformation)
    {
      this.slope = paramDouble1;
      this.yIntercept = paramDouble2;
      this.inverse = paramLinearTransformation;
    }
    
    private LinearTransformation createInverse()
    {
      if (this.slope != 0.0D) {
        return new RegularLinearTransformation(1.0D / this.slope, -1.0D * this.yIntercept / this.slope, this);
      }
      return new LinearTransformation.VerticalLinearTransformation(this.yIntercept, this);
    }
    
    public LinearTransformation inverse()
    {
      LinearTransformation localLinearTransformation2 = this.inverse;
      LinearTransformation localLinearTransformation1 = localLinearTransformation2;
      if (localLinearTransformation2 == null)
      {
        localLinearTransformation1 = createInverse();
        this.inverse = localLinearTransformation1;
      }
      return localLinearTransformation1;
    }
    
    public boolean isHorizontal()
    {
      return this.slope == 0.0D;
    }
    
    public boolean isVertical()
    {
      return false;
    }
    
    public double slope()
    {
      return this.slope;
    }
    
    public String toString()
    {
      return String.format("y = %g * x + %g", new Object[] { Double.valueOf(this.slope), Double.valueOf(this.yIntercept) });
    }
    
    public double transform(double paramDouble)
    {
      return this.slope * paramDouble + this.yIntercept;
    }
  }
  
  static final class VerticalLinearTransformation
    extends LinearTransformation
  {
    @LazyInit
    LinearTransformation inverse;
    final double x;
    
    VerticalLinearTransformation(double paramDouble)
    {
      this.x = paramDouble;
      this.inverse = null;
    }
    
    VerticalLinearTransformation(double paramDouble, LinearTransformation paramLinearTransformation)
    {
      this.x = paramDouble;
      this.inverse = paramLinearTransformation;
    }
    
    private LinearTransformation createInverse()
    {
      return new LinearTransformation.RegularLinearTransformation(0.0D, this.x, this);
    }
    
    public LinearTransformation inverse()
    {
      LinearTransformation localLinearTransformation2 = this.inverse;
      LinearTransformation localLinearTransformation1 = localLinearTransformation2;
      if (localLinearTransformation2 == null)
      {
        localLinearTransformation1 = createInverse();
        this.inverse = localLinearTransformation1;
      }
      return localLinearTransformation1;
    }
    
    public boolean isHorizontal()
    {
      return false;
    }
    
    public boolean isVertical()
    {
      return true;
    }
    
    public double slope()
    {
      throw new IllegalStateException();
    }
    
    public String toString()
    {
      return String.format("x = %g", new Object[] { Double.valueOf(this.x) });
    }
    
    public double transform(double paramDouble)
    {
      throw new IllegalStateException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.LinearTransformation
 * JD-Core Version:    0.7.0.1
 */