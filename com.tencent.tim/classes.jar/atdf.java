import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;

public class atdf
  extends aakb
{
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2131561289, null);
    }
    paramaajx = paramObject.findViewById(2131365430);
    paramaajx.setContentDescription("通讯录 按钮");
    paramaajx.setOnClickListener(paramOnClickListener);
    paramaajx.setOnLongClickListener(paramOnLongClickListener);
    paramaajx.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdf
 * JD-Core Version:    0.7.0.1
 */