import android.os.Bundle;

public class arnt
  extends arns
{
  public arnt(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public String getValue(String paramString1, String paramString2)
  {
    paramString1 = this.bx.getBundle(paramString1);
    if (paramString1 != null) {
      return paramString1.getString(paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnt
 * JD-Core Version:    0.7.0.1
 */