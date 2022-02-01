public class atkt
  implements atiu
{
  private int mode = 0;
  long sortTime;
  
  public atkt(long paramLong)
  {
    this.sortTime = paramLong;
  }
  
  public int getCloudFileType()
  {
    return 5;
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public long getSortSeq()
  {
    return 0L;
  }
  
  public long getSortTime()
  {
    return this.sortTime;
  }
  
  public boolean isClickable()
  {
    return false;
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkt
 * JD-Core Version:    0.7.0.1
 */