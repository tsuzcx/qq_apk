import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.a;

public class aftk
  extends RecyclerView.ViewHolder
{
  private ExtendFriendCampusVerifyTipsView a;
  
  public aftk(View paramView, ExtendFriendCampusVerifyTipsView.a parama)
  {
    super(paramView);
    this.a = ((ExtendFriendCampusVerifyTipsView)paramView);
    this.a.setOnClickListener(parama);
  }
  
  public void a(afua paramafua, int paramInt)
  {
    if ((paramafua instanceof aftl))
    {
      paramafua = (aftl)paramafua;
      this.a.setTipsType(paramafua.a);
      this.a.setPadding(0, paramInt, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftk
 * JD-Core Version:    0.7.0.1
 */