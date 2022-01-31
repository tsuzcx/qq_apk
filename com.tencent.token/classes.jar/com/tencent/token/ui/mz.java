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

public class mz
  extends BaseAdapter
{
  private Context a;
  private ArrayList b;
  private int c = 0;
  
  public mz(Context paramContext, ArrayList paramArrayList)
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
    Object localObject;
    if (paramView == null)
    {
      localObject = new na(this);
      paramView = LayoutInflater.from(this.a).inflate(2130968678, paramViewGroup, false);
      ((na)localObject).d = paramView.findViewById(2131558969);
      ((na)localObject).a = ((TextView)paramView.findViewById(2131558972));
      ((na)localObject).b = ((ImageView)paramView.findViewById(2131558970));
      ((na)localObject).c = ((ImageView)paramView.findViewById(2131558971));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (e)this.b.get(paramInt);
      if ((localObject != null) && (((e)localObject).f()))
      {
        if (!TextUtils.isEmpty(((e)localObject).c())) {
          paramViewGroup.a.setText(((e)localObject).c());
        }
        paramViewGroup.d.setOnClickListener(((e)localObject).d());
        if (((e)localObject).b() <= 0) {
          break label201;
        }
        paramViewGroup.b.setImageResource(((e)localObject).b());
      }
    }
    for (;;)
    {
      if (!((e)localObject).e()) {
        break label231;
      }
      paramViewGroup.c.setVisibility(0);
      return paramView;
      paramViewGroup = (na)paramView.getTag();
      break;
      label201:
      new a(paramViewGroup.b).execute(new String[] { ((e)localObject).a() });
    }
    label231:
    paramViewGroup.c.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mz
 * JD-Core Version:    0.7.0.1
 */