package com.tencent.token.utils.bugscanuitl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public final class n
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  f a;
  private List b;
  private LayoutInflater c;
  
  public n(Context paramContext, List paramList, f paramf)
  {
    this.b = paramList;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.a = paramf;
  }
  
  public final int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    return this.b.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.b == null) {
      return null;
    }
    if (paramView == null)
    {
      paramView = this.c.inflate(2130903122, null);
      paramViewGroup = new o(this);
      paramView.setTag(paramViewGroup);
      paramViewGroup.a = ((Button)paramView.findViewById(2131296770));
    }
    for (;;)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131296772);
      TextView localTextView2 = (TextView)paramView.findViewById(2131296773);
      localTextView1.setText(((a)this.b.get(paramInt)).b());
      localTextView2.setText(((a)this.b.get(paramInt)).d());
      ((ImageView)paramView.findViewById(2131296771)).setImageDrawable(((a)this.b.get(paramInt)).c());
      paramViewGroup.a.setOnClickListener(this.a);
      paramViewGroup.a.setTag(Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = (o)paramView.getTag();
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.n
 * JD-Core Version:    0.7.0.1
 */