public class apyk
{
  public long appid;
  public int dXV;
  public int nUnreadMsgNum;
  public String troopuin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[").append(this.troopuin).append(",").append(this.appid).append(",").append(this.nUnreadMsgNum).append(",").append(this.dXV).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyk
 * JD-Core Version:    0.7.0.1
 */