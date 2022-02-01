import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;

public class yyq
  extends yvp<yvy>
{
  public yyq(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected yvx a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new yxc(paramContext, paramViewGroup);
    paramContext.hC = ((LinearLayout)paramViewGroup.findViewById(2131374288));
    paramContext.uw = ((ImageView)paramViewGroup.findViewById(2131374278));
    paramContext.hD = ((LinearLayout)paramViewGroup.findViewById(2131374285));
    paramContext.LW = ((TextView)paramViewGroup.findViewById(2131374283));
    paramContext.LX = ((TextView)paramViewGroup.findViewById(2131374289));
    paramContext.ej = ((Button)paramViewGroup.findViewById(2131374287));
    return paramContext;
  }
  
  protected void b(yvx paramyvx, yvy paramyvy, int paramInt)
  {
    TroopWithCommonFriendsFragment.a(this.a, paramyvx, paramyvy, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyq
 * JD-Core Version:    0.7.0.1
 */