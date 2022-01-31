import java.util.Observable;

public class vtb
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vtb
 * JD-Core Version:    0.7.0.1
 */