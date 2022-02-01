package com.tencent.token.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.e;
import com.tencent.token.utils.a;
import java.util.ArrayList;

public class k
  extends BaseAdapter
{
  private Context a;
  private ArrayList<e> b;
  private int c = 0;
  
  public k(Context paramContext, ArrayList<e> paramArrayList)
  {
    this.a = paramContext;
    this.b = paramArrayList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new a();
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131296359, paramViewGroup, false);
      paramView.d = paramViewGroup.findViewById(2131165611);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131166156));
      paramView.b = ((ImageView)paramViewGroup.findViewById(2131165609));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131165610));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject = (a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (e)this.b.get(paramInt);
    if ((localObject != null) && (((e)localObject).f()))
    {
      if (!TextUtils.isEmpty(((e)localObject).c())) {
        paramView.a.setText(((e)localObject).c());
      }
      paramView.d.setOnClickListener(((e)localObject).d());
      if (((e)localObject).b() > 0) {
        paramView.b.setImageResource(((e)localObject).b());
      } else {
        new a(paramView.b).execute(new String[] { ((e)localObject).a() });
      }
      if (((e)localObject).e())
      {
        paramView.c.setVisibility(0);
        return paramViewGroup;
      }
      paramView.c.setVisibility(4);
    }
    return paramViewGroup;
  }
  
  class a
  {
    TextView a;
    ImageView b;
    ImageView c;
    View d;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.k
 * JD-Core Version:    0.7.0.1
 */