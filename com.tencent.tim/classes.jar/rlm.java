import java.util.Observable;

public class rlm
  extends Observable
{
  public void notifyObservers()
  {
    setChanged();
    super.notifyObservers();
  }
  
  public void notifyObservers(Object paramObject)
  {
    setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlm
 * JD-Core Version:    0.7.0.1
 */