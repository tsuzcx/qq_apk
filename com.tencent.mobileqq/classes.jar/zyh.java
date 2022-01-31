import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.SearchListener;

public class zyh
  implements SearchListener
{
  public zyh(FullMessageSearchManager paramFullMessageSearchManager) {}
  
  public void a(FullMessageSearchResult paramFullMessageSearchResult)
  {
    FullMessageSearchManager.a(this.a);
    this.a.notifyObservers(paramFullMessageSearchResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zyh
 * JD-Core Version:    0.7.0.1
 */