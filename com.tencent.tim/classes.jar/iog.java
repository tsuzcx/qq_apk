public class iog
{
  private short length;
  private short tag;
  private byte[] value;
  
  public iog(short paramShort1, short paramShort2, byte[] paramArrayOfByte)
  {
    this.tag = paramShort1;
    this.length = paramShort2;
    this.value = paramArrayOfByte;
  }
  
  public short getLength()
  {
    return this.length;
  }
  
  public short getTag()
  {
    return this.tag;
  }
  
  public byte[] getValue()
  {
    return this.value;
  }
  
  public int ln()
  {
    return getLength() + 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iog
 * JD-Core Version:    0.7.0.1
 */