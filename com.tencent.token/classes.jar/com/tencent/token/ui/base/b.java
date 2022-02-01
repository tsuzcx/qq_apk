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
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
      localView = this.c.inflate(2131296332, paramViewGroup, false);
    }
    paramView = localView.findViewById(2131165443);
    if (paramInt == getCount() - 1) {
      paramView.setVisibility(4);
    } else {
      paramView.setVisibility(0);
    }
    paramView = (TextView)localView.findViewById(2131166065);
    paramViewGroup = this.a;
    if (paramViewGroup != null)
    {
      paramViewGroup = (QQUser)paramViewGroup.get(paramInt);
      if (paramViewGroup != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramViewGroup.mNickName);
        localStringBuilder.append("(");
        localStringBuilder.append(l.e(paramViewGroup.mRealUin));
        localStringBuilder.append(")");
        paramView.setText(localStringBuilder.toString());
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.b
 * JD-Core Version:    0.7.0.1
 */