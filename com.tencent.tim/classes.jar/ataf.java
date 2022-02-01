public final class ataf
  implements Cloneable
{
  private long value;
  
  public ataf(long paramLong)
  {
    this.value = paramLong;
  }
  
  public ataf(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public ataf(byte[] paramArrayOfByte, int paramInt)
  {
    this.value = (paramArrayOfByte[(paramInt + 3)] << 24 & 0xFF000000);
    this.value += (paramArrayOfByte[(paramInt + 2)] << 16 & 0xFF0000);
    this.value += (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.value += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ataf))) {}
    while (this.value != ((ataf)paramObject).getValue()) {
      return false;
    }
    return true;
  }
  
  public byte[] getBytes()
  {
    return new byte[] { (byte)(int)(this.value & 0xFF), (byte)(int)((this.value & 0xFF00) >> 8), (byte)(int)((this.value & 0xFF0000) >> 16), (byte)(int)((this.value & 0xFF000000) >> 24) };
  }
  
  public long getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return (int)this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ataf
 * JD-Core Version:    0.7.0.1
 */