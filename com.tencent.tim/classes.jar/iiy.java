import com.tencent.av.app.VideoAppInterface;
import java.util.Observable;

public class iiy
  extends Observable
{
  VideoAppInterface mApp = null;
  
  public iiy(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      this.mApp = paramVideoAppInterface;
    }
  }
  
  public void m(Object[] paramArrayOfObject)
  {
    try
    {
      super.setChanged();
      super.notifyObservers(paramArrayOfObject);
      return;
    }
    finally
    {
      paramArrayOfObject = finally;
      throw paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iiy
 * JD-Core Version:    0.7.0.1
 */