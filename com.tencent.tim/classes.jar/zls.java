public class zls
{
  public String keyword;
  
  public zls(String paramString)
  {
    this.keyword = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keyword = ").append(this.keyword);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zls
 * JD-Core Version:    0.7.0.1
 */