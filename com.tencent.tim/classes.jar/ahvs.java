import java.util.Observable;
import java.util.Observer;

public class ahvs
  implements Observer
{
  protected void cga() {}
  
  protected void cgb() {}
  
  protected void cgc() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 1: 
      cga();
      return;
    case 2: 
      cgb();
      return;
    }
    cgc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvs
 * JD-Core Version:    0.7.0.1
 */