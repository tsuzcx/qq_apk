package com.tencent.token.ui.base;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.FacePwdIndexActivity;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.List;

class b
  extends BaseAdapter
{
  private List<QQUser> a;
  private Dialog b;
  private LayoutInflater c;
  private FacePwdIndexActivity d;
  
  public b(FacePwdIndexActivity paramFacePwdIndexActivity, Dialog paramDialog, List<QQUser> paramList)
  {
    this.c = LayoutInflater.from(paramFacePwdIndexActivity);
    this.b = paramDialog;
    this.a = paramList;
    this.d = paramFacePwdIndexActivity;
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
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.c.inflate(2130968652, paramViewGroup, false);
    }
    paramView = localView.findViewById(2131558837);
    if (paramInt == getCount() - 1) {
      paramView.setVisibility(4);
    }
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131558851);
      if (this.a != null)
      {
        paramViewGroup = (QQUser)this.a.get(paramInt);
        if (paramViewGroup != null)
        {
          paramView.setText(paramViewGroup.mNickName + "(" + l.e(paramViewGroup.mRealUin) + ")");
          localView.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              m.b(paramViewGroup.mRealUin);
              b.a(b.this).dismiss();
              b.b(b.this).refreshList();
            }
          });
        }
      }
      return localView;
      paramView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.b
 * JD-Core Version:    0.7.0.1
 */