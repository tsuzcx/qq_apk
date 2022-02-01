import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aixu
{
  public List<aixx> CK = new ArrayList();
  public String bPV;
  public String bPZ;
  public int dgq;
  public int dgr = -1;
  public String type;
  
  public int im(int paramInt)
  {
    Iterator localIterator = this.CK.iterator();
    while (localIterator.hasNext())
    {
      aixx localaixx = (aixx)localIterator.next();
      if ((localaixx.min <= paramInt) && (localaixx.max > paramInt)) {
        return localaixx.cEg;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixu
 * JD-Core Version:    0.7.0.1
 */