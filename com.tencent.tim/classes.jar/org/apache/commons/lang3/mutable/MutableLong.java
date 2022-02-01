package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

public class MutableLong
  extends Number
  implements Comparable<MutableLong>, Mutable<Number>
{
  private static final long serialVersionUID = 62986528375L;
  private long value;
  
  public MutableLong() {}
  
  public MutableLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public MutableLong(Number paramNumber)
  {
    this.value = paramNumber.longValue();
  }
  
  public MutableLong(String paramString)
    throws NumberFormatException
  {
    this.value = Long.parseLong(paramString);
  }
  
  public void add(long paramLong)
  {
    this.value += paramLong;
  }
  
  public void add(Number paramNumber)
  {
    this.value += paramNumber.longValue();
  }
  
  public int compareTo(MutableLong paramMutableLong)
  {
    return NumberUtils.compare(this.value, paramMutableLong.value);
  }
  
  public void decrement()
  {
    this.value -= 1L;
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MutableLong))
    {
      bool1 = bool2;
      if (this.value == ((MutableLong)paramObject).longValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return (float)this.value;
  }
  
  public Long getValue()
  {
    return Long.valueOf(this.value);
  }
  
  public int hashCode()
  {
    return (int)(this.value ^ this.value >>> 32);
  }
  
  public void increment()
  {
    this.value += 1L;
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(long paramLong)
  {
    this.value = paramLong;
  }
  
  public void setValue(Number paramNumber)
  {
    this.value = paramNumber.longValue();
  }
  
  public void subtract(long paramLong)
  {
    this.value -= paramLong;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value -= paramNumber.longValue();
  }
  
  public Long toLong()
  {
    return Long.valueOf(longValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.mutable.MutableLong
 * JD-Core Version:    0.7.0.1
 */