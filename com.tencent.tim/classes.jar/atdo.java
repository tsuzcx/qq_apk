import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.widget.ListView;

public class atdo
  extends aakb
{
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramInt = 0;
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2131561290, null);
    }
    if ((paramViewGroup instanceof ListView))
    {
      paramaajx = (ListView)paramViewGroup;
      int j = paramaajx.getChildCount();
      int i = 0;
      while (paramInt < j)
      {
        i += paramaajx.getChildAt(paramInt).getHeight();
        paramInt += 1;
      }
      paramObject.findViewById(2131369272).setMinimumHeight(paramaajx.getHeight() - i);
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdo
 * JD-Core Version:    0.7.0.1
 */