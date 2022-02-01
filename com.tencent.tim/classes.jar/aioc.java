public class aioc
{
  public boolean ckO;
  public boolean ckP;
  public String id;
  
  public aioc(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString;
    this.ckO = paramBoolean1;
    this.ckP = paramBoolean2;
  }
  
  public String toString()
  {
    return "MusicExtendedReqParam{id='" + this.id + '\'' + ", needUrl=" + this.ckO + ", needLyric=" + this.ckP + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */