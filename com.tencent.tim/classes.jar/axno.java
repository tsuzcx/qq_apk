public class axno
  extends axob
{
  private String Nl;
  private int color;
  private String content;
  private String fontId;
  private String fontPath;
  private String path;
  
  public axno(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    this.content = paramString1;
    this.fontId = paramString2;
    this.fontPath = paramString3;
    this.Nl = paramString4;
    this.color = paramInt;
    this.path = paramString5;
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public String getContent()
  {
    return this.content;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axno
 * JD-Core Version:    0.7.0.1
 */