import android.text.TextUtils;

public class amqz
{
  public String url;
  public String word;
  
  public amqz(String paramString1, String paramString2)
  {
    this.word = paramString1;
    this.url = paramString2;
  }
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.word);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqz
 * JD-Core Version:    0.7.0.1
 */