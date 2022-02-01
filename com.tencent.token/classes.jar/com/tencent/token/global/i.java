package com.tencent.token.global;

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

public class i
  extends BaseAdapter
  implements SectionIndexer
{
  View.OnClickListener a;
  private List<j> b = null;
  private Context c;
  
  public i(Context paramContext, List<j> paramList, View.OnClickListener paramOnClickListener)
  {
    this.c = paramContext;
    this.b = paramList;
    this.a = paramOnClickListener;
  }
  
  public int a(String paramString)
  {
    int i = 10;
    while (i < getCount())
    {
      if (paramString.equals(((j)this.b.get(i)).c())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getPositionForSection(int paramInt)
  {
    int i = 10;
    while (i < getCount())
    {
      if (((j)this.b.get(i)).c().toUpperCase().charAt(0) == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getSectionForPosition(int paramInt)
  {
    return ((j)this.b.get(paramInt)).c().charAt(0);
  }
  
  public Object[] getSections()
  {
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (j)this.b.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.c).inflate(2130968739, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131559009));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131559007));
      paramViewGroup.c = paramView.findViewById(2131559008);
      paramView.setTag(paramViewGroup);
      int i = getSectionForPosition(paramInt);
      if ((paramInt <= 9) || (paramInt != getPositionForSection(i))) {
        break label225;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(((j)localObject).c());
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)IndexActivity.S_DENSITY * 13, 0, (int)IndexActivity.S_DENSITY * 13);
      paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(this.a);
      paramViewGroup.c.setTag(Integer.valueOf(paramInt));
      paramViewGroup.a.setText(((j)this.b.get(paramInt)).b());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label225:
      if (paramInt == 0)
      {
        paramViewGroup.b.setVisibility(0);
        paramViewGroup.b.setText(this.c.getString(2131231156));
        if ((paramViewGroup.b.getText() != null) && (paramViewGroup.b.getText().toString().equals(this.c.getString(2131231156))))
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
    }
  }
  
  static final class a
  {
    TextView a;
    TextView b;
    View c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.i
 * JD-Core Version:    0.7.0.1
 */