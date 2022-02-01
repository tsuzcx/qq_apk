import android.text.TextUtils;

public final class tgg
{
  public int height;
  public String url;
  public int width;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.url)) && (this.width >= 0) && (this.height >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgg
 * JD-Core Version:    0.7.0.1
 */