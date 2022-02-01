public class anbc
{
  public String content;
  public int contentType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("-----MessageDecContent----");
    localStringBuilder.append("msgType:").append(this.contentType).append(" content:").append(aqft.pk(this.content));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anbc
 * JD-Core Version:    0.7.0.1
 */