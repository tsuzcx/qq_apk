import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.List;

public class vqv
  implements abex.d
{
  public vqv(RecommendFriendActivity paramRecommendFriendActivity) {}
  
  public void bUJ()
  {
    RecommendFriendActivity.a(this.a).setVisibility(0);
  }
  
  public void bUK()
  {
    RecommendFriendActivity.a(this.a).setVisibility(8);
  }
  
  public void fX(List<MayKnowRecommend> paramList)
  {
    Intent localIntent = this.a.getIntent();
    int i = localIntent.getIntExtra("EntranceId", 0);
    RecommendFriendActivity.a(this.a, localIntent, i, paramList);
  }
  
  public void wo(String paramString)
  {
    RecommendFriendActivity.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqv
 * JD-Core Version:    0.7.0.1
 */