public class lhm
{
  public int accountType;
  public boolean isFollowed;
  public long ur;
  
  public lhm(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, false);
  }
  
  public lhm(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.ur = paramLong;
    this.accountType = paramInt;
    this.isFollowed = paramBoolean;
  }
  
  public String toString()
  {
    return "BatchFollowModel{followUin=" + this.ur + ", accountType=" + this.accountType + ", isFollowed=" + this.isFollowed + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhm
 * JD-Core Version:    0.7.0.1
 */