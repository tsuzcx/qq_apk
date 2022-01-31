package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.List;

final class ep
  extends BaseAdapter
{
  private List a;
  private BaseActivity b;
  private LayoutInflater c;
  
  public ep(BaseActivity paramBaseActivity, List paramList)
  {
    this.c = LayoutInflater.from(paramBaseActivity);
    this.b = paramBaseActivity;
    this.a = paramList;
  }
  
  public final int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2130903084, paramViewGroup, false);
    }
    Object localObject = (TextView)localView.findViewById(2131296563);
    paramView = (ImageView)localView.findViewById(2131296543);
    if (this.a != null)
    {
      paramViewGroup = (QQUser)this.a.get(paramInt);
      if (paramViewGroup != null)
      {
        ((TextView)localObject).setText(paramViewGroup.mNickName + "(" + s.e(paramViewGroup.mRealUin) + ")");
        localObject = t.f();
        if ((localObject == null) || (((QQUser)localObject).mUin != paramViewGroup.mUin)) {
          break label155;
        }
        paramView.setVisibility(0);
      }
    }
    for (;;)
    {
      localView.setOnClickListener(new eq(this, paramViewGroup));
      return localView;
      label155:
      paramView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ep
 * JD-Core Version:    0.7.0.1
 */