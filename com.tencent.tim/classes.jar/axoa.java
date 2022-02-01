public class axoa
  extends axob
{
  private String Nl;
  private int color;
  private String content;
  private String fontId;
  private String fontPath;
  private String path;
  private String stickerId;
  
  public axoa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this.stickerId = paramString1;
    this.content = paramString2;
    this.fontId = paramString3;
    this.fontPath = paramString4;
    this.Nl = paramString5;
    this.color = paramInt;
    this.path = paramString6;
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
 * Qualified Name:     axoa
 * JD-Core Version:    0.7.0.1
 */