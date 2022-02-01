public class anbm
{
  public int dEO;
  public int friendType;
  public long groupCode;
  public long groupUin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("----dump tempSession info----");
    localStringBuilder.append("friendType:").append(this.friendType).append(" groupCode:").append(this.groupCode).append(" groupUin:").append(this.groupUin);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anbm
 * JD-Core Version:    0.7.0.1
 */