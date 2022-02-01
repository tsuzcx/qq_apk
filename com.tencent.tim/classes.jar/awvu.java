import android.support.annotation.NonNull;

public class awvu
{
  public static final awvu[] a = { b, c, d, e };
  public static final awvu b = new awvu("STARTED");
  public static final awvu c = new awvu("SUCCESS");
  public static final awvu d = new awvu("ERROR");
  public static final awvu e = new awvu("FAILURE_GESTURE_IN_PROCESS");
  public final String description;
  
  private awvu(@NonNull String paramString)
  {
    this.description = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvu
 * JD-Core Version:    0.7.0.1
 */