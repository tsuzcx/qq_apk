import java.util.Observable;

public class zji
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zji
 * JD-Core Version:    0.7.0.1
 */