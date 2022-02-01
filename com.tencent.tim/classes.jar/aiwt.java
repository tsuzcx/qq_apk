import android.os.Handler;
import android.os.Looper;

final class aiwt
  extends aixa<Handler, Void>
{
  protected Handler a(Void paramVoid)
  {
    return new Handler(Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwt
 * JD-Core Version:    0.7.0.1
 */