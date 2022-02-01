public class ime
{
  private byte[] buffer = new byte[512];
  private int bufferSize;
  private int curIndex;
  
  public ime()
  {
    int i = 0;
    while (i < 512)
    {
      this.buffer[i] = 0;
      i += 1;
    }
    this.curIndex = 0;
    this.bufferSize = 0;
  }
  
  public byte[] Data()
  {
    byte[] arrayOfByte = new byte[this.bufferSize];
    System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.bufferSize);
    return arrayOfByte;
  }
  
  public void WriteUInt32(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    byte[] arrayOfByte = this.buffer;
    paramInt = this.curIndex;
    System.arraycopy(new byte[] { m, k, j, i }, 0, arrayOfByte, paramInt, 4);
    this.curIndex += 4;
    this.bufferSize += 4;
  }
  
  public void WriteUInt8(byte paramByte)
  {
    this.buffer[this.curIndex] = paramByte;
    this.curIndex += 1;
    this.bufferSize += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ime
 * JD-Core Version:    0.7.0.1
 */