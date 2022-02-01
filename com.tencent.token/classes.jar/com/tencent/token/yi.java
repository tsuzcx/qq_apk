package com.tencent.token;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.BaseActivity;
import java.util.List;

public final class yi
  extends BaseAdapter
{
  private List<QQUser> a;
  private BaseActivity b;
  private LayoutInflater c;
  
  public yi(BaseActivity paramBaseActivity, List<QQUser> paramList)
  {
    this.c = LayoutInflater.from(paramBaseActivity);
    this.b = paramBaseActivity;
    this.a = paramList;
  }
  
  public final int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
      localView = this.c.inflate(2131296331, paramViewGroup, false);
    }
    paramViewGroup = (TextView)localView.findViewById(2131166075);
    paramView = (ImageView)localView.findViewById(2131165974);
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (QQUser)((List)localObject).get(paramInt);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((QQUser)localObject).mNickName);
        localStringBuilder.append("(");
        localStringBuilder.append(aao.e(((QQUser)localObject).mRealUin));
        localStringBuilder.append(")");
        paramViewGroup.setText(localStringBuilder.toString());
        paramViewGroup = aap.f();
        if ((paramViewGroup != null) && (paramViewGroup.mUin == ((QQUser)localObject).mUin)) {
          paramView.setVisibility(0);
        } else {
          paramView.setVisibility(4);
        }
        localView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            aap.b(this.a.mRealUin);
            yi.this.notifyDataSetChanged();
          }
        });
      }
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yi
 * JD-Core Version:    0.7.0.1
 */