public class anqi
  extends anqg
{
  public String cgI = "";
  public String cgJ = "";
  public String cgK = "";
  
  public anqi()
  {
    this.deviceModel = "";
    this.cfz = "";
    this.cfA = "";
    this.Uq = "";
  }
  
  public String fo(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(this.deviceModel).append("|");
    localStringBuilder.append(this.cfz).append("|");
    localStringBuilder.append(this.cfA).append("|");
    localStringBuilder.append(this.Uq).append("|");
    localStringBuilder.append(this.cgI).append("|");
    localStringBuilder.append(this.cgJ).append("|");
    localStringBuilder.append(this.cgK).append("|");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    localStringBuffer.append(this.deviceModel).append("|");
    localStringBuffer.append(this.cfz).append("|");
    localStringBuffer.append(this.cfA).append("|");
    localStringBuffer.append(this.Uq).append("|");
    localStringBuffer.append(this.cgI).append("|");
    localStringBuffer.append(this.cgJ).append("|");
    localStringBuffer.append(this.cgK).append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqi
 * JD-Core Version:    0.7.0.1
 */