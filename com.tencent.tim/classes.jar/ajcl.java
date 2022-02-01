import android.os.Bundle;
import android.text.TextUtils;

public abstract class ajcl
{
  public static int dw(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("ak:"))) {
      return 1;
    }
    return 0;
  }
  
  protected abstract boolean E(Bundle paramBundle);
  
  public abstract void f(String paramString1, String paramString2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcl
 * JD-Core Version:    0.7.0.1
 */