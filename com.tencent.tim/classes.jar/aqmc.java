import android.os.Build.VERSION;

public final class aqmc
{
  public static int dw()
  {
    if (Build.VERSION.SDK_INT > 10) {
      return 4;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmc
 * JD-Core Version:    0.7.0.1
 */