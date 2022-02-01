package com.tencent.token.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.global.g;
import java.util.List;
import java.util.Map;

class s
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private List<Map<String, Object>> c;
  
  public s(Context paramContext, List<Map<String, Object>> paramList)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramList;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.b.inflate(2131296438, null);
    }
    ((TextView)paramViewGroup.findViewById(2131165985)).setText((String)((Map)this.c.get(paramInt)).get("setting_op_name"));
    paramViewGroup.setOnClickListener(new a(paramInt));
    paramViewGroup.setOnTouchListener(new b());
    return paramViewGroup;
  }
  
  class a
    implements View.OnClickListener
  {
    public final int a = 0;
    public final int b = 1;
    private int d = 0;
    
    public a(int paramInt)
    {
      this.d = paramInt;
    }
    
    public void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("conf modify onClick=");
      paramView.append(this.d);
      g.a(paramView.toString());
      paramView = (StartPwdDigitSelActivity)s.a(s.this);
      paramView.finish();
      switch (this.d)
      {
      default: 
        return;
      case 1: 
        localIntent = new Intent(paramView, StartPwdDigitVerifyActivity.class);
        localBundle = new Bundle();
        localBundle.putInt("enter_type", 3);
        localIntent.putExtra("com.tencent.input_param", localBundle);
        paramView.startActivity(localIntent);
        return;
      }
      Intent localIntent = new Intent(paramView, StartPwdDigitVerifyActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("enter_type", 2);
      localIntent.putExtra("com.tencent.input_param", localBundle);
      paramView.startActivity(localIntent);
    }
  }
  
  class b
    implements View.OnTouchListener
  {
    b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      paramView = (TextView)paramView.findViewById(2131165985);
      int i = s.a(s.this).getResources().getColor(2130968657);
      int j = s.a(s.this).getResources().getColor(2130968665);
      int k = paramMotionEvent.getAction();
      if (k != 3) {
        switch (k)
        {
        default: 
          break;
        case 0: 
          paramView.setTextColor(j);
          break;
        }
      } else {
        paramView.setTextColor(i);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.s
 * JD-Core Version:    0.7.0.1
 */