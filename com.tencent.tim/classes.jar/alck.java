public class alck
{
  public String bVk;
  public int drE;
  public String strContent;
  public String strJumpUrl;
  public String strTitle;
  
  public boolean isEmpty()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.strTitle != null)
    {
      bool1 = bool2;
      if (this.strTitle.trim().length() > 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.drE).append(",").append(this.bVk).append(",").append(this.strTitle).append(",").append(this.strContent).append(",").append(this.strJumpUrl).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alck
 * JD-Core Version:    0.7.0.1
 */