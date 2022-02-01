public class anpv
  extends anpw
{
  public long anP = 0L;
  public String cgp = "";
  public String cgq = "";
  public String content_id = "";
  public String r1 = "";
  public String r2 = "";
  public String r3 = "";
  public String r4 = "";
  public String r5 = "";
  
  public String fo(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(this.anQ).append("|");
    localStringBuilder.append(this.cgr).append("|");
    localStringBuilder.append(this.cgs).append("|");
    localStringBuilder.append(this.aBx).append("|");
    localStringBuilder.append(this.dLE).append("|");
    localStringBuilder.append(this.caq).append("|");
    if (paramInt == 0) {
      localStringBuilder.append("${count_unknown}").append("|");
    }
    for (;;)
    {
      localStringBuilder.append(this.anP).append("|");
      localStringBuilder.append(this.cgp).append("|");
      localStringBuilder.append(this.content_id).append("|");
      localStringBuilder.append(this.cgq).append("|");
      localStringBuilder.append(this.r1).append("|");
      localStringBuilder.append(this.r2).append("|");
      localStringBuilder.append(this.r3).append("|");
      localStringBuilder.append(this.r4).append("|");
      localStringBuilder.append(this.r5).append("|");
      return localStringBuilder.toString();
      localStringBuilder.append(this.dLF).append("|");
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    localStringBuffer.append(this.anQ).append("|");
    localStringBuffer.append(this.cgr).append("|");
    localStringBuffer.append(this.cgs).append("|");
    localStringBuffer.append(this.aBx).append("|");
    localStringBuffer.append(this.dLE).append("|");
    localStringBuffer.append(this.caq).append("|");
    localStringBuffer.append(this.dLF).append("|");
    localStringBuffer.append(this.anP).append("|");
    localStringBuffer.append(this.cgp).append("|");
    localStringBuffer.append(this.content_id).append("|");
    localStringBuffer.append(this.cgq).append("|");
    localStringBuffer.append(this.r1).append("|");
    localStringBuffer.append(this.r2).append("|");
    localStringBuffer.append(this.r3).append("|");
    localStringBuffer.append(this.r4).append("|");
    localStringBuffer.append(this.r5).append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpv
 * JD-Core Version:    0.7.0.1
 */