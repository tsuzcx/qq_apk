import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.widget.AbsListView.LayoutParams;

public class aegr
  extends aakb
{
  int mHeaderViewHeight;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramaajx = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof aegr.a))) {
        break label179;
      }
      paramaajx = (aegr.a)paramaajx;
      label35:
      paramInt = paramViewGroup.getMeasuredHeight() - this.mHeaderViewHeight;
      if (paramInt >= 0) {
        break label348;
      }
      paramInt = (int)(this.mHeaderViewHeight * 1.5F);
    }
    label81:
    label348:
    for (;;)
    {
      if ((paramView.getLayoutParams() instanceof AbsListView.LayoutParams))
      {
        paramViewGroup = (AbsListView.LayoutParams)paramView.getLayoutParams();
        paramViewGroup.width = -1;
        paramViewGroup.height = paramInt;
        paramView.setLayoutParams(paramViewGroup);
        if ((paramObject instanceof Integer))
        {
          paramInt = ((Integer)paramObject).intValue();
          if (paramInt != 16) {
            break label294;
          }
          paramaajx.iconView.setImageResource(2130839657);
          if ((paramaajx.iconView.getDrawable() instanceof Animatable)) {
            ((Animatable)paramaajx.iconView.getDrawable()).start();
          }
          paramaajx.textView.setText(2131700842);
        }
      }
      while (paramInt != 17)
      {
        return paramView;
        paramaajx = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561272, null);
        paramaajx = new aegr.a();
        paramaajx.dZ = ((ViewGroup)paramView.findViewById(2131370144));
        paramaajx.iconView = ((ImageView)paramView.findViewById(2131368698));
        paramaajx.textView = ((TextView)paramView.findViewById(2131381048));
        paramView.setTag(paramaajx);
        this.mHeaderViewHeight = (paramOnClickListener.getDimensionPixelSize(2131298585) + paramOnClickListener.getDimensionPixelSize(2131298587) + paramOnClickListener.getDimensionPixelSize(2131298586) * 2);
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramaajx.iconView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramaajx.iconView.getDrawable()).stop();
      }
      paramaajx.iconView.setImageDrawable(null);
      paramaajx.textView.setText(2131700841);
      return paramView;
    }
  }
  
  static class a
  {
    ViewGroup dZ;
    ImageView iconView;
    TextView textView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegr
 * JD-Core Version:    0.7.0.1
 */