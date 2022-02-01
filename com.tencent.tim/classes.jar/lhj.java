import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class lhj
{
  private ArrayDeque<String> b = new ArrayDeque();
  private LinkedHashMap<String, Object> t = new LinkedHashMap();
  
  public String toString()
  {
    return "AtlasStackInfo{stackGalleryMap=" + this.t + "mScanStack=" + this.b.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhj
 * JD-Core Version:    0.7.0.1
 */