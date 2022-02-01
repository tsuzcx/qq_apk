import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine.ParseTask;
import java.util.ArrayList;

public class amwk
  extends acfd
{
  public amwk(NetSearchEngine.NetSearchRunnalbe paramNetSearchRunnalbe) {}
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong)
  {
    if (this.b.c != null) {
      NetSearchEngine.a(this.b.this$0).removeObserver(this.b.c);
    }
    if (NetSearchEngine.NetSearchRunnalbe.a(this.b)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt1 != 88) || (paramBoolean2));
        if (!paramBoolean1) {
          break;
        }
      } while (!(paramObject instanceof ArrayList));
      ThreadManager.post(new NetSearchEngine.ParseTask(this.b.this$0, NetSearchEngine.NetSearchRunnalbe.a(this.b), (ArrayList)paramObject, NetSearchEngine.NetSearchRunnalbe.a(this.b)), 10, null, true);
      return;
    } while (NetSearchEngine.NetSearchRunnalbe.a(this.b) == null);
    NetSearchEngine.NetSearchRunnalbe.a(this.b).s(null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwk
 * JD-Core Version:    0.7.0.1
 */