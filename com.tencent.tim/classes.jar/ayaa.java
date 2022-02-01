import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ayaa
{
  private final HashMap<String, axzy> mMap = new HashMap();
  
  final axzy a(String paramString)
  {
    return (axzy)this.mMap.get(paramString);
  }
  
  final void a(String paramString, axzy paramaxzy)
  {
    paramString = (axzy)this.mMap.put(paramString, paramaxzy);
    if (paramString != null) {
      paramString.onCleared();
    }
  }
  
  public final void clear()
  {
    Iterator localIterator = this.mMap.values().iterator();
    while (localIterator.hasNext()) {
      ((axzy)localIterator.next()).onCleared();
    }
    this.mMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayaa
 * JD-Core Version:    0.7.0.1
 */