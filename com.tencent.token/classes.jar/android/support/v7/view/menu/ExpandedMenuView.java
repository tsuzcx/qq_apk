package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.token.hp;
import com.tencent.token.hp.b;
import com.tencent.token.hr;
import com.tencent.token.hx;
import com.tencent.token.ji;

public final class ExpandedMenuView
  extends ListView
  implements AdapterView.OnItemClickListener, hp.b, hx
{
  private static final int[] a = { 16842964, 16843049 };
  private hp b;
  private int c;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    paramContext = ji.a(paramContext, paramAttributeSet, a, paramInt, 0);
    if (paramContext.f(0)) {
      setBackgroundDrawable(paramContext.a(0));
    }
    if (paramContext.f(1)) {
      setDivider(paramContext.a(1));
    }
    paramContext.a.recycle();
  }
  
  public final void a(hp paramhp)
  {
    this.b = paramhp;
  }
  
  public final boolean a(hr paramhr)
  {
    return this.b.a(paramhr, null, 0);
  }
  
  public final int getWindowAnimations()
  {
    return this.c;
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a((hr)getAdapter().getItem(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0.1
 */