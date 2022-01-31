import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import java.util.ArrayList;
import java.util.List;

public class tli
  extends FriendListObserver
{
  public tli(RecommendFriendActivity paramRecommendFriendActivity) {}
  
  protected void onGetMayKnowRecommend(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArrayList localArrayList = RecommendFriendActivity.a(this.a).a();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        RecommendFriendActivity.a(this.a).a(localArrayList);
        RecommendFriendActivity.a(this.a).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    RecommendFriendActivity.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tli
 * JD-Core Version:    0.7.0.1
 */