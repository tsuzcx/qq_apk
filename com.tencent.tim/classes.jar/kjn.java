import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity.2.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class kjn
  extends lce
{
  public kjn(ReadinjoyJumpActivity paramReadinjoyJumpActivity) {}
  
  public void a(boolean paramBoolean, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    QLog.d("ReadinjoyJumpActivity", 1, "68b resp, succ : " + paramBoolean + ", ids : " + paramList + ", articles : " + paramList1);
    if ((paramList == null) || (!paramList.contains(Long.valueOf(ReadinjoyJumpActivity.a(this.this$0))))) {}
    do
    {
      return;
      ThreadManager.getUIHandler().removeCallbacks(ReadinjoyJumpActivity.a(this.this$0));
    } while ((ReadinjoyJumpActivity.a(this.this$0)) || (ReadinjoyJumpActivity.b(this.this$0)));
    if ((paramBoolean) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      int i = 0;
      while (i < paramList1.size())
      {
        paramList = (ArticleInfo)paramList1.get(i);
        if (paramList.mArticleID == ReadinjoyJumpActivity.a(this.this$0))
        {
          ReadinjoyJumpActivity.a(this.this$0, paramList);
          if ((kxs.e(ReadinjoyJumpActivity.a(this.this$0)) == 0) && (kxm.a(ReadinjoyJumpActivity.a(this.this$0).mArticleContentUrl, 0L, ReadinjoyJumpActivity.a(this.this$0))))
          {
            paramList = lbz.a().a();
            if (paramList != null)
            {
              paramList.a(ReadinjoyJumpActivity.a(this.this$0).mArticleContentUrl, ReadinjoyJumpActivity.a(this.this$0).innerUniqueID, ReadinjoyJumpActivity.a(this.this$0).publishUin + "", 1, this.this$0);
              return;
            }
          }
          ReadinjoyJumpActivity.b(this.this$0);
          return;
        }
        i += 1;
      }
    }
    ReadinjoyJumpActivity.a(this.this$0);
  }
  
  public void mh(String paramString)
  {
    super.mh(paramString);
    QLog.d("ReadinjoyJumpActivity", 1, "webCallback : " + paramString);
    ThreadManager.getUIHandler().post(new ReadinjoyJumpActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjn
 * JD-Core Version:    0.7.0.1
 */