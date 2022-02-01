package com.tencent.token;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.tencent.token.ui.IndexActivity;
import java.util.List;

public final class xc
  extends BaseAdapter
  implements SectionIndexer
{
  public List<xd> a = null;
  View.OnClickListener b;
  private Context c;
  
  public xc(Context paramContext, List<xd> paramList, View.OnClickListener paramOnClickListener)
  {
    this.c = paramContext;
    this.a = paramList;
    this.b = paramOnClickListener;
  }
  
  public final int getCount()
  {
    return this.a.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getPositionForSection(int paramInt)
  {
    int i = 10;
    while (i < getCount())
    {
      if (((xd)this.a.get(i)).b.toUpperCase().charAt(0) == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int getSectionForPosition(int paramInt)
  {
    return ((xd)this.a.get(paramInt)).b.charAt(0);
  }
  
  public final Object[] getSections()
  {
    return null;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (xd)this.a.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.c).inflate(2131296421, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131165767));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131165276));
      paramViewGroup.c = paramView.findViewById(2131165768);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (a)paramView.getTag();
    }
    int i = getSectionForPosition(paramInt);
    if ((paramInt > 9) && (paramInt == getPositionForSection(i)))
    {
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(((xd)localObject).b);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)IndexActivity.S_DENSITY * 13, 0, (int)IndexActivity.S_DENSITY * 13);
      paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if (paramInt == 0)
    {
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(this.c.getString(2131493299));
      if ((paramViewGroup.b.getText() != null) && (paramViewGroup.b.getText().toString().equals(this.c.getString(2131493299))))
      {
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)IndexActivity.S_DENSITY * 20, 0, (int)IndexActivity.S_DENSITY * 7);
        paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      paramViewGroup.b.setVisibility(8);
    }
    paramViewGroup.c.setOnClickListener(this.b);
    paramViewGroup.c.setTag(Integer.valueOf(paramInt));
    paramViewGroup.a.setText(((xd)this.a.get(paramInt)).a);
    return paramView;
  }
  
  static final class a
  {
    TextView a;
    TextView b;
    View c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xc
 * JD-Core Version:    0.7.0.1
 */