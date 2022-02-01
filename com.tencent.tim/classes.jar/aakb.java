import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class aakb
{
  public static final int[] fA = { 2131371284, 2131371304, 2131371278, 2131371297, 2131371294, 2131371295, 2131371307, 2131371303, 2131371302, 2131371277 };
  public static final int[] fy = { 2131692505, 2131692304, 2131692274, 2131692278, 2131692275, 2131692276, 2131696102, 2131694514, 2131694512, 2131692273 };
  public static final int[] fz = { 2130839769, 2130839768, 2130839768, 2130839768, 2130839770, 2130839770, 2130839770, 2130839768, 2130839768, 2130839770 };
  protected auvd a;
  protected aajg c;
  
  public abstract View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc);
  
  public final View a(Context paramContext, int paramInt, aakb.a parama)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if ((this.c != null) && (this.c.QH()))
    {
      if (this.a == null) {
        this.a = a(paramContext);
      }
      return this.a.a(paramContext, localView, parama, -1);
    }
    parama.Lz = localView;
    parama.b = null;
    return localView;
  }
  
  public auvd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299263);
    int j = paramContext.getResources().getDimensionPixelSize(2131299264);
    int k = xV();
    paramContext = fA;
    int[] arrayOfInt1 = fy;
    int[] arrayOfInt2 = fz;
    return new aakc(this, k, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(aajg paramaajg)
  {
    this.c = paramaajg;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, aakb.a parama, View.OnClickListener paramOnClickListener)
  {
    if (this.a != null) {}
    for (int i = this.a.a(paramContext, paramView, paramInt, paramObject, parama, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.c != null) && (this.c.bKH == paramInt))
      {
        paramView.scrollTo(i, 0);
        if ((j != 0) && (QLog.isDevelopLevel())) {
          if (this.c != null) {
            break label123;
          }
        }
      }
      label123:
      for (paramContext = null;; paramContext = Integer.valueOf(this.c.bKH))
      {
        ajrk.m("updateItemMenuView", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext });
        return;
        if (j == 0) {
          break;
        }
        paramView.scrollTo(0, 0);
        break;
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
  
  protected void fN(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new auvj();
      }
      paramView.a.setSupportMaskView(true);
    }
  }
  
  public int xV()
  {
    return 1;
  }
  
  public static class a
    extends auvd.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakb
 * JD-Core Version:    0.7.0.1
 */