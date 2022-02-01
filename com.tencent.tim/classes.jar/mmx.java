public class mmx
{
  public String brief;
  public String coverUrl;
  public String title;
  
  public mmx(String paramString1, String paramString2, String paramString3)
  {
    this.coverUrl = paramString1;
    this.title = paramString2;
    this.brief = paramString3;
  }
  
  public String toString()
  {
    return "ColumnPublishInfo{coverUrl='" + this.coverUrl + '\'' + ", title='" + this.title + '\'' + ", intro='" + this.brief + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmx
 * JD-Core Version:    0.7.0.1
 */