package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

public class MutableByte
  extends Number
  implements Comparable<MutableByte>, Mutable<Number>
{
  private static final long serialVersionUID = -1585823265L;
  private byte value;
  
  public MutableByte() {}
  
  public MutableByte(byte paramByte)
  {
    this.value = paramByte;
  }
  
  public MutableByte(Number paramNumber)
  {
    this.value = paramNumber.byteValue();
  }
  
  public MutableByte(String paramString)
    throws NumberFormatException
  {
    this.value = Byte.parseByte(paramString);
  }
  
  public void add(byte paramByte)
  {
    this.value = ((byte)(this.value + paramByte));
  }
  
  public void add(Number paramNumber)
  {
    this.value = ((byte)(this.value + paramNumber.byteValue()));
  }
  
  public byte byteValue()
  {
    return this.value;
  }
  
  public int compareTo(MutableByte paramMutableByte)
  {
    return NumberUtils.compare(this.value, paramMutableByte.value);
  }
  
  public void decrement()
  {
    this.value = ((byte)(this.value - 1));
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MutableByte))
    {
      bool1 = bool2;
      if (this.value == ((MutableByte)paramObject).byteValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public Byte getValue()
  {
    return Byte.valueOf(this.value);
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void increment()
  {
    this.value = ((byte)(this.value + 1));
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(byte paramByte)
  {
    this.value = paramByte;
  }
  
  public void setValue(Number paramNumber)
  {
    this.value = paramNumber.byteValue();
  }
  
  public void subtract(byte paramByte)
  {
    this.value = ((byte)(this.value - paramByte));
  }
  
  public void subtract(Number paramNumber)
  {
    this.value = ((byte)(this.value - paramNumber.byteValue()));
  }
  
  public Byte toByte()
  {
    return Byte.valueOf(byteValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.mutable.MutableByte
 * JD-Core Version:    0.7.0.1
 */