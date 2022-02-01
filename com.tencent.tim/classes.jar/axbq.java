import java.util.ArrayList;
import java.util.List;

public class axbq
  implements Cloneable
{
  public List<axbu> Mm;
  public String cTw;
  public int categoryId;
  public String categoryName;
  public boolean dtV;
  public int eEw = 2;
  
  public axbq() {}
  
  public axbq(String paramString)
  {
    this.categoryName = paramString;
  }
  
  public axbq a()
  {
    axbq localaxbq = new axbq();
    localaxbq.categoryName = this.categoryName;
    localaxbq.categoryId = this.categoryId;
    localaxbq.cTw = this.cTw;
    localaxbq.eEw = this.eEw;
    localaxbq.dtV = this.dtV;
    localaxbq.Mm = new ArrayList();
    localaxbq.Mm.addAll(this.Mm);
    return localaxbq;
  }
  
  public int hashCode()
  {
    if (this.Mm == null) {}
    for (int i = 0;; i = this.Mm.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbq
 * JD-Core Version:    0.7.0.1
 */