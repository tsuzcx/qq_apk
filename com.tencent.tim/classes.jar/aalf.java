import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;

@Deprecated
public class aalf
  extends aakb
{
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2131563243, null);
    }
    paramaajx = paramObject.findViewById(2131380234);
    paramaajx.setTag(-1, Integer.valueOf(paramInt));
    paramaajx.setOnClickListener(paramOnClickListener);
    paramaajx = paramObject.findViewById(2131380233);
    paramaajx.setTag(-1, Integer.valueOf(paramInt));
    paramaajx.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalf
 * JD-Core Version:    0.7.0.1
 */