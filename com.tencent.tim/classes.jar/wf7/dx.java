package wf7;

public class dx
{
  public volatile String lu = "";
  public volatile String lv = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSessionId: ");
    localStringBuilder.append(this.lu);
    localStringBuilder.append(" mEncodeKey: ");
    localStringBuilder.append(this.lv);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.dx
 * JD-Core Version:    0.7.0.1
 */