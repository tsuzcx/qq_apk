import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class yxm
  extends yvp<MessageRecord>
{
  public yxm(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected yvx a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false);
    paramContext = new ywu(paramContext, paramViewGroup);
    paramContext.hC = ((LinearLayout)paramViewGroup.findViewById(2131374288));
    paramContext.uw = ((ImageView)paramViewGroup.findViewById(2131374278));
    paramContext.hD = ((LinearLayout)paramViewGroup.findViewById(2131374285));
    paramContext.uF = ((ImageView)paramViewGroup.findViewById(2131374292));
    paramContext.LW = ((TextView)paramViewGroup.findViewById(2131374283));
    paramContext.LX = ((TextView)paramViewGroup.findViewById(2131374289));
    paramContext.LY = ((TextView)paramViewGroup.findViewById(2131374291));
    paramContext.LZ = ((TextView)paramViewGroup.findViewById(2131374284));
    paramContext.ej = ((Button)paramViewGroup.findViewById(2131374287));
    paramContext.a = ((ShaderAnimLayout)paramViewGroup.findViewById(2131380367));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131380366);
    yym.C(paramContext.S(), false);
    return paramContext;
  }
  
  protected void b(yvx paramyvx, MessageRecord paramMessageRecord, int paramInt)
  {
    TroopNotifyAndRecommendView.a(this.this$0, paramyvx, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxm
 * JD-Core Version:    0.7.0.1
 */