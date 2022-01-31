package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.util.List;

class fg
  extends BaseAdapter
{
  private List a;
  private BaseActivity b;
  private LayoutInflater c;
  
  public fg(BaseActivity paramBaseActivity, List paramList)
  {
    this.c = LayoutInflater.from(paramBaseActivity);
    this.b = paramBaseActivity;
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
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
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2130968650, paramViewGroup, false);
    }
    Object localObject = (TextView)localView.findViewById(2131558850);
    paramView = (ImageView)localView.findViewById(2131558829);
    if (this.a != null)
    {
      paramViewGroup = (QQUser)this.a.get(paramInt);
      if (paramViewGroup != null)
      {
        ((TextView)localObject).setText(paramViewGroup.mNickName + "(" + w.e(paramViewGroup.mRealUin) + ")");
        localObject = x.f();
        if ((localObject == null) || (((QQUser)localObject).mUin != paramViewGroup.mUin)) {
          break label155;
        }
        paramView.setVisibility(0);
      }
    }
    for (;;)
    {
      localView.setOnClickListener(new fh(this, paramViewGroup));
      return localView;
      label155:
      paramView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fg
 * JD-Core Version:    0.7.0.1
 */