import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.2;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.3;
import com.tencent.mobileqq.search.searchengine.MessageSearchEngine.4;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class amwf
  implements amwd<amqb>
{
  public QQAppInterface app;
  public acps b;
  public String keyword;
  
  public amwf(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.b = ((acps)paramQQAppInterface.getManager(105));
  }
  
  private List<amqb> a(String paramString, FullMessageSearchResult paramFullMessageSearchResult)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFullMessageSearchResult != null) && (paramFullMessageSearchResult.xW != null))
    {
      int i = 0;
      while (i < paramFullMessageSearchResult.xW.size())
      {
        localArrayList.add(new amqb(this.app, paramString, (FullMessageSearchResult.SearchResultItem)paramFullMessageSearchResult.xW.get(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List<amqb> a(amwt paramamwt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageSearchEngine", 2, "========== search message use MessageSearchEngine");
    }
    this.keyword = paramamwt.keyword;
    if ((paramamwt.extra != null) && (paramamwt.extra.getBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", false))) {}
    for (paramamwt = this.b.a(this.keyword);; paramamwt = this.b.b(this.keyword)) {
      return a(this.keyword, paramamwt);
    }
  }
  
  public void a(amwt paramamwt, amwe<amqb> paramamwe)
  {
    ThreadManager.post(new MessageSearchEngine.1(this, paramamwe, paramamwt), 8, null, true);
  }
  
  public void cancel()
  {
    ThreadManager.post(new MessageSearchEngine.2(this), 8, null, true);
  }
  
  public void destroy() {}
  
  public void init() {}
  
  public void pause()
  {
    ThreadManager.post(new MessageSearchEngine.3(this, this.keyword), 8, null, true);
  }
  
  public void resume()
  {
    ThreadManager.post(new MessageSearchEngine.4(this, this.keyword), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwf
 * JD-Core Version:    0.7.0.1
 */