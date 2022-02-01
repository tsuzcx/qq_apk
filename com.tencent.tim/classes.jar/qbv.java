import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;

public class qbv
  extends qdh
{
  private boolean aCM;
  private HashMap<String, String> fn;
  
  public qbv()
  {
    this(null, false);
  }
  
  public qbv(HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    a(false, true);
    this.fn = paramHashMap;
    this.aCM = paramBoolean;
  }
  
  protected void M(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.cb != null) && (!this.cb.isEmpty()) && (paramMap.containsKey("ShortenUrlJob_shortenedUrls"))) {
      this.fn = ((HashMap)qdv.a(this.cb, "ShortenUrlJob_shortenedUrls", this.fn));
    }
  }
  
  public void bnE()
  {
    Object localObject2 = qem.getQQAppInterface();
    Object localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    String str = ((TicketManager)((QQAppInterface)localObject2).getManager(2)).getSkey((String)localObject1);
    localObject2 = new Bundle();
    localObject1 = jqc.a(BaseApplication.getContext(), (String)localObject1, str, 1, this.fn, (Bundle)localObject2);
    if ((!((Bundle)localObject2).getBoolean("isSuccess", false)) && (this.aCM))
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "shortenUrl failed size:" + ((HashMap)localObject1).size());
      }
      sA(false);
      return;
    }
    p("ShortenUrlJob_shortenedUrls", localObject1);
    sA(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbv
 * JD-Core Version:    0.7.0.1
 */