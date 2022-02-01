public class ijn
{
  public boolean RH;
  public CharSequence l;
  public CharSequence m;
  public int status;
  public String uin;
  
  public ijn(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    this.uin = paramString;
    this.l = paramCharSequence1;
    this.m = paramCharSequence2;
    this.status = paramInt;
  }
  
  public boolean isEnd()
  {
    return this.status == 2;
  }
  
  public String toString()
  {
    return "SentenceInfo{uin='" + this.uin + '\'' + ", src_text='" + this.l + '\'' + ", tra_text='" + this.m + '\'' + ", status=" + this.status + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijn
 * JD-Core Version:    0.7.0.1
 */