public class atlc
  implements atiu
{
  private int mFileType;
  
  public atlc(int paramInt)
  {
    this.mFileType = paramInt;
  }
  
  public int getCloudFileType()
  {
    return 7;
  }
  
  public int getFileType()
  {
    return this.mFileType;
  }
  
  public long getSortSeq()
  {
    return 0L;
  }
  
  public long getSortTime()
  {
    return 0L;
  }
  
  public boolean isClickable()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlc
 * JD-Core Version:    0.7.0.1
 */