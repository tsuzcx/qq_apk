package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.token.id;
import com.tencent.token.id.b;
import com.tencent.token.if;
import com.tencent.token.il;
import com.tencent.token.jw;

public final class ExpandedMenuView
  extends ListView
  implements AdapterView.OnItemClickListener, id.b, il
{
  private static final int[] a = { 16842964, 16843049 };
  private id b;
  private int c;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    paramContext = jw.a(paramContext, paramAttributeSet, a, paramInt, 0);
    if (paramContext.f(0)) {
      setBackgroundDrawable(paramContext.a(0));
    }
    if (paramContext.f(1)) {
      setDivider(paramContext.a(1));
    }
    paramContext.a.recycle();
  }
  
  public final void a(id paramid)
  {
    this.b = paramid;
  }
  
  public final boolean a(if paramif)
  {
    return this.b.a(paramif, null, 0);
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
    a((if)getAdapter().getItem(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0.1
 */