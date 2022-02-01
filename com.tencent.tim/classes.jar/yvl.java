import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;

public class yvl
  extends yvp<yva>
{
  public yvl(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected yvx a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new yuz(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  protected void b(yvx paramyvx, yva paramyva, int paramInt)
  {
    TroopRecommendFriendFragment.a(this.a, paramyvx, paramyva, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvl
 * JD-Core Version:    0.7.0.1
 */