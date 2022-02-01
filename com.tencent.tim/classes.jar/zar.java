import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class zar
  extends acfd
{
  public zar(RecommendFriendFragment paramRecommendFriendFragment) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onCancelMayKnowRecommend isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.this$0);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onGetMayKnowRecommend isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.this$0);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayKnowListPushAdd isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.this$0);
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayKnowListPushDel isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.this$0);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayknowStateChanged isSuccess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.this$0.a != null) {
        this.this$0.a.notifyDataSetChanged();
      }
      if (this.this$0.mListView != null)
      {
        this.this$0.mListView.removeCallbacks(this.this$0.eJ);
        this.this$0.mListView.postDelayed(this.this$0.eJ, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zar
 * JD-Core Version:    0.7.0.1
 */