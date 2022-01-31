import java.util.Observable;

public class xht
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xht
 * JD-Core Version:    0.7.0.1
 */