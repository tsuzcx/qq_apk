package org.apache.commons.lang3;

public class BitField
{
  private final int _mask;
  private final int _shift_count;
  
  public BitField(int paramInt)
  {
    this._mask = paramInt;
    int j = 0;
    int k = 0;
    if (paramInt != 0)
    {
      int i = paramInt;
      paramInt = k;
      for (;;)
      {
        j = paramInt;
        if ((i & 0x1) != 0) {
          break;
        }
        paramInt += 1;
        i >>= 1;
      }
    }
    this._shift_count = j;
  }
  
  public int clear(int paramInt)
  {
    return (this._mask ^ 0xFFFFFFFF) & paramInt;
  }
  
  public byte clearByte(byte paramByte)
  {
    return (byte)clear(paramByte);
  }
  
  public short clearShort(short paramShort)
  {
    return (short)clear(paramShort);
  }
  
  public int getRawValue(int paramInt)
  {
    return this._mask & paramInt;
  }
  
  public short getShortRawValue(short paramShort)
  {
    return (short)getRawValue(paramShort);
  }
  
  public short getShortValue(short paramShort)
  {
    return (short)getValue(paramShort);
  }
  
  public int getValue(int paramInt)
  {
    return getRawValue(paramInt) >> this._shift_count;
  }
  
  public boolean isAllSet(int paramInt)
  {
    return (this._mask & paramInt) == this._mask;
  }
  
  public boolean isSet(int paramInt)
  {
    return (this._mask & paramInt) != 0;
  }
  
  public int set(int paramInt)
  {
    return this._mask | paramInt;
  }
  
  public int setBoolean(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return set(paramInt);
    }
    return clear(paramInt);
  }
  
  public byte setByte(byte paramByte)
  {
    return (byte)set(paramByte);
  }
  
  public byte setByteBoolean(byte paramByte, boolean paramBoolean)
  {
    if (paramBoolean) {
      return setByte(paramByte);
    }
    return clearByte(paramByte);
  }
  
  public short setShort(short paramShort)
  {
    return (short)set(paramShort);
  }
  
  public short setShortBoolean(short paramShort, boolean paramBoolean)
  {
    if (paramBoolean) {
      return setShort(paramShort);
    }
    return clearShort(paramShort);
  }
  
  public short setShortValue(short paramShort1, short paramShort2)
  {
    return (short)setValue(paramShort1, paramShort2);
  }
  
  public int setValue(int paramInt1, int paramInt2)
  {
    return (this._mask ^ 0xFFFFFFFF) & paramInt1 | paramInt2 << this._shift_count & this._mask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.BitField
 * JD-Core Version:    0.7.0.1
 */