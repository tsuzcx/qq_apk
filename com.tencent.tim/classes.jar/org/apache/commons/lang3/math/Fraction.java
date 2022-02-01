package org.apache.commons.lang3.math;

import java.math.BigInteger;

public final class Fraction
  extends Number
  implements Comparable<Fraction>
{
  public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
  public static final Fraction ONE;
  public static final Fraction ONE_FIFTH;
  public static final Fraction ONE_HALF;
  public static final Fraction ONE_QUARTER;
  public static final Fraction ONE_THIRD;
  public static final Fraction THREE_FIFTHS;
  public static final Fraction THREE_QUARTERS;
  public static final Fraction TWO_FIFTHS;
  public static final Fraction TWO_QUARTERS;
  public static final Fraction TWO_THIRDS;
  public static final Fraction ZERO = new Fraction(0, 1);
  private static final long serialVersionUID = 65382027393090L;
  private final int denominator;
  private transient int hashCode = 0;
  private final int numerator;
  private transient String toProperString = null;
  private transient String toString = null;
  
  static
  {
    ONE = new Fraction(1, 1);
    ONE_HALF = new Fraction(1, 2);
    ONE_THIRD = new Fraction(1, 3);
    TWO_THIRDS = new Fraction(2, 3);
    ONE_QUARTER = new Fraction(1, 4);
    TWO_QUARTERS = new Fraction(2, 4);
    THREE_QUARTERS = new Fraction(3, 4);
    ONE_FIFTH = new Fraction(1, 5);
    TWO_FIFTHS = new Fraction(2, 5);
    THREE_FIFTHS = new Fraction(3, 5);
  }
  
  private Fraction(int paramInt1, int paramInt2)
  {
    this.numerator = paramInt1;
    this.denominator = paramInt2;
  }
  
  private static int addAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 + paramInt2;
    if ((l < -2147483648L) || (l > 2147483647L)) {
      throw new ArithmeticException("overflow: add");
    }
    return (int)l;
  }
  
  private Fraction addSub(Fraction paramFraction, boolean paramBoolean)
  {
    if (paramFraction == null) {
      throw new IllegalArgumentException("The fraction must not be null");
    }
    if (this.numerator == 0)
    {
      if (paramBoolean) {
        return paramFraction;
      }
      return paramFraction.negate();
    }
    if (paramFraction.numerator == 0) {
      return this;
    }
    int j = greatestCommonDivisor(this.denominator, paramFraction.denominator);
    if (j == 1)
    {
      i = mulAndCheck(this.numerator, paramFraction.denominator);
      j = mulAndCheck(paramFraction.numerator, this.denominator);
      if (paramBoolean) {}
      for (i = addAndCheck(i, j);; i = subAndCheck(i, j)) {
        return new Fraction(i, mulPosAndCheck(this.denominator, paramFraction.denominator));
      }
    }
    BigInteger localBigInteger1 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(paramFraction.denominator / j));
    BigInteger localBigInteger2 = BigInteger.valueOf(paramFraction.numerator).multiply(BigInteger.valueOf(this.denominator / j));
    if (paramBoolean)
    {
      localBigInteger1 = localBigInteger1.add(localBigInteger2);
      i = localBigInteger1.mod(BigInteger.valueOf(j)).intValue();
      if (i != 0) {
        break label253;
      }
    }
    label253:
    for (int i = j;; i = greatestCommonDivisor(i, j))
    {
      localBigInteger1 = localBigInteger1.divide(BigInteger.valueOf(i));
      if (localBigInteger1.bitLength() <= 31) {
        break label263;
      }
      throw new ArithmeticException("overflow: numerator too large after multiply");
      localBigInteger1 = localBigInteger1.subtract(localBigInteger2);
      break;
    }
    label263:
    return new Fraction(localBigInteger1.intValue(), mulPosAndCheck(this.denominator / j, paramFraction.denominator / i));
  }
  
  public static Fraction getFraction(double paramDouble)
  {
    if (paramDouble < 0.0D) {}
    for (int k = -1;; k = 1)
    {
      paramDouble = Math.abs(paramDouble);
      if ((paramDouble <= 2147483647.0D) && (!Double.isNaN(paramDouble))) {
        break;
      }
      throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
    }
    int i5 = (int)paramDouble;
    double d4 = paramDouble - i5;
    int i1 = (int)d4;
    paramDouble = i1;
    double d2 = 1.7976931348623157E+308D;
    int m = 1;
    int n = 1;
    int i2 = 0;
    int j = 0;
    int i = 1;
    double d1 = 1.0D;
    paramDouble = d4 - paramDouble;
    for (;;)
    {
      double d3 = d1;
      int i4 = (int)(d3 / paramDouble);
      double d5 = i4;
      int i3 = i2 + i1 * i;
      i1 = i1 * j + n;
      d1 = Math.abs(d4 - i3 / i1);
      m += 1;
      if ((d2 <= d1) || (i1 > 10000) || (i1 <= 0) || (m >= 25))
      {
        if (m == 25) {
          throw new ArithmeticException("Unable to convert double to fraction");
        }
        return getReducedFraction(k * (i5 * j + i), j);
      }
      d2 = d1;
      n = j;
      d1 = paramDouble;
      j = i1;
      i1 = i4;
      paramDouble = d3 - d5 * paramDouble;
      i2 = i;
      i = i3;
    }
  }
  
  public static Fraction getFraction(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      throw new ArithmeticException("The denominator must not be zero");
    }
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt2 < 0)
    {
      if ((paramInt1 == -2147483648) || (paramInt2 == -2147483648)) {
        throw new ArithmeticException("overflow: can't negate");
      }
      j = -paramInt1;
      i = -paramInt2;
    }
    return new Fraction(j, i);
  }
  
  public static Fraction getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      throw new ArithmeticException("The denominator must not be zero");
    }
    if (paramInt3 < 0) {
      throw new ArithmeticException("The denominator must not be negative");
    }
    if (paramInt2 < 0) {
      throw new ArithmeticException("The numerator must not be negative");
    }
    if (paramInt1 < 0) {}
    for (long l = paramInt1 * paramInt3 - paramInt2; (l < -2147483648L) || (l > 2147483647L); l = paramInt1 * paramInt3 + paramInt2) {
      throw new ArithmeticException("Numerator too large to represent as an Integer.");
    }
    return new Fraction((int)l, paramInt3);
  }
  
  public static Fraction getFraction(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The string must not be null");
    }
    if (paramString.indexOf('.') >= 0) {
      return getFraction(Double.parseDouble(paramString));
    }
    int j = paramString.indexOf(' ');
    if (j > 0)
    {
      i = Integer.parseInt(paramString.substring(0, j));
      paramString = paramString.substring(j + 1);
      j = paramString.indexOf('/');
      if (j < 0) {
        throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
      }
      return getFraction(i, Integer.parseInt(paramString.substring(0, j)), Integer.parseInt(paramString.substring(j + 1)));
    }
    int i = paramString.indexOf('/');
    if (i < 0) {
      return getFraction(Integer.parseInt(paramString), 1);
    }
    return getFraction(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
  }
  
  public static Fraction getReducedFraction(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      throw new ArithmeticException("The denominator must not be zero");
    }
    if (paramInt1 == 0) {
      return ZERO;
    }
    int i;
    if ((paramInt2 == -2147483648) && ((paramInt1 & 0x1) == 0))
    {
      i = paramInt1 / 2;
      paramInt1 = paramInt2 / 2;
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      int j = paramInt1;
      i = paramInt2;
      if (paramInt1 < 0)
      {
        if ((paramInt2 == -2147483648) || (paramInt1 == -2147483648)) {
          throw new ArithmeticException("overflow: can't negate");
        }
        i = -paramInt2;
        j = -paramInt1;
      }
      paramInt1 = greatestCommonDivisor(i, j);
      return new Fraction(i / paramInt1, j / paramInt1);
      i = paramInt1;
      paramInt1 = paramInt2;
    }
  }
  
  private static int greatestCommonDivisor(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      if ((paramInt1 == -2147483648) || (paramInt2 == -2147483648)) {
        throw new ArithmeticException("overflow: gcd is 2^31");
      }
      return Math.abs(paramInt1) + Math.abs(paramInt2);
    }
    if ((Math.abs(paramInt1) == 1) || (Math.abs(paramInt2) == 1)) {
      return 1;
    }
    if (paramInt1 > 0) {
      paramInt1 = -paramInt1;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 > 0) {
        i = -paramInt2;
      }
      int j = 0;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (((paramInt2 & 0x1) == 0) && ((paramInt1 & 0x1) == 0) && (j < 31))
      {
        paramInt2 /= 2;
        paramInt1 /= 2;
        j += 1;
      }
      if (j == 31) {
        throw new ArithmeticException("overflow: gcd is 2^31");
      }
      int k;
      if ((paramInt2 & 0x1) == 1)
      {
        i = paramInt1;
        k = paramInt1;
        paramInt1 = i;
        i = k;
      }
      for (;;)
      {
        if ((paramInt1 & 0x1) == 0)
        {
          paramInt1 /= 2;
          continue;
          i = -(paramInt2 / 2);
          break;
        }
        if (paramInt1 > 0) {}
        for (paramInt1 = -paramInt1;; paramInt1 = paramInt2)
        {
          k = (i - paramInt1) / 2;
          if (k != 0) {
            break;
          }
          return -paramInt1 * (1 << j);
          i = paramInt1;
        }
        paramInt2 = paramInt1;
        paramInt1 = k;
      }
    }
  }
  
  private static int mulAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    if ((l < -2147483648L) || (l > 2147483647L)) {
      throw new ArithmeticException("overflow: mul");
    }
    return (int)l;
  }
  
  private static int mulPosAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    if (l > 2147483647L) {
      throw new ArithmeticException("overflow: mulPos");
    }
    return (int)l;
  }
  
  private static int subAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 - paramInt2;
    if ((l < -2147483648L) || (l > 2147483647L)) {
      throw new ArithmeticException("overflow: add");
    }
    return (int)l;
  }
  
  public Fraction abs()
  {
    if (this.numerator >= 0) {
      return this;
    }
    return negate();
  }
  
  public Fraction add(Fraction paramFraction)
  {
    return addSub(paramFraction, true);
  }
  
  public int compareTo(Fraction paramFraction)
  {
    if (this == paramFraction) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return 0;
      } while ((this.numerator == paramFraction.numerator) && (this.denominator == paramFraction.denominator));
      l1 = this.numerator * paramFraction.denominator;
      l2 = paramFraction.numerator * this.denominator;
    } while (l1 == l2);
    if (l1 < l2) {
      return -1;
    }
    return 1;
  }
  
  public Fraction divideBy(Fraction paramFraction)
  {
    if (paramFraction == null) {
      throw new IllegalArgumentException("The fraction must not be null");
    }
    if (paramFraction.numerator == 0) {
      throw new ArithmeticException("The fraction to divide by must not be zero");
    }
    return multiplyBy(paramFraction.invert());
  }
  
  public double doubleValue()
  {
    return this.numerator / this.denominator;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Fraction)) {
        return false;
      }
      paramObject = (Fraction)paramObject;
    } while ((getNumerator() == paramObject.getNumerator()) && (getDenominator() == paramObject.getDenominator()));
    return false;
  }
  
  public float floatValue()
  {
    return this.numerator / this.denominator;
  }
  
  public int getDenominator()
  {
    return this.denominator;
  }
  
  public int getNumerator()
  {
    return this.numerator;
  }
  
  public int getProperNumerator()
  {
    return Math.abs(this.numerator % this.denominator);
  }
  
  public int getProperWhole()
  {
    return this.numerator / this.denominator;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = ((getNumerator() + 629) * 37 + getDenominator());
    }
    return this.hashCode;
  }
  
  public int intValue()
  {
    return this.numerator / this.denominator;
  }
  
  public Fraction invert()
  {
    if (this.numerator == 0) {
      throw new ArithmeticException("Unable to invert zero.");
    }
    if (this.numerator == -2147483648) {
      throw new ArithmeticException("overflow: can't negate numerator");
    }
    if (this.numerator < 0) {
      return new Fraction(-this.denominator, -this.numerator);
    }
    return new Fraction(this.denominator, this.numerator);
  }
  
  public long longValue()
  {
    return this.numerator / this.denominator;
  }
  
  public Fraction multiplyBy(Fraction paramFraction)
  {
    if (paramFraction == null) {
      throw new IllegalArgumentException("The fraction must not be null");
    }
    if ((this.numerator == 0) || (paramFraction.numerator == 0)) {
      return ZERO;
    }
    int i = greatestCommonDivisor(this.numerator, paramFraction.denominator);
    int j = greatestCommonDivisor(paramFraction.numerator, this.denominator);
    return getReducedFraction(mulAndCheck(this.numerator / i, paramFraction.numerator / j), mulPosAndCheck(this.denominator / j, paramFraction.denominator / i));
  }
  
  public Fraction negate()
  {
    if (this.numerator == -2147483648) {
      throw new ArithmeticException("overflow: too large to negate");
    }
    return new Fraction(-this.numerator, this.denominator);
  }
  
  public Fraction pow(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    if (paramInt == 0) {
      return ONE;
    }
    if (paramInt < 0)
    {
      if (paramInt == -2147483648) {
        return invert().pow(2).pow(-(paramInt / 2));
      }
      return invert().pow(-paramInt);
    }
    Fraction localFraction = multiplyBy(this);
    if (paramInt % 2 == 0) {
      return localFraction.pow(paramInt / 2);
    }
    return localFraction.pow(paramInt / 2).multiplyBy(this);
  }
  
  public Fraction reduce()
  {
    if (this.numerator == 0) {
      if (!equals(ZERO)) {}
    }
    int i;
    do
    {
      return this;
      return ZERO;
      i = greatestCommonDivisor(Math.abs(this.numerator), this.denominator);
    } while (i == 1);
    return getFraction(this.numerator / i, this.denominator / i);
  }
  
  public Fraction subtract(Fraction paramFraction)
  {
    return addSub(paramFraction, false);
  }
  
  public String toProperString()
  {
    if (this.toProperString == null)
    {
      if (this.numerator != 0) {
        break label26;
      }
      this.toProperString = "0";
    }
    for (;;)
    {
      return this.toProperString;
      label26:
      if (this.numerator == this.denominator)
      {
        this.toProperString = "1";
      }
      else if (this.numerator == this.denominator * -1)
      {
        this.toProperString = "-1";
      }
      else
      {
        int i;
        if (this.numerator > 0) {
          i = -this.numerator;
        }
        for (;;)
        {
          if (i < -this.denominator)
          {
            i = getProperNumerator();
            if (i == 0)
            {
              this.toProperString = Integer.toString(getProperWhole());
              break;
              i = this.numerator;
              continue;
            }
            this.toProperString = (32 + getProperWhole() + ' ' + i + '/' + getDenominator());
            break;
          }
        }
        this.toProperString = (32 + getNumerator() + '/' + getDenominator());
      }
    }
  }
  
  public String toString()
  {
    if (this.toString == null) {
      this.toString = (32 + getNumerator() + '/' + getDenominator());
    }
    return this.toString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.math.Fraction
 * JD-Core Version:    0.7.0.1
 */