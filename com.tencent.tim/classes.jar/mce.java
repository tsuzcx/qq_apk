import android.os.Looper;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class mce
  extends lce
{
  public mce(ComponentHeaderPolymeric paramComponentHeaderPolymeric) {}
  
  public void V(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
      QLog.e("ComponentHeaderPolymeric", 2, "Please call this method in main thread!!!");
    }
    label32:
    ArticleInfo localArticleInfo;
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentHeaderPolymeric", 2, "onUpdateAfterSmallVideoTopicFollow topicId = " + paramLong + " isFollow = " + paramBoolean);
      }
      localArticleInfo = (ArticleInfo)this.this$0.a.a.a().mGroupSubArticleList.get(0);
    } while ((localArticleInfo == null) || (localArticleInfo.mPolymericInfo == null) || (localArticleInfo.mPolymericInfo.vr != paramLong));
    ComponentHeaderPolymeric.a(this.this$0).setVisibility(0);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.this$0, true);
      if ((localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.ld != null)) {
        ((mih.b)localArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).isFollow = 1;
      }
      if (localArticleInfo.mPolymericInfo != null)
      {
        localArticleInfo.mPolymericInfo.followStatus = 2;
        return;
      }
      QLog.e("ComponentHeaderPolymeric", 2, "articleInfo mPolymericInfo == null articleInfo.mArticleID = " + localArticleInfo.mArticleID);
      return;
    }
    ComponentHeaderPolymeric.a(this.this$0, false);
    if ((localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.ld != null)) {
      ((mih.b)localArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).isFollow = 0;
    }
    if (localArticleInfo.mPolymericInfo != null)
    {
      localArticleInfo.mPolymericInfo.followStatus = 1;
      return;
    }
    QLog.e("ComponentHeaderPolymeric", 2, "articleInfo mPolymericInfo == null articleInfo.mArticleID = " + localArticleInfo.mArticleID);
  }
  
  public void W(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
      QLog.e("ComponentHeaderPolymeric", 2, "Please call this method in main thread!!!");
    }
    label32:
    ArticleInfo localArticleInfo;
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentHeaderPolymeric", 2, "onUpdateAfterAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
      }
      localArticleInfo = (ArticleInfo)this.this$0.a.a.a().mGroupSubArticleList.get(0);
    } while ((localArticleInfo == null) || (localArticleInfo.mPolymericInfo == null) || (localArticleInfo.mPolymericInfo.uin != paramLong));
    SocializeFeedsInfo localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    ComponentHeaderPolymeric.a(this.this$0).setVisibility(0);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.this$0, true);
      if (localSocializeFeedsInfo != null) {
        localSocializeFeedsInfo.mFollowStatus = 2;
      }
      localArticleInfo.mPolymericInfo.followStatus = 2;
      return;
    }
    ComponentHeaderPolymeric.a(this.this$0, false);
    if (localSocializeFeedsInfo != null) {
      localSocializeFeedsInfo.mFollowStatus = 1;
    }
    localArticleInfo.mPolymericInfo.followStatus = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mce
 * JD-Core Version:    0.7.0.1
 */