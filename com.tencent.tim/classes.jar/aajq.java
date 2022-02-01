import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.widget.SingleLineTextView;

public class aajq
  extends aajv
{
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof aajv.a))) {}
    paramObject = super.a(paramInt, paramObject, paramaajx, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramc);
    paramaajx = (aajv.a)paramObject.getTag();
    paramViewGroup = paramContext.getResources();
    paramView = paramViewGroup.getColorStateList(2131167379);
    paramViewGroup = paramViewGroup.getColorStateList(2131167304);
    paramaajx.g.setTextColor(paramViewGroup);
    paramaajx.h.setTextColor(paramView);
    paramaajx.g.setExtendTextColor(paramView, 0);
    paramObject.findViewById(2131377096).setBackgroundResource(2130839639);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajq
 * JD-Core Version:    0.7.0.1
 */