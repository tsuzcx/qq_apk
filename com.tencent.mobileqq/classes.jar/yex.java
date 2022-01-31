import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.qphone.base.util.QLog;

public class yex
  extends FriendListObserver
{
  public yex(RecommendFriendAdapter paramRecommendFriendAdapter) {}
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onStatesChanged ");
    }
    RecommendFriendAdapter.a(this.a, RecommendFriendAdapter.a(this.a).a());
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yex
 * JD-Core Version:    0.7.0.1
 */