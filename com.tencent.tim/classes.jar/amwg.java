import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1;
import java.util.Observable;
import java.util.Observer;

public class amwg
  implements Observer
{
  public amwg(MessageSearchEngine.1 param1) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.a.d.cR(amwf.a(this.a.this$0, this.a.this$0.keyword, (FullMessageSearchResult)paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwg
 * JD-Core Version:    0.7.0.1
 */