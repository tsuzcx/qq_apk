public class aftz
{
  public long XL;
  public String schoolId;
  public String schoolName;
  
  public aftz(String paramString1, String paramString2, long paramLong)
  {
    this.schoolId = paramString1;
    this.schoolName = paramString2;
    this.XL = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{schoolId: ").append(this.schoolId).append("}");
    localStringBuilder.append("{schoolName: ").append(this.schoolName).append("}");
    localStringBuilder.append("{schoolState: ").append(this.XL).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftz
 * JD-Core Version:    0.7.0.1
 */