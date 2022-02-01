public final class atag
  implements Cloneable
{
  private int value;
  
  public atag(int paramInt)
  {
    this.value = paramInt;
  }
  
  public atag(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public atag(byte[] paramArrayOfByte, int paramInt)
  {
    this.value = (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.value += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof atag))) {}
    while (this.value != ((atag)paramObject).getValue()) {
      return false;
    }
    return true;
  }
  
  public byte[] getBytes()
  {
    return new byte[] { (byte)(this.value & 0xFF), (byte)((this.value & 0xFF00) >> 8) };
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atag
 * JD-Core Version:    0.7.0.1
 */