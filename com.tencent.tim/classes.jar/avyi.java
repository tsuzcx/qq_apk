import android.content.Context;
import android.content.ServiceConnection;
import java.lang.ref.WeakReference;

public class avyi
{
  static avxv b;
  private static WeakReference<avyi.a> sListener;
  private static ServiceConnection sSc = new avyj();
  
  public static void a(Context paramContext, avyi.a parama)
  {
    if ((b != null) && (b.isAlive()))
    {
      if (parama != null) {
        parama.a(b);
      }
      return;
    }
    sListener = new WeakReference(parama);
    avxt.a().process(paramContext, sSc, 0);
  }
  
  private static void clear()
  {
    if (sListener != null)
    {
      sListener.clear();
      sListener = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(avxl paramavxl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyi
 * JD-Core Version:    0.7.0.1
 */