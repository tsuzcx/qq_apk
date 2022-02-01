import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class lhi
  extends lir
{
  private AtomicBoolean aq = new AtomicBoolean(false);
  private HashMap<Long, ArticleReadInfo> dP = new LinkedHashMap();
  
  public lhi(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private void cp(List<ArticleReadInfo> paramList)
  {
    if (this.mMainThreadHandler == null) {
      return;
    }
    this.mMainThreadHandler.post(new ArticleReadInfoModule.2(this, paramList));
  }
  
  public void H(long paramLong1, long paramLong2)
  {
    ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)this.dP.get(Long.valueOf(paramLong1));
    if (localArticleReadInfo == null)
    {
      localArticleReadInfo = new ArticleReadInfo();
      localArticleReadInfo.mArticleID = paramLong1;
      localArticleReadInfo.mLastReadTime = paramLong2;
    }
    for (localArticleReadInfo.mIsRead = true;; localArticleReadInfo.mIsRead = true)
    {
      a(localArticleReadInfo);
      this.mExecutorService.execute(new ArticleReadInfoModule.3(this, localArticleReadInfo));
      return;
      localArticleReadInfo.mLastReadTime = paramLong2;
    }
  }
  
  public void a(ArticleReadInfo paramArticleReadInfo)
  {
    this.dP.put(Long.valueOf(paramArticleReadInfo.mArticleID), paramArticleReadInfo);
  }
  
  public void aEL()
  {
    this.dP.clear();
  }
  
  public void aJh()
  {
    if (this.aq.get())
    {
      QLog.d("ArticleReadInfoModule", 1, "article read info has loaded");
      return;
    }
    this.mExecutorService.execute(new ArticleReadInfoModule.1(this));
  }
  
  public boolean aO(long paramLong)
  {
    return this.dP.get(Long.valueOf(paramLong)) != null;
  }
  
  public void ey(long paramLong)
  {
    ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)this.dP.get(Long.valueOf(paramLong));
    if (localArticleReadInfo != null)
    {
      this.dP.remove(Long.valueOf(paramLong));
      this.mExecutorService.execute(new ArticleReadInfoModule.4(this, localArticleReadInfo));
    }
    QLog.d("ArticleInfo", 2, "DeleteArticle ReadInfo , articleID : " + paramLong);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhi
 * JD-Core Version:    0.7.0.1
 */