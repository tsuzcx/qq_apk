package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

public class MutableShort
  extends Number
  implements Comparable<MutableShort>, Mutable<Number>
{
  private static final long serialVersionUID = -2135791679L;
  private short value;
  
  public MutableShort() {}
  
  public MutableShort(Number paramNumber)
  {
    this.value = paramNumber.shortValue();
  }
  
  public MutableShort(String paramString)
    throws NumberFormatException
  {
    this.value = Short.parseShort(paramString);
  }
  
  public MutableShort(short paramShort)
  {
    this.value = paramShort;
  }
  
  public void add(Number paramNumber)
  {
    this.value = ((short)(this.value + paramNumber.shortValue()));
  }
  
  public void add(short paramShort)
  {
    this.value = ((short)(this.value + paramShort));
  }
  
  public int compareTo(MutableShort paramMutableShort)
  {
    return NumberUtils.compare(this.value, paramMutableShort.value);
  }
  
  public void decrement()
  {
    this.value = ((short)(this.value - 1));
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MutableShort))
    {
      bool1 = bool2;
      if (this.value == ((MutableShort)paramObject).shortValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public Short getValue()
  {
    return Short.valueOf(this.value);
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void increment()
  {
    this.value = ((short)(this.value + 1));
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(Number paramNumber)
  {
    this.value = paramNumber.shortValue();
  }
  
  public void setValue(short paramShort)
  {
    this.value = paramShort;
  }
  
  public short shortValue()
  {
    return this.value;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value = ((short)(this.value - paramNumber.shortValue()));
  }
  
  public void subtract(short paramShort)
  {
    this.value = ((short)(this.value - paramShort));
  }
  
  public Short toShort()
  {
    return Short.valueOf(shortValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.mutable.MutableShort
 * JD-Core Version:    0.7.0.1
 */