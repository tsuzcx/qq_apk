public class anxt
{
  public String ciC;
  public int dNj = 0;
  public String errorMsg = "";
  public int errorType = 0;
  public int interval;
  public int result;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:").append(this.result).append(" mainAccount:").append(this.ciC).append(" errorType:").append(this.errorType).append(" errorMsg:").append(this.errorMsg).append(" interval:").append(this.interval).append(" allLastMsgTime:").append(this.dNj);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxt
 * JD-Core Version:    0.7.0.1
 */