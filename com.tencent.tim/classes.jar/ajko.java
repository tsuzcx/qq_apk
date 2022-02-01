import java.util.LinkedList;
import java.util.List;

public class ajko<T>
{
  private List<T> le = new LinkedList();
  
  public T P()
  {
    if (this.le.size() == 0) {
      return null;
    }
    return this.le.remove(0);
  }
  
  public void bs(T paramT)
  {
    if (!this.le.contains(paramT)) {
      this.le.add(paramT);
    }
  }
  
  public void clear()
  {
    this.le.clear();
  }
  
  public int count()
  {
    return this.le.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajko
 * JD-Core Version:    0.7.0.1
 */