public class jgp
{
  public byte[] data;
  public long pi;
  public long pj;
  
  public jgp(byte[] paramArrayOfByte, long paramLong)
  {
    this.data = paramArrayOfByte;
    this.pi = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("PCMFrame:");
    if (this.data == null) {}
    for (int i = -1;; i = this.data.length) {
      return i + ", idx=" + this.pi + ", pts=" + this.pj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgp
 * JD-Core Version:    0.7.0.1
 */