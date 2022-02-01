import java.util.Map;

public class anfd
{
  public long addTime;
  public boolean cFd;
  public boolean cFe;
  public int dFg;
  public Map<String, String> data;
  public byte[] extBuffer;
  public String mark;
  public long opUin;
  
  public anfd(long paramLong1, Map<String, String> paramMap, long paramLong2, String paramString)
  {
    this.addTime = paramLong1;
    this.data = paramMap;
    this.opUin = paramLong2;
    this.mark = paramString;
  }
  
  public anfd(long paramLong1, Map<String, String> paramMap, long paramLong2, String paramString, byte[] paramArrayOfByte)
  {
    this.addTime = paramLong1;
    this.data = paramMap;
    this.opUin = paramLong2;
    this.mark = paramString;
    this.extBuffer = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfd
 * JD-Core Version:    0.7.0.1
 */