import android.os.Bundle;

public class amwt
{
  public byte[] cookie;
  public Bundle extra;
  public String keyword;
  
  public amwt(String paramString)
  {
    this.keyword = paramString;
  }
  
  public amwt(String paramString, Bundle paramBundle)
  {
    this.keyword = paramString;
    this.extra = paramBundle;
  }
  
  public amwt(String paramString, byte[] paramArrayOfByte)
  {
    this.keyword = paramString;
    this.cookie = paramArrayOfByte;
  }
  
  public amwt(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.keyword = paramString;
    this.cookie = paramArrayOfByte;
    this.extra = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwt
 * JD-Core Version:    0.7.0.1
 */