import android.content.Context;
import java.util.Observable;

public class avdz
  extends Observable
{
  public void gk(Context paramContext)
  {
    setChanged();
    notifyObservers(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdz
 * JD-Core Version:    0.7.0.1
 */