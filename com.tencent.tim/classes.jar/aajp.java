import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;

public class aajp
  extends aajv
{
  public aajp()
  {
    this.mListItemLayout = 2131562958;
    this.bvX = true;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    aajv.a locala = null;
    if ((paramView.getTag() instanceof aajv.a)) {
      locala = (aajv.a)paramView.getTag();
    }
    if ((locala == null) || (locala.g == null) || (paramRecentBaseData == null)) {
      return;
    }
    amip.a(paramContext, locala.g, paramRecentBaseData.qx());
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    return super.a(paramInt, paramObject, paramaajx, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramc);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
    a(paramView, paramRecentBaseData, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajp
 * JD-Core Version:    0.7.0.1
 */