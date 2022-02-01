import android.os.Looper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mbm
  extends lce
{
  public mbm(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void W(long paramLong, boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.e(ComponentContentRecommend.TAG, 2, "Please call this method in main thread!!!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ComponentContentRecommend.TAG, 2, "onUpdateAfterAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
    }
    Iterator localIterator = ComponentContentRecommend.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      if (paramLong == localRecommendFollowInfo.uin) {
        localRecommendFollowInfo.isFollowed = paramBoolean;
      }
    }
    ComponentContentRecommend.a(this.this$0).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    if ((ComponentContentRecommend.a(this.this$0) == null) || (ComponentContentRecommend.a(this.this$0).mRecommendFollowInfos == null)) {
      ComponentContentRecommend.a(this.this$0).clearAnimation();
    }
    while (ComponentContentRecommend.a(this.this$0).mArticleID != paramLong) {
      return;
    }
    if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 0))
    {
      ComponentContentRecommend.a(this.this$0).clearAnimation();
      return;
    }
    ComponentContentRecommend.a(this.this$0).clearAnimation();
    ComponentContentRecommend.a(this.this$0).mRecommendFollowInfos.iM.clear();
    ComponentContentRecommend.a(this.this$0).mRecommendFollowInfos.iM.addAll(paramList);
    lbz.a().l(ComponentContentRecommend.a(this.this$0));
    ComponentContentRecommend.a(this.this$0).clear();
    ComponentContentRecommend.a(this.this$0).addAll(paramList);
    ComponentContentRecommend.a(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbm
 * JD-Core Version:    0.7.0.1
 */